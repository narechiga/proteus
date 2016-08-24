package propositionallogic.syntax;

public class PropositionalVariable implements Proposition {
	String label;
	
	public PropositionalVariable( String string ) {
		label = string;
	}
	
	public String toString() {
		return label;
	}

}
