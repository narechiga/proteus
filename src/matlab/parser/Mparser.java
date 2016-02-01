/* A Bison parser, made by GNU Bison 3.0.4.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

package matlab.parser;
/* First part of user declarations.  */
/* "Mparser.y":2  */ /* lalr1.java:91  */

	import java.util.*;
	import dl.syntax.*;
	import dl.semantics.*;
	import matlab.syntax.*;

	@SuppressWarnings({"unchecked"})

/* "Mparser.java":45  */ /* lalr1.java:91  */

/* "Mparser.java":47  */ /* lalr1.java:92  */

/**
 * A Bison parser, automatically generated from <tt>Mparser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Mparser extends AbstractMatlabParser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.0.4";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Mparser</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int NUMBER = 258;
    /** Token number,to be returned by the scanner.  */
    static final int IDENTIFIER = 259;
    /** Token number,to be returned by the scanner.  */
    static final int PLUS = 260;
    /** Token number,to be returned by the scanner.  */
    static final int MINUS = 261;
    /** Token number,to be returned by the scanner.  */
    static final int MULTIPLY = 262;
    /** Token number,to be returned by the scanner.  */
    static final int DIVIDE = 263;
    /** Token number,to be returned by the scanner.  */
    static final int POWER = 264;
    /** Token number,to be returned by the scanner.  */
    static final int INEQUALITY = 265;
    /** Token number,to be returned by the scanner.  */
    static final int EQUALS = 266;
    /** Token number,to be returned by the scanner.  */
    static final int LPAREN = 267;
    /** Token number,to be returned by the scanner.  */
    static final int RPAREN = 268;
    /** Token number,to be returned by the scanner.  */
    static final int SEMICOLON = 269;
    /** Token number,to be returned by the scanner.  */
    static final int COMMA = 270;
    /** Token number,to be returned by the scanner.  */
    static final int AND = 271;
    /** Token number,to be returned by the scanner.  */
    static final int OR = 272;
    /** Token number,to be returned by the scanner.  */
    static final int NOT = 273;
    /** Token number,to be returned by the scanner.  */
    static final int TRUE = 274;
    /** Token number,to be returned by the scanner.  */
    static final int FALSE = 275;
    /** Token number,to be returned by the scanner.  */
    static final int ELSEIF = 276;
    /** Token number,to be returned by the scanner.  */
    static final int END = 277;
    /** Token number,to be returned by the scanner.  */
    static final int ASSIGN = 278;
    /** Token number,to be returned by the scanner.  */
    static final int NEGATIVE = 279;
    /** Token number,to be returned by the scanner.  */
    static final int ELSE = 280;
    /** Token number,to be returned by the scanner.  */
    static final int IF = 281;


    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param msg The string for the error message.
     */
     void yyerror (String msg);
  }

  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;
  
  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Mparser (Lexer yylexer) 
  {
    
    this.yylexer = yylexer;
    
  }

  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * Return the <tt>PrintStream</tt> on which the debugging output is
   * printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror (String msg)
  {
    yylexer.yyerror (msg);
  }


  protected final void yycdebug (String s) {
    if (yydebug > 0)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value                            ) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (num > 0) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out)
    {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Return whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yy_lr_goto_state_ (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - yyntokens_] + yystate;
    if (0 <= yyr && yyr <= yylast_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - yyntokens_];
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    Object yyval;
    

    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    if (yylen > 0)
      yyval = yystack.valueAt (yylen - 1);
    else
      yyval = yystack.valueAt (0);

    yy_reduce_print (yyn, yystack);

    switch (yyn)
      {
          case 2:
  if (yyn == 2)
    /* "Mparser.y":67  */ /* lalr1.java:489  */
    {
//	AbstractMatlabParser parsedProgram = new AbstractMatlabParser();
		try{
			yyval = ((yystack.valueAt (1-(1)))); 
			this.parsedProgram = (MatlabProgram)yyval;
			System.out.println();
			System.out.println("Exiting matlabprogram block from Mparser...");
		}catch ( Exception e){
			System.err.println("Error in matlabfunction block");
			System.err.println( e );
		}
	
	};
  break;
    

  case 3:
  if (yyn == 3)
    /* "Mparser.y":90  */ /* lalr1.java:489  */
    {
		try{
			
			yyval = new MatlabProgram((Statement)((yystack.valueAt (1-(1)))));
			this.parsedProgram = (MatlabProgram)yyval;
			}catch( Exception e ){
			System.out.println("Exception in matlabprogram:statement SEMICOLON");
			System.err.println( e );
		}		
	};
  break;
    

  case 4:
  if (yyn == 4)
    /* "Mparser.y":108  */ /* lalr1.java:489  */
    {
		try{
			yyval = new MatlabProgram( (MatlabProgram)((yystack.valueAt (2-(1)))), (Statement)((yystack.valueAt (2-(2)))));
			}catch ( Exception e){
			System.out.println("Exception in matlabprogram:matlabprogram SEMICOLON statement SEMICOLON");
			System.out.println(e);
		}
	};
  break;
    

  case 5:
  if (yyn == 5)
    /* "Mparser.y":120  */ /* lalr1.java:489  */
    {
		try{
		//System.out.println("in ifstatement block");
			yyval = ((yystack.valueAt (1-(1))));		 
			}catch ( Exception e){
			System.out.println("Exception in statement:ifstatement");
			System.out.println( e );
		}
	};
  break;
    

  case 6:
  if (yyn == 6)
    /* "Mparser.y":129  */ /* lalr1.java:489  */
    {
		try{
			//System.out.println("in Assignment..........");
			yyval = (AssignmentStatement)((yystack.valueAt (1-(1))));
			}catch ( Exception e){
			System.out.println("Exception in statement:assignment");
			System.out.println( e );
		}
	};
  break;
    

  case 7:
  if (yyn == 7)
    /* "Mparser.y":141  */ /* lalr1.java:489  */
    {
		try{
			
			System.out.println("\nIF logicalformula matlabprogram END");
			yyval = new IfStatement( (dLFormula)((yystack.valueAt (4-(2)))), (MatlabProgram)((yystack.valueAt (4-(3)))) );		    
		}catch( Exception e){
 			System.out.println("Exception in ifstatement:IF logicalformula matlabprogram END");
			System.err.println( e );
		}
	};
  break;
    

  case 8:
  if (yyn == 8)
    /* "Mparser.y":151  */ /* lalr1.java:489  */
    {
		try{
			IfStatement is = new IfStatement( (dLFormula)((yystack.valueAt (6-(2)))), (MatlabProgram)((yystack.valueAt (6-(3)))) );
			is.appendCase( new TrueFormula(), (MatlabProgram)((yystack.valueAt (6-(5)))) );
			yyval = is;	    
		}catch( Exception e){
 			System.out.println("Exception in ifstatement:IF logicalformula matlabprogram ELSE matlabprogram END");
			System.err.println( e );
		}
	};
  break;
    

  case 9:
  if (yyn == 9)
    /* "Mparser.y":161  */ /* lalr1.java:489  */
    {
		try{
			IfStatement is = (IfStatement)((yystack.valueAt (5-(4))));
			is.prependCase( (dLFormula)((yystack.valueAt (5-(2)))), (MatlabProgram)((yystack.valueAt (5-(3)))) );
			yyval = is;
		}catch( Exception e){
 			System.out.println("Exception in ifstatement:IF logicalformula matlabprogram elselist END");
			System.err.println( e );
		}
	};
  break;
    

  case 10:
  if (yyn == 10)
    /* "Mparser.y":171  */ /* lalr1.java:489  */
    {
		try{
			IfStatement is = (IfStatement)((yystack.valueAt (7-(4))));
			is.prependCase( (dLFormula)((yystack.valueAt (7-(2)))), (MatlabProgram)((yystack.valueAt (7-(3)))) );
			is.appendCase( new TrueFormula(), (MatlabProgram)((yystack.valueAt (7-(6)))) );
			yyval = is;
		}catch( Exception e){
 			System.out.println("Exception in ifstatement:IF logicalformula matlabprogram elselist ELSE matlabprogram END");
			System.err.println( e );
		}
	};
  break;
    

  case 11:
  if (yyn == 11)
    /* "Mparser.y":185  */ /* lalr1.java:489  */
    {
		try{
			yyval = new IfStatement( (dLFormula)((yystack.valueAt (3-(2)))), (MatlabProgram)((yystack.valueAt (3-(3)))) );		    
		}catch( Exception e){
 			System.out.println("Exception in elselist:ELSEIF logicalformula matlabprogram");
			System.err.println( e );
		}
	};
  break;
    

  case 12:
  if (yyn == 12)
    /* "Mparser.y":193  */ /* lalr1.java:489  */
    {
		try{
			IfStatement is = (IfStatement)((yystack.valueAt (4-(1))));
			is.appendCase( (dLFormula)((yystack.valueAt (4-(3)))), (MatlabProgram)((yystack.valueAt (4-(4)))) );
			yyval = is;
		}catch( Exception e){
 			System.out.println("Exception in elselist:elselist ELSEIF logicalformula matlabprogram");
			System.err.println( e );
		}
		
	};
  break;
    

  case 13:
  if (yyn == 13)
    /* "Mparser.y":207  */ /* lalr1.java:489  */
    {
 		try{
 			yyval = new AssignmentStatement( (Term)((yystack.valueAt (4-(1)))), (Term)((yystack.valueAt (4-(3)))) );
 			System.out.println("\nterm Assignment term SEMICOLON:"+((AssignmentStatement)yyval).toString());
 			}catch ( Exception e ) {
			System.err.println("Exception at location comparison:term ASSIGN term");
			System.err.println( e );
		}
 	};
  break;
    

  case 14:
  if (yyn == 14)
    /* "Mparser.y":219  */ /* lalr1.java:489  */
    {
		//System.out.println("Comparision:");
		yyval = (ComparisonFormula)((yystack.valueAt (1-(1)))); };
  break;
    

  case 15:
  if (yyn == 15)
    /* "Mparser.y":222  */ /* lalr1.java:489  */
    { 
		//System.out.println("logicalformula:");
		yyval = (dLFormula)((yystack.valueAt (3-(2)))); };
  break;
    

  case 16:
  if (yyn == 16)
    /* "Mparser.y":225  */ /* lalr1.java:489  */
    {System.out.println("logicalformula AND:");yyval = new AndFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3))))); };
  break;
    

  case 17:
  if (yyn == 17)
    /* "Mparser.y":226  */ /* lalr1.java:489  */
    {yyval = new OrFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3))))); };
  break;
    

  case 18:
  if (yyn == 18)
    /* "Mparser.y":227  */ /* lalr1.java:489  */
    {yyval = new NotFormula( (dLFormula)((yystack.valueAt (2-(2)))));};
  break;
    

  case 19:
  if (yyn == 19)
    /* "Mparser.y":231  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ComparisonFormula( new Operator( (String)((yystack.valueAt (3-(2)))), 2, true ), (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) ) ;
			System.out.println("\nterm INEQUALITY term"+yyval.toString()+((dLStructure)yyval).todRealString());
			//System.out.println("LOGICALFORMULA-----"+((ComparisonFormula)$$).toMathematicaString());
			//System.out.println("lhs-----"+((ComparisonFormula)$$).getLHS());
			//System.out.println("rhs-----"+((ComparisonFormula)$$).getRHS());
		//	System.out.println("getInequality-----"+((ComparisonFormula)$$).getInequality().toMathematicaString());
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term INEQUALITY term");
			System.err.println( e );
		}
	};
  break;
    

  case 20:
  if (yyn == 20)
    /* "Mparser.y":244  */ /* lalr1.java:489  */
    {
		try {
			yyval = new ComparisonFormula( new Operator( (String)((yystack.valueAt (3-(2)))), 2, true ), (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) ) ;
		//	System.out.println("lhs-----"+((ComparisonFormula)$$).getLHS()+"rhs-----"+((ComparisonFormula)$$).getRHS());
		//	System.out.println("getInequality-----"+((ComparisonFormula)$$).getInequality().toMathematicaString());
			
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term EQUALS term");
			System.err.println( e );
		}
	};
  break;
    

  case 21:
  if (yyn == 21)
    /* "Mparser.y":258  */ /* lalr1.java:489  */
    { 
		try { yyval = new Real( (String)((yystack.valueAt (1-(1)))) ); } catch ( Exception e ) { System.err.println("Exception at location term:NUMBER");
			System.err.println( e );
		}
	};
  break;
    

  case 22:
  if (yyn == 22)
    /* "Mparser.y":275  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new RealVariable( (String)((yystack.valueAt (1-(1)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER");
			System.err.println( e );
		}
	};
  break;
    

  case 23:
  if (yyn == 23)
    /* "Mparser.y":283  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (Term)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location term:LPAREN term RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 24:
  if (yyn == 24)
    /* "Mparser.y":291  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("+", 2, true), args );
			yyval = new AdditionTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term PLUS term");
			System.err.println( e );
		}
	};
  break;
    

  case 25:
  if (yyn == 25)
    /* "Mparser.y":303  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("-", 2, true), args );
			yyval = new SubtractionTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term MINUS term");
			System.err.println( e );
		}
	};
  break;
    

  case 26:
  if (yyn == 26)
    /* "Mparser.y":315  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("/", 2, true), args );
			yyval = new MultiplicationTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term MULTIPY term");
			System.err.println( e );
		}
	};
  break;
    

  case 27:
  if (yyn == 27)
    /* "Mparser.y":328  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("/", 2, true), args );
			yyval = new DivisionTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term DIVIDE term");
			System.err.println( e );
		}
	};
  break;
    

  case 28:
  if (yyn == 28)
    /* "Mparser.y":340  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("^", 2, true), args );
			yyval = new PowerTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term POWER tterm:term POWER term");
			System.err.println( e );
		}
	};
  break;
    

  case 29:
  if (yyn == 29)
    /* "Mparser.y":352  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( new Real( "0" ) );
			//args.add( (Term)$2 );
			//$$ = new Term( new Operator("-", 2, true), args );
			//$$ = new NegativeTerm( (Term)$2 );
			yyval = new SubtractionTerm( new Real(0), (Term)((yystack.valueAt (2-(2)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:MINUS term");
			System.err.println( e );
		}
	};
  break;
    


/* "Mparser.java":774  */ /* lalr1.java:489  */
        default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval);

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    int yystate = yy_lr_goto_state_ (yystack.stateAt (0), yyr1_[yyn]);
    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }



  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yy_symbol_print (String s, int yytype,
                                 Object yyvaluep                                 )
  {
    if (yydebug > 0)
    yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
              + yytname_[yytype] + " ("
              + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
  }


  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
   public boolean parse () throws java.io.IOException

  {
    


    /* Lookahead and lookahead in internal form.  */
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yycdebug ("Starting parse\n");
    yyerrstatus_ = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval );



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate + "\n");
        if (yydebug > 0)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yy_pact_value_is_default_ (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {


            yycdebug ("Reading a token: ");
            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal ();

          }

        /* Convert token to internal form.  */
        if (yychar <= Lexer.EOF)
          {
            yychar = yytoken = Lexer.EOF;
            yycdebug ("Now at end of input.\n");
          }
        else
          {
            yytoken = yytranslate_ (yychar);
            yy_symbol_print ("Next token is", yytoken,
                             yylval);
          }

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
            if (yy_table_value_is_error_ (yyn))
              label = YYERRLAB;
            else
              {
                yyn = -yyn;
                label = YYREDUCE;
              }
          }

        else
          {
            /* Shift the lookahead token.  */
            yy_symbol_print ("Shifting", yytoken,
                             yylval);

            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yysyntax_error (yystate, yytoken));
          }

        
        if (yyerrstatus_ == 3)
          {
        /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

        if (yychar <= Lexer.EOF)
          {
          /* Return failure if at end of input.  */
          if (yychar == Lexer.EOF)
            return false;
          }
        else
            yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:

        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yy_pact_value_is_default_ (yyn))
              {
                yyn += yyterror_;
                if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;

            
            yystack.pop ();
            yystate = yystack.stateAt (0);
            if (yydebug > 0)
              yystack.print (yyDebugStream);
          }

        if (label == YYABORT)
            /* Leave the switch.  */
            break;



        /* Shift the error token.  */
        yy_symbol_print ("Shifting", yystos_[yyn],
                         yylval);

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yy_pact_value_is_default_ (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yy_table_value_is_error_ (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -16;
  private static final byte yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short yypact_[] = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
      82,   -16,   -16,   121,   121,   100,    18,    82,   -16,   -16,
     -16,    93,   -16,   138,   100,   100,    56,   -16,   147,   -16,
     -16,   121,   121,   121,   121,   121,   121,   -16,    48,   129,
     -16,   100,   100,    45,   121,   121,     7,     7,    -4,    -4,
      -4,   114,   -16,    20,    20,   100,   -16,    82,   -15,   154,
     154,   -16,    56,     5,   100,   -16,    82,    82,   -16,    56,
      71,    82,   -16
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte yydefact_[] = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       0,    21,    22,     0,     0,     0,     0,     2,     3,     5,
       6,     0,    29,     0,     0,     0,     0,    14,     0,     1,
       4,     0,     0,     0,     0,     0,     0,    23,     0,     0,
      18,     0,     0,     0,     0,     0,    24,    25,    26,    27,
      28,     0,    15,    16,    17,     0,     7,     0,     0,    19,
      20,    13,     0,     0,     0,     9,     0,    11,     8,     0,
       0,    12,    10
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte yypgoto_[] = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -16,   -16,   -12,    -7,   -16,   -16,   -16,    24,   -16,    -2
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte yydefgoto_[] = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
      -1,     6,     7,     8,     9,    48,    10,    16,    17,    11
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte yytable_[] = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
      20,    12,    13,    18,    33,    25,    54,    55,     1,     2,
      56,     3,    29,    18,    23,    24,    25,     4,    19,    36,
      37,    38,    39,    40,    41,     0,    20,    58,     0,    18,
      18,     5,    49,    50,     0,    53,    31,    32,    28,    30,
      57,     0,     0,    18,    60,     0,    20,    61,     1,     2,
      20,     3,    18,    20,    20,    43,    44,     4,     0,     1,
       2,    42,     3,     0,    31,    32,    45,    46,     4,    52,
      47,     5,    31,    32,     1,     2,     0,     3,    59,     0,
       0,     0,     5,     4,     0,     1,     2,     0,     3,     0,
       0,     0,     0,    62,     4,     0,     0,     5,    21,    22,
      23,    24,    25,     1,     2,     0,     3,     0,     5,     0,
       0,     0,    14,     0,     0,     0,    26,     0,    15,    21,
      22,    23,    24,    25,     1,     2,     0,     3,    51,     0,
       0,     0,     0,     4,    21,    22,    23,    24,    25,    34,
      35,     0,    27,    21,    22,    23,    24,    25,     0,     0,
       0,    27,    21,    22,    23,    24,    25,    34,    35,    21,
      22,    23,    24,    25
    };
  }

private static final byte yycheck_[] = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       7,     3,     4,     5,    16,     9,    21,    22,     3,     4,
      25,     6,    14,    15,     7,     8,     9,    12,     0,    21,
      22,    23,    24,    25,    26,    -1,    33,    22,    -1,    31,
      32,    26,    34,    35,    -1,    47,    16,    17,    14,    15,
      52,    -1,    -1,    45,    56,    -1,    53,    59,     3,     4,
      57,     6,    54,    60,    61,    31,    32,    12,    -1,     3,
       4,    13,     6,    -1,    16,    17,    21,    22,    12,    45,
      25,    26,    16,    17,     3,     4,    -1,     6,    54,    -1,
      -1,    -1,    26,    12,    -1,     3,     4,    -1,     6,    -1,
      -1,    -1,    -1,    22,    12,    -1,    -1,    26,     5,     6,
       7,     8,     9,     3,     4,    -1,     6,    -1,    26,    -1,
      -1,    -1,    12,    -1,    -1,    -1,    23,    -1,    18,     5,
       6,     7,     8,     9,     3,     4,    -1,     6,    14,    -1,
      -1,    -1,    -1,    12,     5,     6,     7,     8,     9,    10,
      11,    -1,    13,     5,     6,     7,     8,     9,    -1,    -1,
      -1,    13,     5,     6,     7,     8,     9,    10,    11,     5,
       6,     7,     8,     9
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,     6,    12,    26,    28,    29,    30,    31,
      33,    36,    36,    36,    12,    18,    34,    35,    36,     0,
      30,     5,     6,     7,     8,     9,    23,    13,    34,    36,
      34,    16,    17,    29,    10,    11,    36,    36,    36,    36,
      36,    36,    13,    34,    34,    21,    22,    25,    32,    36,
      36,    14,    34,    29,    21,    22,    25,    29,    22,    34,
      29,    29,    22
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    27,    28,    29,    29,    30,    30,    31,    31,    31,
      31,    32,    32,    33,    34,    34,    34,    34,    34,    35,
      35,    36,    36,    36,    36,    36,    36,    36,    36,    36
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     1,     2,     1,     1,     4,     6,     5,
       7,     3,     4,     4,     1,     3,     3,     3,     2,     3,
       3,     1,     1,     3,     3,     3,     3,     3,     3,     2
    };
  }

  /* YYTOKEN_NUMBER[YYLEX-NUM] -- Internal symbol number corresponding
      to YYLEX-NUM.  */
  private static final short yytoken_number_[] = yytoken_number_init();
  private static final short[] yytoken_number_init()
  {
    return new short[]
    {
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281
    };
  }

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "NUMBER", "IDENTIFIER", "PLUS", "MINUS",
  "MULTIPLY", "DIVIDE", "POWER", "INEQUALITY", "EQUALS", "LPAREN",
  "RPAREN", "SEMICOLON", "COMMA", "AND", "OR", "NOT", "TRUE", "FALSE",
  "ELSEIF", "END", "ASSIGN", "NEGATIVE", "ELSE", "IF", "$accept", "input",
  "matlabprogram", "statement", "ifstatement", "elselist", "assignment",
  "logicalformula", "comparison", "term", null
    };
  }

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,    67,    67,    90,   108,   120,   129,   141,   151,   161,
     171,   185,   193,   207,   219,   222,   225,   226,   227,   231,
     244,   258,   275,   283,   291,   303,   315,   328,   340,   352
    };
  }


  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yy_reduce_print (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
              + " (line " + yylno + "), ");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yy_symbol_print ("   $" + (yyi + 1) + " =",
                       yystos_[yystack.stateAt(yynrhs - (yyi + 1))],
                       ((yystack.valueAt (yynrhs-(yyi + 1)))));
  }

  /* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX.  */
  private static final byte yytranslate_table_[] = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26
    };
  }

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 163;
  private static final int yynnts_ = 10;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 19;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 27;

  private static final int yyuser_token_number_max_ = 281;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */

}

/* "Mparser.y":373  */ /* lalr1.java:1070  */





