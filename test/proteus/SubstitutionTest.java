package proteus;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dl.syntax.RealVariable;
import ha.Edge;
import ha.HybridAutomaton;
import ha.Mode;
import interfaces.text.TextOutput;
import matlab.processor.SubstitutionStage;
import matlab.syntax.MatlabProgram;
import translationtools.matlab2ha.Matlab2HybridAutomaton;

public class SubstitutionTest {

	@Test
	public void test() {
		
		SubstitutionStage substitution = new SubstitutionStage();
			// uncomment below to check if-else if-else and more than one assignment statements at the end	
			  MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; elseif (n==0) y = k1*x;else k2 = 100; end z = x^2 + k2*y^2;p=0;");
			TextOutput.setDebug( true ); TextOutput.useColor( false );
		//	MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; else y = k1*x; k2 = 100; end p=43; z = x^2 + k2*y^2 + p;");
			List<RealVariable> inputs = new ArrayList<>();
			List<RealVariable> outputs = new ArrayList<>();
			inputs.add( new RealVariable("x"));
			
			outputs.add(new RealVariable("y")); 
			outputs.add( new RealVariable ("z") );// outputs.add(new RealVariable("k2"));
			mp = substitution.mergePostAssignments( mp );
			mp = substitution.mergePreAssignments( mp, inputs, outputs );
		
			TextOutput.info("Matlab program going to HybridAutomaton: "+mp.toString());			
			System.out.println("=======================================================================");
			Matlab2HybridAutomaton matlab2HybridAutomaton= new Matlab2HybridAutomaton();
			HybridAutomaton ha = Matlab2HybridAutomaton.convert(mp);
			List<Mode> modes = ha.getModes();
			List<Edge> edges = ha.getEdges();
			System.out.println("Edge Size "+ edges.size());
			System.out.println("Mode: Incoming Edge, guard: "+modes.get(0).getIncomingEdges().get(0).getGuard().toKeYmaeraString());
			System.out.println("Mode: Incoming Edge, reset: "+modes.get(0).getIncomingEdges().get(0).getReset().toKeYmaeraString());
			System.out.println("Edges - getGuard: "+edges.get(0).getGuard().toKeYmaeraString());
			System.out.println("Edges - getReset: "+edges.get(0).getReset().toKeYmaeraString());
			System.out.println("=======================================================================");
			System.out.println("Mode: Incoming Edge, guard: "+modes.get(0).getIncomingEdges().get(1).getGuard().toKeYmaeraString());
			System.out.println("Mode: Incoming Edge, reset: "+modes.get(0).getIncomingEdges().get(1).getReset().toKeYmaeraString());
			System.out.println("Edges - getGuard: "+edges.get(1).getGuard().toKeYmaeraString());
			System.out.println("Edges - getReset: "+edges.get(1).getReset().toKeYmaeraString());
			System.out.println("=======================================================================");
			System.out.println("Mode: Incoming Edge, guard: "+modes.get(0).getIncomingEdges().get(2).getGuard().toKeYmaeraString());
			System.out.println("Mode: Incoming Edge, reset: "+modes.get(0).getIncomingEdges().get(2).getReset().toKeYmaeraString());
			System.out.println("Edges - getGuard: "+edges.get(2).getGuard().toKeYmaeraString());
			System.out.println("Edges - getReset: "+edges.get(2).getReset().toKeYmaeraString());
							
	}
}
