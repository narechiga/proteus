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
	
//	public String toString() {		
//		if ( conditions.size() == 1 && programs.size() == 1 ){
//			result = "If "+ conditions.get(0).getArguments()+" "+programs.get(0).getStatements();
//		}else if ( conditions.size() == 1 && programs.size() == 2 ){
//			result = "If "+ conditions.get(0).getArguments()+" "+programs.get(0).getStatements()+"Else"+programs.get(1);
//		}else{ 
//			int i = 0;
//			while ( i < programs.size()-2){
//				result = "If "+ conditions.get(i).getArguments()+" "+programs.get(i).getStatements()+"Else If"+conditions.get(i).getArguments()+" "+programs.get(i);
//			}
//		}
//		return result;
//		
//	}
	
	
	public StringBuffer helperString(){
		
		StringBuffer sb = new StringBuffer();
		String result ;
		if ( conditions.size() == 1 && programs.size() == 1 ){
			sb.append("If "+ conditions.get(0).toMathematicaString()+" "+programs.get(0).getStatements());
		}else if ( conditions.size() >= 1 && programs.size() == 2 ){
			sb.append("If "+ conditions.get(0).toMathematicaString()+" "+programs.get(0).getStatements()+" Else "+programs.get(1).getStatements());
		}else { 
			sb.append("If"+ conditions.get(0).toMathematicaString()+" "+programs.get(0).getStatements());
			int i = 1;
			while ( i <= programs.size()-1){
				if( i == programs.size()-1 ){
					sb.append(" Else "+conditions.get(i).toMathematicaString()+" "+programs.get(i).getStatements());
					return sb;
				}
				
				sb.append(" Else If"+conditions.get(i).toMathematicaString()+" "+programs.get(i).getStatements());
				i++;
			
			}
			
		}	
		return sb;
		
	}
	
	public String toMathematicaString(){
		return this.toMathematicaString();
	}
	
	
	public String toString(){
		
			return helperString().toString();
	}
	
	
	
}
