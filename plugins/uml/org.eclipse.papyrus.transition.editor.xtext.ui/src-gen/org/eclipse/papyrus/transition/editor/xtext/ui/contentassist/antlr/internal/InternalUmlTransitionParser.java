package org.eclipse.papyrus.transition.editor.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.papyrus.transition.editor.xtext.services.UmlTransitionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlTransitionParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Activity'", "'StateMachine'", "'OpaqueBehavior'", "','", "'after'", "'at'", "'when'", "'['", "']'", "'/'", "'all'"
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
    public String getGrammarFileName() { return "../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g"; }


     
     	private UmlTransitionGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UmlTransitionGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start entryRuleTransitionRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:61:1: entryRuleTransitionRule : ruleTransitionRule EOF ;
    public final void entryRuleTransitionRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:62:1: ( ruleTransitionRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:63:1: ruleTransitionRule EOF
            {
             before(grammarAccess.getTransitionRuleRule()); 
            pushFollow(FOLLOW_ruleTransitionRule_in_entryRuleTransitionRule61);
            ruleTransitionRule();
            _fsp--;

             after(grammarAccess.getTransitionRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionRule68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleTransitionRule


    // $ANTLR start ruleTransitionRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:70:1: ruleTransitionRule : ( ( rule__TransitionRule__Group__0 ) ) ;
    public final void ruleTransitionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:74:2: ( ( ( rule__TransitionRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:75:1: ( ( rule__TransitionRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:75:1: ( ( rule__TransitionRule__Group__0 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:76:1: ( rule__TransitionRule__Group__0 )
            {
             before(grammarAccess.getTransitionRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:77:1: ( rule__TransitionRule__Group__0 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:77:2: rule__TransitionRule__Group__0
            {
            pushFollow(FOLLOW_rule__TransitionRule__Group__0_in_ruleTransitionRule94);
            rule__TransitionRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTransitionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTransitionRule


    // $ANTLR start entryRuleEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:89:1: entryRuleEventRule : ruleEventRule EOF ;
    public final void entryRuleEventRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:90:1: ( ruleEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:91:1: ruleEventRule EOF
            {
             before(grammarAccess.getEventRuleRule()); 
            pushFollow(FOLLOW_ruleEventRule_in_entryRuleEventRule121);
            ruleEventRule();
            _fsp--;

             after(grammarAccess.getEventRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventRule128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleEventRule


    // $ANTLR start ruleEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:98:1: ruleEventRule : ( ( rule__EventRule__Alternatives ) ) ;
    public final void ruleEventRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:102:2: ( ( ( rule__EventRule__Alternatives ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:103:1: ( ( rule__EventRule__Alternatives ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:103:1: ( ( rule__EventRule__Alternatives ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:104:1: ( rule__EventRule__Alternatives )
            {
             before(grammarAccess.getEventRuleAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:105:1: ( rule__EventRule__Alternatives )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:105:2: rule__EventRule__Alternatives
            {
            pushFollow(FOLLOW_rule__EventRule__Alternatives_in_ruleEventRule154);
            rule__EventRule__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getEventRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEventRule


    // $ANTLR start entryRuleCallOrSignalEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:117:1: entryRuleCallOrSignalEventRule : ruleCallOrSignalEventRule EOF ;
    public final void entryRuleCallOrSignalEventRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:118:1: ( ruleCallOrSignalEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:119:1: ruleCallOrSignalEventRule EOF
            {
             before(grammarAccess.getCallOrSignalEventRuleRule()); 
            pushFollow(FOLLOW_ruleCallOrSignalEventRule_in_entryRuleCallOrSignalEventRule181);
            ruleCallOrSignalEventRule();
            _fsp--;

             after(grammarAccess.getCallOrSignalEventRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallOrSignalEventRule188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleCallOrSignalEventRule


    // $ANTLR start ruleCallOrSignalEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:126:1: ruleCallOrSignalEventRule : ( ( rule__CallOrSignalEventRule__OperationOrSignalAssignment ) ) ;
    public final void ruleCallOrSignalEventRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:130:2: ( ( ( rule__CallOrSignalEventRule__OperationOrSignalAssignment ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:131:1: ( ( rule__CallOrSignalEventRule__OperationOrSignalAssignment ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:131:1: ( ( rule__CallOrSignalEventRule__OperationOrSignalAssignment ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:132:1: ( rule__CallOrSignalEventRule__OperationOrSignalAssignment )
            {
             before(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalAssignment()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:133:1: ( rule__CallOrSignalEventRule__OperationOrSignalAssignment )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:133:2: rule__CallOrSignalEventRule__OperationOrSignalAssignment
            {
            pushFollow(FOLLOW_rule__CallOrSignalEventRule__OperationOrSignalAssignment_in_ruleCallOrSignalEventRule214);
            rule__CallOrSignalEventRule__OperationOrSignalAssignment();
            _fsp--;


            }

             after(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleCallOrSignalEventRule


    // $ANTLR start entryRuleAnyReceiveEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:145:1: entryRuleAnyReceiveEventRule : ruleAnyReceiveEventRule EOF ;
    public final void entryRuleAnyReceiveEventRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:146:1: ( ruleAnyReceiveEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:147:1: ruleAnyReceiveEventRule EOF
            {
             before(grammarAccess.getAnyReceiveEventRuleRule()); 
            pushFollow(FOLLOW_ruleAnyReceiveEventRule_in_entryRuleAnyReceiveEventRule241);
            ruleAnyReceiveEventRule();
            _fsp--;

             after(grammarAccess.getAnyReceiveEventRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnyReceiveEventRule248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleAnyReceiveEventRule


    // $ANTLR start ruleAnyReceiveEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:154:1: ruleAnyReceiveEventRule : ( ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment ) ) ;
    public final void ruleAnyReceiveEventRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:158:2: ( ( ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:159:1: ( ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:159:1: ( ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:160:1: ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment )
            {
             before(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAssignment()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:161:1: ( rule__AnyReceiveEventRule__IsAReceiveEventAssignment )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:161:2: rule__AnyReceiveEventRule__IsAReceiveEventAssignment
            {
            pushFollow(FOLLOW_rule__AnyReceiveEventRule__IsAReceiveEventAssignment_in_ruleAnyReceiveEventRule274);
            rule__AnyReceiveEventRule__IsAReceiveEventAssignment();
            _fsp--;


            }

             after(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAnyReceiveEventRule


    // $ANTLR start entryRuleTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:173:1: entryRuleTimeEventRule : ruleTimeEventRule EOF ;
    public final void entryRuleTimeEventRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:174:1: ( ruleTimeEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:175:1: ruleTimeEventRule EOF
            {
             before(grammarAccess.getTimeEventRuleRule()); 
            pushFollow(FOLLOW_ruleTimeEventRule_in_entryRuleTimeEventRule301);
            ruleTimeEventRule();
            _fsp--;

             after(grammarAccess.getTimeEventRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeEventRule308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleTimeEventRule


    // $ANTLR start ruleTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:182:1: ruleTimeEventRule : ( ( rule__TimeEventRule__Alternatives ) ) ;
    public final void ruleTimeEventRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:186:2: ( ( ( rule__TimeEventRule__Alternatives ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:187:1: ( ( rule__TimeEventRule__Alternatives ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:187:1: ( ( rule__TimeEventRule__Alternatives ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:188:1: ( rule__TimeEventRule__Alternatives )
            {
             before(grammarAccess.getTimeEventRuleAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:189:1: ( rule__TimeEventRule__Alternatives )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:189:2: rule__TimeEventRule__Alternatives
            {
            pushFollow(FOLLOW_rule__TimeEventRule__Alternatives_in_ruleTimeEventRule334);
            rule__TimeEventRule__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getTimeEventRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTimeEventRule


    // $ANTLR start entryRuleRelativeTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:201:1: entryRuleRelativeTimeEventRule : ruleRelativeTimeEventRule EOF ;
    public final void entryRuleRelativeTimeEventRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:202:1: ( ruleRelativeTimeEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:203:1: ruleRelativeTimeEventRule EOF
            {
             before(grammarAccess.getRelativeTimeEventRuleRule()); 
            pushFollow(FOLLOW_ruleRelativeTimeEventRule_in_entryRuleRelativeTimeEventRule361);
            ruleRelativeTimeEventRule();
            _fsp--;

             after(grammarAccess.getRelativeTimeEventRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelativeTimeEventRule368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleRelativeTimeEventRule


    // $ANTLR start ruleRelativeTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:210:1: ruleRelativeTimeEventRule : ( ( rule__RelativeTimeEventRule__Group__0 ) ) ;
    public final void ruleRelativeTimeEventRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:214:2: ( ( ( rule__RelativeTimeEventRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:215:1: ( ( rule__RelativeTimeEventRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:215:1: ( ( rule__RelativeTimeEventRule__Group__0 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:216:1: ( rule__RelativeTimeEventRule__Group__0 )
            {
             before(grammarAccess.getRelativeTimeEventRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:217:1: ( rule__RelativeTimeEventRule__Group__0 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:217:2: rule__RelativeTimeEventRule__Group__0
            {
            pushFollow(FOLLOW_rule__RelativeTimeEventRule__Group__0_in_ruleRelativeTimeEventRule394);
            rule__RelativeTimeEventRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getRelativeTimeEventRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleRelativeTimeEventRule


    // $ANTLR start entryRuleAbsoluteTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:229:1: entryRuleAbsoluteTimeEventRule : ruleAbsoluteTimeEventRule EOF ;
    public final void entryRuleAbsoluteTimeEventRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:230:1: ( ruleAbsoluteTimeEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:231:1: ruleAbsoluteTimeEventRule EOF
            {
             before(grammarAccess.getAbsoluteTimeEventRuleRule()); 
            pushFollow(FOLLOW_ruleAbsoluteTimeEventRule_in_entryRuleAbsoluteTimeEventRule421);
            ruleAbsoluteTimeEventRule();
            _fsp--;

             after(grammarAccess.getAbsoluteTimeEventRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbsoluteTimeEventRule428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleAbsoluteTimeEventRule


    // $ANTLR start ruleAbsoluteTimeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:238:1: ruleAbsoluteTimeEventRule : ( ( rule__AbsoluteTimeEventRule__Group__0 ) ) ;
    public final void ruleAbsoluteTimeEventRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:242:2: ( ( ( rule__AbsoluteTimeEventRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:243:1: ( ( rule__AbsoluteTimeEventRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:243:1: ( ( rule__AbsoluteTimeEventRule__Group__0 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:244:1: ( rule__AbsoluteTimeEventRule__Group__0 )
            {
             before(grammarAccess.getAbsoluteTimeEventRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:245:1: ( rule__AbsoluteTimeEventRule__Group__0 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:245:2: rule__AbsoluteTimeEventRule__Group__0
            {
            pushFollow(FOLLOW_rule__AbsoluteTimeEventRule__Group__0_in_ruleAbsoluteTimeEventRule454);
            rule__AbsoluteTimeEventRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAbsoluteTimeEventRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAbsoluteTimeEventRule


    // $ANTLR start entryRuleChangeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:257:1: entryRuleChangeEventRule : ruleChangeEventRule EOF ;
    public final void entryRuleChangeEventRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:258:1: ( ruleChangeEventRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:259:1: ruleChangeEventRule EOF
            {
             before(grammarAccess.getChangeEventRuleRule()); 
            pushFollow(FOLLOW_ruleChangeEventRule_in_entryRuleChangeEventRule481);
            ruleChangeEventRule();
            _fsp--;

             after(grammarAccess.getChangeEventRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChangeEventRule488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleChangeEventRule


    // $ANTLR start ruleChangeEventRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:266:1: ruleChangeEventRule : ( ( rule__ChangeEventRule__Group__0 ) ) ;
    public final void ruleChangeEventRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:270:2: ( ( ( rule__ChangeEventRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:271:1: ( ( rule__ChangeEventRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:271:1: ( ( rule__ChangeEventRule__Group__0 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:272:1: ( rule__ChangeEventRule__Group__0 )
            {
             before(grammarAccess.getChangeEventRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:273:1: ( rule__ChangeEventRule__Group__0 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:273:2: rule__ChangeEventRule__Group__0
            {
            pushFollow(FOLLOW_rule__ChangeEventRule__Group__0_in_ruleChangeEventRule514);
            rule__ChangeEventRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getChangeEventRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleChangeEventRule


    // $ANTLR start entryRuleGuardRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:285:1: entryRuleGuardRule : ruleGuardRule EOF ;
    public final void entryRuleGuardRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:286:1: ( ruleGuardRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:287:1: ruleGuardRule EOF
            {
             before(grammarAccess.getGuardRuleRule()); 
            pushFollow(FOLLOW_ruleGuardRule_in_entryRuleGuardRule541);
            ruleGuardRule();
            _fsp--;

             after(grammarAccess.getGuardRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuardRule548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleGuardRule


    // $ANTLR start ruleGuardRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:294:1: ruleGuardRule : ( ( rule__GuardRule__Group__0 ) ) ;
    public final void ruleGuardRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:298:2: ( ( ( rule__GuardRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:299:1: ( ( rule__GuardRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:299:1: ( ( rule__GuardRule__Group__0 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:300:1: ( rule__GuardRule__Group__0 )
            {
             before(grammarAccess.getGuardRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:301:1: ( rule__GuardRule__Group__0 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:301:2: rule__GuardRule__Group__0
            {
            pushFollow(FOLLOW_rule__GuardRule__Group__0_in_ruleGuardRule574);
            rule__GuardRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getGuardRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleGuardRule


    // $ANTLR start entryRuleEffectRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:313:1: entryRuleEffectRule : ruleEffectRule EOF ;
    public final void entryRuleEffectRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:314:1: ( ruleEffectRule EOF )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:315:1: ruleEffectRule EOF
            {
             before(grammarAccess.getEffectRuleRule()); 
            pushFollow(FOLLOW_ruleEffectRule_in_entryRuleEffectRule601);
            ruleEffectRule();
            _fsp--;

             after(grammarAccess.getEffectRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEffectRule608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleEffectRule


    // $ANTLR start ruleEffectRule
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:322:1: ruleEffectRule : ( ( rule__EffectRule__Group__0 ) ) ;
    public final void ruleEffectRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:326:2: ( ( ( rule__EffectRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:327:1: ( ( rule__EffectRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:327:1: ( ( rule__EffectRule__Group__0 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:328:1: ( rule__EffectRule__Group__0 )
            {
             before(grammarAccess.getEffectRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:329:1: ( rule__EffectRule__Group__0 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:329:2: rule__EffectRule__Group__0
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__0_in_ruleEffectRule634);
            rule__EffectRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEffectRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEffectRule


    // $ANTLR start ruleBehaviorKind
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:342:1: ruleBehaviorKind : ( ( rule__BehaviorKind__Alternatives ) ) ;
    public final void ruleBehaviorKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:346:1: ( ( ( rule__BehaviorKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:347:1: ( ( rule__BehaviorKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:347:1: ( ( rule__BehaviorKind__Alternatives ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:348:1: ( rule__BehaviorKind__Alternatives )
            {
             before(grammarAccess.getBehaviorKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:349:1: ( rule__BehaviorKind__Alternatives )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:349:2: rule__BehaviorKind__Alternatives
            {
            pushFollow(FOLLOW_rule__BehaviorKind__Alternatives_in_ruleBehaviorKind671);
            rule__BehaviorKind__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getBehaviorKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBehaviorKind


    // $ANTLR start rule__EventRule__Alternatives
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:360:1: rule__EventRule__Alternatives : ( ( ruleCallOrSignalEventRule ) | ( ruleAnyReceiveEventRule ) | ( ruleTimeEventRule ) | ( ruleChangeEventRule ) );
    public final void rule__EventRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:364:1: ( ( ruleCallOrSignalEventRule ) | ( ruleAnyReceiveEventRule ) | ( ruleTimeEventRule ) | ( ruleChangeEventRule ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt1=1;
                }
                break;
            case 21:
                {
                alt1=2;
                }
                break;
            case 15:
            case 16:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("360:1: rule__EventRule__Alternatives : ( ( ruleCallOrSignalEventRule ) | ( ruleAnyReceiveEventRule ) | ( ruleTimeEventRule ) | ( ruleChangeEventRule ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:365:1: ( ruleCallOrSignalEventRule )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:365:1: ( ruleCallOrSignalEventRule )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:366:1: ruleCallOrSignalEventRule
                    {
                     before(grammarAccess.getEventRuleAccess().getCallOrSignalEventRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleCallOrSignalEventRule_in_rule__EventRule__Alternatives706);
                    ruleCallOrSignalEventRule();
                    _fsp--;

                     after(grammarAccess.getEventRuleAccess().getCallOrSignalEventRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:371:6: ( ruleAnyReceiveEventRule )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:371:6: ( ruleAnyReceiveEventRule )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:372:1: ruleAnyReceiveEventRule
                    {
                     before(grammarAccess.getEventRuleAccess().getAnyReceiveEventRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleAnyReceiveEventRule_in_rule__EventRule__Alternatives723);
                    ruleAnyReceiveEventRule();
                    _fsp--;

                     after(grammarAccess.getEventRuleAccess().getAnyReceiveEventRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:377:6: ( ruleTimeEventRule )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:377:6: ( ruleTimeEventRule )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:378:1: ruleTimeEventRule
                    {
                     before(grammarAccess.getEventRuleAccess().getTimeEventRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleTimeEventRule_in_rule__EventRule__Alternatives740);
                    ruleTimeEventRule();
                    _fsp--;

                     after(grammarAccess.getEventRuleAccess().getTimeEventRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:383:6: ( ruleChangeEventRule )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:383:6: ( ruleChangeEventRule )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:384:1: ruleChangeEventRule
                    {
                     before(grammarAccess.getEventRuleAccess().getChangeEventRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleChangeEventRule_in_rule__EventRule__Alternatives757);
                    ruleChangeEventRule();
                    _fsp--;

                     after(grammarAccess.getEventRuleAccess().getChangeEventRuleParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EventRule__Alternatives


    // $ANTLR start rule__TimeEventRule__Alternatives
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:394:1: rule__TimeEventRule__Alternatives : ( ( ruleRelativeTimeEventRule ) | ( ruleAbsoluteTimeEventRule ) );
    public final void rule__TimeEventRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:398:1: ( ( ruleRelativeTimeEventRule ) | ( ruleAbsoluteTimeEventRule ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            else if ( (LA2_0==16) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("394:1: rule__TimeEventRule__Alternatives : ( ( ruleRelativeTimeEventRule ) | ( ruleAbsoluteTimeEventRule ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:399:1: ( ruleRelativeTimeEventRule )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:399:1: ( ruleRelativeTimeEventRule )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:400:1: ruleRelativeTimeEventRule
                    {
                     before(grammarAccess.getTimeEventRuleAccess().getRelativeTimeEventRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRelativeTimeEventRule_in_rule__TimeEventRule__Alternatives789);
                    ruleRelativeTimeEventRule();
                    _fsp--;

                     after(grammarAccess.getTimeEventRuleAccess().getRelativeTimeEventRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:405:6: ( ruleAbsoluteTimeEventRule )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:405:6: ( ruleAbsoluteTimeEventRule )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:406:1: ruleAbsoluteTimeEventRule
                    {
                     before(grammarAccess.getTimeEventRuleAccess().getAbsoluteTimeEventRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleAbsoluteTimeEventRule_in_rule__TimeEventRule__Alternatives806);
                    ruleAbsoluteTimeEventRule();
                    _fsp--;

                     after(grammarAccess.getTimeEventRuleAccess().getAbsoluteTimeEventRuleParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TimeEventRule__Alternatives


    // $ANTLR start rule__BehaviorKind__Alternatives
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:416:1: rule__BehaviorKind__Alternatives : ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) );
    public final void rule__BehaviorKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:420:1: ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("416:1: rule__BehaviorKind__Alternatives : ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:421:1: ( ( 'Activity' ) )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:421:1: ( ( 'Activity' ) )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:422:1: ( 'Activity' )
                    {
                     before(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:423:1: ( 'Activity' )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:423:3: 'Activity'
                    {
                    match(input,11,FOLLOW_11_in_rule__BehaviorKind__Alternatives839); 

                    }

                     after(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:428:6: ( ( 'StateMachine' ) )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:428:6: ( ( 'StateMachine' ) )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:429:1: ( 'StateMachine' )
                    {
                     before(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:430:1: ( 'StateMachine' )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:430:3: 'StateMachine'
                    {
                    match(input,12,FOLLOW_12_in_rule__BehaviorKind__Alternatives860); 

                    }

                     after(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:435:6: ( ( 'OpaqueBehavior' ) )
                    {
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:435:6: ( ( 'OpaqueBehavior' ) )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:436:1: ( 'OpaqueBehavior' )
                    {
                     before(grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:437:1: ( 'OpaqueBehavior' )
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:437:3: 'OpaqueBehavior'
                    {
                    match(input,13,FOLLOW_13_in_rule__BehaviorKind__Alternatives881); 

                    }

                     after(grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BehaviorKind__Alternatives


    // $ANTLR start rule__TransitionRule__Group__0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:449:1: rule__TransitionRule__Group__0 : rule__TransitionRule__Group__0__Impl rule__TransitionRule__Group__1 ;
    public final void rule__TransitionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:453:1: ( rule__TransitionRule__Group__0__Impl rule__TransitionRule__Group__1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:454:2: rule__TransitionRule__Group__0__Impl rule__TransitionRule__Group__1
            {
            pushFollow(FOLLOW_rule__TransitionRule__Group__0__Impl_in_rule__TransitionRule__Group__0914);
            rule__TransitionRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TransitionRule__Group__1_in_rule__TransitionRule__Group__0917);
            rule__TransitionRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group__0


    // $ANTLR start rule__TransitionRule__Group__0__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:461:1: rule__TransitionRule__Group__0__Impl : ( ( rule__TransitionRule__NameAssignment_0 ) ) ;
    public final void rule__TransitionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:465:1: ( ( ( rule__TransitionRule__NameAssignment_0 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:466:1: ( ( rule__TransitionRule__NameAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:466:1: ( ( rule__TransitionRule__NameAssignment_0 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:467:1: ( rule__TransitionRule__NameAssignment_0 )
            {
             before(grammarAccess.getTransitionRuleAccess().getNameAssignment_0()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:468:1: ( rule__TransitionRule__NameAssignment_0 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:468:2: rule__TransitionRule__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__TransitionRule__NameAssignment_0_in_rule__TransitionRule__Group__0__Impl944);
            rule__TransitionRule__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getTransitionRuleAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group__0__Impl


    // $ANTLR start rule__TransitionRule__Group__1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:478:1: rule__TransitionRule__Group__1 : rule__TransitionRule__Group__1__Impl rule__TransitionRule__Group__2 ;
    public final void rule__TransitionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:482:1: ( rule__TransitionRule__Group__1__Impl rule__TransitionRule__Group__2 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:483:2: rule__TransitionRule__Group__1__Impl rule__TransitionRule__Group__2
            {
            pushFollow(FOLLOW_rule__TransitionRule__Group__1__Impl_in_rule__TransitionRule__Group__1974);
            rule__TransitionRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TransitionRule__Group__2_in_rule__TransitionRule__Group__1977);
            rule__TransitionRule__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group__1


    // $ANTLR start rule__TransitionRule__Group__1__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:490:1: rule__TransitionRule__Group__1__Impl : ( ( rule__TransitionRule__Group_1__0 )? ) ;
    public final void rule__TransitionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:494:1: ( ( ( rule__TransitionRule__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:495:1: ( ( rule__TransitionRule__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:495:1: ( ( rule__TransitionRule__Group_1__0 )? )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:496:1: ( rule__TransitionRule__Group_1__0 )?
            {
             before(grammarAccess.getTransitionRuleAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:497:1: ( rule__TransitionRule__Group_1__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID||(LA4_0>=15 && LA4_0<=17)||LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:497:2: rule__TransitionRule__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TransitionRule__Group_1__0_in_rule__TransitionRule__Group__1__Impl1004);
                    rule__TransitionRule__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionRuleAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group__1__Impl


    // $ANTLR start rule__TransitionRule__Group__2
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:507:1: rule__TransitionRule__Group__2 : rule__TransitionRule__Group__2__Impl rule__TransitionRule__Group__3 ;
    public final void rule__TransitionRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:511:1: ( rule__TransitionRule__Group__2__Impl rule__TransitionRule__Group__3 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:512:2: rule__TransitionRule__Group__2__Impl rule__TransitionRule__Group__3
            {
            pushFollow(FOLLOW_rule__TransitionRule__Group__2__Impl_in_rule__TransitionRule__Group__21035);
            rule__TransitionRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TransitionRule__Group__3_in_rule__TransitionRule__Group__21038);
            rule__TransitionRule__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group__2


    // $ANTLR start rule__TransitionRule__Group__2__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:519:1: rule__TransitionRule__Group__2__Impl : ( ( rule__TransitionRule__GuardAssignment_2 )? ) ;
    public final void rule__TransitionRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:523:1: ( ( ( rule__TransitionRule__GuardAssignment_2 )? ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:524:1: ( ( rule__TransitionRule__GuardAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:524:1: ( ( rule__TransitionRule__GuardAssignment_2 )? )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:525:1: ( rule__TransitionRule__GuardAssignment_2 )?
            {
             before(grammarAccess.getTransitionRuleAccess().getGuardAssignment_2()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:526:1: ( rule__TransitionRule__GuardAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:526:2: rule__TransitionRule__GuardAssignment_2
                    {
                    pushFollow(FOLLOW_rule__TransitionRule__GuardAssignment_2_in_rule__TransitionRule__Group__2__Impl1065);
                    rule__TransitionRule__GuardAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionRuleAccess().getGuardAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group__2__Impl


    // $ANTLR start rule__TransitionRule__Group__3
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:536:1: rule__TransitionRule__Group__3 : rule__TransitionRule__Group__3__Impl ;
    public final void rule__TransitionRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:540:1: ( rule__TransitionRule__Group__3__Impl )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:541:2: rule__TransitionRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TransitionRule__Group__3__Impl_in_rule__TransitionRule__Group__31096);
            rule__TransitionRule__Group__3__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group__3


    // $ANTLR start rule__TransitionRule__Group__3__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:547:1: rule__TransitionRule__Group__3__Impl : ( ( rule__TransitionRule__EffectAssignment_3 )? ) ;
    public final void rule__TransitionRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:551:1: ( ( ( rule__TransitionRule__EffectAssignment_3 )? ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:552:1: ( ( rule__TransitionRule__EffectAssignment_3 )? )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:552:1: ( ( rule__TransitionRule__EffectAssignment_3 )? )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:553:1: ( rule__TransitionRule__EffectAssignment_3 )?
            {
             before(grammarAccess.getTransitionRuleAccess().getEffectAssignment_3()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:554:1: ( rule__TransitionRule__EffectAssignment_3 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:554:2: rule__TransitionRule__EffectAssignment_3
                    {
                    pushFollow(FOLLOW_rule__TransitionRule__EffectAssignment_3_in_rule__TransitionRule__Group__3__Impl1123);
                    rule__TransitionRule__EffectAssignment_3();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionRuleAccess().getEffectAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group__3__Impl


    // $ANTLR start rule__TransitionRule__Group_1__0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:572:1: rule__TransitionRule__Group_1__0 : rule__TransitionRule__Group_1__0__Impl rule__TransitionRule__Group_1__1 ;
    public final void rule__TransitionRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:576:1: ( rule__TransitionRule__Group_1__0__Impl rule__TransitionRule__Group_1__1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:577:2: rule__TransitionRule__Group_1__0__Impl rule__TransitionRule__Group_1__1
            {
            pushFollow(FOLLOW_rule__TransitionRule__Group_1__0__Impl_in_rule__TransitionRule__Group_1__01162);
            rule__TransitionRule__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TransitionRule__Group_1__1_in_rule__TransitionRule__Group_1__01165);
            rule__TransitionRule__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group_1__0


    // $ANTLR start rule__TransitionRule__Group_1__0__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:584:1: rule__TransitionRule__Group_1__0__Impl : ( ( rule__TransitionRule__TriggersAssignment_1_0 ) ) ;
    public final void rule__TransitionRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:588:1: ( ( ( rule__TransitionRule__TriggersAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:589:1: ( ( rule__TransitionRule__TriggersAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:589:1: ( ( rule__TransitionRule__TriggersAssignment_1_0 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:590:1: ( rule__TransitionRule__TriggersAssignment_1_0 )
            {
             before(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_1_0()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:591:1: ( rule__TransitionRule__TriggersAssignment_1_0 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:591:2: rule__TransitionRule__TriggersAssignment_1_0
            {
            pushFollow(FOLLOW_rule__TransitionRule__TriggersAssignment_1_0_in_rule__TransitionRule__Group_1__0__Impl1192);
            rule__TransitionRule__TriggersAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group_1__0__Impl


    // $ANTLR start rule__TransitionRule__Group_1__1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:601:1: rule__TransitionRule__Group_1__1 : rule__TransitionRule__Group_1__1__Impl ;
    public final void rule__TransitionRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:605:1: ( rule__TransitionRule__Group_1__1__Impl )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:606:2: rule__TransitionRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TransitionRule__Group_1__1__Impl_in_rule__TransitionRule__Group_1__11222);
            rule__TransitionRule__Group_1__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group_1__1


    // $ANTLR start rule__TransitionRule__Group_1__1__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:612:1: rule__TransitionRule__Group_1__1__Impl : ( ( rule__TransitionRule__Group_1_1__0 )* ) ;
    public final void rule__TransitionRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:616:1: ( ( ( rule__TransitionRule__Group_1_1__0 )* ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:617:1: ( ( rule__TransitionRule__Group_1_1__0 )* )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:617:1: ( ( rule__TransitionRule__Group_1_1__0 )* )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:618:1: ( rule__TransitionRule__Group_1_1__0 )*
            {
             before(grammarAccess.getTransitionRuleAccess().getGroup_1_1()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:619:1: ( rule__TransitionRule__Group_1_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:619:2: rule__TransitionRule__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__TransitionRule__Group_1_1__0_in_rule__TransitionRule__Group_1__1__Impl1249);
            	    rule__TransitionRule__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getTransitionRuleAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group_1__1__Impl


    // $ANTLR start rule__TransitionRule__Group_1_1__0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:633:1: rule__TransitionRule__Group_1_1__0 : rule__TransitionRule__Group_1_1__0__Impl rule__TransitionRule__Group_1_1__1 ;
    public final void rule__TransitionRule__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:637:1: ( rule__TransitionRule__Group_1_1__0__Impl rule__TransitionRule__Group_1_1__1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:638:2: rule__TransitionRule__Group_1_1__0__Impl rule__TransitionRule__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__TransitionRule__Group_1_1__0__Impl_in_rule__TransitionRule__Group_1_1__01284);
            rule__TransitionRule__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TransitionRule__Group_1_1__1_in_rule__TransitionRule__Group_1_1__01287);
            rule__TransitionRule__Group_1_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group_1_1__0


    // $ANTLR start rule__TransitionRule__Group_1_1__0__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:645:1: rule__TransitionRule__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__TransitionRule__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:649:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:650:1: ( ',' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:650:1: ( ',' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:651:1: ','
            {
             before(grammarAccess.getTransitionRuleAccess().getCommaKeyword_1_1_0()); 
            match(input,14,FOLLOW_14_in_rule__TransitionRule__Group_1_1__0__Impl1315); 
             after(grammarAccess.getTransitionRuleAccess().getCommaKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group_1_1__0__Impl


    // $ANTLR start rule__TransitionRule__Group_1_1__1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:664:1: rule__TransitionRule__Group_1_1__1 : rule__TransitionRule__Group_1_1__1__Impl ;
    public final void rule__TransitionRule__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:668:1: ( rule__TransitionRule__Group_1_1__1__Impl )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:669:2: rule__TransitionRule__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TransitionRule__Group_1_1__1__Impl_in_rule__TransitionRule__Group_1_1__11346);
            rule__TransitionRule__Group_1_1__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group_1_1__1


    // $ANTLR start rule__TransitionRule__Group_1_1__1__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:675:1: rule__TransitionRule__Group_1_1__1__Impl : ( ( rule__TransitionRule__TriggersAssignment_1_1_1 ) ) ;
    public final void rule__TransitionRule__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:679:1: ( ( ( rule__TransitionRule__TriggersAssignment_1_1_1 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:680:1: ( ( rule__TransitionRule__TriggersAssignment_1_1_1 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:680:1: ( ( rule__TransitionRule__TriggersAssignment_1_1_1 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:681:1: ( rule__TransitionRule__TriggersAssignment_1_1_1 )
            {
             before(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_1_1_1()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:682:1: ( rule__TransitionRule__TriggersAssignment_1_1_1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:682:2: rule__TransitionRule__TriggersAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__TransitionRule__TriggersAssignment_1_1_1_in_rule__TransitionRule__Group_1_1__1__Impl1373);
            rule__TransitionRule__TriggersAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getTransitionRuleAccess().getTriggersAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__Group_1_1__1__Impl


    // $ANTLR start rule__RelativeTimeEventRule__Group__0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:696:1: rule__RelativeTimeEventRule__Group__0 : rule__RelativeTimeEventRule__Group__0__Impl rule__RelativeTimeEventRule__Group__1 ;
    public final void rule__RelativeTimeEventRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:700:1: ( rule__RelativeTimeEventRule__Group__0__Impl rule__RelativeTimeEventRule__Group__1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:701:2: rule__RelativeTimeEventRule__Group__0__Impl rule__RelativeTimeEventRule__Group__1
            {
            pushFollow(FOLLOW_rule__RelativeTimeEventRule__Group__0__Impl_in_rule__RelativeTimeEventRule__Group__01407);
            rule__RelativeTimeEventRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__RelativeTimeEventRule__Group__1_in_rule__RelativeTimeEventRule__Group__01410);
            rule__RelativeTimeEventRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RelativeTimeEventRule__Group__0


    // $ANTLR start rule__RelativeTimeEventRule__Group__0__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:708:1: rule__RelativeTimeEventRule__Group__0__Impl : ( 'after' ) ;
    public final void rule__RelativeTimeEventRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:712:1: ( ( 'after' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:713:1: ( 'after' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:713:1: ( 'after' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:714:1: 'after'
            {
             before(grammarAccess.getRelativeTimeEventRuleAccess().getAfterKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__RelativeTimeEventRule__Group__0__Impl1438); 
             after(grammarAccess.getRelativeTimeEventRuleAccess().getAfterKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RelativeTimeEventRule__Group__0__Impl


    // $ANTLR start rule__RelativeTimeEventRule__Group__1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:727:1: rule__RelativeTimeEventRule__Group__1 : rule__RelativeTimeEventRule__Group__1__Impl ;
    public final void rule__RelativeTimeEventRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:731:1: ( rule__RelativeTimeEventRule__Group__1__Impl )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:732:2: rule__RelativeTimeEventRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RelativeTimeEventRule__Group__1__Impl_in_rule__RelativeTimeEventRule__Group__11469);
            rule__RelativeTimeEventRule__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RelativeTimeEventRule__Group__1


    // $ANTLR start rule__RelativeTimeEventRule__Group__1__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:738:1: rule__RelativeTimeEventRule__Group__1__Impl : ( ( rule__RelativeTimeEventRule__ExprAssignment_1 ) ) ;
    public final void rule__RelativeTimeEventRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:742:1: ( ( ( rule__RelativeTimeEventRule__ExprAssignment_1 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:743:1: ( ( rule__RelativeTimeEventRule__ExprAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:743:1: ( ( rule__RelativeTimeEventRule__ExprAssignment_1 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:744:1: ( rule__RelativeTimeEventRule__ExprAssignment_1 )
            {
             before(grammarAccess.getRelativeTimeEventRuleAccess().getExprAssignment_1()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:745:1: ( rule__RelativeTimeEventRule__ExprAssignment_1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:745:2: rule__RelativeTimeEventRule__ExprAssignment_1
            {
            pushFollow(FOLLOW_rule__RelativeTimeEventRule__ExprAssignment_1_in_rule__RelativeTimeEventRule__Group__1__Impl1496);
            rule__RelativeTimeEventRule__ExprAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getRelativeTimeEventRuleAccess().getExprAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RelativeTimeEventRule__Group__1__Impl


    // $ANTLR start rule__AbsoluteTimeEventRule__Group__0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:759:1: rule__AbsoluteTimeEventRule__Group__0 : rule__AbsoluteTimeEventRule__Group__0__Impl rule__AbsoluteTimeEventRule__Group__1 ;
    public final void rule__AbsoluteTimeEventRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:763:1: ( rule__AbsoluteTimeEventRule__Group__0__Impl rule__AbsoluteTimeEventRule__Group__1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:764:2: rule__AbsoluteTimeEventRule__Group__0__Impl rule__AbsoluteTimeEventRule__Group__1
            {
            pushFollow(FOLLOW_rule__AbsoluteTimeEventRule__Group__0__Impl_in_rule__AbsoluteTimeEventRule__Group__01530);
            rule__AbsoluteTimeEventRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AbsoluteTimeEventRule__Group__1_in_rule__AbsoluteTimeEventRule__Group__01533);
            rule__AbsoluteTimeEventRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AbsoluteTimeEventRule__Group__0


    // $ANTLR start rule__AbsoluteTimeEventRule__Group__0__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:771:1: rule__AbsoluteTimeEventRule__Group__0__Impl : ( 'at' ) ;
    public final void rule__AbsoluteTimeEventRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:775:1: ( ( 'at' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:776:1: ( 'at' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:776:1: ( 'at' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:777:1: 'at'
            {
             before(grammarAccess.getAbsoluteTimeEventRuleAccess().getAtKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__AbsoluteTimeEventRule__Group__0__Impl1561); 
             after(grammarAccess.getAbsoluteTimeEventRuleAccess().getAtKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AbsoluteTimeEventRule__Group__0__Impl


    // $ANTLR start rule__AbsoluteTimeEventRule__Group__1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:790:1: rule__AbsoluteTimeEventRule__Group__1 : rule__AbsoluteTimeEventRule__Group__1__Impl ;
    public final void rule__AbsoluteTimeEventRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:794:1: ( rule__AbsoluteTimeEventRule__Group__1__Impl )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:795:2: rule__AbsoluteTimeEventRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AbsoluteTimeEventRule__Group__1__Impl_in_rule__AbsoluteTimeEventRule__Group__11592);
            rule__AbsoluteTimeEventRule__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AbsoluteTimeEventRule__Group__1


    // $ANTLR start rule__AbsoluteTimeEventRule__Group__1__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:801:1: rule__AbsoluteTimeEventRule__Group__1__Impl : ( ( rule__AbsoluteTimeEventRule__ExprAssignment_1 ) ) ;
    public final void rule__AbsoluteTimeEventRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:805:1: ( ( ( rule__AbsoluteTimeEventRule__ExprAssignment_1 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:806:1: ( ( rule__AbsoluteTimeEventRule__ExprAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:806:1: ( ( rule__AbsoluteTimeEventRule__ExprAssignment_1 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:807:1: ( rule__AbsoluteTimeEventRule__ExprAssignment_1 )
            {
             before(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprAssignment_1()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:808:1: ( rule__AbsoluteTimeEventRule__ExprAssignment_1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:808:2: rule__AbsoluteTimeEventRule__ExprAssignment_1
            {
            pushFollow(FOLLOW_rule__AbsoluteTimeEventRule__ExprAssignment_1_in_rule__AbsoluteTimeEventRule__Group__1__Impl1619);
            rule__AbsoluteTimeEventRule__ExprAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AbsoluteTimeEventRule__Group__1__Impl


    // $ANTLR start rule__ChangeEventRule__Group__0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:822:1: rule__ChangeEventRule__Group__0 : rule__ChangeEventRule__Group__0__Impl rule__ChangeEventRule__Group__1 ;
    public final void rule__ChangeEventRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:826:1: ( rule__ChangeEventRule__Group__0__Impl rule__ChangeEventRule__Group__1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:827:2: rule__ChangeEventRule__Group__0__Impl rule__ChangeEventRule__Group__1
            {
            pushFollow(FOLLOW_rule__ChangeEventRule__Group__0__Impl_in_rule__ChangeEventRule__Group__01653);
            rule__ChangeEventRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ChangeEventRule__Group__1_in_rule__ChangeEventRule__Group__01656);
            rule__ChangeEventRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ChangeEventRule__Group__0


    // $ANTLR start rule__ChangeEventRule__Group__0__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:834:1: rule__ChangeEventRule__Group__0__Impl : ( 'when' ) ;
    public final void rule__ChangeEventRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:838:1: ( ( 'when' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:839:1: ( 'when' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:839:1: ( 'when' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:840:1: 'when'
            {
             before(grammarAccess.getChangeEventRuleAccess().getWhenKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__ChangeEventRule__Group__0__Impl1684); 
             after(grammarAccess.getChangeEventRuleAccess().getWhenKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ChangeEventRule__Group__0__Impl


    // $ANTLR start rule__ChangeEventRule__Group__1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:853:1: rule__ChangeEventRule__Group__1 : rule__ChangeEventRule__Group__1__Impl ;
    public final void rule__ChangeEventRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:857:1: ( rule__ChangeEventRule__Group__1__Impl )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:858:2: rule__ChangeEventRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ChangeEventRule__Group__1__Impl_in_rule__ChangeEventRule__Group__11715);
            rule__ChangeEventRule__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ChangeEventRule__Group__1


    // $ANTLR start rule__ChangeEventRule__Group__1__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:864:1: rule__ChangeEventRule__Group__1__Impl : ( ( rule__ChangeEventRule__ExpAssignment_1 ) ) ;
    public final void rule__ChangeEventRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:868:1: ( ( ( rule__ChangeEventRule__ExpAssignment_1 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:869:1: ( ( rule__ChangeEventRule__ExpAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:869:1: ( ( rule__ChangeEventRule__ExpAssignment_1 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:870:1: ( rule__ChangeEventRule__ExpAssignment_1 )
            {
             before(grammarAccess.getChangeEventRuleAccess().getExpAssignment_1()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:871:1: ( rule__ChangeEventRule__ExpAssignment_1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:871:2: rule__ChangeEventRule__ExpAssignment_1
            {
            pushFollow(FOLLOW_rule__ChangeEventRule__ExpAssignment_1_in_rule__ChangeEventRule__Group__1__Impl1742);
            rule__ChangeEventRule__ExpAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getChangeEventRuleAccess().getExpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ChangeEventRule__Group__1__Impl


    // $ANTLR start rule__GuardRule__Group__0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:885:1: rule__GuardRule__Group__0 : rule__GuardRule__Group__0__Impl rule__GuardRule__Group__1 ;
    public final void rule__GuardRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:889:1: ( rule__GuardRule__Group__0__Impl rule__GuardRule__Group__1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:890:2: rule__GuardRule__Group__0__Impl rule__GuardRule__Group__1
            {
            pushFollow(FOLLOW_rule__GuardRule__Group__0__Impl_in_rule__GuardRule__Group__01776);
            rule__GuardRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__GuardRule__Group__1_in_rule__GuardRule__Group__01779);
            rule__GuardRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GuardRule__Group__0


    // $ANTLR start rule__GuardRule__Group__0__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:897:1: rule__GuardRule__Group__0__Impl : ( '[' ) ;
    public final void rule__GuardRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:901:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:902:1: ( '[' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:902:1: ( '[' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:903:1: '['
            {
             before(grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__GuardRule__Group__0__Impl1807); 
             after(grammarAccess.getGuardRuleAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GuardRule__Group__0__Impl


    // $ANTLR start rule__GuardRule__Group__1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:916:1: rule__GuardRule__Group__1 : rule__GuardRule__Group__1__Impl rule__GuardRule__Group__2 ;
    public final void rule__GuardRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:920:1: ( rule__GuardRule__Group__1__Impl rule__GuardRule__Group__2 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:921:2: rule__GuardRule__Group__1__Impl rule__GuardRule__Group__2
            {
            pushFollow(FOLLOW_rule__GuardRule__Group__1__Impl_in_rule__GuardRule__Group__11838);
            rule__GuardRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__GuardRule__Group__2_in_rule__GuardRule__Group__11841);
            rule__GuardRule__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GuardRule__Group__1


    // $ANTLR start rule__GuardRule__Group__1__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:928:1: rule__GuardRule__Group__1__Impl : ( ( rule__GuardRule__ConstraintAssignment_1 ) ) ;
    public final void rule__GuardRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:932:1: ( ( ( rule__GuardRule__ConstraintAssignment_1 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:933:1: ( ( rule__GuardRule__ConstraintAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:933:1: ( ( rule__GuardRule__ConstraintAssignment_1 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:934:1: ( rule__GuardRule__ConstraintAssignment_1 )
            {
             before(grammarAccess.getGuardRuleAccess().getConstraintAssignment_1()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:935:1: ( rule__GuardRule__ConstraintAssignment_1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:935:2: rule__GuardRule__ConstraintAssignment_1
            {
            pushFollow(FOLLOW_rule__GuardRule__ConstraintAssignment_1_in_rule__GuardRule__Group__1__Impl1868);
            rule__GuardRule__ConstraintAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getGuardRuleAccess().getConstraintAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GuardRule__Group__1__Impl


    // $ANTLR start rule__GuardRule__Group__2
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:945:1: rule__GuardRule__Group__2 : rule__GuardRule__Group__2__Impl ;
    public final void rule__GuardRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:949:1: ( rule__GuardRule__Group__2__Impl )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:950:2: rule__GuardRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__GuardRule__Group__2__Impl_in_rule__GuardRule__Group__21898);
            rule__GuardRule__Group__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GuardRule__Group__2


    // $ANTLR start rule__GuardRule__Group__2__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:956:1: rule__GuardRule__Group__2__Impl : ( ']' ) ;
    public final void rule__GuardRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:960:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:961:1: ( ']' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:961:1: ( ']' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:962:1: ']'
            {
             before(grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__GuardRule__Group__2__Impl1926); 
             after(grammarAccess.getGuardRuleAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GuardRule__Group__2__Impl


    // $ANTLR start rule__EffectRule__Group__0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:981:1: rule__EffectRule__Group__0 : rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1 ;
    public final void rule__EffectRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:985:1: ( rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:986:2: rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__0__Impl_in_rule__EffectRule__Group__01963);
            rule__EffectRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EffectRule__Group__1_in_rule__EffectRule__Group__01966);
            rule__EffectRule__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EffectRule__Group__0


    // $ANTLR start rule__EffectRule__Group__0__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:993:1: rule__EffectRule__Group__0__Impl : ( '/' ) ;
    public final void rule__EffectRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:997:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:998:1: ( '/' )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:998:1: ( '/' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:999:1: '/'
            {
             before(grammarAccess.getEffectRuleAccess().getSolidusKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__EffectRule__Group__0__Impl1994); 
             after(grammarAccess.getEffectRuleAccess().getSolidusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EffectRule__Group__0__Impl


    // $ANTLR start rule__EffectRule__Group__1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1012:1: rule__EffectRule__Group__1 : rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2 ;
    public final void rule__EffectRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1016:1: ( rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1017:2: rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__1__Impl_in_rule__EffectRule__Group__12025);
            rule__EffectRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EffectRule__Group__2_in_rule__EffectRule__Group__12028);
            rule__EffectRule__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EffectRule__Group__1


    // $ANTLR start rule__EffectRule__Group__1__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1024:1: rule__EffectRule__Group__1__Impl : ( ( rule__EffectRule__KindAssignment_1 ) ) ;
    public final void rule__EffectRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1028:1: ( ( ( rule__EffectRule__KindAssignment_1 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1029:1: ( ( rule__EffectRule__KindAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1029:1: ( ( rule__EffectRule__KindAssignment_1 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1030:1: ( rule__EffectRule__KindAssignment_1 )
            {
             before(grammarAccess.getEffectRuleAccess().getKindAssignment_1()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1031:1: ( rule__EffectRule__KindAssignment_1 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1031:2: rule__EffectRule__KindAssignment_1
            {
            pushFollow(FOLLOW_rule__EffectRule__KindAssignment_1_in_rule__EffectRule__Group__1__Impl2055);
            rule__EffectRule__KindAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEffectRuleAccess().getKindAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EffectRule__Group__1__Impl


    // $ANTLR start rule__EffectRule__Group__2
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1041:1: rule__EffectRule__Group__2 : rule__EffectRule__Group__2__Impl ;
    public final void rule__EffectRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1045:1: ( rule__EffectRule__Group__2__Impl )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1046:2: rule__EffectRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__2__Impl_in_rule__EffectRule__Group__22085);
            rule__EffectRule__Group__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EffectRule__Group__2


    // $ANTLR start rule__EffectRule__Group__2__Impl
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1052:1: rule__EffectRule__Group__2__Impl : ( ( rule__EffectRule__BehaviorNameAssignment_2 ) ) ;
    public final void rule__EffectRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1056:1: ( ( ( rule__EffectRule__BehaviorNameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1057:1: ( ( rule__EffectRule__BehaviorNameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1057:1: ( ( rule__EffectRule__BehaviorNameAssignment_2 ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1058:1: ( rule__EffectRule__BehaviorNameAssignment_2 )
            {
             before(grammarAccess.getEffectRuleAccess().getBehaviorNameAssignment_2()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1059:1: ( rule__EffectRule__BehaviorNameAssignment_2 )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1059:2: rule__EffectRule__BehaviorNameAssignment_2
            {
            pushFollow(FOLLOW_rule__EffectRule__BehaviorNameAssignment_2_in_rule__EffectRule__Group__2__Impl2112);
            rule__EffectRule__BehaviorNameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getEffectRuleAccess().getBehaviorNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EffectRule__Group__2__Impl


    // $ANTLR start rule__TransitionRule__NameAssignment_0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1076:1: rule__TransitionRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__TransitionRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1080:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1081:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1081:1: ( RULE_ID )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1082:1: RULE_ID
            {
             before(grammarAccess.getTransitionRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TransitionRule__NameAssignment_02153); 
             after(grammarAccess.getTransitionRuleAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__NameAssignment_0


    // $ANTLR start rule__TransitionRule__TriggersAssignment_1_0
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1091:1: rule__TransitionRule__TriggersAssignment_1_0 : ( ruleEventRule ) ;
    public final void rule__TransitionRule__TriggersAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1095:1: ( ( ruleEventRule ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1096:1: ( ruleEventRule )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1096:1: ( ruleEventRule )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1097:1: ruleEventRule
            {
             before(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleEventRule_in_rule__TransitionRule__TriggersAssignment_1_02184);
            ruleEventRule();
            _fsp--;

             after(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__TriggersAssignment_1_0


    // $ANTLR start rule__TransitionRule__TriggersAssignment_1_1_1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1106:1: rule__TransitionRule__TriggersAssignment_1_1_1 : ( ruleEventRule ) ;
    public final void rule__TransitionRule__TriggersAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1110:1: ( ( ruleEventRule ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1111:1: ( ruleEventRule )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1111:1: ( ruleEventRule )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1112:1: ruleEventRule
            {
             before(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleEventRule_in_rule__TransitionRule__TriggersAssignment_1_1_12215);
            ruleEventRule();
            _fsp--;

             after(grammarAccess.getTransitionRuleAccess().getTriggersEventRuleParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__TriggersAssignment_1_1_1


    // $ANTLR start rule__TransitionRule__GuardAssignment_2
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1121:1: rule__TransitionRule__GuardAssignment_2 : ( ruleGuardRule ) ;
    public final void rule__TransitionRule__GuardAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1125:1: ( ( ruleGuardRule ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1126:1: ( ruleGuardRule )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1126:1: ( ruleGuardRule )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1127:1: ruleGuardRule
            {
             before(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleGuardRule_in_rule__TransitionRule__GuardAssignment_22246);
            ruleGuardRule();
            _fsp--;

             after(grammarAccess.getTransitionRuleAccess().getGuardGuardRuleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__GuardAssignment_2


    // $ANTLR start rule__TransitionRule__EffectAssignment_3
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1136:1: rule__TransitionRule__EffectAssignment_3 : ( ruleEffectRule ) ;
    public final void rule__TransitionRule__EffectAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1140:1: ( ( ruleEffectRule ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1141:1: ( ruleEffectRule )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1141:1: ( ruleEffectRule )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1142:1: ruleEffectRule
            {
             before(grammarAccess.getTransitionRuleAccess().getEffectEffectRuleParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleEffectRule_in_rule__TransitionRule__EffectAssignment_32277);
            ruleEffectRule();
            _fsp--;

             after(grammarAccess.getTransitionRuleAccess().getEffectEffectRuleParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TransitionRule__EffectAssignment_3


    // $ANTLR start rule__CallOrSignalEventRule__OperationOrSignalAssignment
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1151:1: rule__CallOrSignalEventRule__OperationOrSignalAssignment : ( ( RULE_ID ) ) ;
    public final void rule__CallOrSignalEventRule__OperationOrSignalAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1155:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1156:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1156:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1157:1: ( RULE_ID )
            {
             before(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementCrossReference_0()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1158:1: ( RULE_ID )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1159:1: RULE_ID
            {
             before(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CallOrSignalEventRule__OperationOrSignalAssignment2312); 
             after(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getCallOrSignalEventRuleAccess().getOperationOrSignalNamedElementCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__CallOrSignalEventRule__OperationOrSignalAssignment


    // $ANTLR start rule__AnyReceiveEventRule__IsAReceiveEventAssignment
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1170:1: rule__AnyReceiveEventRule__IsAReceiveEventAssignment : ( ( 'all' ) ) ;
    public final void rule__AnyReceiveEventRule__IsAReceiveEventAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1174:1: ( ( ( 'all' ) ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1175:1: ( ( 'all' ) )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1175:1: ( ( 'all' ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1176:1: ( 'all' )
            {
             before(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0()); 
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1177:1: ( 'all' )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1178:1: 'all'
            {
             before(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__AnyReceiveEventRule__IsAReceiveEventAssignment2352); 
             after(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0()); 

            }

             after(grammarAccess.getAnyReceiveEventRuleAccess().getIsAReceiveEventAllKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AnyReceiveEventRule__IsAReceiveEventAssignment


    // $ANTLR start rule__RelativeTimeEventRule__ExprAssignment_1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1193:1: rule__RelativeTimeEventRule__ExprAssignment_1 : ( RULE_STRING ) ;
    public final void rule__RelativeTimeEventRule__ExprAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1197:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1198:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1198:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1199:1: RULE_STRING
            {
             before(grammarAccess.getRelativeTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__RelativeTimeEventRule__ExprAssignment_12391); 
             after(grammarAccess.getRelativeTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__RelativeTimeEventRule__ExprAssignment_1


    // $ANTLR start rule__AbsoluteTimeEventRule__ExprAssignment_1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1208:1: rule__AbsoluteTimeEventRule__ExprAssignment_1 : ( RULE_STRING ) ;
    public final void rule__AbsoluteTimeEventRule__ExprAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1212:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1213:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1213:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1214:1: RULE_STRING
            {
             before(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__AbsoluteTimeEventRule__ExprAssignment_12422); 
             after(grammarAccess.getAbsoluteTimeEventRuleAccess().getExprSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AbsoluteTimeEventRule__ExprAssignment_1


    // $ANTLR start rule__ChangeEventRule__ExpAssignment_1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1223:1: rule__ChangeEventRule__ExpAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ChangeEventRule__ExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1227:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1228:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1228:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1229:1: RULE_STRING
            {
             before(grammarAccess.getChangeEventRuleAccess().getExpSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ChangeEventRule__ExpAssignment_12453); 
             after(grammarAccess.getChangeEventRuleAccess().getExpSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ChangeEventRule__ExpAssignment_1


    // $ANTLR start rule__GuardRule__ConstraintAssignment_1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1238:1: rule__GuardRule__ConstraintAssignment_1 : ( RULE_STRING ) ;
    public final void rule__GuardRule__ConstraintAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1242:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1243:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1243:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1244:1: RULE_STRING
            {
             before(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__GuardRule__ConstraintAssignment_12484); 
             after(grammarAccess.getGuardRuleAccess().getConstraintSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__GuardRule__ConstraintAssignment_1


    // $ANTLR start rule__EffectRule__KindAssignment_1
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1253:1: rule__EffectRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
    public final void rule__EffectRule__KindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1257:1: ( ( ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1258:1: ( ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1258:1: ( ruleBehaviorKind )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1259:1: ruleBehaviorKind
            {
             before(grammarAccess.getEffectRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBehaviorKind_in_rule__EffectRule__KindAssignment_12515);
            ruleBehaviorKind();
            _fsp--;

             after(grammarAccess.getEffectRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EffectRule__KindAssignment_1


    // $ANTLR start rule__EffectRule__BehaviorNameAssignment_2
    // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1268:1: rule__EffectRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EffectRule__BehaviorNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1272:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1273:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1273:1: ( RULE_ID )
            // ../org.eclipse.papyrus.transition.editor.xtext.ui/src-gen/org/eclipse/papyrus/transition/editor/xtext/ui/contentassist/antlr/internal/InternalUmlTransition.g:1274:1: RULE_ID
            {
             before(grammarAccess.getEffectRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EffectRule__BehaviorNameAssignment_22546); 
             after(grammarAccess.getEffectRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__EffectRule__BehaviorNameAssignment_2


 

    public static final BitSet FOLLOW_ruleTransitionRule_in_entryRuleTransitionRule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group__0_in_ruleTransitionRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRule_in_entryRuleEventRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventRule__Alternatives_in_ruleEventRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOrSignalEventRule_in_entryRuleCallOrSignalEventRule181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallOrSignalEventRule188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallOrSignalEventRule__OperationOrSignalAssignment_in_ruleCallOrSignalEventRule214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnyReceiveEventRule_in_entryRuleAnyReceiveEventRule241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnyReceiveEventRule248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AnyReceiveEventRule__IsAReceiveEventAssignment_in_ruleAnyReceiveEventRule274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventRule_in_entryRuleTimeEventRule301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeEventRule308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimeEventRule__Alternatives_in_ruleTimeEventRule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelativeTimeEventRule_in_entryRuleRelativeTimeEventRule361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelativeTimeEventRule368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelativeTimeEventRule__Group__0_in_ruleRelativeTimeEventRule394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbsoluteTimeEventRule_in_entryRuleAbsoluteTimeEventRule421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbsoluteTimeEventRule428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbsoluteTimeEventRule__Group__0_in_ruleAbsoluteTimeEventRule454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChangeEventRule_in_entryRuleChangeEventRule481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChangeEventRule488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChangeEventRule__Group__0_in_ruleChangeEventRule514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardRule_in_entryRuleGuardRule541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuardRule548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GuardRule__Group__0_in_ruleGuardRule574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_entryRuleEffectRule601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEffectRule608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__0_in_ruleEffectRule634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BehaviorKind__Alternatives_in_ruleBehaviorKind671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallOrSignalEventRule_in_rule__EventRule__Alternatives706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnyReceiveEventRule_in_rule__EventRule__Alternatives723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeEventRule_in_rule__EventRule__Alternatives740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChangeEventRule_in_rule__EventRule__Alternatives757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelativeTimeEventRule_in_rule__TimeEventRule__Alternatives789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbsoluteTimeEventRule_in_rule__TimeEventRule__Alternatives806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BehaviorKind__Alternatives839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BehaviorKind__Alternatives860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__BehaviorKind__Alternatives881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group__0__Impl_in_rule__TransitionRule__Group__0914 = new BitSet(new long[]{0x0000000000378012L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group__1_in_rule__TransitionRule__Group__0917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__NameAssignment_0_in_rule__TransitionRule__Group__0__Impl944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group__1__Impl_in_rule__TransitionRule__Group__1974 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group__2_in_rule__TransitionRule__Group__1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group_1__0_in_rule__TransitionRule__Group__1__Impl1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group__2__Impl_in_rule__TransitionRule__Group__21035 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group__3_in_rule__TransitionRule__Group__21038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__GuardAssignment_2_in_rule__TransitionRule__Group__2__Impl1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group__3__Impl_in_rule__TransitionRule__Group__31096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__EffectAssignment_3_in_rule__TransitionRule__Group__3__Impl1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group_1__0__Impl_in_rule__TransitionRule__Group_1__01162 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group_1__1_in_rule__TransitionRule__Group_1__01165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__TriggersAssignment_1_0_in_rule__TransitionRule__Group_1__0__Impl1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group_1__1__Impl_in_rule__TransitionRule__Group_1__11222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group_1_1__0_in_rule__TransitionRule__Group_1__1__Impl1249 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group_1_1__0__Impl_in_rule__TransitionRule__Group_1_1__01284 = new BitSet(new long[]{0x0000000000238010L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group_1_1__1_in_rule__TransitionRule__Group_1_1__01287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__TransitionRule__Group_1_1__0__Impl1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__Group_1_1__1__Impl_in_rule__TransitionRule__Group_1_1__11346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransitionRule__TriggersAssignment_1_1_1_in_rule__TransitionRule__Group_1_1__1__Impl1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelativeTimeEventRule__Group__0__Impl_in_rule__RelativeTimeEventRule__Group__01407 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RelativeTimeEventRule__Group__1_in_rule__RelativeTimeEventRule__Group__01410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__RelativeTimeEventRule__Group__0__Impl1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelativeTimeEventRule__Group__1__Impl_in_rule__RelativeTimeEventRule__Group__11469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelativeTimeEventRule__ExprAssignment_1_in_rule__RelativeTimeEventRule__Group__1__Impl1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbsoluteTimeEventRule__Group__0__Impl_in_rule__AbsoluteTimeEventRule__Group__01530 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AbsoluteTimeEventRule__Group__1_in_rule__AbsoluteTimeEventRule__Group__01533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__AbsoluteTimeEventRule__Group__0__Impl1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbsoluteTimeEventRule__Group__1__Impl_in_rule__AbsoluteTimeEventRule__Group__11592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbsoluteTimeEventRule__ExprAssignment_1_in_rule__AbsoluteTimeEventRule__Group__1__Impl1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChangeEventRule__Group__0__Impl_in_rule__ChangeEventRule__Group__01653 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ChangeEventRule__Group__1_in_rule__ChangeEventRule__Group__01656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ChangeEventRule__Group__0__Impl1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChangeEventRule__Group__1__Impl_in_rule__ChangeEventRule__Group__11715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChangeEventRule__ExpAssignment_1_in_rule__ChangeEventRule__Group__1__Impl1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GuardRule__Group__0__Impl_in_rule__GuardRule__Group__01776 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__GuardRule__Group__1_in_rule__GuardRule__Group__01779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__GuardRule__Group__0__Impl1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GuardRule__Group__1__Impl_in_rule__GuardRule__Group__11838 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__GuardRule__Group__2_in_rule__GuardRule__Group__11841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GuardRule__ConstraintAssignment_1_in_rule__GuardRule__Group__1__Impl1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GuardRule__Group__2__Impl_in_rule__GuardRule__Group__21898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__GuardRule__Group__2__Impl1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__0__Impl_in_rule__EffectRule__Group__01963 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__1_in_rule__EffectRule__Group__01966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__EffectRule__Group__0__Impl1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__1__Impl_in_rule__EffectRule__Group__12025 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__2_in_rule__EffectRule__Group__12028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__KindAssignment_1_in_rule__EffectRule__Group__1__Impl2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__2__Impl_in_rule__EffectRule__Group__22085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__BehaviorNameAssignment_2_in_rule__EffectRule__Group__2__Impl2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TransitionRule__NameAssignment_02153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRule_in_rule__TransitionRule__TriggersAssignment_1_02184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventRule_in_rule__TransitionRule__TriggersAssignment_1_1_12215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuardRule_in_rule__TransitionRule__GuardAssignment_22246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_rule__TransitionRule__EffectAssignment_32277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CallOrSignalEventRule__OperationOrSignalAssignment2312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__AnyReceiveEventRule__IsAReceiveEventAssignment2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__RelativeTimeEventRule__ExprAssignment_12391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__AbsoluteTimeEventRule__ExprAssignment_12422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ChangeEventRule__ExpAssignment_12453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__GuardRule__ConstraintAssignment_12484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_rule__EffectRule__KindAssignment_12515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EffectRule__BehaviorNameAssignment_22546 = new BitSet(new long[]{0x0000000000000002L});

}