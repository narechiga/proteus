package matlab.semantics;

import matlab.syntax.*;
import dl.semantics.*;
import dl.syntax.*;
import java.util.*;

public class MatlabExecutionEngine {
	
	public static Valuation execute ( MatlabProgram program, Valuation initialState ) {	
		if ( program instanceof NoOp ) {
			return initialState;
		} else if ( program instanceof MatlabAssignment ) {
			return executeAssignment( (MatlabAssignment)program, initialState );
		} else if ( program instanceof MatlabConditional ) {
			return executeConditional( (MatlabConditional)program, initialState );
		} else if ( program instanceof MatlabSequence ) {
			return executeSequence( (MatlabSequence) program, initialState );
		} else {
			throw new RuntimeException("Unsupported Matlab program for execution: " + program.getClass() );
		}
	}
	
	protected static Valuation executeAssignment( MatlabAssignment assignment, Valuation initialState ) {
		 RealVariable assignedVariable = assignment.getLHS();
		 Term assignmentTerm = assignment.getRHS();
		 
		 Interpretation interpretation = new NativeInterpretation();
		 Real assignmentReal = (Real)(interpretation.evaluateTerm( assignmentTerm, initialState ));
		 
		 Valuation finalState = initialState.shallowClone();
		 finalState.put( assignedVariable, assignmentReal );
		 return finalState;	 
	}
	
	protected static Valuation executeConditional( MatlabConditional conditional, Valuation initialState ) {
		 List<dLFormula> conditions = conditional.getConditions();
		 List<MatlabProgram> programs = conditional.getPrograms();
		 
		 Iterator<MatlabProgram> programIterator = programs.iterator();
		 Interpretation interpretation = new NativeInterpretation();
		 for ( dLFormula condition : conditions ) {
			 if ( interpretation.evaluateFormula(condition, initialState ) ) {
				 return execute( programIterator.next(), initialState );
			 }
		 }
		 throw new RuntimeException("Could not run MatlabConditional on input state; state was: " + initialState.toString() + " program was: " + conditional.toString() );
	}
	
	protected static Valuation executeSequence( MatlabSequence sequence, Valuation initialState ) {
		 MatlabProgram first = sequence.getFirstProgram();
		 MatlabProgram second = sequence.getSecondProgram();
		 
		 Valuation intermediateState = execute( first, initialState );
		 Valuation finalState = execute( second, intermediateState );
		 
		 return finalState;
	}
	

}
