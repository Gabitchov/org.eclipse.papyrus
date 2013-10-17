package org.eclipse.papyrus.uml.textedit.port.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlPortParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_INTEGER_VALUE", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'/'", "':'", "'~'", "'<Undefined>'", "'::'", "'['", "'..'", "']'", "'*'", "'{'", "','", "'}'", "'redefines'", "'subsets'", "'='", "'+'", "'-'", "'#'", "'readOnly'", "'union'", "'ordered'", "'unique'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_INTEGER_VALUE=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalUmlPortParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlPortParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlPortParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g"; }



     	private UmlPortGrammarAccess grammarAccess;
     	
        public InternalUmlPortParser(TokenStream input, UmlPortGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "PortRule";	
       	}
       	
       	@Override
       	protected UmlPortGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRulePortRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:68:1: entryRulePortRule returns [EObject current=null] : iv_rulePortRule= rulePortRule EOF ;
    public final EObject entryRulePortRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:69:2: (iv_rulePortRule= rulePortRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:70:2: iv_rulePortRule= rulePortRule EOF
            {
             newCompositeNode(grammarAccess.getPortRuleRule()); 
            pushFollow(FOLLOW_rulePortRule_in_entryRulePortRule75);
            iv_rulePortRule=rulePortRule();

            state._fsp--;

             current =iv_rulePortRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortRule85); 

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
    // $ANTLR end "entryRulePortRule"


    // $ANTLR start "rulePortRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:77:1: rulePortRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_isConjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | otherlv_6= '<Undefined>' ) ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? ) ;
    public final EObject rulePortRule() throws RecognitionException {
        EObject current = null;

        Token lv_isDerived_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_isConjugated_4_0=null;
        Token otherlv_6=null;
        Enumerator lv_visibility_0_0 = null;

        EObject lv_type_5_0 = null;

        EObject lv_multiplicity_7_0 = null;

        EObject lv_modifiers_8_0 = null;

        EObject lv_default_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:80:28: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_isConjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | otherlv_6= '<Undefined>' ) ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_isConjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | otherlv_6= '<Undefined>' ) ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_isConjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | otherlv_6= '<Undefined>' ) ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_isConjugated_4_0= '~' ) )? ( ( (lv_type_5_0= ruleTypeRule ) ) | otherlv_6= '<Undefined>' ) ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )? ( (lv_modifiers_8_0= ruleModifiersRule ) )? ( (lv_default_9_0= ruleDefaultValueRule ) )?
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:83:3: lv_visibility_0_0= ruleVisibilityKind
            {
             
            	        newCompositeNode(grammarAccess.getPortRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVisibilityKind_in_rulePortRule131);
            lv_visibility_0_0=ruleVisibilityKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPortRuleRule());
            	        }
                   		set(
                   			current, 
                   			"visibility",
                    		lv_visibility_0_0, 
                    		"VisibilityKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:99:2: ( (lv_isDerived_1_0= '/' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:100:1: (lv_isDerived_1_0= '/' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:100:1: (lv_isDerived_1_0= '/' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:101:3: lv_isDerived_1_0= '/'
                    {
                    lv_isDerived_1_0=(Token)match(input,12,FOLLOW_12_in_rulePortRule149); 

                            newLeafNode(lv_isDerived_1_0, grammarAccess.getPortRuleAccess().getIsDerivedSolidusKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRuleRule());
                    	        }
                           		setWithLastConsumed(current, "isDerived", lv_isDerived_1_0, "/");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:114:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:115:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:115:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:116:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortRule180); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPortRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_rulePortRule197); 

                	newLeafNode(otherlv_3, grammarAccess.getPortRuleAccess().getColonKeyword_3());
                
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:136:1: ( (lv_isConjugated_4_0= '~' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:137:1: (lv_isConjugated_4_0= '~' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:137:1: (lv_isConjugated_4_0= '~' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:138:3: lv_isConjugated_4_0= '~'
                    {
                    lv_isConjugated_4_0=(Token)match(input,14,FOLLOW_14_in_rulePortRule215); 

                            newLeafNode(lv_isConjugated_4_0, grammarAccess.getPortRuleAccess().getIsConjugatedTildeKeyword_4_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPortRuleRule());
                    	        }
                           		setWithLastConsumed(current, "isConjugated", lv_isConjugated_4_0, "~");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:151:3: ( ( (lv_type_5_0= ruleTypeRule ) ) | otherlv_6= '<Undefined>' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:151:4: ( (lv_type_5_0= ruleTypeRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:151:4: ( (lv_type_5_0= ruleTypeRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:152:1: (lv_type_5_0= ruleTypeRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:152:1: (lv_type_5_0= ruleTypeRule )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:153:3: lv_type_5_0= ruleTypeRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortRuleAccess().getTypeTypeRuleParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRule_in_rulePortRule251);
                    lv_type_5_0=ruleTypeRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_5_0, 
                            		"TypeRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:170:7: otherlv_6= '<Undefined>'
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_15_in_rulePortRule269); 

                        	newLeafNode(otherlv_6, grammarAccess.getPortRuleAccess().getUndefinedKeyword_5_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:174:2: ( (lv_multiplicity_7_0= ruleMultiplicityRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:175:1: (lv_multiplicity_7_0= ruleMultiplicityRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:175:1: (lv_multiplicity_7_0= ruleMultiplicityRule )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:176:3: lv_multiplicity_7_0= ruleMultiplicityRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiplicityRule_in_rulePortRule291);
                    lv_multiplicity_7_0=ruleMultiplicityRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_7_0, 
                            		"MultiplicityRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:192:3: ( (lv_modifiers_8_0= ruleModifiersRule ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:193:1: (lv_modifiers_8_0= ruleModifiersRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:193:1: (lv_modifiers_8_0= ruleModifiersRule )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:194:3: lv_modifiers_8_0= ruleModifiersRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortRuleAccess().getModifiersModifiersRuleParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModifiersRule_in_rulePortRule313);
                    lv_modifiers_8_0=ruleModifiersRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"modifiers",
                            		lv_modifiers_8_0, 
                            		"ModifiersRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:210:3: ( (lv_default_9_0= ruleDefaultValueRule ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:211:1: (lv_default_9_0= ruleDefaultValueRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:211:1: (lv_default_9_0= ruleDefaultValueRule )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:212:3: lv_default_9_0= ruleDefaultValueRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortRuleAccess().getDefaultDefaultValueRuleParserRuleCall_8_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDefaultValueRule_in_rulePortRule335);
                    lv_default_9_0=ruleDefaultValueRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"default",
                            		lv_default_9_0, 
                            		"DefaultValueRule");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "rulePortRule"


    // $ANTLR start "entryRuleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:236:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:237:2: (iv_ruleTypeRule= ruleTypeRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:238:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
             newCompositeNode(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule372);
            iv_ruleTypeRule=ruleTypeRule();

            state._fsp--;

             current =iv_ruleTypeRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule382); 

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
    // $ANTLR end "entryRuleTypeRule"


    // $ANTLR start "ruleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:245:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:248:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:249:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:249:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:249:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:249:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==16) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:250:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:250:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:251:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeRule428);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_0_0, 
                            		"QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:267:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:268:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:268:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:269:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRule449); 

            		newLeafNode(otherlv_1, grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleTypeRule"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:288:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:289:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:290:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName485);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName495); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:297:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_remaining_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:300:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:301:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:301:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:301:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:301:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:302:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:302:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:303:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName540); 

            		newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleQualifiedName552); 

                	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
                
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:318:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==16) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:319:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:319:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:320:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName573);
                    lv_remaining_2_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
                    	        }
                           		set(
                           			current, 
                           			"remaining",
                            		lv_remaining_2_0, 
                            		"QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleMultiplicityRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:344:1: entryRuleMultiplicityRule returns [EObject current=null] : iv_ruleMultiplicityRule= ruleMultiplicityRule EOF ;
    public final EObject entryRuleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:345:2: (iv_ruleMultiplicityRule= ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:346:2: iv_ruleMultiplicityRule= ruleMultiplicityRule EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule610);
            iv_ruleMultiplicityRule=ruleMultiplicityRule();

            state._fsp--;

             current =iv_ruleMultiplicityRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule620); 

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
    // $ANTLR end "entryRuleMultiplicityRule"


    // $ANTLR start "ruleMultiplicityRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:353:1: ruleMultiplicityRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_bounds_1_0 = null;

        EObject lv_bounds_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:356:28: ( (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:357:1: (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:357:1: (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:357:3: otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleMultiplicityRule657); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:361:1: ( (lv_bounds_1_0= ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:362:1: (lv_bounds_1_0= ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:362:1: (lv_bounds_1_0= ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:363:3: lv_bounds_1_0= ruleBoundSpecification
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule678);
            lv_bounds_1_0=ruleBoundSpecification();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiplicityRuleRule());
            	        }
                   		add(
                   			current, 
                   			"bounds",
                    		lv_bounds_1_0, 
                    		"BoundSpecification");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:379:2: (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:379:4: otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleMultiplicityRule691); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:383:1: ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:384:1: (lv_bounds_3_0= ruleBoundSpecification )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:384:1: (lv_bounds_3_0= ruleBoundSpecification )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:385:3: lv_bounds_3_0= ruleBoundSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule712);
                    lv_bounds_3_0=ruleBoundSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMultiplicityRuleRule());
                    	        }
                           		add(
                           			current, 
                           			"bounds",
                            		lv_bounds_3_0, 
                            		"BoundSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleMultiplicityRule726); 

                	newLeafNode(otherlv_4, grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3());
                

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
    // $ANTLR end "ruleMultiplicityRule"


    // $ANTLR start "entryRuleBoundSpecification"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:413:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
    public final EObject entryRuleBoundSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundSpecification = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:414:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:415:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
            {
             newCompositeNode(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification762);
            iv_ruleBoundSpecification=ruleBoundSpecification();

            state._fsp--;

             current =iv_ruleBoundSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification772); 

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
    // $ANTLR end "entryRuleBoundSpecification"


    // $ANTLR start "ruleBoundSpecification"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:422:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleUnlimitedLiteral ) ) ;
    public final EObject ruleBoundSpecification() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:425:28: ( ( (lv_value_0_0= ruleUnlimitedLiteral ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:426:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:426:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:427:1: (lv_value_0_0= ruleUnlimitedLiteral )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:427:1: (lv_value_0_0= ruleUnlimitedLiteral )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:428:3: lv_value_0_0= ruleUnlimitedLiteral
            {
             
            	        newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_ruleBoundSpecification817);
            lv_value_0_0=ruleUnlimitedLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBoundSpecificationRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"UnlimitedLiteral");
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
    // $ANTLR end "ruleBoundSpecification"


    // $ANTLR start "entryRuleUnlimitedLiteral"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:452:1: entryRuleUnlimitedLiteral returns [String current=null] : iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF ;
    public final String entryRuleUnlimitedLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnlimitedLiteral = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:453:2: (iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:454:2: iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF
            {
             newCompositeNode(grammarAccess.getUnlimitedLiteralRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral853);
            iv_ruleUnlimitedLiteral=ruleUnlimitedLiteral();

            state._fsp--;

             current =iv_ruleUnlimitedLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteral864); 

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
    // $ANTLR end "entryRuleUnlimitedLiteral"


    // $ANTLR start "ruleUnlimitedLiteral"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:461:1: ruleUnlimitedLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUnlimitedLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:464:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:465:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:465:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT) ) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:465:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleUnlimitedLiteral904); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:474:2: kw= '*'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleUnlimitedLiteral928); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnlimitedLiteralAccess().getAsteriskKeyword_1()); 
                        

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
    // $ANTLR end "ruleUnlimitedLiteral"


    // $ANTLR start "entryRuleModifiersRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:487:1: entryRuleModifiersRule returns [EObject current=null] : iv_ruleModifiersRule= ruleModifiersRule EOF ;
    public final EObject entryRuleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifiersRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:488:2: (iv_ruleModifiersRule= ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:489:2: iv_ruleModifiersRule= ruleModifiersRule EOF
            {
             newCompositeNode(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule968);
            iv_ruleModifiersRule=ruleModifiersRule();

            state._fsp--;

             current =iv_ruleModifiersRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule978); 

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
    // $ANTLR end "entryRuleModifiersRule"


    // $ANTLR start "ruleModifiersRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:496:1: ruleModifiersRule returns [EObject current=null] : (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' ) ;
    public final EObject ruleModifiersRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:499:28: ( (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:500:1: (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:500:1: (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:500:3: otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleModifiersRule1015); 

                	newLeafNode(otherlv_0, grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:504:1: ( (lv_values_1_0= ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:505:1: (lv_values_1_0= ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:505:1: (lv_values_1_0= ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:506:3: lv_values_1_0= ruleModifierSpecification
            {
             
            	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1036);
            lv_values_1_0=ruleModifierSpecification();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModifiersRuleRule());
            	        }
                   		add(
                   			current, 
                   			"values",
                    		lv_values_1_0, 
                    		"ModifierSpecification");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:522:2: (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==22) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:522:4: otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleModifiersRule1049); 

            	        	newLeafNode(otherlv_2, grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:526:1: ( (lv_values_3_0= ruleModifierSpecification ) )
            	    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:527:1: (lv_values_3_0= ruleModifierSpecification )
            	    {
            	    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:527:1: (lv_values_3_0= ruleModifierSpecification )
            	    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:528:3: lv_values_3_0= ruleModifierSpecification
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1070);
            	    lv_values_3_0=ruleModifierSpecification();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModifiersRuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_3_0, 
            	            		"ModifierSpecification");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleModifiersRule1084); 

                	newLeafNode(otherlv_4, grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleModifiersRule"


    // $ANTLR start "entryRuleModifierSpecification"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:556:1: entryRuleModifierSpecification returns [EObject current=null] : iv_ruleModifierSpecification= ruleModifierSpecification EOF ;
    public final EObject entryRuleModifierSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierSpecification = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:557:2: (iv_ruleModifierSpecification= ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:558:2: iv_ruleModifierSpecification= ruleModifierSpecification EOF
            {
             newCompositeNode(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification1120);
            iv_ruleModifierSpecification=ruleModifierSpecification();

            state._fsp--;

             current =iv_ruleModifierSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification1130); 

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
    // $ANTLR end "entryRuleModifierSpecification"


    // $ANTLR start "ruleModifierSpecification"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:565:1: ruleModifierSpecification returns [EObject current=null] : ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) ;
    public final EObject ruleModifierSpecification() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;

        EObject lv_redefines_1_0 = null;

        EObject lv_subsets_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:568:28: ( ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:569:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:569:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt12=1;
                }
                break;
            case 24:
                {
                alt12=2;
                }
                break;
            case 25:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:569:2: ( (lv_value_0_0= ruleModifierKind ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:569:2: ( (lv_value_0_0= ruleModifierKind ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:570:1: (lv_value_0_0= ruleModifierKind )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:570:1: (lv_value_0_0= ruleModifierKind )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:571:3: lv_value_0_0= ruleModifierKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModifierKind_in_ruleModifierSpecification1176);
                    lv_value_0_0=ruleModifierKind();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_0_0, 
                            		"ModifierKind");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:588:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:588:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:589:1: (lv_redefines_1_0= ruleRedefinesRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:589:1: (lv_redefines_1_0= ruleRedefinesRule )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:590:3: lv_redefines_1_0= ruleRedefinesRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRedefinesRule_in_ruleModifierSpecification1203);
                    lv_redefines_1_0=ruleRedefinesRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"redefines",
                            		lv_redefines_1_0, 
                            		"RedefinesRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:607:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:607:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:608:1: (lv_subsets_2_0= ruleSubsetsRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:608:1: (lv_subsets_2_0= ruleSubsetsRule )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:609:3: lv_subsets_2_0= ruleSubsetsRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSubsetsRule_in_ruleModifierSpecification1230);
                    lv_subsets_2_0=ruleSubsetsRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifierSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"subsets",
                            		lv_subsets_2_0, 
                            		"SubsetsRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleModifierSpecification"


    // $ANTLR start "entryRuleRedefinesRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:633:1: entryRuleRedefinesRule returns [EObject current=null] : iv_ruleRedefinesRule= ruleRedefinesRule EOF ;
    public final EObject entryRuleRedefinesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRedefinesRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:634:2: (iv_ruleRedefinesRule= ruleRedefinesRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:635:2: iv_ruleRedefinesRule= ruleRedefinesRule EOF
            {
             newCompositeNode(grammarAccess.getRedefinesRuleRule()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule1266);
            iv_ruleRedefinesRule=ruleRedefinesRule();

            state._fsp--;

             current =iv_ruleRedefinesRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRedefinesRule1276); 

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
    // $ANTLR end "entryRuleRedefinesRule"


    // $ANTLR start "ruleRedefinesRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:642:1: ruleRedefinesRule returns [EObject current=null] : (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRedefinesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:645:28: ( (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:646:1: (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:646:1: (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:646:3: otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleRedefinesRule1313); 

                	newLeafNode(otherlv_0, grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:650:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:651:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:651:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:652:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRedefinesRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRedefinesRule1333); 

            		newLeafNode(otherlv_1, grammarAccess.getRedefinesRuleAccess().getPortPortCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleRedefinesRule"


    // $ANTLR start "entryRuleSubsetsRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:671:1: entryRuleSubsetsRule returns [EObject current=null] : iv_ruleSubsetsRule= ruleSubsetsRule EOF ;
    public final EObject entryRuleSubsetsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubsetsRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:672:2: (iv_ruleSubsetsRule= ruleSubsetsRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:673:2: iv_ruleSubsetsRule= ruleSubsetsRule EOF
            {
             newCompositeNode(grammarAccess.getSubsetsRuleRule()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule1369);
            iv_ruleSubsetsRule=ruleSubsetsRule();

            state._fsp--;

             current =iv_ruleSubsetsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubsetsRule1379); 

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
    // $ANTLR end "entryRuleSubsetsRule"


    // $ANTLR start "ruleSubsetsRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:680:1: ruleSubsetsRule returns [EObject current=null] : (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleSubsetsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:683:28: ( (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:684:1: (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:684:1: (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:684:3: otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleSubsetsRule1416); 

                	newLeafNode(otherlv_0, grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:688:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:689:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:689:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:690:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubsetsRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubsetsRule1436); 

            		newLeafNode(otherlv_1, grammarAccess.getSubsetsRuleAccess().getPortPortCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleSubsetsRule"


    // $ANTLR start "entryRuleDefaultValueRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:709:1: entryRuleDefaultValueRule returns [EObject current=null] : iv_ruleDefaultValueRule= ruleDefaultValueRule EOF ;
    public final EObject entryRuleDefaultValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultValueRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:710:2: (iv_ruleDefaultValueRule= ruleDefaultValueRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:711:2: iv_ruleDefaultValueRule= ruleDefaultValueRule EOF
            {
             newCompositeNode(grammarAccess.getDefaultValueRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule1472);
            iv_ruleDefaultValueRule=ruleDefaultValueRule();

            state._fsp--;

             current =iv_ruleDefaultValueRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultValueRule1482); 

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
    // $ANTLR end "entryRuleDefaultValueRule"


    // $ANTLR start "ruleDefaultValueRule"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:718:1: ruleDefaultValueRule returns [EObject current=null] : (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleDefaultValueRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_default_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:721:28: ( (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:722:1: (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:722:1: (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:722:3: otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleDefaultValueRule1519); 

                	newLeafNode(otherlv_0, grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:726:1: ( (lv_default_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:727:1: (lv_default_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:727:1: (lv_default_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:728:3: lv_default_1_0= RULE_STRING
            {
            lv_default_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDefaultValueRule1536); 

            			newLeafNode(lv_default_1_0, grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDefaultValueRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"default",
                    		lv_default_1_0, 
                    		"STRING");
            	    

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
    // $ANTLR end "ruleDefaultValueRule"


    // $ANTLR start "ruleVisibilityKind"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:752:1: ruleVisibilityKind returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) ;
    public final Enumerator ruleVisibilityKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:754:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:755:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:755:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt13=1;
                }
                break;
            case 28:
                {
                alt13=2;
                }
                break;
            case 29:
                {
                alt13=3;
                }
                break;
            case 14:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:755:2: (enumLiteral_0= '+' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:755:2: (enumLiteral_0= '+' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:755:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,27,FOLLOW_27_in_ruleVisibilityKind1591); 

                            current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:761:6: (enumLiteral_1= '-' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:761:6: (enumLiteral_1= '-' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:761:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,28,FOLLOW_28_in_ruleVisibilityKind1608); 

                            current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:767:6: (enumLiteral_2= '#' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:767:6: (enumLiteral_2= '#' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:767:8: enumLiteral_2= '#'
                    {
                    enumLiteral_2=(Token)match(input,29,FOLLOW_29_in_ruleVisibilityKind1625); 

                            current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:773:6: (enumLiteral_3= '~' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:773:6: (enumLiteral_3= '~' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:773:8: enumLiteral_3= '~'
                    {
                    enumLiteral_3=(Token)match(input,14,FOLLOW_14_in_ruleVisibilityKind1642); 

                            current = grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleVisibilityKind"


    // $ANTLR start "ruleModifierKind"
    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:783:1: ruleModifierKind returns [Enumerator current=null] : ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) ;
    public final Enumerator ruleModifierKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:785:28: ( ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:786:1: ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:786:1: ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt14=1;
                }
                break;
            case 31:
                {
                alt14=2;
                }
                break;
            case 32:
                {
                alt14=3;
                }
                break;
            case 33:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:786:2: (enumLiteral_0= 'readOnly' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:786:2: (enumLiteral_0= 'readOnly' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:786:4: enumLiteral_0= 'readOnly'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_30_in_ruleModifierKind1687); 

                            current = grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:792:6: (enumLiteral_1= 'union' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:792:6: (enumLiteral_1= 'union' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:792:8: enumLiteral_1= 'union'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_31_in_ruleModifierKind1704); 

                            current = grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:798:6: (enumLiteral_2= 'ordered' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:798:6: (enumLiteral_2= 'ordered' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:798:8: enumLiteral_2= 'ordered'
                    {
                    enumLiteral_2=(Token)match(input,32,FOLLOW_32_in_ruleModifierKind1721); 

                            current = grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:804:6: (enumLiteral_3= 'unique' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:804:6: (enumLiteral_3= 'unique' )
                    // ../org.eclipse.papyrus.uml.textedit.port.xtext/src-gen/org/eclipse/papyrus/uml/textedit/port/xtext/parser/antlr/internal/InternalUmlPort.g:804:8: enumLiteral_3= 'unique'
                    {
                    enumLiteral_3=(Token)match(input,33,FOLLOW_33_in_ruleModifierKind1738); 

                            current = grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleModifierKind"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePortRule_in_entryRulePortRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rulePortRule131 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_rulePortRule149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortRule180 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePortRule197 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_14_in_rulePortRule215 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rulePortRule251 = new BitSet(new long[]{0x0000000004220002L});
    public static final BitSet FOLLOW_15_in_rulePortRule269 = new BitSet(new long[]{0x0000000004220002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rulePortRule291 = new BitSet(new long[]{0x0000000004200002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rulePortRule313 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_rulePortRule335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule372 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeRule428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRule449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName540 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleQualifiedName552 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleMultiplicityRule657 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule678 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleMultiplicityRule691 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule712 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleMultiplicityRule726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_ruleBoundSpecification817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteral864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleUnlimitedLiteral904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleUnlimitedLiteral928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleModifiersRule1015 = new BitSet(new long[]{0x00000003C3000000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1036 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_ruleModifiersRule1049 = new BitSet(new long[]{0x00000003C3000000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1070 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_ruleModifiersRule1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification1120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_ruleModifierSpecification1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_ruleModifierSpecification1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_ruleModifierSpecification1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule1266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRedefinesRule1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleRedefinesRule1313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRedefinesRule1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule1369 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubsetsRule1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleSubsetsRule1416 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubsetsRule1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule1472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultValueRule1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleDefaultValueRule1519 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDefaultValueRule1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVisibilityKind1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVisibilityKind1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleVisibilityKind1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleVisibilityKind1642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleModifierKind1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleModifierKind1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleModifierKind1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleModifierKind1738 = new BitSet(new long[]{0x0000000000000002L});

}