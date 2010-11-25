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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.common.editor.xtext.parser.antlr.internal; 

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
import org.eclipse.papyrus.common.editor.xtext.services.UmlCommonGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlCommonParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'::'"
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

        public InternalUmlCommonParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g"; }



     	private UmlCommonGrammarAccess grammarAccess;
     	
        public InternalUmlCommonParser(TokenStream input, IAstFactory factory, UmlCommonGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "QualifiedName";	
       	}
       	
       	@Override
       	protected UmlCommonGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:78:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:79:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:80:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName75);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName85); 

            }

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
    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:87:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:92:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:93:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:93:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:93:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:93:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:94:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:94:1: ( RULE_ID )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:95:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName128); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,12,FOLLOW_12_in_ruleQualifiedName138); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:111:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:112:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:112:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:113:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName159);
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


    // $ANTLR start entryRuleBoundSpecification
    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:145:1: entryRuleBoundSpecification returns [EObject current=null] : iv_ruleBoundSpecification= ruleBoundSpecification EOF ;
    public final EObject entryRuleBoundSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundSpecification = null;


        try {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:146:2: (iv_ruleBoundSpecification= ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:147:2: iv_ruleBoundSpecification= ruleBoundSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBoundSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification198);
            iv_ruleBoundSpecification=ruleBoundSpecification();
            _fsp--;

             current =iv_ruleBoundSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification208); 

            }

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
    // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:154:1: ruleBoundSpecification returns [EObject current=null] : ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) ;
    public final EObject ruleBoundSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:159:6: ( ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) ) )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:160:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:160:1: ( (lv_value_0_0= RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:161:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:161:1: (lv_value_0_0= RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.common.editor.xtext/src-gen/org/eclipse/papyrus/common/editor/xtext/parser/antlr/internal/InternalUmlCommon.g:162:3: lv_value_0_0= RULE_UNLIMITEDLITERAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification249); 

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


 

    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName128 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedName138 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_ruleBoundSpecification249 = new BitSet(new long[]{0x0000000000000002L});

}