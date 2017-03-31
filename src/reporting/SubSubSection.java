package reporting;

class SubSubSection extends Section {
	
	public SubSubSection ( String title ) {
		this.title = title;
	}
	
	public String toLaTeXString() {
		return "\\subsubsection{" + title + "}\n";
	}

}
