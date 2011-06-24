// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g 2011-03-15 17:01:08

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
    public static final int COMMA=30;
    public static final int DOUBLE_LT=41;
    public static final int ISEQ=38;
    public static final int MINUS=6;
    public static final int INCR=46;
    public static final int SHARP=7;
    public static final int DOUBLE_RCURLY=23;
    public static final int DECR=47;
    public static final int ARROW=34;
    public static final int DOUBLE_GT=44;
    public static final int RULE_ASSIGN=33;
    public static final int TILDE=8;
    public static final int PIPE=26;
    public static final int DOUBLE_PIPE=27;
    public static final int QUESTION_MARK=12;
    public static final int INTEGER=51;
    public static final int RCURLY=22;
    public static final int NL=11;
    public static final int LCURLY=20;
    public static final int LE=42;
    public static final int RPAREN=17;
    public static final int LPAREN=16;
    public static final int SINGLE_QUOTE=15;
    public static final int PLUS=5;
    public static final int REAL=53;
    public static final int LSQUARE=18;
    public static final int RANGE=29;
    public static final int FOUR_POINTS=32;
    public static final int DOUBLE_LCURLY=21;
    public static final int POINT=28;
    public static final int WS=10;
    public static final int ALPHA=49;
    public static final int EQ=37;
    public static final int LT=40;
    public static final int GT=43;
    public static final int DOUBLE_QUOTE=14;
    public static final int RSQUARE=19;
    public static final int DOUBLE_LOGICAL_AND=25;
    public static final int RANGE_VALUE=52;
    public static final int T__55=55;
    public static final int SEMI=31;
    public static final int GE=45;
    public static final int LNOT=13;
    public static final int ISNE=39;
    public static final int LOGICAL_AND=24;
    public static final int EOF=-1;
    public static final int COLON=4;
    public static final int DIV=36;
    public static final int INTEGER_OR_REAL_OR_RANGE=54;
    public static final int STAR=35;
    public static final int IDENTIFIER=9;
    public static final int UNDERSCORE=50;
    public static final int CALLOPERATION=48;

    // delegates
    // delegators

    public CollaborationUseLabelLexer() {;} 
    public CollaborationUseLabelLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CollaborationUseLabelLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g"; }

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:22:7: ( '<Undefined>' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:22:9: '<Undefined>'
            {
            match("<Undefined>"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:319:3: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:319:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:319:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:319:7: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:320:7: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:321:7: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:322:7: '\\n'
                    {
                    match('\n'); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               _channel=HIDDEN;
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:329:3: ( ( ' ' | '\\t' | '\\f' )+ )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:329:6: ( ' ' | '\\t' | '\\f' )+
            {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:329:6: ( ' ' | '\\t' | '\\f' )+
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
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            if ( state.backtracking==0 ) {
              _channel=HIDDEN;
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "QUESTION_MARK"
    public final void mQUESTION_MARK() throws RecognitionException {
        try {
            int _type = QUESTION_MARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:333:3: ( '?' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:333:5: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUESTION_MARK"

    // $ANTLR start "LNOT"
    public final void mLNOT() throws RecognitionException {
        try {
            int _type = LNOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:337:3: ( '!' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:337:5: '!'
            {
            match('!'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LNOT"

    // $ANTLR start "DOUBLE_QUOTE"
    public final void mDOUBLE_QUOTE() throws RecognitionException {
        try {
            int _type = DOUBLE_QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:341:3: ( '\\\"' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:341:5: '\\\"'
            {
            match('\"'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_QUOTE"

    // $ANTLR start "SINGLE_QUOTE"
    public final void mSINGLE_QUOTE() throws RecognitionException {
        try {
            int _type = SINGLE_QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:345:3: ( '\\'' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:345:5: '\\''
            {
            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINGLE_QUOTE"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:349:3: ( '(' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:349:5: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:353:3: ( ')' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:353:5: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:357:3: ( '[' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:357:5: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LSQUARE"

    // $ANTLR start "RSQUARE"
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:361:3: ( ']' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:361:5: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RSQUARE"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:365:3: ( '{' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:365:5: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "DOUBLE_LCURLY"
    public final void mDOUBLE_LCURLY() throws RecognitionException {
        try {
            int _type = DOUBLE_LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:369:3: ( '{{' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:369:5: '{{'
            {
            match("{{"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:372:3: ( '}' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:372:5: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "DOUBLE_RCURLY"
    public final void mDOUBLE_RCURLY() throws RecognitionException {
        try {
            int _type = DOUBLE_RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:376:3: ( '}}' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:376:5: '}}'
            {
            match("}}"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_RCURLY"

    // $ANTLR start "LOGICAL_AND"
    public final void mLOGICAL_AND() throws RecognitionException {
        try {
            int _type = LOGICAL_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:380:3: ( '&' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:380:5: '&'
            {
            match('&'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOGICAL_AND"

    // $ANTLR start "DOUBLE_LOGICAL_AND"
    public final void mDOUBLE_LOGICAL_AND() throws RecognitionException {
        try {
            int _type = DOUBLE_LOGICAL_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:384:3: ( '&&' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:384:5: '&&'
            {
            match("&&"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_LOGICAL_AND"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:388:3: ( '|' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:388:5: '|'
            {
            match('|'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPE"

    // $ANTLR start "DOUBLE_PIPE"
    public final void mDOUBLE_PIPE() throws RecognitionException {
        try {
            int _type = DOUBLE_PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:392:3: ( '||' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:392:5: '||'
            {
            match("||"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_PIPE"

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:396:3: ( '.' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:396:5: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POINT"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:400:3: ( '..' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:400:5: '..'
            {
            match(".."); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:404:3: ( ',' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:404:5: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:408:3: ( ';' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:408:5: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "SHARP"
    public final void mSHARP() throws RecognitionException {
        try {
            int _type = SHARP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:412:3: ( '#' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:412:5: '#'
            {
            match('#'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHARP"

    // $ANTLR start "TILDE"
    public final void mTILDE() throws RecognitionException {
        try {
            int _type = TILDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:416:3: ( '~' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:416:5: '~'
            {
            match('~'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TILDE"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:420:3: ( ':' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:420:5: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "FOUR_POINTS"
    public final void mFOUR_POINTS() throws RecognitionException {
        try {
            int _type = FOUR_POINTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:424:3: ( '::' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:424:5: '::'
            {
            match("::"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOUR_POINTS"

    // $ANTLR start "RULE_ASSIGN"
    public final void mRULE_ASSIGN() throws RecognitionException {
        try {
            int _type = RULE_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:428:3: ( '::=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:428:5: '::='
            {
            match("::="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ASSIGN"

    // $ANTLR start "ARROW"
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:431:3: ( '->' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:431:5: '->'
            {
            match("->"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ARROW"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:435:3: ( '*' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:435:5: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:439:3: ( '/' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:439:5: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:443:3: ( '+' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:443:5: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:447:3: ( '-' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:447:5: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:451:3: ( '=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:451:5: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "ISEQ"
    public final void mISEQ() throws RecognitionException {
        try {
            int _type = ISEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:456:3: ( '==' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:456:5: '=='
            {
            match("=="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISEQ"

    // $ANTLR start "ISNE"
    public final void mISNE() throws RecognitionException {
        try {
            int _type = ISNE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:460:3: ( '!=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:460:5: '!='
            {
            match("!="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISNE"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:463:4: ( '<' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:463:6: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "DOUBLE_LT"
    public final void mDOUBLE_LT() throws RecognitionException {
        try {
            int _type = DOUBLE_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:466:3: ( '<<' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:466:5: '<<'
            {
            match("<<"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_LT"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:470:3: ( '<=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:470:5: '<='
            {
            match("<="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:474:3: ( '>' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:474:5: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "DOUBLE_GT"
    public final void mDOUBLE_GT() throws RecognitionException {
        try {
            int _type = DOUBLE_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:478:3: ( '>>' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:478:5: '>>'
            {
            match(">>"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_GT"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:482:3: ( '>=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:482:5: '>='
            {
            match(">="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "INCR"
    public final void mINCR() throws RecognitionException {
        try {
            int _type = INCR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:487:3: ( '++' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:487:5: '++'
            {
            match("++"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCR"

    // $ANTLR start "DECR"
    public final void mDECR() throws RecognitionException {
        try {
            int _type = DECR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:491:3: ( '--' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:491:5: '--'
            {
            match("--"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECR"

    // $ANTLR start "CALLOPERATION"
    public final void mCALLOPERATION() throws RecognitionException {
        try {
            int _type = CALLOPERATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:495:3: ( ':=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:495:5: ':='
            {
            match(":="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CALLOPERATION"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:500:3: ( 'a' .. 'z' | 'A' .. 'Z' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:506:3: ( '_' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:506:5: '_'
            {
            match('_'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "RANGE_VALUE"
    public final void mRANGE_VALUE() throws RecognitionException {
        try {
            int _type = RANGE_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken c1=null;
            CommonToken c2=null;

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:510:3: (c1= INTEGER '..' (c2= INTEGER | c2= STAR ) )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:510:5: c1= INTEGER '..' (c2= INTEGER | c2= STAR )
            {
            int c1Start771 = getCharIndex();
            mINTEGER(); if (state.failed) return ;
            c1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c1Start771, getCharIndex()-1);
            if ( state.backtracking==0 ) {
              setText("");
            }
            match(".."); if (state.failed) return ;

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:511:3: (c2= INTEGER | c2= STAR )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                alt3=1;
            }
            else if ( (LA3_0=='*') ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:511:5: c2= INTEGER
                    {
                    int c2Start783 = getCharIndex();
                    mINTEGER(); if (state.failed) return ;
                    c2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c2Start783, getCharIndex()-1);
                    if ( state.backtracking==0 ) {
                       setText((c2!=null?c2.getText():null));
                    }

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:512:7: c2= STAR
                    {
                    int c2Start796 = getCharIndex();
                    mSTAR(); if (state.failed) return ;
                    c2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c2Start796, getCharIndex()-1);
                    if ( state.backtracking==0 ) {
                       setText("-1");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
                    setText(getText() + ","+ (c1!=null?c1.getText():null)); 
                 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE_VALUE"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:519:3: ( INTEGER '.' INTEGER )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:519:5: INTEGER '.' INTEGER
            {
            mINTEGER(); if (state.failed) return ;
            match('.'); if (state.failed) return ;
            mINTEGER(); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "INTEGER_OR_REAL_OR_RANGE"
    public final void mINTEGER_OR_REAL_OR_RANGE() throws RecognitionException {
        try {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:524:3: ( ( INTEGER RANGE )=> RANGE_VALUE | ( INTEGER POINT )=> REAL | ( INTEGER )=> INTEGER )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:525:4: ( INTEGER RANGE )=> RANGE_VALUE
                    {
                    mRANGE_VALUE(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:526:6: ( INTEGER POINT )=> REAL
                    {
                    mREAL(); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:527:6: ( INTEGER )=> INTEGER
                    {
                    mINTEGER(); if (state.failed) return ;

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER_OR_REAL_OR_RANGE"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:531:3: ( ( '0' .. '9' )+ )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:531:5: ( '0' .. '9' )+
            {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:531:5: ( '0' .. '9' )+
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
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:531:5: '0' .. '9'
            	    {
            	    matchRange('0','9'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:534:3: ( ( ALPHA | '0' .. '9' | UNDERSCORE )+ )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:534:5: ( ALPHA | '0' .. '9' | UNDERSCORE )+
            {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:534:5: ( ALPHA | '0' .. '9' | UNDERSCORE )+
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
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    public void mTokens() throws RecognitionException {
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:8: ( T__55 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | RANGE | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | UNDERSCORE | RANGE_VALUE | REAL | INTEGER | IDENTIFIER )
        int alt7=50;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:10: T__55
                {
                mT__55(); if (state.failed) return ;

                }
                break;
            case 2 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:16: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 3 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:19: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 4 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:22: QUESTION_MARK
                {
                mQUESTION_MARK(); if (state.failed) return ;

                }
                break;
            case 5 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:36: LNOT
                {
                mLNOT(); if (state.failed) return ;

                }
                break;
            case 6 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:41: DOUBLE_QUOTE
                {
                mDOUBLE_QUOTE(); if (state.failed) return ;

                }
                break;
            case 7 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:54: SINGLE_QUOTE
                {
                mSINGLE_QUOTE(); if (state.failed) return ;

                }
                break;
            case 8 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:67: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 9 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:74: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 10 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:81: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 11 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:89: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 12 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:97: LCURLY
                {
                mLCURLY(); if (state.failed) return ;

                }
                break;
            case 13 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:104: DOUBLE_LCURLY
                {
                mDOUBLE_LCURLY(); if (state.failed) return ;

                }
                break;
            case 14 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:118: RCURLY
                {
                mRCURLY(); if (state.failed) return ;

                }
                break;
            case 15 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:125: DOUBLE_RCURLY
                {
                mDOUBLE_RCURLY(); if (state.failed) return ;

                }
                break;
            case 16 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:139: LOGICAL_AND
                {
                mLOGICAL_AND(); if (state.failed) return ;

                }
                break;
            case 17 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:151: DOUBLE_LOGICAL_AND
                {
                mDOUBLE_LOGICAL_AND(); if (state.failed) return ;

                }
                break;
            case 18 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:170: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 19 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:175: DOUBLE_PIPE
                {
                mDOUBLE_PIPE(); if (state.failed) return ;

                }
                break;
            case 20 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:187: POINT
                {
                mPOINT(); if (state.failed) return ;

                }
                break;
            case 21 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:193: RANGE
                {
                mRANGE(); if (state.failed) return ;

                }
                break;
            case 22 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:199: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 23 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:205: SEMI
                {
                mSEMI(); if (state.failed) return ;

                }
                break;
            case 24 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:210: SHARP
                {
                mSHARP(); if (state.failed) return ;

                }
                break;
            case 25 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:216: TILDE
                {
                mTILDE(); if (state.failed) return ;

                }
                break;
            case 26 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:222: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 27 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:228: FOUR_POINTS
                {
                mFOUR_POINTS(); if (state.failed) return ;

                }
                break;
            case 28 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:240: RULE_ASSIGN
                {
                mRULE_ASSIGN(); if (state.failed) return ;

                }
                break;
            case 29 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:252: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 30 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:258: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 31 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:263: DIV
                {
                mDIV(); if (state.failed) return ;

                }
                break;
            case 32 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:267: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 33 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:272: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 34 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:278: EQ
                {
                mEQ(); if (state.failed) return ;

                }
                break;
            case 35 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:281: ISEQ
                {
                mISEQ(); if (state.failed) return ;

                }
                break;
            case 36 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:286: ISNE
                {
                mISNE(); if (state.failed) return ;

                }
                break;
            case 37 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:291: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 38 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:294: DOUBLE_LT
                {
                mDOUBLE_LT(); if (state.failed) return ;

                }
                break;
            case 39 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:304: LE
                {
                mLE(); if (state.failed) return ;

                }
                break;
            case 40 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:307: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 41 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:310: DOUBLE_GT
                {
                mDOUBLE_GT(); if (state.failed) return ;

                }
                break;
            case 42 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:320: GE
                {
                mGE(); if (state.failed) return ;

                }
                break;
            case 43 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:323: INCR
                {
                mINCR(); if (state.failed) return ;

                }
                break;
            case 44 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:328: DECR
                {
                mDECR(); if (state.failed) return ;

                }
                break;
            case 45 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:333: CALLOPERATION
                {
                mCALLOPERATION(); if (state.failed) return ;

                }
                break;
            case 46 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:347: UNDERSCORE
                {
                mUNDERSCORE(); if (state.failed) return ;

                }
                break;
            case 47 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:358: RANGE_VALUE
                {
                mRANGE_VALUE(); if (state.failed) return ;

                }
                break;
            case 48 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:370: REAL
                {
                mREAL(); if (state.failed) return ;

                }
                break;
            case 49 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:375: INTEGER
                {
                mINTEGER(); if (state.failed) return ;

                }
                break;
            case 50 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:1:383: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_CollaborationUseLabel
    public final void synpred1_CollaborationUseLabel_fragment() throws RecognitionException {   
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:525:4: ( INTEGER RANGE )
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:525:5: INTEGER RANGE
        {
        mINTEGER(); if (state.failed) return ;
        mRANGE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_CollaborationUseLabel

    // $ANTLR start synpred2_CollaborationUseLabel
    public final void synpred2_CollaborationUseLabel_fragment() throws RecognitionException {   
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:526:6: ( INTEGER POINT )
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:526:7: INTEGER POINT
        {
        mINTEGER(); if (state.failed) return ;
        mPOINT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_CollaborationUseLabel

    // $ANTLR start synpred3_CollaborationUseLabel
    public final void synpred3_CollaborationUseLabel_fragment() throws RecognitionException {   
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:527:6: ( INTEGER )
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\CollaborationUseLabel.g:527:7: INTEGER
        {
        mINTEGER(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_CollaborationUseLabel

    public final boolean synpred2_CollaborationUseLabel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_CollaborationUseLabel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_CollaborationUseLabel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_CollaborationUseLabel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_CollaborationUseLabel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_CollaborationUseLabel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
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
        "\1\uffff\1\0\1\uffff\1\1\2\uffff}>";
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
            return "522:1: fragment INTEGER_OR_REAL_OR_RANGE : ( ( INTEGER RANGE )=> RANGE_VALUE | ( INTEGER POINT )=> REAL | ( INTEGER )=> INTEGER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_1 = input.LA(1);

                         
                        int index4_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA4_1>='0' && LA4_1<='9')) ) {s = 1;}

                        else if ( (LA4_1=='.') ) {s = 3;}

                        else s = 2;

                         
                        input.seek(index4_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA4_3=='.') && (synpred1_CollaborationUseLabel())) {s = 4;}

                        else if ( ((LA4_3>='0' && LA4_3<='9')) && (synpred2_CollaborationUseLabel())) {s = 5;}

                         
                        input.seek(index4_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA7_eotS =
        "\1\uffff\1\42\3\uffff\1\44\6\uffff\1\46\1\50\1\52\1\54\1\56\4\uffff"+
        "\1\61\1\64\2\uffff\1\66\1\70\1\73\1\74\1\75\21\uffff\1\100\23\uffff";
    static final String DFA7_eofS =
        "\103\uffff";
    static final String DFA7_minS =
        "\1\11\1\74\3\uffff\1\75\6\uffff\1\173\1\175\1\46\1\174\1\56\4\uffff"+
        "\1\72\1\55\2\uffff\1\53\2\75\1\60\1\56\21\uffff\1\75\16\uffff\1"+
        "\56\4\uffff";
    static final String DFA7_maxS =
        "\1\176\1\125\3\uffff\1\75\6\uffff\1\173\1\175\1\46\1\174\1\56\4"+
        "\uffff\1\75\1\76\2\uffff\1\53\1\75\1\76\2\172\21\uffff\1\75\16\uffff"+
        "\1\71\4\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\uffff\1\6\1\7\1\10\1\11\1\12\1\13\5\uffff"+
        "\1\26\1\27\1\30\1\31\2\uffff\1\36\1\37\5\uffff\1\62\1\1\1\46\1\47"+
        "\1\45\1\44\1\5\1\15\1\14\1\17\1\16\1\21\1\20\1\23\1\22\1\25\1\24"+
        "\1\uffff\1\55\1\32\1\35\1\54\1\41\1\53\1\40\1\43\1\42\1\51\1\52"+
        "\1\50\1\56\1\61\1\uffff\1\34\1\33\1\57\1\60";
    static final String DFA7_specialS =
        "\103\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\3\1\2\1\uffff\1\3\1\2\22\uffff\1\3\1\5\1\6\1\23\2\uffff"+
            "\1\16\1\7\1\10\1\11\1\27\1\31\1\21\1\26\1\20\1\30\12\35\1\25"+
            "\1\22\1\1\1\32\1\33\1\4\1\uffff\32\36\1\12\1\uffff\1\13\1\uffff"+
            "\1\34\1\uffff\32\36\1\14\1\17\1\15\1\24",
            "\1\40\1\41\27\uffff\1\37",
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
            "\1\72\1\71",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\76\1\uffff\12\35\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36",
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
            return "1:1: Tokens : ( T__55 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | RANGE | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | UNDERSCORE | RANGE_VALUE | REAL | INTEGER | IDENTIFIER );";
        }
    }
 

}