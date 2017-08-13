/* The following code was generated by JFlex 1.4.3 on 8/13/17 4:05 PM */

package dl.parser;

import interfaces.text.*;
import dl.syntax.*;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 8/13/17 4:05 PM from the specification file
 * <tt>dLLexer.lex</tt>
 */
public class dLLexer implements dLParser.Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\16\1\13\1\0\1\16\1\14\22\0\1\53\1\12\4\0"+
    "\1\50\1\27\1\33\1\35\1\20\1\24\1\34\1\5\1\3\1\17"+
    "\12\2\1\22\1\15\1\7\1\11\1\10\1\23\1\0\4\1\1\6"+
    "\1\47\13\1\1\21\1\1\1\42\6\1\1\31\1\30\1\32\1\36"+
    "\1\1\1\0\1\44\2\1\1\60\1\4\1\43\1\56\1\1\1\55"+
    "\2\1\1\45\1\57\1\1\1\52\2\1\1\40\1\46\1\37\1\41"+
    "\2\1\1\54\2\1\1\25\1\51\1\26\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\2\5\1\6\1\7"+
    "\2\10\1\11\1\10\1\12\1\13\1\14\1\1\1\15"+
    "\1\16\1\17\1\20\1\21\1\1\1\22\1\23\1\24"+
    "\1\25\5\2\1\26\1\27\1\3\1\0\1\30\1\0"+
    "\1\5\2\0\1\31\1\32\1\0\1\33\1\34\1\35"+
    "\1\36\1\0\5\2\1\37\1\40\1\3\1\0\1\41"+
    "\2\42\4\0\5\2\1\42\1\0\1\42\2\0\1\43"+
    "\1\44\3\2\2\0\1\45\1\2\1\46\2\0\1\2"+
    "\2\0\1\47\2\0\1\50\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[95];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\u0126\0\61"+
    "\0\u0126\0\u0157\0\u0188\0\61\0\61\0\u01b9\0\61\0\142"+
    "\0\u01ea\0\61\0\u021b\0\61\0\61\0\61\0\u024c\0\61"+
    "\0\61\0\61\0\61\0\u027d\0\u02ae\0\u02df\0\u0310\0\u0341"+
    "\0\u0372\0\u03a3\0\u03d4\0\u0405\0\61\0\u0436\0\61\0\u0467"+
    "\0\u0498\0\61\0\61\0\u04c9\0\61\0\61\0\61\0\61"+
    "\0\u04fa\0\u052b\0\u055c\0\u058d\0\u05be\0\u05ef\0\61\0\61"+
    "\0\u0620\0\u0620\0\61\0\u0651\0\u0682\0\u06b3\0\u06e4\0\u0715"+
    "\0\u0746\0\u0777\0\u07a8\0\u07d9\0\u080a\0\u083b\0\61\0\u086c"+
    "\0\u06b3\0\u089d\0\u08ce\0\142\0\142\0\u08ff\0\u0930\0\u0961"+
    "\0\u0992\0\u09c3\0\142\0\u09f4\0\142\0\u0a25\0\u0a56\0\u0a87"+
    "\0\u0ab8\0\u0ae9\0\142\0\u0b1a\0\u0b4b\0\61\0\61";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[95];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\3\1\5\1\3\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\2\2\1\30\1\31\1\32\1\33\1\34\2\3"+
    "\1\35\1\36\2\3\1\37\1\40\1\41\1\42\1\3"+
    "\1\15\5\3\62\0\2\3\1\0\1\3\1\0\1\3"+
    "\12\0\1\3\15\0\11\3\2\0\1\3\1\0\5\3"+
    "\2\0\1\4\1\43\1\44\1\0\1\44\62\0\1\45"+
    "\55\0\1\46\3\0\1\47\60\0\1\47\64\0\1\15"+
    "\56\0\1\15\64\0\1\50\1\51\51\0\1\52\73\0"+
    "\1\53\40\0\1\54\2\0\1\55\1\56\20\0\1\57"+
    "\1\60\10\0\1\61\16\0\2\3\1\0\1\3\1\0"+
    "\1\3\12\0\1\3\15\0\1\3\1\62\7\3\2\0"+
    "\1\3\1\0\5\3\1\0\2\3\1\0\1\3\1\0"+
    "\1\3\12\0\1\3\15\0\1\3\1\63\7\3\2\0"+
    "\1\3\1\0\5\3\1\0\2\3\1\0\1\3\1\0"+
    "\1\3\12\0\1\3\15\0\5\3\1\64\3\3\2\0"+
    "\1\3\1\0\5\3\1\0\2\3\1\0\1\3\1\0"+
    "\1\3\12\0\1\3\15\0\11\3\2\0\1\3\1\0"+
    "\1\3\1\65\3\3\1\0\2\3\1\0\1\3\1\0"+
    "\1\3\12\0\1\3\15\0\5\3\1\66\3\3\2\0"+
    "\1\3\1\0\5\3\50\0\1\67\61\0\1\70\11\0"+
    "\1\43\1\0\1\44\1\0\1\44\54\0\1\71\2\0"+
    "\1\72\16\0\1\72\44\0\1\73\50\0\13\50\1\74"+
    "\1\75\44\50\20\76\1\77\40\76\54\0\1\100\56\0"+
    "\1\101\7\0\2\3\1\0\1\3\1\0\1\3\12\0"+
    "\1\3\15\0\2\3\1\102\6\3\2\0\1\3\1\0"+
    "\5\3\1\0\2\3\1\0\1\3\1\0\1\3\12\0"+
    "\1\3\15\0\2\3\1\103\6\3\2\0\1\3\1\0"+
    "\5\3\1\0\2\3\1\0\1\3\1\0\1\3\12\0"+
    "\1\3\15\0\6\3\1\104\2\3\2\0\1\3\1\0"+
    "\5\3\1\0\2\3\1\0\1\3\1\0\1\3\12\0"+
    "\1\3\15\0\11\3\2\0\1\3\1\0\2\3\1\105"+
    "\2\3\1\0\2\3\1\0\1\3\1\0\1\3\12\0"+
    "\1\3\15\0\6\3\1\106\2\3\2\0\1\3\1\0"+
    "\5\3\2\0\1\71\73\0\1\107\56\0\1\107\45\0"+
    "\20\76\1\110\57\76\1\111\1\110\40\76\55\0\1\112"+
    "\43\0\1\113\21\0\2\3\1\0\1\114\1\0\1\3"+
    "\12\0\1\3\15\0\11\3\2\0\1\3\1\0\5\3"+
    "\1\0\2\3\1\0\1\115\1\0\1\3\12\0\1\3"+
    "\15\0\11\3\2\0\1\3\1\0\5\3\1\0\2\3"+
    "\1\0\1\3\1\0\1\3\12\0\1\3\15\0\7\3"+
    "\1\116\1\3\2\0\1\3\1\0\5\3\1\0\2\3"+
    "\1\0\1\3\1\0\1\3\12\0\1\3\15\0\11\3"+
    "\2\0\1\3\1\0\3\3\1\117\1\3\1\0\2\3"+
    "\1\0\1\3\1\0\1\3\12\0\1\3\15\0\7\3"+
    "\1\120\1\3\2\0\1\3\1\0\5\3\17\76\1\107"+
    "\1\110\40\76\46\0\1\121\56\0\1\122\15\0\2\3"+
    "\1\0\1\123\1\0\1\3\12\0\1\3\15\0\11\3"+
    "\2\0\1\3\1\0\5\3\1\0\2\3\1\0\1\3"+
    "\1\0\1\3\12\0\1\3\15\0\11\3\2\0\1\124"+
    "\1\0\5\3\1\0\2\3\1\0\1\125\1\0\1\3"+
    "\12\0\1\3\15\0\11\3\2\0\1\3\1\0\5\3"+
    "\37\0\1\126\66\0\1\127\14\0\2\3\1\0\1\3"+
    "\1\0\1\3\12\0\1\3\15\0\11\3\2\0\1\3"+
    "\1\0\1\3\1\130\3\3\46\0\1\131\57\0\1\132"+
    "\14\0\2\3\1\0\1\3\1\0\1\3\12\0\1\3"+
    "\15\0\11\3\2\0\1\3\1\0\4\3\1\133\53\0"+
    "\1\134\60\0\1\135\26\0\1\136\60\0\1\137\37\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2940];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\5\1\1\11\3\1\2\11\1\1\1\11"+
    "\2\1\1\11\1\1\3\11\1\1\4\11\10\1\1\0"+
    "\1\11\1\0\1\11\2\0\2\11\1\0\4\11\1\0"+
    "\5\1\2\11\1\1\1\0\1\11\2\1\4\0\5\1"+
    "\1\11\1\0\1\1\2\0\5\1\2\0\3\1\2\0"+
    "\1\1\2\0\1\1\2\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[95];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	int openBraceCount = 0;
	boolean debug = true;
	public Object getLVal() {
		//TextOutput.debug("YYTEXT is: " + yytext() );
		return yytext();
	}

	public void yyerror ( String S ) {
		//System.err.println( S );
		throw new dLStructureFormatException( S );
	}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public dLLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public dLLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 134) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 26: 
          { if ( debug ) {
			TextOutput.debug("Lexer: CUP");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return CUP;
          }
        case 42: break;
        case 3: 
          { if ( debug ) {
			TextOutput.debug("Lexer: NUMBER");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return NUMBER;
          }
        case 43: break;
        case 13: 
          { if ( debug ) {
			TextOutput.debug("Lexer: TEST");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return TEST;
          }
        case 44: break;
        case 22: 
          { if ( debug ) {
			TextOutput.debug("Lexer: AND");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return AND;
          }
        case 45: break;
        case 24: 
          { if ( debug ) {
			TextOutput.debug("Lexer: IMPLIES");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return IMPLIES;
          }
        case 46: break;
        case 15: 
          { if ( debug ) {
			TextOutput.debug("Lexer: OPENBRACE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return OPENBRACE;
          }
        case 47: break;
        case 41: 
          { if ( debug ) {
			TextOutput.debug("Lexer: FORALL");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return FORALL;
          }
        case 48: break;
        case 6: 
          { if ( debug ) {
			TextOutput.debug("Lexer: EQUALS");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return EQUALS;
          }
        case 49: break;
        case 8: 
          { if ( debug ) {
			TextOutput.debug("Lexer: space");
			TextOutput.debug("Lexer @ " + yytext() );
		}
          }
        case 50: break;
        case 29: 
          { if ( debug ) {
			TextOutput.debug("Lexer: OPENBOX");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return OPENBOX;
          }
        case 51: break;
        case 5: 
          { if ( debug ) {
			TextOutput.debug("Lexer: INEQUALITY");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return INEQUALITY;
          }
        case 52: break;
        case 30: 
          { if ( debug ) {
			TextOutput.debug("Lexer: CLOSEBOX");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return CLOSEBOX;
          }
        case 53: break;
        case 17: 
          { if ( debug ) {
			TextOutput.debug("Lexer: PRIME");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return PRIME;
          }
        case 54: break;
        case 23: 
          { if ( debug ) {
			TextOutput.debug("Lexer: OR");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return OR;
          }
        case 55: break;
        case 11: 
          { if ( debug ) {
			TextOutput.debug("Lexer: ASTERISK");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return ASTERISK;
          }
        case 56: break;
        case 10: 
          { if ( debug ) {
			TextOutput.debug("Lexer: DIVIDE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return DIVIDE;
          }
        case 57: break;
        case 4: 
          { if ( debug ) {
			TextOutput.debug("Lexer: MINUS");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return MINUS;
          }
        case 58: break;
        case 1: 
          { TextOutput.debug("Lexer: I'm confused, throwing error");
		TextOutput.debug("Lexer @ " + yytext() );
		return dLParser.YYERROR;
          }
        case 59: break;
        case 12: 
          { if ( debug ) {
			TextOutput.debug("Lexer: REALDECLARATION");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return REALDECLARATION;
          }
        case 60: break;
        case 36: 
          { // for mathematica
		if ( debug ) {
			TextOutput.debug("Lexer: TRUE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return TRUE;
          }
        case 61: break;
        case 21: 
          { if ( debug ) {
			TextOutput.debug("Lexer: POWER");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return POWER;
          }
        case 62: break;
        case 37: 
          { if ( debug ) {
			TextOutput.debug("Lexer: FALSE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return FALSE;
          }
        case 63: break;
        case 16: 
          { if ( debug ) {
			TextOutput.debug("Lexer: CLOSEBRACE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return CLOSEBRACE;
          }
        case 64: break;
        case 9: 
          { if ( debug ) {
			TextOutput.debug("Lexer: SEMICOLON");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return SEMICOLON;
          }
        case 65: break;
        case 39: 
          { if ( debug ) {
			TextOutput.debug("Lexer: SIGMOID");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return SIGMOID;
          }
        case 66: break;
        case 40: 
          { if ( debug ) {
			TextOutput.debug("Lexer: EXISTS");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return EXISTS;
          }
        case 67: break;
        case 38: 
          { // for mathematica
		if ( debug ) {
			TextOutput.debug("Lexer: FALSE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return FALSE;
          }
        case 68: break;
        case 20: 
          { if ( debug ) {
			TextOutput.debug("Lexer: RPAREN");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return RPAREN;
          }
        case 69: break;
        case 32: 
          { // For mathematica
		if ( debug ) {
			TextOutput.debug("Lexer: OR");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return OR;
          }
        case 70: break;
        case 2: 
          { if ( debug ) {
			TextOutput.debug("Lexer: IDENTIFIER");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return IDENTIFIER;
          }
        case 71: break;
        case 18: 
          { if ( debug ) {
			TextOutput.debug("Lexer: LPAREN");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return LPAREN;
          }
        case 72: break;
        case 33: 
          { if ( debug ) {
			TextOutput.debug("Lexer: IFF");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return IFF;
          }
        case 73: break;
        case 19: 
          { if ( debug ) {
			TextOutput.debug("Lexer: COMMA");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return COMMA;
          }
        case 74: break;
        case 31: 
          { // For mathematica
		if ( debug ) {
			TextOutput.debug("Lexer: AND");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return AND;
          }
        case 75: break;
        case 34: 
          { if ( debug ) {
			TextOutput.debug("Lexer: comment");	
			TextOutput.debug("Lexer @ " + yytext() );
		}
          }
        case 76: break;
        case 28: 
          { if ( debug ) {
			TextOutput.debug("Lexer: CLOSEDIAMOND");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return CLOSEDIAMOND;
          }
        case 77: break;
        case 14: 
          { if ( debug ) {
			TextOutput.debug("Lexer: PLUS");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return PLUS;
          }
        case 78: break;
        case 7: 
          { if ( debug ) {
			TextOutput.debug("Lexer: NOT");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return NOT;
          }
        case 79: break;
        case 25: 
          { if ( debug ) {
			TextOutput.debug("Lexer: ASSIGN");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return ASSIGN;
          }
        case 80: break;
        case 27: 
          { if ( debug ) {
			TextOutput.debug("Lexer: OPENDIAMOND");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return OPENDIAMOND;
          }
        case 81: break;
        case 35: 
          { if ( debug ) {
			TextOutput.debug("Lexer: TRUE");
			TextOutput.debug("Lexer @ " + yytext() );
		}
		return TRUE;
          }
        case 82: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return YYEOF;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
