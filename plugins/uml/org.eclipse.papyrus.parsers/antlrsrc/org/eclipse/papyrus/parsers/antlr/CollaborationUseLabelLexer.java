// $ANTLR 3.0.1 D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g 2009-11-05 13:45:23

package org.eclipse.papyrus.parsers.antlr;

import org.eclipse.uml2.uml.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;

import org.eclipse.papyrus.parsers.texteditor.collaborationuselabel.IContext;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class CollaborationUseLabelLexer extends Lexer {

	public static final int LT = 40;

	public static final int STAR = 35;

	public static final int ISNE = 39;

	public static final int LSQUARE = 18;

	public static final int POINT = 28;

	public static final int DOUBLE_QUOTE = 14;

	public static final int FOUR_POINTS = 32;

	public static final int DOUBLE_LCURLY = 21;

	public static final int DOUBLE_LT = 41;

	public static final int CALLOPERATION = 48;

	public static final int EOF = -1;

	public static final int LOGICAL_AND = 24;

	public static final int LPAREN = 16;

	public static final int RULE_ASSIGN = 33;

	public static final int DOUBLE_PIPE = 27;

	public static final int RPAREN = 17;

	public static final int RANGE_VALUE = 52;

	public static final int SINGLE_QUOTE = 15;

	public static final int LNOT = 13;

	public static final int INCR = 46;

	public static final int COMMA = 30;

	public static final int IDENTIFIER = 9;

	public static final int INTEGER_OR_REAL_OR_RANGE = 54;

	public static final int QUESTION_MARK = 12;

	public static final int TILDE = 8;

	public static final int DOUBLE_GT = 44;

	public static final int PLUS = 5;

	public static final int PIPE = 26;

	public static final int NL = 11;

	public static final int EQ = 37;

	public static final int INTEGER = 51;

	public static final int GE = 45;

	public static final int SHARP = 7;

	public static final int DOUBLE_RCURLY = 23;

	public static final int RANGE = 29;

	public static final int UNDERSCORE = 50;

	public static final int LCURLY = 20;

	public static final int RSQUARE = 19;

	public static final int MINUS = 6;

	public static final int Tokens = 56;

	public static final int SEMI = 31;

	public static final int ALPHA = 49;

	public static final int COLON = 4;

	public static final int REAL = 53;

	public static final int WS = 10;

	public static final int DOUBLE_LOGICAL_AND = 25;

	public static final int RCURLY = 22;

	public static final int DECR = 47;

	public static final int GT = 43;

	public static final int ARROW = 34;

	public static final int DIV = 36;

	public static final int LE = 42;

	public static final int T55 = 55;

	public static final int ISEQ = 38;

	public CollaborationUseLabelLexer() {
		;
	}

	public CollaborationUseLabelLexer(CharStream input) {
		super(input);
		ruleMemo = new HashMap[56 + 1];
	}

	public String getGrammarFileName() {
		return "D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g";
	}

	// $ANTLR start T55
	public final void mT55() throws RecognitionException {
		try {
			int _type = T55;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:21:5: ( '<Undefined>' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:21:7: '<Undefined>'
			{
				match("<Undefined>");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end T55

	// $ANTLR start NL
	public final void mNL() throws RecognitionException {
		try {
			int _type = NL;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:337:3: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:337:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
			{
				// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:337:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
				int alt1 = 4;
				int LA1_0 = input.LA(1);

				if((LA1_0 == '\r')) {
					int LA1_1 = input.LA(2);

					if((LA1_1 == '\n')) {
						alt1 = 1;
					} else {
						alt1 = 3;
					}
				} else if((LA1_0 == '\n')) {
					int LA1_2 = input.LA(2);

					if((LA1_2 == '\r')) {
						alt1 = 2;
					} else {
						alt1 = 4;
					}
				} else {
					if(backtracking > 0) {
						failed = true;
						return;
					}
					NoViableAltException nvae =
							new NoViableAltException("337:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )", 1, 0, input);

					throw nvae;
				}
				switch(alt1) {
				case 1:
					// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:337:7: '\\r' '\\n'
				{
					match('\r');
					if(failed)
						return;
					match('\n');
					if(failed)
						return;

				}
					break;
				case 2:
					// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:338:7: '\\n' '\\r'
				{
					match('\n');
					if(failed)
						return;
					match('\r');
					if(failed)
						return;

				}
					break;
				case 3:
					// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:339:7: '\\r'
				{
					match('\r');
					if(failed)
						return;

				}
					break;
				case 4:
					// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:340:7: '\\n'
				{
					match('\n');
					if(failed)
						return;

				}
					break;

				}

				if(backtracking == 0) {
					channel = HIDDEN;
				}

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end NL

	// $ANTLR start WS
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:347:3: ( ( ' ' | '\\t' | '\\f' )+ )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:347:6: ( ' ' | '\\t' | '\\f' )+
			{
				// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:347:6: ( ' ' | '\\t' | '\\f' )+
				int cnt2 = 0;
				loop2: do {
					int alt2 = 2;
					int LA2_0 = input.LA(1);

					if((LA2_0 == '\t' || LA2_0 == '\f' || LA2_0 == ' ')) {
						alt2 = 1;
					}


					switch(alt2) {
					case 1:
						// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:
					{
						if(input.LA(1) == '\t' || input.LA(1) == '\f' || input.LA(1) == ' ') {
							input.consume();
							failed = false;
						} else {
							if(backtracking > 0) {
								failed = true;
								return;
							}
							MismatchedSetException mse =
									new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;

					default:
						if(cnt2 >= 1)
							break loop2;
						if(backtracking > 0) {
							failed = true;
							return;
						}
						EarlyExitException eee =
								new EarlyExitException(2, input);
						throw eee;
					}
					cnt2++;
				} while(true);

				if(backtracking == 0) {
					channel = HIDDEN;
				}

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end WS

	// $ANTLR start QUESTION_MARK
	public final void mQUESTION_MARK() throws RecognitionException {
		try {
			int _type = QUESTION_MARK;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:351:3: ( '?' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:351:5: '?'
			{
				match('?');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end QUESTION_MARK

	// $ANTLR start LNOT
	public final void mLNOT() throws RecognitionException {
		try {
			int _type = LNOT;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:355:3: ( '!' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:355:5: '!'
			{
				match('!');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end LNOT

	// $ANTLR start DOUBLE_QUOTE
	public final void mDOUBLE_QUOTE() throws RecognitionException {
		try {
			int _type = DOUBLE_QUOTE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:359:3: ( '\\\"' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:359:5: '\\\"'
			{
				match('\"');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end DOUBLE_QUOTE

	// $ANTLR start SINGLE_QUOTE
	public final void mSINGLE_QUOTE() throws RecognitionException {
		try {
			int _type = SINGLE_QUOTE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:363:3: ( '\\'' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:363:5: '\\''
			{
				match('\'');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end SINGLE_QUOTE

	// $ANTLR start LPAREN
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:367:3: ( '(' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:367:5: '('
			{
				match('(');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end LPAREN

	// $ANTLR start RPAREN
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:371:3: ( ')' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:371:5: ')'
			{
				match(')');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RPAREN

	// $ANTLR start LSQUARE
	public final void mLSQUARE() throws RecognitionException {
		try {
			int _type = LSQUARE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:375:3: ( '[' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:375:5: '['
			{
				match('[');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end LSQUARE

	// $ANTLR start RSQUARE
	public final void mRSQUARE() throws RecognitionException {
		try {
			int _type = RSQUARE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:379:3: ( ']' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:379:5: ']'
			{
				match(']');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RSQUARE

	// $ANTLR start LCURLY
	public final void mLCURLY() throws RecognitionException {
		try {
			int _type = LCURLY;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:383:3: ( '{' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:383:5: '{'
			{
				match('{');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end LCURLY

	// $ANTLR start DOUBLE_LCURLY
	public final void mDOUBLE_LCURLY() throws RecognitionException {
		try {
			int _type = DOUBLE_LCURLY;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:387:3: ( '{{' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:387:5: '{{'
			{
				match("{{");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end DOUBLE_LCURLY

	// $ANTLR start RCURLY
	public final void mRCURLY() throws RecognitionException {
		try {
			int _type = RCURLY;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:390:3: ( '}' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:390:5: '}'
			{
				match('}');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RCURLY

	// $ANTLR start DOUBLE_RCURLY
	public final void mDOUBLE_RCURLY() throws RecognitionException {
		try {
			int _type = DOUBLE_RCURLY;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:394:3: ( '}}' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:394:5: '}}'
			{
				match("}}");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end DOUBLE_RCURLY

	// $ANTLR start LOGICAL_AND
	public final void mLOGICAL_AND() throws RecognitionException {
		try {
			int _type = LOGICAL_AND;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:398:3: ( '&' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:398:5: '&'
			{
				match('&');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end LOGICAL_AND

	// $ANTLR start DOUBLE_LOGICAL_AND
	public final void mDOUBLE_LOGICAL_AND() throws RecognitionException {
		try {
			int _type = DOUBLE_LOGICAL_AND;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:402:3: ( '&&' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:402:5: '&&'
			{
				match("&&");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end DOUBLE_LOGICAL_AND

	// $ANTLR start PIPE
	public final void mPIPE() throws RecognitionException {
		try {
			int _type = PIPE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:406:3: ( '|' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:406:5: '|'
			{
				match('|');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end PIPE

	// $ANTLR start DOUBLE_PIPE
	public final void mDOUBLE_PIPE() throws RecognitionException {
		try {
			int _type = DOUBLE_PIPE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:410:3: ( '||' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:410:5: '||'
			{
				match("||");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end DOUBLE_PIPE

	// $ANTLR start POINT
	public final void mPOINT() throws RecognitionException {
		try {
			int _type = POINT;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:414:3: ( '.' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:414:5: '.'
			{
				match('.');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end POINT

	// $ANTLR start RANGE
	public final void mRANGE() throws RecognitionException {
		try {
			int _type = RANGE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:418:3: ( '..' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:418:5: '..'
			{
				match("..");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RANGE

	// $ANTLR start COMMA
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:422:3: ( ',' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:422:5: ','
			{
				match(',');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end COMMA

	// $ANTLR start SEMI
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:426:3: ( ';' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:426:5: ';'
			{
				match(';');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end SEMI

	// $ANTLR start SHARP
	public final void mSHARP() throws RecognitionException {
		try {
			int _type = SHARP;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:430:3: ( '#' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:430:5: '#'
			{
				match('#');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end SHARP

	// $ANTLR start TILDE
	public final void mTILDE() throws RecognitionException {
		try {
			int _type = TILDE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:434:3: ( '~' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:434:5: '~'
			{
				match('~');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end TILDE

	// $ANTLR start COLON
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:438:3: ( ':' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:438:5: ':'
			{
				match(':');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end COLON

	// $ANTLR start FOUR_POINTS
	public final void mFOUR_POINTS() throws RecognitionException {
		try {
			int _type = FOUR_POINTS;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:442:3: ( '::' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:442:5: '::'
			{
				match("::");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end FOUR_POINTS

	// $ANTLR start RULE_ASSIGN
	public final void mRULE_ASSIGN() throws RecognitionException {
		try {
			int _type = RULE_ASSIGN;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:446:3: ( '::=' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:446:5: '::='
			{
				match("::=");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RULE_ASSIGN

	// $ANTLR start ARROW
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:449:3: ( '->' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:449:5: '->'
			{
				match("->");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end ARROW

	// $ANTLR start STAR
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:453:3: ( '*' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:453:5: '*'
			{
				match('*');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end STAR

	// $ANTLR start DIV
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:457:3: ( '/' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:457:5: '/'
			{
				match('/');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end DIV

	// $ANTLR start PLUS
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:461:3: ( '+' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:461:5: '+'
			{
				match('+');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end PLUS

	// $ANTLR start MINUS
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:465:3: ( '-' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:465:5: '-'
			{
				match('-');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end MINUS

	// $ANTLR start EQ
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:469:3: ( '=' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:469:5: '='
			{
				match('=');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end EQ

	// $ANTLR start ISEQ
	public final void mISEQ() throws RecognitionException {
		try {
			int _type = ISEQ;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:474:3: ( '==' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:474:5: '=='
			{
				match("==");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end ISEQ

	// $ANTLR start ISNE
	public final void mISNE() throws RecognitionException {
		try {
			int _type = ISNE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:478:3: ( '!=' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:478:5: '!='
			{
				match("!=");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end ISNE

	// $ANTLR start LT
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:481:4: ( '<' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:481:6: '<'
			{
				match('<');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end LT

	// $ANTLR start DOUBLE_LT
	public final void mDOUBLE_LT() throws RecognitionException {
		try {
			int _type = DOUBLE_LT;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:484:3: ( '<<' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:484:5: '<<'
			{
				match("<<");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end DOUBLE_LT

	// $ANTLR start LE
	public final void mLE() throws RecognitionException {
		try {
			int _type = LE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:488:3: ( '<=' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:488:5: '<='
			{
				match("<=");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end LE

	// $ANTLR start GT
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:492:3: ( '>' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:492:5: '>'
			{
				match('>');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end GT

	// $ANTLR start DOUBLE_GT
	public final void mDOUBLE_GT() throws RecognitionException {
		try {
			int _type = DOUBLE_GT;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:496:3: ( '>>' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:496:5: '>>'
			{
				match(">>");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end DOUBLE_GT

	// $ANTLR start GE
	public final void mGE() throws RecognitionException {
		try {
			int _type = GE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:500:3: ( '>=' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:500:5: '>='
			{
				match(">=");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end GE

	// $ANTLR start INCR
	public final void mINCR() throws RecognitionException {
		try {
			int _type = INCR;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:505:3: ( '++' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:505:5: '++'
			{
				match("++");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end INCR

	// $ANTLR start DECR
	public final void mDECR() throws RecognitionException {
		try {
			int _type = DECR;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:509:3: ( '--' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:509:5: '--'
			{
				match("--");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end DECR

	// $ANTLR start CALLOPERATION
	public final void mCALLOPERATION() throws RecognitionException {
		try {
			int _type = CALLOPERATION;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:513:3: ( ':=' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:513:5: ':='
			{
				match(":=");
				if(failed)
					return;


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end CALLOPERATION

	// $ANTLR start ALPHA
	public final void mALPHA() throws RecognitionException {
		try {
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:518:3: ( 'a' .. 'z' | 'A' .. 'Z' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:
			{
				if((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
					input.consume();
					failed = false;
				} else {
					if(backtracking > 0) {
						failed = true;
						return;
					}
					MismatchedSetException mse =
							new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}


			}

		} finally {
		}
	}

	// $ANTLR end ALPHA

	// $ANTLR start UNDERSCORE
	public final void mUNDERSCORE() throws RecognitionException {
		try {
			int _type = UNDERSCORE;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:524:3: ( '_' )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:524:5: '_'
			{
				match('_');
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end UNDERSCORE

	// $ANTLR start RANGE_VALUE
	public final void mRANGE_VALUE() throws RecognitionException {
		try {
			int _type = RANGE_VALUE;
			Token c1 = null;
			Token c2 = null;

			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:528:3: (c1= INTEGER '..' (c2= INTEGER | c2= STAR ) )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:528:5: c1= INTEGER '..' (c2= INTEGER | c2= STAR )
			{
				int c1Start770 = getCharIndex();
				mINTEGER();
				if(failed)
					return;
				c1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c1Start770, getCharIndex() - 1);
				if(backtracking == 0) {
					setText("");
				}
				match("..");
				if(failed)
					return;

				// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:529:3: (c2= INTEGER | c2= STAR )
				int alt3 = 2;
				int LA3_0 = input.LA(1);

				if(((LA3_0 >= '0' && LA3_0 <= '9'))) {
					alt3 = 1;
				} else if((LA3_0 == '*')) {
					alt3 = 2;
				} else {
					if(backtracking > 0) {
						failed = true;
						return;
					}
					NoViableAltException nvae =
							new NoViableAltException("529:3: (c2= INTEGER | c2= STAR )", 3, 0, input);

					throw nvae;
				}
				switch(alt3) {
				case 1:
					// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:529:5: c2= INTEGER
				{
					int c2Start782 = getCharIndex();
					mINTEGER();
					if(failed)
						return;
					c2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c2Start782, getCharIndex() - 1);
					if(backtracking == 0) {
						setText(c2.getText());
					}

				}
					break;
				case 2:
					// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:530:7: c2= STAR
				{
					int c2Start795 = getCharIndex();
					mSTAR();
					if(failed)
						return;
					c2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c2Start795, getCharIndex() - 1);
					if(backtracking == 0) {
						setText("-1");
					}

				}
					break;

				}

				if(backtracking == 0) {

					setText(getText() + "," + c1.getText());

				}

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end RANGE_VALUE

	// $ANTLR start REAL
	public final void mREAL() throws RecognitionException {
		try {
			int _type = REAL;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:537:3: ( INTEGER '.' INTEGER )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:537:5: INTEGER '.' INTEGER
			{
				mINTEGER();
				if(failed)
					return;
				match('.');
				if(failed)
					return;
				mINTEGER();
				if(failed)
					return;

			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end REAL

	// $ANTLR start INTEGER_OR_REAL_OR_RANGE
	public final void mINTEGER_OR_REAL_OR_RANGE() throws RecognitionException {
		try {
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:542:3: ( ( INTEGER RANGE )=> RANGE_VALUE | ( INTEGER POINT )=> REAL | ( INTEGER )=> INTEGER )
			int alt4 = 3;
			alt4 = dfa4.predict(input);
			switch(alt4) {
			case 1:
				// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:543:4: ( INTEGER RANGE )=> RANGE_VALUE
			{
				mRANGE_VALUE();
				if(failed)
					return;

			}
				break;
			case 2:
				// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:544:6: ( INTEGER POINT )=> REAL
			{
				mREAL();
				if(failed)
					return;

			}
				break;
			case 3:
				// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:545:6: ( INTEGER )=> INTEGER
			{
				mINTEGER();
				if(failed)
					return;

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end INTEGER_OR_REAL_OR_RANGE

	// $ANTLR start INTEGER
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:549:3: ( ( '0' .. '9' )+ )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:549:5: ( '0' .. '9' )+
			{
				// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:549:5: ( '0' .. '9' )+
				int cnt5 = 0;
				loop5: do {
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if(((LA5_0 >= '0' && LA5_0 <= '9'))) {
						alt5 = 1;
					}


					switch(alt5) {
					case 1:
						// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:549:5: '0' .. '9'
					{
						matchRange('0', '9');
						if(failed)
							return;

					}
						break;

					default:
						if(cnt5 >= 1)
							break loop5;
						if(backtracking > 0) {
							failed = true;
							return;
						}
						EarlyExitException eee =
								new EarlyExitException(5, input);
						throw eee;
					}
					cnt5++;
				} while(true);


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end INTEGER

	// $ANTLR start IDENTIFIER
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:552:3: ( ( ALPHA | '0' .. '9' | UNDERSCORE )+ )
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:552:5: ( ALPHA | '0' .. '9' | UNDERSCORE )+
			{
				// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:552:5: ( ALPHA | '0' .. '9' | UNDERSCORE )+
				int cnt6 = 0;
				loop6: do {
					int alt6 = 2;
					int LA6_0 = input.LA(1);

					if(((LA6_0 >= '0' && LA6_0 <= '9') || (LA6_0 >= 'A' && LA6_0 <= 'Z') || LA6_0 == '_' || (LA6_0 >= 'a' && LA6_0 <= 'z'))) {
						alt6 = 1;
					}


					switch(alt6) {
					case 1:
						// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:
					{
						if((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
							input.consume();
							failed = false;
						} else {
							if(backtracking > 0) {
								failed = true;
								return;
							}
							MismatchedSetException mse =
									new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
						break;

					default:
						if(cnt6 >= 1)
							break loop6;
						if(backtracking > 0) {
							failed = true;
							return;
						}
						EarlyExitException eee =
								new EarlyExitException(6, input);
						throw eee;
					}
					cnt6++;
				} while(true);


			}

			this.type = _type;
		} finally {
		}
	}

	// $ANTLR end IDENTIFIER

	public void mTokens() throws RecognitionException {
		// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:8: ( T55 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | RANGE | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | UNDERSCORE | RANGE_VALUE | REAL | INTEGER | IDENTIFIER )
		int alt7 = 50;
		alt7 = dfa7.predict(input);
		switch(alt7) {
		case 1:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:10: T55
		{
			mT55();
			if(failed)
				return;

		}
			break;
		case 2:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:14: NL
		{
			mNL();
			if(failed)
				return;

		}
			break;
		case 3:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:17: WS
		{
			mWS();
			if(failed)
				return;

		}
			break;
		case 4:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:20: QUESTION_MARK
		{
			mQUESTION_MARK();
			if(failed)
				return;

		}
			break;
		case 5:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:34: LNOT
		{
			mLNOT();
			if(failed)
				return;

		}
			break;
		case 6:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:39: DOUBLE_QUOTE
		{
			mDOUBLE_QUOTE();
			if(failed)
				return;

		}
			break;
		case 7:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:52: SINGLE_QUOTE
		{
			mSINGLE_QUOTE();
			if(failed)
				return;

		}
			break;
		case 8:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:65: LPAREN
		{
			mLPAREN();
			if(failed)
				return;

		}
			break;
		case 9:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:72: RPAREN
		{
			mRPAREN();
			if(failed)
				return;

		}
			break;
		case 10:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:79: LSQUARE
		{
			mLSQUARE();
			if(failed)
				return;

		}
			break;
		case 11:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:87: RSQUARE
		{
			mRSQUARE();
			if(failed)
				return;

		}
			break;
		case 12:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:95: LCURLY
		{
			mLCURLY();
			if(failed)
				return;

		}
			break;
		case 13:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:102: DOUBLE_LCURLY
		{
			mDOUBLE_LCURLY();
			if(failed)
				return;

		}
			break;
		case 14:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:116: RCURLY
		{
			mRCURLY();
			if(failed)
				return;

		}
			break;
		case 15:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:123: DOUBLE_RCURLY
		{
			mDOUBLE_RCURLY();
			if(failed)
				return;

		}
			break;
		case 16:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:137: LOGICAL_AND
		{
			mLOGICAL_AND();
			if(failed)
				return;

		}
			break;
		case 17:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:149: DOUBLE_LOGICAL_AND
		{
			mDOUBLE_LOGICAL_AND();
			if(failed)
				return;

		}
			break;
		case 18:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:168: PIPE
		{
			mPIPE();
			if(failed)
				return;

		}
			break;
		case 19:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:173: DOUBLE_PIPE
		{
			mDOUBLE_PIPE();
			if(failed)
				return;

		}
			break;
		case 20:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:185: POINT
		{
			mPOINT();
			if(failed)
				return;

		}
			break;
		case 21:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:191: RANGE
		{
			mRANGE();
			if(failed)
				return;

		}
			break;
		case 22:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:197: COMMA
		{
			mCOMMA();
			if(failed)
				return;

		}
			break;
		case 23:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:203: SEMI
		{
			mSEMI();
			if(failed)
				return;

		}
			break;
		case 24:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:208: SHARP
		{
			mSHARP();
			if(failed)
				return;

		}
			break;
		case 25:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:214: TILDE
		{
			mTILDE();
			if(failed)
				return;

		}
			break;
		case 26:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:220: COLON
		{
			mCOLON();
			if(failed)
				return;

		}
			break;
		case 27:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:226: FOUR_POINTS
		{
			mFOUR_POINTS();
			if(failed)
				return;

		}
			break;
		case 28:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:238: RULE_ASSIGN
		{
			mRULE_ASSIGN();
			if(failed)
				return;

		}
			break;
		case 29:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:250: ARROW
		{
			mARROW();
			if(failed)
				return;

		}
			break;
		case 30:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:256: STAR
		{
			mSTAR();
			if(failed)
				return;

		}
			break;
		case 31:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:261: DIV
		{
			mDIV();
			if(failed)
				return;

		}
			break;
		case 32:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:265: PLUS
		{
			mPLUS();
			if(failed)
				return;

		}
			break;
		case 33:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:270: MINUS
		{
			mMINUS();
			if(failed)
				return;

		}
			break;
		case 34:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:276: EQ
		{
			mEQ();
			if(failed)
				return;

		}
			break;
		case 35:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:279: ISEQ
		{
			mISEQ();
			if(failed)
				return;

		}
			break;
		case 36:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:284: ISNE
		{
			mISNE();
			if(failed)
				return;

		}
			break;
		case 37:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:289: LT
		{
			mLT();
			if(failed)
				return;

		}
			break;
		case 38:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:292: DOUBLE_LT
		{
			mDOUBLE_LT();
			if(failed)
				return;

		}
			break;
		case 39:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:302: LE
		{
			mLE();
			if(failed)
				return;

		}
			break;
		case 40:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:305: GT
		{
			mGT();
			if(failed)
				return;

		}
			break;
		case 41:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:308: DOUBLE_GT
		{
			mDOUBLE_GT();
			if(failed)
				return;

		}
			break;
		case 42:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:318: GE
		{
			mGE();
			if(failed)
				return;

		}
			break;
		case 43:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:321: INCR
		{
			mINCR();
			if(failed)
				return;

		}
			break;
		case 44:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:326: DECR
		{
			mDECR();
			if(failed)
				return;

		}
			break;
		case 45:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:331: CALLOPERATION
		{
			mCALLOPERATION();
			if(failed)
				return;

		}
			break;
		case 46:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:345: UNDERSCORE
		{
			mUNDERSCORE();
			if(failed)
				return;

		}
			break;
		case 47:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:356: RANGE_VALUE
		{
			mRANGE_VALUE();
			if(failed)
				return;

		}
			break;
		case 48:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:368: REAL
		{
			mREAL();
			if(failed)
				return;

		}
			break;
		case 49:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:373: INTEGER
		{
			mINTEGER();
			if(failed)
				return;

		}
			break;
		case 50:
			// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:1:381: IDENTIFIER
		{
			mIDENTIFIER();
			if(failed)
				return;

		}
			break;

		}

	}

	// $ANTLR start synpred1
	public final void synpred1_fragment() throws RecognitionException {
		// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:543:4: ( INTEGER RANGE )
		// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:543:5: INTEGER RANGE
		{
			mINTEGER();
			if(failed)
				return;
			mRANGE();
			if(failed)
				return;

		}
	}

	// $ANTLR end synpred1

	// $ANTLR start synpred2
	public final void synpred2_fragment() throws RecognitionException {
		// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:544:6: ( INTEGER POINT )
		// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:544:7: INTEGER POINT
		{
			mINTEGER();
			if(failed)
				return;
			mPOINT();
			if(failed)
				return;

		}
	}

	// $ANTLR end synpred2

	// $ANTLR start synpred3
	public final void synpred3_fragment() throws RecognitionException {
		// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:545:6: ( INTEGER )
		// D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\CollaborationUseLabel.g:545:7: INTEGER
		{
			mINTEGER();
			if(failed)
				return;

		}
	}

	// $ANTLR end synpred3

	public final boolean synpred1() {
		backtracking++;
		int start = input.mark();
		try {
			synpred1_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !failed;
		input.rewind(start);
		backtracking--;
		failed = false;
		return success;
	}

	public final boolean synpred2() {
		backtracking++;
		int start = input.mark();
		try {
			synpred2_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !failed;
		input.rewind(start);
		backtracking--;
		failed = false;
		return success;
	}

	public final boolean synpred3() {
		backtracking++;
		int start = input.mark();
		try {
			synpred3_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !failed;
		input.rewind(start);
		backtracking--;
		failed = false;
		return success;
	}


	protected DFA4 dfa4 = new DFA4(this);

	protected DFA7 dfa7 = new DFA7(this);

	static final String DFA4_eotS =
			"\1\uffff\1\2\4\uffff";

	static final String DFA4_eofS =
			"\6\uffff";

	static final String DFA4_minS =
			"\1\60\1\56\1\uffff\1\56\2\uffff";

	static final String DFA4_maxS =
			"\2\71\1\uffff\1\71\2\uffff";

	static final String DFA4_acceptS =
			"\2\uffff\1\3\1\uffff\1\1\1\2";

	static final String DFA4_specialS =
			"\1\uffff\1\1\1\uffff\1\0\2\uffff}>";

	static final String[] DFA4_transitionS = {
			"\12\1",
			"\1\3\1\uffff\12\1",
			"",
			"\1\4\1\uffff\12\5",
			"",
			""
			};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);

	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);

	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);

	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);

	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);

	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);

	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for(int i = 0; i < numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}

		public String getDescription() {
			return "540:1: fragment INTEGER_OR_REAL_OR_RANGE : ( ( INTEGER RANGE )=> RANGE_VALUE | ( INTEGER POINT )=> REAL | ( INTEGER )=> INTEGER );";
		}

		public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
			int _s = s;
			switch(s) {
			case 0:
				int LA4_3 = input.LA(1);


				int index4_3 = input.index();
				input.rewind();
				s = -1;
				if((LA4_3 == '.') && (synpred1())) {
					s = 4;
				}

				else if(((LA4_3 >= '0' && LA4_3 <= '9')) && (synpred2())) {
					s = 5;
				}


				input.seek(index4_3);
				if(s >= 0)
					return s;
				break;
			case 1:
				int LA4_1 = input.LA(1);


				int index4_1 = input.index();
				input.rewind();
				s = -1;
				if((LA4_1 == '.')) {
					s = 3;
				}

				else if(((LA4_1 >= '0' && LA4_1 <= '9'))) {
					s = 1;
				}

				else
					s = 2;


				input.seek(index4_1);
				if(s >= 0)
					return s;
				break;
			}
			if(backtracking > 0) {
				failed = true;
				return -1;
			}
			NoViableAltException nvae =
					new NoViableAltException(getDescription(), 4, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA7_eotS =
			"\1\uffff\1\42\3\uffff\1\44\6\uffff\1\46\1\50\1\52\1\54\1\56\4\uffff" +
			"\1\61\1\64\2\uffff\1\66\1\70\1\73\1\74\1\75\21\uffff\1\100\23\uffff";

	static final String DFA7_eofS =
			"\103\uffff";

	static final String DFA7_minS =
			"\1\11\1\74\3\uffff\1\75\6\uffff\1\173\1\175\1\46\1\174\1\56\4\uffff" +
			"\1\72\1\55\2\uffff\1\53\2\75\1\60\1\56\21\uffff\1\75\16\uffff\1" +
			"\56\4\uffff";

	static final String DFA7_maxS =
			"\1\176\1\125\3\uffff\1\75\6\uffff\1\173\1\175\1\46\1\174\1\56\4" +
			"\uffff\1\75\1\76\2\uffff\1\53\1\75\1\76\2\172\21\uffff\1\75\16\uffff" +
			"\1\71\4\uffff";

	static final String DFA7_acceptS =
			"\2\uffff\1\2\1\3\1\4\1\uffff\1\6\1\7\1\10\1\11\1\12\1\13\5\uffff" +
			"\1\26\1\27\1\30\1\31\2\uffff\1\36\1\37\5\uffff\1\62\1\47\1\46\1" +
			"\1\1\45\1\44\1\5\1\15\1\14\1\17\1\16\1\21\1\20\1\23\1\22\1\25\1" +
			"\24\1\uffff\1\55\1\32\1\35\1\54\1\41\1\53\1\40\1\43\1\42\1\52\1" +
			"\51\1\50\1\56\1\61\1\uffff\1\34\1\33\1\57\1\60";

	static final String DFA7_specialS =
			"\103\uffff}>";

	static final String[] DFA7_transitionS = {
			"\1\3\1\2\1\uffff\1\3\1\2\22\uffff\1\3\1\5\1\6\1\23\2\uffff\1" +
			"\16\1\7\1\10\1\11\1\27\1\31\1\21\1\26\1\20\1\30\12\35\1\25\1" +
			"\22\1\1\1\32\1\33\1\4\1\uffff\32\36\1\12\1\uffff\1\13\1\uffff" +
			"\1\34\1\uffff\32\36\1\14\1\17\1\15\1\24",
			"\1\40\1\37\27\uffff\1\41",
			"",
			"",
			"",
			"\1\43",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\45",
			"\1\47",
			"\1\51",
			"\1\53",
			"\1\55",
			"",
			"",
			"",
			"",
			"\1\57\2\uffff\1\60",
			"\1\63\20\uffff\1\62",
			"",
			"",
			"\1\65",
			"\1\67",
			"\1\71\1\72",
			"\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"\1\76\1\uffff\12\35\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\77",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\101\1\uffff\12\102",
			"",
			"",
			"",
			""
			};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);

	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);

	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);

	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);

	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);

	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);

	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for(int i = 0; i < numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}

		public String getDescription() {
			return "1:1: Tokens : ( T55 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | RANGE | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | UNDERSCORE | RANGE_VALUE | REAL | INTEGER | IDENTIFIER );";
		}
	}


}
