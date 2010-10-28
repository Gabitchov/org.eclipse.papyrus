package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.services.StereotypeApplicationWithVSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStereotypeApplicationWithVSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INTEGERLITERAL", "RULE_REALLITERAL", "RULE_DATETIMELITERAL", "RULE_BOOLEANLITERAL", "RULE_NULLLITERAL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<<'", "'>>'", "','", "'->'", "'='", "'import'", "'context'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'?'", "':'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'not'", "'.'", "'('", "')'", "'::'", "']'", "'['", "'..'", "'{'", "'}'", "'@'", "'when'", "'&'", "'jitter('", "'$'", "'in'", "'out'", "'inout'"
    };
    public static final int RULE_NULLLITERAL=10;
    public static final int RULE_DATETIMELITERAL=8;
    public static final int RULE_BOOLEANLITERAL=9;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_REALLITERAL=7;
    public static final int RULE_INTEGERLITERAL=6;
    public static final int RULE_INT=11;
    public static final int RULE_WS=14;
    public static final int RULE_SL_COMMENT=13;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=12;

        public InternalStereotypeApplicationWithVSLParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g"; }



     	private StereotypeApplicationWithVSLGrammarAccess grammarAccess;
     	
        public InternalStereotypeApplicationWithVSLParser(TokenStream input, IAstFactory factory, StereotypeApplicationWithVSLGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "StereotypeApplicationsRule";	
       	}
       	
       	@Override
       	protected StereotypeApplicationWithVSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleStereotypeApplicationsRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:77:1: entryRuleStereotypeApplicationsRule returns [EObject current=null] : iv_ruleStereotypeApplicationsRule= ruleStereotypeApplicationsRule EOF ;
    public final EObject entryRuleStereotypeApplicationsRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStereotypeApplicationsRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:78:2: (iv_ruleStereotypeApplicationsRule= ruleStereotypeApplicationsRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:79:2: iv_ruleStereotypeApplicationsRule= ruleStereotypeApplicationsRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStereotypeApplicationsRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleStereotypeApplicationsRule_in_entryRuleStereotypeApplicationsRule75);
            iv_ruleStereotypeApplicationsRule=ruleStereotypeApplicationsRule();
            _fsp--;

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
    // $ANTLR end entryRuleStereotypeApplicationsRule


    // $ANTLR start ruleStereotypeApplicationsRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:86:1: ruleStereotypeApplicationsRule returns [EObject current=null] : ( (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule ) )* ;
    public final EObject ruleStereotypeApplicationsRule() throws RecognitionException {
        EObject current = null;

        EObject lv_stereotypeApplications_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:91:6: ( ( (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:92:1: ( (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:92:1: ( (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:93:1: (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:93:1: (lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:94:3: lv_stereotypeApplications_0_0= ruleStereotypeApplicationRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStereotypeApplicationsRuleAccess().getStereotypeApplicationsStereotypeApplicationRuleParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStereotypeApplicationRule_in_ruleStereotypeApplicationsRule130);
            	    lv_stereotypeApplications_0_0=ruleStereotypeApplicationRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStereotypeApplicationsRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"stereotypeApplications",
            	    	        		lv_stereotypeApplications_0_0, 
            	    	        		"StereotypeApplicationRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end ruleStereotypeApplicationsRule


    // $ANTLR start entryRuleStereotypeApplicationRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:124:1: entryRuleStereotypeApplicationRule returns [EObject current=null] : iv_ruleStereotypeApplicationRule= ruleStereotypeApplicationRule EOF ;
    public final EObject entryRuleStereotypeApplicationRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStereotypeApplicationRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:125:2: (iv_ruleStereotypeApplicationRule= ruleStereotypeApplicationRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:126:2: iv_ruleStereotypeApplicationRule= ruleStereotypeApplicationRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStereotypeApplicationRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleStereotypeApplicationRule_in_entryRuleStereotypeApplicationRule166);
            iv_ruleStereotypeApplicationRule=ruleStereotypeApplicationRule();
            _fsp--;

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
    // $ANTLR end entryRuleStereotypeApplicationRule


    // $ANTLR start ruleStereotypeApplicationRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:133:1: ruleStereotypeApplicationRule returns [EObject current=null] : ( '<<' ( ( RULE_ID ) ) '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) ( ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )? ) ;
    public final EObject ruleStereotypeApplicationRule() throws RecognitionException {
        EObject current = null;

        EObject lv_tagSpecification_3_0 = null;

        EObject lv_tagSpecification_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:138:6: ( ( '<<' ( ( RULE_ID ) ) '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) ( ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:139:1: ( '<<' ( ( RULE_ID ) ) '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) ( ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:139:1: ( '<<' ( ( RULE_ID ) ) '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) ( ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:139:3: '<<' ( ( RULE_ID ) ) '>>' ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) ( ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )?
            {
            match(input,16,FOLLOW_16_in_ruleStereotypeApplicationRule211); 

                    createLeafNode(grammarAccess.getStereotypeApplicationRuleAccess().getLessThanSignLessThanSignKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:143:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:144:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:144:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:145:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStereotypeApplicationRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStereotypeApplicationRule229); 

            		createLeafNode(grammarAccess.getStereotypeApplicationRuleAccess().getStereotypeStereotypeCrossReference_1_0(), "stereotype"); 
            	

            }


            }

            match(input,17,FOLLOW_17_in_ruleStereotypeApplicationRule239); 

                    createLeafNode(grammarAccess.getStereotypeApplicationRuleAccess().getGreaterThanSignGreaterThanSignKeyword_2(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:161:1: ( ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) ( ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:161:2: ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) ) ( ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )*
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:161:2: ( (lv_tagSpecification_3_0= ruleTagSpecificationRule ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:162:1: (lv_tagSpecification_3_0= ruleTagSpecificationRule )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:162:1: (lv_tagSpecification_3_0= ruleTagSpecificationRule )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:163:3: lv_tagSpecification_3_0= ruleTagSpecificationRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStereotypeApplicationRuleAccess().getTagSpecificationTagSpecificationRuleParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTagSpecificationRule_in_ruleStereotypeApplicationRule261);
                    lv_tagSpecification_3_0=ruleTagSpecificationRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStereotypeApplicationRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"tagSpecification",
                    	        		lv_tagSpecification_3_0, 
                    	        		"TagSpecificationRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:185:2: ( ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==18) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:185:4: ',' ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) )
                    	    {
                    	    match(input,18,FOLLOW_18_in_ruleStereotypeApplicationRule272); 

                    	            createLeafNode(grammarAccess.getStereotypeApplicationRuleAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:189:1: ( (lv_tagSpecification_5_0= ruleTagSpecificationRule ) )
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:190:1: (lv_tagSpecification_5_0= ruleTagSpecificationRule )
                    	    {
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:190:1: (lv_tagSpecification_5_0= ruleTagSpecificationRule )
                    	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:191:3: lv_tagSpecification_5_0= ruleTagSpecificationRule
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getStereotypeApplicationRuleAccess().getTagSpecificationTagSpecificationRuleParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTagSpecificationRule_in_ruleStereotypeApplicationRule293);
                    	    lv_tagSpecification_5_0=ruleTagSpecificationRule();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getStereotypeApplicationRuleRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"tagSpecification",
                    	    	        		lv_tagSpecification_5_0, 
                    	    	        		"TagSpecificationRule", 
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
                    	    break loop2;
                        }
                    } while (true);


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
    // $ANTLR end ruleStereotypeApplicationRule


    // $ANTLR start entryRuleTagSpecificationRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:221:1: entryRuleTagSpecificationRule returns [EObject current=null] : iv_ruleTagSpecificationRule= ruleTagSpecificationRule EOF ;
    public final EObject entryRuleTagSpecificationRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTagSpecificationRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:222:2: (iv_ruleTagSpecificationRule= ruleTagSpecificationRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:223:2: iv_ruleTagSpecificationRule= ruleTagSpecificationRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTagSpecificationRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTagSpecificationRule_in_entryRuleTagSpecificationRule333);
            iv_ruleTagSpecificationRule=ruleTagSpecificationRule();
            _fsp--;

             current =iv_ruleTagSpecificationRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTagSpecificationRule343); 

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
    // $ANTLR end entryRuleTagSpecificationRule


    // $ANTLR start ruleTagSpecificationRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:230:1: ruleTagSpecificationRule returns [EObject current=null] : ( ( ( RULE_ID ) ) ( (lv_value_1_0= ruleValueRule ) ) ) ;
    public final EObject ruleTagSpecificationRule() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:235:6: ( ( ( ( RULE_ID ) ) ( (lv_value_1_0= ruleValueRule ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:236:1: ( ( ( RULE_ID ) ) ( (lv_value_1_0= ruleValueRule ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:236:1: ( ( ( RULE_ID ) ) ( (lv_value_1_0= ruleValueRule ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:236:2: ( ( RULE_ID ) ) ( (lv_value_1_0= ruleValueRule ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:236:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:237:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:237:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:238:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTagSpecificationRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTagSpecificationRule386); 

            		createLeafNode(grammarAccess.getTagSpecificationRuleAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:250:2: ( (lv_value_1_0= ruleValueRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:251:1: (lv_value_1_0= ruleValueRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:251:1: (lv_value_1_0= ruleValueRule )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:252:3: lv_value_1_0= ruleValueRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTagSpecificationRuleAccess().getValueValueRuleParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueRule_in_ruleTagSpecificationRule407);
            lv_value_1_0=ruleValueRule();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTagSpecificationRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_1_0, 
            	        		"ValueRule", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleTagSpecificationRule


    // $ANTLR start entryRuleValueRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:282:1: entryRuleValueRule returns [EObject current=null] : iv_ruleValueRule= ruleValueRule EOF ;
    public final EObject entryRuleValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:283:2: (iv_ruleValueRule= ruleValueRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:284:2: iv_ruleValueRule= ruleValueRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueRule_in_entryRuleValueRule443);
            iv_ruleValueRule=ruleValueRule();
            _fsp--;

             current =iv_ruleValueRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueRule453); 

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
    // $ANTLR end entryRuleValueRule


    // $ANTLR start ruleValueRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:291:1: ruleValueRule returns [EObject current=null] : (this_ReferenceValueRule_0= ruleReferenceValueRule | this_ExpressionValueRule_1= ruleExpressionValueRule ) ;
    public final EObject ruleValueRule() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceValueRule_0 = null;

        EObject this_ExpressionValueRule_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:296:6: ( (this_ReferenceValueRule_0= ruleReferenceValueRule | this_ExpressionValueRule_1= ruleExpressionValueRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:297:1: (this_ReferenceValueRule_0= ruleReferenceValueRule | this_ExpressionValueRule_1= ruleExpressionValueRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:297:1: (this_ReferenceValueRule_0= ruleReferenceValueRule | this_ExpressionValueRule_1= ruleExpressionValueRule )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            else if ( (LA4_0==20) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("297:1: (this_ReferenceValueRule_0= ruleReferenceValueRule | this_ExpressionValueRule_1= ruleExpressionValueRule )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:298:5: this_ReferenceValueRule_0= ruleReferenceValueRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueRuleAccess().getReferenceValueRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferenceValueRule_in_ruleValueRule500);
                    this_ReferenceValueRule_0=ruleReferenceValueRule();
                    _fsp--;

                     
                            current = this_ReferenceValueRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:308:5: this_ExpressionValueRule_1= ruleExpressionValueRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueRuleAccess().getExpressionValueRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionValueRule_in_ruleValueRule527);
                    this_ExpressionValueRule_1=ruleExpressionValueRule();
                    _fsp--;

                     
                            current = this_ExpressionValueRule_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleValueRule


    // $ANTLR start entryRuleReferenceValueRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:324:1: entryRuleReferenceValueRule returns [EObject current=null] : iv_ruleReferenceValueRule= ruleReferenceValueRule EOF ;
    public final EObject entryRuleReferenceValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceValueRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:325:2: (iv_ruleReferenceValueRule= ruleReferenceValueRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:326:2: iv_ruleReferenceValueRule= ruleReferenceValueRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceValueRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferenceValueRule_in_entryRuleReferenceValueRule562);
            iv_ruleReferenceValueRule=ruleReferenceValueRule();
            _fsp--;

             current =iv_ruleReferenceValueRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceValueRule572); 

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
    // $ANTLR end entryRuleReferenceValueRule


    // $ANTLR start ruleReferenceValueRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:333:1: ruleReferenceValueRule returns [EObject current=null] : ( '->' ( ( RULE_ID ) ) ) ;
    public final EObject ruleReferenceValueRule() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:338:6: ( ( '->' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:339:1: ( '->' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:339:1: ( '->' ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:339:3: '->' ( ( RULE_ID ) )
            {
            match(input,19,FOLLOW_19_in_ruleReferenceValueRule607); 

                    createLeafNode(grammarAccess.getReferenceValueRuleAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:343:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:344:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:344:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:345:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceValueRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceValueRule625); 

            		createLeafNode(grammarAccess.getReferenceValueRuleAccess().getReferencedElementNamedElementCrossReference_1_0(), "referencedElement"); 
            	

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
    // $ANTLR end ruleReferenceValueRule


    // $ANTLR start entryRuleExpressionValueRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:365:1: entryRuleExpressionValueRule returns [EObject current=null] : iv_ruleExpressionValueRule= ruleExpressionValueRule EOF ;
    public final EObject entryRuleExpressionValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionValueRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:366:2: (iv_ruleExpressionValueRule= ruleExpressionValueRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:367:2: iv_ruleExpressionValueRule= ruleExpressionValueRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionValueRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionValueRule_in_entryRuleExpressionValueRule661);
            iv_ruleExpressionValueRule=ruleExpressionValueRule();
            _fsp--;

             current =iv_ruleExpressionValueRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionValueRule671); 

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
    // $ANTLR end entryRuleExpressionValueRule


    // $ANTLR start ruleExpressionValueRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:374:1: ruleExpressionValueRule returns [EObject current=null] : ( '=' ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExpressionValueRule() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:379:6: ( ( '=' ( (lv_expression_1_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:380:1: ( '=' ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:380:1: ( '=' ( (lv_expression_1_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:380:3: '=' ( (lv_expression_1_0= ruleExpression ) )
            {
            match(input,20,FOLLOW_20_in_ruleExpressionValueRule706); 

                    createLeafNode(grammarAccess.getExpressionValueRuleAccess().getEqualsSignKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:384:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:385:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:385:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:386:3: lv_expression_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionValueRuleAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionValueRule727);
            lv_expression_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionValueRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleExpressionValueRule


    // $ANTLR start entryRuleImport
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:418:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:419:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:420:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport765);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport775); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:427:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:432:6: ( ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:433:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:433:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:433:3: 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            match(input,21,FOLLOW_21_in_ruleImport810); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:437:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:438:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:438:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:439:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport827); 

            			createLeafNode(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"importURI",
            	        		lv_importURI_1_0, 
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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleContext
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:469:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:470:2: (iv_ruleContext= ruleContext EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:471:2: iv_ruleContext= ruleContext EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContextRule(), currentNode); 
            pushFollow(FOLLOW_ruleContext_in_entryRuleContext868);
            iv_ruleContext=ruleContext();
            _fsp--;

             current =iv_ruleContext; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContext878); 

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
    // $ANTLR end entryRuleContext


    // $ANTLR start ruleContext
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:478:1: ruleContext returns [EObject current=null] : ( 'context' ( ( RULE_ID ) ) ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:483:6: ( ( 'context' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:484:1: ( 'context' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:484:1: ( 'context' ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:484:3: 'context' ( ( RULE_ID ) )
            {
            match(input,22,FOLLOW_22_in_ruleContext913); 

                    createLeafNode(grammarAccess.getContextAccess().getContextKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:488:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:489:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:489:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:490:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getContextRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContext931); 

            		createLeafNode(grammarAccess.getContextAccess().getContextNamedElementCrossReference_1_0(), "context"); 
            	

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
    // $ANTLR end ruleContext


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:510:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:511:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:512:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression967);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression977); 

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:519:1: ruleExpression returns [EObject current=null] : ( (lv_exp_0_0= ruleAndOrXorExpression ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:524:6: ( ( (lv_exp_0_0= ruleAndOrXorExpression ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:525:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:525:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:526:1: (lv_exp_0_0= ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:526:1: (lv_exp_0_0= ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:527:3: lv_exp_0_0= ruleAndOrXorExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_ruleExpression1022);
            lv_exp_0_0=ruleAndOrXorExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"exp",
            	        		lv_exp_0_0, 
            	        		"AndOrXorExpression", 
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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleAndOrXorExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:557:1: entryRuleAndOrXorExpression returns [EObject current=null] : iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF ;
    public final EObject entryRuleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrXorExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:558:2: (iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:559:2: iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndOrXorExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression1057);
            iv_ruleAndOrXorExpression=ruleAndOrXorExpression();
            _fsp--;

             current =iv_ruleAndOrXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression1067); 

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
    // $ANTLR end entryRuleAndOrXorExpression


    // $ANTLR start ruleAndOrXorExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:566:1: ruleAndOrXorExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:571:6: ( ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:572:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:572:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:572:2: ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:572:2: ( (lv_exp_0_0= ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:573:1: (lv_exp_0_0= ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:573:1: (lv_exp_0_0= ruleEqualityExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:574:3: lv_exp_0_0= ruleEqualityExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression1113);
            lv_exp_0_0=ruleEqualityExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAndOrXorExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"exp",
            	        		lv_exp_0_0, 
            	        		"EqualityExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:596:2: ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=23 && LA6_0<=25)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:596:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:596:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:597:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:597:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:598:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:598:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    int alt5=3;
            	    switch ( input.LA(1) ) {
            	    case 23:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("598:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:599:3: lv_op_1_1= 'and'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,23,FOLLOW_23_in_ruleAndOrXorExpression1134); 

            	                    createLeafNode(grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getAndOrXorExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_1, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:617:8: lv_op_1_2= 'or'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,24,FOLLOW_24_in_ruleAndOrXorExpression1163); 

            	                    createLeafNode(grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getAndOrXorExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_2, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:635:8: lv_op_1_3= 'xor'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,25,FOLLOW_25_in_ruleAndOrXorExpression1192); 

            	                    createLeafNode(grammarAccess.getAndOrXorExpressionAccess().getOpXorKeyword_1_0_0_2(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getAndOrXorExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_3, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:656:2: ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:657:1: (lv_exp_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:657:1: (lv_exp_2_0= ruleEqualityExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:658:3: lv_exp_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression1229);
            	    lv_exp_2_0=ruleEqualityExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAndOrXorExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"exp",
            	    	        		lv_exp_2_0, 
            	    	        		"EqualityExpression", 
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
    // $ANTLR end ruleAndOrXorExpression


    // $ANTLR start entryRuleEqualityExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:688:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:689:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:690:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1267);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression1277); 

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
    // $ANTLR end entryRuleEqualityExpression


    // $ANTLR start ruleEqualityExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:697:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:702:6: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:703:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:703:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:703:2: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:703:2: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:704:1: (lv_exp_0_0= ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:704:1: (lv_exp_0_0= ruleRelationalExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:705:3: lv_exp_0_0= ruleRelationalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1323);
            lv_exp_0_0=ruleRelationalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"exp",
            	        		lv_exp_0_0, 
            	        		"RelationalExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:727:2: ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=26 && LA8_0<=27)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:727:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:727:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:728:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:728:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:729:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:729:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==26) ) {
            	        alt7=1;
            	    }
            	    else if ( (LA7_0==27) ) {
            	        alt7=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("729:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:730:3: lv_op_1_1= '=='
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,26,FOLLOW_26_in_ruleEqualityExpression1344); 

            	                    createLeafNode(grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_1, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:748:8: lv_op_1_2= '<>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,27,FOLLOW_27_in_ruleEqualityExpression1373); 

            	                    createLeafNode(grammarAccess.getEqualityExpressionAccess().getOpLessThanSignGreaterThanSignKeyword_1_0_0_1(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_2, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:769:2: ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:770:1: (lv_exp_2_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:770:1: (lv_exp_2_0= ruleRelationalExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:771:3: lv_exp_2_0= ruleRelationalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1410);
            	    lv_exp_2_0=ruleRelationalExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"exp",
            	    	        		lv_exp_2_0, 
            	    	        		"RelationalExpression", 
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
    // $ANTLR end ruleEqualityExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:801:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:802:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:803:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1448);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression1458); 

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
    // $ANTLR end entryRuleRelationalExpression


    // $ANTLR start ruleRelationalExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:810:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:815:6: ( ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:816:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:816:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:816:2: ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:816:2: ( (lv_exp_0_0= ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:817:1: (lv_exp_0_0= ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:817:1: (lv_exp_0_0= ruleConditionalExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:818:3: lv_exp_0_0= ruleConditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1504);
            lv_exp_0_0=ruleConditionalExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"exp",
            	        		lv_exp_0_0, 
            	        		"ConditionalExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:840:2: ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=28 && LA10_0<=31)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:840:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:840:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:841:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:841:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:842:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:842:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    int alt9=4;
            	    switch ( input.LA(1) ) {
            	    case 28:
            	        {
            	        alt9=1;
            	        }
            	        break;
            	    case 29:
            	        {
            	        alt9=2;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt9=3;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt9=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("842:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )", 9, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt9) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:843:3: lv_op_1_1= '<'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,28,FOLLOW_28_in_ruleRelationalExpression1525); 

            	                    createLeafNode(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_1, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:861:8: lv_op_1_2= '>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,29,FOLLOW_29_in_ruleRelationalExpression1554); 

            	                    createLeafNode(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_2, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:879:8: lv_op_1_3= '<='
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,30,FOLLOW_30_in_ruleRelationalExpression1583); 

            	                    createLeafNode(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_3, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:897:8: lv_op_1_4= '>='
            	            {
            	            lv_op_1_4=(Token)input.LT(1);
            	            match(input,31,FOLLOW_31_in_ruleRelationalExpression1612); 

            	                    createLeafNode(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_0_3(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_4, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:918:2: ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:919:1: (lv_exp_2_0= ruleConditionalExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:919:1: (lv_exp_2_0= ruleConditionalExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:920:3: lv_exp_2_0= ruleConditionalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1649);
            	    lv_exp_2_0=ruleConditionalExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"exp",
            	    	        		lv_exp_2_0, 
            	    	        		"ConditionalExpression", 
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
            	    break loop10;
                }
            } while (true);


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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleConditionalExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:950:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:951:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:952:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1687);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression1697); 

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
    // $ANTLR end entryRuleConditionalExpression


    // $ANTLR start ruleConditionalExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:959:1: ruleConditionalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;

        EObject lv_exp_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:964:6: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:965:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:965:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:965:2: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:965:2: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:966:1: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:966:1: (lv_exp_0_0= ruleAdditiveExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:967:3: lv_exp_0_0= ruleAdditiveExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1743);
            lv_exp_0_0=ruleAdditiveExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"exp",
            	        		lv_exp_0_0, 
            	        		"AdditiveExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:989:2: ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==32) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:989:3: ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:989:3: ( (lv_op_1_0= '?' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:990:1: (lv_op_1_0= '?' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:990:1: (lv_op_1_0= '?' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:991:3: lv_op_1_0= '?'
                    {
                    lv_op_1_0=(Token)input.LT(1);
                    match(input,32,FOLLOW_32_in_ruleConditionalExpression1762); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0(), "op"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "op", lv_op_1_0, "?", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1010:2: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1011:1: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1011:1: (lv_exp_2_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1012:3: lv_exp_2_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1796);
                    lv_exp_2_0=ruleAdditiveExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"exp",
                    	        		lv_exp_2_0, 
                    	        		"AdditiveExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,33,FOLLOW_33_in_ruleConditionalExpression1806); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1038:1: ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1039:1: (lv_exp_4_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1039:1: (lv_exp_4_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1040:3: lv_exp_4_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1827);
                    lv_exp_4_0=ruleAdditiveExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConditionalExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"exp",
                    	        		lv_exp_4_0, 
                    	        		"AdditiveExpression", 
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
    // $ANTLR end ruleConditionalExpression


    // $ANTLR start entryRuleAdditiveExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1070:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1071:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1072:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1865);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1875); 

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
    // $ANTLR end entryRuleAdditiveExpression


    // $ANTLR start ruleAdditiveExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1079:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1084:6: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1085:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1085:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1085:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1085:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1086:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1086:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1087:3: lv_exp_0_0= ruleMultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1921);
            lv_exp_0_0=ruleMultiplicativeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"exp",
            	        		lv_exp_0_0, 
            	        		"MultiplicativeExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1109:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=34 && LA13_0<=35)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1109:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1109:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1110:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1110:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1111:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1111:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==34) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==35) ) {
            	        alt12=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("1111:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )", 12, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1112:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,34,FOLLOW_34_in_ruleAdditiveExpression1942); 

            	                    createLeafNode(grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_1, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1130:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,35,FOLLOW_35_in_ruleAdditiveExpression1971); 

            	                    createLeafNode(grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_0_0_1(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_2, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1151:2: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1152:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1152:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1153:3: lv_exp_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2008);
            	    lv_exp_2_0=ruleMultiplicativeExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"exp",
            	    	        		lv_exp_2_0, 
            	    	        		"MultiplicativeExpression", 
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
            	    break loop13;
                }
            } while (true);


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
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1183:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1184:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1185:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2046);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression2056); 

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
    // $ANTLR end entryRuleMultiplicativeExpression


    // $ANTLR start ruleMultiplicativeExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1192:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1197:6: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1198:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1198:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1198:2: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1198:2: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1199:1: (lv_exp_0_0= ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1199:1: (lv_exp_0_0= ruleUnaryExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1200:3: lv_exp_0_0= ruleUnaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2102);
            lv_exp_0_0=ruleUnaryExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"exp",
            	        		lv_exp_0_0, 
            	        		"UnaryExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1222:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=36 && LA15_0<=38)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1222:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1222:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1223:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1223:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1224:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1224:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    int alt14=3;
            	    switch ( input.LA(1) ) {
            	    case 36:
            	        {
            	        alt14=1;
            	        }
            	        break;
            	    case 37:
            	        {
            	        alt14=2;
            	        }
            	        break;
            	    case 38:
            	        {
            	        alt14=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("1224:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )", 14, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt14) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1225:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,36,FOLLOW_36_in_ruleMultiplicativeExpression2123); 

            	                    createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_1, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1243:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,37,FOLLOW_37_in_ruleMultiplicativeExpression2152); 

            	                    createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_2, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1261:8: lv_op_1_3= 'mod'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,38,FOLLOW_38_in_ruleMultiplicativeExpression2181); 

            	                    createLeafNode(grammarAccess.getMultiplicativeExpressionAccess().getOpModKeyword_1_0_0_2(), "op"); 
            	                

            	            	        if (current==null) {
            	            	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	            	            associateNodeWithAstElement(currentNode, current);
            	            	        }
            	            	        
            	            	        try {
            	            	       		add(current, "op", lv_op_1_3, null, lastConsumedNode);
            	            	        } catch (ValueConverterException vce) {
            	            				handleValueConverterException(vce);
            	            	        }
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1282:2: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1283:1: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1283:1: (lv_exp_2_0= ruleUnaryExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1284:3: lv_exp_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2218);
            	    lv_exp_2_0=ruleUnaryExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"exp",
            	    	        		lv_exp_2_0, 
            	    	        		"UnaryExpression", 
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
            	    break loop15;
                }
            } while (true);


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
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleUnaryExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1314:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1315:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1316:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression2256);
            iv_ruleUnaryExpression=ruleUnaryExpression();
            _fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression2266); 

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
    // $ANTLR end entryRuleUnaryExpression


    // $ANTLR start ruleUnaryExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1323:1: ruleUnaryExpression returns [EObject current=null] : ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        EObject lv_unary_1_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1328:6: ( ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1329:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1329:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=34 && LA17_0<=35)||LA17_0==39) ) {
                alt17=1;
            }
            else if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_NULLLITERAL)||(LA17_0>=36 && LA17_0<=37)||LA17_0==41||(LA17_0>=44 && LA17_0<=45)||LA17_0==47||LA17_0==49||(LA17_0>=51 && LA17_0<=56)) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1329:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1329:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1329:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1329:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1329:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1330:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1330:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1331:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1331:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    int alt16=3;
                    switch ( input.LA(1) ) {
                    case 39:
                        {
                        alt16=1;
                        }
                        break;
                    case 35:
                        {
                        alt16=2;
                        }
                        break;
                    case 34:
                        {
                        alt16=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("1331:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )", 16, 0, input);

                        throw nvae;
                    }

                    switch (alt16) {
                        case 1 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1332:3: lv_op_0_1= 'not'
                            {
                            lv_op_0_1=(Token)input.LT(1);
                            match(input,39,FOLLOW_39_in_ruleUnaryExpression2312); 

                                    createLeafNode(grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0(), "op"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "op", lv_op_0_1, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1350:8: lv_op_0_2= '-'
                            {
                            lv_op_0_2=(Token)input.LT(1);
                            match(input,35,FOLLOW_35_in_ruleUnaryExpression2341); 

                                    createLeafNode(grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1(), "op"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "op", lv_op_0_2, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1368:8: lv_op_0_3= '+'
                            {
                            lv_op_0_3=(Token)input.LT(1);
                            match(input,34,FOLLOW_34_in_ruleUnaryExpression2370); 

                                    createLeafNode(grammarAccess.getUnaryExpressionAccess().getOpPlusSignKeyword_0_0_0_2(), "op"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "op", lv_op_0_3, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1389:2: ( (lv_unary_1_0= ruleUnaryExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1390:1: (lv_unary_1_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1390:1: (lv_unary_1_0= ruleUnaryExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1391:3: lv_unary_1_0= ruleUnaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression2407);
                    lv_unary_1_0=ruleUnaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unary",
                    	        		lv_unary_1_0, 
                    	        		"UnaryExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1414:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1414:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1415:1: (lv_exp_2_0= rulePrimaryExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1415:1: (lv_exp_2_0= rulePrimaryExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1416:3: lv_exp_2_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression2435);
                    lv_exp_2_0=rulePrimaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exp",
                    	        		lv_exp_2_0, 
                    	        		"PrimaryExpression", 
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
    // $ANTLR end ruleUnaryExpression


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1446:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1447:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1448:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2471);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression2481); 

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
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1455:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_prefix_0_0 = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1460:6: ( ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1461:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1461:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1461:2: ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1461:2: ( (lv_prefix_0_0= ruleValueSpecification ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1462:1: (lv_prefix_0_0= ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1462:1: (lv_prefix_0_0= ruleValueSpecification )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1463:3: lv_prefix_0_0= ruleValueSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueSpecification_in_rulePrimaryExpression2527);
            lv_prefix_0_0=ruleValueSpecification();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPrimaryExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"prefix",
            	        		lv_prefix_0_0, 
            	        		"ValueSpecification", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1485:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==40) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1485:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,40,FOLLOW_40_in_rulePrimaryExpression2538); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1489:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1490:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1490:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1491:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2559);
                    lv_suffix_2_0=ruleSuffixExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPrimaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"suffix",
                    	        		lv_suffix_2_0, 
                    	        		"SuffixExpression", 
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
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleValueSpecification
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1521:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1522:2: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1523:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2597);
            iv_ruleValueSpecification=ruleValueSpecification();
            _fsp--;

             current =iv_ruleValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification2607); 

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
    // $ANTLR end entryRuleValueSpecification


    // $ANTLR start ruleValueSpecification
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1530:1: ruleValueSpecification returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) ;
    public final EObject ruleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_NameOrChoiceOrBehaviorCall_1 = null;

        EObject this_Interval_2 = null;

        EObject this_CollectionOrTuple_3 = null;

        EObject this_Tuple_4 = null;

        EObject this_TimeExpression_5 = null;

        EObject this_VariableDeclaration_6 = null;

        EObject this_Expression_8 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1535:6: ( (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1536:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1536:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            int alt19=8;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case RULE_DATETIMELITERAL:
            case RULE_BOOLEANLITERAL:
            case RULE_NULLLITERAL:
            case 36:
            case 37:
                {
                alt19=1;
                }
                break;
            case RULE_ID:
                {
                alt19=2;
                }
                break;
            case 44:
            case 45:
                {
                alt19=3;
                }
                break;
            case 47:
                {
                int LA19_4 = input.LA(2);

                if ( (LA19_4==RULE_ID) ) {
                    int LA19_8 = input.LA(3);

                    if ( (LA19_8==18||(LA19_8>=23 && LA19_8<=32)||(LA19_8>=34 && LA19_8<=38)||(LA19_8>=40 && LA19_8<=41)||LA19_8==43||LA19_8==48) ) {
                        alt19=4;
                    }
                    else if ( (LA19_8==20) ) {
                        alt19=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1536:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 19, 8, input);

                        throw nvae;
                    }
                }
                else if ( ((LA19_4>=RULE_STRING && LA19_4<=RULE_NULLLITERAL)||(LA19_4>=34 && LA19_4<=37)||LA19_4==39||LA19_4==41||(LA19_4>=44 && LA19_4<=45)||LA19_4==47||LA19_4==49||(LA19_4>=51 && LA19_4<=56)) ) {
                    alt19=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1536:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 19, 4, input);

                    throw nvae;
                }
                }
                break;
            case 49:
            case 51:
            case 52:
                {
                alt19=6;
                }
                break;
            case 53:
            case 54:
            case 55:
            case 56:
                {
                alt19=7;
                }
                break;
            case 41:
                {
                alt19=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1536:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1537:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleValueSpecification2654);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1547:5: this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2681);
                    this_NameOrChoiceOrBehaviorCall_1=ruleNameOrChoiceOrBehaviorCall();
                    _fsp--;

                     
                            current = this_NameOrChoiceOrBehaviorCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1557:5: this_Interval_2= ruleInterval
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInterval_in_ruleValueSpecification2708);
                    this_Interval_2=ruleInterval();
                    _fsp--;

                     
                            current = this_Interval_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1567:5: this_CollectionOrTuple_3= ruleCollectionOrTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2735);
                    this_CollectionOrTuple_3=ruleCollectionOrTuple();
                    _fsp--;

                     
                            current = this_CollectionOrTuple_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1577:5: this_Tuple_4= ruleTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTuple_in_ruleValueSpecification2762);
                    this_Tuple_4=ruleTuple();
                    _fsp--;

                     
                            current = this_Tuple_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1587:5: this_TimeExpression_5= ruleTimeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeExpression_in_ruleValueSpecification2789);
                    this_TimeExpression_5=ruleTimeExpression();
                    _fsp--;

                     
                            current = this_TimeExpression_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1597:5: this_VariableDeclaration_6= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2816);
                    this_VariableDeclaration_6=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1606:6: ( '(' this_Expression_8= ruleExpression ')' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1606:6: ( '(' this_Expression_8= ruleExpression ')' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1606:8: '(' this_Expression_8= ruleExpression ')'
                    {
                    match(input,41,FOLLOW_41_in_ruleValueSpecification2832); 

                            createLeafNode(grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleValueSpecification2854);
                    this_Expression_8=ruleExpression();
                    _fsp--;

                     
                            current = this_Expression_8; 
                            currentNode = currentNode.getParent();
                        
                    match(input,42,FOLLOW_42_in_ruleValueSpecification2863); 

                            createLeafNode(grammarAccess.getValueSpecificationAccess().getRightParenthesisKeyword_7_2(), null); 
                        

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
    // $ANTLR end ruleValueSpecification


    // $ANTLR start entryRuleSuffixExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1631:1: entryRuleSuffixExpression returns [EObject current=null] : iv_ruleSuffixExpression= ruleSuffixExpression EOF ;
    public final EObject entryRuleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuffixExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1632:2: (iv_ruleSuffixExpression= ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1633:2: iv_ruleSuffixExpression= ruleSuffixExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuffixExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2900);
            iv_ruleSuffixExpression=ruleSuffixExpression();
            _fsp--;

             current =iv_ruleSuffixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression2910); 

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
    // $ANTLR end entryRuleSuffixExpression


    // $ANTLR start ruleSuffixExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1640:1: ruleSuffixExpression returns [EObject current=null] : (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) ;
    public final EObject ruleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyCallExpression_0 = null;

        EObject this_OperationCallExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1645:6: ( (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1646:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1646:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==41) ) {
                    alt20=2;
                }
                else if ( (LA20_1==EOF||LA20_1==16||LA20_1==18||(LA20_1>=23 && LA20_1<=38)||LA20_1==40||LA20_1==42||(LA20_1>=44 && LA20_1<=46)||LA20_1==48) ) {
                    alt20=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1646:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1646:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1647:5: this_PropertyCallExpression_0= rulePropertyCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2957);
                    this_PropertyCallExpression_0=rulePropertyCallExpression();
                    _fsp--;

                     
                            current = this_PropertyCallExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1657:5: this_OperationCallExpression_1= ruleOperationCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2984);
                    this_OperationCallExpression_1=ruleOperationCallExpression();
                    _fsp--;

                     
                            current = this_OperationCallExpression_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleSuffixExpression


    // $ANTLR start entryRulePropertyCallExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1673:1: entryRulePropertyCallExpression returns [EObject current=null] : iv_rulePropertyCallExpression= rulePropertyCallExpression EOF ;
    public final EObject entryRulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCallExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1674:2: (iv_rulePropertyCallExpression= rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1675:2: iv_rulePropertyCallExpression= rulePropertyCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression3019);
            iv_rulePropertyCallExpression=rulePropertyCallExpression();
            _fsp--;

             current =iv_rulePropertyCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression3029); 

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
    // $ANTLR end entryRulePropertyCallExpression


    // $ANTLR start rulePropertyCallExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1682:1: rulePropertyCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1687:6: ( ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1688:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1688:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1688:2: ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1688:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1689:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1689:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1690:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyCallExpression3072); 

            		createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1702:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==40) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1702:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,40,FOLLOW_40_in_rulePropertyCallExpression3083); 

                            createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1706:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1707:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1707:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1708:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression3104);
                    lv_suffix_2_0=ruleSuffixExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPropertyCallExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"suffix",
                    	        		lv_suffix_2_0, 
                    	        		"SuffixExpression", 
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
    // $ANTLR end rulePropertyCallExpression


    // $ANTLR start entryRuleOperationCallExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1738:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1739:2: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1740:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression3142);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();
            _fsp--;

             current =iv_ruleOperationCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression3152); 

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
    // $ANTLR end entryRuleOperationCallExpression


    // $ANTLR start ruleOperationCallExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1747:1: ruleOperationCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject ruleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_suffix_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1752:6: ( ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1753:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1753:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1753:2: ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1753:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1754:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1754:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1755:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getOperationCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpression3195); 

            		createLeafNode(grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0(), "operation"); 
            	

            }


            }

            match(input,41,FOLLOW_41_in_ruleOperationCallExpression3205); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1771:1: ( (lv_arguments_2_0= ruleListOfValues ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_NULLLITERAL)||(LA22_0>=34 && LA22_0<=37)||LA22_0==39||LA22_0==41||(LA22_0>=44 && LA22_0<=45)||LA22_0==47||LA22_0==49||(LA22_0>=51 && LA22_0<=56)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1772:1: (lv_arguments_2_0= ruleListOfValues )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1772:1: (lv_arguments_2_0= ruleListOfValues )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1773:3: lv_arguments_2_0= ruleListOfValues
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListOfValues_in_ruleOperationCallExpression3226);
                    lv_arguments_2_0=ruleListOfValues();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationCallExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"arguments",
                    	        		lv_arguments_2_0, 
                    	        		"ListOfValues", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,42,FOLLOW_42_in_ruleOperationCallExpression3237); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1799:1: ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1799:3: '.' ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    {
                    match(input,40,FOLLOW_40_in_ruleOperationCallExpression3248); 

                            createLeafNode(grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1803:1: ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1804:1: (lv_suffix_5_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1804:1: (lv_suffix_5_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1805:3: lv_suffix_5_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression3269);
                    lv_suffix_5_0=ruleSuffixExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationCallExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"suffix",
                    	        		lv_suffix_5_0, 
                    	        		"SuffixExpression", 
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
    // $ANTLR end ruleOperationCallExpression


    // $ANTLR start entryRuleLiteral
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1835:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1836:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1837:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3307);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3317); 

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
    // $ANTLR end entryRuleLiteral


    // $ANTLR start ruleLiteral
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1844:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralRule_0 = null;

        EObject this_DateTimeLiteralRule_1 = null;

        EObject this_BooleanLiteralRule_2 = null;

        EObject this_NullLiteralRule_3 = null;

        EObject this_DefaultLiteralRule_4 = null;

        EObject this_StringLiteralRule_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1849:6: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1850:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1850:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            int alt24=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case 36:
                {
                alt24=1;
                }
                break;
            case RULE_DATETIMELITERAL:
                {
                alt24=2;
                }
                break;
            case RULE_BOOLEANLITERAL:
                {
                alt24=3;
                }
                break;
            case RULE_NULLLITERAL:
                {
                alt24=4;
                }
                break;
            case 37:
                {
                alt24=5;
                }
                break;
            case RULE_STRING:
                {
                alt24=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1850:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1851:5: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_ruleLiteral3364);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();
                    _fsp--;

                     
                            current = this_NumberLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1861:5: this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral3391);
                    this_DateTimeLiteralRule_1=ruleDateTimeLiteralRule();
                    _fsp--;

                     
                            current = this_DateTimeLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1871:5: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral3418);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();
                    _fsp--;

                     
                            current = this_BooleanLiteralRule_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1881:5: this_NullLiteralRule_3= ruleNullLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_ruleLiteral3445);
                    this_NullLiteralRule_3=ruleNullLiteralRule();
                    _fsp--;

                     
                            current = this_NullLiteralRule_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1891:5: this_DefaultLiteralRule_4= ruleDefaultLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral3472);
                    this_DefaultLiteralRule_4=ruleDefaultLiteralRule();
                    _fsp--;

                     
                            current = this_DefaultLiteralRule_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1901:5: this_StringLiteralRule_5= ruleStringLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_ruleLiteral3499);
                    this_StringLiteralRule_5=ruleStringLiteralRule();
                    _fsp--;

                     
                            current = this_StringLiteralRule_5; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleLiteral


    // $ANTLR start entryRuleNameOrChoiceOrBehaviorCall
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1917:1: entryRuleNameOrChoiceOrBehaviorCall returns [EObject current=null] : iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF ;
    public final EObject entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrChoiceOrBehaviorCall = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1918:2: (iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1919:2: iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall3534);
            iv_ruleNameOrChoiceOrBehaviorCall=ruleNameOrChoiceOrBehaviorCall();
            _fsp--;

             current =iv_ruleNameOrChoiceOrBehaviorCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3544); 

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
    // $ANTLR end entryRuleNameOrChoiceOrBehaviorCall


    // $ANTLR start ruleNameOrChoiceOrBehaviorCall
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1926:1: ruleNameOrChoiceOrBehaviorCall returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) ;
    public final EObject ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;

        EObject lv_arguments_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1931:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1932:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1932:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1932:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1932:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==43) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1933:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1933:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1934:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3590);
                    lv_path_0_0=ruleQualifiedName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNameOrChoiceOrBehaviorCallRule().getType().getClassifier());
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1956:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1957:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1957:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1958:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNameOrChoiceOrBehaviorCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3609); 

            		createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0(), "id"); 
            	

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1970:2: ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==41) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1970:4: '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')'
                    {
                    match(input,41,FOLLOW_41_in_ruleNameOrChoiceOrBehaviorCall3620); 

                            createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1974:1: ( (lv_arguments_3_0= ruleListOfValues ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_NULLLITERAL)||(LA26_0>=34 && LA26_0<=37)||LA26_0==39||LA26_0==41||(LA26_0>=44 && LA26_0<=45)||LA26_0==47||LA26_0==49||(LA26_0>=51 && LA26_0<=56)) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1975:1: (lv_arguments_3_0= ruleListOfValues )
                            {
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1975:1: (lv_arguments_3_0= ruleListOfValues )
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1976:3: lv_arguments_3_0= ruleListOfValues
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3641);
                            lv_arguments_3_0=ruleListOfValues();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getNameOrChoiceOrBehaviorCallRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"arguments",
                            	        		lv_arguments_3_0, 
                            	        		"ListOfValues", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }
                            break;

                    }

                    match(input,42,FOLLOW_42_in_ruleNameOrChoiceOrBehaviorCall3652); 

                            createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getRightParenthesisKeyword_2_2(), null); 
                        

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
    // $ANTLR end ruleNameOrChoiceOrBehaviorCall


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2010:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2011:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2012:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3690);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3700); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2019:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2024:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2025:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2025:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2025:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2025:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2026:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2026:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2027:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3743); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,43,FOLLOW_43_in_ruleQualifiedName3753); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2043:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==43) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2044:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2044:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2045:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName3774);
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


    // $ANTLR start entryRuleInterval
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2075:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2076:2: (iv_ruleInterval= ruleInterval EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2077:2: iv_ruleInterval= ruleInterval EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntervalRule(), currentNode); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval3811);
            iv_ruleInterval=ruleInterval();
            _fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval3821); 

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
    // $ANTLR end entryRuleInterval


    // $ANTLR start ruleInterval
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2084:1: ruleInterval returns [EObject current=null] : ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token lv_isLowerIncluded_1_0=null;
        Token lv_isUpperIncluded_5_0=null;
        EObject lv_lower_2_0 = null;

        EObject lv_upper_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2089:6: ( ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2090:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2090:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2090:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2090:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==44) ) {
                alt29=1;
            }
            else if ( (LA29_0==45) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2090:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2090:4: ']'
                    {
                    match(input,44,FOLLOW_44_in_ruleInterval3857); 

                            createLeafNode(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2095:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2095:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2096:1: (lv_isLowerIncluded_1_0= '[' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2096:1: (lv_isLowerIncluded_1_0= '[' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2097:3: lv_isLowerIncluded_1_0= '['
                    {
                    lv_isLowerIncluded_1_0=(Token)input.LT(1);
                    match(input,45,FOLLOW_45_in_ruleInterval3881); 

                            createLeafNode(grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0(), "isLowerIncluded"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntervalRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isLowerIncluded", lv_isLowerIncluded_1_0, "[", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2116:3: ( (lv_lower_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2117:1: (lv_lower_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2117:1: (lv_lower_2_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2118:3: lv_lower_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3916);
            lv_lower_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIntervalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"lower",
            	        		lv_lower_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,46,FOLLOW_46_in_ruleInterval3926); 

                    createLeafNode(grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2144:1: ( (lv_upper_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2145:1: (lv_upper_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2145:1: (lv_upper_4_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2146:3: lv_upper_4_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3947);
            lv_upper_4_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIntervalRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"upper",
            	        		lv_upper_4_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2168:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==44) ) {
                alt30=1;
            }
            else if ( (LA30_0==45) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2168:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2168:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2168:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2169:1: (lv_isUpperIncluded_5_0= ']' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2169:1: (lv_isUpperIncluded_5_0= ']' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2170:3: lv_isUpperIncluded_5_0= ']'
                    {
                    lv_isUpperIncluded_5_0=(Token)input.LT(1);
                    match(input,44,FOLLOW_44_in_ruleInterval3966); 

                            createLeafNode(grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0(), "isUpperIncluded"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntervalRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isUpperIncluded", lv_isUpperIncluded_5_0, "]", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2190:7: '['
                    {
                    match(input,45,FOLLOW_45_in_ruleInterval3995); 

                            createLeafNode(grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_4_1(), null); 
                        

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
    // $ANTLR end ruleInterval


    // $ANTLR start entryRuleCollectionOrTuple
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2202:1: entryRuleCollectionOrTuple returns [EObject current=null] : iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF ;
    public final EObject entryRuleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionOrTuple = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2203:2: (iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2204:2: iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCollectionOrTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple4032);
            iv_ruleCollectionOrTuple=ruleCollectionOrTuple();
            _fsp--;

             current =iv_ruleCollectionOrTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple4042); 

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
    // $ANTLR end entryRuleCollectionOrTuple


    // $ANTLR start ruleCollectionOrTuple
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2211:1: ruleCollectionOrTuple returns [EObject current=null] : ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) ;
    public final EObject ruleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValues_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2216:6: ( ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2217:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2217:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2217:3: '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}'
            {
            match(input,47,FOLLOW_47_in_ruleCollectionOrTuple4077); 

                    createLeafNode(grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2221:1: ( (lv_listOfValues_1_0= ruleListOfValues ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2222:1: (lv_listOfValues_1_0= ruleListOfValues )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2222:1: (lv_listOfValues_1_0= ruleListOfValues )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2223:3: lv_listOfValues_1_0= ruleListOfValues
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple4098);
            lv_listOfValues_1_0=ruleListOfValues();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCollectionOrTupleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"listOfValues",
            	        		lv_listOfValues_1_0, 
            	        		"ListOfValues", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,48,FOLLOW_48_in_ruleCollectionOrTuple4108); 

                    createLeafNode(grammarAccess.getCollectionOrTupleAccess().getRightCurlyBracketKeyword_2(), null); 
                

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
    // $ANTLR end ruleCollectionOrTuple


    // $ANTLR start entryRuleTuple
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2257:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2258:2: (iv_ruleTuple= ruleTuple EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2259:2: iv_ruleTuple= ruleTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple4144);
            iv_ruleTuple=ruleTuple();
            _fsp--;

             current =iv_ruleTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple4154); 

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
    // $ANTLR end entryRuleTuple


    // $ANTLR start ruleTuple
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2266:1: ruleTuple returns [EObject current=null] : ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValueNamePairs_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2271:6: ( ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2272:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2272:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2272:3: '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}'
            {
            match(input,47,FOLLOW_47_in_ruleTuple4189); 

                    createLeafNode(grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2276:1: ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2277:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2277:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2278:3: lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_ruleTuple4210);
            lv_listOfValueNamePairs_1_0=ruleListOfValueNamePairs();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTupleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"listOfValueNamePairs",
            	        		lv_listOfValueNamePairs_1_0, 
            	        		"ListOfValueNamePairs", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,48,FOLLOW_48_in_ruleTuple4220); 

                    createLeafNode(grammarAccess.getTupleAccess().getRightCurlyBracketKeyword_2(), null); 
                

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
    // $ANTLR end ruleTuple


    // $ANTLR start entryRuleListOfValues
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2312:1: entryRuleListOfValues returns [EObject current=null] : iv_ruleListOfValues= ruleListOfValues EOF ;
    public final EObject entryRuleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValues = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2313:2: (iv_ruleListOfValues= ruleListOfValues EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2314:2: iv_ruleListOfValues= ruleListOfValues EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValuesRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues4256);
            iv_ruleListOfValues=ruleListOfValues();
            _fsp--;

             current =iv_ruleListOfValues; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues4266); 

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
    // $ANTLR end entryRuleListOfValues


    // $ANTLR start ruleListOfValues
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2321:1: ruleListOfValues returns [EObject current=null] : ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2326:6: ( ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2327:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2327:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2327:2: ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2327:2: ( (lv_values_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2328:1: (lv_values_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2328:1: (lv_values_0_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2329:3: lv_values_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues4312);
            lv_values_0_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getListOfValuesRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"values",
            	        		lv_values_0_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2351:2: ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==18) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2351:4: ',' ( (lv_values_2_0= ruleExpression ) )
            	    {
            	    match(input,18,FOLLOW_18_in_ruleListOfValues4323); 

            	            createLeafNode(grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2355:1: ( (lv_values_2_0= ruleExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2356:1: (lv_values_2_0= ruleExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2356:1: (lv_values_2_0= ruleExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2357:3: lv_values_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues4344);
            	    lv_values_2_0=ruleExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getListOfValuesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"values",
            	    	        		lv_values_2_0, 
            	    	        		"Expression", 
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
            	    break loop31;
                }
            } while (true);


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
    // $ANTLR end ruleListOfValues


    // $ANTLR start entryRuleListOfValueNamePairs
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2387:1: entryRuleListOfValueNamePairs returns [EObject current=null] : iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF ;
    public final EObject entryRuleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValueNamePairs = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2388:2: (iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2389:2: iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValueNamePairsRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs4382);
            iv_ruleListOfValueNamePairs=ruleListOfValueNamePairs();
            _fsp--;

             current =iv_ruleListOfValueNamePairs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs4392); 

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
    // $ANTLR end entryRuleListOfValueNamePairs


    // $ANTLR start ruleListOfValueNamePairs
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2396:1: ruleListOfValueNamePairs returns [EObject current=null] : ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) ;
    public final EObject ruleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject lv_valueNamePairs_0_0 = null;

        EObject lv_valueNamePairs_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2401:6: ( ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2402:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2402:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2402:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2402:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2403:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2403:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2404:3: lv_valueNamePairs_0_0= ruleValueNamePair
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4438);
            lv_valueNamePairs_0_0=ruleValueNamePair();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getListOfValueNamePairsRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"valueNamePairs",
            	        		lv_valueNamePairs_0_0, 
            	        		"ValueNamePair", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2426:2: ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==18) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2426:4: ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    {
            	    match(input,18,FOLLOW_18_in_ruleListOfValueNamePairs4449); 

            	            createLeafNode(grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2430:1: ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2431:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2431:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2432:3: lv_valueNamePairs_2_0= ruleValueNamePair
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4470);
            	    lv_valueNamePairs_2_0=ruleValueNamePair();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getListOfValueNamePairsRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"valueNamePairs",
            	    	        		lv_valueNamePairs_2_0, 
            	    	        		"ValueNamePair", 
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
            	    break loop32;
                }
            } while (true);


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
    // $ANTLR end ruleListOfValueNamePairs


    // $ANTLR start entryRuleValueNamePair
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2462:1: entryRuleValueNamePair returns [EObject current=null] : iv_ruleValueNamePair= ruleValueNamePair EOF ;
    public final EObject entryRuleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNamePair = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2463:2: (iv_ruleValueNamePair= ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2464:2: iv_ruleValueNamePair= ruleValueNamePair EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueNamePairRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair4508);
            iv_ruleValueNamePair=ruleValueNamePair();
            _fsp--;

             current =iv_ruleValueNamePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair4518); 

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
    // $ANTLR end entryRuleValueNamePair


    // $ANTLR start ruleValueNamePair
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2471:1: ruleValueNamePair returns [EObject current=null] : ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject lv_value_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2476:6: ( ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2477:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2477:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2477:2: ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2477:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2478:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2478:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2479:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getValueNamePairRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueNamePair4561); 

            		createLeafNode(grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            match(input,20,FOLLOW_20_in_ruleValueNamePair4571); 

                    createLeafNode(grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2495:1: ( (lv_value_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2496:1: (lv_value_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2496:1: (lv_value_2_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2497:3: lv_value_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleValueNamePair4592);
            lv_value_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getValueNamePairRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleValueNamePair


    // $ANTLR start entryRuleTimeExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2527:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2528:2: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2529:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4628);
            iv_ruleTimeExpression=ruleTimeExpression();
            _fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression4638); 

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
    // $ANTLR end entryRuleTimeExpression


    // $ANTLR start ruleTimeExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2536:1: ruleTimeExpression returns [EObject current=null] : (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_InstantObsExpression_0 = null;

        EObject this_DurationObsExpression_1 = null;

        EObject this_JitterExp_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2541:6: ( (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2542:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2542:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            int alt33=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt33=1;
                }
                break;
            case 51:
                {
                alt33=2;
                }
                break;
            case 52:
                {
                alt33=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2542:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2543:5: this_InstantObsExpression_0= ruleInstantObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4685);
                    this_InstantObsExpression_0=ruleInstantObsExpression();
                    _fsp--;

                     
                            current = this_InstantObsExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2553:5: this_DurationObsExpression_1= ruleDurationObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4712);
                    this_DurationObsExpression_1=ruleDurationObsExpression();
                    _fsp--;

                     
                            current = this_DurationObsExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2563:5: this_JitterExp_2= ruleJitterExp
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJitterExp_in_ruleTimeExpression4739);
                    this_JitterExp_2=ruleJitterExp();
                    _fsp--;

                     
                            current = this_JitterExp_2; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleTimeExpression


    // $ANTLR start entryRuleInstantObsExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2579:1: entryRuleInstantObsExpression returns [EObject current=null] : iv_ruleInstantObsExpression= ruleInstantObsExpression EOF ;
    public final EObject entryRuleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2580:2: (iv_ruleInstantObsExpression= ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2581:2: iv_ruleInstantObsExpression= ruleInstantObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4774);
            iv_ruleInstantObsExpression=ruleInstantObsExpression();
            _fsp--;

             current =iv_ruleInstantObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression4784); 

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
    // $ANTLR end entryRuleInstantObsExpression


    // $ANTLR start ruleInstantObsExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2588:1: ruleInstantObsExpression returns [EObject current=null] : ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2593:6: ( ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2594:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2594:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2594:3: '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,49,FOLLOW_49_in_ruleInstantObsExpression4819); 

                    createLeafNode(grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2598:1: ( (lv_id_1_0= ruleInstantObsName ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2599:1: (lv_id_1_0= ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2599:1: (lv_id_1_0= ruleInstantObsName )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2600:3: lv_id_1_0= ruleInstantObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4840);
            lv_id_1_0=ruleInstantObsName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getInstantObsExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"id",
            	        		lv_id_1_0, 
            	        		"InstantObsName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2622:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==41) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2622:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,41,FOLLOW_41_in_ruleInstantObsExpression4851); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2626:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2627:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2627:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2628:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4872);
                    lv_index_3_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInstantObsExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"index",
                    	        		lv_index_3_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,42,FOLLOW_42_in_ruleInstantObsExpression4882); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2654:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==50) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2654:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,50,FOLLOW_50_in_ruleInstantObsExpression4895); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,41,FOLLOW_41_in_ruleInstantObsExpression4905); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2662:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2663:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2663:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2664:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4926);
                    lv_condition_7_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInstantObsExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"condition",
                    	        		lv_condition_7_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,42,FOLLOW_42_in_ruleInstantObsExpression4936); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_3_3(), null); 
                        

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
    // $ANTLR end ruleInstantObsExpression


    // $ANTLR start entryRuleInstantObsName
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2698:1: entryRuleInstantObsName returns [EObject current=null] : iv_ruleInstantObsName= ruleInstantObsName EOF ;
    public final EObject entryRuleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2699:2: (iv_ruleInstantObsName= ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2700:2: iv_ruleInstantObsName= ruleInstantObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4974);
            iv_ruleInstantObsName=ruleInstantObsName();
            _fsp--;

             current =iv_ruleInstantObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName4984); 

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
    // $ANTLR end entryRuleInstantObsName


    // $ANTLR start ruleInstantObsName
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2707:1: ruleInstantObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2712:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2713:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2713:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2713:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2713:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==43) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2714:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2714:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2715:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstantObsName5030);
                    lv_path_0_0=ruleQualifiedName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getInstantObsNameRule().getType().getClassifier());
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2737:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2738:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2738:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2739:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getInstantObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstantObsName5049); 

            		createLeafNode(grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationCrossReference_1_0(), "instantId"); 
            	

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
    // $ANTLR end ruleInstantObsName


    // $ANTLR start entryRuleDurationObsExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2759:1: entryRuleDurationObsExpression returns [EObject current=null] : iv_ruleDurationObsExpression= ruleDurationObsExpression EOF ;
    public final EObject entryRuleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2760:2: (iv_ruleDurationObsExpression= ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2761:2: iv_ruleDurationObsExpression= ruleDurationObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression5085);
            iv_ruleDurationObsExpression=ruleDurationObsExpression();
            _fsp--;

             current =iv_ruleDurationObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression5095); 

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
    // $ANTLR end entryRuleDurationObsExpression


    // $ANTLR start ruleDurationObsExpression
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2768:1: ruleDurationObsExpression returns [EObject current=null] : ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2773:6: ( ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2774:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2774:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2774:3: '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,51,FOLLOW_51_in_ruleDurationObsExpression5130); 

                    createLeafNode(grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2778:1: ( (lv_id_1_0= ruleDurationObsName ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2779:1: (lv_id_1_0= ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2779:1: (lv_id_1_0= ruleDurationObsName )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2780:3: lv_id_1_0= ruleDurationObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression5151);
            lv_id_1_0=ruleDurationObsName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDurationObsExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"id",
            	        		lv_id_1_0, 
            	        		"DurationObsName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2802:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==41) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2802:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,41,FOLLOW_41_in_ruleDurationObsExpression5162); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2806:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2807:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2807:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2808:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression5183);
                    lv_index_3_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getDurationObsExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"index",
                    	        		lv_index_3_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,42,FOLLOW_42_in_ruleDurationObsExpression5193); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2834:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==50) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2834:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,50,FOLLOW_50_in_ruleDurationObsExpression5206); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,41,FOLLOW_41_in_ruleDurationObsExpression5216); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2842:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2843:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2843:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2844:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression5237);
                    lv_condition_7_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getDurationObsExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"condition",
                    	        		lv_condition_7_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,42,FOLLOW_42_in_ruleDurationObsExpression5247); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_3_3(), null); 
                        

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
    // $ANTLR end ruleDurationObsExpression


    // $ANTLR start entryRuleDurationObsName
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2878:1: entryRuleDurationObsName returns [EObject current=null] : iv_ruleDurationObsName= ruleDurationObsName EOF ;
    public final EObject entryRuleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2879:2: (iv_ruleDurationObsName= ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2880:2: iv_ruleDurationObsName= ruleDurationObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName5285);
            iv_ruleDurationObsName=ruleDurationObsName();
            _fsp--;

             current =iv_ruleDurationObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName5295); 

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
    // $ANTLR end entryRuleDurationObsName


    // $ANTLR start ruleDurationObsName
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2887:1: ruleDurationObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2892:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2893:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2893:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2893:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2893:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==43) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2894:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2894:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2895:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDurationObsName5341);
                    lv_path_0_0=ruleQualifiedName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getDurationObsNameRule().getType().getClassifier());
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2917:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2918:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2918:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2919:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDurationObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDurationObsName5360); 

            		createLeafNode(grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationCrossReference_1_0(), "durationId"); 
            	

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
    // $ANTLR end ruleDurationObsName


    // $ANTLR start entryRuleJitterExp
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2939:1: entryRuleJitterExp returns [EObject current=null] : iv_ruleJitterExp= ruleJitterExp EOF ;
    public final EObject entryRuleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJitterExp = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2940:2: (iv_ruleJitterExp= ruleJitterExp EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2941:2: iv_ruleJitterExp= ruleJitterExp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJitterExpRule(), currentNode); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp5396);
            iv_ruleJitterExp=ruleJitterExp();
            _fsp--;

             current =iv_ruleJitterExp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp5406); 

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
    // $ANTLR end entryRuleJitterExp


    // $ANTLR start ruleJitterExp
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2948:1: ruleJitterExp returns [EObject current=null] : ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) ;
    public final EObject ruleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject lv_firstInstant_1_0 = null;

        EObject lv_secondInstant_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2953:6: ( ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2954:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2954:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2954:3: 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')'
            {
            match(input,52,FOLLOW_52_in_ruleJitterExp5441); 

                    createLeafNode(grammarAccess.getJitterExpAccess().getJitterKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2958:1: ( (lv_firstInstant_1_0= ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2959:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2959:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2960:3: lv_firstInstant_1_0= ruleInstantObsExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5462);
            lv_firstInstant_1_0=ruleInstantObsExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getJitterExpRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"firstInstant",
            	        		lv_firstInstant_1_0, 
            	        		"InstantObsExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2982:2: ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2982:4: '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    {
                    match(input,35,FOLLOW_35_in_ruleJitterExp5473); 

                            createLeafNode(grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2986:1: ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2987:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2987:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2988:3: lv_secondInstant_3_0= ruleInstantObsExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5494);
                    lv_secondInstant_3_0=ruleInstantObsExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getJitterExpRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"secondInstant",
                    	        		lv_secondInstant_3_0, 
                    	        		"InstantObsExpression", 
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

            match(input,42,FOLLOW_42_in_ruleJitterExp5506); 

                    createLeafNode(grammarAccess.getJitterExpAccess().getRightParenthesisKeyword_3(), null); 
                

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
    // $ANTLR end ruleJitterExp


    // $ANTLR start entryRuleVariableDeclaration
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3022:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3023:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3024:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration5542);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration5552); 

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
    // $ANTLR end entryRuleVariableDeclaration


    // $ANTLR start ruleVariableDeclaration
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3031:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        AntlrDatatypeRuleToken lv_variableDeclaration_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_initValue_7_0 = null;

        EObject lv_initValue_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3036:6: ( ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3037:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3037:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3037:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3037:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=54 && LA41_0<=56)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3038:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3038:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3039:3: lv_variableDeclaration_0_0= ruleVariableDirectionKind
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5598);
                    lv_variableDeclaration_0_0=ruleVariableDirectionKind();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"variableDeclaration",
                    	        		lv_variableDeclaration_0_0, 
                    	        		"VariableDirectionKind", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            match(input,53,FOLLOW_53_in_ruleVariableDeclaration5609); 

                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3065:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3066:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3066:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3067:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration5626); 

            			createLeafNode(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3089:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==33) ) {
                alt43=1;
            }
            else if ( (LA43_0==20) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3089:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3089:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3089:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3089:5: ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    {
                    match(input,33,FOLLOW_33_in_ruleVariableDeclaration5643); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3093:1: ( (lv_type_4_0= ruleDataTypeName ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3094:1: (lv_type_4_0= ruleDataTypeName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3094:1: (lv_type_4_0= ruleDataTypeName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3095:3: lv_type_4_0= ruleDataTypeName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5664);
                    lv_type_4_0=ruleDataTypeName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"type",
                    	        		lv_type_4_0, 
                    	        		"DataTypeName", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3117:2: ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==20) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3117:4: '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')'
                            {
                            match(input,20,FOLLOW_20_in_ruleVariableDeclaration5675); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0(), null); 
                                
                            match(input,41,FOLLOW_41_in_ruleVariableDeclaration5685); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1(), null); 
                                
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3125:1: ( (lv_initValue_7_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3126:1: (lv_initValue_7_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3126:1: (lv_initValue_7_0= ruleExpression )
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3127:3: lv_initValue_7_0= ruleExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5706);
                            lv_initValue_7_0=ruleExpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"initValue",
                            	        		lv_initValue_7_0, 
                            	        		"Expression", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            match(input,42,FOLLOW_42_in_ruleVariableDeclaration5716); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3154:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3154:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3154:8: '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')'
                    {
                    match(input,20,FOLLOW_20_in_ruleVariableDeclaration5736); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0(), null); 
                        
                    match(input,41,FOLLOW_41_in_ruleVariableDeclaration5746); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3162:1: ( (lv_initValue_11_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3163:1: (lv_initValue_11_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3163:1: (lv_initValue_11_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3164:3: lv_initValue_11_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5767);
                    lv_initValue_11_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"initValue",
                    	        		lv_initValue_11_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,42,FOLLOW_42_in_ruleVariableDeclaration5777); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_1_3(), null); 
                        

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
    // $ANTLR end ruleVariableDeclaration


    // $ANTLR start entryRuleVariableDirectionKind
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3198:1: entryRuleVariableDirectionKind returns [String current=null] : iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF ;
    public final String entryRuleVariableDirectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableDirectionKind = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3199:2: (iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3200:2: iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDirectionKindRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5816);
            iv_ruleVariableDirectionKind=ruleVariableDirectionKind();
            _fsp--;

             current =iv_ruleVariableDirectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind5827); 

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
    // $ANTLR end entryRuleVariableDirectionKind


    // $ANTLR start ruleVariableDirectionKind
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3207:1: ruleVariableDirectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleVariableDirectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3212:6: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3213:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3213:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt44=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt44=1;
                }
                break;
            case 55:
                {
                alt44=2;
                }
                break;
            case 56:
                {
                alt44=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3213:1: (kw= 'in' | kw= 'out' | kw= 'inout' )", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3214:2: kw= 'in'
                    {
                    kw=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleVariableDirectionKind5865); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3221:2: kw= 'out'
                    {
                    kw=(Token)input.LT(1);
                    match(input,55,FOLLOW_55_in_ruleVariableDirectionKind5884); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3228:2: kw= 'inout'
                    {
                    kw=(Token)input.LT(1);
                    match(input,56,FOLLOW_56_in_ruleVariableDirectionKind5903); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getInoutKeyword_2(), null); 
                        

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
    // $ANTLR end ruleVariableDirectionKind


    // $ANTLR start entryRuleDataTypeName
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3241:1: entryRuleDataTypeName returns [EObject current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final EObject entryRuleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3242:2: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3243:2: iv_ruleDataTypeName= ruleDataTypeName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5943);
            iv_ruleDataTypeName=ruleDataTypeName();
            _fsp--;

             current =iv_ruleDataTypeName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName5953); 

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
    // $ANTLR end entryRuleDataTypeName


    // $ANTLR start ruleDataTypeName
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3250:1: ruleDataTypeName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3255:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3256:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3256:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3256:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3256:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==43) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3257:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3257:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3258:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDataTypeName5999);
                    lv_path_0_0=ruleQualifiedName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getDataTypeNameRule().getType().getClassifier());
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3280:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3281:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3281:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3282:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDataTypeNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataTypeName6018); 

            		createLeafNode(grammarAccess.getDataTypeNameAccess().getTypeDataTypeCrossReference_1_0(), "type"); 
            	

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
    // $ANTLR end ruleDataTypeName


    // $ANTLR start entryRuleNumberLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3302:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3303:2: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3304:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumberLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule6054);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();
            _fsp--;

             current =iv_ruleNumberLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule6064); 

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
    // $ANTLR end entryRuleNumberLiteralRule


    // $ANTLR start ruleNumberLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3311:1: ruleNumberLiteralRule returns [EObject current=null] : (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteralRule_0 = null;

        EObject this_UnlimitedLiteralRule_1 = null;

        EObject this_RealLiteralRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3316:6: ( (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3317:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3317:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            int alt46=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
                {
                alt46=1;
                }
                break;
            case 36:
                {
                alt46=2;
                }
                break;
            case RULE_REALLITERAL:
                {
                alt46=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3317:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3318:5: this_IntegerLiteralRule_0= ruleIntegerLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule6111);
                    this_IntegerLiteralRule_0=ruleIntegerLiteralRule();
                    _fsp--;

                     
                            current = this_IntegerLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3328:5: this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule6138);
                    this_UnlimitedLiteralRule_1=ruleUnlimitedLiteralRule();
                    _fsp--;

                     
                            current = this_UnlimitedLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3338:5: this_RealLiteralRule_2= ruleRealLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule6165);
                    this_RealLiteralRule_2=ruleRealLiteralRule();
                    _fsp--;

                     
                            current = this_RealLiteralRule_2; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleNumberLiteralRule


    // $ANTLR start entryRuleIntegerLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3354:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3355:2: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3356:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule6200);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();
            _fsp--;

             current =iv_ruleIntegerLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule6210); 

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
    // $ANTLR end entryRuleIntegerLiteralRule


    // $ANTLR start ruleIntegerLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3363:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3368:6: ( ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3369:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3369:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3370:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3370:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3371:3: lv_value_0_0= RULE_INTEGERLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule6251); 

            			createLeafNode(grammarAccess.getIntegerLiteralRuleAccess().getValueIntegerLiteralTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIntegerLiteralRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"IntegerLiteral", 
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
    // $ANTLR end ruleIntegerLiteralRule


    // $ANTLR start entryRuleUnlimitedLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3401:1: entryRuleUnlimitedLiteralRule returns [EObject current=null] : iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF ;
    public final EObject entryRuleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3402:2: (iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3403:2: iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnlimitedLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule6291);
            iv_ruleUnlimitedLiteralRule=ruleUnlimitedLiteralRule();
            _fsp--;

             current =iv_ruleUnlimitedLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule6301); 

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
    // $ANTLR end entryRuleUnlimitedLiteralRule


    // $ANTLR start ruleUnlimitedLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3410:1: ruleUnlimitedLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '*' ) ) ;
    public final EObject ruleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3415:6: ( ( (lv_value_0_0= '*' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3416:1: ( (lv_value_0_0= '*' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3416:1: ( (lv_value_0_0= '*' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3417:1: (lv_value_0_0= '*' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3417:1: (lv_value_0_0= '*' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3418:3: lv_value_0_0= '*'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,36,FOLLOW_36_in_ruleUnlimitedLiteralRule6343); 

                    createLeafNode(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0(), "value"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnlimitedLiteralRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0_0, "*", lastConsumedNode);
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
    // $ANTLR end ruleUnlimitedLiteralRule


    // $ANTLR start entryRuleRealLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3445:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3446:2: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3447:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule6391);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();
            _fsp--;

             current =iv_ruleRealLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule6401); 

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
    // $ANTLR end entryRuleRealLiteralRule


    // $ANTLR start ruleRealLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3454:1: ruleRealLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_REALLITERAL ) ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3459:6: ( ( (lv_value_0_0= RULE_REALLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3460:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3460:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3461:1: (lv_value_0_0= RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3461:1: (lv_value_0_0= RULE_REALLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3462:3: lv_value_0_0= RULE_REALLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule6442); 

            			createLeafNode(grammarAccess.getRealLiteralRuleAccess().getValueRealLiteralTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRealLiteralRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"RealLiteral", 
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
    // $ANTLR end ruleRealLiteralRule


    // $ANTLR start entryRuleDateTimeLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3492:1: entryRuleDateTimeLiteralRule returns [EObject current=null] : iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF ;
    public final EObject entryRuleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTimeLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3493:2: (iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3494:2: iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDateTimeLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule6482);
            iv_ruleDateTimeLiteralRule=ruleDateTimeLiteralRule();
            _fsp--;

             current =iv_ruleDateTimeLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule6492); 

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
    // $ANTLR end entryRuleDateTimeLiteralRule


    // $ANTLR start ruleDateTimeLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3501:1: ruleDateTimeLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) ;
    public final EObject ruleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3506:6: ( ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3507:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3507:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3508:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3508:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3509:3: lv_value_0_0= RULE_DATETIMELITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule6533); 

            			createLeafNode(grammarAccess.getDateTimeLiteralRuleAccess().getValueDateTimeLiteralTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDateTimeLiteralRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"DateTimeLiteral", 
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
    // $ANTLR end ruleDateTimeLiteralRule


    // $ANTLR start entryRuleBooleanLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3539:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3540:2: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3541:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6573);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();
            _fsp--;

             current =iv_ruleBooleanLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule6583); 

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
    // $ANTLR end entryRuleBooleanLiteralRule


    // $ANTLR start ruleBooleanLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3548:1: ruleBooleanLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3553:6: ( ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3554:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3554:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3555:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3555:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3556:3: lv_value_0_0= RULE_BOOLEANLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6624); 

            			createLeafNode(grammarAccess.getBooleanLiteralRuleAccess().getValueBooleanLiteralTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanLiteralRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"BooleanLiteral", 
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
    // $ANTLR end ruleBooleanLiteralRule


    // $ANTLR start entryRuleNullLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3586:1: entryRuleNullLiteralRule returns [EObject current=null] : iv_ruleNullLiteralRule= ruleNullLiteralRule EOF ;
    public final EObject entryRuleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3587:2: (iv_ruleNullLiteralRule= ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3588:2: iv_ruleNullLiteralRule= ruleNullLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6664);
            iv_ruleNullLiteralRule=ruleNullLiteralRule();
            _fsp--;

             current =iv_ruleNullLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule6674); 

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
    // $ANTLR end entryRuleNullLiteralRule


    // $ANTLR start ruleNullLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3595:1: ruleNullLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_NULLLITERAL ) ) ;
    public final EObject ruleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3600:6: ( ( (lv_value_0_0= RULE_NULLLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3601:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3601:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3602:1: (lv_value_0_0= RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3602:1: (lv_value_0_0= RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3603:3: lv_value_0_0= RULE_NULLLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6715); 

            			createLeafNode(grammarAccess.getNullLiteralRuleAccess().getValueNullLiteralTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNullLiteralRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"NullLiteral", 
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
    // $ANTLR end ruleNullLiteralRule


    // $ANTLR start entryRuleDefaultLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3633:1: entryRuleDefaultLiteralRule returns [EObject current=null] : iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF ;
    public final EObject entryRuleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3634:2: (iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3635:2: iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefaultLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6755);
            iv_ruleDefaultLiteralRule=ruleDefaultLiteralRule();
            _fsp--;

             current =iv_ruleDefaultLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule6765); 

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
    // $ANTLR end entryRuleDefaultLiteralRule


    // $ANTLR start ruleDefaultLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3642:1: ruleDefaultLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '/' ) ) ;
    public final EObject ruleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3647:6: ( ( (lv_value_0_0= '/' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3648:1: ( (lv_value_0_0= '/' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3648:1: ( (lv_value_0_0= '/' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3649:1: (lv_value_0_0= '/' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3649:1: (lv_value_0_0= '/' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3650:3: lv_value_0_0= '/'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,37,FOLLOW_37_in_ruleDefaultLiteralRule6807); 

                    createLeafNode(grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0(), "value"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDefaultLiteralRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0_0, "/", lastConsumedNode);
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
    // $ANTLR end ruleDefaultLiteralRule


    // $ANTLR start entryRuleStringLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3677:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3678:2: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3679:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6855);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();
            _fsp--;

             current =iv_ruleStringLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule6865); 

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
    // $ANTLR end entryRuleStringLiteralRule


    // $ANTLR start ruleStringLiteralRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3686:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3691:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3692:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3692:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3693:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3693:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3694:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteralRule6906); 

            			createLeafNode(grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringLiteralRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"STRING", 
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
    // $ANTLR end ruleStringLiteralRule


 

    public static final BitSet FOLLOW_ruleStereotypeApplicationsRule_in_entryRuleStereotypeApplicationsRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStereotypeApplicationsRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStereotypeApplicationRule_in_ruleStereotypeApplicationsRule130 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleStereotypeApplicationRule_in_entryRuleStereotypeApplicationRule166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStereotypeApplicationRule176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleStereotypeApplicationRule211 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStereotypeApplicationRule229 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleStereotypeApplicationRule239 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTagSpecificationRule_in_ruleStereotypeApplicationRule261 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleStereotypeApplicationRule272 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTagSpecificationRule_in_ruleStereotypeApplicationRule293 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleTagSpecificationRule_in_entryRuleTagSpecificationRule333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTagSpecificationRule343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTagSpecificationRule386 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_ruleValueRule_in_ruleTagSpecificationRule407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueRule_in_entryRuleValueRule443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueRule453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceValueRule_in_ruleValueRule500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionValueRule_in_ruleValueRule527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceValueRule_in_entryRuleReferenceValueRule562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceValueRule572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleReferenceValueRule607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceValueRule625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionValueRule_in_entryRuleExpressionValueRule661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionValueRule671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleExpressionValueRule706 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionValueRule727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleImport810 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContext_in_entryRuleContext868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContext878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleContext913 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContext931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_ruleExpression1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression1057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression1113 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_23_in_ruleAndOrXorExpression1134 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_24_in_ruleAndOrXorExpression1163 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_25_in_ruleAndOrXorExpression1192 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression1229 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1323 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_26_in_ruleEqualityExpression1344 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_27_in_ruleEqualityExpression1373 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1410 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1504 = new BitSet(new long[]{0x00000000F0000002L});
    public static final BitSet FOLLOW_28_in_ruleRelationalExpression1525 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_29_in_ruleRelationalExpression1554 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_30_in_ruleRelationalExpression1583 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_31_in_ruleRelationalExpression1612 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1649 = new BitSet(new long[]{0x00000000F0000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1743 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleConditionalExpression1762 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1796 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleConditionalExpression1806 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1921 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_34_in_ruleAdditiveExpression1942 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_35_in_ruleAdditiveExpression1971 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2008 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2046 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2102 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_36_in_ruleMultiplicativeExpression2123 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_37_in_ruleMultiplicativeExpression2152 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_38_in_ruleMultiplicativeExpression2181 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2218 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression2256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression2266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleUnaryExpression2312 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_35_in_ruleUnaryExpression2341 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_34_in_ruleUnaryExpression2370 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rulePrimaryExpression2527 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_rulePrimaryExpression2538 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2597 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification2607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleValueSpecification2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleValueSpecification2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleValueSpecification2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleValueSpecification2789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleValueSpecification2832 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueSpecification2854 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleValueSpecification2863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression2910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression3019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyCallExpression3072 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_rulePropertyCallExpression3083 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression3142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpression3195 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleOperationCallExpression3205 = new BitSet(new long[]{0x01FAB6BC000007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleOperationCallExpression3226 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleOperationCallExpression3237 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleOperationCallExpression3248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression3269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_ruleLiteral3364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral3391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_ruleLiteral3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_ruleLiteral3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall3534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3590 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3609 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleNameOrChoiceOrBehaviorCall3620 = new BitSet(new long[]{0x01FAB6BC000007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3641 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleNameOrChoiceOrBehaviorCall3652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3743 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleQualifiedName3753 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName3774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval3811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleInterval3857 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_45_in_ruleInterval3881 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3916 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleInterval3926 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3947 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_44_in_ruleInterval3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleInterval3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple4032 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple4042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleCollectionOrTuple4077 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple4098 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleCollectionOrTuple4108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple4144 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple4154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleTuple4189 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_ruleTuple4210 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleTuple4220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues4256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues4266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues4312 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleListOfValues4323 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues4344 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs4382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs4392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4438 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleListOfValueNamePairs4449 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4470 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair4508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueNamePair4561 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleValueNamePair4571 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueNamePair4592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_ruleTimeExpression4739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression4784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleInstantObsExpression4819 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4840 = new BitSet(new long[]{0x0004020000000002L});
    public static final BitSet FOLLOW_41_in_ruleInstantObsExpression4851 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4872 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleInstantObsExpression4882 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleInstantObsExpression4895 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleInstantObsExpression4905 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4926 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleInstantObsExpression4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstantObsName5030 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstantObsName5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression5085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression5095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleDurationObsExpression5130 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression5151 = new BitSet(new long[]{0x0004020000000002L});
    public static final BitSet FOLLOW_41_in_ruleDurationObsExpression5162 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression5183 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleDurationObsExpression5193 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleDurationObsExpression5206 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleDurationObsExpression5216 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression5237 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleDurationObsExpression5247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName5285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName5295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDurationObsName5341 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDurationObsName5360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp5396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp5406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleJitterExp5441 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5462 = new BitSet(new long[]{0x0000040800000000L});
    public static final BitSet FOLLOW_35_in_ruleJitterExp5473 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5494 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleJitterExp5506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration5542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration5552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5598 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleVariableDeclaration5609 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration5626 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_33_in_ruleVariableDeclaration5643 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5664 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleVariableDeclaration5675 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleVariableDeclaration5685 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5706 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleVariableDeclaration5716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVariableDeclaration5736 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleVariableDeclaration5746 = new BitSet(new long[]{0x01FAB2BC000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5767 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleVariableDeclaration5777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5816 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind5827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleVariableDirectionKind5865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleVariableDirectionKind5884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleVariableDirectionKind5903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName5953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDataTypeName5999 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeName6018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule6054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule6064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule6111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule6138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule6165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule6200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule6210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule6251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule6291 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule6301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnlimitedLiteralRule6343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule6391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule6401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule6442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule6482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule6492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule6533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule6583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule6674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule6765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleDefaultLiteralRule6807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule6865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteralRule6906 = new BitSet(new long[]{0x0000000000000002L});

}