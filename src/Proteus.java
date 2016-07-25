import dl.parser.PrettyPrinter;
import dl.syntax.*;
import interfaces.text.*;
import propositionallogic.*;
import propositionallogic.syntax.*;

public class Proteus {
	
	public static void main( String[] args ) {
		while ( true ) {
			try {
				String userInput = TextInput.prompt();
				TextOutput.println( parseHandler( userInput ));
				
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		}
	}
	
	public static String parseHandler( String input ) {
		String returnString = "syntax-error";
		//boolean success = false;
		try {
			Proposition structure = Proposition.parseProposition( input );
			structure = PropositionalLogic.simplify( structure );
			return (structure.getClass() + ": " + structure.toString());
		} catch ( Exception e ) {
			//e.printStackTrace();
			TextOutput.info("Input does not contain a proposition: " + input );
		}
		
		try {
			dLStructure structure = dLStructure.parseStructure( input );
			return (structure.getClass() + ": " + PrettyPrinter.print((dLFormula)structure));//structure.toString() );
		} catch ( Exception e ) {
			TextOutput.info("Input does not contain a dLFormula: " + input);
		}
		
		return returnString;
		
	}

}
