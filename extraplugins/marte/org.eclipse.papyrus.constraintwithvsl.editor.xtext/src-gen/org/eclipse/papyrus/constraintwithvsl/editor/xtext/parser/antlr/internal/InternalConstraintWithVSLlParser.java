package org.eclipse.papyrus.constraintwithvsl.editor.xtext.parser.antlr.internal; 

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
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.services.ConstraintWithVSLlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConstraintWithVSLlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INTEGERLITERAL", "RULE_REALLITERAL", "RULE_DATETIMELITERAL", "RULE_BOOLEANLITERAL", "RULE_NULLLITERAL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'context'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'?'", "':'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'not'", "'.'", "'('", "')'", "'::'", "']'", "'['", "'..'", "'{'", "'}'", "','", "'='", "'@'", "'when'", "'&'", "'jitter('", "'$'", "'in'", "'out'", "'inout'"
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

        public InternalConstraintWithVSLlParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g"; }



     	private ConstraintWithVSLlGrammarAccess grammarAccess;
     	
        public InternalConstraintWithVSLlParser(TokenStream input, IAstFactory factory, ConstraintWithVSLlGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ConstraintRule";	
       	}
       	
       	@Override
       	protected ConstraintWithVSLlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleConstraintRule
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:77:1: entryRuleConstraintRule returns [EObject current=null] : iv_ruleConstraintRule= ruleConstraintRule EOF ;
    public final EObject entryRuleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:78:2: (iv_ruleConstraintRule= ruleConstraintRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:79:2: iv_ruleConstraintRule= ruleConstraintRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConstraintRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleConstraintRule_in_entryRuleConstraintRule75);
            iv_ruleConstraintRule=ruleConstraintRule();
            _fsp--;

             current =iv_ruleConstraintRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintRule85); 

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
    // $ANTLR end entryRuleConstraintRule


    // $ANTLR start ruleConstraintRule
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:86:1: ruleConstraintRule returns [EObject current=null] : ( (lv_specification_0_0= ruleConstraintSpecification ) )? ;
    public final EObject ruleConstraintRule() throws RecognitionException {
        EObject current = null;

        EObject lv_specification_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:91:6: ( ( (lv_specification_0_0= ruleConstraintSpecification ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:92:1: ( (lv_specification_0_0= ruleConstraintSpecification ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:92:1: ( (lv_specification_0_0= ruleConstraintSpecification ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_NULLLITERAL)||(LA1_0>=29 && LA1_0<=32)||LA1_0==34||LA1_0==36||(LA1_0>=39 && LA1_0<=40)||LA1_0==42||LA1_0==46||(LA1_0>=48 && LA1_0<=53)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:93:1: (lv_specification_0_0= ruleConstraintSpecification )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:93:1: (lv_specification_0_0= ruleConstraintSpecification )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:94:3: lv_specification_0_0= ruleConstraintSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConstraintRuleAccess().getSpecificationConstraintSpecificationParserRuleCall_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleConstraintSpecification_in_ruleConstraintRule130);
                    lv_specification_0_0=ruleConstraintSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getConstraintRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"specification",
                    	        		lv_specification_0_0, 
                    	        		"ConstraintSpecification", 
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
    // $ANTLR end ruleConstraintRule


    // $ANTLR start entryRuleConstraintSpecification
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:124:1: entryRuleConstraintSpecification returns [EObject current=null] : iv_ruleConstraintSpecification= ruleConstraintSpecification EOF ;
    public final EObject entryRuleConstraintSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintSpecification = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:125:2: (iv_ruleConstraintSpecification= ruleConstraintSpecification EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:126:2: iv_ruleConstraintSpecification= ruleConstraintSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConstraintSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleConstraintSpecification_in_entryRuleConstraintSpecification166);
            iv_ruleConstraintSpecification=ruleConstraintSpecification();
            _fsp--;

             current =iv_ruleConstraintSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintSpecification176); 

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
    // $ANTLR end entryRuleConstraintSpecification


    // $ANTLR start ruleConstraintSpecification
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:133:1: ruleConstraintSpecification returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) ) ;
    public final EObject ruleConstraintSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:138:6: ( ( (lv_expression_0_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:139:1: ( (lv_expression_0_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:139:1: ( (lv_expression_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:140:1: (lv_expression_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:140:1: (lv_expression_0_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:141:3: lv_expression_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConstraintSpecificationAccess().getExpressionExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleConstraintSpecification221);
            lv_expression_0_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConstraintSpecificationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_0_0, 
            	        		"Expression", 
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
    // $ANTLR end ruleConstraintSpecification


    // $ANTLR start entryRuleImport
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:173:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:174:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:175:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport258);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport268); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:182:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:187:6: ( ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:188:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:188:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:188:3: 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            match(input,16,FOLLOW_16_in_ruleImport303); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:192:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:193:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:193:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:194:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport320); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:224:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:225:2: (iv_ruleContext= ruleContext EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:226:2: iv_ruleContext= ruleContext EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContextRule(), currentNode); 
            pushFollow(FOLLOW_ruleContext_in_entryRuleContext361);
            iv_ruleContext=ruleContext();
            _fsp--;

             current =iv_ruleContext; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContext371); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:233:1: ruleContext returns [EObject current=null] : ( 'context' ( ( RULE_ID ) ) ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:238:6: ( ( 'context' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:239:1: ( 'context' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:239:1: ( 'context' ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:239:3: 'context' ( ( RULE_ID ) )
            {
            match(input,17,FOLLOW_17_in_ruleContext406); 

                    createLeafNode(grammarAccess.getContextAccess().getContextKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:243:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:244:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:244:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:245:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getContextRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContext424); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:265:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:266:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:267:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression460);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression470); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:274:1: ruleExpression returns [EObject current=null] : ( (lv_exp_0_0= ruleAndOrXorExpression ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:279:6: ( ( (lv_exp_0_0= ruleAndOrXorExpression ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:280:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:280:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:281:1: (lv_exp_0_0= ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:281:1: (lv_exp_0_0= ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:282:3: lv_exp_0_0= ruleAndOrXorExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_ruleExpression515);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:312:1: entryRuleAndOrXorExpression returns [EObject current=null] : iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF ;
    public final EObject entryRuleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrXorExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:313:2: (iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:314:2: iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndOrXorExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression550);
            iv_ruleAndOrXorExpression=ruleAndOrXorExpression();
            _fsp--;

             current =iv_ruleAndOrXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression560); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:321:1: ruleAndOrXorExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:326:6: ( ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:327:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:327:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:327:2: ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:327:2: ( (lv_exp_0_0= ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:328:1: (lv_exp_0_0= ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:328:1: (lv_exp_0_0= ruleEqualityExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:329:3: lv_exp_0_0= ruleEqualityExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression606);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:351:2: ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=18 && LA3_0<=20)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:351:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:351:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:352:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:352:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:353:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:353:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case 18:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 20:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("353:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:354:3: lv_op_1_1= 'and'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,18,FOLLOW_18_in_ruleAndOrXorExpression627); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:372:8: lv_op_1_2= 'or'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,19,FOLLOW_19_in_ruleAndOrXorExpression656); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:390:8: lv_op_1_3= 'xor'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,20,FOLLOW_20_in_ruleAndOrXorExpression685); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:411:2: ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:412:1: (lv_exp_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:412:1: (lv_exp_2_0= ruleEqualityExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:413:3: lv_exp_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression722);
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
            	    break loop3;
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:443:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:444:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:445:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression760);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression770); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:452:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:457:6: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:458:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:458:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:458:2: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:458:2: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:459:1: (lv_exp_0_0= ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:459:1: (lv_exp_0_0= ruleRelationalExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:460:3: lv_exp_0_0= ruleRelationalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression816);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:482:2: ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=21 && LA5_0<=22)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:482:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:482:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:483:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:483:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:484:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:484:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==21) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==22) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("484:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:485:3: lv_op_1_1= '=='
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,21,FOLLOW_21_in_ruleEqualityExpression837); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:503:8: lv_op_1_2= '<>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,22,FOLLOW_22_in_ruleEqualityExpression866); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:524:2: ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:525:1: (lv_exp_2_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:525:1: (lv_exp_2_0= ruleRelationalExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:526:3: lv_exp_2_0= ruleRelationalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression903);
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
    // $ANTLR end ruleEqualityExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:556:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:557:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:558:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression941);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression951); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:565:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:570:6: ( ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:571:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:571:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:571:2: ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:571:2: ( (lv_exp_0_0= ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:572:1: (lv_exp_0_0= ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:572:1: (lv_exp_0_0= ruleConditionalExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:573:3: lv_exp_0_0= ruleConditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression997);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:595:2: ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=23 && LA7_0<=26)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:595:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:595:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:596:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:596:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:597:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:597:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    int alt6=4;
            	    switch ( input.LA(1) ) {
            	    case 23:
            	        {
            	        alt6=1;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt6=2;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt6=3;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt6=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("597:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )", 6, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:598:3: lv_op_1_1= '<'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,23,FOLLOW_23_in_ruleRelationalExpression1018); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:616:8: lv_op_1_2= '>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,24,FOLLOW_24_in_ruleRelationalExpression1047); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:634:8: lv_op_1_3= '<='
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,25,FOLLOW_25_in_ruleRelationalExpression1076); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:652:8: lv_op_1_4= '>='
            	            {
            	            lv_op_1_4=(Token)input.LT(1);
            	            match(input,26,FOLLOW_26_in_ruleRelationalExpression1105); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:673:2: ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:674:1: (lv_exp_2_0= ruleConditionalExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:674:1: (lv_exp_2_0= ruleConditionalExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:675:3: lv_exp_2_0= ruleConditionalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1142);
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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleConditionalExpression
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:705:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:706:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:707:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1180);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression1190); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:714:1: ruleConditionalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;

        EObject lv_exp_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:719:6: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:720:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:720:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:720:2: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:720:2: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:721:1: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:721:1: (lv_exp_0_0= ruleAdditiveExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:722:3: lv_exp_0_0= ruleAdditiveExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1236);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:744:2: ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:744:3: ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:744:3: ( (lv_op_1_0= '?' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:745:1: (lv_op_1_0= '?' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:745:1: (lv_op_1_0= '?' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:746:3: lv_op_1_0= '?'
                    {
                    lv_op_1_0=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleConditionalExpression1255); 

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

                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:765:2: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:766:1: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:766:1: (lv_exp_2_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:767:3: lv_exp_2_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1289);
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

                    match(input,28,FOLLOW_28_in_ruleConditionalExpression1299); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:793:1: ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:794:1: (lv_exp_4_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:794:1: (lv_exp_4_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:795:3: lv_exp_4_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1320);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:825:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:826:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:827:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1358);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1368); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:834:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:839:6: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:840:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:840:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:840:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:840:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:841:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:841:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:842:3: lv_exp_0_0= ruleMultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1414);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:864:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=29 && LA10_0<=30)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:864:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:864:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:865:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:865:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:866:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:866:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==29) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==30) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("866:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:867:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,29,FOLLOW_29_in_ruleAdditiveExpression1435); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:885:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,30,FOLLOW_30_in_ruleAdditiveExpression1464); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:906:2: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:907:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:907:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:908:3: lv_exp_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1501);
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
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:938:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:939:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:940:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1539);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression1549); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:947:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:952:6: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:953:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:953:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:953:2: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:953:2: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:954:1: (lv_exp_0_0= ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:954:1: (lv_exp_0_0= ruleUnaryExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:955:3: lv_exp_0_0= ruleUnaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1595);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:977:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=31 && LA12_0<=33)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:977:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:977:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:978:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:978:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:979:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:979:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    int alt11=3;
            	    switch ( input.LA(1) ) {
            	    case 31:
            	        {
            	        alt11=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt11=2;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt11=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("979:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )", 11, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt11) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:980:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,31,FOLLOW_31_in_ruleMultiplicativeExpression1616); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:998:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,32,FOLLOW_32_in_ruleMultiplicativeExpression1645); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1016:8: lv_op_1_3= 'mod'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,33,FOLLOW_33_in_ruleMultiplicativeExpression1674); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1037:2: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1038:1: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1038:1: (lv_exp_2_0= ruleUnaryExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1039:3: lv_exp_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1711);
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
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleUnaryExpression
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1069:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1070:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1071:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1749);
            iv_ruleUnaryExpression=ruleUnaryExpression();
            _fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression1759); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1078:1: ruleUnaryExpression returns [EObject current=null] : ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        EObject lv_unary_1_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1083:6: ( ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1084:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1084:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=29 && LA14_0<=30)||LA14_0==34) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_NULLLITERAL)||(LA14_0>=31 && LA14_0<=32)||LA14_0==36||(LA14_0>=39 && LA14_0<=40)||LA14_0==42||LA14_0==46||(LA14_0>=48 && LA14_0<=53)) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1084:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1084:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1084:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1084:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1084:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1085:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1085:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1086:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1086:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    int alt13=3;
                    switch ( input.LA(1) ) {
                    case 34:
                        {
                        alt13=1;
                        }
                        break;
                    case 30:
                        {
                        alt13=2;
                        }
                        break;
                    case 29:
                        {
                        alt13=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("1086:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )", 13, 0, input);

                        throw nvae;
                    }

                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1087:3: lv_op_0_1= 'not'
                            {
                            lv_op_0_1=(Token)input.LT(1);
                            match(input,34,FOLLOW_34_in_ruleUnaryExpression1805); 

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
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1105:8: lv_op_0_2= '-'
                            {
                            lv_op_0_2=(Token)input.LT(1);
                            match(input,30,FOLLOW_30_in_ruleUnaryExpression1834); 

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
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1123:8: lv_op_0_3= '+'
                            {
                            lv_op_0_3=(Token)input.LT(1);
                            match(input,29,FOLLOW_29_in_ruleUnaryExpression1863); 

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

                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1144:2: ( (lv_unary_1_0= ruleUnaryExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1145:1: (lv_unary_1_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1145:1: (lv_unary_1_0= ruleUnaryExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1146:3: lv_unary_1_0= ruleUnaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1900);
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
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1169:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1169:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1170:1: (lv_exp_2_0= rulePrimaryExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1170:1: (lv_exp_2_0= rulePrimaryExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1171:3: lv_exp_2_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1928);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1201:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1202:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1203:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1964);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1974); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1210:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_prefix_0_0 = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1215:6: ( ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1216:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1216:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1216:2: ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1216:2: ( (lv_prefix_0_0= ruleValueSpecification ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1217:1: (lv_prefix_0_0= ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1217:1: (lv_prefix_0_0= ruleValueSpecification )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1218:3: lv_prefix_0_0= ruleValueSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueSpecification_in_rulePrimaryExpression2020);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1240:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1240:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,35,FOLLOW_35_in_rulePrimaryExpression2031); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1244:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1245:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1245:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1246:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2052);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1276:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1277:2: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1278:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2090);
            iv_ruleValueSpecification=ruleValueSpecification();
            _fsp--;

             current =iv_ruleValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification2100); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1285:1: ruleValueSpecification returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1290:6: ( (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1291:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1291:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            int alt16=8;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case RULE_DATETIMELITERAL:
            case RULE_BOOLEANLITERAL:
            case RULE_NULLLITERAL:
            case 31:
            case 32:
                {
                alt16=1;
                }
                break;
            case RULE_ID:
                {
                alt16=2;
                }
                break;
            case 39:
            case 40:
                {
                alt16=3;
                }
                break;
            case 42:
                {
                int LA16_4 = input.LA(2);

                if ( (LA16_4==RULE_STRING||(LA16_4>=RULE_INTEGERLITERAL && LA16_4<=RULE_NULLLITERAL)||(LA16_4>=29 && LA16_4<=32)||LA16_4==34||LA16_4==36||(LA16_4>=39 && LA16_4<=40)||LA16_4==42||LA16_4==46||(LA16_4>=48 && LA16_4<=53)) ) {
                    alt16=4;
                }
                else if ( (LA16_4==RULE_ID) ) {
                    int LA16_9 = input.LA(3);

                    if ( (LA16_9==45) ) {
                        alt16=5;
                    }
                    else if ( ((LA16_9>=18 && LA16_9<=27)||(LA16_9>=29 && LA16_9<=33)||(LA16_9>=35 && LA16_9<=36)||LA16_9==38||(LA16_9>=43 && LA16_9<=44)) ) {
                        alt16=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1291:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 16, 9, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1291:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 16, 4, input);

                    throw nvae;
                }
                }
                break;
            case 46:
            case 48:
            case 49:
                {
                alt16=6;
                }
                break;
            case 50:
            case 51:
            case 52:
            case 53:
                {
                alt16=7;
                }
                break;
            case 36:
                {
                alt16=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1291:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1292:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleValueSpecification2147);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1302:5: this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2174);
                    this_NameOrChoiceOrBehaviorCall_1=ruleNameOrChoiceOrBehaviorCall();
                    _fsp--;

                     
                            current = this_NameOrChoiceOrBehaviorCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1312:5: this_Interval_2= ruleInterval
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInterval_in_ruleValueSpecification2201);
                    this_Interval_2=ruleInterval();
                    _fsp--;

                     
                            current = this_Interval_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1322:5: this_CollectionOrTuple_3= ruleCollectionOrTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2228);
                    this_CollectionOrTuple_3=ruleCollectionOrTuple();
                    _fsp--;

                     
                            current = this_CollectionOrTuple_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1332:5: this_Tuple_4= ruleTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTuple_in_ruleValueSpecification2255);
                    this_Tuple_4=ruleTuple();
                    _fsp--;

                     
                            current = this_Tuple_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1342:5: this_TimeExpression_5= ruleTimeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeExpression_in_ruleValueSpecification2282);
                    this_TimeExpression_5=ruleTimeExpression();
                    _fsp--;

                     
                            current = this_TimeExpression_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1352:5: this_VariableDeclaration_6= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2309);
                    this_VariableDeclaration_6=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1361:6: ( '(' this_Expression_8= ruleExpression ')' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1361:6: ( '(' this_Expression_8= ruleExpression ')' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1361:8: '(' this_Expression_8= ruleExpression ')'
                    {
                    match(input,36,FOLLOW_36_in_ruleValueSpecification2325); 

                            createLeafNode(grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleValueSpecification2347);
                    this_Expression_8=ruleExpression();
                    _fsp--;

                     
                            current = this_Expression_8; 
                            currentNode = currentNode.getParent();
                        
                    match(input,37,FOLLOW_37_in_ruleValueSpecification2356); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1386:1: entryRuleSuffixExpression returns [EObject current=null] : iv_ruleSuffixExpression= ruleSuffixExpression EOF ;
    public final EObject entryRuleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuffixExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1387:2: (iv_ruleSuffixExpression= ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1388:2: iv_ruleSuffixExpression= ruleSuffixExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuffixExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2393);
            iv_ruleSuffixExpression=ruleSuffixExpression();
            _fsp--;

             current =iv_ruleSuffixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression2403); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1395:1: ruleSuffixExpression returns [EObject current=null] : (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) ;
    public final EObject ruleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyCallExpression_0 = null;

        EObject this_OperationCallExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1400:6: ( (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1401:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1401:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==36) ) {
                    alt17=2;
                }
                else if ( (LA17_1==EOF||(LA17_1>=18 && LA17_1<=33)||LA17_1==35||LA17_1==37||(LA17_1>=39 && LA17_1<=41)||(LA17_1>=43 && LA17_1<=44)) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1401:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1401:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1402:5: this_PropertyCallExpression_0= rulePropertyCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2450);
                    this_PropertyCallExpression_0=rulePropertyCallExpression();
                    _fsp--;

                     
                            current = this_PropertyCallExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1412:5: this_OperationCallExpression_1= ruleOperationCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2477);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1428:1: entryRulePropertyCallExpression returns [EObject current=null] : iv_rulePropertyCallExpression= rulePropertyCallExpression EOF ;
    public final EObject entryRulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCallExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1429:2: (iv_rulePropertyCallExpression= rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1430:2: iv_rulePropertyCallExpression= rulePropertyCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2512);
            iv_rulePropertyCallExpression=rulePropertyCallExpression();
            _fsp--;

             current =iv_rulePropertyCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression2522); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1437:1: rulePropertyCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1442:6: ( ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1443:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1443:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1443:2: ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1443:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1444:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1444:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1445:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyCallExpression2565); 

            		createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1457:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==35) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1457:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,35,FOLLOW_35_in_rulePropertyCallExpression2576); 

                            createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1461:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1462:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1462:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1463:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2597);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1493:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1494:2: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1495:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2635);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();
            _fsp--;

             current =iv_ruleOperationCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression2645); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1502:1: ruleOperationCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject ruleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_suffix_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1507:6: ( ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1508:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1508:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1508:2: ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1508:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1509:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1509:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1510:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getOperationCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpression2688); 

            		createLeafNode(grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0(), "operation"); 
            	

            }


            }

            match(input,36,FOLLOW_36_in_ruleOperationCallExpression2698); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1526:1: ( (lv_arguments_2_0= ruleListOfValues ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_NULLLITERAL)||(LA19_0>=29 && LA19_0<=32)||LA19_0==34||LA19_0==36||(LA19_0>=39 && LA19_0<=40)||LA19_0==42||LA19_0==46||(LA19_0>=48 && LA19_0<=53)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1527:1: (lv_arguments_2_0= ruleListOfValues )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1527:1: (lv_arguments_2_0= ruleListOfValues )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1528:3: lv_arguments_2_0= ruleListOfValues
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2719);
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

            match(input,37,FOLLOW_37_in_ruleOperationCallExpression2730); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1554:1: ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==35) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1554:3: '.' ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    {
                    match(input,35,FOLLOW_35_in_ruleOperationCallExpression2741); 

                            createLeafNode(grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1558:1: ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1559:1: (lv_suffix_5_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1559:1: (lv_suffix_5_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1560:3: lv_suffix_5_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2762);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1590:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1591:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1592:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2800);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2810); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1599:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1604:6: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1605:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1605:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            int alt21=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case 31:
                {
                alt21=1;
                }
                break;
            case RULE_DATETIMELITERAL:
                {
                alt21=2;
                }
                break;
            case RULE_BOOLEANLITERAL:
                {
                alt21=3;
                }
                break;
            case RULE_NULLLITERAL:
                {
                alt21=4;
                }
                break;
            case 32:
                {
                alt21=5;
                }
                break;
            case RULE_STRING:
                {
                alt21=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1605:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1606:5: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2857);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();
                    _fsp--;

                     
                            current = this_NumberLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1616:5: this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2884);
                    this_DateTimeLiteralRule_1=ruleDateTimeLiteralRule();
                    _fsp--;

                     
                            current = this_DateTimeLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1626:5: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2911);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();
                    _fsp--;

                     
                            current = this_BooleanLiteralRule_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1636:5: this_NullLiteralRule_3= ruleNullLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_ruleLiteral2938);
                    this_NullLiteralRule_3=ruleNullLiteralRule();
                    _fsp--;

                     
                            current = this_NullLiteralRule_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1646:5: this_DefaultLiteralRule_4= ruleDefaultLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2965);
                    this_DefaultLiteralRule_4=ruleDefaultLiteralRule();
                    _fsp--;

                     
                            current = this_DefaultLiteralRule_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1656:5: this_StringLiteralRule_5= ruleStringLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_ruleLiteral2992);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1672:1: entryRuleNameOrChoiceOrBehaviorCall returns [EObject current=null] : iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF ;
    public final EObject entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrChoiceOrBehaviorCall = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1673:2: (iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1674:2: iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall3027);
            iv_ruleNameOrChoiceOrBehaviorCall=ruleNameOrChoiceOrBehaviorCall();
            _fsp--;

             current =iv_ruleNameOrChoiceOrBehaviorCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3037); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1681:1: ruleNameOrChoiceOrBehaviorCall returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) ;
    public final EObject ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;

        EObject lv_arguments_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1686:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1687:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1687:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1687:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1687:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==38) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1688:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1688:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1689:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3083);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1711:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1712:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1712:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1713:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNameOrChoiceOrBehaviorCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3102); 

            		createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0(), "id"); 
            	

            }


            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1725:2: ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1725:4: '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')'
                    {
                    match(input,36,FOLLOW_36_in_ruleNameOrChoiceOrBehaviorCall3113); 

                            createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1729:1: ( (lv_arguments_3_0= ruleListOfValues ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( ((LA23_0>=RULE_STRING && LA23_0<=RULE_NULLLITERAL)||(LA23_0>=29 && LA23_0<=32)||LA23_0==34||LA23_0==36||(LA23_0>=39 && LA23_0<=40)||LA23_0==42||LA23_0==46||(LA23_0>=48 && LA23_0<=53)) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1730:1: (lv_arguments_3_0= ruleListOfValues )
                            {
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1730:1: (lv_arguments_3_0= ruleListOfValues )
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1731:3: lv_arguments_3_0= ruleListOfValues
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3134);
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

                    match(input,37,FOLLOW_37_in_ruleNameOrChoiceOrBehaviorCall3145); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1765:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1766:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1767:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3183);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3193); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1774:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1779:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1780:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1780:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1780:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1780:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1781:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1781:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1782:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3236); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,38,FOLLOW_38_in_ruleQualifiedName3246); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1798:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==38) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1799:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1799:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1800:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName3267);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1830:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1831:2: (iv_ruleInterval= ruleInterval EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1832:2: iv_ruleInterval= ruleInterval EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntervalRule(), currentNode); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval3304);
            iv_ruleInterval=ruleInterval();
            _fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval3314); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1839:1: ruleInterval returns [EObject current=null] : ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token lv_isLowerIncluded_1_0=null;
        Token lv_isUpperIncluded_5_0=null;
        EObject lv_lower_2_0 = null;

        EObject lv_upper_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1844:6: ( ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1845:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1845:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1845:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1845:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==39) ) {
                alt26=1;
            }
            else if ( (LA26_0==40) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1845:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1845:4: ']'
                    {
                    match(input,39,FOLLOW_39_in_ruleInterval3350); 

                            createLeafNode(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1850:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1850:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1851:1: (lv_isLowerIncluded_1_0= '[' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1851:1: (lv_isLowerIncluded_1_0= '[' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1852:3: lv_isLowerIncluded_1_0= '['
                    {
                    lv_isLowerIncluded_1_0=(Token)input.LT(1);
                    match(input,40,FOLLOW_40_in_ruleInterval3374); 

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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1871:3: ( (lv_lower_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1872:1: (lv_lower_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1872:1: (lv_lower_2_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1873:3: lv_lower_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3409);
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

            match(input,41,FOLLOW_41_in_ruleInterval3419); 

                    createLeafNode(grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1899:1: ( (lv_upper_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1900:1: (lv_upper_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1900:1: (lv_upper_4_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1901:3: lv_upper_4_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3440);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1923:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==39) ) {
                alt27=1;
            }
            else if ( (LA27_0==40) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1923:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1923:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1923:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1924:1: (lv_isUpperIncluded_5_0= ']' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1924:1: (lv_isUpperIncluded_5_0= ']' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1925:3: lv_isUpperIncluded_5_0= ']'
                    {
                    lv_isUpperIncluded_5_0=(Token)input.LT(1);
                    match(input,39,FOLLOW_39_in_ruleInterval3459); 

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
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1945:7: '['
                    {
                    match(input,40,FOLLOW_40_in_ruleInterval3488); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1957:1: entryRuleCollectionOrTuple returns [EObject current=null] : iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF ;
    public final EObject entryRuleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionOrTuple = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1958:2: (iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1959:2: iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCollectionOrTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3525);
            iv_ruleCollectionOrTuple=ruleCollectionOrTuple();
            _fsp--;

             current =iv_ruleCollectionOrTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple3535); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1966:1: ruleCollectionOrTuple returns [EObject current=null] : ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) ;
    public final EObject ruleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValues_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1971:6: ( ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1972:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1972:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1972:3: '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}'
            {
            match(input,42,FOLLOW_42_in_ruleCollectionOrTuple3570); 

                    createLeafNode(grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1976:1: ( (lv_listOfValues_1_0= ruleListOfValues ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1977:1: (lv_listOfValues_1_0= ruleListOfValues )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1977:1: (lv_listOfValues_1_0= ruleListOfValues )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1978:3: lv_listOfValues_1_0= ruleListOfValues
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3591);
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

            match(input,43,FOLLOW_43_in_ruleCollectionOrTuple3601); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2012:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2013:2: (iv_ruleTuple= ruleTuple EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2014:2: iv_ruleTuple= ruleTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple3637);
            iv_ruleTuple=ruleTuple();
            _fsp--;

             current =iv_ruleTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple3647); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2021:1: ruleTuple returns [EObject current=null] : ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValueNamePairs_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2026:6: ( ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2027:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2027:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2027:3: '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}'
            {
            match(input,42,FOLLOW_42_in_ruleTuple3682); 

                    createLeafNode(grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2031:1: ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2032:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2032:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2033:3: lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3703);
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

            match(input,43,FOLLOW_43_in_ruleTuple3713); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2067:1: entryRuleListOfValues returns [EObject current=null] : iv_ruleListOfValues= ruleListOfValues EOF ;
    public final EObject entryRuleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValues = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2068:2: (iv_ruleListOfValues= ruleListOfValues EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2069:2: iv_ruleListOfValues= ruleListOfValues EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValuesRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues3749);
            iv_ruleListOfValues=ruleListOfValues();
            _fsp--;

             current =iv_ruleListOfValues; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues3759); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2076:1: ruleListOfValues returns [EObject current=null] : ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2081:6: ( ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2082:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2082:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2082:2: ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2082:2: ( (lv_values_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2083:1: (lv_values_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2083:1: (lv_values_0_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2084:3: lv_values_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3805);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2106:2: ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==44) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2106:4: ',' ( (lv_values_2_0= ruleExpression ) )
            	    {
            	    match(input,44,FOLLOW_44_in_ruleListOfValues3816); 

            	            createLeafNode(grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2110:1: ( (lv_values_2_0= ruleExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2111:1: (lv_values_2_0= ruleExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2111:1: (lv_values_2_0= ruleExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2112:3: lv_values_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3837);
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
    // $ANTLR end ruleListOfValues


    // $ANTLR start entryRuleListOfValueNamePairs
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2142:1: entryRuleListOfValueNamePairs returns [EObject current=null] : iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF ;
    public final EObject entryRuleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValueNamePairs = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2143:2: (iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2144:2: iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValueNamePairsRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3875);
            iv_ruleListOfValueNamePairs=ruleListOfValueNamePairs();
            _fsp--;

             current =iv_ruleListOfValueNamePairs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs3885); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2151:1: ruleListOfValueNamePairs returns [EObject current=null] : ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) ;
    public final EObject ruleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject lv_valueNamePairs_0_0 = null;

        EObject lv_valueNamePairs_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2156:6: ( ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2157:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2157:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2157:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2157:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2158:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2158:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2159:3: lv_valueNamePairs_0_0= ruleValueNamePair
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3931);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2181:2: ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==44) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2181:4: ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    {
            	    match(input,44,FOLLOW_44_in_ruleListOfValueNamePairs3942); 

            	            createLeafNode(grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2185:1: ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2186:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2186:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2187:3: lv_valueNamePairs_2_0= ruleValueNamePair
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3963);
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
            	    break loop29;
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2217:1: entryRuleValueNamePair returns [EObject current=null] : iv_ruleValueNamePair= ruleValueNamePair EOF ;
    public final EObject entryRuleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNamePair = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2218:2: (iv_ruleValueNamePair= ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2219:2: iv_ruleValueNamePair= ruleValueNamePair EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueNamePairRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair4001);
            iv_ruleValueNamePair=ruleValueNamePair();
            _fsp--;

             current =iv_ruleValueNamePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair4011); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2226:1: ruleValueNamePair returns [EObject current=null] : ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject lv_value_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2231:6: ( ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2232:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2232:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2232:2: ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2232:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2233:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2233:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2234:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getValueNamePairRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueNamePair4054); 

            		createLeafNode(grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            match(input,45,FOLLOW_45_in_ruleValueNamePair4064); 

                    createLeafNode(grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2250:1: ( (lv_value_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2251:1: (lv_value_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2251:1: (lv_value_2_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2252:3: lv_value_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleValueNamePair4085);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2282:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2283:2: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2284:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4121);
            iv_ruleTimeExpression=ruleTimeExpression();
            _fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression4131); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2291:1: ruleTimeExpression returns [EObject current=null] : (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_InstantObsExpression_0 = null;

        EObject this_DurationObsExpression_1 = null;

        EObject this_JitterExp_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2296:6: ( (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2297:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2297:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt30=1;
                }
                break;
            case 48:
                {
                alt30=2;
                }
                break;
            case 49:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2297:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2298:5: this_InstantObsExpression_0= ruleInstantObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4178);
                    this_InstantObsExpression_0=ruleInstantObsExpression();
                    _fsp--;

                     
                            current = this_InstantObsExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2308:5: this_DurationObsExpression_1= ruleDurationObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4205);
                    this_DurationObsExpression_1=ruleDurationObsExpression();
                    _fsp--;

                     
                            current = this_DurationObsExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2318:5: this_JitterExp_2= ruleJitterExp
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJitterExp_in_ruleTimeExpression4232);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2334:1: entryRuleInstantObsExpression returns [EObject current=null] : iv_ruleInstantObsExpression= ruleInstantObsExpression EOF ;
    public final EObject entryRuleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2335:2: (iv_ruleInstantObsExpression= ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2336:2: iv_ruleInstantObsExpression= ruleInstantObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4267);
            iv_ruleInstantObsExpression=ruleInstantObsExpression();
            _fsp--;

             current =iv_ruleInstantObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression4277); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2343:1: ruleInstantObsExpression returns [EObject current=null] : ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2348:6: ( ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2349:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2349:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2349:3: '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,46,FOLLOW_46_in_ruleInstantObsExpression4312); 

                    createLeafNode(grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2353:1: ( (lv_id_1_0= ruleInstantObsName ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2354:1: (lv_id_1_0= ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2354:1: (lv_id_1_0= ruleInstantObsName )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2355:3: lv_id_1_0= ruleInstantObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4333);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2377:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==36) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2377:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,36,FOLLOW_36_in_ruleInstantObsExpression4344); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2381:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2382:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2382:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2383:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4365);
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

                    match(input,37,FOLLOW_37_in_ruleInstantObsExpression4375); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2409:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==47) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2409:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,47,FOLLOW_47_in_ruleInstantObsExpression4388); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,36,FOLLOW_36_in_ruleInstantObsExpression4398); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2417:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2418:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2418:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2419:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4419);
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

                    match(input,37,FOLLOW_37_in_ruleInstantObsExpression4429); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2453:1: entryRuleInstantObsName returns [EObject current=null] : iv_ruleInstantObsName= ruleInstantObsName EOF ;
    public final EObject entryRuleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2454:2: (iv_ruleInstantObsName= ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2455:2: iv_ruleInstantObsName= ruleInstantObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4467);
            iv_ruleInstantObsName=ruleInstantObsName();
            _fsp--;

             current =iv_ruleInstantObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName4477); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2462:1: ruleInstantObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2467:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2468:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2468:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2468:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2468:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==38) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2469:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2469:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2470:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstantObsName4523);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2492:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2493:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2493:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2494:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getInstantObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstantObsName4542); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2514:1: entryRuleDurationObsExpression returns [EObject current=null] : iv_ruleDurationObsExpression= ruleDurationObsExpression EOF ;
    public final EObject entryRuleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2515:2: (iv_ruleDurationObsExpression= ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2516:2: iv_ruleDurationObsExpression= ruleDurationObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4578);
            iv_ruleDurationObsExpression=ruleDurationObsExpression();
            _fsp--;

             current =iv_ruleDurationObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression4588); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2523:1: ruleDurationObsExpression returns [EObject current=null] : ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2528:6: ( ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2529:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2529:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2529:3: '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,48,FOLLOW_48_in_ruleDurationObsExpression4623); 

                    createLeafNode(grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2533:1: ( (lv_id_1_0= ruleDurationObsName ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2534:1: (lv_id_1_0= ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2534:1: (lv_id_1_0= ruleDurationObsName )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2535:3: lv_id_1_0= ruleDurationObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4644);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2557:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==36) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2557:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,36,FOLLOW_36_in_ruleDurationObsExpression4655); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2561:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2562:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2562:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2563:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4676);
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

                    match(input,37,FOLLOW_37_in_ruleDurationObsExpression4686); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2589:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==47) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2589:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,47,FOLLOW_47_in_ruleDurationObsExpression4699); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,36,FOLLOW_36_in_ruleDurationObsExpression4709); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2597:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2598:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2598:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2599:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4730);
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

                    match(input,37,FOLLOW_37_in_ruleDurationObsExpression4740); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2633:1: entryRuleDurationObsName returns [EObject current=null] : iv_ruleDurationObsName= ruleDurationObsName EOF ;
    public final EObject entryRuleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2634:2: (iv_ruleDurationObsName= ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2635:2: iv_ruleDurationObsName= ruleDurationObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4778);
            iv_ruleDurationObsName=ruleDurationObsName();
            _fsp--;

             current =iv_ruleDurationObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName4788); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2642:1: ruleDurationObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2647:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2648:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2648:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2648:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2648:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==38) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2649:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2649:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2650:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDurationObsName4834);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2672:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2673:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2673:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2674:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDurationObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDurationObsName4853); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2694:1: entryRuleJitterExp returns [EObject current=null] : iv_ruleJitterExp= ruleJitterExp EOF ;
    public final EObject entryRuleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJitterExp = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2695:2: (iv_ruleJitterExp= ruleJitterExp EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2696:2: iv_ruleJitterExp= ruleJitterExp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJitterExpRule(), currentNode); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp4889);
            iv_ruleJitterExp=ruleJitterExp();
            _fsp--;

             current =iv_ruleJitterExp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp4899); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2703:1: ruleJitterExp returns [EObject current=null] : ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) ;
    public final EObject ruleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject lv_firstInstant_1_0 = null;

        EObject lv_secondInstant_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2708:6: ( ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2709:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2709:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2709:3: 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')'
            {
            match(input,49,FOLLOW_49_in_ruleJitterExp4934); 

                    createLeafNode(grammarAccess.getJitterExpAccess().getJitterKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2713:1: ( (lv_firstInstant_1_0= ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2714:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2714:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2715:3: lv_firstInstant_1_0= ruleInstantObsExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4955);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2737:2: ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==30) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2737:4: '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    {
                    match(input,30,FOLLOW_30_in_ruleJitterExp4966); 

                            createLeafNode(grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2741:1: ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2742:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2742:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2743:3: lv_secondInstant_3_0= ruleInstantObsExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4987);
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

            match(input,37,FOLLOW_37_in_ruleJitterExp4999); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2777:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2778:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2779:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration5035);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration5045); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2786:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        AntlrDatatypeRuleToken lv_variableDeclaration_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_initValue_7_0 = null;

        EObject lv_initValue_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2791:6: ( ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2792:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2792:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2792:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2792:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=51 && LA38_0<=53)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2793:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2793:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2794:3: lv_variableDeclaration_0_0= ruleVariableDirectionKind
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5091);
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

            match(input,50,FOLLOW_50_in_ruleVariableDeclaration5102); 

                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2820:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2821:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2821:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2822:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration5119); 

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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2844:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==28) ) {
                alt40=1;
            }
            else if ( (LA40_0==45) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2844:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2844:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2844:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2844:5: ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    {
                    match(input,28,FOLLOW_28_in_ruleVariableDeclaration5136); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2848:1: ( (lv_type_4_0= ruleDataTypeName ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2849:1: (lv_type_4_0= ruleDataTypeName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2849:1: (lv_type_4_0= ruleDataTypeName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2850:3: lv_type_4_0= ruleDataTypeName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5157);
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

                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2872:2: ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==45) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2872:4: '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')'
                            {
                            match(input,45,FOLLOW_45_in_ruleVariableDeclaration5168); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0(), null); 
                                
                            match(input,36,FOLLOW_36_in_ruleVariableDeclaration5178); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1(), null); 
                                
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2880:1: ( (lv_initValue_7_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2881:1: (lv_initValue_7_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2881:1: (lv_initValue_7_0= ruleExpression )
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2882:3: lv_initValue_7_0= ruleExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5199);
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

                            match(input,37,FOLLOW_37_in_ruleVariableDeclaration5209); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2909:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2909:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2909:8: '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')'
                    {
                    match(input,45,FOLLOW_45_in_ruleVariableDeclaration5229); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0(), null); 
                        
                    match(input,36,FOLLOW_36_in_ruleVariableDeclaration5239); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2917:1: ( (lv_initValue_11_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2918:1: (lv_initValue_11_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2918:1: (lv_initValue_11_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2919:3: lv_initValue_11_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5260);
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

                    match(input,37,FOLLOW_37_in_ruleVariableDeclaration5270); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2953:1: entryRuleVariableDirectionKind returns [String current=null] : iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF ;
    public final String entryRuleVariableDirectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableDirectionKind = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2954:2: (iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2955:2: iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDirectionKindRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5309);
            iv_ruleVariableDirectionKind=ruleVariableDirectionKind();
            _fsp--;

             current =iv_ruleVariableDirectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind5320); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2962:1: ruleVariableDirectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleVariableDirectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2967:6: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2968:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2968:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt41=1;
                }
                break;
            case 52:
                {
                alt41=2;
                }
                break;
            case 53:
                {
                alt41=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2968:1: (kw= 'in' | kw= 'out' | kw= 'inout' )", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2969:2: kw= 'in'
                    {
                    kw=(Token)input.LT(1);
                    match(input,51,FOLLOW_51_in_ruleVariableDirectionKind5358); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2976:2: kw= 'out'
                    {
                    kw=(Token)input.LT(1);
                    match(input,52,FOLLOW_52_in_ruleVariableDirectionKind5377); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2983:2: kw= 'inout'
                    {
                    kw=(Token)input.LT(1);
                    match(input,53,FOLLOW_53_in_ruleVariableDirectionKind5396); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2996:1: entryRuleDataTypeName returns [EObject current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final EObject entryRuleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2997:2: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2998:2: iv_ruleDataTypeName= ruleDataTypeName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5436);
            iv_ruleDataTypeName=ruleDataTypeName();
            _fsp--;

             current =iv_ruleDataTypeName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName5446); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3005:1: ruleDataTypeName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3010:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3011:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3011:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3011:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3011:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==38) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3012:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3012:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3013:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDataTypeName5492);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3035:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3036:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3036:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3037:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDataTypeNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataTypeName5511); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3057:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3058:2: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3059:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumberLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5547);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();
            _fsp--;

             current =iv_ruleNumberLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule5557); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3066:1: ruleNumberLiteralRule returns [EObject current=null] : (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteralRule_0 = null;

        EObject this_UnlimitedLiteralRule_1 = null;

        EObject this_RealLiteralRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3071:6: ( (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3072:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3072:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            int alt43=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
                {
                alt43=1;
                }
                break;
            case 31:
                {
                alt43=2;
                }
                break;
            case RULE_REALLITERAL:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("3072:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3073:5: this_IntegerLiteralRule_0= ruleIntegerLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5604);
                    this_IntegerLiteralRule_0=ruleIntegerLiteralRule();
                    _fsp--;

                     
                            current = this_IntegerLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3083:5: this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5631);
                    this_UnlimitedLiteralRule_1=ruleUnlimitedLiteralRule();
                    _fsp--;

                     
                            current = this_UnlimitedLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3093:5: this_RealLiteralRule_2= ruleRealLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5658);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3109:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3110:2: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3111:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5693);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();
            _fsp--;

             current =iv_ruleIntegerLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule5703); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3118:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3123:6: ( ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3124:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3124:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3125:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3125:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3126:3: lv_value_0_0= RULE_INTEGERLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5744); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3156:1: entryRuleUnlimitedLiteralRule returns [EObject current=null] : iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF ;
    public final EObject entryRuleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3157:2: (iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3158:2: iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnlimitedLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5784);
            iv_ruleUnlimitedLiteralRule=ruleUnlimitedLiteralRule();
            _fsp--;

             current =iv_ruleUnlimitedLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5794); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3165:1: ruleUnlimitedLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '*' ) ) ;
    public final EObject ruleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3170:6: ( ( (lv_value_0_0= '*' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3171:1: ( (lv_value_0_0= '*' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3171:1: ( (lv_value_0_0= '*' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3172:1: (lv_value_0_0= '*' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3172:1: (lv_value_0_0= '*' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3173:3: lv_value_0_0= '*'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,31,FOLLOW_31_in_ruleUnlimitedLiteralRule5836); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3200:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3201:2: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3202:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5884);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();
            _fsp--;

             current =iv_ruleRealLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule5894); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3209:1: ruleRealLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_REALLITERAL ) ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3214:6: ( ( (lv_value_0_0= RULE_REALLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3215:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3215:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3216:1: (lv_value_0_0= RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3216:1: (lv_value_0_0= RULE_REALLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3217:3: lv_value_0_0= RULE_REALLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5935); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3247:1: entryRuleDateTimeLiteralRule returns [EObject current=null] : iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF ;
    public final EObject entryRuleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTimeLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3248:2: (iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3249:2: iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDateTimeLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5975);
            iv_ruleDateTimeLiteralRule=ruleDateTimeLiteralRule();
            _fsp--;

             current =iv_ruleDateTimeLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5985); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3256:1: ruleDateTimeLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) ;
    public final EObject ruleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3261:6: ( ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3262:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3262:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3263:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3263:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3264:3: lv_value_0_0= RULE_DATETIMELITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule6026); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3294:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3295:2: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3296:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6066);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();
            _fsp--;

             current =iv_ruleBooleanLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule6076); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3303:1: ruleBooleanLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3308:6: ( ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3309:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3309:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3310:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3310:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3311:3: lv_value_0_0= RULE_BOOLEANLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6117); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3341:1: entryRuleNullLiteralRule returns [EObject current=null] : iv_ruleNullLiteralRule= ruleNullLiteralRule EOF ;
    public final EObject entryRuleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3342:2: (iv_ruleNullLiteralRule= ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3343:2: iv_ruleNullLiteralRule= ruleNullLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6157);
            iv_ruleNullLiteralRule=ruleNullLiteralRule();
            _fsp--;

             current =iv_ruleNullLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule6167); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3350:1: ruleNullLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_NULLLITERAL ) ) ;
    public final EObject ruleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3355:6: ( ( (lv_value_0_0= RULE_NULLLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3356:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3356:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3357:1: (lv_value_0_0= RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3357:1: (lv_value_0_0= RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3358:3: lv_value_0_0= RULE_NULLLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6208); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3388:1: entryRuleDefaultLiteralRule returns [EObject current=null] : iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF ;
    public final EObject entryRuleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3389:2: (iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3390:2: iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefaultLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6248);
            iv_ruleDefaultLiteralRule=ruleDefaultLiteralRule();
            _fsp--;

             current =iv_ruleDefaultLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule6258); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3397:1: ruleDefaultLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '/' ) ) ;
    public final EObject ruleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3402:6: ( ( (lv_value_0_0= '/' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3403:1: ( (lv_value_0_0= '/' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3403:1: ( (lv_value_0_0= '/' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3404:1: (lv_value_0_0= '/' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3404:1: (lv_value_0_0= '/' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3405:3: lv_value_0_0= '/'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,32,FOLLOW_32_in_ruleDefaultLiteralRule6300); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3432:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3433:2: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3434:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6348);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();
            _fsp--;

             current =iv_ruleStringLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule6358); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3441:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3446:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3447:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3447:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3448:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3448:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3449:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteralRule6399); 

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


 

    public static final BitSet FOLLOW_ruleConstraintRule_in_entryRuleConstraintRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSpecification_in_ruleConstraintRule130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintSpecification_in_entryRuleConstraintSpecification166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintSpecification176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstraintSpecification221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleImport303 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContext_in_entryRuleContext361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContext371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleContext406 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContext424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_ruleExpression515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression606 = new BitSet(new long[]{0x00000000001C0002L});
    public static final BitSet FOLLOW_18_in_ruleAndOrXorExpression627 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_19_in_ruleAndOrXorExpression656 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_20_in_ruleAndOrXorExpression685 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression722 = new BitSet(new long[]{0x00000000001C0002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression816 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_21_in_ruleEqualityExpression837 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_22_in_ruleEqualityExpression866 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression903 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression997 = new BitSet(new long[]{0x0000000007800002L});
    public static final BitSet FOLLOW_23_in_ruleRelationalExpression1018 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_24_in_ruleRelationalExpression1047 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_25_in_ruleRelationalExpression1076 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_26_in_ruleRelationalExpression1105 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression1142 = new BitSet(new long[]{0x0000000007800002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression1180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1236 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleConditionalExpression1255 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1289 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleConditionalExpression1299 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1414 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_29_in_ruleAdditiveExpression1435 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_30_in_ruleAdditiveExpression1464 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1501 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1595 = new BitSet(new long[]{0x0000000380000002L});
    public static final BitSet FOLLOW_31_in_ruleMultiplicativeExpression1616 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_32_in_ruleMultiplicativeExpression1645 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_33_in_ruleMultiplicativeExpression1674 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1711 = new BitSet(new long[]{0x0000000380000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleUnaryExpression1805 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_30_in_ruleUnaryExpression1834 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_29_in_ruleUnaryExpression1863 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rulePrimaryExpression2020 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_rulePrimaryExpression2031 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification2090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleValueSpecification2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleValueSpecification2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleValueSpecification2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleValueSpecification2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleValueSpecification2325 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueSpecification2347 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleValueSpecification2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression2403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2512 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression2522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyCallExpression2565 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_rulePropertyCallExpression2576 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpression2688 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleOperationCallExpression2698 = new BitSet(new long[]{0x003F45B5E00007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2719 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleOperationCallExpression2730 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleOperationCallExpression2741 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_ruleLiteral2938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_ruleLiteral2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall3027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall3037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall3083 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall3102 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleNameOrChoiceOrBehaviorCall3113 = new BitSet(new long[]{0x003F45B5E00007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall3134 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleNameOrChoiceOrBehaviorCall3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3236 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleQualifiedName3246 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName3267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval3304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleInterval3350 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_40_in_ruleInterval3374 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3409 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleInterval3419 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3440 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_39_in_ruleInterval3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleInterval3488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple3535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCollectionOrTuple3570 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3591 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleCollectionOrTuple3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple3637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleTuple3682 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3703 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleTuple3713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues3749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3805 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleListOfValues3816 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3837 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3875 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs3885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3931 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleListOfValueNamePairs3942 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3963 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair4001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair4011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueNamePair4054 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleValueNamePair4064 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueNamePair4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression4121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression4178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_ruleTimeExpression4232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression4277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleInstantObsExpression4312 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4333 = new BitSet(new long[]{0x0000801000000002L});
    public static final BitSet FOLLOW_36_in_ruleInstantObsExpression4344 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4365 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleInstantObsExpression4375 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleInstantObsExpression4388 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleInstantObsExpression4398 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4419 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleInstantObsExpression4429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstantObsName4523 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstantObsName4542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression4588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleDurationObsExpression4623 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4644 = new BitSet(new long[]{0x0000801000000002L});
    public static final BitSet FOLLOW_36_in_ruleDurationObsExpression4655 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4676 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleDurationObsExpression4686 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_ruleDurationObsExpression4699 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleDurationObsExpression4709 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4730 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleDurationObsExpression4740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName4788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDurationObsName4834 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDurationObsName4853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp4889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp4899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleJitterExp4934 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4955 = new BitSet(new long[]{0x0000002040000000L});
    public static final BitSet FOLLOW_30_in_ruleJitterExp4966 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4987 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleJitterExp4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration5035 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration5045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration5091 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleVariableDeclaration5102 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration5119 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_28_in_ruleVariableDeclaration5136 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration5157 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleVariableDeclaration5168 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleVariableDeclaration5178 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5199 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleVariableDeclaration5209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleVariableDeclaration5229 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleVariableDeclaration5239 = new BitSet(new long[]{0x003F4595E00007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5260 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleVariableDeclaration5270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind5320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleVariableDirectionKind5358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleVariableDirectionKind5377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleVariableDirectionKind5396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName5446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDataTypeName5492 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeName5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule5557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5693 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule5703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleUnlimitedLiteralRule5836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5884 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule5894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5975 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule6026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule6066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule6076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule6117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule6157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule6167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule6258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleDefaultLiteralRule6300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6348 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule6358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteralRule6399 = new BitSet(new long[]{0x0000000000000002L});

}