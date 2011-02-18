package org.eclipse.papyrus.common.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlCommonLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int RULE_STRING=7;
    public static final int RULE_UNLIMITEDLITERAL=5;
    public static final int T__12=12;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=6;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

    // delegates
    // delegators

    public InternalUmlCommonLexer() {;} 
    public InternalUmlCommonLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUmlCommonLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:11:7: ( '::' )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:11:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "RULE_UNLIMITEDLITERAL"
    public final void mRULE_UNLIMITEDLITERAL() throws RecognitionException {
        try {
            int _type = RULE_UNLIMITEDLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:170:23: ( ( '0' .. '9' ( '0' .. '9' )* | '*' ) )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:170:25: ( '0' .. '9' ( '0' .. '9' )* | '*' )
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:170:25: ( '0' .. '9' ( '0' .. '9' )* | '*' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                alt2=1;
            }
            else if ( (LA2_0=='*') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:170:26: '0' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('0','9'); 
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:170:35: ( '0' .. '9' )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:170:36: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:170:47: '*'
                    {
                    match('*'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNLIMITEDLITERAL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:172:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:172:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:172:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:172:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:172:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:174:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:174:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:174:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:174:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
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
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:176:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:178:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:178:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:178:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:178:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:180:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:180:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:180:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:180:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:180:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:180:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:180:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:180:41: '\\r'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:182:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:182:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:182:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:184:16: ( . )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:184:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:8: ( T__12 | RULE_UNLIMITEDLITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=9;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:16: RULE_UNLIMITEDLITERAL
                {
                mRULE_UNLIMITEDLITERAL(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:38: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:46: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:55: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:67: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:83: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:99: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:1:107: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\12\1\15\1\uffff\1\12\1\uffff\3\12\3\uffff\1\15\6\uffff";
    static final String DFA14_eofS =
        "\23\uffff";
    static final String DFA14_minS =
        "\1\0\1\72\1\60\1\uffff\1\101\1\uffff\2\0\1\52\3\uffff\1\60\6\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\72\1\71\1\uffff\1\172\1\uffff\2\uffff\1\57\3\uffff\1"+
        "\71\6\uffff";
    static final String DFA14_acceptS =
        "\3\uffff\1\2\1\uffff\1\3\3\uffff\1\10\1\11\1\1\1\uffff\1\2\1\3"+
        "\1\5\1\6\1\7\1\10";
    static final String DFA14_specialS =
        "\1\1\5\uffff\1\2\1\0\13\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\12\2\11\2\12\1\11\22\12\1\11\1\12\1\6\4\12\1\7\2\12\1\3"+
            "\4\12\1\10\12\2\1\1\6\12\32\5\3\12\1\4\1\5\1\12\32\5\uff85\12",
            "\1\13",
            "\12\14",
            "",
            "\32\16\4\uffff\1\16\1\uffff\32\16",
            "",
            "\0\17",
            "\0\17",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "",
            "\12\14",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | RULE_UNLIMITEDLITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_7 = input.LA(1);

                        s = -1;
                        if ( ((LA14_7>='\u0000' && LA14_7<='\uFFFF')) ) {s = 15;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0==':') ) {s = 1;}

                        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {s = 2;}

                        else if ( (LA14_0=='*') ) {s = 3;}

                        else if ( (LA14_0=='^') ) {s = 4;}

                        else if ( ((LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')) ) {s = 5;}

                        else if ( (LA14_0=='\"') ) {s = 6;}

                        else if ( (LA14_0=='\'') ) {s = 7;}

                        else if ( (LA14_0=='/') ) {s = 8;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 9;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='#' && LA14_0<='&')||(LA14_0>='(' && LA14_0<=')')||(LA14_0>='+' && LA14_0<='.')||(LA14_0>=';' && LA14_0<='@')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||(LA14_0>='{' && LA14_0<='\uFFFF')) ) {s = 10;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_6 = input.LA(1);

                        s = -1;
                        if ( ((LA14_6>='\u0000' && LA14_6<='\uFFFF')) ) {s = 15;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}