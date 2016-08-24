package firstOrderLogic.syntax;

public class ExistsFormula implements FirstOrderFormula {

	FirstOrderVariable variable;
	FirstOrderFormula formula;
	
	public ExistsFormula( FirstOrderVariable variable, FirstOrderFormula formula ) {
		this.variable = variable;
		this.formula = formula;
	}
	
	public String toString() {
		return "\\exists " + variable.toString() + " ; " + formula.toString();
	}
	
}
