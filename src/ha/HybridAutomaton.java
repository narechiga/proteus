package ha;

import java.util.List;

import dl.syntax.AndFormula;
import dl.syntax.OrFormula;
import dl.syntax.dLFormula;

public class HybridAutomaton {

	List<Mode> modes;
	List<Edge> edges;

	public HybridAutomaton( List<Mode> modes, List<Edge> edges ) {
		this.modes = modes;
		this.edges = edges;
	}

	public String toDOTString() {
		return "";
	}

//	public String todReachString( String box, dLFormula init, dLFormula goal ) {
//		TextOutput.warning("Warning: this code is untested!");
//
//		String s = "";
//
//		s += box;
//
//		for ( Mode mode : modes ) {
//
//			s +=( "{ mode " + modes.indexOf( mode ) + ";\n\n");
//
//			s += "invt:\n";
//			List<dLFormula> subInvariants = mode.getInvariant().splitOnAnds();
//			for ( dLFormula formula : subInvariants ) {
//				s += (formula2dReach( formula ) + ";\n");
//			}
//			s += "\n";
//
//			s += "flow:\n";
//			for ( ExplicitODE ode : mode.getODEs() ) {
//				s += ("d/dt[" + ode.getLHS() +"] = " 
//					+ ode.getRHS().toKeYmaeraString() + ";\n" );
//			}
//
//			s += "jump:\n";
//			for ( Edge edge : mode.getIncomingEdges() ) {
//				s += ("(" + formula2dReach( edge.getGuard() ) + ")");
//				s += " ==> ";
//				s += ("@"); //TODO: get the destination mode somehow
//				s += ("(" + program2dReach( edge.getReset() ) + ")");
//			}
//			
//			s += "}\n"
//		}
//
//		return s;
//
//	}

//	protected String program2dReach( HybridProgram program ) {
//		if ( !(program instanceof SequenceProgram
//						|| program instanceof ConcreteAssignmentProgram
//						//|| program instanceof ArbitraryAssignmentProgram
//						//|| program instanceof TestProgram 
//						) {
//
//			TextOutput.error( program.getClass() 
//				+ " is not currently supported as a reset");
//			return null; //<- this statement is unreachable
//		}
//
//		if ( program instanceof SequenceProgram ) {
//			List<HybridProgram> subPrograms = program.splitOnSequence();
//			return ...TODO...
//		} else if ( program instanceof ConcreteAssignmentProgram ) {
//			return ...TODO...
//
//		}
//
//	}

	protected String formula2dReach( dLFormula formula ) {
		if ( formula instanceof AndFormula ) {
			AndFormula thisFormula = (AndFormula)formula;
			return "(and " + formula2dReach( thisFormula.getLHS() )
			                + formula2dReach( thisFormula.getRHS() ) + " )";
			
		} else if ( formula instanceof OrFormula ) {
			OrFormula thisFormula = (OrFormula)formula;
			return "(or " + formula2dReach( thisFormula.getLHS() )
			              + formula2dReach( thisFormula.getRHS() ) + " )";
			
		} else if ( formula.isPropositionalPrimitive() ) {
			return "( " + formula.toKeYmaeraString() + " )"; 
		
		} else {
			System.out.println("WARNING: This formula type might"
		                    + "be unsoppurted by dReach");
			return "( " + formula.toKeYmaeraString() + " )";
		}     
	}
	
	public List<Mode> getModes(){
		return modes;
	}
	
	public List<Edge> getEdges(){
		return edges;
	}
	
	public String toString( List<Mode> modes, List<Edge> edges){
		StringBuffer string2dReach = new StringBuffer();
		
		string2dReach.append("{ mode 1;\n \ninvt: \n \t (");//
		
		System.out.println("Modes in HybridAutomaton:"+);
		//TODO: trying to get invariant for the mode
			
		return string2dReach.toString();
	}

}
