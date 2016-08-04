/**
 * @author Nikos Arechiga
 * @author Anuradha Vakil
 * @author Sumanth Dathathri
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package dl.logicsolvers.abstractions;

import interfaces.text.*;
import java.util.*;
//import java.io.*;

import dl.semantics.*;
import dl.syntax.*;

public abstract class LogicSolverInterface {

// Basic ways to do "quantifier elimination"
	public abstract LogicSolverResult checkValidity( String filename, dLFormula thisFormula, String comment ) 
				throws Exception;
	 
// Basic ways to find an instance
	public abstract LogicSolverResult findInstance( String filename, List<dLFormula> theseFormulas, String comment ) 
				throws Exception;

// Convenient aliases for findInstance
	public LogicSolverResult findInstance( dLFormula thisFormula ) throws Exception {
		ArrayList<dLFormula> theseFormulas = new ArrayList<dLFormula>();
		theseFormulas.add( thisFormula );

		return findInstance( theseFormulas );
	}

	public LogicSolverResult findInstance( List<dLFormula> theseFormulas ) throws Exception {
		String filename = generateFilename();
		String comment = generateFindInstanceComment( theseFormulas );

		return findInstance( filename, theseFormulas, comment );
	}

	public LogicSolverResult findInstance( String filename, dLFormula thisFormula, String comment ) throws Exception {
		ArrayList<dLFormula> theseFormulas = new ArrayList<dLFormula>();
		theseFormulas.add( thisFormula );

		return findInstance( filename, theseFormulas, comment );
	}
// Even more convenient!
	public Valuation sample( dLFormula formula ) {
		ArrayList<dLFormula> formulas = new ArrayList<>();
		formulas.add( formula );
		return sample( formulas );
	}

	public Valuation sample( ArrayList<dLFormula> formulas ) {
		Valuation point = null;
		try {
			point = findInstance( formulas ).valuation;
		} catch ( Exception e ) {
			e.printStackTrace();
		} 

		return point;
	}

	public ArrayList<Valuation> multiSample( dLFormula formula, int numSamples, double resolution ) {
		ArrayList<dLFormula> formulas = new ArrayList<>();
		formulas.add( formula );

		return multiSample( formulas, numSamples, resolution );

	}

	public ArrayList<Valuation> multiSample( List<dLFormula> thisSet, int numberOfPoints, double suggestedRadius ) {
                ArrayList<dLFormula> queryFormulas = new ArrayList<dLFormula>();
                ArrayList<Valuation> samplePoints = new ArrayList<Valuation>();
                Valuation thisPoint;

                queryFormulas.addAll( thisSet );

                for ( int i = 0; i < numberOfPoints; i++ ) { 
                        thisPoint = sample( queryFormulas );
                        if ( thisPoint != null && !thisPoint.isEmpty() ) { 
                                samplePoints.add( thisPoint );
                                try {
                                	queryFormulas.add( createBallExclusionFormula( thisPoint, new Real(suggestedRadius) ) );
                                } catch ( Exception e ) {
                                	e.printStackTrace();
				}
                                //System.out.println("Iteration: " + i + ";  Ball Exclusion Formula: " +
                                //                      createBallExclusionFormula( thisPoint, new Real(suggestedRadius) ).toMathematicaString() );

                        } else {
                                break;
                        }
                }

                return samplePoints;
	}



// Convenient alias for checkvalidity
	public LogicSolverResult checkValidity ( dLFormula thisFormula ) throws Exception {
		TextOutput.debug("Entering checkValidity ( dLformula )");
	    String comment = generateCheckValidityComment( thisFormula );
	    String filename = decorateFilename( "checkValidity" );

	    return checkValidity( filename, thisFormula, comment );
	}
	
	public LogicSolverResult checkValidity ( String filename, dLFormula thisFormula ) throws Exception {
		TextOutput.debug("Entering checkValidity ( dLformula )");
	    String comment = generateCheckValidityComment( thisFormula );
	    filename=decorateFilename(filename);
	    return checkValidity( filename, thisFormula, comment );
	}

// Even more convenient use of checkValidity
	public boolean isValid( dLFormula formula ) {

		boolean result = false;
		try {
			String validity = checkValidity( formula ).validity;

			if ( validity.equals("valid") ) {
				result = true;
			}
			//System.out.println("Validity: " + validity);

		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return result;
	}


// Automatically generate comments and filenames, in accordance with what the solver likes
// this is so I can keep track of what each query does
	public abstract String commentLine( String comment );
	public abstract String decorateFilename( String base );
	public abstract String generateFilename();

// Convenience functions for auto-commenting
	protected abstract String generateFindInstanceComment( List<dLFormula> theseFormulas );
	protected abstract String generateCheckValidityComment( List<dLFormula> theseFormulas );
	protected String generateFindInstanceComment( dLFormula thisFormula ) {
		ArrayList<dLFormula> theseFormulas = new ArrayList<dLFormula>();
		theseFormulas.add( thisFormula );

		return generateFindInstanceComment( theseFormulas );
	}

	protected String generateCheckValidityComment( dLFormula thisFormula ) {
		ArrayList<dLFormula> theseFormulas = new ArrayList<dLFormula>();
		theseFormulas.add( thisFormula );

		return generateCheckValidityComment( theseFormulas );
	}

//**//
        protected ComparisonFormula createBallExclusionFormula( Valuation center, Real radius ) throws Exception {

                ComparisonFormula ballFormula;

                Set<RealVariable> variables = center.keySet();
                Iterator<RealVariable> varIterator = variables.iterator();

                String ballString = "";
                RealVariable thisVar;
                while ( varIterator.hasNext() ) {
                        thisVar = varIterator.next();
                        if ( varIterator.hasNext() ) {
                                ballString = ballString
                                                + "( " +thisVar.toMathematicaString()
                                                + " - " + center.get(thisVar).toMathematicaString()
                                                +  " )^2 + ";
                        } else {
                                ballString = ballString
                                                + "( " +thisVar.toMathematicaString()
                                                + " - " + center.get(thisVar).toMathematicaString()
                                                +  " )^2";
                        }
                }

                ballString = ballString + " > " + radius.toMathematicaString();

                ballFormula = (ComparisonFormula)(dLStructure.parseStructure( ballString ));

                return ballFormula;
        }


}

