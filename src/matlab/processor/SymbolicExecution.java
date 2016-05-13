package matlab.processor;

import matlab.syntax.*;
import dl.syntax.*;
import java.util.*;

public class SymbolicExecution {
	
	public static MatlabProgram run( MatlabProgram program, List<RealVariable> outputs ) {
		MatlabProgram result = null;

		if ( program.isNoOp() ) {
			
			result = (new NoOp()).toMatlabProgram();
			
		} else if ( program.isAssignment() ) {
			
			AssignmentStatement assignment = ((AssignmentStatement)program.getFirstStatement());
		 	if( outputs.contains( assignment.getLHS() )) {
		 		result = program;
		 	} else {
		 		result = (new NoOp()).toMatlabProgram();
		 	}
		} else if ( program.isConditional() ) {
			
			IfStatement conditional = ((IfStatement)(program.getFirstStatement()));
			List<dLFormula> conditions = conditional.getConditions();
			List<MatlabProgram> subPrograms = conditional.getPrograms();
			
			List<MatlabProgram> executedPrograms = new ArrayList<>();
			for ( MatlabProgram subProgram : subPrograms ) {
				executedPrograms.add( run( subProgram, outputs ) );
			}	
			
		} else if ( program.getFirstStatement() instanceof AssignmentStatement ) {
			
			RealVariable variable = ((AssignmentStatement)(program.getFirstStatement())).getLHS();
			Term term = ((AssignmentStatement)(program.getFirstStatement())).getRHS();
			
			result = new MatlabProgram( program.getFirstStatement().replace( new Replacement(variable, term) ) );
			result = result.append( program.exceptFirstStatement().replace( new Replacement(variable, term) ) );

		} else if ( program.getFirstStatement() instanceof IfStatement ) {
			
		}

		return result;
	}

	public static void main( String [] args ) {
		
	}
	
}
