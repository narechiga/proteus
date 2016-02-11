package translationtools.matlab2ha;

import ha.*;
import matlab.syntax.*;
import java.util.*;
import dl.syntax.*;

public class Matlab2HybridAutomaton {

	public static HybridAutomaton convert( MatlabProgram program ) {
		//TODO Check if the program has exactly one statement, and that statement should be an IfStatements
		if ( !(program instanceof IfStatement) || !(program.getStatements().size() == 1))
			return null;
		
		List<dLFormula> guards = getGuards( ((IfStatement)(program.getStatements().get(0))) );
		List<HybridProgram> resets = getResets( ((IfStatement)(program.getStatements().get(0))) );
		
		List<Edge> edges = new ArrayList<>();
		/* for each guard and reset,
		 * thisEdge = new Edge( thisGuard, thisReset );
		 * edges.add( thisEdge );
		 */
//TODO: ASK NIKOS, mode changed from default to public, is that ok?	
		Mode mode = new Mode( new List<ExplicitODE>(), new TrueFormula(), edges, edges );
		List<Mode> modes = new ArrayList<>(); modeList.add( mode );
		return new HybridAutomaton( modes, edges );
	}
	
	public static List<dLFormula> getGuards( IfStatement ifStatement ) {
		// make an arraylist of conditions
		List<dLFormula> conditions = ifStatement.getConditions();
		List<dLFormula> guardList = new ArrayList<>();
		dLFormula thisGuard = null;
		int index = 0;
		while ( index < conditions.size() /*length of conditions*/ ) {
			int index2 = 0;
			dLFormula negatedPrevious = new TrueFormula();
			while ( index2 < index ) {
				negatedPrevious = new AndFormula(negatedPrevious, conditions.get(index2).negate() );
				index2++;
			}
			 thisGuard = new AndFormula( negatedPrevious, conditions.get(index));
			index++;
		}
		
		// add each "thisGuard" to the return list
		guardList.add( thisGuard );
		return guardList;
	}
	
	public static List<HybridProgram> getResets( IfStatement ifStatement ) {
		// make an arraylist of the programs -- ifStatement.getPrograms()
		List<MatlabProgram> programs = ifStatement.getPrograms();
		List<HybridProgram> resetList = new ArrayList<>();
		
		// Turn each assignment into a ConcreteAssignmentProgram, then string them together with SequenceProgram
		for ( MatlabProgram program : programs/*programlist*/ ) {
			SequenceProgram thisHybridProgram;
			ConcreteAssignmentProgram concreteHybridProgram, assignment1, assignment2;
			
			/* if program contains a single statement, then
			 * thisHybridProgram = new ConcreteAssignmentProgram( program.getLHS(), program.getRHS() );
			 * 
			/* if it has two statements, then
			 * 	- convert each statement to a ConcreteAssignmentProgram, assignment1 and assignment2
			 *  - string them together:
			 *  thisHybridProgram = new SequenceProgram( assignment1, assignment 2);
			 */
			/* else
			 * String the first two together, then for each additional one,
			 * thisHybridProgram = new SequenceProgram( thisHybridPRogram, nextAssignment );
			 */
			if ( program.getStatements().size() == 1){
				RealVariable LHS = (RealVariable)((AssignmentStatement)program).getLHS();
				Term RHS = ((AssignmentStatement)program).getRHS();
				concreteHybridProgram = new ConcreteAssignmentProgram( LHS, RHS );
				thisHybridProgram = new SequenceProgram(concreteHybridProgram, null);
			}else if ( program.getStatements().size() == 2){
				RealVariable LHS0 = (RealVariable)((AssignmentStatement)program.getStatements().get(0)).getLHS();
				Term RHS0 = ((AssignmentStatement)program.getStatements().get(0)).getRHS();
				 assignment1 = new ConcreteAssignmentProgram( LHS0, RHS0 );
				RealVariable LHS1 = (RealVariable)((AssignmentStatement)program.getStatements().get(1)).getLHS();
				Term RHS1 = ((AssignmentStatement)program.getStatements().get(1)).getRHS();
				assignment2 = new ConcreteAssignmentProgram( LHS1, RHS1 );
				thisHybridProgram = new SequenceProgram(assignment1, assignment2);
			}else{
				List<Statement> resetsStatements = program.getStatements();
				int index = 0;
				while ( index < resetsStatements.size()-1 ){
					RealVariable LHS0 = (RealVariable)((AssignmentStatement)program.getStatements().get(index)).getLHS();
					Term RHS0 = ((AssignmentStatement)program.getStatements().get(index)).getRHS();
					 assignment1 = new ConcreteAssignmentProgram( LHS0, RHS0 );
					RealVariable LHS1 = (RealVariable)((AssignmentStatement)program.getStatements().get(index + 1)).getLHS();
					Term RHS1 = ((AssignmentStatement)program.getStatements().get(index + 1)).getRHS();
					assignment2 = new ConcreteAssignmentProgram( LHS1, RHS1 );
					thisHybridProgram = new SequenceProgram(assignment1, assignment2);
					index++;
					
					//TODO consider calling it recursively??
				}
				
				
			}
			
			
			
			for ( Statement statement : program.getStatements() ) {
				/* if statement is not an instance of assignment statement, throw and exception*/
				/* else */
				
			}
		}
	}

	
}
