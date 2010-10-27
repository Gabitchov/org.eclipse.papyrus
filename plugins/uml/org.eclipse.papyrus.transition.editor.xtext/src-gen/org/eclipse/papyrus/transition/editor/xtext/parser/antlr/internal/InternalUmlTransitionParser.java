package org.eclipse.papyrus.transition.editor.xtext.parser.antlr.internal; 

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
import org.eclipse.papyrus.transition.editor.xtext.services.UmlTransitionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlTransitionParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "','", "'all'", "'after'", "'at'", "'when'", "'['", "']'", "'/'", "'Activity'", "'StateMachine'", "'OpaqueBehavior'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalUmlTransitionParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g"; }



     	private UmlTransitionGrammarAccess grammarAccess;
     	
        public InternalUmlTransitionParser(TokenStream input, IAstFactory factory, UmlTransitionGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TransitionRule";	
       	}
       	
       	@Override
       	protected UmlTransitionGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleTransitionRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:78:1: entryRuleTransitionRule returns [EObject current=null] : iv_ruleTransitionRule= ruleTransitionRule EOF ;
    public final EObject entryRuleTransitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:79:2: (iv_ruleTransitionRule= ruleTransitionRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:80:2: iv_ruleTransitionRule= ruleTransitionRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransitionRule_in_entryRuleTransitionRule75);
            iv_ruleTransitionRule=ruleTransitionRule();
            _fsp--;

             current =iv_ruleTransitionRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionRule85); 

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
    // $ANTLR end entryRuleTransitionRule


    // $ANTLR start ruleTransitionRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:87:1: ruleTransitionRule returns [EObject current=null] : ( ( ( (lv_triggers_0_0= ruleEventRule ) ) ( ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )? ) ;
    public final EObject ruleTransitionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_triggers_0_0 = null;

        EObject lv_triggers_2_0 = null;

        EObject lv_guard_3_0 = null;

        EObject lv_effect_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:92:6: ( ( ( ( (lv_triggers_0_0= ruleEventRule ) ) ( ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )? ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:93:1: ( ( ( (lv_triggers_0_0= ruleEventRule ) ) ( ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )? )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:93:1: ( ( ( (lv_triggers_0_0= ruleEventRule ) ) ( ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )? )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:93:2: ( ( (lv_triggers_0_0= ruleEventRule ) ) ( ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )?
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:93:2: ( ( (lv_triggers_0_0= ruleEventRule ) ) ( ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||(LA2_0>=12 && LA2_0<=15)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:93:3: ( (lv_triggers_0_0= ruleEventRule ) ) ( ',' ( (lv_triggers_2_0= ruleEventRule ) ) )*
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:93:3: ( (lv_triggers_0_0= ruleEventRule ) )
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:94:1: (lv_triggers_0_0= ruleEventRule )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:94:1: (lv_triggers_0_0= ruleEventRule )
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:95:3: lv_triggers_0_0= ruleEventRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEventRule_in_ruleTransitionRule132);
                    lv_triggers_0_0=ruleEventRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"triggers",
                    	        		lv_triggers_0_0, 
                    	        		"EventRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:117:2: ( ',' ( (lv_triggers_2_0= ruleEventRule ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==11) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:117:4: ',' ( (lv_triggers_2_0= ruleEventRule ) )
                    	    {
                    	    match(input,11,FOLLOW_11_in_ruleTransitionRule143); 

                    	            createLeafNode(grammarAccess.getTransitionRuleAccess().getCommaKeyword_0_1_0(), null); 
                    	        
                    	    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:121:1: ( (lv_triggers_2_0= ruleEventRule ) )
                    	    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:122:1: (lv_triggers_2_0= ruleEventRule )
                    	    {
                    	    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:122:1: (lv_triggers_2_0= ruleEventRule )
                    	    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:123:3: lv_triggers_2_0= ruleEventRule
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEventRule_in_ruleTransitionRule164);
                    	    lv_triggers_2_0=ruleEventRule();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getTransitionRuleRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"triggers",
                    	    	        		lv_triggers_2_0, 
                    	    	        		"EventRule", 
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
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:145:6: ( (lv_guard_3_0= ruleGuardRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:146:1: (lv_guard_3_0= ruleGuardRule )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:146:1: (lv_guard_3_0= ruleGuardRule )
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:147:3: lv_guard_3_0= ruleGuardRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleGuardRule_in_ruleTransitionRule189);
                    lv_guard_3_0=ruleGuardRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"guard",
                    	        		lv_guard_3_0, 
                    	        		"GuardRule", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:169:3: ( (lv_effect_4_0= ruleEffectRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:170:1: (lv_effect_4_0= ruleEffectRule )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:170:1: (lv_effect_4_0= ruleEffectRule )
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:171:3: lv_effect_4_0= ruleEffectRule
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getTransitionRuleAccess().getEffectEffectRuleParserRuleCall_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEffectRule_in_ruleTransitionRule211);
                    lv_effect_4_0=ruleEffectRule();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getTransitionRuleRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"effect",
                    	        		lv_effect_4_0, 
                    	        		"EffectRule", 
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
    // $ANTLR end ruleTransitionRule


    // $ANTLR start entryRuleEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:201:1: entryRuleEventRule returns [EObject current=null] : iv_ruleEventRule= ruleEventRule EOF ;
    public final EObject entryRuleEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:202:2: (iv_ruleEventRule= ruleEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:203:2: iv_ruleEventRule= ruleEventRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleEventRule_in_entryRuleEventRule248);
            iv_ruleEventRule=ruleEventRule();
            _fsp--;

             current =iv_ruleEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventRule258); 

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
    // $ANTLR end entryRuleEventRule


    // $ANTLR start ruleEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:210:1: ruleEventRule returns [EObject current=null] : (this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule | this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule | this_TimeEventRule_2= ruleTimeEventRule | this_ChangeEventRule_3= ruleChangeEventRule ) ;
    public final EObject ruleEventRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallOrSignalEventRule_0 = null;

        EObject this_AnyReceiveEventRule_1 = null;

        EObject this_TimeEventRule_2 = null;

        EObject this_ChangeEventRule_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:215:6: ( (this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule | this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule | this_TimeEventRule_2= ruleTimeEventRule | this_ChangeEventRule_3= ruleChangeEventRule ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:216:1: (this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule | this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule | this_TimeEventRule_2= ruleTimeEventRule | this_ChangeEventRule_3= ruleChangeEventRule )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:216:1: (this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule | this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule | this_TimeEventRule_2= ruleTimeEventRule | this_ChangeEventRule_3= ruleChangeEventRule )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case 12:
                {
                alt5=2;
                }
                break;
            case 13:
            case 14:
                {
                alt5=3;
                }
                break;
            case 15:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("216:1: (this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule | this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule | this_TimeEventRule_2= ruleTimeEventRule | this_ChangeEventRule_3= ruleChangeEventRule )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:217:5: this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventRuleAccess().getCallOrSignalEventRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCallOrSignalEventRule_in_ruleEventRule305);
                    this_CallOrSignalEventRule_0=ruleCallOrSignalEventRule();
                    _fsp--;

                     
                            current = this_CallOrSignalEventRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:227:5: this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventRuleAccess().getAnyReceiveEventRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAnyReceiveEventRule_in_ruleEventRule332);
                    this_AnyReceiveEventRule_1=ruleAnyReceiveEventRule();
                    _fsp--;

                     
                            current = this_AnyReceiveEventRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:237:5: this_TimeEventRule_2= ruleTimeEventRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventRuleAccess().getTimeEventRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTimeEventRule_in_ruleEventRule359);
                    this_TimeEventRule_2=ruleTimeEventRule();
                    _fsp--;

                     
                            current = this_TimeEventRule_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:247:5: this_ChangeEventRule_3= ruleChangeEventRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getEventRuleAccess().getChangeEventRuleParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChangeEventRule_in_ruleEventRule386);
                    this_ChangeEventRule_3=ruleChangeEventRule();
                    _fsp--;

                     
                            current = this_ChangeEventRule_3; 
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
    // $ANTLR end ruleEventRule


    // $ANTLR start entryRuleCallOrSignalEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:263:1: entryRuleCallOrSignalEventRule returns [EObject current=null] : iv_ruleCallOrSignalEventRule= ruleCallOrSignalEventRule EOF ;
    public final EObject entryRuleCallOrSignalEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallOrSignalEventRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:264:2: (iv_ruleCallOrSignalEventRule= ruleCallOrSignalEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:265:2: iv_ruleCallOrSignalEventRule= ruleCallOrSignalEventRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallOrSignalEventRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallOrSignalEventRule_in_entryRuleCallOrSignalEventRule421);
            iv_ruleCallOrSignalEventRule=ruleCallOrSignalEventRule();
            _fsp--;

             current =iv_ruleCallOrSignalEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallOrSignalEventRule431); 

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
    // $ANTLR end entryRuleCallOrSignalEventRule


    // $ANTLR start ruleCallOrSignalEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:272:1: ruleCallOrSignalEventRule returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleCallOrSignalEventRule() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:277:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:278:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:278:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:279:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:279:1: ( RULE_ID )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:280:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getCallOrSignalEventRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCallOrSignalEventRule473); 

            		createLeafNode(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementCrossReference_0(), "operationOrSignal"); 
            	

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
    // $ANTLR end ruleCallOrSignalEventRule


    // $ANTLR start entryRuleAnyReceiveEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:300:1: entryRuleAnyReceiveEventRule returns [EObject current=null] : iv_ruleAnyReceiveEventRule= ruleAnyReceiveEventRule EOF ;
    public final EObject entryRuleAnyReceiveEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnyReceiveEventRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:301:2: (iv_ruleAnyReceiveEventRule= ruleAnyReceiveEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:302:2: iv_ruleAnyReceiveEventRule= ruleAnyReceiveEventRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAnyReceiveEventRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleAnyReceiveEventRule_in_entryRuleAnyReceiveEventRule508);
            iv_ruleAnyReceiveEventRule=ruleAnyReceiveEventRule();
            _fsp--;

             current =iv_ruleAnyReceiveEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnyReceiveEventRule518); 

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
    // $ANTLR end entryRuleAnyReceiveEventRule


    // $ANTLR start ruleAnyReceiveEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:309:1: ruleAnyReceiveEventRule returns [EObject current=null] : ( (lv_isAReceiveEvent_0_0= 'all' ) ) ;
    public final EObject ruleAnyReceiveEventRule() throws RecognitionException {
        EObject current = null;

        Token lv_isAReceiveEvent_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:314:6: ( ( (lv_isAReceiveEvent_0_0= 'all' ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:315:1: ( (lv_isAReceiveEvent_0_0= 'all' ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:315:1: ( (lv_isAReceiveEvent_0_0= 'all' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:316:1: (lv_isAReceiveEvent_0_0= 'all' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:316:1: (lv_isAReceiveEvent_0_0= 'all' )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:317:3: lv_isAReceiveEvent_0_0= 'all'
            {
            lv_isAReceiveEvent_0_0=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_ruleAnyReceiveEventRule560); 

                    createLeafNode(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0(), "isAReceiveEvent"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAnyReceiveEventRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "isAReceiveEvent", lv_isAReceiveEvent_0_0, "all", lastConsumedNode);
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
    // $ANTLR end ruleAnyReceiveEventRule


    // $ANTLR start entryRuleTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:344:1: entryRuleTimeEventRule returns [EObject current=null] : iv_ruleTimeEventRule= ruleTimeEventRule EOF ;
    public final EObject entryRuleTimeEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeEventRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:345:2: (iv_ruleTimeEventRule= ruleTimeEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:346:2: iv_ruleTimeEventRule= ruleTimeEventRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTimeEventRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleTimeEventRule_in_entryRuleTimeEventRule608);
            iv_ruleTimeEventRule=ruleTimeEventRule();
            _fsp--;

             current =iv_ruleTimeEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeEventRule618); 

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
    // $ANTLR end entryRuleTimeEventRule


    // $ANTLR start ruleTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:353:1: ruleTimeEventRule returns [EObject current=null] : (this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule | this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule ) ;
    public final EObject ruleTimeEventRule() throws RecognitionException {
        EObject current = null;

        EObject this_RelativeTimeEventRule_0 = null;

        EObject this_AbsoluteTimeEventRule_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:358:6: ( (this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule | this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:359:1: (this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule | this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:359:1: (this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule | this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                alt6=1;
            }
            else if ( (LA6_0==14) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("359:1: (this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule | this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:360:5: this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeEventRuleAccess().getRelativeTimeEventRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRelativeTimeEventRule_in_ruleTimeEventRule665);
                    this_RelativeTimeEventRule_0=ruleRelativeTimeEventRule();
                    _fsp--;

                     
                            current = this_RelativeTimeEventRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:370:5: this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTimeEventRuleAccess().getAbsoluteTimeEventRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbsoluteTimeEventRule_in_ruleTimeEventRule692);
                    this_AbsoluteTimeEventRule_1=ruleAbsoluteTimeEventRule();
                    _fsp--;

                     
                            current = this_AbsoluteTimeEventRule_1; 
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
    // $ANTLR end ruleTimeEventRule


    // $ANTLR start entryRuleRelativeTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:386:1: entryRuleRelativeTimeEventRule returns [EObject current=null] : iv_ruleRelativeTimeEventRule= ruleRelativeTimeEventRule EOF ;
    public final EObject entryRuleRelativeTimeEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeTimeEventRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:387:2: (iv_ruleRelativeTimeEventRule= ruleRelativeTimeEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:388:2: iv_ruleRelativeTimeEventRule= ruleRelativeTimeEventRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelativeTimeEventRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelativeTimeEventRule_in_entryRuleRelativeTimeEventRule727);
            iv_ruleRelativeTimeEventRule=ruleRelativeTimeEventRule();
            _fsp--;

             current =iv_ruleRelativeTimeEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelativeTimeEventRule737); 

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
    // $ANTLR end entryRuleRelativeTimeEventRule


    // $ANTLR start ruleRelativeTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:395:1: ruleRelativeTimeEventRule returns [EObject current=null] : ( 'after' ( (lv_expr_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleRelativeTimeEventRule() throws RecognitionException {
        EObject current = null;

        Token lv_expr_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:400:6: ( ( 'after' ( (lv_expr_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:401:1: ( 'after' ( (lv_expr_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:401:1: ( 'after' ( (lv_expr_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:401:3: 'after' ( (lv_expr_1_0= RULE_STRING ) )
            {
            match(input,13,FOLLOW_13_in_ruleRelativeTimeEventRule772); 

                    createLeafNode(grammarAccess.getRelativeTimeEventRuleAccess().getAfterKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:405:1: ( (lv_expr_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:406:1: (lv_expr_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:406:1: (lv_expr_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:407:3: lv_expr_1_0= RULE_STRING
            {
            lv_expr_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRelativeTimeEventRule789); 

            			createLeafNode(grammarAccess.getRelativeTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0(), "expr"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRelativeTimeEventRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expr",
            	        		lv_expr_1_0, 
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
    // $ANTLR end ruleRelativeTimeEventRule


    // $ANTLR start entryRuleAbsoluteTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:437:1: entryRuleAbsoluteTimeEventRule returns [EObject current=null] : iv_ruleAbsoluteTimeEventRule= ruleAbsoluteTimeEventRule EOF ;
    public final EObject entryRuleAbsoluteTimeEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbsoluteTimeEventRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:438:2: (iv_ruleAbsoluteTimeEventRule= ruleAbsoluteTimeEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:439:2: iv_ruleAbsoluteTimeEventRule= ruleAbsoluteTimeEventRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbsoluteTimeEventRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbsoluteTimeEventRule_in_entryRuleAbsoluteTimeEventRule830);
            iv_ruleAbsoluteTimeEventRule=ruleAbsoluteTimeEventRule();
            _fsp--;

             current =iv_ruleAbsoluteTimeEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbsoluteTimeEventRule840); 

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
    // $ANTLR end entryRuleAbsoluteTimeEventRule


    // $ANTLR start ruleAbsoluteTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:446:1: ruleAbsoluteTimeEventRule returns [EObject current=null] : ( 'at' ( (lv_expr_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleAbsoluteTimeEventRule() throws RecognitionException {
        EObject current = null;

        Token lv_expr_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:451:6: ( ( 'at' ( (lv_expr_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:452:1: ( 'at' ( (lv_expr_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:452:1: ( 'at' ( (lv_expr_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:452:3: 'at' ( (lv_expr_1_0= RULE_STRING ) )
            {
            match(input,14,FOLLOW_14_in_ruleAbsoluteTimeEventRule875); 

                    createLeafNode(grammarAccess.getAbsoluteTimeEventRuleAccess().getAtKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:456:1: ( (lv_expr_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:457:1: (lv_expr_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:457:1: (lv_expr_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:458:3: lv_expr_1_0= RULE_STRING
            {
            lv_expr_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAbsoluteTimeEventRule892); 

            			createLeafNode(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0(), "expr"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAbsoluteTimeEventRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expr",
            	        		lv_expr_1_0, 
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
    // $ANTLR end ruleAbsoluteTimeEventRule


    // $ANTLR start entryRuleChangeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:488:1: entryRuleChangeEventRule returns [EObject current=null] : iv_ruleChangeEventRule= ruleChangeEventRule EOF ;
    public final EObject entryRuleChangeEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChangeEventRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:489:2: (iv_ruleChangeEventRule= ruleChangeEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:490:2: iv_ruleChangeEventRule= ruleChangeEventRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChangeEventRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleChangeEventRule_in_entryRuleChangeEventRule933);
            iv_ruleChangeEventRule=ruleChangeEventRule();
            _fsp--;

             current =iv_ruleChangeEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChangeEventRule943); 

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
    // $ANTLR end entryRuleChangeEventRule


    // $ANTLR start ruleChangeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:497:1: ruleChangeEventRule returns [EObject current=null] : ( 'when' ( (lv_exp_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleChangeEventRule() throws RecognitionException {
        EObject current = null;

        Token lv_exp_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:502:6: ( ( 'when' ( (lv_exp_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:503:1: ( 'when' ( (lv_exp_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:503:1: ( 'when' ( (lv_exp_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:503:3: 'when' ( (lv_exp_1_0= RULE_STRING ) )
            {
            match(input,15,FOLLOW_15_in_ruleChangeEventRule978); 

                    createLeafNode(grammarAccess.getChangeEventRuleAccess().getWhenKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:507:1: ( (lv_exp_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:508:1: (lv_exp_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:508:1: (lv_exp_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:509:3: lv_exp_1_0= RULE_STRING
            {
            lv_exp_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleChangeEventRule995); 

            			createLeafNode(grammarAccess.getChangeEventRuleAccess().getExpSTRINGTerminalRuleCall_1_0(), "exp"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChangeEventRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"exp",
            	        		lv_exp_1_0, 
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
    // $ANTLR end ruleChangeEventRule


    // $ANTLR start entryRuleGuardRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:539:1: entryRuleGuardRule returns [EObject current=null] : iv_ruleGuardRule= ruleGuardRule EOF ;
    public final EObject entryRuleGuardRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:540:2: (iv_ruleGuardRule= ruleGuardRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:541:2: iv_ruleGuardRule= ruleGuardRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGuardRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleGuardRule_in_entryRuleGuardRule1036);
            iv_ruleGuardRule=ruleGuardRule();
            _fsp--;

             current =iv_ruleGuardRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardRule1046); 

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
    // $ANTLR end entryRuleGuardRule


    // $ANTLR start ruleGuardRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:548:1: ruleGuardRule returns [EObject current=null] : ( '[' ( (lv_constraint_1_0= RULE_STRING ) ) ']' ) ;
    public final EObject ruleGuardRule() throws RecognitionException {
        EObject current = null;

        Token lv_constraint_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:553:6: ( ( '[' ( (lv_constraint_1_0= RULE_STRING ) ) ']' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:554:1: ( '[' ( (lv_constraint_1_0= RULE_STRING ) ) ']' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:554:1: ( '[' ( (lv_constraint_1_0= RULE_STRING ) ) ']' )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:554:3: '[' ( (lv_constraint_1_0= RULE_STRING ) ) ']'
            {
            match(input,16,FOLLOW_16_in_ruleGuardRule1081); 

                    createLeafNode(grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:558:1: ( (lv_constraint_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:559:1: (lv_constraint_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:559:1: (lv_constraint_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:560:3: lv_constraint_1_0= RULE_STRING
            {
            lv_constraint_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGuardRule1098); 

            			createLeafNode(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0(), "constraint"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getGuardRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"constraint",
            	        		lv_constraint_1_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleGuardRule1113); 

                    createLeafNode(grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2(), null); 
                

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
    // $ANTLR end ruleGuardRule


    // $ANTLR start entryRuleEffectRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:594:1: entryRuleEffectRule returns [EObject current=null] : iv_ruleEffectRule= ruleEffectRule EOF ;
    public final EObject entryRuleEffectRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEffectRule = null;


        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:595:2: (iv_ruleEffectRule= ruleEffectRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:596:2: iv_ruleEffectRule= ruleEffectRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEffectRuleRule(), currentNode); 
            pushFollow(FOLLOW_ruleEffectRule_in_entryRuleEffectRule1149);
            iv_ruleEffectRule=ruleEffectRule();
            _fsp--;

             current =iv_ruleEffectRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEffectRule1159); 

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
    // $ANTLR end entryRuleEffectRule


    // $ANTLR start ruleEffectRule
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:603:1: ruleEffectRule returns [EObject current=null] : ( '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEffectRule() throws RecognitionException {
        EObject current = null;

        Token lv_behaviorName_2_0=null;
        Enumerator lv_kind_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:608:6: ( ( '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:609:1: ( '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:609:1: ( '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:609:3: '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
            {
            match(input,18,FOLLOW_18_in_ruleEffectRule1194); 

                    createLeafNode(grammarAccess.getEffectRuleAccess().getSolidusKeyword_0(), null); 
                
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:613:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:614:1: (lv_kind_1_0= ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:614:1: (lv_kind_1_0= ruleBehaviorKind )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:615:3: lv_kind_1_0= ruleBehaviorKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEffectRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBehaviorKind_in_ruleEffectRule1215);
            lv_kind_1_0=ruleBehaviorKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEffectRuleRule().getType().getClassifier());
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

            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:637:2: ( (lv_behaviorName_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:638:1: (lv_behaviorName_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:638:1: (lv_behaviorName_2_0= RULE_ID )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:639:3: lv_behaviorName_2_0= RULE_ID
            {
            lv_behaviorName_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEffectRule1232); 

            			createLeafNode(grammarAccess.getEffectRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), "behaviorName"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEffectRuleRule().getType().getClassifier());
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
    // $ANTLR end ruleEffectRule


    // $ANTLR start ruleBehaviorKind
    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:669:1: ruleBehaviorKind returns [Enumerator current=null] : ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) ) ;
    public final Enumerator ruleBehaviorKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:673:6: ( ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:674:1: ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:674:1: ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt7=1;
                }
                break;
            case 20:
                {
                alt7=2;
                }
                break;
            case 21:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("674:1: ( ( 'Activity' ) | ( 'StateMachine' ) | ( 'OpaqueBehavior' ) )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:674:2: ( 'Activity' )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:674:2: ( 'Activity' )
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:674:4: 'Activity'
                    {
                    match(input,19,FOLLOW_19_in_ruleBehaviorKind1285); 

                            current = grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:680:6: ( 'StateMachine' )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:680:6: ( 'StateMachine' )
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:680:8: 'StateMachine'
                    {
                    match(input,20,FOLLOW_20_in_ruleBehaviorKind1300); 

                            current = grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:686:6: ( 'OpaqueBehavior' )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:686:6: ( 'OpaqueBehavior' )
                    // ../org.eclipse.papyrus.transition.editor.xtext/src-gen/org/eclipse/papyrus/transition/editor/xtext/parser/antlr/internal/InternalUmlTransition.g:686:8: 'OpaqueBehavior'
                    {
                    match(input,21,FOLLOW_21_in_ruleBehaviorKind1315); 

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


 

    public static final BitSet FOLLOW_ruleTransitionRule_in_entryRuleTransitionRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRule_in_ruleTransitionRule132 = new BitSet(new long[]{0x0000000000050802L});
    public static final BitSet FOLLOW_11_in_ruleTransitionRule143 = new BitSet(new long[]{0x000000000000F010L});
    public static final BitSet FOLLOW_ruleEventRule_in_ruleTransitionRule164 = new BitSet(new long[]{0x0000000000050802L});
    public static final BitSet FOLLOW_ruleGuardRule_in_ruleTransitionRule189 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_ruleTransitionRule211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRule_in_entryRuleEventRule248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventRule258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOrSignalEventRule_in_ruleEventRule305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnyReceiveEventRule_in_ruleEventRule332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventRule_in_ruleEventRule359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChangeEventRule_in_ruleEventRule386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOrSignalEventRule_in_entryRuleCallOrSignalEventRule421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallOrSignalEventRule431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCallOrSignalEventRule473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnyReceiveEventRule_in_entryRuleAnyReceiveEventRule508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnyReceiveEventRule518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleAnyReceiveEventRule560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventRule_in_entryRuleTimeEventRule608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeEventRule618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelativeTimeEventRule_in_ruleTimeEventRule665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbsoluteTimeEventRule_in_ruleTimeEventRule692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelativeTimeEventRule_in_entryRuleRelativeTimeEventRule727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelativeTimeEventRule737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleRelativeTimeEventRule772 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRelativeTimeEventRule789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbsoluteTimeEventRule_in_entryRuleAbsoluteTimeEventRule830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbsoluteTimeEventRule840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleAbsoluteTimeEventRule875 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAbsoluteTimeEventRule892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChangeEventRule_in_entryRuleChangeEventRule933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChangeEventRule943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleChangeEventRule978 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleChangeEventRule995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardRule_in_entryRuleGuardRule1036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardRule1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleGuardRule1081 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGuardRule1098 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleGuardRule1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_entryRuleEffectRule1149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEffectRule1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleEffectRule1194 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_ruleEffectRule1215 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEffectRule1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleBehaviorKind1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleBehaviorKind1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleBehaviorKind1315 = new BitSet(new long[]{0x0000000000000002L});

}