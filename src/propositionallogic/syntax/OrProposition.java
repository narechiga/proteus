package propositionallogic.syntax;

public class OrProposition extends BinaryProposition {
	public OrProposition( Proposition lhs, Proposition rhs ) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public String toString() {
		return "( " + lhs.toString() + " | " + rhs.toString() + " )";
	}

}
