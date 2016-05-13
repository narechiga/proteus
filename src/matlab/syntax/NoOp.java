package matlab.syntax;

import dl.syntax.*;

public class NoOp extends Statement {
	
	public NoOp() {
		
	}
	
	public String toString() {
		return "";
	}
	
	public NoOp replace( Replacement replacement ) {
		return new NoOp();
	}
}
