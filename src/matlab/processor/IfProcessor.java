/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 * 
 * 
 * This class does the following:
 * 1. breaks the if-else block into individual blocks with condition (if it exists) and assignments/logic in that block
 * 2. Checks for post if-else assignment 
 * 3. if any then stores them in order
 * 4. appends to each if-else block individually
 * 5. gets any assignment statements at the beginning (before if-else block)
 * 6. substitutes them throughout the code
 * 7. final result is obtained with output variable as LHS.
 * 
 */


 
package matlab.processor;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


import dl.syntax.RealVariable;
import dl.syntax.Replacement;
import dl.syntax.Term;
import dl.syntax.dLFormula;
import interfaces.text.TextOutput;
import matlab.syntax.*;


public class IfProcessor {
	
	public static void pause() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//check for more than one assignment features at the end of if statement
//	public static void main(String[] arg){
//
//		// uncomment below to check if-else if-else and more than one assignment statements at the end	
//	//	  MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; elseif (n==0) y = k1*x;else k2 = 100; end z = x^2 + k2*y^2;p=0;");
//		TextOutput.setDebug( true ); TextOutput.useColor( false );
//		MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; else y = k1*x; k2 = 100; end p=43; z = x^2 + k2*y^2 + p;");
//		List<RealVariable> inputs = new ArrayList<>();
//		List<RealVariable> outputs = new ArrayList<>();
//		inputs.add( new RealVariable("x"));
//		
//		//outputs.add(new RealVariable("y")); 
//		outputs.add( new RealVariable ("z") );// outputs.add(new RealVariable("k2"));
//		mp = mergePostAssignments( mp );
//		mp = mergePreAssignments( mp, inputs, outputs );
//
//		TextOutput.info(mp.toString());
//	}
	
	public static MatlabProgram mergePostAssignments( MatlabProgram mp ) {
	//	List<Statement> matlabStatements = mp.getStatements();
		
		Stack<Statement> postAssignments = new Stack<>();
		while ( !(mp.peekLastStatement() instanceof IfStatement ) ) {
			postAssignments.push( mp.consumeLastStatement() );
		}
		List<Statement> postAssignmentList = new ArrayList<>();
		while ( !(postAssignments.isEmpty() )) {
			postAssignmentList.add(postAssignments.pop());
		}
		
			
		IfStatement ifStatement = ((IfStatement)mp.consumeLastStatement());
		for ( MatlabProgram ifCase : ifStatement.getPrograms() ) {
			ifCase.append(postAssignmentList);
		}
		mp.append( ifStatement );
		TextOutput.debug( "== Merged Post Assignments ==========================");
		TextOutput.debug( mp.toString() );
		TextOutput.debug("======================================================");
		return mp;
	}


	public static MatlabProgram mergePreAssignments( MatlabProgram newMatlabProgram,
														List<RealVariable> inputs,
														List<RealVariable> outputs ){
		
		int index = 0;
		MatlabProgram merged = newMatlabProgram;
		
		while( index < merged.getStatements().size() &&
				merged.getStatements().get(index) instanceof AssignmentStatement ) {
//			TextOutput.debug("Size of program to merge is: " + merged.getStatements().size() );
//			TextOutput.debug("Program to merge is: " + merged.toString() );
			AssignmentStatement assignment = (AssignmentStatement) merged.peekFirstStatement();
			
			if ( outputs.contains( assignment.getLHS() ) ) {
//				TextOutput.debug("Keeping assignment " + assignment.toString() );
//				TextOutput.debug("because it contains output variable: " + assignment.getLHS().toString() );
				index++;	
			} else {
//				TextOutput.debug("Deleting (after substituting) assignment " + assignment.toString() );
//				TextOutput.debug("because it contains no output variables");
				merged.consumeFirstStatement();
			}
			
		//	TextOutput.debug("MatlabProgram: "+ newMatlabProgram.getStatements().toString()+" Assignment: "+assignment );
			Replacement replacement = new Replacement( assignment.getLHS(), assignment.getRHS() );
			merged = replaceWithAssignment( merged, replacement, outputs);
//			TextOutput.debug("Merged is: " + merged );
		}
		
		
		
//		TextOutput.debug("New program is: ");
//		TextOutput.debug(merged.toString());
		return merged;

	}

	public static MatlabProgram replaceWithAssignment( MatlabProgram program, 
														Replacement rrreplacement,
														List<RealVariable> outputs ) {
		
		AssignmentStatement sReplaced;
		//Replacement replacement = new Replacement((RealVariable)assignment.getLHS(), assignment.getRHS());

		Replacement replacement = rrreplacement.clone();
		//TextOutput.debug("------------------------------");
		//TextOutput.debug( program.toString() );
		MatlabProgram result = new MatlabProgram();
		for ( Statement s : program.getStatements() ) {
			//TextOutput.debug("Replacing on statement: " + s.toString() );
			if ( s instanceof IfStatement) {
				// First, the conditions
				List<dLFormula> conditions = ((IfStatement)s).getConditions();
				List<MatlabProgram> programs = ((IfStatement)s).getPrograms();
				List<dLFormula> newConditions = new ArrayList<>();
				List<MatlabProgram> newPrograms = new ArrayList<>();
				//	TextOutput.debug("Replacement is: (" + replace.toMathematicaString() +")");
				for ( dLFormula condition : conditions ) {
					newConditions.add( condition.replace( replacement ) );
				}

				for ( MatlabProgram thisProgram : programs ) {
					//	TextOutput.debug("This program is: " + thisProgram.toString() );
					newPrograms.add( replaceWithAssignment( thisProgram, replacement, outputs ) );
				}

				result.append( new IfStatement( newConditions, newPrograms ) );

			} else if ( s instanceof AssignmentStatement ) {
				RealVariable sLHS = (RealVariable)((AssignmentStatement)s).getLHS();
				Term sRHS = ((AssignmentStatement)s).getRHS();
				
				sReplaced = new AssignmentStatement( sLHS , sRHS.replace( replacement ) );		
				replacement.put( sLHS, sRHS.replace(replacement) );

				result.append( sReplaced );

			}

		}
		//TextOutput.debug( "Substitution returns program: " + result.toString() );
		//pause();
		return result;


	}
}