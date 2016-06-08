import java.io.File;
import java.io.StringReader;
import java.util.Scanner;

import interfaces.text.TextOutput;
import main.java.com.ToyotaITC.Simulink2dReach.parser.Lexer;
import main.java.com.ToyotaITC.Simulink2dReach.parser.ParsingMachine;
import main.java.com.ToyotaITC.Simulink2dReach.parser.VerificationInstance;

public class Temp {
	
	public static String prompt() {
		TextOutput.printBoldYellow(">> ");
		Scanner input = new Scanner( System.in ); // resource leak warning is ok, don't want to close System.in
		
		String returnString = "";
		if ( input.hasNext() ) {
			returnString += input.next();
		}
		
		TextOutput.debug("echo: " + returnString );
		return returnString;
	}
	
	public static String file2String( File file ) {
		String returnString = "";
		try ( Scanner scanner = new Scanner( file ) ) {
			while ( scanner.hasNext() ) {
				returnString += scanner.next();
			}

		} catch ( Exception e ) {
			e.printStackTrace();
		} 
		TextOutput.debug("Read from file: " + returnString);
		return returnString;
	}
	
	public static VerificationInstance parseString( String string ){
		Lexer lexer = new Lexer( new StringReader(string));
		ParsingMachine parser = new ParsingMachine( lexer );
		try {
			parser.parse();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return parser.problemInstance;
	}
	
	public static VerificationInstance parseFile( File file ) {
		return parseString( file2String( file ) );
	}
	
	public static VerificationInstance parseFile( String filename ) {
		return parseFile( new File( filename ));
	}

}
