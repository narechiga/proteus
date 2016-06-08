package interfaces.text;

import java.io.*;
import java.util.*;

public class TextInput {
	
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
	

}
