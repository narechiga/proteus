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

package dl.parser;
/* First part of user declarations.  */
/* "dLParser.y":2  */ /* lalr1.java:91  */

	import java.util.*;

import dl.semantics.*;
import dl.syntax.*;

	@SuppressWarnings({"unchecked"})

/* "dLParser.java":44  */ /* lalr1.java:91  */

/* "dLParser.java":46  */ /* lalr1.java:92  */

/**
 * A Bison parser, automatically generated from <tt>dLParser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class dLParser extends AbstractdLParser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.0.4";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>dLParser</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int ASTERISK = 258;
    /** Token number,to be returned by the scanner.  */
    static final int EXTERNAL = 259;
    /** Token number,to be returned by the scanner.  */
    static final int FUNCTIONS = 260;
    /** Token number,to be returned by the scanner.  */
    static final int RULES = 261;
    /** Token number,to be returned by the scanner.  */
    static final int SCHEMAVARIABLES = 262;
    /** Token number,to be returned by the scanner.  */
    static final int SCHEMATEXT = 263;
    /** Token number,to be returned by the scanner.  */
    static final int PROBLEM = 264;
    /** Token number,to be returned by the scanner.  */
    static final int ANNOTATION = 265;
    /** Token number,to be returned by the scanner.  */
    static final int BOUNDS = 266;
    /** Token number,to be returned by the scanner.  */
    static final int STATEVARIABLES = 267;
    /** Token number,to be returned by the scanner.  */
    static final int INITIALSET = 268;
    /** Token number,to be returned by the scanner.  */
    static final int SAFESET = 269;
    /** Token number,to be returned by the scanner.  */
    static final int EIPARAMETERS = 270;
    /** Token number,to be returned by the scanner.  */
    static final int ENVELOPE = 271;
    /** Token number,to be returned by the scanner.  */
    static final int INVARIANT = 272;
    /** Token number,to be returned by the scanner.  */
    static final int CONTROLLAW = 273;
    /** Token number,to be returned by the scanner.  */
    static final int CONTROLPARAMETERS = 274;
    /** Token number,to be returned by the scanner.  */
    static final int CONTROLTEMPLATE = 275;
    /** Token number,to be returned by the scanner.  */
    static final int OBJECTIVEFUNCTION = 276;
    /** Token number,to be returned by the scanner.  */
    static final int SETTINGS = 277;
    /** Token number,to be returned by the scanner.  */
    static final int ASSIGN = 278;
    /** Token number,to be returned by the scanner.  */
    static final int PRIME = 279;
    /** Token number,to be returned by the scanner.  */
    static final int OPENBRACE = 280;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEBRACE = 281;
    /** Token number,to be returned by the scanner.  */
    static final int EQUALS = 282;
    /** Token number,to be returned by the scanner.  */
    static final int TEST = 283;
    /** Token number,to be returned by the scanner.  */
    static final int CUP = 284;
    /** Token number,to be returned by the scanner.  */
    static final int REALDECLARATION = 285;
    /** Token number,to be returned by the scanner.  */
    static final int KLEENESTAR = 286;
    /** Token number,to be returned by the scanner.  */
    static final int SEMICOLON = 287;
    /** Token number,to be returned by the scanner.  */
    static final int RANDOM = 288;
    /** Token number,to be returned by the scanner.  */
    static final int OPENBOX = 289;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEBOX = 290;
    /** Token number,to be returned by the scanner.  */
    static final int OPENDIAMOND = 291;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEDIAMOND = 292;
    /** Token number,to be returned by the scanner.  */
    static final int NUMBER = 293;
    /** Token number,to be returned by the scanner.  */
    static final int IDENTIFIER = 294;
    /** Token number,to be returned by the scanner.  */
    static final int PLUS = 295;
    /** Token number,to be returned by the scanner.  */
    static final int MINUS = 296;
    /** Token number,to be returned by the scanner.  */
    static final int DIVIDE = 297;
    /** Token number,to be returned by the scanner.  */
    static final int POWER = 298;
    /** Token number,to be returned by the scanner.  */
    static final int NEWLINE = 299;
    /** Token number,to be returned by the scanner.  */
    static final int INEQUALITY = 300;
    /** Token number,to be returned by the scanner.  */
    static final int LPAREN = 301;
    /** Token number,to be returned by the scanner.  */
    static final int RPAREN = 302;
    /** Token number,to be returned by the scanner.  */
    static final int COMMA = 303;
    /** Token number,to be returned by the scanner.  */
    static final int AND = 304;
    /** Token number,to be returned by the scanner.  */
    static final int OR = 305;
    /** Token number,to be returned by the scanner.  */
    static final int NOT = 306;
    /** Token number,to be returned by the scanner.  */
    static final int IMPLIES = 307;
    /** Token number,to be returned by the scanner.  */
    static final int IFF = 308;
    /** Token number,to be returned by the scanner.  */
    static final int FORALL = 309;
    /** Token number,to be returned by the scanner.  */
    static final int EXISTS = 310;
    /** Token number,to be returned by the scanner.  */
    static final int TRUE = 311;
    /** Token number,to be returned by the scanner.  */
    static final int FALSE = 312;
    /** Token number,to be returned by the scanner.  */
    static final int QUANTIFIER = 313;
    /** Token number,to be returned by the scanner.  */
    static final int MULTIPLY = 314;
    /** Token number,to be returned by the scanner.  */
    static final int NEGATIVE = 315;


    

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
  public dLParser (Lexer yylexer) 
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
    /* "dLParser.y":129  */ /* lalr1.java:489  */
    {
		try {
			yyval = (String)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location input:valuation");
			System.err.println( e );
		}
	};
  break;
    

  case 3:
  if (yyn == 3)
    /* "dLParser.y":137  */ /* lalr1.java:489  */
    {
		try {
			parsedStructure = (dLFormula)((yystack.valueAt (4-(1)))); // valuation has already been handled
			yyval = (String)((yystack.valueAt (4-(3)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula OPENBRACE valuation CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 4:
  if (yyn == 4)
    /* "dLParser.y":146  */ /* lalr1.java:489  */
    {
		try {
			parsedStructure = (HybridProgram)((yystack.valueAt (4-(1)))); // valuation has already been handled
			yyval = (String)((yystack.valueAt (4-(3)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula OPENBRACE valuation CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 5:
  if (yyn == 5)
    /* "dLParser.y":155  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("full block"); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:keymaerablock");
			System.err.println( e );
		}
	};
  break;
    

  case 6:
  if (yyn == 6)
    /* "dLParser.y":163  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("function block");
		} catch ( Exception e ) {
			System.err.println("Exception at location input:funblock");
			System.err.println( e );
		}
	};
  break;
    

  case 7:
  if (yyn == 7)
    /* "dLParser.y":171  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("variable declaration block");
		} catch ( Exception e ) {
			System.err.println("Exception at location input:varblock");
			System.err.println( e );
		}
	};
  break;
    

  case 8:
  if (yyn == 8)
    /* "dLParser.y":179  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("schema variables block"); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:schemavarsblock");
			System.err.println( e );
		}
			
	};
  break;
    

  case 9:
  if (yyn == 9)
    /* "dLParser.y":188  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("rules block"); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:rulesblock");
			System.err.println( e );
		}
	};
  break;
    

  case 10:
  if (yyn == 10)
    /* "dLParser.y":196  */ /* lalr1.java:489  */
    { 
		try {
			//System.out.println("Found: dLformula"); 
			parsedStructure = (dLFormula)((yystack.valueAt (1-(1))));	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 11:
  if (yyn == 11)
    /* "dLParser.y":205  */ /* lalr1.java:489  */
    {
		try {
			yyval = "hybrid program"; 
			parsedStructure = (HybridProgram)((yystack.valueAt (1-(1))));	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:hybridprogram");
			System.err.println( e );
		}
	};
  break;
    

  case 12:
  if (yyn == 12)
    /* "dLParser.y":214  */ /* lalr1.java:489  */
    {
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); System.out.println("annotation block"); //System.out.println($$); 
		} catch ( Exception e ) {
			System.err.println("Exception at location input:annotationblock");
			System.err.println( e );
		}
	};
  break;
    

  case 13:
  if (yyn == 13)
    /* "dLParser.y":222  */ /* lalr1.java:489  */
    {
		try {
			yyval = ((Term)((yystack.valueAt (1-(1))))).toKeYmaeraString();
			parsedStructure = (Term)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location input:term");
			System.err.println( e );
		}
	};
  break;
    

  case 14:
  if (yyn == 14)
    /* "dLParser.y":231  */ /* lalr1.java:489  */
    {
		try {
			yyval = "Sucessfully parsed EITool input file";	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:eitoolblock");
			System.err.println( e );
		}
	};
  break;
    

  case 15:
  if (yyn == 15)
    /* "dLParser.y":239  */ /* lalr1.java:489  */
    {
		System.err.println("Parser: I'm confused, throwing error");
		System.out.println( (String)((yystack.valueAt (1-(1)))) );
		//System.exit(1);
	};
  break;
    

  case 16:
  if (yyn == 16)
    /* "dLParser.y":249  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 17:
  if (yyn == 17)
    /* "dLParser.y":257  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (2-(1)))) + (String)((yystack.valueAt (2-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:funblock problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 18:
  if (yyn == 18)
    /* "dLParser.y":265  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (4-(1)))) + (String)((yystack.valueAt (4-(2)))) + (String)((yystack.valueAt (4-(3)))) + (String)((yystack.valueAt (4-(4))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:funblock schemavarsblock rulesblock problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 19:
  if (yyn == 19)
    /* "dLParser.y":273  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (4-(1)))) + (String)((yystack.valueAt (4-(2)))) + (String)((yystack.valueAt (4-(3)))) + (String)((yystack.valueAt (4-(4))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:schemavarsblock rulesblock funblock problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 20:
  if (yyn == 20)
    /* "dLParser.y":281  */ /* lalr1.java:489  */
    { 
		try{
			yyval = (String)((yystack.valueAt (3-(1)))) + (String)((yystack.valueAt (3-(2)))) + (String)((yystack.valueAt (3-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location keymaerablock:schemavarsblock rulesblock problemblock");
			System.err.println( e );
		}
	};
  break;
    

  case 21:
  if (yyn == 21)
    /* "dLParser.y":289  */ /* lalr1.java:489  */
    {
		try{
			yyval = (String)((yystack.valueAt (2-(1)))) + (String)((yystack.valueAt (2-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationblock:keymaerablock");
			System.err.println( e );
		}
	};
  break;
    

  case 22:
  if (yyn == 22)
    /* "dLParser.y":300  */ /* lalr1.java:489  */
    { 
		try {
			parsedStructure = (dLFormula)((yystack.valueAt (4-(3))));
			yyval = "{\n" + ((dLStructure)((yystack.valueAt (4-(3))))).toString() + "\n}"; System.out.println( yyval );
		} catch ( Exception e ) {
			System.err.println("Exception at location problemblock:PROBLEM OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 23:
  if (yyn == 23)
    /* "dLParser.y":309  */ /* lalr1.java:489  */
    { 
		try {
			parsedStructure = (dLFormula)((yystack.valueAt (5-(4))));
			yyval = "{\n" + (String)((yystack.valueAt (5-(3)))) + "\n" + ((dLStructure)((yystack.valueAt (5-(4))))).toString() + "\n}"; System.out.println(yyval);
		} catch ( Exception e ) {
			System.err.println("Exception at location problemblock:PROBLEM OPENBRACE varblock dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 24:
  if (yyn == 24)
    /* "dLParser.y":322  */ /* lalr1.java:489  */
    {
		try {
			synthesis = false;
		} catch ( Exception e ) {
			System.err.println("Exception at location eitoolblock: statevarblock initialsetblock safesetblock eiparameterblock envelopeblock invariantblock robustparameterblock  controllawblock");
			System.err.println( e );
		}
	};
  break;
    

  case 25:
  if (yyn == 25)
    /* "dLParser.y":330  */ /* lalr1.java:489  */
    {
		try {
			synthesis = true;
		} catch ( Exception e ) {
			System.err.println("Exception at location eitoolblock: statevarblock initialsetblock safesetblock eiparameterblock envelopeblock invariantblock controlparameters controltemplateblock objectivefunction");
			System.err.println( e );
		}
	};
  break;
    

  case 26:
  if (yyn == 26)
    /* "dLParser.y":339  */ /* lalr1.java:489  */
    {
		try {
			statevariables = (ArrayList<RealVariable>)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location statevarblock: STATEVARIABLES OPENBRACE varlist CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 27:
  if (yyn == 27)
    /* "dLParser.y":349  */ /* lalr1.java:489  */
    {
		try {
			initialSet = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location invariantblock: INVARIANT OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 28:
  if (yyn == 28)
    /* "dLParser.y":358  */ /* lalr1.java:489  */
    {
		try {
			safeSet = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location invariantblock: INVARIANT OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 29:
  if (yyn == 29)
    /* "dLParser.y":368  */ /* lalr1.java:489  */
    {
		try {
			eiparameterset = (dLFormula)((yystack.valueAt (4-(3))));
			eiparameters = new ArrayList<>();
			eiparameters.addAll(eiparameterset.getFreeVariables());
		} catch ( Exception e ) {
			System.err.println("Exception at location eiparameterblock: EIPARAMETERS OPENBRACE varlist CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 30:
  if (yyn == 30)
    /* "dLParser.y":381  */ /* lalr1.java:489  */
    {
		try {
			envelope = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location envelopeblock: ENVELOPE OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 31:
  if (yyn == 31)
    /* "dLParser.y":391  */ /* lalr1.java:489  */
    {
		try {
			invariant = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location invariantblock: INVARIANT OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 32:
  if (yyn == 32)
    /* "dLParser.y":430  */ /* lalr1.java:489  */
    {
		try {
			control = (HybridProgram)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location controllawblock: CONTROLLAW OPENBRACE hybridprogram CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 33:
  if (yyn == 33)
    /* "dLParser.y":440  */ /* lalr1.java:489  */
    {
		try {
			controlparameters = (dLFormula)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location controltemplateblock: CONTROLTEMPLATE OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 34:
  if (yyn == 34)
    /* "dLParser.y":450  */ /* lalr1.java:489  */
    {
		try {
			control = (HybridProgram)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location controltemplateblock: CONTROLTEMPLATE OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 35:
  if (yyn == 35)
    /* "dLParser.y":460  */ /* lalr1.java:489  */
    {
		try {
			objective = (Term)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location controltemplateblock: CONTROLTEMPLATE OPENBRACE dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 37:
  if (yyn == 37)
    /* "dLParser.y":477  */ /* lalr1.java:489  */
    {
		try {
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}

			this.valuation.put( new RealVariable( (String)((yystack.valueAt (3-(1)))) ), new Real( (String)((yystack.valueAt (3-(3)))) ) );
			yyval = "(valuation " +  (String)((yystack.valueAt (3-(1)))) + "->" + (String)((yystack.valueAt (3-(3)))) + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:IDENTIFIER IMPLIES NUMBER");
			System.err.println( e );
		}
		
	};
  break;
    

  case 38:
  if (yyn == 38)
    /* "dLParser.y":492  */ /* lalr1.java:489  */
    {
		try {
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}

			this.valuation.put( new RealVariable( (String)((yystack.valueAt (4-(1)))) ), new Real( "-" + (String)((yystack.valueAt (4-(4)))) ) );
			yyval = "(valuation " +  (String)((yystack.valueAt (4-(1)))) + "->" + "-" + (String)((yystack.valueAt (4-(3)))) + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:IDENTIFIER IMPLIES MINUS NUMBER");
			System.err.println( e );
		}
		
	};
  break;
    

  case 39:
  if (yyn == 39)
    /* "dLParser.y":507  */ /* lalr1.java:489  */
    {
		try{
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}
			this.valuation.put( new RealVariable( (String)((yystack.valueAt (5-(3)))) ), new Real( (String)((yystack.valueAt (5-(5)))) ) );
			yyval = (String)((yystack.valueAt (5-(1)))) + "\n" + "(valuation " +  (String)((yystack.valueAt (5-(3)))) + "->" + (String)((yystack.valueAt (5-(5)))) + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:valuation COMMA IDENTIFIER IMPLIES NUMBER");
			System.err.println( e );
		}
	};
  break;
    

  case 40:
  if (yyn == 40)
    /* "dLParser.y":519  */ /* lalr1.java:489  */
    {
		try{
			if ( this.valuation == null ) {
				this.valuation = new Valuation();
			}
			this.valuation.put( new RealVariable( (String)((yystack.valueAt (6-(3)))) ), new Real( "-" + (String)((yystack.valueAt (6-(6)))) ) );
			yyval = (String)((yystack.valueAt (6-(1)))) + "\n" + "(valuation " +  (String)((yystack.valueAt (6-(3)))) + "->" + "-" + (String)((yystack.valueAt (6-(5)))) + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location valuation:valuation COMMA IDENTIFIER IMPLIES MINUS NUMBER");
			System.err.println( e );
		}
	};
  break;
    

  case 41:
  if (yyn == 41)
    /* "dLParser.y":537  */ /* lalr1.java:489  */
    {
		try {
			this.annotations = (ArrayList<dLFormula>)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationblock:ANNOTATION OPENBRACE annotationlist CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 42:
  if (yyn == 42)
    /* "dLParser.y":545  */ /* lalr1.java:489  */
    {
		try {
			this.bounds = (dLFormula)((yystack.valueAt (5-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationblock:BOUNDS OPENBRACE dLformula CLOSEBRACE annotationblock");
			System.err.println( e );
		}
	};
  break;
    

  case 43:
  if (yyn == 43)
    /* "dLParser.y":556  */ /* lalr1.java:489  */
    {
		try {
			ArrayList<dLFormula> annot = new ArrayList<dLFormula>();
			annot.add( (dLFormula)((yystack.valueAt (2-(1)))) );
			yyval = annot;
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationlist:dLformula SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 44:
  if (yyn == 44)
    /* "dLParser.y":566  */ /* lalr1.java:489  */
    {
		try {
			ArrayList<dLFormula> annot = new ArrayList<dLFormula>();
			annot.addAll( (ArrayList<dLFormula>)((yystack.valueAt (3-(1)))) );
			annot.add( (dLFormula)((yystack.valueAt (3-(2)))) );
			yyval = annot;
		} catch ( Exception e ) {
			System.err.println("Exception at location annotationlist:annotationlist dLformula SEMICOLON");
			System.err.println( e );
		}

	};
  break;
    

  case 45:
  if (yyn == 45)
    /* "dLParser.y":585  */ /* lalr1.java:489  */
    { 
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			yyval = "(declare-schema-vars: \n" + (String)((yystack.valueAt (4-(3)))) + "\n)"; System.out.println( yyval );
			this.declaredSchemaVariables = (String)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location schemavarsblock:SCHEMAVARIABLES OPENBRACE schematext CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 46:
  if (yyn == 46)
    /* "dLParser.y":600  */ /* lalr1.java:489  */
    { 
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			yyval = "(declare-rules: \n" + (String)((yystack.valueAt (4-(3)))) + "\n)"; System.out.println( yyval );
			this.declaredRules = (String)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location rulesblock:RULES OPENBRACE schematext CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 47:
  if (yyn == 47)
    /* "dLParser.y":615  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location schematext:SCHEMATEXT");
			System.err.println( e );
		}
	};
  break;
    

  case 48:
  if (yyn == 48)
    /* "dLParser.y":623  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (2-(1)))) + (String)((yystack.valueAt (2-(2)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location schematext:SCHEMATEXT schematext");
			System.err.println( e );
		}
	};
  break;
    

  case 49:
  if (yyn == 49)
    /* "dLParser.y":637  */ /* lalr1.java:489  */
    { 
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			this.declaredProgramVariables = new ArrayList<RealVariable>();
			this.declaredProgramVariables.addAll( (ArrayList<RealVariable>)((yystack.valueAt (3-(2)))) );
			yyval = this.declaredProgramVariables.toString();
		} catch ( Exception e ) {
			System.err.println("Exception at location varblock:OPENBOX vardeclaration CLOSEBOX");
			System.err.println( e );
		}
		
	};
  break;
    

  case 50:
  if (yyn == 50)
    /* "dLParser.y":651  */ /* lalr1.java:489  */
    { 
		//$$ = "(declare-vars: \n" + (String)$2 + ")" + (String)$3; System.out.println( $$ );
		try {
			//if ( parsedStructure == null ) {
			//	parsedStructure = new dLStructure();
			//}
			this.declaredProgramVariables = (ArrayList<RealVariable>)((yystack.valueAt (4-(2))));
			this.variableInitializations = (ArrayList<String>)((yystack.valueAt (4-(3))));

			ArrayList<String> result = new ArrayList<String>();
			//result.addAll( this.declaredProgramVariables );
			result.addAll( this.variableInitializations );
			yyval = result.toString();
		} catch ( Exception e ) {
			System.err.println("Exception at location varblock:OPENBOX vardeclaration varinitlist CLOSEBOX");
			System.err.println( e );
		}

	};
  break;
    

  case 51:
  if (yyn == 51)
    /* "dLParser.y":673  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ArrayList<RealVariable>)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location vardeclaration:REALDECLARATION varlist SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 52:
  if (yyn == 52)
    /* "dLParser.y":681  */ /* lalr1.java:489  */
    { 
		//$$ = "\t(declare-real " + (String)$2 + " )\n"  + (String)$4;
		try {
			ArrayList<RealVariable> vars = (ArrayList<RealVariable>)((yystack.valueAt (4-(1))));
			vars.addAll( (ArrayList<RealVariable>)((yystack.valueAt (4-(3)))) );
			yyval = vars;
		} catch ( Exception e ) {
			System.err.println("Exception at location vardeclaration:vardeclaration REALDECLARATION varlist SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 53:
  if (yyn == 53)
    /* "dLParser.y":695  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<RealVariable> vars = new ArrayList<RealVariable>();
			vars.add( new RealVariable( (String)((yystack.valueAt (1-(1)))) ) );
			yyval = vars;
		} catch ( Exception e ) {
			System.err.println("Exception at location varlist:IDENTIFIER");
			System.err.println( e );
		}
	};
  break;
    

  case 54:
  if (yyn == 54)
    /* "dLParser.y":705  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<RealVariable> vars  = (ArrayList<RealVariable>)((yystack.valueAt (3-(1)))) ;
			vars.add( new RealVariable( (String)((yystack.valueAt (3-(3)))) ) );
			yyval = vars;
		} catch ( Exception e ) {
			System.err.println("Exception at location varlist:varlist COMMA IDENTIFIER");
			System.err.println( e );
		}
	};
  break;
    

  case 55:
  if (yyn == 55)
    /* "dLParser.y":718  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<String> init = new ArrayList<String>();
			dLStructure myTerm = (dLStructure)((yystack.valueAt (4-(3))));
			init.add( (String)((yystack.valueAt (4-(1)))) + " := " + myTerm.toString() );
			yyval = init;
		} catch ( Exception e ) {
			System.err.println("Exception at location varinitlist:IDENTIFIER ASSIGN term SEMICOLON");
			System.err.println( e );
		}

	};
  break;
    

  case 56:
  if (yyn == 56)
    /* "dLParser.y":730  */ /* lalr1.java:489  */
    { 
		//$$ = "\t(init: " + (String)$1 + ", " + (String)$3 + " )\n" + (String)$5;
		try {
			ArrayList<String> init = (ArrayList<String>)((yystack.valueAt (5-(1))));
			dLStructure myTerm = (dLStructure)((yystack.valueAt (5-(4))));
			init.add( (String)((yystack.valueAt (5-(2)))) + " := " + myTerm.toString() );
			yyval = init;
		} catch ( Exception e ) {
			System.err.println("Exception at location varinitlist:varinitlist IDENTIFIER ASSIGN term SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 57:
  if (yyn == 57)
    /* "dLParser.y":747  */ /* lalr1.java:489  */
    { 
		try {
			//$$ = "(declare-funs: \n" + (String)$3 + ")"; System.out.println( $$ ); 
			yyval = (String)((yystack.valueAt (4-(3))));
		} catch ( Exception e ) {
			System.err.println("Exception at location funblock:FUNCTIONS OPENBRACE functiondeclaration CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 58:
  if (yyn == 58)
    /* "dLParser.y":759  */ /* lalr1.java:489  */
    {
		try {
			//$$ = "(R fun " + (String)$2 + " " + (String)$4 + " )\n";
			yyval = (String)((yystack.valueAt (6-(1)))) + (String)((yystack.valueAt (6-(2)))) + (String)((yystack.valueAt (6-(3)))) + (String)((yystack.valueAt (6-(4)))) + (String)((yystack.valueAt (6-(5)))) + (String)((yystack.valueAt (6-(6)))) + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 59:
  if (yyn == 59)
    /* "dLParser.y":768  */ /* lalr1.java:489  */
    {
		try {
			//$$ = "(R fun " + (String)$3 + " " + (String)$5 + " )\n"; 
			yyval = (String)((yystack.valueAt (7-(1)))) + (String)((yystack.valueAt (7-(2)))) + (String)((yystack.valueAt (7-(3)))) + (String)((yystack.valueAt (7-(4)))) + (String)((yystack.valueAt (7-(5)))) + (String)((yystack.valueAt (7-(6)))) + (String)((yystack.valueAt (7-(7)))) + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 60:
  if (yyn == 60)
    /* "dLParser.y":777  */ /* lalr1.java:489  */
    {
		try {
			//$$ = "(R fun " + (String)$2 + " " + (String)$4 + " )\n" + (String)$7; 
			yyval = (String)((yystack.valueAt (7-(1)))) + (String)((yystack.valueAt (7-(2)))) + (String)((yystack.valueAt (7-(3)))) + (String)((yystack.valueAt (7-(4)))) + (String)((yystack.valueAt (7-(5)))) + (String)((yystack.valueAt (7-(6)))) + (String)((yystack.valueAt (7-(7)))) + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 61:
  if (yyn == 61)
    /* "dLParser.y":786  */ /* lalr1.java:489  */
    {
		try {
			//$$ = "(R fun " + (String)$3 + " " + (String)$5 + " )\n" + (String)$8; 
			yyval = (String)((yystack.valueAt (8-(1)))) + (String)((yystack.valueAt (8-(2)))) + (String)((yystack.valueAt (8-(3)))) + (String)((yystack.valueAt (8-(4)))) + (String)((yystack.valueAt (8-(5)))) + (String)((yystack.valueAt (8-(6)))) + (String)((yystack.valueAt (8-(7)))) + (String)((yystack.valueAt (8-(8)))) + "\n";
		} catch ( Exception e ) {
			System.err.println("Exception at location functiondeclaration:functiondeclaration EXTERNAL REALDECLARATION IDENTIFIER LPAREN argumentdeclaration RPAREN SEMICOLON");
			System.err.println( e );
		}
	};
  break;
    

  case 62:
  if (yyn == 62)
    /* "dLParser.y":798  */ /* lalr1.java:489  */
    {
		yyval = "";
	};
  break;
    

  case 63:
  if (yyn == 63)
    /* "dLParser.y":801  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentdeclaration:REALDECLARATION");
			System.err.println( e );
		}
	};
  break;
    

  case 64:
  if (yyn == 64)
    /* "dLParser.y":809  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (String)((yystack.valueAt (3-(1)))) + (String)((yystack.valueAt (3-(2)))) + (String)((yystack.valueAt (3-(3)))); 
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentdeclaration:argumentdeclaration COMMA REALDECLARATION");
			System.err.println( e );
		}
	};
  break;
    

  case 65:
  if (yyn == 65)
    /* "dLParser.y":822  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new TrueFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:TRUE");
			System.err.println( e );
		}
	};
  break;
    

  case 66:
  if (yyn == 66)
    /* "dLParser.y":830  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new FalseFormula();
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:FALSE");
			System.err.println( e );
		}
	};
  break;
    

  case 67:
  if (yyn == 67)
    /* "dLParser.y":838  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ComparisonFormula)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:comparison");
			System.err.println( e );
		}
	};
  break;
    

  case 68:
  if (yyn == 68)
    /* "dLParser.y":846  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new AndFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula AND dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 69:
  if (yyn == 69)
    /* "dLParser.y":854  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new OrFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula OR dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 70:
  if (yyn == 70)
    /* "dLParser.y":862  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new NotFormula( (dLFormula)((yystack.valueAt (2-(2)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:NOT dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 71:
  if (yyn == 71)
    /* "dLParser.y":870  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (dLFormula)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:LPAREN dLformula RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 72:
  if (yyn == 72)
    /* "dLParser.y":878  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ImpliesFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula IMPLIES dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 73:
  if (yyn == 73)
    /* "dLParser.y":886  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new IffFormula( (dLFormula)((yystack.valueAt (3-(1)))), (dLFormula)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:dLformula IFF dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 74:
  if (yyn == 74)
    /* "dLParser.y":904  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ForAllFormula( new RealVariable( (String)((yystack.valueAt (4-(2))))), (dLFormula)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:FORALL IDENTIFIER SEMICOLON dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 75:
  if (yyn == 75)
    /* "dLParser.y":912  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ExistsFormula( new RealVariable( (String)((yystack.valueAt (4-(2)))) ), (dLFormula)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location dLformula:EXISTS IDENTIFIER SEMICOLON dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 76:
  if (yyn == 76)
    /* "dLParser.y":920  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new BoxModalityFormula( (HybridProgram)((yystack.valueAt (4-(2)))), (dLFormula)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location OPENBOX:hybridprogram CLOSEBOX dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 77:
  if (yyn == 77)
    /* "dLParser.y":928  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new BoxModalityFormula( (HybridProgram)((yystack.valueAt (4-(2)))), (dLFormula)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location OPENDIAMOND hybridprogram CLOSEDIAMOND dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 78:
  if (yyn == 78)
    /* "dLParser.y":962  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ContinuousProgram)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:odesystem");
			System.err.println( e );
		}
	};
  break;
    

  case 79:
  if (yyn == 79)
    /* "dLParser.y":970  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (TestProgram)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:test");
			System.err.println( e );
		}
	};
  break;
    

  case 80:
  if (yyn == 80)
    /* "dLParser.y":978  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ConcreteAssignmentProgram)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:concreteassignment");
			System.err.println( e );
		}
	};
  break;
    

  case 81:
  if (yyn == 81)
    /* "dLParser.y":986  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (ArbitraryAssignmentProgram)((yystack.valueAt (1-(1))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:arbitraryassignment");
			System.err.println( e );
		}
	};
  break;
    

  case 82:
  if (yyn == 82)
    /* "dLParser.y":994  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new SequenceProgram( (HybridProgram)((yystack.valueAt (3-(1)))), (HybridProgram)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram SEMICOLON hybridprogram");
			System.err.println( e );
		}
	};
  break;
    

  case 83:
  if (yyn == 83)
    /* "dLParser.y":1002  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ChoiceProgram( (HybridProgram)((yystack.valueAt (3-(1)))), (HybridProgram)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram CUP hybridprogram");
			System.err.println( e );
		}
	};
  break;
    

  case 84:
  if (yyn == 84)
    /* "dLParser.y":1010  */ /* lalr1.java:489  */
    {
		try {
			yyval = new RepetitionProgram( (HybridProgram)((yystack.valueAt (2-(1)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:hybridprogram ASTERISK");
			System.err.println( e );
		}
	};
  break;
    

  case 85:
  if (yyn == 85)
    /* "dLParser.y":1018  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (HybridProgram)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location hybridprogram:LPAREN hybridprogram RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 86:
  if (yyn == 86)
    /* "dLParser.y":1029  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ConcreteAssignmentProgram( new RealVariable( (String)((yystack.valueAt (3-(1)))) ), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location concreteassignment:IDENTIFIER ASSIGN term");
			System.err.println( e );
		}
	};
  break;
    

  case 87:
  if (yyn == 87)
    /* "dLParser.y":1040  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ArbitraryAssignmentProgram( new RealVariable( (String)((yystack.valueAt (3-(1)))) ) );
		} catch ( Exception e ) {
			System.err.println("Exception at location arbitraryassignment:IDENTIFIER ASSIGN ASTERISK");
			System.err.println( e );
		}
	};
  break;
    

  case 88:
  if (yyn == 88)
    /* "dLParser.y":1051  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new TestProgram( (dLStructure)((yystack.valueAt (2-(2)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location test:TEST dLformula");
			System.err.println( e );
		}
	};
  break;
    

  case 89:
  if (yyn == 89)
    /* "dLParser.y":1062  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ContinuousProgram( (ArrayList<ExplicitODE>)((yystack.valueAt (3-(2)))) ); // Constructor appends "true" doe automaticaly
		} catch ( Exception e ) {
			System.err.println("Exception at location odesystem:OPENBRACE odelist CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 90:
  if (yyn == 90)
    /* "dLParser.y":1070  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ContinuousProgram( (ArrayList<ExplicitODE>)((yystack.valueAt (5-(2)))), (dLFormula)((yystack.valueAt (5-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location odesystem:OPENBRACE odelist AND dLformula CLOSEBRACE");
			System.err.println( e );
		}
	};
  break;
    

  case 91:
  if (yyn == 91)
    /* "dLParser.y":1081  */ /* lalr1.java:489  */
    { 
		//$$ = (String)$1;
		try {
			ArrayList<ExplicitODE> args = new ArrayList<ExplicitODE>();
			args.add( (ExplicitODE)((yystack.valueAt (1-(1)))) );

			yyval = args;

		} catch ( Exception e ) {
			System.err.println("Exception at location odelist:ode");
			System.err.println( e );
		}

	};
  break;
    

  case 92:
  if (yyn == 92)
    /* "dLParser.y":1095  */ /* lalr1.java:489  */
    { 
		//$$ = (String)$1 + ", " + (String)$3;
		try {
			ArrayList<ExplicitODE> args = new ArrayList<ExplicitODE>();
			args.addAll( (ArrayList<ExplicitODE>)((yystack.valueAt (3-(1)))) );
			args.add( (ExplicitODE)((yystack.valueAt (3-(3)))) );
			yyval = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location odelist:odelist COMMA ode");
			System.err.println( e );
		}

	};
  break;
    

  case 93:
  if (yyn == 93)
    /* "dLParser.y":1110  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ExplicitODE( new RealVariable( (String)((yystack.valueAt (4-(1)))) ), (Term)((yystack.valueAt (4-(4)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location ode:IDENTIFIER PRIME EQUALS term");
			System.err.println( e );
		}

	};
  break;
    

  case 94:
  if (yyn == 94)
    /* "dLParser.y":1124  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ComparisonFormula( new Operator( (String)((yystack.valueAt (3-(2)))), 2, true ), (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) ) ;
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term INEQUALITY term");
			System.err.println( e );
		}
	};
  break;
    

  case 95:
  if (yyn == 95)
    /* "dLParser.y":1132  */ /* lalr1.java:489  */
    {
		try {
			yyval = new ComparisonFormula( new Operator( (String)((yystack.valueAt (3-(2)))), 2, true ), (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) ) ;
		} catch ( Exception e ) {
			System.err.println("Exception at location comparison:term EQUALS term");
			System.err.println( e );
		}
	};
  break;
    

  case 96:
  if (yyn == 96)
    /* "dLParser.y":1144  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new Real( (String)((yystack.valueAt (1-(1)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:NUMBER");
			System.err.println( e );
		}
	};
  break;
    

  case 97:
  if (yyn == 97)
    /* "dLParser.y":1152  */ /* lalr1.java:489  */
    {
		try {
			yyval = new FunctionApplicationTerm( new Operator( (String)((yystack.valueAt (4-(1)))), ((ArrayList<Term>)((yystack.valueAt (4-(3))))).size(), false ), (ArrayList<Term>)((yystack.valueAt (4-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER LPAREN argumentlist RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 98:
  if (yyn == 98)
    /* "dLParser.y":1160  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new RealVariable( (String)((yystack.valueAt (1-(1)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:IDENTIFIER");
			System.err.println( e );
		}
	};
  break;
    

  case 99:
  if (yyn == 99)
    /* "dLParser.y":1168  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (Term)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location term:LPAREN term RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 100:
  if (yyn == 100)
    /* "dLParser.y":1176  */ /* lalr1.java:489  */
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
    

  case 101:
  if (yyn == 101)
    /* "dLParser.y":1188  */ /* lalr1.java:489  */
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
    

  case 102:
  if (yyn == 102)
    /* "dLParser.y":1200  */ /* lalr1.java:489  */
    { 
		try {
			//ArrayList<Term> args = new ArrayList<Term>();
			//args.add( (Term)$1 );
			//args.add( (Term)$3 );
			//$$ = new Term( new Operator("*", 2, true), args );
			yyval = new MultiplicationTerm( (Term)((yystack.valueAt (3-(1)))), (Term)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location term:term ASTERISK term");
			System.err.println( e );
		}
	};
  break;
    

  case 103:
  if (yyn == 103)
    /* "dLParser.y":1212  */ /* lalr1.java:489  */
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
    

  case 104:
  if (yyn == 104)
    /* "dLParser.y":1224  */ /* lalr1.java:489  */
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
    

  case 105:
  if (yyn == 105)
    /* "dLParser.y":1236  */ /* lalr1.java:489  */
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
    

  case 106:
  if (yyn == 106)
    /* "dLParser.y":1252  */ /* lalr1.java:489  */
    {
		yyval = null;
	};
  break;
    

  case 107:
  if (yyn == 107)
    /* "dLParser.y":1255  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<Term> args = new ArrayList<Term>();
			args.add( (Term)((yystack.valueAt (1-(1)))) );
			yyval = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:term");
			System.err.println( e );
		}
	};
  break;
    

  case 108:
  if (yyn == 108)
    /* "dLParser.y":1265  */ /* lalr1.java:489  */
    { 
		try {
			ArrayList<Term> args = new ArrayList<Term>();
			args.addAll( (ArrayList<Term>)((yystack.valueAt (3-(1)))) );
			args.add( (Term)((yystack.valueAt (3-(3)))) );
			yyval = args;
		} catch ( Exception e ) {
			System.err.println("Exception at location argumentlist:argumentlist COMMA term");
			System.err.println( e );
		}
	};
  break;
    


/* "dLParser.java":2024  */ /* lalr1.java:489  */
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

  private static final short yypact_ninf_ = -53;
  private static final short yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short yypact_[] = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
     152,   -53,     6,    42,    65,    82,    91,    97,   114,   115,
     315,   335,   176,   -53,    16,   231,   193,   315,   126,   133,
     -53,   -53,   179,   -53,   -53,   -53,   174,   399,   218,   -53,
     -53,   216,   -15,   153,   -53,   -53,   -53,   -53,   -53,   101,
      28,   220,   220,   339,   315,   315,   187,    -2,    99,    75,
     -53,   176,   200,   315,   334,   101,   213,   187,   239,   176,
     -11,   100,    46,    71,   231,   231,   252,   364,    73,    14,
     -53,   243,   246,   -53,   263,   285,   -53,   399,   218,   216,
      18,   -53,   218,   266,   315,   315,   315,   315,   -53,   266,
     176,   176,   231,   231,   231,   231,   231,   231,   231,   280,
     279,    10,   220,   298,   301,   315,   204,   225,   188,   234,
     -53,   104,   305,   143,   -53,   304,   -53,   213,   315,   313,
     -19,   187,   -53,   323,    -9,   315,   315,   -53,    39,    39,
     169,    30,   -53,   -53,   -53,   315,   315,   315,   325,   337,
     -53,   331,   331,   303,   107,   186,   186,   334,   334,   119,
     163,   163,    17,    39,     5,     5,    17,    17,    39,   340,
     316,   329,   -53,   352,   -53,   -53,   -53,   242,   -53,   -53,
     350,   -53,   232,   -53,   353,   231,   -53,   326,   324,   -53,
     248,   -53,    86,   231,   -53,   374,   -53,   -53,   -53,   231,
     -53,   -53,   259,   315,   373,   385,   -53,   -53,   -53,   -53,
     359,   377,   376,   366,   -53,   -53,   -53,   -53,    39,   -53,
     159,   -53,   -53,   108,   231,    39,   -53,   264,   315,   393,
     402,   377,   -53,   256,   375,   377,   -53,   382,   -53,   128,
     -53,   270,   315,   397,   317,   310,   391,   394,   377,   320,
     -53,   -53,   -53,   276,   315,   400,   401,   -53,   407,   396,
     -53,   -53,   341,   398,   -53,   281,   176,   315,   404,   410,
     -53,   403,   -53,   -53,   173,   289,   315,   408,   -53,   -53,
     -53,   -53,   295,   231,   -53,   170,   -53
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
       0,    15,     0,     0,     0,     0,     0,     0,     0,    36,
       0,     0,     0,    96,    98,     0,     0,     0,     0,     0,
      65,    66,     0,     5,    16,    14,     0,    12,     8,     9,
       7,     6,    10,    11,    80,    81,    79,    78,    67,    13,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
      91,     0,    98,     0,    88,     0,     0,     0,     0,     0,
       0,     0,     0,     0,   106,     0,   105,     0,     0,     0,
      70,     0,     0,     1,     0,     0,    21,     0,     0,     0,
       0,    17,     0,    36,     0,     0,     0,     0,    84,    36,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,    47,     0,     0,     0,     0,     0,     0,     0,
      53,     0,     0,     0,     2,     0,    89,     0,     0,     0,
       0,     0,    49,     0,     0,     0,     0,    87,    86,   107,
       0,     0,    71,    85,    99,     0,     0,     0,     0,     0,
      20,     0,     0,     0,     0,    68,    69,    72,    73,     0,
      83,    82,   102,    95,   100,   101,   103,   104,    94,     0,
       0,     0,    57,     0,    48,    46,    45,     0,    22,    41,
       0,    43,     0,    26,     0,     0,    37,     0,     0,    92,
       0,    51,     0,     0,    50,     0,    76,    77,    97,     0,
      74,    75,     0,     0,     0,     0,    19,    18,     3,     4,
       0,    62,     0,     0,    23,    44,    42,    54,    93,    38,
       0,    90,    52,     0,     0,   108,    27,     0,     0,     0,
       0,    62,    63,     0,     0,    62,    39,     0,    55,     0,
      28,     0,     0,     0,     0,     0,     0,     0,    62,     0,
      40,    56,    29,     0,     0,     0,     0,    24,     0,     0,
      58,    64,     0,     0,    30,     0,     0,     0,     0,     0,
      59,     0,    60,    31,     0,     0,     0,     0,    25,    61,
      32,    33,     0,     0,    34,     0,    35
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short yypgoto_[] = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
     -53,   -53,   432,   -28,   -53,   -53,   -53,   -53,   -53,   -53,
     -53,   -53,   -53,   -53,   -53,    32,     2,   -53,    12,     7,
     -36,   395,   -53,   -52,   -53,     4,   -53,    68,     1,     9,
     -53,   -53,   -53,   -53,   -53,   319,   -53,     0,   -53
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final short yydefgoto_[] = yydefgoto_init();
  private static final short[] yydefgoto_init()
  {
    return new short[]
    {
      -1,    22,    76,    24,    25,    26,    75,   139,   195,   220,
     234,   247,   248,   259,   268,    48,    77,   107,    78,    80,
     103,    30,    60,   111,   124,    79,   101,   223,    67,    61,
      34,    35,    36,    37,    49,    50,    38,    55,   130
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short yytable_[] = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      39,    32,    27,    81,    31,   120,   104,    29,    92,    33,
      83,    54,    28,   181,   161,    66,    69,    92,    70,   121,
      92,    62,   112,     2,   122,    68,   184,     5,   123,   174,
     185,    40,    99,    92,    84,    85,   162,    86,    87,    63,
     163,    93,    92,    82,   106,   108,   109,    96,    97,    88,
     113,    81,   140,    69,    94,    95,    96,    97,   100,    98,
      97,   134,    64,   128,   129,   131,   164,    41,    68,   182,
      94,    95,    96,    97,   127,    90,    88,   134,    91,    94,
      95,    96,    97,   126,   141,   145,   146,   147,   148,   142,
      42,    82,   152,   153,   154,   155,   156,   157,   158,   150,
     151,   116,    90,    88,    92,    91,   167,    43,   170,    13,
      52,    92,    15,   196,   197,   144,    44,    65,   212,   180,
     133,   149,    45,   117,   118,   114,   186,   187,    93,    90,
     173,    92,    91,   198,   174,   125,   190,   191,   192,    46,
     228,    94,    95,    96,    97,   199,    98,   115,    94,    95,
      96,    97,   174,     1,    47,   115,    88,     2,     3,     4,
     241,     5,     6,     7,     8,    71,    88,   115,    94,    95,
      96,    97,    72,    92,   206,   208,    88,     9,    89,    73,
      10,   176,    90,   213,   177,    91,    11,    74,    12,   215,
      13,    14,    90,    15,   217,    91,   276,   226,    16,   270,
     227,    56,    90,    17,    10,    91,    18,    19,    20,    21,
      94,    95,    96,    97,   229,    58,   188,   189,    56,   231,
     171,    10,    59,     4,     3,     5,   110,    51,   102,    12,
     168,    13,    14,   243,    15,    84,    85,    84,    85,    16,
      86,    87,     6,     7,    17,   255,    64,    18,    19,    20,
      21,   169,   119,    84,    85,    92,    86,    87,   265,    51,
     172,    12,    63,    13,    52,   264,    15,   272,   204,    13,
      52,    53,    15,   275,   211,   135,    17,    65,   136,    18,
      19,    20,    21,    84,    85,   216,    86,    87,   137,   235,
     230,    84,    85,   239,    86,    87,   242,    84,    85,   138,
      86,    87,   254,   236,   237,   143,   252,   263,    84,    85,
     159,    86,    87,    84,    85,   271,    86,    87,   160,    84,
      85,   274,    86,    87,   165,    84,    85,   166,    86,    87,
      84,    85,   175,    86,    87,   245,   246,   112,    84,    85,
       5,    86,    87,   178,    84,    85,   183,    86,    87,    51,
     193,    12,   194,    13,    52,   113,    15,   249,   237,   202,
      56,    53,   201,    10,   209,    57,    17,   253,   237,    18,
      19,    20,    21,    11,    58,    12,   210,    13,    52,   200,
      15,    59,   205,    84,    85,    53,    86,    87,   261,   237,
      17,   203,   207,    18,    19,    20,    21,   214,   218,    84,
      85,   219,    86,    87,     2,   221,     4,   222,     5,     6,
       7,   132,   225,    84,    85,   224,    86,    87,   232,   233,
     240,   238,   244,   250,   251,   256,   257,   258,   260,   266,
     262,   267,    23,   273,     0,   269,   179,     0,   105
    };
  }

private static final short yycheck_[] = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
       0,     0,     0,    31,     0,    57,    42,     0,     3,     0,
      25,    10,     0,    32,     4,    15,    16,     3,    17,    30,
       3,    12,    24,     5,    35,    16,    35,     9,    39,    48,
      39,    25,     4,     3,    49,    50,    26,    52,    53,    23,
      30,    27,     3,    31,    43,    44,    45,    42,    43,     3,
      52,    79,    80,    53,    40,    41,    42,    43,    30,    45,
      43,    47,    46,    63,    64,    65,   102,    25,    59,   121,
      40,    41,    42,    43,     3,    29,     3,    47,    32,    40,
      41,    42,    43,    37,    80,    84,    85,    86,    87,    82,
      25,    79,    92,    93,    94,    95,    96,    97,    98,    90,
      91,    26,    29,     3,     3,    32,   105,    25,   107,    38,
      39,     3,    41,   141,   142,    83,    25,    46,    32,   118,
      47,    89,    25,    48,    49,    26,   125,   126,    27,    29,
      26,     3,    32,    26,    48,    35,   135,   136,   137,    25,
      32,    40,    41,    42,    43,    26,    45,    48,    40,    41,
      42,    43,    48,     1,    39,    48,     3,     5,     6,     7,
      32,     9,    10,    11,    12,    39,     3,    48,    40,    41,
      42,    43,    39,     3,   172,   175,     3,    25,    25,     0,
      28,    38,    29,   183,    41,    32,    34,    13,    36,   189,
      38,    39,    29,    41,   193,    32,    26,    38,    46,    26,
      41,    25,    29,    51,    28,    32,    54,    55,    56,    57,
      40,    41,    42,    43,   214,    39,    47,    48,    25,   218,
      32,    28,    46,     7,     6,     9,    39,    34,     8,    36,
      26,    38,    39,   232,    41,    49,    50,    49,    50,    46,
      52,    53,    10,    11,    51,   244,    46,    54,    55,    56,
      57,    26,    39,    49,    50,     3,    52,    53,   257,    34,
      26,    36,    23,    38,    39,   256,    41,   266,    26,    38,
      39,    46,    41,   273,    26,    32,    51,    46,    32,    54,
      55,    56,    57,    49,    50,    26,    52,    53,    25,   221,
      26,    49,    50,   225,    52,    53,    26,    49,    50,    14,
      52,    53,    26,    47,    48,    39,   238,    26,    49,    50,
      30,    52,    53,    49,    50,    26,    52,    53,    39,    49,
      50,    26,    52,    53,    26,    49,    50,    26,    52,    53,
      49,    50,    27,    52,    53,    18,    19,    24,    49,    50,
       9,    52,    53,    39,    49,    50,    23,    52,    53,    34,
      25,    36,    15,    38,    39,    52,    41,    47,    48,    30,
      25,    46,    46,    28,    38,    30,    51,    47,    48,    54,
      55,    56,    57,    34,    39,    36,    52,    38,    39,    39,
      41,    46,    32,    49,    50,    46,    52,    53,    47,    48,
      51,    39,    39,    54,    55,    56,    57,    23,    25,    49,
      50,    16,    52,    53,     5,    46,     7,    30,     9,    10,
      11,    47,    46,    49,    50,    39,    52,    53,    25,    17,
      38,    46,    25,    32,    30,    25,    25,    20,    32,    25,
      32,    21,     0,    25,    -1,    32,   117,    -1,    43
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     1,     5,     6,     7,     9,    10,    11,    12,    25,
      28,    34,    36,    38,    39,    41,    46,    51,    54,    55,
      56,    57,    62,    63,    64,    65,    66,    77,    79,    80,
      82,    86,    89,    90,    91,    92,    93,    94,    97,    98,
      25,    25,    25,    25,    25,    25,    25,    39,    76,    95,
      96,    34,    39,    46,    89,    98,    25,    30,    39,    46,
      83,    90,    90,    23,    46,    46,    98,    89,    90,    98,
      89,    39,    39,     0,    13,    67,    63,    77,    79,    86,
      80,    64,    79,    25,    49,    50,    52,    53,     3,    25,
      29,    32,     3,    27,    40,    41,    42,    43,    45,     4,
      30,    87,     8,    81,    81,    82,    89,    78,    89,    89,
      39,    84,    24,    52,    26,    48,    26,    48,    49,    39,
      84,    30,    35,    39,    85,    35,    37,     3,    98,    98,
      99,    98,    47,    47,    47,    32,    32,    25,    14,    68,
      64,    86,    80,    39,    76,    89,    89,    89,    89,    76,
      90,    90,    98,    98,    98,    98,    98,    98,    98,    30,
      39,     4,    26,    30,    81,    26,    26,    89,    26,    26,
      89,    32,    26,    26,    48,    27,    38,    41,    39,    96,
      89,    32,    84,    23,    35,    39,    89,    89,    47,    48,
      89,    89,    89,    25,    15,    69,    64,    64,    26,    26,
      39,    46,    30,    39,    26,    32,    77,    39,    98,    38,
      52,    26,    32,    98,    23,    98,    26,    89,    25,    16,
      70,    46,    30,    88,    39,    46,    38,    41,    32,    98,
      26,    89,    25,    17,    71,    88,    47,    48,    46,    88,
      38,    32,    26,    89,    25,    18,    19,    72,    73,    47,
      32,    30,    88,    47,    26,    89,    25,    25,    20,    74,
      32,    47,    32,    26,    90,    89,    25,    21,    75,    32,
      26,    26,    89,    25,    26,    98,    26
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    61,    62,    62,    62,    62,    62,    62,    62,    62,
      62,    62,    62,    62,    62,    62,    63,    63,    63,    63,
      63,    63,    64,    64,    65,    65,    66,    67,    68,    69,
      70,    71,    72,    73,    74,    75,    76,    76,    76,    76,
      76,    77,    77,    78,    78,    79,    80,    81,    81,    82,
      82,    83,    83,    84,    84,    85,    85,    86,    87,    87,
      87,    87,    88,    88,    88,    89,    89,    89,    89,    89,
      89,    89,    89,    89,    89,    89,    89,    89,    90,    90,
      90,    90,    90,    90,    90,    90,    91,    92,    93,    94,
      94,    95,    95,    96,    97,    97,    98,    98,    98,    98,
      98,    98,    98,    98,    98,    98,    99,    99,    99
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     3,     4,     4,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     2,     4,     4,
       3,     2,     4,     5,     7,     9,     4,     4,     4,     4,
       4,     4,     4,     4,     4,     4,     0,     3,     4,     5,
       6,     4,     5,     2,     3,     4,     4,     1,     2,     3,
       4,     3,     4,     1,     3,     4,     5,     4,     6,     7,
       7,     8,     0,     1,     3,     1,     1,     1,     3,     3,
       2,     3,     3,     3,     4,     4,     4,     4,     1,     1,
       1,     1,     3,     3,     2,     3,     3,     3,     2,     3,
       5,     1,     3,     4,     3,     3,     1,     4,     1,     3,
       3,     3,     3,     3,     3,     2,     0,     1,     3
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
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297,   298,   299,   300,   301,   302,   303,   304,
     305,   306,   307,   308,   309,   310,   311,   312,   313,   314,
     315
    };
  }

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "ASTERISK", "EXTERNAL", "FUNCTIONS",
  "RULES", "SCHEMAVARIABLES", "SCHEMATEXT", "PROBLEM", "ANNOTATION",
  "BOUNDS", "STATEVARIABLES", "INITIALSET", "SAFESET", "EIPARAMETERS",
  "ENVELOPE", "INVARIANT", "CONTROLLAW", "CONTROLPARAMETERS",
  "CONTROLTEMPLATE", "OBJECTIVEFUNCTION", "SETTINGS", "ASSIGN", "PRIME",
  "OPENBRACE", "CLOSEBRACE", "EQUALS", "TEST", "CUP", "REALDECLARATION",
  "KLEENESTAR", "SEMICOLON", "RANDOM", "OPENBOX", "CLOSEBOX",
  "OPENDIAMOND", "CLOSEDIAMOND", "NUMBER", "IDENTIFIER", "PLUS", "MINUS",
  "DIVIDE", "POWER", "NEWLINE", "INEQUALITY", "LPAREN", "RPAREN", "COMMA",
  "AND", "OR", "NOT", "IMPLIES", "IFF", "FORALL", "EXISTS", "TRUE",
  "FALSE", "QUANTIFIER", "MULTIPLY", "NEGATIVE", "$accept", "input",
  "keymaerablock", "problemblock", "eitoolblock", "statevarblock",
  "initialsetblock", "safesetblock", "eiparameterblock", "envelopeblock",
  "invariantblock", "controllawblock", "controlparameters",
  "controltemplateblock", "objectivefunction", "valuation",
  "annotationblock", "annotationlist", "schemavarsblock", "rulesblock",
  "schematext", "varblock", "vardeclaration", "varlist", "varinitlist",
  "funblock", "functiondeclaration", "argumentdeclaration", "dLformula",
  "hybridprogram", "concreteassignment", "arbitraryassignment", "test",
  "odesystem", "odelist", "ode", "comparison", "term", "argumentlist", null
    };
  }

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,   129,   129,   137,   146,   155,   163,   171,   179,   188,
     196,   205,   214,   222,   231,   239,   249,   257,   265,   273,
     281,   289,   300,   309,   322,   330,   339,   349,   358,   368,
     381,   391,   430,   440,   450,   460,   476,   477,   492,   507,
     519,   537,   545,   556,   566,   585,   600,   615,   623,   637,
     651,   673,   681,   695,   705,   718,   730,   747,   759,   768,
     777,   786,   798,   801,   809,   822,   830,   838,   846,   854,
     862,   870,   878,   886,   904,   912,   920,   928,   962,   970,
     978,   986,   994,  1002,  1010,  1018,  1029,  1040,  1051,  1062,
    1070,  1081,  1095,  1110,  1124,  1132,  1144,  1152,  1160,  1168,
    1176,  1188,  1200,  1212,  1224,  1236,  1252,  1255,  1265
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
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    57,    58,    59,    60
    };
  }

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 438;
  private static final int yynnts_ = 39;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 73;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 61;

  private static final int yyuser_token_number_max_ = 315;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */

}

/* "dLParser.y":1279  */ /* lalr1.java:1070  */







