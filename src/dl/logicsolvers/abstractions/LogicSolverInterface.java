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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.List;
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
		String filename = decorateFilename("findInstance");
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
	
	public ArrayList<Valuation> clusterSample(final dLFormula formula, final int numSamples, final ArrayList<Double> radii,int parallelize_flag ) throws Exception {


		ArrayList<Valuation> points = multiSample(formula,numSamples,radii.get(0));
		
			for (int i=1;i<radii.size();i++)
			{
				points=clusterSampleBase(formula,points,numSamples,radii.get(i),radii.get(i-1),parallelize_flag);
			}
		
		
		return points;
	}
	
	public ArrayList<Valuation> clusterSample(final dLFormula formula, final int numSamples, final ArrayList<Double> radii,int parallelize_flag,long timeout ) throws Exception {
		ArrayList<Valuation> points=new ArrayList<Valuation>();
		ExecutorService executor=Executors.newFixedThreadPool(1);
		Callable<ArrayList<Valuation>> task1 = new Callable<ArrayList<Valuation>>() {
			public ArrayList<Valuation> call()
			{
				ArrayList<Valuation> points = multiSample(formula,numSamples,radii.get(0));

				return points;

			}
		};
		Future<ArrayList<Valuation>> future=executor.submit(task1);
		try{
			points = future.get(timeout,TimeUnit.SECONDS);
		}
		catch(TimeoutException e)
		{
			future.cancel(true);
			TextOutput.info("thread cancelled");
		}
			for (int i=1;i<radii.size();i++)
			{
				points=clusterSampleBase(formula,points,numSamples,radii.get(i),radii.get(i-1),parallelize_flag,timeout);
			}
		
		
		return points;
	}
	/*
	 * else{
			ExecutorService executor=Executors.newFixedThreadPool(points.size());
			Callable<Integer> task = new Callable() {
					public int run()
					{
				    try {
				        TimeUnit.SECONDS.sleep(1);
				        return 123;
				    }
				    catch (InterruptedException e) {
				        throw new IllegalStateException("task interrupted", e);
				    }
				}

					@Override
					public Integer call() throws Exception {
						// TODO Auto-generated method stub
						return 123;
					}
			
			};
			Future<Integer> future = executor.submit(task);
			
			
		}
	 */
	
	protected ArrayList<Valuation> clusterSampleBase(final dLFormula formula, final ArrayList<Valuation> center_points,final int numSamples, final double SR, final double BR,int parallelize_flag,long timeout) throws Exception{
		ArrayList<Future<ArrayList<Valuation>>> futures = new ArrayList<Future<ArrayList<Valuation>>>();
		ArrayList<Valuation> points= new ArrayList<Valuation>();
		ExecutorService executor=Executors.newFixedThreadPool(1);

		if(parallelize_flag==1){
			if(center_points.size()>0)
			{
			executor=Executors.newFixedThreadPool(center_points.size());
			}
			}
			else
			{
			executor=Executors.newFixedThreadPool(1);

			}
		for (int i=0;i<center_points.size();i++)
		{	final int j=i;
			
			Callable<ArrayList<Valuation>> task = new Callable<ArrayList<Valuation>>() {
					public ArrayList<Valuation> call() throws Exception {
						// TODO Auto-generated method stub

						    try {
						    	
						        ArrayList<Valuation> newpoints=(multiSample(new AndFormula(formula,createBallExclusionFormula(center_points.get(j),new Real(BR)).negate()),numSamples,SR));
						        return newpoints;
						    }
						    catch (InterruptedException e) {
						        throw new IllegalStateException("task interrupted", e);
						    }						
					}
			
			};
			Future<ArrayList<Valuation>> future = executor.submit(task);
			futures.add(future);
		}
		
		for (Future<ArrayList<Valuation>> future: futures)
		{
			try{

			points.addAll(future.get(timeout,TimeUnit.SECONDS));
			}
			 catch (TimeoutException e) {
		            future.cancel(true);
					TextOutput.info("ya, timed out");
		        }
		}
		executor.shutdown();

		return points;
	}

	
	
	
	protected ArrayList<Valuation> clusterSampleBase(final dLFormula formula, final ArrayList<Valuation> center_points,final int numSamples, final double SR, final double BR,int parallelize_flag) throws Exception{
			ArrayList<Future<ArrayList<Valuation>>> futures = new ArrayList<Future<ArrayList<Valuation>>>();
			ArrayList<Valuation> points= new ArrayList<Valuation>();
			ExecutorService executor=Executors.newFixedThreadPool(1);

			if(parallelize_flag==1){
				if(center_points.size()>0)
				{
				executor=Executors.newFixedThreadPool(center_points.size());
				}
				}
				else
				{
				executor=Executors.newFixedThreadPool(1);

				}
			for (int i=0;i<center_points.size();i++)
			{	final int j=i;
				
				Callable<ArrayList<Valuation>> task = new Callable<ArrayList<Valuation>>() {
						public ArrayList<Valuation> call() throws Exception {
							// TODO Auto-generated method stub
	
							    try {
							    	
							        ArrayList<Valuation> newpoints=(multiSample(new AndFormula(formula,createBallExclusionFormula(center_points.get(j),new Real(BR)).negate()),numSamples,SR));
							        return newpoints;
							    }
							    catch (InterruptedException e) {
							        throw new IllegalStateException("task interrupted", e);
							    }						
						}
				
				};
				Future<ArrayList<Valuation>> future = executor.submit(task);
				futures.add(future);
			}
			
			for (Future<ArrayList<Valuation>> future: futures)
			{
				points.addAll(future.get());
			}
			return points;
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
	public String decorateFilename( String workSpaceName, String base, String fileExtension ) {
		double randomID = Math.round(Math.random());
		Date date = new Date();
		String formatted_date = date.toString();
		formatted_date=formatted_date.replace(" ","_");
		String filename= workSpaceName + "/" + base + UUID.randomUUID().toString().replaceAll("-", "")+ "_"+  formatted_date + "." + randomID + "." + fileExtension;
		return filename;
	}

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
						+ " - " +  String.format("%.12f",center.get(thisVar).toDouble())
						
						+  " )^2 + ";
			} else {
				ballString = ballString
						+ "( " +thisVar.toMathematicaString()
						+ " - "  +  String.format("%.12f",center.get(thisVar).toDouble())
						+  " )^2";
			}
		}

		ballString = ballString + " > " + String.format("%.12f",radius.toDouble());

		ballFormula = (ComparisonFormula)(dLStructure.parseStructure( ballString ));

		return ballFormula;
	}
	

}


