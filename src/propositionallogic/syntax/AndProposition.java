package propositionallogic.syntax;

public class AndProposition extends BinaryProposition {
	
	public AndProposition( Proposition lhs, Proposition rhs ) {
		this.operator = "&";
		spawnArguments();
		addArgument( lhs );
		addArgument( rhs );
	}

}
