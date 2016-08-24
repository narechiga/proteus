package firstOrderLogic.syntax;

import java.util.*;

public class PredicateFormula implements FirstOrderFormula {

	FirstOrderPredicate predicate;
	List<FirstOrderTerm> subTerms;
	
	public PredicateFormula( FirstOrderPredicate predicate, List<FirstOrderTerm> subTerms ) {
		this.predicate = predicate;
		this.subTerms = subTerms;
	}
	
}
