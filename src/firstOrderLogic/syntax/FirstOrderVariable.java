package firstOrderLogic.syntax;

public class FirstOrderVariable extends FirstOrderTerm {
	
	String name;
	
	public FirstOrderVariable( String name ) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
