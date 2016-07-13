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

package propositionallogic.parser;
/* First part of user declarations.  */
/* "PropositionalLogicParser.y":2  */ /* lalr1.java:91  */

	import java.util.*;
	import propositionallogic.syntax.*;

	@SuppressWarnings({"unchecked"})

/* "PropositionalLogicParser.java":43  */ /* lalr1.java:91  */

/* "PropositionalLogicParser.java":45  */ /* lalr1.java:92  */

/**
 * A Bison parser, automatically generated from <tt>PropositionalLogicParser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class PropositionalLogicParser extends AbstractPropositionalLogicParser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.0.4";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";





  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>PropositionalLogicParser</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int LPAREN = 258;
    /** Token number,to be returned by the scanner.  */
    static final int RPAREN = 259;
    /** Token number,to be returned by the scanner.  */
    static final int COMMA = 260;
    /** Token number,to be returned by the scanner.  */
    static final int SEMICOLON = 261;
    /** Token number,to be returned by the scanner.  */
    static final int OPENBRACE = 262;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSEBRACE = 263;
    /** Token number,to be returned by the scanner.  */
    static final int AND = 264;
    /** Token number,to be returned by the scanner.  */
    static final int OR = 265;
    /** Token number,to be returned by the scanner.  */
    static final int NOT = 266;
    /** Token number,to be returned by the scanner.  */
    static final int IMPLIES = 267;
    /** Token number,to be returned by the scanner.  */
    static final int IFF = 268;
    /** Token number,to be returned by the scanner.  */
    static final int IDENTIFIER = 269;
    /** Token number,to be returned by the scanner.  */
    static final int TRUE = 270;
    /** Token number,to be returned by the scanner.  */
    static final int FALSE = 271;


    

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
  public PropositionalLogicParser (Lexer yylexer) 
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
    /* "PropositionalLogicParser.y":39  */ /* lalr1.java:489  */
    {
		try {
			yyval = (String)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location input:replacement");
			System.err.println( e );
		}
	};
  break;
    

  case 3:
  if (yyn == 3)
    /* "PropositionalLogicParser.y":47  */ /* lalr1.java:489  */
    { 
		try {
			//TextOutput.debug("Found: proposition"); 
			parsedProposition = (Proposition)((yystack.valueAt (1-(1))));	
		} catch ( Exception e ) {
			System.err.println("Exception at location input:proposition");
			System.err.println( e );
		}
	};
  break;
    

  case 4:
  if (yyn == 4)
    /* "PropositionalLogicParser.y":56  */ /* lalr1.java:489  */
    {
		//System.err.println("Propositional logic parser: I'm confused, throwing error");
		//System.err.println( (String)$1 );
		throw new PropositionFormatException("Did not find a propositional logic formula in: " + (String)((yystack.valueAt (1-(1)))) );
	};
  break;
    

  case 5:
  if (yyn == 5)
    /* "PropositionalLogicParser.y":65  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new TrueProposition();
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:TRUE");
			System.err.println( e );
		}
	};
  break;
    

  case 6:
  if (yyn == 6)
    /* "PropositionalLogicParser.y":73  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new FalseProposition();
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:FALSE");
			System.err.println( e );
		}
	};
  break;
    

  case 7:
  if (yyn == 7)
    /* "PropositionalLogicParser.y":81  */ /* lalr1.java:489  */
    {
		try {
			yyval = new PropositionalVariable( (String)((yystack.valueAt (1-(1)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:IDENTIFIER");
			System.err.println( e );
		}
	};
  break;
    

  case 8:
  if (yyn == 8)
    /* "PropositionalLogicParser.y":89  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new AndProposition( (Proposition)((yystack.valueAt (3-(1)))), (Proposition)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:proposition AND proposition");
			System.err.println( e );
		}
	};
  break;
    

  case 9:
  if (yyn == 9)
    /* "PropositionalLogicParser.y":97  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new OrProposition( (Proposition)((yystack.valueAt (3-(1)))), (Proposition)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:proposition OR proposition");
			System.err.println( e );
		}
	};
  break;
    

  case 10:
  if (yyn == 10)
    /* "PropositionalLogicParser.y":105  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new NotProposition( (Proposition)((yystack.valueAt (2-(2)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:NOT proposition");
			System.err.println( e );
		}
	};
  break;
    

  case 11:
  if (yyn == 11)
    /* "PropositionalLogicParser.y":113  */ /* lalr1.java:489  */
    { 
		try {
			yyval = (Proposition)((yystack.valueAt (3-(2))));
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:LPAREN proposition RPAREN");
			System.err.println( e );
		}
	};
  break;
    

  case 12:
  if (yyn == 12)
    /* "PropositionalLogicParser.y":121  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new ImpliesProposition( (Proposition)((yystack.valueAt (3-(1)))), (Proposition)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:proposition IMPLIES proposition");
			System.err.println( e );
		}
	};
  break;
    

  case 13:
  if (yyn == 13)
    /* "PropositionalLogicParser.y":129  */ /* lalr1.java:489  */
    { 
		try {
			yyval = new IffProposition( (Proposition)((yystack.valueAt (3-(1)))), (Proposition)((yystack.valueAt (3-(3)))) );
		} catch ( Exception e ) {
			System.err.println("Exception at location proposition:proposition IFF proposition");
			System.err.println( e );
		}
	};
  break;
    

  case 14:
  if (yyn == 14)
    /* "PropositionalLogicParser.y":143  */ /* lalr1.java:489  */
    {
		try {
			if ( this.replacement == null ) {
				this.replacement = new PropositionalReplacement();
			}

			this.replacement.put( new PropositionalVariable( (String)((yystack.valueAt (3-(1)))) ), new TrueProposition() );
			yyval = "(replacement " +  (String)((yystack.valueAt (3-(1)))) + "->" + (String)((yystack.valueAt (3-(3)))) + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location replacement:IDENTIFIER IMPLIES TRUE");
			System.err.println( e );
		}
		
	};
  break;
    

  case 15:
  if (yyn == 15)
    /* "PropositionalLogicParser.y":158  */ /* lalr1.java:489  */
    {
		try {
			if ( this.replacement == null ) {
				this.replacement = new PropositionalReplacement();
			}

			this.replacement.put( new PropositionalVariable( (String)((yystack.valueAt (3-(1)))) ), new FalseProposition() );
			yyval = "(replacement " +  (String)((yystack.valueAt (3-(1)))) + "->" + "-" + (String)((yystack.valueAt (3-(3)))) + ")";

		} catch ( Exception e ) {
			System.err.println("Exception at location replacement:IDENTIFIER IMPLIES FALSE");
			System.err.println( e );
		}
		
	};
  break;
    

  case 16:
  if (yyn == 16)
    /* "PropositionalLogicParser.y":173  */ /* lalr1.java:489  */
    {
		try{
			if ( this.replacement == null ) {
				this.replacement = new PropositionalReplacement();
			}
			this.replacement.put( new PropositionalVariable( (String)((yystack.valueAt (5-(3)))) ), new TrueProposition() );
			yyval = (String)((yystack.valueAt (5-(1)))) + "\n" + "(replacement " +  (String)((yystack.valueAt (5-(3)))) + "->" + (String)((yystack.valueAt (5-(5)))) + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location replacement:replacement COMMA IDENTIFIER IMPLIES TRUE");
			System.err.println( e );
		}
	};
  break;
    

  case 17:
  if (yyn == 17)
    /* "PropositionalLogicParser.y":185  */ /* lalr1.java:489  */
    {
		try{
			if ( this.replacement == null ) {
				this.replacement = new PropositionalReplacement();
			}
			this.replacement.put( new PropositionalVariable( (String)((yystack.valueAt (5-(3)))) ), new FalseProposition() );
			yyval = (String)((yystack.valueAt (5-(1)))) + "\n" + "(replacement " +  (String)((yystack.valueAt (5-(3)))) + "->" + "-" + (String)((yystack.valueAt (5-(5)))) + ")";
		} catch ( Exception e ) {
			System.err.println("Exception at location replacement:replacement COMMA IDENTIFIER IMPLIES FALSE");
			System.err.println( e );
		}
	};
  break;
    


/* "PropositionalLogicParser.java":583  */ /* lalr1.java:489  */
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

  private static final byte yypact_ninf_ = -13;
  private static final byte yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final byte yypact_[] = yypact_init();
  private static final byte[] yypact_init()
  {
    return new byte[]
    {
      16,   -13,    22,     4,    22,   -13,   -13,   -13,    24,    30,
      -3,    10,     0,   -13,   -13,    22,    22,    22,    22,   -13,
     -12,    12,   -13,     2,     2,    30,    30,   -13,   -13,    17,
       5,   -13,   -13
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
       0,     4,     0,     0,     0,     7,     5,     6,     0,     3,
       0,     0,     0,    10,     1,     0,     0,     0,     0,    11,
       0,     0,     2,     8,     9,    12,    13,    14,    15,     0,
       0,    16,    17
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte yypgoto_[] = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -13,   -13,    -2,   -13
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte yydefgoto_[] = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
      -1,     8,     9,    12
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
      10,    19,    13,    27,    28,    21,    15,    16,    22,    17,
      18,    15,    16,    23,    24,    25,    26,     1,    11,     2,
      31,    32,    20,     3,    14,     2,    29,     4,     0,    30,
       5,     6,     7,     4,     0,     0,     5,     6,     7,    15,
      16,     0,    17,    18
    };
  }

private static final byte yycheck_[] = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
       2,     4,     4,    15,    16,     5,     9,    10,     8,    12,
      13,     9,    10,    15,    16,    17,    18,     1,    14,     3,
      15,    16,    12,     7,     0,     3,    14,    11,    -1,    12,
      14,    15,    16,    11,    -1,    -1,    14,    15,    16,     9,
      10,    -1,    12,    13
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     1,     3,     7,    11,    14,    15,    16,    18,    19,
      19,    14,    20,    19,     0,     9,    10,    12,    13,     4,
      12,     5,     8,    19,    19,    19,    19,    15,    16,    14,
      12,    15,    16
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    17,    18,    18,    18,    19,    19,    19,    19,    19,
      19,    19,    19,    19,    20,    20,    20,    20
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     3,     1,     1,     1,     1,     1,     3,     3,
       2,     3,     3,     3,     3,     3,     5,     5
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
     265,   266,   267,   268,   269,   270,   271
    };
  }

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "LPAREN", "RPAREN", "COMMA", "SEMICOLON",
  "OPENBRACE", "CLOSEBRACE", "AND", "OR", "NOT", "IMPLIES", "IFF",
  "IDENTIFIER", "TRUE", "FALSE", "$accept", "input", "proposition",
  "replacement", null
    };
  }

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] = yyrline_init();
  private static final short[] yyrline_init()
  {
    return new short[]
    {
       0,    39,    39,    47,    56,    65,    73,    81,    89,    97,
     105,   113,   121,   129,   143,   158,   173,   185
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
      15,    16
    };
  }

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 43;
  private static final int yynnts_ = 4;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 14;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 17;

  private static final int yyuser_token_number_max_ = 271;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */

}

/* "PropositionalLogicParser.y":199  */ /* lalr1.java:1070  */





