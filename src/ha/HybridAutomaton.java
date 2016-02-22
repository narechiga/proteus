package ha;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.beans.finder.FieldFinder;

import dl.syntax.AndFormula;
import dl.syntax.ExplicitODE;
import dl.syntax.HybridProgram;
import dl.syntax.OrFormula;
import dl.syntax.RealVariable;
import dl.syntax.dLFormula;
import dl.syntax.dLStructure;

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
	
	public String toString( List<RealVariable> outputs ){
		StringBuffer string2dReach = new StringBuffer();
		StringBuffer newReset = new StringBuffer();
		string2dReach.append("{ mode 1;\n \ninvt: \n \t (");
		List<dLFormula> subInvariants = Mode.getInvariant().splitOnAnds();
		for ( dLFormula formula : subInvariants ) {
			string2dReach.append( formula + ");\n \n");
		}
		
		string2dReach.append("flow: \n \t TODO...\n \njump:");
		int edgesSize = edges.size();
				
		int index = 0;
		while( index < edgesSize ){
			String tempReset = edges.get(index).getReset().toKeYmaeraString();
			
			//TODO:ask Nikos: "and" should precede only if there are two statements?
			string2dReach.append("\n \t"+edges.get(index).getGuard().toKeYmaeraString()+" ==> @1 (and "+tempReset.replaceAll(":=","=").replaceAll(";"," ").replaceAll(outputs.get(0).toKeYmaeraString(),outputs.get(0).toKeYmaeraString()+"'"));
			index++;
		}
				
		System.out.println("Modes in HybridAutomaton:");
		
			
		return string2dReach.toString();
	}
//TODO: 1. get the ' working on outputs, 2. flow:
}
