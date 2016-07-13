package propositionallogic.syntax;

public class BinaryProposition extends Proposition {
	public Proposition getLHS() {
		return subPropositions.get(0);
	}
	public Proposition getRHS() {
		return subPropositions.get( subPropositions.size()-1 );
	}
	public String toString() {
		return "(" + getLHS().toString() + " " + operator.toString() + " " + getRHS().toString() + ")";
	}

}
