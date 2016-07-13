
%{
	import java.util.*;
	import propositionallogic.syntax.*;

	@SuppressWarnings({"unchecked"})
%}

%language "Java"
%define package propositionallogic.parser
%define extends {AbstractPropositionalLogicParser}
%define parser_class_name {PropositionalLogicParser}
%define public

/* Punctuation */
%token LPAREN
%token RPAREN
%token COMMA
%token SEMICOLON
%token OPENBRACE
%token CLOSEBRACE

/* First Order Logic */
%token AND
%token OR
%token NOT
%token IMPLIES
%token IFF
%token IDENTIFIER
%token TRUE
%token FALSE

%right IMPLIES IFF
%right OR AND
%right NOT

%%
input: 
	OPENBRACE replacement CLOSEBRACE {
		try {
			$$ = (String)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location input:replacement");
			System.err.println( e );
		}
	}
	| proposition { 
		try {
			//TextOutput.debug("Found: proposition"); 
			parsedProposition = (Proposition)$1;	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:proposition");
			System.err.println( e );
		}
	}
	| error {
		//System.err.println("Propositional logic parser: I'm confused, throwing error");
		//System.err.println( (String)$1 );
		throw new PropositionFormatException("Did not find a propositional logic formula in: " + (String)$1 );
	}
;

/*==================== Propositional logic ====================*/
proposition:
	TRUE { 
		try {
			$$ = new TrueProposition();
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:TRUE");
			System.err.println( e );
		}
	}
	| FALSE	{ 
		try {
			$$ = new FalseProposition();
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:FALSE");
			System.err.println( e );
		}
	}
	| IDENTIFIER {
		try {
			$$ = new PropositionalVariable( (String)$1 );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:IDENTIFIER");
			System.err.println( e );
		}
	}
	| proposition AND proposition { 
		try {
			$$ = new AndProposition( (Proposition)$1, (Proposition)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:proposition AND proposition");
			System.err.println( e );
		}
	}
	| proposition OR proposition { 
		try {
			$$ = new OrProposition( (Proposition)$1, (Proposition)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:proposition OR proposition");
			System.err.println( e );
		}
	}
	| NOT proposition	{ 
		try {
			$$ = new NotProposition( (Proposition)$2 );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:NOT proposition");
			System.err.println( e );
		}
	}
	| LPAREN proposition RPAREN { 
		try {
			$$ = (Proposition)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:LPAREN proposition RPAREN");
			System.err.println( e );
		}
	}
	| proposition IMPLIES proposition { 
		try {
			$$ = new ImpliesProposition( (Proposition)$1, (Proposition)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:proposition IMPLIES proposition");
			System.err.println( e );
		}
	}
	| proposition IFF proposition { 
		try {
			$$ = new IffProposition( (Proposition)$1, (Proposition)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:proposition IFF proposition");
			System.err.println( e );
		}
	}
;

/*============================================================*/

/*==================== Replacements, for command-line interface ====================*/
replacement:
	IDENTIFIER IMPLIES TRUE {
		try {
			if ( this.replacement == null ) {
				this.replacement = new PropositionalReplacement();
			}

			this.replacement.put( new PropositionalVariable( (String)$1 ), new TrueProposition() );
			$$ = "(replacement " +  (String)$1 + "->" + (String)$3 + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location replacement:IDENTIFIER IMPLIES TRUE");
			System.err.println( e );
		}
		
	}
	| IDENTIFIER IMPLIES FALSE {
		try {
			if ( this.replacement == null ) {
				this.replacement = new PropositionalReplacement();
			}

			this.replacement.put( new PropositionalVariable( (String)$1 ), new FalseProposition() );
			$$ = "(replacement " +  (String)$1 + "->" + "-" + (String)$3 + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location replacement:IDENTIFIER IMPLIES FALSE");
			System.err.println( e );
		}
		
	}
	| replacement COMMA IDENTIFIER IMPLIES TRUE {
		try{
			if ( this.replacement == null ) {
				this.replacement = new PropositionalReplacement();
			}
			this.replacement.put( new PropositionalVariable( (String)$3 ), new TrueProposition() );
			$$ = (String)$1 + "\n" + "(replacement " +  (String)$3 + "->" + (String)$5 + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location replacement:replacement COMMA IDENTIFIER IMPLIES TRUE");
			System.err.println( e );
		}
	}
	| replacement COMMA IDENTIFIER IMPLIES FALSE {
		try{
			if ( this.replacement == null ) {
				this.replacement = new PropositionalReplacement();
			}
			this.replacement.put( new PropositionalVariable( (String)$3 ), new FalseProposition() );
			$$ = (String)$1 + "\n" + "(replacement " +  (String)$3 + "->" + "-" + (String)$5 + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location replacement:replacement COMMA IDENTIFIER IMPLIES FALSE");
			System.err.println( e );
		}
	}
;
/*============================================================*/
%%




