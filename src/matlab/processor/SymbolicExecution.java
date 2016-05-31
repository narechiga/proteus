package matlab.processor;

import matlab.syntax.*;
import dl.syntax.*;
import interfaces.text.TextOutput;

import java.util.*;

public class SymbolicExecution {
	
	public static MatlabProgram run( MatlabProgram program, List<RealVariable> outputs ) {
		MatlabProgram result = null;

		if ( program instanceof NoOp ) {
			
			result = new NoOp();
			
		} else if ( program instanceof MatlabAssignment ) {
			
			MatlabAssignment assignment = ((MatlabAssignment)program);
		 	if( outputs.contains( assignment.getLHS() )) {
		 		result = program;
		 	} else {
		 		result = new NoOp();
		 	}
		} else if ( program instanceof MatlabConditional ) {
			
			MatlabConditional conditional = (MatlabConditional)program;
			List<dLFormula> conditions = conditional.getConditions();
			List<MatlabProgram> subPrograms = conditional.getPrograms();
			
			List<MatlabProgram> executedPrograms = new ArrayList<>();
			for ( MatlabProgram subProgram : subPrograms ) {
				executedPrograms.add( run( subProgram, outputs ) );
			}
			result = new MatlabConditional( conditions, executedPrograms );
			
		} else if ( program instanceof MatlabSequence ) {
			
			MatlabSequence sequence = (MatlabSequence)program;
			
			if ( sequence.getFirstProgram() instanceof MatlabAssignment ) {

				MatlabAssignment assignment = (MatlabAssignment)(sequence.getFirstProgram());
				RealVariable variable = assignment.getLHS();
				Term term = assignment.getRHS();
				Replacement replacement = new Replacement( variable, term );
				
				MatlabProgram firstPart = run( sequence.getFirstProgram(), outputs );
				MatlabProgram secondPart = run( sequence.getSecondProgram().replace( replacement ), outputs);
				
				result = new MatlabSequence( firstPart, secondPart );

			} else if ( sequence.getFirstProgram() instanceof MatlabConditional ) {
				MatlabConditional conditional = (MatlabConditional)(sequence.getFirstProgram() );
				List<dLFormula> conditions = conditional.getConditions();
				List<MatlabProgram> subPrograms = conditional.getPrograms();
				List<MatlabProgram> newPrograms = new ArrayList<>();
				
				for ( MatlabProgram subProgram : subPrograms ) {
					MatlabSequence thisSequence = new MatlabSequence( subProgram, sequence.getSecondProgram() );
					newPrograms.add( run(thisSequence, outputs) );
				}
				result = new MatlabConditional( conditions, newPrograms );
				
				
			} else {
				throw new RuntimeException("This should be unreachable; did you add a new type of program and forget to fully support it?");
			}

		} else {
			throw new RuntimeException("This should be unreachable; did you add a new type of program and forget to fully support it?");
		}

		return result;
	}

	public static boolean unitTest() {
		TextOutput.setDebug(true);
		TextOutput.useColor(false);
		boolean pass = true;
		
		MatlabProgram program; MatlabProgram newProgram;
		List<RealVariable> outputs = new ArrayList<>();
		outputs.add( new RealVariable("y1"));
		outputs.add( new RealVariable("y2"));
		outputs.add( new RealVariable("y3"));
		
		// No-Op
		program = new NoOp();
		newProgram = run( program, outputs );
		pass = pass && ( newProgram instanceof NoOp );
		TextOutput.debug("No-op case: " + newProgram.toString() );
		TextOutput.info("Test passed: " + pass );
		
		// Assignment to intermediate variable
		program = new MatlabAssignment( new RealVariable("k1"), (Term)(dLStructure.parseStructure("3*y1 + 3*k2")) );
		newProgram = run( program, outputs);
		pass = pass && ( newProgram instanceof NoOp );
		TextOutput.debug("Assignment to intermediate variable: " + newProgram.toString() );
		TextOutput.info("Test pased: " + pass );
		
		// Assignment to output variable
		program = new MatlabAssignment( new RealVariable("y2"), (Term)(dLStructure.parseStructure("3*y1 + 3*k2")));
		
		
		return pass;
		
		
	}
	
	public static void main( String [] args ) {
		
	}
	
}
