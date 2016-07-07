/**
 * @author Nikos Arechiga
 * @author Anuradha Vakil
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package dl.syntax;

import dl.semantics.*;
import java.util.*;


public class OrFormula extends dLFormula {

// Constructors and field getters
	public OrFormula ( dLFormula leftArgument, dLFormula rightArgument ) {
		operator = new Operator("or", 2, true); //

		arguments = new ArrayList<dLStructure>();
		arguments.add( leftArgument );
		arguments.add( rightArgument );

		if ( cachingActive() ) {
			try {
			  string = generateString();
			  prefixString = generateString();
			} catch ( Exception e ) {
				// we don't care
			}
		}
	}

	public dLFormula getLHS() {
		return ((dLFormula)(arguments.get(0))).clone();
	}

	public dLFormula getRHS() {
		return ((dLFormula)(arguments.get(1))).clone();
	}

// Substitution method
	public OrFormula substituteConcreteValuation( Valuation substitution ) {
		return new OrFormula( getLHS().substituteConcreteValuation( substitution ), 
					getRHS().substituteConcreteValuation( substitution ) );
	}

	public OrFormula replace( Replacement replacement ) {
		return new OrFormula( getLHS().replace( replacement ), 
					getRHS().replace( replacement ) );
	}

// Clone method
	public OrFormula clone() {
		return new OrFormula( getLHS().clone(), getRHS().clone() );
	}

// String methods
	public String generateString () {
		return "( " + getLHS().toString() + " | " + getRHS().toString() + " )";
	}

	//public String toManticoreString () {
	//	return "( " + getLHS().toManticoreString() + " | " + getRHS().toManticoreString() + " )";
	//}

	//public String toMathematicaString () {
	//	return "( " + getLHS().toMathematicaString() + " || " + getRHS().toMathematicaString() + " )";
	//}

	public String toPrefixString() {
		return "(or " + getLHS().toPrefixString() + " " + getRHS().toPrefixString() + " )";
	}

// Assorted convenience functions
	public boolean isFirstOrder() {
		return (getLHS().isFirstOrder() && getRHS().isFirstOrder() );
	}

	public boolean isModal() {
		return (getLHS().isModal() || getRHS().isModal() );
	}

        public boolean isStatic() {
                return (getLHS().isStatic() && getRHS().isStatic());
        }

        public boolean isQuantifierFree() {
                return (getLHS().isQuantifierFree() && getRHS().isQuantifierFree());
        }

// Logic
	public AndFormula negate() {
		return new AndFormula( getLHS().negate(), getRHS().negate() );
	}

	public Set<RealVariable> getBoundVariables() {
		HashSet<RealVariable> boundVariables = new HashSet<RealVariable>();
		boundVariables.addAll( getLHS().getBoundVariables() );
		boundVariables.addAll( getRHS().getBoundVariables() );
		return boundVariables;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables = new HashSet<RealVariable>();
		freeVariables.addAll( getLHS().getFreeVariables() );
		freeVariables.addAll( getRHS().getFreeVariables() );
		return freeVariables;
	}


	public Set<RealVariable> getDynamicVariables() {
		HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();
		dynamicVariables.addAll( getLHS().getDynamicVariables() );
		dynamicVariables.addAll( getRHS().getDynamicVariables() );
		return dynamicVariables;
	}
	//public dLFormula simplifyOrFalse() {
	//	if ( getLHS() instanceof FalseFormula ) {
	//		if ( getRHS() instanceof OrFormula ) {
	//			return ((OrFormula)getRHS()).simplifyOrFalse();
	//		} else {
	//			return getRHS().clone();
	//		}
	//	else if ( getRHS() instanceof FalseFormula ) {
	//		if ( getLHS() instanceof OrFormula ) {
	//			return ((OrFormula)getLHS()).simplifyOrFalse();
	//		} else {
	//			return getLHS().clone();
	//		}
	//	else {


	//	}

}
