package interfaces.text;

import java.io.*;
import java.util.*;

public class TextInput {
	
	public static String prompt() {
		return prompt("");
	}
	
	public static String prompt( String promptString  ) {
		TextOutput.print(promptString + " >> ");
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
		try {
			String temp="";
			BufferedReader in
			   = new BufferedReader(new FileReader(file));
			while((temp =(in.readLine()))!=null)
			{
				returnString+=temp + "\n";
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//try ( Scanner scanner = new Scanner( file ) ) {
			//while ( scanner.hasNextLine() ) {
				//returnString += scanner.nextLine();
			//}

	//	} catch ( Exception e ) {
		//	e.printStackTrace();
	//	} 
		TextOutput.debug("Read from file: " + returnString);
		return returnString;
	}
	

}
