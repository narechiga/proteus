package translationtools.matlab2ha;

import ha.*;
import interfaces.text.TextOutput;
import matlab.syntax.*;
import java.util.*;
import dl.syntax.*;;

public class Matlab2HybridAutomaton {

	public static HybridAutomaton convert( MatlabProgram program ) {
		//TODO Check if the program has exactly one statement, and that statement should be an IfStatements
//		if ( !(program instanceof IfStatement) )//|| !(program.getStatements().size() == 1))
//			return null;
//		
		List<dLFormula> guards = getGuards( ((IfStatement)(program.getStatements().get(0))) );
		List<HybridProgram> resets = getResets( ((IfStatement)(program.getStatements().get(0))) );
		
		System.out.println("size of guards: "+guards.size()+" Size of resets: "+resets.size());
//		System.out.println("guard[0] "+guards.get(0)+" guard[1] "+guards.get(1));
//		System.out.println("reset[0] "+resets.get(0)+" reset[1] "+resets.get(1));
		List<Edge> edges = new ArrayList<>();
		
		/* for each guard and reset,
		 * thisEdge = new Edge( thisGuard, thisReset );
		 * edges.add( thisEdge );
		 */
		
		Iterator guardsIterator = guards.iterator();
		Iterator resetsIterator = resets.iterator();
		while ( guardsIterator.hasNext() && resetsIterator.hasNext()){
			
			dLFormula tempdl = (dLFormula)guardsIterator.next();
			HybridProgram hp = (HybridProgram)resetsIterator.next();
			Edge thisEdge = new Edge(tempdl, hp);
			edges.add( thisEdge );
			System.out.println("Guard "+tempdl.toMathematicaString()+" reset: "+hp);
			
		}
		
//		int index = 0;
//		while ( index<guards.size() &&  index<resets.size())
//		{
//			System.out.println("HybridAutomaton Modes: "+guards.get(index)+""+resets.get(index));
//			Edge thisEdge = new Edge(guards.get(index), resets.get(index));
//			edges.add( thisEdge );
//			index++;
//		}
		Mode mode = new Mode( new ArrayList<ExplicitODE>(), new TrueFormula(), edges, edges );
		List<Mode> modes = new ArrayList<>(); 
		modes.add( mode );
		
		
		
		
		return new HybridAutomaton( modes, edges );
	}
	
//TODO for the else part, generate the guard	
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
		
		
		dLFormula elseFormula = new TrueFormula();
				
		// add each "thisGuard" to the return list
		guardList.add( thisGuard );
		
	//	guardList.add(elseFormula);//the Last else as true
				
//		Iterator guardIterator =  guardList.iterator();
//		while ( guardIterator.hasNext() )
//			System.out.println("Guard conditions: "+((AndFormula)guardIterator.next()).toMathematicaString());
		
		return guardList;
	}
	
	public static List<HybridProgram> getResets( IfStatement ifStatement ) {
		// make an arraylist of the programs -- ifStatement.getPrograms()
		List<MatlabProgram> programs = ifStatement.getPrograms();
		
		Iterator programsIterator =  programs.iterator();
		while ( programsIterator.hasNext() )
			System.out.println("Programs: "+programsIterator.next());
		
		List<HybridProgram> resetList = new ArrayList<>();
		
		// Turn each assignment into a ConcreteAssignmentProgram, then string them together with SequenceProgram
		for ( MatlabProgram program : programs/*programlist*/ ) {
			SequenceProgram thisHybridProgram = null ;
	//		ConcreteAssignmentProgram concreteHybridProgram, assignment1, assignment2;
			
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
			
			TextOutput.info("Size of getstatements: "+program.getStatements().size()); 
			TextOutput.info("it include---->"+program);
			if ( program.getStatements().size() == 1){
				List<Statement> p = program.getStatements();
				//RealVariable LHS = (RealVariable)((AssignmentStatement)program).getLHS();
						
				RealVariable LHS = ((AssignmentStatement) p.get(0)).getLHS();
				Term RHS = ((AssignmentStatement)p.get(0)).getRHS();
				ConcreteAssignmentProgram concreteHybridProgram = new ConcreteAssignmentProgram( LHS, RHS );
				thisHybridProgram = new SequenceProgram(concreteHybridProgram, concreteHybridProgram);
				resetList.add(thisHybridProgram);
			}else if ( program.getStatements().size() == 2){
				RealVariable LHS0 = (RealVariable)((AssignmentStatement)program.getStatements().get(0)).getLHS();
				Term RHS0 = ((AssignmentStatement)program.getStatements().get(0)).getRHS();
				ConcreteAssignmentProgram assignment1 = new ConcreteAssignmentProgram( LHS0, RHS0 );
				RealVariable LHS1 = (RealVariable)((AssignmentStatement)program.getStatements().get(1)).getLHS();
				Term RHS1 = ((AssignmentStatement)program.getStatements().get(1)).getRHS();
				ConcreteAssignmentProgram assignment2 = new ConcreteAssignmentProgram( LHS1, RHS1 );
				thisHybridProgram = new SequenceProgram(assignment1, assignment2);
				resetList.add(thisHybridProgram);
			}else{
				List<Statement> resetsStatements = program.getStatements();
				int index = 0;
				while ( index < resetsStatements.size() -1){
					RealVariable LHS0 = (RealVariable)((AssignmentStatement)program.getStatements().get(index)).getLHS();
					Term RHS0 = ((AssignmentStatement)program.getStatements().get(index)).getRHS();
					ConcreteAssignmentProgram assignment1 = new ConcreteAssignmentProgram( LHS0, RHS0 );
					RealVariable LHS1 = (RealVariable)((AssignmentStatement)program.getStatements().get(index + 1)).getLHS();
					Term RHS1 = ((AssignmentStatement)program.getStatements().get(index + 1)).getRHS();
					ConcreteAssignmentProgram assignment2 = new ConcreteAssignmentProgram( LHS1, RHS1 );
					thisHybridProgram = new SequenceProgram(assignment1, assignment2);
					index++;
					resetList.add(thisHybridProgram);
					//TODO consider calling it recursively??
				}
				
				
			}
			
//			resetList.add(thisHybridProgram);
		
			
			//TODO:Ask Nikos: what is the purpose of this for loop?
			for ( Statement statement : program.getStatements() ) {
				/* if statement is not an instance of assignment statement, throw and exception*/
				/* else */
				
			}
		}
		return resetList;
	}

	
}
