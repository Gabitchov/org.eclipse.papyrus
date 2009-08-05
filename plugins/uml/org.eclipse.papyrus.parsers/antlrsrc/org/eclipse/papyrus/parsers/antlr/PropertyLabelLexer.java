// $ANTLR 3.0.1 D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g 2009-08-05 15:15:59

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

public class PropertyLabelLexer extends Lexer {
    public static final int LT=42;
    public static final int STAR=17;
    public static final int ISNE=41;
    public static final int LSQUARE=13;
    public static final int POINT=35;
    public static final int DOUBLE_QUOTE=25;
    public static final int FOUR_POINTS=37;
    public static final int DOUBLE_LCURLY=29;
    public static final int DOUBLE_LT=43;
    public static final int CALLOPERATION=50;
    public static final int EOF=-1;
    public static final int LOGICAL_AND=31;
    public static final int LPAREN=27;
    public static final int RULE_ASSIGN=38;
    public static final int DOUBLE_PIPE=34;
    public static final int SINGLE_QUOTE=26;
    public static final int LNOT=24;
    public static final int RPAREN=28;
    public static final int INCR=48;
    public static final int COMMA=20;
    public static final int IDENTIFIER=11;
    public static final int TILDE=9;
    public static final int QUESTION_MARK=23;
    public static final int DOUBLE_GT=46;
    public static final int PLUS=6;
    public static final int PIPE=33;
    public static final int DIGIT=51;
    public static final int NL=22;
    public static final int EQ=18;
    public static final int T61=61;
    public static final int T60=60;
    public static final int INTEGER=16;
    public static final int GE=47;
    public static final int SHARP=8;
    public static final int DOUBLE_RCURLY=30;
    public static final int UNDERSCORE=53;
    public static final int LCURLY=19;
    public static final int RSQUARE=15;
    public static final int MINUS=7;
    public static final int Tokens=62;
    public static final int SEMI=36;
    public static final int ALPHA=52;
    public static final int COLON=5;
    public static final int UNDEFINED=12;
    public static final int REAL=54;
    public static final int WS=4;
    public static final int DOUBLE_LOGICAL_AND=32;
    public static final int POINT_POINT=14;
    public static final int RCURLY=21;
    public static final int DECR=49;
    public static final int T59=59;
    public static final int ARROW=39;
    public static final int GT=45;
    public static final int DIV=10;
    public static final int T56=56;
    public static final int LE=44;
    public static final int T55=55;
    public static final int T58=58;
    public static final int T57=57;
    public static final int ISEQ=40;
    public PropertyLabelLexer() {;} 
    public PropertyLabelLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g"; }

    // $ANTLR start T55
    public final void mT55() throws RecognitionException {
        try {
            int _type = T55;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:21:5: ( 'readOnly' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:21:7: 'readOnly'
            {
            match("readOnly"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T55

    // $ANTLR start T56
    public final void mT56() throws RecognitionException {
        try {
            int _type = T56;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:22:5: ( 'union' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:22:7: 'union'
            {
            match("union"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T56

    // $ANTLR start T57
    public final void mT57() throws RecognitionException {
        try {
            int _type = T57;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:23:5: ( 'ordered' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:23:7: 'ordered'
            {
            match("ordered"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T57

    // $ANTLR start T58
    public final void mT58() throws RecognitionException {
        try {
            int _type = T58;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:24:5: ( 'unique' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:24:7: 'unique'
            {
            match("unique"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T58

    // $ANTLR start T59
    public final void mT59() throws RecognitionException {
        try {
            int _type = T59;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:25:5: ( 'nonunique' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:25:7: 'nonunique'
            {
            match("nonunique"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:26:5: ( 'subsets' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:26:7: 'subsets'
            {
            match("subsets"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:27:5: ( 'redefines' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:27:7: 'redefines'
            {
            match("redefines"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T61

    // $ANTLR start NL
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:574:3: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:574:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:574:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                NoViableAltException nvae =
                    new NoViableAltException("574:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:574:7: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:575:7: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:576:7: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:577:7: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             channel=HIDDEN;

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:585:3: ( ( ' ' | '\\t' ) )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:585:5: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:591:3: ( '?' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:591:5: '?'
            {
            match('?'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:595:3: ( '!' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:595:5: '!'
            {
            match('!'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:599:3: ( '\\\"' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:599:5: '\\\"'
            {
            match('\"'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:603:3: ( '\\'' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:603:5: '\\''
            {
            match('\''); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:607:3: ( '(' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:607:5: '('
            {
            match('('); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:611:3: ( ')' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:611:5: ')'
            {
            match(')'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:615:3: ( '[' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:615:5: '['
            {
            match('['); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:619:3: ( ']' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:619:5: ']'
            {
            match(']'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:623:3: ( '{' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:623:5: '{'
            {
            match('{'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:627:3: ( '{{' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:627:5: '{{'
            {
            match("{{"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:630:3: ( '}' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:630:5: '}'
            {
            match('}'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:634:3: ( '}}' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:634:5: '}}'
            {
            match("}}"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:638:3: ( '&' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:638:5: '&'
            {
            match('&'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:642:3: ( '&&' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:642:5: '&&'
            {
            match("&&"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:646:3: ( '|' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:646:5: '|'
            {
            match('|'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:650:3: ( '||' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:650:5: '||'
            {
            match("||"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:654:3: ( '.' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:654:5: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end POINT

    // $ANTLR start POINT_POINT
    public final void mPOINT_POINT() throws RecognitionException {
        try {
            int _type = POINT_POINT;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:658:3: ( '..' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:658:5: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end POINT_POINT

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:662:3: ( ',' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:662:5: ','
            {
            match(','); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:666:3: ( ';' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:666:5: ';'
            {
            match(';'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:670:3: ( '#' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:670:5: '#'
            {
            match('#'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:674:3: ( '~' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:674:5: '~'
            {
            match('~'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:678:3: ( ':' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:678:5: ':'
            {
            match(':'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:682:3: ( '::' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:682:5: '::'
            {
            match("::"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:686:3: ( '::=' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:686:5: '::='
            {
            match("::="); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:689:3: ( '->' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:689:5: '->'
            {
            match("->"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:693:3: ( '*' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:693:5: '*'
            {
            match('*'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:697:3: ( '/' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:697:5: '/'
            {
            match('/'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:701:3: ( '+' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:701:5: '+'
            {
            match('+'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:705:3: ( '-' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:705:5: '-'
            {
            match('-'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:709:3: ( '=' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:709:5: '='
            {
            match('='); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:714:3: ( '==' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:714:5: '=='
            {
            match("=="); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:718:3: ( '!=' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:718:5: '!='
            {
            match("!="); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:721:4: ( '<' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:721:6: '<'
            {
            match('<'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:724:3: ( '<<' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:724:5: '<<'
            {
            match("<<"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:728:3: ( '<=' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:728:5: '<='
            {
            match("<="); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:732:3: ( '>' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:732:5: '>'
            {
            match('>'); 

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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:736:3: ( '>>' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:736:5: '>>'
            {
            match(">>"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:740:3: ( '>=' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:740:5: '>='
            {
            match(">="); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:745:3: ( '++' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:745:5: '++'
            {
            match("++"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:749:3: ( '--' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:749:5: '--'
            {
            match("--"); 


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
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:753:3: ( ':=' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:753:5: ':='
            {
            match(":="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CALLOPERATION

    // $ANTLR start DIGIT
    public final void mDIGIT() throws RecognitionException {
        try {
            int _type = DIGIT;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:758:3: ( '0' .. '9' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:758:5: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIGIT

    // $ANTLR start ALPHA
    public final void mALPHA() throws RecognitionException {
        try {
            int _type = ALPHA;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:763:3: ( 'a' .. 'z' | 'A' .. 'Z' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ALPHA

    // $ANTLR start UNDERSCORE
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:769:3: ( '_' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:769:5: '_'
            {
            match('_'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UNDERSCORE

    // $ANTLR start UNDEFINED
    public final void mUNDEFINED() throws RecognitionException {
        try {
            int _type = UNDEFINED;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:773:3: ( '<UNDEFINED>' )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:773:5: '<UNDEFINED>'
            {
            match("<UNDEFINED>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UNDEFINED

    // $ANTLR start INTEGER
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:777:3: ( ( DIGIT )+ )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:777:5: ( DIGIT )+
            {
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:777:5: ( DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:777:6: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
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
    // $ANTLR end INTEGER

    // $ANTLR start REAL
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:782:3: ( INTEGER '.' INTEGER )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:782:5: INTEGER '.' INTEGER
            {
            mINTEGER(); 
            match('.'); 
            mINTEGER(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end REAL

    // $ANTLR start IDENTIFIER
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:786:3: ( ( ALPHA | UNDERSCORE ) ( ALPHA | DIGIT | UNDERSCORE )* )
            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:786:5: ( ALPHA | UNDERSCORE ) ( ALPHA | DIGIT | UNDERSCORE )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:786:23: ( ALPHA | DIGIT | UNDERSCORE )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IDENTIFIER

    public void mTokens() throws RecognitionException {
        // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:8: ( T55 | T56 | T57 | T58 | T59 | T60 | T61 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | POINT_POINT | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | DIGIT | ALPHA | UNDERSCORE | UNDEFINED | INTEGER | REAL | IDENTIFIER )
        int alt4=58;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:10: T55
                {
                mT55(); 

                }
                break;
            case 2 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:14: T56
                {
                mT56(); 

                }
                break;
            case 3 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:18: T57
                {
                mT57(); 

                }
                break;
            case 4 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:22: T58
                {
                mT58(); 

                }
                break;
            case 5 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:26: T59
                {
                mT59(); 

                }
                break;
            case 6 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:30: T60
                {
                mT60(); 

                }
                break;
            case 7 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:34: T61
                {
                mT61(); 

                }
                break;
            case 8 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:38: NL
                {
                mNL(); 

                }
                break;
            case 9 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:41: WS
                {
                mWS(); 

                }
                break;
            case 10 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:44: QUESTION_MARK
                {
                mQUESTION_MARK(); 

                }
                break;
            case 11 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:58: LNOT
                {
                mLNOT(); 

                }
                break;
            case 12 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:63: DOUBLE_QUOTE
                {
                mDOUBLE_QUOTE(); 

                }
                break;
            case 13 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:76: SINGLE_QUOTE
                {
                mSINGLE_QUOTE(); 

                }
                break;
            case 14 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:89: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 15 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:96: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 16 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:103: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 17 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:111: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 18 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:119: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 19 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:126: DOUBLE_LCURLY
                {
                mDOUBLE_LCURLY(); 

                }
                break;
            case 20 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:140: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 21 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:147: DOUBLE_RCURLY
                {
                mDOUBLE_RCURLY(); 

                }
                break;
            case 22 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:161: LOGICAL_AND
                {
                mLOGICAL_AND(); 

                }
                break;
            case 23 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:173: DOUBLE_LOGICAL_AND
                {
                mDOUBLE_LOGICAL_AND(); 

                }
                break;
            case 24 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:192: PIPE
                {
                mPIPE(); 

                }
                break;
            case 25 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:197: DOUBLE_PIPE
                {
                mDOUBLE_PIPE(); 

                }
                break;
            case 26 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:209: POINT
                {
                mPOINT(); 

                }
                break;
            case 27 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:215: POINT_POINT
                {
                mPOINT_POINT(); 

                }
                break;
            case 28 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:227: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 29 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:233: SEMI
                {
                mSEMI(); 

                }
                break;
            case 30 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:238: SHARP
                {
                mSHARP(); 

                }
                break;
            case 31 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:244: TILDE
                {
                mTILDE(); 

                }
                break;
            case 32 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:250: COLON
                {
                mCOLON(); 

                }
                break;
            case 33 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:256: FOUR_POINTS
                {
                mFOUR_POINTS(); 

                }
                break;
            case 34 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:268: RULE_ASSIGN
                {
                mRULE_ASSIGN(); 

                }
                break;
            case 35 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:280: ARROW
                {
                mARROW(); 

                }
                break;
            case 36 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:286: STAR
                {
                mSTAR(); 

                }
                break;
            case 37 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:291: DIV
                {
                mDIV(); 

                }
                break;
            case 38 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:295: PLUS
                {
                mPLUS(); 

                }
                break;
            case 39 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:300: MINUS
                {
                mMINUS(); 

                }
                break;
            case 40 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:306: EQ
                {
                mEQ(); 

                }
                break;
            case 41 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:309: ISEQ
                {
                mISEQ(); 

                }
                break;
            case 42 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:314: ISNE
                {
                mISNE(); 

                }
                break;
            case 43 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:319: LT
                {
                mLT(); 

                }
                break;
            case 44 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:322: DOUBLE_LT
                {
                mDOUBLE_LT(); 

                }
                break;
            case 45 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:332: LE
                {
                mLE(); 

                }
                break;
            case 46 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:335: GT
                {
                mGT(); 

                }
                break;
            case 47 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:338: DOUBLE_GT
                {
                mDOUBLE_GT(); 

                }
                break;
            case 48 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:348: GE
                {
                mGE(); 

                }
                break;
            case 49 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:351: INCR
                {
                mINCR(); 

                }
                break;
            case 50 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:356: DECR
                {
                mDECR(); 

                }
                break;
            case 51 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:361: CALLOPERATION
                {
                mCALLOPERATION(); 

                }
                break;
            case 52 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:375: DIGIT
                {
                mDIGIT(); 

                }
                break;
            case 53 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:381: ALPHA
                {
                mALPHA(); 

                }
                break;
            case 54 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:387: UNDERSCORE
                {
                mUNDERSCORE(); 

                }
                break;
            case 55 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:398: UNDEFINED
                {
                mUNDEFINED(); 

                }
                break;
            case 56 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:408: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 57 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:416: REAL
                {
                mREAL(); 

                }
                break;
            case 58 :
                // D:\\Workspaces\\Papyrus2_Head\\org.eclipse.papyrus.parsers\\resources\\grammars\\PropertyLabel.g:1:421: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\5\46\3\uffff\1\54\6\uffff\1\56\1\60\1\62\1\64\1\66\4\uffff"+
        "\1\71\1\74\2\uffff\1\76\1\100\1\104\1\107\1\110\1\46\1\113\1\45"+
        "\2\uffff\4\45\14\uffff\1\123\22\uffff\1\124\1\uffff\6\45\3\uffff"+
        "\12\45\1\146\5\45\1\154\1\uffff\5\45\1\uffff\1\162\1\45\1\164\1"+
        "\165\1\45\1\uffff\1\45\2\uffff\1\170\1\171\2\uffff";
    static final String DFA4_eofS =
        "\172\uffff";
    static final String DFA4_minS =
        "\1\11\5\60\3\uffff\1\75\6\uffff\1\173\1\175\1\46\1\174\1\56\4\uffff"+
        "\1\72\1\55\2\uffff\1\53\1\75\1\74\1\75\1\56\2\60\1\141\2\uffff\1"+
        "\151\1\144\1\156\1\142\14\uffff\1\75\22\uffff\1\56\1\uffff\1\144"+
        "\1\145\1\157\1\145\1\165\1\163\3\uffff\1\117\1\146\1\165\1\156\1"+
        "\162\1\156\1\145\1\156\1\151\1\145\1\60\1\145\1\151\1\164\1\154"+
        "\1\156\1\60\1\uffff\1\144\1\161\1\163\1\171\1\145\1\uffff\1\60\1"+
        "\165\2\60\1\163\1\uffff\1\145\2\uffff\2\60\2\uffff";
    static final String DFA4_maxS =
        "\1\176\5\172\3\uffff\1\75\6\uffff\1\173\1\175\1\46\1\174\1\56\4"+
        "\uffff\1\75\1\76\2\uffff\1\53\1\75\1\125\1\76\1\71\2\172\1\144\2"+
        "\uffff\1\151\1\144\1\156\1\142\14\uffff\1\75\22\uffff\1\71\1\uffff"+
        "\1\144\1\145\1\161\1\145\1\165\1\163\3\uffff\1\117\1\146\1\165\1"+
        "\156\1\162\1\156\1\145\1\156\1\151\1\145\1\172\1\145\1\151\1\164"+
        "\1\154\1\156\1\172\1\uffff\1\144\1\161\1\163\1\171\1\145\1\uffff"+
        "\1\172\1\165\2\172\1\163\1\uffff\1\145\2\uffff\2\172\2\uffff";
    static final String DFA4_acceptS =
        "\6\uffff\1\10\1\11\1\12\1\uffff\1\14\1\15\1\16\1\17\1\20\1\21\5"+
        "\uffff\1\34\1\35\1\36\1\37\2\uffff\1\44\1\45\10\uffff\1\72\1\65"+
        "\4\uffff\1\52\1\13\1\23\1\22\1\25\1\24\1\27\1\26\1\31\1\30\1\33"+
        "\1\32\1\uffff\1\63\1\40\1\43\1\62\1\47\1\61\1\46\1\51\1\50\1\54"+
        "\1\55\1\67\1\53\1\60\1\57\1\56\1\64\1\71\1\uffff\1\66\6\uffff\1"+
        "\42\1\41\1\70\21\uffff\1\2\5\uffff\1\4\5\uffff\1\3\1\uffff\1\6\1"+
        "\1\2\uffff\1\7\1\5";
    static final String DFA4_specialS =
        "\172\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\7\1\6\2\uffff\1\6\22\uffff\1\7\1\11\1\12\1\27\2\uffff\1\22"+
            "\1\13\1\14\1\15\1\33\1\35\1\25\1\32\1\24\1\34\12\41\1\31\1\26"+
            "\1\37\1\36\1\40\1\10\1\uffff\32\42\1\16\1\uffff\1\17\1\uffff"+
            "\1\43\1\uffff\15\42\1\4\1\3\2\42\1\1\1\5\1\42\1\2\5\42\1\20"+
            "\1\23\1\21\1\30",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\44\25\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\15\45\1\47\14\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\21\45\1\50\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\16\45\1\51\13\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\24\45\1\52\5\45",
            "",
            "",
            "",
            "\1\53",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55",
            "\1\57",
            "\1\61",
            "\1\63",
            "\1\65",
            "",
            "",
            "",
            "",
            "\1\67\2\uffff\1\70",
            "\1\73\20\uffff\1\72",
            "",
            "",
            "\1\75",
            "\1\77",
            "\1\101\1\102\27\uffff\1\103",
            "\1\105\1\106",
            "\1\111\1\uffff\12\112",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\114\2\uffff\1\115",
            "",
            "",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
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
            "\1\122",
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
            "",
            "\1\111\1\uffff\12\112",
            "",
            "\1\125",
            "\1\126",
            "\1\130\1\uffff\1\127",
            "\1\131",
            "\1\132",
            "\1\133",
            "",
            "",
            "",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\163",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\166",
            "",
            "\1\167",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
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
            return "1:1: Tokens : ( T55 | T56 | T57 | T58 | T59 | T60 | T61 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | POINT_POINT | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | DIGIT | ALPHA | UNDERSCORE | UNDEFINED | INTEGER | REAL | IDENTIFIER );";
        }
    }
 

}