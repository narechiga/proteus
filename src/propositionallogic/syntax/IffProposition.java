package propositionallogic.syntax;

public class IffProposition extends BinaryProposition {
	
	public IffProposition( Proposition lhs, Proposition rhs ) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public String toString() {
		return "( " + lhs.toString() + " <-> " + rhs.toString() + " )";
	}
	
	

}
