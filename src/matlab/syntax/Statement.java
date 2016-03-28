/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package matlab.syntax;

import java.util.ArrayList;
import java.util.List;

import matlab.parser.AbstractMatlabParser;

public class Statement {

	public Statement(){}

	public MatlabProgram toMatlabProgram() {
		return new MatlabProgram( this );
	}

}
