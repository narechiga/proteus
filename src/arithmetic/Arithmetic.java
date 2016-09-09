package arithmetic;

import dl.syntax.*;
import java.util.*;

public class Arithmetic {
	
	public Term simplify( Term term ) {
		Operator operator = term.getOperator();
		List<Term> subTerms = term.getSubTerms();
		
		ArrayList<Term> simplifiedSubTerms = new ArrayList<>();
		for ( Term subTerm : subTerms ) {
			simplifiedSubTerms.add( simplify(subTerm) );
		}
		Term simplifiedTerm = simplifyBase( new Term(operator, simplifiedSubTerms ));
		return simplifiedTerm;
	}

	public Term simplifyBase( Term term ) {
		if ( term instanceof MultiplicationTerm ) {
			MultiplicationTerm product = (MultiplicationTerm)term;
			if ( product.getLHS().equals( new Real(1) ) ) {
				return product.getRHS();
			} else if (product.getRHS().equals( new Real(1) ) ) {
				return product.getLHS();
			} else if ( (product.getLHS().equals( new Real(0) )) || (product.getLHS().equals( new Real(0) )) ) {
				return new Real(0);
			}
		} else if ( term instanceof AdditionTerm ) {
			AdditionTerm sum = (AdditionTerm)term;
			if ( sum.getLHS().equals( new Real(0))) {
				return sum.getRHS();
			} else if ( sum.getRHS().equals( new Real(0)) ) {
				return sum.getLHS();
			}
		}
		return term;
	}
	
}
