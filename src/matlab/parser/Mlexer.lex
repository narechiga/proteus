package matlab.parser;

import matlab.parser.Mparser;

%%

%public
%class Mlexer
%implements Mparser.Lexer
%int
%unicode
%line
%column

%{
	int openBraceCount = 0;
	boolean debug = false;
	public Object getLVal() {
		//System.out.println("YYTEXT is: " + yytext() );
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
			System.out.println("Lexer: space");
			System.out.println("Lexer @ " + yytext() );
		}
	}
	{Comment} {
		if ( debug ) {
			System.out.println("Lexer: comment");	
			System.out.println("Lexer @ " + yytext() );
		}
	}
	
	
	
	// Punctuation
	"(" { 
		if ( debug ) {
			System.out.println("Lexer: LPAREN");
			System.out.println("Lexer @ " + yytext() );
		}
		return LPAREN;
	}
	"," { 
		if ( debug ) {
			System.out.println("Lexer: COMMA");
			System.out.println("Lexer @ " + yytext() );
		}
		return COMMA;
	}
	";" { 
		if ( debug ) {
			System.out.println("Lexer: SEMICOLON");
			System.out.println("Lexer @ " + yytext() );
		}
		return SEMICOLON;
	}
	")" { 
		if ( debug ) {
			System.out.println("Lexer: RPAREN");
			System.out.println("Lexer @ " + yytext() );
		}
		return RPAREN;
	}
	
	// Basic arithmetic
	"+" { 
		if ( debug ) {
			System.out.println("Lexer: PLUS");
			System.out.println("Lexer @ " + yytext() );
		}
		return PLUS;
	}	
	"*" { 
		if ( debug ) {
			System.out.println("Lexer: MULTIPLY");
			System.out.println("Lexer @ " + yytext() );
		}
		return MULTIPLY;
	}
	"-" { 
		if ( debug ) {
			System.out.println("Lexer: MINUS");
			System.out.println("Lexer @ " + yytext() );
		}
		return MINUS;
	}
	"/" { 
		if ( debug ) {
			System.out.println("Lexer: DIVIDE");
			System.out.println("Lexer @ " + yytext() );
		}
		return DIVIDE;
	}
	"^" { 		
		if ( debug ) {
			System.out.println("Lexer: POWER");
			System.out.println("Lexer @ " + yytext() );
		}
		return POWER;		
	}
	"=" { 
		if ( debug ) {
			System.out.println("Lexer: ASSIGN");
			System.out.println("Lexer @ " + yytext() );
		}
		return ASSIGN;
	}
	"==" { 
		if ( debug ) {
			System.out.println("Lexer: EQUALS");
			System.out.println("Lexer @ " + yytext() );
		}
		return EQUALS;
	}
	{Number} { 
		if ( debug ) {
			System.out.println("Lexer: NUMBER");
			System.out.println("Lexer @ " + yytext() );
		}
		return NUMBER;
	}
	{InequalityLiteral} { 
		if ( debug ) {
			System.out.println("Lexer: INEQUALITY");
			System.out.println("Lexer @ " + yytext() );
		}
		return INEQUALITY;
	}
	
	
	// First order logic symbols
	
	"true" { 
		if ( debug ) {
			System.out.println("Lexer: TRUE");
			System.out.println("Lexer @ " + yytext() );
		}
		return TRUE;
	}
	"false" { 
		if ( debug ) {
			System.out.println("Lexer: FALSE");
			System.out.println("Lexer @ " + yytext() );
		}
		return FALSE;
	}
	
	"\&" { 
		if ( debug ) {
			System.out.println("Lexer: AND");
			System.out.println("Lexer @ " + yytext() );
		}
		return AND;
	}
	"\&\&" { // For mathematica
		if ( debug ) {
			System.out.println("Lexer: AND");
			System.out.println("Lexer @ " + yytext() );
		}
		return AND;
	}
	"\|" { 
		if ( debug ) {
			System.out.println("Lexer: OR");
			System.out.println("Lexer @ " + yytext() );
		}
		return OR;
	}
	"\|\|" { // For mathematica
		if ( debug ) {
			System.out.println("Lexer: OR");
			System.out.println("Lexer @ " + yytext() );
		}
		return OR;
	}
	"~" { 
		if ( debug ) {
			System.out.println("Lexer: NOT");
			System.out.println("Lexer @ " + yytext() );
		}
		return NOT;
	}
	"if" { 
		if ( debug ) {
			System.out.println("Lexer: IF");
			System.out.println("Lexer @ " + yytext() );
		}
		return IF;
	}
	"elseif"	{ 
		if ( debug ) {
			System.out.println("Lexer: ELSEIF");
			System.out.println("Lexer @ " + yytext() );
		}
		return ELSEIF;
	}
	"else" { 
		if ( debug ) {
			System.out.println("Lexer: ELSE");
			System.out.println("Lexer @ " + yytext() );
		}
		return ELSE;
	}
	"end" { 
		if ( debug ) {
			System.out.println("Lexer: END");
			System.out.println("Lexer @ " + yytext() );
		}
		return END;
	}
	
	{IdentifierName} { 
		if ( debug ) {
			System.out.println("Lexer: IDENTIFIER");
			System.out.println("Lexer @ " + yytext() );
		}
		return IDENTIFIER;
	}
		
	[^] { 
		System.out.println("Lexer: I'm confused, throwing error");
		System.out.println("Lexer @ " + yytext() );
		return Mparser.YYERROR;
	}
	
	}

