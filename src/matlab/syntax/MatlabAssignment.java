package matlab.syntax;

import dl.syntax.*;

public class MatlabAssignment extends MatlabProgram {
	private final RealVariable lhs;
	private final Term rhs;
	
	public MatlabAssignment( RealVariable lhs, Term rhs ) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public RealVariable getLHS() {
		return lhs;
	}
	
	public Term getRHS() {
		return rhs;
	}
	
	public MatlabAssignment replace( Replacement replacement ) {
		return new MatlabAssignment( lhs, rhs.replace( replacement ));
	}
	
	public String toString() {
		return lhs.toString() + " = " + rhs.toString() + ";\n";
	}
	
}
