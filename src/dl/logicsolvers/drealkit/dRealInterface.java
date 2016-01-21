/**
 * @author Nikos Arechiga
 * @author Anuradha Vakil
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */

package dl.logicsolvers.drealkit;

//import proteus.logicsolvers.abstractions.*;
import java.util.*;

import dl.semantics.*;
import dl.syntax.*;

import java.io.*;

import dl.logicsolvers.abstractions.LogicSolverInterface;
import dl.logicsolvers.abstractions.LogicSolverResult;


public class dRealInterface extends LogicSolverInterface {

	// COLORS! OMG COLORS!
	public final String ANSI_RESET = "\u001B[0m";
	public final String ANSI_BLACK = "\u001B[30m";
	public final String ANSI_RED = "\u001B[31m";
	public final String ANSI_GREEN = "\u001B[32m";
	public final String ANSI_YELLOW = "\u001B[33m";
	public final String ANSI_BLUE = "\u001B[34m";
	public final String ANSI_PURPLE = "\u001B[35m";
	public final String ANSI_CYAN = "\u001B[36m";
	public final String ANSI_WHITE = "\u001B[37m";
	public final String ANSI_BOLD = "\u001B[1m";

	public double precision = 0.00001;
	public boolean debug = false;

	public void setPrecision( double precision ) {
		this.precision = precision;
	}

//Constructors
	// Constructor with specified precision
	public dRealInterface( double precision ) {
		this.precision = precision;
		
		// Generate the workspace
		File drealworkspacedir = new File("drealworkspace");
                if (!drealworkspacedir.exists()) {
                        drealworkspacedir.mkdir();
                }
	}

	// Constructor with default precision
	public dRealInterface() {
		this.precision = 0.00001;

		// Generate the workspace
		File drealworkspacedir = new File("drealworkspace");
                if (!drealworkspacedir.exists()) {
                        drealworkspacedir.mkdir();
                }
	}

// "checkValidity" family of methods -- try to find a counterexample
	public LogicSolverResult checkValidity( String filename, dLFormula thisFormula, String comment ) throws Exception {
		
		dLFormula negatedFormula = thisFormula.negate();
		ArrayList<dLFormula> theseFormulas = negatedFormula.splitOnAnds();

		// Try to find a counterexample
		LogicSolverResult subResult = findInstance( filename, theseFormulas, comment );
		
		// We queried the negation, so invert the result
		LogicSolverResult result;
		if ( subResult.satisfiability.equals("unsat") ) {
			result = new LogicSolverResult("sat", "valid", new Valuation() );
		} else if ( subResult.satisfiability.equals("delta-sat") ) { 
			// The valuation is then a counterexample
			// but with dReal we can't be sure
			result = new LogicSolverResult("unknown", "unknown", subResult.valuation );
		} else {
			//gibberish, I guess
			result = new LogicSolverResult("unknown", "unknown", new Valuation() );
		}
		
		return result;
	}

// "FindInstance" family of methods
	public LogicSolverResult findInstance( String filename, List<dLFormula> theseFormulas, String comment )
					throws Exception {
		File queryFile = writeQueryFile( filename, theseFormulas, comment );
		//System.out.println("Running query on file: " + filename);
		return runQuery( queryFile );
	}

// Automatically comment a list of formulas
	protected String generateFindInstanceComment( List<dLFormula> theseFormulas ) {
		String comment = ";; Find a valuation of variables that satisfies the formulas:\n;;\n";
		Iterator<dLFormula> formulaIterator = theseFormulas.iterator();
		int counter = 1;
		while ( formulaIterator.hasNext() ) {
			comment = comment + "\n;; Formula " + counter + ":\n";
			comment = comment + ";; " + formulaIterator.next().toMathematicaString();
			counter = counter + 1;
		}

		return comment;
	}

	protected String generateCheckValidityComment( List<dLFormula> theseFormulas ) {
		String comment = ";; Check (conjunctive) validity of: \n;;\n";
		Iterator<dLFormula> formulaIterator = theseFormulas.iterator();
		int counter = 1;
		while ( formulaIterator.hasNext() ) {
			comment = comment + ";; Formula " + counter + ":\n";
			comment = comment + ";; " + formulaIterator.next().toMathematicaString();
			counter = counter + 1;
		}

		return comment;
	}

	public String timeStampComment( String comment ) {
		Date date = new Date();
		String stampedComment = ";; Automatically generated by Proteus on " + date.toString() + "\n\n";
		stampedComment = stampedComment + comment;
		
		return stampedComment;
	}

	public String commentLine( String comment ) {
		return ";; " + comment + "\n";
	}
	

// Runs dReal on a query file, written by some other function The point of this function is to allow code reuse of 
// the piece that actually invokes dReal
	protected LogicSolverResult runQuery( File queryFile ) throws Exception {
		LogicSolverResult result = null;

		String precisionArgument = "--precision=" + precision;
		ProcessBuilder queryPB = new ProcessBuilder("dReal", "--model", 
								precisionArgument, queryFile.getAbsolutePath() );
		queryPB.redirectErrorStream( true );
		Process queryProcess = queryPB.start();
		BufferedReader dRealSays = new BufferedReader( new InputStreamReader(queryProcess.getInputStream()) );

		String line;
		if ( (line = dRealSays.readLine()) != null ) {
			if ( line.equals("unsat")) {
				result = new LogicSolverResult( "unsat", "notvalid", new Valuation() );
			} else if ( line.equals("sat") ) {
				Valuation cex = extractModel( new File( queryFile.getAbsolutePath() + ".model") );
				result = new LogicSolverResult( "delta-sat", "unknown", cex );
			} else if ( line.equals("unknown") ) {
				result = new LogicSolverResult( "unknown", "unknown", new Valuation() );
			} else {
				throw new Exception( line );
			}
		} else {
			throw new Exception("dReal returned no output!");
		}
		//System.out.println("Solver result is: ");
		//System.out.println( result.toString() );

		//queryFile.delete();
		return result;
	}

// Extracts a counterexample from a *.model file produced after running dReal
	protected Valuation extractModel( File modelFile ) throws Exception {
		//System.out.println("Extracting CEX...");
		Valuation model = new Valuation();

		// Wait for file to exist. Yeah, somehow this is a problem sometimes
		//while ( (!modelFile.exists()) || (modelFile.length() == 0) ) {
		//	System.out.println("Waiting for CEX file to exist...");
		//	System.out.println("(yeah, sometimes this happens, somehow)");
		//	try {
                //                    Thread.sleep(3000);                 //1000 milliseconds is one second.
                //        } catch(InterruptedException ex) {
                //                    Thread.currentThread().interrupt();
                //        }
		//}
		
		System.out.println("Pausing to let dReal finish writing out the CEX file...: " + modelFile.toString() );
		try {
                              Thread.sleep(100);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) {
                              Thread.currentThread().interrupt();
                }
			

		Scanner modelReader = new Scanner( modelFile );

		modelReader.nextLine();
		//System.out.println("Discarding preamble: " + modelReader.readLine() );
		String line;
		while( modelReader.hasNextLine() ) {
			line = modelReader.nextLine();

			if (!( line.contains(",")) ) {
				//System.out.println("Skipping strange line: " + line);
				continue;
			}

			
			//System.out.println("CEX line is: " + line);
			line = line.trim();
			String[] tokens = line.split("\\s+");

			RealVariable variable = new RealVariable( tokens[0] );
			String lowerBound = tokens[2].replace("[","").replace(",","").replace("(","").replace(";","");
			String upperBound = tokens[3].replace("]","").replace(")","").replace(";","");
			//System.out.println("lower bound: " + lowerBound );
			//System.out.println("upper bound: " + upperBound );

			if ( lowerBound.equals("-inf") && upperBound.equals("inf") ) {
				model.put(variable, new Real(42));

			} else if ( lowerBound.equals("-inf") ) {
				model.put(variable, new Real( upperBound ));

			} else if ( upperBound.equals("inf") ) {
				model.put( variable, new Real( lowerBound ));

			} else {
				model.put( variable, new Real( (Double.parseDouble(upperBound) 
									+ Double.parseDouble(lowerBound))/2 ));

			}
		}

		//System.out.println("CEX Model is: " + model.toString() );
		//System.out.println("Existence: " + modelFile.exists() );
		//System.exit(1);

		//modelFile.delete();
		
		modelReader.close();

		return model;
	}
//
	public String decorateFilename( String base ) {
		double randomID = Math.round(Math.random());
		Date date = new Date();
		return "drealworkspace/" + base + + date.getTime() + "." + randomID + ".smt2";
	}

//
	public String generateFilename() {
		double randomID = Math.round(Math.random());
		Date date = new Date();
		return "drealworkspace/query." + date.getTime() + "." + randomID + ".smt2";
	}

// Writes a query file for a logical formula.  Note that it does not negate the formula, it just writes out
// a satisfiability query for the formula that it is given
	protected File writeQueryFile( String filename, List<dLFormula> theseFormulas, String comment ) 
			throws Exception {
		String queryString = "(set-logic QF_NRA)\n\n";

		
		// First extract the list of all the variables that occur in any of the formulas
		Iterator<dLFormula> formulaIterator = theseFormulas.iterator();
		Set<RealVariable> variables = new HashSet<RealVariable>();
		while ( formulaIterator.hasNext() ) {
			variables.addAll( formulaIterator.next().getFreeVariables() );
		}

		// Now print the variable declarations
		queryString = queryString + "\n;; Variable declarations\n";
		//RealVariable thisVariable;
		Iterator<RealVariable> variableIterator = variables.iterator();
		while ( variableIterator.hasNext() ) {
			queryString = queryString + "(declare-fun " + variableIterator.next() + " () Real )\n";
		}
		//if ( variables.isEmpty() ) {
		//	RealVariable x = new RealVariable("x");
		//	queryString = queryString + "(declare-fun " + x.todRealString() + " () Real )\n";
		//}



		// Assert each formula
		formulaIterator = theseFormulas.iterator();
		dLFormula thisFormula;
		while ( formulaIterator.hasNext() ) {
			thisFormula = formulaIterator.next();
			if( debug ) {
				if ( thisFormula == null ) {
					System.out.println("Got a null formula!");
				} else {
					System.out.println("Currently printing out formula: " 
						+ thisFormula.toMathematicaString() );
				}
			}

			queryString = queryString + "\n;; Formula is (" + thisFormula.toMathematicaString() +")\n";
			queryString = queryString + "(assert " + thisFormula.todRealString() + " )\n";

		}

		// Print the little thing that needs to go at the end
		queryString = queryString + "\n(check-sat)\n(exit)\n";

		// Now generate the actual file
		PrintWriter queryFile = new PrintWriter( filename );
		queryFile.println( timeStampComment( comment ) + "\n" );
		queryFile.println( queryString );
		queryFile.close();
		if( debug ) {
			System.out.println("Done writing file, writeQueryFile is returning");
		}
		return new File( filename );

	}

}

