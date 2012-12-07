package org.eclipse.papyrus.infra.gmfdiag.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCSSLexer extends Lexer {
    public static final int RULE_ID=7;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int RULE_PC_UNIT=11;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=21;
    public static final int RULE_T_CLASS=19;
    public static final int EOF=-1;
    public static final int RULE_CDC=6;
    public static final int RULE_CDO=5;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_FREQ_UNIT=17;
    public static final int RULE_T_IMPORTANT=9;
    public static final int RULE_HASH=18;
    public static final int RULE_ML_COMMENT=20;
    public static final int T__30=30;
    public static final int RULE_TIME_UNIT=16;
    public static final int T__31=31;
    public static final int RULE_LEN_UNIT=12;
    public static final int T__32=32;
    public static final int RULE_STRING=8;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_T_NUM=10;
    public static final int RULE_ANGLE_UNIT=15;
    public static final int RULE_EX_UNIT=14;
    public static final int RULE_WS=4;
    public static final int RULE_EM_UNIT=13;

    // delegates
    // delegators

    public InternalCSSLexer() {;} 
    public InternalCSSLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCSSLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g"; }

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:11:7: ( '*' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:11:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:12:7: ( '-' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:12:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:13:7: ( '+' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:13:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:14:7: ( '>' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:14:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:15:7: ( '=' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:15:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:16:7: ( '~=' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:16:9: '~='
            {
            match("~="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:17:7: ( '!=' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:17:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:18:7: ( '@charset ' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:18:9: '@charset '
            {
            match("@charset "); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:19:7: ( ';' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:19:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:20:7: ( '@import' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:20:9: '@import'
            {
            match("@import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:21:7: ( ',' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:21:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:22:7: ( '@media' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:22:9: '@media'
            {
            match("@media"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:23:7: ( '{' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:23:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:24:7: ( '}' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:24:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:25:7: ( '@page' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:25:9: '@page'
            {
            match("@page"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:26:7: ( ':' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:26:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:27:7: ( '(' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:27:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:28:7: ( ')' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:28:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:29:7: ( 'url(' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:29:9: 'url('
            {
            match("url("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:30:7: ( '/' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:30:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:31:7: ( '[' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:31:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:32:7: ( ']' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:32:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "RULE_HASH"
    public final void mRULE_HASH() throws RecognitionException {
        try {
            int _type = RULE_HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7632:11: ( '#' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' )+ )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7632:13: '#' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' )+
            {
            match('#'); 
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7632:17: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HASH"

    // $ANTLR start "RULE_T_CLASS"
    public final void mRULE_T_CLASS() throws RecognitionException {
        try {
            int _type = RULE_T_CLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7634:14: ( '.' RULE_ID )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7634:16: '.' RULE_ID
            {
            match('.'); 
            mRULE_ID(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_T_CLASS"

    // $ANTLR start "RULE_T_IMPORTANT"
    public final void mRULE_T_IMPORTANT() throws RecognitionException {
        try {
            int _type = RULE_T_IMPORTANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7636:18: ( '!important' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7636:20: '!important'
            {
            match("!important"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_T_IMPORTANT"

    // $ANTLR start "RULE_PC_UNIT"
    public final void mRULE_PC_UNIT() throws RecognitionException {
        try {
            int _type = RULE_PC_UNIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7638:14: ( '%' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7638:16: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PC_UNIT"

    // $ANTLR start "RULE_LEN_UNIT"
    public final void mRULE_LEN_UNIT() throws RecognitionException {
        try {
            int _type = RULE_LEN_UNIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7640:15: ( ( 'px' | 'cm' | 'mm' | 'in' | 'pt' | 'pc' ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7640:17: ( 'px' | 'cm' | 'mm' | 'in' | 'pt' | 'pc' )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7640:17: ( 'px' | 'cm' | 'mm' | 'in' | 'pt' | 'pc' )
            int alt2=6;
            switch ( input.LA(1) ) {
            case 'p':
                {
                switch ( input.LA(2) ) {
                case 'x':
                    {
                    alt2=1;
                    }
                    break;
                case 't':
                    {
                    alt2=5;
                    }
                    break;
                case 'c':
                    {
                    alt2=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }

                }
                break;
            case 'c':
                {
                alt2=2;
                }
                break;
            case 'm':
                {
                alt2=3;
                }
                break;
            case 'i':
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7640:18: 'px'
                    {
                    match("px"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7640:23: 'cm'
                    {
                    match("cm"); 


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7640:28: 'mm'
                    {
                    match("mm"); 


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7640:33: 'in'
                    {
                    match("in"); 


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7640:38: 'pt'
                    {
                    match("pt"); 


                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7640:43: 'pc'
                    {
                    match("pc"); 


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
    // $ANTLR end "RULE_LEN_UNIT"

    // $ANTLR start "RULE_EM_UNIT"
    public final void mRULE_EM_UNIT() throws RecognitionException {
        try {
            int _type = RULE_EM_UNIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7642:14: ( 'em' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7642:16: 'em'
            {
            match("em"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EM_UNIT"

    // $ANTLR start "RULE_EX_UNIT"
    public final void mRULE_EX_UNIT() throws RecognitionException {
        try {
            int _type = RULE_EX_UNIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7644:14: ( 'ex' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7644:16: 'ex'
            {
            match("ex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EX_UNIT"

    // $ANTLR start "RULE_ANGLE_UNIT"
    public final void mRULE_ANGLE_UNIT() throws RecognitionException {
        try {
            int _type = RULE_ANGLE_UNIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7646:17: ( ( 'deg' | 'rad' | 'grad' ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7646:19: ( 'deg' | 'rad' | 'grad' )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7646:19: ( 'deg' | 'rad' | 'grad' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 'd':
                {
                alt3=1;
                }
                break;
            case 'r':
                {
                alt3=2;
                }
                break;
            case 'g':
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7646:20: 'deg'
                    {
                    match("deg"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7646:26: 'rad'
                    {
                    match("rad"); 


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7646:32: 'grad'
                    {
                    match("grad"); 


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
    // $ANTLR end "RULE_ANGLE_UNIT"

    // $ANTLR start "RULE_TIME_UNIT"
    public final void mRULE_TIME_UNIT() throws RecognitionException {
        try {
            int _type = RULE_TIME_UNIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7648:16: ( ( 's' | 'ms' ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7648:18: ( 's' | 'ms' )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7648:18: ( 's' | 'ms' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='s') ) {
                alt4=1;
            }
            else if ( (LA4_0=='m') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7648:19: 's'
                    {
                    match('s'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7648:23: 'ms'
                    {
                    match("ms"); 


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
    // $ANTLR end "RULE_TIME_UNIT"

    // $ANTLR start "RULE_FREQ_UNIT"
    public final void mRULE_FREQ_UNIT() throws RecognitionException {
        try {
            int _type = RULE_FREQ_UNIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7650:16: ( ( 'hz' | 'mhz' ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7650:18: ( 'hz' | 'mhz' )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7650:18: ( 'hz' | 'mhz' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='h') ) {
                alt5=1;
            }
            else if ( (LA5_0=='m') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7650:19: 'hz'
                    {
                    match("hz"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7650:24: 'mhz'
                    {
                    match("mhz"); 


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
    // $ANTLR end "RULE_FREQ_UNIT"

    // $ANTLR start "RULE_T_NUM"
    public final void mRULE_T_NUM() throws RecognitionException {
        try {
            int _type = RULE_T_NUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:12: ( ( ( '0' .. '9' )+ | ( '0' .. '9' )* '.' ( '0' .. '9' )+ ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:14: ( ( '0' .. '9' )+ | ( '0' .. '9' )* '.' ( '0' .. '9' )+ )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:14: ( ( '0' .. '9' )+ | ( '0' .. '9' )* '.' ( '0' .. '9' )+ )
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:15: ( '0' .. '9' )+
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:15: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:16: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:27: ( '0' .. '9' )* '.' ( '0' .. '9' )+
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:27: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:28: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('.'); 
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:43: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7652:44: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
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
    // $ANTLR end "RULE_T_NUM"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7654:9: ( ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '-' )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7654:11: ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '-' )*
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7654:11: ( '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='-') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7654:11: '-'
                    {
                    match('-'); 

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

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7654:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '-' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='-'||(LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\"') ) {
                alt14=1;
            }
            else if ( (LA14_0=='\'') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\\') ) {
                            alt12=1;
                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop12;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7656:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop13;
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

    // $ANTLR start "RULE_CDO"
    public final void mRULE_CDO() throws RecognitionException {
        try {
            int _type = RULE_CDO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7658:10: ( '<!--' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7658:12: '<!--'
            {
            match("<!--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CDO"

    // $ANTLR start "RULE_CDC"
    public final void mRULE_CDC() throws RecognitionException {
        try {
            int _type = RULE_CDC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7660:10: ( '-->' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7660:12: '-->'
            {
            match("-->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CDC"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7662:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7662:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7662:24: ( options {greedy=false; } : . )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='*') ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1=='/') ) {
                        alt15=2;
                    }
                    else if ( ((LA15_1>='\u0000' && LA15_1<='.')||(LA15_1>='0' && LA15_1<='\uFFFF')) ) {
                        alt15=1;
                    }


                }
                else if ( ((LA15_0>='\u0000' && LA15_0<=')')||(LA15_0>='+' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7662:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop15;
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7664:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7664:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7664:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7666:16: ( . )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:7666:18: .
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
        // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:8: ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | RULE_HASH | RULE_T_CLASS | RULE_T_IMPORTANT | RULE_PC_UNIT | RULE_LEN_UNIT | RULE_EM_UNIT | RULE_EX_UNIT | RULE_ANGLE_UNIT | RULE_TIME_UNIT | RULE_FREQ_UNIT | RULE_T_NUM | RULE_ID | RULE_STRING | RULE_CDO | RULE_CDC | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt17=40;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:10: T__22
                {
                mT__22(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:16: T__23
                {
                mT__23(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:22: T__24
                {
                mT__24(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:28: T__25
                {
                mT__25(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:34: T__26
                {
                mT__26(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:40: T__27
                {
                mT__27(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:46: T__28
                {
                mT__28(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:52: T__29
                {
                mT__29(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:58: T__30
                {
                mT__30(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:64: T__31
                {
                mT__31(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:70: T__32
                {
                mT__32(); 

                }
                break;
            case 12 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:76: T__33
                {
                mT__33(); 

                }
                break;
            case 13 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:82: T__34
                {
                mT__34(); 

                }
                break;
            case 14 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:88: T__35
                {
                mT__35(); 

                }
                break;
            case 15 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:94: T__36
                {
                mT__36(); 

                }
                break;
            case 16 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:100: T__37
                {
                mT__37(); 

                }
                break;
            case 17 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:106: T__38
                {
                mT__38(); 

                }
                break;
            case 18 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:112: T__39
                {
                mT__39(); 

                }
                break;
            case 19 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:118: T__40
                {
                mT__40(); 

                }
                break;
            case 20 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:124: T__41
                {
                mT__41(); 

                }
                break;
            case 21 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:130: T__42
                {
                mT__42(); 

                }
                break;
            case 22 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:136: T__43
                {
                mT__43(); 

                }
                break;
            case 23 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:142: RULE_HASH
                {
                mRULE_HASH(); 

                }
                break;
            case 24 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:152: RULE_T_CLASS
                {
                mRULE_T_CLASS(); 

                }
                break;
            case 25 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:165: RULE_T_IMPORTANT
                {
                mRULE_T_IMPORTANT(); 

                }
                break;
            case 26 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:182: RULE_PC_UNIT
                {
                mRULE_PC_UNIT(); 

                }
                break;
            case 27 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:195: RULE_LEN_UNIT
                {
                mRULE_LEN_UNIT(); 

                }
                break;
            case 28 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:209: RULE_EM_UNIT
                {
                mRULE_EM_UNIT(); 

                }
                break;
            case 29 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:222: RULE_EX_UNIT
                {
                mRULE_EX_UNIT(); 

                }
                break;
            case 30 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:235: RULE_ANGLE_UNIT
                {
                mRULE_ANGLE_UNIT(); 

                }
                break;
            case 31 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:251: RULE_TIME_UNIT
                {
                mRULE_TIME_UNIT(); 

                }
                break;
            case 32 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:266: RULE_FREQ_UNIT
                {
                mRULE_FREQ_UNIT(); 

                }
                break;
            case 33 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:281: RULE_T_NUM
                {
                mRULE_T_NUM(); 

                }
                break;
            case 34 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:292: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 35 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:300: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 36 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:312: RULE_CDO
                {
                mRULE_CDO(); 

                }
                break;
            case 37 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:321: RULE_CDC
                {
                mRULE_CDC(); 

                }
                break;
            case 38 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:330: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 39 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:346: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 40 :
                // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext.ui/src-gen/org/eclipse/papyrus/infra/gmfdiag/ui/contentassist/antlr/internal/InternalCSS.g:1:354: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA9_eotS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA9_eofS =
        "\4\uffff";
    static final String DFA9_minS =
        "\2\56\2\uffff";
    static final String DFA9_maxS =
        "\2\71\2\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA9_specialS =
        "\4\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\2\1\uffff\12\1",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "7652:14: ( ( '0' .. '9' )+ | ( '0' .. '9' )* '.' ( '0' .. '9' )+ )";
        }
    }
    static final String DFA17_eotS =
        "\2\uffff\1\52\3\uffff\3\47\7\uffff\1\53\1\77\2\uffff\2\47\1\uffff"+
        "\10\53\1\123\1\53\2\uffff\3\47\27\uffff\1\53\10\uffff\5\131\1\123"+
        "\1\53\1\131\1\133\1\134\3\53\1\uffff\1\140\3\uffff\1\53\1\uffff"+
        "\1\140\2\uffff\2\142\1\53\3\uffff\1\142";
    static final String DFA17_eofS =
        "\144\uffff";
    static final String DFA17_minS =
        "\1\0\1\uffff\1\55\3\uffff\2\75\1\143\7\uffff\1\162\1\52\2\uffff"+
        "\1\60\1\55\1\uffff\1\143\1\155\1\150\1\156\1\155\1\145\1\141\1\162"+
        "\1\55\1\172\2\uffff\2\0\1\41\27\uffff\1\154\10\uffff\6\55\1\172"+
        "\3\55\1\147\1\144\1\141\1\uffff\1\55\3\uffff\1\50\1\uffff\1\55\2"+
        "\uffff\2\55\1\144\3\uffff\1\55";
    static final String DFA17_maxS =
        "\1\uffff\1\uffff\1\172\3\uffff\1\75\1\151\1\160\7\uffff\1\162\1"+
        "\52\2\uffff\2\172\1\uffff\1\170\1\155\1\163\1\156\1\170\1\145\1"+
        "\141\1\162\2\172\2\uffff\2\uffff\1\41\27\uffff\1\154\10\uffff\12"+
        "\172\1\147\1\144\1\141\1\uffff\1\172\3\uffff\1\50\1\uffff\1\172"+
        "\2\uffff\2\172\1\144\3\uffff\1\172";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\3\uffff\1\11\1\13\1\15\1\16\1"+
        "\20\1\21\1\22\2\uffff\1\25\1\26\2\uffff\1\32\12\uffff\1\41\1\42"+
        "\3\uffff\1\47\1\50\1\1\1\45\1\2\1\42\1\3\1\4\1\5\1\6\1\7\1\31\1"+
        "\10\1\12\1\14\1\17\1\11\1\13\1\15\1\16\1\20\1\21\1\22\1\uffff\1"+
        "\46\1\24\1\25\1\26\1\27\1\41\1\30\1\32\15\uffff\1\37\1\uffff\1\43"+
        "\1\44\1\47\1\uffff\1\33\1\uffff\1\34\1\35\3\uffff\1\40\1\23\1\36"+
        "\1\uffff";
    static final String DFA17_specialS =
        "\1\1\42\uffff\1\2\1\0\77\uffff}>";
    static final String[] DFA17_transitionS = {
            "\11\47\2\46\2\47\1\46\22\47\1\46\1\7\1\43\1\24\1\47\1\26\1"+
            "\47\1\44\1\16\1\17\1\1\1\3\1\12\1\2\1\25\1\21\12\41\1\15\1\11"+
            "\1\45\1\5\1\4\1\47\1\10\32\42\1\22\1\47\1\23\1\47\1\42\1\47"+
            "\2\42\1\30\1\34\1\33\1\42\1\36\1\40\1\32\3\42\1\31\2\42\1\27"+
            "\1\42\1\35\1\37\1\42\1\20\5\42\1\13\1\47\1\14\1\6\uff81\47",
            "",
            "\1\51\23\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "",
            "\1\57",
            "\1\60\53\uffff\1\61",
            "\1\62\5\uffff\1\63\3\uffff\1\64\2\uffff\1\65",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\75",
            "\1\76",
            "",
            "",
            "\12\102\7\uffff\32\102\6\uffff\32\102",
            "\1\104\2\uffff\12\103\7\uffff\32\104\4\uffff\1\104\1\uffff"+
            "\32\104",
            "",
            "\1\110\20\uffff\1\107\3\uffff\1\106",
            "\1\111",
            "\1\114\4\uffff\1\112\5\uffff\1\113",
            "\1\115",
            "\1\116\12\uffff\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\124",
            "",
            "",
            "\0\125",
            "\0\125",
            "\1\126",
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
            "",
            "",
            "",
            "",
            "",
            "\1\130",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\132",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            "",
            "",
            "\1\141",
            "",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "",
            "",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53",
            "\1\143",
            "",
            "",
            "",
            "\1\53\2\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32"+
            "\53"
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | RULE_HASH | RULE_T_CLASS | RULE_T_IMPORTANT | RULE_PC_UNIT | RULE_LEN_UNIT | RULE_EM_UNIT | RULE_EX_UNIT | RULE_ANGLE_UNIT | RULE_TIME_UNIT | RULE_FREQ_UNIT | RULE_T_NUM | RULE_ID | RULE_STRING | RULE_CDO | RULE_CDC | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_36 = input.LA(1);

                        s = -1;
                        if ( ((LA17_36>='\u0000' && LA17_36<='\uFFFF')) ) {s = 85;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_0 = input.LA(1);

                        s = -1;
                        if ( (LA17_0=='*') ) {s = 1;}

                        else if ( (LA17_0=='-') ) {s = 2;}

                        else if ( (LA17_0=='+') ) {s = 3;}

                        else if ( (LA17_0=='>') ) {s = 4;}

                        else if ( (LA17_0=='=') ) {s = 5;}

                        else if ( (LA17_0=='~') ) {s = 6;}

                        else if ( (LA17_0=='!') ) {s = 7;}

                        else if ( (LA17_0=='@') ) {s = 8;}

                        else if ( (LA17_0==';') ) {s = 9;}

                        else if ( (LA17_0==',') ) {s = 10;}

                        else if ( (LA17_0=='{') ) {s = 11;}

                        else if ( (LA17_0=='}') ) {s = 12;}

                        else if ( (LA17_0==':') ) {s = 13;}

                        else if ( (LA17_0=='(') ) {s = 14;}

                        else if ( (LA17_0==')') ) {s = 15;}

                        else if ( (LA17_0=='u') ) {s = 16;}

                        else if ( (LA17_0=='/') ) {s = 17;}

                        else if ( (LA17_0=='[') ) {s = 18;}

                        else if ( (LA17_0==']') ) {s = 19;}

                        else if ( (LA17_0=='#') ) {s = 20;}

                        else if ( (LA17_0=='.') ) {s = 21;}

                        else if ( (LA17_0=='%') ) {s = 22;}

                        else if ( (LA17_0=='p') ) {s = 23;}

                        else if ( (LA17_0=='c') ) {s = 24;}

                        else if ( (LA17_0=='m') ) {s = 25;}

                        else if ( (LA17_0=='i') ) {s = 26;}

                        else if ( (LA17_0=='e') ) {s = 27;}

                        else if ( (LA17_0=='d') ) {s = 28;}

                        else if ( (LA17_0=='r') ) {s = 29;}

                        else if ( (LA17_0=='g') ) {s = 30;}

                        else if ( (LA17_0=='s') ) {s = 31;}

                        else if ( (LA17_0=='h') ) {s = 32;}

                        else if ( ((LA17_0>='0' && LA17_0<='9')) ) {s = 33;}

                        else if ( ((LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='b')||LA17_0=='f'||(LA17_0>='j' && LA17_0<='l')||(LA17_0>='n' && LA17_0<='o')||LA17_0=='q'||LA17_0=='t'||(LA17_0>='v' && LA17_0<='z')) ) {s = 34;}

                        else if ( (LA17_0=='\"') ) {s = 35;}

                        else if ( (LA17_0=='\'') ) {s = 36;}

                        else if ( (LA17_0=='<') ) {s = 37;}

                        else if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {s = 38;}

                        else if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||LA17_0=='$'||LA17_0=='&'||LA17_0=='?'||LA17_0=='\\'||LA17_0=='^'||LA17_0=='`'||LA17_0=='|'||(LA17_0>='\u007F' && LA17_0<='\uFFFF')) ) {s = 39;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_35 = input.LA(1);

                        s = -1;
                        if ( ((LA17_35>='\u0000' && LA17_35<='\uFFFF')) ) {s = 85;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}