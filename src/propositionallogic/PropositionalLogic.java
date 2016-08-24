package propositionallogic;

import dl.syntax.*;

import interfaces.text.*;
import propositionallogic.parser.PropositionalLogicLexer;
import propositionallogic.parser.PropositionalLogicParser;
import propositionallogic.syntax.*;

import java.io.StringReader;
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
	
	public static Proposition parseProposition( String string ) {
		StringReader thisReader = new StringReader( string );
		PropositionalLogicLexer lexer = new PropositionalLogicLexer( thisReader );
		PropositionalLogicParser parser = new PropositionalLogicParser( lexer );

		try {
			parser.parse();
			Proposition proposition = parser.parsedProposition;
			return proposition;
		} catch ( Exception e ) {
			throw new PropositionFormatException("Could not parse: " + string);
		}
	}
	
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
		if ( (proposition instanceof NotProposition) && (((NotProposition)proposition).getProposition() instanceof TrueFormula) ) {
			// Negation of "true"
			return new FalseProposition();
		} else if ( (proposition instanceof NotProposition) && (((NotProposition)proposition).getProposition() instanceof FalseFormula) ) {
			// Negation of "false"
			return new TrueProposition();
		} else if ( (proposition instanceof NotProposition) && (((NotProposition)proposition).getProposition() instanceof NotProposition) ) {
			// Double negation
			return ((NotProposition)((NotProposition)proposition).getProposition()).getProposition();
		} else if ( (proposition instanceof AndProposition) && ( 
					(((AndProposition)proposition).getLHS() instanceof FalseFormula)
					|| (((AndProposition)proposition).getRHS() instanceof FalseFormula)) ) {
			// Conjunction with false
				return new FalseProposition();
		} else if ( (proposition instanceof AndProposition) && (((AndProposition)proposition).getLHS() instanceof TrueFormula) ) {
			// Conjunction with true on the left
			return ((AndProposition)proposition).getRHS();
		} else if ( (proposition instanceof AndProposition) && (((AndProposition)proposition).getRHS() instanceof TrueFormula) ) {
			// Conjunction with true on the right
			return ((AndProposition)proposition).getLHS();
		} else if ( (proposition instanceof OrProposition) && ( 
				(((OrProposition)proposition).getLHS() instanceof TrueFormula)
				|| (((OrProposition)proposition).getRHS() instanceof TrueFormula)) ) {
			// Disjunction with true
			return new TrueProposition();
		} else if ( (proposition instanceof OrProposition) && (((OrProposition)proposition).getLHS() instanceof FalseFormula) ) {
			// Disjunction with false on the left
			return ((OrProposition)proposition).getRHS();
		} else if ( (proposition instanceof OrProposition) && (((OrProposition)proposition).getRHS() instanceof FalseFormula) ) {
			// Disjunction with false on the right
			return ((OrProposition)proposition).getLHS();
		} else if ( (proposition instanceof ImpliesProposition) && (
				(((ImpliesProposition)proposition).getLHS() instanceof FalseFormula )
				|| (((ImpliesProposition)proposition).getRHS() instanceof TrueFormula )
				)) {
			return new TrueProposition();
		} else if ( (proposition instanceof ImpliesProposition) && (((ImpliesProposition)proposition).getLHS() instanceof TrueFormula )) {
			return ((ImpliesProposition)proposition).getRHS();
		} else if ( (proposition instanceof ImpliesProposition) && (((ImpliesProposition)proposition).getRHS() instanceof FalseFormula )) {
			return new NotProposition(((ImpliesProposition)proposition).getLHS());
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getRHS() instanceof TrueFormula) ) {
			return ((IffProposition)proposition).getLHS();
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getLHS() instanceof TrueFormula) ) {
			return ((IffProposition)proposition).getRHS();
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getLHS() instanceof FalseFormula) 
				&& (((IffProposition)proposition).getRHS() instanceof FalseFormula) ) {
			return new TrueProposition();
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getRHS() instanceof FalseFormula) ) {
			return new NotProposition( ((IffProposition)proposition).getLHS() );
		} else if ( (proposition instanceof IffProposition) && (((IffProposition)proposition).getLHS() instanceof FalseFormula) ) {
			return new NotProposition( ((IffProposition)proposition).getRHS() );
		} else {
			return proposition;
		}
	}
	

}
