package matlab.processor;

import matlab.syntax.*;
import dl.syntax.*;
import java.util.*;

public class SingleConditional {
	
	public static MatlabConditional run( MatlabProgram program ) {
		MatlabConditional singleConditional = null;
		
		if ( isAssignmentBlock( program ) ) {
			singleConditional = new MatlabConditional( new TrueFormula(), program );
		} else if ( program instanceof MatlabConditional ) {
			singleConditional = (MatlabConditional)program;
		} else if () {
			
		}
		
		
		return singleConditional;
	}
	
	public static boolean isAssignmentBlock( MatlabProgram program ) {
		List<MatlabProgram> statements = program.asStatementList();
		
		boolean result = true;
		for ( MatlabProgram statement : statements ) {
			result = result && ( statement instanceof MatlabAssignment );
		}
		return result;
	}
	
	public static void main ( String [] args ) {
		
	}
}
