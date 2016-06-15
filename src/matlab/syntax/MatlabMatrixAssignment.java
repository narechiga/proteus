package matlab.syntax;

import dl.syntax.*;


public class MatlabMatrixAssignment extends MatlabProgram {
	private final RealVariable lhs;
	private final GeneralizedTerm rhs;
	
	public MatlabMatrixAssignment( RealVariable lhs, GeneralizedTerm rhs ) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public RealVariable getLHS() {
		return lhs;
	}
	
	public GeneralizedTerm getRHS() {
		return rhs;
	}
	
	public MatlabAssignment replace( Replacement replacement ) {
		//TO DO!
		return null;//new MatlabAssignment( lhs, rhs.replace( replacement ));
	}
	
	public String toString() {
		return lhs.toKeYmaeraString() + " = " + rhs.toKeYmaeraString() + ";\n";
	}

}
