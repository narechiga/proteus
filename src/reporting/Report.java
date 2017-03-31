package reporting;

import java.io.*;
import java.util.*;
import dl.syntax.*;
//import reporting.*;

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
	
	public void addPlot2D( List<Real> xData, List<Real> yData ) {
		throw new RuntimeException("To do!");
	}
	
	public String toLaTeXString() {
		String string = "\\documentclass[12pt,letterpaper]{article}\n\n";
		string += "\\title{" + title + "}\n";
		string += "\\author{" + author + "}\n\n";
		
		string += "\\begin{document}\n";
		string += "\\maketitle\n";
		
		for ( ReportElement element : reportElements ) {
			string += element.toLaTeXString();
		}
		
		string += "\\end{document}";
		
		return string;
	}

	public String generateFileName() {
		double randomID = Math.round(Math.random());
		Date date = new Date();
		String formatted_date = date.toString();
		formatted_date=formatted_date.replace(" ","_");
		String filename = "";// "/tmp/" + title + "_" + author +"/" + UUID.randomUUID().toString().replaceAll("-", "")+ "_"+ formatted_date + "." + randomID + "." + fileExtension;		File targetFile = new File( filename );
		//targetFile.getParentFile().mkdirs();
		throw new RuntimeException("Unfinished");
		//return filename;
	}
	
	public boolean writeToFile( ) {
		return false;
	}
	
	public String generateLaTeXPDF() {
		String fileName = "";
		return fileName;
	}
	
	

}
