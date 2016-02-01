/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 */
package matlab.syntax;

import java.util.List;


import matlab.parser.Mlexer;
import matlab.parser.Mparser;
import java.io.StringReader;
import java.util.ArrayList;

public class MatlabProgram {
	
	private List<Statement> statements;
	
		
	public MatlabProgram(){}
	
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
		StringReader thisReader = new StringReader( string );
		System.out.println("String in Matlab "+string);
		Mlexer thisdLLexer = new Mlexer( thisReader );
		Mparser thisParser = new Mparser( thisdLLexer );
  		thisParser.parse();
		//statements = (List<Statement>) thisParser.parsedProgram;
		
		
		statements = thisParser.parsedProgram.getStatements();
		
		
//		for(Statement o : statements){
//		    System.out.println(o.toString());
//		}
		
//		Iterator<Statement> i = statements.iterator();
//		
//		while(i.hasNext()){
//			System.out.println("MatlabProgram statements  "+i.next().toString());
//		}
		}catch(Exception e){
			System.out.println("Exception caught in MatlabProgram: ");
			System.out.println(e);
		}
	}
	
	

	public List<Statement> getStatements() {
		return statements;
	}
	
//	public String toString(){
//		IfStatement ifs = new IfStatement();
//		return ifs.toString();
//	}

	
	
}
