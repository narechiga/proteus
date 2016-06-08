
%{
	import java.util.*;
	import dl.syntax.*;
	import dl.semantics.*;
	import matlab.syntax.*;
	import interfaces.text.*;

	@SuppressWarnings({"unchecked"})
%}

%language "Java"
%define package matlab.parser
%define extends {AbstractMatlabParser}
%define parser_class_name {MatlabParser}
%define public

/* Arithmetic */
%token NUMBER
%token IDENTIFIER
%token PLUS
%token MINUS
%token MULTIPLY
%token DIVIDE
%token POWER
%token INEQUALITY
%token EQUALS

/* Punctuation */
%token LPAREN
%token RPAREN
%token SEMICOLON
%token COMMA
%token LEFTBRACKET
%token RIGHTBRACKET

/* First Order Logic */
%token AND
%token OR
%token NOT
%token TRUE
%token FALSE


/* Matlab Function code */
//%token STATEMENT
//%token IF
%token ELSEIF
/* ELSE is declared as nonassoc below*/
%token END
%token ASSIGN

%right OR AND
%left NOT

%right INEQUALITY /* <, >, <=, >=, =, != */
%left MINUS PLUS
%left DIVIDE MULTIPLY
%right POWER
%left NEGATIVE

%nonassoc ELSE
%nonassoc IF


%%
input: 
	matlabprogram{
		try{
			$$ = $1; 
			this.parsedProgram = (MatlabProgram)$$;
			TextOutput.debug("Exiting matlabprogram block from Mparser...");
		}catch ( Exception e){
			System.err.println("Error in matlabfunction block");
			System.err.println( e );
		}
	
	}
	
;
/*==================== Matlab Function Block ====================*/
matlabprogram:
	 assignment{
		try{
				$$ = (MatlabAssignment)$1;
			}catch ( Exception e){
				System.err.println("Exception in matlabprogram:assignment");
				System.err.println( e );
		}
	}
	| conditional{
		try{
				$$ = (MatlabConditional)$1;
			}catch ( Exception e){
				System.err.println("Exception in matlabprogram:conditional");
				System.err.println( e );
		}
	}
	| assignment matlabprogram {
		try{
			$$ = new MatlabSequence( (MatlabAssignment)$1, (MatlabProgram)$2);
			}catch ( Exception e){
				System.err.println("Exception in matlabprogram:matlabprogram assignment");
				System.err.println(e);
		}
	}
	| conditional matlabprogram {
		try{
			$$ = new MatlabSequence( (MatlabConditional)$1, (MatlabProgram)$2);
			}catch ( Exception e){
				System.err.println("Exception in matlabprogram:matlabprogram conditional");
				System.err.println(e);
		}
	}
;

conditional:
	IF logicalformula matlabprogram END {
		try{
			TextOutput.debug("\nIF logicalformula matlabprogram END");
			$$ = new MatlabConditional( (dLFormula)$2, (MatlabProgram)$3 );		    
		}catch( Exception e){
 			System.err.println("Exception in conditional:IF logicalformula matlabprogram END");
			System.err.println( e );
		}
	}
	|IF logicalformula matlabprogram ELSE matlabprogram END {
		try{
			MatlabConditional is = new MatlabConditional( (dLFormula)$2, (MatlabProgram)$3 );
			is = is.appendCase( new TrueFormula(), (MatlabProgram)$5 );
			$$ = is;	    
		}catch( Exception e){
 			System.err.println("Exception in conditional:IF logicalformula matlabprogram ELSE matlabprogram END");
			System.err.println( e );
		}
	}
	| IF logicalformula matlabprogram elselist END {
		try{
			MatlabConditional is = (MatlabConditional)$4;
			is = is.prependCase( (dLFormula)$2, (MatlabProgram)$3 );
			TextOutput.debug("IF logicalformula matlabprogram elselist END");
			$$ = is;
		}catch( Exception e){
 			System.err.println("Exception in conditional:IF logicalformula matlabprogram elselist END");
			System.err.println( e );
		}
	}
	| IF logicalformula matlabprogram elselist ELSE matlabprogram END {
		try{
			MatlabConditional is = (MatlabConditional)$4;
			is = is.prependCase( (dLFormula)$2, (MatlabProgram)$3 );
			is = is.appendCase( new TrueFormula(), (MatlabProgram)$6 );
			TextOutput.debug("IF logicalformula matlabprogram elselist ELSE matlabprogram END");
			$$ = is;
		}catch( Exception e){
 			System.err.println("Exception in conditional:IF logicalformula matlabprogram elselist ELSE matlabprogram END");
			System.err.println( e );
		}
	}
;

elselist:
	ELSEIF logicalformula matlabprogram {
		try{
			$$ = new MatlabConditional( (dLFormula)$2, (MatlabProgram)$3 );		    
		}catch( Exception e){
 			System.err.println("Exception in elselist:ELSEIF logicalformula matlabprogram");
			System.err.println( e );
		}
	}
	| elselist ELSEIF logicalformula matlabprogram {
		try{
			MatlabConditional is = (MatlabConditional)$1;
			is = is.appendCase( (dLFormula)$3, (MatlabProgram)$4 );
			$$ = is;
		}catch( Exception e){
 			System.err.println("Exception in elselist:elselist ELSEIF logicalformula matlabprogram");
			System.err.println( e );
		}
		
	}
;

assignment:
 	IDENTIFIER ASSIGN term SEMICOLON{
 		try{
 				$$ = new MatlabAssignment( new RealVariable( (String)$1 ), (Term)$3 );
 				TextOutput.debug("\nterm Assignment term SEMICOLON:"+((MatlabAssignment)$$).toString());
 			}catch ( Exception e ) {
				System.err.println("Exception at location comparison:term ASSIGN term");
				System.err.println( e );
		}
 	}
 ;

logicalformula:
	comparison {
		$$ = (ComparisonFormula)$1; }
	| LPAREN logicalformula RPAREN { 
		$$ = (dLFormula)$2; }
	| logicalformula AND logicalformula {TextOutput.debug("logicalformula AND:");$$ = new AndFormula( (dLFormula)$1, (dLFormula)$3); }
	| logicalformula OR logicalformula {$$ = new OrFormula( (dLFormula)$1, (dLFormula)$3); }
	| NOT logicalformula {$$ = new NotFormula( (dLFormula)$2);}
;

comparison:
	term INEQUALITY term { 
		try {
			$$ = new ComparisonFormula( new Operator( (String)$2, 2, true ), (Term)$1, (Term)$3 ) ;
			TextOutput.debug("\nterm INEQUALITY term"+$$.toString()+((dLStructure)$$).todRealString());
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term INEQUALITY term");
			System.err.println( e );
		}
	}
	| term EQUALS term {
		try {
			$$ = new ComparisonFormula( new Operator( (String)$2, 2, true ), (Term)$1, (Term)$3 ) ;
		//	TextOutput.debug("lhs-----"+((ComparisonFormula)$$).getLHS()+"rhs-----"+((ComparisonFormula)$$).getRHS());
		//	TextOutput.debug("getInequality-----"+((ComparisonFormula)$$).getInequality().toMathematicaString());
			
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term EQUALS term");
			System.err.println( e );
		}
	}
;

term:
	NUMBER { 
		try { $$ = new Real( (String)$1 ); } catch ( Exception e ) { System.err.println("Exception at location term:NUMBER");
			System.err.println( e );
		}
	}
	//| IDENTIFIER LPAREN argumentlist RPAREN {
	//	try {
	//		$$ = new FunctionApplicationTerm( new Operator( (String)$1, ((ArrayList<Term>)$3).size(), false ), (ArrayList<Term>)$3 );
	//	} catch ( Exception e ) {
	//		System.err.println("Exception at location term:IDENTIFIER LPAREN argumentlist RPAREN");
	//		System.err.println( e );
	//	}
//	}

	| IDENTIFIER { 
		try {
			$$ = new RealVariable( (String)$1 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER");
			System.err.println( e );
		}
	}
	| LPAREN term RPAREN { 
		try {
			$$ = (Term)$2;
		} catch ( Exception e ) {
			System.err.println("Exception at location term:LPAREN term RPAREN");
			System.err.println( e );
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
			System.err.println( e );
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
			System.err.println( e );
		}
	}
	| term MULTIPLY term { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("/", 2, true), args );
			$$ = new MultiplicationTerm( (Term)$1, (Term)$3 );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term MULTIPY term");
			System.err.println( e );
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
			System.err.println( e );
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
			System.err.println( e );
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
			System.err.println( e );
		}
	}
	| matrix {
		$$ = (MatrixTerm)$1;
	}
;

matrix: LEFTBRACKET rowlist RIGHTBRACKET {
		$$ = (MatrixTerm)$2;
	};

rowlist: row {
			$$ = (MatrixTerm)$1;
		} | rowlist SEMICOLON row {
			MatrixTerm rows = (MatrixTerm)$1;
			rows.addAsRow( (MatrixTerm)$3 );
		};

row: term {
		List<dLStructure> row = new ArrayList<>();
		row.add( (Term)$1 );
		$$ = new MatrixTerm( 1, row.size(), row);
	}
	| row COMMA term {
		MatrixTerm rowMatrix = (MatrixTerm)$1;
		MatrixTerm elementMatrix = new MatrixTerm(1, 1);
		elementMatrix.setElement(1, 1, (Term)$3);
		rowMatrix.addAsColumn( elementMatrix );
		$$ = rowMatrix; 
	};

/*============================================================*/

%%




