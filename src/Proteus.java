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
				dLFormula dummy=( dLFormula.parse( TextInput.file2String( userInput ) ) );
				String dummy1="(x1^2 + y1^2<=1) &(x2^2 + y2^2<=1) &(x3^2 + y3^2<=1) &(x4^2 + y4^2<=1) &(x5^2 + y5^2<=1) &(x6^2 + y6^2<=1) &(x7^2 + y7^2<=1) &(x8^2 + y8^2<=1) &(x9^2 + y9^2<=1) &(x10^2 + y10^2<=1) &(z <= x1^2 + y1^2 + x2^2 + y2^2 + x3^2 + y3^2 + x4^2 + y4^2 + x5^2 + y5^2 + x6^2 + y6^2 + x7^2 + y7^2 + x8^2 + y8^2 + x9^2 + y9^2 + x10^2 + y10^2) & (z > 10) ";
				dummy=dLFormula.parse(dummy1);
				TextOutput.info("Done parsing");
				LogicSolverResult result = z3.findInstance(dummy);
				TextOutput.info(result.satisfiability);
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
