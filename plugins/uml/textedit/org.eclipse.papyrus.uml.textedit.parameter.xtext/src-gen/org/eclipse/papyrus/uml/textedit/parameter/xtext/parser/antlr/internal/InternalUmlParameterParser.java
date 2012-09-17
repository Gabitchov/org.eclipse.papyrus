package org.eclipse.papyrus.uml.textedit.parameter.xtext.parser.antlr.internal; 

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.parameter.xtext.services.UmlParameterGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;

@SuppressWarnings("all")
public class InternalUmlParameterParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'<Undefined>'", "'{'", "','", "'}'", "'effect: '", "'::'", "'['", "'..'", "']'", "'*'", "'exception'", "'stream'", "'ordered'", "'unique'", "'create'", "'read'", "'update'", "'delete'", "'+'", "'-'", "'#'", "'~'", "'in'", "'out'", "'inout'", "'return'"
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
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalUmlParameterParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlParameterParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlParameterParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g"; }



     	private UmlParameterGrammarAccess grammarAccess;
     	
        public InternalUmlParameterParser(TokenStream input, UmlParameterGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ParameterRule";	
       	}
       	
       	@Override
       	protected UmlParameterGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleParameterRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:68:1: entryRuleParameterRule returns [EObject current=null] : iv_ruleParameterRule= ruleParameterRule EOF ;
    public final EObject entryRuleParameterRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:69:2: (iv_ruleParameterRule= ruleParameterRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:70:2: iv_ruleParameterRule= ruleParameterRule EOF
            {
             newCompositeNode(grammarAccess.getParameterRuleRule()); 
            pushFollow(FOLLOW_ruleParameterRule_in_entryRuleParameterRule75);
            iv_ruleParameterRule=ruleParameterRule();

            state._fsp--;

             current =iv_ruleParameterRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterRule85); 

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
    // $ANTLR end "entryRuleParameterRule"


    // $ANTLR start "ruleParameterRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:77:1: ruleParameterRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) ) ) ;
    public final EObject ruleParameterRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_visibility_0_0 = null;

        Enumerator lv_direction_1_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_multiplicity_6_0 = null;

        EObject lv_modifiers_7_0 = null;

        EObject lv_effect_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:80:28: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_direction_1_0= ruleDirection ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_effect_8_0= ruleEffectRule ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:83:3: lv_visibility_0_0= ruleVisibilityKind
            {
             
            	        newCompositeNode(grammarAccess.getParameterRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVisibilityKind_in_ruleParameterRule131);
            lv_visibility_0_0=ruleVisibilityKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRuleRule());
            	        }
                   		set(
                   			current, 
                   			"visibility",
                    		lv_visibility_0_0, 
                    		"VisibilityKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:99:2: ( (lv_direction_1_0= ruleDirection ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:100:1: (lv_direction_1_0= ruleDirection )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:100:1: (lv_direction_1_0= ruleDirection )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:101:3: lv_direction_1_0= ruleDirection
            {
             
            	        newCompositeNode(grammarAccess.getParameterRuleAccess().getDirectionDirectionEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDirection_in_ruleParameterRule152);
            lv_direction_1_0=ruleDirection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRuleRule());
            	        }
                   		set(
                   			current, 
                   			"direction",
                    		lv_direction_1_0, 
                    		"Direction");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:117:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:118:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:118:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:119:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameterRule169); 

            			newLeafNode(lv_name_2_0, grammarAccess.getParameterRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,11,FOLLOW_11_in_ruleParameterRule186); 

                	newLeafNode(otherlv_3, grammarAccess.getParameterRuleAccess().getColonKeyword_3());
                
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:139:1: ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:139:2: ( (lv_type_4_0= ruleTypeRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:139:2: ( (lv_type_4_0= ruleTypeRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:140:1: (lv_type_4_0= ruleTypeRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:140:1: (lv_type_4_0= ruleTypeRule )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:141:3: lv_type_4_0= ruleTypeRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRule_in_ruleParameterRule208);
                    lv_type_4_0=ruleTypeRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParameterRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"TypeRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:158:7: otherlv_5= '<Undefined>'
                    {
                    otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleParameterRule226); 

                        	newLeafNode(otherlv_5, grammarAccess.getParameterRuleAccess().getUndefinedKeyword_4_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:162:2: ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:163:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:163:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:164:3: lv_multiplicity_6_0= ruleMultiplicityRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getParameterRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiplicityRule_in_ruleParameterRule248);
                    lv_multiplicity_6_0=ruleMultiplicityRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParameterRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_6_0, 
                            		"MultiplicityRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:180:3: ( (lv_modifiers_7_0= ruleModifiersRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                int LA3_1 = input.LA(2);

                if ( ((LA3_1>=22 && LA3_1<=25)) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:181:1: (lv_modifiers_7_0= ruleModifiersRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:181:1: (lv_modifiers_7_0= ruleModifiersRule )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:182:3: lv_modifiers_7_0= ruleModifiersRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getParameterRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModifiersRule_in_ruleParameterRule270);
                    lv_modifiers_7_0=ruleModifiersRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParameterRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"modifiers",
                            		lv_modifiers_7_0, 
                            		"ModifiersRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:198:3: ( (lv_effect_8_0= ruleEffectRule ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:199:1: (lv_effect_8_0= ruleEffectRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:199:1: (lv_effect_8_0= ruleEffectRule )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:200:3: lv_effect_8_0= ruleEffectRule
            {
             
            	        newCompositeNode(grammarAccess.getParameterRuleAccess().getEffectEffectRuleParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleEffectRule_in_ruleParameterRule292);
            lv_effect_8_0=ruleEffectRule();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRuleRule());
            	        }
                   		set(
                   			current, 
                   			"effect",
                    		lv_effect_8_0, 
                    		"EffectRule");
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
    // $ANTLR end "ruleParameterRule"


    // $ANTLR start "entryRuleModifiersRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:224:1: entryRuleModifiersRule returns [EObject current=null] : iv_ruleModifiersRule= ruleModifiersRule EOF ;
    public final EObject entryRuleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifiersRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:225:2: (iv_ruleModifiersRule= ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:226:2: iv_ruleModifiersRule= ruleModifiersRule EOF
            {
             newCompositeNode(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule328);
            iv_ruleModifiersRule=ruleModifiersRule();

            state._fsp--;

             current =iv_ruleModifiersRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule338); 

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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:233:1: ruleModifiersRule returns [EObject current=null] : (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' ) ;
    public final EObject ruleModifiersRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:236:28: ( (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:237:1: (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:237:1: (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:237:3: otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleModifiersRule375); 

                	newLeafNode(otherlv_0, grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:241:1: ( (lv_values_1_0= ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:242:1: (lv_values_1_0= ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:242:1: (lv_values_1_0= ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:243:3: lv_values_1_0= ruleModifierSpecification
            {
             
            	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule396);
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

            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:259:2: (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:259:4: otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) )
            	    {
            	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleModifiersRule409); 

            	        	newLeafNode(otherlv_2, grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:263:1: ( (lv_values_3_0= ruleModifierSpecification ) )
            	    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:264:1: (lv_values_3_0= ruleModifierSpecification )
            	    {
            	    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:264:1: (lv_values_3_0= ruleModifierSpecification )
            	    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:265:3: lv_values_3_0= ruleModifierSpecification
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule430);
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
            	    break loop4;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleModifiersRule444); 

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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:293:1: entryRuleModifierSpecification returns [EObject current=null] : iv_ruleModifierSpecification= ruleModifierSpecification EOF ;
    public final EObject entryRuleModifierSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierSpecification = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:294:2: (iv_ruleModifierSpecification= ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:295:2: iv_ruleModifierSpecification= ruleModifierSpecification EOF
            {
             newCompositeNode(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification480);
            iv_ruleModifierSpecification=ruleModifierSpecification();

            state._fsp--;

             current =iv_ruleModifierSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification490); 

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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:302:1: ruleModifierSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleModifierKind ) ) ;
    public final EObject ruleModifierSpecification() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:305:28: ( ( (lv_value_0_0= ruleModifierKind ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:306:1: ( (lv_value_0_0= ruleModifierKind ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:306:1: ( (lv_value_0_0= ruleModifierKind ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:307:1: (lv_value_0_0= ruleModifierKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:307:1: (lv_value_0_0= ruleModifierKind )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:308:3: lv_value_0_0= ruleModifierKind
            {
             
            	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleModifierKind_in_ruleModifierSpecification535);
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


    // $ANTLR start "entryRuleEffectRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:332:1: entryRuleEffectRule returns [EObject current=null] : iv_ruleEffectRule= ruleEffectRule EOF ;
    public final EObject entryRuleEffectRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEffectRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:333:2: (iv_ruleEffectRule= ruleEffectRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:334:2: iv_ruleEffectRule= ruleEffectRule EOF
            {
             newCompositeNode(grammarAccess.getEffectRuleRule()); 
            pushFollow(FOLLOW_ruleEffectRule_in_entryRuleEffectRule570);
            iv_ruleEffectRule=ruleEffectRule();

            state._fsp--;

             current =iv_ruleEffectRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEffectRule580); 

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
    // $ANTLR end "entryRuleEffectRule"


    // $ANTLR start "ruleEffectRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:341:1: ruleEffectRule returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) otherlv_3= '}' ) ;
    public final EObject ruleEffectRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Enumerator lv_effectKind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:344:28: ( (otherlv_0= '{' otherlv_1= 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) otherlv_3= '}' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:345:1: (otherlv_0= '{' otherlv_1= 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) otherlv_3= '}' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:345:1: (otherlv_0= '{' otherlv_1= 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) otherlv_3= '}' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:345:3: otherlv_0= '{' otherlv_1= 'effect: ' ( (lv_effectKind_2_0= ruleEffectKind ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleEffectRule617); 

                	newLeafNode(otherlv_0, grammarAccess.getEffectRuleAccess().getLeftCurlyBracketKeyword_0());
                
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleEffectRule629); 

                	newLeafNode(otherlv_1, grammarAccess.getEffectRuleAccess().getEffectKeyword_1());
                
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:353:1: ( (lv_effectKind_2_0= ruleEffectKind ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:354:1: (lv_effectKind_2_0= ruleEffectKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:354:1: (lv_effectKind_2_0= ruleEffectKind )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:355:3: lv_effectKind_2_0= ruleEffectKind
            {
             
            	        newCompositeNode(grammarAccess.getEffectRuleAccess().getEffectKindEffectKindEnumRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEffectKind_in_ruleEffectRule650);
            lv_effectKind_2_0=ruleEffectKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEffectRuleRule());
            	        }
                   		set(
                   			current, 
                   			"effectKind",
                    		lv_effectKind_2_0, 
                    		"EffectKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleEffectRule662); 

                	newLeafNode(otherlv_3, grammarAccess.getEffectRuleAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleEffectRule"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:383:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:384:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:385:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName698);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName708); 

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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:392:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_remaining_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:395:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:396:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:396:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:396:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:396:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:397:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:397:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:398:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName753); 

            		newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleQualifiedName765); 

                	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
                
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:413:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==17) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:414:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:414:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:415:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName786);
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


    // $ANTLR start "entryRuleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:439:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:440:2: (iv_ruleTypeRule= ruleTypeRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:441:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
             newCompositeNode(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule823);
            iv_ruleTypeRule=ruleTypeRule();

            state._fsp--;

             current =iv_ruleTypeRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule833); 

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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:448:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:451:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:452:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:452:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:452:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:452:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==17) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:453:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:453:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:454:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeRule879);
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

            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:470:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:471:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:471:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:472:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRule900); 

            		newLeafNode(otherlv_1, grammarAccess.getTypeRuleAccess().getTypeTypeCrossReference_1_0()); 
            	

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


    // $ANTLR start "entryRuleMultiplicityRule"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:491:1: entryRuleMultiplicityRule returns [EObject current=null] : iv_ruleMultiplicityRule= ruleMultiplicityRule EOF ;
    public final EObject entryRuleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:492:2: (iv_ruleMultiplicityRule= ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:493:2: iv_ruleMultiplicityRule= ruleMultiplicityRule EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule936);
            iv_ruleMultiplicityRule=ruleMultiplicityRule();

            state._fsp--;

             current =iv_ruleMultiplicityRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule946); 

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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:500:1: ruleMultiplicityRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_bounds_1_0 = null;

        EObject lv_bounds_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:503:28: ( (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:504:1: (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:504:1: (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:504:3: otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleMultiplicityRule983); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:508:1: ( (lv_bounds_1_0= ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:509:1: (lv_bounds_1_0= ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:509:1: (lv_bounds_1_0= ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:510:3: lv_bounds_1_0= ruleBoundSpecification
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule1004);
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

            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:526:2: (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:526:4: otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleMultiplicityRule1017); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:530:1: ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:531:1: (lv_bounds_3_0= ruleBoundSpecification )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:531:1: (lv_bounds_3_0= ruleBoundSpecification )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:532:3: lv_bounds_3_0= ruleBoundSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule1038);
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

            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleMultiplicityRule1052); 

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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:560:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
    public final EObject entryRuleBoundSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundSpecification = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:561:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:562:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
            {
             newCompositeNode(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification1088);
            iv_ruleBoundSpecification=ruleBoundSpecification();

            state._fsp--;

             current =iv_ruleBoundSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification1098); 

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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:569:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleUnlimitedLiteral ) ) ;
    public final EObject ruleBoundSpecification() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:572:28: ( ( (lv_value_0_0= ruleUnlimitedLiteral ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:573:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:573:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:574:1: (lv_value_0_0= ruleUnlimitedLiteral )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:574:1: (lv_value_0_0= ruleUnlimitedLiteral )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:575:3: lv_value_0_0= ruleUnlimitedLiteral
            {
             
            	        newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_ruleBoundSpecification1143);
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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:599:1: entryRuleUnlimitedLiteral returns [String current=null] : iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF ;
    public final String entryRuleUnlimitedLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnlimitedLiteral = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:600:2: (iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:601:2: iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF
            {
             newCompositeNode(grammarAccess.getUnlimitedLiteralRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral1179);
            iv_ruleUnlimitedLiteral=ruleUnlimitedLiteral();

            state._fsp--;

             current =iv_ruleUnlimitedLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteral1190); 

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
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:608:1: ruleUnlimitedLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUnlimitedLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:611:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:612:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:612:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT) ) {
                alt8=1;
            }
            else if ( (LA8_0==21) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:612:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleUnlimitedLiteral1230); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:621:2: kw= '*'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleUnlimitedLiteral1254); 

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


    // $ANTLR start "ruleModifierKind"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:634:1: ruleModifierKind returns [Enumerator current=null] : ( (enumLiteral_0= 'exception' ) | (enumLiteral_1= 'stream' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) ;
    public final Enumerator ruleModifierKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:636:28: ( ( (enumLiteral_0= 'exception' ) | (enumLiteral_1= 'stream' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:637:1: ( (enumLiteral_0= 'exception' ) | (enumLiteral_1= 'stream' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:637:1: ( (enumLiteral_0= 'exception' ) | (enumLiteral_1= 'stream' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt9=1;
                }
                break;
            case 23:
                {
                alt9=2;
                }
                break;
            case 24:
                {
                alt9=3;
                }
                break;
            case 25:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:637:2: (enumLiteral_0= 'exception' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:637:2: (enumLiteral_0= 'exception' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:637:4: enumLiteral_0= 'exception'
                    {
                    enumLiteral_0=(Token)match(input,22,FOLLOW_22_in_ruleModifierKind1308); 

                            current = grammarAccess.getModifierKindAccess().getEXCEPTIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getModifierKindAccess().getEXCEPTIONEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:643:6: (enumLiteral_1= 'stream' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:643:6: (enumLiteral_1= 'stream' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:643:8: enumLiteral_1= 'stream'
                    {
                    enumLiteral_1=(Token)match(input,23,FOLLOW_23_in_ruleModifierKind1325); 

                            current = grammarAccess.getModifierKindAccess().getSTREAMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getModifierKindAccess().getSTREAMEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:649:6: (enumLiteral_2= 'ordered' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:649:6: (enumLiteral_2= 'ordered' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:649:8: enumLiteral_2= 'ordered'
                    {
                    enumLiteral_2=(Token)match(input,24,FOLLOW_24_in_ruleModifierKind1342); 

                            current = grammarAccess.getModifierKindAccess().getORDEREDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getModifierKindAccess().getORDEREDEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:655:6: (enumLiteral_3= 'unique' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:655:6: (enumLiteral_3= 'unique' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:655:8: enumLiteral_3= 'unique'
                    {
                    enumLiteral_3=(Token)match(input,25,FOLLOW_25_in_ruleModifierKind1359); 

                            current = grammarAccess.getModifierKindAccess().getUNIQUEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getModifierKindAccess().getUNIQUEEnumLiteralDeclaration_3()); 
                        

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


    // $ANTLR start "ruleEffectKind"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:665:1: ruleEffectKind returns [Enumerator current=null] : ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'read' ) | (enumLiteral_2= 'update' ) | (enumLiteral_3= 'delete' ) ) ;
    public final Enumerator ruleEffectKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:667:28: ( ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'read' ) | (enumLiteral_2= 'update' ) | (enumLiteral_3= 'delete' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:668:1: ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'read' ) | (enumLiteral_2= 'update' ) | (enumLiteral_3= 'delete' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:668:1: ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'read' ) | (enumLiteral_2= 'update' ) | (enumLiteral_3= 'delete' ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt10=1;
                }
                break;
            case 27:
                {
                alt10=2;
                }
                break;
            case 28:
                {
                alt10=3;
                }
                break;
            case 29:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:668:2: (enumLiteral_0= 'create' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:668:2: (enumLiteral_0= 'create' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:668:4: enumLiteral_0= 'create'
                    {
                    enumLiteral_0=(Token)match(input,26,FOLLOW_26_in_ruleEffectKind1404); 

                            current = grammarAccess.getEffectKindAccess().getCREATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEffectKindAccess().getCREATEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:674:6: (enumLiteral_1= 'read' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:674:6: (enumLiteral_1= 'read' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:674:8: enumLiteral_1= 'read'
                    {
                    enumLiteral_1=(Token)match(input,27,FOLLOW_27_in_ruleEffectKind1421); 

                            current = grammarAccess.getEffectKindAccess().getREADEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEffectKindAccess().getREADEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:680:6: (enumLiteral_2= 'update' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:680:6: (enumLiteral_2= 'update' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:680:8: enumLiteral_2= 'update'
                    {
                    enumLiteral_2=(Token)match(input,28,FOLLOW_28_in_ruleEffectKind1438); 

                            current = grammarAccess.getEffectKindAccess().getUPDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getEffectKindAccess().getUPDATEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:686:6: (enumLiteral_3= 'delete' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:686:6: (enumLiteral_3= 'delete' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:686:8: enumLiteral_3= 'delete'
                    {
                    enumLiteral_3=(Token)match(input,29,FOLLOW_29_in_ruleEffectKind1455); 

                            current = grammarAccess.getEffectKindAccess().getDELETEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getEffectKindAccess().getDELETEEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleEffectKind"


    // $ANTLR start "ruleVisibilityKind"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:696:1: ruleVisibilityKind returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) ;
    public final Enumerator ruleVisibilityKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:698:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:699:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:699:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt11=1;
                }
                break;
            case 31:
                {
                alt11=2;
                }
                break;
            case 32:
                {
                alt11=3;
                }
                break;
            case 33:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:699:2: (enumLiteral_0= '+' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:699:2: (enumLiteral_0= '+' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:699:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,30,FOLLOW_30_in_ruleVisibilityKind1500); 

                            current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:705:6: (enumLiteral_1= '-' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:705:6: (enumLiteral_1= '-' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:705:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,31,FOLLOW_31_in_ruleVisibilityKind1517); 

                            current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:711:6: (enumLiteral_2= '#' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:711:6: (enumLiteral_2= '#' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:711:8: enumLiteral_2= '#'
                    {
                    enumLiteral_2=(Token)match(input,32,FOLLOW_32_in_ruleVisibilityKind1534); 

                            current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:717:6: (enumLiteral_3= '~' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:717:6: (enumLiteral_3= '~' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:717:8: enumLiteral_3= '~'
                    {
                    enumLiteral_3=(Token)match(input,33,FOLLOW_33_in_ruleVisibilityKind1551); 

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


    // $ANTLR start "ruleDirection"
    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:727:1: ruleDirection returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) ;
    public final Enumerator ruleDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:729:28: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:730:1: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:730:1: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) | (enumLiteral_2= 'inout' ) | (enumLiteral_3= 'return' ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt12=1;
                }
                break;
            case 35:
                {
                alt12=2;
                }
                break;
            case 36:
                {
                alt12=3;
                }
                break;
            case 37:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:730:2: (enumLiteral_0= 'in' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:730:2: (enumLiteral_0= 'in' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:730:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,34,FOLLOW_34_in_ruleDirection1596); 

                            current = grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:736:6: (enumLiteral_1= 'out' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:736:6: (enumLiteral_1= 'out' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:736:8: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,35,FOLLOW_35_in_ruleDirection1613); 

                            current = grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:742:6: (enumLiteral_2= 'inout' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:742:6: (enumLiteral_2= 'inout' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:742:8: enumLiteral_2= 'inout'
                    {
                    enumLiteral_2=(Token)match(input,36,FOLLOW_36_in_ruleDirection1630); 

                            current = grammarAccess.getDirectionAccess().getINOUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getDirectionAccess().getINOUTEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:748:6: (enumLiteral_3= 'return' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:748:6: (enumLiteral_3= 'return' )
                    // ../org.eclipse.papyrus.uml.textedit.parameter.xtext/src-gen/org/eclipse/papyrus/uml/textedit/parameter/xtext/parser/antlr/internal/InternalUmlParameter.g:748:8: enumLiteral_3= 'return'
                    {
                    enumLiteral_3=(Token)match(input,37,FOLLOW_37_in_ruleDirection1647); 

                            current = grammarAccess.getDirectionAccess().getRETURNEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getDirectionAccess().getRETURNEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleDirection"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleParameterRule_in_entryRuleParameterRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_ruleParameterRule131 = new BitSet(new long[]{0x0000003C00000000L});
    public static final BitSet FOLLOW_ruleDirection_in_ruleParameterRule152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameterRule169 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleParameterRule186 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleTypeRule_in_ruleParameterRule208 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_12_in_ruleParameterRule226 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_ruleParameterRule248 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_ruleParameterRule270 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_ruleEffectRule_in_ruleParameterRule292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModifiersRule375 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule396 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleModifiersRule409 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule430 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleModifiersRule444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_ruleModifierSpecification535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_entryRuleEffectRule570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEffectRule580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleEffectRule617 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleEffectRule629 = new BitSet(new long[]{0x000000003C000000L});
    public static final BitSet FOLLOW_ruleEffectKind_in_ruleEffectRule650 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEffectRule662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName698 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName753 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleQualifiedName765 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeRule879 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRule900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleMultiplicityRule983 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule1004 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_ruleMultiplicityRule1017 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule1038 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMultiplicityRule1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification1088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_ruleBoundSpecification1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral1179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteral1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleUnlimitedLiteral1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleUnlimitedLiteral1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleModifierKind1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleModifierKind1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleModifierKind1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleModifierKind1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleEffectKind1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleEffectKind1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleEffectKind1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleEffectKind1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVisibilityKind1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleVisibilityKind1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleVisibilityKind1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVisibilityKind1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleDirection1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleDirection1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleDirection1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleDirection1647 = new BitSet(new long[]{0x0000000000000002L});

}