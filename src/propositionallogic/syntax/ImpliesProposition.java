package propositionallogic.syntax;

public class ImpliesProposition extends BinaryProposition {
	public ImpliesProposition( Proposition lhs, Proposition rhs ) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public String toString() {
		return "( " + lhs.toString() + " -> " + rhs.toString() + " )";
	}

}
