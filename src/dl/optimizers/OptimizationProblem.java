package dl.optimizers;

import dl.syntax.*;
import dl.parser.PrettyPrinter;
import interfaces.text.TextOutput;

import java.util.*;

public class OptimizationProblem {

	protected Term objective; // The quantity that we want to minimize
	protected List<ComparisonFormula> constraints;
	protected List<RealVariable> variables; // stored so we can always return them in the same order
	// TODO(nikos) supprot this: //protected HashMap<String,String> options; // Used to send special options to the optimizer
	
	public OptimizationProblem( Term cost, List<dLFormula> constraints ) {
		this.objective = cost;
		this.constraints = makeConstraintsPrimitive(constraints);
		this.variables = extractVariables();
	}
	
// Can be hard to keep track of the required pre-processing for all the cases, so disabling these for now.	
//	OptimizationProblem() {
//	this.objective = new Real(0);
//	this.constraints = new ArrayList<>();
//	variables = extractVariables();
//}
//	OptimizationProblem( Term cost, dLFormula constraint ) {
//		this.objective = cost;
//		this.constraints = new ArrayList<>();
//		constraints.add( constraint );
//		variables = extractVariables();
//	}
//	
//	OptimizationProblem( Term cost ) {
//		this.objective = cost;
//		this.constraints = new ArrayList<>();
//		variables = extractVariables();
//	}
//	
//	public void setObjective( Term cost ) {
//		this.objective = cost;
//	}
//	
//	public void setConstraints( List <dLFormula> constraints ) {
//		this.constraints = constraints;
//	}
//	
//	public void addConstraint( dLFormula constraint ) {
//		this.constraints.add( constraint );
//	}
	
	public Term getObjective() {
		return objective;
	}
	
	public List<ComparisonFormula> getConstraints() {
		return constraints;
	}
	
	public dLFormula getConstraint( int index ) {
		return constraints.get(index);
	}
	
	public List<RealVariable> getVariables() {
		return variables;
	}
	
	protected List<ComparisonFormula> makeConstraintsPrimitive( List<dLFormula> constraints ) {
		
		List<ComparisonFormula> primitiveConstraints = new ArrayList<>();
		for ( dLFormula constraint : constraints ) {
			if ( constraint instanceof ComparisonFormula ) {
				primitiveConstraints.add( makePrimitive((ComparisonFormula)constraint) );
				
			} else if ( constraint instanceof AndFormula ) {
				List<dLFormula> conjuncts = ((AndFormula)constraint).splitOnAnds();
				primitiveConstraints.addAll( makeConstraintsPrimitive(conjuncts));
				
			} else {
				TextOutput.error("Only conjunctions of constraints are currently supported.");
				TextOutput.error("in: " + PrettyPrinter.print( constraint ));
				throw new RuntimeException("Unsupported.");
				
			}
		}
		return primitiveConstraints;
		
	}
	
	protected List<RealVariable> extractVariables() {
		Set<RealVariable> variables = new HashSet<>();
		for ( dLFormula constraint : getConstraints() ) {
			variables.addAll( constraint.getFreeVariables() );
		}
		List<RealVariable> variableList = new ArrayList<>();
		variableList.addAll( variables );
		return variableList;
	}
	
	protected ComparisonFormula makePrimitive( ComparisonFormula inequality ) {
		return makeRHSZero(makeGEQ(inequality));
	}
	
	protected ComparisonFormula makeRHSZero( ComparisonFormula inequality ) {
		Real zero = new Real(0);
		if ( inequality.getRHS().equals( zero ) ) {
			return inequality;
		} else {
			return new ComparisonFormula( inequality.getOperator(),
											new SubtractionTerm( inequality.getLHS(), inequality.getRHS() ),
											zero );
		}
	}
	
	protected ComparisonFormula makeGEQ( ComparisonFormula inequality ) {
		if ( inequality.getOperator().equals(new Operator(">="))) {
			return inequality;
		} else if ( inequality.getOperator().equals( new Operator("=="))
				|| inequality.getOperator().equals( new Operator("=")) ) {
			return inequality;
			
		} else if ( inequality.getOperator().equals(new Operator(">"))) {
			TextOutput.warning("Strict inequalities are currently converted to non-strict");
			TextOutput.warning("in: " + PrettyPrinter.print(inequality) );
			return new ComparisonFormula(">=", inequality.getLHS(), inequality.getRHS() );
			
		} else if ( inequality.getOperator().equals(new Operator("<=")) ) {
			return new ComparisonFormula(">=", inequality.getRHS(), inequality.getLHS() );
			
		} else if ( inequality.getOperator().equals(new Operator("<")) ) {
			TextOutput.warning("Strict inequalities are currently converted to non-strict");
			TextOutput.warning("in: " + PrettyPrinter.print( inequality ));
			return new ComparisonFormula(">=", inequality.getRHS(), inequality.getLHS() );
			
		} else {
			TextOutput.error("Unsupported inequality operator");
			TextOutput.error("in: " + PrettyPrinter.print(inequality));
			throw new RuntimeException("Unsupported.");
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
