package org.eclipse.papyrus.infra.gmfdiag.parser.antlr.internal; 

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.gmfdiag.services.CSSGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

@SuppressWarnings("all")
public class InternalCSSParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_WS", "RULE_CDO", "RULE_CDC", "RULE_ID", "RULE_T_IMPORTANT", "RULE_T_NUM", "RULE_PC_UNIT", "RULE_LEN_UNIT", "RULE_EM_UNIT", "RULE_EX_UNIT", "RULE_ANGLE_UNIT", "RULE_TIME_UNIT", "RULE_FREQ_UNIT", "RULE_HASH", "RULE_T_CLASS", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'@charset '", "';'", "'@import'", "','", "'@media'", "'{'", "'}'", "'@page'", "':'", "'*'", "'('", "')'", "'url('", "'/'", "'['", "']'", "'-'", "'+'", "'>'", "'='", "'~='", "'!='"
    };
    public static final int RULE_ID=8;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int RULE_PC_UNIT=11;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=21;
    public static final int RULE_T_CLASS=19;
    public static final int EOF=-1;
    public static final int RULE_CDC=7;
    public static final int T__42=42;
    public static final int RULE_CDO=6;
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
    public static final int RULE_STRING=4;
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
    public static final int RULE_WS=5;
    public static final int RULE_EM_UNIT=13;

    // delegates
    // delegators


        public InternalCSSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCSSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCSSParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g"; }



     	private CSSGrammarAccess grammarAccess;
     	
        public InternalCSSParser(TokenStream input, CSSGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Stylesheet";	
       	}
       	
       	@Override
       	protected CSSGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleStylesheet"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:68:1: entryRuleStylesheet returns [EObject current=null] : iv_ruleStylesheet= ruleStylesheet EOF ;
    public final EObject entryRuleStylesheet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStylesheet = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:69:2: (iv_ruleStylesheet= ruleStylesheet EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:70:2: iv_ruleStylesheet= ruleStylesheet EOF
            {
             newCompositeNode(grammarAccess.getStylesheetRule()); 
            pushFollow(FOLLOW_ruleStylesheet_in_entryRuleStylesheet75);
            iv_ruleStylesheet=ruleStylesheet();

            state._fsp--;

             current =iv_ruleStylesheet; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStylesheet85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStylesheet"


    // $ANTLR start "ruleStylesheet"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:77:1: ruleStylesheet returns [EObject current=null] : ( (otherlv_0= '@charset ' ( (lv_charset_1_0= RULE_STRING ) ) otherlv_2= ';' )? (this_WS_3= RULE_WS | this_CDO_4= RULE_CDO | this_CDC_5= RULE_CDC )* ( ( (lv_imports_6_0= ruleImport ) ) ( (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* ) | (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* ) )* )* ( ( (lv_contents_11_0= ruleContent ) ) ( (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* ) | (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* ) )* )* ) ;
    public final EObject ruleStylesheet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_charset_1_0=null;
        Token otherlv_2=null;
        Token this_WS_3=null;
        Token this_CDO_4=null;
        Token this_CDC_5=null;
        Token this_CDO_7=null;
        Token this_WS_8=null;
        Token this_CDC_9=null;
        Token this_WS_10=null;
        Token this_CDO_12=null;
        Token this_WS_13=null;
        Token this_CDC_14=null;
        Token this_WS_15=null;
        EObject lv_imports_6_0 = null;

        EObject lv_contents_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:80:28: ( ( (otherlv_0= '@charset ' ( (lv_charset_1_0= RULE_STRING ) ) otherlv_2= ';' )? (this_WS_3= RULE_WS | this_CDO_4= RULE_CDO | this_CDC_5= RULE_CDC )* ( ( (lv_imports_6_0= ruleImport ) ) ( (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* ) | (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* ) )* )* ( ( (lv_contents_11_0= ruleContent ) ) ( (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* ) | (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* ) )* )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:81:1: ( (otherlv_0= '@charset ' ( (lv_charset_1_0= RULE_STRING ) ) otherlv_2= ';' )? (this_WS_3= RULE_WS | this_CDO_4= RULE_CDO | this_CDC_5= RULE_CDC )* ( ( (lv_imports_6_0= ruleImport ) ) ( (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* ) | (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* ) )* )* ( ( (lv_contents_11_0= ruleContent ) ) ( (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* ) | (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* ) )* )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:81:1: ( (otherlv_0= '@charset ' ( (lv_charset_1_0= RULE_STRING ) ) otherlv_2= ';' )? (this_WS_3= RULE_WS | this_CDO_4= RULE_CDO | this_CDC_5= RULE_CDC )* ( ( (lv_imports_6_0= ruleImport ) ) ( (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* ) | (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* ) )* )* ( ( (lv_contents_11_0= ruleContent ) ) ( (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* ) | (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* ) )* )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:81:2: (otherlv_0= '@charset ' ( (lv_charset_1_0= RULE_STRING ) ) otherlv_2= ';' )? (this_WS_3= RULE_WS | this_CDO_4= RULE_CDO | this_CDC_5= RULE_CDC )* ( ( (lv_imports_6_0= ruleImport ) ) ( (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* ) | (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* ) )* )* ( ( (lv_contents_11_0= ruleContent ) ) ( (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* ) | (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* ) )* )*
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:81:2: (otherlv_0= '@charset ' ( (lv_charset_1_0= RULE_STRING ) ) otherlv_2= ';' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==22) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:81:4: otherlv_0= '@charset ' ( (lv_charset_1_0= RULE_STRING ) ) otherlv_2= ';'
                    {
                    otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleStylesheet123); 

                        	newLeafNode(otherlv_0, grammarAccess.getStylesheetAccess().getCharsetKeyword_0_0());
                        
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:85:1: ( (lv_charset_1_0= RULE_STRING ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:86:1: (lv_charset_1_0= RULE_STRING )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:86:1: (lv_charset_1_0= RULE_STRING )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:87:3: lv_charset_1_0= RULE_STRING
                    {
                    lv_charset_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStylesheet140); 

                    			newLeafNode(lv_charset_1_0, grammarAccess.getStylesheetAccess().getCharsetSTRINGTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStylesheetRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"charset",
                            		lv_charset_1_0, 
                            		"STRING");
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleStylesheet157); 

                        	newLeafNode(otherlv_2, grammarAccess.getStylesheetAccess().getSemicolonKeyword_0_2());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:107:3: (this_WS_3= RULE_WS | this_CDO_4= RULE_CDO | this_CDC_5= RULE_CDC )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case RULE_WS:
                    {
                    alt2=1;
                    }
                    break;
                case RULE_CDO:
                    {
                    alt2=2;
                    }
                    break;
                case RULE_CDC:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:107:4: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleStylesheet171); 
            	     
            	        newLeafNode(this_WS_3, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_1_0()); 
            	        

            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:112:6: this_CDO_4= RULE_CDO
            	    {
            	    this_CDO_4=(Token)match(input,RULE_CDO,FOLLOW_RULE_CDO_in_ruleStylesheet187); 
            	     
            	        newLeafNode(this_CDO_4, grammarAccess.getStylesheetAccess().getCDOTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:117:6: this_CDC_5= RULE_CDC
            	    {
            	    this_CDC_5=(Token)match(input,RULE_CDC,FOLLOW_RULE_CDC_in_ruleStylesheet203); 
            	     
            	        newLeafNode(this_CDC_5, grammarAccess.getStylesheetAccess().getCDCTerminalRuleCall_1_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:121:3: ( ( (lv_imports_6_0= ruleImport ) ) ( (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* ) | (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* ) )* )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:121:4: ( (lv_imports_6_0= ruleImport ) ) ( (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* ) | (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* ) )*
            	    {
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:121:4: ( (lv_imports_6_0= ruleImport ) )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:122:1: (lv_imports_6_0= ruleImport )
            	    {
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:122:1: (lv_imports_6_0= ruleImport )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:123:3: lv_imports_6_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStylesheetAccess().getImportsImportParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleStylesheet226);
            	    lv_imports_6_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStylesheetRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_6_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:139:2: ( (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* ) | (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* ) )*
            	    loop5:
            	    do {
            	        int alt5=3;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==RULE_CDO) ) {
            	            alt5=1;
            	        }
            	        else if ( (LA5_0==RULE_CDC) ) {
            	            alt5=2;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:139:3: (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* )
            	    	    {
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:139:3: (this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )* )
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:139:4: this_CDO_7= RULE_CDO (this_WS_8= RULE_WS )*
            	    	    {
            	    	    this_CDO_7=(Token)match(input,RULE_CDO,FOLLOW_RULE_CDO_in_ruleStylesheet239); 
            	    	     
            	    	        newLeafNode(this_CDO_7, grammarAccess.getStylesheetAccess().getCDOTerminalRuleCall_2_1_0_0()); 
            	    	        
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:143:1: (this_WS_8= RULE_WS )*
            	    	    loop3:
            	    	    do {
            	    	        int alt3=2;
            	    	        int LA3_0 = input.LA(1);

            	    	        if ( (LA3_0==RULE_WS) ) {
            	    	            alt3=1;
            	    	        }


            	    	        switch (alt3) {
            	    	    	case 1 :
            	    	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:143:2: this_WS_8= RULE_WS
            	    	    	    {
            	    	    	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleStylesheet250); 
            	    	    	     
            	    	    	        newLeafNode(this_WS_8, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_2_1_0_1()); 
            	    	    	        

            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    break loop3;
            	    	        }
            	    	    } while (true);


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:148:6: (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* )
            	    	    {
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:148:6: (this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )* )
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:148:7: this_CDC_9= RULE_CDC (this_WS_10= RULE_WS )*
            	    	    {
            	    	    this_CDC_9=(Token)match(input,RULE_CDC,FOLLOW_RULE_CDC_in_ruleStylesheet270); 
            	    	     
            	    	        newLeafNode(this_CDC_9, grammarAccess.getStylesheetAccess().getCDCTerminalRuleCall_2_1_1_0()); 
            	    	        
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:152:1: (this_WS_10= RULE_WS )*
            	    	    loop4:
            	    	    do {
            	    	        int alt4=2;
            	    	        int LA4_0 = input.LA(1);

            	    	        if ( (LA4_0==RULE_WS) ) {
            	    	            alt4=1;
            	    	        }


            	    	        switch (alt4) {
            	    	    	case 1 :
            	    	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:152:2: this_WS_10= RULE_WS
            	    	    	    {
            	    	    	    this_WS_10=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleStylesheet281); 
            	    	    	     
            	    	    	        newLeafNode(this_WS_10, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_2_1_1_1()); 
            	    	    	        

            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    break loop4;
            	    	        }
            	    	    } while (true);


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:156:8: ( ( (lv_contents_11_0= ruleContent ) ) ( (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* ) | (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* ) )* )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||(LA10_0>=RULE_HASH && LA10_0<=RULE_T_CLASS)||LA10_0==26||(LA10_0>=29 && LA10_0<=31)||LA10_0==36) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:156:9: ( (lv_contents_11_0= ruleContent ) ) ( (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* ) | (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* ) )*
            	    {
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:156:9: ( (lv_contents_11_0= ruleContent ) )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:157:1: (lv_contents_11_0= ruleContent )
            	    {
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:157:1: (lv_contents_11_0= ruleContent )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:158:3: lv_contents_11_0= ruleContent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStylesheetAccess().getContentsContentParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleContent_in_ruleStylesheet309);
            	    lv_contents_11_0=ruleContent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStylesheetRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"contents",
            	            		lv_contents_11_0, 
            	            		"Content");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:174:2: ( (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* ) | (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* ) )*
            	    loop9:
            	    do {
            	        int alt9=3;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==RULE_CDO) ) {
            	            alt9=1;
            	        }
            	        else if ( (LA9_0==RULE_CDC) ) {
            	            alt9=2;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:174:3: (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* )
            	    	    {
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:174:3: (this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )* )
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:174:4: this_CDO_12= RULE_CDO (this_WS_13= RULE_WS )*
            	    	    {
            	    	    this_CDO_12=(Token)match(input,RULE_CDO,FOLLOW_RULE_CDO_in_ruleStylesheet322); 
            	    	     
            	    	        newLeafNode(this_CDO_12, grammarAccess.getStylesheetAccess().getCDOTerminalRuleCall_3_1_0_0()); 
            	    	        
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:178:1: (this_WS_13= RULE_WS )*
            	    	    loop7:
            	    	    do {
            	    	        int alt7=2;
            	    	        int LA7_0 = input.LA(1);

            	    	        if ( (LA7_0==RULE_WS) ) {
            	    	            alt7=1;
            	    	        }


            	    	        switch (alt7) {
            	    	    	case 1 :
            	    	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:178:2: this_WS_13= RULE_WS
            	    	    	    {
            	    	    	    this_WS_13=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleStylesheet333); 
            	    	    	     
            	    	    	        newLeafNode(this_WS_13, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_3_1_0_1()); 
            	    	    	        

            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    break loop7;
            	    	        }
            	    	    } while (true);


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:183:6: (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* )
            	    	    {
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:183:6: (this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )* )
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:183:7: this_CDC_14= RULE_CDC (this_WS_15= RULE_WS )*
            	    	    {
            	    	    this_CDC_14=(Token)match(input,RULE_CDC,FOLLOW_RULE_CDC_in_ruleStylesheet353); 
            	    	     
            	    	        newLeafNode(this_CDC_14, grammarAccess.getStylesheetAccess().getCDCTerminalRuleCall_3_1_1_0()); 
            	    	        
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:187:1: (this_WS_15= RULE_WS )*
            	    	    loop8:
            	    	    do {
            	    	        int alt8=2;
            	    	        int LA8_0 = input.LA(1);

            	    	        if ( (LA8_0==RULE_WS) ) {
            	    	            alt8=1;
            	    	        }


            	    	        switch (alt8) {
            	    	    	case 1 :
            	    	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:187:2: this_WS_15= RULE_WS
            	    	    	    {
            	    	    	    this_WS_15=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleStylesheet364); 
            	    	    	     
            	    	    	        newLeafNode(this_WS_15, grammarAccess.getStylesheetAccess().getWSTerminalRuleCall_3_1_1_1()); 
            	    	    	        

            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    break loop8;
            	    	        }
            	    	    } while (true);


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop9;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStylesheet"


    // $ANTLR start "entryRuleContent"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:199:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:200:2: (iv_ruleContent= ruleContent EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:201:2: iv_ruleContent= ruleContent EOF
            {
             newCompositeNode(grammarAccess.getContentRule()); 
            pushFollow(FOLLOW_ruleContent_in_entryRuleContent406);
            iv_ruleContent=ruleContent();

            state._fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContent416); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:208:1: ruleContent returns [EObject current=null] : (this_Ruleset_0= ruleRuleset | this_Media_1= ruleMedia | this_Page_2= rulePage ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        EObject this_Ruleset_0 = null;

        EObject this_Media_1 = null;

        EObject this_Page_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:211:28: ( (this_Ruleset_0= ruleRuleset | this_Media_1= ruleMedia | this_Page_2= rulePage ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:212:1: (this_Ruleset_0= ruleRuleset | this_Media_1= ruleMedia | this_Page_2= rulePage )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:212:1: (this_Ruleset_0= ruleRuleset | this_Media_1= ruleMedia | this_Page_2= rulePage )
            int alt11=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_HASH:
            case RULE_T_CLASS:
            case 30:
            case 31:
            case 36:
                {
                alt11=1;
                }
                break;
            case 26:
                {
                alt11=2;
                }
                break;
            case 29:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:213:5: this_Ruleset_0= ruleRuleset
                    {
                     
                            newCompositeNode(grammarAccess.getContentAccess().getRulesetParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRuleset_in_ruleContent463);
                    this_Ruleset_0=ruleRuleset();

                    state._fsp--;

                     
                            current = this_Ruleset_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:223:5: this_Media_1= ruleMedia
                    {
                     
                            newCompositeNode(grammarAccess.getContentAccess().getMediaParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleMedia_in_ruleContent490);
                    this_Media_1=ruleMedia();

                    state._fsp--;

                     
                            current = this_Media_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:233:5: this_Page_2= rulePage
                    {
                     
                            newCompositeNode(grammarAccess.getContentAccess().getPageParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePage_in_ruleContent517);
                    this_Page_2=rulePage();

                    state._fsp--;

                     
                            current = this_Page_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:249:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:250:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:251:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport552);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport562); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:258:1: ruleImport returns [EObject current=null] : (otherlv_0= '@import' ( ( (this_WS_1= RULE_WS )* ( (lv_string_2_0= RULE_STRING ) ) ) | (this_WS_3= RULE_WS ( (lv_uri_4_0= ruleUri ) ) ) ) (this_WS_5= RULE_WS )* ( ( (lv_media_6_0= RULE_ID ) ) (this_WS_7= RULE_WS )* (otherlv_8= ',' (this_WS_9= RULE_WS )* ( (lv_media_10_0= RULE_ID ) ) )* )? otherlv_11= ';' (this_WS_12= RULE_WS )* ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_WS_1=null;
        Token lv_string_2_0=null;
        Token this_WS_3=null;
        Token this_WS_5=null;
        Token lv_media_6_0=null;
        Token this_WS_7=null;
        Token otherlv_8=null;
        Token this_WS_9=null;
        Token lv_media_10_0=null;
        Token otherlv_11=null;
        Token this_WS_12=null;
        EObject lv_uri_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:261:28: ( (otherlv_0= '@import' ( ( (this_WS_1= RULE_WS )* ( (lv_string_2_0= RULE_STRING ) ) ) | (this_WS_3= RULE_WS ( (lv_uri_4_0= ruleUri ) ) ) ) (this_WS_5= RULE_WS )* ( ( (lv_media_6_0= RULE_ID ) ) (this_WS_7= RULE_WS )* (otherlv_8= ',' (this_WS_9= RULE_WS )* ( (lv_media_10_0= RULE_ID ) ) )* )? otherlv_11= ';' (this_WS_12= RULE_WS )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:262:1: (otherlv_0= '@import' ( ( (this_WS_1= RULE_WS )* ( (lv_string_2_0= RULE_STRING ) ) ) | (this_WS_3= RULE_WS ( (lv_uri_4_0= ruleUri ) ) ) ) (this_WS_5= RULE_WS )* ( ( (lv_media_6_0= RULE_ID ) ) (this_WS_7= RULE_WS )* (otherlv_8= ',' (this_WS_9= RULE_WS )* ( (lv_media_10_0= RULE_ID ) ) )* )? otherlv_11= ';' (this_WS_12= RULE_WS )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:262:1: (otherlv_0= '@import' ( ( (this_WS_1= RULE_WS )* ( (lv_string_2_0= RULE_STRING ) ) ) | (this_WS_3= RULE_WS ( (lv_uri_4_0= ruleUri ) ) ) ) (this_WS_5= RULE_WS )* ( ( (lv_media_6_0= RULE_ID ) ) (this_WS_7= RULE_WS )* (otherlv_8= ',' (this_WS_9= RULE_WS )* ( (lv_media_10_0= RULE_ID ) ) )* )? otherlv_11= ';' (this_WS_12= RULE_WS )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:262:3: otherlv_0= '@import' ( ( (this_WS_1= RULE_WS )* ( (lv_string_2_0= RULE_STRING ) ) ) | (this_WS_3= RULE_WS ( (lv_uri_4_0= ruleUri ) ) ) ) (this_WS_5= RULE_WS )* ( ( (lv_media_6_0= RULE_ID ) ) (this_WS_7= RULE_WS )* (otherlv_8= ',' (this_WS_9= RULE_WS )* ( (lv_media_10_0= RULE_ID ) ) )* )? otherlv_11= ';' (this_WS_12= RULE_WS )*
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleImport599); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:266:1: ( ( (this_WS_1= RULE_WS )* ( (lv_string_2_0= RULE_STRING ) ) ) | (this_WS_3= RULE_WS ( (lv_uri_4_0= ruleUri ) ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_WS) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==34) ) {
                    alt13=2;
                }
                else if ( ((LA13_1>=RULE_STRING && LA13_1<=RULE_WS)) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA13_0==RULE_STRING) ) {
                alt13=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:266:2: ( (this_WS_1= RULE_WS )* ( (lv_string_2_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:266:2: ( (this_WS_1= RULE_WS )* ( (lv_string_2_0= RULE_STRING ) ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:266:3: (this_WS_1= RULE_WS )* ( (lv_string_2_0= RULE_STRING ) )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:266:3: (this_WS_1= RULE_WS )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_WS) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:266:4: this_WS_1= RULE_WS
                    	    {
                    	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleImport613); 
                    	     
                    	        newLeafNode(this_WS_1, grammarAccess.getImportAccess().getWSTerminalRuleCall_1_0_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:270:3: ( (lv_string_2_0= RULE_STRING ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:271:1: (lv_string_2_0= RULE_STRING )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:271:1: (lv_string_2_0= RULE_STRING )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:272:3: lv_string_2_0= RULE_STRING
                    {
                    lv_string_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport631); 

                    			newLeafNode(lv_string_2_0, grammarAccess.getImportAccess().getStringSTRINGTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getImportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"string",
                            		lv_string_2_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:289:6: (this_WS_3= RULE_WS ( (lv_uri_4_0= ruleUri ) ) )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:289:6: (this_WS_3= RULE_WS ( (lv_uri_4_0= ruleUri ) ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:289:7: this_WS_3= RULE_WS ( (lv_uri_4_0= ruleUri ) )
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleImport655); 
                     
                        newLeafNode(this_WS_3, grammarAccess.getImportAccess().getWSTerminalRuleCall_1_1_0()); 
                        
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:293:1: ( (lv_uri_4_0= ruleUri ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:294:1: (lv_uri_4_0= ruleUri )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:294:1: (lv_uri_4_0= ruleUri )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:295:3: lv_uri_4_0= ruleUri
                    {
                     
                    	        newCompositeNode(grammarAccess.getImportAccess().getUriUriParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUri_in_ruleImport675);
                    lv_uri_4_0=ruleUri();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImportRule());
                    	        }
                           		set(
                           			current, 
                           			"uri",
                            		lv_uri_4_0, 
                            		"Uri");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:311:4: (this_WS_5= RULE_WS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_WS) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:311:5: this_WS_5= RULE_WS
            	    {
            	    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleImport689); 
            	     
            	        newLeafNode(this_WS_5, grammarAccess.getImportAccess().getWSTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:315:3: ( ( (lv_media_6_0= RULE_ID ) ) (this_WS_7= RULE_WS )* (otherlv_8= ',' (this_WS_9= RULE_WS )* ( (lv_media_10_0= RULE_ID ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:315:4: ( (lv_media_6_0= RULE_ID ) ) (this_WS_7= RULE_WS )* (otherlv_8= ',' (this_WS_9= RULE_WS )* ( (lv_media_10_0= RULE_ID ) ) )*
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:315:4: ( (lv_media_6_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:316:1: (lv_media_6_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:316:1: (lv_media_6_0= RULE_ID )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:317:3: lv_media_6_0= RULE_ID
                    {
                    lv_media_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImport708); 

                    			newLeafNode(lv_media_6_0, grammarAccess.getImportAccess().getMediaIDTerminalRuleCall_3_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getImportRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"media",
                            		lv_media_6_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:333:2: (this_WS_7= RULE_WS )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_WS) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:333:3: this_WS_7= RULE_WS
                    	    {
                    	    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleImport725); 
                    	     
                    	        newLeafNode(this_WS_7, grammarAccess.getImportAccess().getWSTerminalRuleCall_3_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:337:3: (otherlv_8= ',' (this_WS_9= RULE_WS )* ( (lv_media_10_0= RULE_ID ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==25) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:337:5: otherlv_8= ',' (this_WS_9= RULE_WS )* ( (lv_media_10_0= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,25,FOLLOW_25_in_ruleImport739); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getImportAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:341:1: (this_WS_9= RULE_WS )*
                    	    loop16:
                    	    do {
                    	        int alt16=2;
                    	        int LA16_0 = input.LA(1);

                    	        if ( (LA16_0==RULE_WS) ) {
                    	            alt16=1;
                    	        }


                    	        switch (alt16) {
                    	    	case 1 :
                    	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:341:2: this_WS_9= RULE_WS
                    	    	    {
                    	    	    this_WS_9=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleImport751); 
                    	    	     
                    	    	        newLeafNode(this_WS_9, grammarAccess.getImportAccess().getWSTerminalRuleCall_3_2_1()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop16;
                    	        }
                    	    } while (true);

                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:345:3: ( (lv_media_10_0= RULE_ID ) )
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:346:1: (lv_media_10_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:346:1: (lv_media_10_0= RULE_ID )
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:347:3: lv_media_10_0= RULE_ID
                    	    {
                    	    lv_media_10_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImport769); 

                    	    			newLeafNode(lv_media_10_0, grammarAccess.getImportAccess().getMediaIDTerminalRuleCall_3_2_2_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getImportRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"media",
                    	            		lv_media_10_0, 
                    	            		"ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,23,FOLLOW_23_in_ruleImport790); 

                	newLeafNode(otherlv_11, grammarAccess.getImportAccess().getSemicolonKeyword_4());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:367:1: (this_WS_12= RULE_WS )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_WS) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:367:2: this_WS_12= RULE_WS
            	    {
            	    this_WS_12=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleImport802); 
            	     
            	        newLeafNode(this_WS_12, grammarAccess.getImportAccess().getWSTerminalRuleCall_5()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleMedia"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:379:1: entryRuleMedia returns [EObject current=null] : iv_ruleMedia= ruleMedia EOF ;
    public final EObject entryRuleMedia() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMedia = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:380:2: (iv_ruleMedia= ruleMedia EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:381:2: iv_ruleMedia= ruleMedia EOF
            {
             newCompositeNode(grammarAccess.getMediaRule()); 
            pushFollow(FOLLOW_ruleMedia_in_entryRuleMedia839);
            iv_ruleMedia=ruleMedia();

            state._fsp--;

             current =iv_ruleMedia; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMedia849); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMedia"


    // $ANTLR start "ruleMedia"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:388:1: ruleMedia returns [EObject current=null] : (otherlv_0= '@media' this_WS_1= RULE_WS ( (lv_media_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* (otherlv_4= ',' (this_WS_5= RULE_WS )* ( (lv_media_6_0= RULE_ID ) ) )* otherlv_7= '{' (this_WS_8= RULE_WS )* ( (lv_rules_9_0= ruleRuleset ) )* otherlv_10= '}' (this_WS_11= RULE_WS )* ) ;
    public final EObject ruleMedia() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_WS_1=null;
        Token lv_media_2_0=null;
        Token this_WS_3=null;
        Token otherlv_4=null;
        Token this_WS_5=null;
        Token lv_media_6_0=null;
        Token otherlv_7=null;
        Token this_WS_8=null;
        Token otherlv_10=null;
        Token this_WS_11=null;
        EObject lv_rules_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:391:28: ( (otherlv_0= '@media' this_WS_1= RULE_WS ( (lv_media_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* (otherlv_4= ',' (this_WS_5= RULE_WS )* ( (lv_media_6_0= RULE_ID ) ) )* otherlv_7= '{' (this_WS_8= RULE_WS )* ( (lv_rules_9_0= ruleRuleset ) )* otherlv_10= '}' (this_WS_11= RULE_WS )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:392:1: (otherlv_0= '@media' this_WS_1= RULE_WS ( (lv_media_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* (otherlv_4= ',' (this_WS_5= RULE_WS )* ( (lv_media_6_0= RULE_ID ) ) )* otherlv_7= '{' (this_WS_8= RULE_WS )* ( (lv_rules_9_0= ruleRuleset ) )* otherlv_10= '}' (this_WS_11= RULE_WS )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:392:1: (otherlv_0= '@media' this_WS_1= RULE_WS ( (lv_media_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* (otherlv_4= ',' (this_WS_5= RULE_WS )* ( (lv_media_6_0= RULE_ID ) ) )* otherlv_7= '{' (this_WS_8= RULE_WS )* ( (lv_rules_9_0= ruleRuleset ) )* otherlv_10= '}' (this_WS_11= RULE_WS )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:392:3: otherlv_0= '@media' this_WS_1= RULE_WS ( (lv_media_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* (otherlv_4= ',' (this_WS_5= RULE_WS )* ( (lv_media_6_0= RULE_ID ) ) )* otherlv_7= '{' (this_WS_8= RULE_WS )* ( (lv_rules_9_0= ruleRuleset ) )* otherlv_10= '}' (this_WS_11= RULE_WS )*
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleMedia886); 

                	newLeafNode(otherlv_0, grammarAccess.getMediaAccess().getMediaKeyword_0());
                
            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleMedia897); 
             
                newLeafNode(this_WS_1, grammarAccess.getMediaAccess().getWSTerminalRuleCall_1()); 
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:400:1: ( (lv_media_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:401:1: (lv_media_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:401:1: (lv_media_2_0= RULE_ID )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:402:3: lv_media_2_0= RULE_ID
            {
            lv_media_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMedia913); 

            			newLeafNode(lv_media_2_0, grammarAccess.getMediaAccess().getMediaIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMediaRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"media",
                    		lv_media_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:418:2: (this_WS_3= RULE_WS )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:418:3: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleMedia930); 
            	     
            	        newLeafNode(this_WS_3, grammarAccess.getMediaAccess().getWSTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:422:3: (otherlv_4= ',' (this_WS_5= RULE_WS )* ( (lv_media_6_0= RULE_ID ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==25) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:422:5: otherlv_4= ',' (this_WS_5= RULE_WS )* ( (lv_media_6_0= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleMedia944); 

            	        	newLeafNode(otherlv_4, grammarAccess.getMediaAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:426:1: (this_WS_5= RULE_WS )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==RULE_WS) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:426:2: this_WS_5= RULE_WS
            	    	    {
            	    	    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleMedia956); 
            	    	     
            	    	        newLeafNode(this_WS_5, grammarAccess.getMediaAccess().getWSTerminalRuleCall_4_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop21;
            	        }
            	    } while (true);

            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:430:3: ( (lv_media_6_0= RULE_ID ) )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:431:1: (lv_media_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:431:1: (lv_media_6_0= RULE_ID )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:432:3: lv_media_6_0= RULE_ID
            	    {
            	    lv_media_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMedia974); 

            	    			newLeafNode(lv_media_6_0, grammarAccess.getMediaAccess().getMediaIDTerminalRuleCall_4_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getMediaRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"media",
            	            		lv_media_6_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleMedia993); 

                	newLeafNode(otherlv_7, grammarAccess.getMediaAccess().getLeftCurlyBracketKeyword_5());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:452:1: (this_WS_8= RULE_WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:452:2: this_WS_8= RULE_WS
            	    {
            	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleMedia1005); 
            	     
            	        newLeafNode(this_WS_8, grammarAccess.getMediaAccess().getWSTerminalRuleCall_6()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:456:3: ( (lv_rules_9_0= ruleRuleset ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID||(LA24_0>=RULE_HASH && LA24_0<=RULE_T_CLASS)||(LA24_0>=30 && LA24_0<=31)||LA24_0==36) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:457:1: (lv_rules_9_0= ruleRuleset )
            	    {
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:457:1: (lv_rules_9_0= ruleRuleset )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:458:3: lv_rules_9_0= ruleRuleset
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMediaAccess().getRulesRulesetParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRuleset_in_ruleMedia1027);
            	    lv_rules_9_0=ruleRuleset();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMediaRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_9_0, 
            	            		"Ruleset");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_10=(Token)match(input,28,FOLLOW_28_in_ruleMedia1040); 

                	newLeafNode(otherlv_10, grammarAccess.getMediaAccess().getRightCurlyBracketKeyword_8());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:478:1: (this_WS_11= RULE_WS )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_WS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:478:2: this_WS_11= RULE_WS
            	    {
            	    this_WS_11=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleMedia1052); 
            	     
            	        newLeafNode(this_WS_11, grammarAccess.getMediaAccess().getWSTerminalRuleCall_9()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMedia"


    // $ANTLR start "entryRulePage"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:490:1: entryRulePage returns [EObject current=null] : iv_rulePage= rulePage EOF ;
    public final EObject entryRulePage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePage = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:491:2: (iv_rulePage= rulePage EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:492:2: iv_rulePage= rulePage EOF
            {
             newCompositeNode(grammarAccess.getPageRule()); 
            pushFollow(FOLLOW_rulePage_in_entryRulePage1089);
            iv_rulePage=rulePage();

            state._fsp--;

             current =iv_rulePage; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePage1099); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePage"


    // $ANTLR start "rulePage"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:499:1: rulePage returns [EObject current=null] : ( () otherlv_1= '@page' (this_WS_2= RULE_WS )* ( (lv_pseudo_3_0= rulePseudoPage ) )? otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_declarations_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_declarations_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )* ) ;
    public final EObject rulePage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_WS_2=null;
        Token otherlv_4=null;
        Token this_WS_5=null;
        Token otherlv_7=null;
        Token this_WS_8=null;
        Token otherlv_10=null;
        Token this_WS_11=null;
        EObject lv_pseudo_3_0 = null;

        EObject lv_declarations_6_0 = null;

        EObject lv_declarations_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:502:28: ( ( () otherlv_1= '@page' (this_WS_2= RULE_WS )* ( (lv_pseudo_3_0= rulePseudoPage ) )? otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_declarations_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_declarations_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:503:1: ( () otherlv_1= '@page' (this_WS_2= RULE_WS )* ( (lv_pseudo_3_0= rulePseudoPage ) )? otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_declarations_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_declarations_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:503:1: ( () otherlv_1= '@page' (this_WS_2= RULE_WS )* ( (lv_pseudo_3_0= rulePseudoPage ) )? otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_declarations_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_declarations_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:503:2: () otherlv_1= '@page' (this_WS_2= RULE_WS )* ( (lv_pseudo_3_0= rulePseudoPage ) )? otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_declarations_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_declarations_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )*
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:503:2: ()
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:504:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPageAccess().getPageAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_rulePage1145); 

                	newLeafNode(otherlv_1, grammarAccess.getPageAccess().getPageKeyword_1());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:513:1: (this_WS_2= RULE_WS )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_WS) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:513:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_rulePage1157); 
            	     
            	        newLeafNode(this_WS_2, grammarAccess.getPageAccess().getWSTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:517:3: ( (lv_pseudo_3_0= rulePseudoPage ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==30) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:518:1: (lv_pseudo_3_0= rulePseudoPage )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:518:1: (lv_pseudo_3_0= rulePseudoPage )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:519:3: lv_pseudo_3_0= rulePseudoPage
                    {
                     
                    	        newCompositeNode(grammarAccess.getPageAccess().getPseudoPseudoPageParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_rulePseudoPage_in_rulePage1179);
                    lv_pseudo_3_0=rulePseudoPage();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPageRule());
                    	        }
                           		set(
                           			current, 
                           			"pseudo",
                            		lv_pseudo_3_0, 
                            		"PseudoPage");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FOLLOW_27_in_rulePage1192); 

                	newLeafNode(otherlv_4, grammarAccess.getPageAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:539:1: (this_WS_5= RULE_WS )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_WS) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:539:2: this_WS_5= RULE_WS
            	    {
            	    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_rulePage1204); 
            	     
            	        newLeafNode(this_WS_5, grammarAccess.getPageAccess().getWSTerminalRuleCall_5()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:543:3: ( (lv_declarations_6_0= ruleDeclaration ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:544:1: (lv_declarations_6_0= ruleDeclaration )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:544:1: (lv_declarations_6_0= ruleDeclaration )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:545:3: lv_declarations_6_0= ruleDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getPageAccess().getDeclarationsDeclarationParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDeclaration_in_rulePage1226);
                    lv_declarations_6_0=ruleDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPageRule());
                    	        }
                           		add(
                           			current, 
                           			"declarations",
                            		lv_declarations_6_0, 
                            		"Declaration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:561:3: (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_declarations_9_0= ruleDeclaration ) )? )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==23) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:561:5: otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_declarations_9_0= ruleDeclaration ) )?
            	    {
            	    otherlv_7=(Token)match(input,23,FOLLOW_23_in_rulePage1240); 

            	        	newLeafNode(otherlv_7, grammarAccess.getPageAccess().getSemicolonKeyword_7_0());
            	        
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:565:1: (this_WS_8= RULE_WS )*
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==RULE_WS) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:565:2: this_WS_8= RULE_WS
            	    	    {
            	    	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_rulePage1252); 
            	    	     
            	    	        newLeafNode(this_WS_8, grammarAccess.getPageAccess().getWSTerminalRuleCall_7_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop30;
            	        }
            	    } while (true);

            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:569:3: ( (lv_declarations_9_0= ruleDeclaration ) )?
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==RULE_ID) ) {
            	        alt31=1;
            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:570:1: (lv_declarations_9_0= ruleDeclaration )
            	            {
            	            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:570:1: (lv_declarations_9_0= ruleDeclaration )
            	            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:571:3: lv_declarations_9_0= ruleDeclaration
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getPageAccess().getDeclarationsDeclarationParserRuleCall_7_2_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDeclaration_in_rulePage1274);
            	            lv_declarations_9_0=ruleDeclaration();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getPageRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"declarations",
            	                    		lv_declarations_9_0, 
            	                    		"Declaration");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_10=(Token)match(input,28,FOLLOW_28_in_rulePage1289); 

                	newLeafNode(otherlv_10, grammarAccess.getPageAccess().getRightCurlyBracketKeyword_8());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:591:1: (this_WS_11= RULE_WS )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_WS) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:591:2: this_WS_11= RULE_WS
            	    {
            	    this_WS_11=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_rulePage1301); 
            	     
            	        newLeafNode(this_WS_11, grammarAccess.getPageAccess().getWSTerminalRuleCall_9()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePage"


    // $ANTLR start "entryRulePseudoPage"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:603:1: entryRulePseudoPage returns [EObject current=null] : iv_rulePseudoPage= rulePseudoPage EOF ;
    public final EObject entryRulePseudoPage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePseudoPage = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:604:2: (iv_rulePseudoPage= rulePseudoPage EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:605:2: iv_rulePseudoPage= rulePseudoPage EOF
            {
             newCompositeNode(grammarAccess.getPseudoPageRule()); 
            pushFollow(FOLLOW_rulePseudoPage_in_entryRulePseudoPage1338);
            iv_rulePseudoPage=rulePseudoPage();

            state._fsp--;

             current =iv_rulePseudoPage; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePseudoPage1348); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePseudoPage"


    // $ANTLR start "rulePseudoPage"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:612:1: rulePseudoPage returns [EObject current=null] : (otherlv_0= ':' ( (lv_id_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )* ) ;
    public final EObject rulePseudoPage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token this_WS_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:615:28: ( (otherlv_0= ':' ( (lv_id_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:616:1: (otherlv_0= ':' ( (lv_id_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:616:1: (otherlv_0= ':' ( (lv_id_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:616:3: otherlv_0= ':' ( (lv_id_1_0= RULE_ID ) ) (this_WS_2= RULE_WS )*
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_rulePseudoPage1385); 

                	newLeafNode(otherlv_0, grammarAccess.getPseudoPageAccess().getColonKeyword_0());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:620:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:621:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:621:1: (lv_id_1_0= RULE_ID )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:622:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePseudoPage1402); 

            			newLeafNode(lv_id_1_0, grammarAccess.getPseudoPageAccess().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPseudoPageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:638:2: (this_WS_2= RULE_WS )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_WS) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:638:3: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_rulePseudoPage1419); 
            	     
            	        newLeafNode(this_WS_2, grammarAccess.getPseudoPageAccess().getWSTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePseudoPage"


    // $ANTLR start "entryRuleRuleset"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:650:1: entryRuleRuleset returns [EObject current=null] : iv_ruleRuleset= ruleRuleset EOF ;
    public final EObject entryRuleRuleset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleset = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:651:2: (iv_ruleRuleset= ruleRuleset EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:652:2: iv_ruleRuleset= ruleRuleset EOF
            {
             newCompositeNode(grammarAccess.getRulesetRule()); 
            pushFollow(FOLLOW_ruleRuleset_in_entryRuleRuleset1456);
            iv_ruleRuleset=ruleRuleset();

            state._fsp--;

             current =iv_ruleRuleset; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleset1466); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleset"


    // $ANTLR start "ruleRuleset"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:659:1: ruleRuleset returns [EObject current=null] : ( ( (lv_selectors_0_0= ruleSelector ) ) (otherlv_1= ',' (this_WS_2= RULE_WS )* ( (lv_selectors_3_0= ruleSelector ) ) )* otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_properties_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_properties_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )* ) ;
    public final EObject ruleRuleset() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_WS_2=null;
        Token otherlv_4=null;
        Token this_WS_5=null;
        Token otherlv_7=null;
        Token this_WS_8=null;
        Token otherlv_10=null;
        Token this_WS_11=null;
        EObject lv_selectors_0_0 = null;

        EObject lv_selectors_3_0 = null;

        EObject lv_properties_6_0 = null;

        EObject lv_properties_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:662:28: ( ( ( (lv_selectors_0_0= ruleSelector ) ) (otherlv_1= ',' (this_WS_2= RULE_WS )* ( (lv_selectors_3_0= ruleSelector ) ) )* otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_properties_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_properties_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:663:1: ( ( (lv_selectors_0_0= ruleSelector ) ) (otherlv_1= ',' (this_WS_2= RULE_WS )* ( (lv_selectors_3_0= ruleSelector ) ) )* otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_properties_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_properties_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:663:1: ( ( (lv_selectors_0_0= ruleSelector ) ) (otherlv_1= ',' (this_WS_2= RULE_WS )* ( (lv_selectors_3_0= ruleSelector ) ) )* otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_properties_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_properties_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:663:2: ( (lv_selectors_0_0= ruleSelector ) ) (otherlv_1= ',' (this_WS_2= RULE_WS )* ( (lv_selectors_3_0= ruleSelector ) ) )* otherlv_4= '{' (this_WS_5= RULE_WS )* ( (lv_properties_6_0= ruleDeclaration ) )? (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_properties_9_0= ruleDeclaration ) )? )* otherlv_10= '}' (this_WS_11= RULE_WS )*
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:663:2: ( (lv_selectors_0_0= ruleSelector ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:664:1: (lv_selectors_0_0= ruleSelector )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:664:1: (lv_selectors_0_0= ruleSelector )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:665:3: lv_selectors_0_0= ruleSelector
            {
             
            	        newCompositeNode(grammarAccess.getRulesetAccess().getSelectorsSelectorParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSelector_in_ruleRuleset1512);
            lv_selectors_0_0=ruleSelector();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRulesetRule());
            	        }
                   		add(
                   			current, 
                   			"selectors",
                    		lv_selectors_0_0, 
                    		"Selector");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:681:2: (otherlv_1= ',' (this_WS_2= RULE_WS )* ( (lv_selectors_3_0= ruleSelector ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==25) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:681:4: otherlv_1= ',' (this_WS_2= RULE_WS )* ( (lv_selectors_3_0= ruleSelector ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleRuleset1525); 

            	        	newLeafNode(otherlv_1, grammarAccess.getRulesetAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:685:1: (this_WS_2= RULE_WS )*
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==RULE_WS) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:685:2: this_WS_2= RULE_WS
            	    	    {
            	    	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleRuleset1537); 
            	    	     
            	    	        newLeafNode(this_WS_2, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_1_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop35;
            	        }
            	    } while (true);

            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:689:3: ( (lv_selectors_3_0= ruleSelector ) )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:690:1: (lv_selectors_3_0= ruleSelector )
            	    {
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:690:1: (lv_selectors_3_0= ruleSelector )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:691:3: lv_selectors_3_0= ruleSelector
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRulesetAccess().getSelectorsSelectorParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelector_in_ruleRuleset1559);
            	    lv_selectors_3_0=ruleSelector();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRulesetRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"selectors",
            	            		lv_selectors_3_0, 
            	            		"Selector");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleRuleset1573); 

                	newLeafNode(otherlv_4, grammarAccess.getRulesetAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:711:1: (this_WS_5= RULE_WS )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_WS) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:711:2: this_WS_5= RULE_WS
            	    {
            	    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleRuleset1585); 
            	     
            	        newLeafNode(this_WS_5, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:715:3: ( (lv_properties_6_0= ruleDeclaration ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:716:1: (lv_properties_6_0= ruleDeclaration )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:716:1: (lv_properties_6_0= ruleDeclaration )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:717:3: lv_properties_6_0= ruleDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getRulesetAccess().getPropertiesDeclarationParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDeclaration_in_ruleRuleset1607);
                    lv_properties_6_0=ruleDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRulesetRule());
                    	        }
                           		add(
                           			current, 
                           			"properties",
                            		lv_properties_6_0, 
                            		"Declaration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:733:3: (otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_properties_9_0= ruleDeclaration ) )? )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==23) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:733:5: otherlv_7= ';' (this_WS_8= RULE_WS )* ( (lv_properties_9_0= ruleDeclaration ) )?
            	    {
            	    otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleRuleset1621); 

            	        	newLeafNode(otherlv_7, grammarAccess.getRulesetAccess().getSemicolonKeyword_5_0());
            	        
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:737:1: (this_WS_8= RULE_WS )*
            	    loop39:
            	    do {
            	        int alt39=2;
            	        int LA39_0 = input.LA(1);

            	        if ( (LA39_0==RULE_WS) ) {
            	            alt39=1;
            	        }


            	        switch (alt39) {
            	    	case 1 :
            	    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:737:2: this_WS_8= RULE_WS
            	    	    {
            	    	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleRuleset1633); 
            	    	     
            	    	        newLeafNode(this_WS_8, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_5_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop39;
            	        }
            	    } while (true);

            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:741:3: ( (lv_properties_9_0= ruleDeclaration ) )?
            	    int alt40=2;
            	    int LA40_0 = input.LA(1);

            	    if ( (LA40_0==RULE_ID) ) {
            	        alt40=1;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:742:1: (lv_properties_9_0= ruleDeclaration )
            	            {
            	            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:742:1: (lv_properties_9_0= ruleDeclaration )
            	            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:743:3: lv_properties_9_0= ruleDeclaration
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getRulesetAccess().getPropertiesDeclarationParserRuleCall_5_2_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDeclaration_in_ruleRuleset1655);
            	            lv_properties_9_0=ruleDeclaration();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getRulesetRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"properties",
            	                    		lv_properties_9_0, 
            	                    		"Declaration");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            otherlv_10=(Token)match(input,28,FOLLOW_28_in_ruleRuleset1670); 

                	newLeafNode(otherlv_10, grammarAccess.getRulesetAccess().getRightCurlyBracketKeyword_6());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:763:1: (this_WS_11= RULE_WS )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_WS) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:763:2: this_WS_11= RULE_WS
            	    {
            	    this_WS_11=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleRuleset1682); 
            	     
            	        newLeafNode(this_WS_11, grammarAccess.getRulesetAccess().getWSTerminalRuleCall_7()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleset"


    // $ANTLR start "entryRuleSelector"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:775:1: entryRuleSelector returns [EObject current=null] : iv_ruleSelector= ruleSelector EOF ;
    public final EObject entryRuleSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelector = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:776:2: (iv_ruleSelector= ruleSelector EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:777:2: iv_ruleSelector= ruleSelector EOF
            {
             newCompositeNode(grammarAccess.getSelectorRule()); 
            pushFollow(FOLLOW_ruleSelector_in_entryRuleSelector1719);
            iv_ruleSelector=ruleSelector();

            state._fsp--;

             current =iv_ruleSelector; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelector1729); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:784:1: ruleSelector returns [EObject current=null] : ( (this_SimpleSelector_0= ruleSimpleSelector (this_WS_1= RULE_WS )* ) | this_CompositeSelector_2= ruleCompositeSelector ) ;
    public final EObject ruleSelector() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        EObject this_SimpleSelector_0 = null;

        EObject this_CompositeSelector_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:787:28: ( ( (this_SimpleSelector_0= ruleSimpleSelector (this_WS_1= RULE_WS )* ) | this_CompositeSelector_2= ruleCompositeSelector ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:788:1: ( (this_SimpleSelector_0= ruleSimpleSelector (this_WS_1= RULE_WS )* ) | this_CompositeSelector_2= ruleCompositeSelector )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:788:1: ( (this_SimpleSelector_0= ruleSimpleSelector (this_WS_1= RULE_WS )* ) | this_CompositeSelector_2= ruleCompositeSelector )
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:788:2: (this_SimpleSelector_0= ruleSimpleSelector (this_WS_1= RULE_WS )* )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:788:2: (this_SimpleSelector_0= ruleSimpleSelector (this_WS_1= RULE_WS )* )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:789:5: this_SimpleSelector_0= ruleSimpleSelector (this_WS_1= RULE_WS )*
                    {
                     
                            newCompositeNode(grammarAccess.getSelectorAccess().getSimpleSelectorParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleSelector_in_ruleSelector1777);
                    this_SimpleSelector_0=ruleSimpleSelector();

                    state._fsp--;

                     
                            current = this_SimpleSelector_0; 
                            afterParserOrEnumRuleCall();
                        
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:797:1: (this_WS_1= RULE_WS )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==RULE_WS) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:797:2: this_WS_1= RULE_WS
                    	    {
                    	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleSelector1788); 
                    	     
                    	        newLeafNode(this_WS_1, grammarAccess.getSelectorAccess().getWSTerminalRuleCall_0_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:803:5: this_CompositeSelector_2= ruleCompositeSelector
                    {
                     
                            newCompositeNode(grammarAccess.getSelectorAccess().getCompositeSelectorParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCompositeSelector_in_ruleSelector1818);
                    this_CompositeSelector_2=ruleCompositeSelector();

                    state._fsp--;

                     
                            current = this_CompositeSelector_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleCompositeSelector"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:819:1: entryRuleCompositeSelector returns [EObject current=null] : iv_ruleCompositeSelector= ruleCompositeSelector EOF ;
    public final EObject entryRuleCompositeSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeSelector = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:820:2: (iv_ruleCompositeSelector= ruleCompositeSelector EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:821:2: iv_ruleCompositeSelector= ruleCompositeSelector EOF
            {
             newCompositeNode(grammarAccess.getCompositeSelectorRule()); 
            pushFollow(FOLLOW_ruleCompositeSelector_in_entryRuleCompositeSelector1853);
            iv_ruleCompositeSelector=ruleCompositeSelector();

            state._fsp--;

             current =iv_ruleCompositeSelector; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeSelector1863); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompositeSelector"


    // $ANTLR start "ruleCompositeSelector"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:828:1: ruleCompositeSelector returns [EObject current=null] : ( ( (lv_left_0_0= ruleSimpleSelector ) ) ( (this_WS_1= RULE_WS )+ | ( (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) ) ) ) ( (lv_right_4_0= ruleSelector ) ) ) ;
    public final EObject ruleCompositeSelector() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token this_WS_2=null;
        EObject lv_left_0_0 = null;

        EObject lv_combinator_3_0 = null;

        EObject lv_right_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:831:28: ( ( ( (lv_left_0_0= ruleSimpleSelector ) ) ( (this_WS_1= RULE_WS )+ | ( (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) ) ) ) ( (lv_right_4_0= ruleSelector ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:832:1: ( ( (lv_left_0_0= ruleSimpleSelector ) ) ( (this_WS_1= RULE_WS )+ | ( (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) ) ) ) ( (lv_right_4_0= ruleSelector ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:832:1: ( ( (lv_left_0_0= ruleSimpleSelector ) ) ( (this_WS_1= RULE_WS )+ | ( (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) ) ) ) ( (lv_right_4_0= ruleSelector ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:832:2: ( (lv_left_0_0= ruleSimpleSelector ) ) ( (this_WS_1= RULE_WS )+ | ( (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) ) ) ) ( (lv_right_4_0= ruleSelector ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:832:2: ( (lv_left_0_0= ruleSimpleSelector ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:833:1: (lv_left_0_0= ruleSimpleSelector )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:833:1: (lv_left_0_0= ruleSimpleSelector )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:834:3: lv_left_0_0= ruleSimpleSelector
            {
             
            	        newCompositeNode(grammarAccess.getCompositeSelectorAccess().getLeftSimpleSelectorParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSimpleSelector_in_ruleCompositeSelector1909);
            lv_left_0_0=ruleSimpleSelector();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompositeSelectorRule());
            	        }
                   		set(
                   			current, 
                   			"left",
                    		lv_left_0_0, 
                    		"SimpleSelector");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:850:2: ( (this_WS_1= RULE_WS )+ | ( (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) ) ) )
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:850:3: (this_WS_1= RULE_WS )+
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:850:3: (this_WS_1= RULE_WS )+
                    int cnt45=0;
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==RULE_WS) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:850:4: this_WS_1= RULE_WS
                    	    {
                    	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleCompositeSelector1922); 
                    	     
                    	        newLeafNode(this_WS_1, grammarAccess.getCompositeSelectorAccess().getWSTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt45 >= 1 ) break loop45;
                                EarlyExitException eee =
                                    new EarlyExitException(45, input);
                                throw eee;
                        }
                        cnt45++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:855:6: ( (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) ) )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:855:6: ( (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:855:7: (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:855:7: (this_WS_2= RULE_WS )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==RULE_WS) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:855:8: this_WS_2= RULE_WS
                    	    {
                    	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleCompositeSelector1942); 
                    	     
                    	        newLeafNode(this_WS_2, grammarAccess.getCompositeSelectorAccess().getWSTerminalRuleCall_1_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:859:3: ( (lv_combinator_3_0= ruleCombinator ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:860:1: (lv_combinator_3_0= ruleCombinator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:860:1: (lv_combinator_3_0= ruleCombinator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:861:3: lv_combinator_3_0= ruleCombinator
                    {
                     
                    	        newCompositeNode(grammarAccess.getCompositeSelectorAccess().getCombinatorCombinatorParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCombinator_in_ruleCompositeSelector1964);
                    lv_combinator_3_0=ruleCombinator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCompositeSelectorRule());
                    	        }
                           		set(
                           			current, 
                           			"combinator",
                            		lv_combinator_3_0, 
                            		"Combinator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:877:4: ( (lv_right_4_0= ruleSelector ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:878:1: (lv_right_4_0= ruleSelector )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:878:1: (lv_right_4_0= ruleSelector )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:879:3: lv_right_4_0= ruleSelector
            {
             
            	        newCompositeNode(grammarAccess.getCompositeSelectorAccess().getRightSelectorParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleSelector_in_ruleCompositeSelector1987);
            lv_right_4_0=ruleSelector();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompositeSelectorRule());
            	        }
                   		set(
                   			current, 
                   			"right",
                    		lv_right_4_0, 
                    		"Selector");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompositeSelector"


    // $ANTLR start "entryRuleSimpleSelector"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:903:1: entryRuleSimpleSelector returns [EObject current=null] : iv_ruleSimpleSelector= ruleSimpleSelector EOF ;
    public final EObject entryRuleSimpleSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleSelector = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:904:2: (iv_ruleSimpleSelector= ruleSimpleSelector EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:905:2: iv_ruleSimpleSelector= ruleSimpleSelector EOF
            {
             newCompositeNode(grammarAccess.getSimpleSelectorRule()); 
            pushFollow(FOLLOW_ruleSimpleSelector_in_entryRuleSimpleSelector2023);
            iv_ruleSimpleSelector=ruleSimpleSelector();

            state._fsp--;

             current =iv_ruleSimpleSelector; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleSelector2033); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleSelector"


    // $ANTLR start "ruleSimpleSelector"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:912:1: ruleSimpleSelector returns [EObject current=null] : ( ( ( ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) ) ) ( (lv_condition_1_0= ruleSelectorCondition ) )* ) | ( (lv_condition_2_0= ruleSelectorCondition ) )+ ) ;
    public final EObject ruleSimpleSelector() throws RecognitionException {
        EObject current = null;

        Token lv_elementName_0_1=null;
        Token lv_elementName_0_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_condition_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:915:28: ( ( ( ( ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) ) ) ( (lv_condition_1_0= ruleSelectorCondition ) )* ) | ( (lv_condition_2_0= ruleSelectorCondition ) )+ ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:916:1: ( ( ( ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) ) ) ( (lv_condition_1_0= ruleSelectorCondition ) )* ) | ( (lv_condition_2_0= ruleSelectorCondition ) )+ )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:916:1: ( ( ( ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) ) ) ( (lv_condition_1_0= ruleSelectorCondition ) )* ) | ( (lv_condition_2_0= ruleSelectorCondition ) )+ )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID||LA51_0==31) ) {
                alt51=1;
            }
            else if ( ((LA51_0>=RULE_HASH && LA51_0<=RULE_T_CLASS)||LA51_0==30||LA51_0==36) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:916:2: ( ( ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) ) ) ( (lv_condition_1_0= ruleSelectorCondition ) )* )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:916:2: ( ( ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) ) ) ( (lv_condition_1_0= ruleSelectorCondition ) )* )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:916:3: ( ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) ) ) ( (lv_condition_1_0= ruleSelectorCondition ) )*
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:916:3: ( ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:917:1: ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:917:1: ( (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:918:1: (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:918:1: (lv_elementName_0_1= RULE_ID | lv_elementName_0_2= '*' )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==RULE_ID) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==31) ) {
                        alt48=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }
                    switch (alt48) {
                        case 1 :
                            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:919:3: lv_elementName_0_1= RULE_ID
                            {
                            lv_elementName_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleSelector2078); 

                            			newLeafNode(lv_elementName_0_1, grammarAccess.getSimpleSelectorAccess().getElementNameIDTerminalRuleCall_0_0_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSimpleSelectorRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"elementName",
                                    		lv_elementName_0_1, 
                                    		"ID");
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:934:8: lv_elementName_0_2= '*'
                            {
                            lv_elementName_0_2=(Token)match(input,31,FOLLOW_31_in_ruleSimpleSelector2099); 

                                    newLeafNode(lv_elementName_0_2, grammarAccess.getSimpleSelectorAccess().getElementNameAsteriskKeyword_0_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSimpleSelectorRule());
                            	        }
                                   		setWithLastConsumed(current, "elementName", lv_elementName_0_2, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:949:2: ( (lv_condition_1_0= ruleSelectorCondition ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( ((LA49_0>=RULE_HASH && LA49_0<=RULE_T_CLASS)||LA49_0==30||LA49_0==36) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:950:1: (lv_condition_1_0= ruleSelectorCondition )
                    	    {
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:950:1: (lv_condition_1_0= ruleSelectorCondition )
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:951:3: lv_condition_1_0= ruleSelectorCondition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSimpleSelectorAccess().getConditionSelectorConditionParserRuleCall_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSelectorCondition_in_ruleSimpleSelector2136);
                    	    lv_condition_1_0=ruleSelectorCondition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSimpleSelectorRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"condition",
                    	            		lv_condition_1_0, 
                    	            		"SelectorCondition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:968:6: ( (lv_condition_2_0= ruleSelectorCondition ) )+
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:968:6: ( (lv_condition_2_0= ruleSelectorCondition ) )+
                    int cnt50=0;
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( ((LA50_0>=RULE_HASH && LA50_0<=RULE_T_CLASS)||LA50_0==30||LA50_0==36) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:969:1: (lv_condition_2_0= ruleSelectorCondition )
                    	    {
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:969:1: (lv_condition_2_0= ruleSelectorCondition )
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:970:3: lv_condition_2_0= ruleSelectorCondition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSimpleSelectorAccess().getConditionSelectorConditionParserRuleCall_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSelectorCondition_in_ruleSimpleSelector2165);
                    	    lv_condition_2_0=ruleSelectorCondition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSimpleSelectorRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"condition",
                    	            		lv_condition_2_0, 
                    	            		"SelectorCondition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt50 >= 1 ) break loop50;
                                EarlyExitException eee =
                                    new EarlyExitException(50, input);
                                throw eee;
                        }
                        cnt50++;
                    } while (true);


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleSelector"


    // $ANTLR start "entryRuleSelectorCondition"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:994:1: entryRuleSelectorCondition returns [EObject current=null] : iv_ruleSelectorCondition= ruleSelectorCondition EOF ;
    public final EObject entryRuleSelectorCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectorCondition = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:995:2: (iv_ruleSelectorCondition= ruleSelectorCondition EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:996:2: iv_ruleSelectorCondition= ruleSelectorCondition EOF
            {
             newCompositeNode(grammarAccess.getSelectorConditionRule()); 
            pushFollow(FOLLOW_ruleSelectorCondition_in_entryRuleSelectorCondition2202);
            iv_ruleSelectorCondition=ruleSelectorCondition();

            state._fsp--;

             current =iv_ruleSelectorCondition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectorCondition2212); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectorCondition"


    // $ANTLR start "ruleSelectorCondition"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1003:1: ruleSelectorCondition returns [EObject current=null] : (this_CSSId_0= ruleCSSId | this_Class_1= ruleClass | this_Attribute_2= ruleAttribute | this_Pseudo_3= rulePseudo ) ;
    public final EObject ruleSelectorCondition() throws RecognitionException {
        EObject current = null;

        EObject this_CSSId_0 = null;

        EObject this_Class_1 = null;

        EObject this_Attribute_2 = null;

        EObject this_Pseudo_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1006:28: ( (this_CSSId_0= ruleCSSId | this_Class_1= ruleClass | this_Attribute_2= ruleAttribute | this_Pseudo_3= rulePseudo ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1007:1: (this_CSSId_0= ruleCSSId | this_Class_1= ruleClass | this_Attribute_2= ruleAttribute | this_Pseudo_3= rulePseudo )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1007:1: (this_CSSId_0= ruleCSSId | this_Class_1= ruleClass | this_Attribute_2= ruleAttribute | this_Pseudo_3= rulePseudo )
            int alt52=4;
            switch ( input.LA(1) ) {
            case RULE_HASH:
                {
                alt52=1;
                }
                break;
            case RULE_T_CLASS:
                {
                alt52=2;
                }
                break;
            case 36:
                {
                alt52=3;
                }
                break;
            case 30:
                {
                alt52=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1008:5: this_CSSId_0= ruleCSSId
                    {
                     
                            newCompositeNode(grammarAccess.getSelectorConditionAccess().getCSSIdParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleCSSId_in_ruleSelectorCondition2259);
                    this_CSSId_0=ruleCSSId();

                    state._fsp--;

                     
                            current = this_CSSId_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1018:5: this_Class_1= ruleClass
                    {
                     
                            newCompositeNode(grammarAccess.getSelectorConditionAccess().getClassParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleClass_in_ruleSelectorCondition2286);
                    this_Class_1=ruleClass();

                    state._fsp--;

                     
                            current = this_Class_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1028:5: this_Attribute_2= ruleAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getSelectorConditionAccess().getAttributeParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAttribute_in_ruleSelectorCondition2313);
                    this_Attribute_2=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1038:5: this_Pseudo_3= rulePseudo
                    {
                     
                            newCompositeNode(grammarAccess.getSelectorConditionAccess().getPseudoParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_rulePseudo_in_ruleSelectorCondition2340);
                    this_Pseudo_3=rulePseudo();

                    state._fsp--;

                     
                            current = this_Pseudo_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectorCondition"


    // $ANTLR start "entryRuleCombinator"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1054:1: entryRuleCombinator returns [EObject current=null] : iv_ruleCombinator= ruleCombinator EOF ;
    public final EObject entryRuleCombinator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombinator = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1055:2: (iv_ruleCombinator= ruleCombinator EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1056:2: iv_ruleCombinator= ruleCombinator EOF
            {
             newCompositeNode(grammarAccess.getCombinatorRule()); 
            pushFollow(FOLLOW_ruleCombinator_in_entryRuleCombinator2375);
            iv_ruleCombinator=ruleCombinator();

            state._fsp--;

             current =iv_ruleCombinator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCombinator2385); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCombinator"


    // $ANTLR start "ruleCombinator"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1063:1: ruleCombinator returns [EObject current=null] : ( ( (lv_kind_0_0= ruleKIND ) ) (this_WS_1= RULE_WS )* ) ;
    public final EObject ruleCombinator() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Enumerator lv_kind_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1066:28: ( ( ( (lv_kind_0_0= ruleKIND ) ) (this_WS_1= RULE_WS )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1067:1: ( ( (lv_kind_0_0= ruleKIND ) ) (this_WS_1= RULE_WS )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1067:1: ( ( (lv_kind_0_0= ruleKIND ) ) (this_WS_1= RULE_WS )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1067:2: ( (lv_kind_0_0= ruleKIND ) ) (this_WS_1= RULE_WS )*
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1067:2: ( (lv_kind_0_0= ruleKIND ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1068:1: (lv_kind_0_0= ruleKIND )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1068:1: (lv_kind_0_0= ruleKIND )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1069:3: lv_kind_0_0= ruleKIND
            {
             
            	        newCompositeNode(grammarAccess.getCombinatorAccess().getKindKINDEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleKIND_in_ruleCombinator2431);
            lv_kind_0_0=ruleKIND();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCombinatorRule());
            	        }
                   		set(
                   			current, 
                   			"kind",
                    		lv_kind_0_0, 
                    		"KIND");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1085:2: (this_WS_1= RULE_WS )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_WS) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1085:3: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleCombinator2443); 
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getCombinatorAccess().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCombinator"


    // $ANTLR start "entryRuleDeclaration"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1097:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1098:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1099:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration2480);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;

             current =iv_ruleDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration2490); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1106:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_property_0_0= RULE_ID ) ) (this_WS_1= RULE_WS )* otherlv_2= ':' (this_WS_3= RULE_WS )* ( (lv_expression_4_0= ruleExpression ) ) ( ( (lv_important_5_0= RULE_T_IMPORTANT ) ) (this_WS_6= RULE_WS )* )? ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token this_WS_1=null;
        Token otherlv_2=null;
        Token this_WS_3=null;
        Token lv_important_5_0=null;
        Token this_WS_6=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1109:28: ( ( ( (lv_property_0_0= RULE_ID ) ) (this_WS_1= RULE_WS )* otherlv_2= ':' (this_WS_3= RULE_WS )* ( (lv_expression_4_0= ruleExpression ) ) ( ( (lv_important_5_0= RULE_T_IMPORTANT ) ) (this_WS_6= RULE_WS )* )? ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1110:1: ( ( (lv_property_0_0= RULE_ID ) ) (this_WS_1= RULE_WS )* otherlv_2= ':' (this_WS_3= RULE_WS )* ( (lv_expression_4_0= ruleExpression ) ) ( ( (lv_important_5_0= RULE_T_IMPORTANT ) ) (this_WS_6= RULE_WS )* )? )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1110:1: ( ( (lv_property_0_0= RULE_ID ) ) (this_WS_1= RULE_WS )* otherlv_2= ':' (this_WS_3= RULE_WS )* ( (lv_expression_4_0= ruleExpression ) ) ( ( (lv_important_5_0= RULE_T_IMPORTANT ) ) (this_WS_6= RULE_WS )* )? )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1110:2: ( (lv_property_0_0= RULE_ID ) ) (this_WS_1= RULE_WS )* otherlv_2= ':' (this_WS_3= RULE_WS )* ( (lv_expression_4_0= ruleExpression ) ) ( ( (lv_important_5_0= RULE_T_IMPORTANT ) ) (this_WS_6= RULE_WS )* )?
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1110:2: ( (lv_property_0_0= RULE_ID ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1111:1: (lv_property_0_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1111:1: (lv_property_0_0= RULE_ID )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1112:3: lv_property_0_0= RULE_ID
            {
            lv_property_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclaration2532); 

            			newLeafNode(lv_property_0_0, grammarAccess.getDeclarationAccess().getPropertyIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"property",
                    		lv_property_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1128:2: (this_WS_1= RULE_WS )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_WS) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1128:3: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleDeclaration2549); 
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getDeclarationAccess().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleDeclaration2562); 

                	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getColonKeyword_2());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1136:1: (this_WS_3= RULE_WS )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_WS) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1136:2: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleDeclaration2574); 
            	     
            	        newLeafNode(this_WS_3, grammarAccess.getDeclarationAccess().getWSTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1140:3: ( (lv_expression_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1141:1: (lv_expression_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1141:1: (lv_expression_4_0= ruleExpression )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1142:3: lv_expression_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getDeclarationAccess().getExpressionExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleDeclaration2596);
            lv_expression_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1158:2: ( ( (lv_important_5_0= RULE_T_IMPORTANT ) ) (this_WS_6= RULE_WS )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_T_IMPORTANT) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1158:3: ( (lv_important_5_0= RULE_T_IMPORTANT ) ) (this_WS_6= RULE_WS )*
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1158:3: ( (lv_important_5_0= RULE_T_IMPORTANT ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1159:1: (lv_important_5_0= RULE_T_IMPORTANT )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1159:1: (lv_important_5_0= RULE_T_IMPORTANT )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1160:3: lv_important_5_0= RULE_T_IMPORTANT
                    {
                    lv_important_5_0=(Token)match(input,RULE_T_IMPORTANT,FOLLOW_RULE_T_IMPORTANT_in_ruleDeclaration2614); 

                    			newLeafNode(lv_important_5_0, grammarAccess.getDeclarationAccess().getImportantT_IMPORTANTTerminalRuleCall_5_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"important",
                            		true, 
                            		"T_IMPORTANT");
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1176:2: (this_WS_6= RULE_WS )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==RULE_WS) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1176:3: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleDeclaration2631); 
                    	     
                    	        newLeafNode(this_WS_6, grammarAccess.getDeclarationAccess().getWSTerminalRuleCall_5_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1188:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1189:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1190:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression2670);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression2680); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1197:1: ruleExpression returns [EObject current=null] : ( ( (lv_terms_0_0= ruleTerm ) ) ( (lv_subterms_1_0= ruleSubterm ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_terms_0_0 = null;

        EObject lv_subterms_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1200:28: ( ( ( (lv_terms_0_0= ruleTerm ) ) ( (lv_subterms_1_0= ruleSubterm ) )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1201:1: ( ( (lv_terms_0_0= ruleTerm ) ) ( (lv_subterms_1_0= ruleSubterm ) )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1201:1: ( ( (lv_terms_0_0= ruleTerm ) ) ( (lv_subterms_1_0= ruleSubterm ) )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1201:2: ( (lv_terms_0_0= ruleTerm ) ) ( (lv_subterms_1_0= ruleSubterm ) )*
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1201:2: ( (lv_terms_0_0= ruleTerm ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1202:1: (lv_terms_0_0= ruleTerm )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1202:1: (lv_terms_0_0= ruleTerm )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1203:3: lv_terms_0_0= ruleTerm
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getTermsTermParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleTerm_in_ruleExpression2726);
            lv_terms_0_0=ruleTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"terms",
                    		lv_terms_0_0, 
                    		"Term");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1219:2: ( (lv_subterms_1_0= ruleSubterm ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_STRING||LA58_0==RULE_ID||LA58_0==RULE_T_NUM||LA58_0==RULE_HASH||LA58_0==25||(LA58_0>=34 && LA58_0<=35)||(LA58_0>=38 && LA58_0<=39)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1220:1: (lv_subterms_1_0= ruleSubterm )
            	    {
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1220:1: (lv_subterms_1_0= ruleSubterm )
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1221:3: lv_subterms_1_0= ruleSubterm
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getSubtermsSubtermParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubterm_in_ruleExpression2747);
            	    lv_subterms_1_0=ruleSubterm();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subterms",
            	            		lv_subterms_1_0, 
            	            		"Subterm");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleSubterm"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1245:1: entryRuleSubterm returns [EObject current=null] : iv_ruleSubterm= ruleSubterm EOF ;
    public final EObject entryRuleSubterm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubterm = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1246:2: (iv_ruleSubterm= ruleSubterm EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1247:2: iv_ruleSubterm= ruleSubterm EOF
            {
             newCompositeNode(grammarAccess.getSubtermRule()); 
            pushFollow(FOLLOW_ruleSubterm_in_entryRuleSubterm2784);
            iv_ruleSubterm=ruleSubterm();

            state._fsp--;

             current =iv_ruleSubterm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubterm2794); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubterm"


    // $ANTLR start "ruleSubterm"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1254:1: ruleSubterm returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) )? ( (lv_term_1_0= ruleTerm ) ) ) ;
    public final EObject ruleSubterm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_0_0 = null;

        EObject lv_term_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1257:28: ( ( ( (lv_operator_0_0= ruleOperator ) )? ( (lv_term_1_0= ruleTerm ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1258:1: ( ( (lv_operator_0_0= ruleOperator ) )? ( (lv_term_1_0= ruleTerm ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1258:1: ( ( (lv_operator_0_0= ruleOperator ) )? ( (lv_term_1_0= ruleTerm ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1258:2: ( (lv_operator_0_0= ruleOperator ) )? ( (lv_term_1_0= ruleTerm ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1258:2: ( (lv_operator_0_0= ruleOperator ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==25||LA59_0==35) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1259:1: (lv_operator_0_0= ruleOperator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1259:1: (lv_operator_0_0= ruleOperator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1260:3: lv_operator_0_0= ruleOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getSubtermAccess().getOperatorOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOperator_in_ruleSubterm2840);
                    lv_operator_0_0=ruleOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSubtermRule());
                    	        }
                           		set(
                           			current, 
                           			"operator",
                            		lv_operator_0_0, 
                            		"Operator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1276:3: ( (lv_term_1_0= ruleTerm ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1277:1: (lv_term_1_0= ruleTerm )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1277:1: (lv_term_1_0= ruleTerm )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1278:3: lv_term_1_0= ruleTerm
            {
             
            	        newCompositeNode(grammarAccess.getSubtermAccess().getTermTermParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTerm_in_ruleSubterm2862);
            lv_term_1_0=ruleTerm();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSubtermRule());
            	        }
                   		set(
                   			current, 
                   			"term",
                    		lv_term_1_0, 
                    		"Term");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubterm"


    // $ANTLR start "entryRuleTerm"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1302:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1303:2: (iv_ruleTerm= ruleTerm EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1304:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm2898);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm2908); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1311:1: ruleTerm returns [EObject current=null] : ( (this_Number_0= ruleNumber | this_Percentage_1= rulePercentage | this_Length_2= ruleLength | this_Ems_3= ruleEms | this_Exs_4= ruleExs | this_Angle_5= ruleAngle | this_Time_6= ruleTime | this_Frequency_7= ruleFrequency | this_Name_8= ruleName | this_StringValue_9= ruleStringValue | this_Uri_10= ruleUri | this_HexColor_11= ruleHexColor | this_Function_12= ruleFunction ) (this_WS_13= RULE_WS )* ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        Token this_WS_13=null;
        EObject this_Number_0 = null;

        EObject this_Percentage_1 = null;

        EObject this_Length_2 = null;

        EObject this_Ems_3 = null;

        EObject this_Exs_4 = null;

        EObject this_Angle_5 = null;

        EObject this_Time_6 = null;

        EObject this_Frequency_7 = null;

        EObject this_Name_8 = null;

        EObject this_StringValue_9 = null;

        EObject this_Uri_10 = null;

        EObject this_HexColor_11 = null;

        EObject this_Function_12 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1314:28: ( ( (this_Number_0= ruleNumber | this_Percentage_1= rulePercentage | this_Length_2= ruleLength | this_Ems_3= ruleEms | this_Exs_4= ruleExs | this_Angle_5= ruleAngle | this_Time_6= ruleTime | this_Frequency_7= ruleFrequency | this_Name_8= ruleName | this_StringValue_9= ruleStringValue | this_Uri_10= ruleUri | this_HexColor_11= ruleHexColor | this_Function_12= ruleFunction ) (this_WS_13= RULE_WS )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1315:1: ( (this_Number_0= ruleNumber | this_Percentage_1= rulePercentage | this_Length_2= ruleLength | this_Ems_3= ruleEms | this_Exs_4= ruleExs | this_Angle_5= ruleAngle | this_Time_6= ruleTime | this_Frequency_7= ruleFrequency | this_Name_8= ruleName | this_StringValue_9= ruleStringValue | this_Uri_10= ruleUri | this_HexColor_11= ruleHexColor | this_Function_12= ruleFunction ) (this_WS_13= RULE_WS )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1315:1: ( (this_Number_0= ruleNumber | this_Percentage_1= rulePercentage | this_Length_2= ruleLength | this_Ems_3= ruleEms | this_Exs_4= ruleExs | this_Angle_5= ruleAngle | this_Time_6= ruleTime | this_Frequency_7= ruleFrequency | this_Name_8= ruleName | this_StringValue_9= ruleStringValue | this_Uri_10= ruleUri | this_HexColor_11= ruleHexColor | this_Function_12= ruleFunction ) (this_WS_13= RULE_WS )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1315:2: (this_Number_0= ruleNumber | this_Percentage_1= rulePercentage | this_Length_2= ruleLength | this_Ems_3= ruleEms | this_Exs_4= ruleExs | this_Angle_5= ruleAngle | this_Time_6= ruleTime | this_Frequency_7= ruleFrequency | this_Name_8= ruleName | this_StringValue_9= ruleStringValue | this_Uri_10= ruleUri | this_HexColor_11= ruleHexColor | this_Function_12= ruleFunction ) (this_WS_13= RULE_WS )*
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1315:2: (this_Number_0= ruleNumber | this_Percentage_1= rulePercentage | this_Length_2= ruleLength | this_Ems_3= ruleEms | this_Exs_4= ruleExs | this_Angle_5= ruleAngle | this_Time_6= ruleTime | this_Frequency_7= ruleFrequency | this_Name_8= ruleName | this_StringValue_9= ruleStringValue | this_Uri_10= ruleUri | this_HexColor_11= ruleHexColor | this_Function_12= ruleFunction )
            int alt60=13;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1316:5: this_Number_0= ruleNumber
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getNumberParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleNumber_in_ruleTerm2956);
                    this_Number_0=ruleNumber();

                    state._fsp--;

                     
                            current = this_Number_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1326:5: this_Percentage_1= rulePercentage
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getPercentageParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_rulePercentage_in_ruleTerm2983);
                    this_Percentage_1=rulePercentage();

                    state._fsp--;

                     
                            current = this_Percentage_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1336:5: this_Length_2= ruleLength
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getLengthParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_ruleLength_in_ruleTerm3010);
                    this_Length_2=ruleLength();

                    state._fsp--;

                     
                            current = this_Length_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1346:5: this_Ems_3= ruleEms
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getEmsParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleEms_in_ruleTerm3037);
                    this_Ems_3=ruleEms();

                    state._fsp--;

                     
                            current = this_Ems_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1356:5: this_Exs_4= ruleExs
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getExsParserRuleCall_0_4()); 
                        
                    pushFollow(FOLLOW_ruleExs_in_ruleTerm3064);
                    this_Exs_4=ruleExs();

                    state._fsp--;

                     
                            current = this_Exs_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1366:5: this_Angle_5= ruleAngle
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getAngleParserRuleCall_0_5()); 
                        
                    pushFollow(FOLLOW_ruleAngle_in_ruleTerm3091);
                    this_Angle_5=ruleAngle();

                    state._fsp--;

                     
                            current = this_Angle_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1376:5: this_Time_6= ruleTime
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getTimeParserRuleCall_0_6()); 
                        
                    pushFollow(FOLLOW_ruleTime_in_ruleTerm3118);
                    this_Time_6=ruleTime();

                    state._fsp--;

                     
                            current = this_Time_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1386:5: this_Frequency_7= ruleFrequency
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getFrequencyParserRuleCall_0_7()); 
                        
                    pushFollow(FOLLOW_ruleFrequency_in_ruleTerm3145);
                    this_Frequency_7=ruleFrequency();

                    state._fsp--;

                     
                            current = this_Frequency_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1396:5: this_Name_8= ruleName
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getNameParserRuleCall_0_8()); 
                        
                    pushFollow(FOLLOW_ruleName_in_ruleTerm3172);
                    this_Name_8=ruleName();

                    state._fsp--;

                     
                            current = this_Name_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1406:5: this_StringValue_9= ruleStringValue
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getStringValueParserRuleCall_0_9()); 
                        
                    pushFollow(FOLLOW_ruleStringValue_in_ruleTerm3199);
                    this_StringValue_9=ruleStringValue();

                    state._fsp--;

                     
                            current = this_StringValue_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1416:5: this_Uri_10= ruleUri
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getUriParserRuleCall_0_10()); 
                        
                    pushFollow(FOLLOW_ruleUri_in_ruleTerm3226);
                    this_Uri_10=ruleUri();

                    state._fsp--;

                     
                            current = this_Uri_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1426:5: this_HexColor_11= ruleHexColor
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getHexColorParserRuleCall_0_11()); 
                        
                    pushFollow(FOLLOW_ruleHexColor_in_ruleTerm3253);
                    this_HexColor_11=ruleHexColor();

                    state._fsp--;

                     
                            current = this_HexColor_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1436:5: this_Function_12= ruleFunction
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getFunctionParserRuleCall_0_12()); 
                        
                    pushFollow(FOLLOW_ruleFunction_in_ruleTerm3280);
                    this_Function_12=ruleFunction();

                    state._fsp--;

                     
                            current = this_Function_12; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1444:2: (this_WS_13= RULE_WS )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_WS) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1444:3: this_WS_13= RULE_WS
            	    {
            	    this_WS_13=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleTerm3292); 
            	     
            	        newLeafNode(this_WS_13, grammarAccess.getTermAccess().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleFunction"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1456:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1457:2: (iv_ruleFunction= ruleFunction EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1458:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction3329);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction3339); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1465:1: ruleFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' (this_WS_2= RULE_WS )* ( (lv_args_3_0= ruleExpression ) ) otherlv_4= ')' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token this_WS_2=null;
        Token otherlv_4=null;
        EObject lv_args_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1468:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' (this_WS_2= RULE_WS )* ( (lv_args_3_0= ruleExpression ) ) otherlv_4= ')' ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1469:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' (this_WS_2= RULE_WS )* ( (lv_args_3_0= ruleExpression ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1469:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' (this_WS_2= RULE_WS )* ( (lv_args_3_0= ruleExpression ) ) otherlv_4= ')' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1469:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' (this_WS_2= RULE_WS )* ( (lv_args_3_0= ruleExpression ) ) otherlv_4= ')'
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1469:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1470:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1470:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1471:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction3381); 

            			newLeafNode(lv_name_0_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleFunction3398); 

                	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1491:1: (this_WS_2= RULE_WS )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_WS) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1491:2: this_WS_2= RULE_WS
            	    {
            	    this_WS_2=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleFunction3410); 
            	     
            	        newLeafNode(this_WS_2, grammarAccess.getFunctionAccess().getWSTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1495:3: ( (lv_args_3_0= ruleExpression ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1496:1: (lv_args_3_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1496:1: (lv_args_3_0= ruleExpression )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1497:3: lv_args_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleFunction3432);
            lv_args_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"args",
                    		lv_args_3_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleFunction3444); 

                	newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleName"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1525:1: entryRuleName returns [EObject current=null] : iv_ruleName= ruleName EOF ;
    public final EObject entryRuleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleName = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1526:2: (iv_ruleName= ruleName EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1527:2: iv_ruleName= ruleName EOF
            {
             newCompositeNode(grammarAccess.getNameRule()); 
            pushFollow(FOLLOW_ruleName_in_entryRuleName3480);
            iv_ruleName=ruleName();

            state._fsp--;

             current =iv_ruleName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleName3490); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleName"


    // $ANTLR start "ruleName"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1534:1: ruleName returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleName() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1537:28: ( ( (lv_value_0_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1538:1: ( (lv_value_0_0= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1538:1: ( (lv_value_0_0= RULE_ID ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1539:1: (lv_value_0_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1539:1: (lv_value_0_0= RULE_ID )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1540:3: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleName3531); 

            			newLeafNode(lv_value_0_0, grammarAccess.getNameAccess().getValueIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNameRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleName"


    // $ANTLR start "entryRuleNumber"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1564:1: entryRuleNumber returns [EObject current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final EObject entryRuleNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumber = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1565:2: (iv_ruleNumber= ruleNumber EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1566:2: iv_ruleNumber= ruleNumber EOF
            {
             newCompositeNode(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber3571);
            iv_ruleNumber=ruleNumber();

            state._fsp--;

             current =iv_ruleNumber; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber3581); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1573:1: ruleNumber returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ) ;
    public final EObject ruleNumber() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1576:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1577:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1577:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1577:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1577:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=38 && LA63_0<=39)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1578:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1578:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1579:3: lv_op_0_0= ruleUnaryOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getNumberAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleNumber3627);
                    lv_op_0_0=ruleUnaryOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNumberRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"UnaryOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1595:3: ( (lv_value_1_0= RULE_T_NUM ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1596:1: (lv_value_1_0= RULE_T_NUM )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1596:1: (lv_value_1_0= RULE_T_NUM )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1597:3: lv_value_1_0= RULE_T_NUM
            {
            lv_value_1_0=(Token)match(input,RULE_T_NUM,FOLLOW_RULE_T_NUM_in_ruleNumber3645); 

            			newLeafNode(lv_value_1_0, grammarAccess.getNumberAccess().getValueT_NUMTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNumberRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"T_NUM");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRulePercentage"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1621:1: entryRulePercentage returns [EObject current=null] : iv_rulePercentage= rulePercentage EOF ;
    public final EObject entryRulePercentage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePercentage = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1622:2: (iv_rulePercentage= rulePercentage EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1623:2: iv_rulePercentage= rulePercentage EOF
            {
             newCompositeNode(grammarAccess.getPercentageRule()); 
            pushFollow(FOLLOW_rulePercentage_in_entryRulePercentage3686);
            iv_rulePercentage=rulePercentage();

            state._fsp--;

             current =iv_rulePercentage; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePercentage3696); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePercentage"


    // $ANTLR start "rulePercentage"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1630:1: rulePercentage returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_PC_UNIT ) ) ) ;
    public final EObject rulePercentage() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_unit_2_0=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1633:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_PC_UNIT ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1634:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_PC_UNIT ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1634:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_PC_UNIT ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1634:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_PC_UNIT ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1634:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=38 && LA64_0<=39)) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1635:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1635:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1636:3: lv_op_0_0= ruleUnaryOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getPercentageAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_rulePercentage3742);
                    lv_op_0_0=ruleUnaryOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPercentageRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"UnaryOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1652:3: ( (lv_value_1_0= RULE_T_NUM ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1653:1: (lv_value_1_0= RULE_T_NUM )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1653:1: (lv_value_1_0= RULE_T_NUM )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1654:3: lv_value_1_0= RULE_T_NUM
            {
            lv_value_1_0=(Token)match(input,RULE_T_NUM,FOLLOW_RULE_T_NUM_in_rulePercentage3760); 

            			newLeafNode(lv_value_1_0, grammarAccess.getPercentageAccess().getValueT_NUMTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPercentageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"T_NUM");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1670:2: ( (lv_unit_2_0= RULE_PC_UNIT ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1671:1: (lv_unit_2_0= RULE_PC_UNIT )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1671:1: (lv_unit_2_0= RULE_PC_UNIT )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1672:3: lv_unit_2_0= RULE_PC_UNIT
            {
            lv_unit_2_0=(Token)match(input,RULE_PC_UNIT,FOLLOW_RULE_PC_UNIT_in_rulePercentage3782); 

            			newLeafNode(lv_unit_2_0, grammarAccess.getPercentageAccess().getUnitPC_UNITTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPercentageRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"unit",
                    		lv_unit_2_0, 
                    		"PC_UNIT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePercentage"


    // $ANTLR start "entryRuleLength"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1696:1: entryRuleLength returns [EObject current=null] : iv_ruleLength= ruleLength EOF ;
    public final EObject entryRuleLength() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLength = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1697:2: (iv_ruleLength= ruleLength EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1698:2: iv_ruleLength= ruleLength EOF
            {
             newCompositeNode(grammarAccess.getLengthRule()); 
            pushFollow(FOLLOW_ruleLength_in_entryRuleLength3823);
            iv_ruleLength=ruleLength();

            state._fsp--;

             current =iv_ruleLength; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLength3833); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLength"


    // $ANTLR start "ruleLength"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1705:1: ruleLength returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_LEN_UNIT ) ) ) ;
    public final EObject ruleLength() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_unit_2_0=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1708:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_LEN_UNIT ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1709:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_LEN_UNIT ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1709:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_LEN_UNIT ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1709:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_LEN_UNIT ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1709:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=38 && LA65_0<=39)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1710:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1710:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1711:3: lv_op_0_0= ruleUnaryOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getLengthAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleLength3879);
                    lv_op_0_0=ruleUnaryOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLengthRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"UnaryOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1727:3: ( (lv_value_1_0= RULE_T_NUM ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1728:1: (lv_value_1_0= RULE_T_NUM )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1728:1: (lv_value_1_0= RULE_T_NUM )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1729:3: lv_value_1_0= RULE_T_NUM
            {
            lv_value_1_0=(Token)match(input,RULE_T_NUM,FOLLOW_RULE_T_NUM_in_ruleLength3897); 

            			newLeafNode(lv_value_1_0, grammarAccess.getLengthAccess().getValueT_NUMTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLengthRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"T_NUM");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1745:2: ( (lv_unit_2_0= RULE_LEN_UNIT ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1746:1: (lv_unit_2_0= RULE_LEN_UNIT )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1746:1: (lv_unit_2_0= RULE_LEN_UNIT )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1747:3: lv_unit_2_0= RULE_LEN_UNIT
            {
            lv_unit_2_0=(Token)match(input,RULE_LEN_UNIT,FOLLOW_RULE_LEN_UNIT_in_ruleLength3919); 

            			newLeafNode(lv_unit_2_0, grammarAccess.getLengthAccess().getUnitLEN_UNITTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLengthRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"unit",
                    		lv_unit_2_0, 
                    		"LEN_UNIT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLength"


    // $ANTLR start "entryRuleEms"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1771:1: entryRuleEms returns [EObject current=null] : iv_ruleEms= ruleEms EOF ;
    public final EObject entryRuleEms() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEms = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1772:2: (iv_ruleEms= ruleEms EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1773:2: iv_ruleEms= ruleEms EOF
            {
             newCompositeNode(grammarAccess.getEmsRule()); 
            pushFollow(FOLLOW_ruleEms_in_entryRuleEms3960);
            iv_ruleEms=ruleEms();

            state._fsp--;

             current =iv_ruleEms; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEms3970); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEms"


    // $ANTLR start "ruleEms"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1780:1: ruleEms returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EM_UNIT ) ) ) ;
    public final EObject ruleEms() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_unit_2_0=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1783:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EM_UNIT ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1784:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EM_UNIT ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1784:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EM_UNIT ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1784:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EM_UNIT ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1784:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=38 && LA66_0<=39)) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1785:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1785:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1786:3: lv_op_0_0= ruleUnaryOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getEmsAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleEms4016);
                    lv_op_0_0=ruleUnaryOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEmsRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"UnaryOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1802:3: ( (lv_value_1_0= RULE_T_NUM ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1803:1: (lv_value_1_0= RULE_T_NUM )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1803:1: (lv_value_1_0= RULE_T_NUM )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1804:3: lv_value_1_0= RULE_T_NUM
            {
            lv_value_1_0=(Token)match(input,RULE_T_NUM,FOLLOW_RULE_T_NUM_in_ruleEms4034); 

            			newLeafNode(lv_value_1_0, grammarAccess.getEmsAccess().getValueT_NUMTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEmsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"T_NUM");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1820:2: ( (lv_unit_2_0= RULE_EM_UNIT ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1821:1: (lv_unit_2_0= RULE_EM_UNIT )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1821:1: (lv_unit_2_0= RULE_EM_UNIT )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1822:3: lv_unit_2_0= RULE_EM_UNIT
            {
            lv_unit_2_0=(Token)match(input,RULE_EM_UNIT,FOLLOW_RULE_EM_UNIT_in_ruleEms4056); 

            			newLeafNode(lv_unit_2_0, grammarAccess.getEmsAccess().getUnitEM_UNITTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEmsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"unit",
                    		lv_unit_2_0, 
                    		"EM_UNIT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEms"


    // $ANTLR start "entryRuleExs"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1846:1: entryRuleExs returns [EObject current=null] : iv_ruleExs= ruleExs EOF ;
    public final EObject entryRuleExs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExs = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1847:2: (iv_ruleExs= ruleExs EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1848:2: iv_ruleExs= ruleExs EOF
            {
             newCompositeNode(grammarAccess.getExsRule()); 
            pushFollow(FOLLOW_ruleExs_in_entryRuleExs4097);
            iv_ruleExs=ruleExs();

            state._fsp--;

             current =iv_ruleExs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExs4107); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExs"


    // $ANTLR start "ruleExs"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1855:1: ruleExs returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EX_UNIT ) ) ) ;
    public final EObject ruleExs() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_unit_2_0=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1858:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EX_UNIT ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1859:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EX_UNIT ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1859:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EX_UNIT ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1859:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_EX_UNIT ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1859:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=38 && LA67_0<=39)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1860:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1860:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1861:3: lv_op_0_0= ruleUnaryOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getExsAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleExs4153);
                    lv_op_0_0=ruleUnaryOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExsRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"UnaryOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1877:3: ( (lv_value_1_0= RULE_T_NUM ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1878:1: (lv_value_1_0= RULE_T_NUM )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1878:1: (lv_value_1_0= RULE_T_NUM )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1879:3: lv_value_1_0= RULE_T_NUM
            {
            lv_value_1_0=(Token)match(input,RULE_T_NUM,FOLLOW_RULE_T_NUM_in_ruleExs4171); 

            			newLeafNode(lv_value_1_0, grammarAccess.getExsAccess().getValueT_NUMTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"T_NUM");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1895:2: ( (lv_unit_2_0= RULE_EX_UNIT ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1896:1: (lv_unit_2_0= RULE_EX_UNIT )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1896:1: (lv_unit_2_0= RULE_EX_UNIT )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1897:3: lv_unit_2_0= RULE_EX_UNIT
            {
            lv_unit_2_0=(Token)match(input,RULE_EX_UNIT,FOLLOW_RULE_EX_UNIT_in_ruleExs4193); 

            			newLeafNode(lv_unit_2_0, grammarAccess.getExsAccess().getUnitEX_UNITTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"unit",
                    		lv_unit_2_0, 
                    		"EX_UNIT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExs"


    // $ANTLR start "entryRuleAngle"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1921:1: entryRuleAngle returns [EObject current=null] : iv_ruleAngle= ruleAngle EOF ;
    public final EObject entryRuleAngle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAngle = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1922:2: (iv_ruleAngle= ruleAngle EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1923:2: iv_ruleAngle= ruleAngle EOF
            {
             newCompositeNode(grammarAccess.getAngleRule()); 
            pushFollow(FOLLOW_ruleAngle_in_entryRuleAngle4234);
            iv_ruleAngle=ruleAngle();

            state._fsp--;

             current =iv_ruleAngle; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAngle4244); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAngle"


    // $ANTLR start "ruleAngle"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1930:1: ruleAngle returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_ANGLE_UNIT ) ) ) ;
    public final EObject ruleAngle() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_unit_2_0=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1933:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_ANGLE_UNIT ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1934:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_ANGLE_UNIT ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1934:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_ANGLE_UNIT ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1934:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_ANGLE_UNIT ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1934:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=38 && LA68_0<=39)) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1935:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1935:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1936:3: lv_op_0_0= ruleUnaryOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getAngleAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleAngle4290);
                    lv_op_0_0=ruleUnaryOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAngleRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"UnaryOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1952:3: ( (lv_value_1_0= RULE_T_NUM ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1953:1: (lv_value_1_0= RULE_T_NUM )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1953:1: (lv_value_1_0= RULE_T_NUM )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1954:3: lv_value_1_0= RULE_T_NUM
            {
            lv_value_1_0=(Token)match(input,RULE_T_NUM,FOLLOW_RULE_T_NUM_in_ruleAngle4308); 

            			newLeafNode(lv_value_1_0, grammarAccess.getAngleAccess().getValueT_NUMTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAngleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"T_NUM");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1970:2: ( (lv_unit_2_0= RULE_ANGLE_UNIT ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1971:1: (lv_unit_2_0= RULE_ANGLE_UNIT )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1971:1: (lv_unit_2_0= RULE_ANGLE_UNIT )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1972:3: lv_unit_2_0= RULE_ANGLE_UNIT
            {
            lv_unit_2_0=(Token)match(input,RULE_ANGLE_UNIT,FOLLOW_RULE_ANGLE_UNIT_in_ruleAngle4330); 

            			newLeafNode(lv_unit_2_0, grammarAccess.getAngleAccess().getUnitANGLE_UNITTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAngleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"unit",
                    		lv_unit_2_0, 
                    		"ANGLE_UNIT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAngle"


    // $ANTLR start "entryRuleTime"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1996:1: entryRuleTime returns [EObject current=null] : iv_ruleTime= ruleTime EOF ;
    public final EObject entryRuleTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTime = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1997:2: (iv_ruleTime= ruleTime EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:1998:2: iv_ruleTime= ruleTime EOF
            {
             newCompositeNode(grammarAccess.getTimeRule()); 
            pushFollow(FOLLOW_ruleTime_in_entryRuleTime4371);
            iv_ruleTime=ruleTime();

            state._fsp--;

             current =iv_ruleTime; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTime4381); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTime"


    // $ANTLR start "ruleTime"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2005:1: ruleTime returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_TIME_UNIT ) ) ) ;
    public final EObject ruleTime() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_unit_2_0=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2008:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_TIME_UNIT ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2009:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_TIME_UNIT ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2009:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_TIME_UNIT ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2009:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_TIME_UNIT ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2009:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=38 && LA69_0<=39)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2010:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2010:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2011:3: lv_op_0_0= ruleUnaryOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getTimeAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleTime4427);
                    lv_op_0_0=ruleUnaryOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTimeRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"UnaryOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2027:3: ( (lv_value_1_0= RULE_T_NUM ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2028:1: (lv_value_1_0= RULE_T_NUM )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2028:1: (lv_value_1_0= RULE_T_NUM )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2029:3: lv_value_1_0= RULE_T_NUM
            {
            lv_value_1_0=(Token)match(input,RULE_T_NUM,FOLLOW_RULE_T_NUM_in_ruleTime4445); 

            			newLeafNode(lv_value_1_0, grammarAccess.getTimeAccess().getValueT_NUMTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTimeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"T_NUM");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2045:2: ( (lv_unit_2_0= RULE_TIME_UNIT ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2046:1: (lv_unit_2_0= RULE_TIME_UNIT )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2046:1: (lv_unit_2_0= RULE_TIME_UNIT )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2047:3: lv_unit_2_0= RULE_TIME_UNIT
            {
            lv_unit_2_0=(Token)match(input,RULE_TIME_UNIT,FOLLOW_RULE_TIME_UNIT_in_ruleTime4467); 

            			newLeafNode(lv_unit_2_0, grammarAccess.getTimeAccess().getUnitTIME_UNITTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTimeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"unit",
                    		lv_unit_2_0, 
                    		"TIME_UNIT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTime"


    // $ANTLR start "entryRuleFrequency"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2071:1: entryRuleFrequency returns [EObject current=null] : iv_ruleFrequency= ruleFrequency EOF ;
    public final EObject entryRuleFrequency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFrequency = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2072:2: (iv_ruleFrequency= ruleFrequency EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2073:2: iv_ruleFrequency= ruleFrequency EOF
            {
             newCompositeNode(grammarAccess.getFrequencyRule()); 
            pushFollow(FOLLOW_ruleFrequency_in_entryRuleFrequency4508);
            iv_ruleFrequency=ruleFrequency();

            state._fsp--;

             current =iv_ruleFrequency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFrequency4518); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFrequency"


    // $ANTLR start "ruleFrequency"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2080:1: ruleFrequency returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_FREQ_UNIT ) ) ) ;
    public final EObject ruleFrequency() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_unit_2_0=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2083:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_FREQ_UNIT ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2084:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_FREQ_UNIT ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2084:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_FREQ_UNIT ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2084:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_value_1_0= RULE_T_NUM ) ) ( (lv_unit_2_0= RULE_FREQ_UNIT ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2084:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=38 && LA70_0<=39)) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2085:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2085:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2086:3: lv_op_0_0= ruleUnaryOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getFrequencyAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleFrequency4564);
                    lv_op_0_0=ruleUnaryOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFrequencyRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"UnaryOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2102:3: ( (lv_value_1_0= RULE_T_NUM ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2103:1: (lv_value_1_0= RULE_T_NUM )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2103:1: (lv_value_1_0= RULE_T_NUM )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2104:3: lv_value_1_0= RULE_T_NUM
            {
            lv_value_1_0=(Token)match(input,RULE_T_NUM,FOLLOW_RULE_T_NUM_in_ruleFrequency4582); 

            			newLeafNode(lv_value_1_0, grammarAccess.getFrequencyAccess().getValueT_NUMTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFrequencyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"T_NUM");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2120:2: ( (lv_unit_2_0= RULE_FREQ_UNIT ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2121:1: (lv_unit_2_0= RULE_FREQ_UNIT )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2121:1: (lv_unit_2_0= RULE_FREQ_UNIT )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2122:3: lv_unit_2_0= RULE_FREQ_UNIT
            {
            lv_unit_2_0=(Token)match(input,RULE_FREQ_UNIT,FOLLOW_RULE_FREQ_UNIT_in_ruleFrequency4604); 

            			newLeafNode(lv_unit_2_0, grammarAccess.getFrequencyAccess().getUnitFREQ_UNITTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFrequencyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"unit",
                    		lv_unit_2_0, 
                    		"FREQ_UNIT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFrequency"


    // $ANTLR start "entryRuleUri"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2146:1: entryRuleUri returns [EObject current=null] : iv_ruleUri= ruleUri EOF ;
    public final EObject entryRuleUri() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUri = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2147:2: (iv_ruleUri= ruleUri EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2148:2: iv_ruleUri= ruleUri EOF
            {
             newCompositeNode(grammarAccess.getUriRule()); 
            pushFollow(FOLLOW_ruleUri_in_entryRuleUri4645);
            iv_ruleUri=ruleUri();

            state._fsp--;

             current =iv_ruleUri; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUri4655); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUri"


    // $ANTLR start "ruleUri"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2155:1: ruleUri returns [EObject current=null] : (otherlv_0= 'url(' (this_WS_1= RULE_WS )? ( (lv_value_2_0= RULE_STRING ) ) (this_WS_3= RULE_WS )? otherlv_4= ')' ) ;
    public final EObject ruleUri() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_WS_1=null;
        Token lv_value_2_0=null;
        Token this_WS_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2158:28: ( (otherlv_0= 'url(' (this_WS_1= RULE_WS )? ( (lv_value_2_0= RULE_STRING ) ) (this_WS_3= RULE_WS )? otherlv_4= ')' ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2159:1: (otherlv_0= 'url(' (this_WS_1= RULE_WS )? ( (lv_value_2_0= RULE_STRING ) ) (this_WS_3= RULE_WS )? otherlv_4= ')' )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2159:1: (otherlv_0= 'url(' (this_WS_1= RULE_WS )? ( (lv_value_2_0= RULE_STRING ) ) (this_WS_3= RULE_WS )? otherlv_4= ')' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2159:3: otherlv_0= 'url(' (this_WS_1= RULE_WS )? ( (lv_value_2_0= RULE_STRING ) ) (this_WS_3= RULE_WS )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleUri4692); 

                	newLeafNode(otherlv_0, grammarAccess.getUriAccess().getUrlKeyword_0());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2163:1: (this_WS_1= RULE_WS )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_WS) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2163:2: this_WS_1= RULE_WS
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleUri4704); 
                     
                        newLeafNode(this_WS_1, grammarAccess.getUriAccess().getWSTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2167:3: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2168:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2168:1: (lv_value_2_0= RULE_STRING )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2169:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUri4722); 

            			newLeafNode(lv_value_2_0, grammarAccess.getUriAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUriRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2185:2: (this_WS_3= RULE_WS )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_WS) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2185:3: this_WS_3= RULE_WS
                    {
                    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleUri4739); 
                     
                        newLeafNode(this_WS_3, grammarAccess.getUriAccess().getWSTerminalRuleCall_3()); 
                        

                    }
                    break;

            }

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleUri4752); 

                	newLeafNode(otherlv_4, grammarAccess.getUriAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUri"


    // $ANTLR start "entryRuleStringValue"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2201:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2202:2: (iv_ruleStringValue= ruleStringValue EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2203:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue4788);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue4798); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringValue"


    // $ANTLR start "ruleStringValue"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2210:1: ruleStringValue returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2213:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2214:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2214:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2215:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2215:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2216:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringValue4839); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStringValueAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringValue"


    // $ANTLR start "entryRuleHexColor"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2240:1: entryRuleHexColor returns [EObject current=null] : iv_ruleHexColor= ruleHexColor EOF ;
    public final EObject entryRuleHexColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexColor = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2241:2: (iv_ruleHexColor= ruleHexColor EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2242:2: iv_ruleHexColor= ruleHexColor EOF
            {
             newCompositeNode(grammarAccess.getHexColorRule()); 
            pushFollow(FOLLOW_ruleHexColor_in_entryRuleHexColor4879);
            iv_ruleHexColor=ruleHexColor();

            state._fsp--;

             current =iv_ruleHexColor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHexColor4889); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHexColor"


    // $ANTLR start "ruleHexColor"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2249:1: ruleHexColor returns [EObject current=null] : ( (lv_value_0_0= RULE_HASH ) ) ;
    public final EObject ruleHexColor() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2252:28: ( ( (lv_value_0_0= RULE_HASH ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2253:1: ( (lv_value_0_0= RULE_HASH ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2253:1: ( (lv_value_0_0= RULE_HASH ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2254:1: (lv_value_0_0= RULE_HASH )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2254:1: (lv_value_0_0= RULE_HASH )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2255:3: lv_value_0_0= RULE_HASH
            {
            lv_value_0_0=(Token)match(input,RULE_HASH,FOLLOW_RULE_HASH_in_ruleHexColor4930); 

            			newLeafNode(lv_value_0_0, grammarAccess.getHexColorAccess().getValueHASHTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getHexColorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"HASH");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHexColor"


    // $ANTLR start "entryRuleOperator"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2279:1: entryRuleOperator returns [String current=null] : iv_ruleOperator= ruleOperator EOF ;
    public final String entryRuleOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOperator = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2280:2: (iv_ruleOperator= ruleOperator EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2281:2: iv_ruleOperator= ruleOperator EOF
            {
             newCompositeNode(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_ruleOperator_in_entryRuleOperator4971);
            iv_ruleOperator=ruleOperator();

            state._fsp--;

             current =iv_ruleOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperator4982); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2288:1: ruleOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '/' (this_WS_1= RULE_WS )* ) | (kw= ',' (this_WS_3= RULE_WS )* ) ) ;
    public final AntlrDatatypeRuleToken ruleOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_WS_1=null;
        Token this_WS_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2291:28: ( ( (kw= '/' (this_WS_1= RULE_WS )* ) | (kw= ',' (this_WS_3= RULE_WS )* ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2292:1: ( (kw= '/' (this_WS_1= RULE_WS )* ) | (kw= ',' (this_WS_3= RULE_WS )* ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2292:1: ( (kw= '/' (this_WS_1= RULE_WS )* ) | (kw= ',' (this_WS_3= RULE_WS )* ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==35) ) {
                alt75=1;
            }
            else if ( (LA75_0==25) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2292:2: (kw= '/' (this_WS_1= RULE_WS )* )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2292:2: (kw= '/' (this_WS_1= RULE_WS )* )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2293:2: kw= '/' (this_WS_1= RULE_WS )*
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleOperator5021); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getOperatorAccess().getSolidusKeyword_0_0()); 
                        
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2298:1: (this_WS_1= RULE_WS )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==RULE_WS) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2298:6: this_WS_1= RULE_WS
                    	    {
                    	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleOperator5037); 

                    	    		current.merge(this_WS_1);
                    	        
                    	     
                    	        newLeafNode(this_WS_1, grammarAccess.getOperatorAccess().getWSTerminalRuleCall_0_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2306:6: (kw= ',' (this_WS_3= RULE_WS )* )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2306:6: (kw= ',' (this_WS_3= RULE_WS )* )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2307:2: kw= ',' (this_WS_3= RULE_WS )*
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleOperator5065); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getOperatorAccess().getCommaKeyword_1_0()); 
                        
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2312:1: (this_WS_3= RULE_WS )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==RULE_WS) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2312:6: this_WS_3= RULE_WS
                    	    {
                    	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleOperator5081); 

                    	    		current.merge(this_WS_3);
                    	        
                    	     
                    	        newLeafNode(this_WS_3, grammarAccess.getOperatorAccess().getWSTerminalRuleCall_1_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleClass"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2327:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2328:2: (iv_ruleClass= ruleClass EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2329:2: iv_ruleClass= ruleClass EOF
            {
             newCompositeNode(grammarAccess.getClassRule()); 
            pushFollow(FOLLOW_ruleClass_in_entryRuleClass5129);
            iv_ruleClass=ruleClass();

            state._fsp--;

             current =iv_ruleClass; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClass5139); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2336:1: ruleClass returns [EObject current=null] : ( (lv_class_0_0= RULE_T_CLASS ) ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token lv_class_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2339:28: ( ( (lv_class_0_0= RULE_T_CLASS ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2340:1: ( (lv_class_0_0= RULE_T_CLASS ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2340:1: ( (lv_class_0_0= RULE_T_CLASS ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2341:1: (lv_class_0_0= RULE_T_CLASS )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2341:1: (lv_class_0_0= RULE_T_CLASS )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2342:3: lv_class_0_0= RULE_T_CLASS
            {
            lv_class_0_0=(Token)match(input,RULE_T_CLASS,FOLLOW_RULE_T_CLASS_in_ruleClass5180); 

            			newLeafNode(lv_class_0_0, grammarAccess.getClassAccess().getClassT_CLASSTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"class",
                    		lv_class_0_0, 
                    		"T_CLASS");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleAttribute"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2366:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2367:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2368:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute5220);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute5230); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2375:1: ruleAttribute returns [EObject current=null] : (otherlv_0= '[' (this_WS_1= RULE_WS )* ( (lv_name_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* ( (lv_value_4_0= ruleAttributeValue ) )? otherlv_5= ']' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_WS_1=null;
        Token lv_name_2_0=null;
        Token this_WS_3=null;
        Token otherlv_5=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2378:28: ( (otherlv_0= '[' (this_WS_1= RULE_WS )* ( (lv_name_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* ( (lv_value_4_0= ruleAttributeValue ) )? otherlv_5= ']' ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2379:1: (otherlv_0= '[' (this_WS_1= RULE_WS )* ( (lv_name_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* ( (lv_value_4_0= ruleAttributeValue ) )? otherlv_5= ']' )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2379:1: (otherlv_0= '[' (this_WS_1= RULE_WS )* ( (lv_name_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* ( (lv_value_4_0= ruleAttributeValue ) )? otherlv_5= ']' )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2379:3: otherlv_0= '[' (this_WS_1= RULE_WS )* ( (lv_name_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )* ( (lv_value_4_0= ruleAttributeValue ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleAttribute5267); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2383:1: (this_WS_1= RULE_WS )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_WS) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2383:2: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleAttribute5279); 
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getAttributeAccess().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2387:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2388:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2388:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2389:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute5297); 

            			newLeafNode(lv_name_2_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2405:2: (this_WS_3= RULE_WS )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==RULE_WS) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2405:3: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleAttribute5314); 
            	     
            	        newLeafNode(this_WS_3, grammarAccess.getAttributeAccess().getWSTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2409:3: ( (lv_value_4_0= ruleAttributeValue ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=41 && LA78_0<=43)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2410:1: (lv_value_4_0= ruleAttributeValue )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2410:1: (lv_value_4_0= ruleAttributeValue )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2411:3: lv_value_4_0= ruleAttributeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getValueAttributeValueParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAttributeValue_in_ruleAttribute5336);
                    lv_value_4_0=ruleAttributeValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"AttributeValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,37,FOLLOW_37_in_ruleAttribute5349); 

                	newLeafNode(otherlv_5, grammarAccess.getAttributeAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleAttributeValue"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2439:1: entryRuleAttributeValue returns [EObject current=null] : iv_ruleAttributeValue= ruleAttributeValue EOF ;
    public final EObject entryRuleAttributeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeValue = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2440:2: (iv_ruleAttributeValue= ruleAttributeValue EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2441:2: iv_ruleAttributeValue= ruleAttributeValue EOF
            {
             newCompositeNode(grammarAccess.getAttributeValueRule()); 
            pushFollow(FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5385);
            iv_ruleAttributeValue=ruleAttributeValue();

            state._fsp--;

             current =iv_ruleAttributeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeValue5395); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeValue"


    // $ANTLR start "ruleAttributeValue"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2448:1: ruleAttributeValue returns [EObject current=null] : ( ( (lv_operator_0_0= ruleATTRIBUTE_OP ) ) (this_WS_1= RULE_WS )* ( ( (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING ) ) ) (this_WS_3= RULE_WS )* ) ;
    public final EObject ruleAttributeValue() throws RecognitionException {
        EObject current = null;

        Token this_WS_1=null;
        Token lv_value_2_1=null;
        Token lv_value_2_2=null;
        Token this_WS_3=null;
        Enumerator lv_operator_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2451:28: ( ( ( (lv_operator_0_0= ruleATTRIBUTE_OP ) ) (this_WS_1= RULE_WS )* ( ( (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING ) ) ) (this_WS_3= RULE_WS )* ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2452:1: ( ( (lv_operator_0_0= ruleATTRIBUTE_OP ) ) (this_WS_1= RULE_WS )* ( ( (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING ) ) ) (this_WS_3= RULE_WS )* )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2452:1: ( ( (lv_operator_0_0= ruleATTRIBUTE_OP ) ) (this_WS_1= RULE_WS )* ( ( (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING ) ) ) (this_WS_3= RULE_WS )* )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2452:2: ( (lv_operator_0_0= ruleATTRIBUTE_OP ) ) (this_WS_1= RULE_WS )* ( ( (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING ) ) ) (this_WS_3= RULE_WS )*
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2452:2: ( (lv_operator_0_0= ruleATTRIBUTE_OP ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2453:1: (lv_operator_0_0= ruleATTRIBUTE_OP )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2453:1: (lv_operator_0_0= ruleATTRIBUTE_OP )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2454:3: lv_operator_0_0= ruleATTRIBUTE_OP
            {
             
            	        newCompositeNode(grammarAccess.getAttributeValueAccess().getOperatorATTRIBUTE_OPEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleATTRIBUTE_OP_in_ruleAttributeValue5441);
            lv_operator_0_0=ruleATTRIBUTE_OP();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeValueRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_0_0, 
                    		"ATTRIBUTE_OP");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2470:2: (this_WS_1= RULE_WS )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==RULE_WS) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2470:3: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleAttributeValue5453); 
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getAttributeValueAccess().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2474:3: ( ( (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2475:1: ( (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2475:1: ( (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2476:1: (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2476:1: (lv_value_2_1= RULE_ID | lv_value_2_2= RULE_STRING )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID) ) {
                alt80=1;
            }
            else if ( (LA80_0==RULE_STRING) ) {
                alt80=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2477:3: lv_value_2_1= RULE_ID
                    {
                    lv_value_2_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttributeValue5473); 

                    			newLeafNode(lv_value_2_1, grammarAccess.getAttributeValueAccess().getValueIDTerminalRuleCall_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_2_1, 
                            		"ID");
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2492:8: lv_value_2_2= RULE_STRING
                    {
                    lv_value_2_2=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAttributeValue5493); 

                    			newLeafNode(lv_value_2_2, grammarAccess.getAttributeValueAccess().getValueSTRINGTerminalRuleCall_2_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_2_2, 
                            		"STRING");
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2510:2: (this_WS_3= RULE_WS )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==RULE_WS) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2510:3: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleAttributeValue5513); 
            	     
            	        newLeafNode(this_WS_3, grammarAccess.getAttributeValueAccess().getWSTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeValue"


    // $ANTLR start "entryRulePseudo"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2522:1: entryRulePseudo returns [EObject current=null] : iv_rulePseudo= rulePseudo EOF ;
    public final EObject entryRulePseudo() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePseudo = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2523:2: (iv_rulePseudo= rulePseudo EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2524:2: iv_rulePseudo= rulePseudo EOF
            {
             newCompositeNode(grammarAccess.getPseudoRule()); 
            pushFollow(FOLLOW_rulePseudo_in_entryRulePseudo5550);
            iv_rulePseudo=rulePseudo();

            state._fsp--;

             current =iv_rulePseudo; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePseudo5560); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePseudo"


    // $ANTLR start "rulePseudo"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2531:1: rulePseudo returns [EObject current=null] : (otherlv_0= ':' ( ( (lv_pseudo_1_0= RULE_ID ) ) | ( ( (lv_pseudo_2_0= RULE_ID ) ) otherlv_3= '(' (this_WS_4= RULE_WS )* ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )? otherlv_7= ')' ) ) ) ;
    public final EObject rulePseudo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_pseudo_1_0=null;
        Token lv_pseudo_2_0=null;
        Token otherlv_3=null;
        Token this_WS_4=null;
        Token lv_args_5_0=null;
        Token this_WS_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2534:28: ( (otherlv_0= ':' ( ( (lv_pseudo_1_0= RULE_ID ) ) | ( ( (lv_pseudo_2_0= RULE_ID ) ) otherlv_3= '(' (this_WS_4= RULE_WS )* ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )? otherlv_7= ')' ) ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2535:1: (otherlv_0= ':' ( ( (lv_pseudo_1_0= RULE_ID ) ) | ( ( (lv_pseudo_2_0= RULE_ID ) ) otherlv_3= '(' (this_WS_4= RULE_WS )* ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )? otherlv_7= ')' ) ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2535:1: (otherlv_0= ':' ( ( (lv_pseudo_1_0= RULE_ID ) ) | ( ( (lv_pseudo_2_0= RULE_ID ) ) otherlv_3= '(' (this_WS_4= RULE_WS )* ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )? otherlv_7= ')' ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2535:3: otherlv_0= ':' ( ( (lv_pseudo_1_0= RULE_ID ) ) | ( ( (lv_pseudo_2_0= RULE_ID ) ) otherlv_3= '(' (this_WS_4= RULE_WS )* ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )? otherlv_7= ')' ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_rulePseudo5597); 

                	newLeafNode(otherlv_0, grammarAccess.getPseudoAccess().getColonKeyword_0());
                
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2539:1: ( ( (lv_pseudo_1_0= RULE_ID ) ) | ( ( (lv_pseudo_2_0= RULE_ID ) ) otherlv_3= '(' (this_WS_4= RULE_WS )* ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )? otherlv_7= ')' ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_ID) ) {
                int LA85_1 = input.LA(2);

                if ( (LA85_1==32) ) {
                    alt85=2;
                }
                else if ( (LA85_1==EOF||LA85_1==RULE_WS||(LA85_1>=RULE_HASH && LA85_1<=RULE_T_CLASS)||LA85_1==25||LA85_1==27||LA85_1==30||LA85_1==36||(LA85_1>=39 && LA85_1<=40)) ) {
                    alt85=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 85, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2539:2: ( (lv_pseudo_1_0= RULE_ID ) )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2539:2: ( (lv_pseudo_1_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2540:1: (lv_pseudo_1_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2540:1: (lv_pseudo_1_0= RULE_ID )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2541:3: lv_pseudo_1_0= RULE_ID
                    {
                    lv_pseudo_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePseudo5615); 

                    			newLeafNode(lv_pseudo_1_0, grammarAccess.getPseudoAccess().getPseudoIDTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPseudoRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"pseudo",
                            		lv_pseudo_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2558:6: ( ( (lv_pseudo_2_0= RULE_ID ) ) otherlv_3= '(' (this_WS_4= RULE_WS )* ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )? otherlv_7= ')' )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2558:6: ( ( (lv_pseudo_2_0= RULE_ID ) ) otherlv_3= '(' (this_WS_4= RULE_WS )* ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )? otherlv_7= ')' )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2558:7: ( (lv_pseudo_2_0= RULE_ID ) ) otherlv_3= '(' (this_WS_4= RULE_WS )* ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )? otherlv_7= ')'
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2558:7: ( (lv_pseudo_2_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2559:1: (lv_pseudo_2_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2559:1: (lv_pseudo_2_0= RULE_ID )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2560:3: lv_pseudo_2_0= RULE_ID
                    {
                    lv_pseudo_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePseudo5644); 

                    			newLeafNode(lv_pseudo_2_0, grammarAccess.getPseudoAccess().getPseudoIDTerminalRuleCall_1_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPseudoRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"pseudo",
                            		lv_pseudo_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_rulePseudo5661); 

                        	newLeafNode(otherlv_3, grammarAccess.getPseudoAccess().getLeftParenthesisKeyword_1_1_1());
                        
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2580:1: (this_WS_4= RULE_WS )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==RULE_WS) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2580:2: this_WS_4= RULE_WS
                    	    {
                    	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_rulePseudo5673); 
                    	     
                    	        newLeafNode(this_WS_4, grammarAccess.getPseudoAccess().getWSTerminalRuleCall_1_1_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop82;
                        }
                    } while (true);

                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2584:3: ( ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )* )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==RULE_ID) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2584:4: ( (lv_args_5_0= RULE_ID ) ) (this_WS_6= RULE_WS )*
                            {
                            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2584:4: ( (lv_args_5_0= RULE_ID ) )
                            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2585:1: (lv_args_5_0= RULE_ID )
                            {
                            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2585:1: (lv_args_5_0= RULE_ID )
                            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2586:3: lv_args_5_0= RULE_ID
                            {
                            lv_args_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePseudo5692); 

                            			newLeafNode(lv_args_5_0, grammarAccess.getPseudoAccess().getArgsIDTerminalRuleCall_1_1_3_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getPseudoRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"args",
                                    		lv_args_5_0, 
                                    		"ID");
                            	    

                            }


                            }

                            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2602:2: (this_WS_6= RULE_WS )*
                            loop83:
                            do {
                                int alt83=2;
                                int LA83_0 = input.LA(1);

                                if ( (LA83_0==RULE_WS) ) {
                                    alt83=1;
                                }


                                switch (alt83) {
                            	case 1 :
                            	    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2602:3: this_WS_6= RULE_WS
                            	    {
                            	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_rulePseudo5709); 
                            	     
                            	        newLeafNode(this_WS_6, grammarAccess.getPseudoAccess().getWSTerminalRuleCall_1_1_3_1()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop83;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,33,FOLLOW_33_in_rulePseudo5724); 

                        	newLeafNode(otherlv_7, grammarAccess.getPseudoAccess().getRightParenthesisKeyword_1_1_4());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePseudo"


    // $ANTLR start "entryRuleCSSId"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2618:1: entryRuleCSSId returns [EObject current=null] : iv_ruleCSSId= ruleCSSId EOF ;
    public final EObject entryRuleCSSId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCSSId = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2619:2: (iv_ruleCSSId= ruleCSSId EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2620:2: iv_ruleCSSId= ruleCSSId EOF
            {
             newCompositeNode(grammarAccess.getCSSIdRule()); 
            pushFollow(FOLLOW_ruleCSSId_in_entryRuleCSSId5762);
            iv_ruleCSSId=ruleCSSId();

            state._fsp--;

             current =iv_ruleCSSId; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCSSId5772); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCSSId"


    // $ANTLR start "ruleCSSId"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2627:1: ruleCSSId returns [EObject current=null] : ( (lv_value_0_0= RULE_HASH ) ) ;
    public final EObject ruleCSSId() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2630:28: ( ( (lv_value_0_0= RULE_HASH ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2631:1: ( (lv_value_0_0= RULE_HASH ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2631:1: ( (lv_value_0_0= RULE_HASH ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2632:1: (lv_value_0_0= RULE_HASH )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2632:1: (lv_value_0_0= RULE_HASH )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2633:3: lv_value_0_0= RULE_HASH
            {
            lv_value_0_0=(Token)match(input,RULE_HASH,FOLLOW_RULE_HASH_in_ruleCSSId5813); 

            			newLeafNode(lv_value_0_0, grammarAccess.getCSSIdAccess().getValueHASHTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCSSIdRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"HASH");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCSSId"


    // $ANTLR start "entryRuleUnaryOperator"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2657:1: entryRuleUnaryOperator returns [EObject current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final EObject entryRuleUnaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperator = null;


        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2658:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2659:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator5853);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;

             current =iv_ruleUnaryOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator5863); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2666:1: ruleUnaryOperator returns [EObject current=null] : ( (lv_operator_0_0= ruleUNARY ) ) ;
    public final EObject ruleUnaryOperator() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2669:28: ( ( (lv_operator_0_0= ruleUNARY ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2670:1: ( (lv_operator_0_0= ruleUNARY ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2670:1: ( (lv_operator_0_0= ruleUNARY ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2671:1: (lv_operator_0_0= ruleUNARY )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2671:1: (lv_operator_0_0= ruleUNARY )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2672:3: lv_operator_0_0= ruleUNARY
            {
             
            	        newCompositeNode(grammarAccess.getUnaryOperatorAccess().getOperatorUNARYEnumRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleUNARY_in_ruleUnaryOperator5908);
            lv_operator_0_0=ruleUNARY();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUnaryOperatorRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_0_0, 
                    		"UNARY");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "ruleUNARY"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2696:1: ruleUNARY returns [Enumerator current=null] : ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) ) ;
    public final Enumerator ruleUNARY() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2698:28: ( ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2699:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2699:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==38) ) {
                alt86=1;
            }
            else if ( (LA86_0==39) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2699:2: (enumLiteral_0= '-' )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2699:2: (enumLiteral_0= '-' )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2699:4: enumLiteral_0= '-'
                    {
                    enumLiteral_0=(Token)match(input,38,FOLLOW_38_in_ruleUNARY5957); 

                            current = grammarAccess.getUNARYAccess().getNEGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getUNARYAccess().getNEGEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2705:6: (enumLiteral_1= '+' )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2705:6: (enumLiteral_1= '+' )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2705:8: enumLiteral_1= '+'
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_39_in_ruleUNARY5974); 

                            current = grammarAccess.getUNARYAccess().getPLUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getUNARYAccess().getPLUSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUNARY"


    // $ANTLR start "ruleKIND"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2715:1: ruleKIND returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '+' ) ) ;
    public final Enumerator ruleKIND() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2717:28: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '+' ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2718:1: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '+' ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2718:1: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '+' ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==40) ) {
                alt87=1;
            }
            else if ( (LA87_0==39) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2718:2: (enumLiteral_0= '>' )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2718:2: (enumLiteral_0= '>' )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2718:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,40,FOLLOW_40_in_ruleKIND6019); 

                            current = grammarAccess.getKINDAccess().getFIRST_CHILDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getKINDAccess().getFIRST_CHILDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2724:6: (enumLiteral_1= '+' )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2724:6: (enumLiteral_1= '+' )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2724:8: enumLiteral_1= '+'
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_39_in_ruleKIND6036); 

                            current = grammarAccess.getKINDAccess().getSIBLINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getKINDAccess().getSIBLINGEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKIND"


    // $ANTLR start "ruleATTRIBUTE_OP"
    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2734:1: ruleATTRIBUTE_OP returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '~=' ) | (enumLiteral_2= '!=' ) ) ;
    public final Enumerator ruleATTRIBUTE_OP() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2736:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '~=' ) | (enumLiteral_2= '!=' ) ) )
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2737:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '~=' ) | (enumLiteral_2= '!=' ) )
            {
            // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2737:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '~=' ) | (enumLiteral_2= '!=' ) )
            int alt88=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt88=1;
                }
                break;
            case 42:
                {
                alt88=2;
                }
                break;
            case 43:
                {
                alt88=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2737:2: (enumLiteral_0= '=' )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2737:2: (enumLiteral_0= '=' )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2737:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_41_in_ruleATTRIBUTE_OP6081); 

                            current = grammarAccess.getATTRIBUTE_OPAccess().getEQUALSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getATTRIBUTE_OPAccess().getEQUALSEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2743:6: (enumLiteral_1= '~=' )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2743:6: (enumLiteral_1= '~=' )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2743:8: enumLiteral_1= '~='
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_42_in_ruleATTRIBUTE_OP6098); 

                            current = grammarAccess.getATTRIBUTE_OPAccess().getCONTAINSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getATTRIBUTE_OPAccess().getCONTAINSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2749:6: (enumLiteral_2= '!=' )
                    {
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2749:6: (enumLiteral_2= '!=' )
                    // ../org.eclipse.papyrus.infra.gmfdiag.css.xtext/src-gen/org/eclipse/papyrus/infra/gmfdiag/parser/antlr/internal/InternalCSS.g:2749:8: enumLiteral_2= '!='
                    {
                    enumLiteral_2=(Token)match(input,43,FOLLOW_43_in_ruleATTRIBUTE_OP6115); 

                            current = grammarAccess.getATTRIBUTE_OPAccess().getUNEQUALSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getATTRIBUTE_OPAccess().getUNEQUALSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleATTRIBUTE_OP"

    // Delegated rules


    protected DFA44 dfa44 = new DFA44(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA60 dfa60 = new DFA60(this);
    static final String DFA44_eotS =
        "\60\uffff";
    static final String DFA44_eofS =
        "\1\uffff\4\15\2\uffff\2\15\2\uffff\1\15\4\uffff\1\15\2\uffff\1"+
        "\15\4\uffff\1\15\5\uffff\1\15\6\uffff\1\15\5\uffff\1\15\4\uffff";
    static final String DFA44_minS =
        "\1\10\5\5\1\10\3\5\1\10\1\5\2\uffff\7\5\3\4\3\5\3\4\2\5\1\4\5\5"+
        "\1\4\11\5";
    static final String DFA44_maxS =
        "\1\44\4\50\2\10\2\50\2\10\1\50\2\uffff\1\10\1\53\1\50\1\10\1\53"+
        "\1\50\1\53\3\10\1\50\1\41\1\53\3\10\1\50\1\41\1\10\2\45\2\41\1\50"+
        "\1\10\2\45\2\41\1\50\1\45\1\41\1\45\1\41";
    static final String DFA44_acceptS =
        "\14\uffff\1\2\1\1\42\uffff";
    static final String DFA44_specialS =
        "\60\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\1\11\uffff\1\3\1\4\12\uffff\1\6\1\2\4\uffff\1\5",
            "\1\13\14\uffff\1\7\1\10\5\uffff\1\15\1\uffff\1\15\2\uffff"+
            "\1\12\5\uffff\1\11\2\uffff\2\14",
            "\1\13\14\uffff\1\7\1\10\5\uffff\1\15\1\uffff\1\15\2\uffff"+
            "\1\12\5\uffff\1\11\2\uffff\2\14",
            "\1\13\14\uffff\1\3\1\4\5\uffff\1\15\1\uffff\1\15\2\uffff\1"+
            "\6\5\uffff\1\5\2\uffff\2\14",
            "\1\13\14\uffff\1\3\1\4\5\uffff\1\15\1\uffff\1\15\2\uffff\1"+
            "\6\5\uffff\1\5\2\uffff\2\14",
            "\1\16\2\uffff\1\17",
            "\1\20",
            "\1\13\14\uffff\1\7\1\10\5\uffff\1\15\1\uffff\1\15\2\uffff"+
            "\1\12\5\uffff\1\11\2\uffff\2\14",
            "\1\13\14\uffff\1\7\1\10\5\uffff\1\15\1\uffff\1\15\2\uffff"+
            "\1\12\5\uffff\1\11\2\uffff\2\14",
            "\1\21\2\uffff\1\22",
            "\1\23",
            "\1\13\2\uffff\1\14\11\uffff\2\14\5\uffff\1\15\1\uffff\1\15"+
            "\2\uffff\2\14\4\uffff\1\14\2\uffff\2\14",
            "",
            "",
            "\1\16\2\uffff\1\17",
            "\1\24\37\uffff\1\30\3\uffff\1\25\1\26\1\27",
            "\1\13\14\uffff\1\3\1\4\5\uffff\1\15\1\uffff\1\15\2\uffff\1"+
            "\6\1\uffff\1\31\3\uffff\1\5\2\uffff\2\14",
            "\1\21\2\uffff\1\22",
            "\1\32\37\uffff\1\36\3\uffff\1\33\1\34\1\35",
            "\1\13\14\uffff\1\7\1\10\5\uffff\1\15\1\uffff\1\15\2\uffff"+
            "\1\12\1\uffff\1\37\3\uffff\1\11\2\uffff\2\14",
            "\1\24\37\uffff\1\30\3\uffff\1\25\1\26\1\27",
            "\1\42\1\40\2\uffff\1\41",
            "\1\42\1\40\2\uffff\1\41",
            "\1\42\1\40\2\uffff\1\41",
            "\1\13\14\uffff\1\3\1\4\5\uffff\1\15\1\uffff\1\15\2\uffff\1"+
            "\6\5\uffff\1\5\2\uffff\2\14",
            "\1\43\2\uffff\1\44\30\uffff\1\45",
            "\1\32\37\uffff\1\36\3\uffff\1\33\1\34\1\35",
            "\1\50\1\46\2\uffff\1\47",
            "\1\50\1\46\2\uffff\1\47",
            "\1\50\1\46\2\uffff\1\47",
            "\1\13\14\uffff\1\7\1\10\5\uffff\1\15\1\uffff\1\15\2\uffff"+
            "\1\12\5\uffff\1\11\2\uffff\2\14",
            "\1\51\2\uffff\1\52\30\uffff\1\53",
            "\1\42\1\40\2\uffff\1\41",
            "\1\54\37\uffff\1\30",
            "\1\54\37\uffff\1\30",
            "\1\43\2\uffff\1\44\30\uffff\1\45",
            "\1\55\33\uffff\1\45",
            "\1\13\14\uffff\1\3\1\4\5\uffff\1\15\1\uffff\1\15\2\uffff\1"+
            "\6\5\uffff\1\5\2\uffff\2\14",
            "\1\50\1\46\2\uffff\1\47",
            "\1\56\37\uffff\1\36",
            "\1\56\37\uffff\1\36",
            "\1\51\2\uffff\1\52\30\uffff\1\53",
            "\1\57\33\uffff\1\53",
            "\1\13\14\uffff\1\7\1\10\5\uffff\1\15\1\uffff\1\15\2\uffff"+
            "\1\12\5\uffff\1\11\2\uffff\2\14",
            "\1\54\37\uffff\1\30",
            "\1\55\33\uffff\1\45",
            "\1\56\37\uffff\1\36",
            "\1\57\33\uffff\1\53"
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "788:1: ( (this_SimpleSelector_0= ruleSimpleSelector (this_WS_1= RULE_WS )* ) | this_CompositeSelector_2= ruleCompositeSelector )";
        }
    }
    static final String DFA47_eotS =
        "\4\uffff";
    static final String DFA47_eofS =
        "\4\uffff";
    static final String DFA47_minS =
        "\2\5\2\uffff";
    static final String DFA47_maxS =
        "\2\50\2\uffff";
    static final String DFA47_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA47_specialS =
        "\4\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1\41\uffff\2\2",
            "\1\1\2\uffff\1\3\11\uffff\2\3\12\uffff\2\3\4\uffff\1\3\2\uffff"+
            "\2\2",
            "",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "850:2: ( (this_WS_1= RULE_WS )+ | ( (this_WS_2= RULE_WS )* ( (lv_combinator_3_0= ruleCombinator ) ) ) )";
        }
    }
    static final String DFA60_eotS =
        "\22\uffff";
    static final String DFA60_eofS =
        "\3\uffff\1\17\1\21\15\uffff";
    static final String DFA60_minS =
        "\1\4\2\12\2\4\15\uffff";
    static final String DFA60_maxS =
        "\1\47\2\12\2\47\15\uffff";
    static final String DFA60_acceptS =
        "\5\uffff\1\12\1\13\1\14\1\4\1\2\1\10\1\6\1\7\1\5\1\3\1\1\1\15\1"+
        "\11";
    static final String DFA60_specialS =
        "\22\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\5\3\uffff\1\4\1\uffff\1\3\7\uffff\1\7\17\uffff\1\6\3\uffff"+
            "\1\1\1\2",
            "\1\3",
            "\1\3",
            "\2\17\2\uffff\3\17\1\11\1\16\1\10\1\15\1\13\1\14\1\12\1\17"+
            "\4\uffff\1\17\1\uffff\1\17\2\uffff\1\17\4\uffff\3\17\2\uffff"+
            "\2\17",
            "\2\21\2\uffff\3\21\7\uffff\1\21\4\uffff\1\21\1\uffff\1\21"+
            "\2\uffff\1\21\3\uffff\1\20\3\21\2\uffff\2\21",
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
            ""
    };

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "1315:2: (this_Number_0= ruleNumber | this_Percentage_1= rulePercentage | this_Length_2= ruleLength | this_Ems_3= ruleEms | this_Exs_4= ruleExs | this_Angle_5= ruleAngle | this_Time_6= ruleTime | this_Frequency_7= ruleFrequency | this_Name_8= ruleName | this_StringValue_9= ruleStringValue | this_Uri_10= ruleUri | this_HexColor_11= ruleHexColor | this_Function_12= ruleFunction )";
        }
    }
 

    public static final BitSet FOLLOW_ruleStylesheet_in_entryRuleStylesheet75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStylesheet85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleStylesheet123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStylesheet140 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleStylesheet157 = new BitSet(new long[]{0x00000010E50C01E2L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleStylesheet171 = new BitSet(new long[]{0x00000010E50C01E2L});
    public static final BitSet FOLLOW_RULE_CDO_in_ruleStylesheet187 = new BitSet(new long[]{0x00000010E50C01E2L});
    public static final BitSet FOLLOW_RULE_CDC_in_ruleStylesheet203 = new BitSet(new long[]{0x00000010E50C01E2L});
    public static final BitSet FOLLOW_ruleImport_in_ruleStylesheet226 = new BitSet(new long[]{0x00000010E50C01C2L});
    public static final BitSet FOLLOW_RULE_CDO_in_ruleStylesheet239 = new BitSet(new long[]{0x00000010E50C01E2L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleStylesheet250 = new BitSet(new long[]{0x00000010E50C01E2L});
    public static final BitSet FOLLOW_RULE_CDC_in_ruleStylesheet270 = new BitSet(new long[]{0x00000010E50C01E2L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleStylesheet281 = new BitSet(new long[]{0x00000010E50C01E2L});
    public static final BitSet FOLLOW_ruleContent_in_ruleStylesheet309 = new BitSet(new long[]{0x00000010E40C01C2L});
    public static final BitSet FOLLOW_RULE_CDO_in_ruleStylesheet322 = new BitSet(new long[]{0x00000010E40C01E2L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleStylesheet333 = new BitSet(new long[]{0x00000010E40C01E2L});
    public static final BitSet FOLLOW_RULE_CDC_in_ruleStylesheet353 = new BitSet(new long[]{0x00000010E40C01E2L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleStylesheet364 = new BitSet(new long[]{0x00000010E40C01E2L});
    public static final BitSet FOLLOW_ruleContent_in_entryRuleContent406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContent416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleset_in_ruleContent463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMedia_in_ruleContent490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePage_in_ruleContent517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport552 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleImport599 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleImport613 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport631 = new BitSet(new long[]{0x0000000000800120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleImport655 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ruleUri_in_ruleImport675 = new BitSet(new long[]{0x0000000000800120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleImport689 = new BitSet(new long[]{0x0000000000800120L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImport708 = new BitSet(new long[]{0x0000000002800020L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleImport725 = new BitSet(new long[]{0x0000000002800020L});
    public static final BitSet FOLLOW_25_in_ruleImport739 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleImport751 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImport769 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_ruleImport790 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleImport802 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleMedia_in_entryRuleMedia839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMedia849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleMedia886 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleMedia897 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMedia913 = new BitSet(new long[]{0x000000000A000020L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleMedia930 = new BitSet(new long[]{0x000000000A000020L});
    public static final BitSet FOLLOW_25_in_ruleMedia944 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleMedia956 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMedia974 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_27_in_ruleMedia993 = new BitSet(new long[]{0x00000010D00C0120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleMedia1005 = new BitSet(new long[]{0x00000010D00C0120L});
    public static final BitSet FOLLOW_ruleRuleset_in_ruleMedia1027 = new BitSet(new long[]{0x00000010D00C0100L});
    public static final BitSet FOLLOW_28_in_ruleMedia1040 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleMedia1052 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rulePage_in_entryRulePage1089 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePage1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rulePage1145 = new BitSet(new long[]{0x0000000048000020L});
    public static final BitSet FOLLOW_RULE_WS_in_rulePage1157 = new BitSet(new long[]{0x0000000048000020L});
    public static final BitSet FOLLOW_rulePseudoPage_in_rulePage1179 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePage1192 = new BitSet(new long[]{0x0000000010800120L});
    public static final BitSet FOLLOW_RULE_WS_in_rulePage1204 = new BitSet(new long[]{0x0000000010800120L});
    public static final BitSet FOLLOW_ruleDeclaration_in_rulePage1226 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_23_in_rulePage1240 = new BitSet(new long[]{0x0000000010800120L});
    public static final BitSet FOLLOW_RULE_WS_in_rulePage1252 = new BitSet(new long[]{0x0000000010800120L});
    public static final BitSet FOLLOW_ruleDeclaration_in_rulePage1274 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_28_in_rulePage1289 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_rulePage1301 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rulePseudoPage_in_entryRulePseudoPage1338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePseudoPage1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rulePseudoPage1385 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePseudoPage1402 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_rulePseudoPage1419 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleRuleset_in_entryRuleRuleset1456 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleset1466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelector_in_ruleRuleset1512 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_25_in_ruleRuleset1525 = new BitSet(new long[]{0x00000010C00C0120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleRuleset1537 = new BitSet(new long[]{0x00000010C00C0120L});
    public static final BitSet FOLLOW_ruleSelector_in_ruleRuleset1559 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_27_in_ruleRuleset1573 = new BitSet(new long[]{0x0000000010800120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleRuleset1585 = new BitSet(new long[]{0x0000000010800120L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleRuleset1607 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_23_in_ruleRuleset1621 = new BitSet(new long[]{0x0000000010800120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleRuleset1633 = new BitSet(new long[]{0x0000000010800120L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleRuleset1655 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_28_in_ruleRuleset1670 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleRuleset1682 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleSelector_in_entryRuleSelector1719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelector1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleSelector_in_ruleSelector1777 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleSelector1788 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleCompositeSelector_in_ruleSelector1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeSelector_in_entryRuleCompositeSelector1853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeSelector1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleSelector_in_ruleCompositeSelector1909 = new BitSet(new long[]{0x0000018000000020L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleCompositeSelector1922 = new BitSet(new long[]{0x00000010C00C0120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleCompositeSelector1942 = new BitSet(new long[]{0x0000018000000020L});
    public static final BitSet FOLLOW_ruleCombinator_in_ruleCompositeSelector1964 = new BitSet(new long[]{0x00000010C00C0100L});
    public static final BitSet FOLLOW_ruleSelector_in_ruleCompositeSelector1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleSelector_in_entryRuleSimpleSelector2023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleSelector2033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleSelector2078 = new BitSet(new long[]{0x00000010C00C0102L});
    public static final BitSet FOLLOW_31_in_ruleSimpleSelector2099 = new BitSet(new long[]{0x00000010C00C0102L});
    public static final BitSet FOLLOW_ruleSelectorCondition_in_ruleSimpleSelector2136 = new BitSet(new long[]{0x00000010C00C0102L});
    public static final BitSet FOLLOW_ruleSelectorCondition_in_ruleSimpleSelector2165 = new BitSet(new long[]{0x00000010C00C0102L});
    public static final BitSet FOLLOW_ruleSelectorCondition_in_entryRuleSelectorCondition2202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectorCondition2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCSSId_in_ruleSelectorCondition2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClass_in_ruleSelectorCondition2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleSelectorCondition2313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePseudo_in_ruleSelectorCondition2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCombinator_in_entryRuleCombinator2375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCombinator2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKIND_in_ruleCombinator2431 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleCombinator2443 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration2480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration2490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclaration2532 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleDeclaration2549 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_30_in_ruleDeclaration2562 = new BitSet(new long[]{0x000000C400040530L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleDeclaration2574 = new BitSet(new long[]{0x000000C400040530L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDeclaration2596 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_T_IMPORTANT_in_ruleDeclaration2614 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleDeclaration2631 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleExpression2726 = new BitSet(new long[]{0x000000CC02040532L});
    public static final BitSet FOLLOW_ruleSubterm_in_ruleExpression2747 = new BitSet(new long[]{0x000000CC02040532L});
    public static final BitSet FOLLOW_ruleSubterm_in_entryRuleSubterm2784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubterm2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_ruleSubterm2840 = new BitSet(new long[]{0x000000C400040530L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleSubterm2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm2898 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleTerm2956 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rulePercentage_in_ruleTerm2983 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleLength_in_ruleTerm3010 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleEms_in_ruleTerm3037 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleExs_in_ruleTerm3064 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleAngle_in_ruleTerm3091 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleTime_in_ruleTerm3118 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleFrequency_in_ruleTerm3145 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleName_in_ruleTerm3172 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleStringValue_in_ruleTerm3199 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleUri_in_ruleTerm3226 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleHexColor_in_ruleTerm3253 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleTerm3280 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleTerm3292 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction3329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction3339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction3381 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleFunction3398 = new BitSet(new long[]{0x000000C400040530L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleFunction3410 = new BitSet(new long[]{0x000000C400040530L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunction3432 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleFunction3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName3480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName3490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleName3531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber3571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber3581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleNumber3627 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_T_NUM_in_ruleNumber3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePercentage_in_entryRulePercentage3686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePercentage3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_rulePercentage3742 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_T_NUM_in_rulePercentage3760 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RULE_PC_UNIT_in_rulePercentage3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLength_in_entryRuleLength3823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLength3833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleLength3879 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_T_NUM_in_ruleLength3897 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_LEN_UNIT_in_ruleLength3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEms_in_entryRuleEms3960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEms3970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleEms4016 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_T_NUM_in_ruleEms4034 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_EM_UNIT_in_ruleEms4056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExs_in_entryRuleExs4097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExs4107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleExs4153 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_T_NUM_in_ruleExs4171 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_EX_UNIT_in_ruleExs4193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAngle_in_entryRuleAngle4234 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAngle4244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleAngle4290 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_T_NUM_in_ruleAngle4308 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RULE_ANGLE_UNIT_in_ruleAngle4330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTime_in_entryRuleTime4371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTime4381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleTime4427 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_T_NUM_in_ruleTime4445 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_TIME_UNIT_in_ruleTime4467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFrequency_in_entryRuleFrequency4508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFrequency4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleFrequency4564 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_T_NUM_in_ruleFrequency4582 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_FREQ_UNIT_in_ruleFrequency4604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUri_in_entryRuleUri4645 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUri4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleUri4692 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleUri4704 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUri4722 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleUri4739 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleUri4752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue4788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue4798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringValue4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHexColor_in_entryRuleHexColor4879 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHexColor4889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HASH_in_ruleHexColor4930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_entryRuleOperator4971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperator4982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOperator5021 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleOperator5037 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_25_in_ruleOperator5065 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleOperator5081 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleClass_in_entryRuleClass5129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClass5139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_T_CLASS_in_ruleClass5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute5220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAttribute5267 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleAttribute5279 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute5297 = new BitSet(new long[]{0x00000E2000000020L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleAttribute5314 = new BitSet(new long[]{0x00000E2000000020L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_ruleAttribute5336 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleAttribute5349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue5385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeValue5395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATTRIBUTE_OP_in_ruleAttributeValue5441 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleAttributeValue5453 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeValue5473 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAttributeValue5493 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleAttributeValue5513 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rulePseudo_in_entryRulePseudo5550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePseudo5560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rulePseudo5597 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePseudo5615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePseudo5644 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_rulePseudo5661 = new BitSet(new long[]{0x0000000200000120L});
    public static final BitSet FOLLOW_RULE_WS_in_rulePseudo5673 = new BitSet(new long[]{0x0000000200000120L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePseudo5692 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_RULE_WS_in_rulePseudo5709 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_33_in_rulePseudo5724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCSSId_in_entryRuleCSSId5762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCSSId5772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HASH_in_ruleCSSId5813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator5853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator5863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUNARY_in_ruleUnaryOperator5908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleUNARY5957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleUNARY5974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleKIND6019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleKIND6036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleATTRIBUTE_OP6081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleATTRIBUTE_OP6098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleATTRIBUTE_OP6115 = new BitSet(new long[]{0x0000000000000002L});

}