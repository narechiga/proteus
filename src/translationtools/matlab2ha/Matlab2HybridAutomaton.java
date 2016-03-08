package translationtools.matlab2ha;

import ha.*;
import interfaces.text.TextOutput;
import matlab.syntax.*;
import java.util.*;
import dl.syntax.*;;

public class Matlab2HybridAutomaton {

	public static HybridAutomaton convert( MatlabProgram matlabProgram, List<ExplicitODE> odes ) {
		int length = matlabProgram.getStatements().size();
		List<dLFormula> guards = new ArrayList<>();
		List<HybridProgram> resets = new ArrayList<>();
		List<Statement> program = matlabProgram.getStatements();
		
		if( program.get(0) instanceof IfStatement ){
			guards = getGuards( ((IfStatement)(program.get(0))) );
			resets = getResets( ((IfStatement)(program.get(0))) );
			System.out.println("size of guards: "+guards.size()+"\t Guards:"+guards+"\nSize of resets: "+resets.size()+"\t Resets: "+resets);
		}else{
			throw new RuntimeException("HybridAutomaton.convert() requires guards and resets to be specified as an IfStatement");
			//TODO: presuming if its not an IfStatement it would be Assignment statement, should we fetch the next program?
//			for ( int i = 0; i<length; i++){
//				guards = getGuards( ((IfStatement)(program.get(i))) );
//				resets = getResets( ((IfStatement)(program.get(i))) );
			//System.out.println("size of guards: "+guards.size()+" Guards:"+guards+" Size of resets: "+resets.size()+" Resets: "+resets);
//		}
//				TextOutput.debug("The class of program: "+program.get(0).getClass());
//				convert ( program.get(1), odes);
				
			}
		
		
//		System.out.println("size of guards: "+guards.size()+" Guards:"+guards+" Size of resets: "+resets.size()+" Resets: "+resets);
//		System.out.println("guard[0] "+guards.get(0)+" guard[1] "+guards.get(1));
//		System.out.println("reset[0] "+resets.get(0)+" reset[1] "+resets.get(1));
		List<Edge> edges = new ArrayList<>();
		
		/* for each guard and reset,
		 * thisEdge = new Edge( thisGuard, thisReset );
		 * edges.add( thisEdge );
		 */
		
		Iterator<dLFormula> guardsIterator = guards.iterator();
		Iterator<HybridProgram> resetsIterator = resets.iterator();
	//	while ( guardsIterator.hasNext() && resetsIterator.hasNext()){
		while ( resetsIterator.hasNext()){
			
			if ( guardsIterator.hasNext() == false)
			{
				HybridProgram hp = (HybridProgram)resetsIterator.next();
				Edge thisEdge = new Edge(true, hp);
				edges.add( thisEdge );
			}else{
				dLFormula tempdl = (dLFormula)guardsIterator.next();
				HybridProgram hp = (HybridProgram)resetsIterator.next();
				Edge thisEdge = new Edge(tempdl, hp);
				edges.add( thisEdge );
				System.out.println("Guard "+tempdl.toMathematicaString()+" reset: "+hp);
				
			}
			
			
		}
		
		Mode mode = new Mode( odes, new TrueFormula(), edges, edges );
		List<Mode> modes = new ArrayList<>(); 
		modes.add( mode );
		
		return new HybridAutomaton( modes, edges );
	}
	
	public static List<dLFormula> getGuards( IfStatement ifStatement ) {
		// make an arraylist of conditions
		List<dLFormula> conditions = (ifStatement).getConditions();
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
			guardList.add( thisGuard );
			index++;
		}
		
		dLFormula elseFormula = new TrueFormula();
				
		// add each "thisGuard" to the return list
		
		
		return guardList;
	}
	
	public static List<HybridProgram> getResets( Statement ifStatement ) {
		List<MatlabProgram> programs = ((IfStatement) ifStatement).getPrograms();
		
		Iterator programsIterator =  programs.iterator();
		while ( programsIterator.hasNext() )
			System.out.println("Programs: "+programsIterator.next());
		
		List<HybridProgram> resetList = new ArrayList<>();
		SequenceProgram thisHybridProgram = null ;
		for ( MatlabProgram program : programs/*programlist*/ ) {
			
			TextOutput.info("Size of getstatements: "+program.getStatements().size()); 
			TextOutput.info("Program---->"+program);
			if ( program.getStatements().size() == 1){
				List<Statement> p = program.getStatements();
						
				RealVariable LHS = ((AssignmentStatement) p.get(0)).getLHS();
				Term RHS = ((AssignmentStatement)p.get(0)).getRHS();
				ConcreteAssignmentProgram concreteHybridProgram = new ConcreteAssignmentProgram( LHS, RHS );
				resetList.add(concreteHybridProgram);
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
				while ( index < resetsStatements.size() ){
					RealVariable LHS0 = (RealVariable)((AssignmentStatement)program.getStatements().get(index)).getLHS();
					Term RHS0 = ((AssignmentStatement)program.getStatements().get(index)).getRHS();
					ConcreteAssignmentProgram assignment1 = new ConcreteAssignmentProgram( LHS0, RHS0 );
					index++;
					RealVariable LHS1 = (RealVariable)((AssignmentStatement)program.getStatements().get(index)).getLHS();
					Term RHS1 = ((AssignmentStatement)program.getStatements().get(index)).getRHS();
					ConcreteAssignmentProgram assignment2 = new ConcreteAssignmentProgram( LHS1, RHS1 );
					thisHybridProgram = new SequenceProgram(assignment1, assignment2);
					index++;
					resetList.add(thisHybridProgram);
				}
			}
		}

		return resetList;
	}

	
}
