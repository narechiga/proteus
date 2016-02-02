/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package matlab.syntax;

import dl.syntax.Term;
import matlab.parser.AbstractMatlabParser;

public class AssignmentStatement extends Statement {
	Term rhs, lhs;

	
	public AssignmentStatement(Term lhs, Term rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
//	public Term getAssignmentStatement(){
//		return rhs;
//	}
//	
//	public String toStringRHS(){
//		return rhs.toKeYmaeraString();
//		
//	}
//	
//	public String toStringLHS(){
//		return lhs.toKeYmaeraString();
//		
//	}
	
	//since we know we are in assignment, operator will return '='
	public String getOperator(){
		return "=";
	}
	
	public String toMathematicaString(){
		return this.toMathematicaString();
	}
	
//	public String toRealString(){
//		return rhs.todRealString();
//	}
	
	public String toString(){
		return lhs.toMathematicaString() + " " + getOperator() + " " + rhs.toMathematicaString() + ";";
	}
}
