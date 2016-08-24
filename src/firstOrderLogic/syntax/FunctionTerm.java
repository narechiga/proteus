package firstOrderLogic.syntax;

import java.util.*;

public class FunctionTerm {
	FirstOrderFunction function;
	List<FirstOrderTerm> subTerms;
	
	public FunctionTerm( FirstOrderFunction function, List<FirstOrderTerm> subTerms ) {
		this.function = function;
		this.subTerms = subTerms;
	}

}
