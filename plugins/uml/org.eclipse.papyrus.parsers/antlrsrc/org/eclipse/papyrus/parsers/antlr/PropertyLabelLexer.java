// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g 2011-03-15 16:41:29

package org.eclipse.papyrus.parsers.antlr;

import org.eclipse.uml2.uml.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;
import org.eclipse.papyrus.parsers.util.TypeRecognitionException;
import org.eclipse.papyrus.parsers.util.UnboundTemplateRecognitionException;

import org.eclipse.papyrus.parsers.texteditor.propertylabel.IContext;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class PropertyLabelLexer extends Lexer {
    public static final int DOUBLE_LT=43;
    public static final int COMMA=19;
    public static final int ISEQ=40;
    public static final int MINUS=7;
    public static final int INCR=48;
    public static final int T__57=57;
    public static final int SHARP=8;
    public static final int DOUBLE_RCURLY=29;
    public static final int DECR=49;
    public static final int ARROW=39;
    public static final int DOUBLE_GT=46;
    public static final int RULE_ASSIGN=38;
    public static final int TILDE=9;
    public static final int PIPE=32;
    public static final int DOUBLE_PIPE=33;
    public static final int INTEGER=14;
    public static final int RCURLY=20;
    public static final int QUESTION_MARK=22;
    public static final int NL=21;
    public static final int LCURLY=18;
    public static final int T__62=62;
    public static final int LE=44;
    public static final int RPAREN=27;
    public static final int T__61=61;
    public static final int LPAREN=26;
    public static final int T__59=59;
    public static final int PLUS=6;
    public static final int SINGLE_QUOTE=25;
    public static final int REAL=53;
    public static final int T__56=56;
    public static final int LSQUARE=12;
    public static final int RANGE=35;
    public static final int FOUR_POINTS=37;
    public static final int DOUBLE_LCURLY=28;
    public static final int POINT=34;
    public static final int WS=4;
    public static final int ALPHA=51;
    public static final int T__58=58;
    public static final int EQ=17;
    public static final int LT=42;
    public static final int DOUBLE_QUOTE=24;
    public static final int GT=45;
    public static final int DOUBLE_LOGICAL_AND=31;
    public static final int RSQUARE=15;
    public static final int RANGE_VALUE=13;
    public static final int T__55=55;
    public static final int SEMI=36;
    public static final int GE=47;
    public static final int LNOT=23;
    public static final int LOGICAL_AND=30;
    public static final int ISNE=41;
    public static final int EOF=-1;
    public static final int COLON=5;
    public static final int DIV=10;
    public static final int INTEGER_OR_REAL_OR_RANGE=54;
    public static final int STAR=16;
    public static final int IDENTIFIER=11;
    public static final int T__60=60;
    public static final int UNDERSCORE=52;
    public static final int CALLOPERATION=50;

    // delegates
    // delegators

    public PropertyLabelLexer() {;} 
    public PropertyLabelLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PropertyLabelLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g"; }

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:22:7: ( '<Undefined>' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:22:9: '<Undefined>'
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

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:23:7: ( 'readOnly' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:23:9: 'readOnly'
            {
            match("readOnly"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:24:7: ( 'union' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:24:9: 'union'
            {
            match("union"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:25:7: ( 'ordered' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:25:9: 'ordered'
            {
            match("ordered"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:26:7: ( 'unique' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:26:9: 'unique'
            {
            match("unique"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:27:7: ( 'nonunique' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:27:9: 'nonunique'
            {
            match("nonunique"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:28:7: ( 'subsets' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:28:9: 'subsets'
            {
            match("subsets"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:29:7: ( 'redefines' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:29:9: 'redefines'
            {
            match("redefines"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:781:3: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:781:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:781:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:781:7: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:782:7: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:783:7: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:784:7: '\\n'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:791:3: ( ( ' ' | '\\t' | '\\f' )+ )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:791:6: ( ' ' | '\\t' | '\\f' )+
            {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:791:6: ( ' ' | '\\t' | '\\f' )+
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
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:795:3: ( '?' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:795:5: '?'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:799:3: ( '!' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:799:5: '!'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:803:3: ( '\\\"' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:803:5: '\\\"'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:807:3: ( '\\'' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:807:5: '\\''
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:811:3: ( '(' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:811:5: '('
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:815:3: ( ')' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:815:5: ')'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:819:3: ( '[' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:819:5: '['
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:823:3: ( ']' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:823:5: ']'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:827:3: ( '{' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:827:5: '{'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:831:3: ( '{{' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:831:5: '{{'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:834:3: ( '}' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:834:5: '}'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:838:3: ( '}}' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:838:5: '}}'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:842:3: ( '&' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:842:5: '&'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:846:3: ( '&&' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:846:5: '&&'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:850:3: ( '|' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:850:5: '|'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:854:3: ( '||' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:854:5: '||'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:858:3: ( '.' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:858:5: '.'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:862:3: ( '..' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:862:5: '..'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:866:3: ( ',' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:866:5: ','
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:870:3: ( ';' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:870:5: ';'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:874:3: ( '#' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:874:5: '#'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:878:3: ( '~' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:878:5: '~'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:882:3: ( ':' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:882:5: ':'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:886:3: ( '::' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:886:5: '::'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:890:3: ( '::=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:890:5: '::='
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:893:3: ( '->' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:893:5: '->'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:897:3: ( '*' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:897:5: '*'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:901:3: ( '/' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:901:5: '/'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:905:3: ( '+' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:905:5: '+'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:909:3: ( '-' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:909:5: '-'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:913:3: ( '=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:913:5: '='
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:918:3: ( '==' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:918:5: '=='
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:922:3: ( '!=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:922:5: '!='
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:925:4: ( '<' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:925:6: '<'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:928:3: ( '<<' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:928:5: '<<'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:932:3: ( '<=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:932:5: '<='
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:936:3: ( '>' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:936:5: '>'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:940:3: ( '>>' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:940:5: '>>'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:944:3: ( '>=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:944:5: '>='
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:949:3: ( '++' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:949:5: '++'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:953:3: ( '--' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:953:5: '--'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:957:3: ( ':=' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:957:5: ':='
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:962:3: ( 'a' .. 'z' | 'A' .. 'Z' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:968:3: ( '_' )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:968:5: '_'
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

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:972:3: (c1= INTEGER '..' (c2= INTEGER | c2= STAR ) )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:972:5: c1= INTEGER '..' (c2= INTEGER | c2= STAR )
            {
            int c1Start826 = getCharIndex();
            mINTEGER(); if (state.failed) return ;
            c1 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c1Start826, getCharIndex()-1);
            if ( state.backtracking==0 ) {
              setText("");
            }
            match(".."); if (state.failed) return ;

            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:973:3: (c2= INTEGER | c2= STAR )
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
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:973:5: c2= INTEGER
                    {
                    int c2Start838 = getCharIndex();
                    mINTEGER(); if (state.failed) return ;
                    c2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c2Start838, getCharIndex()-1);
                    if ( state.backtracking==0 ) {
                       setText((c2!=null?c2.getText():null));
                    }

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:974:7: c2= STAR
                    {
                    int c2Start851 = getCharIndex();
                    mSTAR(); if (state.failed) return ;
                    c2 = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, c2Start851, getCharIndex()-1);
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:981:3: ( INTEGER '.' INTEGER )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:981:5: INTEGER '.' INTEGER
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:986:3: ( ( INTEGER RANGE )=> RANGE_VALUE | ( INTEGER POINT )=> REAL | ( INTEGER )=> INTEGER )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:987:4: ( INTEGER RANGE )=> RANGE_VALUE
                    {
                    mRANGE_VALUE(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:988:6: ( INTEGER POINT )=> REAL
                    {
                    mREAL(); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:989:6: ( INTEGER )=> INTEGER
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:993:3: ( ( '0' .. '9' )+ )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:993:5: ( '0' .. '9' )+
            {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:993:5: ( '0' .. '9' )+
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
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:993:5: '0' .. '9'
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
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:996:3: ( ( ALPHA | '0' .. '9' | UNDERSCORE )+ )
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:996:5: ( ALPHA | '0' .. '9' | UNDERSCORE )+
            {
            // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:996:5: ( ALPHA | '0' .. '9' | UNDERSCORE )+
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
            	    // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:
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
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:8: ( T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | RANGE | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | UNDERSCORE | RANGE_VALUE | REAL | INTEGER | IDENTIFIER )
        int alt7=57;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:10: T__55
                {
                mT__55(); if (state.failed) return ;

                }
                break;
            case 2 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:16: T__56
                {
                mT__56(); if (state.failed) return ;

                }
                break;
            case 3 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:22: T__57
                {
                mT__57(); if (state.failed) return ;

                }
                break;
            case 4 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:28: T__58
                {
                mT__58(); if (state.failed) return ;

                }
                break;
            case 5 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:34: T__59
                {
                mT__59(); if (state.failed) return ;

                }
                break;
            case 6 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:40: T__60
                {
                mT__60(); if (state.failed) return ;

                }
                break;
            case 7 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:46: T__61
                {
                mT__61(); if (state.failed) return ;

                }
                break;
            case 8 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:52: T__62
                {
                mT__62(); if (state.failed) return ;

                }
                break;
            case 9 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:58: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 10 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:61: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 11 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:64: QUESTION_MARK
                {
                mQUESTION_MARK(); if (state.failed) return ;

                }
                break;
            case 12 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:78: LNOT
                {
                mLNOT(); if (state.failed) return ;

                }
                break;
            case 13 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:83: DOUBLE_QUOTE
                {
                mDOUBLE_QUOTE(); if (state.failed) return ;

                }
                break;
            case 14 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:96: SINGLE_QUOTE
                {
                mSINGLE_QUOTE(); if (state.failed) return ;

                }
                break;
            case 15 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:109: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 16 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:116: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 17 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:123: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 18 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:131: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 19 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:139: LCURLY
                {
                mLCURLY(); if (state.failed) return ;

                }
                break;
            case 20 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:146: DOUBLE_LCURLY
                {
                mDOUBLE_LCURLY(); if (state.failed) return ;

                }
                break;
            case 21 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:160: RCURLY
                {
                mRCURLY(); if (state.failed) return ;

                }
                break;
            case 22 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:167: DOUBLE_RCURLY
                {
                mDOUBLE_RCURLY(); if (state.failed) return ;

                }
                break;
            case 23 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:181: LOGICAL_AND
                {
                mLOGICAL_AND(); if (state.failed) return ;

                }
                break;
            case 24 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:193: DOUBLE_LOGICAL_AND
                {
                mDOUBLE_LOGICAL_AND(); if (state.failed) return ;

                }
                break;
            case 25 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:212: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 26 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:217: DOUBLE_PIPE
                {
                mDOUBLE_PIPE(); if (state.failed) return ;

                }
                break;
            case 27 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:229: POINT
                {
                mPOINT(); if (state.failed) return ;

                }
                break;
            case 28 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:235: RANGE
                {
                mRANGE(); if (state.failed) return ;

                }
                break;
            case 29 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:241: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 30 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:247: SEMI
                {
                mSEMI(); if (state.failed) return ;

                }
                break;
            case 31 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:252: SHARP
                {
                mSHARP(); if (state.failed) return ;

                }
                break;
            case 32 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:258: TILDE
                {
                mTILDE(); if (state.failed) return ;

                }
                break;
            case 33 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:264: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 34 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:270: FOUR_POINTS
                {
                mFOUR_POINTS(); if (state.failed) return ;

                }
                break;
            case 35 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:282: RULE_ASSIGN
                {
                mRULE_ASSIGN(); if (state.failed) return ;

                }
                break;
            case 36 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:294: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 37 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:300: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 38 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:305: DIV
                {
                mDIV(); if (state.failed) return ;

                }
                break;
            case 39 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:309: PLUS
                {
                mPLUS(); if (state.failed) return ;

                }
                break;
            case 40 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:314: MINUS
                {
                mMINUS(); if (state.failed) return ;

                }
                break;
            case 41 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:320: EQ
                {
                mEQ(); if (state.failed) return ;

                }
                break;
            case 42 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:323: ISEQ
                {
                mISEQ(); if (state.failed) return ;

                }
                break;
            case 43 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:328: ISNE
                {
                mISNE(); if (state.failed) return ;

                }
                break;
            case 44 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:333: LT
                {
                mLT(); if (state.failed) return ;

                }
                break;
            case 45 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:336: DOUBLE_LT
                {
                mDOUBLE_LT(); if (state.failed) return ;

                }
                break;
            case 46 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:346: LE
                {
                mLE(); if (state.failed) return ;

                }
                break;
            case 47 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:349: GT
                {
                mGT(); if (state.failed) return ;

                }
                break;
            case 48 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:352: DOUBLE_GT
                {
                mDOUBLE_GT(); if (state.failed) return ;

                }
                break;
            case 49 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:362: GE
                {
                mGE(); if (state.failed) return ;

                }
                break;
            case 50 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:365: INCR
                {
                mINCR(); if (state.failed) return ;

                }
                break;
            case 51 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:370: DECR
                {
                mDECR(); if (state.failed) return ;

                }
                break;
            case 52 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:375: CALLOPERATION
                {
                mCALLOPERATION(); if (state.failed) return ;

                }
                break;
            case 53 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:389: UNDERSCORE
                {
                mUNDERSCORE(); if (state.failed) return ;

                }
                break;
            case 54 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:400: RANGE_VALUE
                {
                mRANGE_VALUE(); if (state.failed) return ;

                }
                break;
            case 55 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:412: REAL
                {
                mREAL(); if (state.failed) return ;

                }
                break;
            case 56 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:417: INTEGER
                {
                mINTEGER(); if (state.failed) return ;

                }
                break;
            case 57 :
                // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:1:425: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_PropertyLabel
    public final void synpred1_PropertyLabel_fragment() throws RecognitionException {   
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:987:4: ( INTEGER RANGE )
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:987:5: INTEGER RANGE
        {
        mINTEGER(); if (state.failed) return ;
        mRANGE(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_PropertyLabel

    // $ANTLR start synpred2_PropertyLabel
    public final void synpred2_PropertyLabel_fragment() throws RecognitionException {   
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:988:6: ( INTEGER POINT )
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:988:7: INTEGER POINT
        {
        mINTEGER(); if (state.failed) return ;
        mPOINT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_PropertyLabel

    // $ANTLR start synpred3_PropertyLabel
    public final void synpred3_PropertyLabel_fragment() throws RecognitionException {   
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:989:6: ( INTEGER )
        // D:\\Workspaces\\Papyrus_Branch_0.7\\org.eclipse.papyrus.parsers_TRUNK\\resources\\grammars\\PropertyLabel.g:989:7: INTEGER
        {
        mINTEGER(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_PropertyLabel

    public final boolean synpred1_PropertyLabel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_PropertyLabel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PropertyLabel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PropertyLabel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_PropertyLabel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_PropertyLabel_fragment(); // can never throw exception
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
            return "984:1: fragment INTEGER_OR_REAL_OR_RANGE : ( ( INTEGER RANGE )=> RANGE_VALUE | ( INTEGER POINT )=> REAL | ( INTEGER )=> INTEGER );";
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
                        if ( (LA4_1=='.') ) {s = 3;}

                        else if ( ((LA4_1>='0' && LA4_1<='9')) ) {s = 1;}

                        else s = 2;

                         
                        input.seek(index4_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA4_3=='.') && (synpred1_PropertyLabel())) {s = 4;}

                        else if ( ((LA4_3>='0' && LA4_3<='9')) && (synpred2_PropertyLabel())) {s = 5;}

                         
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
        "\1\uffff\1\47\5\43\3\uffff\1\56\6\uffff\1\60\1\62\1\64\1\66\1\70"+
        "\4\uffff\1\73\1\76\2\uffff\1\100\1\102\1\105\1\106\1\107\5\uffff"+
        "\5\43\14\uffff\1\120\17\uffff\6\43\4\uffff\11\43\1\143\6\43\1\uffff"+
        "\1\152\5\43\1\uffff\1\160\1\43\1\162\1\163\1\43\1\uffff\1\43\2\uffff"+
        "\1\166\1\167\2\uffff";
    static final String DFA7_eofS =
        "\170\uffff";
    static final String DFA7_minS =
        "\1\11\1\74\1\145\1\156\1\162\1\157\1\165\3\uffff\1\75\6\uffff\1"+
        "\173\1\175\1\46\1\174\1\56\4\uffff\1\72\1\55\2\uffff\1\53\2\75\1"+
        "\60\1\56\5\uffff\1\141\1\151\1\144\1\156\1\142\14\uffff\1\75\16"+
        "\uffff\1\56\1\144\1\145\1\157\1\145\1\165\1\163\4\uffff\1\117\1"+
        "\146\1\156\1\165\1\162\1\156\1\145\1\156\1\151\1\60\2\145\1\151"+
        "\1\164\1\154\1\156\1\uffff\1\60\1\144\1\161\1\163\1\171\1\145\1"+
        "\uffff\1\60\1\165\2\60\1\163\1\uffff\1\145\2\uffff\2\60\2\uffff";
    static final String DFA7_maxS =
        "\1\176\1\125\1\145\1\156\1\162\1\157\1\165\3\uffff\1\75\6\uffff"+
        "\1\173\1\175\1\46\1\174\1\56\4\uffff\1\75\1\76\2\uffff\1\53\1\75"+
        "\1\76\2\172\5\uffff\1\144\1\151\1\144\1\156\1\142\14\uffff\1\75"+
        "\16\uffff\1\71\1\144\1\145\1\161\1\145\1\165\1\163\4\uffff\1\117"+
        "\1\146\1\156\1\165\1\162\1\156\1\145\1\156\1\151\1\172\2\145\1\151"+
        "\1\164\1\154\1\156\1\uffff\1\172\1\144\1\161\1\163\1\171\1\145\1"+
        "\uffff\1\172\1\165\2\172\1\163\1\uffff\1\145\2\uffff\2\172\2\uffff";
    static final String DFA7_acceptS =
        "\7\uffff\1\11\1\12\1\13\1\uffff\1\15\1\16\1\17\1\20\1\21\1\22\5"+
        "\uffff\1\35\1\36\1\37\1\40\2\uffff\1\45\1\46\5\uffff\1\71\1\1\1"+
        "\55\1\56\1\54\5\uffff\1\53\1\14\1\24\1\23\1\26\1\25\1\30\1\27\1"+
        "\32\1\31\1\34\1\33\1\uffff\1\64\1\41\1\44\1\63\1\50\1\62\1\47\1"+
        "\52\1\51\1\60\1\61\1\57\1\65\1\70\7\uffff\1\43\1\42\1\66\1\67\20"+
        "\uffff\1\3\6\uffff\1\5\5\uffff\1\4\1\uffff\1\7\1\2\2\uffff\1\10"+
        "\1\6";
    static final String DFA7_specialS =
        "\170\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\10\1\7\1\uffff\1\10\1\7\22\uffff\1\10\1\12\1\13\1\30\2\uffff"+
            "\1\23\1\14\1\15\1\16\1\34\1\36\1\26\1\33\1\25\1\35\12\42\1\32"+
            "\1\27\1\1\1\37\1\40\1\11\1\uffff\32\43\1\17\1\uffff\1\20\1\uffff"+
            "\1\41\1\uffff\15\43\1\5\1\4\2\43\1\2\1\6\1\43\1\3\5\43\1\21"+
            "\1\24\1\22\1\31",
            "\1\45\1\46\27\uffff\1\44",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "",
            "",
            "",
            "\1\55",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57",
            "\1\61",
            "\1\63",
            "\1\65",
            "\1\67",
            "",
            "",
            "",
            "",
            "\1\71\2\uffff\1\72",
            "\1\75\20\uffff\1\74",
            "",
            "",
            "\1\77",
            "\1\101",
            "\1\104\1\103",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\110\1\uffff\12\42\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "",
            "",
            "",
            "",
            "",
            "\1\111\2\uffff\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
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
            "\1\117",
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
            "\1\121\1\uffff\12\122",
            "\1\123",
            "\1\124",
            "\1\125\1\uffff\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "",
            "",
            "",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\161",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\164",
            "",
            "\1\165",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
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
            return "1:1: Tokens : ( T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | RANGE | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | UNDERSCORE | RANGE_VALUE | REAL | INTEGER | IDENTIFIER );";
        }
    }
 

}