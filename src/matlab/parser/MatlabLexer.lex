package matlab.parser;

import matlab.parser.MatlabParser;
import interfaces.text.*;

%%

%public
%class MatlabLexer
%implements MatlabParser.Lexer
%int
%unicode
%line
%column

%{
	int openBraceCount = 0;
	boolean debug = false;
	public Object getLVal() {
		TextOutput.setDebug(false);
		TextOutput.setColor(false);
		//TextOutput.debug("YYTEXT is: " + yytext() );
		return yytext();
	}

	public void yyerror ( String S ) {
		System.err.println( S );
	}
%}

IdentifierName = [a-zA-Z_]+[a-z0-9A-Z_]*
Number = [0-9]+ \.?[0-9]* | [0-9]+ \.?[0-9]* e [-+]?[0-9]+ | [0-9]+ \.?[0-9]* E [-+]?[0-9]+
InequalityLiteral = < | > | <= | >= | \!=

InputCharacter = [^\r\n]
LineTerminator = \r|\n|\r\n|\n;
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
			TextOutput.debug("Lexer: space");
			TextOutput.debug("Lexer @ " + yytext() );
		}
	}
	{Comment} {
		if ( debug ) {
			TextOutput.debug("Lexer: comment");	
			TextOutput.debug("Lexer @ " + yytext() );
		}
	}
	
	
	
	// Punctuation
	"(" { 
		if ( debug ) {
			TextOutput.debug("Lexer: LPAREN");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return LPAREN;
	}
	"," { 
		if ( debug ) {
			TextOutput.debug("Lexer: COMMA");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return COMMA;
	}
	";" { 
		if ( debug ) {
			TextOutput.debug("Lexer: SEMICOLON");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return SEMICOLON;
	}
	")" { 
		if ( debug ) {
			TextOutput.debug("Lexer: RPAREN");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return RPAREN;
	}
	
	// Basic arithmetic
	"+" { 
		if ( debug ) {
			TextOutput.debug("Lexer: PLUS");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return PLUS;
	}	
	"*" { 
		if ( debug ) {
			TextOutput.debug("Lexer: MULTIPLY");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return MULTIPLY;
	}
	"-" { 
		if ( debug ) {
			TextOutput.debug("Lexer: MINUS");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return MINUS;
	}
	"/" { 
		if ( debug ) {
			TextOutput.debug("Lexer: DIVIDE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return DIVIDE;
	}
	"^" { 		
		if ( debug ) {
			TextOutput.debug("Lexer: POWER");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return POWER;		
	}
	"=" { 
		if ( debug ) {
			TextOutput.debug("Lexer: ASSIGN");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return ASSIGN;
	}
	"==" { 
		if ( debug ) {
			TextOutput.debug("Lexer: EQUALS");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return EQUALS;
	}
	{Number} { 
		if ( debug ) {
			TextOutput.debug("Lexer: NUMBER");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return NUMBER;
	}
	{InequalityLiteral} { 
		if ( debug ) {
			TextOutput.debug("Lexer: INEQUALITY");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return INEQUALITY;
	}
	
	
	// First order logic symbols
	
	"true" { 
		if ( debug ) {
			TextOutput.debug("Lexer: TRUE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return TRUE;
	}
	"false" { 
		if ( debug ) {
			TextOutput.debug("Lexer: FALSE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return FALSE;
	}
	
	"\&" { 
		if ( debug ) {
			TextOutput.debug("Lexer: AND");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return AND;
	}
	"\&\&" { // For mathematica
		if ( debug ) {
			TextOutput.debug("Lexer: AND");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return AND;
	}
	"\|" { 
		if ( debug ) {
			TextOutput.debug("Lexer: OR");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return OR;
	}
	"\|\|" { // For mathematica
		if ( debug ) {
			TextOutput.debug("Lexer: OR");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return OR;
	}
	"~" { 
		if ( debug ) {
			TextOutput.debug("Lexer: NOT");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return NOT;
	}
	"if" { 
		if ( debug ) {
			TextOutput.debug("Lexer: IF");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return IF;
	}
	"elseif"	{ 
		if ( debug ) {
			TextOutput.debug("Lexer: ELSEIF");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return ELSEIF;
	}
	"else" { 
		if ( debug ) {
			TextOutput.debug("Lexer: ELSE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return ELSE;
	}
	"end" { 
		if ( debug ) {
			TextOutput.debug("Lexer: END");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return END;
	}
	
	{IdentifierName} { 
		if ( debug ) {
			TextOutput.debug("Lexer: IDENTIFIER");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return IDENTIFIER;
	}
		
	[^] { 
		System.err.println("Lexer: I'm confused, throwing error");
		System.err.println("Lexer @ " + yytext() );
		return MatlabParser.YYERROR;
	}
	
	}

