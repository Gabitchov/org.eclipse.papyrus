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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'/'", "':'", "'<Undefined>'", "'::'", "'['", "'..'", "']'", "'{'", "','", "'}'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=7;
    public static final int RULE_UNLIMITEDLITERAL=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=6;
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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:87:1: rulePropertyRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ) ;
    public final EObject rulePropertyRule() throws RecognitionException {
        EObject current = null;

        Token lv_isDerived_1_0=null;
        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_multiplicity_6_0 = null;

        EObject lv_modifiers_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:92:6: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( (lv_type_4_0= ruleTypeRule ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )?
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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:251:1: entryRuleTypeRule returns [EObject current=null] : iv_ruleTypeRule= ruleTypeRule EOF ;
    public final EObject entryRuleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:252:2: (iv_ruleTypeRule= ruleTypeRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:253:2: iv_ruleTypeRule= ruleTypeRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule314);
            iv_ruleTypeRule=ruleTypeRule();
            _fsp--;

             current =iv_ruleTypeRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule324); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:260:1: ruleTypeRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleTypeRule() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:265:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:266:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:266:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:266:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:266:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==15) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:267:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:267:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:268:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeRule370);
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

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:290:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:291:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:291:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:292:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRule389); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:312:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:313:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:314:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName425);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName435); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:321:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:326:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:327:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:327:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:327:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:327:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:328:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:328:1: ( RULE_ID )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:329:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName478); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,15,FOLLOW_15_in_ruleQualifiedName488); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:345:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
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
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:346:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:346:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:347:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName509);
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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:377:1: entryRuleMultiplicityRule returns [EObject current=null] : iv_ruleMultiplicityRule= ruleMultiplicityRule EOF ;
    public final EObject entryRuleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:378:2: (iv_ruleMultiplicityRule= ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:379:2: iv_ruleMultiplicityRule= ruleMultiplicityRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicityRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule546);
            iv_ruleMultiplicityRule=ruleMultiplicityRule();
            _fsp--;

             current =iv_ruleMultiplicityRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule556); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:386:1: ruleMultiplicityRule returns [EObject current=null] : ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' ) ;
    public final EObject ruleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject lv_bounds_1_0 = null;

        EObject lv_bounds_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:391:6: ( ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:392:1: ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:392:1: ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:392:3: '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']'
            {
            match(input,16,FOLLOW_16_in_ruleMultiplicityRule591); 

                    createLeafNode(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:396:1: ( (lv_bounds_1_0= ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:397:1: (lv_bounds_1_0= ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:397:1: (lv_bounds_1_0= ruleBoundSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:398:3: lv_bounds_1_0= ruleBoundSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule612);
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

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:420:2: ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:420:4: '..' ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    {
                    match(input,17,FOLLOW_17_in_ruleMultiplicityRule623); 

                            createLeafNode(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:424:1: ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:425:1: (lv_bounds_3_0= ruleBoundSpecification )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:425:1: (lv_bounds_3_0= ruleBoundSpecification )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:426:3: lv_bounds_3_0= ruleBoundSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule644);
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

            match(input,18,FOLLOW_18_in_ruleMultiplicityRule656); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:460:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
    public final EObject entryRuleBoundSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundSpecification = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:461:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:462:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBoundSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification692);
            iv_ruleBoundSpecification=ruleBoundSpecification();
            _fsp--;

             current =iv_ruleBoundSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification702); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:469:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) ;
    public final EObject ruleBoundSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:474:6: ( ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:475:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:475:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:476:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:476:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:477:3: lv_value_0_0= RULE_UNLIMITEDLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification743); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:507:1: entryRuleModifiersRule returns [EObject current=null] : iv_ruleModifiersRule= ruleModifiersRule EOF ;
    public final EObject entryRuleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifiersRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:508:2: (iv_ruleModifiersRule= ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:509:2: iv_ruleModifiersRule= ruleModifiersRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModifiersRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule783);
            iv_ruleModifiersRule=ruleModifiersRule();
            _fsp--;

             current =iv_ruleModifiersRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule793); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:516:1: ruleModifiersRule returns [EObject current=null] : ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' ) ;
    public final EObject ruleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:521:6: ( ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:522:1: ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:522:1: ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:522:3: '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}'
            {
            match(input,19,FOLLOW_19_in_ruleModifiersRule828); 

                    createLeafNode(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:526:1: ( (lv_values_1_0= ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:527:1: (lv_values_1_0= ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:527:1: (lv_values_1_0= ruleModifierSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:528:3: lv_values_1_0= ruleModifierSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule849);
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

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:550:2: ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==20) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:550:4: ',' ( (lv_values_3_0= ruleModifierSpecification ) )
            	    {
            	    match(input,20,FOLLOW_20_in_ruleModifiersRule860); 

            	            createLeafNode(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:554:1: ( (lv_values_3_0= ruleModifierSpecification ) )
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:555:1: (lv_values_3_0= ruleModifierSpecification )
            	    {
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:555:1: (lv_values_3_0= ruleModifierSpecification )
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:556:3: lv_values_3_0= ruleModifierSpecification
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule881);
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
            	    break loop8;
                }
            } while (true);

            match(input,21,FOLLOW_21_in_ruleModifiersRule893); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:590:1: entryRuleModifierSpecification returns [EObject current=null] : iv_ruleModifierSpecification= ruleModifierSpecification EOF ;
    public final EObject entryRuleModifierSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierSpecification = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:591:2: (iv_ruleModifierSpecification= ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:592:2: iv_ruleModifierSpecification= ruleModifierSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModifierSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification929);
            iv_ruleModifierSpecification=ruleModifierSpecification();
            _fsp--;

             current =iv_ruleModifierSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification939); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:599:1: ruleModifierSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleModifierKind ) ) ;
    public final EObject ruleModifierSpecification() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:604:6: ( ( (lv_value_0_0= ruleModifierKind ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:605:1: ( (lv_value_0_0= ruleModifierKind ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:605:1: ( (lv_value_0_0= ruleModifierKind ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:606:1: (lv_value_0_0= ruleModifierKind )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:606:1: (lv_value_0_0= ruleModifierKind )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:607:3: lv_value_0_0= ruleModifierKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModifierKind_in_ruleModifierSpecification984);
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


    // $ANTLR start ruleVisibilityKind
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:637:1: ruleVisibilityKind returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) ;
    public final Enumerator ruleVisibilityKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:641:6: ( ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:642:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:642:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
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
                    new NoViableAltException("642:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:642:2: ( '+' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:642:2: ( '+' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:642:4: '+'
                    {
                    match(input,22,FOLLOW_22_in_ruleVisibilityKind1031); 

                            current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:648:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:648:6: ( '-' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:648:8: '-'
                    {
                    match(input,23,FOLLOW_23_in_ruleVisibilityKind1046); 

                            current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:654:6: ( '#' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:654:6: ( '#' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:654:8: '#'
                    {
                    match(input,24,FOLLOW_24_in_ruleVisibilityKind1061); 

                            current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:660:6: ( '~' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:660:6: ( '~' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:660:8: '~'
                    {
                    match(input,25,FOLLOW_25_in_ruleVisibilityKind1076); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:670:1: ruleModifierKind returns [Enumerator current=null] : ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) ) ;
    public final Enumerator ruleModifierKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:674:6: ( ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:675:1: ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:675:1: ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) )
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
                    new NoViableAltException("675:1: ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) )", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:675:2: ( 'readOnly' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:675:2: ( 'readOnly' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:675:4: 'readOnly'
                    {
                    match(input,26,FOLLOW_26_in_ruleModifierKind1119); 

                            current = grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:681:6: ( 'union' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:681:6: ( 'union' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:681:8: 'union'
                    {
                    match(input,27,FOLLOW_27_in_ruleModifierKind1134); 

                            current = grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:687:6: ( 'ordered' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:687:6: ( 'ordered' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:687:8: 'ordered'
                    {
                    match(input,28,FOLLOW_28_in_ruleModifierKind1149); 

                            current = grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:693:6: ( 'unique' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:693:6: ( 'unique' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:693:8: 'unique'
                    {
                    match(input,29,FOLLOW_29_in_ruleModifierKind1164); 

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
    public static final BitSet FOLLOW_ruleTypeRule_in_rulePropertyRule217 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_14_in_rulePropertyRule233 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rulePropertyRule255 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rulePropertyRule277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeRule370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRule389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName478 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleQualifiedName488 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMultiplicityRule591 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule612 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleMultiplicityRule623 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule644 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMultiplicityRule656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification692 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleModifiersRule828 = new BitSet(new long[]{0x000000003C000000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule849 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleModifiersRule860 = new BitSet(new long[]{0x000000003C000000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule881 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleModifiersRule893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification929 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_ruleModifierSpecification984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVisibilityKind1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVisibilityKind1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVisibilityKind1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVisibilityKind1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleModifierKind1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleModifierKind1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleModifierKind1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleModifierKind1164 = new BitSet(new long[]{0x0000000000000002L});

}