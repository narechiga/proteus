package propositionallogic.syntax;

public class PropositionalVariable extends Proposition {
	
	public PropositionalVariable( String string ) {
		spawnArguments();
		this.operator = string;
	}

}
