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
	Term RHSterm, LHSterm;

	
	public AssignmentStatement(Term term1, Term term2) {
		
		LHSterm = term1;
		term1 = term2;
		RHSterm = term1;
		
	}
	
//	public Term getAssignmentStatement(){
//		return RHSterm;
//	}
//	
//	public String toStringRHS(){
//		return RHSterm.toKeYmaeraString();
//		
//	}
//	
//	public String toStringLHS(){
//		return LHSterm.toKeYmaeraString();
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
//		return RHSterm.todRealString();
//	}
	
	public String toString(){
		return LHSterm.toMathematicaString() + " " + getOperator() + " " + RHSterm.toMathematicaString();
	}
}
