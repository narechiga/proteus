
%{
	import java.util.*;
	import dl.syntax.*;
	import dl.semantics.*;
	import interfaces.text.*;

	@SuppressWarnings({"unchecked"})
%}

%language "Java"
%define package dl.parser
%define extends {AbstractdLParser}
%define parser_class_name {dLParser}
%define public

%token ASTERISK

/* Hybrid programs */
%token ASSIGN
%token PRIME
%token OPENBRACE
%token CLOSEBRACE
%token EQUALS
%token TEST
/*%token KLEENESTAR*/
%token CUP
/*%token RANDOM*/
%token REALDECLARATION


/* precedence for hybrid program operators */
%left KLEENESTAR
%right SEMICOLON CUP
%left RANDOM


/* Modalities */
%token OPENBOX
%token CLOSEBOX
%token OPENDIAMOND
%token CLOSEDIAMOND

/* Arithmetic */
%token NUMBER
%token IDENTIFIER
%token PLUS
%token MINUS
/*%token MULTIPLY*/
%token DIVIDE
%token POWER
%token NEWLINE
%token INEQUALITY
/*Special aliased functions*/
%token SIGMOID

/* Punctuation */
%token LPAREN
%token RPAREN
%token SEMICOLON
%token COMMA

/* First Order Logic */
%token AND
%token OR
%token NOT
%token IMPLIES
%token IFF
%token FORALL
%token EXISTS
%token TRUE
%token FALSE

%right IMPLIES IFF
%right OR AND
%left OPENBOX CLOSEBOX OPENDIAMOND CLOSEDIAMOND
%left NOT QUANTIFIER

%right INEQUALITY /* <, >, <=, >=, =, != */
%left MINUS PLUS
%left DIVIDE MULTIPLY
%left NEGATIVE
%right POWER
%left REALDECLARATION


%%
input: 
	OPENBRACE valuation CLOSEBRACE {
		try {
			$$ = (String)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location input:valuation");
			e.printStackTrace();
		}
	}
	| dLformula { 
		try {
			//TextOutput.debug("Found: dLformula"); 
			parsedStructure = (dLFormula)$1;	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula");
			e.printStackTrace();
		}
	}
	| hybridprogram {
		try {
			$$ = "hybrid program"; 
			parsedStructure = (HybridProgram)$1;	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:hybridprogram");
			e.printStackTrace();
		}
	}
	| term {
		try {
			$$ = ((Term)$1).toString();
			parsedStructure = (Term)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location input:term");
			e.printStackTrace();
		}
	}
	| error {
		//System.err.println("Parser: I'm confused, throwing error");
		//System.err.println( (String)$1 );
		//System.exit(1);
		throw new dLStructureFormatException( (String)$1 );
	}
;


/*==================== Valuations, for command-line interface ====================*/
valuation:
	%empty
	| IDENTIFIER IMPLIES NUMBER {
		try {
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}

			this.valuation.put( new RealVariable( (String)$1 ), new Real( (String)$3 ) );
			$$ = "(valuation " +  (String)$1 + "->" + (String)$3 + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:IDENTIFIER IMPLIES NUMBER");
			e.printStackTrace();
		}
		
	}
	| IDENTIFIER IMPLIES MINUS NUMBER {
		try {
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}

			this.valuation.put( new RealVariable( (String)$1 ), new Real( "-" + (String)$4 ) );
			$$ = "(valuation " +  (String)$1 + "->" + "-" + (String)$3 + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:IDENTIFIER IMPLIES MINUS NUMBER");
			e.printStackTrace();
		}
		
	}
	| valuation COMMA IDENTIFIER IMPLIES NUMBER {
		try{
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}
			this.valuation.put( new RealVariable( (String)$3 ), new Real( (String)$5 ) );
			$$ = (String)$1 + "\n" + "(valuation " +  (String)$3 + "->" + (String)$5 + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:valuation COMMA IDENTIFIER IMPLIES NUMBER");
			e.printStackTrace();
		}
	}
	| valuation COMMA IDENTIFIER IMPLIES MINUS NUMBER {
		try{
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}
			this.valuation.put( new RealVariable( (String)$3 ), new Real( "-" + (String)$6 ) );
			$$ = (String)$1 + "\n" + "(valuation " +  (String)$3 + "->" + "-" + (String)$5 + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:valuation COMMA IDENTIFIER IMPLIES MINUS NUMBER");
			e.printStackTrace();
		}
	}
;
/*============================================================*/

/*==================== Differential dynamic logic ====================*/
dLformula:
	TRUE { 
		try {
			$$ = new TrueFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:TRUE");
			e.printStackTrace();
		}
	}
	| FALSE	{ 
		try {
			$$ = new FalseFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:FALSE");
			e.printStackTrace();
		}
	}
	| comparison { 
		try {
			$$ = (ComparisonFormula)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:comparison");
			e.printStackTrace();
		}
	}
	| dLformula AND dLformula { 
		try {
			$$ = new AndFormula( (dLFormula)$1, (dLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula AND dLformula");
			e.printStackTrace();
		}
	}
	| dLformula OR dLformula { 
		try {
			$$ = new OrFormula( (dLFormula)$1, (dLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula OR dLformula");
			e.printStackTrace();
		}
	}
	| NOT dLformula	{ 
		try {
			$$ = new NotFormula( (dLFormula)$2 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:NOT dLformula");
			e.printStackTrace();
		}
	}
	| LPAREN dLformula RPAREN { 
		try {
			$$ = (dLFormula)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:LPAREN dLformula RPAREN");
			e.printStackTrace();
		}
	}
	| dLformula IMPLIES dLformula { 
		try {
			$$ = new ImpliesFormula( (dLFormula)$1, (dLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula IMPLIES dLformula");
			e.printStackTrace();
		}
	}
	| dLformula IFF dLformula { 
		try {
			$$ = new IffFormula( (dLFormula)$1, (dLFormula)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula IFF dLformula");
			e.printStackTrace();
		}
	}
	//| IDENTIFIER LPAREN formulalist RPAREN {
	//	try {
	//		$$ = new BooleanFunctionFormula(
	//					new Operator( (String)$1 ),
	//					(List<dLFormula>)$3 );
	//	} catch ( Exception e ) {
	//		System.err.println("Exception at location dLformula:IDENTIFIER LPAREN formulalist RPAREN");
	//		e.printStackTrace();
	//	}
	//}
	| FORALL IDENTIFIER SEMICOLON dLformula %prec QUANTIFIER { 
		try {
			$$ = new ForAllFormula( new RealVariable( (String)$2), (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:FORALL IDENTIFIER SEMICOLON dLformula");
			e.printStackTrace();
		}
	}
	| EXISTS IDENTIFIER SEMICOLON dLformula %prec QUANTIFIER { 
		try {
			$$ = new ExistsFormula( new RealVariable( (String)$2 ), (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:EXISTS IDENTIFIER SEMICOLON dLformula");
			e.printStackTrace();
		}
	}
	| OPENBOX hybridprogram CLOSEBOX dLformula { 
		try {
			$$ = new BoxModalityFormula( (HybridProgram)$2, (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location OPENBOX:hybridprogram CLOSEBOX dLformula");
			e.printStackTrace();
		}
	}
	| OPENDIAMOND hybridprogram CLOSEDIAMOND dLformula { 
		try {
			$$ = new BoxModalityFormula( (HybridProgram)$2, (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location OPENDIAMOND hybridprogram CLOSEDIAMOND dLformula");
			e.printStackTrace();
		}
	}
;

//formulalist:
//	dLformula {
//		try {
//			ArrayList<dLFormula> formulas = new ArrayList<>();
//			formulas.add( (dLFormula)$1 );
//			$$ = formulas;
//		} catch ( Exception e ) {
//			System.err.println("Exception at location formulalist:dLformula");
//			e.printStackTrace();
//		}
//	}
//	| formulalist COMMA dLformula {
//		try {
//			ArrayList<dLFormula> formulas  = (ArrayList<dLFormula>)$1 ;
//			formulas.add( (dLFormula)$3 );
//			$$ = formulas;
//		} catch ( Exception e ) {
//			System.err.println("Exception at location formulalist:formulalist COMMA dLformula");
//			e.printStackTrace();
//		}
//	}
//;

hybridprogram:
	odesystem { 
		try {
			$$ = (ContinuousProgram)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:odesystem");
			e.printStackTrace();
		}
	}
	| test { 
		try {
			$$ = (TestProgram)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:test");
			e.printStackTrace();
		}
	}
	| concreteassignment { 
		try {
			$$ = (ConcreteAssignmentProgram)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:concreteassignment");
			e.printStackTrace();
		}
	}
	| arbitraryassignment { 
		try {
			$$ = (ArbitraryAssignmentProgram)$1;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:arbitraryassignment");
			e.printStackTrace();
		}
	}
	| hybridprogram SEMICOLON hybridprogram { 
		try {
			$$ = new SequenceProgram( (HybridProgram)$1, (HybridProgram)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram SEMICOLON hybridprogram");
			e.printStackTrace();
		}
	}
	| hybridprogram CUP hybridprogram { 
		try {
			$$ = new ChoiceProgram( (HybridProgram)$1, (HybridProgram)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram CUP hybridprogram");
			e.printStackTrace();
		}
	}
	| hybridprogram ASTERISK %prec KLEENESTAR {
		try {
			$$ = new RepetitionProgram( (HybridProgram)$1 );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram ASTERISK");
			e.printStackTrace();
		}
	}
	| LPAREN hybridprogram RPAREN { 
		try {
			$$ = (HybridProgram)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:LPAREN hybridprogram RPAREN");
			e.printStackTrace();
		}
	}
;

concreteassignment:
	IDENTIFIER ASSIGN term { 
		try {
			$$ = new ConcreteAssignmentProgram( new RealVariable( (String)$1 ), (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location concreteassignment:IDENTIFIER ASSIGN term");
			e.printStackTrace();
		}
	}
;

arbitraryassignment:
	IDENTIFIER ASSIGN ASTERISK %prec RANDOM { 
		try {
			$$ = new ArbitraryAssignmentProgram( new RealVariable( (String)$1 ) );
		} catch ( Exception e ) {
			System.err.println("Exception at location arbitraryassignment:IDENTIFIER ASSIGN ASTERISK");
			e.printStackTrace();
		}
	}


test:
	TEST dLformula { 
		try {
			$$ = new TestProgram( (dLStructure)$2 );
		} catch ( Exception e ) {
			System.err.println("Exception at location test:TEST dLformula");
			e.printStackTrace();
		}
	}
;

odesystem:
	OPENBRACE odelist CLOSEBRACE { 
		try {
			$$ = new ContinuousProgram( (ArrayList<ExplicitODE>)$2 ); // Constructor appends "true" doe automaticaly
		} catch ( Exception e ) {
			System.err.println("Exception at location odesystem:OPENBRACE odelist CLOSEBRACE");
			e.printStackTrace();
		}
	}
	| OPENBRACE odelist AND dLformula CLOSEBRACE { 
		try {
			$$ = new ContinuousProgram( (ArrayList<ExplicitODE>)$2, (dLFormula)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location odesystem:OPENBRACE odelist AND dLformula CLOSEBRACE");
			e.printStackTrace();
		}
	}
;

odelist:
	ode { 
		//$$ = (String)$1;
		try {
			ArrayList<ExplicitODE> args = new ArrayList<ExplicitODE>();
			args.add( (ExplicitODE)$1 );

			$$ = args;

		} catch ( Exception e ) {
			System.err.println("Exception at location odelist:ode");
			e.printStackTrace();
		}

	}
	| odelist COMMA ode { 
		//$$ = (String)$1 + ", " + (String)$3;
		try {
			ArrayList<ExplicitODE> args = new ArrayList<ExplicitODE>();
			args.addAll( (ArrayList<ExplicitODE>)$1 );
			args.add( (ExplicitODE)$3 );
			$$ = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location odelist:odelist COMMA ode");
			e.printStackTrace();
		}

	}
;
ode:
	IDENTIFIER PRIME EQUALS term { 
		try {
			$$ = new ExplicitODE( new RealVariable( (String)$1 ), (Term)$4 );
		} catch ( Exception e ) {
			System.err.println("Exception at location ode:IDENTIFIER PRIME EQUALS term");
			e.printStackTrace();
		}

	}
;



comparison:
	term INEQUALITY term { 
		try {
			$$ = new ComparisonFormula( new Operator( (String)$2, 2, true ), (Term)$1, (Term)$3 ) ;
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term INEQUALITY term");
			e.printStackTrace();
		}
	}
	| term EQUALS term {
		try {
			$$ = new ComparisonFormula( new Operator( (String)$2, 2, true ), (Term)$1, (Term)$3 ) ;
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term EQUALS term");
			e.printStackTrace();
		}
	}
;


term:
	NUMBER { 
		try {
			//TextOutput.setDebug( true );
			String numberString = (String)$1;
			//TextOutput.debug("From number string: " + numberString );
			if ( numberString.contains("e") ) {
				//TextOutput.debug("Found e-notation");
				String[] numberParts = numberString.split("e");
				Real base = new Real( numberParts[0] );
				Real exponent = new Real( numberParts[1] );
				//TextOutput.debug("Base: " + base.toString() + " exponent: " + exponent.toString() );
				$$ = new MultiplicationTerm( base, new PowerTerm( new Real(10), exponent ) );
				//TextOutput.debug("Parsed: " + $$.toString() );
			} else if ( numberString.contains("E") ) {
				//TextOutput.debug("Found E-notation");
				String[] numberParts = numberString.split("E");
				Real base = new Real( numberParts[0] );
				Real exponent = new Real( numberParts[1] );
				//TextOutput.debug("Base: " + base.toString() + " exponent: " + exponent.toString() );
				$$ = new MultiplicationTerm( base, new PowerTerm( new Real(10), exponent ) );
				//TextOutput.debug("Parsed: " + $$.toString() );
			} else {
				$$ = new Real( (String)$1 );
				//TextOutput.debug( "Found non-scientific notation number: " + $$.toString() );
			}
			//TextOutput.setDebug( false );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:NUMBER");
			e.printStackTrace();
		}
	}
	| IDENTIFIER LPAREN argumentlist RPAREN {
		try {
			$$ = new FunctionApplicationTerm( new Operator( (String)$1, ((ArrayList<Term>)$3).size(), false ), (ArrayList<Term>)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER LPAREN argumentlist RPAREN");
			e.printStackTrace();
		}
	}
	| IDENTIFIER { 
		try {
			$$ = new RealVariable( (String)$1 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER");
			e.printStackTrace();
		}
	}
	| LPAREN term RPAREN { 
		try {
			$$ = (Term)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location term:LPAREN term RPAREN");
			e.printStackTrace();
		}
	}
	| term PLUS term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("+", 2, true), args );
			$$ = new AdditionTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term PLUS term");
			e.printStackTrace();
		}
	}
	| term MINUS term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("-", 2, true), args );
			$$ = new SubtractionTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term MINUS term");
			e.printStackTrace();
		}
	}
	| term ASTERISK term %prec MULTIPLY { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("*", 2, true), args );
			$$ = new MultiplicationTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term ASTERISK term");
			e.printStackTrace();
		}
	}
	| term DIVIDE term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("/", 2, true), args );
			$$ = new DivisionTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term DIVIDE term");
			e.printStackTrace();
		}
	}
	| term POWER term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("^", 2, true), args );
			$$ = new PowerTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term POWER tterm:term POWER term");
			e.printStackTrace();
		}
	}
	| MINUS term %prec NEGATIVE { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( new Real( "0" ) );
			//args.add( (Term)$2 );
			//$$ = new Term( new Operator("-", 2, true), args );
			//$$ = new NegativeTerm( (Term)$2 );
			$$ = new SubtractionTerm( new Real(0), (Term)$2 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:MINUS term");
			e.printStackTrace();
		}
	}
	| aliasedterm {
		try {
			$$ = $1;
		} catch ( Exception e ) {
			System.err.println("Exception at location term:aliasedterm");
			e.printStackTrace();
		}
	}
;

/* function aliases that get expanded */
aliasedterm:
	SIGMOID LPAREN term RPAREN {
		try {
			Term argument = (Term)$3;
			SubtractionTerm negativeArgument = new SubtractionTerm( new Real(0), argument );
			FunctionApplicationTerm exp = new FunctionApplicationTerm("exp", negativeArgument );
			AdditionTerm onePlusExp = new AdditionTerm( new Real(1), exp );
			$$ = new DivisionTerm( new Real(1), onePlusExp );
		} catch ( Exception e ) {
			System.err.println("Exception at location aliasedterm:SIGMOID LPAREN term RPAREN");
			e.printStackTrace();
		}
	}
  

argumentlist:
	%empty {
		$$ = null;
	}
	| term	{ 
		try {
			ArrayList<Term> args = new ArrayList<Term>();
			args.add( (Term)$1 );
			$$ = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:term");
			e.printStackTrace();
		}
	}
	| argumentlist COMMA term { 
		try {
			ArrayList<Term> args = new ArrayList<Term>();
			args.addAll( (ArrayList<Term>)$1 );
			args.add( (Term)$3 );
			$$ = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:argumentlist COMMA term");
			e.printStackTrace();
		}
	}
;

/*============================================================*/
%%




