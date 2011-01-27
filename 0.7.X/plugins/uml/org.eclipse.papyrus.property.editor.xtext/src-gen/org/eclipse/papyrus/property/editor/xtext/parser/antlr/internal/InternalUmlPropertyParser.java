package org.eclipse.papyrus.property.editor.xtext.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.papyrus.property.editor.xtext.services.UmlPropertyGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlPropertyParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'/'", "':'", "'<Undefined>'", "'::'", "'['", "'..'", "']'", "'{'", "','", "'}'", "'redefines'", "'subsets'", "'='", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_UNLIMITEDLITERAL=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=7;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

        public InternalUmlPropertyParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g"; }



     	private UmlPropertyGrammarAccess grammarAccess;
     	
        public InternalUmlPropertyParser(TokenStream input, IAstFactory factory, UmlPropertyGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "PropertyRule";	
       	}
       	
       	@Override
       	protected UmlPropertyGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRulePropertyRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:78:1: entryRulePropertyRule returns [EObject current=null] : iv_rulePropertyRule= rulePropertyRule EOF ;
    public final EObject entryRulePropertyRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:79:2: (iv_rulePropertyRule= rulePropertyRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:80:2: iv_rulePropertyRule= rulePropertyRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRuleRule(), currentNode); 
            pushFollow(FOLLOW_rulePropertyRule_in_entryRulePropertyRule75);
            iv_rulePropertyRule=rulePropertyRule();
            _fsp--;

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
    // $ANTLR end entryRulePropertyRule


    // $ANTLR start rulePropertyRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:87:1: rulePropertyRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )? ) ;
    public final EObject rulePropertyRule() throws RecognitionException {
        EObject current = null;

        Token lv_isDerived_1_0=null;
        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_multiplicity_6_0 = null;

        EObject lv_modifiers_7_0 = null;

        EObject lv_default_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:92:6: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )? )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ( (lv_default_8_0= ruleDefaultValueRule ) )?
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:2: ( (lv_visibility_0_0= ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:94:1: (lv_visibility_0_0= ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:94:1: (lv_visibility_0_0= ruleVisibilityKind )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:95:3: lv_visibility_0_0= ruleVisibilityKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPropertyRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleVisibilityKind_in_rulePropertyRule131);
            lv_visibility_0_0=ruleVisibilityKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"visibility",
            	        		lv_visibility_0_0, 
            	        		"VisibilityKind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:117:2: ( (lv_isDerived_1_0= '/' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:118:1: (lv_isDerived_1_0= '/' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:118:1: (lv_isDerived_1_0= '/' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:119:3: lv_isDerived_1_0= '/'
                    {
                    lv_isDerived_1_0=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_rulePropertyRule149); 

                            createLeafNode(grammarAccess.getPropertyRuleAccess().getIsDerivedSolidusKeyword_1_0(), "isDerived"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPropertyRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isDerived", lv_isDerived_1_0, "/", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:138:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:139:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:139:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:140:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyRule180); 

            			createLeafNode(grammarAccess.getPropertyRuleAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FOLLOW_13_in_rulePropertyRule195); 

                    createLeafNode(grammarAccess.getPropertyRuleAccess().getColonKeyword_3(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:166:1: ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("166:1: ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:166:2: ( (lv_type_4_0= ruleTypeRule ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:166:2: ( (lv_type_4_0= ruleTypeRule ) )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:167:1: (lv_type_4_0= ruleTypeRule )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:167:1: (lv_type_4_0= ruleTypeRule )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:168:3: lv_type_4_0= ruleTypeRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRule_in_rulePropertyRule217);
                    lv_type_4_0=ruleTypeRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPropertyRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_4_0, 
                    	        		"TypeRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:191:7: '<Undefined>'
                    {
                    match(input,14,FOLLOW_14_in_rulePropertyRule233); 

                            createLeafNode(grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:195:2: ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:196:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:196:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:197:3: lv_multiplicity_6_0= ruleMultiplicityRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleMultiplicityRule_in_rulePropertyRule255);
                    lv_multiplicity_6_0=ruleMultiplicityRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPropertyRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"multiplicity",
                    	        		lv_multiplicity_6_0, 
                    	        		"MultiplicityRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:219:3: ( (lv_modifiers_7_0= ruleModifiersRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:220:1: (lv_modifiers_7_0= ruleModifiersRule )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:220:1: (lv_modifiers_7_0= ruleModifiersRule )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:221:3: lv_modifiers_7_0= ruleModifiersRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleModifiersRule_in_rulePropertyRule277);
                    lv_modifiers_7_0=ruleModifiersRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPropertyRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"modifiers",
                    	        		lv_modifiers_7_0, 
                    	        		"ModifiersRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:243:3: ( (lv_default_8_0= ruleDefaultValueRule ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==24) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:244:1: (lv_default_8_0= ruleDefaultValueRule )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:244:1: (lv_default_8_0= ruleDefaultValueRule )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:245:3: lv_default_8_0= ruleDefaultValueRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyRuleAccess().getDefaultDefaultValueRuleParserRuleCall_7_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDefaultValueRule_in_rulePropertyRule299);
                    lv_default_8_0=ruleDefaultValueRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPropertyRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"default",
                    	        		lv_default_8_0, 
                    	        		"DefaultValueRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePropertyRule


    // $ANTLR start entryRuleTypeRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:275:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:276:2: (iv_ruleTypeRule= ruleTypeRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:277:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule336);
            iv_ruleTypeRule=ruleTypeRule();
            _fsp--;

             current =iv_ruleTypeRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule346); 

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
    // $ANTLR end entryRuleTypeRule


    // $ANTLR start ruleTypeRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:284:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:289:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:290:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:290:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:290:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:290:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==15) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:291:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:291:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:292:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeRule392);
                    lv_path_0_0=ruleQualifiedName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"path",
                    	        		lv_path_0_0, 
                    	        		"QualifiedName", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:314:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:315:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:315:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:316:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRule411); 

            		createLeafNode(grammarAccess.getTypeRuleAccess().getTypeClassifierCrossReference_1_0(), "type"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTypeRule


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:336:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:337:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:338:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName447);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName457); 

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
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:345:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:350:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:351:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:351:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:351:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:351:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:352:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:352:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:353:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName500); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,15,FOLLOW_15_in_ruleQualifiedName510); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:369:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==15) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:370:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:370:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:371:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName531);
                    lv_remaining_2_0=ruleQualifiedName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"remaining",
                    	        		lv_remaining_2_0, 
                    	        		"QualifiedName", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleQualifiedName


    // $ANTLR start entryRuleMultiplicityRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:401:1: entryRuleMultiplicityRule returns [EObject current=null] : iv_ruleMultiplicityRule= ruleMultiplicityRule EOF ;
    public final EObject entryRuleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:402:2: (iv_ruleMultiplicityRule= ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:403:2: iv_ruleMultiplicityRule= ruleMultiplicityRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicityRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule568);
            iv_ruleMultiplicityRule=ruleMultiplicityRule();
            _fsp--;

             current =iv_ruleMultiplicityRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule578); 

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
    // $ANTLR end entryRuleMultiplicityRule


    // $ANTLR start ruleMultiplicityRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:410:1: ruleMultiplicityRule returns [EObject current=null] : ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' ) ;
    public final EObject ruleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject lv_bounds_1_0 = null;

        EObject lv_bounds_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:415:6: ( ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:416:1: ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:416:1: ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:416:3: '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']'
            {
            match(input,16,FOLLOW_16_in_ruleMultiplicityRule613); 

                    createLeafNode(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:420:1: ( (lv_bounds_1_0= ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:421:1: (lv_bounds_1_0= ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:421:1: (lv_bounds_1_0= ruleBoundSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:422:3: lv_bounds_1_0= ruleBoundSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule634);
            lv_bounds_1_0=ruleBoundSpecification();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplicityRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"bounds",
            	        		lv_bounds_1_0, 
            	        		"BoundSpecification", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:444:2: ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:444:4: '..' ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleMultiplicityRule645); 

                            createLeafNode(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:448:1: ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:449:1: (lv_bounds_3_0= ruleBoundSpecification )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:449:1: (lv_bounds_3_0= ruleBoundSpecification )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:450:3: lv_bounds_3_0= ruleBoundSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule666);
                    lv_bounds_3_0=ruleBoundSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMultiplicityRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"bounds",
                    	        		lv_bounds_3_0, 
                    	        		"BoundSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,18,FOLLOW_18_in_ruleMultiplicityRule678); 

                    createLeafNode(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMultiplicityRule


    // $ANTLR start entryRuleBoundSpecification
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:484:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
    public final EObject entryRuleBoundSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundSpecification = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:485:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:486:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBoundSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification714);
            iv_ruleBoundSpecification=ruleBoundSpecification();
            _fsp--;

             current =iv_ruleBoundSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification724); 

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
    // $ANTLR end entryRuleBoundSpecification


    // $ANTLR start ruleBoundSpecification
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:493:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) ;
    public final EObject ruleBoundSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:498:6: ( ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:499:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:499:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:500:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:500:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:501:3: lv_value_0_0= RULE_UNLIMITEDLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification765); 

            			createLeafNode(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBoundSpecificationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"UnlimitedLiteral", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBoundSpecification


    // $ANTLR start entryRuleModifiersRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:531:1: entryRuleModifiersRule returns [EObject current=null] : iv_ruleModifiersRule= ruleModifiersRule EOF ;
    public final EObject entryRuleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifiersRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:532:2: (iv_ruleModifiersRule= ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:533:2: iv_ruleModifiersRule= ruleModifiersRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModifiersRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule805);
            iv_ruleModifiersRule=ruleModifiersRule();
            _fsp--;

             current =iv_ruleModifiersRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule815); 

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
    // $ANTLR end entryRuleModifiersRule


    // $ANTLR start ruleModifiersRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:540:1: ruleModifiersRule returns [EObject current=null] : ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' ) ;
    public final EObject ruleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:545:6: ( ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:546:1: ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:546:1: ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:546:3: '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}'
            {
            match(input,19,FOLLOW_19_in_ruleModifiersRule850); 

                    createLeafNode(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:550:1: ( (lv_values_1_0= ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:551:1: (lv_values_1_0= ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:551:1: (lv_values_1_0= ruleModifierSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:552:3: lv_values_1_0= ruleModifierSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule871);
            lv_values_1_0=ruleModifierSpecification();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModifiersRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"values",
            	        		lv_values_1_0, 
            	        		"ModifierSpecification", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:574:2: ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:574:4: ',' ( (lv_values_3_0= ruleModifierSpecification ) )
            	    {
            	    match(input,20,FOLLOW_20_in_ruleModifiersRule882); 

            	            createLeafNode(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:578:1: ( (lv_values_3_0= ruleModifierSpecification ) )
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:579:1: (lv_values_3_0= ruleModifierSpecification )
            	    {
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:579:1: (lv_values_3_0= ruleModifierSpecification )
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:580:3: lv_values_3_0= ruleModifierSpecification
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule903);
            	    lv_values_3_0=ruleModifierSpecification();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModifiersRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"values",
            	    	        		lv_values_3_0, 
            	    	        		"ModifierSpecification", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match(input,21,FOLLOW_21_in_ruleModifiersRule915); 

                    createLeafNode(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModifiersRule


    // $ANTLR start entryRuleModifierSpecification
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:614:1: entryRuleModifierSpecification returns [EObject current=null] : iv_ruleModifierSpecification= ruleModifierSpecification EOF ;
    public final EObject entryRuleModifierSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierSpecification = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:615:2: (iv_ruleModifierSpecification= ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:616:2: iv_ruleModifierSpecification= ruleModifierSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModifierSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification951);
            iv_ruleModifierSpecification=ruleModifierSpecification();
            _fsp--;

             current =iv_ruleModifierSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification961); 

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
    // $ANTLR end entryRuleModifierSpecification


    // $ANTLR start ruleModifierSpecification
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:623:1: ruleModifierSpecification returns [EObject current=null] : ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) ;
    public final EObject ruleModifierSpecification() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;

        EObject lv_redefines_1_0 = null;

        EObject lv_subsets_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:628:6: ( ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:629:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:629:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 29:
            case 30:
            case 31:
            case 32:
                {
                alt10=1;
                }
                break;
            case 22:
                {
                alt10=2;
                }
                break;
            case 23:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("629:1: ( ( (lv_value_0_0= ruleModifierKind ) ) | ( (lv_redefines_1_0= ruleRedefinesRule ) ) | ( (lv_subsets_2_0= ruleSubsetsRule ) ) )", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:629:2: ( (lv_value_0_0= ruleModifierKind ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:629:2: ( (lv_value_0_0= ruleModifierKind ) )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:630:1: (lv_value_0_0= ruleModifierKind )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:630:1: (lv_value_0_0= ruleModifierKind )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:631:3: lv_value_0_0= ruleModifierKind
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleModifierKind_in_ruleModifierSpecification1007);
                    lv_value_0_0=ruleModifierKind();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModifierSpecificationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_0_0, 
                    	        		"ModifierKind", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:654:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:654:6: ( (lv_redefines_1_0= ruleRedefinesRule ) )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:655:1: (lv_redefines_1_0= ruleRedefinesRule )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:655:1: (lv_redefines_1_0= ruleRedefinesRule )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:656:3: lv_redefines_1_0= ruleRedefinesRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModifierSpecificationAccess().getRedefinesRedefinesRuleParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRedefinesRule_in_ruleModifierSpecification1034);
                    lv_redefines_1_0=ruleRedefinesRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModifierSpecificationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"redefines",
                    	        		lv_redefines_1_0, 
                    	        		"RedefinesRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:679:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:679:6: ( (lv_subsets_2_0= ruleSubsetsRule ) )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:680:1: (lv_subsets_2_0= ruleSubsetsRule )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:680:1: (lv_subsets_2_0= ruleSubsetsRule )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:681:3: lv_subsets_2_0= ruleSubsetsRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModifierSpecificationAccess().getSubsetsSubsetsRuleParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSubsetsRule_in_ruleModifierSpecification1061);
                    lv_subsets_2_0=ruleSubsetsRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModifierSpecificationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"subsets",
                    	        		lv_subsets_2_0, 
                    	        		"SubsetsRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModifierSpecification


    // $ANTLR start entryRuleRedefinesRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:711:1: entryRuleRedefinesRule returns [EObject current=null] : iv_ruleRedefinesRule= ruleRedefinesRule EOF ;
    public final EObject entryRuleRedefinesRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRedefinesRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:712:2: (iv_ruleRedefinesRule= ruleRedefinesRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:713:2: iv_ruleRedefinesRule= ruleRedefinesRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRedefinesRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule1097);
            iv_ruleRedefinesRule=ruleRedefinesRule();
            _fsp--;

             current =iv_ruleRedefinesRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRedefinesRule1107); 

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
    // $ANTLR end entryRuleRedefinesRule


    // $ANTLR start ruleRedefinesRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:720:1: ruleRedefinesRule returns [EObject current=null] : ( 'redefines' ( ( RULE_ID ) ) ) ;
    public final EObject ruleRedefinesRule() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:725:6: ( ( 'redefines' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:726:1: ( 'redefines' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:726:1: ( 'redefines' ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:726:3: 'redefines' ( ( RULE_ID ) )
            {
            match(input,22,FOLLOW_22_in_ruleRedefinesRule1142); 

                    createLeafNode(grammarAccess.getRedefinesRuleAccess().getRedefinesKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:730:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:731:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:731:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:732:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getRedefinesRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRedefinesRule1160); 

            		createLeafNode(grammarAccess.getRedefinesRuleAccess().getPropertyPropertyCrossReference_1_0(), "property"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRedefinesRule


    // $ANTLR start entryRuleSubsetsRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:752:1: entryRuleSubsetsRule returns [EObject current=null] : iv_ruleSubsetsRule= ruleSubsetsRule EOF ;
    public final EObject entryRuleSubsetsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubsetsRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:753:2: (iv_ruleSubsetsRule= ruleSubsetsRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:754:2: iv_ruleSubsetsRule= ruleSubsetsRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubsetsRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule1196);
            iv_ruleSubsetsRule=ruleSubsetsRule();
            _fsp--;

             current =iv_ruleSubsetsRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubsetsRule1206); 

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
    // $ANTLR end entryRuleSubsetsRule


    // $ANTLR start ruleSubsetsRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:761:1: ruleSubsetsRule returns [EObject current=null] : ( 'subsets' ( ( RULE_ID ) ) ) ;
    public final EObject ruleSubsetsRule() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:766:6: ( ( 'subsets' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:767:1: ( 'subsets' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:767:1: ( 'subsets' ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:767:3: 'subsets' ( ( RULE_ID ) )
            {
            match(input,23,FOLLOW_23_in_ruleSubsetsRule1241); 

                    createLeafNode(grammarAccess.getSubsetsRuleAccess().getSubsetsKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:771:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:772:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:772:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:773:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubsetsRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubsetsRule1259); 

            		createLeafNode(grammarAccess.getSubsetsRuleAccess().getPropertyPropertyCrossReference_1_0(), "property"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSubsetsRule


    // $ANTLR start entryRuleDefaultValueRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:793:1: entryRuleDefaultValueRule returns [EObject current=null] : iv_ruleDefaultValueRule= ruleDefaultValueRule EOF ;
    public final EObject entryRuleDefaultValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultValueRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:794:2: (iv_ruleDefaultValueRule= ruleDefaultValueRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:795:2: iv_ruleDefaultValueRule= ruleDefaultValueRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefaultValueRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule1295);
            iv_ruleDefaultValueRule=ruleDefaultValueRule();
            _fsp--;

             current =iv_ruleDefaultValueRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultValueRule1305); 

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
    // $ANTLR end entryRuleDefaultValueRule


    // $ANTLR start ruleDefaultValueRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:802:1: ruleDefaultValueRule returns [EObject current=null] : ( '=' ( (lv_default_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleDefaultValueRule() throws RecognitionException {
        EObject current = null;

        Token lv_default_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:807:6: ( ( '=' ( (lv_default_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:808:1: ( '=' ( (lv_default_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:808:1: ( '=' ( (lv_default_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:808:3: '=' ( (lv_default_1_0= RULE_STRING ) )
            {
            match(input,24,FOLLOW_24_in_ruleDefaultValueRule1340); 

                    createLeafNode(grammarAccess.getDefaultValueRuleAccess().getEqualsSignKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:812:1: ( (lv_default_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:813:1: (lv_default_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:813:1: (lv_default_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:814:3: lv_default_1_0= RULE_STRING
            {
            lv_default_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDefaultValueRule1357); 

            			createLeafNode(grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0(), "default"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDefaultValueRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"default",
            	        		lv_default_1_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDefaultValueRule


    // $ANTLR start ruleVisibilityKind
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:844:1: ruleVisibilityKind returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) ;
    public final Enumerator ruleVisibilityKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:848:6: ( ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:849:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:849:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt11=1;
                }
                break;
            case 26:
                {
                alt11=2;
                }
                break;
            case 27:
                {
                alt11=3;
                }
                break;
            case 28:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("849:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:849:2: ( '+' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:849:2: ( '+' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:849:4: '+'
                    {
                    match(input,25,FOLLOW_25_in_ruleVisibilityKind1410); 

                            current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:855:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:855:6: ( '-' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:855:8: '-'
                    {
                    match(input,26,FOLLOW_26_in_ruleVisibilityKind1425); 

                            current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:861:6: ( '#' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:861:6: ( '#' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:861:8: '#'
                    {
                    match(input,27,FOLLOW_27_in_ruleVisibilityKind1440); 

                            current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:867:6: ( '~' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:867:6: ( '~' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:867:8: '~'
                    {
                    match(input,28,FOLLOW_28_in_ruleVisibilityKind1455); 

                            current = grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVisibilityKind


    // $ANTLR start ruleModifierKind
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:877:1: ruleModifierKind returns [Enumerator current=null] : ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) ) ;
    public final Enumerator ruleModifierKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:881:6: ( ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:882:1: ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:882:1: ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt12=1;
                }
                break;
            case 30:
                {
                alt12=2;
                }
                break;
            case 31:
                {
                alt12=3;
                }
                break;
            case 32:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("882:1: ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:882:2: ( 'readOnly' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:882:2: ( 'readOnly' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:882:4: 'readOnly'
                    {
                    match(input,29,FOLLOW_29_in_ruleModifierKind1498); 

                            current = grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:888:6: ( 'union' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:888:6: ( 'union' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:888:8: 'union'
                    {
                    match(input,30,FOLLOW_30_in_ruleModifierKind1513); 

                            current = grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:894:6: ( 'ordered' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:894:6: ( 'ordered' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:894:8: 'ordered'
                    {
                    match(input,31,FOLLOW_31_in_ruleModifierKind1528); 

                            current = grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:900:6: ( 'unique' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:900:6: ( 'unique' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:900:8: 'unique'
                    {
                    match(input,32,FOLLOW_32_in_ruleModifierKind1543); 

                            current = grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getUniqueEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModifierKind


 

    public static final BitSet FOLLOW_rulePropertyRule_in_entryRulePropertyRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rulePropertyRule131 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_rulePropertyRule149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyRule180 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePropertyRule195 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rulePropertyRule217 = new BitSet(new long[]{0x0000000001090002L});
    public static final BitSet FOLLOW_14_in_rulePropertyRule233 = new BitSet(new long[]{0x0000000001090002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rulePropertyRule255 = new BitSet(new long[]{0x0000000001080002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rulePropertyRule277 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_rulePropertyRule299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeRule392 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRule411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName500 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleQualifiedName510 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMultiplicityRule613 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule634 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleMultiplicityRule645 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule666 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMultiplicityRule678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleModifiersRule850 = new BitSet(new long[]{0x00000001E0C00000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule871 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleModifiersRule882 = new BitSet(new long[]{0x00000001E0C00000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule903 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleModifiersRule915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification951 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_ruleModifierSpecification1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_ruleModifierSpecification1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_ruleModifierSpecification1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRedefinesRule_in_entryRuleRedefinesRule1097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRedefinesRule1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleRedefinesRule1142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRedefinesRule1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubsetsRule_in_entryRuleSubsetsRule1196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubsetsRule1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleSubsetsRule1241 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubsetsRule1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultValueRule_in_entryRuleDefaultValueRule1295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultValueRule1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleDefaultValueRule1340 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDefaultValueRule1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVisibilityKind1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleVisibilityKind1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleVisibilityKind1440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVisibilityKind1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleModifierKind1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleModifierKind1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleModifierKind1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleModifierKind1543 = new BitSet(new long[]{0x0000000000000002L});

}