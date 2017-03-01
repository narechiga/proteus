package reporting;

import java.util.*;

class Section extends ReportElement{
	
	String title;
	List<ReportElement> elements;
	
	public Section() {
		
	}
	
	public Section ( String title ) {
		this.title = title;
	}
	
}
