import dl.parser.PrettyPrinter;
import dl.syntax.*;
import interfaces.text.*;
import dl.logicsolvers.z3kit.*;
import dl.logicsolvers.abstractions.*;
import propositionallogic.*;
import propositionallogic.syntax.*;

public class Proteus {
	
	public static void main( String[] args ) {
		while ( true ) {
			try {
				String userInput = TextInput.prompt();
				//TextOutput.println( parseHandler( userInput ));
				LogicSolverInterface z3 = new z3Interface();
				z3.checkValidity( dLFormula.parse( TextInput.file2String( userInput ) ) );
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		}
	}
	
	public static String parseHandler( String input ) {
		String returnString = "syntax-error";
		//boolean success = false;
		try {
			Proposition structure = PropositionalLogic.parseProposition( input );
			structure = PropositionalLogic.simplify( structure );
			return (structure.getClass() + ": " + structure.toString());
		} catch ( Exception e ) {
			//e.printStackTrace();
			TextOutput.info("Input does not contain a proposition: " + input );
		}
		
		try {
			//dLStructure structure = dLStructure.parseStructure( input );
			dLFormula formula = dLFormula.parseNNF( input );
			return (formula.getClass() + ": " + PrettyPrinter.print(formula));//structure.toString() );
		} catch ( Exception e ) {
			TextOutput.info("Input does not contain a dLFormula: " + input);
		}
		
		return returnString;
	}

}
