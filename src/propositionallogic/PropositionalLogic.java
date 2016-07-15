package propositionallogic;

import dl.syntax.*;

import interfaces.text.*;
import propositionallogic.syntax.*;
import java.util.*;

public class PropositionalLogic {
	
//	public static dLFormula simplify ( dLFormula formula ) {
//		if ( !formula.isStatic() ) {
//			throw new RuntimeException("PropositionalLogic cannot simplify dynamic formulas.");
//		}
//		
//		if ( formula.isPropositionalPrimitive() ) {
//			return formula;
//		}
//		// We will replace propositional primitive dLFormulas with propositional variables
//		// This hash map stores the mapping, so we can reconstruct the original formula later
//		HashMap<Proposition,dLFormula> propositionalMapping = new HashMap<>();
//		int propositionCounter = 0;
//		
//		
//		
//		
//	}
	
	public static Proposition simplify ( Proposition proposition ) {
		
		Proposition returnProposition = null;
		if ( proposition instanceof NotProposition ) {
			Proposition negatedProposition = ((NotProposition)proposition).getProposition();
			//TextOutput.setDebug(true);
			//TextOutput.debug("Negated proposition is: " + negatedProposition );
			//TextOutput.debug("Simplified negated proposition is: " + simplify( negatedProposition) );
			returnProposition = simplifyBase( new NotProposition( simplify( negatedProposition ) ));
			
		} else if ( proposition instanceof BinaryProposition ) {
			try {
				Proposition lhs = ((BinaryProposition)proposition).getLHS();
				Proposition rhs = ((BinaryProposition)proposition).getRHS();
				Proposition simplifiedLHS = simplify( lhs );
				Proposition simplifiedRHS = simplify( rhs );
				Proposition newProposition = proposition.getClass().getConstructor(Proposition.class, Proposition.class).newInstance( simplifiedLHS, simplifiedRHS );

				returnProposition = simplifyBase( newProposition );
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		} else {
			returnProposition = proposition;
		}
		return returnProposition;
	}

	protected static Proposition simplifyBase( Proposition proposition ) {
		if ( (proposition instanceof NotProposition) && (((NotProposition)proposition).getProposition() instanceof TrueProposition) ) {
			// Negation of "true"
			return new FalseProposition();
		} else if ( (proposition instanceof NotProposition) && (((NotProposition)proposition).getProposition() instanceof FalseProposition) ) {
			// Negation of "false"
			return new TrueProposition();
		} else if ( (proposition instanceof NotProposition) && (((NotProposition)proposition).getProposition() instanceof NotProposition) ) {
			// Double negation
			return ((NotProposition)((NotProposition)proposition).getProposition()).getProposition();
		} else if ( (proposition instanceof AndProposition) && ( 
					(((AndProposition)proposition).getLHS() instanceof FalseProposition)
					|| (((AndProposition)proposition).getRHS() instanceof FalseProposition)) ) {
			// Conjunction with false
				return new FalseProposition();
		} else if ( (proposition instanceof AndProposition) && (((AndProposition)proposition).getLHS() instanceof TrueProposition) ) {
			// Conjunction with true on the left
			return ((AndProposition)proposition).getRHS();
		} else if ( (proposition instanceof AndProposition) && (((AndProposition)proposition).getRHS() instanceof TrueProposition) ) {
			// Conjunction with true on the right
			return ((AndProposition)proposition).getLHS();
		} else if ( (proposition instanceof OrProposition) && ( 
				(((OrProposition)proposition).getLHS() instanceof TrueProposition)
				|| (((OrProposition)proposition).getRHS() instanceof TrueProposition)) ) {
			// Disjunction with true
			return new TrueProposition();
		} else if ( (proposition instanceof OrProposition) && (((OrProposition)proposition).getLHS() instanceof FalseProposition) ) {
			// Disjunction with false on the left
			return ((OrProposition)proposition).getRHS();
		} else if ( (proposition instanceof OrProposition) && (((OrProposition)proposition).getRHS() instanceof FalseProposition) ) {
			// Disjunction with false on the right
			return ((OrProposition)proposition).getLHS();
		} else if ( (proposition instanceof ImpliesProposition) && (
				(((ImpliesProposition)proposition).getLHS() instanceof FalseProposition )
				|| (((ImpliesProposition)proposition).getRHS() instanceof TrueProposition )
				)) {
			return new TrueProposition();
		} else if ( (proposition instanceof ImpliesProposition) && (((ImpliesProposition)proposition).getLHS() instanceof TrueProposition )) {
			return ((ImpliesProposition)proposition).getRHS();
		} else if ( (proposition instanceof ImpliesProposition) && (((ImpliesProposition)proposition).getRHS() instanceof FalseProposition )) {
			return new NotProposition(((ImpliesProposition)proposition).getLHS());
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getRHS() instanceof TrueProposition) ) {
			return ((IffProposition)proposition).getLHS();
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getLHS() instanceof TrueProposition) ) {
			return ((IffProposition)proposition).getRHS();
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getLHS() instanceof FalseProposition) 
				&& (((IffProposition)proposition).getRHS() instanceof FalseProposition) ) {
			return new TrueProposition();
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getRHS() instanceof FalseProposition) ) {
			return new NotProposition( ((IffProposition)proposition).getLHS() );
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getLHS() instanceof FalseProposition) ) {
			return new NotProposition( ((IffProposition)proposition).getRHS() );
		} else {
			return proposition;
		}
	}
	

}
