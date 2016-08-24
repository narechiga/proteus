package firstOrderLogic.syntax;

import propositionallogic.syntax.*;

public class AndFormula extends AndProposition implements FirstOrderFormula { //, Proposition {

	public AndFormula( FirstOrderFormula lhs, FirstOrderFormula rhs ) {
		super( lhs, rhs );
	}
	
}

