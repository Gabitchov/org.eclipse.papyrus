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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INTEGERLITERAL", "RULE_REALLITERAL", "RULE_DATETIMELITERAL", "RULE_BOOLEANLITERAL", "RULE_NULLLITERAL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<<'", "'>>'", "','", "'='", "'import'", "'context'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'?'", "':'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'not'", "'.'", "'('", "')'", "'::'", "']'", "'['", "'..'", "'{'", "'}'", "'@'", "'when'", "'&'", "'jitter('", "'$'", "'in'", "'out'", "'inout'"
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:230:1: ruleTagSpecificationRule returns [EObject current=null] : ( ( ( RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) ) ) ;
    public final EObject ruleTagSpecificationRule() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:235:6: ( ( ( ( RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:236:1: ( ( ( RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:236:1: ( ( ( RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:236:2: ( ( RULE_ID ) ) ( (lv_value_1_0= ruleExpressionValueRule ) )
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:250:2: ( (lv_value_1_0= ruleExpressionValueRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:251:1: (lv_value_1_0= ruleExpressionValueRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:251:1: (lv_value_1_0= ruleExpressionValueRule )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:252:3: lv_value_1_0= ruleExpressionValueRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTagSpecificationRuleAccess().getValueExpressionValueRuleParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionValueRule_in_ruleTagSpecificationRule407);
            lv_value_1_0=ruleExpressionValueRule();
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
            	        		"ExpressionValueRule", 
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


    // $ANTLR start entryRuleExpressionValueRule
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:282:1: entryRuleExpressionValueRule returns [EObject current=null] : iv_ruleExpressionValueRule= ruleExpressionValueRule EOF ;
    public final EObject entryRuleExpressionValueRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionValueRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:283:2: (iv_ruleExpressionValueRule= ruleExpressionValueRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:284:2: iv_ruleExpressionValueRule= ruleExpressionValueRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionValueRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionValueRule_in_entryRuleExpressionValueRule443);
            iv_ruleExpressionValueRule=ruleExpressionValueRule();
            _fsp--;

             current =iv_ruleExpressionValueRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionValueRule453); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:291:1: ruleExpressionValueRule returns [EObject current=null] : ( '=' ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleExpressionValueRule() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:296:6: ( ( '=' ( (lv_expression_1_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:297:1: ( '=' ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:297:1: ( '=' ( (lv_expression_1_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:297:3: '=' ( (lv_expression_1_0= ruleExpression ) )
            {
            match(input,19,FOLLOW_19_in_ruleExpressionValueRule488); 

                    createLeafNode(grammarAccess.getExpressionValueRuleAccess().getEqualsSignKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:301:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:302:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:302:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:303:3: lv_expression_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionValueRuleAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionValueRule509);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:335:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:336:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:337:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport547);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport557); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:344:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:349:6: ( ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:350:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:350:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:350:3: 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            match(input,20,FOLLOW_20_in_ruleImport592); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:354:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:355:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:355:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:356:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport609); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:386:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:387:2: (iv_ruleContext= ruleContext EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:388:2: iv_ruleContext= ruleContext EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContextRule(), currentNode); 
            pushFollow(FOLLOW_ruleContext_in_entryRuleContext650);
            iv_ruleContext=ruleContext();
            _fsp--;

             current =iv_ruleContext; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContext660); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:395:1: ruleContext returns [EObject current=null] : ( 'context' ( ( RULE_ID ) ) ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:400:6: ( ( 'context' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:401:1: ( 'context' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:401:1: ( 'context' ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:401:3: 'context' ( ( RULE_ID ) )
            {
            match(input,21,FOLLOW_21_in_ruleContext695); 

                    createLeafNode(grammarAccess.getContextAccess().getContextKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:405:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:406:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:406:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:407:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getContextRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContext713); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:427:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:428:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:429:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression749);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression759); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:436:1: ruleExpression returns [EObject current=null] : ( (lv_exp_0_0= ruleAndOrXorExpression ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:441:6: ( ( (lv_exp_0_0= ruleAndOrXorExpression ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:442:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:442:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:443:1: (lv_exp_0_0= ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:443:1: (lv_exp_0_0= ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:444:3: lv_exp_0_0= ruleAndOrXorExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_ruleExpression804);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:474:1: entryRuleAndOrXorExpression returns [EObject current=null] : iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF ;
    public final EObject entryRuleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrXorExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:475:2: (iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:476:2: iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndOrXorExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression839);
            iv_ruleAndOrXorExpression=ruleAndOrXorExpression();
            _fsp--;

             current =iv_ruleAndOrXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression849); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:483:1: ruleAndOrXorExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:488:6: ( ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:489:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:489:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:489:2: ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:489:2: ( (lv_exp_0_0= ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:490:1: (lv_exp_0_0= ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:490:1: (lv_exp_0_0= ruleEqualityExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:491:3: lv_exp_0_0= ruleEqualityExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression895);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:513:2: ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=22 && LA5_0<=24)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:513:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:513:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:514:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:514:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:515:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:515:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    int alt4=3;
            	    switch ( input.LA(1) ) {
            	    case 22:
            	        {
            	        alt4=1;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt4=2;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt4=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("515:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )", 4, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:516:3: lv_op_1_1= 'and'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,22,FOLLOW_22_in_ruleAndOrXorExpression916); 

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
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:534:8: lv_op_1_2= 'or'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,23,FOLLOW_23_in_ruleAndOrXorExpression945); 

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
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:552:8: lv_op_1_3= 'xor'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,24,FOLLOW_24_in_ruleAndOrXorExpression974); 

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

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:573:2: ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:574:1: (lv_exp_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:574:1: (lv_exp_2_0= ruleEqualityExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:575:3: lv_exp_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression1011);
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
            	    break loop5;
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:605:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:606:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:607:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1049);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression1059); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:614:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:619:6: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:620:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:620:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:620:2: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:620:2: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:621:1: (lv_exp_0_0= ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:621:1: (lv_exp_0_0= ruleRelationalExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:622:3: lv_exp_0_0= ruleRelationalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1105);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:644:2: ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=25 && LA7_0<=26)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:644:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:644:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:645:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:645:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:646:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:646:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==25) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==26) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("646:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:647:3: lv_op_1_1= '=='
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,25,FOLLOW_25_in_ruleEqualityExpression1126); 

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
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:665:8: lv_op_1_2= '<>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,26,FOLLOW_26_in_ruleEqualityExpression1155); 

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

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:686:2: ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:687:1: (lv_exp_2_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:687:1: (lv_exp_2_0= ruleRelationalExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:688:3: lv_exp_2_0= ruleRelationalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1192);
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
            	    break loop7;
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:718:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:719:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:720:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1230);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression1240); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:727:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) ;
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
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:732:6: ( ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:733:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:733:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:733:2: ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:733:2: ( (lv_exp_0_0= ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:734:1: (lv_exp_0_0= ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:734:1: (lv_exp_0_0= ruleConditionalExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:735:3: lv_exp_0_0= ruleConditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1286);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:757:2: ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=27 && LA9_0<=30)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:757:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:757:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:758:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:758:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:759:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:759:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    int alt8=4;
            	    switch ( input.LA(1) ) {
            	    case 27:
            	        {
            	        alt8=1;
            	        }
            	        break;
            	    case 28:
            	        {
            	        alt8=2;
            	        }
            	        break;
            	    case 29:
            	        {
            	        alt8=3;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt8=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("759:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:760:3: lv_op_1_1= '<'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,27,FOLLOW_27_in_ruleRelationalExpression1307); 

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
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:778:8: lv_op_1_2= '>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,28,FOLLOW_28_in_ruleRelationalExpression1336); 

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
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:796:8: lv_op_1_3= '<='
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,29,FOLLOW_29_in_ruleRelationalExpression1365); 

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
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:814:8: lv_op_1_4= '>='
            	            {
            	            lv_op_1_4=(Token)input.LT(1);
            	            match(input,30,FOLLOW_30_in_ruleRelationalExpression1394); 

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

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:835:2: ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:836:1: (lv_exp_2_0= ruleConditionalExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:836:1: (lv_exp_2_0= ruleConditionalExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:837:3: lv_exp_2_0= ruleConditionalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1431);
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
            	    break loop9;
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:867:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:868:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:869:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1469);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression1479); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:876:1: ruleConditionalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;

        EObject lv_exp_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:881:6: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:882:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:882:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:882:2: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:882:2: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:883:1: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:883:1: (lv_exp_0_0= ruleAdditiveExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:884:3: lv_exp_0_0= ruleAdditiveExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1525);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:906:2: ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==31) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:906:3: ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:906:3: ( (lv_op_1_0= '?' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:907:1: (lv_op_1_0= '?' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:907:1: (lv_op_1_0= '?' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:908:3: lv_op_1_0= '?'
                    {
                    lv_op_1_0=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleConditionalExpression1544); 

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

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:927:2: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:928:1: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:928:1: (lv_exp_2_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:929:3: lv_exp_2_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1578);
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

                    match(input,32,FOLLOW_32_in_ruleConditionalExpression1588); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:955:1: ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:956:1: (lv_exp_4_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:956:1: (lv_exp_4_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:957:3: lv_exp_4_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1609);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:987:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:988:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:989:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1647);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1657); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:996:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1001:6: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1002:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1002:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1002:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1002:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1003:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1003:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1004:3: lv_exp_0_0= ruleMultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1703);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1026:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=33 && LA12_0<=34)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1026:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1026:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1027:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1027:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1028:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1028:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==33) ) {
            	        alt11=1;
            	    }
            	    else if ( (LA11_0==34) ) {
            	        alt11=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("1028:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )", 11, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1029:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,33,FOLLOW_33_in_ruleAdditiveExpression1724); 

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
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1047:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,34,FOLLOW_34_in_ruleAdditiveExpression1753); 

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

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1068:2: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1069:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1069:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1070:3: lv_exp_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1790);
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
            	    break loop12;
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1100:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1101:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1102:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1828);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression1838); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1109:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1114:6: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1115:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1115:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1115:2: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1115:2: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1116:1: (lv_exp_0_0= ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1116:1: (lv_exp_0_0= ruleUnaryExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1117:3: lv_exp_0_0= ruleUnaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1884);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1139:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=35 && LA14_0<=37)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1139:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1139:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1140:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1140:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1141:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1141:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    int alt13=3;
            	    switch ( input.LA(1) ) {
            	    case 35:
            	        {
            	        alt13=1;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt13=2;
            	        }
            	        break;
            	    case 37:
            	        {
            	        alt13=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("1141:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )", 13, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt13) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1142:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,35,FOLLOW_35_in_ruleMultiplicativeExpression1905); 

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
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1160:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,36,FOLLOW_36_in_ruleMultiplicativeExpression1934); 

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
            	            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1178:8: lv_op_1_3= 'mod'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,37,FOLLOW_37_in_ruleMultiplicativeExpression1963); 

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

            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1199:2: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1200:1: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1200:1: (lv_exp_2_0= ruleUnaryExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1201:3: lv_exp_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2000);
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
            	    break loop14;
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1231:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1232:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1233:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression2038);
            iv_ruleUnaryExpression=ruleUnaryExpression();
            _fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression2048); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1240:1: ruleUnaryExpression returns [EObject current=null] : ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        EObject lv_unary_1_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1245:6: ( ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1246:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1246:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=33 && LA16_0<=34)||LA16_0==38) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_NULLLITERAL)||(LA16_0>=35 && LA16_0<=36)||LA16_0==40||(LA16_0>=43 && LA16_0<=44)||LA16_0==46||LA16_0==48||(LA16_0>=50 && LA16_0<=55)) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1246:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1246:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1246:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1246:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1246:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1247:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1247:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1248:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1248:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    int alt15=3;
                    switch ( input.LA(1) ) {
                    case 38:
                        {
                        alt15=1;
                        }
                        break;
                    case 34:
                        {
                        alt15=2;
                        }
                        break;
                    case 33:
                        {
                        alt15=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("1248:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )", 15, 0, input);

                        throw nvae;
                    }

                    switch (alt15) {
                        case 1 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1249:3: lv_op_0_1= 'not'
                            {
                            lv_op_0_1=(Token)input.LT(1);
                            match(input,38,FOLLOW_38_in_ruleUnaryExpression2094); 

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
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1267:8: lv_op_0_2= '-'
                            {
                            lv_op_0_2=(Token)input.LT(1);
                            match(input,34,FOLLOW_34_in_ruleUnaryExpression2123); 

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
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1285:8: lv_op_0_3= '+'
                            {
                            lv_op_0_3=(Token)input.LT(1);
                            match(input,33,FOLLOW_33_in_ruleUnaryExpression2152); 

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

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1306:2: ( (lv_unary_1_0= ruleUnaryExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1307:1: (lv_unary_1_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1307:1: (lv_unary_1_0= ruleUnaryExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1308:3: lv_unary_1_0= ruleUnaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression2189);
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
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1331:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1331:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1332:1: (lv_exp_2_0= rulePrimaryExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1332:1: (lv_exp_2_0= rulePrimaryExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1333:3: lv_exp_2_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression2217);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1363:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1364:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1365:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2253);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression2263); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1372:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_prefix_0_0 = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1377:6: ( ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1378:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1378:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1378:2: ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1378:2: ( (lv_prefix_0_0= ruleValueSpecification ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1379:1: (lv_prefix_0_0= ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1379:1: (lv_prefix_0_0= ruleValueSpecification )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1380:3: lv_prefix_0_0= ruleValueSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueSpecification_in_rulePrimaryExpression2309);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1402:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1402:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,39,FOLLOW_39_in_rulePrimaryExpression2320); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1406:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1407:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1407:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1408:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2341);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1438:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1439:2: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1440:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2379);
            iv_ruleValueSpecification=ruleValueSpecification();
            _fsp--;

             current =iv_ruleValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification2389); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1447:1: ruleValueSpecification returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) ;
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
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1452:6: ( (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1453:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1453:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            int alt18=8;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case RULE_DATETIMELITERAL:
            case RULE_BOOLEANLITERAL:
            case RULE_NULLLITERAL:
            case 35:
            case 36:
                {
                alt18=1;
                }
                break;
            case RULE_ID:
                {
                alt18=2;
                }
                break;
            case 43:
            case 44:
                {
                alt18=3;
                }
                break;
            case 46:
                {
                int LA18_4 = input.LA(2);

                if ( (LA18_4==RULE_ID) ) {
                    int LA18_8 = input.LA(3);

                    if ( (LA18_8==18||(LA18_8>=22 && LA18_8<=31)||(LA18_8>=33 && LA18_8<=37)||(LA18_8>=39 && LA18_8<=40)||LA18_8==42||LA18_8==47) ) {
                        alt18=4;
                    }
                    else if ( (LA18_8==19) ) {
                        alt18=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1453:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 18, 8, input);

                        throw nvae;
                    }
                }
                else if ( ((LA18_4>=RULE_STRING && LA18_4<=RULE_NULLLITERAL)||(LA18_4>=33 && LA18_4<=36)||LA18_4==38||LA18_4==40||(LA18_4>=43 && LA18_4<=44)||LA18_4==46||LA18_4==48||(LA18_4>=50 && LA18_4<=55)) ) {
                    alt18=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1453:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 18, 4, input);

                    throw nvae;
                }
                }
                break;
            case 48:
            case 50:
            case 51:
                {
                alt18=6;
                }
                break;
            case 52:
            case 53:
            case 54:
            case 55:
                {
                alt18=7;
                }
                break;
            case 40:
                {
                alt18=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1453:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1454:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleValueSpecification2436);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1464:5: this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2463);
                    this_NameOrChoiceOrBehaviorCall_1=ruleNameOrChoiceOrBehaviorCall();
                    _fsp--;

                     
                            current = this_NameOrChoiceOrBehaviorCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1474:5: this_Interval_2= ruleInterval
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInterval_in_ruleValueSpecification2490);
                    this_Interval_2=ruleInterval();
                    _fsp--;

                     
                            current = this_Interval_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1484:5: this_CollectionOrTuple_3= ruleCollectionOrTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2517);
                    this_CollectionOrTuple_3=ruleCollectionOrTuple();
                    _fsp--;

                     
                            current = this_CollectionOrTuple_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1494:5: this_Tuple_4= ruleTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTuple_in_ruleValueSpecification2544);
                    this_Tuple_4=ruleTuple();
                    _fsp--;

                     
                            current = this_Tuple_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1504:5: this_TimeExpression_5= ruleTimeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeExpression_in_ruleValueSpecification2571);
                    this_TimeExpression_5=ruleTimeExpression();
                    _fsp--;

                     
                            current = this_TimeExpression_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1514:5: this_VariableDeclaration_6= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2598);
                    this_VariableDeclaration_6=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1523:6: ( '(' this_Expression_8= ruleExpression ')' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1523:6: ( '(' this_Expression_8= ruleExpression ')' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1523:8: '(' this_Expression_8= ruleExpression ')'
                    {
                    match(input,40,FOLLOW_40_in_ruleValueSpecification2614); 

                            createLeafNode(grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleValueSpecification2636);
                    this_Expression_8=ruleExpression();
                    _fsp--;

                     
                            current = this_Expression_8; 
                            currentNode = currentNode.getParent();
                        
                    match(input,41,FOLLOW_41_in_ruleValueSpecification2645); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1548:1: entryRuleSuffixExpression returns [EObject current=null] : iv_ruleSuffixExpression= ruleSuffixExpression EOF ;
    public final EObject entryRuleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuffixExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1549:2: (iv_ruleSuffixExpression= ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1550:2: iv_ruleSuffixExpression= ruleSuffixExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuffixExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2682);
            iv_ruleSuffixExpression=ruleSuffixExpression();
            _fsp--;

             current =iv_ruleSuffixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression2692); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1557:1: ruleSuffixExpression returns [EObject current=null] : (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) ;
    public final EObject ruleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyCallExpression_0 = null;

        EObject this_OperationCallExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1562:6: ( (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1563:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1563:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==40) ) {
                    alt19=2;
                }
                else if ( (LA19_1==EOF||LA19_1==16||LA19_1==18||(LA19_1>=22 && LA19_1<=37)||LA19_1==39||LA19_1==41||(LA19_1>=43 && LA19_1<=45)||LA19_1==47) ) {
                    alt19=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1563:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1563:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1564:5: this_PropertyCallExpression_0= rulePropertyCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2739);
                    this_PropertyCallExpression_0=rulePropertyCallExpression();
                    _fsp--;

                     
                            current = this_PropertyCallExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1574:5: this_OperationCallExpression_1= ruleOperationCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2766);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1590:1: entryRulePropertyCallExpression returns [EObject current=null] : iv_rulePropertyCallExpression= rulePropertyCallExpression EOF ;
    public final EObject entryRulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCallExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1591:2: (iv_rulePropertyCallExpression= rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1592:2: iv_rulePropertyCallExpression= rulePropertyCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2801);
            iv_rulePropertyCallExpression=rulePropertyCallExpression();
            _fsp--;

             current =iv_rulePropertyCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression2811); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1599:1: rulePropertyCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1604:6: ( ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1605:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1605:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1605:2: ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1605:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1606:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1606:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1607:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyCallExpression2854); 

            		createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1619:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==39) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1619:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,39,FOLLOW_39_in_rulePropertyCallExpression2865); 

                            createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1623:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1624:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1624:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1625:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2886);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1655:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1656:2: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1657:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2924);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();
            _fsp--;

             current =iv_ruleOperationCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression2934); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1664:1: ruleOperationCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject ruleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_suffix_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1669:6: ( ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1670:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1670:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1670:2: ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1670:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1671:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1671:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1672:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getOperationCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpression2977); 

            		createLeafNode(grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0(), "operation"); 
            	

            }


            }

            match(input,40,FOLLOW_40_in_ruleOperationCallExpression2987); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1688:1: ( (lv_arguments_2_0= ruleListOfValues ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_NULLLITERAL)||(LA21_0>=33 && LA21_0<=36)||LA21_0==38||LA21_0==40||(LA21_0>=43 && LA21_0<=44)||LA21_0==46||LA21_0==48||(LA21_0>=50 && LA21_0<=55)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1689:1: (lv_arguments_2_0= ruleListOfValues )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1689:1: (lv_arguments_2_0= ruleListOfValues )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1690:3: lv_arguments_2_0= ruleListOfValues
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListOfValues_in_ruleOperationCallExpression3008);
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

            match(input,41,FOLLOW_41_in_ruleOperationCallExpression3019); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1716:1: ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==39) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1716:3: '.' ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    {
                    match(input,39,FOLLOW_39_in_ruleOperationCallExpression3030); 

                            createLeafNode(grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1720:1: ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1721:1: (lv_suffix_5_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1721:1: (lv_suffix_5_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1722:3: lv_suffix_5_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression3051);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1752:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1753:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1754:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3089);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3099); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1761:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) ;
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
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1766:6: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1767:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1767:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            int alt23=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case 35:
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
            case 36:
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
                    new NoViableAltException("1767:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1768:5: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_ruleLiteral3146);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();
                    _fsp--;

                     
                            current = this_NumberLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1778:5: this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral3173);
                    this_DateTimeLiteralRule_1=ruleDateTimeLiteralRule();
                    _fsp--;

                     
                            current = this_DateTimeLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1788:5: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral3200);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();
                    _fsp--;

                     
                            current = this_BooleanLiteralRule_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1798:5: this_NullLiteralRule_3= ruleNullLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_ruleLiteral3227);
                    this_NullLiteralRule_3=ruleNullLiteralRule();
                    _fsp--;

                     
                            current = this_NullLiteralRule_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1808:5: this_DefaultLiteralRule_4= ruleDefaultLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral3254);
                    this_DefaultLiteralRule_4=ruleDefaultLiteralRule();
                    _fsp--;

                     
                            current = this_DefaultLiteralRule_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1818:5: this_StringLiteralRule_5= ruleStringLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_ruleLiteral3281);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1834:1: entryRuleNameOrChoiceOrBehaviorCall returns [EObject current=null] : iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF ;
    public final EObject entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrChoiceOrBehaviorCall = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1835:2: (iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1836:2: iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall3316);
            iv_ruleNameOrChoiceOrBehaviorCall=ruleNameOrChoiceOrBehaviorCall();
            _fsp--;

             current =iv_ruleNameOrChoiceOrBehaviorCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3326); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1843:1: ruleNameOrChoiceOrBehaviorCall returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) ;
    public final EObject ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;

        EObject lv_arguments_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1848:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1849:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1849:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1849:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1849:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==42) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1850:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1850:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1851:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3372);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1873:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1874:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1874:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1875:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNameOrChoiceOrBehaviorCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3391); 

            		createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0(), "id"); 
            	

            }


            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1887:2: ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1887:4: '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')'
                    {
                    match(input,40,FOLLOW_40_in_ruleNameOrChoiceOrBehaviorCall3402); 

                            createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1891:1: ( (lv_arguments_3_0= ruleListOfValues ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_NULLLITERAL)||(LA25_0>=33 && LA25_0<=36)||LA25_0==38||LA25_0==40||(LA25_0>=43 && LA25_0<=44)||LA25_0==46||LA25_0==48||(LA25_0>=50 && LA25_0<=55)) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1892:1: (lv_arguments_3_0= ruleListOfValues )
                            {
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1892:1: (lv_arguments_3_0= ruleListOfValues )
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1893:3: lv_arguments_3_0= ruleListOfValues
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3423);
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

                    match(input,41,FOLLOW_41_in_ruleNameOrChoiceOrBehaviorCall3434); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1927:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1928:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1929:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3472);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3482); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1936:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1941:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1942:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1942:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1942:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1942:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1943:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1943:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1944:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3525); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,42,FOLLOW_42_in_ruleQualifiedName3535); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1960:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==42) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1961:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1961:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1962:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName3556);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1992:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1993:2: (iv_ruleInterval= ruleInterval EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:1994:2: iv_ruleInterval= ruleInterval EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntervalRule(), currentNode); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval3593);
            iv_ruleInterval=ruleInterval();
            _fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval3603); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2001:1: ruleInterval returns [EObject current=null] : ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token lv_isLowerIncluded_1_0=null;
        Token lv_isUpperIncluded_5_0=null;
        EObject lv_lower_2_0 = null;

        EObject lv_upper_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2006:6: ( ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2007:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2007:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2007:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2007:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==43) ) {
                alt28=1;
            }
            else if ( (LA28_0==44) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2007:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2007:4: ']'
                    {
                    match(input,43,FOLLOW_43_in_ruleInterval3639); 

                            createLeafNode(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2012:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2012:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2013:1: (lv_isLowerIncluded_1_0= '[' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2013:1: (lv_isLowerIncluded_1_0= '[' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2014:3: lv_isLowerIncluded_1_0= '['
                    {
                    lv_isLowerIncluded_1_0=(Token)input.LT(1);
                    match(input,44,FOLLOW_44_in_ruleInterval3663); 

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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2033:3: ( (lv_lower_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2034:1: (lv_lower_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2034:1: (lv_lower_2_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2035:3: lv_lower_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3698);
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

            match(input,45,FOLLOW_45_in_ruleInterval3708); 

                    createLeafNode(grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2061:1: ( (lv_upper_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2062:1: (lv_upper_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2062:1: (lv_upper_4_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2063:3: lv_upper_4_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3729);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2085:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==43) ) {
                alt29=1;
            }
            else if ( (LA29_0==44) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2085:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2085:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2085:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2086:1: (lv_isUpperIncluded_5_0= ']' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2086:1: (lv_isUpperIncluded_5_0= ']' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2087:3: lv_isUpperIncluded_5_0= ']'
                    {
                    lv_isUpperIncluded_5_0=(Token)input.LT(1);
                    match(input,43,FOLLOW_43_in_ruleInterval3748); 

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
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2107:7: '['
                    {
                    match(input,44,FOLLOW_44_in_ruleInterval3777); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2119:1: entryRuleCollectionOrTuple returns [EObject current=null] : iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF ;
    public final EObject entryRuleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionOrTuple = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2120:2: (iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2121:2: iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCollectionOrTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3814);
            iv_ruleCollectionOrTuple=ruleCollectionOrTuple();
            _fsp--;

             current =iv_ruleCollectionOrTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple3824); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2128:1: ruleCollectionOrTuple returns [EObject current=null] : ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) ;
    public final EObject ruleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValues_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2133:6: ( ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2134:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2134:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2134:3: '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}'
            {
            match(input,46,FOLLOW_46_in_ruleCollectionOrTuple3859); 

                    createLeafNode(grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2138:1: ( (lv_listOfValues_1_0= ruleListOfValues ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2139:1: (lv_listOfValues_1_0= ruleListOfValues )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2139:1: (lv_listOfValues_1_0= ruleListOfValues )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2140:3: lv_listOfValues_1_0= ruleListOfValues
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3880);
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

            match(input,47,FOLLOW_47_in_ruleCollectionOrTuple3890); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2174:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2175:2: (iv_ruleTuple= ruleTuple EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2176:2: iv_ruleTuple= ruleTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple3926);
            iv_ruleTuple=ruleTuple();
            _fsp--;

             current =iv_ruleTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple3936); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2183:1: ruleTuple returns [EObject current=null] : ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValueNamePairs_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2188:6: ( ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2189:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2189:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2189:3: '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}'
            {
            match(input,46,FOLLOW_46_in_ruleTuple3971); 

                    createLeafNode(grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2193:1: ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2194:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2194:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2195:3: lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3992);
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

            match(input,47,FOLLOW_47_in_ruleTuple4002); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2229:1: entryRuleListOfValues returns [EObject current=null] : iv_ruleListOfValues= ruleListOfValues EOF ;
    public final EObject entryRuleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValues = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2230:2: (iv_ruleListOfValues= ruleListOfValues EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2231:2: iv_ruleListOfValues= ruleListOfValues EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValuesRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues4038);
            iv_ruleListOfValues=ruleListOfValues();
            _fsp--;

             current =iv_ruleListOfValues; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues4048); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2238:1: ruleListOfValues returns [EObject current=null] : ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2243:6: ( ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2244:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2244:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2244:2: ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2244:2: ( (lv_values_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2245:1: (lv_values_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2245:1: (lv_values_0_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2246:3: lv_values_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues4094);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2268:2: ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==18) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2268:4: ',' ( (lv_values_2_0= ruleExpression ) )
            	    {
            	    match(input,18,FOLLOW_18_in_ruleListOfValues4105); 

            	            createLeafNode(grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2272:1: ( (lv_values_2_0= ruleExpression ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2273:1: (lv_values_2_0= ruleExpression )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2273:1: (lv_values_2_0= ruleExpression )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2274:3: lv_values_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues4126);
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
            	    break loop30;
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2304:1: entryRuleListOfValueNamePairs returns [EObject current=null] : iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF ;
    public final EObject entryRuleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValueNamePairs = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2305:2: (iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2306:2: iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValueNamePairsRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs4164);
            iv_ruleListOfValueNamePairs=ruleListOfValueNamePairs();
            _fsp--;

             current =iv_ruleListOfValueNamePairs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs4174); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2313:1: ruleListOfValueNamePairs returns [EObject current=null] : ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) ;
    public final EObject ruleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject lv_valueNamePairs_0_0 = null;

        EObject lv_valueNamePairs_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2318:6: ( ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2319:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2319:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2319:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2319:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2320:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2320:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2321:3: lv_valueNamePairs_0_0= ruleValueNamePair
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4220);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2343:2: ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==18) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2343:4: ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    {
            	    match(input,18,FOLLOW_18_in_ruleListOfValueNamePairs4231); 

            	            createLeafNode(grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2347:1: ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2348:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    {
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2348:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2349:3: lv_valueNamePairs_2_0= ruleValueNamePair
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4252);
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
    // $ANTLR end ruleListOfValueNamePairs


    // $ANTLR start entryRuleValueNamePair
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2379:1: entryRuleValueNamePair returns [EObject current=null] : iv_ruleValueNamePair= ruleValueNamePair EOF ;
    public final EObject entryRuleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNamePair = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2380:2: (iv_ruleValueNamePair= ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2381:2: iv_ruleValueNamePair= ruleValueNamePair EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueNamePairRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair4290);
            iv_ruleValueNamePair=ruleValueNamePair();
            _fsp--;

             current =iv_ruleValueNamePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair4300); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2388:1: ruleValueNamePair returns [EObject current=null] : ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject lv_value_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2393:6: ( ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2394:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2394:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2394:2: ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2394:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2395:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2395:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2396:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getValueNamePairRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueNamePair4343); 

            		createLeafNode(grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            match(input,19,FOLLOW_19_in_ruleValueNamePair4353); 

                    createLeafNode(grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2412:1: ( (lv_value_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2413:1: (lv_value_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2413:1: (lv_value_2_0= ruleExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2414:3: lv_value_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleValueNamePair4374);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2444:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2445:2: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2446:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4410);
            iv_ruleTimeExpression=ruleTimeExpression();
            _fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression4420); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2453:1: ruleTimeExpression returns [EObject current=null] : (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_InstantObsExpression_0 = null;

        EObject this_DurationObsExpression_1 = null;

        EObject this_JitterExp_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2458:6: ( (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2459:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2459:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt32=1;
                }
                break;
            case 50:
                {
                alt32=2;
                }
                break;
            case 51:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2459:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2460:5: this_InstantObsExpression_0= ruleInstantObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4467);
                    this_InstantObsExpression_0=ruleInstantObsExpression();
                    _fsp--;

                     
                            current = this_InstantObsExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2470:5: this_DurationObsExpression_1= ruleDurationObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4494);
                    this_DurationObsExpression_1=ruleDurationObsExpression();
                    _fsp--;

                     
                            current = this_DurationObsExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2480:5: this_JitterExp_2= ruleJitterExp
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJitterExp_in_ruleTimeExpression4521);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2496:1: entryRuleInstantObsExpression returns [EObject current=null] : iv_ruleInstantObsExpression= ruleInstantObsExpression EOF ;
    public final EObject entryRuleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2497:2: (iv_ruleInstantObsExpression= ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2498:2: iv_ruleInstantObsExpression= ruleInstantObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4556);
            iv_ruleInstantObsExpression=ruleInstantObsExpression();
            _fsp--;

             current =iv_ruleInstantObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression4566); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2505:1: ruleInstantObsExpression returns [EObject current=null] : ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2510:6: ( ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2511:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2511:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2511:3: '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,48,FOLLOW_48_in_ruleInstantObsExpression4601); 

                    createLeafNode(grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2515:1: ( (lv_id_1_0= ruleInstantObsName ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2516:1: (lv_id_1_0= ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2516:1: (lv_id_1_0= ruleInstantObsName )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2517:3: lv_id_1_0= ruleInstantObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4622);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2539:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==40) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2539:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,40,FOLLOW_40_in_ruleInstantObsExpression4633); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2543:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2544:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2544:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2545:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4654);
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

                    match(input,41,FOLLOW_41_in_ruleInstantObsExpression4664); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2571:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==49) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2571:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,49,FOLLOW_49_in_ruleInstantObsExpression4677); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,40,FOLLOW_40_in_ruleInstantObsExpression4687); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2579:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2580:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2580:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2581:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4708);
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

                    match(input,41,FOLLOW_41_in_ruleInstantObsExpression4718); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2615:1: entryRuleInstantObsName returns [EObject current=null] : iv_ruleInstantObsName= ruleInstantObsName EOF ;
    public final EObject entryRuleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2616:2: (iv_ruleInstantObsName= ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2617:2: iv_ruleInstantObsName= ruleInstantObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4756);
            iv_ruleInstantObsName=ruleInstantObsName();
            _fsp--;

             current =iv_ruleInstantObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName4766); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2624:1: ruleInstantObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2629:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2630:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2630:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2630:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2630:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==42) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2631:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2631:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2632:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstantObsName4812);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2654:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2655:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2655:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2656:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getInstantObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstantObsName4831); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2676:1: entryRuleDurationObsExpression returns [EObject current=null] : iv_ruleDurationObsExpression= ruleDurationObsExpression EOF ;
    public final EObject entryRuleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsExpression = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2677:2: (iv_ruleDurationObsExpression= ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2678:2: iv_ruleDurationObsExpression= ruleDurationObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4867);
            iv_ruleDurationObsExpression=ruleDurationObsExpression();
            _fsp--;

             current =iv_ruleDurationObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression4877); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2685:1: ruleDurationObsExpression returns [EObject current=null] : ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2690:6: ( ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2691:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2691:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2691:3: '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,50,FOLLOW_50_in_ruleDurationObsExpression4912); 

                    createLeafNode(grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2695:1: ( (lv_id_1_0= ruleDurationObsName ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2696:1: (lv_id_1_0= ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2696:1: (lv_id_1_0= ruleDurationObsName )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2697:3: lv_id_1_0= ruleDurationObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4933);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2719:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==40) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2719:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,40,FOLLOW_40_in_ruleDurationObsExpression4944); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2723:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2724:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2724:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2725:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4965);
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

                    match(input,41,FOLLOW_41_in_ruleDurationObsExpression4975); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2751:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==49) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2751:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,49,FOLLOW_49_in_ruleDurationObsExpression4988); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,40,FOLLOW_40_in_ruleDurationObsExpression4998); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2759:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2760:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2760:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2761:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression5019);
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

                    match(input,41,FOLLOW_41_in_ruleDurationObsExpression5029); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2795:1: entryRuleDurationObsName returns [EObject current=null] : iv_ruleDurationObsName= ruleDurationObsName EOF ;
    public final EObject entryRuleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2796:2: (iv_ruleDurationObsName= ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2797:2: iv_ruleDurationObsName= ruleDurationObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName5067);
            iv_ruleDurationObsName=ruleDurationObsName();
            _fsp--;

             current =iv_ruleDurationObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName5077); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2804:1: ruleDurationObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2809:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2810:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2810:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2810:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2810:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==42) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2811:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2811:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2812:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDurationObsName5123);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2834:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2835:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2835:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2836:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDurationObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDurationObsName5142); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2856:1: entryRuleJitterExp returns [EObject current=null] : iv_ruleJitterExp= ruleJitterExp EOF ;
    public final EObject entryRuleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJitterExp = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2857:2: (iv_ruleJitterExp= ruleJitterExp EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2858:2: iv_ruleJitterExp= ruleJitterExp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJitterExpRule(), currentNode); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp5178);
            iv_ruleJitterExp=ruleJitterExp();
            _fsp--;

             current =iv_ruleJitterExp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp5188); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2865:1: ruleJitterExp returns [EObject current=null] : ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) ;
    public final EObject ruleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject lv_firstInstant_1_0 = null;

        EObject lv_secondInstant_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2870:6: ( ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2871:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2871:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2871:3: 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')'
            {
            match(input,51,FOLLOW_51_in_ruleJitterExp5223); 

                    createLeafNode(grammarAccess.getJitterExpAccess().getJitterKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2875:1: ( (lv_firstInstant_1_0= ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2876:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2876:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2877:3: lv_firstInstant_1_0= ruleInstantObsExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5244);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2899:2: ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==34) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2899:4: '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    {
                    match(input,34,FOLLOW_34_in_ruleJitterExp5255); 

                            createLeafNode(grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2903:1: ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2904:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2904:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2905:3: lv_secondInstant_3_0= ruleInstantObsExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5276);
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

            match(input,41,FOLLOW_41_in_ruleJitterExp5288); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2939:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2940:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2941:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration5324);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration5334); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2948:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        AntlrDatatypeRuleToken lv_variableDeclaration_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_initValue_7_0 = null;

        EObject lv_initValue_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2953:6: ( ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2954:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2954:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2954:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2954:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=53 && LA40_0<=55)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2955:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2955:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2956:3: lv_variableDeclaration_0_0= ruleVariableDirectionKind
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5380);
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

            match(input,52,FOLLOW_52_in_ruleVariableDeclaration5391); 

                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2982:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2983:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2983:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:2984:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration5408); 

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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3006:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==32) ) {
                alt42=1;
            }
            else if ( (LA42_0==19) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("3006:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3006:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3006:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3006:5: ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    {
                    match(input,32,FOLLOW_32_in_ruleVariableDeclaration5425); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3010:1: ( (lv_type_4_0= ruleDataTypeName ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3011:1: (lv_type_4_0= ruleDataTypeName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3011:1: (lv_type_4_0= ruleDataTypeName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3012:3: lv_type_4_0= ruleDataTypeName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5446);
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

                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3034:2: ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==19) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3034:4: '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')'
                            {
                            match(input,19,FOLLOW_19_in_ruleVariableDeclaration5457); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0(), null); 
                                
                            match(input,40,FOLLOW_40_in_ruleVariableDeclaration5467); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1(), null); 
                                
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3042:1: ( (lv_initValue_7_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3043:1: (lv_initValue_7_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3043:1: (lv_initValue_7_0= ruleExpression )
                            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3044:3: lv_initValue_7_0= ruleExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5488);
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

                            match(input,41,FOLLOW_41_in_ruleVariableDeclaration5498); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3071:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3071:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3071:8: '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')'
                    {
                    match(input,19,FOLLOW_19_in_ruleVariableDeclaration5518); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0(), null); 
                        
                    match(input,40,FOLLOW_40_in_ruleVariableDeclaration5528); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1(), null); 
                        
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3079:1: ( (lv_initValue_11_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3080:1: (lv_initValue_11_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3080:1: (lv_initValue_11_0= ruleExpression )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3081:3: lv_initValue_11_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5549);
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

                    match(input,41,FOLLOW_41_in_ruleVariableDeclaration5559); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3115:1: entryRuleVariableDirectionKind returns [String current=null] : iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF ;
    public final String entryRuleVariableDirectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableDirectionKind = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3116:2: (iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3117:2: iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDirectionKindRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5598);
            iv_ruleVariableDirectionKind=ruleVariableDirectionKind();
            _fsp--;

             current =iv_ruleVariableDirectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind5609); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3124:1: ruleVariableDirectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleVariableDirectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3129:6: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3130:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3130:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt43=1;
                }
                break;
            case 54:
                {
                alt43=2;
                }
                break;
            case 55:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3130:1: (kw= 'in' | kw= 'out' | kw= 'inout' )", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3131:2: kw= 'in'
                    {
                    kw=(Token)input.LT(1);
                    match(input,53,FOLLOW_53_in_ruleVariableDirectionKind5647); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3138:2: kw= 'out'
                    {
                    kw=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleVariableDirectionKind5666); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3145:2: kw= 'inout'
                    {
                    kw=(Token)input.LT(1);
                    match(input,55,FOLLOW_55_in_ruleVariableDirectionKind5685); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3158:1: entryRuleDataTypeName returns [EObject current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final EObject entryRuleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeName = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3159:2: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3160:2: iv_ruleDataTypeName= ruleDataTypeName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5725);
            iv_ruleDataTypeName=ruleDataTypeName();
            _fsp--;

             current =iv_ruleDataTypeName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName5735); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3167:1: ruleDataTypeName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3172:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3173:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3173:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3173:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3173:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==42) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3174:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3174:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3175:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDataTypeName5781);
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

            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3197:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3198:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3198:1: ( RULE_ID )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3199:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDataTypeNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataTypeName5800); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3219:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3220:2: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3221:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumberLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5836);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();
            _fsp--;

             current =iv_ruleNumberLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule5846); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3228:1: ruleNumberLiteralRule returns [EObject current=null] : (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteralRule_0 = null;

        EObject this_UnlimitedLiteralRule_1 = null;

        EObject this_RealLiteralRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3233:6: ( (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3234:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3234:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            int alt45=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
                {
                alt45=1;
                }
                break;
            case 35:
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
                    new NoViableAltException("3234:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3235:5: this_IntegerLiteralRule_0= ruleIntegerLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5893);
                    this_IntegerLiteralRule_0=ruleIntegerLiteralRule();
                    _fsp--;

                     
                            current = this_IntegerLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3245:5: this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5920);
                    this_UnlimitedLiteralRule_1=ruleUnlimitedLiteralRule();
                    _fsp--;

                     
                            current = this_UnlimitedLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3255:5: this_RealLiteralRule_2= ruleRealLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5947);
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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3271:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3272:2: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3273:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5982);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();
            _fsp--;

             current =iv_ruleIntegerLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule5992); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3280:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3285:6: ( ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3286:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3286:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3287:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3287:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3288:3: lv_value_0_0= RULE_INTEGERLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule6033); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3318:1: entryRuleUnlimitedLiteralRule returns [EObject current=null] : iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF ;
    public final EObject entryRuleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3319:2: (iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3320:2: iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnlimitedLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule6073);
            iv_ruleUnlimitedLiteralRule=ruleUnlimitedLiteralRule();
            _fsp--;

             current =iv_ruleUnlimitedLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule6083); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3327:1: ruleUnlimitedLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '*' ) ) ;
    public final EObject ruleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3332:6: ( ( (lv_value_0_0= '*' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3333:1: ( (lv_value_0_0= '*' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3333:1: ( (lv_value_0_0= '*' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3334:1: (lv_value_0_0= '*' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3334:1: (lv_value_0_0= '*' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3335:3: lv_value_0_0= '*'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,35,FOLLOW_35_in_ruleUnlimitedLiteralRule6125); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3362:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3363:2: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3364:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule6173);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();
            _fsp--;

             current =iv_ruleRealLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule6183); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3371:1: ruleRealLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_REALLITERAL ) ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3376:6: ( ( (lv_value_0_0= RULE_REALLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3377:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3377:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3378:1: (lv_value_0_0= RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3378:1: (lv_value_0_0= RULE_REALLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3379:3: lv_value_0_0= RULE_REALLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule6224); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3409:1: entryRuleDateTimeLiteralRule returns [EObject current=null] : iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF ;
    public final EObject entryRuleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTimeLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3410:2: (iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3411:2: iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDateTimeLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule6264);
            iv_ruleDateTimeLiteralRule=ruleDateTimeLiteralRule();
            _fsp--;

             current =iv_ruleDateTimeLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule6274); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3418:1: ruleDateTimeLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) ;
    public final EObject ruleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3423:6: ( ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3424:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3424:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3425:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3425:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3426:3: lv_value_0_0= RULE_DATETIMELITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule6315); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3456:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3457:2: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3458:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6355);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();
            _fsp--;

             current =iv_ruleBooleanLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule6365); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3465:1: ruleBooleanLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3470:6: ( ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3471:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3471:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3472:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3472:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3473:3: lv_value_0_0= RULE_BOOLEANLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6406); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3503:1: entryRuleNullLiteralRule returns [EObject current=null] : iv_ruleNullLiteralRule= ruleNullLiteralRule EOF ;
    public final EObject entryRuleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3504:2: (iv_ruleNullLiteralRule= ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3505:2: iv_ruleNullLiteralRule= ruleNullLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6446);
            iv_ruleNullLiteralRule=ruleNullLiteralRule();
            _fsp--;

             current =iv_ruleNullLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule6456); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3512:1: ruleNullLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_NULLLITERAL ) ) ;
    public final EObject ruleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3517:6: ( ( (lv_value_0_0= RULE_NULLLITERAL ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3518:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3518:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3519:1: (lv_value_0_0= RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3519:1: (lv_value_0_0= RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3520:3: lv_value_0_0= RULE_NULLLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6497); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3550:1: entryRuleDefaultLiteralRule returns [EObject current=null] : iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF ;
    public final EObject entryRuleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3551:2: (iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3552:2: iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefaultLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6537);
            iv_ruleDefaultLiteralRule=ruleDefaultLiteralRule();
            _fsp--;

             current =iv_ruleDefaultLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule6547); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3559:1: ruleDefaultLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '/' ) ) ;
    public final EObject ruleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3564:6: ( ( (lv_value_0_0= '/' ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3565:1: ( (lv_value_0_0= '/' ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3565:1: ( (lv_value_0_0= '/' ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3566:1: (lv_value_0_0= '/' )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3566:1: (lv_value_0_0= '/' )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3567:3: lv_value_0_0= '/'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,36,FOLLOW_36_in_ruleDefaultLiteralRule6589); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3594:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3595:2: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3596:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6637);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();
            _fsp--;

             current =iv_ruleStringLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule6647); 

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
    // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3603:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3608:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3609:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3609:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3610:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3610:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.g:3611:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteralRule6688); 

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
    public static final BitSet FOLLOW_RULE_ID_in_ruleTagSpecificationRule386 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleExpressionValueRule_in_ruleTagSpecificationRule407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionValueRule_in_entryRuleExpressionValueRule443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionValueRule453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleExpressionValueRule488 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionValueRule509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleImport592 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContext_in_entryRuleContext650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContext660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleContext695 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContext713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_ruleExpression804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression895 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_22_in_ruleAndOrXorExpression916 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_23_in_ruleAndOrXorExpression945 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_24_in_ruleAndOrXorExpression974 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression1011 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1049 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1105 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_25_in_ruleEqualityExpression1126 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_26_in_ruleEqualityExpression1155 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1192 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1286 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_27_in_ruleRelationalExpression1307 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_28_in_ruleRelationalExpression1336 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_29_in_ruleRelationalExpression1365 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_30_in_ruleRelationalExpression1394 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1431 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1525 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleConditionalExpression1544 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1578 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleConditionalExpression1588 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1703 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_33_in_ruleAdditiveExpression1724 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_34_in_ruleAdditiveExpression1753 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1790 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1828 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1884 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_35_in_ruleMultiplicativeExpression1905 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_36_in_ruleMultiplicativeExpression1934 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_37_in_ruleMultiplicativeExpression1963 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2000 = new BitSet(new long[]{0x0000003800000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression2038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleUnaryExpression2094 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_34_in_ruleUnaryExpression2123 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_33_in_ruleUnaryExpression2152 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rulePrimaryExpression2309 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_rulePrimaryExpression2320 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleValueSpecification2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleValueSpecification2490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleValueSpecification2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleValueSpecification2571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleValueSpecification2614 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueSpecification2636 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleValueSpecification2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression2692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression2811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyCallExpression2854 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_rulePropertyCallExpression2865 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression2934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpression2977 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleOperationCallExpression2987 = new BitSet(new long[]{0x00FD5B5E000007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleOperationCallExpression3008 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleOperationCallExpression3019 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleOperationCallExpression3030 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3089 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_ruleLiteral3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral3173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_ruleLiteral3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral3254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_ruleLiteral3281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall3316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3391 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleNameOrChoiceOrBehaviorCall3402 = new BitSet(new long[]{0x00FD5B5E000007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3423 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleNameOrChoiceOrBehaviorCall3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3525 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleQualifiedName3535 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval3593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleInterval3639 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_44_in_ruleInterval3663 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3698 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleInterval3708 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3729 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_43_in_ruleInterval3748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleInterval3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple3824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleCollectionOrTuple3859 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3880 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleCollectionOrTuple3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple3926 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple3936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleTuple3971 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3992 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleTuple4002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues4038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues4094 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleListOfValues4105 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues4126 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs4164 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs4174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4220 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleListOfValueNamePairs4231 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs4252 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair4290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair4300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueNamePair4343 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleValueNamePair4353 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueNamePair4374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression4420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_ruleTimeExpression4521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression4566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleInstantObsExpression4601 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4622 = new BitSet(new long[]{0x0002010000000002L});
    public static final BitSet FOLLOW_40_in_ruleInstantObsExpression4633 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4654 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleInstantObsExpression4664 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleInstantObsExpression4677 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleInstantObsExpression4687 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4708 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleInstantObsExpression4718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName4766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstantObsName4812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstantObsName4831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression4877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleDurationObsExpression4912 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4933 = new BitSet(new long[]{0x0002010000000002L});
    public static final BitSet FOLLOW_40_in_ruleDurationObsExpression4944 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4965 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleDurationObsExpression4975 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleDurationObsExpression4988 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDurationObsExpression4998 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression5019 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleDurationObsExpression5029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName5067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName5077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDurationObsName5123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDurationObsName5142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp5178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp5188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleJitterExp5223 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5244 = new BitSet(new long[]{0x0000020400000000L});
    public static final BitSet FOLLOW_34_in_ruleJitterExp5255 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp5276 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleJitterExp5288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration5324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration5334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5380 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleVariableDeclaration5391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration5408 = new BitSet(new long[]{0x0000000100080000L});
    public static final BitSet FOLLOW_32_in_ruleVariableDeclaration5425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5446 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVariableDeclaration5457 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleVariableDeclaration5467 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5488 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleVariableDeclaration5498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleVariableDeclaration5518 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleVariableDeclaration5528 = new BitSet(new long[]{0x00FD595E000007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5549 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleVariableDeclaration5559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind5609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleVariableDirectionKind5647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleVariableDirectionKind5666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleVariableDirectionKind5685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5725 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName5735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDataTypeName5781 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeName5800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule5846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule5992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule6073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule6083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleUnlimitedLiteralRule6125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule6173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule6183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule6224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule6264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule6274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule6315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6355 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule6365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule6456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule6547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleDefaultLiteralRule6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule6647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteralRule6688 = new BitSet(new long[]{0x0000000000000002L});

}