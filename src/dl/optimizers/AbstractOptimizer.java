package dl.optimizers;

import java.io.File;
import java.util.*;
import dl.syntax.*;

import dl.filebasedinterface.*;

public abstract class AbstractOptimizer extends FileBasedInterface {
	
	// An optimizer implementation needs to provide the following 6 functions; 
	// only the last two require effort.
	// 1/6 Some kind of name, for creating the name of the workspace:
	protected abstract String getToolName();
	// 2/6 The command needed to run the script (i.e., the program you would call from the commandline)
	protected abstract String getCommand();
	// 3/6 The file extension of the input files:
	protected abstract String getFileExtension();
	// 4/6 Takes an input string without newlines and returns it as a comment
	protected abstract String commentLine( String commentLine );
	// 5/6 Generates a script as a string:
	protected abstract String generateScript( OptimizationProblem problem );
	// 6/6 Parses the output produced by the string:
	protected abstract OptimizationResult parseOutput( String output);
	
	/* Shared code across different types of optimizers */
	public OptimizationResult optimize ( OptimizationProblem problem ) {
		String scriptString = generateScript( problem );
		
		/* These two functions inherited from FileBasedInterface */
		/**/File scriptFile = writeToFile( scriptString );
		/**/String output = runScript( scriptFile );
		/***/
		
		OptimizationResult result = parseOutput( output );
		
		return result;
	}
	
	protected String problemDescriptionComment( OptimizationProblem problem ) {
		// Create a comment that documents the OptimizationProblem we are solving
		String description = commentLine("Cost: " + problem.getObjective().toString()) + "\n";
		description += commentLine("Number of constraints: " + problem.getConstraints().size()) + "\n";
		for ( int k = 0; k < problem.getConstraints().size(); k++ ) {
			description += commentLine("Constraint " + k + ": " + problem.getConstraint( k )) + "\n";
		}
		return description;
	}
	
//	protected Set<RealVariable> getVariables( OptimizationProblem problem ) {
//		Set<RealVariable> variables = new HashSet<>();
//		variables.addAll( problem.getObjective().getFreeVariables() );
//		for ( dLFormula constraint : problem.getConstraints() ) {
//			variables.addAll( constraint.getFreeVariables() );
//		}
//		return variables;
//	}


}
