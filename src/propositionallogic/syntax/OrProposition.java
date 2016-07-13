package propositionallogic.syntax;

public class OrProposition extends BinaryProposition {
	public OrProposition( Proposition lhs, Proposition rhs ) {
		this.operator = "|";
		spawnArguments();
		addArgument( lhs );
		addArgument( rhs );
	}

}
