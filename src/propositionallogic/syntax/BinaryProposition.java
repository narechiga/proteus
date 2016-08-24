package propositionallogic.syntax;

public abstract class BinaryProposition implements Proposition {
	protected Proposition lhs;
	protected Proposition rhs;
	
	public Proposition getLHS() {
		return lhs;
	}
	public Proposition getRHS() {
		return rhs;
	}

}
