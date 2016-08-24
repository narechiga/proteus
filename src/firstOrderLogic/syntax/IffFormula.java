package firstOrderLogic.syntax;

import propositionallogic.syntax.*;

public class IffFormula extends IffProposition implements FirstOrderFormula {

	public IffFormula( FirstOrderFormula lhs, FirstOrderFormula rhs ) {
		super( lhs, rhs );
	}
	
}
