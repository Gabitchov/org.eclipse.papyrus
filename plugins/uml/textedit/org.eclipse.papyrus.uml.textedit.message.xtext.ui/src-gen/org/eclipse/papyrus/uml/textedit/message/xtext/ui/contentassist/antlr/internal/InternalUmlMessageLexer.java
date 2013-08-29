package org.eclipse.papyrus.uml.textedit.message.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlMessageLexer extends Lexer {
    public static final int RULE_NAMERULE=5;
    public static final int RULE_ID=7;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=6;
    public static final int RULE_INTEGER_VALUE=8;
    public static final int RULE_WS=11;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;

    // delegates
    // delegators

    public InternalUmlMessageLexer() {;} 
    public InternalUmlMessageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUmlMessageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:11:7: ( ':' )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:11:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:12:7: ( '.' )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:12:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:13:7: ( '*' )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:13:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:14:7: ( '[' )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:14:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:15:7: ( ']' )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:15:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "RULE_NAMERULE"
    public final void mRULE_NAMERULE() throws RecognitionException {
        try {
            int _type = RULE_NAMERULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:765:15: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' | '(' | ')' )* )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:765:17: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' | '(' | ')' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:765:37: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' | '(' | ')' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='(' && LA1_0<=')')||LA1_0=='-'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:
            	    {
            	    if ( (input.LA(1)>='(' && input.LA(1)<=')')||input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NAMERULE"

    // $ANTLR start "RULE_INTEGER_VALUE"
    public final void mRULE_INTEGER_VALUE() throws RecognitionException {
        try {
            int _type = RULE_INTEGER_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:20: ( ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* ) )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            int alt14=4;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'B':
                case 'b':
                    {
                    alt14=2;
                    }
                    break;
                case 'X':
                case 'x':
                    {
                    alt14=3;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '_':
                    {
                    alt14=4;
                    }
                    break;
                default:
                    alt14=1;}

            }
            else if ( ((LA14_0>='1' && LA14_0<='9')) ) {
                alt14=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='0') ) {
                        alt4=1;
                    }
                    else if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:24: '0'
                            {
                            match('0'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:28: '1' .. '9' ( ( '_' )? '0' .. '9' )*
                            {
                            matchRange('1','9'); 
                            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:37: ( ( '_' )? '0' .. '9' )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( ((LA3_0>='0' && LA3_0<='9')||LA3_0=='_') ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:38: ( '_' )? '0' .. '9'
                            	    {
                            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:38: ( '_' )?
                            	    int alt2=2;
                            	    int LA2_0 = input.LA(1);

                            	    if ( (LA2_0=='_') ) {
                            	        alt2=1;
                            	    }
                            	    switch (alt2) {
                            	        case 1 :
                            	            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:38: '_'
                            	            {
                            	            match('_'); 

                            	            }
                            	            break;

                            	    }

                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:55: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
                    {
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:55: ( '0b' | '0B' )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='0') ) {
                        int LA5_1 = input.LA(2);

                        if ( (LA5_1=='b') ) {
                            alt5=1;
                        }
                        else if ( (LA5_1=='B') ) {
                            alt5=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:56: '0b'
                            {
                            match("0b"); 


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:61: '0B'
                            {
                            match("0B"); 


                            }
                            break;

                    }

                    matchRange('0','1'); 
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:76: ( ( '_' )? '0' .. '1' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='1')||LA7_0=='_') ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:77: ( '_' )? '0' .. '1'
                    	    {
                    	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:77: ( '_' )?
                    	    int alt6=2;
                    	    int LA6_0 = input.LA(1);

                    	    if ( (LA6_0=='_') ) {
                    	        alt6=1;
                    	    }
                    	    switch (alt6) {
                    	        case 1 :
                    	            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:77: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','1'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:93: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    {
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:93: ( '0x' | '0X' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='0') ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1=='x') ) {
                            alt8=1;
                        }
                        else if ( (LA8_1=='X') ) {
                            alt8=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:94: '0x'
                            {
                            match("0x"); 


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:99: '0X'
                            {
                            match("0X"); 


                            }
                            break;

                    }

                    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:134: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='F')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='f')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:135: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
                    	    {
                    	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:135: ( '_' )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0=='_') ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:135: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:171: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
                    {
                    match('0'); 
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:175: ( '_' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='_') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:175: '_'
                            {
                            match('_'); 

                            }
                            break;

                    }

                    matchRange('0','7'); 
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:189: ( ( '_' )? '0' .. '7' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='7')||LA13_0=='_') ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:190: ( '_' )? '0' .. '7'
                    	    {
                    	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:190: ( '_' )?
                    	    int alt12=2;
                    	    int LA12_0 = input.LA(1);

                    	    if ( (LA12_0=='_') ) {
                    	        alt12=1;
                    	    }
                    	    switch (alt12) {
                    	        case 1 :
                    	            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:767:190: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','7'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


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
    // $ANTLR end "RULE_INTEGER_VALUE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:769:9: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' ) )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:769:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:769:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
                alt17=1;
            }
            else if ( (LA17_0=='\'') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:769:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:769:36: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')||(LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='z')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:
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
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:769:70: '\\'' ( options {greedy=false; } : . )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:769:75: ( options {greedy=false; } : . )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0=='\'') ) {
                            alt16=2;
                        }
                        else if ( ((LA16_0>='\u0000' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='\uFFFF')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:769:103: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
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
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:771:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:771:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:771:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\\') ) {
                    alt18=1;
                }
                else if ( ((LA18_0>='\u0000' && LA18_0<='!')||(LA18_0>='#' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='\uFFFF')) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:771:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:771:61: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop18;
                }
            } while (true);

            match('\"'); 

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
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:773:17: ( '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:773:19: '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            if ( (input.LA(1)>='\u0000' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:773:31: ( options {greedy=false; } : . )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='*') ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1=='/') ) {
                        alt19=2;
                    }
                    else if ( ((LA19_1>='\u0000' && LA19_1<='.')||(LA19_1>='0' && LA19_1<='\uFFFF')) ) {
                        alt19=1;
                    }


                }
                else if ( ((LA19_0>='\u0000' && LA19_0<=')')||(LA19_0>='+' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:773:59: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop19;
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
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:775:17: ( '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:775:19: '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:775:24: (~ ( ( '\\n' | '\\r' | '@' ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\u0000' && LA20_0<='\t')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='?')||(LA20_0>='A' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:775:24: ~ ( ( '\\n' | '\\r' | '@' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:775:44: ( ( '\\r' )? '\\n' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\n'||LA22_0=='\r') ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:775:45: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:775:45: ( '\\r' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='\r') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:775:45: '\\r'
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:777:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:777:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:777:12: ( '0' .. '9' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='0' && LA23_0<='9')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:777:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:779:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:779:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:779:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='\t' && LA24_0<='\n')||LA24_0=='\r'||LA24_0==' ') ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:
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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
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
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:781:16: ( . )
            // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:781:18: .
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
        // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | RULE_NAMERULE | RULE_INTEGER_VALUE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_WS | RULE_ANY_OTHER )
        int alt25=14;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:40: RULE_NAMERULE
                {
                mRULE_NAMERULE(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:54: RULE_INTEGER_VALUE
                {
                mRULE_INTEGER_VALUE(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:73: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:81: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:93: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:109: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 12 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:125: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 13 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:134: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 14 :
                // ../org.eclipse.papyrus.uml.textedit.message.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/message/xtext/ui/contentassist/antlr/internal/InternalUmlMessage.g:1:142: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\6\uffff\1\24\2\26\1\uffff\3\16\10\uffff\1\24\1\uffff\1\26\1\uffff"+
        "\1\26\5\uffff\1\26";
    static final String DFA25_eofS =
        "\40\uffff";
    static final String DFA25_minS =
        "\1\0\5\uffff\3\60\1\uffff\2\0\1\52\10\uffff\1\60\1\uffff\1\60\1"+
        "\uffff\1\60\5\uffff\1\60";
    static final String DFA25_maxS =
        "\1\uffff\5\uffff\1\172\2\71\1\uffff\2\uffff\1\57\10\uffff\1\172"+
        "\1\uffff\1\71\1\uffff\1\71\5\uffff\1\71";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\3\uffff\1\10\3\uffff\1\15\1\16\1\1"+
        "\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff\1\14\1\uffff\1\10\1\11"+
        "\1\12\1\13\1\15\1\uffff";
    static final String DFA25_specialS =
        "\1\2\11\uffff\1\1\1\0\24\uffff}>";
    static final String[] DFA25_transitionS = {
            "\11\16\2\15\2\16\1\15\22\16\1\15\1\16\1\13\4\16\1\12\2\16\1"+
            "\3\3\16\1\2\1\14\1\7\11\10\1\1\6\16\32\6\1\4\1\16\1\5\1\16\1"+
            "\11\1\16\32\6\uff85\16",
            "",
            "",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\10\27\2\30",
            "\12\31",
            "",
            "\0\32",
            "\0\33",
            "\1\34\4\uffff\1\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\10\37\2\30",
            "",
            "\12\31",
            "",
            "",
            "",
            "",
            "",
            "\10\37\2\30"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | RULE_NAMERULE | RULE_INTEGER_VALUE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_11 = input.LA(1);

                        s = -1;
                        if ( ((LA25_11>='\u0000' && LA25_11<='\uFFFF')) ) {s = 27;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_10 = input.LA(1);

                        s = -1;
                        if ( ((LA25_10>='\u0000' && LA25_10<='\uFFFF')) ) {s = 26;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_0 = input.LA(1);

                        s = -1;
                        if ( (LA25_0==':') ) {s = 1;}

                        else if ( (LA25_0=='.') ) {s = 2;}

                        else if ( (LA25_0=='*') ) {s = 3;}

                        else if ( (LA25_0=='[') ) {s = 4;}

                        else if ( (LA25_0==']') ) {s = 5;}

                        else if ( ((LA25_0>='A' && LA25_0<='Z')||(LA25_0>='a' && LA25_0<='z')) ) {s = 6;}

                        else if ( (LA25_0=='0') ) {s = 7;}

                        else if ( ((LA25_0>='1' && LA25_0<='9')) ) {s = 8;}

                        else if ( (LA25_0=='_') ) {s = 9;}

                        else if ( (LA25_0=='\'') ) {s = 10;}

                        else if ( (LA25_0=='\"') ) {s = 11;}

                        else if ( (LA25_0=='/') ) {s = 12;}

                        else if ( ((LA25_0>='\t' && LA25_0<='\n')||LA25_0=='\r'||LA25_0==' ') ) {s = 13;}

                        else if ( ((LA25_0>='\u0000' && LA25_0<='\b')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\u001F')||LA25_0=='!'||(LA25_0>='#' && LA25_0<='&')||(LA25_0>='(' && LA25_0<=')')||(LA25_0>='+' && LA25_0<='-')||(LA25_0>=';' && LA25_0<='@')||LA25_0=='\\'||LA25_0=='^'||LA25_0=='`'||(LA25_0>='{' && LA25_0<='\uFFFF')) ) {s = 14;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}