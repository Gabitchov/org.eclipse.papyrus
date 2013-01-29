package org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStereotypeApplicationWithVSLLexer extends Lexer {
    public static final int RULE_DATETIMELITERAL=7;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__20=20;
    public static final int RULE_REALLITERAL=6;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_BOOLEANLITERAL=8;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__17=17;
    public static final int RULE_INT=11;
    public static final int T__50=50;
    public static final int RULE_NULLLITERAL=9;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_INTEGERLITERAL=5;
    public static final int RULE_SL_COMMENT=13;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=10;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=14;

    // delegates
    // delegators

    public InternalStereotypeApplicationWithVSLLexer() {;} 
    public InternalStereotypeApplicationWithVSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalStereotypeApplicationWithVSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:11:7: ( 'and' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:11:9: 'and'
            {
            match("and"); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:12:7: ( 'or' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:12:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:13:7: ( 'xor' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:13:9: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:14:7: ( '==' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:14:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:15:7: ( '<>' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:15:9: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:16:7: ( '<' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:16:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:17:7: ( '>' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:17:9: '>'
            {
            match('>'); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:18:7: ( '<=' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:18:9: '<='
            {
            match("<="); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:19:7: ( '>=' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:19:9: '>='
            {
            match(">="); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:20:7: ( '+' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:20:9: '+'
            {
            match('+'); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:21:7: ( '-' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:21:9: '-'
            {
            match('-'); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:22:7: ( '*' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:22:9: '*'
            {
            match('*'); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:23:7: ( '/' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:23:9: '/'
            {
            match('/'); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:24:7: ( 'mod' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:24:9: 'mod'
            {
            match("mod"); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:25:7: ( 'not' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:25:9: 'not'
            {
            match("not"); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:26:7: ( ']' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:26:9: ']'
            {
            match(']'); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:27:7: ( '[' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:27:9: '['
            {
            match('['); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:28:7: ( 'in' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:28:9: 'in'
            {
            match("in"); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:29:7: ( 'out' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:29:9: 'out'
            {
            match("out"); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:30:7: ( 'inout' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:30:9: 'inout'
            {
            match("inout"); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:31:7: ( '<<' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:31:9: '<<'
            {
            match("<<"); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:32:7: ( '>>' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:32:9: '>>'
            {
            match(">>"); 


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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:33:7: ( ',' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:33:9: ','
            {
            match(','); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:34:7: ( '=' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:34:9: '='
            {
            match('='); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:35:7: ( ':' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:35:9: ':'
            {
            match(':'); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:36:7: ( '.' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:36:9: '.'
            {
            match('.'); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:37:7: ( '(' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:37:9: '('
            {
            match('('); 

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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:38:7: ( ')' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:38:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:39:7: ( '::' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:39:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:40:7: ( '..' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:40:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:41:7: ( '{' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:41:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:42:7: ( '}' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:42:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:43:7: ( '@' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:43:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:44:7: ( 'when' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:44:9: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:45:7: ( '&' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:45:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:46:7: ( 'jitter(' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:46:9: 'jitter('
            {
            match("jitter("); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:47:7: ( '$' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:47:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:48:7: ( '?' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:48:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "RULE_INTEGERLITERAL"
    public final void mRULE_INTEGERLITERAL() throws RecognitionException {
        try {
            int _type = RULE_INTEGERLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:21: ( ( '+' | '-' )? ( ( '0' .. '9' )+ | '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ | '0b' ( '0' .. '1' )+ ) )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:23: ( '+' | '-' )? ( ( '0' .. '9' )+ | '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ | '0b' ( '0' .. '1' )+ )
            {
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:23: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:34: ( ( '0' .. '9' )+ | '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ | '0b' ( '0' .. '1' )+ )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'x':
                    {
                    alt5=2;
                    }
                    break;
                case 'b':
                    {
                    alt5=3;
                    }
                    break;
                default:
                    alt5=1;}

            }
            else if ( ((LA5_0>='1' && LA5_0<='9')) ) {
                alt5=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:35: ( '0' .. '9' )+
                    {
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:35: ( '0' .. '9' )+
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
                    	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:36: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:47: '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
                    {
                    match("0x"); 

                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:52: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='F')||(LA3_0>='a' && LA3_0<='f')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:
                    	    {
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
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:82: '0b' ( '0' .. '1' )+
                    {
                    match("0b"); 

                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:87: ( '0' .. '1' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='1')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7420:88: '0' .. '1'
                    	    {
                    	    matchRange('0','1'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
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
    // $ANTLR end "RULE_INTEGERLITERAL"

    // $ANTLR start "RULE_REALLITERAL"
    public final void mRULE_REALLITERAL() throws RecognitionException {
        try {
            int _type = RULE_REALLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:18: ( ( '+' | '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ ( 'E' ( '+' | '-' )? ( '0' .. '9' )+ )? )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:20: ( '+' | '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ ( 'E' ( '+' | '-' )? ( '0' .. '9' )+ )?
            {
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:20: ( '+' | '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='+'||LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:31: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:32: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            match('.'); 
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:47: ( '0' .. '9' )+
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
            	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:48: '0' .. '9'
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

            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:59: ( 'E' ( '+' | '-' )? ( '0' .. '9' )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='E') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:60: 'E' ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    match('E'); 
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:64: ( '+' | '-' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='+'||LA9_0=='-') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:75: ( '0' .. '9' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7422:76: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
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
    // $ANTLR end "RULE_REALLITERAL"

    // $ANTLR start "RULE_DATETIMELITERAL"
    public final void mRULE_DATETIMELITERAL() throws RecognitionException {
        try {
            int _type = RULE_DATETIMELITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:22: ( ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) ) )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:24: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )
            {
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:24: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case '0':
            case '1':
                {
                int LA25_1 = input.LA(2);

                if ( ((LA25_1>='0' && LA25_1<='9')) ) {
                    int LA25_5 = input.LA(3);

                    if ( ((LA25_5>='0' && LA25_5<='9')) ) {
                        alt25=2;
                    }
                    else if ( (LA25_5==':') ) {
                        alt25=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
                }
                break;
            case '2':
                {
                int LA25_2 = input.LA(2);

                if ( ((LA25_2>='0' && LA25_2<='3')) ) {
                    int LA25_6 = input.LA(3);

                    if ( ((LA25_6>='0' && LA25_6<='9')) ) {
                        alt25=2;
                    }
                    else if ( (LA25_6==':') ) {
                        alt25=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 6, input);

                        throw nvae;
                    }
                }
                else if ( ((LA25_2>='4' && LA25_2<='9')) ) {
                    alt25=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 2, input);

                    throw nvae;
                }
                }
                break;
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt25=2;
                }
                break;
            case 'F':
            case 'M':
            case 'S':
            case 'T':
            case 'W':
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:25: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )?
                    {
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:25: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>='0' && LA12_0<='1')) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0=='2') ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:26: '0' .. '1' '0' .. '9'
                            {
                            matchRange('0','1'); 
                            matchRange('0','9'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:44: '2' '0' .. '3'
                            {
                            match('2'); 
                            matchRange('0','3'); 

                            }
                            break;

                    }

                    match(':'); 
                    matchRange('0','5'); 
                    matchRange('0','9'); 
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:80: ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==':') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:81: ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )?
                            {
                            match(':'); 
                            matchRange('0','5'); 
                            matchRange('0','9'); 
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:103: ( ':' '0' .. '9' '0' .. '9' )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==':') ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:104: ':' '0' .. '9' '0' .. '9'
                                    {
                                    match(':'); 
                                    matchRange('0','9'); 
                                    matchRange('0','9'); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:130: ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==' ') ) {
                        int LA17_1 = input.LA(2);

                        if ( ((LA17_1>='0' && LA17_1<='9')) ) {
                            alt17=1;
                        }
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:131: ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) )
                            {
                            match(' '); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 
                            match('/'); 
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:175: ( '0' '0' .. '9' | '1' '0' .. '2' )
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0=='0') ) {
                                alt15=1;
                            }
                            else if ( (LA15_0=='1') ) {
                                alt15=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 15, 0, input);

                                throw nvae;
                            }
                            switch (alt15) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:176: '0' '0' .. '9'
                                    {
                                    match('0'); 
                                    matchRange('0','9'); 

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:189: '1' '0' .. '2'
                                    {
                                    match('1'); 
                                    matchRange('0','2'); 

                                    }
                                    break;

                            }

                            match('/'); 
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:207: ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) )
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( ((LA16_0>='0' && LA16_0<='2')) ) {
                                alt16=1;
                            }
                            else if ( (LA16_0=='3') ) {
                                alt16=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 16, 0, input);

                                throw nvae;
                            }
                            switch (alt16) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:208: '0' .. '2' '0' .. '9'
                                    {
                                    matchRange('0','2'); 
                                    matchRange('0','9'); 

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:226: '3' ( '0' | '1' )
                                    {
                                    match('3'); 
                                    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:243: ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==' ') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:244: ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                            {
                            match(' '); 
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:248: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                            int alt18=7;
                            alt18 = dfa18.predict(input);
                            switch (alt18) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:249: 'Mon'
                                    {
                                    match("Mon"); 


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:255: 'Tue'
                                    {
                                    match("Tue"); 


                                    }
                                    break;
                                case 3 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:261: 'Wed'
                                    {
                                    match("Wed"); 


                                    }
                                    break;
                                case 4 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:267: 'Thr'
                                    {
                                    match("Thr"); 


                                    }
                                    break;
                                case 5 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:273: 'Fri'
                                    {
                                    match("Fri"); 


                                    }
                                    break;
                                case 6 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:279: 'Sat'
                                    {
                                    match("Sat"); 


                                    }
                                    break;
                                case 7 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:285: 'Sun'
                                    {
                                    match("Sun"); 


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:294: '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )?
                    {
                    matchRange('0','9'); 
                    matchRange('0','9'); 
                    matchRange('0','9'); 
                    matchRange('0','9'); 
                    match('/'); 
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:334: ( '0' '0' .. '9' | '1' '0' .. '2' )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='0') ) {
                        alt20=1;
                    }
                    else if ( (LA20_0=='1') ) {
                        alt20=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:335: '0' '0' .. '9'
                            {
                            match('0'); 
                            matchRange('0','9'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:348: '1' '0' .. '2'
                            {
                            match('1'); 
                            matchRange('0','2'); 

                            }
                            break;

                    }

                    match('/'); 
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:366: ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>='0' && LA21_0<='2')) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0=='3') ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:367: '0' .. '2' '0' .. '9'
                            {
                            matchRange('0','2'); 
                            matchRange('0','9'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:385: '3' ( '0' | '1' )
                            {
                            match('3'); 
                            if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:400: ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==' ') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:401: ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                            {
                            match(' '); 
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:405: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                            int alt22=7;
                            alt22 = dfa22.predict(input);
                            switch (alt22) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:406: 'Mon'
                                    {
                                    match("Mon"); 


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:412: 'Tue'
                                    {
                                    match("Tue"); 


                                    }
                                    break;
                                case 3 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:418: 'Wed'
                                    {
                                    match("Wed"); 


                                    }
                                    break;
                                case 4 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:424: 'Thr'
                                    {
                                    match("Thr"); 


                                    }
                                    break;
                                case 5 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:430: 'Fri'
                                    {
                                    match("Fri"); 


                                    }
                                    break;
                                case 6 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:436: 'Sat'
                                    {
                                    match("Sat"); 


                                    }
                                    break;
                                case 7 :
                                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:442: 'Sun'
                                    {
                                    match("Sun"); 


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:451: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                    {
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:451: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                    int alt24=7;
                    alt24 = dfa24.predict(input);
                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:452: 'Mon'
                            {
                            match("Mon"); 


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:458: 'Tue'
                            {
                            match("Tue"); 


                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:464: 'Wed'
                            {
                            match("Wed"); 


                            }
                            break;
                        case 4 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:470: 'Thr'
                            {
                            match("Thr"); 


                            }
                            break;
                        case 5 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:476: 'Fri'
                            {
                            match("Fri"); 


                            }
                            break;
                        case 6 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:482: 'Sat'
                            {
                            match("Sat"); 


                            }
                            break;
                        case 7 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7424:488: 'Sun'
                            {
                            match("Sun"); 


                            }
                            break;

                    }


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
    // $ANTLR end "RULE_DATETIMELITERAL"

    // $ANTLR start "RULE_BOOLEANLITERAL"
    public final void mRULE_BOOLEANLITERAL() throws RecognitionException {
        try {
            int _type = RULE_BOOLEANLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7426:21: ( ( 'true' | 'false' ) )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7426:23: ( 'true' | 'false' )
            {
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7426:23: ( 'true' | 'false' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='t') ) {
                alt26=1;
            }
            else if ( (LA26_0=='f') ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7426:24: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7426:31: 'false'
                    {
                    match("false"); 


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
    // $ANTLR end "RULE_BOOLEANLITERAL"

    // $ANTLR start "RULE_NULLLITERAL"
    public final void mRULE_NULLLITERAL() throws RecognitionException {
        try {
            int _type = RULE_NULLLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7428:18: ( 'null' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7428:20: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NULLLITERAL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7430:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7430:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7430:11: ( '^' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='^') ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7430:11: '^'
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

            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7430:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>='0' && LA28_0<='9')||(LA28_0>='A' && LA28_0<='Z')||LA28_0=='_'||(LA28_0>='a' && LA28_0<='z')) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:
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
            	    break loop28;
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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7432:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7432:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7432:12: ( '0' .. '9' )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='0' && LA29_0<='9')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7432:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='\"') ) {
                alt32=1;
            }
            else if ( (LA32_0=='\'') ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop30:
                    do {
                        int alt30=3;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0=='\\') ) {
                            alt30=1;
                        }
                        else if ( ((LA30_0>='\u0000' && LA30_0<='!')||(LA30_0>='#' && LA30_0<='[')||(LA30_0>=']' && LA30_0<='\uFFFF')) ) {
                            alt30=2;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop30;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop31:
                    do {
                        int alt31=3;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0=='\\') ) {
                            alt31=1;
                        }
                        else if ( ((LA31_0>='\u0000' && LA31_0<='&')||(LA31_0>='(' && LA31_0<='[')||(LA31_0>=']' && LA31_0<='\uFFFF')) ) {
                            alt31=2;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7434:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop31;
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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7436:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7436:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7436:24: ( options {greedy=false; } : . )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0=='*') ) {
                    int LA33_1 = input.LA(2);

                    if ( (LA33_1=='/') ) {
                        alt33=2;
                    }
                    else if ( ((LA33_1>='\u0000' && LA33_1<='.')||(LA33_1>='0' && LA33_1<='\uFFFF')) ) {
                        alt33=1;
                    }


                }
                else if ( ((LA33_0>='\u0000' && LA33_0<=')')||(LA33_0>='+' && LA33_0<='\uFFFF')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7436:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop33;
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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7438:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7438:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7438:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>='\u0000' && LA34_0<='\t')||(LA34_0>='\u000B' && LA34_0<='\f')||(LA34_0>='\u000E' && LA34_0<='\uFFFF')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7438:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop34;
                }
            } while (true);

            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7438:40: ( ( '\\r' )? '\\n' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0=='\n'||LA36_0=='\r') ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7438:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7438:41: ( '\\r' )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0=='\r') ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7438:41: '\\r'
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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7440:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7440:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7440:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>='\t' && LA37_0<='\n')||LA37_0=='\r'||LA37_0==' ') ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:
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
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
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
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7442:16: ( . )
            // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:7442:18: .
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
        // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | RULE_INTEGERLITERAL | RULE_REALLITERAL | RULE_DATETIMELITERAL | RULE_BOOLEANLITERAL | RULE_NULLLITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt38=50;
        alt38 = dfa38.predict(input);
        switch (alt38) {
            case 1 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:40: T__21
                {
                mT__21(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:46: T__22
                {
                mT__22(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:52: T__23
                {
                mT__23(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:58: T__24
                {
                mT__24(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:64: T__25
                {
                mT__25(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:70: T__26
                {
                mT__26(); 

                }
                break;
            case 12 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:76: T__27
                {
                mT__27(); 

                }
                break;
            case 13 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:82: T__28
                {
                mT__28(); 

                }
                break;
            case 14 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:88: T__29
                {
                mT__29(); 

                }
                break;
            case 15 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:94: T__30
                {
                mT__30(); 

                }
                break;
            case 16 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:100: T__31
                {
                mT__31(); 

                }
                break;
            case 17 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:106: T__32
                {
                mT__32(); 

                }
                break;
            case 18 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:112: T__33
                {
                mT__33(); 

                }
                break;
            case 19 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:118: T__34
                {
                mT__34(); 

                }
                break;
            case 20 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:124: T__35
                {
                mT__35(); 

                }
                break;
            case 21 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:130: T__36
                {
                mT__36(); 

                }
                break;
            case 22 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:136: T__37
                {
                mT__37(); 

                }
                break;
            case 23 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:142: T__38
                {
                mT__38(); 

                }
                break;
            case 24 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:148: T__39
                {
                mT__39(); 

                }
                break;
            case 25 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:154: T__40
                {
                mT__40(); 

                }
                break;
            case 26 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:160: T__41
                {
                mT__41(); 

                }
                break;
            case 27 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:166: T__42
                {
                mT__42(); 

                }
                break;
            case 28 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:172: T__43
                {
                mT__43(); 

                }
                break;
            case 29 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:178: T__44
                {
                mT__44(); 

                }
                break;
            case 30 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:184: T__45
                {
                mT__45(); 

                }
                break;
            case 31 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:190: T__46
                {
                mT__46(); 

                }
                break;
            case 32 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:196: T__47
                {
                mT__47(); 

                }
                break;
            case 33 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:202: T__48
                {
                mT__48(); 

                }
                break;
            case 34 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:208: T__49
                {
                mT__49(); 

                }
                break;
            case 35 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:214: T__50
                {
                mT__50(); 

                }
                break;
            case 36 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:220: T__51
                {
                mT__51(); 

                }
                break;
            case 37 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:226: T__52
                {
                mT__52(); 

                }
                break;
            case 38 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:232: T__53
                {
                mT__53(); 

                }
                break;
            case 39 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:238: RULE_INTEGERLITERAL
                {
                mRULE_INTEGERLITERAL(); 

                }
                break;
            case 40 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:258: RULE_REALLITERAL
                {
                mRULE_REALLITERAL(); 

                }
                break;
            case 41 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:275: RULE_DATETIMELITERAL
                {
                mRULE_DATETIMELITERAL(); 

                }
                break;
            case 42 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:296: RULE_BOOLEANLITERAL
                {
                mRULE_BOOLEANLITERAL(); 

                }
                break;
            case 43 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:316: RULE_NULLLITERAL
                {
                mRULE_NULLLITERAL(); 

                }
                break;
            case 44 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:333: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 45 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:341: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 46 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:350: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 47 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:362: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 48 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:378: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 49 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:394: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 50 :
                // ../org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui/src-gen/org/eclipse/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/ui/contentassist/antlr/internal/InternalStereotypeApplicationWithVSL.g:1:402: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA18_eotS =
        "\12\uffff";
    static final String DFA18_eofS =
        "\12\uffff";
    static final String DFA18_minS =
        "\1\106\1\uffff\1\150\2\uffff\1\141\4\uffff";
    static final String DFA18_maxS =
        "\1\127\1\uffff\1\165\2\uffff\1\165\4\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\5\1\uffff\1\2\1\4\1\6\1\7";
    static final String DFA18_specialS =
        "\12\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\4\6\uffff\1\1\5\uffff\1\5\1\2\2\uffff\1\3",
            "",
            "\1\7\14\uffff\1\6",
            "",
            "",
            "\1\10\23\uffff\1\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "7424:248: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )";
        }
    }
    static final String DFA22_eotS =
        "\12\uffff";
    static final String DFA22_eofS =
        "\12\uffff";
    static final String DFA22_minS =
        "\1\106\1\uffff\1\150\2\uffff\1\141\4\uffff";
    static final String DFA22_maxS =
        "\1\127\1\uffff\1\165\2\uffff\1\165\4\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\5\1\uffff\1\2\1\4\1\6\1\7";
    static final String DFA22_specialS =
        "\12\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\4\6\uffff\1\1\5\uffff\1\5\1\2\2\uffff\1\3",
            "",
            "\1\7\14\uffff\1\6",
            "",
            "",
            "\1\10\23\uffff\1\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "7424:405: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )";
        }
    }
    static final String DFA24_eotS =
        "\12\uffff";
    static final String DFA24_eofS =
        "\12\uffff";
    static final String DFA24_minS =
        "\1\106\1\uffff\1\150\2\uffff\1\141\4\uffff";
    static final String DFA24_maxS =
        "\1\127\1\uffff\1\165\2\uffff\1\165\4\uffff";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\5\1\uffff\1\2\1\4\1\6\1\7";
    static final String DFA24_specialS =
        "\12\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\4\6\uffff\1\1\5\uffff\1\5\1\2\2\uffff\1\3",
            "",
            "\1\7\14\uffff\1\6",
            "",
            "",
            "\1\10\23\uffff\1\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "7424:451: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )";
        }
    }
    static final String DFA38_eotS =
        "\1\uffff\3\57\1\64\1\70\1\73\1\74\1\77\1\uffff\1\103\2\57\2\uffff"+
        "\1\57\1\uffff\1\114\1\116\5\uffff\1\57\1\uffff\1\57\2\uffff\4\131"+
        "\7\57\1\55\1\uffff\2\55\2\uffff\1\57\1\uffff\1\152\2\57\12\uffff"+
        "\2\131\5\uffff\3\57\2\uffff\1\161\12\uffff\1\57\1\uffff\1\57\3\uffff"+
        "\1\131\1\uffff\2\131\11\57\2\uffff\1\177\1\uffff\1\u0080\1\u0081"+
        "\1\u0082\1\u0083\2\57\1\uffff\2\57\1\131\1\uffff\7\165\2\57\5\uffff"+
        "\1\u008b\1\57\1\u008d\1\57\1\131\1\u0090\1\57\1\uffff\1\u0092\1"+
        "\uffff\1\57\1\131\1\uffff\1\u0090\1\uffff\1\57\1\uffff";
    static final String DFA38_eofS =
        "\u0095\uffff";
    static final String DFA38_minS =
        "\1\0\1\156\1\162\1\157\1\75\1\74\1\75\2\60\1\uffff\1\52\2\157\2"+
        "\uffff\1\156\1\uffff\1\72\1\56\5\uffff\1\150\1\uffff\1\151\2\uffff"+
        "\4\56\1\157\1\150\1\145\1\162\1\141\1\162\1\141\1\101\1\uffff\2"+
        "\0\2\uffff\1\144\1\uffff\1\60\1\164\1\162\12\uffff\2\56\5\uffff"+
        "\1\144\1\164\1\154\2\uffff\1\60\12\uffff\1\145\1\uffff\1\164\3\uffff"+
        "\1\56\1\uffff\2\56\1\156\1\145\1\162\1\144\1\151\1\164\1\156\1\165"+
        "\1\154\2\uffff\1\60\1\uffff\4\60\1\154\1\165\1\uffff\1\156\1\164"+
        "\1\56\1\uffff\7\60\1\145\1\163\5\uffff\1\60\1\164\1\60\1\145\1\56"+
        "\1\60\1\145\1\uffff\1\60\1\uffff\1\162\1\56\1\uffff\1\60\1\uffff"+
        "\1\50\1\uffff";
    static final String DFA38_maxS =
        "\1\uffff\1\156\1\165\1\157\1\75\2\76\2\71\1\uffff\1\57\1\157\1"+
        "\165\2\uffff\1\156\1\uffff\1\72\1\56\5\uffff\1\150\1\uffff\1\151"+
        "\2\uffff\4\71\1\157\1\165\1\145\1\162\1\165\1\162\1\141\1\172\1"+
        "\uffff\2\uffff\2\uffff\1\144\1\uffff\1\172\1\164\1\162\12\uffff"+
        "\2\71\5\uffff\1\144\1\164\1\154\2\uffff\1\172\12\uffff\1\145\1\uffff"+
        "\1\164\3\uffff\1\72\1\uffff\1\72\1\71\1\156\1\145\1\162\1\144\1"+
        "\151\1\164\1\156\1\165\1\154\2\uffff\1\172\1\uffff\4\172\1\154\1"+
        "\165\1\uffff\1\156\1\164\1\71\1\uffff\7\172\1\145\1\163\5\uffff"+
        "\1\172\1\164\1\172\1\145\1\71\1\172\1\145\1\uffff\1\172\1\uffff"+
        "\1\162\1\71\1\uffff\1\172\1\uffff\1\50\1\uffff";
    static final String DFA38_acceptS =
        "\11\uffff\1\14\3\uffff\1\20\1\21\1\uffff\1\27\2\uffff\1\33\1\34"+
        "\1\37\1\40\1\41\1\uffff\1\43\1\uffff\1\45\1\46\14\uffff\1\54\2\uffff"+
        "\1\61\1\62\1\uffff\1\54\3\uffff\1\4\1\30\1\5\1\10\1\25\1\6\1\11"+
        "\1\26\1\7\1\12\2\uffff\1\13\1\14\1\57\1\60\1\15\3\uffff\1\20\1\21"+
        "\1\uffff\1\27\1\35\1\31\1\36\1\32\1\33\1\34\1\37\1\40\1\41\1\uffff"+
        "\1\43\1\uffff\1\45\1\46\1\47\1\uffff\1\50\13\uffff\1\56\1\61\1\uffff"+
        "\1\2\6\uffff\1\22\3\uffff\1\51\11\uffff\1\1\1\23\1\3\1\16\1\17\7"+
        "\uffff\1\53\1\uffff\1\42\2\uffff\1\52\1\uffff\1\24\1\uffff\1\44";
    static final String DFA38_specialS =
        "\1\1\51\uffff\1\0\1\2\151\uffff}>";
    static final String[] DFA38_transitionS = {
            "\11\55\2\54\2\55\1\54\22\55\1\54\1\55\1\52\1\55\1\33\1\55\1"+
            "\31\1\53\1\23\1\24\1\11\1\7\1\20\1\10\1\22\1\12\1\35\1\36\1"+
            "\37\7\40\1\21\1\55\1\5\1\4\1\6\1\34\1\27\5\51\1\44\6\51\1\41"+
            "\5\51\1\45\1\42\2\51\1\43\3\51\1\16\1\55\1\15\1\50\1\51\1\55"+
            "\1\1\4\51\1\47\2\51\1\17\1\32\2\51\1\13\1\14\1\2\4\51\1\46\2"+
            "\51\1\30\1\3\2\51\1\25\1\55\1\26\uff82\55",
            "\1\56",
            "\1\60\2\uffff\1\61",
            "\1\62",
            "\1\63",
            "\1\67\1\66\1\65",
            "\1\71\1\72",
            "\1\75\11\76",
            "\1\75\11\76",
            "",
            "\1\101\4\uffff\1\102",
            "\1\104",
            "\1\105\5\uffff\1\106",
            "",
            "",
            "\1\111",
            "",
            "\1\113",
            "\1\115",
            "",
            "",
            "",
            "",
            "",
            "\1\124",
            "",
            "\1\126",
            "",
            "",
            "\1\133\1\uffff\12\132",
            "\1\133\1\uffff\12\132",
            "\1\133\1\uffff\4\134\6\135",
            "\1\133\1\uffff\12\135",
            "\1\136",
            "\1\140\14\uffff\1\137",
            "\1\141",
            "\1\142",
            "\1\143\23\uffff\1\144",
            "\1\145",
            "\1\146",
            "\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\0\147",
            "\0\147",
            "",
            "",
            "\1\151",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\153",
            "\1\154",
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
            "\1\133\1\uffff\12\76",
            "\1\133\1\uffff\12\76",
            "",
            "",
            "",
            "",
            "",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\16\57\1\160\13\57",
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
            "\1\162",
            "",
            "\1\163",
            "",
            "",
            "",
            "\1\133\1\uffff\12\164\1\165",
            "",
            "\1\133\1\uffff\12\164\1\165",
            "\1\133\1\uffff\12\164",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\133\1\uffff\12\u0088",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0089",
            "\1\u008a",
            "",
            "",
            "",
            "",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u008c",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u008e",
            "\1\133\1\165\12\u008f",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0091",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u0093",
            "\1\133\1\uffff\12\u008f",
            "",
            "\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\u0094",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | RULE_INTEGERLITERAL | RULE_REALLITERAL | RULE_DATETIMELITERAL | RULE_BOOLEANLITERAL | RULE_NULLLITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_42 = input.LA(1);

                        s = -1;
                        if ( ((LA38_42>='\u0000' && LA38_42<='\uFFFF')) ) {s = 103;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_0 = input.LA(1);

                        s = -1;
                        if ( (LA38_0=='a') ) {s = 1;}

                        else if ( (LA38_0=='o') ) {s = 2;}

                        else if ( (LA38_0=='x') ) {s = 3;}

                        else if ( (LA38_0=='=') ) {s = 4;}

                        else if ( (LA38_0=='<') ) {s = 5;}

                        else if ( (LA38_0=='>') ) {s = 6;}

                        else if ( (LA38_0=='+') ) {s = 7;}

                        else if ( (LA38_0=='-') ) {s = 8;}

                        else if ( (LA38_0=='*') ) {s = 9;}

                        else if ( (LA38_0=='/') ) {s = 10;}

                        else if ( (LA38_0=='m') ) {s = 11;}

                        else if ( (LA38_0=='n') ) {s = 12;}

                        else if ( (LA38_0==']') ) {s = 13;}

                        else if ( (LA38_0=='[') ) {s = 14;}

                        else if ( (LA38_0=='i') ) {s = 15;}

                        else if ( (LA38_0==',') ) {s = 16;}

                        else if ( (LA38_0==':') ) {s = 17;}

                        else if ( (LA38_0=='.') ) {s = 18;}

                        else if ( (LA38_0=='(') ) {s = 19;}

                        else if ( (LA38_0==')') ) {s = 20;}

                        else if ( (LA38_0=='{') ) {s = 21;}

                        else if ( (LA38_0=='}') ) {s = 22;}

                        else if ( (LA38_0=='@') ) {s = 23;}

                        else if ( (LA38_0=='w') ) {s = 24;}

                        else if ( (LA38_0=='&') ) {s = 25;}

                        else if ( (LA38_0=='j') ) {s = 26;}

                        else if ( (LA38_0=='$') ) {s = 27;}

                        else if ( (LA38_0=='?') ) {s = 28;}

                        else if ( (LA38_0=='0') ) {s = 29;}

                        else if ( (LA38_0=='1') ) {s = 30;}

                        else if ( (LA38_0=='2') ) {s = 31;}

                        else if ( ((LA38_0>='3' && LA38_0<='9')) ) {s = 32;}

                        else if ( (LA38_0=='M') ) {s = 33;}

                        else if ( (LA38_0=='T') ) {s = 34;}

                        else if ( (LA38_0=='W') ) {s = 35;}

                        else if ( (LA38_0=='F') ) {s = 36;}

                        else if ( (LA38_0=='S') ) {s = 37;}

                        else if ( (LA38_0=='t') ) {s = 38;}

                        else if ( (LA38_0=='f') ) {s = 39;}

                        else if ( (LA38_0=='^') ) {s = 40;}

                        else if ( ((LA38_0>='A' && LA38_0<='E')||(LA38_0>='G' && LA38_0<='L')||(LA38_0>='N' && LA38_0<='R')||(LA38_0>='U' && LA38_0<='V')||(LA38_0>='X' && LA38_0<='Z')||LA38_0=='_'||(LA38_0>='b' && LA38_0<='e')||(LA38_0>='g' && LA38_0<='h')||(LA38_0>='k' && LA38_0<='l')||(LA38_0>='p' && LA38_0<='s')||(LA38_0>='u' && LA38_0<='v')||(LA38_0>='y' && LA38_0<='z')) ) {s = 41;}

                        else if ( (LA38_0=='\"') ) {s = 42;}

                        else if ( (LA38_0=='\'') ) {s = 43;}

                        else if ( ((LA38_0>='\t' && LA38_0<='\n')||LA38_0=='\r'||LA38_0==' ') ) {s = 44;}

                        else if ( ((LA38_0>='\u0000' && LA38_0<='\b')||(LA38_0>='\u000B' && LA38_0<='\f')||(LA38_0>='\u000E' && LA38_0<='\u001F')||LA38_0=='!'||LA38_0=='#'||LA38_0=='%'||LA38_0==';'||LA38_0=='\\'||LA38_0=='`'||LA38_0=='|'||(LA38_0>='~' && LA38_0<='\uFFFF')) ) {s = 45;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA38_43 = input.LA(1);

                        s = -1;
                        if ( ((LA38_43>='\u0000' && LA38_43<='\uFFFF')) ) {s = 103;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}