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
package org.eclipse.papyrus.state.editor.xtext.parser.antlr.internal; 

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
import org.eclipse.papyrus.state.editor.xtext.services.UmlStateGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlStateParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entry'", "'do'", "'exit'", "'Activity'", "'StateMachine'", "'OpaqueBehavior'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalUmlStateParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g"; }



     	private UmlStateGrammarAccess grammarAccess;
     	
        public InternalUmlStateParser(TokenStream input, IAstFactory factory, UmlStateGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "StateRule";	
       	}
       	
       	@Override
       	protected UmlStateGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleStateRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:78:1: entryRuleStateRule returns [EObject current=null] : iv_ruleStateRule= ruleStateRule EOF ;
    public final EObject entryRuleStateRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateRule = null;


        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:79:2: (iv_ruleStateRule= ruleStateRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:80:2: iv_ruleStateRule= ruleStateRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleStateRule_in_entryRuleStateRule75);
            iv_ruleStateRule=ruleStateRule();
            _fsp--;

             current =iv_ruleStateRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateRule85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStateRule


    // $ANTLR start ruleStateRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:87:1: ruleStateRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleStateRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_entry_2_0 = null;

        EObject lv_do_3_0 = null;

        EObject lv_exit_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:92:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* ) ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:93:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* ) ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:93:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:93:2: ( (lv_name_0_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:93:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:94:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:94:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:95:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateRule127); 

            			createLeafNode(grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStateRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:117:2: ( ( ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:119:1: ( ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:119:1: ( ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:120:2: ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getStateRuleAccess().getUnorderedGroup_1());
            	
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:123:2: ( ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )* )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:124:3: ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )*
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:124:3: ( ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) ) )*
            loop1:
            do {
                int alt1=4;
                int LA1_0 = input.LA(1);

                if ( LA1_0 ==11 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0) ) {
                    alt1=1;
                }
                else if ( LA1_0 ==12 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1) ) {
                    alt1=2;
                }
                else if ( LA1_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2) ) {
                    alt1=3;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:126:4: ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:126:4: ({...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:127:5: {...}? => ( ( (lv_entry_2_0= ruleEntryRule ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStateRule", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:127:106: ( ( (lv_entry_2_0= ruleEntryRule ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:128:6: ( (lv_entry_2_0= ruleEntryRule ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0);
            	    	 				
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:131:6: ( (lv_entry_2_0= ruleEntryRule ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:132:1: (lv_entry_2_0= ruleEntryRule )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:132:1: (lv_entry_2_0= ruleEntryRule )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:133:3: lv_entry_2_0= ruleEntryRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_1_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEntryRule_in_ruleStateRule195);
            	    lv_entry_2_0=ruleEntryRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"entry",
            	    	        		lv_entry_2_0, 
            	    	        		"EntryRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:162:4: ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:162:4: ({...}? => ( ( (lv_do_3_0= ruleDoRule ) ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:163:5: {...}? => ( ( (lv_do_3_0= ruleDoRule ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStateRule", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:163:106: ( ( (lv_do_3_0= ruleDoRule ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:164:6: ( (lv_do_3_0= ruleDoRule ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1);
            	    	 				
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:167:6: ( (lv_do_3_0= ruleDoRule ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:168:1: (lv_do_3_0= ruleDoRule )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:168:1: (lv_do_3_0= ruleDoRule )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:169:3: lv_do_3_0= ruleDoRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDoRule_in_ruleStateRule266);
            	    lv_do_3_0=ruleDoRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"do",
            	    	        		lv_do_3_0, 
            	    	        		"DoRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:198:4: ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:198:4: ({...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:199:5: {...}? => ( ( (lv_exit_4_0= ruleExitRule ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStateRule", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:199:106: ( ( (lv_exit_4_0= ruleExitRule ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:200:6: ( (lv_exit_4_0= ruleExitRule ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2);
            	    	 				
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:203:6: ( (lv_exit_4_0= ruleExitRule ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:204:1: (lv_exit_4_0= ruleExitRule )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:204:1: (lv_exit_4_0= ruleExitRule )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:205:3: lv_exit_4_0= ruleExitRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExitRule_in_ruleStateRule337);
            	    lv_exit_4_0=ruleExitRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"exit",
            	    	        		lv_exit_4_0, 
            	    	        		"ExitRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_1());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getStateRuleAccess().getUnorderedGroup_1());
            	

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
    // $ANTLR end ruleStateRule


    // $ANTLR start entryRuleEntryRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:249:1: entryRuleEntryRule returns [EObject current=null] : iv_ruleEntryRule= ruleEntryRule EOF ;
    public final EObject entryRuleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryRule = null;


        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:250:2: (iv_ruleEntryRule= ruleEntryRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:251:2: iv_ruleEntryRule= ruleEntryRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryRule_in_entryRuleEntryRule412);
            iv_ruleEntryRule=ruleEntryRule();
            _fsp--;

             current =iv_ruleEntryRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryRule422); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEntryRule


    // $ANTLR start ruleEntryRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:258:1: ruleEntryRule returns [EObject current=null] : ( 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        Token lv_behaviorName_2_0=null;
        Enumerator lv_kind_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:263:6: ( ( 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:264:1: ( 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:264:1: ( 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:264:3: 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
            {
            match(input,11,FOLLOW_11_in_ruleEntryRule457); 

                    createLeafNode(grammarAccess.getEntryRuleAccess().getEntryKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:268:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:269:1: (lv_kind_1_0= ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:269:1: (lv_kind_1_0= ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:270:3: lv_kind_1_0= ruleBehaviorKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBehaviorKind_in_ruleEntryRule478);
            lv_kind_1_0=ruleBehaviorKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntryRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"kind",
            	        		lv_kind_1_0, 
            	        		"BehaviorKind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:292:2: ( (lv_behaviorName_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:293:1: (lv_behaviorName_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:293:1: (lv_behaviorName_2_0= RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:294:3: lv_behaviorName_2_0= RULE_ID
            {
            lv_behaviorName_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryRule495); 

            			createLeafNode(grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), "behaviorName"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntryRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"behaviorName",
            	        		lv_behaviorName_2_0, 
            	        		"ID", 
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
    // $ANTLR end ruleEntryRule


    // $ANTLR start entryRuleDoRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:324:1: entryRuleDoRule returns [EObject current=null] : iv_ruleDoRule= ruleDoRule EOF ;
    public final EObject entryRuleDoRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoRule = null;


        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:325:2: (iv_ruleDoRule= ruleDoRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:326:2: iv_ruleDoRule= ruleDoRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoRule_in_entryRuleDoRule536);
            iv_ruleDoRule=ruleDoRule();
            _fsp--;

             current =iv_ruleDoRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoRule546); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDoRule


    // $ANTLR start ruleDoRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:333:1: ruleDoRule returns [EObject current=null] : ( 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
    public final EObject ruleDoRule() throws RecognitionException {
        EObject current = null;

        Token lv_behaviorName_2_0=null;
        Enumerator lv_kind_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:338:6: ( ( 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:339:1: ( 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:339:1: ( 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:339:3: 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
            {
            match(input,12,FOLLOW_12_in_ruleDoRule581); 

                    createLeafNode(grammarAccess.getDoRuleAccess().getDoKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:343:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:344:1: (lv_kind_1_0= ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:344:1: (lv_kind_1_0= ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:345:3: lv_kind_1_0= ruleBehaviorKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBehaviorKind_in_ruleDoRule602);
            lv_kind_1_0=ruleBehaviorKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"kind",
            	        		lv_kind_1_0, 
            	        		"BehaviorKind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:367:2: ( (lv_behaviorName_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:368:1: (lv_behaviorName_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:368:1: (lv_behaviorName_2_0= RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:369:3: lv_behaviorName_2_0= RULE_ID
            {
            lv_behaviorName_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoRule619); 

            			createLeafNode(grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), "behaviorName"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"behaviorName",
            	        		lv_behaviorName_2_0, 
            	        		"ID", 
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
    // $ANTLR end ruleDoRule


    // $ANTLR start entryRuleExitRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:399:1: entryRuleExitRule returns [EObject current=null] : iv_ruleExitRule= ruleExitRule EOF ;
    public final EObject entryRuleExitRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitRule = null;


        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:400:2: (iv_ruleExitRule= ruleExitRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:401:2: iv_ruleExitRule= ruleExitRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExitRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleExitRule_in_entryRuleExitRule660);
            iv_ruleExitRule=ruleExitRule();
            _fsp--;

             current =iv_ruleExitRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitRule670); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExitRule


    // $ANTLR start ruleExitRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:408:1: ruleExitRule returns [EObject current=null] : ( 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
    public final EObject ruleExitRule() throws RecognitionException {
        EObject current = null;

        Token lv_behaviorName_2_0=null;
        Enumerator lv_kind_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:413:6: ( ( 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:414:1: ( 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:414:1: ( 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:414:3: 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
            {
            match(input,13,FOLLOW_13_in_ruleExitRule705); 

                    createLeafNode(grammarAccess.getExitRuleAccess().getExitKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:418:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:419:1: (lv_kind_1_0= ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:419:1: (lv_kind_1_0= ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:420:3: lv_kind_1_0= ruleBehaviorKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBehaviorKind_in_ruleExitRule726);
            lv_kind_1_0=ruleBehaviorKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExitRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"kind",
            	        		lv_kind_1_0, 
            	        		"BehaviorKind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:442:2: ( (lv_behaviorName_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:443:1: (lv_behaviorName_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:443:1: (lv_behaviorName_2_0= RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:444:3: lv_behaviorName_2_0= RULE_ID
            {
            lv_behaviorName_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitRule743); 

            			createLeafNode(grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), "behaviorName"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExitRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"behaviorName",
            	        		lv_behaviorName_2_0, 
            	        		"ID", 
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
    // $ANTLR end ruleExitRule


    // $ANTLR start ruleBehaviorKind
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:474:1: ruleBehaviorKind returns [Enumerator current=null] : ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) ) ;
    public final Enumerator ruleBehaviorKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:478:6: ( ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:479:1: ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:479:1: ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt2=1;
                }
                break;
            case 15:
                {
                alt2=2;
                }
                break;
            case 16:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("479:1: ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:479:2: ( 'Activity' )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:479:2: ( 'Activity' )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:479:4: 'Activity'
                    {
                    match(input,14,FOLLOW_14_in_ruleBehaviorKind796); 

                            current = grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:485:6: ( 'StateMachine' )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:485:6: ( 'StateMachine' )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:485:8: 'StateMachine'
                    {
                    match(input,15,FOLLOW_15_in_ruleBehaviorKind811); 

                            current = grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:491:6: ( 'OpaqueBehavior' )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:491:6: ( 'OpaqueBehavior' )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:491:8: 'OpaqueBehavior'
                    {
                    match(input,16,FOLLOW_16_in_ruleBehaviorKind826); 

                            current = grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2(), null); 
                        

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
    // $ANTLR end ruleBehaviorKind


 

    public static final BitSet FOLLOW_ruleStateRule_in_entryRuleStateRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateRule127 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_ruleEntryRule_in_ruleStateRule195 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_ruleDoRule_in_ruleStateRule266 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_ruleExitRule_in_ruleStateRule337 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_ruleEntryRule_in_entryRuleEntryRule412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryRule422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleEntryRule457 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_ruleEntryRule478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryRule495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoRule_in_entryRuleDoRule536 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoRule546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleDoRule581 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_ruleDoRule602 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoRule619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitRule_in_entryRuleExitRule660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitRule670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleExitRule705 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_ruleExitRule726 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitRule743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleBehaviorKind796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleBehaviorKind811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleBehaviorKind826 = new BitSet(new long[]{0x0000000000000002L});

}
