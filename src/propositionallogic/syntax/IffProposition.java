package propositionallogic.syntax;

public class IffProposition extends BinaryProposition {
	
	public IffProposition( Proposition lhs, Proposition rhs ) {
		this.operator = "<->";
		spawnArguments();
		addArgument( lhs );
		addArgument( rhs );
	}
	
	

}
