package propositionallogic.syntax;

public class ImpliesProposition extends BinaryProposition {
	public ImpliesProposition( Proposition lhs, Proposition rhs ) {
		this.operator = "->";
		spawnArguments();
		addArgument( lhs );
		addArgument( rhs );
	}
	

}
