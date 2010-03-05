// $ANTLR 3.0.1 D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g 2010-03-04 18:50:07

package org.eclipse.papyrus.parsers.antlr;

import org.eclipse.uml2.uml.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;

import org.eclipse.papyrus.parsers.texteditor.parameterlabel.IContext;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ParameterLabelLexer extends Lexer {
    public static final int LT=46;
    public static final int ISNE=45;
    public static final int STAR=19;
    public static final int LSQUARE=15;
    public static final int POINT=37;
    public static final int DOUBLE_QUOTE=27;
    public static final int FOUR_POINTS=40;
    public static final int DOUBLE_LCURLY=31;
    public static final int DOUBLE_LT=47;
    public static final int CALLOPERATION=54;
    public static final int EOF=-1;
    public static final int LOGICAL_AND=33;
    public static final int LPAREN=29;
    public static final int RULE_ASSIGN=41;
    public static final int INOUT=12;
    public static final int T62=62;
    public static final int DOUBLE_PIPE=36;
    public static final int T63=63;
    public static final int T64=64;
    public static final int RANGE_VALUE=16;
    public static final int LNOT=26;
    public static final int SINGLE_QUOTE=28;
    public static final int RPAREN=30;
    public static final int IN=10;
    public static final int INCR=52;
    public static final int COMMA=22;
    public static final int IDENTIFIER=14;
    public static final int INTEGER_OR_REAL_OR_RANGE=58;
    public static final int RETURN=13;
    public static final int TILDE=9;
    public static final int QUESTION_MARK=25;
    public static final int DOUBLE_GT=50;
    public static final int PLUS=6;
    public static final int PIPE=35;
    public static final int NL=24;
    public static final int EQ=20;
    public static final int T61=61;
    public static final int T60=60;
    public static final int INTEGER=17;
    public static final int GE=51;
    public static final int SHARP=8;
    public static final int DOUBLE_RCURLY=32;
    public static final int RANGE=38;
    public static final int UNDERSCORE=56;
    public static final int LCURLY=21;
    public static final int MINUS=7;
    public static final int RSQUARE=18;
    public static final int Tokens=65;
    public static final int SEMI=39;
    public static final int ALPHA=55;
    public static final int COLON=5;
    public static final int REAL=57;
    public static final int WS=4;
    public static final int DOUBLE_LOGICAL_AND=34;
    public static final int OUT=11;
    public static final int RCURLY=23;
    public static final int DECR=53;
    public static final int T59=59;
    public static final int ARROW=42;
    public static final int GT=49;
    public static final int DIV=43;
    public static final int LE=48;
    public static final int ISEQ=44;
    public ParameterLabelLexer() {;} 
    public ParameterLabelLexer(CharStream input) {
        super(input);
        ruleMemo = new HashMap[65+1];
     }
    public String getGrammarFileName() { return "D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g"; }

    // $ANTLR start T59
    public final void mT59() throws RecognitionException {
        try {
            int _type = T59;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:21:5: ( '<Undefined>' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:21:7: '<Undefined>'
            {
            match("<Undefined>"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T59

    // $ANTLR start T60
    public final void mT60() throws RecognitionException {
        try {
            int _type = T60;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:22:5: ( 'ordered' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:22:7: 'ordered'
            {
            match("ordered"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T60

    // $ANTLR start T61
    public final void mT61() throws RecognitionException {
        try {
            int _type = T61;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:23:5: ( 'unique' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:23:7: 'unique'
            {
            match("unique"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T61

    // $ANTLR start T62
    public final void mT62() throws RecognitionException {
        try {
            int _type = T62;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:24:5: ( 'nonunique' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:24:7: 'nonunique'
            {
            match("nonunique"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T62

    // $ANTLR start T63
    public final void mT63() throws RecognitionException {
        try {
            int _type = T63;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:25:5: ( 'exception' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:25:7: 'exception'
            {
            match("exception"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T63

    // $ANTLR start T64
    public final void mT64() throws RecognitionException {
        try {
            int _type = T64;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:26:5: ( 'stream' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:26:7: 'stream'
            {
            match("stream"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T64

    // $ANTLR start NL
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:641:3: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:641:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:641:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='\n') ) {
                    alt1=1;
                }
                else {
                    alt1=3;}
            }
            else if ( (LA1_0=='\n') ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2=='\r') ) {
                    alt1=2;
                }
                else {
                    alt1=4;}
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("641:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:641:7: '\\r' '\\n'
                    {
                    match('\r'); if (failed) return ;
                    match('\n'); if (failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:642:7: '\\n' '\\r'
                    {
                    match('\n'); if (failed) return ;
                    match('\r'); if (failed) return ;

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:643:7: '\\r'
                    {
                    match('\r'); if (failed) return ;

                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:644:7: '\\n'
                    {
                    match('\n'); if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               channel=HIDDEN;
            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NL

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:651:3: ( ( ' ' | '\\t' | '\\f' )+ )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:651:6: ( ' ' | '\\t' | '\\f' )+
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:651:6: ( ' ' | '\\t' | '\\f' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\t'||LA2_0=='\f'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start QUESTION_MARK
    public final void mQUESTION_MARK() throws RecognitionException {
        try {
            int _type = QUESTION_MARK;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:655:3: ( '?' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:655:5: '?'
            {
            match('?'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUESTION_MARK

    // $ANTLR start LNOT
    public final void mLNOT() throws RecognitionException {
        try {
            int _type = LNOT;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:659:3: ( '!' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:659:5: '!'
            {
            match('!'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LNOT

    // $ANTLR start DOUBLE_QUOTE
    public final void mDOUBLE_QUOTE() throws RecognitionException {
        try {
            int _type = DOUBLE_QUOTE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:663:3: ( '\\\"' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:663:5: '\\\"'
            {
            match('\"'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_QUOTE

    // $ANTLR start SINGLE_QUOTE
    public final void mSINGLE_QUOTE() throws RecognitionException {
        try {
            int _type = SINGLE_QUOTE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:667:3: ( '\\'' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:667:5: '\\''
            {
            match('\''); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SINGLE_QUOTE

    // $ANTLR start LPAREN
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:671:3: ( '(' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:671:5: '('
            {
            match('('); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LPAREN

    // $ANTLR start RPAREN
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:675:3: ( ')' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:675:5: ')'
            {
            match(')'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RPAREN

    // $ANTLR start LSQUARE
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:679:3: ( '[' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:679:5: '['
            {
            match('['); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LSQUARE

    // $ANTLR start RSQUARE
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:683:3: ( ']' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:683:5: ']'
            {
            match(']'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RSQUARE

    // $ANTLR start LCURLY
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:687:3: ( '{' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:687:5: '{'
            {
            match('{'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LCURLY

    // $ANTLR start DOUBLE_LCURLY
    public final void mDOUBLE_LCURLY() throws RecognitionException {
        try {
            int _type = DOUBLE_LCURLY;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:691:3: ( '{{' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:691:5: '{{'
            {
            match("{{"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_LCURLY

    // $ANTLR start RCURLY
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:694:3: ( '}' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:694:5: '}'
            {
            match('}'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RCURLY

    // $ANTLR start DOUBLE_RCURLY
    public final void mDOUBLE_RCURLY() throws RecognitionException {
        try {
            int _type = DOUBLE_RCURLY;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:698:3: ( '}}' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:698:5: '}}'
            {
            match("}}"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_RCURLY

    // $ANTLR start LOGICAL_AND
    public final void mLOGICAL_AND() throws RecognitionException {
        try {
            int _type = LOGICAL_AND;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:702:3: ( '&' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:702:5: '&'
            {
            match('&'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LOGICAL_AND

    // $ANTLR start DOUBLE_LOGICAL_AND
    public final void mDOUBLE_LOGICAL_AND() throws RecognitionException {
        try {
            int _type = DOUBLE_LOGICAL_AND;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:706:3: ( '&&' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:706:5: '&&'
            {
            match("&&"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_LOGICAL_AND

    // $ANTLR start PIPE
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:710:3: ( '|' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:710:5: '|'
            {
            match('|'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PIPE

    // $ANTLR start DOUBLE_PIPE
    public final void mDOUBLE_PIPE() throws RecognitionException {
        try {
            int _type = DOUBLE_PIPE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:714:3: ( '||' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:714:5: '||'
            {
            match("||"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_PIPE

    // $ANTLR start POINT
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:718:3: ( '.' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:718:5: '.'
            {
            match('.'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end POINT

    // $ANTLR start RANGE
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:722:3: ( '..' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:722:5: '..'
            {
            match(".."); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RANGE

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:726:3: ( ',' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:726:5: ','
            {
            match(','); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start SEMI
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:730:3: ( ';' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:730:5: ';'
            {
            match(';'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMI

    // $ANTLR start SHARP
    public final void mSHARP() throws RecognitionException {
        try {
            int _type = SHARP;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:734:3: ( '#' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:734:5: '#'
            {
            match('#'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SHARP

    // $ANTLR start TILDE
    public final void mTILDE() throws RecognitionException {
        try {
            int _type = TILDE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:738:3: ( '~' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:738:5: '~'
            {
            match('~'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TILDE

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:742:3: ( ':' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:742:5: ':'
            {
            match(':'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start FOUR_POINTS
    public final void mFOUR_POINTS() throws RecognitionException {
        try {
            int _type = FOUR_POINTS;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:746:3: ( '::' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:746:5: '::'
            {
            match("::"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FOUR_POINTS

    // $ANTLR start RULE_ASSIGN
    public final void mRULE_ASSIGN() throws RecognitionException {
        try {
            int _type = RULE_ASSIGN;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:750:3: ( '::=' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:750:5: '::='
            {
            match("::="); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ASSIGN

    // $ANTLR start ARROW
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:753:3: ( '->' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:753:5: '->'
            {
            match("->"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ARROW

    // $ANTLR start STAR
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:757:3: ( '*' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:757:5: '*'
            {
            match('*'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STAR

    // $ANTLR start DIV
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:761:3: ( '/' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:761:5: '/'
            {
            match('/'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIV

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:765:3: ( '+' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:765:5: '+'
            {
            match('+'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PLUS

    // $ANTLR start MINUS
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:769:3: ( '-' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:769:5: '-'
            {
            match('-'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MINUS

    // $ANTLR start EQ
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:773:3: ( '=' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:773:5: '='
            {
            match('='); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQ

    // $ANTLR start ISEQ
    public final void mISEQ() throws RecognitionException {
        try {
            int _type = ISEQ;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:778:3: ( '==' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:778:5: '=='
            {
            match("=="); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ISEQ

    // $ANTLR start ISNE
    public final void mISNE() throws RecognitionException {
        try {
            int _type = ISNE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:782:3: ( '!=' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:782:5: '!='
            {
            match("!="); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ISNE

    // $ANTLR start LT
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:785:4: ( '<' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:785:6: '<'
            {
            match('<'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LT

    // $ANTLR start DOUBLE_LT
    public final void mDOUBLE_LT() throws RecognitionException {
        try {
            int _type = DOUBLE_LT;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:788:3: ( '<<' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:788:5: '<<'
            {
            match("<<"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_LT

    // $ANTLR start LE
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:792:3: ( '<=' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:792:5: '<='
            {
            match("<="); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LE

    // $ANTLR start GT
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:796:3: ( '>' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:796:5: '>'
            {
            match('>'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GT

    // $ANTLR start DOUBLE_GT
    public final void mDOUBLE_GT() throws RecognitionException {
        try {
            int _type = DOUBLE_GT;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:800:3: ( '>>' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:800:5: '>>'
            {
            match(">>"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_GT

    // $ANTLR start GE
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:804:3: ( '>=' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:804:5: '>='
            {
            match(">="); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GE

    // $ANTLR start INCR
    public final void mINCR() throws RecognitionException {
        try {
            int _type = INCR;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:809:3: ( '++' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:809:5: '++'
            {
            match("++"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INCR

    // $ANTLR start DECR
    public final void mDECR() throws RecognitionException {
        try {
            int _type = DECR;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:813:3: ( '--' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:813:5: '--'
            {
            match("--"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DECR

    // $ANTLR start CALLOPERATION
    public final void mCALLOPERATION() throws RecognitionException {
        try {
            int _type = CALLOPERATION;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:817:3: ( ':=' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:817:5: ':='
            {
            match(":="); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CALLOPERATION

    // $ANTLR start IN
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:821:3: ( 'in' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:821:5: 'in'
            {
            match("in"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IN

    // $ANTLR start OUT
    public final void mOUT() throws RecognitionException {
        try {
            int _type = OUT;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:825:3: ( 'out' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:825:5: 'out'
            {
            match("out"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OUT

    // $ANTLR start INOUT
    public final void mINOUT() throws RecognitionException {
        try {
            int _type = INOUT;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:829:3: ( 'inout' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:829:5: 'inout'
            {
            match("inout"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INOUT

    // $ANTLR start RETURN
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:833:3: ( 'return' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:833:5: 'return'
            {
            match("return"); if (failed) return ;


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RETURN

    // $ANTLR start ALPHA
    public final void mALPHA() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:838:3: ( 'a' .. 'z' | 'A' .. 'Z' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end ALPHA

    // $ANTLR start UNDERSCORE
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:844:3: ( '_' )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:844:5: '_'
            {
            match('_'); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UNDERSCORE

    // $ANTLR start RANGE_VALUE
    public final void mRANGE_VALUE() throws RecognitionException {
        try {
            int _type = RANGE_VALUE;
            Token c1=null;
            Token c2=null;

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:848:3: (c1= INTEGER '..' (c2= INTEGER | c2= STAR ) )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:848:5: c1= INTEGER '..' (c2= INTEGER | c2= STAR )
            {
            int c1Start869 = getCharIndex();
            mINTEGER(); if (failed) return ;
            c1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c1Start869, getCharIndex()-1);
            if ( backtracking==0 ) {
              setText("");
            }
            match(".."); if (failed) return ;

            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:849:3: (c2= INTEGER | c2= STAR )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                alt3=1;
            }
            else if ( (LA3_0=='*') ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("849:3: (c2= INTEGER | c2= STAR )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:849:5: c2= INTEGER
                    {
                    int c2Start881 = getCharIndex();
                    mINTEGER(); if (failed) return ;
                    c2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c2Start881, getCharIndex()-1);
                    if ( backtracking==0 ) {
                       setText(c2.getText());
                    }

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:850:7: c2= STAR
                    {
                    int c2Start894 = getCharIndex();
                    mSTAR(); if (failed) return ;
                    c2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c2Start894, getCharIndex()-1);
                    if ( backtracking==0 ) {
                       setText("-1");
                    }

                    }
                    break;

            }

            if ( backtracking==0 ) {
               
                    setText(getText() + ","+ c1.getText()); 
                 
            }

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RANGE_VALUE

    // $ANTLR start REAL
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:857:3: ( INTEGER '.' INTEGER )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:857:5: INTEGER '.' INTEGER
            {
            mINTEGER(); if (failed) return ;
            match('.'); if (failed) return ;
            mINTEGER(); if (failed) return ;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end REAL

    // $ANTLR start INTEGER_OR_REAL_OR_RANGE
    public final void mINTEGER_OR_REAL_OR_RANGE() throws RecognitionException {
        try {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:862:3: ( ( INTEGER RANGE )=> RANGE_VALUE | ( INTEGER POINT )=> REAL | ( INTEGER )=> INTEGER )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:863:4: ( INTEGER RANGE )=> RANGE_VALUE
                    {
                    mRANGE_VALUE(); if (failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:864:6: ( INTEGER POINT )=> REAL
                    {
                    mREAL(); if (failed) return ;

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:865:6: ( INTEGER )=> INTEGER
                    {
                    mINTEGER(); if (failed) return ;

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end INTEGER_OR_REAL_OR_RANGE

    // $ANTLR start INTEGER
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:869:3: ( ( '0' .. '9' )+ )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:869:5: ( '0' .. '9' )+
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:869:5: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:869:5: '0' .. '9'
            	    {
            	    matchRange('0','9'); if (failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INTEGER

    // $ANTLR start IDENTIFIER
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:872:3: ( ( ALPHA | '0' .. '9' | UNDERSCORE )+ )
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:872:5: ( ALPHA | '0' .. '9' | UNDERSCORE )+
            {
            // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:872:5: ( ALPHA | '0' .. '9' | UNDERSCORE )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    failed=false;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return ;}
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IDENTIFIER

    public void mTokens() throws RecognitionException {
        // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:8: ( T59 | T60 | T61 | T62 | T63 | T64 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | RANGE | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | IN | OUT | INOUT | RETURN | UNDERSCORE | RANGE_VALUE | REAL | INTEGER | IDENTIFIER )
        int alt7=59;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:10: T59
                {
                mT59(); if (failed) return ;

                }
                break;
            case 2 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:14: T60
                {
                mT60(); if (failed) return ;

                }
                break;
            case 3 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:18: T61
                {
                mT61(); if (failed) return ;

                }
                break;
            case 4 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:22: T62
                {
                mT62(); if (failed) return ;

                }
                break;
            case 5 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:26: T63
                {
                mT63(); if (failed) return ;

                }
                break;
            case 6 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:30: T64
                {
                mT64(); if (failed) return ;

                }
                break;
            case 7 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:34: NL
                {
                mNL(); if (failed) return ;

                }
                break;
            case 8 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:37: WS
                {
                mWS(); if (failed) return ;

                }
                break;
            case 9 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:40: QUESTION_MARK
                {
                mQUESTION_MARK(); if (failed) return ;

                }
                break;
            case 10 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:54: LNOT
                {
                mLNOT(); if (failed) return ;

                }
                break;
            case 11 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:59: DOUBLE_QUOTE
                {
                mDOUBLE_QUOTE(); if (failed) return ;

                }
                break;
            case 12 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:72: SINGLE_QUOTE
                {
                mSINGLE_QUOTE(); if (failed) return ;

                }
                break;
            case 13 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:85: LPAREN
                {
                mLPAREN(); if (failed) return ;

                }
                break;
            case 14 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:92: RPAREN
                {
                mRPAREN(); if (failed) return ;

                }
                break;
            case 15 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:99: LSQUARE
                {
                mLSQUARE(); if (failed) return ;

                }
                break;
            case 16 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:107: RSQUARE
                {
                mRSQUARE(); if (failed) return ;

                }
                break;
            case 17 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:115: LCURLY
                {
                mLCURLY(); if (failed) return ;

                }
                break;
            case 18 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:122: DOUBLE_LCURLY
                {
                mDOUBLE_LCURLY(); if (failed) return ;

                }
                break;
            case 19 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:136: RCURLY
                {
                mRCURLY(); if (failed) return ;

                }
                break;
            case 20 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:143: DOUBLE_RCURLY
                {
                mDOUBLE_RCURLY(); if (failed) return ;

                }
                break;
            case 21 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:157: LOGICAL_AND
                {
                mLOGICAL_AND(); if (failed) return ;

                }
                break;
            case 22 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:169: DOUBLE_LOGICAL_AND
                {
                mDOUBLE_LOGICAL_AND(); if (failed) return ;

                }
                break;
            case 23 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:188: PIPE
                {
                mPIPE(); if (failed) return ;

                }
                break;
            case 24 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:193: DOUBLE_PIPE
                {
                mDOUBLE_PIPE(); if (failed) return ;

                }
                break;
            case 25 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:205: POINT
                {
                mPOINT(); if (failed) return ;

                }
                break;
            case 26 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:211: RANGE
                {
                mRANGE(); if (failed) return ;

                }
                break;
            case 27 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:217: COMMA
                {
                mCOMMA(); if (failed) return ;

                }
                break;
            case 28 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:223: SEMI
                {
                mSEMI(); if (failed) return ;

                }
                break;
            case 29 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:228: SHARP
                {
                mSHARP(); if (failed) return ;

                }
                break;
            case 30 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:234: TILDE
                {
                mTILDE(); if (failed) return ;

                }
                break;
            case 31 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:240: COLON
                {
                mCOLON(); if (failed) return ;

                }
                break;
            case 32 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:246: FOUR_POINTS
                {
                mFOUR_POINTS(); if (failed) return ;

                }
                break;
            case 33 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:258: RULE_ASSIGN
                {
                mRULE_ASSIGN(); if (failed) return ;

                }
                break;
            case 34 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:270: ARROW
                {
                mARROW(); if (failed) return ;

                }
                break;
            case 35 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:276: STAR
                {
                mSTAR(); if (failed) return ;

                }
                break;
            case 36 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:281: DIV
                {
                mDIV(); if (failed) return ;

                }
                break;
            case 37 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:285: PLUS
                {
                mPLUS(); if (failed) return ;

                }
                break;
            case 38 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:290: MINUS
                {
                mMINUS(); if (failed) return ;

                }
                break;
            case 39 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:296: EQ
                {
                mEQ(); if (failed) return ;

                }
                break;
            case 40 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:299: ISEQ
                {
                mISEQ(); if (failed) return ;

                }
                break;
            case 41 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:304: ISNE
                {
                mISNE(); if (failed) return ;

                }
                break;
            case 42 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:309: LT
                {
                mLT(); if (failed) return ;

                }
                break;
            case 43 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:312: DOUBLE_LT
                {
                mDOUBLE_LT(); if (failed) return ;

                }
                break;
            case 44 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:322: LE
                {
                mLE(); if (failed) return ;

                }
                break;
            case 45 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:325: GT
                {
                mGT(); if (failed) return ;

                }
                break;
            case 46 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:328: DOUBLE_GT
                {
                mDOUBLE_GT(); if (failed) return ;

                }
                break;
            case 47 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:338: GE
                {
                mGE(); if (failed) return ;

                }
                break;
            case 48 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:341: INCR
                {
                mINCR(); if (failed) return ;

                }
                break;
            case 49 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:346: DECR
                {
                mDECR(); if (failed) return ;

                }
                break;
            case 50 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:351: CALLOPERATION
                {
                mCALLOPERATION(); if (failed) return ;

                }
                break;
            case 51 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:365: IN
                {
                mIN(); if (failed) return ;

                }
                break;
            case 52 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:368: OUT
                {
                mOUT(); if (failed) return ;

                }
                break;
            case 53 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:372: INOUT
                {
                mINOUT(); if (failed) return ;

                }
                break;
            case 54 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:378: RETURN
                {
                mRETURN(); if (failed) return ;

                }
                break;
            case 55 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:385: UNDERSCORE
                {
                mUNDERSCORE(); if (failed) return ;

                }
                break;
            case 56 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:396: RANGE_VALUE
                {
                mRANGE_VALUE(); if (failed) return ;

                }
                break;
            case 57 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:408: REAL
                {
                mREAL(); if (failed) return ;

                }
                break;
            case 58 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:413: INTEGER
                {
                mINTEGER(); if (failed) return ;

                }
                break;
            case 59 :
                // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:1:421: IDENTIFIER
                {
                mIDENTIFIER(); if (failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:863:4: ( INTEGER RANGE )
        // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:863:5: INTEGER RANGE
        {
        mINTEGER(); if (failed) return ;
        mRANGE(); if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:864:6: ( INTEGER POINT )
        // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:864:7: INTEGER POINT
        {
        mINTEGER(); if (failed) return ;
        mPOINT(); if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    // $ANTLR start synpred3
    public final void synpred3_fragment() throws RecognitionException {   
        // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:865:6: ( INTEGER )
        // D:\\Workspaces\\Ganymede\\p2_dev_ws\\org.eclipse.papyrus.parsers\\resources\\grammars\\ParameterLabel.g:865:7: INTEGER
        {
        mINTEGER(); if (failed) return ;

        }
    }
    // $ANTLR end synpred3

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred3() {
        backtracking++;
        int start = input.mark();
        try {
            synpred3_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
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
        for (int i=0; i<numStates; i++) {
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
            return "860:1: fragment INTEGER_OR_REAL_OR_RANGE : ( ( INTEGER RANGE )=> RANGE_VALUE | ( INTEGER POINT )=> REAL | ( INTEGER )=> INTEGER );";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA4_3=='.') && (synpred1())) {s = 4;}

                        else if ( ((LA4_3>='0' && LA4_3<='9')) && (synpred2())) {s = 5;}

                         
                        input.seek(index4_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_1 = input.LA(1);

                         
                        int index4_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA4_1=='.') ) {s = 3;}

                        else if ( ((LA4_1>='0' && LA4_1<='9')) ) {s = 1;}

                        else s = 2;

                         
                        input.seek(index4_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (backtracking>0) {failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA7_eotS =
        "\1\uffff\1\51\5\45\3\uffff\1\61\6\uffff\1\63\1\65\1\67\1\71\1\73"+
        "\4\uffff\1\76\1\101\2\uffff\1\103\1\105\1\110\2\45\1\113\1\114\5"+
        "\uffff\6\45\14\uffff\1\125\14\uffff\1\127\1\45\3\uffff\1\45\1\134"+
        "\4\45\2\uffff\1\45\1\uffff\1\45\2\uffff\1\45\1\uffff\13\45\1\157"+
        "\2\45\1\162\2\45\1\165\1\uffff\1\166\1\167\1\uffff\2\45\3\uffff"+
        "\2\45\1\174\1\175\2\uffff";
    static final String DFA7_eofS =
        "\176\uffff";
    static final String DFA7_minS =
        "\1\11\1\74\1\162\1\156\1\157\1\170\1\164\3\uffff\1\75\6\uffff\1"+
        "\173\1\175\1\46\1\174\1\56\4\uffff\1\72\1\55\2\uffff\1\53\2\75\1"+
        "\156\1\145\1\60\1\56\5\uffff\1\144\1\164\1\151\1\156\1\143\1\162"+
        "\14\uffff\1\75\14\uffff\1\60\1\164\2\uffff\1\56\1\145\1\60\1\161"+
        "\1\165\2\145\2\uffff\1\165\1\uffff\1\165\2\uffff\1\162\1\uffff\1"+
        "\165\1\156\1\160\1\141\1\164\1\162\2\145\1\151\1\164\1\155\1\60"+
        "\1\156\1\144\1\60\1\161\1\151\1\60\1\uffff\2\60\1\uffff\1\165\1"+
        "\157\3\uffff\1\145\1\156\2\60\2\uffff";
    static final String DFA7_maxS =
        "\1\176\1\125\1\165\1\156\1\157\1\170\1\164\3\uffff\1\75\6\uffff"+
        "\1\173\1\175\1\46\1\174\1\56\4\uffff\1\75\1\76\2\uffff\1\53\1\75"+
        "\1\76\1\156\1\145\2\172\5\uffff\1\144\1\164\1\151\1\156\1\143\1"+
        "\162\14\uffff\1\75\14\uffff\1\172\1\164\2\uffff\1\71\1\145\1\172"+
        "\1\161\1\165\2\145\2\uffff\1\165\1\uffff\1\165\2\uffff\1\162\1\uffff"+
        "\1\165\1\156\1\160\1\141\1\164\1\162\2\145\1\151\1\164\1\155\1\172"+
        "\1\156\1\144\1\172\1\161\1\151\1\172\1\uffff\2\172\1\uffff\1\165"+
        "\1\157\3\uffff\1\145\1\156\2\172\2\uffff";
    static final String DFA7_acceptS =
        "\7\uffff\1\7\1\10\1\11\1\uffff\1\13\1\14\1\15\1\16\1\17\1\20\5\uffff"+
        "\1\33\1\34\1\35\1\36\2\uffff\1\43\1\44\7\uffff\1\73\1\1\1\53\1\54"+
        "\1\52\6\uffff\1\51\1\12\1\22\1\21\1\24\1\23\1\26\1\25\1\30\1\27"+
        "\1\32\1\31\1\uffff\1\62\1\37\1\42\1\61\1\46\1\60\1\45\1\50\1\47"+
        "\1\57\1\56\1\55\2\uffff\1\67\1\72\7\uffff\1\41\1\40\1\uffff\1\63"+
        "\1\uffff\1\70\1\71\1\uffff\1\64\22\uffff\1\65\2\uffff\1\3\2\uffff"+
        "\1\6\1\66\1\2\4\uffff\1\4\1\5";
    static final String DFA7_specialS =
        "\176\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\10\1\7\1\uffff\1\10\1\7\22\uffff\1\10\1\12\1\13\1\30\2\uffff"+
            "\1\23\1\14\1\15\1\16\1\34\1\36\1\26\1\33\1\25\1\35\12\44\1\32"+
            "\1\27\1\1\1\37\1\40\1\11\1\uffff\32\45\1\17\1\uffff\1\20\1\uffff"+
            "\1\43\1\uffff\4\45\1\5\3\45\1\41\4\45\1\4\1\2\2\45\1\42\1\6"+
            "\1\45\1\3\5\45\1\21\1\24\1\22\1\31",
            "\1\47\1\50\27\uffff\1\46",
            "\1\52\2\uffff\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "",
            "",
            "",
            "\1\60",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\62",
            "\1\64",
            "\1\66",
            "\1\70",
            "\1\72",
            "",
            "",
            "",
            "",
            "\1\74\2\uffff\1\75",
            "\1\100\20\uffff\1\77",
            "",
            "",
            "\1\102",
            "\1\104",
            "\1\106\1\107",
            "\1\111",
            "\1\112",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\115\1\uffff\12\44\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "",
            "",
            "",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
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
            "\1\124",
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
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\126\13\45",
            "\1\130",
            "",
            "",
            "\1\131\1\uffff\12\132",
            "\1\133",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "",
            "",
            "\1\141",
            "",
            "\1\142",
            "",
            "",
            "\1\143",
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\160",
            "\1\161",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\163",
            "\1\164",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\170",
            "\1\171",
            "",
            "",
            "",
            "\1\172",
            "\1\173",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
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
        for (int i=0; i<numStates; i++) {
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
            return "1:1: Tokens : ( T59 | T60 | T61 | T62 | T63 | T64 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | RANGE | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | IN | OUT | INOUT | RETURN | UNDERSCORE | RANGE_VALUE | REAL | INTEGER | IDENTIFIER );";
        }
    }
 

}