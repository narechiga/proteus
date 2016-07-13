package propositionallogic.parser;

import interfaces.text.*;
import propositionallogic.syntax.*;


%%

%public
%class PropositionalLogicLexer
%implements PropositionalLogicParser.Lexer
%int
%unicode
%line
%column

%{
	int openBraceCount = 0;
	boolean debug = false;
	public Object getLVal() {
		//TextOutput.debug("YYTEXT is: " + yytext() );
		return yytext();
	}

	public void yyerror ( String S ) {
		//System.err.println( S );
		throw new PropositionFormatException( S );
	}
%}


IdentifierName = [a-zA-Z_]+[a-z0-9A-Z_]*

InputCharacter = [^\r\n]
LineTerminator = \r|\n|\r\n;
WhiteSpace     = {LineTerminator} | [ \t\f]

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*
/**/
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

%%
<YYINITIAL> {
	{WhiteSpace} { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: space");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
	}
	{Comment} {
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: comment");	
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
	}
	
	// Punctuation
	"(" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: LPAREN");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return LPAREN;
	}
	"," { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: COMMA");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return COMMA;
	}
	";" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: SEMICOLON");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return SEMICOLON;
	}
	")" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: RPAREN");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return RPAREN;
	}
	
	// First order logic symbols
	"true" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: TRUE");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return TRUE;
	}
	"True" { // for mathematica
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: TRUE");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return TRUE;
	}
	"false" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: FALSE");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return FALSE;
	}	
	"False" { // for mathematica
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: FALSE");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return FALSE;
	}	
	"\&" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: AND");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return AND;
	}
	"\&\&" { // For mathematica
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: AND");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return AND;
	}
	"\|" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: OR");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return OR;
	}
	"\|\|" { // For mathematica
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: OR");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return OR;
	}
	"\!" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: NOT");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return NOT;
	}
	"<->" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: IFF");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return IFF;
	}
	"->" { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: IMPLIES");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return IMPLIES;
	}
	{IdentifierName} { 
		if ( debug ) {
			TextOutput.debug("Propositional logic lexer: IDENTIFIER");
			TextOutput.debug("Propositional logic lexer @ " + yytext() );
		}
		return IDENTIFIER;
	}
	
	[^] { 
		TextOutput.debug("Propositional logic lexer: I'm confused, throwing error");
		TextOutput.debug("Propositional logic lexer @ " + yytext() );
		return PropositionalLogicParser.YYERROR;
	}
}

