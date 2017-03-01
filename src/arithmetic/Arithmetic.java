package arithmetic;

import dl.syntax.*;
import java.util.*;

public class Arithmetic {
	
	// Lagrange interpolation
	public Term lagrangeInterpolation( ) {
		return null;
	}
	
	// Lightweight simplification functions
	public Term simplify( Term term ) {
		Term lightlySimplified;
		if ( term instanceof MultiplicationTerm ) {
			lightlySimplified = simplifyProduct( (MultiplicationTerm)term );
		} else if ( term instanceof AdditionTerm ) {
			lightlySimplified = simplifySum( (AdditionTerm)term );
		} else if ( term instanceof NegativeTerm ) {
			lightlySimplified = simplifyNegative( (NegativeTerm)term );
		} else {
			lightlySimplified = term;
		}
		return simplifyBase( lightlySimplified );
	}
	protected MultiplicationTerm simplifyProduct( MultiplicationTerm product ) { 
		return new MultiplicationTerm( simplify( product.getLHS() ), simplify( product.getRHS() ) );
	}	
	protected AdditionTerm simplifySum( AdditionTerm sum ) {
		return new AdditionTerm( simplify( sum.getLHS()), simplify(sum.getRHS()));
	}	
	protected NegativeTerm simplifyNegative( NegativeTerm negative ) {
		return new NegativeTerm( simplify(negative.getNegatedTerm() ));
	}
	protected Term simplifyBase( Term term ) {
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
