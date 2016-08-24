package firstOrderLogic.syntax;

public class ForAllFormula {

	FirstOrderVariable variable;
	FirstOrderFormula formula;
	
	public ForAllFormula( FirstOrderVariable variable, FirstOrderFormula formula ) {
		this.variable = variable;
		this.formula = formula;
	}
	
	public String toString() {
		return "\\forall " + variable.toString() + " ; " + formula.toString();
	}
	
}
