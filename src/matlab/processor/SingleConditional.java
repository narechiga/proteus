package matlab.processor;

import matlab.syntax.*;
import dl.syntax.*;
import java.util.*;

public class SingleConditional {
	
	public static MatlabConditional conditionalize( MatlabProgram program ) {
		MatlabConditional singleConditional = null;
		
		if ( isAssignmentBlock( program ) ) {
			
			singleConditional = new MatlabConditional( new TrueFormula(), program );
			
		} else if ( program instanceof MatlabConditional ) {
			
			singleConditional = (MatlabConditional)program;
			
		} else if ( isAssignmentBlockFollowedByConditional( program ) ) {
			
			singleConditional = processAssignmentBlockFollowedByConditional( program );
			
		} else {
			throw new RuntimeException("This program structure is not supported!: " + program.toString() );
		}
		
		return singleConditional;
	}
	
	protected static boolean isAssignmentBlock( MatlabProgram program ) {
		List<MatlabProgram> statements = program.asStatementList();
		
		boolean result = true;
		for ( MatlabProgram statement : statements ) {
			result = result && ( statement instanceof MatlabAssignment );
		}
		return result;
	}
	
	protected static boolean isAssignmentBlockFollowedByConditional( MatlabProgram program ) {
		if ( !(program instanceof MatlabSequence) ) {
			return false;
		}
		
		MatlabProgram head = ((MatlabSequence)program).getFirstProgram();
		MatlabProgram tail = ((MatlabSequence)program).getSecondProgram();
		
		return ((isAssignmentBlock(head)) && ( tail instanceof MatlabConditional ));
	}
	
	protected static MatlabConditional processAssignmentBlockFollowedByConditional( MatlabProgram program ) {
		// Assuming you already checked that the program isAssignmentBlockFollowedByConditional !
		
		MatlabProgram head = ((MatlabSequence)program).getFirstProgram();
		MatlabProgram tail = ((MatlabSequence)program).getSecondProgram();
		
		List<MatlabProgram> subPrograms = ((MatlabConditional)tail).getPrograms();
		List<dLFormula> conditions = ((MatlabConditional)tail).getConditions();
		
		List<MatlabProgram> newSubPrograms = new ArrayList<>();
		for ( MatlabProgram thisSubProgram : subPrograms ) {
			newSubPrograms.add( new MatlabSequence( head, thisSubProgram ));
		}
		
		return new MatlabConditional( conditions, newSubPrograms );
		
	}
	
	public static void main ( String [] args ) {
		
	}
}
