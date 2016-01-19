/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package dl.syntax;

import dl.semantics.*;

public class UnknownInequalityException extends RuntimeException {
	// Extends RuntimeException because if you wrote something with a bad
	// operator, we really should just crash

	public UnknownInequalityException( String message ) {
		super( message );
	}
}
