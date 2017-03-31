package reporting;

class SubSection extends Section {
	
	public SubSection ( String title ) {
		this.title = title;
	}

	
	public String toLaTeXString() {
		return "\\subsection{" + title + "}\n";
	}
}
