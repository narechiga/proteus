package propositionallogic.syntax;

public class NotProposition extends Proposition {
	
	public NotProposition( Proposition proposition ) {
		spawnArguments();
		this.operator = "!";
		addArgument(proposition);
	}
	
	public Proposition getProposition() {
		return getArgument(0);
	}

}
