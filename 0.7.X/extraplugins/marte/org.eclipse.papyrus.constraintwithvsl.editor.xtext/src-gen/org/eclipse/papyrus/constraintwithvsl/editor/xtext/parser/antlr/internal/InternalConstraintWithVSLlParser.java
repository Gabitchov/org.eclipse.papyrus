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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGERLITERAL", "RULE_REALLITERAL", "RULE_DATETIMELITERAL", "RULE_BOOLEANLITERAL", "RULE_NULLLITERAL", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'?'", "':'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'not'", "'.'", "'('", "')'", "'::'", "']'", "'['", "'..'", "'{'", "'}'", "','", "'='", "'@'", "'when'", "'&'", "'jitter('", "'$'", "'in'", "'out'", "'inout'"
    };
    public static final int RULE_NULLLITERAL=9;
    public static final int RULE_DATETIMELITERAL=7;
    public static final int RULE_BOOLEANLITERAL=8;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=10;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_REALLITERAL=6;
    public static final int RULE_INTEGERLITERAL=5;
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

            if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)||(LA1_0>=27 && LA1_0<=30)||LA1_0==32||LA1_0==34||(LA1_0>=37 && LA1_0<=38)||LA1_0==40||LA1_0==44||(LA1_0>=46 && LA1_0<=51)) ) {
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


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:171:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:172:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:173:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression256);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression266); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:180:1: ruleExpression returns [EObject current=null] : ( (lv_exp_0_0= ruleAndOrXorExpression ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_exp_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:185:6: ( ( (lv_exp_0_0= ruleAndOrXorExpression ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:186:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:186:1: ( (lv_exp_0_0= ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:187:1: (lv_exp_0_0= ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:187:1: (lv_exp_0_0= ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:188:3: lv_exp_0_0= ruleAndOrXorExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_ruleExpression311);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:218:1: entryRuleAndOrXorExpression returns [EObject current=null] : iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF ;
    public final EObject entryRuleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrXorExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:219:2: (iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:220:2: iv_ruleAndOrXorExpression= ruleAndOrXorExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndOrXorExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression346);
            iv_ruleAndOrXorExpression=ruleAndOrXorExpression();
            _fsp--;

             current =iv_ruleAndOrXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression356); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:227:1: ruleAndOrXorExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndOrXorExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:232:6: ( ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:233:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:233:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:233:2: ( (lv_exp_0_0= ruleEqualityExpression ) ) ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:233:2: ( (lv_exp_0_0= ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:234:1: (lv_exp_0_0= ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:234:1: (lv_exp_0_0= ruleEqualityExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:235:3: lv_exp_0_0= ruleEqualityExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression402);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:257:2: ( ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=16 && LA3_0<=18)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:257:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) ) ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:257:3: ( ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:258:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:258:1: ( (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:259:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:259:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case 16:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("259:1: (lv_op_1_1= 'and' | lv_op_1_2= 'or' | lv_op_1_3= 'xor' )", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:260:3: lv_op_1_1= 'and'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,16,FOLLOW_16_in_ruleAndOrXorExpression423); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:278:8: lv_op_1_2= 'or'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,17,FOLLOW_17_in_ruleAndOrXorExpression452); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:296:8: lv_op_1_3= 'xor'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,18,FOLLOW_18_in_ruleAndOrXorExpression481); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:317:2: ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:318:1: (lv_exp_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:318:1: (lv_exp_2_0= ruleEqualityExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:319:3: lv_exp_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression518);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:349:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:350:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:351:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression556);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression566); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:358:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:363:6: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:364:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:364:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:364:2: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:364:2: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:365:1: (lv_exp_0_0= ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:365:1: (lv_exp_0_0= ruleRelationalExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:366:3: lv_exp_0_0= ruleRelationalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression612);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:388:2: ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=19 && LA5_0<=20)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:388:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) ) ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:388:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:389:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:389:1: ( (lv_op_1_1= '==' | lv_op_1_2= '<>' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:390:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:390:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )
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
            	            new NoViableAltException("390:1: (lv_op_1_1= '==' | lv_op_1_2= '<>' )", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:391:3: lv_op_1_1= '=='
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,19,FOLLOW_19_in_ruleEqualityExpression633); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:409:8: lv_op_1_2= '<>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,20,FOLLOW_20_in_ruleEqualityExpression662); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:430:2: ( (lv_exp_2_0= ruleRelationalExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:431:1: (lv_exp_2_0= ruleRelationalExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:431:1: (lv_exp_2_0= ruleRelationalExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:432:3: lv_exp_2_0= ruleRelationalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression699);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:462:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:463:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:464:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression737);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression747); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:471:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:476:6: ( ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:477:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:477:1: ( ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:477:2: ( (lv_exp_0_0= ruleConditionalExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:477:2: ( (lv_exp_0_0= ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:478:1: (lv_exp_0_0= ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:478:1: (lv_exp_0_0= ruleConditionalExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:479:3: lv_exp_0_0= ruleConditionalExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression793);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:501:2: ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=21 && LA7_0<=24)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:501:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:501:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:502:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:502:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:503:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:503:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
            	    int alt6=4;
            	    switch ( input.LA(1) ) {
            	    case 21:
            	        {
            	        alt6=1;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt6=2;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt6=3;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt6=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("503:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )", 6, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:504:3: lv_op_1_1= '<'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,21,FOLLOW_21_in_ruleRelationalExpression814); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:522:8: lv_op_1_2= '>'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,22,FOLLOW_22_in_ruleRelationalExpression843); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:540:8: lv_op_1_3= '<='
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,23,FOLLOW_23_in_ruleRelationalExpression872); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:558:8: lv_op_1_4= '>='
            	            {
            	            lv_op_1_4=(Token)input.LT(1);
            	            match(input,24,FOLLOW_24_in_ruleRelationalExpression901); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:579:2: ( (lv_exp_2_0= ruleConditionalExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:580:1: (lv_exp_2_0= ruleConditionalExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:580:1: (lv_exp_2_0= ruleConditionalExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:581:3: lv_exp_2_0= ruleConditionalExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression938);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:611:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:612:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:613:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConditionalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression976);
            iv_ruleConditionalExpression=ruleConditionalExpression();
            _fsp--;

             current =iv_ruleConditionalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression986); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:620:1: ruleConditionalExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;

        EObject lv_exp_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:625:6: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:626:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:626:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:626:2: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:626:2: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:627:1: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:627:1: (lv_exp_0_0= ruleAdditiveExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:628:3: lv_exp_0_0= ruleAdditiveExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1032);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:650:2: ( ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==25) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:650:3: ( (lv_op_1_0= '?' ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) ':' ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:650:3: ( (lv_op_1_0= '?' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:651:1: (lv_op_1_0= '?' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:651:1: (lv_op_1_0= '?' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:652:3: lv_op_1_0= '?'
                    {
                    lv_op_1_0=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_ruleConditionalExpression1051); 

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

                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:671:2: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:672:1: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:672:1: (lv_exp_2_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:673:3: lv_exp_2_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1085);
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

                    match(input,26,FOLLOW_26_in_ruleConditionalExpression1095); 

                            createLeafNode(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:699:1: ( (lv_exp_4_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:700:1: (lv_exp_4_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:700:1: (lv_exp_4_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:701:3: lv_exp_4_0= ruleAdditiveExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1116);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:731:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:732:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:733:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1154);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression1164); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:740:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:745:6: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:746:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:746:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:746:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:746:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:747:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:747:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:748:3: lv_exp_0_0= ruleMultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1210);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:770:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=27 && LA10_0<=28)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:770:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:770:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:771:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:771:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:772:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:772:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==27) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==28) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("772:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:773:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,27,FOLLOW_27_in_ruleAdditiveExpression1231); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:791:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,28,FOLLOW_28_in_ruleAdditiveExpression1260); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:812:2: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:813:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:813:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:814:3: lv_exp_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1297);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:844:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:845:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:846:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1335);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression1345); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:853:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:858:6: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:859:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:859:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:859:2: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:859:2: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:860:1: (lv_exp_0_0= ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:860:1: (lv_exp_0_0= ruleUnaryExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:861:3: lv_exp_0_0= ruleUnaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1391);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:883:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=29 && LA12_0<=31)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:883:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:883:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:884:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:884:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:885:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:885:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )
            	    int alt11=3;
            	    switch ( input.LA(1) ) {
            	    case 29:
            	        {
            	        alt11=1;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt11=2;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt11=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("885:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= 'mod' )", 11, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt11) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:886:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)input.LT(1);
            	            match(input,29,FOLLOW_29_in_ruleMultiplicativeExpression1412); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:904:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)input.LT(1);
            	            match(input,30,FOLLOW_30_in_ruleMultiplicativeExpression1441); 

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
            	            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:922:8: lv_op_1_3= 'mod'
            	            {
            	            lv_op_1_3=(Token)input.LT(1);
            	            match(input,31,FOLLOW_31_in_ruleMultiplicativeExpression1470); 

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

            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:943:2: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:944:1: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:944:1: (lv_exp_2_0= ruleUnaryExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:945:3: lv_exp_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1507);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:975:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:976:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:977:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1545);
            iv_ruleUnaryExpression=ruleUnaryExpression();
            _fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression1555); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:984:1: ruleUnaryExpression returns [EObject current=null] : ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        EObject lv_unary_1_0 = null;

        EObject lv_exp_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:989:6: ( ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:990:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:990:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=27 && LA14_0<=28)||LA14_0==32) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=RULE_ID && LA14_0<=RULE_STRING)||(LA14_0>=29 && LA14_0<=30)||LA14_0==34||(LA14_0>=37 && LA14_0<=38)||LA14_0==40||LA14_0==44||(LA14_0>=46 && LA14_0<=51)) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("990:1: ( ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) ) | ( (lv_exp_2_0= rulePrimaryExpression ) ) )", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:990:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:990:2: ( ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:990:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) ) ( (lv_unary_1_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:990:3: ( ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:991:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:991:1: ( (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:992:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:992:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )
                    int alt13=3;
                    switch ( input.LA(1) ) {
                    case 32:
                        {
                        alt13=1;
                        }
                        break;
                    case 28:
                        {
                        alt13=2;
                        }
                        break;
                    case 27:
                        {
                        alt13=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("992:1: (lv_op_0_1= 'not' | lv_op_0_2= '-' | lv_op_0_3= '+' )", 13, 0, input);

                        throw nvae;
                    }

                    switch (alt13) {
                        case 1 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:993:3: lv_op_0_1= 'not'
                            {
                            lv_op_0_1=(Token)input.LT(1);
                            match(input,32,FOLLOW_32_in_ruleUnaryExpression1601); 

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
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1011:8: lv_op_0_2= '-'
                            {
                            lv_op_0_2=(Token)input.LT(1);
                            match(input,28,FOLLOW_28_in_ruleUnaryExpression1630); 

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
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1029:8: lv_op_0_3= '+'
                            {
                            lv_op_0_3=(Token)input.LT(1);
                            match(input,27,FOLLOW_27_in_ruleUnaryExpression1659); 

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

                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1050:2: ( (lv_unary_1_0= ruleUnaryExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1051:1: (lv_unary_1_0= ruleUnaryExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1051:1: (lv_unary_1_0= ruleUnaryExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1052:3: lv_unary_1_0= ruleUnaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1696);
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
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1075:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1075:6: ( (lv_exp_2_0= rulePrimaryExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1076:1: (lv_exp_2_0= rulePrimaryExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1076:1: (lv_exp_2_0= rulePrimaryExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1077:3: lv_exp_2_0= rulePrimaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1724);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1107:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1108:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1109:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1760);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1770); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1116:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_prefix_0_0 = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1121:6: ( ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1122:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1122:1: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1122:2: ( (lv_prefix_0_0= ruleValueSpecification ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1122:2: ( (lv_prefix_0_0= ruleValueSpecification ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1123:1: (lv_prefix_0_0= ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1123:1: (lv_prefix_0_0= ruleValueSpecification )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1124:3: lv_prefix_0_0= ruleValueSpecification
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueSpecification_in_rulePrimaryExpression1816);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1146:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==33) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1146:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,33,FOLLOW_33_in_rulePrimaryExpression1827); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1150:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1151:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1151:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1152:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression1848);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1182:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1183:2: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1184:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification1886);
            iv_ruleValueSpecification=ruleValueSpecification();
            _fsp--;

             current =iv_ruleValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification1896); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1191:1: ruleValueSpecification returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1196:6: ( (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1197:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1197:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )
            int alt16=8;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case RULE_DATETIMELITERAL:
            case RULE_BOOLEANLITERAL:
            case RULE_NULLLITERAL:
            case RULE_STRING:
            case 29:
            case 30:
                {
                alt16=1;
                }
                break;
            case RULE_ID:
                {
                alt16=2;
                }
                break;
            case 37:
            case 38:
                {
                alt16=3;
                }
                break;
            case 40:
                {
                int LA16_4 = input.LA(2);

                if ( ((LA16_4>=RULE_INTEGERLITERAL && LA16_4<=RULE_STRING)||(LA16_4>=27 && LA16_4<=30)||LA16_4==32||LA16_4==34||(LA16_4>=37 && LA16_4<=38)||LA16_4==40||LA16_4==44||(LA16_4>=46 && LA16_4<=51)) ) {
                    alt16=4;
                }
                else if ( (LA16_4==RULE_ID) ) {
                    int LA16_9 = input.LA(3);

                    if ( (LA16_9==43) ) {
                        alt16=5;
                    }
                    else if ( ((LA16_9>=16 && LA16_9<=25)||(LA16_9>=27 && LA16_9<=31)||(LA16_9>=33 && LA16_9<=34)||LA16_9==36||(LA16_9>=41 && LA16_9<=42)) ) {
                        alt16=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1197:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 16, 9, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1197:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 16, 4, input);

                    throw nvae;
                }
                }
                break;
            case 44:
            case 46:
            case 47:
                {
                alt16=6;
                }
                break;
            case 48:
            case 49:
            case 50:
            case 51:
                {
                alt16=7;
                }
                break;
            case 34:
                {
                alt16=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1197:1: (this_Literal_0= ruleLiteral | this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall | this_Interval_2= ruleInterval | this_CollectionOrTuple_3= ruleCollectionOrTuple | this_Tuple_4= ruleTuple | this_TimeExpression_5= ruleTimeExpression | this_VariableDeclaration_6= ruleVariableDeclaration | ( '(' this_Expression_8= ruleExpression ')' ) )", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1198:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_ruleValueSpecification1943);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1208:5: this_NameOrChoiceOrBehaviorCall_1= ruleNameOrChoiceOrBehaviorCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification1970);
                    this_NameOrChoiceOrBehaviorCall_1=ruleNameOrChoiceOrBehaviorCall();
                    _fsp--;

                     
                            current = this_NameOrChoiceOrBehaviorCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1218:5: this_Interval_2= ruleInterval
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInterval_in_ruleValueSpecification1997);
                    this_Interval_2=ruleInterval();
                    _fsp--;

                     
                            current = this_Interval_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1228:5: this_CollectionOrTuple_3= ruleCollectionOrTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2024);
                    this_CollectionOrTuple_3=ruleCollectionOrTuple();
                    _fsp--;

                     
                            current = this_CollectionOrTuple_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1238:5: this_Tuple_4= ruleTuple
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTuple_in_ruleValueSpecification2051);
                    this_Tuple_4=ruleTuple();
                    _fsp--;

                     
                            current = this_Tuple_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1248:5: this_TimeExpression_5= ruleTimeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeExpression_in_ruleValueSpecification2078);
                    this_TimeExpression_5=ruleTimeExpression();
                    _fsp--;

                     
                            current = this_TimeExpression_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1258:5: this_VariableDeclaration_6= ruleVariableDeclaration
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2105);
                    this_VariableDeclaration_6=ruleVariableDeclaration();
                    _fsp--;

                     
                            current = this_VariableDeclaration_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1267:6: ( '(' this_Expression_8= ruleExpression ')' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1267:6: ( '(' this_Expression_8= ruleExpression ')' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1267:8: '(' this_Expression_8= ruleExpression ')'
                    {
                    match(input,34,FOLLOW_34_in_ruleValueSpecification2121); 

                            createLeafNode(grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleValueSpecification2143);
                    this_Expression_8=ruleExpression();
                    _fsp--;

                     
                            current = this_Expression_8; 
                            currentNode = currentNode.getParent();
                        
                    match(input,35,FOLLOW_35_in_ruleValueSpecification2152); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1292:1: entryRuleSuffixExpression returns [EObject current=null] : iv_ruleSuffixExpression= ruleSuffixExpression EOF ;
    public final EObject entryRuleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuffixExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1293:2: (iv_ruleSuffixExpression= ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1294:2: iv_ruleSuffixExpression= ruleSuffixExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuffixExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2189);
            iv_ruleSuffixExpression=ruleSuffixExpression();
            _fsp--;

             current =iv_ruleSuffixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression2199); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1301:1: ruleSuffixExpression returns [EObject current=null] : (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) ;
    public final EObject ruleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyCallExpression_0 = null;

        EObject this_OperationCallExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1306:6: ( (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1307:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1307:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==34) ) {
                    alt17=2;
                }
                else if ( (LA17_1==EOF||(LA17_1>=16 && LA17_1<=31)||LA17_1==33||LA17_1==35||(LA17_1>=37 && LA17_1<=39)||(LA17_1>=41 && LA17_1<=42)) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1307:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1307:1: (this_PropertyCallExpression_0= rulePropertyCallExpression | this_OperationCallExpression_1= ruleOperationCallExpression )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1308:5: this_PropertyCallExpression_0= rulePropertyCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2246);
                    this_PropertyCallExpression_0=rulePropertyCallExpression();
                    _fsp--;

                     
                            current = this_PropertyCallExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1318:5: this_OperationCallExpression_1= ruleOperationCallExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2273);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1334:1: entryRulePropertyCallExpression returns [EObject current=null] : iv_rulePropertyCallExpression= rulePropertyCallExpression EOF ;
    public final EObject entryRulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCallExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1335:2: (iv_rulePropertyCallExpression= rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1336:2: iv_rulePropertyCallExpression= rulePropertyCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2308);
            iv_rulePropertyCallExpression=rulePropertyCallExpression();
            _fsp--;

             current =iv_rulePropertyCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression2318); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1343:1: rulePropertyCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject rulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_suffix_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1348:6: ( ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1349:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1349:1: ( ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1349:2: ( ( RULE_ID ) ) ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1349:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1350:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1350:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1351:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyCallExpression2361); 

            		createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1363:2: ( '.' ( (lv_suffix_2_0= ruleSuffixExpression ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1363:4: '.' ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    {
                    match(input,33,FOLLOW_33_in_rulePropertyCallExpression2372); 

                            createLeafNode(grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1367:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1368:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1368:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1369:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2393);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1399:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1400:2: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1401:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationCallExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2431);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();
            _fsp--;

             current =iv_ruleOperationCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression2441); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1408:1: ruleOperationCallExpression returns [EObject current=null] : ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject ruleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_suffix_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1413:6: ( ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1414:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1414:1: ( ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1414:2: ( ( RULE_ID ) ) '(' ( (lv_arguments_2_0= ruleListOfValues ) )? ')' ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1414:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1415:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1415:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1416:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getOperationCallExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpression2484); 

            		createLeafNode(grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0(), "operation"); 
            	

            }


            }

            match(input,34,FOLLOW_34_in_ruleOperationCallExpression2494); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1432:1: ( (lv_arguments_2_0= ruleListOfValues ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_STRING)||(LA19_0>=27 && LA19_0<=30)||LA19_0==32||LA19_0==34||(LA19_0>=37 && LA19_0<=38)||LA19_0==40||LA19_0==44||(LA19_0>=46 && LA19_0<=51)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1433:1: (lv_arguments_2_0= ruleListOfValues )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1433:1: (lv_arguments_2_0= ruleListOfValues )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1434:3: lv_arguments_2_0= ruleListOfValues
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2515);
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

            match(input,35,FOLLOW_35_in_ruleOperationCallExpression2526); 

                    createLeafNode(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1460:1: ( '.' ( (lv_suffix_5_0= ruleSuffixExpression ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1460:3: '.' ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    {
                    match(input,33,FOLLOW_33_in_ruleOperationCallExpression2537); 

                            createLeafNode(grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1464:1: ( (lv_suffix_5_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1465:1: (lv_suffix_5_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1465:1: (lv_suffix_5_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1466:3: lv_suffix_5_0= ruleSuffixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2558);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1496:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1497:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1498:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral2596);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral2606); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1505:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) ;
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
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1510:6: ( (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1511:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1511:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )
            int alt21=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case 29:
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
            case 30:
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
                    new NoViableAltException("1511:1: (this_NumberLiteralRule_0= ruleNumberLiteralRule | this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule | this_BooleanLiteralRule_2= ruleBooleanLiteralRule | this_NullLiteralRule_3= ruleNullLiteralRule | this_DefaultLiteralRule_4= ruleDefaultLiteralRule | this_StringLiteralRule_5= ruleStringLiteralRule )", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1512:5: this_NumberLiteralRule_0= ruleNumberLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2653);
                    this_NumberLiteralRule_0=ruleNumberLiteralRule();
                    _fsp--;

                     
                            current = this_NumberLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1522:5: this_DateTimeLiteralRule_1= ruleDateTimeLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2680);
                    this_DateTimeLiteralRule_1=ruleDateTimeLiteralRule();
                    _fsp--;

                     
                            current = this_DateTimeLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1532:5: this_BooleanLiteralRule_2= ruleBooleanLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2707);
                    this_BooleanLiteralRule_2=ruleBooleanLiteralRule();
                    _fsp--;

                     
                            current = this_BooleanLiteralRule_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1542:5: this_NullLiteralRule_3= ruleNullLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_ruleLiteral2734);
                    this_NullLiteralRule_3=ruleNullLiteralRule();
                    _fsp--;

                     
                            current = this_NullLiteralRule_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1552:5: this_DefaultLiteralRule_4= ruleDefaultLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2761);
                    this_DefaultLiteralRule_4=ruleDefaultLiteralRule();
                    _fsp--;

                     
                            current = this_DefaultLiteralRule_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1562:5: this_StringLiteralRule_5= ruleStringLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_ruleLiteral2788);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1578:1: entryRuleNameOrChoiceOrBehaviorCall returns [EObject current=null] : iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF ;
    public final EObject entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameOrChoiceOrBehaviorCall = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1579:2: (iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1580:2: iv_ruleNameOrChoiceOrBehaviorCall= ruleNameOrChoiceOrBehaviorCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall2823);
            iv_ruleNameOrChoiceOrBehaviorCall=ruleNameOrChoiceOrBehaviorCall();
            _fsp--;

             current =iv_ruleNameOrChoiceOrBehaviorCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall2833); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1587:1: ruleNameOrChoiceOrBehaviorCall returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) ;
    public final EObject ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;

        EObject lv_arguments_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1592:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1593:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1593:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1593:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1593:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==36) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1594:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1594:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1595:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall2879);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1617:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1618:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1618:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1619:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNameOrChoiceOrBehaviorCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall2898); 

            		createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0(), "id"); 
            	

            }


            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1631:2: ( '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1631:4: '(' ( (lv_arguments_3_0= ruleListOfValues ) )? ')'
                    {
                    match(input,34,FOLLOW_34_in_ruleNameOrChoiceOrBehaviorCall2909); 

                            createLeafNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1635:1: ( (lv_arguments_3_0= ruleListOfValues ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_STRING)||(LA23_0>=27 && LA23_0<=30)||LA23_0==32||LA23_0==34||(LA23_0>=37 && LA23_0<=38)||LA23_0==40||LA23_0==44||(LA23_0>=46 && LA23_0<=51)) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1636:1: (lv_arguments_3_0= ruleListOfValues )
                            {
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1636:1: (lv_arguments_3_0= ruleListOfValues )
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1637:3: lv_arguments_3_0= ruleListOfValues
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall2930);
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

                    match(input,35,FOLLOW_35_in_ruleNameOrChoiceOrBehaviorCall2941); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1671:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1672:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1673:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2979);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2989); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1680:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1685:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1686:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1686:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1686:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1686:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1687:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1687:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1688:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3032); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,36,FOLLOW_36_in_ruleQualifiedName3042); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1704:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==36) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1705:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1705:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1706:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName3063);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1736:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1737:2: (iv_ruleInterval= ruleInterval EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1738:2: iv_ruleInterval= ruleInterval EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntervalRule(), currentNode); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval3100);
            iv_ruleInterval=ruleInterval();
            _fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval3110); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1745:1: ruleInterval returns [EObject current=null] : ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token lv_isLowerIncluded_1_0=null;
        Token lv_isUpperIncluded_5_0=null;
        EObject lv_lower_2_0 = null;

        EObject lv_upper_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1750:6: ( ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1751:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1751:1: ( ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1751:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) ) ( (lv_lower_2_0= ruleExpression ) ) '..' ( (lv_upper_4_0= ruleExpression ) ) ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1751:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            else if ( (LA26_0==38) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1751:2: ( ']' | ( (lv_isLowerIncluded_1_0= '[' ) ) )", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1751:4: ']'
                    {
                    match(input,37,FOLLOW_37_in_ruleInterval3146); 

                            createLeafNode(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1756:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1756:6: ( (lv_isLowerIncluded_1_0= '[' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1757:1: (lv_isLowerIncluded_1_0= '[' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1757:1: (lv_isLowerIncluded_1_0= '[' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1758:3: lv_isLowerIncluded_1_0= '['
                    {
                    lv_isLowerIncluded_1_0=(Token)input.LT(1);
                    match(input,38,FOLLOW_38_in_ruleInterval3170); 

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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1777:3: ( (lv_lower_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1778:1: (lv_lower_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1778:1: (lv_lower_2_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1779:3: lv_lower_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3205);
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

            match(input,39,FOLLOW_39_in_ruleInterval3215); 

                    createLeafNode(grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1805:1: ( (lv_upper_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1806:1: (lv_upper_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1806:1: (lv_upper_4_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1807:3: lv_upper_4_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleInterval3236);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1829:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==37) ) {
                alt27=1;
            }
            else if ( (LA27_0==38) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1829:2: ( ( (lv_isUpperIncluded_5_0= ']' ) ) | '[' )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1829:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1829:3: ( (lv_isUpperIncluded_5_0= ']' ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1830:1: (lv_isUpperIncluded_5_0= ']' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1830:1: (lv_isUpperIncluded_5_0= ']' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1831:3: lv_isUpperIncluded_5_0= ']'
                    {
                    lv_isUpperIncluded_5_0=(Token)input.LT(1);
                    match(input,37,FOLLOW_37_in_ruleInterval3255); 

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
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1851:7: '['
                    {
                    match(input,38,FOLLOW_38_in_ruleInterval3284); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1863:1: entryRuleCollectionOrTuple returns [EObject current=null] : iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF ;
    public final EObject entryRuleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionOrTuple = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1864:2: (iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1865:2: iv_ruleCollectionOrTuple= ruleCollectionOrTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCollectionOrTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3321);
            iv_ruleCollectionOrTuple=ruleCollectionOrTuple();
            _fsp--;

             current =iv_ruleCollectionOrTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple3331); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1872:1: ruleCollectionOrTuple returns [EObject current=null] : ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) ;
    public final EObject ruleCollectionOrTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValues_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1877:6: ( ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1878:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1878:1: ( '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1878:3: '{' ( (lv_listOfValues_1_0= ruleListOfValues ) ) '}'
            {
            match(input,40,FOLLOW_40_in_ruleCollectionOrTuple3366); 

                    createLeafNode(grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1882:1: ( (lv_listOfValues_1_0= ruleListOfValues ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1883:1: (lv_listOfValues_1_0= ruleListOfValues )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1883:1: (lv_listOfValues_1_0= ruleListOfValues )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1884:3: lv_listOfValues_1_0= ruleListOfValues
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3387);
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

            match(input,41,FOLLOW_41_in_ruleCollectionOrTuple3397); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1918:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1919:2: (iv_ruleTuple= ruleTuple EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1920:2: iv_ruleTuple= ruleTuple EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTupleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple3433);
            iv_ruleTuple=ruleTuple();
            _fsp--;

             current =iv_ruleTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple3443); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1927:1: ruleTuple returns [EObject current=null] : ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        EObject lv_listOfValueNamePairs_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1932:6: ( ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1933:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1933:1: ( '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1933:3: '{' ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) ) '}'
            {
            match(input,40,FOLLOW_40_in_ruleTuple3478); 

                    createLeafNode(grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1937:1: ( (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1938:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1938:1: (lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1939:3: lv_listOfValueNamePairs_1_0= ruleListOfValueNamePairs
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3499);
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

            match(input,41,FOLLOW_41_in_ruleTuple3509); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1973:1: entryRuleListOfValues returns [EObject current=null] : iv_ruleListOfValues= ruleListOfValues EOF ;
    public final EObject entryRuleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValues = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1974:2: (iv_ruleListOfValues= ruleListOfValues EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1975:2: iv_ruleListOfValues= ruleListOfValues EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValuesRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues3545);
            iv_ruleListOfValues=ruleListOfValues();
            _fsp--;

             current =iv_ruleListOfValues; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues3555); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1982:1: ruleListOfValues returns [EObject current=null] : ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListOfValues() throws RecognitionException {
        EObject current = null;

        EObject lv_values_0_0 = null;

        EObject lv_values_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1987:6: ( ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1988:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1988:1: ( ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1988:2: ( (lv_values_0_0= ruleExpression ) ) ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1988:2: ( (lv_values_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1989:1: (lv_values_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1989:1: (lv_values_0_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:1990:3: lv_values_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3601);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2012:2: ( ',' ( (lv_values_2_0= ruleExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==42) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2012:4: ',' ( (lv_values_2_0= ruleExpression ) )
            	    {
            	    match(input,42,FOLLOW_42_in_ruleListOfValues3612); 

            	            createLeafNode(grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2016:1: ( (lv_values_2_0= ruleExpression ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2017:1: (lv_values_2_0= ruleExpression )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2017:1: (lv_values_2_0= ruleExpression )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2018:3: lv_values_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleListOfValues3633);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2048:1: entryRuleListOfValueNamePairs returns [EObject current=null] : iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF ;
    public final EObject entryRuleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListOfValueNamePairs = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2049:2: (iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2050:2: iv_ruleListOfValueNamePairs= ruleListOfValueNamePairs EOF
            {
             currentNode = createCompositeNode(grammarAccess.getListOfValueNamePairsRule(), currentNode); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3671);
            iv_ruleListOfValueNamePairs=ruleListOfValueNamePairs();
            _fsp--;

             current =iv_ruleListOfValueNamePairs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs3681); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2057:1: ruleListOfValueNamePairs returns [EObject current=null] : ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) ;
    public final EObject ruleListOfValueNamePairs() throws RecognitionException {
        EObject current = null;

        EObject lv_valueNamePairs_0_0 = null;

        EObject lv_valueNamePairs_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2062:6: ( ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2063:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2063:1: ( ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )* )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2063:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) ) ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2063:2: ( (lv_valueNamePairs_0_0= ruleValueNamePair ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2064:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2064:1: (lv_valueNamePairs_0_0= ruleValueNamePair )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2065:3: lv_valueNamePairs_0_0= ruleValueNamePair
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3727);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2087:2: ( ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==42) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2087:4: ',' ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    {
            	    match(input,42,FOLLOW_42_in_ruleListOfValueNamePairs3738); 

            	            createLeafNode(grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2091:1: ( (lv_valueNamePairs_2_0= ruleValueNamePair ) )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2092:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    {
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2092:1: (lv_valueNamePairs_2_0= ruleValueNamePair )
            	    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2093:3: lv_valueNamePairs_2_0= ruleValueNamePair
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3759);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2123:1: entryRuleValueNamePair returns [EObject current=null] : iv_ruleValueNamePair= ruleValueNamePair EOF ;
    public final EObject entryRuleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNamePair = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2124:2: (iv_ruleValueNamePair= ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2125:2: iv_ruleValueNamePair= ruleValueNamePair EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueNamePairRule(), currentNode); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair3797);
            iv_ruleValueNamePair=ruleValueNamePair();
            _fsp--;

             current =iv_ruleValueNamePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair3807); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2132:1: ruleValueNamePair returns [EObject current=null] : ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueNamePair() throws RecognitionException {
        EObject current = null;

        EObject lv_value_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2137:6: ( ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2138:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2138:1: ( ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2138:2: ( ( RULE_ID ) ) '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2138:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2139:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2139:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2140:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getValueNamePairRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueNamePair3850); 

            		createLeafNode(grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0(), "property"); 
            	

            }


            }

            match(input,43,FOLLOW_43_in_ruleValueNamePair3860); 

                    createLeafNode(grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2156:1: ( (lv_value_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2157:1: (lv_value_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2157:1: (lv_value_2_0= ruleExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2158:3: lv_value_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleValueNamePair3881);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2188:1: entryRuleTimeExpression returns [EObject current=null] : iv_ruleTimeExpression= ruleTimeExpression EOF ;
    public final EObject entryRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2189:2: (iv_ruleTimeExpression= ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2190:2: iv_ruleTimeExpression= ruleTimeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression3917);
            iv_ruleTimeExpression=ruleTimeExpression();
            _fsp--;

             current =iv_ruleTimeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression3927); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2197:1: ruleTimeExpression returns [EObject current=null] : (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) ;
    public final EObject ruleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_InstantObsExpression_0 = null;

        EObject this_DurationObsExpression_1 = null;

        EObject this_JitterExp_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2202:6: ( (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2203:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2203:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt30=1;
                }
                break;
            case 46:
                {
                alt30=2;
                }
                break;
            case 47:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2203:1: (this_InstantObsExpression_0= ruleInstantObsExpression | this_DurationObsExpression_1= ruleDurationObsExpression | this_JitterExp_2= ruleJitterExp )", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2204:5: this_InstantObsExpression_0= ruleInstantObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression3974);
                    this_InstantObsExpression_0=ruleInstantObsExpression();
                    _fsp--;

                     
                            current = this_InstantObsExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2214:5: this_DurationObsExpression_1= ruleDurationObsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4001);
                    this_DurationObsExpression_1=ruleDurationObsExpression();
                    _fsp--;

                     
                            current = this_DurationObsExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2224:5: this_JitterExp_2= ruleJitterExp
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleJitterExp_in_ruleTimeExpression4028);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2240:1: entryRuleInstantObsExpression returns [EObject current=null] : iv_ruleInstantObsExpression= ruleInstantObsExpression EOF ;
    public final EObject entryRuleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2241:2: (iv_ruleInstantObsExpression= ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2242:2: iv_ruleInstantObsExpression= ruleInstantObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4063);
            iv_ruleInstantObsExpression=ruleInstantObsExpression();
            _fsp--;

             current =iv_ruleInstantObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression4073); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2249:1: ruleInstantObsExpression returns [EObject current=null] : ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleInstantObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2254:6: ( ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2255:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2255:1: ( '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2255:3: '@' ( (lv_id_1_0= ruleInstantObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,44,FOLLOW_44_in_ruleInstantObsExpression4108); 

                    createLeafNode(grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2259:1: ( (lv_id_1_0= ruleInstantObsName ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2260:1: (lv_id_1_0= ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2260:1: (lv_id_1_0= ruleInstantObsName )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2261:3: lv_id_1_0= ruleInstantObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4129);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2283:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==34) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2283:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,34,FOLLOW_34_in_ruleInstantObsExpression4140); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2287:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2288:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2288:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2289:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4161);
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

                    match(input,35,FOLLOW_35_in_ruleInstantObsExpression4171); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2315:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2315:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,45,FOLLOW_45_in_ruleInstantObsExpression4184); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,34,FOLLOW_34_in_ruleInstantObsExpression4194); 

                            createLeafNode(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2323:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2324:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2324:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2325:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleInstantObsExpression4215);
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

                    match(input,35,FOLLOW_35_in_ruleInstantObsExpression4225); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2359:1: entryRuleInstantObsName returns [EObject current=null] : iv_ruleInstantObsName= ruleInstantObsName EOF ;
    public final EObject entryRuleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantObsName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2360:2: (iv_ruleInstantObsName= ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2361:2: iv_ruleInstantObsName= ruleInstantObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInstantObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4263);
            iv_ruleInstantObsName=ruleInstantObsName();
            _fsp--;

             current =iv_ruleInstantObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName4273); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2368:1: ruleInstantObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleInstantObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2373:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2374:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2374:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2374:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2374:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==36) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2375:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2375:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2376:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstantObsName4319);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2398:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2399:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2399:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2400:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getInstantObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstantObsName4338); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2420:1: entryRuleDurationObsExpression returns [EObject current=null] : iv_ruleDurationObsExpression= ruleDurationObsExpression EOF ;
    public final EObject entryRuleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsExpression = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2421:2: (iv_ruleDurationObsExpression= ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2422:2: iv_ruleDurationObsExpression= ruleDurationObsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4374);
            iv_ruleDurationObsExpression=ruleDurationObsExpression();
            _fsp--;

             current =iv_ruleDurationObsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression4384); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2429:1: ruleDurationObsExpression returns [EObject current=null] : ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) ;
    public final EObject ruleDurationObsExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_id_1_0 = null;

        EObject lv_index_3_0 = null;

        EObject lv_condition_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2434:6: ( ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2435:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2435:1: ( '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )? )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2435:3: '&' ( (lv_id_1_0= ruleDurationObsName ) ) ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )? ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            {
            match(input,46,FOLLOW_46_in_ruleDurationObsExpression4419); 

                    createLeafNode(grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2439:1: ( (lv_id_1_0= ruleDurationObsName ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2440:1: (lv_id_1_0= ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2440:1: (lv_id_1_0= ruleDurationObsName )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2441:3: lv_id_1_0= ruleDurationObsName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4440);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2463:2: ( '(' ( (lv_index_3_0= ruleExpression ) ) ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==34) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2463:4: '(' ( (lv_index_3_0= ruleExpression ) ) ')'
                    {
                    match(input,34,FOLLOW_34_in_ruleDurationObsExpression4451); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2467:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2468:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2468:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2469:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4472);
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

                    match(input,35,FOLLOW_35_in_ruleDurationObsExpression4482); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2495:3: ( 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==45) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2495:5: 'when' '(' ( (lv_condition_7_0= ruleExpression ) ) ')'
                    {
                    match(input,45,FOLLOW_45_in_ruleDurationObsExpression4495); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0(), null); 
                        
                    match(input,34,FOLLOW_34_in_ruleDurationObsExpression4505); 

                            createLeafNode(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2503:1: ( (lv_condition_7_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2504:1: (lv_condition_7_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2504:1: (lv_condition_7_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2505:3: lv_condition_7_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleDurationObsExpression4526);
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

                    match(input,35,FOLLOW_35_in_ruleDurationObsExpression4536); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2539:1: entryRuleDurationObsName returns [EObject current=null] : iv_ruleDurationObsName= ruleDurationObsName EOF ;
    public final EObject entryRuleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDurationObsName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2540:2: (iv_ruleDurationObsName= ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2541:2: iv_ruleDurationObsName= ruleDurationObsName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDurationObsNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4574);
            iv_ruleDurationObsName=ruleDurationObsName();
            _fsp--;

             current =iv_ruleDurationObsName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName4584); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2548:1: ruleDurationObsName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDurationObsName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2553:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2554:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2554:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2554:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2554:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==36) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2555:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2555:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2556:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDurationObsName4630);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2578:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2579:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2579:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2580:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDurationObsNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDurationObsName4649); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2600:1: entryRuleJitterExp returns [EObject current=null] : iv_ruleJitterExp= ruleJitterExp EOF ;
    public final EObject entryRuleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJitterExp = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2601:2: (iv_ruleJitterExp= ruleJitterExp EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2602:2: iv_ruleJitterExp= ruleJitterExp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getJitterExpRule(), currentNode); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp4685);
            iv_ruleJitterExp=ruleJitterExp();
            _fsp--;

             current =iv_ruleJitterExp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp4695); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2609:1: ruleJitterExp returns [EObject current=null] : ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) ;
    public final EObject ruleJitterExp() throws RecognitionException {
        EObject current = null;

        EObject lv_firstInstant_1_0 = null;

        EObject lv_secondInstant_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2614:6: ( ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2615:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2615:1: ( 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2615:3: 'jitter(' ( (lv_firstInstant_1_0= ruleInstantObsExpression ) ) ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )? ')'
            {
            match(input,47,FOLLOW_47_in_ruleJitterExp4730); 

                    createLeafNode(grammarAccess.getJitterExpAccess().getJitterKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2619:1: ( (lv_firstInstant_1_0= ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2620:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2620:1: (lv_firstInstant_1_0= ruleInstantObsExpression )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2621:3: lv_firstInstant_1_0= ruleInstantObsExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4751);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2643:2: ( '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==28) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2643:4: '-' ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    {
                    match(input,28,FOLLOW_28_in_ruleJitterExp4762); 

                            createLeafNode(grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2647:1: ( (lv_secondInstant_3_0= ruleInstantObsExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2648:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2648:1: (lv_secondInstant_3_0= ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2649:3: lv_secondInstant_3_0= ruleInstantObsExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4783);
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

            match(input,35,FOLLOW_35_in_ruleJitterExp4795); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2683:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2684:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2685:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4831);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration4841); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2692:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        AntlrDatatypeRuleToken lv_variableDeclaration_0_0 = null;

        EObject lv_type_4_0 = null;

        EObject lv_initValue_7_0 = null;

        EObject lv_initValue_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2697:6: ( ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2698:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2698:1: ( ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2698:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )? '$' ( (lv_name_2_0= RULE_ID ) ) ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2698:2: ( (lv_variableDeclaration_0_0= ruleVariableDirectionKind ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=49 && LA38_0<=51)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2699:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2699:1: (lv_variableDeclaration_0_0= ruleVariableDirectionKind )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2700:3: lv_variableDeclaration_0_0= ruleVariableDirectionKind
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration4887);
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

            match(input,48,FOLLOW_48_in_ruleVariableDeclaration4898); 

                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2726:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2727:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2727:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2728:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration4915); 

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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2750:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==26) ) {
                alt40=1;
            }
            else if ( (LA40_0==43) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2750:2: ( ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? ) | ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' ) )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2750:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2750:3: ( ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )? )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2750:5: ':' ( (lv_type_4_0= ruleDataTypeName ) ) ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    {
                    match(input,26,FOLLOW_26_in_ruleVariableDeclaration4932); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2754:1: ( (lv_type_4_0= ruleDataTypeName ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2755:1: (lv_type_4_0= ruleDataTypeName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2755:1: (lv_type_4_0= ruleDataTypeName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2756:3: lv_type_4_0= ruleDataTypeName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration4953);
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

                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2778:2: ( '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')' )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==43) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2778:4: '=' '(' ( (lv_initValue_7_0= ruleExpression ) ) ')'
                            {
                            match(input,43,FOLLOW_43_in_ruleVariableDeclaration4964); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0(), null); 
                                
                            match(input,34,FOLLOW_34_in_ruleVariableDeclaration4974); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1(), null); 
                                
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2786:1: ( (lv_initValue_7_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2787:1: (lv_initValue_7_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2787:1: (lv_initValue_7_0= ruleExpression )
                            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2788:3: lv_initValue_7_0= ruleExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration4995);
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

                            match(input,35,FOLLOW_35_in_ruleVariableDeclaration5005); 

                                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3(), null); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2815:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2815:6: ( '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')' )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2815:8: '=' '(' ( (lv_initValue_11_0= ruleExpression ) ) ')'
                    {
                    match(input,43,FOLLOW_43_in_ruleVariableDeclaration5025); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0(), null); 
                        
                    match(input,34,FOLLOW_34_in_ruleVariableDeclaration5035); 

                            createLeafNode(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1(), null); 
                        
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2823:1: ( (lv_initValue_11_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2824:1: (lv_initValue_11_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2824:1: (lv_initValue_11_0= ruleExpression )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2825:3: lv_initValue_11_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration5056);
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

                    match(input,35,FOLLOW_35_in_ruleVariableDeclaration5066); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2859:1: entryRuleVariableDirectionKind returns [String current=null] : iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF ;
    public final String entryRuleVariableDirectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableDirectionKind = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2860:2: (iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2861:2: iv_ruleVariableDirectionKind= ruleVariableDirectionKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDirectionKindRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5105);
            iv_ruleVariableDirectionKind=ruleVariableDirectionKind();
            _fsp--;

             current =iv_ruleVariableDirectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind5116); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2868:1: ruleVariableDirectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleVariableDirectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2873:6: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2874:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2874:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt41=1;
                }
                break;
            case 50:
                {
                alt41=2;
                }
                break;
            case 51:
                {
                alt41=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2874:1: (kw= 'in' | kw= 'out' | kw= 'inout' )", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2875:2: kw= 'in'
                    {
                    kw=(Token)input.LT(1);
                    match(input,49,FOLLOW_49_in_ruleVariableDirectionKind5154); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2882:2: kw= 'out'
                    {
                    kw=(Token)input.LT(1);
                    match(input,50,FOLLOW_50_in_ruleVariableDirectionKind5173); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2889:2: kw= 'inout'
                    {
                    kw=(Token)input.LT(1);
                    match(input,51,FOLLOW_51_in_ruleVariableDirectionKind5192); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2902:1: entryRuleDataTypeName returns [EObject current=null] : iv_ruleDataTypeName= ruleDataTypeName EOF ;
    public final EObject entryRuleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeName = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2903:2: (iv_ruleDataTypeName= ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2904:2: iv_ruleDataTypeName= ruleDataTypeName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5232);
            iv_ruleDataTypeName=ruleDataTypeName();
            _fsp--;

             current =iv_ruleDataTypeName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName5242); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2911:1: ruleDataTypeName returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleDataTypeName() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2916:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2917:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2917:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2917:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2917:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==36) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2918:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2918:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2919:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleDataTypeName5288);
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

            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2941:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2942:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2942:1: ( RULE_ID )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2943:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDataTypeNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataTypeName5307); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2963:1: entryRuleNumberLiteralRule returns [EObject current=null] : iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF ;
    public final EObject entryRuleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2964:2: (iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2965:2: iv_ruleNumberLiteralRule= ruleNumberLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumberLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5343);
            iv_ruleNumberLiteralRule=ruleNumberLiteralRule();
            _fsp--;

             current =iv_ruleNumberLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule5353); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2972:1: ruleNumberLiteralRule returns [EObject current=null] : (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) ;
    public final EObject ruleNumberLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerLiteralRule_0 = null;

        EObject this_UnlimitedLiteralRule_1 = null;

        EObject this_RealLiteralRule_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2977:6: ( (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2978:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2978:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )
            int alt43=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
                {
                alt43=1;
                }
                break;
            case 29:
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
                    new NoViableAltException("2978:1: (this_IntegerLiteralRule_0= ruleIntegerLiteralRule | this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule | this_RealLiteralRule_2= ruleRealLiteralRule )", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2979:5: this_IntegerLiteralRule_0= ruleIntegerLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5400);
                    this_IntegerLiteralRule_0=ruleIntegerLiteralRule();
                    _fsp--;

                     
                            current = this_IntegerLiteralRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2989:5: this_UnlimitedLiteralRule_1= ruleUnlimitedLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5427);
                    this_UnlimitedLiteralRule_1=ruleUnlimitedLiteralRule();
                    _fsp--;

                     
                            current = this_UnlimitedLiteralRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:2999:5: this_RealLiteralRule_2= ruleRealLiteralRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5454);
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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3015:1: entryRuleIntegerLiteralRule returns [EObject current=null] : iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF ;
    public final EObject entryRuleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3016:2: (iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3017:2: iv_ruleIntegerLiteralRule= ruleIntegerLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5489);
            iv_ruleIntegerLiteralRule=ruleIntegerLiteralRule();
            _fsp--;

             current =iv_ruleIntegerLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule5499); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3024:1: ruleIntegerLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) ;
    public final EObject ruleIntegerLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3029:6: ( ( (lv_value_0_0= RULE_INTEGERLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3030:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3030:1: ( (lv_value_0_0= RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3031:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3031:1: (lv_value_0_0= RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3032:3: lv_value_0_0= RULE_INTEGERLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5540); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3062:1: entryRuleUnlimitedLiteralRule returns [EObject current=null] : iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF ;
    public final EObject entryRuleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3063:2: (iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3064:2: iv_ruleUnlimitedLiteralRule= ruleUnlimitedLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnlimitedLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5580);
            iv_ruleUnlimitedLiteralRule=ruleUnlimitedLiteralRule();
            _fsp--;

             current =iv_ruleUnlimitedLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5590); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3071:1: ruleUnlimitedLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '*' ) ) ;
    public final EObject ruleUnlimitedLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3076:6: ( ( (lv_value_0_0= '*' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3077:1: ( (lv_value_0_0= '*' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3077:1: ( (lv_value_0_0= '*' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3078:1: (lv_value_0_0= '*' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3078:1: (lv_value_0_0= '*' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3079:3: lv_value_0_0= '*'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,29,FOLLOW_29_in_ruleUnlimitedLiteralRule5632); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3106:1: entryRuleRealLiteralRule returns [EObject current=null] : iv_ruleRealLiteralRule= ruleRealLiteralRule EOF ;
    public final EObject entryRuleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3107:2: (iv_ruleRealLiteralRule= ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3108:2: iv_ruleRealLiteralRule= ruleRealLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5680);
            iv_ruleRealLiteralRule=ruleRealLiteralRule();
            _fsp--;

             current =iv_ruleRealLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule5690); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3115:1: ruleRealLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_REALLITERAL ) ) ;
    public final EObject ruleRealLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3120:6: ( ( (lv_value_0_0= RULE_REALLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3121:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3121:1: ( (lv_value_0_0= RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3122:1: (lv_value_0_0= RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3122:1: (lv_value_0_0= RULE_REALLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3123:3: lv_value_0_0= RULE_REALLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5731); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3153:1: entryRuleDateTimeLiteralRule returns [EObject current=null] : iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF ;
    public final EObject entryRuleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateTimeLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3154:2: (iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3155:2: iv_ruleDateTimeLiteralRule= ruleDateTimeLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDateTimeLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5771);
            iv_ruleDateTimeLiteralRule=ruleDateTimeLiteralRule();
            _fsp--;

             current =iv_ruleDateTimeLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5781); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3162:1: ruleDateTimeLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) ;
    public final EObject ruleDateTimeLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3167:6: ( ( (lv_value_0_0= RULE_DATETIMELITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3168:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3168:1: ( (lv_value_0_0= RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3169:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3169:1: (lv_value_0_0= RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3170:3: lv_value_0_0= RULE_DATETIMELITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule5822); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3200:1: entryRuleBooleanLiteralRule returns [EObject current=null] : iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF ;
    public final EObject entryRuleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3201:2: (iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3202:2: iv_ruleBooleanLiteralRule= ruleBooleanLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule5862);
            iv_ruleBooleanLiteralRule=ruleBooleanLiteralRule();
            _fsp--;

             current =iv_ruleBooleanLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule5872); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3209:1: ruleBooleanLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) ;
    public final EObject ruleBooleanLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3214:6: ( ( (lv_value_0_0= RULE_BOOLEANLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3215:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3215:1: ( (lv_value_0_0= RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3216:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3216:1: (lv_value_0_0= RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3217:3: lv_value_0_0= RULE_BOOLEANLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule5913); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3247:1: entryRuleNullLiteralRule returns [EObject current=null] : iv_ruleNullLiteralRule= ruleNullLiteralRule EOF ;
    public final EObject entryRuleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3248:2: (iv_ruleNullLiteralRule= ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3249:2: iv_ruleNullLiteralRule= ruleNullLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule5953);
            iv_ruleNullLiteralRule=ruleNullLiteralRule();
            _fsp--;

             current =iv_ruleNullLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule5963); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3256:1: ruleNullLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_NULLLITERAL ) ) ;
    public final EObject ruleNullLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3261:6: ( ( (lv_value_0_0= RULE_NULLLITERAL ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3262:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3262:1: ( (lv_value_0_0= RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3263:1: (lv_value_0_0= RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3263:1: (lv_value_0_0= RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3264:3: lv_value_0_0= RULE_NULLLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6004); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3294:1: entryRuleDefaultLiteralRule returns [EObject current=null] : iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF ;
    public final EObject entryRuleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3295:2: (iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3296:2: iv_ruleDefaultLiteralRule= ruleDefaultLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefaultLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6044);
            iv_ruleDefaultLiteralRule=ruleDefaultLiteralRule();
            _fsp--;

             current =iv_ruleDefaultLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule6054); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3303:1: ruleDefaultLiteralRule returns [EObject current=null] : ( (lv_value_0_0= '/' ) ) ;
    public final EObject ruleDefaultLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3308:6: ( ( (lv_value_0_0= '/' ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3309:1: ( (lv_value_0_0= '/' ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3309:1: ( (lv_value_0_0= '/' ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3310:1: (lv_value_0_0= '/' )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3310:1: (lv_value_0_0= '/' )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3311:3: lv_value_0_0= '/'
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,30,FOLLOW_30_in_ruleDefaultLiteralRule6096); 

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3338:1: entryRuleStringLiteralRule returns [EObject current=null] : iv_ruleStringLiteralRule= ruleStringLiteralRule EOF ;
    public final EObject entryRuleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralRule = null;


        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3339:2: (iv_ruleStringLiteralRule= ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3340:2: iv_ruleStringLiteralRule= ruleStringLiteralRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6144);
            iv_ruleStringLiteralRule=ruleStringLiteralRule();
            _fsp--;

             current =iv_ruleStringLiteralRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule6154); 

            }

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
    // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3347:1: ruleStringLiteralRule returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralRule() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3352:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3353:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3353:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3354:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3354:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.constraintwithvsl.editor.xtext/src-gen/org/eclipse/papyrus/constraintwithvsl/editor/xtext/parser/antlr/internal/InternalConstraintWithVSLl.g:3355:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteralRule6195); 

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
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_ruleExpression311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression402 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_16_in_ruleAndOrXorExpression423 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_17_in_ruleAndOrXorExpression452 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_18_in_ruleAndOrXorExpression481 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndOrXorExpression518 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression612 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_ruleEqualityExpression633 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_20_in_ruleEqualityExpression662 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression699 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression793 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_21_in_ruleRelationalExpression814 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_22_in_ruleRelationalExpression843 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_23_in_ruleRelationalExpression872 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_24_in_ruleRelationalExpression901 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleRelationalExpression938 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1032 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleConditionalExpression1051 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1085 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleConditionalExpression1095 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleConditionalExpression1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression1154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1210 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_ruleAdditiveExpression1231 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_28_in_ruleAdditiveExpression1260 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression1297 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression1335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1391 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_29_in_ruleMultiplicativeExpression1412 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_30_in_ruleMultiplicativeExpression1441 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_31_in_ruleMultiplicativeExpression1470 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression1507 = new BitSet(new long[]{0x00000000E0000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression1545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleUnaryExpression1601 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_28_in_ruleUnaryExpression1630 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_27_in_ruleUnaryExpression1659 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleUnaryExpression1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rulePrimaryExpression1816 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_rulePrimaryExpression1827 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePrimaryExpression1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification1886 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification1896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleValueSpecification1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_ruleValueSpecification1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleValueSpecification1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_ruleValueSpecification2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleValueSpecification2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_ruleValueSpecification2078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleValueSpecification2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleValueSpecification2121 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueSpecification2143 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleValueSpecification2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression2189 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression2308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression2318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyCallExpression2361 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_rulePropertyCallExpression2372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression2393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression2431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpression2484 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleOperationCallExpression2494 = new BitSet(new long[]{0x000FD16D780007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleOperationCallExpression2515 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleOperationCallExpression2526 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleOperationCallExpression2537 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral2596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_ruleLiteral2653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_ruleLiteral2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_ruleLiteral2707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_ruleLiteral2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_ruleLiteral2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_ruleLiteral2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall2823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall2833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNameOrChoiceOrBehaviorCall2879 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameOrChoiceOrBehaviorCall2898 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleNameOrChoiceOrBehaviorCall2909 = new BitSet(new long[]{0x000FD16D780007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleNameOrChoiceOrBehaviorCall2930 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleNameOrChoiceOrBehaviorCall2941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3032 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleQualifiedName3042 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName3063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval3100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleInterval3146 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_38_in_ruleInterval3170 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3205 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleInterval3215 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInterval3236 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_37_in_ruleInterval3255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleInterval3284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple3321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleCollectionOrTuple3366 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleListOfValues_in_ruleCollectionOrTuple3387 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleCollectionOrTuple3397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple3433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleTuple3478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_ruleTuple3499 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleTuple3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues3545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3601 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleListOfValues3612 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleListOfValues3633 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs3671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3727 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleListOfValueNamePairs3738 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_ruleListOfValueNamePairs3759 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair3797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair3807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueNamePair3850 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleValueNamePair3860 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueNamePair3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression3917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression3927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleTimeExpression3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_ruleTimeExpression4001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_ruleTimeExpression4028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression4063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression4073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleInstantObsExpression4108 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_ruleInstantObsExpression4129 = new BitSet(new long[]{0x0000200400000002L});
    public static final BitSet FOLLOW_34_in_ruleInstantObsExpression4140 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4161 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleInstantObsExpression4171 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleInstantObsExpression4184 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleInstantObsExpression4194 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInstantObsExpression4215 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleInstantObsExpression4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName4263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName4273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstantObsName4319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstantObsName4338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression4374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression4384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleDurationObsExpression4419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_ruleDurationObsExpression4440 = new BitSet(new long[]{0x0000200400000002L});
    public static final BitSet FOLLOW_34_in_ruleDurationObsExpression4451 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4472 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleDurationObsExpression4482 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleDurationObsExpression4495 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleDurationObsExpression4505 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDurationObsExpression4526 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleDurationObsExpression4536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName4574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName4584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDurationObsName4630 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDurationObsName4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp4685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp4695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleJitterExp4730 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4751 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_ruleJitterExp4762 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_ruleJitterExp4783 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleJitterExp4795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration4831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration4841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_ruleVariableDeclaration4887 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleVariableDeclaration4898 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration4915 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_26_in_ruleVariableDeclaration4932 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_ruleVariableDeclaration4953 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleVariableDeclaration4964 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleVariableDeclaration4974 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration4995 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleVariableDeclaration5005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleVariableDeclaration5025 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleVariableDeclaration5035 = new BitSet(new long[]{0x000FD165780007F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration5056 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleVariableDeclaration5066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind5105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind5116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleVariableDirectionKind5154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleVariableDirectionKind5173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleVariableDirectionKind5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName5232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName5242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDataTypeName5288 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataTypeName5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule5343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule5353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_ruleNumberLiteralRule5400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_ruleNumberLiteralRule5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_ruleNumberLiteralRule5454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule5489 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule5499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_ruleIntegerLiteralRule5540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule5580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule5590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleUnlimitedLiteralRule5632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule5680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule5690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_ruleRealLiteralRule5731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule5771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule5781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_ruleDateTimeLiteralRule5822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule5862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule5872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_ruleBooleanLiteralRule5913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule5953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule5963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_ruleNullLiteralRule6004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule6044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule6054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDefaultLiteralRule6096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule6144 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule6154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteralRule6195 = new BitSet(new long[]{0x0000000000000002L});

}