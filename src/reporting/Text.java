package reporting;

public class Text extends ReportElement{
	String text = "";
	
	public Text() {
		
	}
	
	public Text( String text ) {
		this.text = text;
	}
	
	public void addText( String text ) {
		this.text += text;
	}
	
	public String toLaTeXString() {
		return text;
	}

}
