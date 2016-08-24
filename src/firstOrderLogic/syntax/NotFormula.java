package firstOrderLogic.syntax;

import propositionallogic.syntax.NotProposition;

public class NotFormula extends NotProposition implements FirstOrderFormula {

	public NotFormula( FirstOrderFormula negatedFormula ) {
		super( negatedFormula );
	}
}
