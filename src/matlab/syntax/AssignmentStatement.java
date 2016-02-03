/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package matlab.syntax;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dl.syntax.Real;
import dl.syntax.RealVariable;
import dl.syntax.Replacement;
import dl.syntax.Term;
import dl.syntax.dLStructure;
import matlab.parser.AbstractMatlabParser;

public class AssignmentStatement extends Statement {
	Term rhs, lhs;

	
	public AssignmentStatement(Term lhs, Term rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Term replaceVariable( Replacement replace, RealVariable LHS, Statement statement){
		
		Term rhs = ((AssignmentStatement) statement).getRHS();
		Term returnTerm = rhs.replace( new Replacement( LHS, replace.get(LHS) ));

			
			System.out.println(" in Assignment Statement "+returnTerm.getArgument(1));
				
		return returnTerm;
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
	
	public Term getLHS(){
		return lhs;
	}
	
	public Term getRHS(){
		return rhs;
	}
	
	public String toMathematicaString(){
		return this.toMathematicaString();
	}
	
	public boolean containsLHS(Term t, Statement s){
		Term temp = ((AssignmentStatement) s).getRHS();
	//	Term LHS = ((AssignmentStatement) s).getLHS();
		System.out.println("RHS "+temp+"LHS "+t);
		for ( int i = 0; i<s.toString().length(); i++){
			if ( temp.toString().contains(t.toString())){
				return true;
			}
		}
		
		
		return false;
	}
	
//	public String toRealString(){
//		return rhs.todRealString();
//	}
	
	public String toString(){
		return lhs.toMathematicaString() + " " + getOperator() + " " + rhs.toMathematicaString() + ";";
	}
}
