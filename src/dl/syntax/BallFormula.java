/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package dl.syntax;

import dl.semantics.*;

public abstract class BallFormula extends ComparisonFormula {

	protected Real radius;
	protected Valuation center;

	public Real getRadius() {
		return radius;
	}

	public Valuation getCenter() {
		return center;
	}


}
