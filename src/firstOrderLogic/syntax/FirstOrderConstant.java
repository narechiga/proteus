package firstOrderLogic.syntax;

public class FirstOrderConstant extends FirstOrderTerm {
	String name;
	
	public FirstOrderConstant( String name ) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

}
