/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package dl.syntax;

import java.util.*;

public class FunctionApplicationTerm extends Term {

	public FunctionApplicationTerm( String operatorName, Term subTerm ) {
		this.operator = new Operator( operatorName );
		spawnArguments();
		addSubTerm(subTerm);
	}
	
	public FunctionApplicationTerm ( Operator operator, ArrayList<Term> subTerms ) {
		this.operator = operator;
		spawnArguments();
		addSubTerms( subTerms );
	}

	public Term clone() {
		ArrayList<Term> newSubTerms = new ArrayList<>();

		Iterator<Term> subTermIterator = getSubTerms().iterator();
		while( subTermIterator.hasNext() ) {
			newSubTerms.add( subTermIterator.next().clone() );
		}

		return new FunctionApplicationTerm( operator.clone(), newSubTerms );
	}

	public Term distributeMultiplication() {
		return this.clone();
	}

// Arithmetic Analysis
	public boolean isLinearIn( ArrayList<RealVariable> variables ) {
		return false;
	}

	public boolean isAffineIn( ArrayList<RealVariable> variables ) {
		return false;
	}

}
