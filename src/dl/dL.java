package dl;

import dl.syntax.*;



public class dL {
	public static dLFormula simplify( dLFormula formula ) {
		
		//return simplifyBase( formula );
		dLFormula returnFormula = null;
		if ( formula instanceof NotFormula ) {
			dLFormula negatedFormula = ((NotFormula)formula).getFormula();
			//TextOutput.setDebug(true);
			//TextOutput.debug("Negated Formula is: " + negatedFormula );
			//TextOutput.debug("Simplified negated Formula is: " + simplify( negatedFormula) );
			returnFormula = simplifyBase( new NotFormula( simplify( negatedFormula ) ));
			
		} else if ( formula instanceof BinaryFormula ) {
			try {
				dLFormula lhs = ((BinaryFormula)formula).getLHS();
				dLFormula rhs = ((BinaryFormula)formula).getRHS();
				dLFormula simplifiedLHS = simplify( lhs );
				dLFormula simplifiedRHS = simplify( rhs );
				dLFormula newFormula = formula.getClass().getConstructor(dLFormula.class, dLFormula.class).newInstance( simplifiedLHS, simplifiedRHS );

				returnFormula = simplifyBase( newFormula );
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		} else {
			returnFormula = formula;
		}
		return returnFormula;
		
	}
	
	protected static dLFormula simplifyBase( dLFormula formula ) {
		if ( (formula instanceof NotFormula) && (((NotFormula)formula).getFormula() instanceof TrueFormula) ) {
			// Negation of "true"
			return new FalseFormula();
		} else if ( (formula instanceof NotFormula) && (((NotFormula)formula).getFormula() instanceof FalseFormula) ) {
			// Negation of "false"
			return new TrueFormula();
		} else if ( (formula instanceof NotFormula) && (((NotFormula)formula).getFormula() instanceof NotFormula) ) {
			// Double negation
			return ((NotFormula)((NotFormula)formula).getFormula()).getFormula();
		} else if ( (formula instanceof AndFormula) && ( 
					(((AndFormula)formula).getLHS() instanceof FalseFormula)
					|| (((AndFormula)formula).getRHS() instanceof FalseFormula)) ) {
			// Conjunction with false
				return new FalseFormula();
		} else if ( (formula instanceof AndFormula) && (((AndFormula)formula).getLHS() instanceof TrueFormula) ) {
			// Conjunction with true on the left
			return ((AndFormula)formula).getRHS();
		} else if ( (formula instanceof AndFormula) && (((AndFormula)formula).getRHS() instanceof TrueFormula) ) {
			// Conjunction with true on the right
			return ((AndFormula)formula).getLHS();
		} else if ( (formula instanceof OrFormula) && ( 
				(((OrFormula)formula).getLHS() instanceof TrueFormula)
				|| (((OrFormula)formula).getRHS() instanceof TrueFormula)) ) {
			// Disjunction with true
			return new TrueFormula();
		} else if ( (formula instanceof OrFormula) && (((OrFormula)formula).getLHS() instanceof FalseFormula) ) {
			// Disjunction with false on the left
			return ((OrFormula)formula).getRHS();
		} else if ( (formula instanceof OrFormula) && (((OrFormula)formula).getRHS() instanceof FalseFormula) ) {
			// Disjunction with false on the right
			return ((OrFormula)formula).getLHS();
		} else if ( (formula instanceof ImpliesFormula) && (
				(((ImpliesFormula)formula).getLHS() instanceof FalseFormula )
				|| (((ImpliesFormula)formula).getRHS() instanceof TrueFormula )
				)) {
			return new TrueFormula();
		} else if ( (formula instanceof ImpliesFormula) && (((ImpliesFormula)formula).getLHS() instanceof TrueFormula )) {
			return ((ImpliesFormula)formula).getRHS();
		} else if ( (formula instanceof ImpliesFormula) && (((ImpliesFormula)formula).getRHS() instanceof FalseFormula )) {
			return new NotFormula(((ImpliesFormula)formula).getLHS());
		} else if ( (formula instanceof IffFormula) && (((IffFormula)formula).getRHS() instanceof TrueFormula) ) {
			return ((IffFormula)formula).getLHS();
		} else if ( (formula instanceof IffFormula) && (((IffFormula)formula).getLHS() instanceof TrueFormula) ) {
			return ((IffFormula)formula).getRHS();
		} else if ( (formula instanceof IffFormula) && (((IffFormula)formula).getLHS() instanceof FalseFormula) 
				&& (((IffFormula)formula).getRHS() instanceof FalseFormula) ) {
			return new TrueFormula();
		} else if ( (formula instanceof IffFormula) && (((IffFormula)formula).getRHS() instanceof FalseFormula) ) {
			return new NotFormula( ((IffFormula)formula).getLHS() );
		} else if ( (formula instanceof IffFormula) && (((IffFormula)formula).getLHS() instanceof FalseFormula) ) {
			return new NotFormula( ((IffFormula)formula).getRHS() );
		} else {
			return formula;
		}
	}

}
