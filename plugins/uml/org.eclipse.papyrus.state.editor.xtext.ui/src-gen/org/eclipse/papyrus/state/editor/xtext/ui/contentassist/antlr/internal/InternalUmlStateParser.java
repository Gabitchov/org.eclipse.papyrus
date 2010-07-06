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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Activity'", "'StateMachine'", "'OpaqueBehavior'", "'entry'", "'do'", "'exit'"
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


    // $ANTLR start entryRuleEntryRule
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:89:1: entryRuleEntryRule : ruleEntryRule EOF ;
    public final void entryRuleEntryRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:90:1: ( ruleEntryRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:91:1: ruleEntryRule EOF
            {
             before(grammarAccess.getEntryRuleRule()); 
            pushFollow(FOLLOW_ruleEntryRule_in_entryRuleEntryRule121);
            ruleEntryRule();
            _fsp--;

             after(grammarAccess.getEntryRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntryRule128); 

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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:98:1: ruleEntryRule : ( ( rule__EntryRule__Group__0 ) ) ;
    public final void ruleEntryRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:102:2: ( ( ( rule__EntryRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:103:1: ( ( rule__EntryRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:103:1: ( ( rule__EntryRule__Group__0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:104:1: ( rule__EntryRule__Group__0 )
            {
             before(grammarAccess.getEntryRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:105:1: ( rule__EntryRule__Group__0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:105:2: rule__EntryRule__Group__0
            {
            pushFollow(FOLLOW_rule__EntryRule__Group__0_in_ruleEntryRule154);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:117:1: entryRuleDoRule : ruleDoRule EOF ;
    public final void entryRuleDoRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:118:1: ( ruleDoRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:119:1: ruleDoRule EOF
            {
             before(grammarAccess.getDoRuleRule()); 
            pushFollow(FOLLOW_ruleDoRule_in_entryRuleDoRule181);
            ruleDoRule();
            _fsp--;

             after(grammarAccess.getDoRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoRule188); 

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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:126:1: ruleDoRule : ( ( rule__DoRule__Group__0 ) ) ;
    public final void ruleDoRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:130:2: ( ( ( rule__DoRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:131:1: ( ( rule__DoRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:131:1: ( ( rule__DoRule__Group__0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:132:1: ( rule__DoRule__Group__0 )
            {
             before(grammarAccess.getDoRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:133:1: ( rule__DoRule__Group__0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:133:2: rule__DoRule__Group__0
            {
            pushFollow(FOLLOW_rule__DoRule__Group__0_in_ruleDoRule214);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:145:1: entryRuleExitRule : ruleExitRule EOF ;
    public final void entryRuleExitRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:146:1: ( ruleExitRule EOF )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:147:1: ruleExitRule EOF
            {
             before(grammarAccess.getExitRuleRule()); 
            pushFollow(FOLLOW_ruleExitRule_in_entryRuleExitRule241);
            ruleExitRule();
            _fsp--;

             after(grammarAccess.getExitRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExitRule248); 

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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:154:1: ruleExitRule : ( ( rule__ExitRule__Group__0 ) ) ;
    public final void ruleExitRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:158:2: ( ( ( rule__ExitRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:159:1: ( ( rule__ExitRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:159:1: ( ( rule__ExitRule__Group__0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:160:1: ( rule__ExitRule__Group__0 )
            {
             before(grammarAccess.getExitRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:161:1: ( rule__ExitRule__Group__0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:161:2: rule__ExitRule__Group__0
            {
            pushFollow(FOLLOW_rule__ExitRule__Group__0_in_ruleExitRule274);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:174:1: ruleBehaviorKind : ( ( rule__BehaviorKind__Alternatives ) ) ;
    public final void ruleBehaviorKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:178:1: ( ( ( rule__BehaviorKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:179:1: ( ( rule__BehaviorKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:179:1: ( ( rule__BehaviorKind__Alternatives ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:180:1: ( rule__BehaviorKind__Alternatives )
            {
             before(grammarAccess.getBehaviorKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:181:1: ( rule__BehaviorKind__Alternatives )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:181:2: rule__BehaviorKind__Alternatives
            {
            pushFollow(FOLLOW_rule__BehaviorKind__Alternatives_in_ruleBehaviorKind311);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:192:1: rule__BehaviorKind__Alternatives : ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) );
    public final void rule__BehaviorKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:196:1: ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) )
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
                    new NoViableAltException("192:1: rule__BehaviorKind__Alternatives : ( ( ( 'Activity' ) ) | ( ( 'StateMachine' ) ) | ( ( 'OpaqueBehavior' ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:197:1: ( ( 'Activity' ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:197:1: ( ( 'Activity' ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:198:1: ( 'Activity' )
                    {
                     before(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:199:1: ( 'Activity' )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:199:3: 'Activity'
                    {
                    match(input,11,FOLLOW_11_in_rule__BehaviorKind__Alternatives347); 

                    }

                     after(grammarAccess.getBehaviorKindAccess().getACTIVITYEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:204:6: ( ( 'StateMachine' ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:204:6: ( ( 'StateMachine' ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:205:1: ( 'StateMachine' )
                    {
                     before(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:206:1: ( 'StateMachine' )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:206:3: 'StateMachine'
                    {
                    match(input,12,FOLLOW_12_in_rule__BehaviorKind__Alternatives368); 

                    }

                     after(grammarAccess.getBehaviorKindAccess().getSTATE_MACHINEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:211:6: ( ( 'OpaqueBehavior' ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:211:6: ( ( 'OpaqueBehavior' ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:212:1: ( 'OpaqueBehavior' )
                    {
                     before(grammarAccess.getBehaviorKindAccess().getOPAQUE_BEHAVIOREnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:213:1: ( 'OpaqueBehavior' )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:213:3: 'OpaqueBehavior'
                    {
                    match(input,13,FOLLOW_13_in_rule__BehaviorKind__Alternatives389); 

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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:225:1: rule__StateRule__Group__0 : rule__StateRule__Group__0__Impl rule__StateRule__Group__1 ;
    public final void rule__StateRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:229:1: ( rule__StateRule__Group__0__Impl rule__StateRule__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:230:2: rule__StateRule__Group__0__Impl rule__StateRule__Group__1
            {
            pushFollow(FOLLOW_rule__StateRule__Group__0__Impl_in_rule__StateRule__Group__0422);
            rule__StateRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__StateRule__Group__1_in_rule__StateRule__Group__0425);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:237:1: rule__StateRule__Group__0__Impl : ( ( rule__StateRule__NameAssignment_0 ) ) ;
    public final void rule__StateRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:241:1: ( ( ( rule__StateRule__NameAssignment_0 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:242:1: ( ( rule__StateRule__NameAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:242:1: ( ( rule__StateRule__NameAssignment_0 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:243:1: ( rule__StateRule__NameAssignment_0 )
            {
             before(grammarAccess.getStateRuleAccess().getNameAssignment_0()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:244:1: ( rule__StateRule__NameAssignment_0 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:244:2: rule__StateRule__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__StateRule__NameAssignment_0_in_rule__StateRule__Group__0__Impl452);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:254:1: rule__StateRule__Group__1 : rule__StateRule__Group__1__Impl ;
    public final void rule__StateRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:258:1: ( rule__StateRule__Group__1__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:259:2: rule__StateRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__StateRule__Group__1__Impl_in_rule__StateRule__Group__1482);
            rule__StateRule__Group__1__Impl();
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:265:1: rule__StateRule__Group__1__Impl : ( ( rule__StateRule__UnorderedGroup_1 ) ) ;
    public final void rule__StateRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:269:1: ( ( ( rule__StateRule__UnorderedGroup_1 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:270:1: ( ( rule__StateRule__UnorderedGroup_1 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:270:1: ( ( rule__StateRule__UnorderedGroup_1 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:271:1: ( rule__StateRule__UnorderedGroup_1 )
            {
             before(grammarAccess.getStateRuleAccess().getUnorderedGroup_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:272:1: ( rule__StateRule__UnorderedGroup_1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:272:2: rule__StateRule__UnorderedGroup_1
            {
            pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_1_in_rule__StateRule__Group__1__Impl509);
            rule__StateRule__UnorderedGroup_1();
            _fsp--;


            }

             after(grammarAccess.getStateRuleAccess().getUnorderedGroup_1()); 

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


    // $ANTLR start rule__EntryRule__Group__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:286:1: rule__EntryRule__Group__0 : rule__EntryRule__Group__0__Impl rule__EntryRule__Group__1 ;
    public final void rule__EntryRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:290:1: ( rule__EntryRule__Group__0__Impl rule__EntryRule__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:291:2: rule__EntryRule__Group__0__Impl rule__EntryRule__Group__1
            {
            pushFollow(FOLLOW_rule__EntryRule__Group__0__Impl_in_rule__EntryRule__Group__0543);
            rule__EntryRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EntryRule__Group__1_in_rule__EntryRule__Group__0546);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:298:1: rule__EntryRule__Group__0__Impl : ( 'entry' ) ;
    public final void rule__EntryRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:302:1: ( ( 'entry' ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:303:1: ( 'entry' )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:303:1: ( 'entry' )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:304:1: 'entry'
            {
             before(grammarAccess.getEntryRuleAccess().getEntryKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__EntryRule__Group__0__Impl574); 
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:317:1: rule__EntryRule__Group__1 : rule__EntryRule__Group__1__Impl rule__EntryRule__Group__2 ;
    public final void rule__EntryRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:321:1: ( rule__EntryRule__Group__1__Impl rule__EntryRule__Group__2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:322:2: rule__EntryRule__Group__1__Impl rule__EntryRule__Group__2
            {
            pushFollow(FOLLOW_rule__EntryRule__Group__1__Impl_in_rule__EntryRule__Group__1605);
            rule__EntryRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EntryRule__Group__2_in_rule__EntryRule__Group__1608);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:329:1: rule__EntryRule__Group__1__Impl : ( ( rule__EntryRule__KindAssignment_1 ) ) ;
    public final void rule__EntryRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:333:1: ( ( ( rule__EntryRule__KindAssignment_1 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:334:1: ( ( rule__EntryRule__KindAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:334:1: ( ( rule__EntryRule__KindAssignment_1 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:335:1: ( rule__EntryRule__KindAssignment_1 )
            {
             before(grammarAccess.getEntryRuleAccess().getKindAssignment_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:336:1: ( rule__EntryRule__KindAssignment_1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:336:2: rule__EntryRule__KindAssignment_1
            {
            pushFollow(FOLLOW_rule__EntryRule__KindAssignment_1_in_rule__EntryRule__Group__1__Impl635);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:346:1: rule__EntryRule__Group__2 : rule__EntryRule__Group__2__Impl ;
    public final void rule__EntryRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:350:1: ( rule__EntryRule__Group__2__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:351:2: rule__EntryRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__EntryRule__Group__2__Impl_in_rule__EntryRule__Group__2665);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:357:1: rule__EntryRule__Group__2__Impl : ( ( rule__EntryRule__BehaviorNameAssignment_2 ) ) ;
    public final void rule__EntryRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:361:1: ( ( ( rule__EntryRule__BehaviorNameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:362:1: ( ( rule__EntryRule__BehaviorNameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:362:1: ( ( rule__EntryRule__BehaviorNameAssignment_2 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:363:1: ( rule__EntryRule__BehaviorNameAssignment_2 )
            {
             before(grammarAccess.getEntryRuleAccess().getBehaviorNameAssignment_2()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:364:1: ( rule__EntryRule__BehaviorNameAssignment_2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:364:2: rule__EntryRule__BehaviorNameAssignment_2
            {
            pushFollow(FOLLOW_rule__EntryRule__BehaviorNameAssignment_2_in_rule__EntryRule__Group__2__Impl692);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:380:1: rule__DoRule__Group__0 : rule__DoRule__Group__0__Impl rule__DoRule__Group__1 ;
    public final void rule__DoRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:384:1: ( rule__DoRule__Group__0__Impl rule__DoRule__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:385:2: rule__DoRule__Group__0__Impl rule__DoRule__Group__1
            {
            pushFollow(FOLLOW_rule__DoRule__Group__0__Impl_in_rule__DoRule__Group__0728);
            rule__DoRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DoRule__Group__1_in_rule__DoRule__Group__0731);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:392:1: rule__DoRule__Group__0__Impl : ( 'do' ) ;
    public final void rule__DoRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:396:1: ( ( 'do' ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:397:1: ( 'do' )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:397:1: ( 'do' )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:398:1: 'do'
            {
             before(grammarAccess.getDoRuleAccess().getDoKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__DoRule__Group__0__Impl759); 
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:411:1: rule__DoRule__Group__1 : rule__DoRule__Group__1__Impl rule__DoRule__Group__2 ;
    public final void rule__DoRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:415:1: ( rule__DoRule__Group__1__Impl rule__DoRule__Group__2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:416:2: rule__DoRule__Group__1__Impl rule__DoRule__Group__2
            {
            pushFollow(FOLLOW_rule__DoRule__Group__1__Impl_in_rule__DoRule__Group__1790);
            rule__DoRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DoRule__Group__2_in_rule__DoRule__Group__1793);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:423:1: rule__DoRule__Group__1__Impl : ( ( rule__DoRule__KindAssignment_1 ) ) ;
    public final void rule__DoRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:427:1: ( ( ( rule__DoRule__KindAssignment_1 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:428:1: ( ( rule__DoRule__KindAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:428:1: ( ( rule__DoRule__KindAssignment_1 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:429:1: ( rule__DoRule__KindAssignment_1 )
            {
             before(grammarAccess.getDoRuleAccess().getKindAssignment_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:430:1: ( rule__DoRule__KindAssignment_1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:430:2: rule__DoRule__KindAssignment_1
            {
            pushFollow(FOLLOW_rule__DoRule__KindAssignment_1_in_rule__DoRule__Group__1__Impl820);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:440:1: rule__DoRule__Group__2 : rule__DoRule__Group__2__Impl ;
    public final void rule__DoRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:444:1: ( rule__DoRule__Group__2__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:445:2: rule__DoRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DoRule__Group__2__Impl_in_rule__DoRule__Group__2850);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:451:1: rule__DoRule__Group__2__Impl : ( ( rule__DoRule__BehaviorNameAssignment_2 ) ) ;
    public final void rule__DoRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:455:1: ( ( ( rule__DoRule__BehaviorNameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:456:1: ( ( rule__DoRule__BehaviorNameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:456:1: ( ( rule__DoRule__BehaviorNameAssignment_2 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:457:1: ( rule__DoRule__BehaviorNameAssignment_2 )
            {
             before(grammarAccess.getDoRuleAccess().getBehaviorNameAssignment_2()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:458:1: ( rule__DoRule__BehaviorNameAssignment_2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:458:2: rule__DoRule__BehaviorNameAssignment_2
            {
            pushFollow(FOLLOW_rule__DoRule__BehaviorNameAssignment_2_in_rule__DoRule__Group__2__Impl877);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:474:1: rule__ExitRule__Group__0 : rule__ExitRule__Group__0__Impl rule__ExitRule__Group__1 ;
    public final void rule__ExitRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:478:1: ( rule__ExitRule__Group__0__Impl rule__ExitRule__Group__1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:479:2: rule__ExitRule__Group__0__Impl rule__ExitRule__Group__1
            {
            pushFollow(FOLLOW_rule__ExitRule__Group__0__Impl_in_rule__ExitRule__Group__0913);
            rule__ExitRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ExitRule__Group__1_in_rule__ExitRule__Group__0916);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:486:1: rule__ExitRule__Group__0__Impl : ( 'exit' ) ;
    public final void rule__ExitRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:490:1: ( ( 'exit' ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:491:1: ( 'exit' )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:491:1: ( 'exit' )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:492:1: 'exit'
            {
             before(grammarAccess.getExitRuleAccess().getExitKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__ExitRule__Group__0__Impl944); 
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:505:1: rule__ExitRule__Group__1 : rule__ExitRule__Group__1__Impl rule__ExitRule__Group__2 ;
    public final void rule__ExitRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:509:1: ( rule__ExitRule__Group__1__Impl rule__ExitRule__Group__2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:510:2: rule__ExitRule__Group__1__Impl rule__ExitRule__Group__2
            {
            pushFollow(FOLLOW_rule__ExitRule__Group__1__Impl_in_rule__ExitRule__Group__1975);
            rule__ExitRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ExitRule__Group__2_in_rule__ExitRule__Group__1978);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:517:1: rule__ExitRule__Group__1__Impl : ( ( rule__ExitRule__KindAssignment_1 ) ) ;
    public final void rule__ExitRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:521:1: ( ( ( rule__ExitRule__KindAssignment_1 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:522:1: ( ( rule__ExitRule__KindAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:522:1: ( ( rule__ExitRule__KindAssignment_1 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:523:1: ( rule__ExitRule__KindAssignment_1 )
            {
             before(grammarAccess.getExitRuleAccess().getKindAssignment_1()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:524:1: ( rule__ExitRule__KindAssignment_1 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:524:2: rule__ExitRule__KindAssignment_1
            {
            pushFollow(FOLLOW_rule__ExitRule__KindAssignment_1_in_rule__ExitRule__Group__1__Impl1005);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:534:1: rule__ExitRule__Group__2 : rule__ExitRule__Group__2__Impl ;
    public final void rule__ExitRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:538:1: ( rule__ExitRule__Group__2__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:539:2: rule__ExitRule__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ExitRule__Group__2__Impl_in_rule__ExitRule__Group__21035);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:545:1: rule__ExitRule__Group__2__Impl : ( ( rule__ExitRule__BehaviorNameAssignment_2 ) ) ;
    public final void rule__ExitRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:549:1: ( ( ( rule__ExitRule__BehaviorNameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:550:1: ( ( rule__ExitRule__BehaviorNameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:550:1: ( ( rule__ExitRule__BehaviorNameAssignment_2 ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:551:1: ( rule__ExitRule__BehaviorNameAssignment_2 )
            {
             before(grammarAccess.getExitRuleAccess().getBehaviorNameAssignment_2()); 
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:552:1: ( rule__ExitRule__BehaviorNameAssignment_2 )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:552:2: rule__ExitRule__BehaviorNameAssignment_2
            {
            pushFollow(FOLLOW_rule__ExitRule__BehaviorNameAssignment_2_in_rule__ExitRule__Group__2__Impl1062);
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


    // $ANTLR start rule__StateRule__UnorderedGroup_1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:569:1: rule__StateRule__UnorderedGroup_1 : ( rule__StateRule__UnorderedGroup_1__0 )? ;
    public final void rule__StateRule__UnorderedGroup_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getStateRuleAccess().getUnorderedGroup_1());
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:574:1: ( ( rule__StateRule__UnorderedGroup_1__0 )? )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:575:2: ( rule__StateRule__UnorderedGroup_1__0 )?
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:575:2: ( rule__StateRule__UnorderedGroup_1__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( LA2_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0) ) {
                alt2=1;
            }
            else if ( LA2_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1) ) {
                alt2=1;
            }
            else if ( LA2_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:575:2: rule__StateRule__UnorderedGroup_1__0
                    {
                    pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_1__0_in_rule__StateRule__UnorderedGroup_11099);
                    rule__StateRule__UnorderedGroup_1__0();
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

            	getUnorderedGroupHelper().leave(grammarAccess.getStateRuleAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StateRule__UnorderedGroup_1


    // $ANTLR start rule__StateRule__UnorderedGroup_1__Impl
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:585:1: rule__StateRule__UnorderedGroup_1__Impl : ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_1_2 ) ) ) ) ) ;
    public final void rule__StateRule__UnorderedGroup_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:590:1: ( ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_1_2 ) ) ) ) ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:591:3: ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_1_2 ) ) ) ) )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:591:3: ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_1_2 ) ) ) ) )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( LA3_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0) ) {
                alt3=1;
            }
            else if ( LA3_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1) ) {
                alt3=2;
            }
            else if ( LA3_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2) ) {
                alt3=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("591:3: ( ({...}? => ( ( ( rule__StateRule__EntryAssignment_1_0 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__DoAssignment_1_1 ) ) ) ) | ({...}? => ( ( ( rule__StateRule__ExitAssignment_1_2 ) ) ) ) )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:593:4: ({...}? => ( ( ( rule__StateRule__EntryAssignment_1_0 ) ) ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:593:4: ({...}? => ( ( ( rule__StateRule__EntryAssignment_1_0 ) ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:594:5: {...}? => ( ( ( rule__StateRule__EntryAssignment_1_0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__StateRule__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0)");
                    }
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:594:106: ( ( ( rule__StateRule__EntryAssignment_1_0 ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:595:6: ( ( rule__StateRule__EntryAssignment_1_0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:601:6: ( ( rule__StateRule__EntryAssignment_1_0 ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:603:7: ( rule__StateRule__EntryAssignment_1_0 )
                    {
                     before(grammarAccess.getStateRuleAccess().getEntryAssignment_1_0()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:604:7: ( rule__StateRule__EntryAssignment_1_0 )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:604:8: rule__StateRule__EntryAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__StateRule__EntryAssignment_1_0_in_rule__StateRule__UnorderedGroup_1__Impl1186);
                    rule__StateRule__EntryAssignment_1_0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateRuleAccess().getEntryAssignment_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:610:4: ({...}? => ( ( ( rule__StateRule__DoAssignment_1_1 ) ) ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:610:4: ({...}? => ( ( ( rule__StateRule__DoAssignment_1_1 ) ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:611:5: {...}? => ( ( ( rule__StateRule__DoAssignment_1_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__StateRule__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1)");
                    }
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:611:106: ( ( ( rule__StateRule__DoAssignment_1_1 ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:612:6: ( ( rule__StateRule__DoAssignment_1_1 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:618:6: ( ( rule__StateRule__DoAssignment_1_1 ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:620:7: ( rule__StateRule__DoAssignment_1_1 )
                    {
                     before(grammarAccess.getStateRuleAccess().getDoAssignment_1_1()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:621:7: ( rule__StateRule__DoAssignment_1_1 )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:621:8: rule__StateRule__DoAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__StateRule__DoAssignment_1_1_in_rule__StateRule__UnorderedGroup_1__Impl1277);
                    rule__StateRule__DoAssignment_1_1();
                    _fsp--;


                    }

                     after(grammarAccess.getStateRuleAccess().getDoAssignment_1_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:627:4: ({...}? => ( ( ( rule__StateRule__ExitAssignment_1_2 ) ) ) )
                    {
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:627:4: ({...}? => ( ( ( rule__StateRule__ExitAssignment_1_2 ) ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:628:5: {...}? => ( ( ( rule__StateRule__ExitAssignment_1_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__StateRule__UnorderedGroup_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2)");
                    }
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:628:106: ( ( ( rule__StateRule__ExitAssignment_1_2 ) ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:629:6: ( ( rule__StateRule__ExitAssignment_1_2 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:635:6: ( ( rule__StateRule__ExitAssignment_1_2 ) )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:637:7: ( rule__StateRule__ExitAssignment_1_2 )
                    {
                     before(grammarAccess.getStateRuleAccess().getExitAssignment_1_2()); 
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:638:7: ( rule__StateRule__ExitAssignment_1_2 )
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:638:8: rule__StateRule__ExitAssignment_1_2
                    {
                    pushFollow(FOLLOW_rule__StateRule__ExitAssignment_1_2_in_rule__StateRule__UnorderedGroup_1__Impl1368);
                    rule__StateRule__ExitAssignment_1_2();
                    _fsp--;


                    }

                     after(grammarAccess.getStateRuleAccess().getExitAssignment_1_2()); 

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStateRuleAccess().getUnorderedGroup_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StateRule__UnorderedGroup_1__Impl


    // $ANTLR start rule__StateRule__UnorderedGroup_1__0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:653:1: rule__StateRule__UnorderedGroup_1__0 : rule__StateRule__UnorderedGroup_1__Impl ( rule__StateRule__UnorderedGroup_1__1 )? ;
    public final void rule__StateRule__UnorderedGroup_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:657:1: ( rule__StateRule__UnorderedGroup_1__Impl ( rule__StateRule__UnorderedGroup_1__1 )? )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:658:2: rule__StateRule__UnorderedGroup_1__Impl ( rule__StateRule__UnorderedGroup_1__1 )?
            {
            pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_1__Impl_in_rule__StateRule__UnorderedGroup_1__01427);
            rule__StateRule__UnorderedGroup_1__Impl();
            _fsp--;

            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:659:2: ( rule__StateRule__UnorderedGroup_1__1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( LA4_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0) ) {
                alt4=1;
            }
            else if ( LA4_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1) ) {
                alt4=1;
            }
            else if ( LA4_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:659:2: rule__StateRule__UnorderedGroup_1__1
                    {
                    pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_1__1_in_rule__StateRule__UnorderedGroup_1__01430);
                    rule__StateRule__UnorderedGroup_1__1();
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
    // $ANTLR end rule__StateRule__UnorderedGroup_1__0


    // $ANTLR start rule__StateRule__UnorderedGroup_1__1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:666:1: rule__StateRule__UnorderedGroup_1__1 : rule__StateRule__UnorderedGroup_1__Impl ( rule__StateRule__UnorderedGroup_1__2 )? ;
    public final void rule__StateRule__UnorderedGroup_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:670:1: ( rule__StateRule__UnorderedGroup_1__Impl ( rule__StateRule__UnorderedGroup_1__2 )? )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:671:2: rule__StateRule__UnorderedGroup_1__Impl ( rule__StateRule__UnorderedGroup_1__2 )?
            {
            pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_1__Impl_in_rule__StateRule__UnorderedGroup_1__11455);
            rule__StateRule__UnorderedGroup_1__Impl();
            _fsp--;

            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:672:2: ( rule__StateRule__UnorderedGroup_1__2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( LA5_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 0) ) {
                alt5=1;
            }
            else if ( LA5_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 1) ) {
                alt5=1;
            }
            else if ( LA5_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStateRuleAccess().getUnorderedGroup_1(), 2) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:672:2: rule__StateRule__UnorderedGroup_1__2
                    {
                    pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_1__2_in_rule__StateRule__UnorderedGroup_1__11458);
                    rule__StateRule__UnorderedGroup_1__2();
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
    // $ANTLR end rule__StateRule__UnorderedGroup_1__1


    // $ANTLR start rule__StateRule__UnorderedGroup_1__2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:679:1: rule__StateRule__UnorderedGroup_1__2 : rule__StateRule__UnorderedGroup_1__Impl ;
    public final void rule__StateRule__UnorderedGroup_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:683:1: ( rule__StateRule__UnorderedGroup_1__Impl )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:684:2: rule__StateRule__UnorderedGroup_1__Impl
            {
            pushFollow(FOLLOW_rule__StateRule__UnorderedGroup_1__Impl_in_rule__StateRule__UnorderedGroup_1__21483);
            rule__StateRule__UnorderedGroup_1__Impl();
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
    // $ANTLR end rule__StateRule__UnorderedGroup_1__2


    // $ANTLR start rule__StateRule__NameAssignment_0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:697:1: rule__StateRule__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__StateRule__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:701:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:702:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:702:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:703:1: RULE_ID
            {
             before(grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StateRule__NameAssignment_01517); 
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


    // $ANTLR start rule__StateRule__EntryAssignment_1_0
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:712:1: rule__StateRule__EntryAssignment_1_0 : ( ruleEntryRule ) ;
    public final void rule__StateRule__EntryAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:716:1: ( ( ruleEntryRule ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:717:1: ( ruleEntryRule )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:717:1: ( ruleEntryRule )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:718:1: ruleEntryRule
            {
             before(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleEntryRule_in_rule__StateRule__EntryAssignment_1_01548);
            ruleEntryRule();
            _fsp--;

             after(grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_1_0_0()); 

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
    // $ANTLR end rule__StateRule__EntryAssignment_1_0


    // $ANTLR start rule__StateRule__DoAssignment_1_1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:727:1: rule__StateRule__DoAssignment_1_1 : ( ruleDoRule ) ;
    public final void rule__StateRule__DoAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:731:1: ( ( ruleDoRule ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:732:1: ( ruleDoRule )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:732:1: ( ruleDoRule )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:733:1: ruleDoRule
            {
             before(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleDoRule_in_rule__StateRule__DoAssignment_1_11579);
            ruleDoRule();
            _fsp--;

             after(grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__StateRule__DoAssignment_1_1


    // $ANTLR start rule__StateRule__ExitAssignment_1_2
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:742:1: rule__StateRule__ExitAssignment_1_2 : ( ruleExitRule ) ;
    public final void rule__StateRule__ExitAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:746:1: ( ( ruleExitRule ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:747:1: ( ruleExitRule )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:747:1: ( ruleExitRule )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:748:1: ruleExitRule
            {
             before(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleExitRule_in_rule__StateRule__ExitAssignment_1_21610);
            ruleExitRule();
            _fsp--;

             after(grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_1_2_0()); 

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
    // $ANTLR end rule__StateRule__ExitAssignment_1_2


    // $ANTLR start rule__EntryRule__KindAssignment_1
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:757:1: rule__EntryRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
    public final void rule__EntryRule__KindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:761:1: ( ( ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:762:1: ( ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:762:1: ( ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:763:1: ruleBehaviorKind
            {
             before(grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBehaviorKind_in_rule__EntryRule__KindAssignment_11641);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:772:1: rule__EntryRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EntryRule__BehaviorNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:776:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:777:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:777:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:778:1: RULE_ID
            {
             before(grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EntryRule__BehaviorNameAssignment_21672); 
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:787:1: rule__DoRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
    public final void rule__DoRule__KindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:791:1: ( ( ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:792:1: ( ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:792:1: ( ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:793:1: ruleBehaviorKind
            {
             before(grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBehaviorKind_in_rule__DoRule__KindAssignment_11703);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:802:1: rule__DoRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__DoRule__BehaviorNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:806:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:807:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:807:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:808:1: RULE_ID
            {
             before(grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DoRule__BehaviorNameAssignment_21734); 
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:817:1: rule__ExitRule__KindAssignment_1 : ( ruleBehaviorKind ) ;
    public final void rule__ExitRule__KindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:821:1: ( ( ruleBehaviorKind ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:822:1: ( ruleBehaviorKind )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:822:1: ( ruleBehaviorKind )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:823:1: ruleBehaviorKind
            {
             before(grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBehaviorKind_in_rule__ExitRule__KindAssignment_11765);
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
    // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:832:1: rule__ExitRule__BehaviorNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ExitRule__BehaviorNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:836:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:837:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:837:1: ( RULE_ID )
            // ../org.eclipse.papyrus.state.editor.xtext.ui/src-gen/org/eclipse/papyrus/state/editor/xtext/ui/contentassist/antlr/internal/InternalUmlState.g:838:1: RULE_ID
            {
             before(grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ExitRule__BehaviorNameAssignment_21796); 
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
    public static final BitSet FOLLOW_ruleEntryRule_in_entryRuleEntryRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntryRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__0_in_ruleEntryRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoRule_in_entryRuleDoRule181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoRule188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__Group__0_in_ruleDoRule214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitRule_in_entryRuleExitRule241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExitRule248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__0_in_ruleExitRule274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BehaviorKind__Alternatives_in_ruleBehaviorKind311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BehaviorKind__Alternatives347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BehaviorKind__Alternatives368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__BehaviorKind__Alternatives389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__Group__0__Impl_in_rule__StateRule__Group__0422 = new BitSet(new long[]{0x000000000001C002L});
    public static final BitSet FOLLOW_rule__StateRule__Group__1_in_rule__StateRule__Group__0425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__NameAssignment_0_in_rule__StateRule__Group__0__Impl452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__Group__1__Impl_in_rule__StateRule__Group__1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_1_in_rule__StateRule__Group__1__Impl509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__0__Impl_in_rule__EntryRule__Group__0543 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__1_in_rule__EntryRule__Group__0546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__EntryRule__Group__0__Impl574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__1__Impl_in_rule__EntryRule__Group__1605 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__2_in_rule__EntryRule__Group__1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__KindAssignment_1_in_rule__EntryRule__Group__1__Impl635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__Group__2__Impl_in_rule__EntryRule__Group__2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EntryRule__BehaviorNameAssignment_2_in_rule__EntryRule__Group__2__Impl692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__Group__0__Impl_in_rule__DoRule__Group__0728 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__DoRule__Group__1_in_rule__DoRule__Group__0731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DoRule__Group__0__Impl759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__Group__1__Impl_in_rule__DoRule__Group__1790 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DoRule__Group__2_in_rule__DoRule__Group__1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__KindAssignment_1_in_rule__DoRule__Group__1__Impl820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__Group__2__Impl_in_rule__DoRule__Group__2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoRule__BehaviorNameAssignment_2_in_rule__DoRule__Group__2__Impl877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__0__Impl_in_rule__ExitRule__Group__0913 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__1_in_rule__ExitRule__Group__0916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ExitRule__Group__0__Impl944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__1__Impl_in_rule__ExitRule__Group__1975 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__2_in_rule__ExitRule__Group__1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__KindAssignment_1_in_rule__ExitRule__Group__1__Impl1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__Group__2__Impl_in_rule__ExitRule__Group__21035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExitRule__BehaviorNameAssignment_2_in_rule__ExitRule__Group__2__Impl1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_1__0_in_rule__StateRule__UnorderedGroup_11099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__EntryAssignment_1_0_in_rule__StateRule__UnorderedGroup_1__Impl1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__DoAssignment_1_1_in_rule__StateRule__UnorderedGroup_1__Impl1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__ExitAssignment_1_2_in_rule__StateRule__UnorderedGroup_1__Impl1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_1__Impl_in_rule__StateRule__UnorderedGroup_1__01427 = new BitSet(new long[]{0x000000000001C002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_1__1_in_rule__StateRule__UnorderedGroup_1__01430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_1__Impl_in_rule__StateRule__UnorderedGroup_1__11455 = new BitSet(new long[]{0x000000000001C002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_1__2_in_rule__StateRule__UnorderedGroup_1__11458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StateRule__UnorderedGroup_1__Impl_in_rule__StateRule__UnorderedGroup_1__21483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StateRule__NameAssignment_01517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntryRule_in_rule__StateRule__EntryAssignment_1_01548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoRule_in_rule__StateRule__DoAssignment_1_11579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExitRule_in_rule__StateRule__ExitAssignment_1_21610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_rule__EntryRule__KindAssignment_11641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EntryRule__BehaviorNameAssignment_21672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_rule__DoRule__KindAssignment_11703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DoRule__BehaviorNameAssignment_21734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBehaviorKind_in_rule__ExitRule__KindAssignment_11765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ExitRule__BehaviorNameAssignment_21796 = new BitSet(new long[]{0x0000000000000002L});

}
