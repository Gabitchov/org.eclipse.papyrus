package org.eclipse.papyrus.uml.textedit.transition.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.uml.textedit.transition.xtext.services.UmlTransitionGrammarAccess;



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
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalUmlTransitionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUmlTransitionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUmlTransitionParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g"; }



     	private UmlTransitionGrammarAccess grammarAccess;
     	
        public InternalUmlTransitionParser(TokenStream input, UmlTransitionGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TransitionRule";	
       	}
       	
       	@Override
       	protected UmlTransitionGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTransitionRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:68:1: entryRuleTransitionRule returns [EObject current=null] : iv_ruleTransitionRule= ruleTransitionRule EOF ;
    public final EObject entryRuleTransitionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:69:2: (iv_ruleTransitionRule= ruleTransitionRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:70:2: iv_ruleTransitionRule= ruleTransitionRule EOF
            {
             newCompositeNode(grammarAccess.getTransitionRuleRule()); 
            pushFollow(FOLLOW_ruleTransitionRule_in_entryRuleTransitionRule75);
            iv_ruleTransitionRule=ruleTransitionRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleTransitionRule"


    // $ANTLR start "ruleTransitionRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:77:1: ruleTransitionRule returns [EObject current=null] : ( ( ( (lv_triggers_0_0= ruleEventRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )? ) ;
    public final EObject ruleTransitionRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_triggers_0_0 = null;

        EObject lv_triggers_2_0 = null;

        EObject lv_guard_3_0 = null;

        EObject lv_effect_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:80:28: ( ( ( ( (lv_triggers_0_0= ruleEventRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )? ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:81:1: ( ( ( (lv_triggers_0_0= ruleEventRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )? )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:81:1: ( ( ( (lv_triggers_0_0= ruleEventRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )? )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:81:2: ( ( (lv_triggers_0_0= ruleEventRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )? ( (lv_guard_3_0= ruleGuardRule ) )? ( (lv_effect_4_0= ruleEffectRule ) )?
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:81:2: ( ( (lv_triggers_0_0= ruleEventRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleEventRule ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||(LA2_0>=12 && LA2_0<=15)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:81:3: ( (lv_triggers_0_0= ruleEventRule ) ) (otherlv_1= ',' ( (lv_triggers_2_0= ruleEventRule ) ) )*
                    {
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:81:3: ( (lv_triggers_0_0= ruleEventRule ) )
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:82:1: (lv_triggers_0_0= ruleEventRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:82:1: (lv_triggers_0_0= ruleEventRule )
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:83:3: lv_triggers_0_0= ruleEventRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEventRule_in_ruleTransitionRule132);
                    lv_triggers_0_0=ruleEventRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
                    	        }
                           		add(
                           			current, 
                           			"triggers",
                            		lv_triggers_0_0, 
                            		"EventRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:99:2: (otherlv_1= ',' ( (lv_triggers_2_0= ruleEventRule ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==11) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:99:4: otherlv_1= ',' ( (lv_triggers_2_0= ruleEventRule ) )
                    	    {
                    	    otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleTransitionRule145); 

                    	        	newLeafNode(otherlv_1, grammarAccess.getTransitionRuleAccess().getCommaKeyword_0_1_0());
                    	        
                    	    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:103:1: ( (lv_triggers_2_0= ruleEventRule ) )
                    	    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:104:1: (lv_triggers_2_0= ruleEventRule )
                    	    {
                    	    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:104:1: (lv_triggers_2_0= ruleEventRule )
                    	    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:105:3: lv_triggers_2_0= ruleEventRule
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_0_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEventRule_in_ruleTransitionRule166);
                    	    lv_triggers_2_0=ruleEventRule();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"triggers",
                    	            		lv_triggers_2_0, 
                    	            		"EventRule");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:121:6: ( (lv_guard_3_0= ruleGuardRule ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:122:1: (lv_guard_3_0= ruleGuardRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:122:1: (lv_guard_3_0= ruleGuardRule )
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:123:3: lv_guard_3_0= ruleGuardRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleGuardRule_in_ruleTransitionRule191);
                    lv_guard_3_0=ruleGuardRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"guard",
                            		lv_guard_3_0, 
                            		"GuardRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:139:3: ( (lv_effect_4_0= ruleEffectRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:140:1: (lv_effect_4_0= ruleEffectRule )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:140:1: (lv_effect_4_0= ruleEffectRule )
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:141:3: lv_effect_4_0= ruleEffectRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionRuleAccess().getEffectEffectRuleParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEffectRule_in_ruleTransitionRule213);
                    lv_effect_4_0=ruleEffectRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"effect",
                            		lv_effect_4_0, 
                            		"EffectRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransitionRule"


    // $ANTLR start "entryRuleEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:165:1: entryRuleEventRule returns [EObject current=null] : iv_ruleEventRule= ruleEventRule EOF ;
    public final EObject entryRuleEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:166:2: (iv_ruleEventRule= ruleEventRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:167:2: iv_ruleEventRule= ruleEventRule EOF
            {
             newCompositeNode(grammarAccess.getEventRuleRule()); 
            pushFollow(FOLLOW_ruleEventRule_in_entryRuleEventRule250);
            iv_ruleEventRule=ruleEventRule();

            state._fsp--;

             current =iv_ruleEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventRule260); 

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
    // $ANTLR end "entryRuleEventRule"


    // $ANTLR start "ruleEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:174:1: ruleEventRule returns [EObject current=null] : (this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule | this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule | this_TimeEventRule_2= ruleTimeEventRule | this_ChangeEventRule_3= ruleChangeEventRule ) ;
    public final EObject ruleEventRule() throws RecognitionException {
        EObject current = null;

        EObject this_CallOrSignalEventRule_0 = null;

        EObject this_AnyReceiveEventRule_1 = null;

        EObject this_TimeEventRule_2 = null;

        EObject this_ChangeEventRule_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:177:28: ( (this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule | this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule | this_TimeEventRule_2= ruleTimeEventRule | this_ChangeEventRule_3= ruleChangeEventRule ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:178:1: (this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule | this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule | this_TimeEventRule_2= ruleTimeEventRule | this_ChangeEventRule_3= ruleChangeEventRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:178:1: (this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule | this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule | this_TimeEventRule_2= ruleTimeEventRule | this_ChangeEventRule_3= ruleChangeEventRule )
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
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:179:5: this_CallOrSignalEventRule_0= ruleCallOrSignalEventRule
                    {
                     
                            newCompositeNode(grammarAccess.getEventRuleAccess().getCallOrSignalEventRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleCallOrSignalEventRule_in_ruleEventRule307);
                    this_CallOrSignalEventRule_0=ruleCallOrSignalEventRule();

                    state._fsp--;

                     
                            current = this_CallOrSignalEventRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:189:5: this_AnyReceiveEventRule_1= ruleAnyReceiveEventRule
                    {
                     
                            newCompositeNode(grammarAccess.getEventRuleAccess().getAnyReceiveEventRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAnyReceiveEventRule_in_ruleEventRule334);
                    this_AnyReceiveEventRule_1=ruleAnyReceiveEventRule();

                    state._fsp--;

                     
                            current = this_AnyReceiveEventRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:199:5: this_TimeEventRule_2= ruleTimeEventRule
                    {
                     
                            newCompositeNode(grammarAccess.getEventRuleAccess().getTimeEventRuleParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTimeEventRule_in_ruleEventRule361);
                    this_TimeEventRule_2=ruleTimeEventRule();

                    state._fsp--;

                     
                            current = this_TimeEventRule_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:209:5: this_ChangeEventRule_3= ruleChangeEventRule
                    {
                     
                            newCompositeNode(grammarAccess.getEventRuleAccess().getChangeEventRuleParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleChangeEventRule_in_ruleEventRule388);
                    this_ChangeEventRule_3=ruleChangeEventRule();

                    state._fsp--;

                     
                            current = this_ChangeEventRule_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEventRule"


    // $ANTLR start "entryRuleCallOrSignalEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:225:1: entryRuleCallOrSignalEventRule returns [EObject current=null] : iv_ruleCallOrSignalEventRule= ruleCallOrSignalEventRule EOF ;
    public final EObject entryRuleCallOrSignalEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallOrSignalEventRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:226:2: (iv_ruleCallOrSignalEventRule= ruleCallOrSignalEventRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:227:2: iv_ruleCallOrSignalEventRule= ruleCallOrSignalEventRule EOF
            {
             newCompositeNode(grammarAccess.getCallOrSignalEventRuleRule()); 
            pushFollow(FOLLOW_ruleCallOrSignalEventRule_in_entryRuleCallOrSignalEventRule423);
            iv_ruleCallOrSignalEventRule=ruleCallOrSignalEventRule();

            state._fsp--;

             current =iv_ruleCallOrSignalEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallOrSignalEventRule433); 

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
    // $ANTLR end "entryRuleCallOrSignalEventRule"


    // $ANTLR start "ruleCallOrSignalEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:234:1: ruleCallOrSignalEventRule returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleCallOrSignalEventRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:237:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:238:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:238:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:239:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:239:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:240:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallOrSignalEventRuleRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCallOrSignalEventRule477); 

            		newLeafNode(otherlv_0, grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallOrSignalEventRule"


    // $ANTLR start "entryRuleAnyReceiveEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:259:1: entryRuleAnyReceiveEventRule returns [EObject current=null] : iv_ruleAnyReceiveEventRule= ruleAnyReceiveEventRule EOF ;
    public final EObject entryRuleAnyReceiveEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnyReceiveEventRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:260:2: (iv_ruleAnyReceiveEventRule= ruleAnyReceiveEventRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:261:2: iv_ruleAnyReceiveEventRule= ruleAnyReceiveEventRule EOF
            {
             newCompositeNode(grammarAccess.getAnyReceiveEventRuleRule()); 
            pushFollow(FOLLOW_ruleAnyReceiveEventRule_in_entryRuleAnyReceiveEventRule512);
            iv_ruleAnyReceiveEventRule=ruleAnyReceiveEventRule();

            state._fsp--;

             current =iv_ruleAnyReceiveEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnyReceiveEventRule522); 

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
    // $ANTLR end "entryRuleAnyReceiveEventRule"


    // $ANTLR start "ruleAnyReceiveEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:268:1: ruleAnyReceiveEventRule returns [EObject current=null] : ( (lv_isAReceiveEvent_0_0= 'all' ) ) ;
    public final EObject ruleAnyReceiveEventRule() throws RecognitionException {
        EObject current = null;

        Token lv_isAReceiveEvent_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:271:28: ( ( (lv_isAReceiveEvent_0_0= 'all' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:272:1: ( (lv_isAReceiveEvent_0_0= 'all' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:272:1: ( (lv_isAReceiveEvent_0_0= 'all' ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:273:1: (lv_isAReceiveEvent_0_0= 'all' )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:273:1: (lv_isAReceiveEvent_0_0= 'all' )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:274:3: lv_isAReceiveEvent_0_0= 'all'
            {
            lv_isAReceiveEvent_0_0=(Token)match(input,12,FOLLOW_12_in_ruleAnyReceiveEventRule564); 

                    newLeafNode(lv_isAReceiveEvent_0_0, grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAnyReceiveEventRuleRule());
            	        }
                   		setWithLastConsumed(current, "isAReceiveEvent", lv_isAReceiveEvent_0_0, "all");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnyReceiveEventRule"


    // $ANTLR start "entryRuleTimeEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:295:1: entryRuleTimeEventRule returns [EObject current=null] : iv_ruleTimeEventRule= ruleTimeEventRule EOF ;
    public final EObject entryRuleTimeEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeEventRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:296:2: (iv_ruleTimeEventRule= ruleTimeEventRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:297:2: iv_ruleTimeEventRule= ruleTimeEventRule EOF
            {
             newCompositeNode(grammarAccess.getTimeEventRuleRule()); 
            pushFollow(FOLLOW_ruleTimeEventRule_in_entryRuleTimeEventRule612);
            iv_ruleTimeEventRule=ruleTimeEventRule();

            state._fsp--;

             current =iv_ruleTimeEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeEventRule622); 

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
    // $ANTLR end "entryRuleTimeEventRule"


    // $ANTLR start "ruleTimeEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:304:1: ruleTimeEventRule returns [EObject current=null] : (this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule | this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule ) ;
    public final EObject ruleTimeEventRule() throws RecognitionException {
        EObject current = null;

        EObject this_RelativeTimeEventRule_0 = null;

        EObject this_AbsoluteTimeEventRule_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:307:28: ( (this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule | this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:308:1: (this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule | this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:308:1: (this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule | this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule )
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
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:309:5: this_RelativeTimeEventRule_0= ruleRelativeTimeEventRule
                    {
                     
                            newCompositeNode(grammarAccess.getTimeEventRuleAccess().getRelativeTimeEventRuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRelativeTimeEventRule_in_ruleTimeEventRule669);
                    this_RelativeTimeEventRule_0=ruleRelativeTimeEventRule();

                    state._fsp--;

                     
                            current = this_RelativeTimeEventRule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:319:5: this_AbsoluteTimeEventRule_1= ruleAbsoluteTimeEventRule
                    {
                     
                            newCompositeNode(grammarAccess.getTimeEventRuleAccess().getAbsoluteTimeEventRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAbsoluteTimeEventRule_in_ruleTimeEventRule696);
                    this_AbsoluteTimeEventRule_1=ruleAbsoluteTimeEventRule();

                    state._fsp--;

                     
                            current = this_AbsoluteTimeEventRule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeEventRule"


    // $ANTLR start "entryRuleRelativeTimeEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:335:1: entryRuleRelativeTimeEventRule returns [EObject current=null] : iv_ruleRelativeTimeEventRule= ruleRelativeTimeEventRule EOF ;
    public final EObject entryRuleRelativeTimeEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeTimeEventRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:336:2: (iv_ruleRelativeTimeEventRule= ruleRelativeTimeEventRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:337:2: iv_ruleRelativeTimeEventRule= ruleRelativeTimeEventRule EOF
            {
             newCompositeNode(grammarAccess.getRelativeTimeEventRuleRule()); 
            pushFollow(FOLLOW_ruleRelativeTimeEventRule_in_entryRuleRelativeTimeEventRule731);
            iv_ruleRelativeTimeEventRule=ruleRelativeTimeEventRule();

            state._fsp--;

             current =iv_ruleRelativeTimeEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelativeTimeEventRule741); 

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
    // $ANTLR end "entryRuleRelativeTimeEventRule"


    // $ANTLR start "ruleRelativeTimeEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:344:1: ruleRelativeTimeEventRule returns [EObject current=null] : (otherlv_0= 'after' ( (lv_expr_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleRelativeTimeEventRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_expr_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:347:28: ( (otherlv_0= 'after' ( (lv_expr_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:348:1: (otherlv_0= 'after' ( (lv_expr_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:348:1: (otherlv_0= 'after' ( (lv_expr_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:348:3: otherlv_0= 'after' ( (lv_expr_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleRelativeTimeEventRule778); 

                	newLeafNode(otherlv_0, grammarAccess.getRelativeTimeEventRuleAccess().getAfterKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:352:1: ( (lv_expr_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:353:1: (lv_expr_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:353:1: (lv_expr_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:354:3: lv_expr_1_0= RULE_STRING
            {
            lv_expr_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRelativeTimeEventRule795); 

            			newLeafNode(lv_expr_1_0, grammarAccess.getRelativeTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRelativeTimeEventRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"expr",
                    		lv_expr_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelativeTimeEventRule"


    // $ANTLR start "entryRuleAbsoluteTimeEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:378:1: entryRuleAbsoluteTimeEventRule returns [EObject current=null] : iv_ruleAbsoluteTimeEventRule= ruleAbsoluteTimeEventRule EOF ;
    public final EObject entryRuleAbsoluteTimeEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbsoluteTimeEventRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:379:2: (iv_ruleAbsoluteTimeEventRule= ruleAbsoluteTimeEventRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:380:2: iv_ruleAbsoluteTimeEventRule= ruleAbsoluteTimeEventRule EOF
            {
             newCompositeNode(grammarAccess.getAbsoluteTimeEventRuleRule()); 
            pushFollow(FOLLOW_ruleAbsoluteTimeEventRule_in_entryRuleAbsoluteTimeEventRule836);
            iv_ruleAbsoluteTimeEventRule=ruleAbsoluteTimeEventRule();

            state._fsp--;

             current =iv_ruleAbsoluteTimeEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbsoluteTimeEventRule846); 

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
    // $ANTLR end "entryRuleAbsoluteTimeEventRule"


    // $ANTLR start "ruleAbsoluteTimeEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:387:1: ruleAbsoluteTimeEventRule returns [EObject current=null] : (otherlv_0= 'at' ( (lv_expr_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleAbsoluteTimeEventRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_expr_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:390:28: ( (otherlv_0= 'at' ( (lv_expr_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:391:1: (otherlv_0= 'at' ( (lv_expr_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:391:1: (otherlv_0= 'at' ( (lv_expr_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:391:3: otherlv_0= 'at' ( (lv_expr_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleAbsoluteTimeEventRule883); 

                	newLeafNode(otherlv_0, grammarAccess.getAbsoluteTimeEventRuleAccess().getAtKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:395:1: ( (lv_expr_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:396:1: (lv_expr_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:396:1: (lv_expr_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:397:3: lv_expr_1_0= RULE_STRING
            {
            lv_expr_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAbsoluteTimeEventRule900); 

            			newLeafNode(lv_expr_1_0, grammarAccess.getAbsoluteTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAbsoluteTimeEventRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"expr",
                    		lv_expr_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbsoluteTimeEventRule"


    // $ANTLR start "entryRuleChangeEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:421:1: entryRuleChangeEventRule returns [EObject current=null] : iv_ruleChangeEventRule= ruleChangeEventRule EOF ;
    public final EObject entryRuleChangeEventRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChangeEventRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:422:2: (iv_ruleChangeEventRule= ruleChangeEventRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:423:2: iv_ruleChangeEventRule= ruleChangeEventRule EOF
            {
             newCompositeNode(grammarAccess.getChangeEventRuleRule()); 
            pushFollow(FOLLOW_ruleChangeEventRule_in_entryRuleChangeEventRule941);
            iv_ruleChangeEventRule=ruleChangeEventRule();

            state._fsp--;

             current =iv_ruleChangeEventRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChangeEventRule951); 

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
    // $ANTLR end "entryRuleChangeEventRule"


    // $ANTLR start "ruleChangeEventRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:430:1: ruleChangeEventRule returns [EObject current=null] : (otherlv_0= 'when' ( (lv_exp_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleChangeEventRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_exp_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:433:28: ( (otherlv_0= 'when' ( (lv_exp_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:434:1: (otherlv_0= 'when' ( (lv_exp_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:434:1: (otherlv_0= 'when' ( (lv_exp_1_0= RULE_STRING ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:434:3: otherlv_0= 'when' ( (lv_exp_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleChangeEventRule988); 

                	newLeafNode(otherlv_0, grammarAccess.getChangeEventRuleAccess().getWhenKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:438:1: ( (lv_exp_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:439:1: (lv_exp_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:439:1: (lv_exp_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:440:3: lv_exp_1_0= RULE_STRING
            {
            lv_exp_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleChangeEventRule1005); 

            			newLeafNode(lv_exp_1_0, grammarAccess.getChangeEventRuleAccess().getExpSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChangeEventRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"exp",
                    		lv_exp_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChangeEventRule"


    // $ANTLR start "entryRuleGuardRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:464:1: entryRuleGuardRule returns [EObject current=null] : iv_ruleGuardRule= ruleGuardRule EOF ;
    public final EObject entryRuleGuardRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuardRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:465:2: (iv_ruleGuardRule= ruleGuardRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:466:2: iv_ruleGuardRule= ruleGuardRule EOF
            {
             newCompositeNode(grammarAccess.getGuardRuleRule()); 
            pushFollow(FOLLOW_ruleGuardRule_in_entryRuleGuardRule1046);
            iv_ruleGuardRule=ruleGuardRule();

            state._fsp--;

             current =iv_ruleGuardRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardRule1056); 

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
    // $ANTLR end "entryRuleGuardRule"


    // $ANTLR start "ruleGuardRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:473:1: ruleGuardRule returns [EObject current=null] : (otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']' ) ;
    public final EObject ruleGuardRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constraint_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:476:28: ( (otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']' ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:477:1: (otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']' )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:477:1: (otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']' )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:477:3: otherlv_0= '[' ( (lv_constraint_1_0= RULE_STRING ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleGuardRule1093); 

                	newLeafNode(otherlv_0, grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:481:1: ( (lv_constraint_1_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:482:1: (lv_constraint_1_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:482:1: (lv_constraint_1_0= RULE_STRING )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:483:3: lv_constraint_1_0= RULE_STRING
            {
            lv_constraint_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGuardRule1110); 

            			newLeafNode(lv_constraint_1_0, grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGuardRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"constraint",
                    		lv_constraint_1_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleGuardRule1127); 

                	newLeafNode(otherlv_2, grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGuardRule"


    // $ANTLR start "entryRuleEffectRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:511:1: entryRuleEffectRule returns [EObject current=null] : iv_ruleEffectRule= ruleEffectRule EOF ;
    public final EObject entryRuleEffectRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEffectRule = null;


        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:512:2: (iv_ruleEffectRule= ruleEffectRule EOF )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:513:2: iv_ruleEffectRule= ruleEffectRule EOF
            {
             newCompositeNode(grammarAccess.getEffectRuleRule()); 
            pushFollow(FOLLOW_ruleEffectRule_in_entryRuleEffectRule1163);
            iv_ruleEffectRule=ruleEffectRule();

            state._fsp--;

             current =iv_ruleEffectRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEffectRule1173); 

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
    // $ANTLR end "entryRuleEffectRule"


    // $ANTLR start "ruleEffectRule"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:520:1: ruleEffectRule returns [EObject current=null] : (otherlv_0= '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEffectRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_behaviorName_2_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:523:28: ( (otherlv_0= '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:524:1: (otherlv_0= '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:524:1: (otherlv_0= '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:524:3: otherlv_0= '/' ( (lv_kind_1_0= ruleBehaviorKind ) ) ( (lv_behaviorName_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleEffectRule1210); 

                	newLeafNode(otherlv_0, grammarAccess.getEffectRuleAccess().getSolidusKeyword_0());
                
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:528:1: ( (lv_kind_1_0= ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:529:1: (lv_kind_1_0= ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:529:1: (lv_kind_1_0= ruleBehaviorKind )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:530:3: lv_kind_1_0= ruleBehaviorKind
            {
             
            	        newCompositeNode(grammarAccess.getEffectRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBehaviorKind_in_ruleEffectRule1231);
            lv_kind_1_0=ruleBehaviorKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEffectRuleRule());
            	        }
                   		set(
                   			current, 
                   			"kind",
                    		lv_kind_1_0, 
                    		"BehaviorKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:546:2: ( (lv_behaviorName_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:547:1: (lv_behaviorName_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:547:1: (lv_behaviorName_2_0= RULE_ID )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:548:3: lv_behaviorName_2_0= RULE_ID
            {
            lv_behaviorName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEffectRule1248); 

            			newLeafNode(lv_behaviorName_2_0, grammarAccess.getEffectRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEffectRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"behaviorName",
                    		lv_behaviorName_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEffectRule"


    // $ANTLR start "ruleBehaviorKind"
    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:572:1: ruleBehaviorKind returns [Enumerator current=null] : ( (enumLiteral_0= 'Activity' ) | (enumLiteral_1= 'StateMachine' ) | (enumLiteral_2= 'OpaqueBehavior' ) ) ;
    public final Enumerator ruleBehaviorKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:574:28: ( ( (enumLiteral_0= 'Activity' ) | (enumLiteral_1= 'StateMachine' ) | (enumLiteral_2= 'OpaqueBehavior' ) ) )
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:575:1: ( (enumLiteral_0= 'Activity' ) | (enumLiteral_1= 'StateMachine' ) | (enumLiteral_2= 'OpaqueBehavior' ) )
            {
            // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:575:1: ( (enumLiteral_0= 'Activity' ) | (enumLiteral_1= 'StateMachine' ) | (enumLiteral_2= 'OpaqueBehavior' ) )
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
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:575:2: (enumLiteral_0= 'Activity' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:575:2: (enumLiteral_0= 'Activity' )
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:575:4: enumLiteral_0= 'Activity'
                    {
                    enumLiteral_0=(Token)match(input,19,FOLLOW_19_in_ruleBehaviorKind1303); 

                            current = grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:581:6: (enumLiteral_1= 'StateMachine' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:581:6: (enumLiteral_1= 'StateMachine' )
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:581:8: enumLiteral_1= 'StateMachine'
                    {
                    enumLiteral_1=(Token)match(input,20,FOLLOW_20_in_ruleBehaviorKind1320); 

                            current = grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:587:6: (enumLiteral_2= 'OpaqueBehavior' )
                    {
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:587:6: (enumLiteral_2= 'OpaqueBehavior' )
                    // ../org.eclipse.papyrus.uml.textedit.transition.xtext/src-gen/org/eclipse/papyrus/uml/textedit/transition/xtext/parser/antlr/internal/InternalUmlTransition.g:587:8: enumLiteral_2= 'OpaqueBehavior'
                    {
                    enumLiteral_2=(Token)match(input,21,FOLLOW_21_in_ruleBehaviorKind1337); 

                            current = grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBehaviorKind"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleTransitionRule_in_entryRuleTransitionRule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRule_in_ruleTransitionRule132 = new BitSet(new long[]{0x0000000000050802L});
    public static final BitSet FOLLOW_11_in_ruleTransitionRule145 = new BitSet(new long[]{0x000000000000F010L});
    public static final BitSet FOLLOW_ruleEventRule_in_ruleTransitionRule166 = new BitSet(new long[]{0x0000000000050802L});
    public static final BitSet FOLLOW_ruleGuardRule_in_ruleTransitionRule191 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_ruleTransitionRule213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRule_in_entryRuleEventRule250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventRule260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOrSignalEventRule_in_ruleEventRule307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnyReceiveEventRule_in_ruleEventRule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventRule_in_ruleEventRule361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChangeEventRule_in_ruleEventRule388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOrSignalEventRule_in_entryRuleCallOrSignalEventRule423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallOrSignalEventRule433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCallOrSignalEventRule477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnyReceiveEventRule_in_entryRuleAnyReceiveEventRule512 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnyReceiveEventRule522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleAnyReceiveEventRule564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventRule_in_entryRuleTimeEventRule612 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeEventRule622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelativeTimeEventRule_in_ruleTimeEventRule669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbsoluteTimeEventRule_in_ruleTimeEventRule696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelativeTimeEventRule_in_entryRuleRelativeTimeEventRule731 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelativeTimeEventRule741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleRelativeTimeEventRule778 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRelativeTimeEventRule795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbsoluteTimeEventRule_in_entryRuleAbsoluteTimeEventRule836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbsoluteTimeEventRule846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleAbsoluteTimeEventRule883 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAbsoluteTimeEventRule900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChangeEventRule_in_entryRuleChangeEventRule941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChangeEventRule951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleChangeEventRule988 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleChangeEventRule1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardRule_in_entryRuleGuardRule1046 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardRule1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleGuardRule1093 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGuardRule1110 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleGuardRule1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_entryRuleEffectRule1163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEffectRule1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleEffectRule1210 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_ruleEffectRule1231 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEffectRule1248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleBehaviorKind1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleBehaviorKind1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleBehaviorKind1337 = new BitSet(new long[]{0x0000000000000002L});

}