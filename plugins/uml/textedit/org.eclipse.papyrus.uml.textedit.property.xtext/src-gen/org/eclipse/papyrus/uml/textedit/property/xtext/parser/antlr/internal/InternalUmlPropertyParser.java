/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.property.xtext.parser.antlr.internal; 

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
import org.eclipse.papyrus.uml.textedit.property.xtext.services.UmlPropertyGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlPropertyParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'/'", "':'", "'<Undefined>'", "'::'", "'['", "'..'", "']'", "'*'", "'{'", "','", "'}'", "'redefines'", "'subsets'", "'='", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'"
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
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalUmlPropertyParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlPropertyParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlPropertyParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g"; }



     	private UmlPropertyGrammarAccess grammarAccess;
     	
        public InternalUmlPropertyParser(TokenStream input, UmlPropertyGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "PropertyRule";	
       	}
       	
       	@Override
       	protected UmlPropertyGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRulePropertyRule"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:68:1: entryRulePropertyRule returns [EObject current=null] : iv_rulePropertyRule= rulePropertyRule EOF ;
    public final EObject entryRulePropertyRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:69:2: (iv_rulePropertyRule= rulePropertyRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:70:2: iv_rulePropertyRule= rulePropertyRule EOF
            {
             newCompositeNode(grammarAccess.getPropertyRuleRule()); 
            pushFollow(FOLLOW_rulePropertyRule_in_entryRulePropertyRule75);
            iv_rulePropertyRule=rulePropertyRule();

            state._fsp--;

             current =iv_rulePropertyRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyRule85); 

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
    // $ANTLR end "entryRulePropertyRule"


    // $ANTLR start "rulePropertyRule"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:77:1: rulePropertyRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )? ) ;
    public final EObject rulePropertyRule() throws RecognitionException {
        EObject current = null;

        Token lv_isDerived_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_visibility_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_multiplicity_6_0 = null;

        EObject lv_modifiers_7_0 = null;

        EObject lv_default_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:80:28: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )? ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:81:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )? )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )?
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:81:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:82:1: (lv_visibility_0_0= ruleVisibilityKind )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:83:3: lv_visibility_0_0= ruleVisibilityKind
            {
             
            	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVisibilityKind_in_rulePropertyRule131);
            lv_visibility_0_0=ruleVisibilityKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
            	        }
                   		set(
                   			current, 
                   			"visibility",
                    		lv_visibility_0_0, 
                    		"VisibilityKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:99:2: ( (lv_isDerived_1_0= '/' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:100:1: (lv_isDerived_1_0= '/' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:100:1: (lv_isDerived_1_0= '/' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:101:3: lv_isDerived_1_0= '/'
                    {
                    lv_isDerived_1_0=(Token)match(input,11,FOLLOW_11_in_rulePropertyRule149); 

                            newLeafNode(lv_isDerived_1_0, grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPropertyRuleRule());
                    	        }
                           		setWithLastConsumed(current, "isDerived", lv_isDerived_1_0, "/");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:114:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:115:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:115:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:116:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyRule180); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_rulePropertyRule197); 

                	newLeafNode(otherlv_3, grammarAccess.getPropertyRuleAccess().getColonKeyword_3());
                
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:136:1: ( ( (lv_type_4_0= ruleTypeRule ) ) | otherlv_5= '<Undefined>' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:136:2: ( (lv_type_4_0= ruleTypeRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:136:2: ( (lv_type_4_0= ruleTypeRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:137:1: (lv_type_4_0= ruleTypeRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:137:1: (lv_type_4_0= ruleTypeRule )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:138:3: lv_type_4_0= ruleTypeRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRule_in_rulePropertyRule219);
                    lv_type_4_0=ruleTypeRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:155:7: otherlv_5= '<Undefined>'
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_rulePropertyRule237); 

                        	newLeafNode(otherlv_5, grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:159:2: ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:160:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:160:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:161:3: lv_multiplicity_6_0= ruleMultiplicityRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiplicityRule_in_rulePropertyRule259);
                    lv_multiplicity_6_0=ruleMultiplicityRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
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

            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:177:3: ( (lv_modifiers_7_0= ruleModifiersRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:178:1: (lv_modifiers_7_0= ruleModifiersRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:178:1: (lv_modifiers_7_0= ruleModifiersRule )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:179:3: lv_modifiers_7_0= ruleModifiersRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModifiersRule_in_rulePropertyRule281);
                    lv_modifiers_7_0=ruleModifiersRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
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

            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:195:3: ( (lv_default_8_0= ruleDefaultValueRule ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==24) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:196:1: (lv_default_8_0= ruleDefaultValueRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:196:1: (lv_default_8_0= ruleDefaultValueRule )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:197:3: lv_default_8_0= ruleDefaultValueRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDefaultValueRule_in_rulePropertyRule303);
                    lv_default_8_0=ruleDefaultValueRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"default",
                            		lv_default_8_0, 
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
    // $ANTLR end "rulePropertyRule"


    // $ANTLR start "entryRuleTypeRule"
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:221:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:222:2: (iv_ruleTypeRule= ruleTypeRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:223:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
             newCompositeNode(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule340);
            iv_ruleTypeRule=ruleTypeRule();

            state._fsp--;

             current =iv_ruleTypeRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule350); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:230:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:233:28: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:234:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:234:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:234:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:234:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==14) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:235:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:235:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:236:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeRule396);
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

            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:252:3: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:253:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:253:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:254:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRule417); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:273:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:274:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:275:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName453);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName463); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:282:1: ruleQualifiedName returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_remaining_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:285:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:286:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:286:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:286:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:286:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:287:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:287:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:288:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName508); 

            		newLeafNode(otherlv_0, grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleQualifiedName520); 

                	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1());
                
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:303:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==14) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:304:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:304:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:305:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName541);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:329:1: entryRuleMultiplicityRule returns [EObject current=null] : iv_ruleMultiplicityRule= ruleMultiplicityRule EOF ;
    public final EObject entryRuleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:330:2: (iv_ruleMultiplicityRule= ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:331:2: iv_ruleMultiplicityRule= ruleMultiplicityRule EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule578);
            iv_ruleMultiplicityRule=ruleMultiplicityRule();

            state._fsp--;

             current =iv_ruleMultiplicityRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule588); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:338:1: ruleMultiplicityRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_bounds_1_0 = null;

        EObject lv_bounds_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:341:28: ( (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:342:1: (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:342:1: (otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:342:3: otherlv_0= '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleMultiplicityRule625); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:346:1: ( (lv_bounds_1_0= ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:347:1: (lv_bounds_1_0= ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:347:1: (lv_bounds_1_0= ruleBoundSpecification )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:348:3: lv_bounds_1_0= ruleBoundSpecification
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule646);
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

            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:364:2: (otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:364:4: otherlv_2= '..' ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleMultiplicityRule659); 

                        	newLeafNode(otherlv_2, grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:368:1: ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:369:1: (lv_bounds_3_0= ruleBoundSpecification )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:369:1: (lv_bounds_3_0= ruleBoundSpecification )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:370:3: lv_bounds_3_0= ruleBoundSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule680);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleMultiplicityRule694); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:398:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
    public final EObject entryRuleBoundSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundSpecification = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:399:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:400:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
            {
             newCompositeNode(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification730);
            iv_ruleBoundSpecification=ruleBoundSpecification();

            state._fsp--;

             current =iv_ruleBoundSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification740); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:407:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleUnlimitedLiteral ) ) ;
    public final EObject ruleBoundSpecification() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:410:28: ( ( (lv_value_0_0= ruleUnlimitedLiteral ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:411:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:411:1: ( (lv_value_0_0= ruleUnlimitedLiteral ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:412:1: (lv_value_0_0= ruleUnlimitedLiteral )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:412:1: (lv_value_0_0= ruleUnlimitedLiteral )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:413:3: lv_value_0_0= ruleUnlimitedLiteral
            {
             
            	        newCompositeNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_ruleBoundSpecification785);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:437:1: entryRuleUnlimitedLiteral returns [String current=null] : iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF ;
    public final String entryRuleUnlimitedLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnlimitedLiteral = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:438:2: (iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:439:2: iv_ruleUnlimitedLiteral= ruleUnlimitedLiteral EOF
            {
             newCompositeNode(grammarAccess.getUnlimitedLiteralRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral821);
            iv_ruleUnlimitedLiteral=ruleUnlimitedLiteral();

            state._fsp--;

             current =iv_ruleUnlimitedLiteral.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteral832); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:446:1: ruleUnlimitedLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUnlimitedLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:449:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:450:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:450:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                alt9=1;
            }
            else if ( (LA9_0==18) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:450:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleUnlimitedLiteral872); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getUnlimitedLiteralAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:459:2: kw= '*'
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleUnlimitedLiteral896); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:472:1: entryRuleModifiersRule returns [EObject current=null] : iv_ruleModifiersRule= ruleModifiersRule EOF ;
    public final EObject entryRuleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifiersRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:473:2: (iv_ruleModifiersRule= ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:474:2: iv_ruleModifiersRule= ruleModifiersRule EOF
            {
             newCompositeNode(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule936);
            iv_ruleModifiersRule=ruleModifiersRule();

            state._fsp--;

             current =iv_ruleModifiersRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule946); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:481:1: ruleModifiersRule returns [EObject current=null] : (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' ) ;
    public final EObject ruleModifiersRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:484:28: ( (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:485:1: (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:485:1: (otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}' )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:485:3: otherlv_0= '{' ( (lv_values_1_0= ruleModifierSpecification ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleModifiersRule983); 

                	newLeafNode(otherlv_0, grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:489:1: ( (lv_values_1_0= ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:490:1: (lv_values_1_0= ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:490:1: (lv_values_1_0= ruleModifierSpecification )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:491:3: lv_values_1_0= ruleModifierSpecification
            {
             
            	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1004);
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

            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:507:2: (otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:507:4: otherlv_2= ',' ( (lv_values_3_0= ruleModifierSpecification ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleModifiersRule1017); 

            	        	newLeafNode(otherlv_2, grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:511:1: ( (lv_values_3_0= ruleModifierSpecification ) )
            	    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:512:1: (lv_values_3_0= ruleModifierSpecification )
            	    {
            	    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:512:1: (lv_values_3_0= ruleModifierSpecification )
            	    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:513:3: lv_values_3_0= ruleModifierSpecification
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1038);
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
            	    break loop10;
                }
            } while (true);

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleModifiersRule1052); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:541:1: entryRuleModifierSpecification returns [EObject current=null] : iv_ruleModifierSpecification= ruleModifierSpecification EOF ;
    public final EObject entryRuleModifierSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierSpecification = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:542:2: (iv_ruleModifierSpecification= ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:543:2: iv_ruleModifierSpecification= ruleModifierSpecification EOF
            {
             newCompositeNode(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification1088);
            iv_ruleModifierSpecification=ruleModifierSpecification();

            state._fsp--;

             current =iv_ruleModifierSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification1098); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:550:1: ruleModifierSpecification returns [EObject current=null] : ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) ;
    public final EObject ruleModifierSpecification() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;

        EObject lv_redefines_1_0 = null;

        EObject lv_subsets_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:553:28: ( ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:554:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:554:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 29:
            case 30:
            case 31:
            case 32:
                {
                alt11=1;
                }
                break;
            case 22:
                {
                alt11=2;
                }
                break;
            case 23:
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:554:2: ( (lv_value_0_0= ruleModifierKind ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:554:2: ( (lv_value_0_0= ruleModifierKind ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:555:1: (lv_value_0_0= ruleModifierKind )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:555:1: (lv_value_0_0= ruleModifierKind )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:556:3: lv_value_0_0= ruleModifierKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModifierKind_in_ruleModifierSpecification1144);
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:573:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:573:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:574:1: (lv_redefines_1_0= ruleRedefinesRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:574:1: (lv_redefines_1_0= ruleRedefinesRule )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:575:3: lv_redefines_1_0= ruleRedefinesRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRedefinesRule_in_ruleModifierSpecification1171);
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:592:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:592:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:593:1: (lv_subsets_2_0= ruleSubsetsRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:593:1: (lv_subsets_2_0= ruleSubsetsRule )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:594:3: lv_subsets_2_0= ruleSubsetsRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSubsetsRule_in_ruleModifierSpecification1198);
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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:618:1: entryRuleRedefinesRule returns [EObject current=null] : iv_ruleRedefinesRule= ruleRedefinesRule EOF ;
    public final EObject entryRuleRedefinesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRedefinesRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:619:2: (iv_ruleRedefinesRule= ruleRedefinesRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:620:2: iv_ruleRedefinesRule= ruleRedefinesRule EOF
            {
             newCompositeNode(grammarAccess.getRedefinesRuleRule()); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule1234);
            iv_ruleRedefinesRule=ruleRedefinesRule();

            state._fsp--;

             current =iv_ruleRedefinesRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRedefinesRule1244); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:627:1: ruleRedefinesRule returns [EObject current=null] : (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleRedefinesRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:630:28: ( (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:631:1: (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:631:1: (otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:631:3: otherlv_0= 'redefines' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleRedefinesRule1281); 

                	newLeafNode(otherlv_0, grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:635:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:636:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:636:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:637:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRedefinesRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRedefinesRule1301); 

            		newLeafNode(otherlv_1, grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            	

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:656:1: entryRuleSubsetsRule returns [EObject current=null] : iv_ruleSubsetsRule= ruleSubsetsRule EOF ;
    public final EObject entryRuleSubsetsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubsetsRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:657:2: (iv_ruleSubsetsRule= ruleSubsetsRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:658:2: iv_ruleSubsetsRule= ruleSubsetsRule EOF
            {
             newCompositeNode(grammarAccess.getSubsetsRuleRule()); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule1337);
            iv_ruleSubsetsRule=ruleSubsetsRule();

            state._fsp--;

             current =iv_ruleSubsetsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubsetsRule1347); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:665:1: ruleSubsetsRule returns [EObject current=null] : (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleSubsetsRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:668:28: ( (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:669:1: (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:669:1: (otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:669:3: otherlv_0= 'subsets' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleSubsetsRule1384); 

                	newLeafNode(otherlv_0, grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:673:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:674:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:674:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:675:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSubsetsRuleRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubsetsRule1404); 

            		newLeafNode(otherlv_1, grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0()); 
            	

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:694:1: entryRuleDefaultValueRule returns [EObject current=null] : iv_ruleDefaultValueRule= ruleDefaultValueRule EOF ;
    public final EObject entryRuleDefaultValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultValueRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:695:2: (iv_ruleDefaultValueRule= ruleDefaultValueRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:696:2: iv_ruleDefaultValueRule= ruleDefaultValueRule EOF
            {
             newCompositeNode(grammarAccess.getDefaultValueRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule1440);
            iv_ruleDefaultValueRule=ruleDefaultValueRule();

            state._fsp--;

             current =iv_ruleDefaultValueRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultValueRule1450); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:703:1: ruleDefaultValueRule returns [EObject current=null] : (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleDefaultValueRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_default_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:706:28: ( (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:707:1: (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:707:1: (otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:707:3: otherlv_0= '=' ( (lv_default_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleDefaultValueRule1487); 

                	newLeafNode(otherlv_0, grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:711:1: ( (lv_default_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:712:1: (lv_default_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:712:1: (lv_default_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:713:3: lv_default_1_0= RULE_STRING
            {
            lv_default_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDefaultValueRule1504); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:737:1: ruleVisibilityKind returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) ;
    public final Enumerator ruleVisibilityKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:739:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:740:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:740:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '#' ) | (enumLiteral_3= '~' ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt12=1;
                }
                break;
            case 26:
                {
                alt12=2;
                }
                break;
            case 27:
                {
                alt12=3;
                }
                break;
            case 28:
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:740:2: (enumLiteral_0= '+' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:740:2: (enumLiteral_0= '+' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:740:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,25,FOLLOW_25_in_ruleVisibilityKind1559); 

                            current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:746:6: (enumLiteral_1= '-' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:746:6: (enumLiteral_1= '-' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:746:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,26,FOLLOW_26_in_ruleVisibilityKind1576); 

                            current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:752:6: (enumLiteral_2= '#' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:752:6: (enumLiteral_2= '#' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:752:8: enumLiteral_2= '#'
                    {
                    enumLiteral_2=(Token)match(input,27,FOLLOW_27_in_ruleVisibilityKind1593); 

                            current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:758:6: (enumLiteral_3= '~' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:758:6: (enumLiteral_3= '~' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:758:8: enumLiteral_3= '~'
                    {
                    enumLiteral_3=(Token)match(input,28,FOLLOW_28_in_ruleVisibilityKind1610); 

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
    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:768:1: ruleModifierKind returns [Enumerator current=null] : ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) ;
    public final Enumerator ruleModifierKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:770:28: ( ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:771:1: ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:771:1: ( (enumLiteral_0= 'readOnly' ) | (enumLiteral_1= 'union' ) | (enumLiteral_2= 'ordered' ) | (enumLiteral_3= 'unique' ) )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt13=1;
                }
                break;
            case 30:
                {
                alt13=2;
                }
                break;
            case 31:
                {
                alt13=3;
                }
                break;
            case 32:
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
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:771:2: (enumLiteral_0= 'readOnly' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:771:2: (enumLiteral_0= 'readOnly' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:771:4: enumLiteral_0= 'readOnly'
                    {
                    enumLiteral_0=(Token)match(input,29,FOLLOW_29_in_ruleModifierKind1655); 

                            current = grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:777:6: (enumLiteral_1= 'union' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:777:6: (enumLiteral_1= 'union' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:777:8: enumLiteral_1= 'union'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_30_in_ruleModifierKind1672); 

                            current = grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:783:6: (enumLiteral_2= 'ordered' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:783:6: (enumLiteral_2= 'ordered' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:783:8: enumLiteral_2= 'ordered'
                    {
                    enumLiteral_2=(Token)match(input,31,FOLLOW_31_in_ruleModifierKind1689); 

                            current = grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:789:6: (enumLiteral_3= 'unique' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:789:6: (enumLiteral_3= 'unique' )
                    // ../org.eclipse.papyrus.uml.textedit.property.xtext/src-gen/org/eclipse/papyrus/uml/textedit/property/xtext/parser/antlr/internal/InternalUmlProperty.g:789:8: enumLiteral_3= 'unique'
                    {
                    enumLiteral_3=(Token)match(input,32,FOLLOW_32_in_ruleModifierKind1706); 

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


 

    public static final BitSet FOLLOW_rulePropertyRule_in_entryRulePropertyRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rulePropertyRule131 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_rulePropertyRule149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyRule180 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePropertyRule197 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rulePropertyRule219 = new BitSet(new long[]{0x0000000001088002L});
    public static final BitSet FOLLOW_13_in_rulePropertyRule237 = new BitSet(new long[]{0x0000000001088002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rulePropertyRule259 = new BitSet(new long[]{0x0000000001080002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rulePropertyRule281 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_rulePropertyRule303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeRule396 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRule417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName508 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleQualifiedName520 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleMultiplicityRule625 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule646 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleMultiplicityRule659 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule680 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMultiplicityRule694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_ruleBoundSpecification785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteral_in_entryRuleUnlimitedLiteral821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteral832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleUnlimitedLiteral872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleUnlimitedLiteral896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleModifiersRule983 = new BitSet(new long[]{0x00000001E0C00000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1004 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleModifiersRule1017 = new BitSet(new long[]{0x00000001E0C00000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule1038 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleModifiersRule1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification1088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_ruleModifierSpecification1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_ruleModifierSpecification1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_ruleModifierSpecification1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule1234 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRedefinesRule1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleRedefinesRule1281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRedefinesRule1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule1337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubsetsRule1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleSubsetsRule1384 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubsetsRule1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule1440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultValueRule1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleDefaultValueRule1487 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDefaultValueRule1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVisibilityKind1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVisibilityKind1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVisibilityKind1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVisibilityKind1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleModifierKind1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleModifierKind1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleModifierKind1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleModifierKind1706 = new BitSet(new long[]{0x0000000000000002L});

}