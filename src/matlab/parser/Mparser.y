
%{
	import java.util.*;
	import dl.syntax.*;
	import dl.semantics.*;
	import matlab.syntax.*;

	@SuppressWarnings({"unchecked"})
%}

%language "Java"
%define package matlab.parser
%define extends {AbstractMatlabParser}
%define parser_class_name {Mparser}
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
//	AbstractMatlabParser parsedProgram = new AbstractMatlabParser();
		try{
			$$ = $1; 
			this.parsedProgram = (MatlabProgram)$$;
			System.out.println();
			System.out.println("Exiting matlabprogram block from Mparser...");
		}catch ( Exception e){
			System.err.println("Error in matlabfunction block");
			System.err.println( e );
		}
	
	}
	
;





/*==================== Matlab Function Block ====================*/

matlabprogram:
	 statement{
		try{
			
			$$ = new MatlabProgram((Statement)$1);
			this.parsedProgram = (MatlabProgram)$$;
			}catch( Exception e ){
			System.out.println("Exception in matlabprogram:statement SEMICOLON");
			System.err.println( e );
		}		
	}
//	| statement SEMICOLON statement SEMICOLON{
//		try{
//			$$ = new MatlabProgram((Statement)$1,(Statement)$2);
//			 }catch( Exception e){
//			System.out.println("Exception in matlabprogram:statement statement");
//			System.out.println(e);
//		}	
//	}
	| matlabprogram statement{
		try{
			$$ = new MatlabProgram( (MatlabProgram)$1, (Statement)$2);
			}catch ( Exception e){
			System.out.println("Exception in matlabprogram:matlabprogram SEMICOLON statement SEMICOLON");
			System.out.println(e);
		}
	}
	
	
;
statement:
	ifstatement{
		try{
		//System.out.println("in ifstatement block");
			$$ = $1;		 
			}catch ( Exception e){
			System.out.println("Exception in statement:ifstatement");
			System.out.println( e );
		}
	}
	|assignment {
		try{
			//System.out.println("in Assignment..........");
			$$ = (AssignmentStatement)$1;
			}catch ( Exception e){
			System.out.println("Exception in statement:assignment");
			System.out.println( e );
		}
	}
;

ifstatement:
	IF logicalformula matlabprogram END {
		try{
			
			System.out.println("\nIF logicalformula matlabprogram END");
			$$ = new IfStatement( (dLFormula)$2, (MatlabProgram)$3 );		    
		}catch( Exception e){
 			System.out.println("Exception in ifstatement:IF logicalformula matlabprogram END");
			System.err.println( e );
		}
	}
	|IF logicalformula matlabprogram ELSE matlabprogram END {
		try{
			IfStatement is = new IfStatement( (dLFormula)$2, (MatlabProgram)$3 );
			is.appendCase( new TrueFormula(), (AssignmentStatement)$5 );
			$$ = is;	    
		}catch( Exception e){
 			System.out.println("Exception in ifstatement:IF logicalformula matlabprogram ELSE matlabprogram END");
			System.err.println( e );
		}
	}
	| IF logicalformula matlabprogram elselist END {
		try{
			IfStatement is = (IfStatement)$4;
			is.prependCase( (dLFormula)$2, (MatlabProgram)$3 );
			$$ = is;
		}catch( Exception e){
 			System.out.println("Exception in ifstatement:IF logicalformula matlabprogram elselist END");
			System.err.println( e );
		}
	}
	| IF logicalformula matlabprogram elselist ELSE matlabprogram END {
		try{
			IfStatement is = (IfStatement)$4;
			is.prependCase( (dLFormula)$2, (MatlabProgram)$3 );
			is.appendCase( new TrueFormula(), (MatlabProgram)$6 );
			$$ = is;
		}catch( Exception e){
 			System.out.println("Exception in ifstatement:IF logicalformula matlabprogram elselist ELSE matlabprogram END");
			System.err.println( e );
		}
	}
;

elselist:
	ELSEIF logicalformula matlabprogram {
		try{
			$$ = new IfStatement( (dLFormula)$2, (MatlabProgram)$3 );		    
		}catch( Exception e){
 			System.out.println("Exception in elselist:ELSEIF logicalformula matlabprogram");
			System.err.println( e );
		}
	}
	| elselist ELSEIF logicalformula matlabprogram {
		try{
			IfStatement is = (IfStatement)$1;
			is.appendCase( (dLFormula)$3, (MatlabProgram)$4 );
			$$ = is;
		}catch( Exception e){
 			System.out.println("Exception in elselist:elselist ELSEIF logicalformula matlabprogram");
			System.err.println( e );
		}
		
	}
;

assignment:
 	term ASSIGN term SEMICOLON{
 		try{
 			$$ = new AssignmentStatement( (Term)$1, (Term)$3 );
 			System.out.println("\nterm Assignment term SEMICOLON:"+((AssignmentStatement)$$).toString());
 			}catch ( Exception e ) {
			System.err.println("Exception at location comparison:term ASSIGN term");
			System.err.println( e );
		}
 	}
 ;

logicalformula:
	comparison {
		//System.out.println("Comparision:");
		$$ = (ComparisonFormula)$1; }
	| LPAREN logicalformula RPAREN { 
		//System.out.println("logicalformula:");
		$$ = (dLFormula)$2; }
	| logicalformula AND logicalformula {System.out.println("logicalformula AND:");$$ = new AndFormula( (dLFormula)$1, (dLFormula)$3); }
	| logicalformula OR logicalformula {$$ = new OrFormula( (dLFormula)$1, (dLFormula)$3); }
	| NOT logicalformula {$$ = new NotFormula( (dLFormula)$2);}
;

comparison:
	term INEQUALITY term { 
		try {
			$$ = new ComparisonFormula( new Operator( (String)$2, 2, true ), (Term)$1, (Term)$3 ) ;
			System.out.println("\nterm INEQUALITY term"+$$.toString()+((dLStructure)$$).todRealString());
			//System.out.println("LOGICALFORMULA-----"+((ComparisonFormula)$$).toMathematicaString());
			//System.out.println("lhs-----"+((ComparisonFormula)$$).getLHS());
			//System.out.println("rhs-----"+((ComparisonFormula)$$).getRHS());
		//	System.out.println("getInequality-----"+((ComparisonFormula)$$).getInequality().toMathematicaString());
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term INEQUALITY term");
			System.err.println( e );
		}
	}
	| term EQUALS term {
		try {
			$$ = new ComparisonFormula( new Operator( (String)$2, 2, true ), (Term)$1, (Term)$3 ) ;
		//	System.out.println("lhs-----"+((ComparisonFormula)$$).getLHS()+"rhs-----"+((ComparisonFormula)$$).getRHS());
		//	System.out.println("getInequality-----"+((ComparisonFormula)$$).getInequality().toMathematicaString());
			
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
	//|  LPAREN term RPAREN 



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
;





/*============================================================*/

%%




