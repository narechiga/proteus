package firstOrderLogic.syntax;

import propositionallogic.syntax.*;

public class ImpliesFormula extends ImpliesProposition implements FirstOrderFormula {

	public ImpliesFormula( FirstOrderFormula lhs, FirstOrderFormula rhs ) {
		super(lhs, rhs);
	}
}
