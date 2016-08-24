package propositionallogic.syntax;

public class AndProposition extends BinaryProposition {
	
	public AndProposition( Proposition lhs, Proposition rhs ) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public String toString() {
		return "( " + lhs.toString() + " & " + rhs.toString() + " )";
	}

}
