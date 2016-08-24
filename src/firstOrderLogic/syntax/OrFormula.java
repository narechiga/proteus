package firstOrderLogic.syntax;

import propositionallogic.syntax.OrProposition;
import propositionallogic.syntax.Proposition;

public class OrFormula extends OrProposition implements FirstOrderFormula { //, Proposition {

	public OrFormula( FirstOrderFormula lhs, FirstOrderFormula rhs ) {
		super( lhs, rhs );
	}
}
