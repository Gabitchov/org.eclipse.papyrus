package org.eclipse.papyrus.state.editor.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.state.editor.xtext.services.UmlStateGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlStateParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Activity'", "'StateMachine'", "'OpaqueBehavior'", "':'", "'::'", "'entry'", "'do'", "'exit'"
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
    public String getGrammarFileName() { return "../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g"; }


     
     	private UmlStateGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UmlStateGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleStateRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:61:1: entryRuleStateRule : ruleStateRule EOF ;
    public final void entryRuleStateRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:62:1: ( ruleStateRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:63:1: ruleStateRule EOF
            {
             before(grammarAccess.getStateRuleRule()); 
            pushFollow(FOLLOW_ruleStateRule_in_entryRuleStateRule61);
            ruleStateRule();
            _fsp--;

             after(grammarAccess.getStateRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateRule68); 

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
    // $ANTLR end entryRuleStateRule


    // $ANTLR start ruleStateRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:70:1: ruleStateRule : ( ( rule__StateRule__Group__0 ) ) ;
    public final void ruleStateRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:74:2: ( ( ( rule__StateRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:75:1: ( ( rule__StateRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:75:1: ( ( rule__StateRule__Group__0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:76:1: ( rule__StateRule__Group__0 )
            {
             before(grammarAccess.getStateRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:77:1: ( rule__StateRule__Group__0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:77:2: rule__StateRule__Group__0
            {
            pushFollow(FOLLOW_rule__StateRule__Group__0_in_ruleStateRule94);
            rule__StateRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getStateRuleAccess().getGroup()); 

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
    // $ANTLR end ruleStateRule


    // $ANTLR start entryRuleSubmachineRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:89:1: entryRuleSubmachineRule : ruleSubmachineRule EOF ;
    public final void entryRuleSubmachineRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:90:1: ( ruleSubmachineRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:91:1: ruleSubmachineRule EOF
            {
             before(grammarAccess.getSubmachineRuleRule()); 
            pushFollow(FOLLOW_ruleSubmachineRule_in_entryRuleSubmachineRule121);
            ruleSubmachineRule();
            _fsp--;

             after(grammarAccess.getSubmachineRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubmachineRule128); 

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
    // $ANTLR end entryRuleSubmachineRule


    // $ANTLR start ruleSubmachineRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:98:1: ruleSubmachineRule : ( ( rule__SubmachineRule__Group__0 ) ) ;
    public final void ruleSubmachineRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:102:2: ( ( ( rule__SubmachineRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:103:1: ( ( rule__SubmachineRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:103:1: ( ( rule__SubmachineRule__Group__0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:104:1: ( rule__SubmachineRule__Group__0 )
            {
             before(grammarAccess.getSubmachineRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:105:1: ( rule__SubmachineRule__Group__0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:105:2: rule__SubmachineRule__Group__0
            {
            pushFollow(FOLLOW_rule__SubmachineRule__Group__0_in_ruleSubmachineRule154);
            rule__SubmachineRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSubmachineRuleAccess().getGroup()); 

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
    // $ANTLR end ruleSubmachineRule


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:117:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:118:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:119:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName181);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName188); 

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
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:126:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:130:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:131:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:132:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:133:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:133:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName214);
            rule__QualifiedName__Group__0();
            _fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

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
    // $ANTLR end ruleQualifiedName


    // $ANTLR start entryRuleEntryRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:145:1: entryRuleEntryRule : ruleEntryRule EOF ;
    public final void entryRuleEntryRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:146:1: ( ruleEntryRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:147:1: ruleEntryRule EOF
            {
             before(grammarAccess.getEntryRuleRule()); 
            pushFollow(FOLLOW_ruleEntryRule_in_entryRuleEntryRule241);
            ruleEntryRule();
            _fsp--;

             after(grammarAccess.getEntryRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryRule248); 

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
    // $ANTLR end entryRuleEntryRule


    // $ANTLR start ruleEntryRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:154:1: ruleEntryRule : ( ( rule__EntryRule__Group__0 ) ) ;
    public final void ruleEntryRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:158:2: ( ( ( rule__EntryRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:159:1: ( ( rule__EntryRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:159:1: ( ( rule__EntryRule__Group__0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:160:1: ( rule__EntryRule__Group__0 )
            {
             before(grammarAccess.getEntryRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:161:1: ( rule__EntryRule__Group__0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:161:2: rule__EntryRule__Group__0
            {
            pushFollow(FOLLOW_rule__EntryRule__Group__0_in_ruleEntryRule274);
            rule__EntryRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEntryRuleAccess().getGroup()); 

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
    // $ANTLR end ruleEntryRule


    // $ANTLR start entryRuleDoRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:173:1: entryRuleDoRule : ruleDoRule EOF ;
    public final void entryRuleDoRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:174:1: ( ruleDoRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:175:1: ruleDoRule EOF
            {
             before(grammarAccess.getDoRuleRule()); 
            pushFollow(FOLLOW_ruleDoRule_in_entryRuleDoRule301);
            ruleDoRule();
            _fsp--;

             after(grammarAccess.getDoRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoRule308); 

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
    // $ANTLR end entryRuleDoRule


    // $ANTLR start ruleDoRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:182:1: ruleDoRule : ( ( rule__DoRule__Group__0 ) ) ;
    public final void ruleDoRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:186:2: ( ( ( rule__DoRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:187:1: ( ( rule__DoRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:187:1: ( ( rule__DoRule__Group__0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:188:1: ( rule__DoRule__Group__0 )
            {
             before(grammarAccess.getDoRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:189:1: ( rule__DoRule__Group__0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:189:2: rule__DoRule__Group__0
            {
            pushFollow(FOLLOW_rule__DoRule__Group__0_in_ruleDoRule334);
            rule__DoRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getDoRuleAccess().getGroup()); 

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
    // $ANTLR end ruleDoRule


    // $ANTLR start entryRuleExitRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:201:1: entryRuleExitRule : ruleExitRule EOF ;
    public final void entryRuleExitRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:202:1: ( ruleExitRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:203:1: ruleExitRule EOF
            {
             before(grammarAccess.getExitRuleRule()); 
            pushFollow(FOLLOW_ruleExitRule_in_entryRuleExitRule361);
            ruleExitRule();
            _fsp--;

             after(grammarAccess.getExitRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitRule368); 

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
    // $ANTLR end entryRuleExitRule


    // $ANTLR start ruleExitRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:210:1: ruleExitRule : ( ( rule__ExitRule__Group__0 ) ) ;
    public final void ruleExitRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:214:2: ( ( ( rule__ExitRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:215:1: ( ( rule__ExitRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:215:1: ( ( rule__ExitRule__Group__0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:216:1: ( rule__ExitRule__Group__0 )
            {
             before(grammarAccess.getExitRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:217:1: ( rule__ExitRule__Group__0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:217:2: rule__ExitRule__Group__0
            {
            pushFollow(FOLLOW_rule__ExitRule__Group__0_in_ruleExitRule394);
            rule__ExitRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getExitRuleAccess().getGroup()); 

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
    // $ANTLR end ruleExitRule


    // $ANTLR start ruleBehaviorKind
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:230:1: ruleBehaviorKind : ( ( rule__BehaviorKind__Alternatives ) ) ;
    public final void ruleBehaviorKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:234:1: ( ( ( rule__BehaviorKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:235:1: ( ( rule__BehaviorKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:235:1: ( ( rule__BehaviorKind__Alternatives ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:236:1: ( rule__BehaviorKind__Alternatives )
            {
             before(grammarAccess.getBehaviorKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:237:1: ( rule__BehaviorKind__Alternatives )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:237:2: rule__BehaviorKind__Alternatives
            {
            pushFollow(FOLLOW_rule__BehaviorKind__Alternatives_in_ruleBehaviorKind431);
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


    // $ANTLR start rule__BehaviorKind__Alternatives
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:248:1: rule__BehaviorKind__Alternatives : ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) );
    public final void rule__BehaviorKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:252:1: ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("248:1: rule__BehaviorKind__Alternatives : ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:253:1: ( ( 'Activity' ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:253:1: ( ( 'Activity' ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:254:1: ( 'Activity' )
                    {
                     before(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:255:1: ( 'Activity' )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:255:3: 'Activity'
                    {
                    match(input,11,FOLLOW_11_in_rule__BehaviorKind__Alternatives467); 

                    }

                     after(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:260:6: ( ( 'StateMachine' ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:260:6: ( ( 'StateMachine' ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:261:1: ( 'StateMachine' )
                    {
                     before(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:262:1: ( 'StateMachine' )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:262:3: 'StateMachine'
                    {
                    match(input,12,FOLLOW_12_in_rule__BehaviorKind__Alternatives488); 

                    }

                     after(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:267:6: ( ( 'OpaqueBehavior' ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:267:6: ( ( 'OpaqueBehavior' ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:268:1: ( 'OpaqueBehavior' )
                    {
                     before(grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:269:1: ( 'OpaqueBehavior' )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:269:3: 'OpaqueBehavior'
                    {
                    match(input,13,FOLLOW_13_in_rule__BehaviorKind__Alternatives509); 

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


    // $ANTLR start rule__StateRule__Group__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:281:1: rule__StateRule__Group__0 : rule__StateRule__Group__0__Impl rule__StateRule__Group__1 ;
    public final void rule__StateRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:285:1: ( rule__StateRule__Group__0__Impl rule__StateRule__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:286:2: rule__StateRule__Group__0__Impl rule__StateRule__Group__1
            {
            pushFollow(FOLLOW_rule__StateRule__Group__0__Impl_in_rule__StateRule__Group__0542);
            rule__StateRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__StateRule__Group__1_in_rule__StateRule__Group__0545);
            rule__StateRule__Group__1();
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
    // $ANTLR end rule__StateRule__Group__0


    // $ANTLR start rule__StateRule__Group__0__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:293:1: rule__StateRule__Group__0__Impl : ( ( rule__StateRule__NameAssignment_0 ) ) ;
    public final void rule__StateRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:297:1: ( ( ( rule__StateRule__NameAssignment_0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:298:1: ( ( rule__StateRule__NameAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:298:1: ( ( rule__StateRule__NameAssignment_0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:299:1: ( rule__StateRule__NameAssignment_0 )
            {
             before(grammarAccess.getStateRuleAccess().getNameAssignment_0()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:300:1: ( rule__StateRule__NameAssignment_0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:300:2: rule__StateRule__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__StateRule__NameAssignment_0_in_rule__StateRule__Group__0__Impl572);
            rule__StateRule__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getStateRuleAccess().getNameAssignment_0()); 

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
    // $ANTLR end rule__StateRule__Group__0__Impl


    // $ANTLR start rule__StateRule__Group__1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:310:1: rule__StateRule__Group__1 : rule__StateRule__Group__1__Impl rule__StateRule__Group__2 ;
    public final void rule__StateRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:314:1: ( rule__StateRule__Group__1__Impl rule__StateRule__Group__2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:315:2: rule__StateRule__Group__1__Impl rule__StateRule__Group__2
            {
            pushFollow(FOLLOW_rule__StateRule__Group__1__Impl_in_rule__StateRule__Group__1602);
            rule__StateRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__StateRule__Group__2_in_rule__StateRule__Group__1605);
            rule__StateRule__Group__2();
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
    // $ANTLR end rule__StateRule__Group__1


    // $ANTLR start rule__StateRule__Group__1__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:322:1: rule__StateRule__Group__1__Impl : ( ( rule__StateRule__Group_1__0 )? ) ;
    public final void rule__StateRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:326:1: ( ( ( rule__StateRule__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:327:1: ( ( rule__StateRule__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:327:1: ( ( rule__StateRule__Group_1__0 )? )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:328:1: ( rule__StateRule__Group_1__0 )?
            {
             before(grammarAccess.getStateRuleAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:329:1: ( rule__StateRule__Group_1__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:329:2: rule__StateRule__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__StateRule__Group_1__0_in_rule__StateRule__Group__1__Impl632);
                    rule__StateRule__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateRuleAccess().getGroup_1()); 

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
    // $ANTLR end rule__StateRule__Group__1__Impl


    // $ANTLR start rule__StateRule__Group__2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:339:1: rule__StateRule__Group__2 : rule__StateRule__Group__2__Impl ;
    public final void rule__StateRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:343:1: ( rule__StateRule__Group__2__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:344:2: rule__StateRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__StateRule__Group__2__Impl_in_rule__StateRule__Group__2663);
            rule__StateRule__Group__2__Impl();
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
    // $ANTLR end rule__StateRule__Group__2


    // $ANTLR start rule__StateRule__Group__2__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:350:1: rule__StateRule__Group__2__Impl : ( ( rule__StateRule__UnorderedGroup_2 ) ) ;
    public final void rule__StateRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:354:1: ( ( ( rule__StateRule__UnorderedGroup_2 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:355:1: ( ( rule__StateRule__UnorderedGroup_2 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:355:1: ( ( rule__StateRule__UnorderedGroup_2 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:356:1: ( rule__StateRule__UnorderedGroup_2 )
            {
             before(grammarAccess.getStateRuleAccess().getUnorderedGroup_2()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:357:1: ( rule__StateRule__UnorderedGroup_2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:357:2: rule__StateRule__UnorderedGroup_2
            {
            pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_2_in_rule__StateRule__Group__2__Impl690);
            rule__StateRule__UnorderedGroup_2();
            _fsp--;


            }

             after(grammarAccess.getStateRuleAccess().getUnorderedGroup_2()); 

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
    // $ANTLR end rule__StateRule__Group__2__Impl


    // $ANTLR start rule__StateRule__Group_1__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:373:1: rule__StateRule__Group_1__0 : rule__StateRule__Group_1__0__Impl rule__StateRule__Group_1__1 ;
    public final void rule__StateRule__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:377:1: ( rule__StateRule__Group_1__0__Impl rule__StateRule__Group_1__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:378:2: rule__StateRule__Group_1__0__Impl rule__StateRule__Group_1__1
            {
            pushFollow(FOLLOW_rule__StateRule__Group_1__0__Impl_in_rule__StateRule__Group_1__0726);
            rule__StateRule__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__StateRule__Group_1__1_in_rule__StateRule__Group_1__0729);
            rule__StateRule__Group_1__1();
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
    // $ANTLR end rule__StateRule__Group_1__0


    // $ANTLR start rule__StateRule__Group_1__0__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:385:1: rule__StateRule__Group_1__0__Impl : ( ':' ) ;
    public final void rule__StateRule__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:389:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:390:1: ( ':' )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:390:1: ( ':' )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:391:1: ':'
            {
             before(grammarAccess.getStateRuleAccess().getColonKeyword_1_0()); 
            match(input,14,FOLLOW_14_in_rule__StateRule__Group_1__0__Impl757); 
             after(grammarAccess.getStateRuleAccess().getColonKeyword_1_0()); 

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
    // $ANTLR end rule__StateRule__Group_1__0__Impl


    // $ANTLR start rule__StateRule__Group_1__1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:404:1: rule__StateRule__Group_1__1 : rule__StateRule__Group_1__1__Impl ;
    public final void rule__StateRule__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:408:1: ( rule__StateRule__Group_1__1__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:409:2: rule__StateRule__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__StateRule__Group_1__1__Impl_in_rule__StateRule__Group_1__1788);
            rule__StateRule__Group_1__1__Impl();
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
    // $ANTLR end rule__StateRule__Group_1__1


    // $ANTLR start rule__StateRule__Group_1__1__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:415:1: rule__StateRule__Group_1__1__Impl : ( ( rule__StateRule__SubmachineAssignment_1_1 ) ) ;
    public final void rule__StateRule__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:419:1: ( ( ( rule__StateRule__SubmachineAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:420:1: ( ( rule__StateRule__SubmachineAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:420:1: ( ( rule__StateRule__SubmachineAssignment_1_1 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:421:1: ( rule__StateRule__SubmachineAssignment_1_1 )
            {
             before(grammarAccess.getStateRuleAccess().getSubmachineAssignment_1_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:422:1: ( rule__StateRule__SubmachineAssignment_1_1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:422:2: rule__StateRule__SubmachineAssignment_1_1
            {
            pushFollow(FOLLOW_rule__StateRule__SubmachineAssignment_1_1_in_rule__StateRule__Group_1__1__Impl815);
            rule__StateRule__SubmachineAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getStateRuleAccess().getSubmachineAssignment_1_1()); 

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
    // $ANTLR end rule__StateRule__Group_1__1__Impl


    // $ANTLR start rule__SubmachineRule__Group__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:436:1: rule__SubmachineRule__Group__0 : rule__SubmachineRule__Group__0__Impl rule__SubmachineRule__Group__1 ;
    public final void rule__SubmachineRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:440:1: ( rule__SubmachineRule__Group__0__Impl rule__SubmachineRule__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:441:2: rule__SubmachineRule__Group__0__Impl rule__SubmachineRule__Group__1
            {
            pushFollow(FOLLOW_rule__SubmachineRule__Group__0__Impl_in_rule__SubmachineRule__Group__0849);
            rule__SubmachineRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__SubmachineRule__Group__1_in_rule__SubmachineRule__Group__0852);
            rule__SubmachineRule__Group__1();
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
    // $ANTLR end rule__SubmachineRule__Group__0


    // $ANTLR start rule__SubmachineRule__Group__0__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:448:1: rule__SubmachineRule__Group__0__Impl : ( ( rule__SubmachineRule__PathAssignment_0 )? ) ;
    public final void rule__SubmachineRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:452:1: ( ( ( rule__SubmachineRule__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:453:1: ( ( rule__SubmachineRule__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:453:1: ( ( rule__SubmachineRule__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:454:1: ( rule__SubmachineRule__PathAssignment_0 )?
            {
             before(grammarAccess.getSubmachineRuleAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:455:1: ( rule__SubmachineRule__PathAssignment_0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==15) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:455:2: rule__SubmachineRule__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__SubmachineRule__PathAssignment_0_in_rule__SubmachineRule__Group__0__Impl879);
                    rule__SubmachineRule__PathAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubmachineRuleAccess().getPathAssignment_0()); 

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
    // $ANTLR end rule__SubmachineRule__Group__0__Impl


    // $ANTLR start rule__SubmachineRule__Group__1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:465:1: rule__SubmachineRule__Group__1 : rule__SubmachineRule__Group__1__Impl ;
    public final void rule__SubmachineRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:469:1: ( rule__SubmachineRule__Group__1__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:470:2: rule__SubmachineRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SubmachineRule__Group__1__Impl_in_rule__SubmachineRule__Group__1910);
            rule__SubmachineRule__Group__1__Impl();
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
    // $ANTLR end rule__SubmachineRule__Group__1


    // $ANTLR start rule__SubmachineRule__Group__1__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:476:1: rule__SubmachineRule__Group__1__Impl : ( ( rule__SubmachineRule__SubmachineAssignment_1 ) ) ;
    public final void rule__SubmachineRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:480:1: ( ( ( rule__SubmachineRule__SubmachineAssignment_1 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:481:1: ( ( rule__SubmachineRule__SubmachineAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:481:1: ( ( rule__SubmachineRule__SubmachineAssignment_1 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:482:1: ( rule__SubmachineRule__SubmachineAssignment_1 )
            {
             before(grammarAccess.getSubmachineRuleAccess().getSubmachineAssignment_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:483:1: ( rule__SubmachineRule__SubmachineAssignment_1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:483:2: rule__SubmachineRule__SubmachineAssignment_1
            {
            pushFollow(FOLLOW_rule__SubmachineRule__SubmachineAssignment_1_in_rule__SubmachineRule__Group__1__Impl937);
            rule__SubmachineRule__SubmachineAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getSubmachineRuleAccess().getSubmachineAssignment_1()); 

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
    // $ANTLR end rule__SubmachineRule__Group__1__Impl


    // $ANTLR start rule__QualifiedName__Group__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:497:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:501:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:502:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0971);
            rule__QualifiedName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0974);
            rule__QualifiedName__Group__1();
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
    // $ANTLR end rule__QualifiedName__Group__0


    // $ANTLR start rule__QualifiedName__Group__0__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:509:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:513:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:514:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:514:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:515:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:516:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:516:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1001);
            rule__QualifiedName__PathAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 

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
    // $ANTLR end rule__QualifiedName__Group__0__Impl


    // $ANTLR start rule__QualifiedName__Group__1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:526:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:530:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:531:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11031);
            rule__QualifiedName__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11034);
            rule__QualifiedName__Group__2();
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
    // $ANTLR end rule__QualifiedName__Group__1


    // $ANTLR start rule__QualifiedName__Group__1__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:538:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:542:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:543:1: ( '::' )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:543:1: ( '::' )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:544:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__QualifiedName__Group__1__Impl1062); 
             after(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 

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
    // $ANTLR end rule__QualifiedName__Group__1__Impl


    // $ANTLR start rule__QualifiedName__Group__2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:557:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:561:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:562:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21093);
            rule__QualifiedName__Group__2__Impl();
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
    // $ANTLR end rule__QualifiedName__Group__2


    // $ANTLR start rule__QualifiedName__Group__2__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:568:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:572:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:573:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:573:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:574:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:575:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==15) ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:575:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1120);
                    rule__QualifiedName__RemainingAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 

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
    // $ANTLR end rule__QualifiedName__Group__2__Impl


    // $ANTLR start rule__EntryRule__Group__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:591:1: rule__EntryRule__Group__0 : rule__EntryRule__Group__0__Impl rule__EntryRule__Group__1 ;
    public final void rule__EntryRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:595:1: ( rule__EntryRule__Group__0__Impl rule__EntryRule__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:596:2: rule__EntryRule__Group__0__Impl rule__EntryRule__Group__1
            {
            pushFollow(FOLLOW_rule__EntryRule__Group__0__Impl_in_rule__EntryRule__Group__01157);
            rule__EntryRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EntryRule__Group__1_in_rule__EntryRule__Group__01160);
            rule__EntryRule__Group__1();
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
    // $ANTLR end rule__EntryRule__Group__0


    // $ANTLR start rule__EntryRule__Group__0__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:603:1: rule__EntryRule__Group__0__Impl : ( 'entry' ) ;
    public final void rule__EntryRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:607:1: ( ( 'entry' ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:608:1: ( 'entry' )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:608:1: ( 'entry' )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:609:1: 'entry'
            {
             before(grammarAccess.getEntryRuleAccess().getEntryKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__EntryRule__Group__0__Impl1188); 
             after(grammarAccess.getEntryRuleAccess().getEntryKeyword_0()); 

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
    // $ANTLR end rule__EntryRule__Group__0__Impl


    // $ANTLR start rule__EntryRule__Group__1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:622:1: rule__EntryRule__Group__1 : rule__EntryRule__Group__1__Impl rule__EntryRule__Group__2 ;
    public final void rule__EntryRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:626:1: ( rule__EntryRule__Group__1__Impl rule__EntryRule__Group__2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:627:2: rule__EntryRule__Group__1__Impl rule__EntryRule__Group__2
            {
            pushFollow(FOLLOW_rule__EntryRule__Group__1__Impl_in_rule__EntryRule__Group__11219);
            rule__EntryRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EntryRule__Group__2_in_rule__EntryRule__Group__11222);
            rule__EntryRule__Group__2();
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
    // $ANTLR end rule__EntryRule__Group__1


    // $ANTLR start rule__EntryRule__Group__1__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:634:1: rule__EntryRule__Group__1__Impl : ( ( rule__EntryRule__KindAssignment_1 ) ) ;
    public final void rule__EntryRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:638:1: ( ( ( rule__EntryRule__KindAssignment_1 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:639:1: ( ( rule__EntryRule__KindAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:639:1: ( ( rule__EntryRule__KindAssignment_1 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:640:1: ( rule__EntryRule__KindAssignment_1 )
            {
             before(grammarAccess.getEntryRuleAccess().getKindAssignment_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:641:1: ( rule__EntryRule__KindAssignment_1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:641:2: rule__EntryRule__KindAssignment_1
            {
            pushFollow(FOLLOW_rule__EntryRule__KindAssignment_1_in_rule__EntryRule__Group__1__Impl1249);
            rule__EntryRule__KindAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEntryRuleAccess().getKindAssignment_1()); 

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
    // $ANTLR end rule__EntryRule__Group__1__Impl


    // $ANTLR start rule__EntryRule__Group__2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:651:1: rule__EntryRule__Group__2 : rule__EntryRule__Group__2__Impl ;
    public final void rule__EntryRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:655:1: ( rule__EntryRule__Group__2__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:656:2: rule__EntryRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__EntryRule__Group__2__Impl_in_rule__EntryRule__Group__21279);
            rule__EntryRule__Group__2__Impl();
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
    // $ANTLR end rule__EntryRule__Group__2


    // $ANTLR start rule__EntryRule__Group__2__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:662:1: rule__EntryRule__Group__2__Impl : ( ( rule__EntryRule__BehaviorNameAssignment_2 ) ) ;
    public final void rule__EntryRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:666:1: ( ( ( rule__EntryRule__BehaviorNameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:667:1: ( ( rule__EntryRule__BehaviorNameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:667:1: ( ( rule__EntryRule__BehaviorNameAssignment_2 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:668:1: ( rule__EntryRule__BehaviorNameAssignment_2 )
            {
             before(grammarAccess.getEntryRuleAccess().getBehaviorNameAssignment_2()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:669:1: ( rule__EntryRule__BehaviorNameAssignment_2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:669:2: rule__EntryRule__BehaviorNameAssignment_2
            {
            pushFollow(FOLLOW_rule__EntryRule__BehaviorNameAssignment_2_in_rule__EntryRule__Group__2__Impl1306);
            rule__EntryRule__BehaviorNameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getEntryRuleAccess().getBehaviorNameAssignment_2()); 

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
    // $ANTLR end rule__EntryRule__Group__2__Impl


    // $ANTLR start rule__DoRule__Group__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:685:1: rule__DoRule__Group__0 : rule__DoRule__Group__0__Impl rule__DoRule__Group__1 ;
    public final void rule__DoRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:689:1: ( rule__DoRule__Group__0__Impl rule__DoRule__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:690:2: rule__DoRule__Group__0__Impl rule__DoRule__Group__1
            {
            pushFollow(FOLLOW_rule__DoRule__Group__0__Impl_in_rule__DoRule__Group__01342);
            rule__DoRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DoRule__Group__1_in_rule__DoRule__Group__01345);
            rule__DoRule__Group__1();
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
    // $ANTLR end rule__DoRule__Group__0


    // $ANTLR start rule__DoRule__Group__0__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:697:1: rule__DoRule__Group__0__Impl : ( 'do' ) ;
    public final void rule__DoRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:701:1: ( ( 'do' ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:702:1: ( 'do' )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:702:1: ( 'do' )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:703:1: 'do'
            {
             before(grammarAccess.getDoRuleAccess().getDoKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__DoRule__Group__0__Impl1373); 
             after(grammarAccess.getDoRuleAccess().getDoKeyword_0()); 

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
    // $ANTLR end rule__DoRule__Group__0__Impl


    // $ANTLR start rule__DoRule__Group__1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:716:1: rule__DoRule__Group__1 : rule__DoRule__Group__1__Impl rule__DoRule__Group__2 ;
    public final void rule__DoRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:720:1: ( rule__DoRule__Group__1__Impl rule__DoRule__Group__2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:721:2: rule__DoRule__Group__1__Impl rule__DoRule__Group__2
            {
            pushFollow(FOLLOW_rule__DoRule__Group__1__Impl_in_rule__DoRule__Group__11404);
            rule__DoRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DoRule__Group__2_in_rule__DoRule__Group__11407);
            rule__DoRule__Group__2();
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
    // $ANTLR end rule__DoRule__Group__1


    // $ANTLR start rule__DoRule__Group__1__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:728:1: rule__DoRule__Group__1__Impl : ( ( rule__DoRule__KindAssignment_1 ) ) ;
    public final void rule__DoRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:732:1: ( ( ( rule__DoRule__KindAssignment_1 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:733:1: ( ( rule__DoRule__KindAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:733:1: ( ( rule__DoRule__KindAssignment_1 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:734:1: ( rule__DoRule__KindAssignment_1 )
            {
             before(grammarAccess.getDoRuleAccess().getKindAssignment_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:735:1: ( rule__DoRule__KindAssignment_1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:735:2: rule__DoRule__KindAssignment_1
            {
            pushFollow(FOLLOW_rule__DoRule__KindAssignment_1_in_rule__DoRule__Group__1__Impl1434);
            rule__DoRule__KindAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getDoRuleAccess().getKindAssignment_1()); 

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
    // $ANTLR end rule__DoRule__Group__1__Impl


    // $ANTLR start rule__DoRule__Group__2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:745:1: rule__DoRule__Group__2 : rule__DoRule__Group__2__Impl ;
    public final void rule__DoRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:749:1: ( rule__DoRule__Group__2__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:750:2: rule__DoRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DoRule__Group__2__Impl_in_rule__DoRule__Group__21464);
            rule__DoRule__Group__2__Impl();
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
    // $ANTLR end rule__DoRule__Group__2


    // $ANTLR start rule__DoRule__Group__2__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:756:1: rule__DoRule__Group__2__Impl : ( ( rule__DoRule__BehaviorNameAssignment_2 ) ) ;
    public final void rule__DoRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:760:1: ( ( ( rule__DoRule__BehaviorNameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:761:1: ( ( rule__DoRule__BehaviorNameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:761:1: ( ( rule__DoRule__BehaviorNameAssignment_2 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:762:1: ( rule__DoRule__BehaviorNameAssignment_2 )
            {
             before(grammarAccess.getDoRuleAccess().getBehaviorNameAssignment_2()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:763:1: ( rule__DoRule__BehaviorNameAssignment_2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:763:2: rule__DoRule__BehaviorNameAssignment_2
            {
            pushFollow(FOLLOW_rule__DoRule__BehaviorNameAssignment_2_in_rule__DoRule__Group__2__Impl1491);
            rule__DoRule__BehaviorNameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getDoRuleAccess().getBehaviorNameAssignment_2()); 

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
    // $ANTLR end rule__DoRule__Group__2__Impl


    // $ANTLR start rule__ExitRule__Group__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:779:1: rule__ExitRule__Group__0 : rule__ExitRule__Group__0__Impl rule__ExitRule__Group__1 ;
    public final void rule__ExitRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:783:1: ( rule__ExitRule__Group__0__Impl rule__ExitRule__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:784:2: rule__ExitRule__Group__0__Impl rule__ExitRule__Group__1
            {
            pushFollow(FOLLOW_rule__ExitRule__Group__0__Impl_in_rule__ExitRule__Group__01527);
            rule__ExitRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ExitRule__Group__1_in_rule__ExitRule__Group__01530);
            rule__ExitRule__Group__1();
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
    // $ANTLR end rule__ExitRule__Group__0


    // $ANTLR start rule__ExitRule__Group__0__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:791:1: rule__ExitRule__Group__0__Impl : ( 'exit' ) ;
    public final void rule__ExitRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:795:1: ( ( 'exit' ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:796:1: ( 'exit' )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:796:1: ( 'exit' )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:797:1: 'exit'
            {
             before(grammarAccess.getExitRuleAccess().getExitKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__ExitRule__Group__0__Impl1558); 
             after(grammarAccess.getExitRuleAccess().getExitKeyword_0()); 

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
    // $ANTLR end rule__ExitRule__Group__0__Impl


    // $ANTLR start rule__ExitRule__Group__1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:810:1: rule__ExitRule__Group__1 : rule__ExitRule__Group__1__Impl rule__ExitRule__Group__2 ;
    public final void rule__ExitRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:814:1: ( rule__ExitRule__Group__1__Impl rule__ExitRule__Group__2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:815:2: rule__ExitRule__Group__1__Impl rule__ExitRule__Group__2
            {
            pushFollow(FOLLOW_rule__ExitRule__Group__1__Impl_in_rule__ExitRule__Group__11589);
            rule__ExitRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ExitRule__Group__2_in_rule__ExitRule__Group__11592);
            rule__ExitRule__Group__2();
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
    // $ANTLR end rule__ExitRule__Group__1


    // $ANTLR start rule__ExitRule__Group__1__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:822:1: rule__ExitRule__Group__1__Impl : ( ( rule__ExitRule__KindAssignment_1 ) ) ;
    public final void rule__ExitRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:826:1: ( ( ( rule__ExitRule__KindAssignment_1 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:827:1: ( ( rule__ExitRule__KindAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:827:1: ( ( rule__ExitRule__KindAssignment_1 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:828:1: ( rule__ExitRule__KindAssignment_1 )
            {
             before(grammarAccess.getExitRuleAccess().getKindAssignment_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:829:1: ( rule__ExitRule__KindAssignment_1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:829:2: rule__ExitRule__KindAssignment_1
            {
            pushFollow(FOLLOW_rule__ExitRule__KindAssignment_1_in_rule__ExitRule__Group__1__Impl1619);
            rule__ExitRule__KindAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getExitRuleAccess().getKindAssignment_1()); 

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
    // $ANTLR end rule__ExitRule__Group__1__Impl


    // $ANTLR start rule__ExitRule__Group__2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:839:1: rule__ExitRule__Group__2 : rule__ExitRule__Group__2__Impl ;
    public final void rule__ExitRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:843:1: ( rule__ExitRule__Group__2__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:844:2: rule__ExitRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ExitRule__Group__2__Impl_in_rule__ExitRule__Group__21649);
            rule__ExitRule__Group__2__Impl();
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
    // $ANTLR end rule__ExitRule__Group__2


    // $ANTLR start rule__ExitRule__Group__2__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:850:1: rule__ExitRule__Group__2__Impl : ( ( rule__ExitRule__BehaviorNameAssignment_2 ) ) ;
    public final void rule__ExitRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:854:1: ( ( ( rule__ExitRule__BehaviorNameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:855:1: ( ( rule__ExitRule__BehaviorNameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:855:1: ( ( rule__ExitRule__BehaviorNameAssignment_2 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:856:1: ( rule__ExitRule__BehaviorNameAssignment_2 )
            {
             before(grammarAccess.getExitRuleAccess().getBehaviorNameAssignment_2()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:857:1: ( rule__ExitRule__BehaviorNameAssignment_2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:857:2: rule__ExitRule__BehaviorNameAssignment_2
            {
            pushFollow(FOLLOW_rule__ExitRule__BehaviorNameAssignment_2_in_rule__ExitRule__Group__2__Impl1676);
            rule__ExitRule__BehaviorNameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getExitRuleAccess().getBehaviorNameAssignment_2()); 

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
    // $ANTLR end rule__ExitRule__Group__2__Impl


    // $ANTLR start rule__StateRule__UnorderedGroup_2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:874:1: rule__StateRule__UnorderedGroup_2 : ( rule__StateRule__UnorderedGroup_2__0 )? ;
    public final void rule__StateRule__UnorderedGroup_2() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:879:1: ( ( rule__StateRule__UnorderedGroup_2__0 )? )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:880:2: ( rule__StateRule__UnorderedGroup_2__0 )?
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:880:2: ( rule__StateRule__UnorderedGroup_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( LA5_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0) ) {
                alt5=1;
            }
            else if ( LA5_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1) ) {
                alt5=1;
            }
            else if ( LA5_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:880:2: rule__StateRule__UnorderedGroup_2__0
                    {
                    pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_2__0_in_rule__StateRule__UnorderedGroup_21713);
                    rule__StateRule__UnorderedGroup_2__0();
                    _fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StateRule__UnorderedGroup_2


    // $ANTLR start rule__StateRule__UnorderedGroup_2__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:890:1: rule__StateRule__UnorderedGroup_2__Impl : ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) ) ) ;
    public final void rule__StateRule__UnorderedGroup_2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:895:1: ( ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:896:3: ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:896:3: ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) ) )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( LA6_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0) ) {
                alt6=1;
            }
            else if ( LA6_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1) ) {
                alt6=2;
            }
            else if ( LA6_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2) ) {
                alt6=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("896:3: ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) ) )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:898:4: ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:898:4: ({...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:899:5: {...}? => ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0) ) {
                        throw new FailedPredicateException(input, "rule__StateRule__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0)");
                    }
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:899:106: ( ( ( rule__StateRule__EntryAssignment_2_0 ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:900:6: ( ( rule__StateRule__EntryAssignment_2_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:906:6: ( ( rule__StateRule__EntryAssignment_2_0 ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:908:7: ( rule__StateRule__EntryAssignment_2_0 )
                    {
                     before(grammarAccess.getStateRuleAccess().getEntryAssignment_2_0()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:909:7: ( rule__StateRule__EntryAssignment_2_0 )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:909:8: rule__StateRule__EntryAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__StateRule__EntryAssignment_2_0_in_rule__StateRule__UnorderedGroup_2__Impl1800);
                    rule__StateRule__EntryAssignment_2_0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateRuleAccess().getEntryAssignment_2_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:915:4: ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:915:4: ({...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:916:5: {...}? => ( ( ( rule__StateRule__DoAssignment_2_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1) ) {
                        throw new FailedPredicateException(input, "rule__StateRule__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1)");
                    }
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:916:106: ( ( ( rule__StateRule__DoAssignment_2_1 ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:917:6: ( ( rule__StateRule__DoAssignment_2_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:923:6: ( ( rule__StateRule__DoAssignment_2_1 ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:925:7: ( rule__StateRule__DoAssignment_2_1 )
                    {
                     before(grammarAccess.getStateRuleAccess().getDoAssignment_2_1()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:926:7: ( rule__StateRule__DoAssignment_2_1 )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:926:8: rule__StateRule__DoAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__StateRule__DoAssignment_2_1_in_rule__StateRule__UnorderedGroup_2__Impl1891);
                    rule__StateRule__DoAssignment_2_1();
                    _fsp--;


                    }

                     after(grammarAccess.getStateRuleAccess().getDoAssignment_2_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:932:4: ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:932:4: ({...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:933:5: {...}? => ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2) ) {
                        throw new FailedPredicateException(input, "rule__StateRule__UnorderedGroup_2__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2)");
                    }
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:933:106: ( ( ( rule__StateRule__ExitAssignment_2_2 ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:934:6: ( ( rule__StateRule__ExitAssignment_2_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:940:6: ( ( rule__StateRule__ExitAssignment_2_2 ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:942:7: ( rule__StateRule__ExitAssignment_2_2 )
                    {
                     before(grammarAccess.getStateRuleAccess().getExitAssignment_2_2()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:943:7: ( rule__StateRule__ExitAssignment_2_2 )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:943:8: rule__StateRule__ExitAssignment_2_2
                    {
                    pushFollow(FOLLOW_rule__StateRule__ExitAssignment_2_2_in_rule__StateRule__UnorderedGroup_2__Impl1982);
                    rule__StateRule__ExitAssignment_2_2();
                    _fsp--;


                    }

                     after(grammarAccess.getStateRuleAccess().getExitAssignment_2_2()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_2());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StateRule__UnorderedGroup_2__Impl


    // $ANTLR start rule__StateRule__UnorderedGroup_2__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:958:1: rule__StateRule__UnorderedGroup_2__0 : rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__1 )? ;
    public final void rule__StateRule__UnorderedGroup_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:962:1: ( rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__1 )? )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:963:2: rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__1 )?
            {
            pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_2__Impl_in_rule__StateRule__UnorderedGroup_2__02041);
            rule__StateRule__UnorderedGroup_2__Impl();
            _fsp--;

            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:964:2: ( rule__StateRule__UnorderedGroup_2__1 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( LA7_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0) ) {
                alt7=1;
            }
            else if ( LA7_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1) ) {
                alt7=1;
            }
            else if ( LA7_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:964:2: rule__StateRule__UnorderedGroup_2__1
                    {
                    pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_2__1_in_rule__StateRule__UnorderedGroup_2__02044);
                    rule__StateRule__UnorderedGroup_2__1();
                    _fsp--;


                    }
                    break;

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
    // $ANTLR end rule__StateRule__UnorderedGroup_2__0


    // $ANTLR start rule__StateRule__UnorderedGroup_2__1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:971:1: rule__StateRule__UnorderedGroup_2__1 : rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__2 )? ;
    public final void rule__StateRule__UnorderedGroup_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:975:1: ( rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__2 )? )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:976:2: rule__StateRule__UnorderedGroup_2__Impl ( rule__StateRule__UnorderedGroup_2__2 )?
            {
            pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_2__Impl_in_rule__StateRule__UnorderedGroup_2__12069);
            rule__StateRule__UnorderedGroup_2__Impl();
            _fsp--;

            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:977:2: ( rule__StateRule__UnorderedGroup_2__2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_2(), 2) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:977:2: rule__StateRule__UnorderedGroup_2__2
                    {
                    pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_2__2_in_rule__StateRule__UnorderedGroup_2__12072);
                    rule__StateRule__UnorderedGroup_2__2();
                    _fsp--;


                    }
                    break;

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
    // $ANTLR end rule__StateRule__UnorderedGroup_2__1


    // $ANTLR start rule__StateRule__UnorderedGroup_2__2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:984:1: rule__StateRule__UnorderedGroup_2__2 : rule__StateRule__UnorderedGroup_2__Impl ;
    public final void rule__StateRule__UnorderedGroup_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:988:1: ( rule__StateRule__UnorderedGroup_2__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:989:2: rule__StateRule__UnorderedGroup_2__Impl
            {
            pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_2__Impl_in_rule__StateRule__UnorderedGroup_2__22097);
            rule__StateRule__UnorderedGroup_2__Impl();
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
    // $ANTLR end rule__StateRule__UnorderedGroup_2__2


    // $ANTLR start rule__StateRule__NameAssignment_0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1002:1: rule__StateRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__StateRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1006:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1007:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1007:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1008:1: RULE_ID
            {
             before(grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StateRule__NameAssignment_02131); 
             after(grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end rule__StateRule__NameAssignment_0


    // $ANTLR start rule__StateRule__SubmachineAssignment_1_1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1017:1: rule__StateRule__SubmachineAssignment_1_1 : ( ruleSubmachineRule ) ;
    public final void rule__StateRule__SubmachineAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1021:1: ( ( ruleSubmachineRule ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1022:1: ( ruleSubmachineRule )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1022:1: ( ruleSubmachineRule )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1023:1: ruleSubmachineRule
            {
             before(grammarAccess.getStateRuleAccess().getSubmachineSubmachineRuleParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleSubmachineRule_in_rule__StateRule__SubmachineAssignment_1_12162);
            ruleSubmachineRule();
            _fsp--;

             after(grammarAccess.getStateRuleAccess().getSubmachineSubmachineRuleParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__StateRule__SubmachineAssignment_1_1


    // $ANTLR start rule__StateRule__EntryAssignment_2_0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1032:1: rule__StateRule__EntryAssignment_2_0 : ( ruleEntryRule ) ;
    public final void rule__StateRule__EntryAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1036:1: ( ( ruleEntryRule ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1037:1: ( ruleEntryRule )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1037:1: ( ruleEntryRule )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1038:1: ruleEntryRule
            {
             before(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleEntryRule_in_rule__StateRule__EntryAssignment_2_02193);
            ruleEntryRule();
            _fsp--;

             after(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_2_0_0()); 

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
    // $ANTLR end rule__StateRule__EntryAssignment_2_0


    // $ANTLR start rule__StateRule__DoAssignment_2_1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1047:1: rule__StateRule__DoAssignment_2_1 : ( ruleDoRule ) ;
    public final void rule__StateRule__DoAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1051:1: ( ( ruleDoRule ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1052:1: ( ruleDoRule )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1052:1: ( ruleDoRule )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1053:1: ruleDoRule
            {
             before(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleDoRule_in_rule__StateRule__DoAssignment_2_12224);
            ruleDoRule();
            _fsp--;

             after(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__StateRule__DoAssignment_2_1


    // $ANTLR start rule__StateRule__ExitAssignment_2_2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1062:1: rule__StateRule__ExitAssignment_2_2 : ( ruleExitRule ) ;
    public final void rule__StateRule__ExitAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1066:1: ( ( ruleExitRule ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1067:1: ( ruleExitRule )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1067:1: ( ruleExitRule )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1068:1: ruleExitRule
            {
             before(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_ruleExitRule_in_rule__StateRule__ExitAssignment_2_22255);
            ruleExitRule();
            _fsp--;

             after(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_2_2_0()); 

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
    // $ANTLR end rule__StateRule__ExitAssignment_2_2


    // $ANTLR start rule__SubmachineRule__PathAssignment_0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1077:1: rule__SubmachineRule__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__SubmachineRule__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1081:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1082:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1082:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1083:1: ruleQualifiedName
            {
             before(grammarAccess.getSubmachineRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SubmachineRule__PathAssignment_02286);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getSubmachineRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 

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
    // $ANTLR end rule__SubmachineRule__PathAssignment_0


    // $ANTLR start rule__SubmachineRule__SubmachineAssignment_1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1092:1: rule__SubmachineRule__SubmachineAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__SubmachineRule__SubmachineAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1096:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1097:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1097:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1098:1: ( RULE_ID )
            {
             before(grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineCrossReference_1_0()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1099:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1100:1: RULE_ID
            {
             before(grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubmachineRule__SubmachineAssignment_12321); 
             after(grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSubmachineRuleAccess().getSubmachineStateMachineCrossReference_1_0()); 

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
    // $ANTLR end rule__SubmachineRule__SubmachineAssignment_1


    // $ANTLR start rule__QualifiedName__PathAssignment_0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1111:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1115:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1116:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1116:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1117:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1118:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1119:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_02360); 
             after(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 

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
    // $ANTLR end rule__QualifiedName__PathAssignment_0


    // $ANTLR start rule__QualifiedName__RemainingAssignment_2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1130:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1134:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1135:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1135:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1136:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_22395);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 

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
    // $ANTLR end rule__QualifiedName__RemainingAssignment_2


    // $ANTLR start rule__EntryRule__KindAssignment_1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1145:1: rule__EntryRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
    public final void rule__EntryRule__KindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1149:1: ( ( ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1150:1: ( ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1150:1: ( ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1151:1: ruleBehaviorKind
            {
             before(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBehaviorKind_in_rule__EntryRule__KindAssignment_12426);
            ruleBehaviorKind();
            _fsp--;

             after(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 

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
    // $ANTLR end rule__EntryRule__KindAssignment_1


    // $ANTLR start rule__EntryRule__BehaviorNameAssignment_2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1160:1: rule__EntryRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EntryRule__BehaviorNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1164:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1165:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1165:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1166:1: RULE_ID
            {
             before(grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EntryRule__BehaviorNameAssignment_22457); 
             after(grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end rule__EntryRule__BehaviorNameAssignment_2


    // $ANTLR start rule__DoRule__KindAssignment_1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1175:1: rule__DoRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
    public final void rule__DoRule__KindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1179:1: ( ( ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1180:1: ( ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1180:1: ( ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1181:1: ruleBehaviorKind
            {
             before(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBehaviorKind_in_rule__DoRule__KindAssignment_12488);
            ruleBehaviorKind();
            _fsp--;

             after(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 

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
    // $ANTLR end rule__DoRule__KindAssignment_1


    // $ANTLR start rule__DoRule__BehaviorNameAssignment_2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1190:1: rule__DoRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DoRule__BehaviorNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1194:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1195:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1195:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1196:1: RULE_ID
            {
             before(grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DoRule__BehaviorNameAssignment_22519); 
             after(grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end rule__DoRule__BehaviorNameAssignment_2


    // $ANTLR start rule__ExitRule__KindAssignment_1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1205:1: rule__ExitRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
    public final void rule__ExitRule__KindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1209:1: ( ( ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1210:1: ( ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1210:1: ( ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1211:1: ruleBehaviorKind
            {
             before(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBehaviorKind_in_rule__ExitRule__KindAssignment_12550);
            ruleBehaviorKind();
            _fsp--;

             after(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 

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
    // $ANTLR end rule__ExitRule__KindAssignment_1


    // $ANTLR start rule__ExitRule__BehaviorNameAssignment_2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1220:1: rule__ExitRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ExitRule__BehaviorNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1224:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1225:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1225:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:1226:1: RULE_ID
            {
             before(grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ExitRule__BehaviorNameAssignment_22581); 
             after(grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end rule__ExitRule__BehaviorNameAssignment_2


 

    public static final BitSet FOLLOW_ruleStateRule_in_entryRuleStateRule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateRule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__Group__0_in_ruleStateRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubmachineRule_in_entryRuleSubmachineRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubmachineRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubmachineRule__Group__0_in_ruleSubmachineRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryRule_in_entryRuleEntryRule241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryRule248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__0_in_ruleEntryRule274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoRule_in_entryRuleDoRule301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoRule308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__Group__0_in_ruleDoRule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitRule_in_entryRuleExitRule361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitRule368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__0_in_ruleExitRule394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BehaviorKind__Alternatives_in_ruleBehaviorKind431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BehaviorKind__Alternatives467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BehaviorKind__Alternatives488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__BehaviorKind__Alternatives509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__Group__0__Impl_in_rule__StateRule__Group__0542 = new BitSet(new long[]{0x0000000000074002L});
    public static final BitSet FOLLOW_rule__StateRule__Group__1_in_rule__StateRule__Group__0545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__NameAssignment_0_in_rule__StateRule__Group__0__Impl572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__Group__1__Impl_in_rule__StateRule__Group__1602 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_rule__StateRule__Group__2_in_rule__StateRule__Group__1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__Group_1__0_in_rule__StateRule__Group__1__Impl632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__Group__2__Impl_in_rule__StateRule__Group__2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_2_in_rule__StateRule__Group__2__Impl690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__Group_1__0__Impl_in_rule__StateRule__Group_1__0726 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__StateRule__Group_1__1_in_rule__StateRule__Group_1__0729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__StateRule__Group_1__0__Impl757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__Group_1__1__Impl_in_rule__StateRule__Group_1__1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__SubmachineAssignment_1_1_in_rule__StateRule__Group_1__1__Impl815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubmachineRule__Group__0__Impl_in_rule__SubmachineRule__Group__0849 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SubmachineRule__Group__1_in_rule__SubmachineRule__Group__0852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubmachineRule__PathAssignment_0_in_rule__SubmachineRule__Group__0__Impl879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubmachineRule__Group__1__Impl_in_rule__SubmachineRule__Group__1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubmachineRule__SubmachineAssignment_1_in_rule__SubmachineRule__Group__1__Impl937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__0971 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__0974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11031 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__11034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__QualifiedName__Group__1__Impl1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__21093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__0__Impl_in_rule__EntryRule__Group__01157 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__1_in_rule__EntryRule__Group__01160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__EntryRule__Group__0__Impl1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__1__Impl_in_rule__EntryRule__Group__11219 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__2_in_rule__EntryRule__Group__11222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__KindAssignment_1_in_rule__EntryRule__Group__1__Impl1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__2__Impl_in_rule__EntryRule__Group__21279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__BehaviorNameAssignment_2_in_rule__EntryRule__Group__2__Impl1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__Group__0__Impl_in_rule__DoRule__Group__01342 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__DoRule__Group__1_in_rule__DoRule__Group__01345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DoRule__Group__0__Impl1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__Group__1__Impl_in_rule__DoRule__Group__11404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DoRule__Group__2_in_rule__DoRule__Group__11407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__KindAssignment_1_in_rule__DoRule__Group__1__Impl1434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__Group__2__Impl_in_rule__DoRule__Group__21464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__BehaviorNameAssignment_2_in_rule__DoRule__Group__2__Impl1491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__0__Impl_in_rule__ExitRule__Group__01527 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__1_in_rule__ExitRule__Group__01530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ExitRule__Group__0__Impl1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__1__Impl_in_rule__ExitRule__Group__11589 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__2_in_rule__ExitRule__Group__11592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__KindAssignment_1_in_rule__ExitRule__Group__1__Impl1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__2__Impl_in_rule__ExitRule__Group__21649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__BehaviorNameAssignment_2_in_rule__ExitRule__Group__2__Impl1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_2__0_in_rule__StateRule__UnorderedGroup_21713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__EntryAssignment_2_0_in_rule__StateRule__UnorderedGroup_2__Impl1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__DoAssignment_2_1_in_rule__StateRule__UnorderedGroup_2__Impl1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__ExitAssignment_2_2_in_rule__StateRule__UnorderedGroup_2__Impl1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_2__Impl_in_rule__StateRule__UnorderedGroup_2__02041 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_2__1_in_rule__StateRule__UnorderedGroup_2__02044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_2__Impl_in_rule__StateRule__UnorderedGroup_2__12069 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_2__2_in_rule__StateRule__UnorderedGroup_2__12072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_2__Impl_in_rule__StateRule__UnorderedGroup_2__22097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StateRule__NameAssignment_02131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubmachineRule_in_rule__StateRule__SubmachineAssignment_1_12162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryRule_in_rule__StateRule__EntryAssignment_2_02193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoRule_in_rule__StateRule__DoAssignment_2_12224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitRule_in_rule__StateRule__ExitAssignment_2_22255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SubmachineRule__PathAssignment_02286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubmachineRule__SubmachineAssignment_12321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_02360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_22395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_rule__EntryRule__KindAssignment_12426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EntryRule__BehaviorNameAssignment_22457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_rule__DoRule__KindAssignment_12488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DoRule__BehaviorNameAssignment_22519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_rule__ExitRule__KindAssignment_12550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ExitRule__BehaviorNameAssignment_22581 = new BitSet(new long[]{0x0000000000000002L});

}
