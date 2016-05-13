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
	
	
	public void appendStatementToAllCases( Statement statement ) {
		for ( MatlabProgram program : programs ) {
			program.append( statement );
		}
		
	}
	
	public IfStatement replace( Replacement replacement ) {
		List<dLFormula> conditions = this.getConditions();
		List<MatlabProgram> programs = this.getPrograms();
		
		List<dLFormula> replacedConditions = new ArrayList<>();
		List<MatlabProgram> replacedPrograms = new ArrayList<>();
		
		for ( dLFormula condition : conditions ) {
			replacedConditions.add( condition.replace( replacement ));
		}
		for ( MatlabProgram program : programs ) {
			replacedPrograms.add( program.replace( replacement) );
		}
		
		return new IfStatement( replacedConditions, replacedPrograms );	
	}
	
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
				
				for ( Statement statement : programs.get(counter).getStatements() ) {
					returnString += "\t" + statement.toString() + "\n";
				}
				
				returnString += "end\n";
			} else {
				returnString += "elseif (" + condition.toMathematicaString() +")\n";
				counter += 1;
				for ( Statement statement : programs.get(counter).getStatements() ) {
					returnString += "\t" + statement.toString() + "\n";
				}
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
