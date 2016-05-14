package matlab.processor;

import matlab.syntax.*;
import dl.syntax.*;
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

	public static void main( String [] args ) {
		
	}
	
}
