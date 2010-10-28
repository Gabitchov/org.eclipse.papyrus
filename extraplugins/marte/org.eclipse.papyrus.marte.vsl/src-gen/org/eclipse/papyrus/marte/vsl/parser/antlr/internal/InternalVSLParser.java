package org.eclipse.papyrus.marte.vsl.parser.antlr.internal; 

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
import org.eclipse.papyrus.marte.vsl.services.VSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INTEGERLITERAL", "RULE_REALLITERAL", "RULE_DATETIMELITERAL", "RULE_BOOLEANLITERAL", "RULE_NULLLITERAL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'value'", "'import'", "'context'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'?'", "':'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'not'", "'.'", "'('", "')'", "'::'", "']'", "'['", "'..'", "'{'", "'}'", "','", "'='", "'@'", "'when'", "'&'", "'jitter('", "'$'", "'in'", "'out'", "'inout'"
    };
    public static final int RULE_NULLLITERAL=10;
    public static final int RULE_DATETIMELITERAL=8;
    public static final int RULE_BOOLEANLITERAL=9;
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_REALLITERAL=7;
    public static final int RULE_INTEGERLITERAL=6;
    public static final int RULE_INT=11;
    public static final int RULE_WS=14;
    public static final int RULE_SL_COMMENT=13;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=12;

        public InternalVSLParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g"; }



     	private VSLGrammarAccess grammarAccess;
     	
        public InternalVSLParser(TokenStream input, IAstFactory factory, VSLGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected VSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:86:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) ) ( (lv_context_1_0= ruleContext ) ) ( 'value' ( (lv_value_3_0= ruleExpression ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_context_1_0 = null;

        EObject lv_value_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:91:6: ( ( ( (lv_imports_0_0= ruleImport ) ) ( (lv_context_1_0= ruleContext ) ) ( 'value' ( (lv_value_3_0= ruleExpression ) ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:92:1: ( ( (lv_imports_0_0= ruleImport ) ) ( (lv_context_1_0= ruleContext ) ) ( 'value' ( (lv_value_3_0= ruleExpression ) ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:92:1: ( ( (lv_imports_0_0= ruleImport ) ) ( (lv_context_1_0= ruleContext ) ) ( 'value' ( (lv_value_3_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:92:2: ( (lv_imports_0_0= ruleImport ) ) ( (lv_context_1_0= ruleContext ) ) ( 'value' ( (lv_value_3_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:92:2: ( (lv_imports_0_0= ruleImport ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:93:1: (lv_imports_0_0= ruleImport )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:93:1: (lv_imports_0_0= ruleImport )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:94:3: lv_imports_0_0= ruleImport
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleImport_in_ruleModel131);
            lv_imports_0_0=ruleImport();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"imports",
            	        		lv_imports_0_0, 
            	        		"Import", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:116:2: ( (lv_context_1_0= ruleContext ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:117:1: (lv_context_1_0= ruleContext )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:117:1: (lv_context_1_0= ruleContext )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:118:3: lv_context_1_0= ruleContext
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getContextContextParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleContext_in_ruleModel152);
            lv_context_1_0=ruleContext();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"context",
            	        		lv_context_1_0, 
            	        		"Context", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:140:2: ( 'value' ( (lv_value_3_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:140:4: 'value' ( (lv_value_3_0= ruleExpression ) )
            {
            match(input,16,FOLLOW_16_in_ruleModel163); 

                    createLeafNode(grammarAccess.getModelAccess().getValueKeyword_2_0(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:144:1: ( (lv_value_3_0= ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:145:1: (lv_value_3_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:145:1: (lv_value_3_0= ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:146:3: lv_value_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueExpressionParserRuleCall_2_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleModel184);
            lv_value_3_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_3_0, 
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleImport
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:176:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:177:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:178:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport221);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport231); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:185:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:190:6: ( ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:191:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:191:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:191:3: 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            match(input,17,FOLLOW_17_in_ruleImport266); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:195:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:196:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:196:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:197:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport283); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:227:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:228:2: (iv_ruleContext= ruleContext EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:229:2: iv_ruleContext= ruleContext EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContextRule(), currentNode); 
            pushFollow(FOLLOW_ruleContext_in_entryRuleContext324);
            iv_ruleContext=ruleContext();
            _fsp--;

             current =iv_ruleContext; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContext334); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:236:1: ruleContext returns [EObject current=null] : ( 'context' ( ( RULE_ID ) ) ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:241:6: ( ( 'context' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:242:1: ( 'context' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:242:1: ( 'context' ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:242:3: 'context' ( ( RULE_ID ) )
            {
            match(input,18,FOLLOW_18_in_ruleContext369); 

                    createLeafNode(grammarAccess.getContextAccess().getContextKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:246:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:247:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:247:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:248:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getContextRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContext387); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:268:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:269:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:270:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression423);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression433); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:277:1: ruleExpression returns [EObject current=null] : ( (lv_exp_0_0= ruleAndOrXorExpression ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:282:6: ( ( (lv_exp_0_0= ruleAndOrXorExpression ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:283:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:283:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:284:1: (lv_exp_0_0= ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:284:1: (lv_exp_0_0= ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:285:3: lv_exp_0_0= ruleAndOrXorExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_ruleExpression478);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:315:1: entryRuleAndOrXorExpression returns [EObject current=null] : iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF ;
    public final EObject entryRuleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrXorExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:316:2: (iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:317:2: iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndOrXorExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression513);
            iv_ruleAndOrXorExpression=ruleAndOrXorExpression();
            _fsp--;

             current =iv_ruleAndOrXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression523); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:324:1: ruleAndOrXorExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:329:6: ( ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:330:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:330:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:330:2: ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:330:2: ( (lv_exp_0_0= ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:331:1: (lv_exp_0_0= ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:331:1: (lv_exp_0_0= ruleEqualityExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:332:3: lv_exp_0_0= ruleEqualityExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression569);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:354:2: ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=19 && LA2_0<=21)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:354:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:354:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:355:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:355:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:356:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:356:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    int alt1=3;
            	    switch ( input.LA(1) ) {
            	    case 19:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case 20:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    case 21:
            	        {
            	        alt1=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("356:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )", 1, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:357:3: lv_op_1_1= 'and'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,19,FOLLOW_19_in_ruleAndOrXorExpression590); 

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
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:375:8: lv_op_1_2= 'or'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,20,FOLLOW_20_in_ruleAndOrXorExpression619); 

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
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:393:8: lv_op_1_3= 'xor'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,21,FOLLOW_21_in_ruleAndOrXorExpression648); 

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

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:414:2: ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:415:1: (lv_exp_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:415:1: (lv_exp_2_0= ruleEqualityExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:416:3: lv_exp_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression685);
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
            	    break loop2;
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:446:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:447:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:448:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression723);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression733); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:455:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:460:6: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:461:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:461:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:461:2: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:461:2: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:462:1: (lv_exp_0_0= ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:462:1: (lv_exp_0_0= ruleRelationalExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:463:3: lv_exp_0_0= ruleRelationalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression779);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:485:2: ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=22 && LA4_0<=23)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:485:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:485:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:486:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:486:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:487:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:487:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==22) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==23) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("487:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:488:3: lv_op_1_1= '=='
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,22,FOLLOW_22_in_ruleEqualityExpression800); 

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
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:506:8: lv_op_1_2= '<>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,23,FOLLOW_23_in_ruleEqualityExpression829); 

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

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:527:2: ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:528:1: (lv_exp_2_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:528:1: (lv_exp_2_0= ruleRelationalExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:529:3: lv_exp_2_0= ruleRelationalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression866);
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
            	    break loop4;
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:559:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:560:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:561:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression904);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression914); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:568:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) ;
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:573:6: ( ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:574:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:574:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:574:2: ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:574:2: ( (lv_exp_0_0= ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:575:1: (lv_exp_0_0= ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:575:1: (lv_exp_0_0= ruleConditionalExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:576:3: lv_exp_0_0= ruleConditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression960);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:598:2: ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=24 && LA6_0<=27)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:598:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:598:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:599:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:599:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:600:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:600:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    int alt5=4;
            	    switch ( input.LA(1) ) {
            	    case 24:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    case 27:
            	        {
            	        alt5=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("600:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:601:3: lv_op_1_1= '<'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,24,FOLLOW_24_in_ruleRelationalExpression981); 

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
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:619:8: lv_op_1_2= '>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,25,FOLLOW_25_in_ruleRelationalExpression1010); 

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
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:637:8: lv_op_1_3= '<='
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,26,FOLLOW_26_in_ruleRelationalExpression1039); 

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
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:655:8: lv_op_1_4= '>='
            	            {
            	            lv_op_1_4=(Token)input.LT(1);
            	            match(input,27,FOLLOW_27_in_ruleRelationalExpression1068); 

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

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:676:2: ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:677:1: (lv_exp_2_0= ruleConditionalExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:677:1: (lv_exp_2_0= ruleConditionalExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:678:3: lv_exp_2_0= ruleConditionalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1105);
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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleConditionalExpression
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:708:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:709:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:710:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1143);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression1153); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:717:1: ruleConditionalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;

        EObject lv_exp_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:722:6: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:723:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:723:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:723:2: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:723:2: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:724:1: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:724:1: (lv_exp_0_0= ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:725:3: lv_exp_0_0= ruleAdditiveExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1199);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:747:2: ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==28) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:747:3: ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:747:3: ( (lv_op_1_0= '?' ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:748:1: (lv_op_1_0= '?' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:748:1: (lv_op_1_0= '?' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:749:3: lv_op_1_0= '?'
                    {
                    lv_op_1_0=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_ruleConditionalExpression1218); 

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

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:768:2: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:769:1: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:769:1: (lv_exp_2_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:770:3: lv_exp_2_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1252);
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

                    match(input,29,FOLLOW_29_in_ruleConditionalExpression1262); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:796:1: ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:797:1: (lv_exp_4_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:797:1: (lv_exp_4_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:798:3: lv_exp_4_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1283);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:828:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:829:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:830:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1321);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1331); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:837:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:842:6: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:843:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:843:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:843:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:843:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:844:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:844:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:845:3: lv_exp_0_0= ruleMultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1377);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:867:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=30 && LA9_0<=31)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:867:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:867:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:868:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:868:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:869:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:869:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==30) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==31) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("869:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:870:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,30,FOLLOW_30_in_ruleAdditiveExpression1398); 

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
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:888:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,31,FOLLOW_31_in_ruleAdditiveExpression1427); 

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

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:909:2: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:910:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:910:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:911:3: lv_exp_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1464);
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
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:941:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:942:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:943:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1502);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression1512); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:950:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:955:6: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:956:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:956:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:956:2: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:956:2: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:957:1: (lv_exp_0_0= ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:957:1: (lv_exp_0_0= ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:958:3: lv_exp_0_0= ruleUnaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1558);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:980:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=32 && LA11_0<=34)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:980:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:980:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:981:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:981:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:982:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:982:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    int alt10=3;
            	    switch ( input.LA(1) ) {
            	    case 32:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("982:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )", 10, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:983:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,32,FOLLOW_32_in_ruleMultiplicativeExpression1579); 

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
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1001:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,33,FOLLOW_33_in_ruleMultiplicativeExpression1608); 

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
            	            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1019:8: lv_op_1_3= 'mod'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,34,FOLLOW_34_in_ruleMultiplicativeExpression1637); 

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

            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1040:2: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1041:1: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1041:1: (lv_exp_2_0= ruleUnaryExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1042:3: lv_exp_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1674);
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
            	    break loop11;
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1072:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1073:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1074:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1712);
            iv_ruleUnaryExpression=ruleUnaryExpression();
            _fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression1722); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1081:1: ruleUnaryExpression returns [EObject current=null] : ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        EObject lv_unary_1_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1086:6: ( ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1087:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1087:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=30 && LA13_0<=31)||LA13_0==35) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_NULLLITERAL)||(LA13_0>=32 && LA13_0<=33)||LA13_0==37||(LA13_0>=40 && LA13_0<=41)||LA13_0==43||LA13_0==47||(LA13_0>=49 && LA13_0<=54)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1087:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1087:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1087:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1087:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1087:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1088:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1088:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1089:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1089:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    int alt12=3;
                    switch ( input.LA(1) ) {
                    case 35:
                        {
                        alt12=1;
                        }
                        break;
                    case 31:
                        {
                        alt12=2;
                        }
                        break;
                    case 30:
                        {
                        alt12=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("1089:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )", 12, 0, input);

                        throw nvae;
                    }

                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1090:3: lv_op_0_1= 'not'
                            {
                            lv_op_0_1=(Token)input.LT(1);
                            match(input,35,FOLLOW_35_in_ruleUnaryExpression1768); 

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
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1108:8: lv_op_0_2= '-'
                            {
                            lv_op_0_2=(Token)input.LT(1);
                            match(input,31,FOLLOW_31_in_ruleUnaryExpression1797); 

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
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1126:8: lv_op_0_3= '+'
                            {
                            lv_op_0_3=(Token)input.LT(1);
                            match(input,30,FOLLOW_30_in_ruleUnaryExpression1826); 

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

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1147:2: ( (lv_unary_1_0= ruleUnaryExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1148:1: (lv_unary_1_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1148:1: (lv_unary_1_0= ruleUnaryExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1149:3: lv_unary_1_0= ruleUnaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1863);
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
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1172:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1172:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1173:1: (lv_exp_2_0= rulePrimaryExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1173:1: (lv_exp_2_0= rulePrimaryExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1174:3: lv_exp_2_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1891);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1204:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1205:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1206:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1927);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1937); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1213:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_prefix_0_0 = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1218:6: ( ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1219:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1219:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1219:2: ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1219:2: ( (lv_prefix_0_0= ruleValueSpecification ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1220:1: (lv_prefix_0_0= ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1220:1: (lv_prefix_0_0= ruleValueSpecification )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1221:3: lv_prefix_0_0= ruleValueSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueSpecification_in_rulePrimaryExpression1983);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1243:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==36) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1243:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,36,FOLLOW_36_in_rulePrimaryExpression1994); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1247:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1248:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1248:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1249:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2015);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1279:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1280:2: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1281:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2053);
            iv_ruleValueSpecification=ruleValueSpecification();
            _fsp--;

             current =iv_ruleValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification2063); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1288:1: ruleValueSpecification returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) ;
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1293:6: ( (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1294:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1294:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            int alt15=8;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case RULE_DATETIMELITERAL:
            case RULE_BOOLEANLITERAL:
            case RULE_NULLLITERAL:
            case 32:
            case 33:
                {
                alt15=1;
                }
                break;
            case RULE_ID:
                {
                alt15=2;
                }
                break;
            case 40:
            case 41:
                {
                alt15=3;
                }
                break;
            case 43:
                {
                int LA15_4 = input.LA(2);

                if ( (LA15_4==RULE_STRING||(LA15_4>=RULE_INTEGERLITERAL && LA15_4<=RULE_NULLLITERAL)||(LA15_4>=30 && LA15_4<=33)||LA15_4==35||LA15_4==37||(LA15_4>=40 && LA15_4<=41)||LA15_4==43||LA15_4==47||(LA15_4>=49 && LA15_4<=54)) ) {
                    alt15=4;
                }
                else if ( (LA15_4==RULE_ID) ) {
                    int LA15_9 = input.LA(3);

                    if ( (LA15_9==46) ) {
                        alt15=5;
                    }
                    else if ( ((LA15_9>=19 && LA15_9<=28)||(LA15_9>=30 && LA15_9<=34)||(LA15_9>=36 && LA15_9<=37)||LA15_9==39||(LA15_9>=44 && LA15_9<=45)) ) {
                        alt15=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1294:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 15, 9, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1294:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 15, 4, input);

                    throw nvae;
                }
                }
                break;
            case 47:
            case 49:
            case 50:
                {
                alt15=6;
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
                {
                alt15=7;
                }
                break;
            case 37:
                {
                alt15=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1294:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1295:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleValueSpecification2110);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1305:5: this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2137);
                    this_NameOrChoiceOrBehaviorCall_1=ruleNameOrChoiceOrBehaviorCall();
                    _fsp--;

                     
                            current = this_NameOrChoiceOrBehaviorCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1315:5: this_Interval_2= ruleInterval
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInterval_in_ruleValueSpecification2164);
                    this_Interval_2=ruleInterval();
                    _fsp--;

                     
                            current = this_Interval_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1325:5: this_CollectionOrTuple_3= ruleCollectionOrTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2191);
                    this_CollectionOrTuple_3=ruleCollectionOrTuple();
                    _fsp--;

                     
                            current = this_CollectionOrTuple_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1335:5: this_Tuple_4= ruleTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTuple_in_ruleValueSpecification2218);
                    this_Tuple_4=ruleTuple();
                    _fsp--;

                     
                            current = this_Tuple_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1345:5: this_TimeExpression_5= ruleTimeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeExpression_in_ruleValueSpecification2245);
                    this_TimeExpression_5=ruleTimeExpression();
                    _fsp--;

                     
                            current = this_TimeExpression_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1355:5: this_VariableDeclaration_6= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2272);
                    this_VariableDeclaration_6=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1364:6: ( '(' this_Expression_8= ruleExpression ')' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1364:6: ( '(' this_Expression_8= ruleExpression ')' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1364:8: '(' this_Expression_8= ruleExpression ')'
                    {
                    match(input,37,FOLLOW_37_in_ruleValueSpecification2288); 

                            createLeafNode(grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleValueSpecification2310);
                    this_Expression_8=ruleExpression();
                    _fsp--;

                     
                            current = this_Expression_8; 
                            currentNode = currentNode.getParent();
                        
                    match(input,38,FOLLOW_38_in_ruleValueSpecification2319); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1389:1: entryRuleSuffixExpression returns [EObject current=null] : iv_ruleSuffixExpression= ruleSuffixExpression EOF ;
    public final EObject entryRuleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuffixExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1390:2: (iv_ruleSuffixExpression= ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1391:2: iv_ruleSuffixExpression= ruleSuffixExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuffixExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2356);
            iv_ruleSuffixExpression=ruleSuffixExpression();
            _fsp--;

             current =iv_ruleSuffixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression2366); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1398:1: ruleSuffixExpression returns [EObject current=null] : (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) ;
    public final EObject ruleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyCallExpression_0 = null;

        EObject this_OperationCallExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1403:6: ( (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1404:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1404:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==37) ) {
                    alt16=2;
                }
                else if ( (LA16_1==EOF||(LA16_1>=19 && LA16_1<=34)||LA16_1==36||LA16_1==38||(LA16_1>=40 && LA16_1<=42)||(LA16_1>=44 && LA16_1<=45)) ) {
                    alt16=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1404:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1404:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1405:5: this_PropertyCallExpression_0= rulePropertyCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2413);
                    this_PropertyCallExpression_0=rulePropertyCallExpression();
                    _fsp--;

                     
                            current = this_PropertyCallExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1415:5: this_OperationCallExpression_1= ruleOperationCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2440);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1431:1: entryRulePropertyCallExpression returns [EObject current=null] : iv_rulePropertyCallExpression= rulePropertyCallExpression EOF ;
    public final EObject entryRulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCallExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1432:2: (iv_rulePropertyCallExpression= rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1433:2: iv_rulePropertyCallExpression= rulePropertyCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2475);
            iv_rulePropertyCallExpression=rulePropertyCallExpression();
            _fsp--;

             current =iv_rulePropertyCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression2485); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1440:1: rulePropertyCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1445:6: ( ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1446:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1446:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1446:2: ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1446:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1447:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1447:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1448:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyCallExpression2528); 

            		createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1460:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==36) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1460:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,36,FOLLOW_36_in_rulePropertyCallExpression2539); 

                            createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1464:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1465:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1465:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1466:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2560);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1496:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1497:2: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1498:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2598);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();
            _fsp--;

             current =iv_ruleOperationCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression2608); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1505:1: ruleOperationCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject ruleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_suffix_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1510:6: ( ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1511:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1511:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1511:2: ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1511:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1512:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1512:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1513:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getOperationCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpression2651); 

            		createLeafNode(grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0(), "operation"); 
            	

            }


            }

            match(input,37,FOLLOW_37_in_ruleOperationCallExpression2661); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1529:1: ( (lv_arguments_2_0= ruleListOfValues ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_NULLLITERAL)||(LA18_0>=30 && LA18_0<=33)||LA18_0==35||LA18_0==37||(LA18_0>=40 && LA18_0<=41)||LA18_0==43||LA18_0==47||(LA18_0>=49 && LA18_0<=54)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1530:1: (lv_arguments_2_0= ruleListOfValues )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1530:1: (lv_arguments_2_0= ruleListOfValues )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1531:3: lv_arguments_2_0= ruleListOfValues
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2682);
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

            match(input,38,FOLLOW_38_in_ruleOperationCallExpression2693); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1557:1: ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==36) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1557:3: '.' ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    {
                    match(input,36,FOLLOW_36_in_ruleOperationCallExpression2704); 

                            createLeafNode(grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1561:1: ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1562:1: (lv_suffix_5_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1562:1: (lv_suffix_5_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1563:3: lv_suffix_5_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2725);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1593:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1594:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1595:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2763);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2773); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1602:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) ;
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
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1607:6: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1608:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1608:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            int alt20=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case 32:
                {
                alt20=1;
                }
                break;
            case RULE_DATETIMELITERAL:
                {
                alt20=2;
                }
                break;
            case RULE_BOOLEANLITERAL:
                {
                alt20=3;
                }
                break;
            case RULE_NULLLITERAL:
                {
                alt20=4;
                }
                break;
            case 33:
                {
                alt20=5;
                }
                break;
            case RULE_STRING:
                {
                alt20=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1608:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1609:5: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2820);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();
                    _fsp--;

                     
                            current = this_NumberLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1619:5: this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2847);
                    this_DateTimeLiteralRule_1=ruleDateTimeLiteralRule();
                    _fsp--;

                     
                            current = this_DateTimeLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1629:5: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2874);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();
                    _fsp--;

                     
                            current = this_BooleanLiteralRule_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1639:5: this_NullLiteralRule_3= ruleNullLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_ruleLiteral2901);
                    this_NullLiteralRule_3=ruleNullLiteralRule();
                    _fsp--;

                     
                            current = this_NullLiteralRule_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1649:5: this_DefaultLiteralRule_4= ruleDefaultLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2928);
                    this_DefaultLiteralRule_4=ruleDefaultLiteralRule();
                    _fsp--;

                     
                            current = this_DefaultLiteralRule_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1659:5: this_StringLiteralRule_5= ruleStringLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_ruleLiteral2955);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1675:1: entryRuleNameOrChoiceOrBehaviorCall returns [EObject current=null] : iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF ;
    public final EObject entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrChoiceOrBehaviorCall = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1676:2: (iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1677:2: iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall2990);
            iv_ruleNameOrChoiceOrBehaviorCall=ruleNameOrChoiceOrBehaviorCall();
            _fsp--;

             current =iv_ruleNameOrChoiceOrBehaviorCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3000); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1684:1: ruleNameOrChoiceOrBehaviorCall returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) ;
    public final EObject ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;

        EObject lv_arguments_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1689:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1690:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1690:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1690:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1690:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==39) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1691:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1691:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1692:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3046);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1714:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1715:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1715:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1716:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNameOrChoiceOrBehaviorCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3065); 

            		createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0(), "id"); 
            	

            }


            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1728:2: ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==37) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1728:4: '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')'
                    {
                    match(input,37,FOLLOW_37_in_ruleNameOrChoiceOrBehaviorCall3076); 

                            createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1732:1: ( (lv_arguments_3_0= ruleListOfValues ) )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_NULLLITERAL)||(LA22_0>=30 && LA22_0<=33)||LA22_0==35||LA22_0==37||(LA22_0>=40 && LA22_0<=41)||LA22_0==43||LA22_0==47||(LA22_0>=49 && LA22_0<=54)) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1733:1: (lv_arguments_3_0= ruleListOfValues )
                            {
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1733:1: (lv_arguments_3_0= ruleListOfValues )
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1734:3: lv_arguments_3_0= ruleListOfValues
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3097);
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

                    match(input,38,FOLLOW_38_in_ruleNameOrChoiceOrBehaviorCall3108); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1768:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1769:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1770:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3146);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3156); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1777:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1782:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1783:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1783:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1783:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1783:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1784:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1784:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1785:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3199); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,39,FOLLOW_39_in_ruleQualifiedName3209); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1801:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==39) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1802:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1802:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1803:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName3230);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1833:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1834:2: (iv_ruleInterval= ruleInterval EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1835:2: iv_ruleInterval= ruleInterval EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntervalRule(), currentNode); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval3267);
            iv_ruleInterval=ruleInterval();
            _fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval3277); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1842:1: ruleInterval returns [EObject current=null] : ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token lv_isLowerIncluded_1_0=null;
        Token lv_isUpperIncluded_5_0=null;
        EObject lv_lower_2_0 = null;

        EObject lv_upper_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1847:6: ( ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1848:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1848:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1848:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1848:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==40) ) {
                alt25=1;
            }
            else if ( (LA25_0==41) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1848:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1848:4: ']'
                    {
                    match(input,40,FOLLOW_40_in_ruleInterval3313); 

                            createLeafNode(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1853:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1853:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1854:1: (lv_isLowerIncluded_1_0= '[' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1854:1: (lv_isLowerIncluded_1_0= '[' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1855:3: lv_isLowerIncluded_1_0= '['
                    {
                    lv_isLowerIncluded_1_0=(Token)input.LT(1);
                    match(input,41,FOLLOW_41_in_ruleInterval3337); 

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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1874:3: ( (lv_lower_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1875:1: (lv_lower_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1875:1: (lv_lower_2_0= ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1876:3: lv_lower_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3372);
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

            match(input,42,FOLLOW_42_in_ruleInterval3382); 

                    createLeafNode(grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1902:1: ( (lv_upper_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1903:1: (lv_upper_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1903:1: (lv_upper_4_0= ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1904:3: lv_upper_4_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3403);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1926:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            else if ( (LA26_0==41) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1926:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1926:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1926:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1927:1: (lv_isUpperIncluded_5_0= ']' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1927:1: (lv_isUpperIncluded_5_0= ']' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1928:3: lv_isUpperIncluded_5_0= ']'
                    {
                    lv_isUpperIncluded_5_0=(Token)input.LT(1);
                    match(input,40,FOLLOW_40_in_ruleInterval3422); 

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
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1948:7: '['
                    {
                    match(input,41,FOLLOW_41_in_ruleInterval3451); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1960:1: entryRuleCollectionOrTuple returns [EObject current=null] : iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF ;
    public final EObject entryRuleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionOrTuple = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1961:2: (iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1962:2: iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCollectionOrTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3488);
            iv_ruleCollectionOrTuple=ruleCollectionOrTuple();
            _fsp--;

             current =iv_ruleCollectionOrTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple3498); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1969:1: ruleCollectionOrTuple returns [EObject current=null] : ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) ;
    public final EObject ruleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValues_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1974:6: ( ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1975:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1975:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1975:3: '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}'
            {
            match(input,43,FOLLOW_43_in_ruleCollectionOrTuple3533); 

                    createLeafNode(grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1979:1: ( (lv_listOfValues_1_0= ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1980:1: (lv_listOfValues_1_0= ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1980:1: (lv_listOfValues_1_0= ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:1981:3: lv_listOfValues_1_0= ruleListOfValues
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3554);
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

            match(input,44,FOLLOW_44_in_ruleCollectionOrTuple3564); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2015:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2016:2: (iv_ruleTuple= ruleTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2017:2: iv_ruleTuple= ruleTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple3600);
            iv_ruleTuple=ruleTuple();
            _fsp--;

             current =iv_ruleTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple3610); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2024:1: ruleTuple returns [EObject current=null] : ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValueNamePairs_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2029:6: ( ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2030:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2030:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2030:3: '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}'
            {
            match(input,43,FOLLOW_43_in_ruleTuple3645); 

                    createLeafNode(grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2034:1: ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2035:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2035:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2036:3: lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3666);
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

            match(input,44,FOLLOW_44_in_ruleTuple3676); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2070:1: entryRuleListOfValues returns [EObject current=null] : iv_ruleListOfValues= ruleListOfValues EOF ;
    public final EObject entryRuleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValues = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2071:2: (iv_ruleListOfValues= ruleListOfValues EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2072:2: iv_ruleListOfValues= ruleListOfValues EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValuesRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues3712);
            iv_ruleListOfValues=ruleListOfValues();
            _fsp--;

             current =iv_ruleListOfValues; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues3722); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2079:1: ruleListOfValues returns [EObject current=null] : ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2084:6: ( ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2085:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2085:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2085:2: ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2085:2: ( (lv_values_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2086:1: (lv_values_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2086:1: (lv_values_0_0= ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2087:3: lv_values_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3768);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2109:2: ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==45) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2109:4: ',' ( (lv_values_2_0= ruleExpression ) )
            	    {
            	    match(input,45,FOLLOW_45_in_ruleListOfValues3779); 

            	            createLeafNode(grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2113:1: ( (lv_values_2_0= ruleExpression ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2114:1: (lv_values_2_0= ruleExpression )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2114:1: (lv_values_2_0= ruleExpression )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2115:3: lv_values_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3800);
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
            	    break loop27;
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2145:1: entryRuleListOfValueNamePairs returns [EObject current=null] : iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF ;
    public final EObject entryRuleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValueNamePairs = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2146:2: (iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2147:2: iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValueNamePairsRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3838);
            iv_ruleListOfValueNamePairs=ruleListOfValueNamePairs();
            _fsp--;

             current =iv_ruleListOfValueNamePairs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs3848); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2154:1: ruleListOfValueNamePairs returns [EObject current=null] : ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) ;
    public final EObject ruleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject lv_valueNamePairs_0_0 = null;

        EObject lv_valueNamePairs_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2159:6: ( ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2160:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2160:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2160:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2160:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2161:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2161:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2162:3: lv_valueNamePairs_0_0= ruleValueNamePair
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3894);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2184:2: ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==45) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2184:4: ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    {
            	    match(input,45,FOLLOW_45_in_ruleListOfValueNamePairs3905); 

            	            createLeafNode(grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2188:1: ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2189:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    {
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2189:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2190:3: lv_valueNamePairs_2_0= ruleValueNamePair
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3926);
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
            	    break loop28;
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2220:1: entryRuleValueNamePair returns [EObject current=null] : iv_ruleValueNamePair= ruleValueNamePair EOF ;
    public final EObject entryRuleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNamePair = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2221:2: (iv_ruleValueNamePair= ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2222:2: iv_ruleValueNamePair= ruleValueNamePair EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueNamePairRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair3964);
            iv_ruleValueNamePair=ruleValueNamePair();
            _fsp--;

             current =iv_ruleValueNamePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair3974); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2229:1: ruleValueNamePair returns [EObject current=null] : ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject lv_value_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2234:6: ( ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2235:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2235:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2235:2: ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2235:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2236:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2236:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2237:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getValueNamePairRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueNamePair4017); 

            		createLeafNode(grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            match(input,46,FOLLOW_46_in_ruleValueNamePair4027); 

                    createLeafNode(grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2253:1: ( (lv_value_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2254:1: (lv_value_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2254:1: (lv_value_2_0= ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2255:3: lv_value_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleValueNamePair4048);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2285:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2286:2: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2287:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4084);
            iv_ruleTimeExpression=ruleTimeExpression();
            _fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression4094); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2294:1: ruleTimeExpression returns [EObject current=null] : (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_InstantObsExpression_0 = null;

        EObject this_DurationObsExpression_1 = null;

        EObject this_JitterExp_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2299:6: ( (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2300:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2300:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt29=1;
                }
                break;
            case 49:
                {
                alt29=2;
                }
                break;
            case 50:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2300:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2301:5: this_InstantObsExpression_0= ruleInstantObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4141);
                    this_InstantObsExpression_0=ruleInstantObsExpression();
                    _fsp--;

                     
                            current = this_InstantObsExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2311:5: this_DurationObsExpression_1= ruleDurationObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4168);
                    this_DurationObsExpression_1=ruleDurationObsExpression();
                    _fsp--;

                     
                            current = this_DurationObsExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2321:5: this_JitterExp_2= ruleJitterExp
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJitterExp_in_ruleTimeExpression4195);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2337:1: entryRuleInstantObsExpression returns [EObject current=null] : iv_ruleInstantObsExpression= ruleInstantObsExpression EOF ;
    public final EObject entryRuleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2338:2: (iv_ruleInstantObsExpression= ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2339:2: iv_ruleInstantObsExpression= ruleInstantObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4230);
            iv_ruleInstantObsExpression=ruleInstantObsExpression();
            _fsp--;

             current =iv_ruleInstantObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression4240); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2346:1: ruleInstantObsExpression returns [EObject current=null] : ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2351:6: ( ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2352:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2352:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2352:3: '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,47,FOLLOW_47_in_ruleInstantObsExpression4275); 

                    createLeafNode(grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2356:1: ( (lv_id_1_0= ruleInstantObsName ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2357:1: (lv_id_1_0= ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2357:1: (lv_id_1_0= ruleInstantObsName )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2358:3: lv_id_1_0= ruleInstantObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4296);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2380:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==37) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2380:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,37,FOLLOW_37_in_ruleInstantObsExpression4307); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2384:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2385:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2385:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2386:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4328);
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

                    match(input,38,FOLLOW_38_in_ruleInstantObsExpression4338); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2412:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==48) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2412:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,48,FOLLOW_48_in_ruleInstantObsExpression4351); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,37,FOLLOW_37_in_ruleInstantObsExpression4361); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2420:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2421:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2421:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2422:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4382);
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

                    match(input,38,FOLLOW_38_in_ruleInstantObsExpression4392); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2456:1: entryRuleInstantObsName returns [EObject current=null] : iv_ruleInstantObsName= ruleInstantObsName EOF ;
    public final EObject entryRuleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsName = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2457:2: (iv_ruleInstantObsName= ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2458:2: iv_ruleInstantObsName= ruleInstantObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4430);
            iv_ruleInstantObsName=ruleInstantObsName();
            _fsp--;

             current =iv_ruleInstantObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName4440); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2465:1: ruleInstantObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2470:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2471:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2471:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2471:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2471:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==39) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2472:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2472:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2473:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstantObsName4486);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2495:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2496:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2496:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2497:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getInstantObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstantObsName4505); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2517:1: entryRuleDurationObsExpression returns [EObject current=null] : iv_ruleDurationObsExpression= ruleDurationObsExpression EOF ;
    public final EObject entryRuleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsExpression = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2518:2: (iv_ruleDurationObsExpression= ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2519:2: iv_ruleDurationObsExpression= ruleDurationObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4541);
            iv_ruleDurationObsExpression=ruleDurationObsExpression();
            _fsp--;

             current =iv_ruleDurationObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression4551); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2526:1: ruleDurationObsExpression returns [EObject current=null] : ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2531:6: ( ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2532:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2532:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2532:3: '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,49,FOLLOW_49_in_ruleDurationObsExpression4586); 

                    createLeafNode(grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2536:1: ( (lv_id_1_0= ruleDurationObsName ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2537:1: (lv_id_1_0= ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2537:1: (lv_id_1_0= ruleDurationObsName )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2538:3: lv_id_1_0= ruleDurationObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4607);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2560:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==37) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2560:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,37,FOLLOW_37_in_ruleDurationObsExpression4618); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2564:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2565:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2565:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2566:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4639);
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

                    match(input,38,FOLLOW_38_in_ruleDurationObsExpression4649); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2592:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==48) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2592:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,48,FOLLOW_48_in_ruleDurationObsExpression4662); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,37,FOLLOW_37_in_ruleDurationObsExpression4672); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2600:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2601:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2601:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2602:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4693);
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

                    match(input,38,FOLLOW_38_in_ruleDurationObsExpression4703); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2636:1: entryRuleDurationObsName returns [EObject current=null] : iv_ruleDurationObsName= ruleDurationObsName EOF ;
    public final EObject entryRuleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsName = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2637:2: (iv_ruleDurationObsName= ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2638:2: iv_ruleDurationObsName= ruleDurationObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4741);
            iv_ruleDurationObsName=ruleDurationObsName();
            _fsp--;

             current =iv_ruleDurationObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName4751); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2645:1: ruleDurationObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2650:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2651:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2651:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2651:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2651:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==39) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2652:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2652:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2653:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDurationObsName4797);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2675:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2676:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2676:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2677:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDurationObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDurationObsName4816); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2697:1: entryRuleJitterExp returns [EObject current=null] : iv_ruleJitterExp= ruleJitterExp EOF ;
    public final EObject entryRuleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJitterExp = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2698:2: (iv_ruleJitterExp= ruleJitterExp EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2699:2: iv_ruleJitterExp= ruleJitterExp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJitterExpRule(), currentNode); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp4852);
            iv_ruleJitterExp=ruleJitterExp();
            _fsp--;

             current =iv_ruleJitterExp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp4862); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2706:1: ruleJitterExp returns [EObject current=null] : ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) ;
    public final EObject ruleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject lv_firstInstant_1_0 = null;

        EObject lv_secondInstant_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2711:6: ( ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2712:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2712:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2712:3: 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')'
            {
            match(input,50,FOLLOW_50_in_ruleJitterExp4897); 

                    createLeafNode(grammarAccess.getJitterExpAccess().getJitterKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2716:1: ( (lv_firstInstant_1_0= ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2717:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2717:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2718:3: lv_firstInstant_1_0= ruleInstantObsExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4918);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2740:2: ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==31) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2740:4: '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    {
                    match(input,31,FOLLOW_31_in_ruleJitterExp4929); 

                            createLeafNode(grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2744:1: ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2745:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2745:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2746:3: lv_secondInstant_3_0= ruleInstantObsExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4950);
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

            match(input,38,FOLLOW_38_in_ruleJitterExp4962); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2780:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2781:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2782:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4998);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration5008); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2789:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        AntlrDatatypeRuleToken lv_variableDeclaration_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_initValue_7_0 = null;

        EObject lv_initValue_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2794:6: ( ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2795:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2795:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2795:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2795:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=52 && LA37_0<=54)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2796:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2796:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2797:3: lv_variableDeclaration_0_0= ruleVariableDirectionKind
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5054);
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

            match(input,51,FOLLOW_51_in_ruleVariableDeclaration5065); 

                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2823:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2824:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2824:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2825:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration5082); 

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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2847:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==29) ) {
                alt39=1;
            }
            else if ( (LA39_0==46) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2847:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2847:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2847:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2847:5: ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    {
                    match(input,29,FOLLOW_29_in_ruleVariableDeclaration5099); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2851:1: ( (lv_type_4_0= ruleDataTypeName ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2852:1: (lv_type_4_0= ruleDataTypeName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2852:1: (lv_type_4_0= ruleDataTypeName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2853:3: lv_type_4_0= ruleDataTypeName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5120);
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

                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2875:2: ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==46) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2875:4: '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')'
                            {
                            match(input,46,FOLLOW_46_in_ruleVariableDeclaration5131); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0(), null); 
                                
                            match(input,37,FOLLOW_37_in_ruleVariableDeclaration5141); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1(), null); 
                                
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2883:1: ( (lv_initValue_7_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2884:1: (lv_initValue_7_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2884:1: (lv_initValue_7_0= ruleExpression )
                            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2885:3: lv_initValue_7_0= ruleExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5162);
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

                            match(input,38,FOLLOW_38_in_ruleVariableDeclaration5172); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2912:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2912:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2912:8: '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')'
                    {
                    match(input,46,FOLLOW_46_in_ruleVariableDeclaration5192); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0(), null); 
                        
                    match(input,37,FOLLOW_37_in_ruleVariableDeclaration5202); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1(), null); 
                        
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2920:1: ( (lv_initValue_11_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2921:1: (lv_initValue_11_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2921:1: (lv_initValue_11_0= ruleExpression )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2922:3: lv_initValue_11_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5223);
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

                    match(input,38,FOLLOW_38_in_ruleVariableDeclaration5233); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2956:1: entryRuleVariableDirectionKind returns [String current=null] : iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF ;
    public final String entryRuleVariableDirectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableDirectionKind = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2957:2: (iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2958:2: iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDirectionKindRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5272);
            iv_ruleVariableDirectionKind=ruleVariableDirectionKind();
            _fsp--;

             current =iv_ruleVariableDirectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind5283); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2965:1: ruleVariableDirectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleVariableDirectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2970:6: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2971:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2971:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt40=1;
                }
                break;
            case 53:
                {
                alt40=2;
                }
                break;
            case 54:
                {
                alt40=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2971:1: (kw= 'in' | kw= 'out' | kw= 'inout' )", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2972:2: kw= 'in'
                    {
                    kw=(Token)input.LT(1);
                    match(input,52,FOLLOW_52_in_ruleVariableDirectionKind5321); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2979:2: kw= 'out'
                    {
                    kw=(Token)input.LT(1);
                    match(input,53,FOLLOW_53_in_ruleVariableDirectionKind5340); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2986:2: kw= 'inout'
                    {
                    kw=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleVariableDirectionKind5359); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:2999:1: entryRuleDataTypeName returns [EObject current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final EObject entryRuleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeName = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3000:2: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3001:2: iv_ruleDataTypeName= ruleDataTypeName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5399);
            iv_ruleDataTypeName=ruleDataTypeName();
            _fsp--;

             current =iv_ruleDataTypeName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName5409); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3008:1: ruleDataTypeName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3013:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3014:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3014:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3014:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3014:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==39) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3015:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3015:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3016:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDataTypeName5455);
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

            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3038:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3039:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3039:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3040:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDataTypeNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataTypeName5474); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3060:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3061:2: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3062:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumberLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5510);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();
            _fsp--;

             current =iv_ruleNumberLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule5520); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3069:1: ruleNumberLiteralRule returns [EObject current=null] : (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteralRule_0 = null;

        EObject this_UnlimitedLiteralRule_1 = null;

        EObject this_RealLiteralRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3074:6: ( (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3075:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3075:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            int alt42=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
                {
                alt42=1;
                }
                break;
            case 32:
                {
                alt42=2;
                }
                break;
            case RULE_REALLITERAL:
                {
                alt42=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3075:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3076:5: this_IntegerLiteralRule_0= ruleIntegerLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5567);
                    this_IntegerLiteralRule_0=ruleIntegerLiteralRule();
                    _fsp--;

                     
                            current = this_IntegerLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3086:5: this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5594);
                    this_UnlimitedLiteralRule_1=ruleUnlimitedLiteralRule();
                    _fsp--;

                     
                            current = this_UnlimitedLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3096:5: this_RealLiteralRule_2= ruleRealLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5621);
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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3112:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3113:2: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3114:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5656);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();
            _fsp--;

             current =iv_ruleIntegerLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule5666); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3121:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3126:6: ( ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3127:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3127:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3128:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3128:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3129:3: lv_value_0_0= RULE_INTEGERLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5707); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3159:1: entryRuleUnlimitedLiteralRule returns [EObject current=null] : iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF ;
    public final EObject entryRuleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3160:2: (iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3161:2: iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnlimitedLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5747);
            iv_ruleUnlimitedLiteralRule=ruleUnlimitedLiteralRule();
            _fsp--;

             current =iv_ruleUnlimitedLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5757); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3168:1: ruleUnlimitedLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '*' ) ) ;
    public final EObject ruleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3173:6: ( ( (lv_value_0_0= '*' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3174:1: ( (lv_value_0_0= '*' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3174:1: ( (lv_value_0_0= '*' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3175:1: (lv_value_0_0= '*' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3175:1: (lv_value_0_0= '*' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3176:3: lv_value_0_0= '*'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,32,FOLLOW_32_in_ruleUnlimitedLiteralRule5799); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3203:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3204:2: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3205:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5847);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();
            _fsp--;

             current =iv_ruleRealLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule5857); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3212:1: ruleRealLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_REALLITERAL ) ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3217:6: ( ( (lv_value_0_0= RULE_REALLITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3218:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3218:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3219:1: (lv_value_0_0= RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3219:1: (lv_value_0_0= RULE_REALLITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3220:3: lv_value_0_0= RULE_REALLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5898); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3250:1: entryRuleDateTimeLiteralRule returns [EObject current=null] : iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF ;
    public final EObject entryRuleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTimeLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3251:2: (iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3252:2: iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDateTimeLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5938);
            iv_ruleDateTimeLiteralRule=ruleDateTimeLiteralRule();
            _fsp--;

             current =iv_ruleDateTimeLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5948); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3259:1: ruleDateTimeLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) ;
    public final EObject ruleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3264:6: ( ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3265:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3265:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3266:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3266:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3267:3: lv_value_0_0= RULE_DATETIMELITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule5989); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3297:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3298:2: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3299:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6029);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();
            _fsp--;

             current =iv_ruleBooleanLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule6039); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3306:1: ruleBooleanLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3311:6: ( ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3312:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3312:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3313:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3313:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3314:3: lv_value_0_0= RULE_BOOLEANLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6080); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3344:1: entryRuleNullLiteralRule returns [EObject current=null] : iv_ruleNullLiteralRule= ruleNullLiteralRule EOF ;
    public final EObject entryRuleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3345:2: (iv_ruleNullLiteralRule= ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3346:2: iv_ruleNullLiteralRule= ruleNullLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6120);
            iv_ruleNullLiteralRule=ruleNullLiteralRule();
            _fsp--;

             current =iv_ruleNullLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule6130); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3353:1: ruleNullLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_NULLLITERAL ) ) ;
    public final EObject ruleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3358:6: ( ( (lv_value_0_0= RULE_NULLLITERAL ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3359:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3359:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3360:1: (lv_value_0_0= RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3360:1: (lv_value_0_0= RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3361:3: lv_value_0_0= RULE_NULLLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6171); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3391:1: entryRuleDefaultLiteralRule returns [EObject current=null] : iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF ;
    public final EObject entryRuleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3392:2: (iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3393:2: iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefaultLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6211);
            iv_ruleDefaultLiteralRule=ruleDefaultLiteralRule();
            _fsp--;

             current =iv_ruleDefaultLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule6221); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3400:1: ruleDefaultLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '/' ) ) ;
    public final EObject ruleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3405:6: ( ( (lv_value_0_0= '/' ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3406:1: ( (lv_value_0_0= '/' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3406:1: ( (lv_value_0_0= '/' ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3407:1: (lv_value_0_0= '/' )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3407:1: (lv_value_0_0= '/' )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3408:3: lv_value_0_0= '/'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,33,FOLLOW_33_in_ruleDefaultLiteralRule6263); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3435:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3436:2: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3437:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6311);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();
            _fsp--;

             current =iv_ruleStringLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule6321); 

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
    // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3444:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3449:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3450:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3450:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3451:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3451:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.marte.vsl/src-gen/org/eclipse/papyrus/marte/vsl/parser/antlr/internal/InternalVSL.g:3452:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteralRule6362); 

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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleModel131 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleContext_in_ruleModel152 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleModel163 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleModel184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleImport266 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContext_in_entryRuleContext324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContext334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleContext369 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContext387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_ruleExpression478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression569 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_19_in_ruleAndOrXorExpression590 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_20_in_ruleAndOrXorExpression619 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_21_in_ruleAndOrXorExpression648 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression685 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression779 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_22_in_ruleEqualityExpression800 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_23_in_ruleEqualityExpression829 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression866 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression960 = new BitSet(new long[]{0x000000000F000002L});
    public static final BitSet FOLLOW_24_in_ruleRelationalExpression981 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_25_in_ruleRelationalExpression1010 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_26_in_ruleRelationalExpression1039 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_27_in_ruleRelationalExpression1068 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1105 = new BitSet(new long[]{0x000000000F000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1199 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleConditionalExpression1218 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1252 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleConditionalExpression1262 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1377 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_30_in_ruleAdditiveExpression1398 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_31_in_ruleAdditiveExpression1427 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1464 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1558 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_32_in_ruleMultiplicativeExpression1579 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_33_in_ruleMultiplicativeExpression1608 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_34_in_ruleMultiplicativeExpression1637 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1674 = new BitSet(new long[]{0x0000000700000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleUnaryExpression1768 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_31_in_ruleUnaryExpression1797 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_30_in_ruleUnaryExpression1826 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rulePrimaryExpression1983 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_rulePrimaryExpression1994 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleValueSpecification2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleValueSpecification2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleValueSpecification2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleValueSpecification2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleValueSpecification2288 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueSpecification2310 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleValueSpecification2319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2356 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression2485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyCallExpression2528 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_rulePropertyCallExpression2539 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpression2651 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleOperationCallExpression2661 = new BitSet(new long[]{0x007E8B6BC00007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2682 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleOperationCallExpression2693 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleOperationCallExpression2704 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_ruleLiteral2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_ruleLiteral2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall2990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3046 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3065 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleNameOrChoiceOrBehaviorCall3076 = new BitSet(new long[]{0x007E8B6BC00007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3097 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleNameOrChoiceOrBehaviorCall3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3199 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleQualifiedName3209 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval3267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleInterval3313 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_41_in_ruleInterval3337 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3372 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleInterval3382 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3403 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_40_in_ruleInterval3422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleInterval3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleCollectionOrTuple3533 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3554 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleCollectionOrTuple3564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple3600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleTuple3645 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3666 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleTuple3676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues3712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3768 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleListOfValues3779 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3800 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3894 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleListOfValueNamePairs3905 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3926 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair3964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueNamePair4017 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleValueNamePair4027 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueNamePair4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_ruleTimeExpression4195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression4240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleInstantObsExpression4275 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4296 = new BitSet(new long[]{0x0001002000000002L});
    public static final BitSet FOLLOW_37_in_ruleInstantObsExpression4307 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4328 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleInstantObsExpression4338 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_ruleInstantObsExpression4351 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleInstantObsExpression4361 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4382 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleInstantObsExpression4392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName4440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstantObsName4486 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstantObsName4505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression4551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleDurationObsExpression4586 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4607 = new BitSet(new long[]{0x0001002000000002L});
    public static final BitSet FOLLOW_37_in_ruleDurationObsExpression4618 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4639 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleDurationObsExpression4649 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_ruleDurationObsExpression4662 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleDurationObsExpression4672 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4693 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleDurationObsExpression4703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName4751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDurationObsName4797 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDurationObsName4816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp4852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp4862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleJitterExp4897 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4918 = new BitSet(new long[]{0x0000004080000000L});
    public static final BitSet FOLLOW_31_in_ruleJitterExp4929 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4950 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleJitterExp4962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration5008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5054 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleVariableDeclaration5065 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration5082 = new BitSet(new long[]{0x0000400020000000L});
    public static final BitSet FOLLOW_29_in_ruleVariableDeclaration5099 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5120 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleVariableDeclaration5131 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleVariableDeclaration5141 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5162 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleVariableDeclaration5172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleVariableDeclaration5192 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleVariableDeclaration5202 = new BitSet(new long[]{0x007E8B2BC00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5223 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleVariableDeclaration5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind5283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleVariableDirectionKind5321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleVariableDirectionKind5340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleVariableDirectionKind5359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDataTypeName5455 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeName5474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule5520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule5666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5747 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleUnlimitedLiteralRule5799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule5857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5938 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule5989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule6039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule6130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule6221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleDefaultLiteralRule6263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule6321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteralRule6362 = new BitSet(new long[]{0x0000000000000002L});

}