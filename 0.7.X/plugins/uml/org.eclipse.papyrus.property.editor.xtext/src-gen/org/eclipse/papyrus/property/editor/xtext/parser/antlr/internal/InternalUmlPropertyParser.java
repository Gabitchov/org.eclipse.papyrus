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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'/'", "':'", "'<Undefined>'", "'['", "'..'", "']'", "'{'", "','", "'}'", "'+'", "'-'", "'#'", "'~'", "'readOnly'", "'union'", "'ordered'", "'unique'"
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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:87:1: rulePropertyRule returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( ( RULE_ID ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ) ;
    public final EObject rulePropertyRule() throws RecognitionException {
        EObject current = null;

        Token lv_isDerived_1_0=null;
        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;

        EObject lv_multiplicity_6_0 = null;

        EObject lv_modifiers_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:92:6: ( ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( ( RULE_ID ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( ( RULE_ID ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:1: ( ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( ( RULE_ID ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )? )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:93:2: ( (lv_visibility_0_0= ruleVisibilityKind ) ) ( (lv_isDerived_1_0= '/' ) )? ( (lv_name_2_0= RULE_ID ) ) ':' ( ( ( RULE_ID ) ) | '<Undefined>' ) ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )? ( (lv_modifiers_7_0= ruleModifiersRule ) )?
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
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:166:1: ( ( ( RULE_ID ) ) | '<Undefined>' )
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
                    new NoViableAltException("166:1: ( ( ( RULE_ID ) ) | '<Undefined>' )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:166:2: ( ( RULE_ID ) )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:166:2: ( ( RULE_ID ) )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:167:1: ( RULE_ID )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:167:1: ( RULE_ID )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:168:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getPropertyRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyRule214); 

                    		createLeafNode(grammarAccess.getPropertyRuleAccess().getTypeClassifierCrossReference_4_0_0(), "type"); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:181:7: '<Undefined>'
                    {
                    match(input,14,FOLLOW_14_in_rulePropertyRule230); 

                            createLeafNode(grammarAccess.getPropertyRuleAccess().getUndefinedKeyword_4_1(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:185:2: ( (lv_multiplicity_6_0= ruleMultiplicityRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:186:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:186:1: (lv_multiplicity_6_0= ruleMultiplicityRule )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:187:3: lv_multiplicity_6_0= ruleMultiplicityRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleMultiplicityRule_in_rulePropertyRule252);
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

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:209:3: ( (lv_modifiers_7_0= ruleModifiersRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:210:1: (lv_modifiers_7_0= ruleModifiersRule )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:210:1: (lv_modifiers_7_0= ruleModifiersRule )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:211:3: lv_modifiers_7_0= ruleModifiersRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleModifiersRule_in_rulePropertyRule274);
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


    // $ANTLR start entryRuleMultiplicityRule
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:241:1: entryRuleMultiplicityRule returns [EObject current=null] : iv_ruleMultiplicityRule= ruleMultiplicityRule EOF ;
    public final EObject entryRuleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:242:2: (iv_ruleMultiplicityRule= ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:243:2: iv_ruleMultiplicityRule= ruleMultiplicityRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicityRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule311);
            iv_ruleMultiplicityRule=ruleMultiplicityRule();
            _fsp--;

             current =iv_ruleMultiplicityRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule321); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:250:1: ruleMultiplicityRule returns [EObject current=null] : ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' ) ;
    public final EObject ruleMultiplicityRule() throws RecognitionException {
        EObject current = null;

        EObject lv_bounds_1_0 = null;

        EObject lv_bounds_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:255:6: ( ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:256:1: ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:256:1: ( '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']' )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:256:3: '[' ( (lv_bounds_1_0= ruleBoundSpecification ) ) ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )? ']'
            {
            match(input,15,FOLLOW_15_in_ruleMultiplicityRule356); 

                    createLeafNode(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:260:1: ( (lv_bounds_1_0= ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:261:1: (lv_bounds_1_0= ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:261:1: (lv_bounds_1_0= ruleBoundSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:262:3: lv_bounds_1_0= ruleBoundSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule377);
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

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:284:2: ( '..' ( (lv_bounds_3_0= ruleBoundSpecification ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:284:4: '..' ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    {
                    match(input,16,FOLLOW_16_in_ruleMultiplicityRule388); 

                            createLeafNode(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:288:1: ( (lv_bounds_3_0= ruleBoundSpecification ) )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:289:1: (lv_bounds_3_0= ruleBoundSpecification )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:289:1: (lv_bounds_3_0= ruleBoundSpecification )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:290:3: lv_bounds_3_0= ruleBoundSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule409);
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

            match(input,17,FOLLOW_17_in_ruleMultiplicityRule421); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:324:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
    public final EObject entryRuleBoundSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundSpecification = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:325:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:326:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBoundSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification457);
            iv_ruleBoundSpecification=ruleBoundSpecification();
            _fsp--;

             current =iv_ruleBoundSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification467); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:333:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) ;
    public final EObject ruleBoundSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:338:6: ( ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:339:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:339:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:340:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:340:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:341:3: lv_value_0_0= RULE_UNLIMITEDLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification508); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:371:1: entryRuleModifiersRule returns [EObject current=null] : iv_ruleModifiersRule= ruleModifiersRule EOF ;
    public final EObject entryRuleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifiersRule = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:372:2: (iv_ruleModifiersRule= ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:373:2: iv_ruleModifiersRule= ruleModifiersRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModifiersRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule548);
            iv_ruleModifiersRule=ruleModifiersRule();
            _fsp--;

             current =iv_ruleModifiersRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule558); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:380:1: ruleModifiersRule returns [EObject current=null] : ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' ) ;
    public final EObject ruleModifiersRule() throws RecognitionException {
        EObject current = null;

        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:385:6: ( ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:386:1: ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:386:1: ( '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}' )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:386:3: '{' ( (lv_values_1_0= ruleModifierSpecification ) ) ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )* '}'
            {
            match(input,18,FOLLOW_18_in_ruleModifiersRule593); 

                    createLeafNode(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:390:1: ( (lv_values_1_0= ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:391:1: (lv_values_1_0= ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:391:1: (lv_values_1_0= ruleModifierSpecification )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:392:3: lv_values_1_0= ruleModifierSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule614);
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

            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:414:2: ( ',' ( (lv_values_3_0= ruleModifierSpecification ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:414:4: ',' ( (lv_values_3_0= ruleModifierSpecification ) )
            	    {
            	    match(input,19,FOLLOW_19_in_ruleModifiersRule625); 

            	            createLeafNode(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:418:1: ( (lv_values_3_0= ruleModifierSpecification ) )
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:419:1: (lv_values_3_0= ruleModifierSpecification )
            	    {
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:419:1: (lv_values_3_0= ruleModifierSpecification )
            	    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:420:3: lv_values_3_0= ruleModifierSpecification
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleModifierSpecification_in_ruleModifiersRule646);
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
            	    break loop6;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_ruleModifiersRule658); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:454:1: entryRuleModifierSpecification returns [EObject current=null] : iv_ruleModifierSpecification= ruleModifierSpecification EOF ;
    public final EObject entryRuleModifierSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierSpecification = null;


        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:455:2: (iv_ruleModifierSpecification= ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:456:2: iv_ruleModifierSpecification= ruleModifierSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModifierSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification694);
            iv_ruleModifierSpecification=ruleModifierSpecification();
            _fsp--;

             current =iv_ruleModifierSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification704); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:463:1: ruleModifierSpecification returns [EObject current=null] : ( (lv_value_0_0= ruleModifierKind ) ) ;
    public final EObject ruleModifierSpecification() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:468:6: ( ( (lv_value_0_0= ruleModifierKind ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:469:1: ( (lv_value_0_0= ruleModifierKind ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:469:1: ( (lv_value_0_0= ruleModifierKind ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:470:1: (lv_value_0_0= ruleModifierKind )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:470:1: (lv_value_0_0= ruleModifierKind )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:471:3: lv_value_0_0= ruleModifierKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleModifierKind_in_ruleModifierSpecification749);
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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:501:1: ruleVisibilityKind returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) ;
    public final Enumerator ruleVisibilityKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:505:6: ( ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:506:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:506:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt7=1;
                }
                break;
            case 22:
                {
                alt7=2;
                }
                break;
            case 23:
                {
                alt7=3;
                }
                break;
            case 24:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("506:1: ( ( '+' ) | ( '-' ) | ( '#' ) | ( '~' ) )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:506:2: ( '+' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:506:2: ( '+' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:506:4: '+'
                    {
                    match(input,21,FOLLOW_21_in_ruleVisibilityKind796); 

                            current = grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:512:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:512:6: ( '-' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:512:8: '-'
                    {
                    match(input,22,FOLLOW_22_in_ruleVisibilityKind811); 

                            current = grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:518:6: ( '#' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:518:6: ( '#' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:518:8: '#'
                    {
                    match(input,23,FOLLOW_23_in_ruleVisibilityKind826); 

                            current = grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:524:6: ( '~' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:524:6: ( '~' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:524:8: '~'
                    {
                    match(input,24,FOLLOW_24_in_ruleVisibilityKind841); 

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
    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:534:1: ruleModifierKind returns [Enumerator current=null] : ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) ) ;
    public final Enumerator ruleModifierKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:538:6: ( ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) ) )
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:539:1: ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) )
            {
            // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:539:1: ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) )
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
                    new NoViableAltException("539:1: ( ( 'readOnly' ) | ( 'union' ) | ( 'ordered' ) | ( 'unique' ) )", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:539:2: ( 'readOnly' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:539:2: ( 'readOnly' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:539:4: 'readOnly'
                    {
                    match(input,25,FOLLOW_25_in_ruleModifierKind884); 

                            current = grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getReadOnlyEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:545:6: ( 'union' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:545:6: ( 'union' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:545:8: 'union'
                    {
                    match(input,26,FOLLOW_26_in_ruleModifierKind899); 

                            current = grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getUnionEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:551:6: ( 'ordered' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:551:6: ( 'ordered' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:551:8: 'ordered'
                    {
                    match(input,27,FOLLOW_27_in_ruleModifierKind914); 

                            current = grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getModifierKindAccess().getOrderedEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:557:6: ( 'unique' )
                    {
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:557:6: ( 'unique' )
                    // ../org.eclipse.papyrus.property.editor.xtext/src-gen/org/eclipse/papyrus/property/editor/xtext/parser/antlr/internal/InternalUmlProperty.g:557:8: 'unique'
                    {
                    match(input,28,FOLLOW_28_in_ruleModifierKind929); 

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
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyRule214 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_14_in_rulePropertyRule230 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rulePropertyRule252 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rulePropertyRule274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleMultiplicityRule356 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule377 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleMultiplicityRule388 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_ruleMultiplicityRule409 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMultiplicityRule421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleModifiersRule593 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule614 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_ruleModifiersRule625 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_ruleModifiersRule646 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_20_in_ruleModifiersRule658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_ruleModifierSpecification749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVisibilityKind796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVisibilityKind811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVisibilityKind826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleVisibilityKind841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleModifierKind884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleModifierKind899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleModifierKind914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleModifierKind929 = new BitSet(new long[]{0x0000000000000002L});

}