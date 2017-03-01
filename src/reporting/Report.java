package reporting;

import java.util.*;
import reporting.*;

public class Report {
	
	// Note: the currentSection pointer is not actually used;
	// it is in case we later want to have some kind of XML report,
	// where "sections" need to have start and end tags
	
	String title = "Automatically Generated Report";
	String author = "Proteus";
	
	List<ReportElement> reportElements;
	Section currentSection;
	
	public Report() {
		reportElements = new ArrayList<>();
	}
	
	public void setTitle( String title ) {
		this.title = title;
	}
	
	public void setAuthor( String author ) {
		this.author = author;
	}
	
	public void addText( String text ) {
		Text body = new Text( text );
		reportElements.add( body );
	}
	
	public void addSection( String sectionTitle ) {
		currentSection = new Section( sectionTitle );
		reportElements.add( currentSection );
	}

	public void addSubSection( String subSectionTitle ) {
		SubSection newSubSection = new SubSection( subSectionTitle );
		reportElements.add( newSubSection );
		currentSection = newSubSection;
	}
	
	public void addSubSubSection( String subSubSectionTitle ) {
		SubSubSection newSubSubSection = new SubSubSection( subSubSectionTitle );
		reportElements.add( newSubSubSection );
		currentSection = newSubSubSection;
	}
	
	public void addEquation( String equationText ) {
		Equation equation = new Equation( equationText );
		reportElements.add( equation );
	}
	
	public void addPlot2D( ) {
		throw new RuntimeException("To do!");
	}
	
	

}
