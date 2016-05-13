/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package matlab.syntax;

import java.util.List;

import dl.syntax.*;
import interfaces.text.TextOutput;
import matlab.parser.*;
import java.io.StringReader;
import java.util.ArrayList;

public class MatlabProgram {
	
	private List<Statement> statements;	
		
	public MatlabProgram(){
		this.statements = new ArrayList<>();
	}
	
	public MatlabProgram(List<Statement> list){
		this.statements =  list;
	}
	public MatlabProgram(MatlabProgram program, Statement statement){
		this.statements = program.getStatements();
		this.statements.add( statement );
	}
	
	public MatlabProgram(MatlabProgram program, IfStatement ifStatement){
		this.statements = program.getStatements();
		this.statements.add( ifStatement );
	}
	
	public MatlabProgram(Statement statement) {
		this.statements = new ArrayList<>();
		this.statements.add( statement );
	//	String s = statement.checkCondition(statement);
		
	//	System.out.println("matlabprogram statement constructor ");
		}
//	public MatlabProgram( String string, Boolean t){
//		String[] program = string.split(";");
//		System.out.println("Program: "+program[0]);
//	}
	
	public MatlabProgram( String string ) {
		TextOutput.debug("Going to parse matlab program from string: " + string );
		StringReader thisReader = new StringReader( string );
		System.out.println("String in Matlab "+string);
		Mlexer thisdLLexer = new Mlexer( thisReader );
		Mparser thisParser = new Mparser( thisdLLexer );
		
		try {
			thisParser.parse();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		this.statements = thisParser.parsedProgram.getStatements();
	}
	
	public int getLength() {
		return this.getStatements().size();
	}
	
	public Statement getFirstStatement() {
		return this.getStatements().get(0);
	}
	public MatlabProgram exceptFirstStatement() {		
		List<Statement> statements = this.getStatements();
		statements.remove( 0 );
		return new MatlabProgram( statements );
	}
	
	public Statement peekFirstStatement() {
		return this.statements.get(0);
	}
	
	public Statement consumeFirstStatement() {
		Statement result = this.statements.get(0);
		this.statements.remove(0);
		return result;
	}
	
	public Statement peekLastStatement() {
		try {
			return this.statements.get(this.statements.size()-1);
		} catch ( ArrayIndexOutOfBoundsException e ) {
			return null;
		}
	}
	
	public Statement consumeLastStatement() {
		try {
			Statement result = statements.get(this.statements.size()-1);
			this.statements.remove(this.statements.size()-1);
			return result;
		} catch ( ArrayIndexOutOfBoundsException e ) {
			return null;
		}
	}
	
	public MatlabProgram append( Statement statement ) {
		return new MatlabProgram( this, statement );
	}
	public MatlabProgram append( MatlabProgram program ) {
		List<Statement> totalStatements = new ArrayList<>();
		totalStatements.addAll( this.getStatements() );
		totalStatements.addAll( program.getStatements() );
		return new MatlabProgram( totalStatements );
	}
	
	public void append( List<Statement> statements ) {
		this.statements.addAll( statements );
	}

	public List<Statement> getStatements() {
		return this.statements;
	}

	public String toString() {
		String returnString = "";
		for ( Statement statement : getStatements() ) {
			returnString += statement.toString() + "\n";
		}
		return returnString;
	}

	public MatlabProgram replace( Replacement replacement ) {
		List<Statement> statements = this.getStatements();
		
		MatlabProgram substitutedProgram = new MatlabProgram();
		for ( Statement statement : statements ) {
			substitutedProgram = substitutedProgram.append( statement.replace( replacement ));
		}
		
		return substitutedProgram;
	}
	
	public boolean isNoOp() {
		if ( (this.getLength() == 1) && (this.getFirstStatement() instanceof NoOp ) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isAssignment() {
		return ( this.getLength() == 1 ) && ( this.getFirstStatement() instanceof AssignmentStatement );
	}
	
//	public AssignmentStatement asAssignment() {
//		if ( this.isAssignment() ) {
//			return ((AssignmentStatement)(this.getFirstStatement()));
//		} else {
//			throw new RuntimeException("Not an assignment statement!");
//		}
//	}
	
		
}
