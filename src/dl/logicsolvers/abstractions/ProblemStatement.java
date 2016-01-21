/**
 * @author Nikos Arechiga
 * @author Anuradha Vakil
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package dl.logicsolvers.abstractions;

//import proteus.dl.semantics.*;
import java.util.*;

import dl.syntax.*;

public abstract class ProblemStatement {
	public List<RealVariable> stateVariables;
	public dLFormula initialSet;
	public dLFormula safeSet;
	public List<RealVariable> eiParameters;
	public dLFormula eiParameterSet;
	public dLFormula envelope;
	public dLFormula invariant;
	public dLFormula control;
}
