package org.eclipse.papyrus.transition.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlTransitionLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int Tokens=22;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_STRING=5;
    public static final int RULE_INT=6;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int RULE_WS=9;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T19=19;
    public InternalUmlTransitionLexer() {;} 
    public InternalUmlTransitionLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:10:5: ( 'Activity' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:10:7: 'Activity'
            {
            match("Activity"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:11:5: ( 'StateMachine' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:11:7: 'StateMachine'
            {
            match("StateMachine"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:12:5: ( 'OpaqueBehavior' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:12:7: 'OpaqueBehavior'
            {
            match("OpaqueBehavior"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:13:5: ( ',' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:13:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:14:5: ( 'after' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:14:7: 'after'
            {
            match("after"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:15:5: ( 'at' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:15:7: 'at'
            {
            match("at"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:16:5: ( 'when' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:16:7: 'when'
            {
            match("when"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:17:5: ( '[' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:17:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:18:5: ( ']' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:18:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:19:5: ( '/' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:19:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:20:5: ( 'all' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:20:7: 'all'
            {
            match("all"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1284:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1284:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1284:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1284:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1284:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:
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
            	    break loop2;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1286:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1286:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1286:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1286:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1288:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:62: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
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
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1288:129: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
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
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1290:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1290:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1290:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFE')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1290:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1292:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1292:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1292:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1292:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
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
            	    break loop8;
                }
            } while (true);

            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1292:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1292:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1292:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1292:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1294:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1294:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1294:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1296:16: ( . )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1296:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=18;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='A') ) {
            int LA12_1 = input.LA(2);

            if ( (LA12_1=='c') ) {
                int LA12_17 = input.LA(3);

                if ( (LA12_17=='t') ) {
                    int LA12_34 = input.LA(4);

                    if ( (LA12_34=='i') ) {
                        int LA12_41 = input.LA(5);

                        if ( (LA12_41=='v') ) {
                            int LA12_47 = input.LA(6);

                            if ( (LA12_47=='i') ) {
                                int LA12_52 = input.LA(7);

                                if ( (LA12_52=='t') ) {
                                    int LA12_56 = input.LA(8);

                                    if ( (LA12_56=='y') ) {
                                        int LA12_59 = input.LA(9);

                                        if ( ((LA12_59>='0' && LA12_59<='9')||(LA12_59>='A' && LA12_59<='Z')||LA12_59=='_'||(LA12_59>='a' && LA12_59<='z')) ) {
                                            alt12=12;
                                        }
                                        else {
                                            alt12=1;}
                                    }
                                    else {
                                        alt12=12;}
                                }
                                else {
                                    alt12=12;}
                            }
                            else {
                                alt12=12;}
                        }
                        else {
                            alt12=12;}
                    }
                    else {
                        alt12=12;}
                }
                else {
                    alt12=12;}
            }
            else {
                alt12=12;}
        }
        else if ( (LA12_0=='S') ) {
            int LA12_2 = input.LA(2);

            if ( (LA12_2=='t') ) {
                int LA12_19 = input.LA(3);

                if ( (LA12_19=='a') ) {
                    int LA12_35 = input.LA(4);

                    if ( (LA12_35=='t') ) {
                        int LA12_42 = input.LA(5);

                        if ( (LA12_42=='e') ) {
                            int LA12_48 = input.LA(6);

                            if ( (LA12_48=='M') ) {
                                int LA12_53 = input.LA(7);

                                if ( (LA12_53=='a') ) {
                                    int LA12_57 = input.LA(8);

                                    if ( (LA12_57=='c') ) {
                                        int LA12_60 = input.LA(9);

                                        if ( (LA12_60=='h') ) {
                                            int LA12_63 = input.LA(10);

                                            if ( (LA12_63=='i') ) {
                                                int LA12_65 = input.LA(11);

                                                if ( (LA12_65=='n') ) {
                                                    int LA12_67 = input.LA(12);

                                                    if ( (LA12_67=='e') ) {
                                                        int LA12_69 = input.LA(13);

                                                        if ( ((LA12_69>='0' && LA12_69<='9')||(LA12_69>='A' && LA12_69<='Z')||LA12_69=='_'||(LA12_69>='a' && LA12_69<='z')) ) {
                                                            alt12=12;
                                                        }
                                                        else {
                                                            alt12=2;}
                                                    }
                                                    else {
                                                        alt12=12;}
                                                }
                                                else {
                                                    alt12=12;}
                                            }
                                            else {
                                                alt12=12;}
                                        }
                                        else {
                                            alt12=12;}
                                    }
                                    else {
                                        alt12=12;}
                                }
                                else {
                                    alt12=12;}
                            }
                            else {
                                alt12=12;}
                        }
                        else {
                            alt12=12;}
                    }
                    else {
                        alt12=12;}
                }
                else {
                    alt12=12;}
            }
            else {
                alt12=12;}
        }
        else if ( (LA12_0=='O') ) {
            int LA12_3 = input.LA(2);

            if ( (LA12_3=='p') ) {
                int LA12_20 = input.LA(3);

                if ( (LA12_20=='a') ) {
                    int LA12_36 = input.LA(4);

                    if ( (LA12_36=='q') ) {
                        int LA12_43 = input.LA(5);

                        if ( (LA12_43=='u') ) {
                            int LA12_49 = input.LA(6);

                            if ( (LA12_49=='e') ) {
                                int LA12_54 = input.LA(7);

                                if ( (LA12_54=='B') ) {
                                    int LA12_58 = input.LA(8);

                                    if ( (LA12_58=='e') ) {
                                        int LA12_61 = input.LA(9);

                                        if ( (LA12_61=='h') ) {
                                            int LA12_64 = input.LA(10);

                                            if ( (LA12_64=='a') ) {
                                                int LA12_66 = input.LA(11);

                                                if ( (LA12_66=='v') ) {
                                                    int LA12_68 = input.LA(12);

                                                    if ( (LA12_68=='i') ) {
                                                        int LA12_70 = input.LA(13);

                                                        if ( (LA12_70=='o') ) {
                                                            int LA12_72 = input.LA(14);

                                                            if ( (LA12_72=='r') ) {
                                                                int LA12_73 = input.LA(15);

                                                                if ( ((LA12_73>='0' && LA12_73<='9')||(LA12_73>='A' && LA12_73<='Z')||LA12_73=='_'||(LA12_73>='a' && LA12_73<='z')) ) {
                                                                    alt12=12;
                                                                }
                                                                else {
                                                                    alt12=3;}
                                                            }
                                                            else {
                                                                alt12=12;}
                                                        }
                                                        else {
                                                            alt12=12;}
                                                    }
                                                    else {
                                                        alt12=12;}
                                                }
                                                else {
                                                    alt12=12;}
                                            }
                                            else {
                                                alt12=12;}
                                        }
                                        else {
                                            alt12=12;}
                                    }
                                    else {
                                        alt12=12;}
                                }
                                else {
                                    alt12=12;}
                            }
                            else {
                                alt12=12;}
                        }
                        else {
                            alt12=12;}
                    }
                    else {
                        alt12=12;}
                }
                else {
                    alt12=12;}
            }
            else {
                alt12=12;}
        }
        else if ( (LA12_0==',') ) {
            alt12=4;
        }
        else if ( (LA12_0=='a') ) {
            switch ( input.LA(2) ) {
            case 'f':
                {
                int LA12_22 = input.LA(3);

                if ( (LA12_22=='t') ) {
                    int LA12_37 = input.LA(4);

                    if ( (LA12_37=='e') ) {
                        int LA12_44 = input.LA(5);

                        if ( (LA12_44=='r') ) {
                            int LA12_50 = input.LA(6);

                            if ( ((LA12_50>='0' && LA12_50<='9')||(LA12_50>='A' && LA12_50<='Z')||LA12_50=='_'||(LA12_50>='a' && LA12_50<='z')) ) {
                                alt12=12;
                            }
                            else {
                                alt12=5;}
                        }
                        else {
                            alt12=12;}
                    }
                    else {
                        alt12=12;}
                }
                else {
                    alt12=12;}
                }
                break;
            case 't':
                {
                int LA12_23 = input.LA(3);

                if ( ((LA12_23>='0' && LA12_23<='9')||(LA12_23>='A' && LA12_23<='Z')||LA12_23=='_'||(LA12_23>='a' && LA12_23<='z')) ) {
                    alt12=12;
                }
                else {
                    alt12=6;}
                }
                break;
            case 'l':
                {
                int LA12_24 = input.LA(3);

                if ( (LA12_24=='l') ) {
                    int LA12_39 = input.LA(4);

                    if ( ((LA12_39>='0' && LA12_39<='9')||(LA12_39>='A' && LA12_39<='Z')||LA12_39=='_'||(LA12_39>='a' && LA12_39<='z')) ) {
                        alt12=12;
                    }
                    else {
                        alt12=11;}
                }
                else {
                    alt12=12;}
                }
                break;
            default:
                alt12=12;}

        }
        else if ( (LA12_0=='w') ) {
            int LA12_6 = input.LA(2);

            if ( (LA12_6=='h') ) {
                int LA12_25 = input.LA(3);

                if ( (LA12_25=='e') ) {
                    int LA12_40 = input.LA(4);

                    if ( (LA12_40=='n') ) {
                        int LA12_46 = input.LA(5);

                        if ( ((LA12_46>='0' && LA12_46<='9')||(LA12_46>='A' && LA12_46<='Z')||LA12_46=='_'||(LA12_46>='a' && LA12_46<='z')) ) {
                            alt12=12;
                        }
                        else {
                            alt12=7;}
                    }
                    else {
                        alt12=12;}
                }
                else {
                    alt12=12;}
            }
            else {
                alt12=12;}
        }
        else if ( (LA12_0=='[') ) {
            alt12=8;
        }
        else if ( (LA12_0==']') ) {
            alt12=9;
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt12=15;
                }
                break;
            case '/':
                {
                alt12=16;
                }
                break;
            default:
                alt12=10;}

        }
        else if ( (LA12_0=='^') ) {
            int LA12_10 = input.LA(2);

            if ( ((LA12_10>='A' && LA12_10<='Z')||LA12_10=='_'||(LA12_10>='a' && LA12_10<='z')) ) {
                alt12=12;
            }
            else {
                alt12=18;}
        }
        else if ( ((LA12_0>='B' && LA12_0<='N')||(LA12_0>='P' && LA12_0<='R')||(LA12_0>='T' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='b' && LA12_0<='v')||(LA12_0>='x' && LA12_0<='z')) ) {
            alt12=12;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=13;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_13 = input.LA(2);

            if ( ((LA12_13>='\u0000' && LA12_13<='\uFFFE')) ) {
                alt12=14;
            }
            else {
                alt12=18;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_14 = input.LA(2);

            if ( ((LA12_14>='\u0000' && LA12_14<='\uFFFE')) ) {
                alt12=14;
            }
            else {
                alt12=18;}
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=17;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='+')||(LA12_0>='-' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12=18;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:54: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 13 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:62: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 14 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:71: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 15 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:83: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 16 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:99: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 17 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:115: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 18 :
                // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1:123: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}