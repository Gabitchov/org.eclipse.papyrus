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
package org.eclipse.papyrus.parameter.editor.xtext.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.parameter.editor.xtext.services.UmlParameterGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalUmlParameterParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNLIMITEDLITERAL", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'<Undefined>'", "'exception'", "'stream'", "'ordered'", "'unique'", "'create'", "'read'", "'update'", "'delete'", "'+'", "'-'", "'#'", "'~'", "'in'", "'out'", "'inout'", "'return'", "':'", "'{'", "'}'", "','", "'effect: '", "'::'", "'['", "']'", "'..'"
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

        public InternalUmlParameterParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g"; }


     
     	private UmlParameterGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(UmlParameterGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleParameterRule
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:61:1: entryRuleParameterRule : ruleParameterRule EOF ;
    public final void entryRuleParameterRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:62:1: ( ruleParameterRule EOF )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:63:1: ruleParameterRule EOF
            {
             before(grammarAccess.getParameterRuleRule()); 
            pushFollow(FOLLOW_ruleParameterRule_in_entryRuleParameterRule61);
            ruleParameterRule();
            _fsp--;

             after(grammarAccess.getParameterRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterRule68); 

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
    // $ANTLR end entryRuleParameterRule


    // $ANTLR start ruleParameterRule
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:70:1: ruleParameterRule : ( ( rule__ParameterRule__Group__0 ) ) ;
    public final void ruleParameterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:74:2: ( ( ( rule__ParameterRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:75:1: ( ( rule__ParameterRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:75:1: ( ( rule__ParameterRule__Group__0 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:76:1: ( rule__ParameterRule__Group__0 )
            {
             before(grammarAccess.getParameterRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:77:1: ( rule__ParameterRule__Group__0 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:77:2: rule__ParameterRule__Group__0
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__0_in_ruleParameterRule94);
            rule__ParameterRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getParameterRuleAccess().getGroup()); 

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
    // $ANTLR end ruleParameterRule


    // $ANTLR start entryRuleModifiersRule
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:89:1: entryRuleModifiersRule : ruleModifiersRule EOF ;
    public final void entryRuleModifiersRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:90:1: ( ruleModifiersRule EOF )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:91:1: ruleModifiersRule EOF
            {
             before(grammarAccess.getModifiersRuleRule()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule121);
            ruleModifiersRule();
            _fsp--;

             after(grammarAccess.getModifiersRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifiersRule128); 

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
    // $ANTLR end entryRuleModifiersRule


    // $ANTLR start ruleModifiersRule
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:98:1: ruleModifiersRule : ( ( rule__ModifiersRule__Group__0 ) ) ;
    public final void ruleModifiersRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:102:2: ( ( ( rule__ModifiersRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:103:1: ( ( rule__ModifiersRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:103:1: ( ( rule__ModifiersRule__Group__0 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:104:1: ( rule__ModifiersRule__Group__0 )
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:105:1: ( rule__ModifiersRule__Group__0 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:105:2: rule__ModifiersRule__Group__0
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule154);
            rule__ModifiersRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModifiersRuleAccess().getGroup()); 

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
    // $ANTLR end ruleModifiersRule


    // $ANTLR start entryRuleModifierSpecification
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:117:1: entryRuleModifierSpecification : ruleModifierSpecification EOF ;
    public final void entryRuleModifierSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:118:1: ( ruleModifierSpecification EOF )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:119:1: ruleModifierSpecification EOF
            {
             before(grammarAccess.getModifierSpecificationRule()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification181);
            ruleModifierSpecification();
            _fsp--;

             after(grammarAccess.getModifierSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModifierSpecification188); 

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
    // $ANTLR end entryRuleModifierSpecification


    // $ANTLR start ruleModifierSpecification
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:126:1: ruleModifierSpecification : ( ( rule__ModifierSpecification__ValueAssignment ) ) ;
    public final void ruleModifierSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:130:2: ( ( ( rule__ModifierSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:131:1: ( ( rule__ModifierSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:131:1: ( ( rule__ModifierSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:132:1: ( rule__ModifierSpecification__ValueAssignment )
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:133:1: ( rule__ModifierSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:133:2: rule__ModifierSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__ModifierSpecification__ValueAssignment_in_ruleModifierSpecification214);
            rule__ModifierSpecification__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getModifierSpecificationAccess().getValueAssignment()); 

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
    // $ANTLR end ruleModifierSpecification


    // $ANTLR start entryRuleEffectRule
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:145:1: entryRuleEffectRule : ruleEffectRule EOF ;
    public final void entryRuleEffectRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:146:1: ( ruleEffectRule EOF )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:147:1: ruleEffectRule EOF
            {
             before(grammarAccess.getEffectRuleRule()); 
            pushFollow(FOLLOW_ruleEffectRule_in_entryRuleEffectRule241);
            ruleEffectRule();
            _fsp--;

             after(grammarAccess.getEffectRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEffectRule248); 

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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:154:1: ruleEffectRule : ( ( rule__EffectRule__Group__0 ) ) ;
    public final void ruleEffectRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:158:2: ( ( ( rule__EffectRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:159:1: ( ( rule__EffectRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:159:1: ( ( rule__EffectRule__Group__0 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:160:1: ( rule__EffectRule__Group__0 )
            {
             before(grammarAccess.getEffectRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:161:1: ( rule__EffectRule__Group__0 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:161:2: rule__EffectRule__Group__0
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__0_in_ruleEffectRule274);
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


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:173:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:174:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:175:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName301);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName308); 

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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:182:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:186:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:187:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:187:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:188:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:189:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:189:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName334);
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


    // $ANTLR start entryRuleTypeRule
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:201:1: entryRuleTypeRule : ruleTypeRule EOF ;
    public final void entryRuleTypeRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:202:1: ( ruleTypeRule EOF )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:203:1: ruleTypeRule EOF
            {
             before(grammarAccess.getTypeRuleRule()); 
            pushFollow(FOLLOW_ruleTypeRule_in_entryRuleTypeRule361);
            ruleTypeRule();
            _fsp--;

             after(grammarAccess.getTypeRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRule368); 

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
    // $ANTLR end entryRuleTypeRule


    // $ANTLR start ruleTypeRule
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:210:1: ruleTypeRule : ( ( rule__TypeRule__Group__0 ) ) ;
    public final void ruleTypeRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:214:2: ( ( ( rule__TypeRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:215:1: ( ( rule__TypeRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:215:1: ( ( rule__TypeRule__Group__0 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:216:1: ( rule__TypeRule__Group__0 )
            {
             before(grammarAccess.getTypeRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:217:1: ( rule__TypeRule__Group__0 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:217:2: rule__TypeRule__Group__0
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule394);
            rule__TypeRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTypeRuleAccess().getGroup()); 

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
    // $ANTLR end ruleTypeRule


    // $ANTLR start entryRuleMultiplicityRule
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:229:1: entryRuleMultiplicityRule : ruleMultiplicityRule EOF ;
    public final void entryRuleMultiplicityRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:230:1: ( ruleMultiplicityRule EOF )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:231:1: ruleMultiplicityRule EOF
            {
             before(grammarAccess.getMultiplicityRuleRule()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule421);
            ruleMultiplicityRule();
            _fsp--;

             after(grammarAccess.getMultiplicityRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityRule428); 

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
    // $ANTLR end entryRuleMultiplicityRule


    // $ANTLR start ruleMultiplicityRule
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:238:1: ruleMultiplicityRule : ( ( rule__MultiplicityRule__Group__0 ) ) ;
    public final void ruleMultiplicityRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:242:2: ( ( ( rule__MultiplicityRule__Group__0 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:243:1: ( ( rule__MultiplicityRule__Group__0 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:243:1: ( ( rule__MultiplicityRule__Group__0 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:244:1: ( rule__MultiplicityRule__Group__0 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:245:1: ( rule__MultiplicityRule__Group__0 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:245:2: rule__MultiplicityRule__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule454);
            rule__MultiplicityRule__Group__0();
            _fsp--;


            }

             after(grammarAccess.getMultiplicityRuleAccess().getGroup()); 

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
    // $ANTLR end ruleMultiplicityRule


    // $ANTLR start entryRuleBoundSpecification
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:257:1: entryRuleBoundSpecification : ruleBoundSpecification EOF ;
    public final void entryRuleBoundSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:258:1: ( ruleBoundSpecification EOF )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:259:1: ruleBoundSpecification EOF
            {
             before(grammarAccess.getBoundSpecificationRule()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification481);
            ruleBoundSpecification();
            _fsp--;

             after(grammarAccess.getBoundSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoundSpecification488); 

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
    // $ANTLR end entryRuleBoundSpecification


    // $ANTLR start ruleBoundSpecification
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:266:1: ruleBoundSpecification : ( ( rule__BoundSpecification__ValueAssignment ) ) ;
    public final void ruleBoundSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:270:2: ( ( ( rule__BoundSpecification__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:271:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:271:1: ( ( rule__BoundSpecification__ValueAssignment ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:272:1: ( rule__BoundSpecification__ValueAssignment )
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:273:1: ( rule__BoundSpecification__ValueAssignment )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:273:2: rule__BoundSpecification__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification514);
            rule__BoundSpecification__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); 

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
    // $ANTLR end ruleBoundSpecification


    // $ANTLR start ruleModifierKind
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:286:1: ruleModifierKind : ( ( rule__ModifierKind__Alternatives ) ) ;
    public final void ruleModifierKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:290:1: ( ( ( rule__ModifierKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:291:1: ( ( rule__ModifierKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:291:1: ( ( rule__ModifierKind__Alternatives ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:292:1: ( rule__ModifierKind__Alternatives )
            {
             before(grammarAccess.getModifierKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:293:1: ( rule__ModifierKind__Alternatives )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:293:2: rule__ModifierKind__Alternatives
            {
            pushFollow(FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind551);
            rule__ModifierKind__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getModifierKindAccess().getAlternatives()); 

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
    // $ANTLR end ruleModifierKind


    // $ANTLR start ruleEffectKind
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:305:1: ruleEffectKind : ( ( rule__EffectKind__Alternatives ) ) ;
    public final void ruleEffectKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:309:1: ( ( ( rule__EffectKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:310:1: ( ( rule__EffectKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:310:1: ( ( rule__EffectKind__Alternatives ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:311:1: ( rule__EffectKind__Alternatives )
            {
             before(grammarAccess.getEffectKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:312:1: ( rule__EffectKind__Alternatives )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:312:2: rule__EffectKind__Alternatives
            {
            pushFollow(FOLLOW_rule__EffectKind__Alternatives_in_ruleEffectKind587);
            rule__EffectKind__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getEffectKindAccess().getAlternatives()); 

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
    // $ANTLR end ruleEffectKind


    // $ANTLR start ruleVisibilityKind
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:324:1: ruleVisibilityKind : ( ( rule__VisibilityKind__Alternatives ) ) ;
    public final void ruleVisibilityKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:328:1: ( ( ( rule__VisibilityKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:329:1: ( ( rule__VisibilityKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:329:1: ( ( rule__VisibilityKind__Alternatives ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:330:1: ( rule__VisibilityKind__Alternatives )
            {
             before(grammarAccess.getVisibilityKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:331:1: ( rule__VisibilityKind__Alternatives )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:331:2: rule__VisibilityKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind623);
            rule__VisibilityKind__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getVisibilityKindAccess().getAlternatives()); 

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
    // $ANTLR end ruleVisibilityKind


    // $ANTLR start ruleDirection
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:343:1: ruleDirection : ( ( rule__Direction__Alternatives ) ) ;
    public final void ruleDirection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:347:1: ( ( ( rule__Direction__Alternatives ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:348:1: ( ( rule__Direction__Alternatives ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:348:1: ( ( rule__Direction__Alternatives ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:349:1: ( rule__Direction__Alternatives )
            {
             before(grammarAccess.getDirectionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:350:1: ( rule__Direction__Alternatives )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:350:2: rule__Direction__Alternatives
            {
            pushFollow(FOLLOW_rule__Direction__Alternatives_in_ruleDirection659);
            rule__Direction__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getDirectionAccess().getAlternatives()); 

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
    // $ANTLR end ruleDirection


    // $ANTLR start rule__ParameterRule__Alternatives_4
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:361:1: rule__ParameterRule__Alternatives_4 : ( ( ( rule__ParameterRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );
    public final void rule__ParameterRule__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:365:1: ( ( ( rule__ParameterRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("361:1: rule__ParameterRule__Alternatives_4 : ( ( ( rule__ParameterRule__TypeAssignment_4_0 ) ) | ( '<Undefined>' ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:366:1: ( ( rule__ParameterRule__TypeAssignment_4_0 ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:366:1: ( ( rule__ParameterRule__TypeAssignment_4_0 ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:367:1: ( rule__ParameterRule__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getParameterRuleAccess().getTypeAssignment_4_0()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:368:1: ( rule__ParameterRule__TypeAssignment_4_0 )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:368:2: rule__ParameterRule__TypeAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__ParameterRule__TypeAssignment_4_0_in_rule__ParameterRule__Alternatives_4694);
                    rule__ParameterRule__TypeAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getParameterRuleAccess().getTypeAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:372:6: ( '<Undefined>' )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:372:6: ( '<Undefined>' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:373:1: '<Undefined>'
                    {
                     before(grammarAccess.getParameterRuleAccess().getUndefinedKeyword_4_1()); 
                    match(input,12,FOLLOW_12_in_rule__ParameterRule__Alternatives_4713); 
                     after(grammarAccess.getParameterRuleAccess().getUndefinedKeyword_4_1()); 

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
    // $ANTLR end rule__ParameterRule__Alternatives_4


    // $ANTLR start rule__ModifierKind__Alternatives
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:385:1: rule__ModifierKind__Alternatives : ( ( ( 'exception' ) ) | ( ( 'stream' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );
    public final void rule__ModifierKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:389:1: ( ( ( 'exception' ) ) | ( ( 'stream' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 15:
                {
                alt2=3;
                }
                break;
            case 16:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("385:1: rule__ModifierKind__Alternatives : ( ( ( 'exception' ) ) | ( ( 'stream' ) ) | ( ( 'ordered' ) ) | ( ( 'unique' ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:390:1: ( ( 'exception' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:390:1: ( ( 'exception' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:391:1: ( 'exception' )
                    {
                     before(grammarAccess.getModifierKindAccess().getEXCEPTIONEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:392:1: ( 'exception' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:392:3: 'exception'
                    {
                    match(input,13,FOLLOW_13_in_rule__ModifierKind__Alternatives748); 

                    }

                     after(grammarAccess.getModifierKindAccess().getEXCEPTIONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:397:6: ( ( 'stream' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:397:6: ( ( 'stream' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:398:1: ( 'stream' )
                    {
                     before(grammarAccess.getModifierKindAccess().getSTREAMEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:399:1: ( 'stream' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:399:3: 'stream'
                    {
                    match(input,14,FOLLOW_14_in_rule__ModifierKind__Alternatives769); 

                    }

                     after(grammarAccess.getModifierKindAccess().getSTREAMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:404:6: ( ( 'ordered' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:404:6: ( ( 'ordered' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:405:1: ( 'ordered' )
                    {
                     before(grammarAccess.getModifierKindAccess().getORDEREDEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:406:1: ( 'ordered' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:406:3: 'ordered'
                    {
                    match(input,15,FOLLOW_15_in_rule__ModifierKind__Alternatives790); 

                    }

                     after(grammarAccess.getModifierKindAccess().getORDEREDEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:411:6: ( ( 'unique' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:411:6: ( ( 'unique' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:412:1: ( 'unique' )
                    {
                     before(grammarAccess.getModifierKindAccess().getUNIQUEEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:413:1: ( 'unique' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:413:3: 'unique'
                    {
                    match(input,16,FOLLOW_16_in_rule__ModifierKind__Alternatives811); 

                    }

                     after(grammarAccess.getModifierKindAccess().getUNIQUEEnumLiteralDeclaration_3()); 

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
    // $ANTLR end rule__ModifierKind__Alternatives


    // $ANTLR start rule__EffectKind__Alternatives
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:423:1: rule__EffectKind__Alternatives : ( ( ( 'create' ) ) | ( ( 'read' ) ) | ( ( 'update' ) ) | ( ( 'delete' ) ) );
    public final void rule__EffectKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:427:1: ( ( ( 'create' ) ) | ( ( 'read' ) ) | ( ( 'update' ) ) | ( ( 'delete' ) ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt3=1;
                }
                break;
            case 18:
                {
                alt3=2;
                }
                break;
            case 19:
                {
                alt3=3;
                }
                break;
            case 20:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("423:1: rule__EffectKind__Alternatives : ( ( ( 'create' ) ) | ( ( 'read' ) ) | ( ( 'update' ) ) | ( ( 'delete' ) ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:428:1: ( ( 'create' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:428:1: ( ( 'create' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:429:1: ( 'create' )
                    {
                     before(grammarAccess.getEffectKindAccess().getCREATEEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:430:1: ( 'create' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:430:3: 'create'
                    {
                    match(input,17,FOLLOW_17_in_rule__EffectKind__Alternatives847); 

                    }

                     after(grammarAccess.getEffectKindAccess().getCREATEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:435:6: ( ( 'read' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:435:6: ( ( 'read' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:436:1: ( 'read' )
                    {
                     before(grammarAccess.getEffectKindAccess().getREADEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:437:1: ( 'read' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:437:3: 'read'
                    {
                    match(input,18,FOLLOW_18_in_rule__EffectKind__Alternatives868); 

                    }

                     after(grammarAccess.getEffectKindAccess().getREADEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:442:6: ( ( 'update' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:442:6: ( ( 'update' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:443:1: ( 'update' )
                    {
                     before(grammarAccess.getEffectKindAccess().getUPDATEEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:444:1: ( 'update' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:444:3: 'update'
                    {
                    match(input,19,FOLLOW_19_in_rule__EffectKind__Alternatives889); 

                    }

                     after(grammarAccess.getEffectKindAccess().getUPDATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:449:6: ( ( 'delete' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:449:6: ( ( 'delete' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:450:1: ( 'delete' )
                    {
                     before(grammarAccess.getEffectKindAccess().getDELETEEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:451:1: ( 'delete' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:451:3: 'delete'
                    {
                    match(input,20,FOLLOW_20_in_rule__EffectKind__Alternatives910); 

                    }

                     after(grammarAccess.getEffectKindAccess().getDELETEEnumLiteralDeclaration_3()); 

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
    // $ANTLR end rule__EffectKind__Alternatives


    // $ANTLR start rule__VisibilityKind__Alternatives
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:461:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );
    public final void rule__VisibilityKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:465:1: ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt4=1;
                }
                break;
            case 22:
                {
                alt4=2;
                }
                break;
            case 23:
                {
                alt4=3;
                }
                break;
            case 24:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("461:1: rule__VisibilityKind__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) | ( ( '#' ) ) | ( ( '~' ) ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:466:1: ( ( '+' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:466:1: ( ( '+' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:467:1: ( '+' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:468:1: ( '+' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:468:3: '+'
                    {
                    match(input,21,FOLLOW_21_in_rule__VisibilityKind__Alternatives946); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPublicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:473:6: ( ( '-' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:473:6: ( ( '-' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:474:1: ( '-' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:475:1: ( '-' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:475:3: '-'
                    {
                    match(input,22,FOLLOW_22_in_rule__VisibilityKind__Alternatives967); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPrivateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:480:6: ( ( '#' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:480:6: ( ( '#' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:481:1: ( '#' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:482:1: ( '#' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:482:3: '#'
                    {
                    match(input,23,FOLLOW_23_in_rule__VisibilityKind__Alternatives988); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getProtectedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:487:6: ( ( '~' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:487:6: ( ( '~' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:488:1: ( '~' )
                    {
                     before(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:489:1: ( '~' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:489:3: '~'
                    {
                    match(input,24,FOLLOW_24_in_rule__VisibilityKind__Alternatives1009); 

                    }

                     after(grammarAccess.getVisibilityKindAccess().getPackageEnumLiteralDeclaration_3()); 

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
    // $ANTLR end rule__VisibilityKind__Alternatives


    // $ANTLR start rule__Direction__Alternatives
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:499:1: rule__Direction__Alternatives : ( ( ( 'in' ) ) | ( ( 'out' ) ) | ( ( 'inout' ) ) | ( ( 'return' ) ) );
    public final void rule__Direction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:503:1: ( ( ( 'in' ) ) | ( ( 'out' ) ) | ( ( 'inout' ) ) | ( ( 'return' ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt5=1;
                }
                break;
            case 26:
                {
                alt5=2;
                }
                break;
            case 27:
                {
                alt5=3;
                }
                break;
            case 28:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("499:1: rule__Direction__Alternatives : ( ( ( 'in' ) ) | ( ( 'out' ) ) | ( ( 'inout' ) ) | ( ( 'return' ) ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:504:1: ( ( 'in' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:504:1: ( ( 'in' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:505:1: ( 'in' )
                    {
                     before(grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:506:1: ( 'in' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:506:3: 'in'
                    {
                    match(input,25,FOLLOW_25_in_rule__Direction__Alternatives1045); 

                    }

                     after(grammarAccess.getDirectionAccess().getINEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:511:6: ( ( 'out' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:511:6: ( ( 'out' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:512:1: ( 'out' )
                    {
                     before(grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:513:1: ( 'out' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:513:3: 'out'
                    {
                    match(input,26,FOLLOW_26_in_rule__Direction__Alternatives1066); 

                    }

                     after(grammarAccess.getDirectionAccess().getOUTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:518:6: ( ( 'inout' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:518:6: ( ( 'inout' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:519:1: ( 'inout' )
                    {
                     before(grammarAccess.getDirectionAccess().getINOUTEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:520:1: ( 'inout' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:520:3: 'inout'
                    {
                    match(input,27,FOLLOW_27_in_rule__Direction__Alternatives1087); 

                    }

                     after(grammarAccess.getDirectionAccess().getINOUTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:525:6: ( ( 'return' ) )
                    {
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:525:6: ( ( 'return' ) )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:526:1: ( 'return' )
                    {
                     before(grammarAccess.getDirectionAccess().getRETURNEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:527:1: ( 'return' )
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:527:3: 'return'
                    {
                    match(input,28,FOLLOW_28_in_rule__Direction__Alternatives1108); 

                    }

                     after(grammarAccess.getDirectionAccess().getRETURNEnumLiteralDeclaration_3()); 

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
    // $ANTLR end rule__Direction__Alternatives


    // $ANTLR start rule__ParameterRule__Group__0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:539:1: rule__ParameterRule__Group__0 : rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 ;
    public final void rule__ParameterRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:543:1: ( rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:544:2: rule__ParameterRule__Group__0__Impl rule__ParameterRule__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__0__Impl_in_rule__ParameterRule__Group__01141);
            rule__ParameterRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__1_in_rule__ParameterRule__Group__01144);
            rule__ParameterRule__Group__1();
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
    // $ANTLR end rule__ParameterRule__Group__0


    // $ANTLR start rule__ParameterRule__Group__0__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:551:1: rule__ParameterRule__Group__0__Impl : ( ( rule__ParameterRule__VisibilityAssignment_0 ) ) ;
    public final void rule__ParameterRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:555:1: ( ( ( rule__ParameterRule__VisibilityAssignment_0 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:556:1: ( ( rule__ParameterRule__VisibilityAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:556:1: ( ( rule__ParameterRule__VisibilityAssignment_0 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:557:1: ( rule__ParameterRule__VisibilityAssignment_0 )
            {
             before(grammarAccess.getParameterRuleAccess().getVisibilityAssignment_0()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:558:1: ( rule__ParameterRule__VisibilityAssignment_0 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:558:2: rule__ParameterRule__VisibilityAssignment_0
            {
            pushFollow(FOLLOW_rule__ParameterRule__VisibilityAssignment_0_in_rule__ParameterRule__Group__0__Impl1171);
            rule__ParameterRule__VisibilityAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getParameterRuleAccess().getVisibilityAssignment_0()); 

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
    // $ANTLR end rule__ParameterRule__Group__0__Impl


    // $ANTLR start rule__ParameterRule__Group__1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:568:1: rule__ParameterRule__Group__1 : rule__ParameterRule__Group__1__Impl rule__ParameterRule__Group__2 ;
    public final void rule__ParameterRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:572:1: ( rule__ParameterRule__Group__1__Impl rule__ParameterRule__Group__2 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:573:2: rule__ParameterRule__Group__1__Impl rule__ParameterRule__Group__2
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__1__Impl_in_rule__ParameterRule__Group__11201);
            rule__ParameterRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__2_in_rule__ParameterRule__Group__11204);
            rule__ParameterRule__Group__2();
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
    // $ANTLR end rule__ParameterRule__Group__1


    // $ANTLR start rule__ParameterRule__Group__1__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:580:1: rule__ParameterRule__Group__1__Impl : ( ( rule__ParameterRule__DirectionAssignment_1 ) ) ;
    public final void rule__ParameterRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:584:1: ( ( ( rule__ParameterRule__DirectionAssignment_1 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:585:1: ( ( rule__ParameterRule__DirectionAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:585:1: ( ( rule__ParameterRule__DirectionAssignment_1 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:586:1: ( rule__ParameterRule__DirectionAssignment_1 )
            {
             before(grammarAccess.getParameterRuleAccess().getDirectionAssignment_1()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:587:1: ( rule__ParameterRule__DirectionAssignment_1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:587:2: rule__ParameterRule__DirectionAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterRule__DirectionAssignment_1_in_rule__ParameterRule__Group__1__Impl1231);
            rule__ParameterRule__DirectionAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getParameterRuleAccess().getDirectionAssignment_1()); 

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
    // $ANTLR end rule__ParameterRule__Group__1__Impl


    // $ANTLR start rule__ParameterRule__Group__2
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:597:1: rule__ParameterRule__Group__2 : rule__ParameterRule__Group__2__Impl rule__ParameterRule__Group__3 ;
    public final void rule__ParameterRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:601:1: ( rule__ParameterRule__Group__2__Impl rule__ParameterRule__Group__3 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:602:2: rule__ParameterRule__Group__2__Impl rule__ParameterRule__Group__3
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__2__Impl_in_rule__ParameterRule__Group__21261);
            rule__ParameterRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__3_in_rule__ParameterRule__Group__21264);
            rule__ParameterRule__Group__3();
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
    // $ANTLR end rule__ParameterRule__Group__2


    // $ANTLR start rule__ParameterRule__Group__2__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:609:1: rule__ParameterRule__Group__2__Impl : ( ( rule__ParameterRule__NameAssignment_2 ) ) ;
    public final void rule__ParameterRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:613:1: ( ( ( rule__ParameterRule__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:614:1: ( ( rule__ParameterRule__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:614:1: ( ( rule__ParameterRule__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:615:1: ( rule__ParameterRule__NameAssignment_2 )
            {
             before(grammarAccess.getParameterRuleAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:616:1: ( rule__ParameterRule__NameAssignment_2 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:616:2: rule__ParameterRule__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ParameterRule__NameAssignment_2_in_rule__ParameterRule__Group__2__Impl1291);
            rule__ParameterRule__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getParameterRuleAccess().getNameAssignment_2()); 

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
    // $ANTLR end rule__ParameterRule__Group__2__Impl


    // $ANTLR start rule__ParameterRule__Group__3
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:626:1: rule__ParameterRule__Group__3 : rule__ParameterRule__Group__3__Impl rule__ParameterRule__Group__4 ;
    public final void rule__ParameterRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:630:1: ( rule__ParameterRule__Group__3__Impl rule__ParameterRule__Group__4 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:631:2: rule__ParameterRule__Group__3__Impl rule__ParameterRule__Group__4
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__3__Impl_in_rule__ParameterRule__Group__31321);
            rule__ParameterRule__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__4_in_rule__ParameterRule__Group__31324);
            rule__ParameterRule__Group__4();
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
    // $ANTLR end rule__ParameterRule__Group__3


    // $ANTLR start rule__ParameterRule__Group__3__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:638:1: rule__ParameterRule__Group__3__Impl : ( ':' ) ;
    public final void rule__ParameterRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:642:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:643:1: ( ':' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:643:1: ( ':' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:644:1: ':'
            {
             before(grammarAccess.getParameterRuleAccess().getColonKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__ParameterRule__Group__3__Impl1352); 
             after(grammarAccess.getParameterRuleAccess().getColonKeyword_3()); 

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
    // $ANTLR end rule__ParameterRule__Group__3__Impl


    // $ANTLR start rule__ParameterRule__Group__4
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:657:1: rule__ParameterRule__Group__4 : rule__ParameterRule__Group__4__Impl rule__ParameterRule__Group__5 ;
    public final void rule__ParameterRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:661:1: ( rule__ParameterRule__Group__4__Impl rule__ParameterRule__Group__5 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:662:2: rule__ParameterRule__Group__4__Impl rule__ParameterRule__Group__5
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__4__Impl_in_rule__ParameterRule__Group__41383);
            rule__ParameterRule__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__5_in_rule__ParameterRule__Group__41386);
            rule__ParameterRule__Group__5();
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
    // $ANTLR end rule__ParameterRule__Group__4


    // $ANTLR start rule__ParameterRule__Group__4__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:669:1: rule__ParameterRule__Group__4__Impl : ( ( rule__ParameterRule__Alternatives_4 ) ) ;
    public final void rule__ParameterRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:673:1: ( ( ( rule__ParameterRule__Alternatives_4 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:674:1: ( ( rule__ParameterRule__Alternatives_4 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:674:1: ( ( rule__ParameterRule__Alternatives_4 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:675:1: ( rule__ParameterRule__Alternatives_4 )
            {
             before(grammarAccess.getParameterRuleAccess().getAlternatives_4()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:676:1: ( rule__ParameterRule__Alternatives_4 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:676:2: rule__ParameterRule__Alternatives_4
            {
            pushFollow(FOLLOW_rule__ParameterRule__Alternatives_4_in_rule__ParameterRule__Group__4__Impl1413);
            rule__ParameterRule__Alternatives_4();
            _fsp--;


            }

             after(grammarAccess.getParameterRuleAccess().getAlternatives_4()); 

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
    // $ANTLR end rule__ParameterRule__Group__4__Impl


    // $ANTLR start rule__ParameterRule__Group__5
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:686:1: rule__ParameterRule__Group__5 : rule__ParameterRule__Group__5__Impl rule__ParameterRule__Group__6 ;
    public final void rule__ParameterRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:690:1: ( rule__ParameterRule__Group__5__Impl rule__ParameterRule__Group__6 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:691:2: rule__ParameterRule__Group__5__Impl rule__ParameterRule__Group__6
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__5__Impl_in_rule__ParameterRule__Group__51443);
            rule__ParameterRule__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__6_in_rule__ParameterRule__Group__51446);
            rule__ParameterRule__Group__6();
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
    // $ANTLR end rule__ParameterRule__Group__5


    // $ANTLR start rule__ParameterRule__Group__5__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:698:1: rule__ParameterRule__Group__5__Impl : ( ( rule__ParameterRule__MultiplicityAssignment_5 )? ) ;
    public final void rule__ParameterRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:702:1: ( ( ( rule__ParameterRule__MultiplicityAssignment_5 )? ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:703:1: ( ( rule__ParameterRule__MultiplicityAssignment_5 )? )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:703:1: ( ( rule__ParameterRule__MultiplicityAssignment_5 )? )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:704:1: ( rule__ParameterRule__MultiplicityAssignment_5 )?
            {
             before(grammarAccess.getParameterRuleAccess().getMultiplicityAssignment_5()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:705:1: ( rule__ParameterRule__MultiplicityAssignment_5 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==35) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:705:2: rule__ParameterRule__MultiplicityAssignment_5
                    {
                    pushFollow(FOLLOW_rule__ParameterRule__MultiplicityAssignment_5_in_rule__ParameterRule__Group__5__Impl1473);
                    rule__ParameterRule__MultiplicityAssignment_5();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterRuleAccess().getMultiplicityAssignment_5()); 

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
    // $ANTLR end rule__ParameterRule__Group__5__Impl


    // $ANTLR start rule__ParameterRule__Group__6
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:715:1: rule__ParameterRule__Group__6 : rule__ParameterRule__Group__6__Impl rule__ParameterRule__Group__7 ;
    public final void rule__ParameterRule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:719:1: ( rule__ParameterRule__Group__6__Impl rule__ParameterRule__Group__7 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:720:2: rule__ParameterRule__Group__6__Impl rule__ParameterRule__Group__7
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__6__Impl_in_rule__ParameterRule__Group__61504);
            rule__ParameterRule__Group__6__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParameterRule__Group__7_in_rule__ParameterRule__Group__61507);
            rule__ParameterRule__Group__7();
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
    // $ANTLR end rule__ParameterRule__Group__6


    // $ANTLR start rule__ParameterRule__Group__6__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:727:1: rule__ParameterRule__Group__6__Impl : ( ( rule__ParameterRule__ModifiersAssignment_6 )? ) ;
    public final void rule__ParameterRule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:731:1: ( ( ( rule__ParameterRule__ModifiersAssignment_6 )? ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:732:1: ( ( rule__ParameterRule__ModifiersAssignment_6 )? )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:732:1: ( ( rule__ParameterRule__ModifiersAssignment_6 )? )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:733:1: ( rule__ParameterRule__ModifiersAssignment_6 )?
            {
             before(grammarAccess.getParameterRuleAccess().getModifiersAssignment_6()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:734:1: ( rule__ParameterRule__ModifiersAssignment_6 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==30) ) {
                int LA7_1 = input.LA(2);

                if ( ((LA7_1>=13 && LA7_1<=16)) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:734:2: rule__ParameterRule__ModifiersAssignment_6
                    {
                    pushFollow(FOLLOW_rule__ParameterRule__ModifiersAssignment_6_in_rule__ParameterRule__Group__6__Impl1534);
                    rule__ParameterRule__ModifiersAssignment_6();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterRuleAccess().getModifiersAssignment_6()); 

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
    // $ANTLR end rule__ParameterRule__Group__6__Impl


    // $ANTLR start rule__ParameterRule__Group__7
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:744:1: rule__ParameterRule__Group__7 : rule__ParameterRule__Group__7__Impl ;
    public final void rule__ParameterRule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:748:1: ( rule__ParameterRule__Group__7__Impl )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:749:2: rule__ParameterRule__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__ParameterRule__Group__7__Impl_in_rule__ParameterRule__Group__71565);
            rule__ParameterRule__Group__7__Impl();
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
    // $ANTLR end rule__ParameterRule__Group__7


    // $ANTLR start rule__ParameterRule__Group__7__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:755:1: rule__ParameterRule__Group__7__Impl : ( ( rule__ParameterRule__EffectAssignment_7 ) ) ;
    public final void rule__ParameterRule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:759:1: ( ( ( rule__ParameterRule__EffectAssignment_7 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:760:1: ( ( rule__ParameterRule__EffectAssignment_7 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:760:1: ( ( rule__ParameterRule__EffectAssignment_7 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:761:1: ( rule__ParameterRule__EffectAssignment_7 )
            {
             before(grammarAccess.getParameterRuleAccess().getEffectAssignment_7()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:762:1: ( rule__ParameterRule__EffectAssignment_7 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:762:2: rule__ParameterRule__EffectAssignment_7
            {
            pushFollow(FOLLOW_rule__ParameterRule__EffectAssignment_7_in_rule__ParameterRule__Group__7__Impl1592);
            rule__ParameterRule__EffectAssignment_7();
            _fsp--;


            }

             after(grammarAccess.getParameterRuleAccess().getEffectAssignment_7()); 

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
    // $ANTLR end rule__ParameterRule__Group__7__Impl


    // $ANTLR start rule__ModifiersRule__Group__0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:788:1: rule__ModifiersRule__Group__0 : rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 ;
    public final void rule__ModifiersRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:792:1: ( rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:793:2: rule__ModifiersRule__Group__0__Impl rule__ModifiersRule__Group__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__01638);
            rule__ModifiersRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__01641);
            rule__ModifiersRule__Group__1();
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
    // $ANTLR end rule__ModifiersRule__Group__0


    // $ANTLR start rule__ModifiersRule__Group__0__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:800:1: rule__ModifiersRule__Group__0__Impl : ( '{' ) ;
    public final void rule__ModifiersRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:804:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:805:1: ( '{' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:805:1: ( '{' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:806:1: '{'
            {
             before(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__ModifiersRule__Group__0__Impl1669); 
             after(grammarAccess.getModifiersRuleAccess().getLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end rule__ModifiersRule__Group__0__Impl


    // $ANTLR start rule__ModifiersRule__Group__1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:819:1: rule__ModifiersRule__Group__1 : rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 ;
    public final void rule__ModifiersRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:823:1: ( rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:824:2: rule__ModifiersRule__Group__1__Impl rule__ModifiersRule__Group__2
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__11700);
            rule__ModifiersRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__11703);
            rule__ModifiersRule__Group__2();
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
    // $ANTLR end rule__ModifiersRule__Group__1


    // $ANTLR start rule__ModifiersRule__Group__1__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:831:1: rule__ModifiersRule__Group__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) ;
    public final void rule__ModifiersRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:835:1: ( ( ( rule__ModifiersRule__ValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:836:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:836:1: ( ( rule__ModifiersRule__ValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:837:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:838:1: ( rule__ModifiersRule__ValuesAssignment_1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:838:2: rule__ModifiersRule__ValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl1730);
            rule__ModifiersRule__ValuesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getModifiersRuleAccess().getValuesAssignment_1()); 

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
    // $ANTLR end rule__ModifiersRule__Group__1__Impl


    // $ANTLR start rule__ModifiersRule__Group__2
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:848:1: rule__ModifiersRule__Group__2 : rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 ;
    public final void rule__ModifiersRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:852:1: ( rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:853:2: rule__ModifiersRule__Group__2__Impl rule__ModifiersRule__Group__3
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__21760);
            rule__ModifiersRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__21763);
            rule__ModifiersRule__Group__3();
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
    // $ANTLR end rule__ModifiersRule__Group__2


    // $ANTLR start rule__ModifiersRule__Group__2__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:860:1: rule__ModifiersRule__Group__2__Impl : ( ( rule__ModifiersRule__Group_2__0 )* ) ;
    public final void rule__ModifiersRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:864:1: ( ( ( rule__ModifiersRule__Group_2__0 )* ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:865:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:865:1: ( ( rule__ModifiersRule__Group_2__0 )* )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:866:1: ( rule__ModifiersRule__Group_2__0 )*
            {
             before(grammarAccess.getModifiersRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:867:1: ( rule__ModifiersRule__Group_2__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==32) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:867:2: rule__ModifiersRule__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl1790);
            	    rule__ModifiersRule__Group_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getModifiersRuleAccess().getGroup_2()); 

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
    // $ANTLR end rule__ModifiersRule__Group__2__Impl


    // $ANTLR start rule__ModifiersRule__Group__3
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:877:1: rule__ModifiersRule__Group__3 : rule__ModifiersRule__Group__3__Impl ;
    public final void rule__ModifiersRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:881:1: ( rule__ModifiersRule__Group__3__Impl )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:882:2: rule__ModifiersRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__31821);
            rule__ModifiersRule__Group__3__Impl();
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
    // $ANTLR end rule__ModifiersRule__Group__3


    // $ANTLR start rule__ModifiersRule__Group__3__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:888:1: rule__ModifiersRule__Group__3__Impl : ( '}' ) ;
    public final void rule__ModifiersRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:892:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:893:1: ( '}' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:893:1: ( '}' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:894:1: '}'
            {
             before(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__ModifiersRule__Group__3__Impl1849); 
             after(grammarAccess.getModifiersRuleAccess().getRightCurlyBracketKeyword_3()); 

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
    // $ANTLR end rule__ModifiersRule__Group__3__Impl


    // $ANTLR start rule__ModifiersRule__Group_2__0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:915:1: rule__ModifiersRule__Group_2__0 : rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 ;
    public final void rule__ModifiersRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:919:1: ( rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:920:2: rule__ModifiersRule__Group_2__0__Impl rule__ModifiersRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__01888);
            rule__ModifiersRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__01891);
            rule__ModifiersRule__Group_2__1();
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
    // $ANTLR end rule__ModifiersRule__Group_2__0


    // $ANTLR start rule__ModifiersRule__Group_2__0__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:927:1: rule__ModifiersRule__Group_2__0__Impl : ( ',' ) ;
    public final void rule__ModifiersRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:931:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:932:1: ( ',' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:932:1: ( ',' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:933:1: ','
            {
             before(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 
            match(input,32,FOLLOW_32_in_rule__ModifiersRule__Group_2__0__Impl1919); 
             after(grammarAccess.getModifiersRuleAccess().getCommaKeyword_2_0()); 

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
    // $ANTLR end rule__ModifiersRule__Group_2__0__Impl


    // $ANTLR start rule__ModifiersRule__Group_2__1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:946:1: rule__ModifiersRule__Group_2__1 : rule__ModifiersRule__Group_2__1__Impl ;
    public final void rule__ModifiersRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:950:1: ( rule__ModifiersRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:951:2: rule__ModifiersRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__11950);
            rule__ModifiersRule__Group_2__1__Impl();
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
    // $ANTLR end rule__ModifiersRule__Group_2__1


    // $ANTLR start rule__ModifiersRule__Group_2__1__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:957:1: rule__ModifiersRule__Group_2__1__Impl : ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) ;
    public final void rule__ModifiersRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:961:1: ( ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:962:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:962:1: ( ( rule__ModifiersRule__ValuesAssignment_2_1 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:963:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:964:1: ( rule__ModifiersRule__ValuesAssignment_2_1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:964:2: rule__ModifiersRule__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl1977);
            rule__ModifiersRule__ValuesAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getModifiersRuleAccess().getValuesAssignment_2_1()); 

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
    // $ANTLR end rule__ModifiersRule__Group_2__1__Impl


    // $ANTLR start rule__EffectRule__Group__0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:978:1: rule__EffectRule__Group__0 : rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1 ;
    public final void rule__EffectRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:982:1: ( rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:983:2: rule__EffectRule__Group__0__Impl rule__EffectRule__Group__1
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__0__Impl_in_rule__EffectRule__Group__02011);
            rule__EffectRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EffectRule__Group__1_in_rule__EffectRule__Group__02014);
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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:990:1: rule__EffectRule__Group__0__Impl : ( '{' ) ;
    public final void rule__EffectRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:994:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:995:1: ( '{' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:995:1: ( '{' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:996:1: '{'
            {
             before(grammarAccess.getEffectRuleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EffectRule__Group__0__Impl2042); 
             after(grammarAccess.getEffectRuleAccess().getLeftCurlyBracketKeyword_0()); 

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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1009:1: rule__EffectRule__Group__1 : rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2 ;
    public final void rule__EffectRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1013:1: ( rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1014:2: rule__EffectRule__Group__1__Impl rule__EffectRule__Group__2
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__1__Impl_in_rule__EffectRule__Group__12073);
            rule__EffectRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EffectRule__Group__2_in_rule__EffectRule__Group__12076);
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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1021:1: rule__EffectRule__Group__1__Impl : ( 'effect: ' ) ;
    public final void rule__EffectRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1025:1: ( ( 'effect: ' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1026:1: ( 'effect: ' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1026:1: ( 'effect: ' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1027:1: 'effect: '
            {
             before(grammarAccess.getEffectRuleAccess().getEffectKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__EffectRule__Group__1__Impl2104); 
             after(grammarAccess.getEffectRuleAccess().getEffectKeyword_1()); 

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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1040:1: rule__EffectRule__Group__2 : rule__EffectRule__Group__2__Impl rule__EffectRule__Group__3 ;
    public final void rule__EffectRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1044:1: ( rule__EffectRule__Group__2__Impl rule__EffectRule__Group__3 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1045:2: rule__EffectRule__Group__2__Impl rule__EffectRule__Group__3
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__2__Impl_in_rule__EffectRule__Group__22135);
            rule__EffectRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EffectRule__Group__3_in_rule__EffectRule__Group__22138);
            rule__EffectRule__Group__3();
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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1052:1: rule__EffectRule__Group__2__Impl : ( ( rule__EffectRule__EffectKindAssignment_2 ) ) ;
    public final void rule__EffectRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1056:1: ( ( ( rule__EffectRule__EffectKindAssignment_2 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1057:1: ( ( rule__EffectRule__EffectKindAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1057:1: ( ( rule__EffectRule__EffectKindAssignment_2 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1058:1: ( rule__EffectRule__EffectKindAssignment_2 )
            {
             before(grammarAccess.getEffectRuleAccess().getEffectKindAssignment_2()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1059:1: ( rule__EffectRule__EffectKindAssignment_2 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1059:2: rule__EffectRule__EffectKindAssignment_2
            {
            pushFollow(FOLLOW_rule__EffectRule__EffectKindAssignment_2_in_rule__EffectRule__Group__2__Impl2165);
            rule__EffectRule__EffectKindAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getEffectRuleAccess().getEffectKindAssignment_2()); 

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


    // $ANTLR start rule__EffectRule__Group__3
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1069:1: rule__EffectRule__Group__3 : rule__EffectRule__Group__3__Impl ;
    public final void rule__EffectRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1073:1: ( rule__EffectRule__Group__3__Impl )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1074:2: rule__EffectRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__EffectRule__Group__3__Impl_in_rule__EffectRule__Group__32195);
            rule__EffectRule__Group__3__Impl();
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
    // $ANTLR end rule__EffectRule__Group__3


    // $ANTLR start rule__EffectRule__Group__3__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1080:1: rule__EffectRule__Group__3__Impl : ( '}' ) ;
    public final void rule__EffectRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1084:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1085:1: ( '}' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1085:1: ( '}' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1086:1: '}'
            {
             before(grammarAccess.getEffectRuleAccess().getRightCurlyBracketKeyword_3()); 
            match(input,31,FOLLOW_31_in_rule__EffectRule__Group__3__Impl2223); 
             after(grammarAccess.getEffectRuleAccess().getRightCurlyBracketKeyword_3()); 

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
    // $ANTLR end rule__EffectRule__Group__3__Impl


    // $ANTLR start rule__QualifiedName__Group__0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1107:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1111:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1112:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02262);
            rule__QualifiedName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02265);
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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1119:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1123:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1124:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1124:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1125:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1126:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1126:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl2292);
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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1136:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1140:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1141:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12322);
            rule__QualifiedName__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__12325);
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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1148:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1152:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1153:1: ( '::' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1153:1: ( '::' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1154:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__QualifiedName__Group__1__Impl2353); 
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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1167:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1171:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1172:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__22384);
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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1178:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1182:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1183:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1183:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1184:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1185:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==34) ) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1185:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2411);
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


    // $ANTLR start rule__TypeRule__Group__0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1201:1: rule__TypeRule__Group__0 : rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 ;
    public final void rule__TypeRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1205:1: ( rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1206:2: rule__TypeRule__Group__0__Impl rule__TypeRule__Group__1
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__02448);
            rule__TypeRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__02451);
            rule__TypeRule__Group__1();
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
    // $ANTLR end rule__TypeRule__Group__0


    // $ANTLR start rule__TypeRule__Group__0__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1213:1: rule__TypeRule__Group__0__Impl : ( ( rule__TypeRule__PathAssignment_0 )? ) ;
    public final void rule__TypeRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1217:1: ( ( ( rule__TypeRule__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1218:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1218:1: ( ( rule__TypeRule__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1219:1: ( rule__TypeRule__PathAssignment_0 )?
            {
             before(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1220:1: ( rule__TypeRule__PathAssignment_0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==34) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1220:2: rule__TypeRule__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl2478);
                    rule__TypeRule__PathAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRuleAccess().getPathAssignment_0()); 

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
    // $ANTLR end rule__TypeRule__Group__0__Impl


    // $ANTLR start rule__TypeRule__Group__1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1230:1: rule__TypeRule__Group__1 : rule__TypeRule__Group__1__Impl ;
    public final void rule__TypeRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1234:1: ( rule__TypeRule__Group__1__Impl )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1235:2: rule__TypeRule__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__12509);
            rule__TypeRule__Group__1__Impl();
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
    // $ANTLR end rule__TypeRule__Group__1


    // $ANTLR start rule__TypeRule__Group__1__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1241:1: rule__TypeRule__Group__1__Impl : ( ( rule__TypeRule__TypeAssignment_1 ) ) ;
    public final void rule__TypeRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1245:1: ( ( ( rule__TypeRule__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1246:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1246:1: ( ( rule__TypeRule__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1247:1: ( rule__TypeRule__TypeAssignment_1 )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1248:1: ( rule__TypeRule__TypeAssignment_1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1248:2: rule__TypeRule__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl2536);
            rule__TypeRule__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTypeRuleAccess().getTypeAssignment_1()); 

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
    // $ANTLR end rule__TypeRule__Group__1__Impl


    // $ANTLR start rule__MultiplicityRule__Group__0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1262:1: rule__MultiplicityRule__Group__0 : rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 ;
    public final void rule__MultiplicityRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1266:1: ( rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1267:2: rule__MultiplicityRule__Group__0__Impl rule__MultiplicityRule__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02570);
            rule__MultiplicityRule__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02573);
            rule__MultiplicityRule__Group__1();
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
    // $ANTLR end rule__MultiplicityRule__Group__0


    // $ANTLR start rule__MultiplicityRule__Group__0__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1274:1: rule__MultiplicityRule__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1278:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1279:1: ( '[' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1279:1: ( '[' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1280:1: '['
            {
             before(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__MultiplicityRule__Group__0__Impl2601); 
             after(grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0()); 

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
    // $ANTLR end rule__MultiplicityRule__Group__0__Impl


    // $ANTLR start rule__MultiplicityRule__Group__1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1293:1: rule__MultiplicityRule__Group__1 : rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 ;
    public final void rule__MultiplicityRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1297:1: ( rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1298:2: rule__MultiplicityRule__Group__1__Impl rule__MultiplicityRule__Group__2
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12632);
            rule__MultiplicityRule__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12635);
            rule__MultiplicityRule__Group__2();
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
    // $ANTLR end rule__MultiplicityRule__Group__1


    // $ANTLR start rule__MultiplicityRule__Group__1__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1305:1: rule__MultiplicityRule__Group__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) ;
    public final void rule__MultiplicityRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1309:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1310:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1310:1: ( ( rule__MultiplicityRule__BoundsAssignment_1 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1311:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1312:1: ( rule__MultiplicityRule__BoundsAssignment_1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1312:2: rule__MultiplicityRule__BoundsAssignment_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2662);
            rule__MultiplicityRule__BoundsAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1()); 

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
    // $ANTLR end rule__MultiplicityRule__Group__1__Impl


    // $ANTLR start rule__MultiplicityRule__Group__2
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1322:1: rule__MultiplicityRule__Group__2 : rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 ;
    public final void rule__MultiplicityRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1326:1: ( rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1327:2: rule__MultiplicityRule__Group__2__Impl rule__MultiplicityRule__Group__3
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22692);
            rule__MultiplicityRule__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22695);
            rule__MultiplicityRule__Group__3();
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
    // $ANTLR end rule__MultiplicityRule__Group__2


    // $ANTLR start rule__MultiplicityRule__Group__2__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1334:1: rule__MultiplicityRule__Group__2__Impl : ( ( rule__MultiplicityRule__Group_2__0 )? ) ;
    public final void rule__MultiplicityRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1338:1: ( ( ( rule__MultiplicityRule__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1339:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1339:1: ( ( rule__MultiplicityRule__Group_2__0 )? )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1340:1: ( rule__MultiplicityRule__Group_2__0 )?
            {
             before(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1341:1: ( rule__MultiplicityRule__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==37) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1341:2: rule__MultiplicityRule__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2722);
                    rule__MultiplicityRule__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiplicityRuleAccess().getGroup_2()); 

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
    // $ANTLR end rule__MultiplicityRule__Group__2__Impl


    // $ANTLR start rule__MultiplicityRule__Group__3
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1351:1: rule__MultiplicityRule__Group__3 : rule__MultiplicityRule__Group__3__Impl ;
    public final void rule__MultiplicityRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1355:1: ( rule__MultiplicityRule__Group__3__Impl )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1356:2: rule__MultiplicityRule__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32753);
            rule__MultiplicityRule__Group__3__Impl();
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
    // $ANTLR end rule__MultiplicityRule__Group__3


    // $ANTLR start rule__MultiplicityRule__Group__3__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1362:1: rule__MultiplicityRule__Group__3__Impl : ( ']' ) ;
    public final void rule__MultiplicityRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1366:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1367:1: ( ']' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1367:1: ( ']' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1368:1: ']'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 
            match(input,36,FOLLOW_36_in_rule__MultiplicityRule__Group__3__Impl2781); 
             after(grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3()); 

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
    // $ANTLR end rule__MultiplicityRule__Group__3__Impl


    // $ANTLR start rule__MultiplicityRule__Group_2__0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1389:1: rule__MultiplicityRule__Group_2__0 : rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 ;
    public final void rule__MultiplicityRule__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1393:1: ( rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1394:2: rule__MultiplicityRule__Group_2__0__Impl rule__MultiplicityRule__Group_2__1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02820);
            rule__MultiplicityRule__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02823);
            rule__MultiplicityRule__Group_2__1();
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
    // $ANTLR end rule__MultiplicityRule__Group_2__0


    // $ANTLR start rule__MultiplicityRule__Group_2__0__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1401:1: rule__MultiplicityRule__Group_2__0__Impl : ( '..' ) ;
    public final void rule__MultiplicityRule__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1405:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1406:1: ( '..' )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1406:1: ( '..' )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1407:1: '..'
            {
             before(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 
            match(input,37,FOLLOW_37_in_rule__MultiplicityRule__Group_2__0__Impl2851); 
             after(grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0()); 

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
    // $ANTLR end rule__MultiplicityRule__Group_2__0__Impl


    // $ANTLR start rule__MultiplicityRule__Group_2__1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1420:1: rule__MultiplicityRule__Group_2__1 : rule__MultiplicityRule__Group_2__1__Impl ;
    public final void rule__MultiplicityRule__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1424:1: ( rule__MultiplicityRule__Group_2__1__Impl )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1425:2: rule__MultiplicityRule__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12882);
            rule__MultiplicityRule__Group_2__1__Impl();
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
    // $ANTLR end rule__MultiplicityRule__Group_2__1


    // $ANTLR start rule__MultiplicityRule__Group_2__1__Impl
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1431:1: rule__MultiplicityRule__Group_2__1__Impl : ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) ;
    public final void rule__MultiplicityRule__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1435:1: ( ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1436:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1436:1: ( ( rule__MultiplicityRule__BoundsAssignment_2_1 ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1437:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1438:1: ( rule__MultiplicityRule__BoundsAssignment_2_1 )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1438:2: rule__MultiplicityRule__BoundsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2909);
            rule__MultiplicityRule__BoundsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1()); 

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
    // $ANTLR end rule__MultiplicityRule__Group_2__1__Impl


    // $ANTLR start rule__ParameterRule__VisibilityAssignment_0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1453:1: rule__ParameterRule__VisibilityAssignment_0 : ( ruleVisibilityKind ) ;
    public final void rule__ParameterRule__VisibilityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1457:1: ( ( ruleVisibilityKind ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1458:1: ( ruleVisibilityKind )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1458:1: ( ruleVisibilityKind )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1459:1: ruleVisibilityKind
            {
             before(grammarAccess.getParameterRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVisibilityKind_in_rule__ParameterRule__VisibilityAssignment_02948);
            ruleVisibilityKind();
            _fsp--;

             after(grammarAccess.getParameterRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0()); 

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
    // $ANTLR end rule__ParameterRule__VisibilityAssignment_0


    // $ANTLR start rule__ParameterRule__DirectionAssignment_1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1468:1: rule__ParameterRule__DirectionAssignment_1 : ( ruleDirection ) ;
    public final void rule__ParameterRule__DirectionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1472:1: ( ( ruleDirection ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1473:1: ( ruleDirection )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1473:1: ( ruleDirection )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1474:1: ruleDirection
            {
             before(grammarAccess.getParameterRuleAccess().getDirectionDirectionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDirection_in_rule__ParameterRule__DirectionAssignment_12979);
            ruleDirection();
            _fsp--;

             after(grammarAccess.getParameterRuleAccess().getDirectionDirectionEnumRuleCall_1_0()); 

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
    // $ANTLR end rule__ParameterRule__DirectionAssignment_1


    // $ANTLR start rule__ParameterRule__NameAssignment_2
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1483:1: rule__ParameterRule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ParameterRule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1487:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1488:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1488:1: ( RULE_ID )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1489:1: RULE_ID
            {
             before(grammarAccess.getParameterRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParameterRule__NameAssignment_23010); 
             after(grammarAccess.getParameterRuleAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end rule__ParameterRule__NameAssignment_2


    // $ANTLR start rule__ParameterRule__TypeAssignment_4_0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1498:1: rule__ParameterRule__TypeAssignment_4_0 : ( ruleTypeRule ) ;
    public final void rule__ParameterRule__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1502:1: ( ( ruleTypeRule ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1503:1: ( ruleTypeRule )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1503:1: ( ruleTypeRule )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1504:1: ruleTypeRule
            {
             before(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_ruleTypeRule_in_rule__ParameterRule__TypeAssignment_4_03041);
            ruleTypeRule();
            _fsp--;

             after(grammarAccess.getParameterRuleAccess().getTypeTypeRuleParserRuleCall_4_0_0()); 

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
    // $ANTLR end rule__ParameterRule__TypeAssignment_4_0


    // $ANTLR start rule__ParameterRule__MultiplicityAssignment_5
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1513:1: rule__ParameterRule__MultiplicityAssignment_5 : ( ruleMultiplicityRule ) ;
    public final void rule__ParameterRule__MultiplicityAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1517:1: ( ( ruleMultiplicityRule ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1518:1: ( ruleMultiplicityRule )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1518:1: ( ruleMultiplicityRule )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1519:1: ruleMultiplicityRule
            {
             before(grammarAccess.getParameterRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMultiplicityRule_in_rule__ParameterRule__MultiplicityAssignment_53072);
            ruleMultiplicityRule();
            _fsp--;

             after(grammarAccess.getParameterRuleAccess().getMultiplicityMultiplicityRuleParserRuleCall_5_0()); 

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
    // $ANTLR end rule__ParameterRule__MultiplicityAssignment_5


    // $ANTLR start rule__ParameterRule__ModifiersAssignment_6
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1528:1: rule__ParameterRule__ModifiersAssignment_6 : ( ruleModifiersRule ) ;
    public final void rule__ParameterRule__ModifiersAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1532:1: ( ( ruleModifiersRule ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1533:1: ( ruleModifiersRule )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1533:1: ( ruleModifiersRule )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1534:1: ruleModifiersRule
            {
             before(grammarAccess.getParameterRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleModifiersRule_in_rule__ParameterRule__ModifiersAssignment_63103);
            ruleModifiersRule();
            _fsp--;

             after(grammarAccess.getParameterRuleAccess().getModifiersModifiersRuleParserRuleCall_6_0()); 

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
    // $ANTLR end rule__ParameterRule__ModifiersAssignment_6


    // $ANTLR start rule__ParameterRule__EffectAssignment_7
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1543:1: rule__ParameterRule__EffectAssignment_7 : ( ruleEffectRule ) ;
    public final void rule__ParameterRule__EffectAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1547:1: ( ( ruleEffectRule ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1548:1: ( ruleEffectRule )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1548:1: ( ruleEffectRule )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1549:1: ruleEffectRule
            {
             before(grammarAccess.getParameterRuleAccess().getEffectEffectRuleParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleEffectRule_in_rule__ParameterRule__EffectAssignment_73134);
            ruleEffectRule();
            _fsp--;

             after(grammarAccess.getParameterRuleAccess().getEffectEffectRuleParserRuleCall_7_0()); 

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
    // $ANTLR end rule__ParameterRule__EffectAssignment_7


    // $ANTLR start rule__ModifiersRule__ValuesAssignment_1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1558:1: rule__ModifiersRule__ValuesAssignment_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1562:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1563:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1563:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1564:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13165);
            ruleModifierSpecification();
            _fsp--;

             after(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_1_0()); 

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
    // $ANTLR end rule__ModifiersRule__ValuesAssignment_1


    // $ANTLR start rule__ModifiersRule__ValuesAssignment_2_1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1573:1: rule__ModifiersRule__ValuesAssignment_2_1 : ( ruleModifierSpecification ) ;
    public final void rule__ModifiersRule__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1577:1: ( ( ruleModifierSpecification ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1578:1: ( ruleModifierSpecification )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1578:1: ( ruleModifierSpecification )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1579:1: ruleModifierSpecification
            {
             before(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13196);
            ruleModifierSpecification();
            _fsp--;

             after(grammarAccess.getModifiersRuleAccess().getValuesModifierSpecificationParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__ModifiersRule__ValuesAssignment_2_1


    // $ANTLR start rule__ModifierSpecification__ValueAssignment
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1588:1: rule__ModifierSpecification__ValueAssignment : ( ruleModifierKind ) ;
    public final void rule__ModifierSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1592:1: ( ( ruleModifierKind ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1593:1: ( ruleModifierKind )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1593:1: ( ruleModifierKind )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1594:1: ruleModifierKind
            {
             before(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0()); 
            pushFollow(FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment3227);
            ruleModifierKind();
            _fsp--;

             after(grammarAccess.getModifierSpecificationAccess().getValueModifierKindEnumRuleCall_0()); 

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
    // $ANTLR end rule__ModifierSpecification__ValueAssignment


    // $ANTLR start rule__EffectRule__EffectKindAssignment_2
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1603:1: rule__EffectRule__EffectKindAssignment_2 : ( ruleEffectKind ) ;
    public final void rule__EffectRule__EffectKindAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1607:1: ( ( ruleEffectKind ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1608:1: ( ruleEffectKind )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1608:1: ( ruleEffectKind )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1609:1: ruleEffectKind
            {
             before(grammarAccess.getEffectRuleAccess().getEffectKindEffectKindEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEffectKind_in_rule__EffectRule__EffectKindAssignment_23258);
            ruleEffectKind();
            _fsp--;

             after(grammarAccess.getEffectRuleAccess().getEffectKindEffectKindEnumRuleCall_2_0()); 

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
    // $ANTLR end rule__EffectRule__EffectKindAssignment_2


    // $ANTLR start rule__QualifiedName__PathAssignment_0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1618:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1622:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1623:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1623:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1624:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1625:1: ( RULE_ID )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1626:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03293); 
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
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1637:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1641:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1642:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1642:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1643:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23328);
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


    // $ANTLR start rule__TypeRule__PathAssignment_0
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1652:1: rule__TypeRule__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__TypeRule__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1656:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1657:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1657:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1658:1: ruleQualifiedName
            {
             before(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03359);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0()); 

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
    // $ANTLR end rule__TypeRule__PathAssignment_0


    // $ANTLR start rule__TypeRule__TypeAssignment_1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1667:1: rule__TypeRule__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRule__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1671:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1672:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1672:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1673:1: ( RULE_ID )
            {
             before(grammarAccess.getTypeRuleAccess().getTypeTypeCrossReference_1_0()); 
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1674:1: ( RULE_ID )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1675:1: RULE_ID
            {
             before(grammarAccess.getTypeRuleAccess().getTypeTypeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13394); 
             after(grammarAccess.getTypeRuleAccess().getTypeTypeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTypeRuleAccess().getTypeTypeCrossReference_1_0()); 

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
    // $ANTLR end rule__TypeRule__TypeAssignment_1


    // $ANTLR start rule__MultiplicityRule__BoundsAssignment_1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1686:1: rule__MultiplicityRule__BoundsAssignment_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1690:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1691:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1691:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1692:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13429);
            ruleBoundSpecification();
            _fsp--;

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0()); 

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
    // $ANTLR end rule__MultiplicityRule__BoundsAssignment_1


    // $ANTLR start rule__MultiplicityRule__BoundsAssignment_2_1
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1701:1: rule__MultiplicityRule__BoundsAssignment_2_1 : ( ruleBoundSpecification ) ;
    public final void rule__MultiplicityRule__BoundsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1705:1: ( ( ruleBoundSpecification ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1706:1: ( ruleBoundSpecification )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1706:1: ( ruleBoundSpecification )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1707:1: ruleBoundSpecification
            {
             before(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13460);
            ruleBoundSpecification();
            _fsp--;

             after(grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__MultiplicityRule__BoundsAssignment_2_1


    // $ANTLR start rule__BoundSpecification__ValueAssignment
    // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1716:1: rule__BoundSpecification__ValueAssignment : ( RULE_UNLIMITEDLITERAL ) ;
    public final void rule__BoundSpecification__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1720:1: ( ( RULE_UNLIMITEDLITERAL ) )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1721:1: ( RULE_UNLIMITEDLITERAL )
            {
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1721:1: ( RULE_UNLIMITEDLITERAL )
            // ../org.eclipse.papyrus.parameter.editor.xtext.ui/src-gen/org/eclipse/papyrus/parameter/editor/xtext/ui/contentassist/antlr/internal/InternalUmlParameter.g:1722:1: RULE_UNLIMITEDLITERAL
            {
             before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0()); 
            match(input,RULE_UNLIMITEDLITERAL,FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment3491); 
             after(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0()); 

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
    // $ANTLR end rule__BoundSpecification__ValueAssignment


 

    public static final BitSet FOLLOW_ruleParameterRule_in_entryRuleParameterRule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterRule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__0_in_ruleParameterRule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_entryRuleModifiersRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifiersRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0_in_ruleModifiersRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_entryRuleModifierSpecification181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModifierSpecification188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierSpecification__ValueAssignment_in_ruleModifierSpecification214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_entryRuleEffectRule241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEffectRule248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__0_in_ruleEffectRule274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_entryRuleTypeRule361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRule368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0_in_ruleTypeRule394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_entryRuleMultiplicityRule421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityRule428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0_in_ruleMultiplicityRule454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_entryRuleBoundSpecification481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoundSpecification488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BoundSpecification__ValueAssignment_in_ruleBoundSpecification514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifierKind__Alternatives_in_ruleModifierKind551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectKind__Alternatives_in_ruleEffectKind587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibilityKind__Alternatives_in_ruleVisibilityKind623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Direction__Alternatives_in_ruleDirection659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__TypeAssignment_4_0_in_rule__ParameterRule__Alternatives_4694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ParameterRule__Alternatives_4713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ModifierKind__Alternatives748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ModifierKind__Alternatives769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ModifierKind__Alternatives790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ModifierKind__Alternatives811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__EffectKind__Alternatives847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__EffectKind__Alternatives868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__EffectKind__Alternatives889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__EffectKind__Alternatives910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__VisibilityKind__Alternatives946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__VisibilityKind__Alternatives967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__VisibilityKind__Alternatives988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__VisibilityKind__Alternatives1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Direction__Alternatives1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Direction__Alternatives1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Direction__Alternatives1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Direction__Alternatives1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__0__Impl_in_rule__ParameterRule__Group__01141 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__1_in_rule__ParameterRule__Group__01144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__VisibilityAssignment_0_in_rule__ParameterRule__Group__0__Impl1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__1__Impl_in_rule__ParameterRule__Group__11201 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__2_in_rule__ParameterRule__Group__11204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__DirectionAssignment_1_in_rule__ParameterRule__Group__1__Impl1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__2__Impl_in_rule__ParameterRule__Group__21261 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__3_in_rule__ParameterRule__Group__21264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__NameAssignment_2_in_rule__ParameterRule__Group__2__Impl1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__3__Impl_in_rule__ParameterRule__Group__31321 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__4_in_rule__ParameterRule__Group__31324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ParameterRule__Group__3__Impl1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__4__Impl_in_rule__ParameterRule__Group__41383 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__5_in_rule__ParameterRule__Group__41386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Alternatives_4_in_rule__ParameterRule__Group__4__Impl1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__5__Impl_in_rule__ParameterRule__Group__51443 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__6_in_rule__ParameterRule__Group__51446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__MultiplicityAssignment_5_in_rule__ParameterRule__Group__5__Impl1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__6__Impl_in_rule__ParameterRule__Group__61504 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__7_in_rule__ParameterRule__Group__61507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__ModifiersAssignment_6_in_rule__ParameterRule__Group__6__Impl1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__Group__7__Impl_in_rule__ParameterRule__Group__71565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterRule__EffectAssignment_7_in_rule__ParameterRule__Group__7__Impl1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__0__Impl_in_rule__ModifiersRule__Group__01638 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1_in_rule__ModifiersRule__Group__01641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ModifiersRule__Group__0__Impl1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__1__Impl_in_rule__ModifiersRule__Group__11700 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2_in_rule__ModifiersRule__Group__11703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_1_in_rule__ModifiersRule__Group__1__Impl1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__2__Impl_in_rule__ModifiersRule__Group__21760 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3_in_rule__ModifiersRule__Group__21763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0_in_rule__ModifiersRule__Group__2__Impl1790 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group__3__Impl_in_rule__ModifiersRule__Group__31821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ModifiersRule__Group__3__Impl1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__0__Impl_in_rule__ModifiersRule__Group_2__01888 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1_in_rule__ModifiersRule__Group_2__01891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ModifiersRule__Group_2__0__Impl1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__Group_2__1__Impl_in_rule__ModifiersRule__Group_2__11950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModifiersRule__ValuesAssignment_2_1_in_rule__ModifiersRule__Group_2__1__Impl1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__0__Impl_in_rule__EffectRule__Group__02011 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__1_in_rule__EffectRule__Group__02014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EffectRule__Group__0__Impl2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__1__Impl_in_rule__EffectRule__Group__12073 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__2_in_rule__EffectRule__Group__12076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__EffectRule__Group__1__Impl2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__2__Impl_in_rule__EffectRule__Group__22135 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__3_in_rule__EffectRule__Group__22138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__EffectKindAssignment_2_in_rule__EffectRule__Group__2__Impl2165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EffectRule__Group__3__Impl_in_rule__EffectRule__Group__32195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__EffectRule__Group__3__Impl2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02262 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12322 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__12325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__QualifiedName__Group__1__Impl2353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__22384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__0__Impl_in_rule__TypeRule__Group__02448 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1_in_rule__TypeRule__Group__02451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__PathAssignment_0_in_rule__TypeRule__Group__0__Impl2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__Group__1__Impl_in_rule__TypeRule__Group__12509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeRule__TypeAssignment_1_in_rule__TypeRule__Group__1__Impl2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__0__Impl_in_rule__MultiplicityRule__Group__02570 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1_in_rule__MultiplicityRule__Group__02573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__MultiplicityRule__Group__0__Impl2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__1__Impl_in_rule__MultiplicityRule__Group__12632 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2_in_rule__MultiplicityRule__Group__12635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_1_in_rule__MultiplicityRule__Group__1__Impl2662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__2__Impl_in_rule__MultiplicityRule__Group__22692 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3_in_rule__MultiplicityRule__Group__22695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0_in_rule__MultiplicityRule__Group__2__Impl2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group__3__Impl_in_rule__MultiplicityRule__Group__32753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__MultiplicityRule__Group__3__Impl2781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__0__Impl_in_rule__MultiplicityRule__Group_2__02820 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1_in_rule__MultiplicityRule__Group_2__02823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__MultiplicityRule__Group_2__0__Impl2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__Group_2__1__Impl_in_rule__MultiplicityRule__Group_2__12882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicityRule__BoundsAssignment_2_1_in_rule__MultiplicityRule__Group_2__1__Impl2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibilityKind_in_rule__ParameterRule__VisibilityAssignment_02948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirection_in_rule__ParameterRule__DirectionAssignment_12979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParameterRule__NameAssignment_23010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRule_in_rule__ParameterRule__TypeAssignment_4_03041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityRule_in_rule__ParameterRule__MultiplicityAssignment_53072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifiersRule_in_rule__ParameterRule__ModifiersAssignment_63103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectRule_in_rule__ParameterRule__EffectAssignment_73134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_13165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierSpecification_in_rule__ModifiersRule__ValuesAssignment_2_13196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifierKind_in_rule__ModifierSpecification__ValueAssignment3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEffectKind_in_rule__EffectRule__EffectKindAssignment_23258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_03293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_23328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TypeRule__PathAssignment_03359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TypeRule__TypeAssignment_13394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_13429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoundSpecification_in_rule__MultiplicityRule__BoundsAssignment_2_13460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNLIMITEDLITERAL_in_rule__BoundSpecification__ValueAssignment3491 = new BitSet(new long[]{0x0000000000000002L});

}