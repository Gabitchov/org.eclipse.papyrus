package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUMLConnectionPointReferenceLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=9;
    public static final int RULE_INTEGER_VALUE=5;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators

    public InternalUMLConnectionPointReferenceLexer() {;} 
    public InternalUMLConnectionPointReferenceLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUMLConnectionPointReferenceLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:11:7: ( 'entry' )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:11:9: 'entry'
            {
            match("entry"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:12:7: ( ',' )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:12:9: ','
            {
            match(','); 

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
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:13:7: ( 'exit' )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:13:9: 'exit'
            {
            match("exit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "RULE_INTEGER_VALUE"
    public final void mRULE_INTEGER_VALUE() throws RecognitionException {
        try {
            int _type = RULE_INTEGER_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:20: ( ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            int alt13=4;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'B':
                case 'b':
                    {
                    alt13=2;
                    }
                    break;
                case 'X':
                case 'x':
                    {
                    alt13=3;
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
                    alt13=4;
                    }
                    break;
                default:
                    alt13=1;}

            }
            else if ( ((LA13_0>='1' && LA13_0<='9')) ) {
                alt13=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='0') ) {
                        alt3=1;
                    }
                    else if ( ((LA3_0>='1' && LA3_0<='9')) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:24: '0'
                            {
                            match('0'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:28: '1' .. '9' ( ( '_' )? '0' .. '9' )*
                            {
                            matchRange('1','9'); 
                            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:37: ( ( '_' )? '0' .. '9' )*
                            loop2:
                            do {
                                int alt2=2;
                                int LA2_0 = input.LA(1);

                                if ( ((LA2_0>='0' && LA2_0<='9')||LA2_0=='_') ) {
                                    alt2=1;
                                }


                                switch (alt2) {
                            	case 1 :
                            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:38: ( '_' )? '0' .. '9'
                            	    {
                            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:38: ( '_' )?
                            	    int alt1=2;
                            	    int LA1_0 = input.LA(1);

                            	    if ( (LA1_0=='_') ) {
                            	        alt1=1;
                            	    }
                            	    switch (alt1) {
                            	        case 1 :
                            	            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:38: '_'
                            	            {
                            	            match('_'); 

                            	            }
                            	            break;

                            	    }

                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop2;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:55: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:55: ( '0b' | '0B' )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='0') ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1=='b') ) {
                            alt4=1;
                        }
                        else if ( (LA4_1=='B') ) {
                            alt4=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:56: '0b'
                            {
                            match("0b"); 


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:61: '0B'
                            {
                            match("0B"); 


                            }
                            break;

                    }

                    matchRange('0','1'); 
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:76: ( ( '_' )? '0' .. '1' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='1')||LA6_0=='_') ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:77: ( '_' )? '0' .. '1'
                    	    {
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:77: ( '_' )?
                    	    int alt5=2;
                    	    int LA5_0 = input.LA(1);

                    	    if ( (LA5_0=='_') ) {
                    	        alt5=1;
                    	    }
                    	    switch (alt5) {
                    	        case 1 :
                    	            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:77: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','1'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:93: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:93: ( '0x' | '0X' )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='0') ) {
                        int LA7_1 = input.LA(2);

                        if ( (LA7_1=='x') ) {
                            alt7=1;
                        }
                        else if ( (LA7_1=='X') ) {
                            alt7=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:94: '0x'
                            {
                            match("0x"); 


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:99: '0X'
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

                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:134: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='F')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='f')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:135: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
                    	    {
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:135: ( '_' )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0=='_') ) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:135: '_'
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
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:171: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
                    {
                    match('0'); 
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:175: ( '_' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='_') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:175: '_'
                            {
                            match('_'); 

                            }
                            break;

                    }

                    matchRange('0','7'); 
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:189: ( ( '_' )? '0' .. '7' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='7')||LA12_0=='_') ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:190: ( '_' )? '0' .. '7'
                    	    {
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:190: ( '_' )?
                    	    int alt11=2;
                    	    int LA11_0 = input.LA(1);

                    	    if ( (LA11_0=='_') ) {
                    	        alt11=1;
                    	    }
                    	    switch (alt11) {
                    	        case 1 :
                    	            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:504:190: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','7'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
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
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:506:9: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' ) )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:506:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:506:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>='A' && LA16_0<='Z')||LA16_0=='_'||(LA16_0>='a' && LA16_0<='z')) ) {
                alt16=1;
            }
            else if ( (LA16_0=='\'') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:506:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:506:36: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:
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
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:506:70: '\\'' ( options {greedy=false; } : . )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:506:75: ( options {greedy=false; } : . )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0=='\'') ) {
                            alt15=2;
                        }
                        else if ( ((LA15_0>='\u0000' && LA15_0<='&')||(LA15_0>='(' && LA15_0<='\uFFFF')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:506:103: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
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
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:508:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:508:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:508:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\\') ) {
                    alt17=1;
                }
                else if ( ((LA17_0>='\u0000' && LA17_0<='!')||(LA17_0>='#' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:508:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:508:61: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop17;
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
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:510:17: ( '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:510:19: '/*' ~ ( '@' ) ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            if ( (input.LA(1)>='\u0000' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:510:31: ( options {greedy=false; } : . )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='*') ) {
                    int LA18_1 = input.LA(2);

                    if ( (LA18_1=='/') ) {
                        alt18=2;
                    }
                    else if ( ((LA18_1>='\u0000' && LA18_1<='.')||(LA18_1>='0' && LA18_1<='\uFFFF')) ) {
                        alt18=1;
                    }


                }
                else if ( ((LA18_0>='\u0000' && LA18_0<=')')||(LA18_0>='+' && LA18_0<='\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:510:59: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:512:17: ( '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:512:19: '//' (~ ( ( '\\n' | '\\r' | '@' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:512:24: (~ ( ( '\\n' | '\\r' | '@' ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='\u0000' && LA19_0<='\t')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='?')||(LA19_0>='A' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:512:24: ~ ( ( '\\n' | '\\r' | '@' ) )
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
            	    break loop19;
                }
            } while (true);

            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:512:44: ( ( '\\r' )? '\\n' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\n'||LA21_0=='\r') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:512:45: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:512:45: ( '\\r' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='\r') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:512:45: '\\r'
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
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:514:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:514:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:514:12: ( '0' .. '9' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='0' && LA22_0<='9')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:514:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:516:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:516:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:516:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='\t' && LA23_0<='\n')||LA23_0=='\r'||LA23_0==' ') ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:
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
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:518:16: ( . )
            // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:518:18: .
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
        // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:8: ( T__12 | T__13 | T__14 | RULE_INTEGER_VALUE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_WS | RULE_ANY_OTHER )
        int alt24=11;
        alt24 = dfa24.predict(input);
        switch (alt24) {
            case 1 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:28: RULE_INTEGER_VALUE
                {
                mRULE_INTEGER_VALUE(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:47: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:55: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:67: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:83: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:99: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:108: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.ui/src-gen/org/eclipse/papyrus/uml/textedit/connectionpointreference/xtext/ui/contentassist/antlr/internal/InternalUMLConnectionPointReference.g:1:116: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA24_eotS =
        "\1\uffff\1\15\1\uffff\2\17\1\uffff\3\12\2\uffff\2\15\3\uffff\1"+
        "\17\1\uffff\1\17\4\uffff\2\15\1\17\1\15\1\35\1\36\2\uffff";
    static final String DFA24_eofS =
        "\37\uffff";
    static final String DFA24_minS =
        "\1\0\1\156\1\uffff\2\60\1\uffff\2\0\1\52\2\uffff\1\164\1\151\3"+
        "\uffff\1\60\1\uffff\1\60\4\uffff\1\162\1\164\1\60\1\171\2\60\2\uffff";
    static final String DFA24_maxS =
        "\1\uffff\1\170\1\uffff\2\71\1\uffff\2\uffff\1\57\2\uffff\1\164"+
        "\1\151\3\uffff\1\71\1\uffff\1\71\4\uffff\1\162\1\164\1\71\1\171"+
        "\2\172\2\uffff";
    static final String DFA24_acceptS =
        "\2\uffff\1\2\2\uffff\1\5\3\uffff\1\12\1\13\2\uffff\1\5\1\2\1\4"+
        "\1\uffff\1\11\1\uffff\1\6\1\7\1\10\1\12\6\uffff\1\3\1\1";
    static final String DFA24_specialS =
        "\1\0\5\uffff\1\1\1\2\27\uffff}>";
    static final String[] DFA24_transitionS = {
            "\11\12\2\11\2\12\1\11\22\12\1\11\1\12\1\7\4\12\1\6\4\12\1\2"+
            "\2\12\1\10\1\3\11\4\7\12\32\5\4\12\1\5\1\12\4\5\1\1\25\5\uff85"+
            "\12",
            "\1\13\11\uffff\1\14",
            "",
            "\10\20\2\21",
            "\12\22",
            "",
            "\0\15",
            "\0\23",
            "\1\24\4\uffff\1\25",
            "",
            "",
            "\1\27",
            "\1\30",
            "",
            "",
            "",
            "\10\31\2\21",
            "",
            "\12\22",
            "",
            "",
            "",
            "",
            "\1\32",
            "\1\33",
            "\10\31\2\21",
            "\1\34",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
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
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | RULE_INTEGER_VALUE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_0 = input.LA(1);

                        s = -1;
                        if ( (LA24_0=='e') ) {s = 1;}

                        else if ( (LA24_0==',') ) {s = 2;}

                        else if ( (LA24_0=='0') ) {s = 3;}

                        else if ( ((LA24_0>='1' && LA24_0<='9')) ) {s = 4;}

                        else if ( ((LA24_0>='A' && LA24_0<='Z')||LA24_0=='_'||(LA24_0>='a' && LA24_0<='d')||(LA24_0>='f' && LA24_0<='z')) ) {s = 5;}

                        else if ( (LA24_0=='\'') ) {s = 6;}

                        else if ( (LA24_0=='\"') ) {s = 7;}

                        else if ( (LA24_0=='/') ) {s = 8;}

                        else if ( ((LA24_0>='\t' && LA24_0<='\n')||LA24_0=='\r'||LA24_0==' ') ) {s = 9;}

                        else if ( ((LA24_0>='\u0000' && LA24_0<='\b')||(LA24_0>='\u000B' && LA24_0<='\f')||(LA24_0>='\u000E' && LA24_0<='\u001F')||LA24_0=='!'||(LA24_0>='#' && LA24_0<='&')||(LA24_0>='(' && LA24_0<='+')||(LA24_0>='-' && LA24_0<='.')||(LA24_0>=':' && LA24_0<='@')||(LA24_0>='[' && LA24_0<='^')||LA24_0=='`'||(LA24_0>='{' && LA24_0<='\uFFFF')) ) {s = 10;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_6 = input.LA(1);

                        s = -1;
                        if ( ((LA24_6>='\u0000' && LA24_6<='\uFFFF')) ) {s = 13;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_7 = input.LA(1);

                        s = -1;
                        if ( ((LA24_7>='\u0000' && LA24_7<='\uFFFF')) ) {s = 19;}

                        else s = 10;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}