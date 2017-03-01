package arithmetic;

import dl.syntax.*;
import java.util.*;

public class Arithmetic {
	
	public Term simplify( Term term ) {
		if ( term instanceof MultiplicationTerm ) {
			return simplifyProduct( (MultiplicationTerm)term );
		} else if ( term instanceof AdditionTerm ) {
			return simplifySum( (AdditionTerm)term );
		} else if ( term instanceof NegativeTerm ) {
			return simplifyNegative( (NegativeTerm)term );
		} else {
			return term;
		}
	}

	public MultiplicationTerm simplifyProduct( MultiplicationTerm product ) { 
		return new MultiplicationTerm( simplifyBase( product.getLHS() ), simplifyBase( product.getRHS() ) );
	}	
	public AdditionTerm simplifySum( AdditionTerm sum ) {
		return new AdditionTerm( simplifyBase( sum.getLHS()), simplifyBase(sum.getRHS()));
	}	
	public NegativeTerm simplifyNegative( NegativeTerm negative ) {
		return new NegativeTerm( simplifyBase(negative.getNegatedTerm() ));
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
