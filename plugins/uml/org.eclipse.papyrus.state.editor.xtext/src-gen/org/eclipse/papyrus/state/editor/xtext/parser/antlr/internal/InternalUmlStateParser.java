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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'::'", "'entry'", "'do'", "'exit'", "'Activity'", "'StateMachine'", "'OpaqueBehavior'"
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
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:87:1: ruleStateRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleStateRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_submachine_2_0 = null;

        EObject lv_entry_4_0 = null;

        EObject lv_do_5_0 = null;

        EObject lv_exit_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:92:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* ) ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:93:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* ) ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:93:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:93:2: ( (lv_name_0_0= RULE_ID ) ) ( ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )? ( ( ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* ) ) )
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

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:117:2: ( ':' ( (lv_submachine_2_0= ruleSubmachineRule ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:117:4: ':' ( (lv_submachine_2_0= ruleSubmachineRule ) )
                    {
                    match(input,11,FOLLOW_11_in_ruleStateRule143); 

                            createLeafNode(grammarAccess.getStateRuleAccess().getColonKeyword_1_0(), null); 
                        
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:121:1: ( (lv_submachine_2_0= ruleSubmachineRule ) )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:122:1: (lv_submachine_2_0= ruleSubmachineRule )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:122:1: (lv_submachine_2_0= ruleSubmachineRule )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:123:3: lv_submachine_2_0= ruleSubmachineRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStateRuleAccess().getSubmachineSubmachineRuleParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSubmachineRule_in_ruleStateRule164);
                    lv_submachine_2_0=ruleSubmachineRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStateRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"submachine",
                    	        		lv_submachine_2_0, 
                    	        		"SubmachineRule", 
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

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:145:4: ( ( ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:147:1: ( ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:147:1: ( ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:148:2: ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
            	
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:151:2: ( ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )* )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:152:3: ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )*
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:152:3: ( ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) ) | ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) ) | ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) ) )*
            loop2:
            do {
                int alt2=4;
                int LA2_0 = input.LA(1);

                if ( LA2_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0) ) {
                    alt2=1;
                }
                else if ( LA2_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1) ) {
                    alt2=2;
                }
                else if ( LA2_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2) ) {
                    alt2=3;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:154:4: ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:154:4: ({...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:155:5: {...}? => ( ( (lv_entry_4_0= ruleEntryRule ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStateRule", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:155:106: ( ( (lv_entry_4_0= ruleEntryRule ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:156:6: ( (lv_entry_4_0= ruleEntryRule ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0);
            	    	 				
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:159:6: ( (lv_entry_4_0= ruleEntryRule ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:160:1: (lv_entry_4_0= ruleEntryRule )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:160:1: (lv_entry_4_0= ruleEntryRule )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:161:3: lv_entry_4_0= ruleEntryRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_2_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEntryRule_in_ruleStateRule229);
            	    lv_entry_4_0=ruleEntryRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"entry",
            	    	        		lv_entry_4_0, 
            	    	        		"EntryRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:190:4: ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:190:4: ({...}? => ( ( (lv_do_5_0= ruleDoRule ) ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:191:5: {...}? => ( ( (lv_do_5_0= ruleDoRule ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStateRule", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:191:106: ( ( (lv_do_5_0= ruleDoRule ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:192:6: ( (lv_do_5_0= ruleDoRule ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1);
            	    	 				
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:195:6: ( (lv_do_5_0= ruleDoRule ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:196:1: (lv_do_5_0= ruleDoRule )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:196:1: (lv_do_5_0= ruleDoRule )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:197:3: lv_do_5_0= ruleDoRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleDoRule_in_ruleStateRule300);
            	    lv_do_5_0=ruleDoRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"do",
            	    	        		lv_do_5_0, 
            	    	        		"DoRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:226:4: ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:226:4: ({...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:227:5: {...}? => ( ( (lv_exit_6_0= ruleExitRule ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStateRule", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:227:106: ( ( (lv_exit_6_0= ruleExitRule ) ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:228:6: ( (lv_exit_6_0= ruleExitRule ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2);
            	    	 				
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:231:6: ( (lv_exit_6_0= ruleExitRule ) )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:232:1: (lv_exit_6_0= ruleExitRule )
            	    {
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:232:1: (lv_exit_6_0= ruleExitRule )
            	    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:233:3: lv_exit_6_0= ruleExitRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_2_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExitRule_in_ruleStateRule371);
            	    lv_exit_6_0=ruleExitRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"exit",
            	    	        		lv_exit_6_0, 
            	    	        		"ExitRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
            	

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


    // $ANTLR start entryRuleSubmachineRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:277:1: entryRuleSubmachineRule returns [EObject current=null] : iv_ruleSubmachineRule= ruleSubmachineRule EOF ;
    public final EObject entryRuleSubmachineRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubmachineRule = null;


        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:278:2: (iv_ruleSubmachineRule= ruleSubmachineRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:279:2: iv_ruleSubmachineRule= ruleSubmachineRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubmachineRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubmachineRule_in_entryRuleSubmachineRule446);
            iv_ruleSubmachineRule=ruleSubmachineRule();
            _fsp--;

             current =iv_ruleSubmachineRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubmachineRule456); 

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
    // $ANTLR end entryRuleSubmachineRule


    // $ANTLR start ruleSubmachineRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:286:1: ruleSubmachineRule returns [EObject current=null] : ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleSubmachineRule() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:291:6: ( ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:292:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:292:1: ( ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:292:2: ( (lv_path_0_0= ruleQualifiedName ) )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:292:2: ( (lv_path_0_0= ruleQualifiedName ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==12) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:293:1: (lv_path_0_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:293:1: (lv_path_0_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:294:3: lv_path_0_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSubmachineRuleAccess().getPathQualifiedNameParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSubmachineRule502);
                    lv_path_0_0=ruleQualifiedName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubmachineRuleRule().getType().getClassifier());
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

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:316:3: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:317:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:317:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:318:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubmachineRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubmachineRule521); 

            		createLeafNode(grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineCrossReference_1_0(), "submachine"); 
            	

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
    // $ANTLR end ruleSubmachineRule


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:338:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:339:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:340:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName557);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName567); 

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
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:347:1: ruleQualifiedName returns [EObject current=null] : ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject lv_remaining_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:352:6: ( ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:353:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:353:1: ( ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )? )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:353:2: ( ( RULE_ID ) ) '::' ( (lv_remaining_2_0= ruleQualifiedName ) )?
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:353:2: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:354:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:354:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:355:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName610); 

            		createLeafNode(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(), "path"); 
            	

            }


            }

            match(input,12,FOLLOW_12_in_ruleQualifiedName620); 

                    createLeafNode(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1(), null); 
                
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:371:1: ( (lv_remaining_2_0= ruleQualifiedName ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==12) ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:372:1: (lv_remaining_2_0= ruleQualifiedName )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:372:1: (lv_remaining_2_0= ruleQualifiedName )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:373:3: lv_remaining_2_0= ruleQualifiedName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedName641);
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


    // $ANTLR start entryRuleEntryRule
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:403:1: entryRuleEntryRule returns [EObject current=null] : iv_ruleEntryRule= ruleEntryRule EOF ;
    public final EObject entryRuleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntryRule = null;


        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:404:2: (iv_ruleEntryRule= ruleEntryRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:405:2: iv_ruleEntryRule= ruleEntryRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntryRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntryRule_in_entryRuleEntryRule678);
            iv_ruleEntryRule=ruleEntryRule();
            _fsp--;

             current =iv_ruleEntryRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryRule688); 

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
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:412:1: ruleEntryRule returns [EObject current=null] : ( 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        Token lv_behaviorName_2_0=null;
        Enumerator lv_kind_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:417:6: ( ( 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:418:1: ( 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:418:1: ( 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:418:3: 'entry' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
            {
            match(input,13,FOLLOW_13_in_ruleEntryRule723); 

                    createLeafNode(grammarAccess.getEntryRuleAccess().getEntryKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:422:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:423:1: (lv_kind_1_0= ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:423:1: (lv_kind_1_0= ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:424:3: lv_kind_1_0= ruleBehaviorKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBehaviorKind_in_ruleEntryRule744);
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

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:446:2: ( (lv_behaviorName_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:447:1: (lv_behaviorName_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:447:1: (lv_behaviorName_2_0= RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:448:3: lv_behaviorName_2_0= RULE_ID
            {
            lv_behaviorName_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntryRule761); 

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
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:478:1: entryRuleDoRule returns [EObject current=null] : iv_ruleDoRule= ruleDoRule EOF ;
    public final EObject entryRuleDoRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoRule = null;


        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:479:2: (iv_ruleDoRule= ruleDoRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:480:2: iv_ruleDoRule= ruleDoRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoRule_in_entryRuleDoRule802);
            iv_ruleDoRule=ruleDoRule();
            _fsp--;

             current =iv_ruleDoRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoRule812); 

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
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:487:1: ruleDoRule returns [EObject current=null] : ( 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
    public final EObject ruleDoRule() throws RecognitionException {
        EObject current = null;

        Token lv_behaviorName_2_0=null;
        Enumerator lv_kind_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:492:6: ( ( 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:493:1: ( 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:493:1: ( 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:493:3: 'do' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
            {
            match(input,14,FOLLOW_14_in_ruleDoRule847); 

                    createLeafNode(grammarAccess.getDoRuleAccess().getDoKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:497:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:498:1: (lv_kind_1_0= ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:498:1: (lv_kind_1_0= ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:499:3: lv_kind_1_0= ruleBehaviorKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBehaviorKind_in_ruleDoRule868);
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

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:521:2: ( (lv_behaviorName_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:522:1: (lv_behaviorName_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:522:1: (lv_behaviorName_2_0= RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:523:3: lv_behaviorName_2_0= RULE_ID
            {
            lv_behaviorName_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoRule885); 

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
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:553:1: entryRuleExitRule returns [EObject current=null] : iv_ruleExitRule= ruleExitRule EOF ;
    public final EObject entryRuleExitRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitRule = null;


        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:554:2: (iv_ruleExitRule= ruleExitRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:555:2: iv_ruleExitRule= ruleExitRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExitRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleExitRule_in_entryRuleExitRule926);
            iv_ruleExitRule=ruleExitRule();
            _fsp--;

             current =iv_ruleExitRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitRule936); 

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
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:562:1: ruleExitRule returns [EObject current=null] : ( 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
    public final EObject ruleExitRule() throws RecognitionException {
        EObject current = null;

        Token lv_behaviorName_2_0=null;
        Enumerator lv_kind_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:567:6: ( ( 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:568:1: ( 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:568:1: ( 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:568:3: 'exit' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
            {
            match(input,15,FOLLOW_15_in_ruleExitRule971); 

                    createLeafNode(grammarAccess.getExitRuleAccess().getExitKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:572:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:573:1: (lv_kind_1_0= ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:573:1: (lv_kind_1_0= ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:574:3: lv_kind_1_0= ruleBehaviorKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBehaviorKind_in_ruleExitRule992);
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

            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:596:2: ( (lv_behaviorName_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:597:1: (lv_behaviorName_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:597:1: (lv_behaviorName_2_0= RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:598:3: lv_behaviorName_2_0= RULE_ID
            {
            lv_behaviorName_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExitRule1009); 

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
    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:628:1: ruleBehaviorKind returns [Enumerator current=null] : ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) ) ;
    public final Enumerator ruleBehaviorKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:632:6: ( ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:633:1: ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:633:1: ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case 18:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("633:1: ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:633:2: ( 'Activity' )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:633:2: ( 'Activity' )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:633:4: 'Activity'
                    {
                    match(input,16,FOLLOW_16_in_ruleBehaviorKind1062); 

                            current = grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:639:6: ( 'StateMachine' )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:639:6: ( 'StateMachine' )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:639:8: 'StateMachine'
                    {
                    match(input,17,FOLLOW_17_in_ruleBehaviorKind1077); 

                            current = grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:645:6: ( 'OpaqueBehavior' )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:645:6: ( 'OpaqueBehavior' )
                    // ../org.eclipse.papyrus.state.editor.xtext/src-gen/org/eclipse/papyrus/state/editor/xtext/parser/antlr/internal/InternalUmlState.g:645:8: 'OpaqueBehavior'
                    {
                    match(input,18,FOLLOW_18_in_ruleBehaviorKind1092); 

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
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateRule127 = new BitSet(new long[]{0x000000000000E802L});
    public static final BitSet FOLLOW_11_in_ruleStateRule143 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSubmachineRule_in_ruleStateRule164 = new BitSet(new long[]{0x000000000000E002L});
    public static final BitSet FOLLOW_ruleEntryRule_in_ruleStateRule229 = new BitSet(new long[]{0x000000000000E002L});
    public static final BitSet FOLLOW_ruleDoRule_in_ruleStateRule300 = new BitSet(new long[]{0x000000000000E002L});
    public static final BitSet FOLLOW_ruleExitRule_in_ruleStateRule371 = new BitSet(new long[]{0x000000000000E002L});
    public static final BitSet FOLLOW_ruleSubmachineRule_in_entryRuleSubmachineRule446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubmachineRule456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSubmachineRule502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubmachineRule521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName610 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleQualifiedName620 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedName641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryRule_in_entryRuleEntryRule678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryRule688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleEntryRule723 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_ruleEntryRule744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntryRule761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoRule_in_entryRuleDoRule802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoRule812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleDoRule847 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_ruleDoRule868 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoRule885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitRule_in_entryRuleExitRule926 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitRule936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleExitRule971 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_ruleExitRule992 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExitRule1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleBehaviorKind1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleBehaviorKind1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleBehaviorKind1092 = new BitSet(new long[]{0x0000000000000002L});

}
