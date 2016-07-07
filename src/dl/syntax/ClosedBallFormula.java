/**
 * @author Nikos Arechiga
 * @author Anuradha Vakil
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package dl.syntax;

import dl.semantics.*;

import java.util.*;

public class ClosedBallFormula extends BallFormula {

	Valuation center;
	Real radius;

	public ClosedBallFormula( ArrayList<RealVariable> variables, Valuation center, Real radius ) {
		this.center = center;
		this.radius = radius;
		this.operator = new Operator("<=");

		// Generate an open ball
		Iterator<RealVariable> varIterator = variables.iterator();
		RealVariable thisVariable;
		ArrayList<Term> normTerms = new ArrayList<Term>();
		while ( varIterator.hasNext() ) {
			thisVariable = varIterator.next();
			normTerms.add( new SubtractionTerm( thisVariable, center.get( thisVariable ) ) );
		}

		spawnArguments();
		addArgument( new NormTerm( normTerms, 2 ) );
		addArgument( radius );

		if ( cachingActive() ) {
			try {
			  string = generateString();
			  prefixString = generateString();
			} catch ( Exception e ) {
				// we don't care
			}
		}
	}


	// Just inherit the negation from ComparisonFormula (?)
	//public ComparisonFormula negate() {
	//	return new ComparisonFormula( ">", this.getLHS(), this.getRHS() );
	//}


	//public ClosedBallFormula( ArrayList<RealVariable> variables, Valuation center, Real radius ) {
	//}



	//public ClosedBallFormula( ArrayList<RealVariable>, Real radius, Real pDegree ) {
	//}

	//public ClosedBallFormula( ArrayList<RealVariable>, Real radius, int pDegree ) {
	//}
	//
	//public ClosedBallFormula( ComparisonFormula ballFormula ) throws ClosedBall2FormulaFormatException {
	//	// Try to parse an open ball, and throw an exception if it doesn't work out

	//}

}

