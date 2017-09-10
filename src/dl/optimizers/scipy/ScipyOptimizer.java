package dl.optimizers.scipy;

import dl.optimizers.*;
import dl.syntax.*;
import dl.semantics.*;
import interfaces.text.*;

import java.io.*;
import java.util.*;

public class ScipyOptimizer extends AbstractOptimizer {
	
	@Override
	public String getToolName() {
		return "Scipy_Optimizer";
	}
	
	@Override
	public String getCommand() {
		return "python3";
	}
	
	@Override
	public String getFileExtension() {
		return "py";
	}
	
	@Override
	public String commentLine( String line ) {
		return "# " + line;
	}
		
	protected String generateScript( OptimizationProblem problem ) {
		String script = "";
		script += timeStampComment() + "\n";
		script += problemDescriptionComment( problem ) + "\n";
		
		Replacement variableAliases = generateVariableAliases( problem.getVariables() );
		script += comment("Variable aliases are " + variableAliases.toString()) + "\n\n";
		
		script += "import scipy.optimize\n\n";
		script += objectiveDeclaration( problem.getObjective(), variableAliases );
		script += constraintDeclaration( problem.getConstraints(), variableAliases );
		
		script += problemStatement( problem );
		script += formatSolution( problem );
		
		return script;
	}
	
	/* Helper functions for generateScript */
	protected String objectiveDeclaration( Term objective, Replacement variableAliases ) {
		Term aliasedObjective = objective.replace( variableAliases );
		return "def objective(X):\n\treturn " + pythonizeString(aliasedObjective.toString()) + "\n\n";
	}
	
	protected String constraintDeclaration( List<ComparisonFormula> list, Replacement variableAliases ) {
		String declarations = "";
		String constraintsObject = "cons = (";
		int constraintCount = 0;
		for ( dLFormula constraint : list ) {
			ComparisonFormula aliasedConstraint = (ComparisonFormula)(constraint.replace(variableAliases));
			declarations += "def c" + constraintCount + "(X):\n";
			declarations += "\treturn " + pythonizeString(aliasedConstraint.getLHS().toString()) + "\n\n";
			
			if ( constraint.getOperator().equals(new Operator("="))
					|| constraint.getOperator().equals(new Operator("=="))) {
				constraintsObject += "{'type': 'eq', 'fun': c" + constraintCount + "},\n"; //thankfully python doesn't care if there is an extra comma on the last element
			} else {
				constraintsObject += "{'type': 'ineq', 'fun': c" + constraintCount + "},\n"; //thankfully python doesn't care if there is an extra comma on the last element
			}
			
			constraintCount++;
		}
		constraintsObject += ")\n\n";
		
		return declarations + constraintsObject;
	}
	
	protected String problemStatement( OptimizationProblem problem ) {
		String problemStatement = "";
				
		problemStatement += "x0 = scipy.zeros((" + problem.getVariables().size() + ",1))\n";
		problemStatement += "solution = scipy.optimize.minimize( objective, x0, method='SLSQP', constraints=cons )\n";
		
		return problemStatement;
	}
	
	protected String formatSolution( OptimizationProblem problem ) {
		String formatString = "";
		formatString += "xopt = solution.x\n";
		formatString += "print(\"{ ";

		List<RealVariable> variables = problem.getVariables();
		for ( int k = 0; k < variables.size(); k++ ) {
			if ( k == 0 ) {
				formatString += variables.get(k).toString() + "->\"" + " + str(xopt[" + k + "])";
			} else {
				formatString += " + \", " + variables.get(k).toString() + "->\"" + "+str(xopt[" + k +"])";
			}
		}
		formatString += "+ \"}\")\n";
		
		return formatString;
	}
	
	protected OptimizationResult parseOutput( String output ) {
		Valuation optimalValue = Valuation.parse( output );
		OptimizationResult result = new OptimizationResult( optimalValue );
		return result;
	}
	
	protected String pythonizeString( String string ) {
		// Takes care of idiosyncratic aspects of python, such as
		// the fact that exponentiation is denoted by **
		return string.replace("^", "**");
	}
	
	protected Replacement generateVariableAliases( List<RealVariable> variables ) {
		Replacement variableAliases = new Replacement();
		for ( int k = 0; k < variables.size(); k++ ) {
			variableAliases.put( variables.get(k), new RealVariable("X["+k+"]"));
		}
		return variableAliases;
	}


	public static void main(String[] args) {
		boolean allTestsPassed = true;
		
		allTestsPassed &= test1();
		
		if ( allTestsPassed ) {
			TextOutput.info("All tests passed.");
		} else {
			TextOutput.error("Some tests failed.");
		}
	}
	
	public static boolean test1() {
		boolean success = true;
		
		RealVariable x1 = new RealVariable("x1");
		RealVariable x2 = new RealVariable("x2");
		Term objective = Term.parse("x1^2 + x2^2");
		dLFormula c1 = dLFormula.parse("x1 > 3");
		dLFormula c2 = dLFormula.parse("x2 > 2");
		List<dLFormula> constraints = new ArrayList<>();
		constraints.add(c1); constraints.add(c2);
		
		OptimizationProblem p = new OptimizationProblem( objective, constraints );
		ScipyOptimizer s = new ScipyOptimizer();
		
		//TextOutput.say( s.optimize(p).getOptimum() );
		Valuation optimum = s.optimize(p).getOptimum();
		success &= optimum.get(x1).equals(new Real("3.0"));
		success &= optimum.get(x2).equals(new Real("2.0"));
			
		return success;
	}

}
