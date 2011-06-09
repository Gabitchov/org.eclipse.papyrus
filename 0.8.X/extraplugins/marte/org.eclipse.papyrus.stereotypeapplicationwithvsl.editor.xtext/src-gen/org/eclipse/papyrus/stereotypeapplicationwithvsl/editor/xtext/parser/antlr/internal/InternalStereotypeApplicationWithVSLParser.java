package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.services.StereotypeApplicationWithVSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStereotypeApplicationWithVSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGERLITERAL", "RULE_REALLITERAL", "RULE_DATETIMELITERAL", "RULE_BOOLEANLITERAL", "RULE_NULLLITERAL", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<<'", "'>>'", "','", "'='", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'?'", "':'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'not'", "'.'", "'('", "')'", "'::'", "']'", "'['", "'..'", "'{'", "'}'", "'@'", "'when'", "'&'", "'jitter('", "'$'", "'in'", "'out'", "'inout'"
    };
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
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_REALLITERAL=6;
    public static final int EOF=-1;
    public static final int RULE_BOOLEANLITERAL=8;
    public static final int T__19=19;
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
    public static final int RULE_STRING=10;
    public static final int T__32=32;
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


        public InternalStereotypeApplicationWithVSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStereotypeApplicationWithVSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStereotypeApplicationWithVSLParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g"; }



     	private StereotypeApplicationWithVSLGrammarAccess grammarAccess;
     	
        public InternalStereotypeApplicationWithVSLParser(TokenStream input, StereotypeApplicationWithVSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "StereotypeApplicationsRule";	
       	}
       	
       	@Override
       	protected StereotypeApplicationWithVSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleStereotypeApplicationsRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:67:1: entryRuleStereotypeApplicationsRule returns [EObject current=null] : iv_ruleStereotypeApplicationsRule= ruleStereotypeApplicationsRule EOF ;
    public final EObject entryRuleStereotypeApplicationsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStereotypeApplicationsRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:68:2: (iv_ruleStereotypeApplicationsRule= ruleStereotypeApplicationsRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:69:2: iv_ruleStereotypeApplicationsRule= ruleStereotypeApplicationsRule EOF
            {
             newCompositeNode(grammarAccess.getStereotypeApplicationsRuleRule()); 
            pushFollow(FOLLOW_ruleStereotypeApplicationsRule_in_entryRuleStereotypeApplicationsRule75);
            iv_ruleStereotypeApplicationsRule=ruleStereotypeApplicationsRule();

            state._fsp--;

             current =iv_ruleStereotypeApplicationsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStereotypeApplicationsRule85); 

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
    // $ANTLR end "entryRuleStereotypeApplicationsRule"


    // $ANTLR start "ruleStereotypeApplicationsRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:76:1: ruleStereotypeApplicationsRule returns [EObject current=null] : ( (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule ) )* ;
    public final EObject ruleStereotypeApplicationsRule() throws RecognitionException {
        EObject current = null;

        EObject lv_stereotypeApplications_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:79:28: ( ( (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:80:1: ( (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:80:1: ( (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:81:1: (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:81:1: (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:82:3: lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStereotypeApplicationsRuleAccess().getStereotypeApplicationsStereotypeApplicationRuleParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStereotypeApplicationRule_in_ruleStereotypeApplicationsRule130);
            	    lv_stereotypeApplications_0_0=ruleStereotypeApplicationRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStereotypeApplicationsRuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"stereotypeApplications",
            	            		lv_stereotypeApplications_0_0, 
            	            		"StereotypeApplicationRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleStereotypeApplicationsRule"


    // $ANTLR start "entryRuleStereotypeApplicationRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:106:1: entryRuleStereotypeApplicationRule returns [EObject current=null] : iv_ruleStereotypeApplicationRule= ruleStereotypeApplicationRule EOF ;
    public final EObject entryRuleStereotypeApplicationRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStereotypeApplicationRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:107:2: (iv_ruleStereotypeApplicationRule= ruleStereotypeApplicationRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:108:2: iv_ruleStereotypeApplicationRule= ruleStereotypeApplicationRule EOF
            {
             newCompositeNode(grammarAccess.getStereotypeApplicationRuleRule()); 
            pushFollow(FOLLOW_ruleStereotypeApplicationRule_in_entryRuleStereotypeApplicationRule166);
            iv_ruleStereotypeApplicationRule=ruleStereotypeApplicationRule();

            state._fsp--;

             current =iv_ruleStereotypeApplicationRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStereotypeApplicationRule176); 

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
    // $ANTLR end "entryRuleStereotypeApplicationRule"


    // $ANTLR start "ruleStereotypeApplicationRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:115:1: ruleStereotypeApplicationRule returns [EObject current=null] : (otherlv_0= '<<' ( (otherlv_1= RULE_ID ) ) otherlv_2= '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) (otherlv_4= ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )? ) ;
    public final EObject ruleStereotypeApplicationRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_tagSpecification_3_0 = null;

        EObject lv_tagSpecification_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:118:28: ( (otherlv_0= '<<' ( (otherlv_1= RULE_ID ) ) otherlv_2= '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) (otherlv_4= ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:119:1: (otherlv_0= '<<' ( (otherlv_1= RULE_ID ) ) otherlv_2= '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) (otherlv_4= ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:119:1: (otherlv_0= '<<' ( (otherlv_1= RULE_ID ) ) otherlv_2= '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) (otherlv_4= ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:119:3: otherlv_0= '<<' ( (otherlv_1= RULE_ID ) ) otherlv_2= '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) (otherlv_4= ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleStereotypeApplicationRule213); 

                	newLeafNode(otherlv_0, grammarAccess.getStereotypeApplicationRuleAccess().getLessThanSignLessThanSignKeyword_0());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:123:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:124:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:124:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:125:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStereotypeApplicationRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStereotypeApplicationRule233); 

            		newLeafNode(otherlv_1, grammarAccess.getStereotypeApplicationRuleAccess().getStereotypeStereotypeCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleStereotypeApplicationRule245); 

                	newLeafNode(otherlv_2, grammarAccess.getStereotypeApplicationRuleAccess().getGreaterThanSignGreaterThanSignKeyword_2());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:140:1: ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) (otherlv_4= ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:140:2: ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) (otherlv_4= ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )*
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:140:2: ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:141:1: (lv_tagSpecification_3_0= ruleTagSpecificationRule )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:141:1: (lv_tagSpecification_3_0= ruleTagSpecificationRule )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:142:3: lv_tagSpecification_3_0= ruleTagSpecificationRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getStereotypeApplicationRuleAccess().getTagSpecificationTagSpecificationRuleParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTagSpecificationRule_in_ruleStereotypeApplicationRule267);
                    lv_tagSpecification_3_0=ruleTagSpecificationRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStereotypeApplicationRuleRule());
                    	        }
                           		add(
                           			current, 
                           			"tagSpecification",
                            		lv_tagSpecification_3_0, 
                            		"TagSpecificationRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:158:2: (otherlv_4= ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==18) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:158:4: otherlv_4= ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) )
                    	    {
                    	    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleStereotypeApplicationRule280); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getStereotypeApplicationRuleAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:162:1: ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) )
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:163:1: (lv_tagSpecification_5_0= ruleTagSpecificationRule )
                    	    {
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:163:1: (lv_tagSpecification_5_0= ruleTagSpecificationRule )
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:164:3: lv_tagSpecification_5_0= ruleTagSpecificationRule
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStereotypeApplicationRuleAccess().getTagSpecificationTagSpecificationRuleParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTagSpecificationRule_in_ruleStereotypeApplicationRule301);
                    	    lv_tagSpecification_5_0=ruleTagSpecificationRule();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStereotypeApplicationRuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"tagSpecification",
                    	            		lv_tagSpecification_5_0, 
                    	            		"TagSpecificationRule");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


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
    // $ANTLR end "ruleStereotypeApplicationRule"


    // $ANTLR start "entryRuleTagSpecificationRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:188:1: entryRuleTagSpecificationRule returns [EObject current=null] : iv_ruleTagSpecificationRule= ruleTagSpecificationRule EOF ;
    public final EObject entryRuleTagSpecificationRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTagSpecificationRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:189:2: (iv_ruleTagSpecificationRule= ruleTagSpecificationRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:190:2: iv_ruleTagSpecificationRule= ruleTagSpecificationRule EOF
            {
             newCompositeNode(grammarAccess.getTagSpecificationRuleRule()); 
            pushFollow(FOLLOW_ruleTagSpecificationRule_in_entryRuleTagSpecificationRule341);
            iv_ruleTagSpecificationRule=ruleTagSpecificationRule();

            state._fsp--;

             current =iv_ruleTagSpecificationRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTagSpecificationRule351); 

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
    // $ANTLR end "entryRuleTagSpecificationRule"


    // $ANTLR start "ruleTagSpecificationRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:197:1: ruleTagSpecificationRule returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) ) ) ;
    public final EObject ruleTagSpecificationRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:200:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:201:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:201:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:201:2: ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:201:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:202:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:202:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:203:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTagSpecificationRuleRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTagSpecificationRule396); 

            		newLeafNode(otherlv_0, grammarAccess.getTagSpecificationRuleAccess().getPropertyPropertyCrossReference_0_0()); 
            	

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:214:2: ( (lv_value_1_0= ruleExpressionValueRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:215:1: (lv_value_1_0= ruleExpressionValueRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:215:1: (lv_value_1_0= ruleExpressionValueRule )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:216:3: lv_value_1_0= ruleExpressionValueRule
            {
             
            	        newCompositeNode(grammarAccess.getTagSpecificationRuleAccess().getValueExpressionValueRuleParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressionValueRule_in_ruleTagSpecificationRule417);
            lv_value_1_0=ruleExpressionValueRule();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTagSpecificationRuleRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"ExpressionValueRule");
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
    // $ANTLR end "ruleTagSpecificationRule"


    // $ANTLR start "entryRuleExpressionValueRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:240:1: entryRuleExpressionValueRule returns [EObject current=null] : iv_ruleExpressionValueRule= ruleExpressionValueRule EOF ;
    public final EObject entryRuleExpressionValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionValueRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:241:2: (iv_ruleExpressionValueRule= ruleExpressionValueRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:242:2: iv_ruleExpressionValueRule= ruleExpressionValueRule EOF
            {
             newCompositeNode(grammarAccess.getExpressionValueRuleRule()); 
            pushFollow(FOLLOW_ruleExpressionValueRule_in_entryRuleExpressionValueRule453);
            iv_ruleExpressionValueRule=ruleExpressionValueRule();

            state._fsp--;

             current =iv_ruleExpressionValueRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionValueRule463); 

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
    // $ANTLR end "entryRuleExpressionValueRule"


    // $ANTLR start "ruleExpressionValueRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:249:1: ruleExpressionValueRule returns [EObject current=null] : (otherlv_0= '=' ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExpressionValueRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:252:28: ( (otherlv_0= '=' ( (lv_expression_1_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:253:1: (otherlv_0= '=' ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:253:1: (otherlv_0= '=' ( (lv_expression_1_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:253:3: otherlv_0= '=' ( (lv_expression_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleExpressionValueRule500); 

                	newLeafNode(otherlv_0, grammarAccess.getExpressionValueRuleAccess().getEqualsSignKeyword_0());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:257:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:258:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:258:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:259:3: lv_expression_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionValueRuleAccess().getExpressionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionValueRule521);
            lv_expression_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionValueRuleRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"Expression");
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
    // $ANTLR end "ruleExpressionValueRule"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:283:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:284:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:285:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression557);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression567); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:292:1: ruleExpression returns [EObject current=null] : ( (lv_exp_0_0= ruleAndOrXorExpression ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:295:28: ( ( (lv_exp_0_0= ruleAndOrXorExpression ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:296:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:296:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:297:1: (lv_exp_0_0= ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:297:1: (lv_exp_0_0= ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:298:3: lv_exp_0_0= ruleAndOrXorExpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_ruleExpression612);
            lv_exp_0_0=ruleAndOrXorExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"AndOrXorExpression");
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAndOrXorExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:322:1: entryRuleAndOrXorExpression returns [EObject current=null] : iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF ;
    public final EObject entryRuleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrXorExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:323:2: (iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:324:2: iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF
            {
             newCompositeNode(grammarAccess.getAndOrXorExpressionRule()); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression647);
            iv_ruleAndOrXorExpression=ruleAndOrXorExpression();

            state._fsp--;

             current =iv_ruleAndOrXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression657); 

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
    // $ANTLR end "entryRuleAndOrXorExpression"


    // $ANTLR start "ruleAndOrXorExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:331:1: ruleAndOrXorExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:334:28: ( ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:335:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:335:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:335:2: ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:335:2: ( (lv_exp_0_0= ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:336:1: (lv_exp_0_0= ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:336:1: (lv_exp_0_0= ruleEqualityExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:337:3: lv_exp_0_0= ruleEqualityExpression
            {
             
            	        newCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression703);
            lv_exp_0_0=ruleEqualityExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAndOrXorExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"EqualityExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:353:2: ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=20 && LA5_0<=22)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:353:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:353:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:354:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:354:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:355:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:355:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    int alt4=3;
            	    switch ( input.LA(1) ) {
            	    case 20:
            	        {
            	        alt4=1;
            	        }
            	        break;
            	    case 21:
            	        {
            	        alt4=2;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt4=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:356:3: lv_op_1_1= 'and'
            	            {
            	            lv_op_1_1=(Token)match(input,20,FOLLOW_20_in_ruleAndOrXorExpression724); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAndOrXorExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:368:8: lv_op_1_2= 'or'
            	            {
            	            lv_op_1_2=(Token)match(input,21,FOLLOW_21_in_ruleAndOrXorExpression753); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAndOrXorExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:380:8: lv_op_1_3= 'xor'
            	            {
            	            lv_op_1_3=(Token)match(input,22,FOLLOW_22_in_ruleAndOrXorExpression782); 

            	                    newLeafNode(lv_op_1_3, grammarAccess.getAndOrXorExpressionAccess().getOpXorKeyword_1_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAndOrXorExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_3, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:395:2: ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:396:1: (lv_exp_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:396:1: (lv_exp_2_0= ruleEqualityExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:397:3: lv_exp_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression819);
            	    lv_exp_2_0=ruleEqualityExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAndOrXorExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"EqualityExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleAndOrXorExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:421:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:422:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:423:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression857);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression867); 

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
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:430:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:433:28: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:434:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:434:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:434:2: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:434:2: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:435:1: (lv_exp_0_0= ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:435:1: (lv_exp_0_0= ruleRelationalExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:436:3: lv_exp_0_0= ruleRelationalExpression
            {
             
            	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression913);
            lv_exp_0_0=ruleRelationalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"RelationalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:452:2: ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=23 && LA7_0<=24)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:452:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:452:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:453:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:453:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:454:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:454:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==23) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==24) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:455:3: lv_op_1_1= '=='
            	            {
            	            lv_op_1_1=(Token)match(input,23,FOLLOW_23_in_ruleEqualityExpression934); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:467:8: lv_op_1_2= '<>'
            	            {
            	            lv_op_1_2=(Token)match(input,24,FOLLOW_24_in_ruleEqualityExpression963); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getEqualityExpressionAccess().getOpLessThanSignGreaterThanSignKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:482:2: ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:483:1: (lv_exp_2_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:483:1: (lv_exp_2_0= ruleRelationalExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:484:3: lv_exp_2_0= ruleRelationalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1000);
            	    lv_exp_2_0=ruleRelationalExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"RelationalExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:508:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:509:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:510:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1038);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression1048); 

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
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:517:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:520:28: ( ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:521:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:521:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:521:2: ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:521:2: ( (lv_exp_0_0= ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:522:1: (lv_exp_0_0= ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:522:1: (lv_exp_0_0= ruleConditionalExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:523:3: lv_exp_0_0= ruleConditionalExpression
            {
             
            	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1094);
            lv_exp_0_0=ruleConditionalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"ConditionalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:539:2: ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=25 && LA9_0<=28)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:539:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:539:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:540:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:540:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:541:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:541:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    int alt8=4;
            	    switch ( input.LA(1) ) {
            	    case 25:
            	        {
            	        alt8=1;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt8=2;
            	        }
            	        break;
            	    case 27:
            	        {
            	        alt8=3;
            	        }
            	        break;
            	    case 28:
            	        {
            	        alt8=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:542:3: lv_op_1_1= '<'
            	            {
            	            lv_op_1_1=(Token)match(input,25,FOLLOW_25_in_ruleRelationalExpression1115); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:554:8: lv_op_1_2= '>'
            	            {
            	            lv_op_1_2=(Token)match(input,26,FOLLOW_26_in_ruleRelationalExpression1144); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:566:8: lv_op_1_3= '<='
            	            {
            	            lv_op_1_3=(Token)match(input,27,FOLLOW_27_in_ruleRelationalExpression1173); 

            	                    newLeafNode(lv_op_1_3, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_3, null);
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:578:8: lv_op_1_4= '>='
            	            {
            	            lv_op_1_4=(Token)match(input,28,FOLLOW_28_in_ruleRelationalExpression1202); 

            	                    newLeafNode(lv_op_1_4, grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_0_3());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_4, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:593:2: ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:594:1: (lv_exp_2_0= ruleConditionalExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:594:1: (lv_exp_2_0= ruleConditionalExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:595:3: lv_exp_2_0= ruleConditionalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1239);
            	    lv_exp_2_0=ruleConditionalExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"ConditionalExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:619:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:620:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:621:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1277);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression1287); 

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
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:628:1: ruleConditionalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        Token otherlv_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;

        EObject lv_exp_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:631:28: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:632:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:632:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:632:2: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:632:2: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:633:1: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:633:1: (lv_exp_0_0= ruleAdditiveExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:634:3: lv_exp_0_0= ruleAdditiveExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1333);
            lv_exp_0_0=ruleAdditiveExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"AdditiveExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:650:2: ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:650:3: ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) otherlv_3= ':' ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:650:3: ( (lv_op_1_0= '?' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:651:1: (lv_op_1_0= '?' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:651:1: (lv_op_1_0= '?' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:652:3: lv_op_1_0= '?'
                    {
                    lv_op_1_0=(Token)match(input,29,FOLLOW_29_in_ruleConditionalExpression1352); 

                            newLeafNode(lv_op_1_0, grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConditionalExpressionRule());
                    	        }
                           		addWithLastConsumed(current, "op", lv_op_1_0, "?");
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:665:2: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:666:1: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:666:1: (lv_exp_2_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:667:3: lv_exp_2_0= ruleAdditiveExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1386);
                    lv_exp_2_0=ruleAdditiveExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                    	        }
                           		add(
                           			current, 
                           			"exp",
                            		lv_exp_2_0, 
                            		"AdditiveExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleConditionalExpression1398); 

                        	newLeafNode(otherlv_3, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:687:1: ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:688:1: (lv_exp_4_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:688:1: (lv_exp_4_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:689:3: lv_exp_4_0= ruleAdditiveExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1419);
                    lv_exp_4_0=ruleAdditiveExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                    	        }
                           		add(
                           			current, 
                           			"exp",
                            		lv_exp_4_0, 
                            		"AdditiveExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:713:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:714:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:715:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1457);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1467); 

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
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:722:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:725:28: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:726:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:726:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:726:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:726:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:727:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:727:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:728:3: lv_exp_0_0= ruleMultiplicativeExpression
            {
             
            	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1513);
            lv_exp_0_0=ruleMultiplicativeExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"MultiplicativeExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:744:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=31 && LA12_0<=32)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:744:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:744:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:745:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:745:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:746:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:746:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==31) ) {
            	        alt11=1;
            	    }
            	    else if ( (LA11_0==32) ) {
            	        alt11=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:747:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)match(input,31,FOLLOW_31_in_ruleAdditiveExpression1534); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:759:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)match(input,32,FOLLOW_32_in_ruleAdditiveExpression1563); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:774:2: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:775:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:775:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:776:3: lv_exp_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1600);
            	    lv_exp_2_0=ruleMultiplicativeExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"MultiplicativeExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:800:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:801:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:802:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1638);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression1648); 

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
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:809:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:812:28: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:813:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:813:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:813:2: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:813:2: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:814:1: (lv_exp_0_0= ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:814:1: (lv_exp_0_0= ruleUnaryExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:815:3: lv_exp_0_0= ruleUnaryExpression
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1694);
            lv_exp_0_0=ruleUnaryExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"UnaryExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:831:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=33 && LA14_0<=35)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:831:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:831:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:832:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:832:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:833:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:833:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    int alt13=3;
            	    switch ( input.LA(1) ) {
            	    case 33:
            	        {
            	        alt13=1;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt13=2;
            	        }
            	        break;
            	    case 35:
            	        {
            	        alt13=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt13) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:834:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)match(input,33,FOLLOW_33_in_ruleMultiplicativeExpression1715); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:846:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)match(input,34,FOLLOW_34_in_ruleMultiplicativeExpression1744); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:858:8: lv_op_1_3= 'mod'
            	            {
            	            lv_op_1_3=(Token)match(input,35,FOLLOW_35_in_ruleMultiplicativeExpression1773); 

            	                    newLeafNode(lv_op_1_3, grammarAccess.getMultiplicativeExpressionAccess().getOpModKeyword_1_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_3, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:873:2: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:874:1: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:874:1: (lv_exp_2_0= ruleUnaryExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:875:3: lv_exp_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1810);
            	    lv_exp_2_0=ruleUnaryExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"UnaryExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:899:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:900:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:901:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1848);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression1858); 

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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:908:1: ruleUnaryExpression returns [EObject current=null] : ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        EObject lv_unary_1_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:911:28: ( ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:912:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:912:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=31 && LA16_0<=32)||LA16_0==36) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_STRING)||(LA16_0>=33 && LA16_0<=34)||LA16_0==38||(LA16_0>=41 && LA16_0<=42)||LA16_0==44||LA16_0==46||(LA16_0>=48 && LA16_0<=53)) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:912:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:912:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:912:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:912:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:913:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:913:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:914:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:914:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    int alt15=3;
                    switch ( input.LA(1) ) {
                    case 36:
                        {
                        alt15=1;
                        }
                        break;
                    case 32:
                        {
                        alt15=2;
                        }
                        break;
                    case 31:
                        {
                        alt15=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }

                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:915:3: lv_op_0_1= 'not'
                            {
                            lv_op_0_1=(Token)match(input,36,FOLLOW_36_in_ruleUnaryExpression1904); 

                                    newLeafNode(lv_op_0_1, grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:927:8: lv_op_0_2= '-'
                            {
                            lv_op_0_2=(Token)match(input,32,FOLLOW_32_in_ruleUnaryExpression1933); 

                                    newLeafNode(lv_op_0_2, grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:939:8: lv_op_0_3= '+'
                            {
                            lv_op_0_3=(Token)match(input,31,FOLLOW_31_in_ruleUnaryExpression1962); 

                                    newLeafNode(lv_op_0_3, grammarAccess.getUnaryExpressionAccess().getOpPlusSignKeyword_0_0_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_3, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:954:2: ( (lv_unary_1_0= ruleUnaryExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:955:1: (lv_unary_1_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:955:1: (lv_unary_1_0= ruleUnaryExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:956:3: lv_unary_1_0= ruleUnaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1999);
                    lv_unary_1_0=ruleUnaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"unary",
                            		lv_unary_1_0, 
                            		"UnaryExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:973:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:973:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:974:1: (lv_exp_2_0= rulePrimaryExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:974:1: (lv_exp_2_0= rulePrimaryExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:975:3: lv_exp_2_0= rulePrimaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression2027);
                    lv_exp_2_0=rulePrimaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"exp",
                            		lv_exp_2_0, 
                            		"PrimaryExpression");
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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:999:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1000:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1001:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2063);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression2073); 

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1008:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_prefix_0_0 = null;

        EObject lv_suffix_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1011:28: ( ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1012:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1012:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1012:2: ( (lv_prefix_0_0= ruleValueSpecification ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1012:2: ( (lv_prefix_0_0= ruleValueSpecification ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1013:1: (lv_prefix_0_0= ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1013:1: (lv_prefix_0_0= ruleValueSpecification )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1014:3: lv_prefix_0_0= ruleValueSpecification
            {
             
            	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueSpecification_in_rulePrimaryExpression2119);
            lv_prefix_0_0=ruleValueSpecification();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"prefix",
                    		lv_prefix_0_0, 
                    		"ValueSpecification");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1030:2: (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==37) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1030:4: otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_rulePrimaryExpression2132); 

                        	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1034:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1035:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1035:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1036:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2153);
                    lv_suffix_2_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_2_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleValueSpecification"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1060:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1061:2: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1062:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
             newCompositeNode(grammarAccess.getValueSpecificationRule()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2191);
            iv_ruleValueSpecification=ruleValueSpecification();

            state._fsp--;

             current =iv_ruleValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification2201); 

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
    // $ANTLR end "entryRuleValueSpecification"


    // $ANTLR start "ruleValueSpecification"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1069:1: ruleValueSpecification returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) ) ;
    public final EObject ruleValueSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject this_Literal_0 = null;

        EObject this_NameOrChoiceOrBehaviorCall_1 = null;

        EObject this_Interval_2 = null;

        EObject this_CollectionOrTuple_3 = null;

        EObject this_Tuple_4 = null;

        EObject this_TimeExpression_5 = null;

        EObject this_VariableDeclaration_6 = null;

        EObject this_Expression_8 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1072:28: ( (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1073:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1073:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )
            int alt18=8;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1074:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleValueSpecification2248);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1084:5: this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2275);
                    this_NameOrChoiceOrBehaviorCall_1=ruleNameOrChoiceOrBehaviorCall();

                    state._fsp--;

                     
                            current = this_NameOrChoiceOrBehaviorCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1094:5: this_Interval_2= ruleInterval
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInterval_in_ruleValueSpecification2302);
                    this_Interval_2=ruleInterval();

                    state._fsp--;

                     
                            current = this_Interval_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1104:5: this_CollectionOrTuple_3= ruleCollectionOrTuple
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2329);
                    this_CollectionOrTuple_3=ruleCollectionOrTuple();

                    state._fsp--;

                     
                            current = this_CollectionOrTuple_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1114:5: this_Tuple_4= ruleTuple
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleTuple_in_ruleValueSpecification2356);
                    this_Tuple_4=ruleTuple();

                    state._fsp--;

                     
                            current = this_Tuple_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1124:5: this_TimeExpression_5= ruleTimeExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleTimeExpression_in_ruleValueSpecification2383);
                    this_TimeExpression_5=ruleTimeExpression();

                    state._fsp--;

                     
                            current = this_TimeExpression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1134:5: this_VariableDeclaration_6= ruleVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2410);
                    this_VariableDeclaration_6=ruleVariableDeclaration();

                    state._fsp--;

                     
                            current = this_VariableDeclaration_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1143:6: (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1143:6: (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1143:8: otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')'
                    {
                    otherlv_7=(Token)match(input,38,FOLLOW_38_in_ruleValueSpecification2428); 

                        	newLeafNode(otherlv_7, grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0());
                        
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1()); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleValueSpecification2450);
                    this_Expression_8=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_8; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_9=(Token)match(input,39,FOLLOW_39_in_ruleValueSpecification2461); 

                        	newLeafNode(otherlv_9, grammarAccess.getValueSpecificationAccess().getRightParenthesisKeyword_7_2());
                        

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
    // $ANTLR end "ruleValueSpecification"


    // $ANTLR start "entryRuleSuffixExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1168:1: entryRuleSuffixExpression returns [EObject current=null] : iv_ruleSuffixExpression= ruleSuffixExpression EOF ;
    public final EObject entryRuleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuffixExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1169:2: (iv_ruleSuffixExpression= ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1170:2: iv_ruleSuffixExpression= ruleSuffixExpression EOF
            {
             newCompositeNode(grammarAccess.getSuffixExpressionRule()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2498);
            iv_ruleSuffixExpression=ruleSuffixExpression();

            state._fsp--;

             current =iv_ruleSuffixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression2508); 

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
    // $ANTLR end "entryRuleSuffixExpression"


    // $ANTLR start "ruleSuffixExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1177:1: ruleSuffixExpression returns [EObject current=null] : (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) ;
    public final EObject ruleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyCallExpression_0 = null;

        EObject this_OperationCallExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1180:28: ( (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1181:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1181:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==EOF||LA19_1==16||LA19_1==18||(LA19_1>=20 && LA19_1<=35)||LA19_1==37||LA19_1==39||(LA19_1>=41 && LA19_1<=43)||LA19_1==45) ) {
                    alt19=1;
                }
                else if ( (LA19_1==38) ) {
                    alt19=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1182:5: this_PropertyCallExpression_0= rulePropertyCallExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2555);
                    this_PropertyCallExpression_0=rulePropertyCallExpression();

                    state._fsp--;

                     
                            current = this_PropertyCallExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1192:5: this_OperationCallExpression_1= ruleOperationCallExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2582);
                    this_OperationCallExpression_1=ruleOperationCallExpression();

                    state._fsp--;

                     
                            current = this_OperationCallExpression_1; 
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
    // $ANTLR end "ruleSuffixExpression"


    // $ANTLR start "entryRulePropertyCallExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1208:1: entryRulePropertyCallExpression returns [EObject current=null] : iv_rulePropertyCallExpression= rulePropertyCallExpression EOF ;
    public final EObject entryRulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCallExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1209:2: (iv_rulePropertyCallExpression= rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1210:2: iv_rulePropertyCallExpression= rulePropertyCallExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyCallExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2617);
            iv_rulePropertyCallExpression=rulePropertyCallExpression();

            state._fsp--;

             current =iv_rulePropertyCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression2627); 

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
    // $ANTLR end "entryRulePropertyCallExpression"


    // $ANTLR start "rulePropertyCallExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1217:1: rulePropertyCallExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_suffix_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1220:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1221:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1221:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1221:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1221:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1222:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1222:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1223:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyCallExpressionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyCallExpression2672); 

            		newLeafNode(otherlv_0, grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0()); 
            	

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1234:2: (otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==37) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1234:4: otherlv_1= '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_rulePropertyCallExpression2685); 

                        	newLeafNode(otherlv_1, grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1238:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1239:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1239:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1240:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2706);
                    lv_suffix_2_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyCallExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_2_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "rulePropertyCallExpression"


    // $ANTLR start "entryRuleOperationCallExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1264:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1265:2: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1266:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
             newCompositeNode(grammarAccess.getOperationCallExpressionRule()); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2744);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();

            state._fsp--;

             current =iv_ruleOperationCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression2754); 

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
    // $ANTLR end "entryRuleOperationCallExpression"


    // $ANTLR start "ruleOperationCallExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1273:1: ruleOperationCallExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject ruleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_suffix_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1276:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1277:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1277:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1277:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_arguments_2_0= ruleListOfValues ) )? otherlv_3= ')' (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1277:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1278:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1278:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1279:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationCallExpressionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpression2799); 

            		newLeafNode(otherlv_0, grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleOperationCallExpression2811); 

                	newLeafNode(otherlv_1, grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1294:1: ( (lv_arguments_2_0= ruleListOfValues ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||(LA21_0>=31 && LA21_0<=34)||LA21_0==36||LA21_0==38||(LA21_0>=41 && LA21_0<=42)||LA21_0==44||LA21_0==46||(LA21_0>=48 && LA21_0<=53)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1295:1: (lv_arguments_2_0= ruleListOfValues )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1295:1: (lv_arguments_2_0= ruleListOfValues )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1296:3: lv_arguments_2_0= ruleListOfValues
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2832);
                    lv_arguments_2_0=ruleListOfValues();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"arguments",
                            		lv_arguments_2_0, 
                            		"ListOfValues");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleOperationCallExpression2845); 

                	newLeafNode(otherlv_3, grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1316:1: (otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==37) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1316:3: otherlv_4= '.' ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    {
                    otherlv_4=(Token)match(input,37,FOLLOW_37_in_ruleOperationCallExpression2858); 

                        	newLeafNode(otherlv_4, grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1320:1: ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1321:1: (lv_suffix_5_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1321:1: (lv_suffix_5_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1322:3: lv_suffix_5_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2879);
                    lv_suffix_5_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_5_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleOperationCallExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1346:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1347:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1348:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2917);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2927); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1355:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_DateTimeLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_NullLiteralRule_3 = null;

        EObject this_DefaultLiteralRule_4 = null;

        EObject this_StringLiteralRule_5 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1358:28: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1359:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1359:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            int alt23=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case 33:
                {
                alt23=1;
                }
                break;
            case RULE_DATETIMELITERAL:
                {
                alt23=2;
                }
                break;
            case RULE_BOOLEANLITERAL:
                {
                alt23=3;
                }
                break;
            case RULE_NULLLITERAL:
                {
                alt23=4;
                }
                break;
            case 34:
                {
                alt23=5;
                }
                break;
            case RULE_STRING:
                {
                alt23=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1360:5: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2974);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();

                    state._fsp--;

                     
                            current = this_NumberLiteralRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1370:5: this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral3001);
                    this_DateTimeLiteralRule_1=ruleDateTimeLiteralRule();

                    state._fsp--;

                     
                            current = this_DateTimeLiteralRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1380:5: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral3028);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();

                    state._fsp--;

                     
                            current = this_BooleanLiteralRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1390:5: this_NullLiteralRule_3= ruleNullLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_ruleLiteral3055);
                    this_NullLiteralRule_3=ruleNullLiteralRule();

                    state._fsp--;

                     
                            current = this_NullLiteralRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1400:5: this_DefaultLiteralRule_4= ruleDefaultLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral3082);
                    this_DefaultLiteralRule_4=ruleDefaultLiteralRule();

                    state._fsp--;

                     
                            current = this_DefaultLiteralRule_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1410:5: this_StringLiteralRule_5= ruleStringLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_ruleLiteral3109);
                    this_StringLiteralRule_5=ruleStringLiteralRule();

                    state._fsp--;

                     
                            current = this_StringLiteralRule_5; 
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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleNameOrChoiceOrBehaviorCall"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1426:1: entryRuleNameOrChoiceOrBehaviorCall returns [EObject current=null] : iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF ;
    public final EObject entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrChoiceOrBehaviorCall = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1427:2: (iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1428:2: iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF
            {
             newCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallRule()); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall3144);
            iv_ruleNameOrChoiceOrBehaviorCall=ruleNameOrChoiceOrBehaviorCall();

            state._fsp--;

             current =iv_ruleNameOrChoiceOrBehaviorCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3154); 

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
    // $ANTLR end "entryRuleNameOrChoiceOrBehaviorCall"


    // $ANTLR start "ruleNameOrChoiceOrBehaviorCall"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1435:1: ruleNameOrChoiceOrBehaviorCall returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? ) ;
    public final EObject ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_path_0_0 = null;

        EObject lv_arguments_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1438:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1439:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1439:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1439:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1439:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==40) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1440:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1440:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1441:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3200);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNameOrChoiceOrBehaviorCallRule());
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1457:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1458:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1458:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1459:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNameOrChoiceOrBehaviorCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3221); 

            		newLeafNode(otherlv_1, grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0()); 
            	

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1470:2: (otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1470:4: otherlv_2= '(' ( (lv_arguments_3_0= ruleListOfValues ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleNameOrChoiceOrBehaviorCall3234); 

                        	newLeafNode(otherlv_2, grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1474:1: ( (lv_arguments_3_0= ruleListOfValues ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)||(LA25_0>=31 && LA25_0<=34)||LA25_0==36||LA25_0==38||(LA25_0>=41 && LA25_0<=42)||LA25_0==44||LA25_0==46||(LA25_0>=48 && LA25_0<=53)) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1475:1: (lv_arguments_3_0= ruleListOfValues )
                            {
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1475:1: (lv_arguments_3_0= ruleListOfValues )
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1476:3: lv_arguments_3_0= ruleListOfValues
                            {
                             
                            	        newCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3255);
                            lv_arguments_3_0=ruleListOfValues();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNameOrChoiceOrBehaviorCallRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"arguments",
                                    		lv_arguments_3_0, 
                                    		"ListOfValues");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleNameOrChoiceOrBehaviorCall3268); 

                        	newLeafNode(otherlv_4, grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getRightParenthesisKeyword_2_2());
                        

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
    // $ANTLR end "ruleNameOrChoiceOrBehaviorCall"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1504:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1505:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1506:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3306);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3316); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1513:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_remaining_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1516:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1517:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1517:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1517:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1517:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1518:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1518:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1519:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3361); 

            		newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleQualifiedName3373); 

                	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1534:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==40) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1535:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1535:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1536:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName3394);
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


    // $ANTLR start "entryRuleInterval"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1560:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1561:2: (iv_ruleInterval= ruleInterval EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1562:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval3431);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval3441); 

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
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1569:1: ruleInterval returns [EObject current=null] : ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_isLowerIncluded_1_0=null;
        Token otherlv_3=null;
        Token lv_isUpperIncluded_5_0=null;
        Token otherlv_6=null;
        EObject lv_lower_2_0 = null;

        EObject lv_upper_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1572:28: ( ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1573:1: ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1573:1: ( (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1573:2: (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) otherlv_3= '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1573:2: (otherlv_0= ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==41) ) {
                alt28=1;
            }
            else if ( (LA28_0==42) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1573:4: otherlv_0= ']'
                    {
                    otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleInterval3479); 

                        	newLeafNode(otherlv_0, grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1578:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1578:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1579:1: (lv_isLowerIncluded_1_0= '[' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1579:1: (lv_isLowerIncluded_1_0= '[' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1580:3: lv_isLowerIncluded_1_0= '['
                    {
                    lv_isLowerIncluded_1_0=(Token)match(input,42,FOLLOW_42_in_ruleInterval3503); 

                            newLeafNode(lv_isLowerIncluded_1_0, grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntervalRule());
                    	        }
                           		setWithLastConsumed(current, "isLowerIncluded", lv_isLowerIncluded_1_0, "[");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1593:3: ( (lv_lower_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1594:1: (lv_lower_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1594:1: (lv_lower_2_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1595:3: lv_lower_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3538);
            lv_lower_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntervalRule());
            	        }
                   		set(
                   			current, 
                   			"lower",
                    		lv_lower_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleInterval3550); 

                	newLeafNode(otherlv_3, grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1615:1: ( (lv_upper_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1616:1: (lv_upper_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1616:1: (lv_upper_4_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1617:3: lv_upper_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3571);
            lv_upper_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntervalRule());
            	        }
                   		set(
                   			current, 
                   			"upper",
                    		lv_upper_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1633:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | otherlv_6= '[' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==41) ) {
                alt29=1;
            }
            else if ( (LA29_0==42) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1633:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1633:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1634:1: (lv_isUpperIncluded_5_0= ']' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1634:1: (lv_isUpperIncluded_5_0= ']' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1635:3: lv_isUpperIncluded_5_0= ']'
                    {
                    lv_isUpperIncluded_5_0=(Token)match(input,41,FOLLOW_41_in_ruleInterval3590); 

                            newLeafNode(lv_isUpperIncluded_5_0, grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntervalRule());
                    	        }
                           		setWithLastConsumed(current, "isUpperIncluded", lv_isUpperIncluded_5_0, "]");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1649:7: otherlv_6= '['
                    {
                    otherlv_6=(Token)match(input,42,FOLLOW_42_in_ruleInterval3621); 

                        	newLeafNode(otherlv_6, grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_4_1());
                        

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
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleCollectionOrTuple"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1661:1: entryRuleCollectionOrTuple returns [EObject current=null] : iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF ;
    public final EObject entryRuleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionOrTuple = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1662:2: (iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1663:2: iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF
            {
             newCompositeNode(grammarAccess.getCollectionOrTupleRule()); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3658);
            iv_ruleCollectionOrTuple=ruleCollectionOrTuple();

            state._fsp--;

             current =iv_ruleCollectionOrTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple3668); 

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
    // $ANTLR end "entryRuleCollectionOrTuple"


    // $ANTLR start "ruleCollectionOrTuple"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1670:1: ruleCollectionOrTuple returns [EObject current=null] : (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' ) ;
    public final EObject ruleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_listOfValues_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1673:28: ( (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1674:1: (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1674:1: (otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1674:3: otherlv_0= '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleCollectionOrTuple3705); 

                	newLeafNode(otherlv_0, grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1678:1: ( (lv_listOfValues_1_0= ruleListOfValues ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1679:1: (lv_listOfValues_1_0= ruleListOfValues )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1679:1: (lv_listOfValues_1_0= ruleListOfValues )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1680:3: lv_listOfValues_1_0= ruleListOfValues
            {
             
            	        newCompositeNode(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3726);
            lv_listOfValues_1_0=ruleListOfValues();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectionOrTupleRule());
            	        }
                   		set(
                   			current, 
                   			"listOfValues",
                    		lv_listOfValues_1_0, 
                    		"ListOfValues");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleCollectionOrTuple3738); 

                	newLeafNode(otherlv_2, grammarAccess.getCollectionOrTupleAccess().getRightCurlyBracketKeyword_2());
                

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
    // $ANTLR end "ruleCollectionOrTuple"


    // $ANTLR start "entryRuleTuple"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1708:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1709:2: (iv_ruleTuple= ruleTuple EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1710:2: iv_ruleTuple= ruleTuple EOF
            {
             newCompositeNode(grammarAccess.getTupleRule()); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple3774);
            iv_ruleTuple=ruleTuple();

            state._fsp--;

             current =iv_ruleTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple3784); 

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
    // $ANTLR end "entryRuleTuple"


    // $ANTLR start "ruleTuple"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1717:1: ruleTuple returns [EObject current=null] : (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_listOfValueNamePairs_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1720:28: ( (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1721:1: (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1721:1: (otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1721:3: otherlv_0= '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleTuple3821); 

                	newLeafNode(otherlv_0, grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1725:1: ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1726:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1726:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1727:3: lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs
            {
             
            	        newCompositeNode(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3842);
            lv_listOfValueNamePairs_1_0=ruleListOfValueNamePairs();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTupleRule());
            	        }
                   		set(
                   			current, 
                   			"listOfValueNamePairs",
                    		lv_listOfValueNamePairs_1_0, 
                    		"ListOfValueNamePairs");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleTuple3854); 

                	newLeafNode(otherlv_2, grammarAccess.getTupleAccess().getRightCurlyBracketKeyword_2());
                

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
    // $ANTLR end "ruleTuple"


    // $ANTLR start "entryRuleListOfValues"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1755:1: entryRuleListOfValues returns [EObject current=null] : iv_ruleListOfValues= ruleListOfValues EOF ;
    public final EObject entryRuleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValues = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1756:2: (iv_ruleListOfValues= ruleListOfValues EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1757:2: iv_ruleListOfValues= ruleListOfValues EOF
            {
             newCompositeNode(grammarAccess.getListOfValuesRule()); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues3890);
            iv_ruleListOfValues=ruleListOfValues();

            state._fsp--;

             current =iv_ruleListOfValues; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues3900); 

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
    // $ANTLR end "entryRuleListOfValues"


    // $ANTLR start "ruleListOfValues"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1764:1: ruleListOfValues returns [EObject current=null] : ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfValues() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1767:28: ( ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1768:1: ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1768:1: ( ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1768:2: ( (lv_values_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1768:2: ( (lv_values_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1769:1: (lv_values_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1769:1: (lv_values_0_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1770:3: lv_values_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3946);
            lv_values_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getListOfValuesRule());
            	        }
                   		add(
                   			current, 
                   			"values",
                    		lv_values_0_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1786:2: (otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==18) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1786:4: otherlv_1= ',' ( (lv_values_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleListOfValues3959); 

            	        	newLeafNode(otherlv_1, grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1790:1: ( (lv_values_2_0= ruleExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1791:1: (lv_values_2_0= ruleExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1791:1: (lv_values_2_0= ruleExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1792:3: lv_values_2_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3980);
            	    lv_values_2_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getListOfValuesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_2_0, 
            	            		"Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // $ANTLR end "ruleListOfValues"


    // $ANTLR start "entryRuleListOfValueNamePairs"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1816:1: entryRuleListOfValueNamePairs returns [EObject current=null] : iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF ;
    public final EObject entryRuleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValueNamePairs = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1817:2: (iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1818:2: iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF
            {
             newCompositeNode(grammarAccess.getListOfValueNamePairsRule()); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs4018);
            iv_ruleListOfValueNamePairs=ruleListOfValueNamePairs();

            state._fsp--;

             current =iv_ruleListOfValueNamePairs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs4028); 

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
    // $ANTLR end "entryRuleListOfValueNamePairs"


    // $ANTLR start "ruleListOfValueNamePairs"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1825:1: ruleListOfValueNamePairs returns [EObject current=null] : ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) ;
    public final EObject ruleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_valueNamePairs_0_0 = null;

        EObject lv_valueNamePairs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1828:28: ( ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1829:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1829:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1829:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1829:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1830:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1830:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1831:3: lv_valueNamePairs_0_0= ruleValueNamePair
            {
             
            	        newCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4074);
            lv_valueNamePairs_0_0=ruleValueNamePair();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getListOfValueNamePairsRule());
            	        }
                   		add(
                   			current, 
                   			"valueNamePairs",
                    		lv_valueNamePairs_0_0, 
                    		"ValueNamePair");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1847:2: (otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==18) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1847:4: otherlv_1= ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleListOfValueNamePairs4087); 

            	        	newLeafNode(otherlv_1, grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1851:1: ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1852:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1852:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1853:3: lv_valueNamePairs_2_0= ruleValueNamePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4108);
            	    lv_valueNamePairs_2_0=ruleValueNamePair();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getListOfValueNamePairsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"valueNamePairs",
            	            		lv_valueNamePairs_2_0, 
            	            		"ValueNamePair");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // $ANTLR end "ruleListOfValueNamePairs"


    // $ANTLR start "entryRuleValueNamePair"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1877:1: entryRuleValueNamePair returns [EObject current=null] : iv_ruleValueNamePair= ruleValueNamePair EOF ;
    public final EObject entryRuleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNamePair = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1878:2: (iv_ruleValueNamePair= ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1879:2: iv_ruleValueNamePair= ruleValueNamePair EOF
            {
             newCompositeNode(grammarAccess.getValueNamePairRule()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair4146);
            iv_ruleValueNamePair=ruleValueNamePair();

            state._fsp--;

             current =iv_ruleValueNamePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair4156); 

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
    // $ANTLR end "entryRuleValueNamePair"


    // $ANTLR start "ruleValueNamePair"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1886:1: ruleValueNamePair returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueNamePair() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1889:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1890:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1890:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1890:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1890:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1891:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1891:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1892:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getValueNamePairRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueNamePair4201); 

            		newLeafNode(otherlv_0, grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleValueNamePair4213); 

                	newLeafNode(otherlv_1, grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1907:1: ( (lv_value_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1908:1: (lv_value_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1908:1: (lv_value_2_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1909:3: lv_value_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleValueNamePair4234);
            lv_value_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValueNamePairRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Expression");
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
    // $ANTLR end "ruleValueNamePair"


    // $ANTLR start "entryRuleTimeExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1933:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1934:2: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1935:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             newCompositeNode(grammarAccess.getTimeExpressionRule()); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4270);
            iv_ruleTimeExpression=ruleTimeExpression();

            state._fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression4280); 

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
    // $ANTLR end "entryRuleTimeExpression"


    // $ANTLR start "ruleTimeExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1942:1: ruleTimeExpression returns [EObject current=null] : (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_InstantObsExpression_0 = null;

        EObject this_DurationObsExpression_1 = null;

        EObject this_JitterExp_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1945:28: ( (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1946:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1946:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt32=1;
                }
                break;
            case 48:
                {
                alt32=2;
                }
                break;
            case 49:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1947:5: this_InstantObsExpression_0= ruleInstantObsExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4327);
                    this_InstantObsExpression_0=ruleInstantObsExpression();

                    state._fsp--;

                     
                            current = this_InstantObsExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1957:5: this_DurationObsExpression_1= ruleDurationObsExpression
                    {
                     
                            newCompositeNode(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4354);
                    this_DurationObsExpression_1=ruleDurationObsExpression();

                    state._fsp--;

                     
                            current = this_DurationObsExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1967:5: this_JitterExp_2= ruleJitterExp
                    {
                     
                            newCompositeNode(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleJitterExp_in_ruleTimeExpression4381);
                    this_JitterExp_2=ruleJitterExp();

                    state._fsp--;

                     
                            current = this_JitterExp_2; 
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
    // $ANTLR end "ruleTimeExpression"


    // $ANTLR start "entryRuleInstantObsExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1983:1: entryRuleInstantObsExpression returns [EObject current=null] : iv_ruleInstantObsExpression= ruleInstantObsExpression EOF ;
    public final EObject entryRuleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1984:2: (iv_ruleInstantObsExpression= ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1985:2: iv_ruleInstantObsExpression= ruleInstantObsExpression EOF
            {
             newCompositeNode(grammarAccess.getInstantObsExpressionRule()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4416);
            iv_ruleInstantObsExpression=ruleInstantObsExpression();

            state._fsp--;

             current =iv_ruleInstantObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression4426); 

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
    // $ANTLR end "entryRuleInstantObsExpression"


    // $ANTLR start "ruleInstantObsExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1992:1: ruleInstantObsExpression returns [EObject current=null] : (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) ;
    public final EObject ruleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1995:28: ( (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1996:1: (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1996:1: (otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1996:3: otherlv_0= '@' ( (lv_id_1_0= ruleInstantObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleInstantObsExpression4463); 

                	newLeafNode(otherlv_0, grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2000:1: ( (lv_id_1_0= ruleInstantObsName ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2001:1: (lv_id_1_0= ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2001:1: (lv_id_1_0= ruleInstantObsName )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2002:3: lv_id_1_0= ruleInstantObsName
            {
             
            	        newCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4484);
            lv_id_1_0=ruleInstantObsName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstantObsExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"InstantObsName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2018:2: (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2018:4: otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleInstantObsExpression4497); 

                        	newLeafNode(otherlv_2, grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2022:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2023:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2023:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2024:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4518);
                    lv_index_3_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstantObsExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_3_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleInstantObsExpression4530); 

                        	newLeafNode(otherlv_4, grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2044:3: (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==47) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2044:5: otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,47,FOLLOW_47_in_ruleInstantObsExpression4545); 

                        	newLeafNode(otherlv_5, grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0());
                        
                    otherlv_6=(Token)match(input,38,FOLLOW_38_in_ruleInstantObsExpression4557); 

                        	newLeafNode(otherlv_6, grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2052:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2053:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2053:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2054:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4578);
                    lv_condition_7_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstantObsExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"condition",
                            		lv_condition_7_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,39,FOLLOW_39_in_ruleInstantObsExpression4590); 

                        	newLeafNode(otherlv_8, grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_3_3());
                        

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
    // $ANTLR end "ruleInstantObsExpression"


    // $ANTLR start "entryRuleInstantObsName"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2082:1: entryRuleInstantObsName returns [EObject current=null] : iv_ruleInstantObsName= ruleInstantObsName EOF ;
    public final EObject entryRuleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2083:2: (iv_ruleInstantObsName= ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2084:2: iv_ruleInstantObsName= ruleInstantObsName EOF
            {
             newCompositeNode(grammarAccess.getInstantObsNameRule()); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4628);
            iv_ruleInstantObsName=ruleInstantObsName();

            state._fsp--;

             current =iv_ruleInstantObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName4638); 

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
    // $ANTLR end "entryRuleInstantObsName"


    // $ANTLR start "ruleInstantObsName"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2091:1: ruleInstantObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleInstantObsName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2094:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2095:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2095:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2095:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2095:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==40) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2096:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2096:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2097:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstantObsName4684);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstantObsNameRule());
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2113:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2114:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2114:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2115:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInstantObsNameRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstantObsName4705); 

            		newLeafNode(otherlv_1, grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleInstantObsName"


    // $ANTLR start "entryRuleDurationObsExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2134:1: entryRuleDurationObsExpression returns [EObject current=null] : iv_ruleDurationObsExpression= ruleDurationObsExpression EOF ;
    public final EObject entryRuleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2135:2: (iv_ruleDurationObsExpression= ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2136:2: iv_ruleDurationObsExpression= ruleDurationObsExpression EOF
            {
             newCompositeNode(grammarAccess.getDurationObsExpressionRule()); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4741);
            iv_ruleDurationObsExpression=ruleDurationObsExpression();

            state._fsp--;

             current =iv_ruleDurationObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression4751); 

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
    // $ANTLR end "entryRuleDurationObsExpression"


    // $ANTLR start "ruleDurationObsExpression"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2143:1: ruleDurationObsExpression returns [EObject current=null] : (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) ;
    public final EObject ruleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2146:28: ( (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2147:1: (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2147:1: (otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2147:3: otherlv_0= '&' ( (lv_id_1_0= ruleDurationObsName ) ) (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )? (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleDurationObsExpression4788); 

                	newLeafNode(otherlv_0, grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2151:1: ( (lv_id_1_0= ruleDurationObsName ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2152:1: (lv_id_1_0= ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2152:1: (lv_id_1_0= ruleDurationObsName )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2153:3: lv_id_1_0= ruleDurationObsName
            {
             
            	        newCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4809);
            lv_id_1_0=ruleDurationObsName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDurationObsExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"DurationObsName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2169:2: (otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==38) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2169:4: otherlv_2= '(' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleDurationObsExpression4822); 

                        	newLeafNode(otherlv_2, grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2173:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2174:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2174:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2175:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4843);
                    lv_index_3_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDurationObsExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_3_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleDurationObsExpression4855); 

                        	newLeafNode(otherlv_4, grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2195:3: (otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==47) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2195:5: otherlv_5= 'when' otherlv_6= '(' ( (lv_condition_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,47,FOLLOW_47_in_ruleDurationObsExpression4870); 

                        	newLeafNode(otherlv_5, grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0());
                        
                    otherlv_6=(Token)match(input,38,FOLLOW_38_in_ruleDurationObsExpression4882); 

                        	newLeafNode(otherlv_6, grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2203:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2204:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2204:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2205:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4903);
                    lv_condition_7_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDurationObsExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"condition",
                            		lv_condition_7_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,39,FOLLOW_39_in_ruleDurationObsExpression4915); 

                        	newLeafNode(otherlv_8, grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_3_3());
                        

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
    // $ANTLR end "ruleDurationObsExpression"


    // $ANTLR start "entryRuleDurationObsName"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2233:1: entryRuleDurationObsName returns [EObject current=null] : iv_ruleDurationObsName= ruleDurationObsName EOF ;
    public final EObject entryRuleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2234:2: (iv_ruleDurationObsName= ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2235:2: iv_ruleDurationObsName= ruleDurationObsName EOF
            {
             newCompositeNode(grammarAccess.getDurationObsNameRule()); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4953);
            iv_ruleDurationObsName=ruleDurationObsName();

            state._fsp--;

             current =iv_ruleDurationObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName4963); 

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
    // $ANTLR end "entryRuleDurationObsName"


    // $ANTLR start "ruleDurationObsName"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2242:1: ruleDurationObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDurationObsName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2245:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2246:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2246:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2246:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2246:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==40) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2247:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2247:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2248:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDurationObsName5009);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDurationObsNameRule());
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2264:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2265:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2265:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2266:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDurationObsNameRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDurationObsName5030); 

            		newLeafNode(otherlv_1, grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleDurationObsName"


    // $ANTLR start "entryRuleJitterExp"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2285:1: entryRuleJitterExp returns [EObject current=null] : iv_ruleJitterExp= ruleJitterExp EOF ;
    public final EObject entryRuleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJitterExp = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2286:2: (iv_ruleJitterExp= ruleJitterExp EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2287:2: iv_ruleJitterExp= ruleJitterExp EOF
            {
             newCompositeNode(grammarAccess.getJitterExpRule()); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp5066);
            iv_ruleJitterExp=ruleJitterExp();

            state._fsp--;

             current =iv_ruleJitterExp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp5076); 

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
    // $ANTLR end "entryRuleJitterExp"


    // $ANTLR start "ruleJitterExp"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2294:1: ruleJitterExp returns [EObject current=null] : (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' ) ;
    public final EObject ruleJitterExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_firstInstant_1_0 = null;

        EObject lv_secondInstant_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2297:28: ( (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2298:1: (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2298:1: (otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2298:3: otherlv_0= 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleJitterExp5113); 

                	newLeafNode(otherlv_0, grammarAccess.getJitterExpAccess().getJitterKeyword_0());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2302:1: ( (lv_firstInstant_1_0= ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2303:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2303:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2304:3: lv_firstInstant_1_0= ruleInstantObsExpression
            {
             
            	        newCompositeNode(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5134);
            lv_firstInstant_1_0=ruleInstantObsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJitterExpRule());
            	        }
                   		set(
                   			current, 
                   			"firstInstant",
                    		lv_firstInstant_1_0, 
                    		"InstantObsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2320:2: (otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==32) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2320:4: otherlv_2= '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleJitterExp5147); 

                        	newLeafNode(otherlv_2, grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2324:1: ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2325:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2325:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2326:3: lv_secondInstant_3_0= ruleInstantObsExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5168);
                    lv_secondInstant_3_0=ruleInstantObsExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getJitterExpRule());
                    	        }
                           		set(
                           			current, 
                           			"secondInstant",
                            		lv_secondInstant_3_0, 
                            		"InstantObsExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleJitterExp5182); 

                	newLeafNode(otherlv_4, grammarAccess.getJitterExpAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleJitterExp"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2354:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2355:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2356:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration5218);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration5228); 

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
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2363:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_variableDeclaration_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_initValue_7_0 = null;

        EObject lv_initValue_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2366:28: ( ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2367:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2367:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2367:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? otherlv_1= '$' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2367:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=51 && LA40_0<=53)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2368:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2368:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2369:3: lv_variableDeclaration_0_0= ruleVariableDirectionKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5274);
                    lv_variableDeclaration_0_0=ruleVariableDirectionKind();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"variableDeclaration",
                            		lv_variableDeclaration_0_0, 
                            		"VariableDirectionKind");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleVariableDeclaration5287); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1());
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2389:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2390:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2390:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2391:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration5304); 

            			newLeafNode(lv_name_2_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2407:2: ( (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? ) | (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==30) ) {
                alt42=1;
            }
            else if ( (LA42_0==19) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2407:3: (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2407:3: (otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )? )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2407:5: otherlv_3= ':' ( (lv_type_4_0= ruleDataTypeName ) ) (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )?
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleVariableDeclaration5323); 

                        	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2411:1: ( (lv_type_4_0= ruleDataTypeName ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2412:1: (lv_type_4_0= ruleDataTypeName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2412:1: (lv_type_4_0= ruleDataTypeName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2413:3: lv_type_4_0= ruleDataTypeName
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5344);
                    lv_type_4_0=ruleDataTypeName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"DataTypeName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2429:2: (otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==19) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2429:4: otherlv_5= '=' otherlv_6= '(' ( (lv_initValue_7_0= ruleExpression ) ) otherlv_8= ')'
                            {
                            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleVariableDeclaration5357); 

                                	newLeafNode(otherlv_5, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0());
                                
                            otherlv_6=(Token)match(input,38,FOLLOW_38_in_ruleVariableDeclaration5369); 

                                	newLeafNode(otherlv_6, grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1());
                                
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2437:1: ( (lv_initValue_7_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2438:1: (lv_initValue_7_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2438:1: (lv_initValue_7_0= ruleExpression )
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2439:3: lv_initValue_7_0= ruleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5390);
                            lv_initValue_7_0=ruleExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"initValue",
                                    		lv_initValue_7_0, 
                                    		"Expression");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_8=(Token)match(input,39,FOLLOW_39_in_ruleVariableDeclaration5402); 

                                	newLeafNode(otherlv_8, grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2460:6: (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2460:6: (otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2460:8: otherlv_9= '=' otherlv_10= '(' ( (lv_initValue_11_0= ruleExpression ) ) otherlv_12= ')'
                    {
                    otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleVariableDeclaration5424); 

                        	newLeafNode(otherlv_9, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0());
                        
                    otherlv_10=(Token)match(input,38,FOLLOW_38_in_ruleVariableDeclaration5436); 

                        	newLeafNode(otherlv_10, grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1());
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2468:1: ( (lv_initValue_11_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2469:1: (lv_initValue_11_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2469:1: (lv_initValue_11_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2470:3: lv_initValue_11_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5457);
                    lv_initValue_11_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"initValue",
                            		lv_initValue_11_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,39,FOLLOW_39_in_ruleVariableDeclaration5469); 

                        	newLeafNode(otherlv_12, grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_1_3());
                        

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
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleVariableDirectionKind"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2498:1: entryRuleVariableDirectionKind returns [String current=null] : iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF ;
    public final String entryRuleVariableDirectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableDirectionKind = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2499:2: (iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2500:2: iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF
            {
             newCompositeNode(grammarAccess.getVariableDirectionKindRule()); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5508);
            iv_ruleVariableDirectionKind=ruleVariableDirectionKind();

            state._fsp--;

             current =iv_ruleVariableDirectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind5519); 

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
    // $ANTLR end "entryRuleVariableDirectionKind"


    // $ANTLR start "ruleVariableDirectionKind"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2507:1: ruleVariableDirectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleVariableDirectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2510:28: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2511:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2511:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt43=1;
                }
                break;
            case 52:
                {
                alt43=2;
                }
                break;
            case 53:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2512:2: kw= 'in'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleVariableDirectionKind5557); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableDirectionKindAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2519:2: kw= 'out'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleVariableDirectionKind5576); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2526:2: kw= 'inout'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleVariableDirectionKind5595); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVariableDirectionKindAccess().getInoutKeyword_2()); 
                        

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
    // $ANTLR end "ruleVariableDirectionKind"


    // $ANTLR start "entryRuleDataTypeName"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2539:1: entryRuleDataTypeName returns [EObject current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final EObject entryRuleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2540:2: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2541:2: iv_ruleDataTypeName= ruleDataTypeName EOF
            {
             newCompositeNode(grammarAccess.getDataTypeNameRule()); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5635);
            iv_ruleDataTypeName=ruleDataTypeName();

            state._fsp--;

             current =iv_ruleDataTypeName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName5645); 

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
    // $ANTLR end "entryRuleDataTypeName"


    // $ANTLR start "ruleDataTypeName"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2548:1: ruleDataTypeName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDataTypeName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2551:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2552:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2552:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2552:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2552:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==40) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2553:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2553:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2554:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDataTypeName5691);
                    lv_path_0_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDataTypeNameRule());
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2570:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2571:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2571:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2572:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDataTypeNameRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataTypeName5712); 

            		newLeafNode(otherlv_1, grammarAccess.getDataTypeNameAccess().getTypeDataTypeCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleDataTypeName"


    // $ANTLR start "entryRuleNumberLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2591:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2592:2: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2593:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5748);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();

            state._fsp--;

             current =iv_ruleNumberLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule5758); 

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
    // $ANTLR end "entryRuleNumberLiteralRule"


    // $ANTLR start "ruleNumberLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2600:1: ruleNumberLiteralRule returns [EObject current=null] : (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteralRule_0 = null;

        EObject this_UnlimitedLiteralRule_1 = null;

        EObject this_RealLiteralRule_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2603:28: ( (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2604:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2604:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            int alt45=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
                {
                alt45=1;
                }
                break;
            case 33:
                {
                alt45=2;
                }
                break;
            case RULE_REALLITERAL:
                {
                alt45=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2605:5: this_IntegerLiteralRule_0= ruleIntegerLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5805);
                    this_IntegerLiteralRule_0=ruleIntegerLiteralRule();

                    state._fsp--;

                     
                            current = this_IntegerLiteralRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2615:5: this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5832);
                    this_UnlimitedLiteralRule_1=ruleUnlimitedLiteralRule();

                    state._fsp--;

                     
                            current = this_UnlimitedLiteralRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2625:5: this_RealLiteralRule_2= ruleRealLiteralRule
                    {
                     
                            newCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5859);
                    this_RealLiteralRule_2=ruleRealLiteralRule();

                    state._fsp--;

                     
                            current = this_RealLiteralRule_2; 
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
    // $ANTLR end "ruleNumberLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2641:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2642:2: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2643:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getIntegerLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5894);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();

            state._fsp--;

             current =iv_ruleIntegerLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule5904); 

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
    // $ANTLR end "entryRuleIntegerLiteralRule"


    // $ANTLR start "ruleIntegerLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2650:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2653:28: ( ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2654:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2654:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2655:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2655:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2656:3: lv_value_0_0= RULE_INTEGERLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5945); 

            			newLeafNode(lv_value_0_0, grammarAccess.getIntegerLiteralRuleAccess().getValueIntegerLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntegerLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"IntegerLiteral");
            	    

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
    // $ANTLR end "ruleIntegerLiteralRule"


    // $ANTLR start "entryRuleUnlimitedLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2680:1: entryRuleUnlimitedLiteralRule returns [EObject current=null] : iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF ;
    public final EObject entryRuleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2681:2: (iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2682:2: iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getUnlimitedLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5985);
            iv_ruleUnlimitedLiteralRule=ruleUnlimitedLiteralRule();

            state._fsp--;

             current =iv_ruleUnlimitedLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5995); 

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
    // $ANTLR end "entryRuleUnlimitedLiteralRule"


    // $ANTLR start "ruleUnlimitedLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2689:1: ruleUnlimitedLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '*' ) ) ;
    public final EObject ruleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2692:28: ( ( (lv_value_0_0= '*' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2693:1: ( (lv_value_0_0= '*' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2693:1: ( (lv_value_0_0= '*' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2694:1: (lv_value_0_0= '*' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2694:1: (lv_value_0_0= '*' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2695:3: lv_value_0_0= '*'
            {
            lv_value_0_0=(Token)match(input,33,FOLLOW_33_in_ruleUnlimitedLiteralRule6037); 

                    newLeafNode(lv_value_0_0, grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnlimitedLiteralRuleRule());
            	        }
                   		setWithLastConsumed(current, "value", lv_value_0_0, "*");
            	    

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
    // $ANTLR end "ruleUnlimitedLiteralRule"


    // $ANTLR start "entryRuleRealLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2716:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2717:2: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2718:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule6085);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();

            state._fsp--;

             current =iv_ruleRealLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule6095); 

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
    // $ANTLR end "entryRuleRealLiteralRule"


    // $ANTLR start "ruleRealLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2725:1: ruleRealLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_REALLITERAL ) ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2728:28: ( ( (lv_value_0_0= RULE_REALLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2729:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2729:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2730:1: (lv_value_0_0= RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2730:1: (lv_value_0_0= RULE_REALLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2731:3: lv_value_0_0= RULE_REALLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule6136); 

            			newLeafNode(lv_value_0_0, grammarAccess.getRealLiteralRuleAccess().getValueRealLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRealLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"RealLiteral");
            	    

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
    // $ANTLR end "ruleRealLiteralRule"


    // $ANTLR start "entryRuleDateTimeLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2755:1: entryRuleDateTimeLiteralRule returns [EObject current=null] : iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF ;
    public final EObject entryRuleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTimeLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2756:2: (iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2757:2: iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getDateTimeLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule6176);
            iv_ruleDateTimeLiteralRule=ruleDateTimeLiteralRule();

            state._fsp--;

             current =iv_ruleDateTimeLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule6186); 

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
    // $ANTLR end "entryRuleDateTimeLiteralRule"


    // $ANTLR start "ruleDateTimeLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2764:1: ruleDateTimeLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) ;
    public final EObject ruleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2767:28: ( ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2768:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2768:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2769:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2769:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2770:3: lv_value_0_0= RULE_DATETIMELITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule6227); 

            			newLeafNode(lv_value_0_0, grammarAccess.getDateTimeLiteralRuleAccess().getValueDateTimeLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDateTimeLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"DateTimeLiteral");
            	    

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
    // $ANTLR end "ruleDateTimeLiteralRule"


    // $ANTLR start "entryRuleBooleanLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2794:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2795:2: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2796:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6267);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();

            state._fsp--;

             current =iv_ruleBooleanLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule6277); 

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
    // $ANTLR end "entryRuleBooleanLiteralRule"


    // $ANTLR start "ruleBooleanLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2803:1: ruleBooleanLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2806:28: ( ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2807:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2807:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2808:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2808:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2809:3: lv_value_0_0= RULE_BOOLEANLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6318); 

            			newLeafNode(lv_value_0_0, grammarAccess.getBooleanLiteralRuleAccess().getValueBooleanLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBooleanLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"BooleanLiteral");
            	    

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
    // $ANTLR end "ruleBooleanLiteralRule"


    // $ANTLR start "entryRuleNullLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2833:1: entryRuleNullLiteralRule returns [EObject current=null] : iv_ruleNullLiteralRule= ruleNullLiteralRule EOF ;
    public final EObject entryRuleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2834:2: (iv_ruleNullLiteralRule= ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2835:2: iv_ruleNullLiteralRule= ruleNullLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getNullLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6358);
            iv_ruleNullLiteralRule=ruleNullLiteralRule();

            state._fsp--;

             current =iv_ruleNullLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule6368); 

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
    // $ANTLR end "entryRuleNullLiteralRule"


    // $ANTLR start "ruleNullLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2842:1: ruleNullLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_NULLLITERAL ) ) ;
    public final EObject ruleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2845:28: ( ( (lv_value_0_0= RULE_NULLLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2846:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2846:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2847:1: (lv_value_0_0= RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2847:1: (lv_value_0_0= RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2848:3: lv_value_0_0= RULE_NULLLITERAL
            {
            lv_value_0_0=(Token)match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6409); 

            			newLeafNode(lv_value_0_0, grammarAccess.getNullLiteralRuleAccess().getValueNullLiteralTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNullLiteralRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"NullLiteral");
            	    

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
    // $ANTLR end "ruleNullLiteralRule"


    // $ANTLR start "entryRuleDefaultLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2872:1: entryRuleDefaultLiteralRule returns [EObject current=null] : iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF ;
    public final EObject entryRuleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2873:2: (iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2874:2: iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getDefaultLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6449);
            iv_ruleDefaultLiteralRule=ruleDefaultLiteralRule();

            state._fsp--;

             current =iv_ruleDefaultLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule6459); 

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
    // $ANTLR end "entryRuleDefaultLiteralRule"


    // $ANTLR start "ruleDefaultLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2881:1: ruleDefaultLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '/' ) ) ;
    public final EObject ruleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2884:28: ( ( (lv_value_0_0= '/' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2885:1: ( (lv_value_0_0= '/' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2885:1: ( (lv_value_0_0= '/' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2886:1: (lv_value_0_0= '/' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2886:1: (lv_value_0_0= '/' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2887:3: lv_value_0_0= '/'
            {
            lv_value_0_0=(Token)match(input,34,FOLLOW_34_in_ruleDefaultLiteralRule6501); 

                    newLeafNode(lv_value_0_0, grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDefaultLiteralRuleRule());
            	        }
                   		setWithLastConsumed(current, "value", lv_value_0_0, "/");
            	    

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
    // $ANTLR end "ruleDefaultLiteralRule"


    // $ANTLR start "entryRuleStringLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2908:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2909:2: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2910:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6549);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();

            state._fsp--;

             current =iv_ruleStringLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule6559); 

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
    // $ANTLR end "entryRuleStringLiteralRule"


    // $ANTLR start "ruleStringLiteralRule"
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2917:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2920:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2921:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2921:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2922:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2922:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2923:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteralRule6600); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringLiteralRuleRule());
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
    // $ANTLR end "ruleStringLiteralRule"

    // Delegated rules


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\13\uffff";
    static final String DFA18_eofS =
        "\13\uffff";
    static final String DFA18_minS =
        "\1\4\3\uffff\1\4\3\uffff\1\22\2\uffff";
    static final String DFA18_maxS =
        "\1\65\3\uffff\1\65\3\uffff\1\55\2\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\1\10\1\uffff\1\4\1\5";
    static final String DFA18_specialS =
        "\13\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\6\1\26\uffff\2\1\3\uffff\1\7\2\uffff\2\3\1\uffff\1\4\1"+
            "\uffff\1\5\1\uffff\2\5\4\6",
            "",
            "",
            "",
            "\1\10\6\11\24\uffff\4\11\1\uffff\1\11\1\uffff\1\11\2\uffff"+
            "\2\11\1\uffff\1\11\1\uffff\1\11\1\uffff\6\11",
            "",
            "",
            "",
            "\1\11\1\12\12\11\1\uffff\5\11\1\uffff\2\11\1\uffff\1\11\4"+
            "\uffff\1\11",
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
            return "1073:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleStereotypeApplicationsRule_in_entryRuleStereotypeApplicationsRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStereotypeApplicationsRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStereotypeApplicationRule_in_ruleStereotypeApplicationsRule130 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleStereotypeApplicationRule_in_entryRuleStereotypeApplicationRule166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStereotypeApplicationRule176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleStereotypeApplicationRule213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStereotypeApplicationRule233 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleStereotypeApplicationRule245 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTagSpecificationRule_in_ruleStereotypeApplicationRule267 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleStereotypeApplicationRule280 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTagSpecificationRule_in_ruleStereotypeApplicationRule301 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleTagSpecificationRule_in_entryRuleTagSpecificationRule341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTagSpecificationRule351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTagSpecificationRule396 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleExpressionValueRule_in_ruleTagSpecificationRule417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionValueRule_in_entryRuleExpressionValueRule453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionValueRule463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleExpressionValueRule500 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionValueRule521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_ruleExpression612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression703 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_20_in_ruleAndOrXorExpression724 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_21_in_ruleAndOrXorExpression753 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_22_in_ruleAndOrXorExpression782 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression819 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression913 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_23_in_ruleEqualityExpression934 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_24_in_ruleEqualityExpression963 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1000 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1094 = new BitSet(new long[]{0x000000001E000002L});
    public static final BitSet FOLLOW_25_in_ruleRelationalExpression1115 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_26_in_ruleRelationalExpression1144 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_27_in_ruleRelationalExpression1173 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_28_in_ruleRelationalExpression1202 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1239 = new BitSet(new long[]{0x000000001E000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1333 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleConditionalExpression1352 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1386 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleConditionalExpression1398 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1513 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_31_in_ruleAdditiveExpression1534 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_32_in_ruleAdditiveExpression1563 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1600 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1694 = new BitSet(new long[]{0x0000000E00000002L});
    public static final BitSet FOLLOW_33_in_ruleMultiplicativeExpression1715 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_34_in_ruleMultiplicativeExpression1744 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_35_in_ruleMultiplicativeExpression1773 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1810 = new BitSet(new long[]{0x0000000E00000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnaryExpression1904 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_32_in_ruleUnaryExpression1933 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_31_in_ruleUnaryExpression1962 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rulePrimaryExpression2119 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_rulePrimaryExpression2132 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleValueSpecification2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleValueSpecification2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleValueSpecification2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleValueSpecification2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleValueSpecification2428 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueSpecification2450 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleValueSpecification2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2498 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2617 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression2627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyCallExpression2672 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_rulePropertyCallExpression2685 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpression2799 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleOperationCallExpression2811 = new BitSet(new long[]{0x003F56D7800007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2832 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleOperationCallExpression2845 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleOperationCallExpression2858 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral3001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral3028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_ruleLiteral3055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral3082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_ruleLiteral3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall3144 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3200 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3221 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleNameOrChoiceOrBehaviorCall3234 = new BitSet(new long[]{0x003F56D7800007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3255 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleNameOrChoiceOrBehaviorCall3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3361 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleQualifiedName3373 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval3431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval3441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleInterval3479 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_42_in_ruleInterval3503 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3538 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleInterval3550 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3571 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_41_in_ruleInterval3590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleInterval3621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3658 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleCollectionOrTuple3705 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3726 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleCollectionOrTuple3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple3774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple3784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleTuple3821 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3842 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleTuple3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues3890 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues3900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3946 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleListOfValues3959 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3980 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs4018 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs4028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4074 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleListOfValueNamePairs4087 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4108 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair4146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueNamePair4201 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleValueNamePair4213 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueNamePair4234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_ruleTimeExpression4381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression4426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleInstantObsExpression4463 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4484 = new BitSet(new long[]{0x0000804000000002L});
    public static final BitSet FOLLOW_38_in_ruleInstantObsExpression4497 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4518 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleInstantObsExpression4530 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleInstantObsExpression4545 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleInstantObsExpression4557 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4578 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleInstantObsExpression4590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstantObsName4684 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstantObsName4705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression4751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleDurationObsExpression4788 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4809 = new BitSet(new long[]{0x0000804000000002L});
    public static final BitSet FOLLOW_38_in_ruleDurationObsExpression4822 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4843 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleDurationObsExpression4855 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleDurationObsExpression4870 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleDurationObsExpression4882 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4903 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleDurationObsExpression4915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName4963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDurationObsName5009 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDurationObsName5030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp5066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleJitterExp5113 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5134 = new BitSet(new long[]{0x0000008100000000L});
    public static final BitSet FOLLOW_32_in_ruleJitterExp5147 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5168 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleJitterExp5182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration5218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration5228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5274 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleVariableDeclaration5287 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration5304 = new BitSet(new long[]{0x0000000040080000L});
    public static final BitSet FOLLOW_30_in_ruleVariableDeclaration5323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5344 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVariableDeclaration5357 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleVariableDeclaration5369 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5390 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleVariableDeclaration5402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleVariableDeclaration5424 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleVariableDeclaration5436 = new BitSet(new long[]{0x003F5657800007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5457 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleVariableDeclaration5469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind5519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleVariableDirectionKind5557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleVariableDirectionKind5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleVariableDirectionKind5595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName5645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDataTypeName5691 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeName5712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule5758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule5904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleUnlimitedLiteralRule6037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule6085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule6095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule6136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule6176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule6186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule6227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule6277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule6368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6449 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule6459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleDefaultLiteralRule6501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteralRule6600 = new BitSet(new long[]{0x0000000000000002L});

}