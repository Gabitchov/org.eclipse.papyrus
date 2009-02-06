/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
  *****************************************************************************/

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
    public static final int COMMA=19;
    public static final int DOUBLE_LT=42;
    public static final int ISEQ=39;
    public static final int MINUS=7;
    public static final int INCR=47;
    public static final int SHARP=8;
    public static final int DOUBLE_RCURLY=29;
    public static final int DECR=48;
    public static final int T58=58;
    public static final int ARROW=38;
    public static final int DOUBLE_GT=45;
    public static final int RULE_ASSIGN=37;
    public static final int T61=61;
    public static final int TILDE=9;
    public static final int PIPE=32;
    public static final int DOUBLE_PIPE=33;
    public static final int RCURLY=20;
    public static final int INTEGER=15;
    public static final int QUESTION_MARK=22;
    public static final int NL=21;
    public static final int LCURLY=18;
    public static final int LE=43;
    public static final int RPAREN=27;
    public static final int LPAREN=26;
    public static final int DIGIT=50;
    public static final int PLUS=6;
    public static final int SINGLE_QUOTE=25;
    public static final int REAL=53;
    public static final int T55=55;
    public static final int LSQUARE=12;
    public static final int FOUR_POINTS=36;
    public static final int DOUBLE_LCURLY=28;
    public static final int POINT=34;
    public static final int WS=4;
    public static final int ALPHA=51;
    public static final int EQ=17;
    public static final int LT=41;
    public static final int GT=44;
    public static final int DOUBLE_QUOTE=24;
    public static final int RSQUARE=14;
    public static final int POINT_POINT=13;
    public static final int DOUBLE_LOGICAL_AND=31;
    public static final int T57=57;
    public static final int T56=56;
    public static final int SEMI=35;
    public static final int GE=46;
    public static final int LNOT=23;
    public static final int T59=59;
    public static final int ISNE=40;
    public static final int LOGICAL_AND=30;
    public static final int T54=54;
    public static final int EOF=-1;
    public static final int Tokens=62;
    public static final int T60=60;
    public static final int COLON=5;
    public static final int DIV=10;
    public static final int IDENTIFIER=11;
    public static final int STAR=16;
    public static final int UNDERSCORE=52;
    public static final int CALLOPERATION=49;
    public PropertyLabelLexer() {;} 
    public PropertyLabelLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g"; }

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:22:7: ( '<Undefined>' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:22:7: '<Undefined>'
            {
            match("<Undefined>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start T55
    public final void mT55() throws RecognitionException {
        try {
            int _type = T55;
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:23:7: ( 'readOnly' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:23:7: 'readOnly'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:24:7: ( 'union' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:24:7: 'union'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:25:7: ( 'ordered' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:25:7: 'ordered'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:26:7: ( 'unique' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:26:7: 'unique'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:27:7: ( 'nonunique' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:27:7: 'nonunique'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:28:7: ( 'subsets' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:28:7: 'subsets'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:29:7: ( 'redefines' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:29:7: 'redefines'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:570:5: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:570:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:570:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    new NoViableAltException("570:5: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:570:7: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:571:7: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:572:7: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:573:7: '\\n'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:581:5: ( ( ' ' | '\\t' ) )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:581:5: ( ' ' | '\\t' )
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:587:5: ( '?' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:587:5: '?'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:591:5: ( '!' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:591:5: '!'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:595:5: ( '\\\"' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:595:5: '\\\"'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:599:5: ( '\\'' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:599:5: '\\''
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:603:5: ( '(' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:603:5: '('
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:607:5: ( ')' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:607:5: ')'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:611:5: ( '[' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:611:5: '['
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:615:5: ( ']' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:615:5: ']'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:619:5: ( '{' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:619:5: '{'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:623:5: ( '{{' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:623:5: '{{'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:626:5: ( '}' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:626:5: '}'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:630:5: ( '}}' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:630:5: '}}'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:634:5: ( '&' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:634:5: '&'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:638:5: ( '&&' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:638:5: '&&'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:642:5: ( '|' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:642:5: '|'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:646:5: ( '||' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:646:5: '||'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:650:5: ( '.' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:650:5: '.'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:654:5: ( '..' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:654:5: '..'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:658:5: ( ',' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:658:5: ','
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:662:5: ( ';' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:662:5: ';'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:666:5: ( '#' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:666:5: '#'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:670:5: ( '~' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:670:5: '~'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:674:5: ( ':' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:674:5: ':'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:678:5: ( '::' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:678:5: '::'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:682:5: ( '::=' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:682:5: '::='
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:685:5: ( '->' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:685:5: '->'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:689:5: ( '*' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:689:5: '*'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:693:5: ( '/' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:693:5: '/'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:697:5: ( '+' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:697:5: '+'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:701:5: ( '-' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:701:5: '-'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:705:5: ( '=' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:705:5: '='
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:710:5: ( '==' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:710:5: '=='
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:714:5: ( '!=' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:714:5: '!='
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:717:6: ( '<' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:717:6: '<'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:720:5: ( '<<' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:720:5: '<<'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:724:5: ( '<=' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:724:5: '<='
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:728:5: ( '>' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:728:5: '>'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:732:5: ( '>>' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:732:5: '>>'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:736:5: ( '>=' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:736:5: '>='
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:741:5: ( '++' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:741:5: '++'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:745:5: ( '--' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:745:5: '--'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:749:5: ( ':=' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:749:5: ':='
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:754:5: ( '0' .. '9' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:754:5: '0' .. '9'
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:759:5: ( 'a' .. 'z' | 'A' .. 'Z' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:765:5: ( '_' )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:765:5: '_'
            {
            match('_'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UNDERSCORE

    // $ANTLR start INTEGER
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:770:5: ( ( DIGIT )+ )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:770:5: ( DIGIT )+
            {
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:770:5: ( DIGIT )+
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
            	    // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:770:6: DIGIT
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:775:5: ( INTEGER '.' INTEGER )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:775:5: INTEGER '.' INTEGER
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
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:779:5: ( ( ALPHA | UNDERSCORE ) ( ALPHA | DIGIT | UNDERSCORE )* )
            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:779:5: ( ALPHA | UNDERSCORE ) ( ALPHA | DIGIT | UNDERSCORE )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:779:23: ( ALPHA | DIGIT | UNDERSCORE )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:
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
        // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:10: ( T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | POINT_POINT | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | DIGIT | ALPHA | UNDERSCORE | INTEGER | REAL | IDENTIFIER )
        int alt4=58;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:10: T54
                {
                mT54(); 

                }
                break;
            case 2 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:14: T55
                {
                mT55(); 

                }
                break;
            case 3 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:18: T56
                {
                mT56(); 

                }
                break;
            case 4 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:22: T57
                {
                mT57(); 

                }
                break;
            case 5 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:26: T58
                {
                mT58(); 

                }
                break;
            case 6 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:30: T59
                {
                mT59(); 

                }
                break;
            case 7 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:34: T60
                {
                mT60(); 

                }
                break;
            case 8 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:38: T61
                {
                mT61(); 

                }
                break;
            case 9 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:42: NL
                {
                mNL(); 

                }
                break;
            case 10 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:45: WS
                {
                mWS(); 

                }
                break;
            case 11 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:48: QUESTION_MARK
                {
                mQUESTION_MARK(); 

                }
                break;
            case 12 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:62: LNOT
                {
                mLNOT(); 

                }
                break;
            case 13 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:67: DOUBLE_QUOTE
                {
                mDOUBLE_QUOTE(); 

                }
                break;
            case 14 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:80: SINGLE_QUOTE
                {
                mSINGLE_QUOTE(); 

                }
                break;
            case 15 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:93: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 16 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:100: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 17 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:107: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 18 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:115: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 19 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:123: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 20 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:130: DOUBLE_LCURLY
                {
                mDOUBLE_LCURLY(); 

                }
                break;
            case 21 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:144: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 22 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:151: DOUBLE_RCURLY
                {
                mDOUBLE_RCURLY(); 

                }
                break;
            case 23 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:165: LOGICAL_AND
                {
                mLOGICAL_AND(); 

                }
                break;
            case 24 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:177: DOUBLE_LOGICAL_AND
                {
                mDOUBLE_LOGICAL_AND(); 

                }
                break;
            case 25 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:196: PIPE
                {
                mPIPE(); 

                }
                break;
            case 26 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:201: DOUBLE_PIPE
                {
                mDOUBLE_PIPE(); 

                }
                break;
            case 27 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:213: POINT
                {
                mPOINT(); 

                }
                break;
            case 28 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:219: POINT_POINT
                {
                mPOINT_POINT(); 

                }
                break;
            case 29 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:231: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 30 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:237: SEMI
                {
                mSEMI(); 

                }
                break;
            case 31 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:242: SHARP
                {
                mSHARP(); 

                }
                break;
            case 32 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:248: TILDE
                {
                mTILDE(); 

                }
                break;
            case 33 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:254: COLON
                {
                mCOLON(); 

                }
                break;
            case 34 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:260: FOUR_POINTS
                {
                mFOUR_POINTS(); 

                }
                break;
            case 35 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:272: RULE_ASSIGN
                {
                mRULE_ASSIGN(); 

                }
                break;
            case 36 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:284: ARROW
                {
                mARROW(); 

                }
                break;
            case 37 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:290: STAR
                {
                mSTAR(); 

                }
                break;
            case 38 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:295: DIV
                {
                mDIV(); 

                }
                break;
            case 39 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:299: PLUS
                {
                mPLUS(); 

                }
                break;
            case 40 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:304: MINUS
                {
                mMINUS(); 

                }
                break;
            case 41 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:310: EQ
                {
                mEQ(); 

                }
                break;
            case 42 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:313: ISEQ
                {
                mISEQ(); 

                }
                break;
            case 43 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:318: ISNE
                {
                mISNE(); 

                }
                break;
            case 44 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:323: LT
                {
                mLT(); 

                }
                break;
            case 45 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:326: DOUBLE_LT
                {
                mDOUBLE_LT(); 

                }
                break;
            case 46 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:336: LE
                {
                mLE(); 

                }
                break;
            case 47 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:339: GT
                {
                mGT(); 

                }
                break;
            case 48 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:342: DOUBLE_GT
                {
                mDOUBLE_GT(); 

                }
                break;
            case 49 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:352: GE
                {
                mGE(); 

                }
                break;
            case 50 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:355: INCR
                {
                mINCR(); 

                }
                break;
            case 51 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:360: DECR
                {
                mDECR(); 

                }
                break;
            case 52 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:365: CALLOPERATION
                {
                mCALLOPERATION(); 

                }
                break;
            case 53 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:379: DIGIT
                {
                mDIGIT(); 

                }
                break;
            case 54 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:385: ALPHA
                {
                mALPHA(); 

                }
                break;
            case 55 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:391: UNDERSCORE
                {
                mUNDERSCORE(); 

                }
                break;
            case 56 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:402: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 57 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:410: REAL
                {
                mREAL(); 

                }
                break;
            case 58 :
                // D:\\Workspaces\\Workspace_PapyrusMDT_0.7.0\\org.eclipse.papyrus.parsers\\resources/grammars/PropertyLabel.g:1:415: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\1\47\5\52\3\uffff\1\60\6\uffff\1\62\1\64\1\66\1\70\1\72"+
        "\4\uffff\1\75\1\100\2\uffff\1\102\1\104\1\107\1\110\1\52\1\113\4"+
        "\uffff\1\51\2\uffff\4\51\14\uffff\1\123\16\uffff\1\124\1\uffff\6"+
        "\51\3\uffff\12\51\1\146\5\51\1\154\1\uffff\5\51\1\uffff\1\162\1"+
        "\51\1\164\1\165\1\51\1\uffff\1\51\2\uffff\1\170\1\171\2\uffff";
    static final String DFA4_eofS =
        "\172\uffff";
    static final String DFA4_minS =
        "\1\11\1\74\5\60\3\uffff\1\75\6\uffff\1\173\1\175\1\46\1\174\1\56"+
        "\4\uffff\1\72\1\55\2\uffff\1\53\2\75\1\56\2\60\4\uffff\1\141\2\uffff"+
        "\1\151\1\144\1\156\1\142\14\uffff\1\75\16\uffff\1\56\1\uffff\1\144"+
        "\1\145\1\157\1\145\1\165\1\163\3\uffff\1\117\1\146\1\165\1\156\1"+
        "\162\1\156\1\145\1\156\1\151\1\145\1\60\1\145\1\151\1\164\1\154"+
        "\1\156\1\60\1\uffff\1\144\1\161\1\163\1\171\1\145\1\uffff\1\60\1"+
        "\165\2\60\1\163\1\uffff\1\145\2\uffff\2\60\2\uffff";
    static final String DFA4_maxS =
        "\1\176\1\125\5\172\3\uffff\1\75\6\uffff\1\173\1\175\1\46\1\174"+
        "\1\56\4\uffff\1\75\1\76\2\uffff\1\53\1\75\1\76\1\71\2\172\4\uffff"+
        "\1\144\2\uffff\1\151\1\144\1\156\1\142\14\uffff\1\75\16\uffff\1"+
        "\71\1\uffff\1\144\1\145\1\161\1\145\1\165\1\163\3\uffff\1\117\1"+
        "\146\1\165\1\156\1\162\1\156\1\145\1\156\1\151\1\145\1\172\1\145"+
        "\1\151\1\164\1\154\1\156\1\172\1\uffff\1\144\1\161\1\163\1\171\1"+
        "\145\1\uffff\1\172\1\165\2\172\1\163\1\uffff\1\145\2\uffff\2\172"+
        "\2\uffff";
    static final String DFA4_acceptS =
        "\7\uffff\1\11\1\12\1\13\1\uffff\1\15\1\16\1\17\1\20\1\21\1\22\5"+
        "\uffff\1\35\1\36\1\37\1\40\2\uffff\1\45\1\46\6\uffff\1\56\1\1\1"+
        "\55\1\54\1\uffff\1\72\1\66\4\uffff\1\53\1\14\1\24\1\23\1\26\1\25"+
        "\1\30\1\27\1\32\1\31\1\34\1\33\1\uffff\1\64\1\41\1\44\1\63\1\50"+
        "\1\62\1\47\1\52\1\51\1\61\1\60\1\57\1\65\1\71\1\uffff\1\67\6\uffff"+
        "\1\43\1\42\1\70\21\uffff\1\3\5\uffff\1\5\5\uffff\1\4\1\uffff\1\7"+
        "\1\2\2\uffff\1\10\1\6";
    static final String DFA4_specialS =
        "\172\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\10\1\7\2\uffff\1\7\22\uffff\1\10\1\12\1\13\1\30\2\uffff"+
            "\1\23\1\14\1\15\1\16\1\34\1\36\1\26\1\33\1\25\1\35\12\41\1\32"+
            "\1\27\1\1\1\37\1\40\1\11\1\uffff\32\42\1\17\1\uffff\1\20\1\uffff"+
            "\1\43\1\uffff\15\42\1\5\1\4\2\42\1\2\1\6\1\42\1\3\5\42\1\21"+
            "\1\24\1\22\1\31",
            "\1\46\1\44\27\uffff\1\45",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\4\51\1\50\25\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\15\51\1\53\14\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\21\51\1\54\10\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\16\51\1\55\13\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\24\51\1\56\5\51",
            "",
            "",
            "",
            "\1\57",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\61",
            "\1\63",
            "\1\65",
            "\1\67",
            "\1\71",
            "",
            "",
            "",
            "",
            "\1\73\2\uffff\1\74",
            "\1\77\20\uffff\1\76",
            "",
            "",
            "\1\101",
            "\1\103",
            "\1\105\1\106",
            "\1\111\1\uffff\12\112",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "",
            "",
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
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\163",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\166",
            "",
            "\1\167",
            "",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
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
            return "1:1: Tokens : ( T54 | T55 | T56 | T57 | T58 | T59 | T60 | T61 | NL | WS | QUESTION_MARK | LNOT | DOUBLE_QUOTE | SINGLE_QUOTE | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | DOUBLE_LCURLY | RCURLY | DOUBLE_RCURLY | LOGICAL_AND | DOUBLE_LOGICAL_AND | PIPE | DOUBLE_PIPE | POINT | POINT_POINT | COMMA | SEMI | SHARP | TILDE | COLON | FOUR_POINTS | RULE_ASSIGN | ARROW | STAR | DIV | PLUS | MINUS | EQ | ISEQ | ISNE | LT | DOUBLE_LT | LE | GT | DOUBLE_GT | GE | INCR | DECR | CALLOPERATION | DIGIT | ALPHA | UNDERSCORE | INTEGER | REAL | IDENTIFIER );";
        }
    }
 

}