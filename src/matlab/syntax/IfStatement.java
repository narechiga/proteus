/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package matlab.syntax;

import java.util.*;

import interfaces.text.*;
import dl.syntax.*;

public class IfStatement extends Statement {

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
	
	public IfStatement( List<dLFormula> conditions, List<MatlabProgram> programs ) {
		this.conditions = conditions;
		this.programs = programs;
	}
	
	public List<dLFormula> getConditions() {
		return conditions;
	}
	
	public List<MatlabProgram> getPrograms() {
		return programs;
	}
	
	public List<Statement> getStatements() {
		List<Statement> statements = new ArrayList<>();
		statements.add(this);
		return statements;
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
	
//	public String getConditionstoString(){
//		return conditions.get(0).toString();
//	}
//	
//	public String getProgramstoString(){
//		return programs.get(0).toString();
//	}
//	
//	public String getConditionstoMathematicaString(){
//		return conditions.get(0).toMathematicaString();
//	}
//	
//	public String getProgramstoMathematicaString(){
//		return ( programs.get(0)).toMathematicaString();
//	}
	
	public void appendStatementToAllCases( Statement statement ) {
		for ( MatlabProgram program : programs ) {
			program.append( statement );
		}
		
	}
	
//	public void replace( Replacement replace ){
//		System.out.println(" in IfStatement replaceVariable() replace getvalues"+replace.getValues()+" replace getVariables "+replace.getVariables()+"statement "+statement);
//		String LHS = replace.getVariables().toString();
//		String l = (String) LHS.substring(1, LHS.length()-2);
//		System.out.println ( "statement.contains( l ) "+statement.contains( l )+" LHS "+l+" statement "+statement + "compareTo((Object)l) "+compareTo((Object)l));
//		while( compareTo((Object)l) == 0 ){
//			System.out.println( "in compareTo");
//			
//		}
//			
	
		
//	}
	
	
	
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
	
	
	//public StringBuffer helperString(){
	//	
	//	StringBuffer sb = new StringBuffer();
	//	String result ;
	//	if ( conditions.size() == 1 && programs.size() == 1 ){
	//		sb.append("if "+ conditions.get(0).toMathematicaString()+" "+programs.get(0).getStatements());
	//	}else if ( conditions.size() >= 1 && programs.size() == 2 ){
	//		sb.append("if "+ conditions.get(0).toMathematicaString()+" "+programs.get(0).getStatements()+" else "+programs.get(1).getStatements());
	//	}else { 
	//		sb.append("if"+ conditions.get(0).toMathematicaString()+" "+programs.get(0).getStatements());
	//		int i = 1;
	//		while ( i <= programs.size()-1){
	//			if( i == programs.size()-1 ){
	//				sb.append(" else "+conditions.get(i).toMathematicaString()+" "+programs.get(i).getStatements());
	//				return sb;
	//			}
	//			
	//			sb.append(" elseif"+conditions.get(i).toMathematicaString()+" "+programs.get(i).getStatements());
	//			i++;
	//		
	//		}
	//		
	//	}	
	//	return sb;
	//	
	//}
	
	public String toString(){

		String returnString = "";

		returnString = "\nif (" + conditions.get(0).toMathematicaString() + ")\n";
		for ( Statement statement : programs.get(0).getStatements() ) {
			returnString += "\t" + statement.toString() + "\n";
		}
		
		// Becomes true after we see an else clause
		// helps to prevent extra clauses after the else
		int counter = 0;
		for ( dLFormula condition : conditions.subList(1, conditions.size() ) ) { //changed from conditions.size()-1 to conditions.size()
			
			if ( condition instanceof TrueFormula ) {
				returnString += "else\n";
				counter += 1;
				returnString += programs.get(counter).toString();
				returnString += "end";
			} else {
				returnString += "elseif (" + condition.toMathematicaString() +")\n";
				counter += 1;
				returnString += programs.get(counter).toString();
			}

		//	for ( MatlabProgram program : programs.subList(1, programs.size()) ) { //added .subList(1, programs.size()) toget programs for else part
//			for ( int i = counter; i < conditions.size()-counter; i++){
//				returnString += programs.get(i).toString();
//			}

		}

//		returnString += "end";
		return returnString;
		
		
	}

	
	
	
}
