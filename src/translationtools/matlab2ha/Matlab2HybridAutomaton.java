package translationtools.matlab2ha;

import ha.*;
import interfaces.text.TextOutput;
import matlab.syntax.*;
import java.util.*;

import dl.parser.PrettyPrinter;
import dl.syntax.*;;

public class Matlab2HybridAutomaton {
	
	public static HybridAutomaton convert( MatlabProgram matlabProgram, List<ExplicitODE> odes ) {
		return convert( matlabProgram, new TrueFormula(), odes);
	}
	
	public static HybridAutomaton convert( MatlabProgram matlabProgram, dLFormula timing, List<ExplicitODE> odes ) {
		int length = matlabProgram.asStatementList().size();
		List<dLFormula> guards = new ArrayList<>();
		List<HybridProgram> untimedResets = new ArrayList<>();
		List<MatlabProgram> statements = matlabProgram.asStatementList();
		List<HybridProgram> resets = new ArrayList<>();
		
		TextOutput.debug("Program is: " + matlabProgram.toString() );
		TextOutput.debug("Timing formula is: " + timing.toString() );

		if( statements.get(0) instanceof MatlabConditional ){
			guards = getGuards( ((MatlabConditional)(statements.get(0))) );
			untimedResets = getResets( ((MatlabConditional)(statements.get(0))) );
			System.out.println("size of guards: "+guards.size()+"\t Guards:"+guards+"\nSize of resets: "+untimedResets.size()+"\t Resets: "+untimedResets);
			
			
			if ( timing instanceof TrueFormula ) {
				// No problem!
				TextOutput.debug("timing was a true formula");
				resets = untimedResets;
			} else {
				TextOutput.debug("Timing variable: "+timing.toString());
				Set<RealVariable> timingVariables = timing.getFreeVariables();
				List<HybridProgram> timingResets = new ArrayList<>();
				for (RealVariable timingVariable : timingVariables ) {
					HybridProgram newReset = new ConcreteAssignmentProgram(timingVariable, new Real(0));
					TextOutput.debug("Adding reset: " + newReset.toString());
					timingResets.add( newReset );
				}
				HybridProgram timedReset = null;
				for ( HybridProgram untimedReset : untimedResets ) {
					for ( HybridProgram timingReset : timingResets ) {
						timedReset = new SequenceProgram( timingReset, untimedReset );
					}
					resets.add( timedReset );
				}
				
			}
			
		}else{
			System.out.println(statements.get(0).toString());
			throw new RuntimeException("HybridAutomaton.convert() requires guards and resets to be specified as an MatlabConditional");
			//TODO: presuming if its not an MatlabConditional it would be Assignment statement, should we fetch the next program?
//			for ( int i = 0; i<length; i++){
//				guards = getGuards( ((MatlabConditional)(program.get(i))) );
//				resets = getResets( ((MatlabConditional)(program.get(i))) );
			//System.out.println("size of guards: "+guards.size()+" Guards:"+guards+" Size of resets: "+resets.size()+" Resets: "+resets);
//		}
//				TextOutput.debug("The class of program: "+peekFirstStatement().getClass());
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
				TextOutput.debug("Adding reset: " + hp.toString());
				Edge thisEdge = new Edge(tempdl, hp);
				edges.add( thisEdge );
				System.out.println("Guard "+PrettyPrinter.print(tempdl)+" reset: "+hp);
				
			}
			
			
		}
		
		Mode mode = new Mode( odes, timing, edges, edges );
		List<Mode> modes = new ArrayList<>(); 
		modes.add( mode );
		
		return new HybridAutomaton( modes, edges );
	}
	
	public static List<dLFormula> getGuards( MatlabConditional ifStatement ) {
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
	
	public static List<HybridProgram> getResets( MatlabProgram ifStatement ) {
		List<MatlabProgram> programs = ((MatlabConditional) ifStatement).getPrograms();

		List<HybridProgram> resetList = new ArrayList<>();
		SequenceProgram thisHybridProgram = null ;
		for ( MatlabProgram program : programs ) {

			TextOutput.info("Size of getstatements: "+program.asStatementList().size()); 
			TextOutput.info("Program---->"+program);
			if ( program.asStatementList().size() == 1) {
				List<MatlabProgram> p = program.asStatementList();

				RealVariable LHS = ((MatlabAssignment) p.get(0)).getLHS();
				Term RHS = ((MatlabAssignment)p.get(0)).getRHS();
				ConcreteAssignmentProgram concreteHybridProgram = new ConcreteAssignmentProgram( LHS, RHS );
				resetList.add(concreteHybridProgram);

			} else {
				boolean first = true;
				boolean second = false;
				ConcreteAssignmentProgram firstProgram = null;
				SequenceProgram thisSequenceProgram = null;
				for ( MatlabProgram statement : program.asStatementList() ) {
					RealVariable LHS = ((MatlabAssignment) statement).getLHS();
					Term RHS = ((MatlabAssignment)statement).getRHS();
					ConcreteAssignmentProgram concreteHybridProgram = new ConcreteAssignmentProgram( LHS, RHS );

					if ( first ) {
						firstProgram = concreteHybridProgram;
						first = false; second = true;
					} else if (second) {
						thisSequenceProgram = new SequenceProgram( firstProgram, concreteHybridProgram );
					} else {
						thisSequenceProgram = new SequenceProgram( thisSequenceProgram, concreteHybridProgram );
					}

				}
				resetList.add( thisSequenceProgram );

			}
		}
		return resetList;
	}

	
}
