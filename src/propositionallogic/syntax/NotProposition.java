package propositionallogic.syntax;

public class NotProposition implements Proposition {
	
	Proposition negatedProposition;
	
	public NotProposition( Proposition proposition ) {
		negatedProposition = proposition;
	}
	
	public Proposition getProposition() {
		return negatedProposition;
	}
	
	public String toString() {
		return negatedProposition.toString();
	}

}
