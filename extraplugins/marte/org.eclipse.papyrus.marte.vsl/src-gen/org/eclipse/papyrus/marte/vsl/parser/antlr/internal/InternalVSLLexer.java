package org.eclipse.papyrus.marte.vsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVSLLexer extends Lexer {
    public static final int RULE_DATETIMELITERAL=8;
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_REALLITERAL=7;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int EOF=-1;
    public static final int T24=24;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_BOOLEANLITERAL=9;
    public static final int RULE_INT=11;
    public static final int T38=38;
    public static final int T37=37;
    public static final int T39=39;
    public static final int T34=34;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int T30=30;
    public static final int T32=32;
    public static final int T31=31;
    public static final int RULE_NULLLITERAL=10;
    public static final int RULE_INTEGERLITERAL=6;
    public static final int T49=49;
    public static final int T48=48;
    public static final int T43=43;
    public static final int Tokens=55;
    public static final int RULE_SL_COMMENT=13;
    public static final int T42=42;
    public static final int T41=41;
    public static final int T40=40;
    public static final int T47=47;
    public static final int T46=46;
    public static final int T45=45;
    public static final int RULE_ML_COMMENT=12;
    public static final int T44=44;
    public static final int RULE_STRING=4;
    public static final int T50=50;
    public static final int T52=52;
    public static final int RULE_WS=14;
    public static final int T51=51;
    public static final int T16=16;
    public static final int T54=54;
    public static final int T17=17;
    public static final int T53=53;
    public static final int T18=18;
    public static final int T19=19;
    public InternalVSLLexer() {;} 
    public InternalVSLLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g"; }

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:10:5: ( 'value' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:10:7: 'value'
            {
            match("value"); 


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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:11:5: ( 'import' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:11:7: 'import'
            {
            match("import"); 


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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:12:5: ( 'context' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:12:7: 'context'
            {
            match("context"); 


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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:13:5: ( 'and' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:13:7: 'and'
            {
            match("and"); 


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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:14:5: ( 'or' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:14:7: 'or'
            {
            match("or"); 


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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:15:5: ( 'xor' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:15:7: 'xor'
            {
            match("xor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:16:5: ( '==' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:16:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:17:5: ( '<>' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:17:7: '<>'
            {
            match("<>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:18:5: ( '<' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:18:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:19:5: ( '>' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:19:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:20:5: ( '<=' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:20:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:21:5: ( '>=' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:21:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:22:5: ( '?' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:22:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:23:5: ( ':' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:23:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:24:5: ( '+' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:24:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:25:5: ( '-' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:25:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:26:5: ( '*' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:26:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:27:5: ( '/' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:27:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:28:5: ( 'mod' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:28:7: 'mod'
            {
            match("mod"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:29:5: ( 'not' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:29:7: 'not'
            {
            match("not"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:30:5: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:30:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:31:5: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:31:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:32:5: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:32:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:33:5: ( '::' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:33:7: '::'
            {
            match("::"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:34:5: ( ']' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:34:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:35:5: ( '[' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:35:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:36:5: ( '..' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:36:7: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:37:5: ( '{' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:37:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:38:5: ( '}' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:38:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:39:5: ( ',' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:39:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:40:5: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:40:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:41:5: ( '@' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:41:7: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:42:5: ( 'when' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:42:7: 'when'
            {
            match("when"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:43:5: ( '&' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:43:7: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:44:5: ( 'jitter(' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:44:7: 'jitter('
            {
            match("jitter("); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:45:5: ( '$' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:45:7: '$'
            {
            match('$'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start T52
    public final void mT52() throws RecognitionException {
        try {
            int _type = T52;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:46:5: ( 'in' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:46:7: 'in'
            {
            match("in"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T52

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:47:5: ( 'out' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:47:7: 'out'
            {
            match("out"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:48:5: ( 'inout' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:48:7: 'inout'
            {
            match("inout"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start RULE_INTEGERLITERAL
    public final void mRULE_INTEGERLITERAL() throws RecognitionException {
        try {
            int _type = RULE_INTEGERLITERAL;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:21: ( ( '+' | '-' )? ( ( '0' .. '9' )+ | '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ | '0b' ( '0' .. '1' )+ ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:23: ( '+' | '-' )? ( ( '0' .. '9' )+ | '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ | '0b' ( '0' .. '1' )+ )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:23: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:34: ( ( '0' .. '9' )+ | '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ | '0b' ( '0' .. '1' )+ )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'b':
                    {
                    alt5=3;
                    }
                    break;
                case 'x':
                    {
                    alt5=2;
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
                    new NoViableAltException("3481:34: ( ( '0' .. '9' )+ | '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+ | '0b' ( '0' .. '1' )+ )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:35: ( '0' .. '9' )+
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:35: ( '0' .. '9' )+
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
                    	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:36: '0' .. '9'
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
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:47: '0x' ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
                    {
                    match("0x"); 

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:52: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )+
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
                    	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:82: '0b' ( '0' .. '1' )+
                    {
                    match("0b"); 

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:87: ( '0' .. '1' )+
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
                    	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3481:88: '0' .. '1'
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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INTEGERLITERAL

    // $ANTLR start RULE_REALLITERAL
    public final void mRULE_REALLITERAL() throws RecognitionException {
        try {
            int _type = RULE_REALLITERAL;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:18: ( ( '+' | '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ ( 'E' ( '+' | '-' )? ( '0' .. '9' )+ )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:20: ( '+' | '-' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ ( 'E' ( '+' | '-' )? ( '0' .. '9' )+ )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:20: ( '+' | '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='+'||LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:31: ( '0' .. '9' )+
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
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:32: '0' .. '9'
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:47: ( '0' .. '9' )+
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
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:48: '0' .. '9'
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:59: ( 'E' ( '+' | '-' )? ( '0' .. '9' )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='E') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:60: 'E' ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    match('E'); 
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:64: ( '+' | '-' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='+'||LA9_0=='-') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:75: ( '0' .. '9' )+
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
                    	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3483:76: '0' .. '9'
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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_REALLITERAL

    // $ANTLR start RULE_DATETIMELITERAL
    public final void mRULE_DATETIMELITERAL() throws RecognitionException {
        try {
            int _type = RULE_DATETIMELITERAL;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:22: ( ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:24: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:24: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )
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
                            new NoViableAltException("3485:24: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )", 25, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("3485:24: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )", 25, 1, input);

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
                            new NoViableAltException("3485:24: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )", 25, 6, input);

                        throw nvae;
                    }
                }
                else if ( ((LA25_2>='4' && LA25_2<='9')) ) {
                    alt25=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("3485:24: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )", 25, 2, input);

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
                    new NoViableAltException("3485:24: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )? | ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:25: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )? ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )? ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )?
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:25: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
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
                            new NoViableAltException("3485:25: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:26: '0' .. '1' '0' .. '9'
                            {
                            matchRange('0','1'); 
                            matchRange('0','9'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:44: '2' '0' .. '3'
                            {
                            match('2'); 
                            matchRange('0','3'); 

                            }
                            break;

                    }

                    match(':'); 
                    matchRange('0','5'); 
                    matchRange('0','9'); 
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:80: ( ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )? )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==':') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:81: ':' '0' .. '5' '0' .. '9' ( ':' '0' .. '9' '0' .. '9' )?
                            {
                            match(':'); 
                            matchRange('0','5'); 
                            matchRange('0','9'); 
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:103: ( ':' '0' .. '9' '0' .. '9' )?
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==':') ) {
                                alt13=1;
                            }
                            switch (alt13) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:104: ':' '0' .. '9' '0' .. '9'
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

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:130: ( ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) )?
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
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:131: ' ' '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) )
                            {
                            match(' '); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 
                            matchRange('0','9'); 
                            match('/'); 
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:175: ( '0' '0' .. '9' | '1' '0' .. '2' )
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
                                    new NoViableAltException("3485:175: ( '0' '0' .. '9' | '1' '0' .. '2' )", 15, 0, input);

                                throw nvae;
                            }
                            switch (alt15) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:176: '0' '0' .. '9'
                                    {
                                    match('0'); 
                                    matchRange('0','9'); 

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:189: '1' '0' .. '2'
                                    {
                                    match('1'); 
                                    matchRange('0','2'); 

                                    }
                                    break;

                            }

                            match('/'); 
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:207: ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) )
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
                                    new NoViableAltException("3485:207: ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) )", 16, 0, input);

                                throw nvae;
                            }
                            switch (alt16) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:208: '0' .. '2' '0' .. '9'
                                    {
                                    matchRange('0','2'); 
                                    matchRange('0','9'); 

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:226: '3' ( '0' | '1' )
                                    {
                                    match('3'); 
                                    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse =
                                            new MismatchedSetException(null,input);
                                        recover(mse);    throw mse;
                                    }


                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:243: ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==' ') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:244: ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                            {
                            match(' '); 
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:248: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                            int alt18=7;
                            switch ( input.LA(1) ) {
                            case 'M':
                                {
                                alt18=1;
                                }
                                break;
                            case 'T':
                                {
                                int LA18_2 = input.LA(2);

                                if ( (LA18_2=='u') ) {
                                    alt18=2;
                                }
                                else if ( (LA18_2=='h') ) {
                                    alt18=4;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("3485:248: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )", 18, 2, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case 'W':
                                {
                                alt18=3;
                                }
                                break;
                            case 'F':
                                {
                                alt18=5;
                                }
                                break;
                            case 'S':
                                {
                                int LA18_5 = input.LA(2);

                                if ( (LA18_5=='a') ) {
                                    alt18=6;
                                }
                                else if ( (LA18_5=='u') ) {
                                    alt18=7;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("3485:248: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )", 18, 5, input);

                                    throw nvae;
                                }
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("3485:248: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )", 18, 0, input);

                                throw nvae;
                            }

                            switch (alt18) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:249: 'Mon'
                                    {
                                    match("Mon"); 


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:255: 'Tue'
                                    {
                                    match("Tue"); 


                                    }
                                    break;
                                case 3 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:261: 'Wed'
                                    {
                                    match("Wed"); 


                                    }
                                    break;
                                case 4 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:267: 'Thr'
                                    {
                                    match("Thr"); 


                                    }
                                    break;
                                case 5 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:273: 'Fri'
                                    {
                                    match("Fri"); 


                                    }
                                    break;
                                case 6 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:279: 'Sat'
                                    {
                                    match("Sat"); 


                                    }
                                    break;
                                case 7 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:285: 'Sun'
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
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:294: '0' .. '9' '0' .. '9' '0' .. '9' '0' .. '9' '/' ( '0' '0' .. '9' | '1' '0' .. '2' ) '/' ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) ) ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )?
                    {
                    matchRange('0','9'); 
                    matchRange('0','9'); 
                    matchRange('0','9'); 
                    matchRange('0','9'); 
                    match('/'); 
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:334: ( '0' '0' .. '9' | '1' '0' .. '2' )
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
                            new NoViableAltException("3485:334: ( '0' '0' .. '9' | '1' '0' .. '2' )", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:335: '0' '0' .. '9'
                            {
                            match('0'); 
                            matchRange('0','9'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:348: '1' '0' .. '2'
                            {
                            match('1'); 
                            matchRange('0','2'); 

                            }
                            break;

                    }

                    match('/'); 
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:366: ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) )
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
                            new NoViableAltException("3485:366: ( '0' .. '2' '0' .. '9' | '3' ( '0' | '1' ) )", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:367: '0' .. '2' '0' .. '9'
                            {
                            matchRange('0','2'); 
                            matchRange('0','9'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:385: '3' ( '0' | '1' )
                            {
                            match('3'); 
                            if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse =
                                    new MismatchedSetException(null,input);
                                recover(mse);    throw mse;
                            }


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:400: ( ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==' ') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:401: ' ' ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                            {
                            match(' '); 
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:405: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                            int alt22=7;
                            switch ( input.LA(1) ) {
                            case 'M':
                                {
                                alt22=1;
                                }
                                break;
                            case 'T':
                                {
                                int LA22_2 = input.LA(2);

                                if ( (LA22_2=='u') ) {
                                    alt22=2;
                                }
                                else if ( (LA22_2=='h') ) {
                                    alt22=4;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("3485:405: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )", 22, 2, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case 'W':
                                {
                                alt22=3;
                                }
                                break;
                            case 'F':
                                {
                                alt22=5;
                                }
                                break;
                            case 'S':
                                {
                                int LA22_5 = input.LA(2);

                                if ( (LA22_5=='a') ) {
                                    alt22=6;
                                }
                                else if ( (LA22_5=='u') ) {
                                    alt22=7;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("3485:405: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )", 22, 5, input);

                                    throw nvae;
                                }
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("3485:405: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )", 22, 0, input);

                                throw nvae;
                            }

                            switch (alt22) {
                                case 1 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:406: 'Mon'
                                    {
                                    match("Mon"); 


                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:412: 'Tue'
                                    {
                                    match("Tue"); 


                                    }
                                    break;
                                case 3 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:418: 'Wed'
                                    {
                                    match("Wed"); 


                                    }
                                    break;
                                case 4 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:424: 'Thr'
                                    {
                                    match("Thr"); 


                                    }
                                    break;
                                case 5 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:430: 'Fri'
                                    {
                                    match("Fri"); 


                                    }
                                    break;
                                case 6 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:436: 'Sat'
                                    {
                                    match("Sat"); 


                                    }
                                    break;
                                case 7 :
                                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:442: 'Sun'
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
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:451: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:451: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )
                    int alt24=7;
                    switch ( input.LA(1) ) {
                    case 'M':
                        {
                        alt24=1;
                        }
                        break;
                    case 'T':
                        {
                        int LA24_2 = input.LA(2);

                        if ( (LA24_2=='u') ) {
                            alt24=2;
                        }
                        else if ( (LA24_2=='h') ) {
                            alt24=4;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("3485:451: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )", 24, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 'W':
                        {
                        alt24=3;
                        }
                        break;
                    case 'F':
                        {
                        alt24=5;
                        }
                        break;
                    case 'S':
                        {
                        int LA24_5 = input.LA(2);

                        if ( (LA24_5=='a') ) {
                            alt24=6;
                        }
                        else if ( (LA24_5=='u') ) {
                            alt24=7;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("3485:451: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )", 24, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("3485:451: ( 'Mon' | 'Tue' | 'Wed' | 'Thr' | 'Fri' | 'Sat' | 'Sun' )", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:452: 'Mon'
                            {
                            match("Mon"); 


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:458: 'Tue'
                            {
                            match("Tue"); 


                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:464: 'Wed'
                            {
                            match("Wed"); 


                            }
                            break;
                        case 4 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:470: 'Thr'
                            {
                            match("Thr"); 


                            }
                            break;
                        case 5 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:476: 'Fri'
                            {
                            match("Fri"); 


                            }
                            break;
                        case 6 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:482: 'Sat'
                            {
                            match("Sat"); 


                            }
                            break;
                        case 7 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3485:488: 'Sun'
                            {
                            match("Sun"); 


                            }
                            break;

                    }


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_DATETIMELITERAL

    // $ANTLR start RULE_BOOLEANLITERAL
    public final void mRULE_BOOLEANLITERAL() throws RecognitionException {
        try {
            int _type = RULE_BOOLEANLITERAL;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3487:21: ( ( 'true' | 'false' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3487:23: ( 'true' | 'false' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3487:23: ( 'true' | 'false' )
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
                    new NoViableAltException("3487:23: ( 'true' | 'false' )", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3487:24: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3487:31: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_BOOLEANLITERAL

    // $ANTLR start RULE_NULLLITERAL
    public final void mRULE_NULLLITERAL() throws RecognitionException {
        try {
            int _type = RULE_NULLLITERAL;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3489:18: ( 'null' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3489:20: 'null'
            {
            match("null"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_NULLLITERAL

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3491:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3491:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3491:11: ( '^' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='^') ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3491:11: '^'
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3491:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>='0' && LA28_0<='9')||(LA28_0>='A' && LA28_0<='Z')||LA28_0=='_'||(LA28_0>='a' && LA28_0<='z')) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:
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
            	    break loop28;
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3493:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3493:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3493:12: ( '0' .. '9' )+
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
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3493:13: '0' .. '9'
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    new NoViableAltException("3495:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop30:
                    do {
                        int alt30=3;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0=='\\') ) {
                            alt30=1;
                        }
                        else if ( ((LA30_0>='\u0000' && LA30_0<='!')||(LA30_0>='#' && LA30_0<='[')||(LA30_0>=']' && LA30_0<='\uFFFE')) ) {
                            alt30=2;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:62: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop30;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop31:
                    do {
                        int alt31=3;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0=='\\') ) {
                            alt31=1;
                        }
                        else if ( ((LA31_0>='\u0000' && LA31_0<='&')||(LA31_0>='(' && LA31_0<='[')||(LA31_0>=']' && LA31_0<='\uFFFE')) ) {
                            alt31=2;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3495:129: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop31;
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3497:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3497:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3497:24: ( options {greedy=false; } : . )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0=='*') ) {
                    int LA33_1 = input.LA(2);

                    if ( (LA33_1=='/') ) {
                        alt33=2;
                    }
                    else if ( ((LA33_1>='\u0000' && LA33_1<='.')||(LA33_1>='0' && LA33_1<='\uFFFE')) ) {
                        alt33=1;
                    }


                }
                else if ( ((LA33_0>='\u0000' && LA33_0<=')')||(LA33_0>='+' && LA33_0<='\uFFFE')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3497:52: .
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3499:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3499:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3499:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>='\u0000' && LA34_0<='\t')||(LA34_0>='\u000B' && LA34_0<='\f')||(LA34_0>='\u000E' && LA34_0<='\uFFFE')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3499:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop34;
                }
            } while (true);

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3499:40: ( ( '\\r' )? '\\n' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0=='\n'||LA36_0=='\r') ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3499:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3499:41: ( '\\r' )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0=='\r') ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3499:41: '\\r'
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3501:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3501:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3501:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:
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
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3503:16: ( . )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3503:18: .
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
        // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:8: ( T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | RULE_INTEGERLITERAL | RULE_REALLITERAL | RULE_DATETIMELITERAL | RULE_BOOLEANLITERAL | RULE_NULLLITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt38=51;
        alt38 = dfa38.predict(input);
        switch (alt38) {
            case 1 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:10: T16
                {
                mT16(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:14: T17
                {
                mT17(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:18: T18
                {
                mT18(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:22: T19
                {
                mT19(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:26: T20
                {
                mT20(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:30: T21
                {
                mT21(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:34: T22
                {
                mT22(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:38: T23
                {
                mT23(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:42: T24
                {
                mT24(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:46: T25
                {
                mT25(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:50: T26
                {
                mT26(); 

                }
                break;
            case 12 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:54: T27
                {
                mT27(); 

                }
                break;
            case 13 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:58: T28
                {
                mT28(); 

                }
                break;
            case 14 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:62: T29
                {
                mT29(); 

                }
                break;
            case 15 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:66: T30
                {
                mT30(); 

                }
                break;
            case 16 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:70: T31
                {
                mT31(); 

                }
                break;
            case 17 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:74: T32
                {
                mT32(); 

                }
                break;
            case 18 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:78: T33
                {
                mT33(); 

                }
                break;
            case 19 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:82: T34
                {
                mT34(); 

                }
                break;
            case 20 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:86: T35
                {
                mT35(); 

                }
                break;
            case 21 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:90: T36
                {
                mT36(); 

                }
                break;
            case 22 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:94: T37
                {
                mT37(); 

                }
                break;
            case 23 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:98: T38
                {
                mT38(); 

                }
                break;
            case 24 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:102: T39
                {
                mT39(); 

                }
                break;
            case 25 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:106: T40
                {
                mT40(); 

                }
                break;
            case 26 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:110: T41
                {
                mT41(); 

                }
                break;
            case 27 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:114: T42
                {
                mT42(); 

                }
                break;
            case 28 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:118: T43
                {
                mT43(); 

                }
                break;
            case 29 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:122: T44
                {
                mT44(); 

                }
                break;
            case 30 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:126: T45
                {
                mT45(); 

                }
                break;
            case 31 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:130: T46
                {
                mT46(); 

                }
                break;
            case 32 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:134: T47
                {
                mT47(); 

                }
                break;
            case 33 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:138: T48
                {
                mT48(); 

                }
                break;
            case 34 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:142: T49
                {
                mT49(); 

                }
                break;
            case 35 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:146: T50
                {
                mT50(); 

                }
                break;
            case 36 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:150: T51
                {
                mT51(); 

                }
                break;
            case 37 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:154: T52
                {
                mT52(); 

                }
                break;
            case 38 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:158: T53
                {
                mT53(); 

                }
                break;
            case 39 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:162: T54
                {
                mT54(); 

                }
                break;
            case 40 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:166: RULE_INTEGERLITERAL
                {
                mRULE_INTEGERLITERAL(); 

                }
                break;
            case 41 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:186: RULE_REALLITERAL
                {
                mRULE_REALLITERAL(); 

                }
                break;
            case 42 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:203: RULE_DATETIMELITERAL
                {
                mRULE_DATETIMELITERAL(); 

                }
                break;
            case 43 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:224: RULE_BOOLEANLITERAL
                {
                mRULE_BOOLEANLITERAL(); 

                }
                break;
            case 44 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:244: RULE_NULLLITERAL
                {
                mRULE_NULLLITERAL(); 

                }
                break;
            case 45 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:261: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 46 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:269: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 47 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:278: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 48 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:290: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 49 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:306: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 50 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:322: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 51 :
                // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1:330: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA38_eotS =
        "\1\uffff\6\61\1\72\1\75\1\77\1\uffff\1\102\1\104\1\106\1\uffff\1"+
        "\112\2\61\1\117\10\uffff\1\61\1\uffff\1\61\1\uffff\4\134\7\61\1"+
        "\57\1\uffff\2\57\2\uffff\1\61\1\uffff\1\156\4\61\1\163\1\61\12\uffff"+
        "\1\134\1\uffff\1\134\5\uffff\3\61\12\uffff\1\61\1\uffff\1\61\2\uffff"+
        "\1\134\1\uffff\2\134\11\61\2\uffff\2\61\1\uffff\2\61\1\u0089\1\u008a"+
        "\1\uffff\1\u008b\1\u008c\1\61\1\u008e\2\61\1\134\1\uffff\7\173\6"+
        "\61\4\uffff\1\u0098\1\uffff\1\u0099\1\61\1\134\1\u009c\1\61\1\u009e"+
        "\1\u009f\2\61\2\uffff\1\61\1\134\1\uffff\1\u009c\2\uffff\1\u00a3"+
        "\2\61\1\uffff\1\u00a6\2\uffff";
    static final String DFA38_eofS =
        "\u00a7\uffff";
    static final String DFA38_minS =
        "\1\0\1\141\1\155\1\157\1\156\1\162\1\157\3\75\1\uffff\1\72\2\60"+
        "\1\uffff\1\52\2\157\1\56\10\uffff\1\150\1\uffff\1\151\1\uffff\4"+
        "\56\1\157\1\150\1\145\1\162\1\141\1\162\1\141\1\101\1\uffff\2\0"+
        "\2\uffff\1\154\1\uffff\1\60\1\160\1\156\1\144\1\164\1\60\1\162\12"+
        "\uffff\1\56\1\uffff\1\56\5\uffff\1\144\1\154\1\164\12\uffff\1\145"+
        "\1\uffff\1\164\2\uffff\1\56\1\uffff\2\56\1\156\1\162\1\145\1\144"+
        "\1\151\1\156\1\164\1\165\1\154\2\uffff\2\165\1\uffff\1\157\1\164"+
        "\2\60\1\uffff\2\60\1\154\1\60\1\156\1\164\1\56\1\uffff\7\60\1\145"+
        "\1\163\1\145\1\164\1\162\1\145\4\uffff\1\60\1\uffff\1\60\1\145\1"+
        "\56\1\60\1\145\2\60\1\164\1\170\2\uffff\1\162\1\56\1\uffff\1\60"+
        "\2\uffff\1\60\1\164\1\50\1\uffff\1\60\2\uffff";
    static final String DFA38_maxS =
        "\1\ufffe\1\141\1\156\1\157\1\156\1\165\1\157\1\75\1\76\1\75\1\uffff"+
        "\1\72\2\71\1\uffff\1\57\1\157\1\165\1\56\10\uffff\1\150\1\uffff"+
        "\1\151\1\uffff\4\71\1\157\1\165\1\145\1\162\1\165\1\162\1\141\1"+
        "\172\1\uffff\2\ufffe\2\uffff\1\154\1\uffff\1\172\1\160\1\156\1\144"+
        "\1\164\1\172\1\162\12\uffff\1\71\1\uffff\1\71\5\uffff\1\144\1\154"+
        "\1\164\12\uffff\1\145\1\uffff\1\164\2\uffff\1\72\1\uffff\1\72\1"+
        "\71\1\156\1\162\1\145\1\144\1\151\1\156\1\164\1\165\1\154\2\uffff"+
        "\2\165\1\uffff\1\157\1\164\2\172\1\uffff\2\172\1\154\1\172\1\156"+
        "\1\164\1\71\1\uffff\7\172\1\145\1\163\1\145\1\164\1\162\1\145\4"+
        "\uffff\1\172\1\uffff\1\172\1\145\1\71\1\172\1\145\2\172\1\164\1"+
        "\170\2\uffff\1\162\1\71\1\uffff\1\172\2\uffff\1\172\1\164\1\50\1"+
        "\uffff\1\172\2\uffff";
    static final String DFA38_acceptS =
        "\12\uffff\1\15\3\uffff\1\21\4\uffff\1\26\1\27\1\31\1\32\1\34\1\35"+
        "\1\36\1\40\1\uffff\1\42\1\uffff\1\44\14\uffff\1\55\2\uffff\1\62"+
        "\1\63\1\uffff\1\55\7\uffff\1\7\1\37\1\13\1\10\1\11\1\14\1\12\1\15"+
        "\1\30\1\16\1\uffff\1\17\1\uffff\1\20\1\21\1\61\1\60\1\22\3\uffff"+
        "\1\33\1\25\1\26\1\27\1\31\1\32\1\34\1\35\1\36\1\40\1\uffff\1\42"+
        "\1\uffff\1\44\1\50\1\uffff\1\51\13\uffff\1\57\1\62\2\uffff\1\45"+
        "\4\uffff\1\5\7\uffff\1\52\15\uffff\1\4\1\46\1\6\1\23\1\uffff\1\24"+
        "\11\uffff\1\54\1\41\2\uffff\1\53\1\uffff\1\1\1\47\3\uffff\1\2\1"+
        "\uffff\1\43\1\3";
    static final String DFA38_specialS =
        "\u00a7\uffff}>";
    static final String[] DFA38_transitionS = {
            "\11\57\2\56\2\57\1\56\22\57\1\56\1\57\1\54\1\57\1\36\1\57\1"+
            "\34\1\55\1\23\1\24\1\16\1\14\1\31\1\15\1\22\1\17\1\37\1\40\1"+
            "\41\7\42\1\13\1\57\1\10\1\7\1\11\1\12\1\32\5\53\1\46\6\53\1"+
            "\43\5\53\1\47\1\44\2\53\1\45\3\53\1\26\1\57\1\25\1\52\1\53\1"+
            "\57\1\4\1\53\1\3\2\53\1\51\2\53\1\2\1\35\2\53\1\20\1\21\1\5"+
            "\4\53\1\50\1\53\1\1\1\33\1\6\2\53\1\27\1\57\1\30\uff81\57",
            "\1\60",
            "\1\63\1\62",
            "\1\64",
            "\1\65",
            "\1\67\2\uffff\1\66",
            "\1\70",
            "\1\71",
            "\1\73\1\74",
            "\1\76",
            "",
            "\1\101",
            "\1\103\11\105",
            "\1\103\11\105",
            "",
            "\1\111\4\uffff\1\110",
            "\1\113",
            "\1\115\5\uffff\1\114",
            "\1\116",
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
            "\1\132",
            "",
            "\1\136\1\uffff\12\135",
            "\1\136\1\uffff\12\135",
            "\1\136\1\uffff\4\137\6\140",
            "\1\136\1\uffff\12\140",
            "\1\141",
            "\1\142\14\uffff\1\143",
            "\1\144",
            "\1\145",
            "\1\147\23\uffff\1\146",
            "\1\150",
            "\1\151",
            "\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "\uffff\152",
            "\uffff\152",
            "",
            "",
            "\1\154",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\16\61\1\155\13\61",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\1\164",
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
            "\1\136\1\uffff\12\105",
            "",
            "\1\136\1\uffff\12\105",
            "",
            "",
            "",
            "",
            "",
            "\1\165",
            "\1\166",
            "\1\167",
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
            "\1\170",
            "",
            "\1\171",
            "",
            "",
            "\1\136\1\uffff\12\172\1\173",
            "",
            "\1\136\1\uffff\12\172\1\173",
            "\1\136\1\uffff\12\172",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "",
            "",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\u0088",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\1\u008d",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\1\u008f",
            "\1\u0090",
            "\1\136\1\uffff\12\u0091",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "",
            "",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\1\u009a",
            "\1\136\1\173\12\u009b",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\1\u009d",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\1\u00a0",
            "\1\u00a1",
            "",
            "",
            "\1\u00a2",
            "\1\136\1\uffff\12\u009b",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "\12\61\7\uffff\32\61\4\uffff\1\61\1\uffff\32\61",
            "",
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
            return "1:1: Tokens : ( T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | T52 | T53 | T54 | RULE_INTEGERLITERAL | RULE_REALLITERAL | RULE_DATETIMELITERAL | RULE_BOOLEANLITERAL | RULE_NULLLITERAL | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
    }
 

}