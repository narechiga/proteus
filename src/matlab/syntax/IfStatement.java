/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package matlab.syntax;

import java.util.*;

import dl.syntax.ComparisonFormula;
import dl.syntax.dLFormula;

public class IfStatement extends Statement{

	//private LinkedHashMap<dLFormula, MatlabProgram> lh = new LinkedHashMap<dLFormula, MatlabProgram>();
	private List<dLFormula> conditions;
	private List<MatlabProgram> programs;

	public IfStatement () {
		conditions = new ArrayList<>();
		programs = new ArrayList<>();
	}
	
	public IfStatement( dLFormula condition, MatlabProgram program){
		conditions = new ArrayList<>();
		programs = new ArrayList<>();
		conditions.add( condition );
		programs.add( program );
	//	System.out.println("condition in ifstatement"+getConditionstoString());
	//	System.out.println("matlabprogram after ifstatement "+getProgramstoString());
	
	}
	
	public void appendCase( dLFormula condition, MatlabProgram program ) {
		conditions.add( condition );
		programs.add( program );
//		System.out.println("condition in ifstatement"+getConditionstoString());
	}
	
	
	public void appendCase( dLFormula condition, AssignmentStatement statement ) {
		try{
		conditions.add( condition );
		programs.add( new MatlabProgram(statement) );
//		System.out.println("condition in ifstatement"+getConditionstoString());
		}catch( Exception e){
			System.out.println("in appendCase - Ifstatement. Stacktrace: "+e);
		}
	}
	
	public void prependCase( dLFormula condition, MatlabProgram program ) {
		conditions.add(0, condition );
		programs.add(0, program);
	}
	
	public String getConditionstoString(){
		return conditions.get(0).toString();
	}
	
	public String getProgramstoString(){
		return programs.get(0).toString();
	}
	
	public String toString() {
		return "To do";
		// This guy should return the string as matlab would expect it
	}
	
}
