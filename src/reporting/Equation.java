package reporting;

class Equation extends ReportElement {
	
	String equation;
	
	public Equation( String equation ) {
		this.equation = equation;
	}
	
	public String toLaTeXString() {
		return "\\begin{equation}\n" + equation + "\n\\end{equation}";
	}

}
