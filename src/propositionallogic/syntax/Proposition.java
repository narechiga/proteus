package propositionallogic.syntax;

import propositionallogic.parser.*;

import java.io.*;
import java.util.*;

public abstract class Proposition {

	String operator;
	List<Proposition> subPropositions;
	
	public static Proposition parseProposition( String string ) {
		StringReader thisReader = new StringReader( string );
		PropositionalLogicLexer lexer = new PropositionalLogicLexer( thisReader );
		PropositionalLogicParser parser = new PropositionalLogicParser( lexer );

		try {
			parser.parse();
			Proposition proposition = parser.parsedProposition;
			return proposition;
		} catch ( Exception e ) {
			throw new PropositionFormatException("Could not parse: " + string);
		}
	}
	
	protected void spawnArguments() {
		this.subPropositions = new ArrayList<>();
	}
	
	protected void addArgument( Proposition proposition ) {
		this.subPropositions.add( proposition );
	}
	
	protected Proposition getArgument( int index ) {
		return subPropositions.get( index );
	}
	
	public String toString() {
		String string = "(" + operator;
		
		for ( Proposition subProposition : subPropositions ) { 
			string += (" " + subProposition.toString());
		}
		string += ")";
		
		return string;
	}


}
