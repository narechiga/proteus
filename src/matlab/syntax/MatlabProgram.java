/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package matlab.syntax;

import java.util.List;

import dl.syntax.RealVariable;
import interfaces.text.TextOutput;
import matlab.parser.Mlexer;
import matlab.parser.Mparser;
import java.io.StringReader;
import java.util.ArrayList;

public class MatlabProgram {
	
	private List<Statement> statements;
	
		
	public MatlabProgram(){
		statements = new ArrayList<>();
	}
	
	public MatlabProgram(List<Statement> list){
		statements =  list;
	}
	public MatlabProgram(MatlabProgram program, Statement statement){
		statements = program.getStatements();
		statements.add( statement );
	}
	
	public MatlabProgram(MatlabProgram program, IfStatement ifStatement){
		statements = program.getStatements();
		statements.add( ifStatement );
	}
	
	public MatlabProgram(Statement statement) {
		statements = new ArrayList<>();
		statements.add( statement );
	//	String s = statement.checkCondition(statement);
		
	//	System.out.println("matlabprogram statement constructor ");
		}
	public MatlabProgram( String string, Boolean t){
		String[] program = string.split(";");
		System.out.println("Program: "+program[0]);
	}
	public MatlabProgram( String string ) {
		try{
			TextOutput.debug("Going to parse matlab program from string: " + string );
			StringReader thisReader = new StringReader( string );
			System.out.println("String in Matlab "+string);
			Mlexer thisdLLexer = new Mlexer( thisReader );
			Mparser thisParser = new Mparser( thisdLLexer );
			thisParser.parse();
			//	statements = (List<Statement>) thisParser.parsedProgram;
			//	MatlabProgram m = thisParser.parsedProgram;
		
		statements = thisParser.parsedProgram.getStatements();
		}catch(Exception e){
			System.out.println("Exception caught in MatlabProgram: ");
			System.out.println(e);
		}
	}
	
	public Statement peekFirstStatement() {
		return statements.get(0);
	}
	
	public Statement consumeFirstStatement() {
		Statement result = statements.get(0);
		statements.remove(0);
		return result;
	}
	
	public Statement peekLastStatement() {
		return statements.get(statements.size()-1);
	}
	
	public Statement consumeLastStatement() {
		Statement result = statements.get(statements.size()-1);
		statements.remove(statements.size()-1);
		return result;
	}
	
	public void append( Statement statement ) {
		statements.add( statement );
	}
	
	public void append( List<Statement> statements ) {
		this.statements.addAll( statements );
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public String toString() {
		String returnString = "";
		for ( Statement statement : getStatements() ) {
			returnString += statement.toString();
		}
		return returnString;
	}

	public String toMathematicaString() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
		
}
