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
package org.eclipse.papyrus.marte.vsl.ui.contentassist.antlr.internal; 

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
import org.eclipse.papyrus.marte.vsl.services.VSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGERLITERAL", "RULE_REALLITERAL", "RULE_DATETIMELITERAL", "RULE_BOOLEANLITERAL", "RULE_NULLLITERAL", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'mod'", "'not'", "']'", "'['", "'in'", "'out'", "'inout'", "':'", "'.'", "'('", "')'", "'::'", "'..'", "'{'", "'}'", "','", "'='", "'@'", "'when'", "'&'", "'jitter('", "'$'", "'?'"
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

        public InternalVSLParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g"; }


     
     	private VSLGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(VSLGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:61:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:62:1: ( ruleExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:63:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression61);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression68); 

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:70:1: ruleExpression : ( ( rule__Expression__ExpAssignment ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:74:2: ( ( ( rule__Expression__ExpAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:75:1: ( ( rule__Expression__ExpAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:75:1: ( ( rule__Expression__ExpAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:76:1: ( rule__Expression__ExpAssignment )
            {
             before(grammarAccess.getExpressionAccess().getExpAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:77:1: ( rule__Expression__ExpAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:77:2: rule__Expression__ExpAssignment
            {
            pushFollow(FOLLOW_rule__Expression__ExpAssignment_in_ruleExpression94);
            rule__Expression__ExpAssignment();
            _fsp--;


            }

             after(grammarAccess.getExpressionAccess().getExpAssignment()); 

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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleAndOrXorExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:89:1: entryRuleAndOrXorExpression : ruleAndOrXorExpression EOF ;
    public final void entryRuleAndOrXorExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:90:1: ( ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:91:1: ruleAndOrXorExpression EOF
            {
             before(grammarAccess.getAndOrXorExpressionRule()); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression121);
            ruleAndOrXorExpression();
            _fsp--;

             after(grammarAccess.getAndOrXorExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression128); 

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
    // $ANTLR end entryRuleAndOrXorExpression


    // $ANTLR start ruleAndOrXorExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:98:1: ruleAndOrXorExpression : ( ( rule__AndOrXorExpression__Group__0 ) ) ;
    public final void ruleAndOrXorExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:102:2: ( ( ( rule__AndOrXorExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:103:1: ( ( rule__AndOrXorExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:103:1: ( ( rule__AndOrXorExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:104:1: ( rule__AndOrXorExpression__Group__0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:105:1: ( rule__AndOrXorExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:105:2: rule__AndOrXorExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__0_in_ruleAndOrXorExpression154);
            rule__AndOrXorExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAndOrXorExpressionAccess().getGroup()); 

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
    // $ANTLR end ruleAndOrXorExpression


    // $ANTLR start entryRuleEqualityExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:117:1: entryRuleEqualityExpression : ruleEqualityExpression EOF ;
    public final void entryRuleEqualityExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:118:1: ( ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:119:1: ruleEqualityExpression EOF
            {
             before(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression181);
            ruleEqualityExpression();
            _fsp--;

             after(grammarAccess.getEqualityExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression188); 

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
    // $ANTLR end entryRuleEqualityExpression


    // $ANTLR start ruleEqualityExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:126:1: ruleEqualityExpression : ( ( rule__EqualityExpression__Group__0 ) ) ;
    public final void ruleEqualityExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:130:2: ( ( ( rule__EqualityExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:131:1: ( ( rule__EqualityExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:131:1: ( ( rule__EqualityExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:132:1: ( rule__EqualityExpression__Group__0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:133:1: ( rule__EqualityExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:133:2: rule__EqualityExpression__Group__0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__0_in_ruleEqualityExpression214);
            rule__EqualityExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEqualityExpressionAccess().getGroup()); 

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
    // $ANTLR end ruleEqualityExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:145:1: entryRuleRelationalExpression : ruleRelationalExpression EOF ;
    public final void entryRuleRelationalExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:146:1: ( ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:147:1: ruleRelationalExpression EOF
            {
             before(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression241);
            ruleRelationalExpression();
            _fsp--;

             after(grammarAccess.getRelationalExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression248); 

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
    // $ANTLR end entryRuleRelationalExpression


    // $ANTLR start ruleRelationalExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:154:1: ruleRelationalExpression : ( ( rule__RelationalExpression__Group__0 ) ) ;
    public final void ruleRelationalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:158:2: ( ( ( rule__RelationalExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:159:1: ( ( rule__RelationalExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:159:1: ( ( rule__RelationalExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:160:1: ( rule__RelationalExpression__Group__0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:161:1: ( rule__RelationalExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:161:2: rule__RelationalExpression__Group__0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__0_in_ruleRelationalExpression274);
            rule__RelationalExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getGroup()); 

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
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleConditionalExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:173:1: entryRuleConditionalExpression : ruleConditionalExpression EOF ;
    public final void entryRuleConditionalExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:174:1: ( ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:175:1: ruleConditionalExpression EOF
            {
             before(grammarAccess.getConditionalExpressionRule()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression301);
            ruleConditionalExpression();
            _fsp--;

             after(grammarAccess.getConditionalExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression308); 

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
    // $ANTLR end entryRuleConditionalExpression


    // $ANTLR start ruleConditionalExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:182:1: ruleConditionalExpression : ( ( rule__ConditionalExpression__Group__0 ) ) ;
    public final void ruleConditionalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:186:2: ( ( ( rule__ConditionalExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:187:1: ( ( rule__ConditionalExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:187:1: ( ( rule__ConditionalExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:188:1: ( rule__ConditionalExpression__Group__0 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:189:1: ( rule__ConditionalExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:189:2: rule__ConditionalExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__0_in_ruleConditionalExpression334);
            rule__ConditionalExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getConditionalExpressionAccess().getGroup()); 

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
    // $ANTLR end ruleConditionalExpression


    // $ANTLR start entryRuleAdditiveExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:201:1: entryRuleAdditiveExpression : ruleAdditiveExpression EOF ;
    public final void entryRuleAdditiveExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:202:1: ( ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:203:1: ruleAdditiveExpression EOF
            {
             before(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression361);
            ruleAdditiveExpression();
            _fsp--;

             after(grammarAccess.getAdditiveExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression368); 

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
    // $ANTLR end entryRuleAdditiveExpression


    // $ANTLR start ruleAdditiveExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:210:1: ruleAdditiveExpression : ( ( rule__AdditiveExpression__Group__0 ) ) ;
    public final void ruleAdditiveExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:214:2: ( ( ( rule__AdditiveExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:215:1: ( ( rule__AdditiveExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:215:1: ( ( rule__AdditiveExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:216:1: ( rule__AdditiveExpression__Group__0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:217:1: ( rule__AdditiveExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:217:2: rule__AdditiveExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__0_in_ruleAdditiveExpression394);
            rule__AdditiveExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getGroup()); 

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
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:229:1: entryRuleMultiplicativeExpression : ruleMultiplicativeExpression EOF ;
    public final void entryRuleMultiplicativeExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:230:1: ( ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:231:1: ruleMultiplicativeExpression EOF
            {
             before(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression421);
            ruleMultiplicativeExpression();
            _fsp--;

             after(grammarAccess.getMultiplicativeExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression428); 

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
    // $ANTLR end entryRuleMultiplicativeExpression


    // $ANTLR start ruleMultiplicativeExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:238:1: ruleMultiplicativeExpression : ( ( rule__MultiplicativeExpression__Group__0 ) ) ;
    public final void ruleMultiplicativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:242:2: ( ( ( rule__MultiplicativeExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:243:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:243:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:244:1: ( rule__MultiplicativeExpression__Group__0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:245:1: ( rule__MultiplicativeExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:245:2: rule__MultiplicativeExpression__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__0_in_ruleMultiplicativeExpression454);
            rule__MultiplicativeExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 

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
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleUnaryExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:257:1: entryRuleUnaryExpression : ruleUnaryExpression EOF ;
    public final void entryRuleUnaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:258:1: ( ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:259:1: ruleUnaryExpression EOF
            {
             before(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression481);
            ruleUnaryExpression();
            _fsp--;

             after(grammarAccess.getUnaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression488); 

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
    // $ANTLR end entryRuleUnaryExpression


    // $ANTLR start ruleUnaryExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:266:1: ruleUnaryExpression : ( ( rule__UnaryExpression__Alternatives ) ) ;
    public final void ruleUnaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:270:2: ( ( ( rule__UnaryExpression__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:271:1: ( ( rule__UnaryExpression__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:271:1: ( ( rule__UnaryExpression__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:272:1: ( rule__UnaryExpression__Alternatives )
            {
             before(grammarAccess.getUnaryExpressionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:273:1: ( rule__UnaryExpression__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:273:2: rule__UnaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Alternatives_in_ruleUnaryExpression514);
            rule__UnaryExpression__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getUnaryExpressionAccess().getAlternatives()); 

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
    // $ANTLR end ruleUnaryExpression


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:285:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:286:1: ( rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:287:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression541);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression548); 

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
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:294:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Group__0 ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:298:2: ( ( ( rule__PrimaryExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:299:1: ( ( rule__PrimaryExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:299:1: ( ( rule__PrimaryExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:300:1: ( rule__PrimaryExpression__Group__0 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:301:1: ( rule__PrimaryExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:301:2: rule__PrimaryExpression__Group__0
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group__0_in_rulePrimaryExpression574);
            rule__PrimaryExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getGroup()); 

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
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleValueSpecification
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:313:1: entryRuleValueSpecification : ruleValueSpecification EOF ;
    public final void entryRuleValueSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:314:1: ( ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:315:1: ruleValueSpecification EOF
            {
             before(grammarAccess.getValueSpecificationRule()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification601);
            ruleValueSpecification();
            _fsp--;

             after(grammarAccess.getValueSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification608); 

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
    // $ANTLR end entryRuleValueSpecification


    // $ANTLR start ruleValueSpecification
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:322:1: ruleValueSpecification : ( ( rule__ValueSpecification__Alternatives ) ) ;
    public final void ruleValueSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:326:2: ( ( ( rule__ValueSpecification__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:327:1: ( ( rule__ValueSpecification__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:327:1: ( ( rule__ValueSpecification__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:328:1: ( rule__ValueSpecification__Alternatives )
            {
             before(grammarAccess.getValueSpecificationAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:329:1: ( rule__ValueSpecification__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:329:2: rule__ValueSpecification__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Alternatives_in_ruleValueSpecification634);
            rule__ValueSpecification__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getValueSpecificationAccess().getAlternatives()); 

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
    // $ANTLR end ruleValueSpecification


    // $ANTLR start entryRuleSuffixExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:341:1: entryRuleSuffixExpression : ruleSuffixExpression EOF ;
    public final void entryRuleSuffixExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:342:1: ( ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:343:1: ruleSuffixExpression EOF
            {
             before(grammarAccess.getSuffixExpressionRule()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression661);
            ruleSuffixExpression();
            _fsp--;

             after(grammarAccess.getSuffixExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression668); 

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
    // $ANTLR end entryRuleSuffixExpression


    // $ANTLR start ruleSuffixExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:350:1: ruleSuffixExpression : ( ( rule__SuffixExpression__Alternatives ) ) ;
    public final void ruleSuffixExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:354:2: ( ( ( rule__SuffixExpression__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:355:1: ( ( rule__SuffixExpression__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:355:1: ( ( rule__SuffixExpression__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:356:1: ( rule__SuffixExpression__Alternatives )
            {
             before(grammarAccess.getSuffixExpressionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:357:1: ( rule__SuffixExpression__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:357:2: rule__SuffixExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__SuffixExpression__Alternatives_in_ruleSuffixExpression694);
            rule__SuffixExpression__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getSuffixExpressionAccess().getAlternatives()); 

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
    // $ANTLR end ruleSuffixExpression


    // $ANTLR start entryRulePropertyCallExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:369:1: entryRulePropertyCallExpression : rulePropertyCallExpression EOF ;
    public final void entryRulePropertyCallExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:370:1: ( rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:371:1: rulePropertyCallExpression EOF
            {
             before(grammarAccess.getPropertyCallExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression721);
            rulePropertyCallExpression();
            _fsp--;

             after(grammarAccess.getPropertyCallExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression728); 

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
    // $ANTLR end entryRulePropertyCallExpression


    // $ANTLR start rulePropertyCallExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:378:1: rulePropertyCallExpression : ( ( rule__PropertyCallExpression__Group__0 ) ) ;
    public final void rulePropertyCallExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:382:2: ( ( ( rule__PropertyCallExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:383:1: ( ( rule__PropertyCallExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:383:1: ( ( rule__PropertyCallExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:384:1: ( rule__PropertyCallExpression__Group__0 )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:385:1: ( rule__PropertyCallExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:385:2: rule__PropertyCallExpression__Group__0
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__0_in_rulePropertyCallExpression754);
            rule__PropertyCallExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getPropertyCallExpressionAccess().getGroup()); 

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
    // $ANTLR end rulePropertyCallExpression


    // $ANTLR start entryRuleOperationCallExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:397:1: entryRuleOperationCallExpression : ruleOperationCallExpression EOF ;
    public final void entryRuleOperationCallExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:398:1: ( ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:399:1: ruleOperationCallExpression EOF
            {
             before(grammarAccess.getOperationCallExpressionRule()); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression781);
            ruleOperationCallExpression();
            _fsp--;

             after(grammarAccess.getOperationCallExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression788); 

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
    // $ANTLR end entryRuleOperationCallExpression


    // $ANTLR start ruleOperationCallExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:406:1: ruleOperationCallExpression : ( ( rule__OperationCallExpression__Group__0 ) ) ;
    public final void ruleOperationCallExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:410:2: ( ( ( rule__OperationCallExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:411:1: ( ( rule__OperationCallExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:411:1: ( ( rule__OperationCallExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:412:1: ( rule__OperationCallExpression__Group__0 )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:413:1: ( rule__OperationCallExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:413:2: rule__OperationCallExpression__Group__0
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__0_in_ruleOperationCallExpression814);
            rule__OperationCallExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getOperationCallExpressionAccess().getGroup()); 

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
    // $ANTLR end ruleOperationCallExpression


    // $ANTLR start entryRuleLiteral
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:425:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:426:1: ( ruleLiteral EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:427:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral841);
            ruleLiteral();
            _fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral848); 

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
    // $ANTLR end entryRuleLiteral


    // $ANTLR start ruleLiteral
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:434:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:438:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:439:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:439:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:440:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:441:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:441:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral874);
            rule__Literal__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

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
    // $ANTLR end ruleLiteral


    // $ANTLR start entryRuleNameOrChoiceOrBehaviorCall
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:453:1: entryRuleNameOrChoiceOrBehaviorCall : ruleNameOrChoiceOrBehaviorCall EOF ;
    public final void entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:454:1: ( ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:455:1: ruleNameOrChoiceOrBehaviorCall EOF
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallRule()); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall901);
            ruleNameOrChoiceOrBehaviorCall();
            _fsp--;

             after(grammarAccess.getNameOrChoiceOrBehaviorCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall908); 

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
    // $ANTLR end entryRuleNameOrChoiceOrBehaviorCall


    // $ANTLR start ruleNameOrChoiceOrBehaviorCall
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:462:1: ruleNameOrChoiceOrBehaviorCall : ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) ) ;
    public final void ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:466:2: ( ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:467:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:467:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:468:1: ( rule__NameOrChoiceOrBehaviorCall__Group__0 )
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:469:1: ( rule__NameOrChoiceOrBehaviorCall__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:469:2: rule__NameOrChoiceOrBehaviorCall__Group__0
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0_in_ruleNameOrChoiceOrBehaviorCall934);
            rule__NameOrChoiceOrBehaviorCall__Group__0();
            _fsp--;


            }

             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getGroup()); 

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
    // $ANTLR end ruleNameOrChoiceOrBehaviorCall


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:481:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:482:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:483:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName961);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName968); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:490:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:494:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:495:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:495:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:496:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:497:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:497:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName994);
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


    // $ANTLR start entryRuleInterval
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:509:1: entryRuleInterval : ruleInterval EOF ;
    public final void entryRuleInterval() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:510:1: ( ruleInterval EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:511:1: ruleInterval EOF
            {
             before(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval1021);
            ruleInterval();
            _fsp--;

             after(grammarAccess.getIntervalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval1028); 

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
    // $ANTLR end entryRuleInterval


    // $ANTLR start ruleInterval
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:518:1: ruleInterval : ( ( rule__Interval__Group__0 ) ) ;
    public final void ruleInterval() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:522:2: ( ( ( rule__Interval__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:523:1: ( ( rule__Interval__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:523:1: ( ( rule__Interval__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:524:1: ( rule__Interval__Group__0 )
            {
             before(grammarAccess.getIntervalAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:525:1: ( rule__Interval__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:525:2: rule__Interval__Group__0
            {
            pushFollow(FOLLOW_rule__Interval__Group__0_in_ruleInterval1054);
            rule__Interval__Group__0();
            _fsp--;


            }

             after(grammarAccess.getIntervalAccess().getGroup()); 

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
    // $ANTLR end ruleInterval


    // $ANTLR start entryRuleCollectionOrTuple
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:537:1: entryRuleCollectionOrTuple : ruleCollectionOrTuple EOF ;
    public final void entryRuleCollectionOrTuple() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:538:1: ( ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:539:1: ruleCollectionOrTuple EOF
            {
             before(grammarAccess.getCollectionOrTupleRule()); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple1081);
            ruleCollectionOrTuple();
            _fsp--;

             after(grammarAccess.getCollectionOrTupleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple1088); 

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
    // $ANTLR end entryRuleCollectionOrTuple


    // $ANTLR start ruleCollectionOrTuple
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:546:1: ruleCollectionOrTuple : ( ( rule__CollectionOrTuple__Group__0 ) ) ;
    public final void ruleCollectionOrTuple() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:550:2: ( ( ( rule__CollectionOrTuple__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:551:1: ( ( rule__CollectionOrTuple__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:551:1: ( ( rule__CollectionOrTuple__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:552:1: ( rule__CollectionOrTuple__Group__0 )
            {
             before(grammarAccess.getCollectionOrTupleAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:553:1: ( rule__CollectionOrTuple__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:553:2: rule__CollectionOrTuple__Group__0
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__0_in_ruleCollectionOrTuple1114);
            rule__CollectionOrTuple__Group__0();
            _fsp--;


            }

             after(grammarAccess.getCollectionOrTupleAccess().getGroup()); 

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
    // $ANTLR end ruleCollectionOrTuple


    // $ANTLR start entryRuleTuple
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:565:1: entryRuleTuple : ruleTuple EOF ;
    public final void entryRuleTuple() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:566:1: ( ruleTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:567:1: ruleTuple EOF
            {
             before(grammarAccess.getTupleRule()); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple1141);
            ruleTuple();
            _fsp--;

             after(grammarAccess.getTupleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple1148); 

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
    // $ANTLR end entryRuleTuple


    // $ANTLR start ruleTuple
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:574:1: ruleTuple : ( ( rule__Tuple__Group__0 ) ) ;
    public final void ruleTuple() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:578:2: ( ( ( rule__Tuple__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:579:1: ( ( rule__Tuple__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:579:1: ( ( rule__Tuple__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:580:1: ( rule__Tuple__Group__0 )
            {
             before(grammarAccess.getTupleAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:581:1: ( rule__Tuple__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:581:2: rule__Tuple__Group__0
            {
            pushFollow(FOLLOW_rule__Tuple__Group__0_in_ruleTuple1174);
            rule__Tuple__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTupleAccess().getGroup()); 

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
    // $ANTLR end ruleTuple


    // $ANTLR start entryRuleListOfValues
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:593:1: entryRuleListOfValues : ruleListOfValues EOF ;
    public final void entryRuleListOfValues() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:594:1: ( ruleListOfValues EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:595:1: ruleListOfValues EOF
            {
             before(grammarAccess.getListOfValuesRule()); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues1201);
            ruleListOfValues();
            _fsp--;

             after(grammarAccess.getListOfValuesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues1208); 

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
    // $ANTLR end entryRuleListOfValues


    // $ANTLR start ruleListOfValues
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:602:1: ruleListOfValues : ( ( rule__ListOfValues__Group__0 ) ) ;
    public final void ruleListOfValues() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:606:2: ( ( ( rule__ListOfValues__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:607:1: ( ( rule__ListOfValues__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:607:1: ( ( rule__ListOfValues__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:608:1: ( rule__ListOfValues__Group__0 )
            {
             before(grammarAccess.getListOfValuesAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:609:1: ( rule__ListOfValues__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:609:2: rule__ListOfValues__Group__0
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group__0_in_ruleListOfValues1234);
            rule__ListOfValues__Group__0();
            _fsp--;


            }

             after(grammarAccess.getListOfValuesAccess().getGroup()); 

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
    // $ANTLR end ruleListOfValues


    // $ANTLR start entryRuleListOfValueNamePairs
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:621:1: entryRuleListOfValueNamePairs : ruleListOfValueNamePairs EOF ;
    public final void entryRuleListOfValueNamePairs() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:622:1: ( ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:623:1: ruleListOfValueNamePairs EOF
            {
             before(grammarAccess.getListOfValueNamePairsRule()); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs1261);
            ruleListOfValueNamePairs();
            _fsp--;

             after(grammarAccess.getListOfValueNamePairsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs1268); 

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
    // $ANTLR end entryRuleListOfValueNamePairs


    // $ANTLR start ruleListOfValueNamePairs
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:630:1: ruleListOfValueNamePairs : ( ( rule__ListOfValueNamePairs__Group__0 ) ) ;
    public final void ruleListOfValueNamePairs() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:634:2: ( ( ( rule__ListOfValueNamePairs__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:635:1: ( ( rule__ListOfValueNamePairs__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:635:1: ( ( rule__ListOfValueNamePairs__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:636:1: ( rule__ListOfValueNamePairs__Group__0 )
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:637:1: ( rule__ListOfValueNamePairs__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:637:2: rule__ListOfValueNamePairs__Group__0
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__0_in_ruleListOfValueNamePairs1294);
            rule__ListOfValueNamePairs__Group__0();
            _fsp--;


            }

             after(grammarAccess.getListOfValueNamePairsAccess().getGroup()); 

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
    // $ANTLR end ruleListOfValueNamePairs


    // $ANTLR start entryRuleValueNamePair
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:649:1: entryRuleValueNamePair : ruleValueNamePair EOF ;
    public final void entryRuleValueNamePair() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:650:1: ( ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:651:1: ruleValueNamePair EOF
            {
             before(grammarAccess.getValueNamePairRule()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair1321);
            ruleValueNamePair();
            _fsp--;

             after(grammarAccess.getValueNamePairRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair1328); 

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
    // $ANTLR end entryRuleValueNamePair


    // $ANTLR start ruleValueNamePair
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:658:1: ruleValueNamePair : ( ( rule__ValueNamePair__Group__0 ) ) ;
    public final void ruleValueNamePair() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:662:2: ( ( ( rule__ValueNamePair__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:663:1: ( ( rule__ValueNamePair__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:663:1: ( ( rule__ValueNamePair__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:664:1: ( rule__ValueNamePair__Group__0 )
            {
             before(grammarAccess.getValueNamePairAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:665:1: ( rule__ValueNamePair__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:665:2: rule__ValueNamePair__Group__0
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__0_in_ruleValueNamePair1354);
            rule__ValueNamePair__Group__0();
            _fsp--;


            }

             after(grammarAccess.getValueNamePairAccess().getGroup()); 

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
    // $ANTLR end ruleValueNamePair


    // $ANTLR start entryRuleTimeExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:677:1: entryRuleTimeExpression : ruleTimeExpression EOF ;
    public final void entryRuleTimeExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:678:1: ( ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:679:1: ruleTimeExpression EOF
            {
             before(grammarAccess.getTimeExpressionRule()); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression1381);
            ruleTimeExpression();
            _fsp--;

             after(grammarAccess.getTimeExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression1388); 

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
    // $ANTLR end entryRuleTimeExpression


    // $ANTLR start ruleTimeExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:686:1: ruleTimeExpression : ( ( rule__TimeExpression__Alternatives ) ) ;
    public final void ruleTimeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:690:2: ( ( ( rule__TimeExpression__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:691:1: ( ( rule__TimeExpression__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:691:1: ( ( rule__TimeExpression__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:692:1: ( rule__TimeExpression__Alternatives )
            {
             before(grammarAccess.getTimeExpressionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:693:1: ( rule__TimeExpression__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:693:2: rule__TimeExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__TimeExpression__Alternatives_in_ruleTimeExpression1414);
            rule__TimeExpression__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getTimeExpressionAccess().getAlternatives()); 

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
    // $ANTLR end ruleTimeExpression


    // $ANTLR start entryRuleInstantObsExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:705:1: entryRuleInstantObsExpression : ruleInstantObsExpression EOF ;
    public final void entryRuleInstantObsExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:706:1: ( ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:707:1: ruleInstantObsExpression EOF
            {
             before(grammarAccess.getInstantObsExpressionRule()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression1441);
            ruleInstantObsExpression();
            _fsp--;

             after(grammarAccess.getInstantObsExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression1448); 

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
    // $ANTLR end entryRuleInstantObsExpression


    // $ANTLR start ruleInstantObsExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:714:1: ruleInstantObsExpression : ( ( rule__InstantObsExpression__Group__0 ) ) ;
    public final void ruleInstantObsExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:718:2: ( ( ( rule__InstantObsExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:719:1: ( ( rule__InstantObsExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:719:1: ( ( rule__InstantObsExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:720:1: ( rule__InstantObsExpression__Group__0 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:721:1: ( rule__InstantObsExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:721:2: rule__InstantObsExpression__Group__0
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__0_in_ruleInstantObsExpression1474);
            rule__InstantObsExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getInstantObsExpressionAccess().getGroup()); 

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
    // $ANTLR end ruleInstantObsExpression


    // $ANTLR start entryRuleInstantObsName
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:733:1: entryRuleInstantObsName : ruleInstantObsName EOF ;
    public final void entryRuleInstantObsName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:734:1: ( ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:735:1: ruleInstantObsName EOF
            {
             before(grammarAccess.getInstantObsNameRule()); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName1501);
            ruleInstantObsName();
            _fsp--;

             after(grammarAccess.getInstantObsNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName1508); 

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
    // $ANTLR end entryRuleInstantObsName


    // $ANTLR start ruleInstantObsName
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:742:1: ruleInstantObsName : ( ( rule__InstantObsName__Group__0 ) ) ;
    public final void ruleInstantObsName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:746:2: ( ( ( rule__InstantObsName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:747:1: ( ( rule__InstantObsName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:747:1: ( ( rule__InstantObsName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:748:1: ( rule__InstantObsName__Group__0 )
            {
             before(grammarAccess.getInstantObsNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:749:1: ( rule__InstantObsName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:749:2: rule__InstantObsName__Group__0
            {
            pushFollow(FOLLOW_rule__InstantObsName__Group__0_in_ruleInstantObsName1534);
            rule__InstantObsName__Group__0();
            _fsp--;


            }

             after(grammarAccess.getInstantObsNameAccess().getGroup()); 

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
    // $ANTLR end ruleInstantObsName


    // $ANTLR start entryRuleDurationObsExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:761:1: entryRuleDurationObsExpression : ruleDurationObsExpression EOF ;
    public final void entryRuleDurationObsExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:762:1: ( ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:763:1: ruleDurationObsExpression EOF
            {
             before(grammarAccess.getDurationObsExpressionRule()); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression1561);
            ruleDurationObsExpression();
            _fsp--;

             after(grammarAccess.getDurationObsExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression1568); 

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
    // $ANTLR end entryRuleDurationObsExpression


    // $ANTLR start ruleDurationObsExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:770:1: ruleDurationObsExpression : ( ( rule__DurationObsExpression__Group__0 ) ) ;
    public final void ruleDurationObsExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:774:2: ( ( ( rule__DurationObsExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:775:1: ( ( rule__DurationObsExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:775:1: ( ( rule__DurationObsExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:776:1: ( rule__DurationObsExpression__Group__0 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:777:1: ( rule__DurationObsExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:777:2: rule__DurationObsExpression__Group__0
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__0_in_ruleDurationObsExpression1594);
            rule__DurationObsExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getDurationObsExpressionAccess().getGroup()); 

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
    // $ANTLR end ruleDurationObsExpression


    // $ANTLR start entryRuleDurationObsName
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:789:1: entryRuleDurationObsName : ruleDurationObsName EOF ;
    public final void entryRuleDurationObsName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:790:1: ( ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:791:1: ruleDurationObsName EOF
            {
             before(grammarAccess.getDurationObsNameRule()); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName1621);
            ruleDurationObsName();
            _fsp--;

             after(grammarAccess.getDurationObsNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName1628); 

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
    // $ANTLR end entryRuleDurationObsName


    // $ANTLR start ruleDurationObsName
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:798:1: ruleDurationObsName : ( ( rule__DurationObsName__Group__0 ) ) ;
    public final void ruleDurationObsName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:802:2: ( ( ( rule__DurationObsName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:803:1: ( ( rule__DurationObsName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:803:1: ( ( rule__DurationObsName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:804:1: ( rule__DurationObsName__Group__0 )
            {
             before(grammarAccess.getDurationObsNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:805:1: ( rule__DurationObsName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:805:2: rule__DurationObsName__Group__0
            {
            pushFollow(FOLLOW_rule__DurationObsName__Group__0_in_ruleDurationObsName1654);
            rule__DurationObsName__Group__0();
            _fsp--;


            }

             after(grammarAccess.getDurationObsNameAccess().getGroup()); 

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
    // $ANTLR end ruleDurationObsName


    // $ANTLR start entryRuleJitterExp
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:817:1: entryRuleJitterExp : ruleJitterExp EOF ;
    public final void entryRuleJitterExp() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:818:1: ( ruleJitterExp EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:819:1: ruleJitterExp EOF
            {
             before(grammarAccess.getJitterExpRule()); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp1681);
            ruleJitterExp();
            _fsp--;

             after(grammarAccess.getJitterExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp1688); 

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
    // $ANTLR end entryRuleJitterExp


    // $ANTLR start ruleJitterExp
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:826:1: ruleJitterExp : ( ( rule__JitterExp__Group__0 ) ) ;
    public final void ruleJitterExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:830:2: ( ( ( rule__JitterExp__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:831:1: ( ( rule__JitterExp__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:831:1: ( ( rule__JitterExp__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:832:1: ( rule__JitterExp__Group__0 )
            {
             before(grammarAccess.getJitterExpAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:833:1: ( rule__JitterExp__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:833:2: rule__JitterExp__Group__0
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__0_in_ruleJitterExp1714);
            rule__JitterExp__Group__0();
            _fsp--;


            }

             after(grammarAccess.getJitterExpAccess().getGroup()); 

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
    // $ANTLR end ruleJitterExp


    // $ANTLR start entryRuleVariableDeclaration
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:845:1: entryRuleVariableDeclaration : ruleVariableDeclaration EOF ;
    public final void entryRuleVariableDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:846:1: ( ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:847:1: ruleVariableDeclaration EOF
            {
             before(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1741);
            ruleVariableDeclaration();
            _fsp--;

             after(grammarAccess.getVariableDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration1748); 

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
    // $ANTLR end entryRuleVariableDeclaration


    // $ANTLR start ruleVariableDeclaration
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:854:1: ruleVariableDeclaration : ( ( rule__VariableDeclaration__Group__0 ) ) ;
    public final void ruleVariableDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:858:2: ( ( ( rule__VariableDeclaration__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:859:1: ( ( rule__VariableDeclaration__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:859:1: ( ( rule__VariableDeclaration__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:860:1: ( rule__VariableDeclaration__Group__0 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:861:1: ( rule__VariableDeclaration__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:861:2: rule__VariableDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__0_in_ruleVariableDeclaration1774);
            rule__VariableDeclaration__Group__0();
            _fsp--;


            }

             after(grammarAccess.getVariableDeclarationAccess().getGroup()); 

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
    // $ANTLR end ruleVariableDeclaration


    // $ANTLR start entryRuleVariableDirectionKind
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:873:1: entryRuleVariableDirectionKind : ruleVariableDirectionKind EOF ;
    public final void entryRuleVariableDirectionKind() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:874:1: ( ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:875:1: ruleVariableDirectionKind EOF
            {
             before(grammarAccess.getVariableDirectionKindRule()); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind1801);
            ruleVariableDirectionKind();
            _fsp--;

             after(grammarAccess.getVariableDirectionKindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind1808); 

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
    // $ANTLR end entryRuleVariableDirectionKind


    // $ANTLR start ruleVariableDirectionKind
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:882:1: ruleVariableDirectionKind : ( ( rule__VariableDirectionKind__Alternatives ) ) ;
    public final void ruleVariableDirectionKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:886:2: ( ( ( rule__VariableDirectionKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:887:1: ( ( rule__VariableDirectionKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:887:1: ( ( rule__VariableDirectionKind__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:888:1: ( rule__VariableDirectionKind__Alternatives )
            {
             before(grammarAccess.getVariableDirectionKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:889:1: ( rule__VariableDirectionKind__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:889:2: rule__VariableDirectionKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VariableDirectionKind__Alternatives_in_ruleVariableDirectionKind1834);
            rule__VariableDirectionKind__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getVariableDirectionKindAccess().getAlternatives()); 

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
    // $ANTLR end ruleVariableDirectionKind


    // $ANTLR start entryRuleDataTypeName
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:901:1: entryRuleDataTypeName : ruleDataTypeName EOF ;
    public final void entryRuleDataTypeName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:902:1: ( ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:903:1: ruleDataTypeName EOF
            {
             before(grammarAccess.getDataTypeNameRule()); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName1861);
            ruleDataTypeName();
            _fsp--;

             after(grammarAccess.getDataTypeNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName1868); 

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
    // $ANTLR end entryRuleDataTypeName


    // $ANTLR start ruleDataTypeName
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:910:1: ruleDataTypeName : ( ( rule__DataTypeName__Group__0 ) ) ;
    public final void ruleDataTypeName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:914:2: ( ( ( rule__DataTypeName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:915:1: ( ( rule__DataTypeName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:915:1: ( ( rule__DataTypeName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:916:1: ( rule__DataTypeName__Group__0 )
            {
             before(grammarAccess.getDataTypeNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:917:1: ( rule__DataTypeName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:917:2: rule__DataTypeName__Group__0
            {
            pushFollow(FOLLOW_rule__DataTypeName__Group__0_in_ruleDataTypeName1894);
            rule__DataTypeName__Group__0();
            _fsp--;


            }

             after(grammarAccess.getDataTypeNameAccess().getGroup()); 

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
    // $ANTLR end ruleDataTypeName


    // $ANTLR start entryRuleNumberLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:929:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:930:1: ( ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:931:1: ruleNumberLiteralRule EOF
            {
             before(grammarAccess.getNumberLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule1921);
            ruleNumberLiteralRule();
            _fsp--;

             after(grammarAccess.getNumberLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule1928); 

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
    // $ANTLR end entryRuleNumberLiteralRule


    // $ANTLR start ruleNumberLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:938:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:942:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:943:1: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:943:1: ( ( rule__NumberLiteralRule__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:944:1: ( rule__NumberLiteralRule__Alternatives )
            {
             before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:945:1: ( rule__NumberLiteralRule__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:945:2: rule__NumberLiteralRule__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteralRule__Alternatives_in_ruleNumberLiteralRule1954);
            rule__NumberLiteralRule__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 

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
    // $ANTLR end ruleNumberLiteralRule


    // $ANTLR start entryRuleIntegerLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:957:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:958:1: ( ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:959:1: ruleIntegerLiteralRule EOF
            {
             before(grammarAccess.getIntegerLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule1981);
            ruleIntegerLiteralRule();
            _fsp--;

             after(grammarAccess.getIntegerLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule1988); 

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
    // $ANTLR end entryRuleIntegerLiteralRule


    // $ANTLR start ruleIntegerLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:966:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__ValueAssignment ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:970:2: ( ( ( rule__IntegerLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:971:1: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:971:1: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:972:1: ( rule__IntegerLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:973:1: ( rule__IntegerLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:973:2: rule__IntegerLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__IntegerLiteralRule__ValueAssignment_in_ruleIntegerLiteralRule2014);
            rule__IntegerLiteralRule__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getIntegerLiteralRuleAccess().getValueAssignment()); 

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
    // $ANTLR end ruleIntegerLiteralRule


    // $ANTLR start entryRuleUnlimitedLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:985:1: entryRuleUnlimitedLiteralRule : ruleUnlimitedLiteralRule EOF ;
    public final void entryRuleUnlimitedLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:986:1: ( ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:987:1: ruleUnlimitedLiteralRule EOF
            {
             before(grammarAccess.getUnlimitedLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule2041);
            ruleUnlimitedLiteralRule();
            _fsp--;

             after(grammarAccess.getUnlimitedLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule2048); 

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
    // $ANTLR end entryRuleUnlimitedLiteralRule


    // $ANTLR start ruleUnlimitedLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:994:1: ruleUnlimitedLiteralRule : ( ( rule__UnlimitedLiteralRule__ValueAssignment ) ) ;
    public final void ruleUnlimitedLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:998:2: ( ( ( rule__UnlimitedLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:999:1: ( ( rule__UnlimitedLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:999:1: ( ( rule__UnlimitedLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1000:1: ( rule__UnlimitedLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1001:1: ( rule__UnlimitedLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1001:2: rule__UnlimitedLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__UnlimitedLiteralRule__ValueAssignment_in_ruleUnlimitedLiteralRule2074);
            rule__UnlimitedLiteralRule__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAssignment()); 

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
    // $ANTLR end ruleUnlimitedLiteralRule


    // $ANTLR start entryRuleRealLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1013:1: entryRuleRealLiteralRule : ruleRealLiteralRule EOF ;
    public final void entryRuleRealLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1014:1: ( ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1015:1: ruleRealLiteralRule EOF
            {
             before(grammarAccess.getRealLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule2101);
            ruleRealLiteralRule();
            _fsp--;

             after(grammarAccess.getRealLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule2108); 

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
    // $ANTLR end entryRuleRealLiteralRule


    // $ANTLR start ruleRealLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1022:1: ruleRealLiteralRule : ( ( rule__RealLiteralRule__ValueAssignment ) ) ;
    public final void ruleRealLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1026:2: ( ( ( rule__RealLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1027:1: ( ( rule__RealLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1027:1: ( ( rule__RealLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1028:1: ( rule__RealLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getRealLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1029:1: ( rule__RealLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1029:2: rule__RealLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__RealLiteralRule__ValueAssignment_in_ruleRealLiteralRule2134);
            rule__RealLiteralRule__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getRealLiteralRuleAccess().getValueAssignment()); 

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
    // $ANTLR end ruleRealLiteralRule


    // $ANTLR start entryRuleDateTimeLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1041:1: entryRuleDateTimeLiteralRule : ruleDateTimeLiteralRule EOF ;
    public final void entryRuleDateTimeLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1042:1: ( ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1043:1: ruleDateTimeLiteralRule EOF
            {
             before(grammarAccess.getDateTimeLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule2161);
            ruleDateTimeLiteralRule();
            _fsp--;

             after(grammarAccess.getDateTimeLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule2168); 

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
    // $ANTLR end entryRuleDateTimeLiteralRule


    // $ANTLR start ruleDateTimeLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1050:1: ruleDateTimeLiteralRule : ( ( rule__DateTimeLiteralRule__ValueAssignment ) ) ;
    public final void ruleDateTimeLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1054:2: ( ( ( rule__DateTimeLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1055:1: ( ( rule__DateTimeLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1055:1: ( ( rule__DateTimeLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1056:1: ( rule__DateTimeLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getDateTimeLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1057:1: ( rule__DateTimeLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1057:2: rule__DateTimeLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__DateTimeLiteralRule__ValueAssignment_in_ruleDateTimeLiteralRule2194);
            rule__DateTimeLiteralRule__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getDateTimeLiteralRuleAccess().getValueAssignment()); 

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
    // $ANTLR end ruleDateTimeLiteralRule


    // $ANTLR start entryRuleBooleanLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1069:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1070:1: ( ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1071:1: ruleBooleanLiteralRule EOF
            {
             before(grammarAccess.getBooleanLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule2221);
            ruleBooleanLiteralRule();
            _fsp--;

             after(grammarAccess.getBooleanLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule2228); 

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
    // $ANTLR end entryRuleBooleanLiteralRule


    // $ANTLR start ruleBooleanLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1078:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__ValueAssignment ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1082:2: ( ( ( rule__BooleanLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1083:1: ( ( rule__BooleanLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1083:1: ( ( rule__BooleanLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1084:1: ( rule__BooleanLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1085:1: ( rule__BooleanLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1085:2: rule__BooleanLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BooleanLiteralRule__ValueAssignment_in_ruleBooleanLiteralRule2254);
            rule__BooleanLiteralRule__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment()); 

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
    // $ANTLR end ruleBooleanLiteralRule


    // $ANTLR start entryRuleNullLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1097:1: entryRuleNullLiteralRule : ruleNullLiteralRule EOF ;
    public final void entryRuleNullLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1098:1: ( ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1099:1: ruleNullLiteralRule EOF
            {
             before(grammarAccess.getNullLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule2281);
            ruleNullLiteralRule();
            _fsp--;

             after(grammarAccess.getNullLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule2288); 

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
    // $ANTLR end entryRuleNullLiteralRule


    // $ANTLR start ruleNullLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1106:1: ruleNullLiteralRule : ( ( rule__NullLiteralRule__ValueAssignment ) ) ;
    public final void ruleNullLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1110:2: ( ( ( rule__NullLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1111:1: ( ( rule__NullLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1111:1: ( ( rule__NullLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1112:1: ( rule__NullLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getNullLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1113:1: ( rule__NullLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1113:2: rule__NullLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__NullLiteralRule__ValueAssignment_in_ruleNullLiteralRule2314);
            rule__NullLiteralRule__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getNullLiteralRuleAccess().getValueAssignment()); 

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
    // $ANTLR end ruleNullLiteralRule


    // $ANTLR start entryRuleDefaultLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1125:1: entryRuleDefaultLiteralRule : ruleDefaultLiteralRule EOF ;
    public final void entryRuleDefaultLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1126:1: ( ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1127:1: ruleDefaultLiteralRule EOF
            {
             before(grammarAccess.getDefaultLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule2341);
            ruleDefaultLiteralRule();
            _fsp--;

             after(grammarAccess.getDefaultLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule2348); 

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
    // $ANTLR end entryRuleDefaultLiteralRule


    // $ANTLR start ruleDefaultLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1134:1: ruleDefaultLiteralRule : ( ( rule__DefaultLiteralRule__ValueAssignment ) ) ;
    public final void ruleDefaultLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1138:2: ( ( ( rule__DefaultLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1139:1: ( ( rule__DefaultLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1139:1: ( ( rule__DefaultLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1140:1: ( rule__DefaultLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getDefaultLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1141:1: ( rule__DefaultLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1141:2: rule__DefaultLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__DefaultLiteralRule__ValueAssignment_in_ruleDefaultLiteralRule2374);
            rule__DefaultLiteralRule__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getDefaultLiteralRuleAccess().getValueAssignment()); 

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
    // $ANTLR end ruleDefaultLiteralRule


    // $ANTLR start entryRuleStringLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1153:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1154:1: ( ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1155:1: ruleStringLiteralRule EOF
            {
             before(grammarAccess.getStringLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule2401);
            ruleStringLiteralRule();
            _fsp--;

             after(grammarAccess.getStringLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule2408); 

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
    // $ANTLR end entryRuleStringLiteralRule


    // $ANTLR start ruleStringLiteralRule
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1162:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1166:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1167:1: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1167:1: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1168:1: ( rule__StringLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1169:1: ( rule__StringLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1169:2: rule__StringLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__StringLiteralRule__ValueAssignment_in_ruleStringLiteralRule2434);
            rule__StringLiteralRule__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 

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
    // $ANTLR end ruleStringLiteralRule


    // $ANTLR start rule__AndOrXorExpression__OpAlternatives_1_0_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1181:1: rule__AndOrXorExpression__OpAlternatives_1_0_0 : ( ( 'and' ) | ( 'or' ) | ( 'xor' ) );
    public final void rule__AndOrXorExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1185:1: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt1=1;
                }
                break;
            case 17:
                {
                alt1=2;
                }
                break;
            case 18:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1181:1: rule__AndOrXorExpression__OpAlternatives_1_0_0 : ( ( 'and' ) | ( 'or' ) | ( 'xor' ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1186:1: ( 'and' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1186:1: ( 'and' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1187:1: 'and'
                    {
                     before(grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__AndOrXorExpression__OpAlternatives_1_0_02471); 
                     after(grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1194:6: ( 'or' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1194:6: ( 'or' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1195:1: 'or'
                    {
                     before(grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__AndOrXorExpression__OpAlternatives_1_0_02491); 
                     after(grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1202:6: ( 'xor' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1202:6: ( 'xor' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1203:1: 'xor'
                    {
                     before(grammarAccess.getAndOrXorExpressionAccess().getOpXorKeyword_1_0_0_2()); 
                    match(input,18,FOLLOW_18_in_rule__AndOrXorExpression__OpAlternatives_1_0_02511); 
                     after(grammarAccess.getAndOrXorExpressionAccess().getOpXorKeyword_1_0_0_2()); 

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
    // $ANTLR end rule__AndOrXorExpression__OpAlternatives_1_0_0


    // $ANTLR start rule__EqualityExpression__OpAlternatives_1_0_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1215:1: rule__EqualityExpression__OpAlternatives_1_0_0 : ( ( '==' ) | ( '<>' ) );
    public final void rule__EqualityExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1219:1: ( ( '==' ) | ( '<>' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==19) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1215:1: rule__EqualityExpression__OpAlternatives_1_0_0 : ( ( '==' ) | ( '<>' ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1220:1: ( '==' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1220:1: ( '==' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1221:1: '=='
                    {
                     before(grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0()); 
                    match(input,19,FOLLOW_19_in_rule__EqualityExpression__OpAlternatives_1_0_02546); 
                     after(grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1228:6: ( '<>' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1228:6: ( '<>' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1229:1: '<>'
                    {
                     before(grammarAccess.getEqualityExpressionAccess().getOpLessThanSignGreaterThanSignKeyword_1_0_0_1()); 
                    match(input,20,FOLLOW_20_in_rule__EqualityExpression__OpAlternatives_1_0_02566); 
                     after(grammarAccess.getEqualityExpressionAccess().getOpLessThanSignGreaterThanSignKeyword_1_0_0_1()); 

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
    // $ANTLR end rule__EqualityExpression__OpAlternatives_1_0_0


    // $ANTLR start rule__RelationalExpression__OpAlternatives_1_0_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1241:1: rule__RelationalExpression__OpAlternatives_1_0_0 : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) );
    public final void rule__RelationalExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1245:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case 23:
                {
                alt3=3;
                }
                break;
            case 24:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1241:1: rule__RelationalExpression__OpAlternatives_1_0_0 : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1246:1: ( '<' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1246:1: ( '<' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1247:1: '<'
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0()); 
                    match(input,21,FOLLOW_21_in_rule__RelationalExpression__OpAlternatives_1_0_02601); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1254:6: ( '>' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1254:6: ( '>' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1255:1: '>'
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1()); 
                    match(input,22,FOLLOW_22_in_rule__RelationalExpression__OpAlternatives_1_0_02621); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1262:6: ( '<=' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1262:6: ( '<=' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1263:1: '<='
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2()); 
                    match(input,23,FOLLOW_23_in_rule__RelationalExpression__OpAlternatives_1_0_02641); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1270:6: ( '>=' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1270:6: ( '>=' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1271:1: '>='
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_0_3()); 
                    match(input,24,FOLLOW_24_in_rule__RelationalExpression__OpAlternatives_1_0_02661); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_0_3()); 

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
    // $ANTLR end rule__RelationalExpression__OpAlternatives_1_0_0


    // $ANTLR start rule__AdditiveExpression__OpAlternatives_1_0_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1283:1: rule__AdditiveExpression__OpAlternatives_1_0_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__AdditiveExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1287:1: ( ( '+' ) | ( '-' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==25) ) {
                alt4=1;
            }
            else if ( (LA4_0==26) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1283:1: rule__AdditiveExpression__OpAlternatives_1_0_0 : ( ( '+' ) | ( '-' ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1288:1: ( '+' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1288:1: ( '+' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1289:1: '+'
                    {
                     before(grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0()); 
                    match(input,25,FOLLOW_25_in_rule__AdditiveExpression__OpAlternatives_1_0_02696); 
                     after(grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1296:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1296:6: ( '-' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1297:1: '-'
                    {
                     before(grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_0_0_1()); 
                    match(input,26,FOLLOW_26_in_rule__AdditiveExpression__OpAlternatives_1_0_02716); 
                     after(grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_0_0_1()); 

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
    // $ANTLR end rule__AdditiveExpression__OpAlternatives_1_0_0


    // $ANTLR start rule__MultiplicativeExpression__OpAlternatives_1_0_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1309:1: rule__MultiplicativeExpression__OpAlternatives_1_0_0 : ( ( '*' ) | ( '/' ) | ( 'mod' ) );
    public final void rule__MultiplicativeExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1313:1: ( ( '*' ) | ( '/' ) | ( 'mod' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt5=1;
                }
                break;
            case 28:
                {
                alt5=2;
                }
                break;
            case 29:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1309:1: rule__MultiplicativeExpression__OpAlternatives_1_0_0 : ( ( '*' ) | ( '/' ) | ( 'mod' ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1314:1: ( '*' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1314:1: ( '*' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1315:1: '*'
                    {
                     before(grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0()); 
                    match(input,27,FOLLOW_27_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02751); 
                     after(grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1322:6: ( '/' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1322:6: ( '/' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1323:1: '/'
                    {
                     before(grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1()); 
                    match(input,28,FOLLOW_28_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02771); 
                     after(grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1330:6: ( 'mod' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1330:6: ( 'mod' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1331:1: 'mod'
                    {
                     before(grammarAccess.getMultiplicativeExpressionAccess().getOpModKeyword_1_0_0_2()); 
                    match(input,29,FOLLOW_29_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02791); 
                     after(grammarAccess.getMultiplicativeExpressionAccess().getOpModKeyword_1_0_0_2()); 

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
    // $ANTLR end rule__MultiplicativeExpression__OpAlternatives_1_0_0


    // $ANTLR start rule__UnaryExpression__Alternatives
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1343:1: rule__UnaryExpression__Alternatives : ( ( ( rule__UnaryExpression__Group_0__0 ) ) | ( ( rule__UnaryExpression__ExpAssignment_1 ) ) );
    public final void rule__UnaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1347:1: ( ( ( rule__UnaryExpression__Group_0__0 ) ) | ( ( rule__UnaryExpression__ExpAssignment_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=25 && LA6_0<=26)||LA6_0==30) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||(LA6_0>=27 && LA6_0<=28)||(LA6_0>=31 && LA6_0<=35)||LA6_0==38||LA6_0==42||LA6_0==46||(LA6_0>=48 && LA6_0<=50)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1343:1: rule__UnaryExpression__Alternatives : ( ( ( rule__UnaryExpression__Group_0__0 ) ) | ( ( rule__UnaryExpression__ExpAssignment_1 ) ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1348:1: ( ( rule__UnaryExpression__Group_0__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1348:1: ( ( rule__UnaryExpression__Group_0__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1349:1: ( rule__UnaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getGroup_0()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1350:1: ( rule__UnaryExpression__Group_0__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1350:2: rule__UnaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__UnaryExpression__Group_0__0_in_rule__UnaryExpression__Alternatives2825);
                    rule__UnaryExpression__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getUnaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1354:6: ( ( rule__UnaryExpression__ExpAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1354:6: ( ( rule__UnaryExpression__ExpAssignment_1 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1355:1: ( rule__UnaryExpression__ExpAssignment_1 )
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getExpAssignment_1()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1356:1: ( rule__UnaryExpression__ExpAssignment_1 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1356:2: rule__UnaryExpression__ExpAssignment_1
                    {
                    pushFollow(FOLLOW_rule__UnaryExpression__ExpAssignment_1_in_rule__UnaryExpression__Alternatives2843);
                    rule__UnaryExpression__ExpAssignment_1();
                    _fsp--;


                    }

                     after(grammarAccess.getUnaryExpressionAccess().getExpAssignment_1()); 

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
    // $ANTLR end rule__UnaryExpression__Alternatives


    // $ANTLR start rule__UnaryExpression__OpAlternatives_0_0_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1365:1: rule__UnaryExpression__OpAlternatives_0_0_0 : ( ( 'not' ) | ( '-' ) | ( '+' ) );
    public final void rule__UnaryExpression__OpAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1369:1: ( ( 'not' ) | ( '-' ) | ( '+' ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt7=1;
                }
                break;
            case 26:
                {
                alt7=2;
                }
                break;
            case 25:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1365:1: rule__UnaryExpression__OpAlternatives_0_0_0 : ( ( 'not' ) | ( '-' ) | ( '+' ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1370:1: ( 'not' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1370:1: ( 'not' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1371:1: 'not'
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0()); 
                    match(input,30,FOLLOW_30_in_rule__UnaryExpression__OpAlternatives_0_0_02877); 
                     after(grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1378:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1378:6: ( '-' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1379:1: '-'
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1()); 
                    match(input,26,FOLLOW_26_in_rule__UnaryExpression__OpAlternatives_0_0_02897); 
                     after(grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1386:6: ( '+' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1386:6: ( '+' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1387:1: '+'
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getOpPlusSignKeyword_0_0_0_2()); 
                    match(input,25,FOLLOW_25_in_rule__UnaryExpression__OpAlternatives_0_0_02917); 
                     after(grammarAccess.getUnaryExpressionAccess().getOpPlusSignKeyword_0_0_0_2()); 

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
    // $ANTLR end rule__UnaryExpression__OpAlternatives_0_0_0


    // $ANTLR start rule__ValueSpecification__Alternatives
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1399:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );
    public final void rule__ValueSpecification__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1403:1: ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) )
            int alt8=8;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case RULE_DATETIMELITERAL:
            case RULE_BOOLEANLITERAL:
            case RULE_NULLLITERAL:
            case RULE_STRING:
            case 27:
            case 28:
                {
                alt8=1;
                }
                break;
            case RULE_ID:
                {
                alt8=2;
                }
                break;
            case 31:
            case 32:
                {
                alt8=3;
                }
                break;
            case 42:
                {
                int LA8_4 = input.LA(2);

                if ( ((LA8_4>=RULE_INTEGERLITERAL && LA8_4<=RULE_STRING)||(LA8_4>=25 && LA8_4<=28)||(LA8_4>=30 && LA8_4<=35)||LA8_4==38||LA8_4==42||LA8_4==46||(LA8_4>=48 && LA8_4<=50)) ) {
                    alt8=4;
                }
                else if ( (LA8_4==RULE_ID) ) {
                    int LA8_9 = input.LA(3);

                    if ( ((LA8_9>=16 && LA8_9<=29)||(LA8_9>=37 && LA8_9<=38)||LA8_9==40||(LA8_9>=43 && LA8_9<=44)||LA8_9==51) ) {
                        alt8=4;
                    }
                    else if ( (LA8_9==45) ) {
                        alt8=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1399:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );", 8, 9, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1399:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );", 8, 4, input);

                    throw nvae;
                }
                }
                break;
            case 46:
            case 48:
            case 49:
                {
                alt8=6;
                }
                break;
            case 33:
            case 34:
            case 35:
            case 50:
                {
                alt8=7;
                }
                break;
            case 38:
                {
                alt8=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1399:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1404:1: ( ruleLiteral )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1404:1: ( ruleLiteral )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1405:1: ruleLiteral
                    {
                     before(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLiteral_in_rule__ValueSpecification__Alternatives2951);
                    ruleLiteral();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1410:6: ( ruleNameOrChoiceOrBehaviorCall )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1410:6: ( ruleNameOrChoiceOrBehaviorCall )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1411:1: ruleNameOrChoiceOrBehaviorCall
                    {
                     before(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_rule__ValueSpecification__Alternatives2968);
                    ruleNameOrChoiceOrBehaviorCall();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1416:6: ( ruleInterval )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1416:6: ( ruleInterval )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1417:1: ruleInterval
                    {
                     before(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleInterval_in_rule__ValueSpecification__Alternatives2985);
                    ruleInterval();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1422:6: ( ruleCollectionOrTuple )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1422:6: ( ruleCollectionOrTuple )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1423:1: ruleCollectionOrTuple
                    {
                     before(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_rule__ValueSpecification__Alternatives3002);
                    ruleCollectionOrTuple();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1428:6: ( ruleTuple )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1428:6: ( ruleTuple )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1429:1: ruleTuple
                    {
                     before(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleTuple_in_rule__ValueSpecification__Alternatives3019);
                    ruleTuple();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1434:6: ( ruleTimeExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1434:6: ( ruleTimeExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1435:1: ruleTimeExpression
                    {
                     before(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleTimeExpression_in_rule__ValueSpecification__Alternatives3036);
                    ruleTimeExpression();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1440:6: ( ruleVariableDeclaration )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1440:6: ( ruleVariableDeclaration )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1441:1: ruleVariableDeclaration
                    {
                     before(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_rule__ValueSpecification__Alternatives3053);
                    ruleVariableDeclaration();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1446:6: ( ( rule__ValueSpecification__Group_7__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1446:6: ( ( rule__ValueSpecification__Group_7__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1447:1: ( rule__ValueSpecification__Group_7__0 )
                    {
                     before(grammarAccess.getValueSpecificationAccess().getGroup_7()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1448:1: ( rule__ValueSpecification__Group_7__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1448:2: rule__ValueSpecification__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ValueSpecification__Group_7__0_in_rule__ValueSpecification__Alternatives3070);
                    rule__ValueSpecification__Group_7__0();
                    _fsp--;


                    }

                     after(grammarAccess.getValueSpecificationAccess().getGroup_7()); 

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
    // $ANTLR end rule__ValueSpecification__Alternatives


    // $ANTLR start rule__SuffixExpression__Alternatives
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1457:1: rule__SuffixExpression__Alternatives : ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) );
    public final void rule__SuffixExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1461:1: ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==EOF||(LA9_1>=16 && LA9_1<=29)||(LA9_1>=31 && LA9_1<=32)||(LA9_1>=36 && LA9_1<=37)||LA9_1==39||LA9_1==41||(LA9_1>=43 && LA9_1<=44)||LA9_1==51) ) {
                    alt9=1;
                }
                else if ( (LA9_1==38) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1457:1: rule__SuffixExpression__Alternatives : ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) );", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1457:1: rule__SuffixExpression__Alternatives : ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1462:1: ( rulePropertyCallExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1462:1: ( rulePropertyCallExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1463:1: rulePropertyCallExpression
                    {
                     before(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_rule__SuffixExpression__Alternatives3103);
                    rulePropertyCallExpression();
                    _fsp--;

                     after(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1468:6: ( ruleOperationCallExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1468:6: ( ruleOperationCallExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1469:1: ruleOperationCallExpression
                    {
                     before(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_rule__SuffixExpression__Alternatives3120);
                    ruleOperationCallExpression();
                    _fsp--;

                     after(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1()); 

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
    // $ANTLR end rule__SuffixExpression__Alternatives


    // $ANTLR start rule__Literal__Alternatives
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1479:1: rule__Literal__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleDateTimeLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleNullLiteralRule ) | ( ruleDefaultLiteralRule ) | ( ruleStringLiteralRule ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1483:1: ( ( ruleNumberLiteralRule ) | ( ruleDateTimeLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleNullLiteralRule ) | ( ruleDefaultLiteralRule ) | ( ruleStringLiteralRule ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case 27:
                {
                alt10=1;
                }
                break;
            case RULE_DATETIMELITERAL:
                {
                alt10=2;
                }
                break;
            case RULE_BOOLEANLITERAL:
                {
                alt10=3;
                }
                break;
            case RULE_NULLLITERAL:
                {
                alt10=4;
                }
                break;
            case 28:
                {
                alt10=5;
                }
                break;
            case RULE_STRING:
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1479:1: rule__Literal__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleDateTimeLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleNullLiteralRule ) | ( ruleDefaultLiteralRule ) | ( ruleStringLiteralRule ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1484:1: ( ruleNumberLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1484:1: ( ruleNumberLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1485:1: ruleNumberLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_rule__Literal__Alternatives3152);
                    ruleNumberLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1490:6: ( ruleDateTimeLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1490:6: ( ruleDateTimeLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1491:1: ruleDateTimeLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_rule__Literal__Alternatives3169);
                    ruleDateTimeLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1496:6: ( ruleBooleanLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1496:6: ( ruleBooleanLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1497:1: ruleBooleanLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_rule__Literal__Alternatives3186);
                    ruleBooleanLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1502:6: ( ruleNullLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1502:6: ( ruleNullLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1503:1: ruleNullLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_rule__Literal__Alternatives3203);
                    ruleNullLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1508:6: ( ruleDefaultLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1508:6: ( ruleDefaultLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1509:1: ruleDefaultLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_rule__Literal__Alternatives3220);
                    ruleDefaultLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1514:6: ( ruleStringLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1514:6: ( ruleStringLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1515:1: ruleStringLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_rule__Literal__Alternatives3237);
                    ruleStringLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5()); 

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
    // $ANTLR end rule__Literal__Alternatives


    // $ANTLR start rule__Interval__Alternatives_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1525:1: rule__Interval__Alternatives_0 : ( ( ']' ) | ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) ) );
    public final void rule__Interval__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1529:1: ( ( ']' ) | ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            else if ( (LA11_0==32) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1525:1: rule__Interval__Alternatives_0 : ( ( ']' ) | ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) ) );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1530:1: ( ']' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1530:1: ( ']' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1531:1: ']'
                    {
                     before(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0()); 
                    match(input,31,FOLLOW_31_in_rule__Interval__Alternatives_03270); 
                     after(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1538:6: ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1538:6: ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1539:1: ( rule__Interval__IsLowerIncludedAssignment_0_1 )
                    {
                     before(grammarAccess.getIntervalAccess().getIsLowerIncludedAssignment_0_1()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1540:1: ( rule__Interval__IsLowerIncludedAssignment_0_1 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1540:2: rule__Interval__IsLowerIncludedAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__Interval__IsLowerIncludedAssignment_0_1_in_rule__Interval__Alternatives_03289);
                    rule__Interval__IsLowerIncludedAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getIntervalAccess().getIsLowerIncludedAssignment_0_1()); 

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
    // $ANTLR end rule__Interval__Alternatives_0


    // $ANTLR start rule__Interval__Alternatives_4
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1549:1: rule__Interval__Alternatives_4 : ( ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) ) | ( '[' ) );
    public final void rule__Interval__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1553:1: ( ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) ) | ( '[' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==31) ) {
                alt12=1;
            }
            else if ( (LA12_0==32) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1549:1: rule__Interval__Alternatives_4 : ( ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) ) | ( '[' ) );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1554:1: ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1554:1: ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1555:1: ( rule__Interval__IsUpperIncludedAssignment_4_0 )
                    {
                     before(grammarAccess.getIntervalAccess().getIsUpperIncludedAssignment_4_0()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1556:1: ( rule__Interval__IsUpperIncludedAssignment_4_0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1556:2: rule__Interval__IsUpperIncludedAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__Interval__IsUpperIncludedAssignment_4_0_in_rule__Interval__Alternatives_43322);
                    rule__Interval__IsUpperIncludedAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getIntervalAccess().getIsUpperIncludedAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1560:6: ( '[' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1560:6: ( '[' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1561:1: '['
                    {
                     before(grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_4_1()); 
                    match(input,32,FOLLOW_32_in_rule__Interval__Alternatives_43341); 
                     after(grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_4_1()); 

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
    // $ANTLR end rule__Interval__Alternatives_4


    // $ANTLR start rule__TimeExpression__Alternatives
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1573:1: rule__TimeExpression__Alternatives : ( ( ruleInstantObsExpression ) | ( ruleDurationObsExpression ) | ( ruleJitterExp ) );
    public final void rule__TimeExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1577:1: ( ( ruleInstantObsExpression ) | ( ruleDurationObsExpression ) | ( ruleJitterExp ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt13=1;
                }
                break;
            case 48:
                {
                alt13=2;
                }
                break;
            case 49:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1573:1: rule__TimeExpression__Alternatives : ( ( ruleInstantObsExpression ) | ( ruleDurationObsExpression ) | ( ruleJitterExp ) );", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1578:1: ( ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1578:1: ( ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1579:1: ruleInstantObsExpression
                    {
                     before(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_rule__TimeExpression__Alternatives3375);
                    ruleInstantObsExpression();
                    _fsp--;

                     after(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1584:6: ( ruleDurationObsExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1584:6: ( ruleDurationObsExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1585:1: ruleDurationObsExpression
                    {
                     before(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_rule__TimeExpression__Alternatives3392);
                    ruleDurationObsExpression();
                    _fsp--;

                     after(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1590:6: ( ruleJitterExp )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1590:6: ( ruleJitterExp )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1591:1: ruleJitterExp
                    {
                     before(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleJitterExp_in_rule__TimeExpression__Alternatives3409);
                    ruleJitterExp();
                    _fsp--;

                     after(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2()); 

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
    // $ANTLR end rule__TimeExpression__Alternatives


    // $ANTLR start rule__VariableDeclaration__Alternatives_3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1601:1: rule__VariableDeclaration__Alternatives_3 : ( ( ( rule__VariableDeclaration__Group_3_0__0 ) ) | ( ( rule__VariableDeclaration__Group_3_1__0 ) ) );
    public final void rule__VariableDeclaration__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1605:1: ( ( ( rule__VariableDeclaration__Group_3_0__0 ) ) | ( ( rule__VariableDeclaration__Group_3_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==36) ) {
                alt14=1;
            }
            else if ( (LA14_0==45) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1601:1: rule__VariableDeclaration__Alternatives_3 : ( ( ( rule__VariableDeclaration__Group_3_0__0 ) ) | ( ( rule__VariableDeclaration__Group_3_1__0 ) ) );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1606:1: ( ( rule__VariableDeclaration__Group_3_0__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1606:1: ( ( rule__VariableDeclaration__Group_3_0__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1607:1: ( rule__VariableDeclaration__Group_3_0__0 )
                    {
                     before(grammarAccess.getVariableDeclarationAccess().getGroup_3_0()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1608:1: ( rule__VariableDeclaration__Group_3_0__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1608:2: rule__VariableDeclaration__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__0_in_rule__VariableDeclaration__Alternatives_33441);
                    rule__VariableDeclaration__Group_3_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getVariableDeclarationAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1612:6: ( ( rule__VariableDeclaration__Group_3_1__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1612:6: ( ( rule__VariableDeclaration__Group_3_1__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1613:1: ( rule__VariableDeclaration__Group_3_1__0 )
                    {
                     before(grammarAccess.getVariableDeclarationAccess().getGroup_3_1()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1614:1: ( rule__VariableDeclaration__Group_3_1__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1614:2: rule__VariableDeclaration__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__0_in_rule__VariableDeclaration__Alternatives_33459);
                    rule__VariableDeclaration__Group_3_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getVariableDeclarationAccess().getGroup_3_1()); 

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
    // $ANTLR end rule__VariableDeclaration__Alternatives_3


    // $ANTLR start rule__VariableDirectionKind__Alternatives
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1623:1: rule__VariableDirectionKind__Alternatives : ( ( 'in' ) | ( 'out' ) | ( 'inout' ) );
    public final void rule__VariableDirectionKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1627:1: ( ( 'in' ) | ( 'out' ) | ( 'inout' ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt15=1;
                }
                break;
            case 34:
                {
                alt15=2;
                }
                break;
            case 35:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1623:1: rule__VariableDirectionKind__Alternatives : ( ( 'in' ) | ( 'out' ) | ( 'inout' ) );", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1628:1: ( 'in' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1628:1: ( 'in' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1629:1: 'in'
                    {
                     before(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0()); 
                    match(input,33,FOLLOW_33_in_rule__VariableDirectionKind__Alternatives3493); 
                     after(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1636:6: ( 'out' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1636:6: ( 'out' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1637:1: 'out'
                    {
                     before(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1()); 
                    match(input,34,FOLLOW_34_in_rule__VariableDirectionKind__Alternatives3513); 
                     after(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1644:6: ( 'inout' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1644:6: ( 'inout' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1645:1: 'inout'
                    {
                     before(grammarAccess.getVariableDirectionKindAccess().getInoutKeyword_2()); 
                    match(input,35,FOLLOW_35_in_rule__VariableDirectionKind__Alternatives3533); 
                     after(grammarAccess.getVariableDirectionKindAccess().getInoutKeyword_2()); 

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
    // $ANTLR end rule__VariableDirectionKind__Alternatives


    // $ANTLR start rule__NumberLiteralRule__Alternatives
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1657:1: rule__NumberLiteralRule__Alternatives : ( ( ruleIntegerLiteralRule ) | ( ruleUnlimitedLiteralRule ) | ( ruleRealLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1661:1: ( ( ruleIntegerLiteralRule ) | ( ruleUnlimitedLiteralRule ) | ( ruleRealLiteralRule ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_INTEGERLITERAL:
                {
                alt16=1;
                }
                break;
            case 27:
                {
                alt16=2;
                }
                break;
            case RULE_REALLITERAL:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1657:1: rule__NumberLiteralRule__Alternatives : ( ( ruleIntegerLiteralRule ) | ( ruleUnlimitedLiteralRule ) | ( ruleRealLiteralRule ) );", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1662:1: ( ruleIntegerLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1662:1: ( ruleIntegerLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1663:1: ruleIntegerLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_rule__NumberLiteralRule__Alternatives3567);
                    ruleIntegerLiteralRule();
                    _fsp--;

                     after(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1668:6: ( ruleUnlimitedLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1668:6: ( ruleUnlimitedLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1669:1: ruleUnlimitedLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_rule__NumberLiteralRule__Alternatives3584);
                    ruleUnlimitedLiteralRule();
                    _fsp--;

                     after(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1674:6: ( ruleRealLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1674:6: ( ruleRealLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1675:1: ruleRealLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_rule__NumberLiteralRule__Alternatives3601);
                    ruleRealLiteralRule();
                    _fsp--;

                     after(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2()); 

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
    // $ANTLR end rule__NumberLiteralRule__Alternatives


    // $ANTLR start rule__AndOrXorExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1687:1: rule__AndOrXorExpression__Group__0 : rule__AndOrXorExpression__Group__0__Impl rule__AndOrXorExpression__Group__1 ;
    public final void rule__AndOrXorExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1691:1: ( rule__AndOrXorExpression__Group__0__Impl rule__AndOrXorExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1692:2: rule__AndOrXorExpression__Group__0__Impl rule__AndOrXorExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__0__Impl_in_rule__AndOrXorExpression__Group__03631);
            rule__AndOrXorExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__1_in_rule__AndOrXorExpression__Group__03634);
            rule__AndOrXorExpression__Group__1();
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
    // $ANTLR end rule__AndOrXorExpression__Group__0


    // $ANTLR start rule__AndOrXorExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1699:1: rule__AndOrXorExpression__Group__0__Impl : ( ( rule__AndOrXorExpression__ExpAssignment_0 ) ) ;
    public final void rule__AndOrXorExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1703:1: ( ( ( rule__AndOrXorExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1704:1: ( ( rule__AndOrXorExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1704:1: ( ( rule__AndOrXorExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1705:1: ( rule__AndOrXorExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1706:1: ( rule__AndOrXorExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1706:2: rule__AndOrXorExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__ExpAssignment_0_in_rule__AndOrXorExpression__Group__0__Impl3661);
            rule__AndOrXorExpression__ExpAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAndOrXorExpressionAccess().getExpAssignment_0()); 

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
    // $ANTLR end rule__AndOrXorExpression__Group__0__Impl


    // $ANTLR start rule__AndOrXorExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1716:1: rule__AndOrXorExpression__Group__1 : rule__AndOrXorExpression__Group__1__Impl ;
    public final void rule__AndOrXorExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1720:1: ( rule__AndOrXorExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1721:2: rule__AndOrXorExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__1__Impl_in_rule__AndOrXorExpression__Group__13691);
            rule__AndOrXorExpression__Group__1__Impl();
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
    // $ANTLR end rule__AndOrXorExpression__Group__1


    // $ANTLR start rule__AndOrXorExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1727:1: rule__AndOrXorExpression__Group__1__Impl : ( ( rule__AndOrXorExpression__Group_1__0 )* ) ;
    public final void rule__AndOrXorExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1731:1: ( ( ( rule__AndOrXorExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1732:1: ( ( rule__AndOrXorExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1732:1: ( ( rule__AndOrXorExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1733:1: ( rule__AndOrXorExpression__Group_1__0 )*
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1734:1: ( rule__AndOrXorExpression__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=16 && LA17_0<=18)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1734:2: rule__AndOrXorExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__0_in_rule__AndOrXorExpression__Group__1__Impl3718);
            	    rule__AndOrXorExpression__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getAndOrXorExpressionAccess().getGroup_1()); 

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
    // $ANTLR end rule__AndOrXorExpression__Group__1__Impl


    // $ANTLR start rule__AndOrXorExpression__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1748:1: rule__AndOrXorExpression__Group_1__0 : rule__AndOrXorExpression__Group_1__0__Impl rule__AndOrXorExpression__Group_1__1 ;
    public final void rule__AndOrXorExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1752:1: ( rule__AndOrXorExpression__Group_1__0__Impl rule__AndOrXorExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1753:2: rule__AndOrXorExpression__Group_1__0__Impl rule__AndOrXorExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__0__Impl_in_rule__AndOrXorExpression__Group_1__03753);
            rule__AndOrXorExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__1_in_rule__AndOrXorExpression__Group_1__03756);
            rule__AndOrXorExpression__Group_1__1();
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
    // $ANTLR end rule__AndOrXorExpression__Group_1__0


    // $ANTLR start rule__AndOrXorExpression__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1760:1: rule__AndOrXorExpression__Group_1__0__Impl : ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) ) ;
    public final void rule__AndOrXorExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1764:1: ( ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1765:1: ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1765:1: ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1766:1: ( rule__AndOrXorExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1767:1: ( rule__AndOrXorExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1767:2: rule__AndOrXorExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__OpAssignment_1_0_in_rule__AndOrXorExpression__Group_1__0__Impl3783);
            rule__AndOrXorExpression__OpAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getAndOrXorExpressionAccess().getOpAssignment_1_0()); 

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
    // $ANTLR end rule__AndOrXorExpression__Group_1__0__Impl


    // $ANTLR start rule__AndOrXorExpression__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1777:1: rule__AndOrXorExpression__Group_1__1 : rule__AndOrXorExpression__Group_1__1__Impl ;
    public final void rule__AndOrXorExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1781:1: ( rule__AndOrXorExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1782:2: rule__AndOrXorExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__1__Impl_in_rule__AndOrXorExpression__Group_1__13813);
            rule__AndOrXorExpression__Group_1__1__Impl();
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
    // $ANTLR end rule__AndOrXorExpression__Group_1__1


    // $ANTLR start rule__AndOrXorExpression__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1788:1: rule__AndOrXorExpression__Group_1__1__Impl : ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__AndOrXorExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1792:1: ( ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1793:1: ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1793:1: ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1794:1: ( rule__AndOrXorExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1795:1: ( rule__AndOrXorExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1795:2: rule__AndOrXorExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__ExpAssignment_1_1_in_rule__AndOrXorExpression__Group_1__1__Impl3840);
            rule__AndOrXorExpression__ExpAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getAndOrXorExpressionAccess().getExpAssignment_1_1()); 

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
    // $ANTLR end rule__AndOrXorExpression__Group_1__1__Impl


    // $ANTLR start rule__EqualityExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1809:1: rule__EqualityExpression__Group__0 : rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 ;
    public final void rule__EqualityExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1813:1: ( rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1814:2: rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__0__Impl_in_rule__EqualityExpression__Group__03874);
            rule__EqualityExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EqualityExpression__Group__1_in_rule__EqualityExpression__Group__03877);
            rule__EqualityExpression__Group__1();
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
    // $ANTLR end rule__EqualityExpression__Group__0


    // $ANTLR start rule__EqualityExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1821:1: rule__EqualityExpression__Group__0__Impl : ( ( rule__EqualityExpression__ExpAssignment_0 ) ) ;
    public final void rule__EqualityExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1825:1: ( ( ( rule__EqualityExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1826:1: ( ( rule__EqualityExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1826:1: ( ( rule__EqualityExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1827:1: ( rule__EqualityExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1828:1: ( rule__EqualityExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1828:2: rule__EqualityExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__ExpAssignment_0_in_rule__EqualityExpression__Group__0__Impl3904);
            rule__EqualityExpression__ExpAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getEqualityExpressionAccess().getExpAssignment_0()); 

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
    // $ANTLR end rule__EqualityExpression__Group__0__Impl


    // $ANTLR start rule__EqualityExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1838:1: rule__EqualityExpression__Group__1 : rule__EqualityExpression__Group__1__Impl ;
    public final void rule__EqualityExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1842:1: ( rule__EqualityExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1843:2: rule__EqualityExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__1__Impl_in_rule__EqualityExpression__Group__13934);
            rule__EqualityExpression__Group__1__Impl();
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
    // $ANTLR end rule__EqualityExpression__Group__1


    // $ANTLR start rule__EqualityExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1849:1: rule__EqualityExpression__Group__1__Impl : ( ( rule__EqualityExpression__Group_1__0 )* ) ;
    public final void rule__EqualityExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1853:1: ( ( ( rule__EqualityExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1854:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1854:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1855:1: ( rule__EqualityExpression__Group_1__0 )*
            {
             before(grammarAccess.getEqualityExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1856:1: ( rule__EqualityExpression__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=19 && LA18_0<=20)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1856:2: rule__EqualityExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__EqualityExpression__Group_1__0_in_rule__EqualityExpression__Group__1__Impl3961);
            	    rule__EqualityExpression__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getEqualityExpressionAccess().getGroup_1()); 

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
    // $ANTLR end rule__EqualityExpression__Group__1__Impl


    // $ANTLR start rule__EqualityExpression__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1870:1: rule__EqualityExpression__Group_1__0 : rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 ;
    public final void rule__EqualityExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1874:1: ( rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1875:2: rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group_1__0__Impl_in_rule__EqualityExpression__Group_1__03996);
            rule__EqualityExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EqualityExpression__Group_1__1_in_rule__EqualityExpression__Group_1__03999);
            rule__EqualityExpression__Group_1__1();
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
    // $ANTLR end rule__EqualityExpression__Group_1__0


    // $ANTLR start rule__EqualityExpression__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1882:1: rule__EqualityExpression__Group_1__0__Impl : ( ( rule__EqualityExpression__OpAssignment_1_0 ) ) ;
    public final void rule__EqualityExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1886:1: ( ( ( rule__EqualityExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1887:1: ( ( rule__EqualityExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1887:1: ( ( rule__EqualityExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1888:1: ( rule__EqualityExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1889:1: ( rule__EqualityExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1889:2: rule__EqualityExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__OpAssignment_1_0_in_rule__EqualityExpression__Group_1__0__Impl4026);
            rule__EqualityExpression__OpAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getEqualityExpressionAccess().getOpAssignment_1_0()); 

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
    // $ANTLR end rule__EqualityExpression__Group_1__0__Impl


    // $ANTLR start rule__EqualityExpression__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1899:1: rule__EqualityExpression__Group_1__1 : rule__EqualityExpression__Group_1__1__Impl ;
    public final void rule__EqualityExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1903:1: ( rule__EqualityExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1904:2: rule__EqualityExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group_1__1__Impl_in_rule__EqualityExpression__Group_1__14056);
            rule__EqualityExpression__Group_1__1__Impl();
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
    // $ANTLR end rule__EqualityExpression__Group_1__1


    // $ANTLR start rule__EqualityExpression__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1910:1: rule__EqualityExpression__Group_1__1__Impl : ( ( rule__EqualityExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__EqualityExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1914:1: ( ( ( rule__EqualityExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1915:1: ( ( rule__EqualityExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1915:1: ( ( rule__EqualityExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1916:1: ( rule__EqualityExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1917:1: ( rule__EqualityExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1917:2: rule__EqualityExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__ExpAssignment_1_1_in_rule__EqualityExpression__Group_1__1__Impl4083);
            rule__EqualityExpression__ExpAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getEqualityExpressionAccess().getExpAssignment_1_1()); 

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
    // $ANTLR end rule__EqualityExpression__Group_1__1__Impl


    // $ANTLR start rule__RelationalExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1931:1: rule__RelationalExpression__Group__0 : rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 ;
    public final void rule__RelationalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1935:1: ( rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1936:2: rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__0__Impl_in_rule__RelationalExpression__Group__04117);
            rule__RelationalExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__RelationalExpression__Group__1_in_rule__RelationalExpression__Group__04120);
            rule__RelationalExpression__Group__1();
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
    // $ANTLR end rule__RelationalExpression__Group__0


    // $ANTLR start rule__RelationalExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1943:1: rule__RelationalExpression__Group__0__Impl : ( ( rule__RelationalExpression__ExpAssignment_0 ) ) ;
    public final void rule__RelationalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1947:1: ( ( ( rule__RelationalExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1948:1: ( ( rule__RelationalExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1948:1: ( ( rule__RelationalExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1949:1: ( rule__RelationalExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1950:1: ( rule__RelationalExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1950:2: rule__RelationalExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__ExpAssignment_0_in_rule__RelationalExpression__Group__0__Impl4147);
            rule__RelationalExpression__ExpAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getExpAssignment_0()); 

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
    // $ANTLR end rule__RelationalExpression__Group__0__Impl


    // $ANTLR start rule__RelationalExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1960:1: rule__RelationalExpression__Group__1 : rule__RelationalExpression__Group__1__Impl ;
    public final void rule__RelationalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1964:1: ( rule__RelationalExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1965:2: rule__RelationalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__1__Impl_in_rule__RelationalExpression__Group__14177);
            rule__RelationalExpression__Group__1__Impl();
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
    // $ANTLR end rule__RelationalExpression__Group__1


    // $ANTLR start rule__RelationalExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1971:1: rule__RelationalExpression__Group__1__Impl : ( ( rule__RelationalExpression__Group_1__0 )* ) ;
    public final void rule__RelationalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1975:1: ( ( ( rule__RelationalExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1976:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1976:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1977:1: ( rule__RelationalExpression__Group_1__0 )*
            {
             before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1978:1: ( rule__RelationalExpression__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=21 && LA19_0<=24)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1978:2: rule__RelationalExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__RelationalExpression__Group_1__0_in_rule__RelationalExpression__Group__1__Impl4204);
            	    rule__RelationalExpression__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getRelationalExpressionAccess().getGroup_1()); 

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
    // $ANTLR end rule__RelationalExpression__Group__1__Impl


    // $ANTLR start rule__RelationalExpression__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1992:1: rule__RelationalExpression__Group_1__0 : rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 ;
    public final void rule__RelationalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1996:1: ( rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1997:2: rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group_1__0__Impl_in_rule__RelationalExpression__Group_1__04239);
            rule__RelationalExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__RelationalExpression__Group_1__1_in_rule__RelationalExpression__Group_1__04242);
            rule__RelationalExpression__Group_1__1();
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
    // $ANTLR end rule__RelationalExpression__Group_1__0


    // $ANTLR start rule__RelationalExpression__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2004:1: rule__RelationalExpression__Group_1__0__Impl : ( ( rule__RelationalExpression__OpAssignment_1_0 ) ) ;
    public final void rule__RelationalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2008:1: ( ( ( rule__RelationalExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2009:1: ( ( rule__RelationalExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2009:1: ( ( rule__RelationalExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2010:1: ( rule__RelationalExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2011:1: ( rule__RelationalExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2011:2: rule__RelationalExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__OpAssignment_1_0_in_rule__RelationalExpression__Group_1__0__Impl4269);
            rule__RelationalExpression__OpAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0()); 

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
    // $ANTLR end rule__RelationalExpression__Group_1__0__Impl


    // $ANTLR start rule__RelationalExpression__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2021:1: rule__RelationalExpression__Group_1__1 : rule__RelationalExpression__Group_1__1__Impl ;
    public final void rule__RelationalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2025:1: ( rule__RelationalExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2026:2: rule__RelationalExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group_1__1__Impl_in_rule__RelationalExpression__Group_1__14299);
            rule__RelationalExpression__Group_1__1__Impl();
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
    // $ANTLR end rule__RelationalExpression__Group_1__1


    // $ANTLR start rule__RelationalExpression__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2032:1: rule__RelationalExpression__Group_1__1__Impl : ( ( rule__RelationalExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__RelationalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2036:1: ( ( ( rule__RelationalExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2037:1: ( ( rule__RelationalExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2037:1: ( ( rule__RelationalExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2038:1: ( rule__RelationalExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2039:1: ( rule__RelationalExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2039:2: rule__RelationalExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__ExpAssignment_1_1_in_rule__RelationalExpression__Group_1__1__Impl4326);
            rule__RelationalExpression__ExpAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getExpAssignment_1_1()); 

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
    // $ANTLR end rule__RelationalExpression__Group_1__1__Impl


    // $ANTLR start rule__ConditionalExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2053:1: rule__ConditionalExpression__Group__0 : rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 ;
    public final void rule__ConditionalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2057:1: ( rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2058:2: rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__04360);
            rule__ConditionalExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1_in_rule__ConditionalExpression__Group__04363);
            rule__ConditionalExpression__Group__1();
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
    // $ANTLR end rule__ConditionalExpression__Group__0


    // $ANTLR start rule__ConditionalExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2065:1: rule__ConditionalExpression__Group__0__Impl : ( ( rule__ConditionalExpression__ExpAssignment_0 ) ) ;
    public final void rule__ConditionalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2069:1: ( ( ( rule__ConditionalExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2070:1: ( ( rule__ConditionalExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2070:1: ( ( rule__ConditionalExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2071:1: ( rule__ConditionalExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2072:1: ( rule__ConditionalExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2072:2: rule__ConditionalExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__ExpAssignment_0_in_rule__ConditionalExpression__Group__0__Impl4390);
            rule__ConditionalExpression__ExpAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getConditionalExpressionAccess().getExpAssignment_0()); 

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
    // $ANTLR end rule__ConditionalExpression__Group__0__Impl


    // $ANTLR start rule__ConditionalExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2082:1: rule__ConditionalExpression__Group__1 : rule__ConditionalExpression__Group__1__Impl ;
    public final void rule__ConditionalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2086:1: ( rule__ConditionalExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2087:2: rule__ConditionalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1__Impl_in_rule__ConditionalExpression__Group__14420);
            rule__ConditionalExpression__Group__1__Impl();
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
    // $ANTLR end rule__ConditionalExpression__Group__1


    // $ANTLR start rule__ConditionalExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2093:1: rule__ConditionalExpression__Group__1__Impl : ( ( rule__ConditionalExpression__Group_1__0 )? ) ;
    public final void rule__ConditionalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2097:1: ( ( ( rule__ConditionalExpression__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2098:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2098:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2099:1: ( rule__ConditionalExpression__Group_1__0 )?
            {
             before(grammarAccess.getConditionalExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2100:1: ( rule__ConditionalExpression__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==51) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2100:2: rule__ConditionalExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0_in_rule__ConditionalExpression__Group__1__Impl4447);
                    rule__ConditionalExpression__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConditionalExpressionAccess().getGroup_1()); 

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
    // $ANTLR end rule__ConditionalExpression__Group__1__Impl


    // $ANTLR start rule__ConditionalExpression__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2114:1: rule__ConditionalExpression__Group_1__0 : rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 ;
    public final void rule__ConditionalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2118:1: ( rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2119:2: rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0__Impl_in_rule__ConditionalExpression__Group_1__04482);
            rule__ConditionalExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1_in_rule__ConditionalExpression__Group_1__04485);
            rule__ConditionalExpression__Group_1__1();
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
    // $ANTLR end rule__ConditionalExpression__Group_1__0


    // $ANTLR start rule__ConditionalExpression__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2126:1: rule__ConditionalExpression__Group_1__0__Impl : ( ( rule__ConditionalExpression__OpAssignment_1_0 ) ) ;
    public final void rule__ConditionalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2130:1: ( ( ( rule__ConditionalExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2131:1: ( ( rule__ConditionalExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2131:1: ( ( rule__ConditionalExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2132:1: ( rule__ConditionalExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2133:1: ( rule__ConditionalExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2133:2: rule__ConditionalExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__OpAssignment_1_0_in_rule__ConditionalExpression__Group_1__0__Impl4512);
            rule__ConditionalExpression__OpAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getConditionalExpressionAccess().getOpAssignment_1_0()); 

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
    // $ANTLR end rule__ConditionalExpression__Group_1__0__Impl


    // $ANTLR start rule__ConditionalExpression__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2143:1: rule__ConditionalExpression__Group_1__1 : rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 ;
    public final void rule__ConditionalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2147:1: ( rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2148:2: rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1__Impl_in_rule__ConditionalExpression__Group_1__14542);
            rule__ConditionalExpression__Group_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2_in_rule__ConditionalExpression__Group_1__14545);
            rule__ConditionalExpression__Group_1__2();
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
    // $ANTLR end rule__ConditionalExpression__Group_1__1


    // $ANTLR start rule__ConditionalExpression__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2155:1: rule__ConditionalExpression__Group_1__1__Impl : ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__ConditionalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2159:1: ( ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2160:1: ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2160:1: ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2161:1: ( rule__ConditionalExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2162:1: ( rule__ConditionalExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2162:2: rule__ConditionalExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__ExpAssignment_1_1_in_rule__ConditionalExpression__Group_1__1__Impl4572);
            rule__ConditionalExpression__ExpAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getConditionalExpressionAccess().getExpAssignment_1_1()); 

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
    // $ANTLR end rule__ConditionalExpression__Group_1__1__Impl


    // $ANTLR start rule__ConditionalExpression__Group_1__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2172:1: rule__ConditionalExpression__Group_1__2 : rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 ;
    public final void rule__ConditionalExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2176:1: ( rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2177:2: rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2__Impl_in_rule__ConditionalExpression__Group_1__24602);
            rule__ConditionalExpression__Group_1__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3_in_rule__ConditionalExpression__Group_1__24605);
            rule__ConditionalExpression__Group_1__3();
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
    // $ANTLR end rule__ConditionalExpression__Group_1__2


    // $ANTLR start rule__ConditionalExpression__Group_1__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2184:1: rule__ConditionalExpression__Group_1__2__Impl : ( ':' ) ;
    public final void rule__ConditionalExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2188:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2189:1: ( ':' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2189:1: ( ':' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2190:1: ':'
            {
             before(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2()); 
            match(input,36,FOLLOW_36_in_rule__ConditionalExpression__Group_1__2__Impl4633); 
             after(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2()); 

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
    // $ANTLR end rule__ConditionalExpression__Group_1__2__Impl


    // $ANTLR start rule__ConditionalExpression__Group_1__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2203:1: rule__ConditionalExpression__Group_1__3 : rule__ConditionalExpression__Group_1__3__Impl ;
    public final void rule__ConditionalExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2207:1: ( rule__ConditionalExpression__Group_1__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2208:2: rule__ConditionalExpression__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3__Impl_in_rule__ConditionalExpression__Group_1__34664);
            rule__ConditionalExpression__Group_1__3__Impl();
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
    // $ANTLR end rule__ConditionalExpression__Group_1__3


    // $ANTLR start rule__ConditionalExpression__Group_1__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2214:1: rule__ConditionalExpression__Group_1__3__Impl : ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) ) ;
    public final void rule__ConditionalExpression__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2218:1: ( ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2219:1: ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2219:1: ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2220:1: ( rule__ConditionalExpression__ExpAssignment_1_3 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAssignment_1_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2221:1: ( rule__ConditionalExpression__ExpAssignment_1_3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2221:2: rule__ConditionalExpression__ExpAssignment_1_3
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__ExpAssignment_1_3_in_rule__ConditionalExpression__Group_1__3__Impl4691);
            rule__ConditionalExpression__ExpAssignment_1_3();
            _fsp--;


            }

             after(grammarAccess.getConditionalExpressionAccess().getExpAssignment_1_3()); 

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
    // $ANTLR end rule__ConditionalExpression__Group_1__3__Impl


    // $ANTLR start rule__AdditiveExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2239:1: rule__AdditiveExpression__Group__0 : rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 ;
    public final void rule__AdditiveExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2243:1: ( rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2244:2: rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__0__Impl_in_rule__AdditiveExpression__Group__04729);
            rule__AdditiveExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AdditiveExpression__Group__1_in_rule__AdditiveExpression__Group__04732);
            rule__AdditiveExpression__Group__1();
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
    // $ANTLR end rule__AdditiveExpression__Group__0


    // $ANTLR start rule__AdditiveExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2251:1: rule__AdditiveExpression__Group__0__Impl : ( ( rule__AdditiveExpression__ExpAssignment_0 ) ) ;
    public final void rule__AdditiveExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2255:1: ( ( ( rule__AdditiveExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2256:1: ( ( rule__AdditiveExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2256:1: ( ( rule__AdditiveExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2257:1: ( rule__AdditiveExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2258:1: ( rule__AdditiveExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2258:2: rule__AdditiveExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__ExpAssignment_0_in_rule__AdditiveExpression__Group__0__Impl4759);
            rule__AdditiveExpression__ExpAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_0()); 

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
    // $ANTLR end rule__AdditiveExpression__Group__0__Impl


    // $ANTLR start rule__AdditiveExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2268:1: rule__AdditiveExpression__Group__1 : rule__AdditiveExpression__Group__1__Impl ;
    public final void rule__AdditiveExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2272:1: ( rule__AdditiveExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2273:2: rule__AdditiveExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__1__Impl_in_rule__AdditiveExpression__Group__14789);
            rule__AdditiveExpression__Group__1__Impl();
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
    // $ANTLR end rule__AdditiveExpression__Group__1


    // $ANTLR start rule__AdditiveExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2279:1: rule__AdditiveExpression__Group__1__Impl : ( ( rule__AdditiveExpression__Group_1__0 )* ) ;
    public final void rule__AdditiveExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2283:1: ( ( ( rule__AdditiveExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2284:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2284:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2285:1: ( rule__AdditiveExpression__Group_1__0 )*
            {
             before(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2286:1: ( rule__AdditiveExpression__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=25 && LA21_0<=26)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2286:2: rule__AdditiveExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__0_in_rule__AdditiveExpression__Group__1__Impl4816);
            	    rule__AdditiveExpression__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); 

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
    // $ANTLR end rule__AdditiveExpression__Group__1__Impl


    // $ANTLR start rule__AdditiveExpression__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2300:1: rule__AdditiveExpression__Group_1__0 : rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 ;
    public final void rule__AdditiveExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2304:1: ( rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2305:2: rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__0__Impl_in_rule__AdditiveExpression__Group_1__04851);
            rule__AdditiveExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__1_in_rule__AdditiveExpression__Group_1__04854);
            rule__AdditiveExpression__Group_1__1();
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
    // $ANTLR end rule__AdditiveExpression__Group_1__0


    // $ANTLR start rule__AdditiveExpression__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2312:1: rule__AdditiveExpression__Group_1__0__Impl : ( ( rule__AdditiveExpression__OpAssignment_1_0 ) ) ;
    public final void rule__AdditiveExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2316:1: ( ( ( rule__AdditiveExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2317:1: ( ( rule__AdditiveExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2317:1: ( ( rule__AdditiveExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2318:1: ( rule__AdditiveExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2319:1: ( rule__AdditiveExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2319:2: rule__AdditiveExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__OpAssignment_1_0_in_rule__AdditiveExpression__Group_1__0__Impl4881);
            rule__AdditiveExpression__OpAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_0()); 

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
    // $ANTLR end rule__AdditiveExpression__Group_1__0__Impl


    // $ANTLR start rule__AdditiveExpression__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2329:1: rule__AdditiveExpression__Group_1__1 : rule__AdditiveExpression__Group_1__1__Impl ;
    public final void rule__AdditiveExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2333:1: ( rule__AdditiveExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2334:2: rule__AdditiveExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__1__Impl_in_rule__AdditiveExpression__Group_1__14911);
            rule__AdditiveExpression__Group_1__1__Impl();
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
    // $ANTLR end rule__AdditiveExpression__Group_1__1


    // $ANTLR start rule__AdditiveExpression__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2340:1: rule__AdditiveExpression__Group_1__1__Impl : ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__AdditiveExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2344:1: ( ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2345:1: ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2345:1: ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2346:1: ( rule__AdditiveExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2347:1: ( rule__AdditiveExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2347:2: rule__AdditiveExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__ExpAssignment_1_1_in_rule__AdditiveExpression__Group_1__1__Impl4938);
            rule__AdditiveExpression__ExpAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_1_1()); 

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
    // $ANTLR end rule__AdditiveExpression__Group_1__1__Impl


    // $ANTLR start rule__MultiplicativeExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2361:1: rule__MultiplicativeExpression__Group__0 : rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 ;
    public final void rule__MultiplicativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2365:1: ( rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2366:2: rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__0__Impl_in_rule__MultiplicativeExpression__Group__04972);
            rule__MultiplicativeExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__1_in_rule__MultiplicativeExpression__Group__04975);
            rule__MultiplicativeExpression__Group__1();
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
    // $ANTLR end rule__MultiplicativeExpression__Group__0


    // $ANTLR start rule__MultiplicativeExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2373:1: rule__MultiplicativeExpression__Group__0__Impl : ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) ) ;
    public final void rule__MultiplicativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2377:1: ( ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2378:1: ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2378:1: ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2379:1: ( rule__MultiplicativeExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2380:1: ( rule__MultiplicativeExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2380:2: rule__MultiplicativeExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__ExpAssignment_0_in_rule__MultiplicativeExpression__Group__0__Impl5002);
            rule__MultiplicativeExpression__ExpAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_0()); 

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
    // $ANTLR end rule__MultiplicativeExpression__Group__0__Impl


    // $ANTLR start rule__MultiplicativeExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2390:1: rule__MultiplicativeExpression__Group__1 : rule__MultiplicativeExpression__Group__1__Impl ;
    public final void rule__MultiplicativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2394:1: ( rule__MultiplicativeExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2395:2: rule__MultiplicativeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__1__Impl_in_rule__MultiplicativeExpression__Group__15032);
            rule__MultiplicativeExpression__Group__1__Impl();
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
    // $ANTLR end rule__MultiplicativeExpression__Group__1


    // $ANTLR start rule__MultiplicativeExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2401:1: rule__MultiplicativeExpression__Group__1__Impl : ( ( rule__MultiplicativeExpression__Group_1__0 )* ) ;
    public final void rule__MultiplicativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2405:1: ( ( ( rule__MultiplicativeExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2406:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2406:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2407:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2408:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=27 && LA22_0<=29)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2408:2: rule__MultiplicativeExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__0_in_rule__MultiplicativeExpression__Group__1__Impl5059);
            	    rule__MultiplicativeExpression__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1()); 

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
    // $ANTLR end rule__MultiplicativeExpression__Group__1__Impl


    // $ANTLR start rule__MultiplicativeExpression__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2422:1: rule__MultiplicativeExpression__Group_1__0 : rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 ;
    public final void rule__MultiplicativeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2426:1: ( rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2427:2: rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__0__Impl_in_rule__MultiplicativeExpression__Group_1__05094);
            rule__MultiplicativeExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__1_in_rule__MultiplicativeExpression__Group_1__05097);
            rule__MultiplicativeExpression__Group_1__1();
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
    // $ANTLR end rule__MultiplicativeExpression__Group_1__0


    // $ANTLR start rule__MultiplicativeExpression__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2434:1: rule__MultiplicativeExpression__Group_1__0__Impl : ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2438:1: ( ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2439:1: ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2439:1: ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2440:1: ( rule__MultiplicativeExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2441:1: ( rule__MultiplicativeExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2441:2: rule__MultiplicativeExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__OpAssignment_1_0_in_rule__MultiplicativeExpression__Group_1__0__Impl5124);
            rule__MultiplicativeExpression__OpAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_0()); 

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
    // $ANTLR end rule__MultiplicativeExpression__Group_1__0__Impl


    // $ANTLR start rule__MultiplicativeExpression__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2451:1: rule__MultiplicativeExpression__Group_1__1 : rule__MultiplicativeExpression__Group_1__1__Impl ;
    public final void rule__MultiplicativeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2455:1: ( rule__MultiplicativeExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2456:2: rule__MultiplicativeExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__1__Impl_in_rule__MultiplicativeExpression__Group_1__15154);
            rule__MultiplicativeExpression__Group_1__1__Impl();
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
    // $ANTLR end rule__MultiplicativeExpression__Group_1__1


    // $ANTLR start rule__MultiplicativeExpression__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2462:1: rule__MultiplicativeExpression__Group_1__1__Impl : ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2466:1: ( ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2467:1: ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2467:1: ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2468:1: ( rule__MultiplicativeExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2469:1: ( rule__MultiplicativeExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2469:2: rule__MultiplicativeExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__ExpAssignment_1_1_in_rule__MultiplicativeExpression__Group_1__1__Impl5181);
            rule__MultiplicativeExpression__ExpAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_1_1()); 

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
    // $ANTLR end rule__MultiplicativeExpression__Group_1__1__Impl


    // $ANTLR start rule__UnaryExpression__Group_0__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2483:1: rule__UnaryExpression__Group_0__0 : rule__UnaryExpression__Group_0__0__Impl rule__UnaryExpression__Group_0__1 ;
    public final void rule__UnaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2487:1: ( rule__UnaryExpression__Group_0__0__Impl rule__UnaryExpression__Group_0__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2488:2: rule__UnaryExpression__Group_0__0__Impl rule__UnaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Group_0__0__Impl_in_rule__UnaryExpression__Group_0__05215);
            rule__UnaryExpression__Group_0__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__UnaryExpression__Group_0__1_in_rule__UnaryExpression__Group_0__05218);
            rule__UnaryExpression__Group_0__1();
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
    // $ANTLR end rule__UnaryExpression__Group_0__0


    // $ANTLR start rule__UnaryExpression__Group_0__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2495:1: rule__UnaryExpression__Group_0__0__Impl : ( ( rule__UnaryExpression__OpAssignment_0_0 ) ) ;
    public final void rule__UnaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2499:1: ( ( ( rule__UnaryExpression__OpAssignment_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2500:1: ( ( rule__UnaryExpression__OpAssignment_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2500:1: ( ( rule__UnaryExpression__OpAssignment_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2501:1: ( rule__UnaryExpression__OpAssignment_0_0 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2502:1: ( rule__UnaryExpression__OpAssignment_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2502:2: rule__UnaryExpression__OpAssignment_0_0
            {
            pushFollow(FOLLOW_rule__UnaryExpression__OpAssignment_0_0_in_rule__UnaryExpression__Group_0__0__Impl5245);
            rule__UnaryExpression__OpAssignment_0_0();
            _fsp--;


            }

             after(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0_0()); 

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
    // $ANTLR end rule__UnaryExpression__Group_0__0__Impl


    // $ANTLR start rule__UnaryExpression__Group_0__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2512:1: rule__UnaryExpression__Group_0__1 : rule__UnaryExpression__Group_0__1__Impl ;
    public final void rule__UnaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2516:1: ( rule__UnaryExpression__Group_0__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2517:2: rule__UnaryExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Group_0__1__Impl_in_rule__UnaryExpression__Group_0__15275);
            rule__UnaryExpression__Group_0__1__Impl();
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
    // $ANTLR end rule__UnaryExpression__Group_0__1


    // $ANTLR start rule__UnaryExpression__Group_0__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2523:1: rule__UnaryExpression__Group_0__1__Impl : ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) ) ;
    public final void rule__UnaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2527:1: ( ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2528:1: ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2528:1: ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2529:1: ( rule__UnaryExpression__UnaryAssignment_0_1 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getUnaryAssignment_0_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2530:1: ( rule__UnaryExpression__UnaryAssignment_0_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2530:2: rule__UnaryExpression__UnaryAssignment_0_1
            {
            pushFollow(FOLLOW_rule__UnaryExpression__UnaryAssignment_0_1_in_rule__UnaryExpression__Group_0__1__Impl5302);
            rule__UnaryExpression__UnaryAssignment_0_1();
            _fsp--;


            }

             after(grammarAccess.getUnaryExpressionAccess().getUnaryAssignment_0_1()); 

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
    // $ANTLR end rule__UnaryExpression__Group_0__1__Impl


    // $ANTLR start rule__PrimaryExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2544:1: rule__PrimaryExpression__Group__0 : rule__PrimaryExpression__Group__0__Impl rule__PrimaryExpression__Group__1 ;
    public final void rule__PrimaryExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2548:1: ( rule__PrimaryExpression__Group__0__Impl rule__PrimaryExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2549:2: rule__PrimaryExpression__Group__0__Impl rule__PrimaryExpression__Group__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group__0__Impl_in_rule__PrimaryExpression__Group__05336);
            rule__PrimaryExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group__1_in_rule__PrimaryExpression__Group__05339);
            rule__PrimaryExpression__Group__1();
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
    // $ANTLR end rule__PrimaryExpression__Group__0


    // $ANTLR start rule__PrimaryExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2556:1: rule__PrimaryExpression__Group__0__Impl : ( ( rule__PrimaryExpression__PrefixAssignment_0 ) ) ;
    public final void rule__PrimaryExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2560:1: ( ( ( rule__PrimaryExpression__PrefixAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2561:1: ( ( rule__PrimaryExpression__PrefixAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2561:1: ( ( rule__PrimaryExpression__PrefixAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2562:1: ( rule__PrimaryExpression__PrefixAssignment_0 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrefixAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2563:1: ( rule__PrimaryExpression__PrefixAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2563:2: rule__PrimaryExpression__PrefixAssignment_0
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__PrefixAssignment_0_in_rule__PrimaryExpression__Group__0__Impl5366);
            rule__PrimaryExpression__PrefixAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getPrefixAssignment_0()); 

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
    // $ANTLR end rule__PrimaryExpression__Group__0__Impl


    // $ANTLR start rule__PrimaryExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2573:1: rule__PrimaryExpression__Group__1 : rule__PrimaryExpression__Group__1__Impl ;
    public final void rule__PrimaryExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2577:1: ( rule__PrimaryExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2578:2: rule__PrimaryExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group__1__Impl_in_rule__PrimaryExpression__Group__15396);
            rule__PrimaryExpression__Group__1__Impl();
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
    // $ANTLR end rule__PrimaryExpression__Group__1


    // $ANTLR start rule__PrimaryExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2584:1: rule__PrimaryExpression__Group__1__Impl : ( ( rule__PrimaryExpression__Group_1__0 )? ) ;
    public final void rule__PrimaryExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2588:1: ( ( ( rule__PrimaryExpression__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2589:1: ( ( rule__PrimaryExpression__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2589:1: ( ( rule__PrimaryExpression__Group_1__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2590:1: ( rule__PrimaryExpression__Group_1__0 )?
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2591:1: ( rule__PrimaryExpression__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==37) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2591:2: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Group__1__Impl5423);
                    rule__PrimaryExpression__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 

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
    // $ANTLR end rule__PrimaryExpression__Group__1__Impl


    // $ANTLR start rule__PrimaryExpression__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2605:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2609:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2610:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__05458);
            rule__PrimaryExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__05461);
            rule__PrimaryExpression__Group_1__1();
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
    // $ANTLR end rule__PrimaryExpression__Group_1__0


    // $ANTLR start rule__PrimaryExpression__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2617:1: rule__PrimaryExpression__Group_1__0__Impl : ( '.' ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2621:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2622:1: ( '.' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2622:1: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2623:1: '.'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0()); 
            match(input,37,FOLLOW_37_in_rule__PrimaryExpression__Group_1__0__Impl5489); 
             after(grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end rule__PrimaryExpression__Group_1__0__Impl


    // $ANTLR start rule__PrimaryExpression__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2636:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2640:1: ( rule__PrimaryExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2641:2: rule__PrimaryExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__15520);
            rule__PrimaryExpression__Group_1__1__Impl();
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
    // $ANTLR end rule__PrimaryExpression__Group_1__1


    // $ANTLR start rule__PrimaryExpression__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2647:1: rule__PrimaryExpression__Group_1__1__Impl : ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2651:1: ( ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2652:1: ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2652:1: ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2653:1: ( rule__PrimaryExpression__SuffixAssignment_1_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getSuffixAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2654:1: ( rule__PrimaryExpression__SuffixAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2654:2: rule__PrimaryExpression__SuffixAssignment_1_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__SuffixAssignment_1_1_in_rule__PrimaryExpression__Group_1__1__Impl5547);
            rule__PrimaryExpression__SuffixAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getSuffixAssignment_1_1()); 

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
    // $ANTLR end rule__PrimaryExpression__Group_1__1__Impl


    // $ANTLR start rule__ValueSpecification__Group_7__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2668:1: rule__ValueSpecification__Group_7__0 : rule__ValueSpecification__Group_7__0__Impl rule__ValueSpecification__Group_7__1 ;
    public final void rule__ValueSpecification__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2672:1: ( rule__ValueSpecification__Group_7__0__Impl rule__ValueSpecification__Group_7__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2673:2: rule__ValueSpecification__Group_7__0__Impl rule__ValueSpecification__Group_7__1
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__0__Impl_in_rule__ValueSpecification__Group_7__05581);
            rule__ValueSpecification__Group_7__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__1_in_rule__ValueSpecification__Group_7__05584);
            rule__ValueSpecification__Group_7__1();
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
    // $ANTLR end rule__ValueSpecification__Group_7__0


    // $ANTLR start rule__ValueSpecification__Group_7__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2680:1: rule__ValueSpecification__Group_7__0__Impl : ( '(' ) ;
    public final void rule__ValueSpecification__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2684:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2685:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2685:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2686:1: '('
            {
             before(grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0()); 
            match(input,38,FOLLOW_38_in_rule__ValueSpecification__Group_7__0__Impl5612); 
             after(grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0()); 

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
    // $ANTLR end rule__ValueSpecification__Group_7__0__Impl


    // $ANTLR start rule__ValueSpecification__Group_7__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2699:1: rule__ValueSpecification__Group_7__1 : rule__ValueSpecification__Group_7__1__Impl rule__ValueSpecification__Group_7__2 ;
    public final void rule__ValueSpecification__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2703:1: ( rule__ValueSpecification__Group_7__1__Impl rule__ValueSpecification__Group_7__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2704:2: rule__ValueSpecification__Group_7__1__Impl rule__ValueSpecification__Group_7__2
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__1__Impl_in_rule__ValueSpecification__Group_7__15643);
            rule__ValueSpecification__Group_7__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__2_in_rule__ValueSpecification__Group_7__15646);
            rule__ValueSpecification__Group_7__2();
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
    // $ANTLR end rule__ValueSpecification__Group_7__1


    // $ANTLR start rule__ValueSpecification__Group_7__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2711:1: rule__ValueSpecification__Group_7__1__Impl : ( ruleExpression ) ;
    public final void rule__ValueSpecification__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2715:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2716:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2716:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2717:1: ruleExpression
            {
             before(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ValueSpecification__Group_7__1__Impl5673);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1()); 

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
    // $ANTLR end rule__ValueSpecification__Group_7__1__Impl


    // $ANTLR start rule__ValueSpecification__Group_7__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2728:1: rule__ValueSpecification__Group_7__2 : rule__ValueSpecification__Group_7__2__Impl ;
    public final void rule__ValueSpecification__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2732:1: ( rule__ValueSpecification__Group_7__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2733:2: rule__ValueSpecification__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__2__Impl_in_rule__ValueSpecification__Group_7__25702);
            rule__ValueSpecification__Group_7__2__Impl();
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
    // $ANTLR end rule__ValueSpecification__Group_7__2


    // $ANTLR start rule__ValueSpecification__Group_7__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2739:1: rule__ValueSpecification__Group_7__2__Impl : ( ')' ) ;
    public final void rule__ValueSpecification__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2743:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2744:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2744:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2745:1: ')'
            {
             before(grammarAccess.getValueSpecificationAccess().getRightParenthesisKeyword_7_2()); 
            match(input,39,FOLLOW_39_in_rule__ValueSpecification__Group_7__2__Impl5730); 
             after(grammarAccess.getValueSpecificationAccess().getRightParenthesisKeyword_7_2()); 

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
    // $ANTLR end rule__ValueSpecification__Group_7__2__Impl


    // $ANTLR start rule__PropertyCallExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2764:1: rule__PropertyCallExpression__Group__0 : rule__PropertyCallExpression__Group__0__Impl rule__PropertyCallExpression__Group__1 ;
    public final void rule__PropertyCallExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2768:1: ( rule__PropertyCallExpression__Group__0__Impl rule__PropertyCallExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2769:2: rule__PropertyCallExpression__Group__0__Impl rule__PropertyCallExpression__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__0__Impl_in_rule__PropertyCallExpression__Group__05767);
            rule__PropertyCallExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__1_in_rule__PropertyCallExpression__Group__05770);
            rule__PropertyCallExpression__Group__1();
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
    // $ANTLR end rule__PropertyCallExpression__Group__0


    // $ANTLR start rule__PropertyCallExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2776:1: rule__PropertyCallExpression__Group__0__Impl : ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) ) ;
    public final void rule__PropertyCallExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2780:1: ( ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2781:1: ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2781:1: ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2782:1: ( rule__PropertyCallExpression__PropertyAssignment_0 )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getPropertyAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2783:1: ( rule__PropertyCallExpression__PropertyAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2783:2: rule__PropertyCallExpression__PropertyAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__PropertyAssignment_0_in_rule__PropertyCallExpression__Group__0__Impl5797);
            rule__PropertyCallExpression__PropertyAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getPropertyCallExpressionAccess().getPropertyAssignment_0()); 

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
    // $ANTLR end rule__PropertyCallExpression__Group__0__Impl


    // $ANTLR start rule__PropertyCallExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2793:1: rule__PropertyCallExpression__Group__1 : rule__PropertyCallExpression__Group__1__Impl ;
    public final void rule__PropertyCallExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2797:1: ( rule__PropertyCallExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2798:2: rule__PropertyCallExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__1__Impl_in_rule__PropertyCallExpression__Group__15827);
            rule__PropertyCallExpression__Group__1__Impl();
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
    // $ANTLR end rule__PropertyCallExpression__Group__1


    // $ANTLR start rule__PropertyCallExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2804:1: rule__PropertyCallExpression__Group__1__Impl : ( ( rule__PropertyCallExpression__Group_1__0 )? ) ;
    public final void rule__PropertyCallExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2808:1: ( ( ( rule__PropertyCallExpression__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2809:1: ( ( rule__PropertyCallExpression__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2809:1: ( ( rule__PropertyCallExpression__Group_1__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2810:1: ( rule__PropertyCallExpression__Group_1__0 )?
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2811:1: ( rule__PropertyCallExpression__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==37) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2811:2: rule__PropertyCallExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__0_in_rule__PropertyCallExpression__Group__1__Impl5854);
                    rule__PropertyCallExpression__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPropertyCallExpressionAccess().getGroup_1()); 

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
    // $ANTLR end rule__PropertyCallExpression__Group__1__Impl


    // $ANTLR start rule__PropertyCallExpression__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2825:1: rule__PropertyCallExpression__Group_1__0 : rule__PropertyCallExpression__Group_1__0__Impl rule__PropertyCallExpression__Group_1__1 ;
    public final void rule__PropertyCallExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2829:1: ( rule__PropertyCallExpression__Group_1__0__Impl rule__PropertyCallExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2830:2: rule__PropertyCallExpression__Group_1__0__Impl rule__PropertyCallExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__0__Impl_in_rule__PropertyCallExpression__Group_1__05889);
            rule__PropertyCallExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__1_in_rule__PropertyCallExpression__Group_1__05892);
            rule__PropertyCallExpression__Group_1__1();
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
    // $ANTLR end rule__PropertyCallExpression__Group_1__0


    // $ANTLR start rule__PropertyCallExpression__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2837:1: rule__PropertyCallExpression__Group_1__0__Impl : ( '.' ) ;
    public final void rule__PropertyCallExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2841:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2842:1: ( '.' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2842:1: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2843:1: '.'
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0()); 
            match(input,37,FOLLOW_37_in_rule__PropertyCallExpression__Group_1__0__Impl5920); 
             after(grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end rule__PropertyCallExpression__Group_1__0__Impl


    // $ANTLR start rule__PropertyCallExpression__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2856:1: rule__PropertyCallExpression__Group_1__1 : rule__PropertyCallExpression__Group_1__1__Impl ;
    public final void rule__PropertyCallExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2860:1: ( rule__PropertyCallExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2861:2: rule__PropertyCallExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__1__Impl_in_rule__PropertyCallExpression__Group_1__15951);
            rule__PropertyCallExpression__Group_1__1__Impl();
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
    // $ANTLR end rule__PropertyCallExpression__Group_1__1


    // $ANTLR start rule__PropertyCallExpression__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2867:1: rule__PropertyCallExpression__Group_1__1__Impl : ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) ) ;
    public final void rule__PropertyCallExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2871:1: ( ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2872:1: ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2872:1: ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2873:1: ( rule__PropertyCallExpression__SuffixAssignment_1_1 )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getSuffixAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2874:1: ( rule__PropertyCallExpression__SuffixAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2874:2: rule__PropertyCallExpression__SuffixAssignment_1_1
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__SuffixAssignment_1_1_in_rule__PropertyCallExpression__Group_1__1__Impl5978);
            rule__PropertyCallExpression__SuffixAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getPropertyCallExpressionAccess().getSuffixAssignment_1_1()); 

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
    // $ANTLR end rule__PropertyCallExpression__Group_1__1__Impl


    // $ANTLR start rule__OperationCallExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2888:1: rule__OperationCallExpression__Group__0 : rule__OperationCallExpression__Group__0__Impl rule__OperationCallExpression__Group__1 ;
    public final void rule__OperationCallExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2892:1: ( rule__OperationCallExpression__Group__0__Impl rule__OperationCallExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2893:2: rule__OperationCallExpression__Group__0__Impl rule__OperationCallExpression__Group__1
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__0__Impl_in_rule__OperationCallExpression__Group__06012);
            rule__OperationCallExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__1_in_rule__OperationCallExpression__Group__06015);
            rule__OperationCallExpression__Group__1();
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
    // $ANTLR end rule__OperationCallExpression__Group__0


    // $ANTLR start rule__OperationCallExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2900:1: rule__OperationCallExpression__Group__0__Impl : ( ( rule__OperationCallExpression__OperationAssignment_0 ) ) ;
    public final void rule__OperationCallExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2904:1: ( ( ( rule__OperationCallExpression__OperationAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2905:1: ( ( rule__OperationCallExpression__OperationAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2905:1: ( ( rule__OperationCallExpression__OperationAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2906:1: ( rule__OperationCallExpression__OperationAssignment_0 )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getOperationAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2907:1: ( rule__OperationCallExpression__OperationAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2907:2: rule__OperationCallExpression__OperationAssignment_0
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__OperationAssignment_0_in_rule__OperationCallExpression__Group__0__Impl6042);
            rule__OperationCallExpression__OperationAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getOperationCallExpressionAccess().getOperationAssignment_0()); 

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
    // $ANTLR end rule__OperationCallExpression__Group__0__Impl


    // $ANTLR start rule__OperationCallExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2917:1: rule__OperationCallExpression__Group__1 : rule__OperationCallExpression__Group__1__Impl rule__OperationCallExpression__Group__2 ;
    public final void rule__OperationCallExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2921:1: ( rule__OperationCallExpression__Group__1__Impl rule__OperationCallExpression__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2922:2: rule__OperationCallExpression__Group__1__Impl rule__OperationCallExpression__Group__2
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__1__Impl_in_rule__OperationCallExpression__Group__16072);
            rule__OperationCallExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__2_in_rule__OperationCallExpression__Group__16075);
            rule__OperationCallExpression__Group__2();
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
    // $ANTLR end rule__OperationCallExpression__Group__1


    // $ANTLR start rule__OperationCallExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2929:1: rule__OperationCallExpression__Group__1__Impl : ( '(' ) ;
    public final void rule__OperationCallExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2933:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2934:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2934:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2935:1: '('
            {
             before(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1()); 
            match(input,38,FOLLOW_38_in_rule__OperationCallExpression__Group__1__Impl6103); 
             after(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1()); 

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
    // $ANTLR end rule__OperationCallExpression__Group__1__Impl


    // $ANTLR start rule__OperationCallExpression__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2948:1: rule__OperationCallExpression__Group__2 : rule__OperationCallExpression__Group__2__Impl rule__OperationCallExpression__Group__3 ;
    public final void rule__OperationCallExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2952:1: ( rule__OperationCallExpression__Group__2__Impl rule__OperationCallExpression__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2953:2: rule__OperationCallExpression__Group__2__Impl rule__OperationCallExpression__Group__3
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__2__Impl_in_rule__OperationCallExpression__Group__26134);
            rule__OperationCallExpression__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__3_in_rule__OperationCallExpression__Group__26137);
            rule__OperationCallExpression__Group__3();
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
    // $ANTLR end rule__OperationCallExpression__Group__2


    // $ANTLR start rule__OperationCallExpression__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2960:1: rule__OperationCallExpression__Group__2__Impl : ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? ) ;
    public final void rule__OperationCallExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2964:1: ( ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2965:1: ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2965:1: ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2966:1: ( rule__OperationCallExpression__ArgumentsAssignment_2 )?
            {
             before(grammarAccess.getOperationCallExpressionAccess().getArgumentsAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2967:1: ( rule__OperationCallExpression__ArgumentsAssignment_2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)||(LA25_0>=25 && LA25_0<=28)||(LA25_0>=30 && LA25_0<=35)||LA25_0==38||LA25_0==42||LA25_0==46||(LA25_0>=48 && LA25_0<=50)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2967:2: rule__OperationCallExpression__ArgumentsAssignment_2
                    {
                    pushFollow(FOLLOW_rule__OperationCallExpression__ArgumentsAssignment_2_in_rule__OperationCallExpression__Group__2__Impl6164);
                    rule__OperationCallExpression__ArgumentsAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationCallExpressionAccess().getArgumentsAssignment_2()); 

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
    // $ANTLR end rule__OperationCallExpression__Group__2__Impl


    // $ANTLR start rule__OperationCallExpression__Group__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2977:1: rule__OperationCallExpression__Group__3 : rule__OperationCallExpression__Group__3__Impl rule__OperationCallExpression__Group__4 ;
    public final void rule__OperationCallExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2981:1: ( rule__OperationCallExpression__Group__3__Impl rule__OperationCallExpression__Group__4 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2982:2: rule__OperationCallExpression__Group__3__Impl rule__OperationCallExpression__Group__4
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__3__Impl_in_rule__OperationCallExpression__Group__36195);
            rule__OperationCallExpression__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__4_in_rule__OperationCallExpression__Group__36198);
            rule__OperationCallExpression__Group__4();
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
    // $ANTLR end rule__OperationCallExpression__Group__3


    // $ANTLR start rule__OperationCallExpression__Group__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2989:1: rule__OperationCallExpression__Group__3__Impl : ( ')' ) ;
    public final void rule__OperationCallExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2993:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2994:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2994:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2995:1: ')'
            {
             before(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3()); 
            match(input,39,FOLLOW_39_in_rule__OperationCallExpression__Group__3__Impl6226); 
             after(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3()); 

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
    // $ANTLR end rule__OperationCallExpression__Group__3__Impl


    // $ANTLR start rule__OperationCallExpression__Group__4
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3008:1: rule__OperationCallExpression__Group__4 : rule__OperationCallExpression__Group__4__Impl ;
    public final void rule__OperationCallExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3012:1: ( rule__OperationCallExpression__Group__4__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3013:2: rule__OperationCallExpression__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__4__Impl_in_rule__OperationCallExpression__Group__46257);
            rule__OperationCallExpression__Group__4__Impl();
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
    // $ANTLR end rule__OperationCallExpression__Group__4


    // $ANTLR start rule__OperationCallExpression__Group__4__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3019:1: rule__OperationCallExpression__Group__4__Impl : ( ( rule__OperationCallExpression__Group_4__0 )? ) ;
    public final void rule__OperationCallExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3023:1: ( ( ( rule__OperationCallExpression__Group_4__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3024:1: ( ( rule__OperationCallExpression__Group_4__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3024:1: ( ( rule__OperationCallExpression__Group_4__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3025:1: ( rule__OperationCallExpression__Group_4__0 )?
            {
             before(grammarAccess.getOperationCallExpressionAccess().getGroup_4()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3026:1: ( rule__OperationCallExpression__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3026:2: rule__OperationCallExpression__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__0_in_rule__OperationCallExpression__Group__4__Impl6284);
                    rule__OperationCallExpression__Group_4__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationCallExpressionAccess().getGroup_4()); 

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
    // $ANTLR end rule__OperationCallExpression__Group__4__Impl


    // $ANTLR start rule__OperationCallExpression__Group_4__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3046:1: rule__OperationCallExpression__Group_4__0 : rule__OperationCallExpression__Group_4__0__Impl rule__OperationCallExpression__Group_4__1 ;
    public final void rule__OperationCallExpression__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3050:1: ( rule__OperationCallExpression__Group_4__0__Impl rule__OperationCallExpression__Group_4__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3051:2: rule__OperationCallExpression__Group_4__0__Impl rule__OperationCallExpression__Group_4__1
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__0__Impl_in_rule__OperationCallExpression__Group_4__06325);
            rule__OperationCallExpression__Group_4__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__1_in_rule__OperationCallExpression__Group_4__06328);
            rule__OperationCallExpression__Group_4__1();
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
    // $ANTLR end rule__OperationCallExpression__Group_4__0


    // $ANTLR start rule__OperationCallExpression__Group_4__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3058:1: rule__OperationCallExpression__Group_4__0__Impl : ( '.' ) ;
    public final void rule__OperationCallExpression__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3062:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3063:1: ( '.' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3063:1: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3064:1: '.'
            {
             before(grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0()); 
            match(input,37,FOLLOW_37_in_rule__OperationCallExpression__Group_4__0__Impl6356); 
             after(grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0()); 

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
    // $ANTLR end rule__OperationCallExpression__Group_4__0__Impl


    // $ANTLR start rule__OperationCallExpression__Group_4__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3077:1: rule__OperationCallExpression__Group_4__1 : rule__OperationCallExpression__Group_4__1__Impl ;
    public final void rule__OperationCallExpression__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3081:1: ( rule__OperationCallExpression__Group_4__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3082:2: rule__OperationCallExpression__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__1__Impl_in_rule__OperationCallExpression__Group_4__16387);
            rule__OperationCallExpression__Group_4__1__Impl();
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
    // $ANTLR end rule__OperationCallExpression__Group_4__1


    // $ANTLR start rule__OperationCallExpression__Group_4__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3088:1: rule__OperationCallExpression__Group_4__1__Impl : ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) ) ;
    public final void rule__OperationCallExpression__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3092:1: ( ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3093:1: ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3093:1: ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3094:1: ( rule__OperationCallExpression__SuffixAssignment_4_1 )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getSuffixAssignment_4_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3095:1: ( rule__OperationCallExpression__SuffixAssignment_4_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3095:2: rule__OperationCallExpression__SuffixAssignment_4_1
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__SuffixAssignment_4_1_in_rule__OperationCallExpression__Group_4__1__Impl6414);
            rule__OperationCallExpression__SuffixAssignment_4_1();
            _fsp--;


            }

             after(grammarAccess.getOperationCallExpressionAccess().getSuffixAssignment_4_1()); 

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
    // $ANTLR end rule__OperationCallExpression__Group_4__1__Impl


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3109:1: rule__NameOrChoiceOrBehaviorCall__Group__0 : rule__NameOrChoiceOrBehaviorCall__Group__0__Impl rule__NameOrChoiceOrBehaviorCall__Group__1 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3113:1: ( rule__NameOrChoiceOrBehaviorCall__Group__0__Impl rule__NameOrChoiceOrBehaviorCall__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3114:2: rule__NameOrChoiceOrBehaviorCall__Group__0__Impl rule__NameOrChoiceOrBehaviorCall__Group__1
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__06448);
            rule__NameOrChoiceOrBehaviorCall__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1_in_rule__NameOrChoiceOrBehaviorCall__Group__06451);
            rule__NameOrChoiceOrBehaviorCall__Group__1();
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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group__0


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3121:1: rule__NameOrChoiceOrBehaviorCall__Group__0__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3125:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3126:1: ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3126:1: ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3127:1: ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )?
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3128:1: ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==40) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3128:2: rule__NameOrChoiceOrBehaviorCall__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__PathAssignment_0_in_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl6478);
                    rule__NameOrChoiceOrBehaviorCall__PathAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathAssignment_0()); 

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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group__0__Impl


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3138:1: rule__NameOrChoiceOrBehaviorCall__Group__1 : rule__NameOrChoiceOrBehaviorCall__Group__1__Impl rule__NameOrChoiceOrBehaviorCall__Group__2 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3142:1: ( rule__NameOrChoiceOrBehaviorCall__Group__1__Impl rule__NameOrChoiceOrBehaviorCall__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3143:2: rule__NameOrChoiceOrBehaviorCall__Group__1__Impl rule__NameOrChoiceOrBehaviorCall__Group__2
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__16509);
            rule__NameOrChoiceOrBehaviorCall__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2_in_rule__NameOrChoiceOrBehaviorCall__Group__16512);
            rule__NameOrChoiceOrBehaviorCall__Group__2();
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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group__1


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3150:1: rule__NameOrChoiceOrBehaviorCall__Group__1__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3154:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3155:1: ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3155:1: ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3156:1: ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 )
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3157:1: ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3157:2: rule__NameOrChoiceOrBehaviorCall__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__IdAssignment_1_in_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl6539);
            rule__NameOrChoiceOrBehaviorCall__IdAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdAssignment_1()); 

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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group__1__Impl


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3167:1: rule__NameOrChoiceOrBehaviorCall__Group__2 : rule__NameOrChoiceOrBehaviorCall__Group__2__Impl ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3171:1: ( rule__NameOrChoiceOrBehaviorCall__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3172:2: rule__NameOrChoiceOrBehaviorCall__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__26569);
            rule__NameOrChoiceOrBehaviorCall__Group__2__Impl();
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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group__2


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3178:1: rule__NameOrChoiceOrBehaviorCall__Group__2__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3182:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3183:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3183:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3184:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )?
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3185:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==38) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3185:2: rule__NameOrChoiceOrBehaviorCall__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0_in_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl6596);
                    rule__NameOrChoiceOrBehaviorCall__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getGroup_2()); 

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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group__2__Impl


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group_2__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3201:1: rule__NameOrChoiceOrBehaviorCall__Group_2__0 : rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__1 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3205:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3206:2: rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__1
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__06633);
            rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__06636);
            rule__NameOrChoiceOrBehaviorCall__Group_2__1();
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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group_2__0


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3213:1: rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl : ( '(' ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3217:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3218:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3218:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3219:1: '('
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,38,FOLLOW_38_in_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl6664); 
             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0()); 

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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group_2__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3232:1: rule__NameOrChoiceOrBehaviorCall__Group_2__1 : rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__2 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3236:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3237:2: rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__2
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__16695);
            rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2_in_rule__NameOrChoiceOrBehaviorCall__Group_2__16698);
            rule__NameOrChoiceOrBehaviorCall__Group_2__2();
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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group_2__1


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3244:1: rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3248:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3249:1: ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3249:1: ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3250:1: ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )?
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3251:1: ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_STRING)||(LA29_0>=25 && LA29_0<=28)||(LA29_0>=30 && LA29_0<=35)||LA29_0==38||LA29_0==42||LA29_0==46||(LA29_0>=48 && LA29_0<=50)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3251:2: rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl6725);
                    rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsAssignment_2_1()); 

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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group_2__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3261:1: rule__NameOrChoiceOrBehaviorCall__Group_2__2 : rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3265:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3266:2: rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__26756);
            rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl();
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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group_2__2


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3272:1: rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl : ( ')' ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3276:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3277:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3277:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3278:1: ')'
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getRightParenthesisKeyword_2_2()); 
            match(input,39,FOLLOW_39_in_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl6784); 
             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getRightParenthesisKeyword_2_2()); 

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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl


    // $ANTLR start rule__QualifiedName__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3297:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3301:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3302:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__06821);
            rule__QualifiedName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__06824);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3309:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3313:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3314:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3314:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3315:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3316:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3316:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl6851);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3326:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3330:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3331:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__16881);
            rule__QualifiedName__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__16884);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3338:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3342:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3343:1: ( '::' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3343:1: ( '::' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3344:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,40,FOLLOW_40_in_rule__QualifiedName__Group__1__Impl6912); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3357:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3361:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3362:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__26943);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3368:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3372:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3373:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3373:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3374:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3375:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==40) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3375:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl6970);
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


    // $ANTLR start rule__Interval__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3391:1: rule__Interval__Group__0 : rule__Interval__Group__0__Impl rule__Interval__Group__1 ;
    public final void rule__Interval__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3395:1: ( rule__Interval__Group__0__Impl rule__Interval__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3396:2: rule__Interval__Group__0__Impl rule__Interval__Group__1
            {
            pushFollow(FOLLOW_rule__Interval__Group__0__Impl_in_rule__Interval__Group__07007);
            rule__Interval__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__1_in_rule__Interval__Group__07010);
            rule__Interval__Group__1();
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
    // $ANTLR end rule__Interval__Group__0


    // $ANTLR start rule__Interval__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3403:1: rule__Interval__Group__0__Impl : ( ( rule__Interval__Alternatives_0 ) ) ;
    public final void rule__Interval__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3407:1: ( ( ( rule__Interval__Alternatives_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3408:1: ( ( rule__Interval__Alternatives_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3408:1: ( ( rule__Interval__Alternatives_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3409:1: ( rule__Interval__Alternatives_0 )
            {
             before(grammarAccess.getIntervalAccess().getAlternatives_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3410:1: ( rule__Interval__Alternatives_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3410:2: rule__Interval__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Interval__Alternatives_0_in_rule__Interval__Group__0__Impl7037);
            rule__Interval__Alternatives_0();
            _fsp--;


            }

             after(grammarAccess.getIntervalAccess().getAlternatives_0()); 

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
    // $ANTLR end rule__Interval__Group__0__Impl


    // $ANTLR start rule__Interval__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3420:1: rule__Interval__Group__1 : rule__Interval__Group__1__Impl rule__Interval__Group__2 ;
    public final void rule__Interval__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3424:1: ( rule__Interval__Group__1__Impl rule__Interval__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3425:2: rule__Interval__Group__1__Impl rule__Interval__Group__2
            {
            pushFollow(FOLLOW_rule__Interval__Group__1__Impl_in_rule__Interval__Group__17067);
            rule__Interval__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__2_in_rule__Interval__Group__17070);
            rule__Interval__Group__2();
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
    // $ANTLR end rule__Interval__Group__1


    // $ANTLR start rule__Interval__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3432:1: rule__Interval__Group__1__Impl : ( ( rule__Interval__LowerAssignment_1 ) ) ;
    public final void rule__Interval__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3436:1: ( ( ( rule__Interval__LowerAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3437:1: ( ( rule__Interval__LowerAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3437:1: ( ( rule__Interval__LowerAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3438:1: ( rule__Interval__LowerAssignment_1 )
            {
             before(grammarAccess.getIntervalAccess().getLowerAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3439:1: ( rule__Interval__LowerAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3439:2: rule__Interval__LowerAssignment_1
            {
            pushFollow(FOLLOW_rule__Interval__LowerAssignment_1_in_rule__Interval__Group__1__Impl7097);
            rule__Interval__LowerAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getIntervalAccess().getLowerAssignment_1()); 

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
    // $ANTLR end rule__Interval__Group__1__Impl


    // $ANTLR start rule__Interval__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3449:1: rule__Interval__Group__2 : rule__Interval__Group__2__Impl rule__Interval__Group__3 ;
    public final void rule__Interval__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3453:1: ( rule__Interval__Group__2__Impl rule__Interval__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3454:2: rule__Interval__Group__2__Impl rule__Interval__Group__3
            {
            pushFollow(FOLLOW_rule__Interval__Group__2__Impl_in_rule__Interval__Group__27127);
            rule__Interval__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__3_in_rule__Interval__Group__27130);
            rule__Interval__Group__3();
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
    // $ANTLR end rule__Interval__Group__2


    // $ANTLR start rule__Interval__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3461:1: rule__Interval__Group__2__Impl : ( '..' ) ;
    public final void rule__Interval__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3465:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3466:1: ( '..' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3466:1: ( '..' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3467:1: '..'
            {
             before(grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2()); 
            match(input,41,FOLLOW_41_in_rule__Interval__Group__2__Impl7158); 
             after(grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2()); 

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
    // $ANTLR end rule__Interval__Group__2__Impl


    // $ANTLR start rule__Interval__Group__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3480:1: rule__Interval__Group__3 : rule__Interval__Group__3__Impl rule__Interval__Group__4 ;
    public final void rule__Interval__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3484:1: ( rule__Interval__Group__3__Impl rule__Interval__Group__4 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3485:2: rule__Interval__Group__3__Impl rule__Interval__Group__4
            {
            pushFollow(FOLLOW_rule__Interval__Group__3__Impl_in_rule__Interval__Group__37189);
            rule__Interval__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__4_in_rule__Interval__Group__37192);
            rule__Interval__Group__4();
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
    // $ANTLR end rule__Interval__Group__3


    // $ANTLR start rule__Interval__Group__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3492:1: rule__Interval__Group__3__Impl : ( ( rule__Interval__UpperAssignment_3 ) ) ;
    public final void rule__Interval__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3496:1: ( ( ( rule__Interval__UpperAssignment_3 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3497:1: ( ( rule__Interval__UpperAssignment_3 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3497:1: ( ( rule__Interval__UpperAssignment_3 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3498:1: ( rule__Interval__UpperAssignment_3 )
            {
             before(grammarAccess.getIntervalAccess().getUpperAssignment_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3499:1: ( rule__Interval__UpperAssignment_3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3499:2: rule__Interval__UpperAssignment_3
            {
            pushFollow(FOLLOW_rule__Interval__UpperAssignment_3_in_rule__Interval__Group__3__Impl7219);
            rule__Interval__UpperAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getIntervalAccess().getUpperAssignment_3()); 

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
    // $ANTLR end rule__Interval__Group__3__Impl


    // $ANTLR start rule__Interval__Group__4
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3509:1: rule__Interval__Group__4 : rule__Interval__Group__4__Impl ;
    public final void rule__Interval__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3513:1: ( rule__Interval__Group__4__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3514:2: rule__Interval__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Interval__Group__4__Impl_in_rule__Interval__Group__47249);
            rule__Interval__Group__4__Impl();
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
    // $ANTLR end rule__Interval__Group__4


    // $ANTLR start rule__Interval__Group__4__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3520:1: rule__Interval__Group__4__Impl : ( ( rule__Interval__Alternatives_4 ) ) ;
    public final void rule__Interval__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3524:1: ( ( ( rule__Interval__Alternatives_4 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3525:1: ( ( rule__Interval__Alternatives_4 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3525:1: ( ( rule__Interval__Alternatives_4 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3526:1: ( rule__Interval__Alternatives_4 )
            {
             before(grammarAccess.getIntervalAccess().getAlternatives_4()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3527:1: ( rule__Interval__Alternatives_4 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3527:2: rule__Interval__Alternatives_4
            {
            pushFollow(FOLLOW_rule__Interval__Alternatives_4_in_rule__Interval__Group__4__Impl7276);
            rule__Interval__Alternatives_4();
            _fsp--;


            }

             after(grammarAccess.getIntervalAccess().getAlternatives_4()); 

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
    // $ANTLR end rule__Interval__Group__4__Impl


    // $ANTLR start rule__CollectionOrTuple__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3547:1: rule__CollectionOrTuple__Group__0 : rule__CollectionOrTuple__Group__0__Impl rule__CollectionOrTuple__Group__1 ;
    public final void rule__CollectionOrTuple__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3551:1: ( rule__CollectionOrTuple__Group__0__Impl rule__CollectionOrTuple__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3552:2: rule__CollectionOrTuple__Group__0__Impl rule__CollectionOrTuple__Group__1
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__0__Impl_in_rule__CollectionOrTuple__Group__07316);
            rule__CollectionOrTuple__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__1_in_rule__CollectionOrTuple__Group__07319);
            rule__CollectionOrTuple__Group__1();
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
    // $ANTLR end rule__CollectionOrTuple__Group__0


    // $ANTLR start rule__CollectionOrTuple__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3559:1: rule__CollectionOrTuple__Group__0__Impl : ( '{' ) ;
    public final void rule__CollectionOrTuple__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3563:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3564:1: ( '{' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3564:1: ( '{' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3565:1: '{'
            {
             before(grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,42,FOLLOW_42_in_rule__CollectionOrTuple__Group__0__Impl7347); 
             after(grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end rule__CollectionOrTuple__Group__0__Impl


    // $ANTLR start rule__CollectionOrTuple__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3578:1: rule__CollectionOrTuple__Group__1 : rule__CollectionOrTuple__Group__1__Impl rule__CollectionOrTuple__Group__2 ;
    public final void rule__CollectionOrTuple__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3582:1: ( rule__CollectionOrTuple__Group__1__Impl rule__CollectionOrTuple__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3583:2: rule__CollectionOrTuple__Group__1__Impl rule__CollectionOrTuple__Group__2
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__1__Impl_in_rule__CollectionOrTuple__Group__17378);
            rule__CollectionOrTuple__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__2_in_rule__CollectionOrTuple__Group__17381);
            rule__CollectionOrTuple__Group__2();
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
    // $ANTLR end rule__CollectionOrTuple__Group__1


    // $ANTLR start rule__CollectionOrTuple__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3590:1: rule__CollectionOrTuple__Group__1__Impl : ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) ) ;
    public final void rule__CollectionOrTuple__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3594:1: ( ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3595:1: ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3595:1: ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3596:1: ( rule__CollectionOrTuple__ListOfValuesAssignment_1 )
            {
             before(grammarAccess.getCollectionOrTupleAccess().getListOfValuesAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3597:1: ( rule__CollectionOrTuple__ListOfValuesAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3597:2: rule__CollectionOrTuple__ListOfValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__ListOfValuesAssignment_1_in_rule__CollectionOrTuple__Group__1__Impl7408);
            rule__CollectionOrTuple__ListOfValuesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getCollectionOrTupleAccess().getListOfValuesAssignment_1()); 

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
    // $ANTLR end rule__CollectionOrTuple__Group__1__Impl


    // $ANTLR start rule__CollectionOrTuple__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3607:1: rule__CollectionOrTuple__Group__2 : rule__CollectionOrTuple__Group__2__Impl ;
    public final void rule__CollectionOrTuple__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3611:1: ( rule__CollectionOrTuple__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3612:2: rule__CollectionOrTuple__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__2__Impl_in_rule__CollectionOrTuple__Group__27438);
            rule__CollectionOrTuple__Group__2__Impl();
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
    // $ANTLR end rule__CollectionOrTuple__Group__2


    // $ANTLR start rule__CollectionOrTuple__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3618:1: rule__CollectionOrTuple__Group__2__Impl : ( '}' ) ;
    public final void rule__CollectionOrTuple__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3622:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3623:1: ( '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3623:1: ( '}' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3624:1: '}'
            {
             before(grammarAccess.getCollectionOrTupleAccess().getRightCurlyBracketKeyword_2()); 
            match(input,43,FOLLOW_43_in_rule__CollectionOrTuple__Group__2__Impl7466); 
             after(grammarAccess.getCollectionOrTupleAccess().getRightCurlyBracketKeyword_2()); 

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
    // $ANTLR end rule__CollectionOrTuple__Group__2__Impl


    // $ANTLR start rule__Tuple__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3643:1: rule__Tuple__Group__0 : rule__Tuple__Group__0__Impl rule__Tuple__Group__1 ;
    public final void rule__Tuple__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3647:1: ( rule__Tuple__Group__0__Impl rule__Tuple__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3648:2: rule__Tuple__Group__0__Impl rule__Tuple__Group__1
            {
            pushFollow(FOLLOW_rule__Tuple__Group__0__Impl_in_rule__Tuple__Group__07503);
            rule__Tuple__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Tuple__Group__1_in_rule__Tuple__Group__07506);
            rule__Tuple__Group__1();
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
    // $ANTLR end rule__Tuple__Group__0


    // $ANTLR start rule__Tuple__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3655:1: rule__Tuple__Group__0__Impl : ( '{' ) ;
    public final void rule__Tuple__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3659:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3660:1: ( '{' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3660:1: ( '{' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3661:1: '{'
            {
             before(grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,42,FOLLOW_42_in_rule__Tuple__Group__0__Impl7534); 
             after(grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end rule__Tuple__Group__0__Impl


    // $ANTLR start rule__Tuple__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3674:1: rule__Tuple__Group__1 : rule__Tuple__Group__1__Impl rule__Tuple__Group__2 ;
    public final void rule__Tuple__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3678:1: ( rule__Tuple__Group__1__Impl rule__Tuple__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3679:2: rule__Tuple__Group__1__Impl rule__Tuple__Group__2
            {
            pushFollow(FOLLOW_rule__Tuple__Group__1__Impl_in_rule__Tuple__Group__17565);
            rule__Tuple__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Tuple__Group__2_in_rule__Tuple__Group__17568);
            rule__Tuple__Group__2();
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
    // $ANTLR end rule__Tuple__Group__1


    // $ANTLR start rule__Tuple__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3686:1: rule__Tuple__Group__1__Impl : ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) ) ;
    public final void rule__Tuple__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3690:1: ( ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3691:1: ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3691:1: ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3692:1: ( rule__Tuple__ListOfValueNamePairsAssignment_1 )
            {
             before(grammarAccess.getTupleAccess().getListOfValueNamePairsAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3693:1: ( rule__Tuple__ListOfValueNamePairsAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3693:2: rule__Tuple__ListOfValueNamePairsAssignment_1
            {
            pushFollow(FOLLOW_rule__Tuple__ListOfValueNamePairsAssignment_1_in_rule__Tuple__Group__1__Impl7595);
            rule__Tuple__ListOfValueNamePairsAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTupleAccess().getListOfValueNamePairsAssignment_1()); 

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
    // $ANTLR end rule__Tuple__Group__1__Impl


    // $ANTLR start rule__Tuple__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3703:1: rule__Tuple__Group__2 : rule__Tuple__Group__2__Impl ;
    public final void rule__Tuple__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3707:1: ( rule__Tuple__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3708:2: rule__Tuple__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Tuple__Group__2__Impl_in_rule__Tuple__Group__27625);
            rule__Tuple__Group__2__Impl();
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
    // $ANTLR end rule__Tuple__Group__2


    // $ANTLR start rule__Tuple__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3714:1: rule__Tuple__Group__2__Impl : ( '}' ) ;
    public final void rule__Tuple__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3718:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3719:1: ( '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3719:1: ( '}' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3720:1: '}'
            {
             before(grammarAccess.getTupleAccess().getRightCurlyBracketKeyword_2()); 
            match(input,43,FOLLOW_43_in_rule__Tuple__Group__2__Impl7653); 
             after(grammarAccess.getTupleAccess().getRightCurlyBracketKeyword_2()); 

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
    // $ANTLR end rule__Tuple__Group__2__Impl


    // $ANTLR start rule__ListOfValues__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3739:1: rule__ListOfValues__Group__0 : rule__ListOfValues__Group__0__Impl rule__ListOfValues__Group__1 ;
    public final void rule__ListOfValues__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3743:1: ( rule__ListOfValues__Group__0__Impl rule__ListOfValues__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3744:2: rule__ListOfValues__Group__0__Impl rule__ListOfValues__Group__1
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group__0__Impl_in_rule__ListOfValues__Group__07690);
            rule__ListOfValues__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ListOfValues__Group__1_in_rule__ListOfValues__Group__07693);
            rule__ListOfValues__Group__1();
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
    // $ANTLR end rule__ListOfValues__Group__0


    // $ANTLR start rule__ListOfValues__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3751:1: rule__ListOfValues__Group__0__Impl : ( ( rule__ListOfValues__ValuesAssignment_0 ) ) ;
    public final void rule__ListOfValues__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3755:1: ( ( ( rule__ListOfValues__ValuesAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3756:1: ( ( rule__ListOfValues__ValuesAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3756:1: ( ( rule__ListOfValues__ValuesAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3757:1: ( rule__ListOfValues__ValuesAssignment_0 )
            {
             before(grammarAccess.getListOfValuesAccess().getValuesAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3758:1: ( rule__ListOfValues__ValuesAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3758:2: rule__ListOfValues__ValuesAssignment_0
            {
            pushFollow(FOLLOW_rule__ListOfValues__ValuesAssignment_0_in_rule__ListOfValues__Group__0__Impl7720);
            rule__ListOfValues__ValuesAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getListOfValuesAccess().getValuesAssignment_0()); 

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
    // $ANTLR end rule__ListOfValues__Group__0__Impl


    // $ANTLR start rule__ListOfValues__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3768:1: rule__ListOfValues__Group__1 : rule__ListOfValues__Group__1__Impl ;
    public final void rule__ListOfValues__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3772:1: ( rule__ListOfValues__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3773:2: rule__ListOfValues__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group__1__Impl_in_rule__ListOfValues__Group__17750);
            rule__ListOfValues__Group__1__Impl();
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
    // $ANTLR end rule__ListOfValues__Group__1


    // $ANTLR start rule__ListOfValues__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3779:1: rule__ListOfValues__Group__1__Impl : ( ( rule__ListOfValues__Group_1__0 )* ) ;
    public final void rule__ListOfValues__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3783:1: ( ( ( rule__ListOfValues__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3784:1: ( ( rule__ListOfValues__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3784:1: ( ( rule__ListOfValues__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3785:1: ( rule__ListOfValues__Group_1__0 )*
            {
             before(grammarAccess.getListOfValuesAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3786:1: ( rule__ListOfValues__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==44) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3786:2: rule__ListOfValues__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ListOfValues__Group_1__0_in_rule__ListOfValues__Group__1__Impl7777);
            	    rule__ListOfValues__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getListOfValuesAccess().getGroup_1()); 

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
    // $ANTLR end rule__ListOfValues__Group__1__Impl


    // $ANTLR start rule__ListOfValues__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3800:1: rule__ListOfValues__Group_1__0 : rule__ListOfValues__Group_1__0__Impl rule__ListOfValues__Group_1__1 ;
    public final void rule__ListOfValues__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3804:1: ( rule__ListOfValues__Group_1__0__Impl rule__ListOfValues__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3805:2: rule__ListOfValues__Group_1__0__Impl rule__ListOfValues__Group_1__1
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group_1__0__Impl_in_rule__ListOfValues__Group_1__07812);
            rule__ListOfValues__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ListOfValues__Group_1__1_in_rule__ListOfValues__Group_1__07815);
            rule__ListOfValues__Group_1__1();
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
    // $ANTLR end rule__ListOfValues__Group_1__0


    // $ANTLR start rule__ListOfValues__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3812:1: rule__ListOfValues__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ListOfValues__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3816:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3817:1: ( ',' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3817:1: ( ',' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3818:1: ','
            {
             before(grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0()); 
            match(input,44,FOLLOW_44_in_rule__ListOfValues__Group_1__0__Impl7843); 
             after(grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0()); 

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
    // $ANTLR end rule__ListOfValues__Group_1__0__Impl


    // $ANTLR start rule__ListOfValues__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3831:1: rule__ListOfValues__Group_1__1 : rule__ListOfValues__Group_1__1__Impl ;
    public final void rule__ListOfValues__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3835:1: ( rule__ListOfValues__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3836:2: rule__ListOfValues__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group_1__1__Impl_in_rule__ListOfValues__Group_1__17874);
            rule__ListOfValues__Group_1__1__Impl();
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
    // $ANTLR end rule__ListOfValues__Group_1__1


    // $ANTLR start rule__ListOfValues__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3842:1: rule__ListOfValues__Group_1__1__Impl : ( ( rule__ListOfValues__ValuesAssignment_1_1 ) ) ;
    public final void rule__ListOfValues__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3846:1: ( ( ( rule__ListOfValues__ValuesAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3847:1: ( ( rule__ListOfValues__ValuesAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3847:1: ( ( rule__ListOfValues__ValuesAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3848:1: ( rule__ListOfValues__ValuesAssignment_1_1 )
            {
             before(grammarAccess.getListOfValuesAccess().getValuesAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3849:1: ( rule__ListOfValues__ValuesAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3849:2: rule__ListOfValues__ValuesAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ListOfValues__ValuesAssignment_1_1_in_rule__ListOfValues__Group_1__1__Impl7901);
            rule__ListOfValues__ValuesAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getListOfValuesAccess().getValuesAssignment_1_1()); 

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
    // $ANTLR end rule__ListOfValues__Group_1__1__Impl


    // $ANTLR start rule__ListOfValueNamePairs__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3863:1: rule__ListOfValueNamePairs__Group__0 : rule__ListOfValueNamePairs__Group__0__Impl rule__ListOfValueNamePairs__Group__1 ;
    public final void rule__ListOfValueNamePairs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3867:1: ( rule__ListOfValueNamePairs__Group__0__Impl rule__ListOfValueNamePairs__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3868:2: rule__ListOfValueNamePairs__Group__0__Impl rule__ListOfValueNamePairs__Group__1
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__0__Impl_in_rule__ListOfValueNamePairs__Group__07935);
            rule__ListOfValueNamePairs__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__1_in_rule__ListOfValueNamePairs__Group__07938);
            rule__ListOfValueNamePairs__Group__1();
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
    // $ANTLR end rule__ListOfValueNamePairs__Group__0


    // $ANTLR start rule__ListOfValueNamePairs__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3875:1: rule__ListOfValueNamePairs__Group__0__Impl : ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) ) ;
    public final void rule__ListOfValueNamePairs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3879:1: ( ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3880:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3880:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3881:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 )
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3882:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3882:2: rule__ListOfValueNamePairs__ValueNamePairsAssignment_0
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_0_in_rule__ListOfValueNamePairs__Group__0__Impl7965);
            rule__ListOfValueNamePairs__ValueNamePairsAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsAssignment_0()); 

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
    // $ANTLR end rule__ListOfValueNamePairs__Group__0__Impl


    // $ANTLR start rule__ListOfValueNamePairs__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3892:1: rule__ListOfValueNamePairs__Group__1 : rule__ListOfValueNamePairs__Group__1__Impl ;
    public final void rule__ListOfValueNamePairs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3896:1: ( rule__ListOfValueNamePairs__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3897:2: rule__ListOfValueNamePairs__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__1__Impl_in_rule__ListOfValueNamePairs__Group__17995);
            rule__ListOfValueNamePairs__Group__1__Impl();
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
    // $ANTLR end rule__ListOfValueNamePairs__Group__1


    // $ANTLR start rule__ListOfValueNamePairs__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3903:1: rule__ListOfValueNamePairs__Group__1__Impl : ( ( rule__ListOfValueNamePairs__Group_1__0 )* ) ;
    public final void rule__ListOfValueNamePairs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3907:1: ( ( ( rule__ListOfValueNamePairs__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3908:1: ( ( rule__ListOfValueNamePairs__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3908:1: ( ( rule__ListOfValueNamePairs__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3909:1: ( rule__ListOfValueNamePairs__Group_1__0 )*
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3910:1: ( rule__ListOfValueNamePairs__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==44) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3910:2: rule__ListOfValueNamePairs__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__0_in_rule__ListOfValueNamePairs__Group__1__Impl8022);
            	    rule__ListOfValueNamePairs__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getListOfValueNamePairsAccess().getGroup_1()); 

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
    // $ANTLR end rule__ListOfValueNamePairs__Group__1__Impl


    // $ANTLR start rule__ListOfValueNamePairs__Group_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3924:1: rule__ListOfValueNamePairs__Group_1__0 : rule__ListOfValueNamePairs__Group_1__0__Impl rule__ListOfValueNamePairs__Group_1__1 ;
    public final void rule__ListOfValueNamePairs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3928:1: ( rule__ListOfValueNamePairs__Group_1__0__Impl rule__ListOfValueNamePairs__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3929:2: rule__ListOfValueNamePairs__Group_1__0__Impl rule__ListOfValueNamePairs__Group_1__1
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__0__Impl_in_rule__ListOfValueNamePairs__Group_1__08057);
            rule__ListOfValueNamePairs__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__1_in_rule__ListOfValueNamePairs__Group_1__08060);
            rule__ListOfValueNamePairs__Group_1__1();
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
    // $ANTLR end rule__ListOfValueNamePairs__Group_1__0


    // $ANTLR start rule__ListOfValueNamePairs__Group_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3936:1: rule__ListOfValueNamePairs__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ListOfValueNamePairs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3940:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3941:1: ( ',' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3941:1: ( ',' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3942:1: ','
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0()); 
            match(input,44,FOLLOW_44_in_rule__ListOfValueNamePairs__Group_1__0__Impl8088); 
             after(grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0()); 

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
    // $ANTLR end rule__ListOfValueNamePairs__Group_1__0__Impl


    // $ANTLR start rule__ListOfValueNamePairs__Group_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3955:1: rule__ListOfValueNamePairs__Group_1__1 : rule__ListOfValueNamePairs__Group_1__1__Impl ;
    public final void rule__ListOfValueNamePairs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3959:1: ( rule__ListOfValueNamePairs__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3960:2: rule__ListOfValueNamePairs__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__1__Impl_in_rule__ListOfValueNamePairs__Group_1__18119);
            rule__ListOfValueNamePairs__Group_1__1__Impl();
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
    // $ANTLR end rule__ListOfValueNamePairs__Group_1__1


    // $ANTLR start rule__ListOfValueNamePairs__Group_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3966:1: rule__ListOfValueNamePairs__Group_1__1__Impl : ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) ) ;
    public final void rule__ListOfValueNamePairs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3970:1: ( ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3971:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3971:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3972:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 )
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3973:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3973:2: rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1_in_rule__ListOfValueNamePairs__Group_1__1__Impl8146);
            rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsAssignment_1_1()); 

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
    // $ANTLR end rule__ListOfValueNamePairs__Group_1__1__Impl


    // $ANTLR start rule__ValueNamePair__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3987:1: rule__ValueNamePair__Group__0 : rule__ValueNamePair__Group__0__Impl rule__ValueNamePair__Group__1 ;
    public final void rule__ValueNamePair__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3991:1: ( rule__ValueNamePair__Group__0__Impl rule__ValueNamePair__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3992:2: rule__ValueNamePair__Group__0__Impl rule__ValueNamePair__Group__1
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__0__Impl_in_rule__ValueNamePair__Group__08180);
            rule__ValueNamePair__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ValueNamePair__Group__1_in_rule__ValueNamePair__Group__08183);
            rule__ValueNamePair__Group__1();
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
    // $ANTLR end rule__ValueNamePair__Group__0


    // $ANTLR start rule__ValueNamePair__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3999:1: rule__ValueNamePair__Group__0__Impl : ( ( rule__ValueNamePair__PropertyAssignment_0 ) ) ;
    public final void rule__ValueNamePair__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4003:1: ( ( ( rule__ValueNamePair__PropertyAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4004:1: ( ( rule__ValueNamePair__PropertyAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4004:1: ( ( rule__ValueNamePair__PropertyAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4005:1: ( rule__ValueNamePair__PropertyAssignment_0 )
            {
             before(grammarAccess.getValueNamePairAccess().getPropertyAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4006:1: ( rule__ValueNamePair__PropertyAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4006:2: rule__ValueNamePair__PropertyAssignment_0
            {
            pushFollow(FOLLOW_rule__ValueNamePair__PropertyAssignment_0_in_rule__ValueNamePair__Group__0__Impl8210);
            rule__ValueNamePair__PropertyAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getValueNamePairAccess().getPropertyAssignment_0()); 

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
    // $ANTLR end rule__ValueNamePair__Group__0__Impl


    // $ANTLR start rule__ValueNamePair__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4016:1: rule__ValueNamePair__Group__1 : rule__ValueNamePair__Group__1__Impl rule__ValueNamePair__Group__2 ;
    public final void rule__ValueNamePair__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4020:1: ( rule__ValueNamePair__Group__1__Impl rule__ValueNamePair__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4021:2: rule__ValueNamePair__Group__1__Impl rule__ValueNamePair__Group__2
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__1__Impl_in_rule__ValueNamePair__Group__18240);
            rule__ValueNamePair__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ValueNamePair__Group__2_in_rule__ValueNamePair__Group__18243);
            rule__ValueNamePair__Group__2();
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
    // $ANTLR end rule__ValueNamePair__Group__1


    // $ANTLR start rule__ValueNamePair__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4028:1: rule__ValueNamePair__Group__1__Impl : ( '=' ) ;
    public final void rule__ValueNamePair__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4032:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4033:1: ( '=' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4033:1: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4034:1: '='
            {
             before(grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1()); 
            match(input,45,FOLLOW_45_in_rule__ValueNamePair__Group__1__Impl8271); 
             after(grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1()); 

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
    // $ANTLR end rule__ValueNamePair__Group__1__Impl


    // $ANTLR start rule__ValueNamePair__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4047:1: rule__ValueNamePair__Group__2 : rule__ValueNamePair__Group__2__Impl ;
    public final void rule__ValueNamePair__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4051:1: ( rule__ValueNamePair__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4052:2: rule__ValueNamePair__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__2__Impl_in_rule__ValueNamePair__Group__28302);
            rule__ValueNamePair__Group__2__Impl();
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
    // $ANTLR end rule__ValueNamePair__Group__2


    // $ANTLR start rule__ValueNamePair__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4058:1: rule__ValueNamePair__Group__2__Impl : ( ( rule__ValueNamePair__ValueAssignment_2 ) ) ;
    public final void rule__ValueNamePair__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4062:1: ( ( ( rule__ValueNamePair__ValueAssignment_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4063:1: ( ( rule__ValueNamePair__ValueAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4063:1: ( ( rule__ValueNamePair__ValueAssignment_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4064:1: ( rule__ValueNamePair__ValueAssignment_2 )
            {
             before(grammarAccess.getValueNamePairAccess().getValueAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4065:1: ( rule__ValueNamePair__ValueAssignment_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4065:2: rule__ValueNamePair__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ValueNamePair__ValueAssignment_2_in_rule__ValueNamePair__Group__2__Impl8329);
            rule__ValueNamePair__ValueAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getValueNamePairAccess().getValueAssignment_2()); 

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
    // $ANTLR end rule__ValueNamePair__Group__2__Impl


    // $ANTLR start rule__InstantObsExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4081:1: rule__InstantObsExpression__Group__0 : rule__InstantObsExpression__Group__0__Impl rule__InstantObsExpression__Group__1 ;
    public final void rule__InstantObsExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4085:1: ( rule__InstantObsExpression__Group__0__Impl rule__InstantObsExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4086:2: rule__InstantObsExpression__Group__0__Impl rule__InstantObsExpression__Group__1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__0__Impl_in_rule__InstantObsExpression__Group__08365);
            rule__InstantObsExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group__1_in_rule__InstantObsExpression__Group__08368);
            rule__InstantObsExpression__Group__1();
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
    // $ANTLR end rule__InstantObsExpression__Group__0


    // $ANTLR start rule__InstantObsExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4093:1: rule__InstantObsExpression__Group__0__Impl : ( '@' ) ;
    public final void rule__InstantObsExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4097:1: ( ( '@' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4098:1: ( '@' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4098:1: ( '@' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4099:1: '@'
            {
             before(grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0()); 
            match(input,46,FOLLOW_46_in_rule__InstantObsExpression__Group__0__Impl8396); 
             after(grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0()); 

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
    // $ANTLR end rule__InstantObsExpression__Group__0__Impl


    // $ANTLR start rule__InstantObsExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4112:1: rule__InstantObsExpression__Group__1 : rule__InstantObsExpression__Group__1__Impl rule__InstantObsExpression__Group__2 ;
    public final void rule__InstantObsExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4116:1: ( rule__InstantObsExpression__Group__1__Impl rule__InstantObsExpression__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4117:2: rule__InstantObsExpression__Group__1__Impl rule__InstantObsExpression__Group__2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__1__Impl_in_rule__InstantObsExpression__Group__18427);
            rule__InstantObsExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group__2_in_rule__InstantObsExpression__Group__18430);
            rule__InstantObsExpression__Group__2();
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
    // $ANTLR end rule__InstantObsExpression__Group__1


    // $ANTLR start rule__InstantObsExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4124:1: rule__InstantObsExpression__Group__1__Impl : ( ( rule__InstantObsExpression__IdAssignment_1 ) ) ;
    public final void rule__InstantObsExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4128:1: ( ( ( rule__InstantObsExpression__IdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4129:1: ( ( rule__InstantObsExpression__IdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4129:1: ( ( rule__InstantObsExpression__IdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4130:1: ( rule__InstantObsExpression__IdAssignment_1 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4131:1: ( rule__InstantObsExpression__IdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4131:2: rule__InstantObsExpression__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__IdAssignment_1_in_rule__InstantObsExpression__Group__1__Impl8457);
            rule__InstantObsExpression__IdAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getInstantObsExpressionAccess().getIdAssignment_1()); 

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
    // $ANTLR end rule__InstantObsExpression__Group__1__Impl


    // $ANTLR start rule__InstantObsExpression__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4141:1: rule__InstantObsExpression__Group__2 : rule__InstantObsExpression__Group__2__Impl rule__InstantObsExpression__Group__3 ;
    public final void rule__InstantObsExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4145:1: ( rule__InstantObsExpression__Group__2__Impl rule__InstantObsExpression__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4146:2: rule__InstantObsExpression__Group__2__Impl rule__InstantObsExpression__Group__3
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__2__Impl_in_rule__InstantObsExpression__Group__28487);
            rule__InstantObsExpression__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group__3_in_rule__InstantObsExpression__Group__28490);
            rule__InstantObsExpression__Group__3();
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
    // $ANTLR end rule__InstantObsExpression__Group__2


    // $ANTLR start rule__InstantObsExpression__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4153:1: rule__InstantObsExpression__Group__2__Impl : ( ( rule__InstantObsExpression__Group_2__0 )? ) ;
    public final void rule__InstantObsExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4157:1: ( ( ( rule__InstantObsExpression__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4158:1: ( ( rule__InstantObsExpression__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4158:1: ( ( rule__InstantObsExpression__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4159:1: ( rule__InstantObsExpression__Group_2__0 )?
            {
             before(grammarAccess.getInstantObsExpressionAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4160:1: ( rule__InstantObsExpression__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4160:2: rule__InstantObsExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__0_in_rule__InstantObsExpression__Group__2__Impl8517);
                    rule__InstantObsExpression__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstantObsExpressionAccess().getGroup_2()); 

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
    // $ANTLR end rule__InstantObsExpression__Group__2__Impl


    // $ANTLR start rule__InstantObsExpression__Group__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4170:1: rule__InstantObsExpression__Group__3 : rule__InstantObsExpression__Group__3__Impl ;
    public final void rule__InstantObsExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4174:1: ( rule__InstantObsExpression__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4175:2: rule__InstantObsExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__3__Impl_in_rule__InstantObsExpression__Group__38548);
            rule__InstantObsExpression__Group__3__Impl();
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
    // $ANTLR end rule__InstantObsExpression__Group__3


    // $ANTLR start rule__InstantObsExpression__Group__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4181:1: rule__InstantObsExpression__Group__3__Impl : ( ( rule__InstantObsExpression__Group_3__0 )? ) ;
    public final void rule__InstantObsExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4185:1: ( ( ( rule__InstantObsExpression__Group_3__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4186:1: ( ( rule__InstantObsExpression__Group_3__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4186:1: ( ( rule__InstantObsExpression__Group_3__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4187:1: ( rule__InstantObsExpression__Group_3__0 )?
            {
             before(grammarAccess.getInstantObsExpressionAccess().getGroup_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4188:1: ( rule__InstantObsExpression__Group_3__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==47) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4188:2: rule__InstantObsExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__0_in_rule__InstantObsExpression__Group__3__Impl8575);
                    rule__InstantObsExpression__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstantObsExpressionAccess().getGroup_3()); 

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
    // $ANTLR end rule__InstantObsExpression__Group__3__Impl


    // $ANTLR start rule__InstantObsExpression__Group_2__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4206:1: rule__InstantObsExpression__Group_2__0 : rule__InstantObsExpression__Group_2__0__Impl rule__InstantObsExpression__Group_2__1 ;
    public final void rule__InstantObsExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4210:1: ( rule__InstantObsExpression__Group_2__0__Impl rule__InstantObsExpression__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4211:2: rule__InstantObsExpression__Group_2__0__Impl rule__InstantObsExpression__Group_2__1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__0__Impl_in_rule__InstantObsExpression__Group_2__08614);
            rule__InstantObsExpression__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__1_in_rule__InstantObsExpression__Group_2__08617);
            rule__InstantObsExpression__Group_2__1();
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
    // $ANTLR end rule__InstantObsExpression__Group_2__0


    // $ANTLR start rule__InstantObsExpression__Group_2__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4218:1: rule__InstantObsExpression__Group_2__0__Impl : ( '(' ) ;
    public final void rule__InstantObsExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4222:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4223:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4223:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4224:1: '('
            {
             before(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,38,FOLLOW_38_in_rule__InstantObsExpression__Group_2__0__Impl8645); 
             after(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0()); 

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
    // $ANTLR end rule__InstantObsExpression__Group_2__0__Impl


    // $ANTLR start rule__InstantObsExpression__Group_2__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4237:1: rule__InstantObsExpression__Group_2__1 : rule__InstantObsExpression__Group_2__1__Impl rule__InstantObsExpression__Group_2__2 ;
    public final void rule__InstantObsExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4241:1: ( rule__InstantObsExpression__Group_2__1__Impl rule__InstantObsExpression__Group_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4242:2: rule__InstantObsExpression__Group_2__1__Impl rule__InstantObsExpression__Group_2__2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__1__Impl_in_rule__InstantObsExpression__Group_2__18676);
            rule__InstantObsExpression__Group_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__2_in_rule__InstantObsExpression__Group_2__18679);
            rule__InstantObsExpression__Group_2__2();
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
    // $ANTLR end rule__InstantObsExpression__Group_2__1


    // $ANTLR start rule__InstantObsExpression__Group_2__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4249:1: rule__InstantObsExpression__Group_2__1__Impl : ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) ) ;
    public final void rule__InstantObsExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4253:1: ( ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4254:1: ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4254:1: ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4255:1: ( rule__InstantObsExpression__IndexAssignment_2_1 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIndexAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4256:1: ( rule__InstantObsExpression__IndexAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4256:2: rule__InstantObsExpression__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__IndexAssignment_2_1_in_rule__InstantObsExpression__Group_2__1__Impl8706);
            rule__InstantObsExpression__IndexAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getInstantObsExpressionAccess().getIndexAssignment_2_1()); 

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
    // $ANTLR end rule__InstantObsExpression__Group_2__1__Impl


    // $ANTLR start rule__InstantObsExpression__Group_2__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4266:1: rule__InstantObsExpression__Group_2__2 : rule__InstantObsExpression__Group_2__2__Impl ;
    public final void rule__InstantObsExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4270:1: ( rule__InstantObsExpression__Group_2__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4271:2: rule__InstantObsExpression__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__2__Impl_in_rule__InstantObsExpression__Group_2__28736);
            rule__InstantObsExpression__Group_2__2__Impl();
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
    // $ANTLR end rule__InstantObsExpression__Group_2__2


    // $ANTLR start rule__InstantObsExpression__Group_2__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4277:1: rule__InstantObsExpression__Group_2__2__Impl : ( ')' ) ;
    public final void rule__InstantObsExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4281:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4282:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4282:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4283:1: ')'
            {
             before(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2()); 
            match(input,39,FOLLOW_39_in_rule__InstantObsExpression__Group_2__2__Impl8764); 
             after(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2()); 

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
    // $ANTLR end rule__InstantObsExpression__Group_2__2__Impl


    // $ANTLR start rule__InstantObsExpression__Group_3__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4302:1: rule__InstantObsExpression__Group_3__0 : rule__InstantObsExpression__Group_3__0__Impl rule__InstantObsExpression__Group_3__1 ;
    public final void rule__InstantObsExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4306:1: ( rule__InstantObsExpression__Group_3__0__Impl rule__InstantObsExpression__Group_3__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4307:2: rule__InstantObsExpression__Group_3__0__Impl rule__InstantObsExpression__Group_3__1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__0__Impl_in_rule__InstantObsExpression__Group_3__08801);
            rule__InstantObsExpression__Group_3__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__1_in_rule__InstantObsExpression__Group_3__08804);
            rule__InstantObsExpression__Group_3__1();
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
    // $ANTLR end rule__InstantObsExpression__Group_3__0


    // $ANTLR start rule__InstantObsExpression__Group_3__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4314:1: rule__InstantObsExpression__Group_3__0__Impl : ( 'when' ) ;
    public final void rule__InstantObsExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4318:1: ( ( 'when' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4319:1: ( 'when' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4319:1: ( 'when' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4320:1: 'when'
            {
             before(grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0()); 
            match(input,47,FOLLOW_47_in_rule__InstantObsExpression__Group_3__0__Impl8832); 
             after(grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0()); 

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
    // $ANTLR end rule__InstantObsExpression__Group_3__0__Impl


    // $ANTLR start rule__InstantObsExpression__Group_3__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4333:1: rule__InstantObsExpression__Group_3__1 : rule__InstantObsExpression__Group_3__1__Impl rule__InstantObsExpression__Group_3__2 ;
    public final void rule__InstantObsExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4337:1: ( rule__InstantObsExpression__Group_3__1__Impl rule__InstantObsExpression__Group_3__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4338:2: rule__InstantObsExpression__Group_3__1__Impl rule__InstantObsExpression__Group_3__2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__1__Impl_in_rule__InstantObsExpression__Group_3__18863);
            rule__InstantObsExpression__Group_3__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__2_in_rule__InstantObsExpression__Group_3__18866);
            rule__InstantObsExpression__Group_3__2();
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
    // $ANTLR end rule__InstantObsExpression__Group_3__1


    // $ANTLR start rule__InstantObsExpression__Group_3__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4345:1: rule__InstantObsExpression__Group_3__1__Impl : ( '(' ) ;
    public final void rule__InstantObsExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4349:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4350:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4350:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4351:1: '('
            {
             before(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,38,FOLLOW_38_in_rule__InstantObsExpression__Group_3__1__Impl8894); 
             after(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1()); 

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
    // $ANTLR end rule__InstantObsExpression__Group_3__1__Impl


    // $ANTLR start rule__InstantObsExpression__Group_3__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4364:1: rule__InstantObsExpression__Group_3__2 : rule__InstantObsExpression__Group_3__2__Impl rule__InstantObsExpression__Group_3__3 ;
    public final void rule__InstantObsExpression__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4368:1: ( rule__InstantObsExpression__Group_3__2__Impl rule__InstantObsExpression__Group_3__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4369:2: rule__InstantObsExpression__Group_3__2__Impl rule__InstantObsExpression__Group_3__3
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__2__Impl_in_rule__InstantObsExpression__Group_3__28925);
            rule__InstantObsExpression__Group_3__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__3_in_rule__InstantObsExpression__Group_3__28928);
            rule__InstantObsExpression__Group_3__3();
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
    // $ANTLR end rule__InstantObsExpression__Group_3__2


    // $ANTLR start rule__InstantObsExpression__Group_3__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4376:1: rule__InstantObsExpression__Group_3__2__Impl : ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) ) ;
    public final void rule__InstantObsExpression__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4380:1: ( ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4381:1: ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4381:1: ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4382:1: ( rule__InstantObsExpression__ConditionAssignment_3_2 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getConditionAssignment_3_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4383:1: ( rule__InstantObsExpression__ConditionAssignment_3_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4383:2: rule__InstantObsExpression__ConditionAssignment_3_2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__ConditionAssignment_3_2_in_rule__InstantObsExpression__Group_3__2__Impl8955);
            rule__InstantObsExpression__ConditionAssignment_3_2();
            _fsp--;


            }

             after(grammarAccess.getInstantObsExpressionAccess().getConditionAssignment_3_2()); 

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
    // $ANTLR end rule__InstantObsExpression__Group_3__2__Impl


    // $ANTLR start rule__InstantObsExpression__Group_3__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4393:1: rule__InstantObsExpression__Group_3__3 : rule__InstantObsExpression__Group_3__3__Impl ;
    public final void rule__InstantObsExpression__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4397:1: ( rule__InstantObsExpression__Group_3__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4398:2: rule__InstantObsExpression__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__3__Impl_in_rule__InstantObsExpression__Group_3__38985);
            rule__InstantObsExpression__Group_3__3__Impl();
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
    // $ANTLR end rule__InstantObsExpression__Group_3__3


    // $ANTLR start rule__InstantObsExpression__Group_3__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4404:1: rule__InstantObsExpression__Group_3__3__Impl : ( ')' ) ;
    public final void rule__InstantObsExpression__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4408:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4409:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4409:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4410:1: ')'
            {
             before(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_3_3()); 
            match(input,39,FOLLOW_39_in_rule__InstantObsExpression__Group_3__3__Impl9013); 
             after(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_3_3()); 

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
    // $ANTLR end rule__InstantObsExpression__Group_3__3__Impl


    // $ANTLR start rule__InstantObsName__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4431:1: rule__InstantObsName__Group__0 : rule__InstantObsName__Group__0__Impl rule__InstantObsName__Group__1 ;
    public final void rule__InstantObsName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4435:1: ( rule__InstantObsName__Group__0__Impl rule__InstantObsName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4436:2: rule__InstantObsName__Group__0__Impl rule__InstantObsName__Group__1
            {
            pushFollow(FOLLOW_rule__InstantObsName__Group__0__Impl_in_rule__InstantObsName__Group__09052);
            rule__InstantObsName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsName__Group__1_in_rule__InstantObsName__Group__09055);
            rule__InstantObsName__Group__1();
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
    // $ANTLR end rule__InstantObsName__Group__0


    // $ANTLR start rule__InstantObsName__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4443:1: rule__InstantObsName__Group__0__Impl : ( ( rule__InstantObsName__PathAssignment_0 )? ) ;
    public final void rule__InstantObsName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4447:1: ( ( ( rule__InstantObsName__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4448:1: ( ( rule__InstantObsName__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4448:1: ( ( rule__InstantObsName__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4449:1: ( rule__InstantObsName__PathAssignment_0 )?
            {
             before(grammarAccess.getInstantObsNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4450:1: ( rule__InstantObsName__PathAssignment_0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==40) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4450:2: rule__InstantObsName__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__InstantObsName__PathAssignment_0_in_rule__InstantObsName__Group__0__Impl9082);
                    rule__InstantObsName__PathAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstantObsNameAccess().getPathAssignment_0()); 

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
    // $ANTLR end rule__InstantObsName__Group__0__Impl


    // $ANTLR start rule__InstantObsName__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4460:1: rule__InstantObsName__Group__1 : rule__InstantObsName__Group__1__Impl ;
    public final void rule__InstantObsName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4464:1: ( rule__InstantObsName__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4465:2: rule__InstantObsName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsName__Group__1__Impl_in_rule__InstantObsName__Group__19113);
            rule__InstantObsName__Group__1__Impl();
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
    // $ANTLR end rule__InstantObsName__Group__1


    // $ANTLR start rule__InstantObsName__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4471:1: rule__InstantObsName__Group__1__Impl : ( ( rule__InstantObsName__InstantIdAssignment_1 ) ) ;
    public final void rule__InstantObsName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4475:1: ( ( ( rule__InstantObsName__InstantIdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4476:1: ( ( rule__InstantObsName__InstantIdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4476:1: ( ( rule__InstantObsName__InstantIdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4477:1: ( rule__InstantObsName__InstantIdAssignment_1 )
            {
             before(grammarAccess.getInstantObsNameAccess().getInstantIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4478:1: ( rule__InstantObsName__InstantIdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4478:2: rule__InstantObsName__InstantIdAssignment_1
            {
            pushFollow(FOLLOW_rule__InstantObsName__InstantIdAssignment_1_in_rule__InstantObsName__Group__1__Impl9140);
            rule__InstantObsName__InstantIdAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getInstantObsNameAccess().getInstantIdAssignment_1()); 

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
    // $ANTLR end rule__InstantObsName__Group__1__Impl


    // $ANTLR start rule__DurationObsExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4492:1: rule__DurationObsExpression__Group__0 : rule__DurationObsExpression__Group__0__Impl rule__DurationObsExpression__Group__1 ;
    public final void rule__DurationObsExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4496:1: ( rule__DurationObsExpression__Group__0__Impl rule__DurationObsExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4497:2: rule__DurationObsExpression__Group__0__Impl rule__DurationObsExpression__Group__1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__0__Impl_in_rule__DurationObsExpression__Group__09174);
            rule__DurationObsExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group__1_in_rule__DurationObsExpression__Group__09177);
            rule__DurationObsExpression__Group__1();
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
    // $ANTLR end rule__DurationObsExpression__Group__0


    // $ANTLR start rule__DurationObsExpression__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4504:1: rule__DurationObsExpression__Group__0__Impl : ( '&' ) ;
    public final void rule__DurationObsExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4508:1: ( ( '&' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4509:1: ( '&' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4509:1: ( '&' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4510:1: '&'
            {
             before(grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0()); 
            match(input,48,FOLLOW_48_in_rule__DurationObsExpression__Group__0__Impl9205); 
             after(grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0()); 

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
    // $ANTLR end rule__DurationObsExpression__Group__0__Impl


    // $ANTLR start rule__DurationObsExpression__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4523:1: rule__DurationObsExpression__Group__1 : rule__DurationObsExpression__Group__1__Impl rule__DurationObsExpression__Group__2 ;
    public final void rule__DurationObsExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4527:1: ( rule__DurationObsExpression__Group__1__Impl rule__DurationObsExpression__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4528:2: rule__DurationObsExpression__Group__1__Impl rule__DurationObsExpression__Group__2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__1__Impl_in_rule__DurationObsExpression__Group__19236);
            rule__DurationObsExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group__2_in_rule__DurationObsExpression__Group__19239);
            rule__DurationObsExpression__Group__2();
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
    // $ANTLR end rule__DurationObsExpression__Group__1


    // $ANTLR start rule__DurationObsExpression__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4535:1: rule__DurationObsExpression__Group__1__Impl : ( ( rule__DurationObsExpression__IdAssignment_1 ) ) ;
    public final void rule__DurationObsExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4539:1: ( ( ( rule__DurationObsExpression__IdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4540:1: ( ( rule__DurationObsExpression__IdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4540:1: ( ( rule__DurationObsExpression__IdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4541:1: ( rule__DurationObsExpression__IdAssignment_1 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4542:1: ( rule__DurationObsExpression__IdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4542:2: rule__DurationObsExpression__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__IdAssignment_1_in_rule__DurationObsExpression__Group__1__Impl9266);
            rule__DurationObsExpression__IdAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getDurationObsExpressionAccess().getIdAssignment_1()); 

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
    // $ANTLR end rule__DurationObsExpression__Group__1__Impl


    // $ANTLR start rule__DurationObsExpression__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4552:1: rule__DurationObsExpression__Group__2 : rule__DurationObsExpression__Group__2__Impl rule__DurationObsExpression__Group__3 ;
    public final void rule__DurationObsExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4556:1: ( rule__DurationObsExpression__Group__2__Impl rule__DurationObsExpression__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4557:2: rule__DurationObsExpression__Group__2__Impl rule__DurationObsExpression__Group__3
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__2__Impl_in_rule__DurationObsExpression__Group__29296);
            rule__DurationObsExpression__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group__3_in_rule__DurationObsExpression__Group__29299);
            rule__DurationObsExpression__Group__3();
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
    // $ANTLR end rule__DurationObsExpression__Group__2


    // $ANTLR start rule__DurationObsExpression__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4564:1: rule__DurationObsExpression__Group__2__Impl : ( ( rule__DurationObsExpression__Group_2__0 )? ) ;
    public final void rule__DurationObsExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4568:1: ( ( ( rule__DurationObsExpression__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4569:1: ( ( rule__DurationObsExpression__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4569:1: ( ( rule__DurationObsExpression__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4570:1: ( rule__DurationObsExpression__Group_2__0 )?
            {
             before(grammarAccess.getDurationObsExpressionAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4571:1: ( rule__DurationObsExpression__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==38) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4571:2: rule__DurationObsExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__0_in_rule__DurationObsExpression__Group__2__Impl9326);
                    rule__DurationObsExpression__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDurationObsExpressionAccess().getGroup_2()); 

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
    // $ANTLR end rule__DurationObsExpression__Group__2__Impl


    // $ANTLR start rule__DurationObsExpression__Group__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4581:1: rule__DurationObsExpression__Group__3 : rule__DurationObsExpression__Group__3__Impl ;
    public final void rule__DurationObsExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4585:1: ( rule__DurationObsExpression__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4586:2: rule__DurationObsExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__3__Impl_in_rule__DurationObsExpression__Group__39357);
            rule__DurationObsExpression__Group__3__Impl();
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
    // $ANTLR end rule__DurationObsExpression__Group__3


    // $ANTLR start rule__DurationObsExpression__Group__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4592:1: rule__DurationObsExpression__Group__3__Impl : ( ( rule__DurationObsExpression__Group_3__0 )? ) ;
    public final void rule__DurationObsExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4596:1: ( ( ( rule__DurationObsExpression__Group_3__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4597:1: ( ( rule__DurationObsExpression__Group_3__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4597:1: ( ( rule__DurationObsExpression__Group_3__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4598:1: ( rule__DurationObsExpression__Group_3__0 )?
            {
             before(grammarAccess.getDurationObsExpressionAccess().getGroup_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4599:1: ( rule__DurationObsExpression__Group_3__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==47) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4599:2: rule__DurationObsExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__0_in_rule__DurationObsExpression__Group__3__Impl9384);
                    rule__DurationObsExpression__Group_3__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDurationObsExpressionAccess().getGroup_3()); 

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
    // $ANTLR end rule__DurationObsExpression__Group__3__Impl


    // $ANTLR start rule__DurationObsExpression__Group_2__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4617:1: rule__DurationObsExpression__Group_2__0 : rule__DurationObsExpression__Group_2__0__Impl rule__DurationObsExpression__Group_2__1 ;
    public final void rule__DurationObsExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4621:1: ( rule__DurationObsExpression__Group_2__0__Impl rule__DurationObsExpression__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4622:2: rule__DurationObsExpression__Group_2__0__Impl rule__DurationObsExpression__Group_2__1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__0__Impl_in_rule__DurationObsExpression__Group_2__09423);
            rule__DurationObsExpression__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__1_in_rule__DurationObsExpression__Group_2__09426);
            rule__DurationObsExpression__Group_2__1();
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
    // $ANTLR end rule__DurationObsExpression__Group_2__0


    // $ANTLR start rule__DurationObsExpression__Group_2__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4629:1: rule__DurationObsExpression__Group_2__0__Impl : ( '(' ) ;
    public final void rule__DurationObsExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4633:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4634:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4634:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4635:1: '('
            {
             before(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,38,FOLLOW_38_in_rule__DurationObsExpression__Group_2__0__Impl9454); 
             after(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0()); 

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
    // $ANTLR end rule__DurationObsExpression__Group_2__0__Impl


    // $ANTLR start rule__DurationObsExpression__Group_2__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4648:1: rule__DurationObsExpression__Group_2__1 : rule__DurationObsExpression__Group_2__1__Impl rule__DurationObsExpression__Group_2__2 ;
    public final void rule__DurationObsExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4652:1: ( rule__DurationObsExpression__Group_2__1__Impl rule__DurationObsExpression__Group_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4653:2: rule__DurationObsExpression__Group_2__1__Impl rule__DurationObsExpression__Group_2__2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__1__Impl_in_rule__DurationObsExpression__Group_2__19485);
            rule__DurationObsExpression__Group_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__2_in_rule__DurationObsExpression__Group_2__19488);
            rule__DurationObsExpression__Group_2__2();
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
    // $ANTLR end rule__DurationObsExpression__Group_2__1


    // $ANTLR start rule__DurationObsExpression__Group_2__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4660:1: rule__DurationObsExpression__Group_2__1__Impl : ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) ) ;
    public final void rule__DurationObsExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4664:1: ( ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4665:1: ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4665:1: ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4666:1: ( rule__DurationObsExpression__IndexAssignment_2_1 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIndexAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4667:1: ( rule__DurationObsExpression__IndexAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4667:2: rule__DurationObsExpression__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__IndexAssignment_2_1_in_rule__DurationObsExpression__Group_2__1__Impl9515);
            rule__DurationObsExpression__IndexAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getDurationObsExpressionAccess().getIndexAssignment_2_1()); 

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
    // $ANTLR end rule__DurationObsExpression__Group_2__1__Impl


    // $ANTLR start rule__DurationObsExpression__Group_2__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4677:1: rule__DurationObsExpression__Group_2__2 : rule__DurationObsExpression__Group_2__2__Impl ;
    public final void rule__DurationObsExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4681:1: ( rule__DurationObsExpression__Group_2__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4682:2: rule__DurationObsExpression__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__2__Impl_in_rule__DurationObsExpression__Group_2__29545);
            rule__DurationObsExpression__Group_2__2__Impl();
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
    // $ANTLR end rule__DurationObsExpression__Group_2__2


    // $ANTLR start rule__DurationObsExpression__Group_2__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4688:1: rule__DurationObsExpression__Group_2__2__Impl : ( ')' ) ;
    public final void rule__DurationObsExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4692:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4693:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4693:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4694:1: ')'
            {
             before(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2()); 
            match(input,39,FOLLOW_39_in_rule__DurationObsExpression__Group_2__2__Impl9573); 
             after(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2()); 

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
    // $ANTLR end rule__DurationObsExpression__Group_2__2__Impl


    // $ANTLR start rule__DurationObsExpression__Group_3__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4713:1: rule__DurationObsExpression__Group_3__0 : rule__DurationObsExpression__Group_3__0__Impl rule__DurationObsExpression__Group_3__1 ;
    public final void rule__DurationObsExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4717:1: ( rule__DurationObsExpression__Group_3__0__Impl rule__DurationObsExpression__Group_3__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4718:2: rule__DurationObsExpression__Group_3__0__Impl rule__DurationObsExpression__Group_3__1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__0__Impl_in_rule__DurationObsExpression__Group_3__09610);
            rule__DurationObsExpression__Group_3__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__1_in_rule__DurationObsExpression__Group_3__09613);
            rule__DurationObsExpression__Group_3__1();
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
    // $ANTLR end rule__DurationObsExpression__Group_3__0


    // $ANTLR start rule__DurationObsExpression__Group_3__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4725:1: rule__DurationObsExpression__Group_3__0__Impl : ( 'when' ) ;
    public final void rule__DurationObsExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4729:1: ( ( 'when' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4730:1: ( 'when' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4730:1: ( 'when' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4731:1: 'when'
            {
             before(grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0()); 
            match(input,47,FOLLOW_47_in_rule__DurationObsExpression__Group_3__0__Impl9641); 
             after(grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0()); 

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
    // $ANTLR end rule__DurationObsExpression__Group_3__0__Impl


    // $ANTLR start rule__DurationObsExpression__Group_3__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4744:1: rule__DurationObsExpression__Group_3__1 : rule__DurationObsExpression__Group_3__1__Impl rule__DurationObsExpression__Group_3__2 ;
    public final void rule__DurationObsExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4748:1: ( rule__DurationObsExpression__Group_3__1__Impl rule__DurationObsExpression__Group_3__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4749:2: rule__DurationObsExpression__Group_3__1__Impl rule__DurationObsExpression__Group_3__2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__1__Impl_in_rule__DurationObsExpression__Group_3__19672);
            rule__DurationObsExpression__Group_3__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__2_in_rule__DurationObsExpression__Group_3__19675);
            rule__DurationObsExpression__Group_3__2();
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
    // $ANTLR end rule__DurationObsExpression__Group_3__1


    // $ANTLR start rule__DurationObsExpression__Group_3__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4756:1: rule__DurationObsExpression__Group_3__1__Impl : ( '(' ) ;
    public final void rule__DurationObsExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4760:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4761:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4761:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4762:1: '('
            {
             before(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,38,FOLLOW_38_in_rule__DurationObsExpression__Group_3__1__Impl9703); 
             after(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1()); 

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
    // $ANTLR end rule__DurationObsExpression__Group_3__1__Impl


    // $ANTLR start rule__DurationObsExpression__Group_3__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4775:1: rule__DurationObsExpression__Group_3__2 : rule__DurationObsExpression__Group_3__2__Impl rule__DurationObsExpression__Group_3__3 ;
    public final void rule__DurationObsExpression__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4779:1: ( rule__DurationObsExpression__Group_3__2__Impl rule__DurationObsExpression__Group_3__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4780:2: rule__DurationObsExpression__Group_3__2__Impl rule__DurationObsExpression__Group_3__3
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__2__Impl_in_rule__DurationObsExpression__Group_3__29734);
            rule__DurationObsExpression__Group_3__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__3_in_rule__DurationObsExpression__Group_3__29737);
            rule__DurationObsExpression__Group_3__3();
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
    // $ANTLR end rule__DurationObsExpression__Group_3__2


    // $ANTLR start rule__DurationObsExpression__Group_3__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4787:1: rule__DurationObsExpression__Group_3__2__Impl : ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) ) ;
    public final void rule__DurationObsExpression__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4791:1: ( ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4792:1: ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4792:1: ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4793:1: ( rule__DurationObsExpression__ConditionAssignment_3_2 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getConditionAssignment_3_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4794:1: ( rule__DurationObsExpression__ConditionAssignment_3_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4794:2: rule__DurationObsExpression__ConditionAssignment_3_2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__ConditionAssignment_3_2_in_rule__DurationObsExpression__Group_3__2__Impl9764);
            rule__DurationObsExpression__ConditionAssignment_3_2();
            _fsp--;


            }

             after(grammarAccess.getDurationObsExpressionAccess().getConditionAssignment_3_2()); 

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
    // $ANTLR end rule__DurationObsExpression__Group_3__2__Impl


    // $ANTLR start rule__DurationObsExpression__Group_3__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4804:1: rule__DurationObsExpression__Group_3__3 : rule__DurationObsExpression__Group_3__3__Impl ;
    public final void rule__DurationObsExpression__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4808:1: ( rule__DurationObsExpression__Group_3__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4809:2: rule__DurationObsExpression__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__3__Impl_in_rule__DurationObsExpression__Group_3__39794);
            rule__DurationObsExpression__Group_3__3__Impl();
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
    // $ANTLR end rule__DurationObsExpression__Group_3__3


    // $ANTLR start rule__DurationObsExpression__Group_3__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4815:1: rule__DurationObsExpression__Group_3__3__Impl : ( ')' ) ;
    public final void rule__DurationObsExpression__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4819:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4820:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4820:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4821:1: ')'
            {
             before(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_3_3()); 
            match(input,39,FOLLOW_39_in_rule__DurationObsExpression__Group_3__3__Impl9822); 
             after(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_3_3()); 

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
    // $ANTLR end rule__DurationObsExpression__Group_3__3__Impl


    // $ANTLR start rule__DurationObsName__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4842:1: rule__DurationObsName__Group__0 : rule__DurationObsName__Group__0__Impl rule__DurationObsName__Group__1 ;
    public final void rule__DurationObsName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4846:1: ( rule__DurationObsName__Group__0__Impl rule__DurationObsName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4847:2: rule__DurationObsName__Group__0__Impl rule__DurationObsName__Group__1
            {
            pushFollow(FOLLOW_rule__DurationObsName__Group__0__Impl_in_rule__DurationObsName__Group__09861);
            rule__DurationObsName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsName__Group__1_in_rule__DurationObsName__Group__09864);
            rule__DurationObsName__Group__1();
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
    // $ANTLR end rule__DurationObsName__Group__0


    // $ANTLR start rule__DurationObsName__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4854:1: rule__DurationObsName__Group__0__Impl : ( ( rule__DurationObsName__PathAssignment_0 )? ) ;
    public final void rule__DurationObsName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4858:1: ( ( ( rule__DurationObsName__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4859:1: ( ( rule__DurationObsName__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4859:1: ( ( rule__DurationObsName__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4860:1: ( rule__DurationObsName__PathAssignment_0 )?
            {
             before(grammarAccess.getDurationObsNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4861:1: ( rule__DurationObsName__PathAssignment_0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==40) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4861:2: rule__DurationObsName__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DurationObsName__PathAssignment_0_in_rule__DurationObsName__Group__0__Impl9891);
                    rule__DurationObsName__PathAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDurationObsNameAccess().getPathAssignment_0()); 

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
    // $ANTLR end rule__DurationObsName__Group__0__Impl


    // $ANTLR start rule__DurationObsName__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4871:1: rule__DurationObsName__Group__1 : rule__DurationObsName__Group__1__Impl ;
    public final void rule__DurationObsName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4875:1: ( rule__DurationObsName__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4876:2: rule__DurationObsName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsName__Group__1__Impl_in_rule__DurationObsName__Group__19922);
            rule__DurationObsName__Group__1__Impl();
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
    // $ANTLR end rule__DurationObsName__Group__1


    // $ANTLR start rule__DurationObsName__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4882:1: rule__DurationObsName__Group__1__Impl : ( ( rule__DurationObsName__DurationIdAssignment_1 ) ) ;
    public final void rule__DurationObsName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4886:1: ( ( ( rule__DurationObsName__DurationIdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4887:1: ( ( rule__DurationObsName__DurationIdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4887:1: ( ( rule__DurationObsName__DurationIdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4888:1: ( rule__DurationObsName__DurationIdAssignment_1 )
            {
             before(grammarAccess.getDurationObsNameAccess().getDurationIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4889:1: ( rule__DurationObsName__DurationIdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4889:2: rule__DurationObsName__DurationIdAssignment_1
            {
            pushFollow(FOLLOW_rule__DurationObsName__DurationIdAssignment_1_in_rule__DurationObsName__Group__1__Impl9949);
            rule__DurationObsName__DurationIdAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getDurationObsNameAccess().getDurationIdAssignment_1()); 

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
    // $ANTLR end rule__DurationObsName__Group__1__Impl


    // $ANTLR start rule__JitterExp__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4903:1: rule__JitterExp__Group__0 : rule__JitterExp__Group__0__Impl rule__JitterExp__Group__1 ;
    public final void rule__JitterExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4907:1: ( rule__JitterExp__Group__0__Impl rule__JitterExp__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4908:2: rule__JitterExp__Group__0__Impl rule__JitterExp__Group__1
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__0__Impl_in_rule__JitterExp__Group__09983);
            rule__JitterExp__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group__1_in_rule__JitterExp__Group__09986);
            rule__JitterExp__Group__1();
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
    // $ANTLR end rule__JitterExp__Group__0


    // $ANTLR start rule__JitterExp__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4915:1: rule__JitterExp__Group__0__Impl : ( 'jitter(' ) ;
    public final void rule__JitterExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4919:1: ( ( 'jitter(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4920:1: ( 'jitter(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4920:1: ( 'jitter(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4921:1: 'jitter('
            {
             before(grammarAccess.getJitterExpAccess().getJitterKeyword_0()); 
            match(input,49,FOLLOW_49_in_rule__JitterExp__Group__0__Impl10014); 
             after(grammarAccess.getJitterExpAccess().getJitterKeyword_0()); 

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
    // $ANTLR end rule__JitterExp__Group__0__Impl


    // $ANTLR start rule__JitterExp__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4934:1: rule__JitterExp__Group__1 : rule__JitterExp__Group__1__Impl rule__JitterExp__Group__2 ;
    public final void rule__JitterExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4938:1: ( rule__JitterExp__Group__1__Impl rule__JitterExp__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4939:2: rule__JitterExp__Group__1__Impl rule__JitterExp__Group__2
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__1__Impl_in_rule__JitterExp__Group__110045);
            rule__JitterExp__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group__2_in_rule__JitterExp__Group__110048);
            rule__JitterExp__Group__2();
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
    // $ANTLR end rule__JitterExp__Group__1


    // $ANTLR start rule__JitterExp__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4946:1: rule__JitterExp__Group__1__Impl : ( ( rule__JitterExp__FirstInstantAssignment_1 ) ) ;
    public final void rule__JitterExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4950:1: ( ( ( rule__JitterExp__FirstInstantAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4951:1: ( ( rule__JitterExp__FirstInstantAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4951:1: ( ( rule__JitterExp__FirstInstantAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4952:1: ( rule__JitterExp__FirstInstantAssignment_1 )
            {
             before(grammarAccess.getJitterExpAccess().getFirstInstantAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4953:1: ( rule__JitterExp__FirstInstantAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4953:2: rule__JitterExp__FirstInstantAssignment_1
            {
            pushFollow(FOLLOW_rule__JitterExp__FirstInstantAssignment_1_in_rule__JitterExp__Group__1__Impl10075);
            rule__JitterExp__FirstInstantAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getJitterExpAccess().getFirstInstantAssignment_1()); 

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
    // $ANTLR end rule__JitterExp__Group__1__Impl


    // $ANTLR start rule__JitterExp__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4963:1: rule__JitterExp__Group__2 : rule__JitterExp__Group__2__Impl rule__JitterExp__Group__3 ;
    public final void rule__JitterExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4967:1: ( rule__JitterExp__Group__2__Impl rule__JitterExp__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4968:2: rule__JitterExp__Group__2__Impl rule__JitterExp__Group__3
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__2__Impl_in_rule__JitterExp__Group__210105);
            rule__JitterExp__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group__3_in_rule__JitterExp__Group__210108);
            rule__JitterExp__Group__3();
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
    // $ANTLR end rule__JitterExp__Group__2


    // $ANTLR start rule__JitterExp__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4975:1: rule__JitterExp__Group__2__Impl : ( ( rule__JitterExp__Group_2__0 )? ) ;
    public final void rule__JitterExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4979:1: ( ( ( rule__JitterExp__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4980:1: ( ( rule__JitterExp__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4980:1: ( ( rule__JitterExp__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4981:1: ( rule__JitterExp__Group_2__0 )?
            {
             before(grammarAccess.getJitterExpAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4982:1: ( rule__JitterExp__Group_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==26) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4982:2: rule__JitterExp__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__JitterExp__Group_2__0_in_rule__JitterExp__Group__2__Impl10135);
                    rule__JitterExp__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJitterExpAccess().getGroup_2()); 

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
    // $ANTLR end rule__JitterExp__Group__2__Impl


    // $ANTLR start rule__JitterExp__Group__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4992:1: rule__JitterExp__Group__3 : rule__JitterExp__Group__3__Impl ;
    public final void rule__JitterExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4996:1: ( rule__JitterExp__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4997:2: rule__JitterExp__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__3__Impl_in_rule__JitterExp__Group__310166);
            rule__JitterExp__Group__3__Impl();
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
    // $ANTLR end rule__JitterExp__Group__3


    // $ANTLR start rule__JitterExp__Group__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5003:1: rule__JitterExp__Group__3__Impl : ( ')' ) ;
    public final void rule__JitterExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5007:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5008:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5008:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5009:1: ')'
            {
             before(grammarAccess.getJitterExpAccess().getRightParenthesisKeyword_3()); 
            match(input,39,FOLLOW_39_in_rule__JitterExp__Group__3__Impl10194); 
             after(grammarAccess.getJitterExpAccess().getRightParenthesisKeyword_3()); 

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
    // $ANTLR end rule__JitterExp__Group__3__Impl


    // $ANTLR start rule__JitterExp__Group_2__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5030:1: rule__JitterExp__Group_2__0 : rule__JitterExp__Group_2__0__Impl rule__JitterExp__Group_2__1 ;
    public final void rule__JitterExp__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5034:1: ( rule__JitterExp__Group_2__0__Impl rule__JitterExp__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5035:2: rule__JitterExp__Group_2__0__Impl rule__JitterExp__Group_2__1
            {
            pushFollow(FOLLOW_rule__JitterExp__Group_2__0__Impl_in_rule__JitterExp__Group_2__010233);
            rule__JitterExp__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group_2__1_in_rule__JitterExp__Group_2__010236);
            rule__JitterExp__Group_2__1();
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
    // $ANTLR end rule__JitterExp__Group_2__0


    // $ANTLR start rule__JitterExp__Group_2__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5042:1: rule__JitterExp__Group_2__0__Impl : ( '-' ) ;
    public final void rule__JitterExp__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5046:1: ( ( '-' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5047:1: ( '-' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5047:1: ( '-' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5048:1: '-'
            {
             before(grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__JitterExp__Group_2__0__Impl10264); 
             after(grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0()); 

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
    // $ANTLR end rule__JitterExp__Group_2__0__Impl


    // $ANTLR start rule__JitterExp__Group_2__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5061:1: rule__JitterExp__Group_2__1 : rule__JitterExp__Group_2__1__Impl ;
    public final void rule__JitterExp__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5065:1: ( rule__JitterExp__Group_2__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5066:2: rule__JitterExp__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__JitterExp__Group_2__1__Impl_in_rule__JitterExp__Group_2__110295);
            rule__JitterExp__Group_2__1__Impl();
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
    // $ANTLR end rule__JitterExp__Group_2__1


    // $ANTLR start rule__JitterExp__Group_2__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5072:1: rule__JitterExp__Group_2__1__Impl : ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) ) ;
    public final void rule__JitterExp__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5076:1: ( ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5077:1: ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5077:1: ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5078:1: ( rule__JitterExp__SecondInstantAssignment_2_1 )
            {
             before(grammarAccess.getJitterExpAccess().getSecondInstantAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5079:1: ( rule__JitterExp__SecondInstantAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5079:2: rule__JitterExp__SecondInstantAssignment_2_1
            {
            pushFollow(FOLLOW_rule__JitterExp__SecondInstantAssignment_2_1_in_rule__JitterExp__Group_2__1__Impl10322);
            rule__JitterExp__SecondInstantAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getJitterExpAccess().getSecondInstantAssignment_2_1()); 

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
    // $ANTLR end rule__JitterExp__Group_2__1__Impl


    // $ANTLR start rule__VariableDeclaration__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5093:1: rule__VariableDeclaration__Group__0 : rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 ;
    public final void rule__VariableDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5097:1: ( rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5098:2: rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__0__Impl_in_rule__VariableDeclaration__Group__010356);
            rule__VariableDeclaration__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group__1_in_rule__VariableDeclaration__Group__010359);
            rule__VariableDeclaration__Group__1();
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
    // $ANTLR end rule__VariableDeclaration__Group__0


    // $ANTLR start rule__VariableDeclaration__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5105:1: rule__VariableDeclaration__Group__0__Impl : ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? ) ;
    public final void rule__VariableDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5109:1: ( ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5110:1: ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5110:1: ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5111:1: ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )?
            {
             before(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5112:1: ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=33 && LA40_0<=35)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5112:2: rule__VariableDeclaration__VariableDeclarationAssignment_0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__VariableDeclarationAssignment_0_in_rule__VariableDeclaration__Group__0__Impl10386);
                    rule__VariableDeclaration__VariableDeclarationAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAssignment_0()); 

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
    // $ANTLR end rule__VariableDeclaration__Group__0__Impl


    // $ANTLR start rule__VariableDeclaration__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5122:1: rule__VariableDeclaration__Group__1 : rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2 ;
    public final void rule__VariableDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5126:1: ( rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5127:2: rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__1__Impl_in_rule__VariableDeclaration__Group__110417);
            rule__VariableDeclaration__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group__2_in_rule__VariableDeclaration__Group__110420);
            rule__VariableDeclaration__Group__2();
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
    // $ANTLR end rule__VariableDeclaration__Group__1


    // $ANTLR start rule__VariableDeclaration__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5134:1: rule__VariableDeclaration__Group__1__Impl : ( '$' ) ;
    public final void rule__VariableDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5138:1: ( ( '$' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5139:1: ( '$' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5139:1: ( '$' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5140:1: '$'
            {
             before(grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1()); 
            match(input,50,FOLLOW_50_in_rule__VariableDeclaration__Group__1__Impl10448); 
             after(grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1()); 

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
    // $ANTLR end rule__VariableDeclaration__Group__1__Impl


    // $ANTLR start rule__VariableDeclaration__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5153:1: rule__VariableDeclaration__Group__2 : rule__VariableDeclaration__Group__2__Impl rule__VariableDeclaration__Group__3 ;
    public final void rule__VariableDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5157:1: ( rule__VariableDeclaration__Group__2__Impl rule__VariableDeclaration__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5158:2: rule__VariableDeclaration__Group__2__Impl rule__VariableDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__2__Impl_in_rule__VariableDeclaration__Group__210479);
            rule__VariableDeclaration__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group__3_in_rule__VariableDeclaration__Group__210482);
            rule__VariableDeclaration__Group__3();
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
    // $ANTLR end rule__VariableDeclaration__Group__2


    // $ANTLR start rule__VariableDeclaration__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5165:1: rule__VariableDeclaration__Group__2__Impl : ( ( rule__VariableDeclaration__NameAssignment_2 ) ) ;
    public final void rule__VariableDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5169:1: ( ( ( rule__VariableDeclaration__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5170:1: ( ( rule__VariableDeclaration__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5170:1: ( ( rule__VariableDeclaration__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5171:1: ( rule__VariableDeclaration__NameAssignment_2 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5172:1: ( rule__VariableDeclaration__NameAssignment_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5172:2: rule__VariableDeclaration__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__NameAssignment_2_in_rule__VariableDeclaration__Group__2__Impl10509);
            rule__VariableDeclaration__NameAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2()); 

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
    // $ANTLR end rule__VariableDeclaration__Group__2__Impl


    // $ANTLR start rule__VariableDeclaration__Group__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5182:1: rule__VariableDeclaration__Group__3 : rule__VariableDeclaration__Group__3__Impl ;
    public final void rule__VariableDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5186:1: ( rule__VariableDeclaration__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5187:2: rule__VariableDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__3__Impl_in_rule__VariableDeclaration__Group__310539);
            rule__VariableDeclaration__Group__3__Impl();
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
    // $ANTLR end rule__VariableDeclaration__Group__3


    // $ANTLR start rule__VariableDeclaration__Group__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5193:1: rule__VariableDeclaration__Group__3__Impl : ( ( rule__VariableDeclaration__Alternatives_3 ) ) ;
    public final void rule__VariableDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5197:1: ( ( ( rule__VariableDeclaration__Alternatives_3 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5198:1: ( ( rule__VariableDeclaration__Alternatives_3 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5198:1: ( ( rule__VariableDeclaration__Alternatives_3 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5199:1: ( rule__VariableDeclaration__Alternatives_3 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getAlternatives_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5200:1: ( rule__VariableDeclaration__Alternatives_3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5200:2: rule__VariableDeclaration__Alternatives_3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Alternatives_3_in_rule__VariableDeclaration__Group__3__Impl10566);
            rule__VariableDeclaration__Alternatives_3();
            _fsp--;


            }

             after(grammarAccess.getVariableDeclarationAccess().getAlternatives_3()); 

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
    // $ANTLR end rule__VariableDeclaration__Group__3__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_0__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5218:1: rule__VariableDeclaration__Group_3_0__0 : rule__VariableDeclaration__Group_3_0__0__Impl rule__VariableDeclaration__Group_3_0__1 ;
    public final void rule__VariableDeclaration__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5222:1: ( rule__VariableDeclaration__Group_3_0__0__Impl rule__VariableDeclaration__Group_3_0__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5223:2: rule__VariableDeclaration__Group_3_0__0__Impl rule__VariableDeclaration__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__0__Impl_in_rule__VariableDeclaration__Group_3_0__010604);
            rule__VariableDeclaration__Group_3_0__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__1_in_rule__VariableDeclaration__Group_3_0__010607);
            rule__VariableDeclaration__Group_3_0__1();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_0__0


    // $ANTLR start rule__VariableDeclaration__Group_3_0__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5230:1: rule__VariableDeclaration__Group_3_0__0__Impl : ( ':' ) ;
    public final void rule__VariableDeclaration__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5234:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5235:1: ( ':' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5235:1: ( ':' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5236:1: ':'
            {
             before(grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0()); 
            match(input,36,FOLLOW_36_in_rule__VariableDeclaration__Group_3_0__0__Impl10635); 
             after(grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_0__0__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_0__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5249:1: rule__VariableDeclaration__Group_3_0__1 : rule__VariableDeclaration__Group_3_0__1__Impl rule__VariableDeclaration__Group_3_0__2 ;
    public final void rule__VariableDeclaration__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5253:1: ( rule__VariableDeclaration__Group_3_0__1__Impl rule__VariableDeclaration__Group_3_0__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5254:2: rule__VariableDeclaration__Group_3_0__1__Impl rule__VariableDeclaration__Group_3_0__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__1__Impl_in_rule__VariableDeclaration__Group_3_0__110666);
            rule__VariableDeclaration__Group_3_0__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__2_in_rule__VariableDeclaration__Group_3_0__110669);
            rule__VariableDeclaration__Group_3_0__2();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_0__1


    // $ANTLR start rule__VariableDeclaration__Group_3_0__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5261:1: rule__VariableDeclaration__Group_3_0__1__Impl : ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) ) ;
    public final void rule__VariableDeclaration__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5265:1: ( ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5266:1: ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5266:1: ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5267:1: ( rule__VariableDeclaration__TypeAssignment_3_0_1 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_3_0_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5268:1: ( rule__VariableDeclaration__TypeAssignment_3_0_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5268:2: rule__VariableDeclaration__TypeAssignment_3_0_1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__TypeAssignment_3_0_1_in_rule__VariableDeclaration__Group_3_0__1__Impl10696);
            rule__VariableDeclaration__TypeAssignment_3_0_1();
            _fsp--;


            }

             after(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_3_0_1()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_0__1__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_0__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5278:1: rule__VariableDeclaration__Group_3_0__2 : rule__VariableDeclaration__Group_3_0__2__Impl ;
    public final void rule__VariableDeclaration__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5282:1: ( rule__VariableDeclaration__Group_3_0__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5283:2: rule__VariableDeclaration__Group_3_0__2__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__2__Impl_in_rule__VariableDeclaration__Group_3_0__210726);
            rule__VariableDeclaration__Group_3_0__2__Impl();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_0__2


    // $ANTLR start rule__VariableDeclaration__Group_3_0__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5289:1: rule__VariableDeclaration__Group_3_0__2__Impl : ( ( rule__VariableDeclaration__Group_3_0_2__0 )? ) ;
    public final void rule__VariableDeclaration__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5293:1: ( ( ( rule__VariableDeclaration__Group_3_0_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5294:1: ( ( rule__VariableDeclaration__Group_3_0_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5294:1: ( ( rule__VariableDeclaration__Group_3_0_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5295:1: ( rule__VariableDeclaration__Group_3_0_2__0 )?
            {
             before(grammarAccess.getVariableDeclarationAccess().getGroup_3_0_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5296:1: ( rule__VariableDeclaration__Group_3_0_2__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==45) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5296:2: rule__VariableDeclaration__Group_3_0_2__0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__0_in_rule__VariableDeclaration__Group_3_0__2__Impl10753);
                    rule__VariableDeclaration__Group_3_0_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableDeclarationAccess().getGroup_3_0_2()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_0__2__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_0_2__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5312:1: rule__VariableDeclaration__Group_3_0_2__0 : rule__VariableDeclaration__Group_3_0_2__0__Impl rule__VariableDeclaration__Group_3_0_2__1 ;
    public final void rule__VariableDeclaration__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5316:1: ( rule__VariableDeclaration__Group_3_0_2__0__Impl rule__VariableDeclaration__Group_3_0_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5317:2: rule__VariableDeclaration__Group_3_0_2__0__Impl rule__VariableDeclaration__Group_3_0_2__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__0__Impl_in_rule__VariableDeclaration__Group_3_0_2__010790);
            rule__VariableDeclaration__Group_3_0_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__1_in_rule__VariableDeclaration__Group_3_0_2__010793);
            rule__VariableDeclaration__Group_3_0_2__1();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_0_2__0


    // $ANTLR start rule__VariableDeclaration__Group_3_0_2__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5324:1: rule__VariableDeclaration__Group_3_0_2__0__Impl : ( '=' ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5328:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5329:1: ( '=' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5329:1: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5330:1: '='
            {
             before(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0()); 
            match(input,45,FOLLOW_45_in_rule__VariableDeclaration__Group_3_0_2__0__Impl10821); 
             after(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_0_2__0__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_0_2__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5343:1: rule__VariableDeclaration__Group_3_0_2__1 : rule__VariableDeclaration__Group_3_0_2__1__Impl rule__VariableDeclaration__Group_3_0_2__2 ;
    public final void rule__VariableDeclaration__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5347:1: ( rule__VariableDeclaration__Group_3_0_2__1__Impl rule__VariableDeclaration__Group_3_0_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5348:2: rule__VariableDeclaration__Group_3_0_2__1__Impl rule__VariableDeclaration__Group_3_0_2__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__1__Impl_in_rule__VariableDeclaration__Group_3_0_2__110852);
            rule__VariableDeclaration__Group_3_0_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__2_in_rule__VariableDeclaration__Group_3_0_2__110855);
            rule__VariableDeclaration__Group_3_0_2__2();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_0_2__1


    // $ANTLR start rule__VariableDeclaration__Group_3_0_2__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5355:1: rule__VariableDeclaration__Group_3_0_2__1__Impl : ( '(' ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5359:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5360:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5360:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5361:1: '('
            {
             before(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1()); 
            match(input,38,FOLLOW_38_in_rule__VariableDeclaration__Group_3_0_2__1__Impl10883); 
             after(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_0_2__1__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_0_2__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5374:1: rule__VariableDeclaration__Group_3_0_2__2 : rule__VariableDeclaration__Group_3_0_2__2__Impl rule__VariableDeclaration__Group_3_0_2__3 ;
    public final void rule__VariableDeclaration__Group_3_0_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5378:1: ( rule__VariableDeclaration__Group_3_0_2__2__Impl rule__VariableDeclaration__Group_3_0_2__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5379:2: rule__VariableDeclaration__Group_3_0_2__2__Impl rule__VariableDeclaration__Group_3_0_2__3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__2__Impl_in_rule__VariableDeclaration__Group_3_0_2__210914);
            rule__VariableDeclaration__Group_3_0_2__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__3_in_rule__VariableDeclaration__Group_3_0_2__210917);
            rule__VariableDeclaration__Group_3_0_2__3();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_0_2__2


    // $ANTLR start rule__VariableDeclaration__Group_3_0_2__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5386:1: rule__VariableDeclaration__Group_3_0_2__2__Impl : ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5390:1: ( ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5391:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5391:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5392:1: ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueAssignment_3_0_2_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5393:1: ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5393:2: rule__VariableDeclaration__InitValueAssignment_3_0_2_2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_0_2_2_in_rule__VariableDeclaration__Group_3_0_2__2__Impl10944);
            rule__VariableDeclaration__InitValueAssignment_3_0_2_2();
            _fsp--;


            }

             after(grammarAccess.getVariableDeclarationAccess().getInitValueAssignment_3_0_2_2()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_0_2__2__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_0_2__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5403:1: rule__VariableDeclaration__Group_3_0_2__3 : rule__VariableDeclaration__Group_3_0_2__3__Impl ;
    public final void rule__VariableDeclaration__Group_3_0_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5407:1: ( rule__VariableDeclaration__Group_3_0_2__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5408:2: rule__VariableDeclaration__Group_3_0_2__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__3__Impl_in_rule__VariableDeclaration__Group_3_0_2__310974);
            rule__VariableDeclaration__Group_3_0_2__3__Impl();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_0_2__3


    // $ANTLR start rule__VariableDeclaration__Group_3_0_2__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5414:1: rule__VariableDeclaration__Group_3_0_2__3__Impl : ( ')' ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5418:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5419:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5419:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5420:1: ')'
            {
             before(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3()); 
            match(input,39,FOLLOW_39_in_rule__VariableDeclaration__Group_3_0_2__3__Impl11002); 
             after(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_0_2__3__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_1__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5441:1: rule__VariableDeclaration__Group_3_1__0 : rule__VariableDeclaration__Group_3_1__0__Impl rule__VariableDeclaration__Group_3_1__1 ;
    public final void rule__VariableDeclaration__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5445:1: ( rule__VariableDeclaration__Group_3_1__0__Impl rule__VariableDeclaration__Group_3_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5446:2: rule__VariableDeclaration__Group_3_1__0__Impl rule__VariableDeclaration__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__0__Impl_in_rule__VariableDeclaration__Group_3_1__011041);
            rule__VariableDeclaration__Group_3_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__1_in_rule__VariableDeclaration__Group_3_1__011044);
            rule__VariableDeclaration__Group_3_1__1();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_1__0


    // $ANTLR start rule__VariableDeclaration__Group_3_1__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5453:1: rule__VariableDeclaration__Group_3_1__0__Impl : ( '=' ) ;
    public final void rule__VariableDeclaration__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5457:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5458:1: ( '=' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5458:1: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5459:1: '='
            {
             before(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0()); 
            match(input,45,FOLLOW_45_in_rule__VariableDeclaration__Group_3_1__0__Impl11072); 
             after(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_1__0__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_1__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5472:1: rule__VariableDeclaration__Group_3_1__1 : rule__VariableDeclaration__Group_3_1__1__Impl rule__VariableDeclaration__Group_3_1__2 ;
    public final void rule__VariableDeclaration__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5476:1: ( rule__VariableDeclaration__Group_3_1__1__Impl rule__VariableDeclaration__Group_3_1__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5477:2: rule__VariableDeclaration__Group_3_1__1__Impl rule__VariableDeclaration__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__1__Impl_in_rule__VariableDeclaration__Group_3_1__111103);
            rule__VariableDeclaration__Group_3_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__2_in_rule__VariableDeclaration__Group_3_1__111106);
            rule__VariableDeclaration__Group_3_1__2();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_1__1


    // $ANTLR start rule__VariableDeclaration__Group_3_1__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5484:1: rule__VariableDeclaration__Group_3_1__1__Impl : ( '(' ) ;
    public final void rule__VariableDeclaration__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5488:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5489:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5489:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5490:1: '('
            {
             before(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1()); 
            match(input,38,FOLLOW_38_in_rule__VariableDeclaration__Group_3_1__1__Impl11134); 
             after(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_1__1__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_1__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5503:1: rule__VariableDeclaration__Group_3_1__2 : rule__VariableDeclaration__Group_3_1__2__Impl rule__VariableDeclaration__Group_3_1__3 ;
    public final void rule__VariableDeclaration__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5507:1: ( rule__VariableDeclaration__Group_3_1__2__Impl rule__VariableDeclaration__Group_3_1__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5508:2: rule__VariableDeclaration__Group_3_1__2__Impl rule__VariableDeclaration__Group_3_1__3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__2__Impl_in_rule__VariableDeclaration__Group_3_1__211165);
            rule__VariableDeclaration__Group_3_1__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__3_in_rule__VariableDeclaration__Group_3_1__211168);
            rule__VariableDeclaration__Group_3_1__3();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_1__2


    // $ANTLR start rule__VariableDeclaration__Group_3_1__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5515:1: rule__VariableDeclaration__Group_3_1__2__Impl : ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) ) ;
    public final void rule__VariableDeclaration__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5519:1: ( ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5520:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5520:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5521:1: ( rule__VariableDeclaration__InitValueAssignment_3_1_2 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueAssignment_3_1_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5522:1: ( rule__VariableDeclaration__InitValueAssignment_3_1_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5522:2: rule__VariableDeclaration__InitValueAssignment_3_1_2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_1_2_in_rule__VariableDeclaration__Group_3_1__2__Impl11195);
            rule__VariableDeclaration__InitValueAssignment_3_1_2();
            _fsp--;


            }

             after(grammarAccess.getVariableDeclarationAccess().getInitValueAssignment_3_1_2()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_1__2__Impl


    // $ANTLR start rule__VariableDeclaration__Group_3_1__3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5532:1: rule__VariableDeclaration__Group_3_1__3 : rule__VariableDeclaration__Group_3_1__3__Impl ;
    public final void rule__VariableDeclaration__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5536:1: ( rule__VariableDeclaration__Group_3_1__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5537:2: rule__VariableDeclaration__Group_3_1__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__3__Impl_in_rule__VariableDeclaration__Group_3_1__311225);
            rule__VariableDeclaration__Group_3_1__3__Impl();
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
    // $ANTLR end rule__VariableDeclaration__Group_3_1__3


    // $ANTLR start rule__VariableDeclaration__Group_3_1__3__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5543:1: rule__VariableDeclaration__Group_3_1__3__Impl : ( ')' ) ;
    public final void rule__VariableDeclaration__Group_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5547:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5548:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5548:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5549:1: ')'
            {
             before(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_1_3()); 
            match(input,39,FOLLOW_39_in_rule__VariableDeclaration__Group_3_1__3__Impl11253); 
             after(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_1_3()); 

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
    // $ANTLR end rule__VariableDeclaration__Group_3_1__3__Impl


    // $ANTLR start rule__DataTypeName__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5570:1: rule__DataTypeName__Group__0 : rule__DataTypeName__Group__0__Impl rule__DataTypeName__Group__1 ;
    public final void rule__DataTypeName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5574:1: ( rule__DataTypeName__Group__0__Impl rule__DataTypeName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5575:2: rule__DataTypeName__Group__0__Impl rule__DataTypeName__Group__1
            {
            pushFollow(FOLLOW_rule__DataTypeName__Group__0__Impl_in_rule__DataTypeName__Group__011292);
            rule__DataTypeName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DataTypeName__Group__1_in_rule__DataTypeName__Group__011295);
            rule__DataTypeName__Group__1();
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
    // $ANTLR end rule__DataTypeName__Group__0


    // $ANTLR start rule__DataTypeName__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5582:1: rule__DataTypeName__Group__0__Impl : ( ( rule__DataTypeName__PathAssignment_0 )? ) ;
    public final void rule__DataTypeName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5586:1: ( ( ( rule__DataTypeName__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5587:1: ( ( rule__DataTypeName__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5587:1: ( ( rule__DataTypeName__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5588:1: ( rule__DataTypeName__PathAssignment_0 )?
            {
             before(grammarAccess.getDataTypeNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5589:1: ( rule__DataTypeName__PathAssignment_0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==40) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5589:2: rule__DataTypeName__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DataTypeName__PathAssignment_0_in_rule__DataTypeName__Group__0__Impl11322);
                    rule__DataTypeName__PathAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataTypeNameAccess().getPathAssignment_0()); 

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
    // $ANTLR end rule__DataTypeName__Group__0__Impl


    // $ANTLR start rule__DataTypeName__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5599:1: rule__DataTypeName__Group__1 : rule__DataTypeName__Group__1__Impl ;
    public final void rule__DataTypeName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5603:1: ( rule__DataTypeName__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5604:2: rule__DataTypeName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DataTypeName__Group__1__Impl_in_rule__DataTypeName__Group__111353);
            rule__DataTypeName__Group__1__Impl();
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
    // $ANTLR end rule__DataTypeName__Group__1


    // $ANTLR start rule__DataTypeName__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5610:1: rule__DataTypeName__Group__1__Impl : ( ( rule__DataTypeName__TypeAssignment_1 ) ) ;
    public final void rule__DataTypeName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5614:1: ( ( ( rule__DataTypeName__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5615:1: ( ( rule__DataTypeName__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5615:1: ( ( rule__DataTypeName__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5616:1: ( rule__DataTypeName__TypeAssignment_1 )
            {
             before(grammarAccess.getDataTypeNameAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5617:1: ( rule__DataTypeName__TypeAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5617:2: rule__DataTypeName__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__DataTypeName__TypeAssignment_1_in_rule__DataTypeName__Group__1__Impl11380);
            rule__DataTypeName__TypeAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getDataTypeNameAccess().getTypeAssignment_1()); 

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
    // $ANTLR end rule__DataTypeName__Group__1__Impl


    // $ANTLR start rule__Expression__ExpAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5632:1: rule__Expression__ExpAssignment : ( ruleAndOrXorExpression ) ;
    public final void rule__Expression__ExpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5636:1: ( ( ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5637:1: ( ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5637:1: ( ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5638:1: ruleAndOrXorExpression
            {
             before(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_rule__Expression__ExpAssignment11419);
            ruleAndOrXorExpression();
            _fsp--;

             after(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0()); 

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
    // $ANTLR end rule__Expression__ExpAssignment


    // $ANTLR start rule__AndOrXorExpression__ExpAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5647:1: rule__AndOrXorExpression__ExpAssignment_0 : ( ruleEqualityExpression ) ;
    public final void rule__AndOrXorExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5651:1: ( ( ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5652:1: ( ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5652:1: ( ruleEqualityExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5653:1: ruleEqualityExpression
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_011450);
            ruleEqualityExpression();
            _fsp--;

             after(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0()); 

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
    // $ANTLR end rule__AndOrXorExpression__ExpAssignment_0


    // $ANTLR start rule__AndOrXorExpression__OpAssignment_1_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5662:1: rule__AndOrXorExpression__OpAssignment_1_0 : ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__AndOrXorExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5666:1: ( ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5667:1: ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5667:1: ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5668:1: ( rule__AndOrXorExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5669:1: ( rule__AndOrXorExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5669:2: rule__AndOrXorExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__OpAlternatives_1_0_0_in_rule__AndOrXorExpression__OpAssignment_1_011481);
            rule__AndOrXorExpression__OpAlternatives_1_0_0();
            _fsp--;


            }

             after(grammarAccess.getAndOrXorExpressionAccess().getOpAlternatives_1_0_0()); 

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
    // $ANTLR end rule__AndOrXorExpression__OpAssignment_1_0


    // $ANTLR start rule__AndOrXorExpression__ExpAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5678:1: rule__AndOrXorExpression__ExpAssignment_1_1 : ( ruleEqualityExpression ) ;
    public final void rule__AndOrXorExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5682:1: ( ( ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5683:1: ( ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5683:1: ( ruleEqualityExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5684:1: ruleEqualityExpression
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_1_111514);
            ruleEqualityExpression();
            _fsp--;

             after(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__AndOrXorExpression__ExpAssignment_1_1


    // $ANTLR start rule__EqualityExpression__ExpAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5693:1: rule__EqualityExpression__ExpAssignment_0 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5697:1: ( ( ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5698:1: ( ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5698:1: ( ruleRelationalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5699:1: ruleRelationalExpression
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_011545);
            ruleRelationalExpression();
            _fsp--;

             after(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 

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
    // $ANTLR end rule__EqualityExpression__ExpAssignment_0


    // $ANTLR start rule__EqualityExpression__OpAssignment_1_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5708:1: rule__EqualityExpression__OpAssignment_1_0 : ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__EqualityExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5712:1: ( ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5713:1: ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5713:1: ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5714:1: ( rule__EqualityExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5715:1: ( rule__EqualityExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5715:2: rule__EqualityExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__OpAlternatives_1_0_0_in_rule__EqualityExpression__OpAssignment_1_011576);
            rule__EqualityExpression__OpAlternatives_1_0_0();
            _fsp--;


            }

             after(grammarAccess.getEqualityExpressionAccess().getOpAlternatives_1_0_0()); 

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
    // $ANTLR end rule__EqualityExpression__OpAssignment_1_0


    // $ANTLR start rule__EqualityExpression__ExpAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5724:1: rule__EqualityExpression__ExpAssignment_1_1 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5728:1: ( ( ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5729:1: ( ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5729:1: ( ruleRelationalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5730:1: ruleRelationalExpression
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_1_111609);
            ruleRelationalExpression();
            _fsp--;

             after(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__EqualityExpression__ExpAssignment_1_1


    // $ANTLR start rule__RelationalExpression__ExpAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5739:1: rule__RelationalExpression__ExpAssignment_0 : ( ruleConditionalExpression ) ;
    public final void rule__RelationalExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5743:1: ( ( ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5744:1: ( ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5744:1: ( ruleConditionalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5745:1: ruleConditionalExpression
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_011640);
            ruleConditionalExpression();
            _fsp--;

             after(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0()); 

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
    // $ANTLR end rule__RelationalExpression__ExpAssignment_0


    // $ANTLR start rule__RelationalExpression__OpAssignment_1_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5754:1: rule__RelationalExpression__OpAssignment_1_0 : ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__RelationalExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5758:1: ( ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5759:1: ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5759:1: ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5760:1: ( rule__RelationalExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5761:1: ( rule__RelationalExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5761:2: rule__RelationalExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__OpAlternatives_1_0_0_in_rule__RelationalExpression__OpAssignment_1_011671);
            rule__RelationalExpression__OpAlternatives_1_0_0();
            _fsp--;


            }

             after(grammarAccess.getRelationalExpressionAccess().getOpAlternatives_1_0_0()); 

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
    // $ANTLR end rule__RelationalExpression__OpAssignment_1_0


    // $ANTLR start rule__RelationalExpression__ExpAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5770:1: rule__RelationalExpression__ExpAssignment_1_1 : ( ruleConditionalExpression ) ;
    public final void rule__RelationalExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5774:1: ( ( ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5775:1: ( ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5775:1: ( ruleConditionalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5776:1: ruleConditionalExpression
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_1_111704);
            ruleConditionalExpression();
            _fsp--;

             after(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__RelationalExpression__ExpAssignment_1_1


    // $ANTLR start rule__ConditionalExpression__ExpAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5785:1: rule__ConditionalExpression__ExpAssignment_0 : ( ruleAdditiveExpression ) ;
    public final void rule__ConditionalExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5789:1: ( ( ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5790:1: ( ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5790:1: ( ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5791:1: ruleAdditiveExpression
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_011735);
            ruleAdditiveExpression();
            _fsp--;

             after(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 

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
    // $ANTLR end rule__ConditionalExpression__ExpAssignment_0


    // $ANTLR start rule__ConditionalExpression__OpAssignment_1_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5800:1: rule__ConditionalExpression__OpAssignment_1_0 : ( ( '?' ) ) ;
    public final void rule__ConditionalExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5804:1: ( ( ( '?' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5805:1: ( ( '?' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5805:1: ( ( '?' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5806:1: ( '?' )
            {
             before(grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5807:1: ( '?' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5808:1: '?'
            {
             before(grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0()); 
            match(input,51,FOLLOW_51_in_rule__ConditionalExpression__OpAssignment_1_011771); 
             after(grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0()); 

            }

             after(grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0()); 

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
    // $ANTLR end rule__ConditionalExpression__OpAssignment_1_0


    // $ANTLR start rule__ConditionalExpression__ExpAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5823:1: rule__ConditionalExpression__ExpAssignment_1_1 : ( ruleAdditiveExpression ) ;
    public final void rule__ConditionalExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5827:1: ( ( ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5828:1: ( ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5828:1: ( ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5829:1: ruleAdditiveExpression
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_111810);
            ruleAdditiveExpression();
            _fsp--;

             after(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__ConditionalExpression__ExpAssignment_1_1


    // $ANTLR start rule__ConditionalExpression__ExpAssignment_1_3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5838:1: rule__ConditionalExpression__ExpAssignment_1_3 : ( ruleAdditiveExpression ) ;
    public final void rule__ConditionalExpression__ExpAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5842:1: ( ( ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5843:1: ( ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5843:1: ( ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5844:1: ruleAdditiveExpression
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_311841);
            ruleAdditiveExpression();
            _fsp--;

             after(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0()); 

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
    // $ANTLR end rule__ConditionalExpression__ExpAssignment_1_3


    // $ANTLR start rule__AdditiveExpression__ExpAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5853:1: rule__AdditiveExpression__ExpAssignment_0 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5857:1: ( ( ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5858:1: ( ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5858:1: ( ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5859:1: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_011872);
            ruleMultiplicativeExpression();
            _fsp--;

             after(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 

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
    // $ANTLR end rule__AdditiveExpression__ExpAssignment_0


    // $ANTLR start rule__AdditiveExpression__OpAssignment_1_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5868:1: rule__AdditiveExpression__OpAssignment_1_0 : ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__AdditiveExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5872:1: ( ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5873:1: ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5873:1: ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5874:1: ( rule__AdditiveExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5875:1: ( rule__AdditiveExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5875:2: rule__AdditiveExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__OpAlternatives_1_0_0_in_rule__AdditiveExpression__OpAssignment_1_011903);
            rule__AdditiveExpression__OpAlternatives_1_0_0();
            _fsp--;


            }

             after(grammarAccess.getAdditiveExpressionAccess().getOpAlternatives_1_0_0()); 

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
    // $ANTLR end rule__AdditiveExpression__OpAssignment_1_0


    // $ANTLR start rule__AdditiveExpression__ExpAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5884:1: rule__AdditiveExpression__ExpAssignment_1_1 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5888:1: ( ( ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5889:1: ( ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5889:1: ( ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5890:1: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_1_111936);
            ruleMultiplicativeExpression();
            _fsp--;

             after(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__AdditiveExpression__ExpAssignment_1_1


    // $ANTLR start rule__MultiplicativeExpression__ExpAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5899:1: rule__MultiplicativeExpression__ExpAssignment_0 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5903:1: ( ( ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5904:1: ( ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5904:1: ( ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5905:1: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_011967);
            ruleUnaryExpression();
            _fsp--;

             after(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 

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
    // $ANTLR end rule__MultiplicativeExpression__ExpAssignment_0


    // $ANTLR start rule__MultiplicativeExpression__OpAssignment_1_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5914:1: rule__MultiplicativeExpression__OpAssignment_1_0 : ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__MultiplicativeExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5918:1: ( ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5919:1: ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5919:1: ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5920:1: ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5921:1: ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5921:2: rule__MultiplicativeExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__OpAlternatives_1_0_0_in_rule__MultiplicativeExpression__OpAssignment_1_011998);
            rule__MultiplicativeExpression__OpAlternatives_1_0_0();
            _fsp--;


            }

             after(grammarAccess.getMultiplicativeExpressionAccess().getOpAlternatives_1_0_0()); 

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
    // $ANTLR end rule__MultiplicativeExpression__OpAssignment_1_0


    // $ANTLR start rule__MultiplicativeExpression__ExpAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5930:1: rule__MultiplicativeExpression__ExpAssignment_1_1 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5934:1: ( ( ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5935:1: ( ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5935:1: ( ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5936:1: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_1_112031);
            ruleUnaryExpression();
            _fsp--;

             after(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__MultiplicativeExpression__ExpAssignment_1_1


    // $ANTLR start rule__UnaryExpression__OpAssignment_0_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5945:1: rule__UnaryExpression__OpAssignment_0_0 : ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) ) ;
    public final void rule__UnaryExpression__OpAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5949:1: ( ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5950:1: ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5950:1: ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5951:1: ( rule__UnaryExpression__OpAlternatives_0_0_0 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpAlternatives_0_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5952:1: ( rule__UnaryExpression__OpAlternatives_0_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5952:2: rule__UnaryExpression__OpAlternatives_0_0_0
            {
            pushFollow(FOLLOW_rule__UnaryExpression__OpAlternatives_0_0_0_in_rule__UnaryExpression__OpAssignment_0_012062);
            rule__UnaryExpression__OpAlternatives_0_0_0();
            _fsp--;


            }

             after(grammarAccess.getUnaryExpressionAccess().getOpAlternatives_0_0_0()); 

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
    // $ANTLR end rule__UnaryExpression__OpAssignment_0_0


    // $ANTLR start rule__UnaryExpression__UnaryAssignment_0_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5961:1: rule__UnaryExpression__UnaryAssignment_0_1 : ( ruleUnaryExpression ) ;
    public final void rule__UnaryExpression__UnaryAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5965:1: ( ( ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5966:1: ( ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5966:1: ( ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5967:1: ruleUnaryExpression
            {
             before(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__UnaryExpression__UnaryAssignment_0_112095);
            ruleUnaryExpression();
            _fsp--;

             after(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0()); 

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
    // $ANTLR end rule__UnaryExpression__UnaryAssignment_0_1


    // $ANTLR start rule__UnaryExpression__ExpAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5976:1: rule__UnaryExpression__ExpAssignment_1 : ( rulePrimaryExpression ) ;
    public final void rule__UnaryExpression__ExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5980:1: ( ( rulePrimaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5981:1: ( rulePrimaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5981:1: ( rulePrimaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5982:1: rulePrimaryExpression
            {
             before(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__UnaryExpression__ExpAssignment_112126);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0()); 

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
    // $ANTLR end rule__UnaryExpression__ExpAssignment_1


    // $ANTLR start rule__PrimaryExpression__PrefixAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5991:1: rule__PrimaryExpression__PrefixAssignment_0 : ( ruleValueSpecification ) ;
    public final void rule__PrimaryExpression__PrefixAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5995:1: ( ( ruleValueSpecification ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5996:1: ( ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5996:1: ( ruleValueSpecification )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5997:1: ruleValueSpecification
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_rule__PrimaryExpression__PrefixAssignment_012157);
            ruleValueSpecification();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0()); 

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
    // $ANTLR end rule__PrimaryExpression__PrefixAssignment_0


    // $ANTLR start rule__PrimaryExpression__SuffixAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6006:1: rule__PrimaryExpression__SuffixAssignment_1_1 : ( ruleSuffixExpression ) ;
    public final void rule__PrimaryExpression__SuffixAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6010:1: ( ( ruleSuffixExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6011:1: ( ruleSuffixExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6011:1: ( ruleSuffixExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6012:1: ruleSuffixExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_rule__PrimaryExpression__SuffixAssignment_1_112188);
            ruleSuffixExpression();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__PrimaryExpression__SuffixAssignment_1_1


    // $ANTLR start rule__PropertyCallExpression__PropertyAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6021:1: rule__PropertyCallExpression__PropertyAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__PropertyCallExpression__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6025:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6026:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6026:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6027:1: ( RULE_ID )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6028:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6029:1: RULE_ID
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyCallExpression__PropertyAssignment_012223); 
             after(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0()); 

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
    // $ANTLR end rule__PropertyCallExpression__PropertyAssignment_0


    // $ANTLR start rule__PropertyCallExpression__SuffixAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6040:1: rule__PropertyCallExpression__SuffixAssignment_1_1 : ( ruleSuffixExpression ) ;
    public final void rule__PropertyCallExpression__SuffixAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6044:1: ( ( ruleSuffixExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6045:1: ( ruleSuffixExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6045:1: ( ruleSuffixExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6046:1: ruleSuffixExpression
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_rule__PropertyCallExpression__SuffixAssignment_1_112258);
            ruleSuffixExpression();
            _fsp--;

             after(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__PropertyCallExpression__SuffixAssignment_1_1


    // $ANTLR start rule__OperationCallExpression__OperationAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6055:1: rule__OperationCallExpression__OperationAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__OperationCallExpression__OperationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6059:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6060:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6060:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6061:1: ( RULE_ID )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6062:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6063:1: RULE_ID
            {
             before(grammarAccess.getOperationCallExpressionAccess().getOperationOperationIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__OperationCallExpression__OperationAssignment_012293); 
             after(grammarAccess.getOperationCallExpressionAccess().getOperationOperationIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0()); 

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
    // $ANTLR end rule__OperationCallExpression__OperationAssignment_0


    // $ANTLR start rule__OperationCallExpression__ArgumentsAssignment_2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6074:1: rule__OperationCallExpression__ArgumentsAssignment_2 : ( ruleListOfValues ) ;
    public final void rule__OperationCallExpression__ArgumentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6078:1: ( ( ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6079:1: ( ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6079:1: ( ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6080:1: ruleListOfValues
            {
             before(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleListOfValues_in_rule__OperationCallExpression__ArgumentsAssignment_212328);
            ruleListOfValues();
            _fsp--;

             after(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0()); 

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
    // $ANTLR end rule__OperationCallExpression__ArgumentsAssignment_2


    // $ANTLR start rule__OperationCallExpression__SuffixAssignment_4_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6089:1: rule__OperationCallExpression__SuffixAssignment_4_1 : ( ruleSuffixExpression ) ;
    public final void rule__OperationCallExpression__SuffixAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6093:1: ( ( ruleSuffixExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6094:1: ( ruleSuffixExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6094:1: ( ruleSuffixExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6095:1: ruleSuffixExpression
            {
             before(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_rule__OperationCallExpression__SuffixAssignment_4_112359);
            ruleSuffixExpression();
            _fsp--;

             after(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0()); 

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
    // $ANTLR end rule__OperationCallExpression__SuffixAssignment_4_1


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__PathAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6104:1: rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6108:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6109:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6109:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6110:1: ruleQualifiedName
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__NameOrChoiceOrBehaviorCall__PathAssignment_012390);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0()); 

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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__PathAssignment_0


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__IdAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6119:1: rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6123:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6124:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6124:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6125:1: ( RULE_ID )
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6126:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6127:1: RULE_ID
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NameOrChoiceOrBehaviorCall__IdAssignment_112425); 
             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0()); 

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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__IdAssignment_1


    // $ANTLR start rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6138:1: rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 : ( ruleListOfValues ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6142:1: ( ( ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6143:1: ( ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6143:1: ( ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6144:1: ruleListOfValues
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleListOfValues_in_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_112460);
            ruleListOfValues();
            _fsp--;

             after(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1


    // $ANTLR start rule__QualifiedName__PathAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6153:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6157:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6158:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6158:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6159:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6160:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6161:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_012495); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6172:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6176:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6177:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6177:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6178:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_212530);
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


    // $ANTLR start rule__Interval__IsLowerIncludedAssignment_0_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6187:1: rule__Interval__IsLowerIncludedAssignment_0_1 : ( ( '[' ) ) ;
    public final void rule__Interval__IsLowerIncludedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6191:1: ( ( ( '[' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6192:1: ( ( '[' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6192:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6193:1: ( '[' )
            {
             before(grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6194:1: ( '[' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6195:1: '['
            {
             before(grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Interval__IsLowerIncludedAssignment_0_112566); 
             after(grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0()); 

            }

             after(grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0()); 

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
    // $ANTLR end rule__Interval__IsLowerIncludedAssignment_0_1


    // $ANTLR start rule__Interval__LowerAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6210:1: rule__Interval__LowerAssignment_1 : ( ruleExpression ) ;
    public final void rule__Interval__LowerAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6214:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6215:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6215:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6216:1: ruleExpression
            {
             before(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Interval__LowerAssignment_112605);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0()); 

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
    // $ANTLR end rule__Interval__LowerAssignment_1


    // $ANTLR start rule__Interval__UpperAssignment_3
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6225:1: rule__Interval__UpperAssignment_3 : ( ruleExpression ) ;
    public final void rule__Interval__UpperAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6229:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6230:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6230:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6231:1: ruleExpression
            {
             before(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Interval__UpperAssignment_312636);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0()); 

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
    // $ANTLR end rule__Interval__UpperAssignment_3


    // $ANTLR start rule__Interval__IsUpperIncludedAssignment_4_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6240:1: rule__Interval__IsUpperIncludedAssignment_4_0 : ( ( ']' ) ) ;
    public final void rule__Interval__IsUpperIncludedAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6244:1: ( ( ( ']' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6245:1: ( ( ']' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6245:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6246:1: ( ']' )
            {
             before(grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6247:1: ( ']' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6248:1: ']'
            {
             before(grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0()); 
            match(input,31,FOLLOW_31_in_rule__Interval__IsUpperIncludedAssignment_4_012672); 
             after(grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0()); 

            }

             after(grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0()); 

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
    // $ANTLR end rule__Interval__IsUpperIncludedAssignment_4_0


    // $ANTLR start rule__CollectionOrTuple__ListOfValuesAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6263:1: rule__CollectionOrTuple__ListOfValuesAssignment_1 : ( ruleListOfValues ) ;
    public final void rule__CollectionOrTuple__ListOfValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6267:1: ( ( ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6268:1: ( ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6268:1: ( ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6269:1: ruleListOfValues
            {
             before(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleListOfValues_in_rule__CollectionOrTuple__ListOfValuesAssignment_112711);
            ruleListOfValues();
            _fsp--;

             after(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0()); 

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
    // $ANTLR end rule__CollectionOrTuple__ListOfValuesAssignment_1


    // $ANTLR start rule__Tuple__ListOfValueNamePairsAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6278:1: rule__Tuple__ListOfValueNamePairsAssignment_1 : ( ruleListOfValueNamePairs ) ;
    public final void rule__Tuple__ListOfValueNamePairsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6282:1: ( ( ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6283:1: ( ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6283:1: ( ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6284:1: ruleListOfValueNamePairs
            {
             before(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_rule__Tuple__ListOfValueNamePairsAssignment_112742);
            ruleListOfValueNamePairs();
            _fsp--;

             after(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0()); 

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
    // $ANTLR end rule__Tuple__ListOfValueNamePairsAssignment_1


    // $ANTLR start rule__ListOfValues__ValuesAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6293:1: rule__ListOfValues__ValuesAssignment_0 : ( ruleExpression ) ;
    public final void rule__ListOfValues__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6297:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6298:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6298:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6299:1: ruleExpression
            {
             before(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_012773);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0()); 

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
    // $ANTLR end rule__ListOfValues__ValuesAssignment_0


    // $ANTLR start rule__ListOfValues__ValuesAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6308:1: rule__ListOfValues__ValuesAssignment_1_1 : ( ruleExpression ) ;
    public final void rule__ListOfValues__ValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6312:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6313:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6313:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6314:1: ruleExpression
            {
             before(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_1_112804);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__ListOfValues__ValuesAssignment_1_1


    // $ANTLR start rule__ListOfValueNamePairs__ValueNamePairsAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6323:1: rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 : ( ruleValueNamePair ) ;
    public final void rule__ListOfValueNamePairs__ValueNamePairsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6327:1: ( ( ruleValueNamePair ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6328:1: ( ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6328:1: ( ruleValueNamePair )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6329:1: ruleValueNamePair
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_012835);
            ruleValueNamePair();
            _fsp--;

             after(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0()); 

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
    // $ANTLR end rule__ListOfValueNamePairs__ValueNamePairsAssignment_0


    // $ANTLR start rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6338:1: rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 : ( ruleValueNamePair ) ;
    public final void rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6342:1: ( ( ruleValueNamePair ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6343:1: ( ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6343:1: ( ruleValueNamePair )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6344:1: ruleValueNamePair
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_112866);
            ruleValueNamePair();
            _fsp--;

             after(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1


    // $ANTLR start rule__ValueNamePair__PropertyAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6353:1: rule__ValueNamePair__PropertyAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ValueNamePair__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6357:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6358:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6358:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6359:1: ( RULE_ID )
            {
             before(grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6360:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6361:1: RULE_ID
            {
             before(grammarAccess.getValueNamePairAccess().getPropertyPropertyIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ValueNamePair__PropertyAssignment_012901); 
             after(grammarAccess.getValueNamePairAccess().getPropertyPropertyIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0()); 

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
    // $ANTLR end rule__ValueNamePair__PropertyAssignment_0


    // $ANTLR start rule__ValueNamePair__ValueAssignment_2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6372:1: rule__ValueNamePair__ValueAssignment_2 : ( ruleExpression ) ;
    public final void rule__ValueNamePair__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6376:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6377:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6377:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6378:1: ruleExpression
            {
             before(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ValueNamePair__ValueAssignment_212936);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0()); 

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
    // $ANTLR end rule__ValueNamePair__ValueAssignment_2


    // $ANTLR start rule__InstantObsExpression__IdAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6387:1: rule__InstantObsExpression__IdAssignment_1 : ( ruleInstantObsName ) ;
    public final void rule__InstantObsExpression__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6391:1: ( ( ruleInstantObsName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6392:1: ( ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6392:1: ( ruleInstantObsName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6393:1: ruleInstantObsName
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInstantObsName_in_rule__InstantObsExpression__IdAssignment_112967);
            ruleInstantObsName();
            _fsp--;

             after(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0()); 

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
    // $ANTLR end rule__InstantObsExpression__IdAssignment_1


    // $ANTLR start rule__InstantObsExpression__IndexAssignment_2_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6402:1: rule__InstantObsExpression__IndexAssignment_2_1 : ( ruleExpression ) ;
    public final void rule__InstantObsExpression__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6406:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6407:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6407:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6408:1: ruleExpression
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__InstantObsExpression__IndexAssignment_2_112998);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__InstantObsExpression__IndexAssignment_2_1


    // $ANTLR start rule__InstantObsExpression__ConditionAssignment_3_2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6417:1: rule__InstantObsExpression__ConditionAssignment_3_2 : ( ruleExpression ) ;
    public final void rule__InstantObsExpression__ConditionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6421:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6422:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6422:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6423:1: ruleExpression
            {
             before(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__InstantObsExpression__ConditionAssignment_3_213029);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 

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
    // $ANTLR end rule__InstantObsExpression__ConditionAssignment_3_2


    // $ANTLR start rule__InstantObsName__PathAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6432:1: rule__InstantObsName__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__InstantObsName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6436:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6437:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6437:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6438:1: ruleQualifiedName
            {
             before(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__InstantObsName__PathAssignment_013060);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 

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
    // $ANTLR end rule__InstantObsName__PathAssignment_0


    // $ANTLR start rule__InstantObsName__InstantIdAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6447:1: rule__InstantObsName__InstantIdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__InstantObsName__InstantIdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6451:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6452:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6452:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6453:1: ( RULE_ID )
            {
             before(grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6454:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6455:1: RULE_ID
            {
             before(grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__InstantObsName__InstantIdAssignment_113095); 
             after(grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationCrossReference_1_0()); 

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
    // $ANTLR end rule__InstantObsName__InstantIdAssignment_1


    // $ANTLR start rule__DurationObsExpression__IdAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6466:1: rule__DurationObsExpression__IdAssignment_1 : ( ruleDurationObsName ) ;
    public final void rule__DurationObsExpression__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6470:1: ( ( ruleDurationObsName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6471:1: ( ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6471:1: ( ruleDurationObsName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6472:1: ruleDurationObsName
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDurationObsName_in_rule__DurationObsExpression__IdAssignment_113130);
            ruleDurationObsName();
            _fsp--;

             after(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0()); 

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
    // $ANTLR end rule__DurationObsExpression__IdAssignment_1


    // $ANTLR start rule__DurationObsExpression__IndexAssignment_2_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6481:1: rule__DurationObsExpression__IndexAssignment_2_1 : ( ruleExpression ) ;
    public final void rule__DurationObsExpression__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6485:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6486:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6486:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6487:1: ruleExpression
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__DurationObsExpression__IndexAssignment_2_113161);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__DurationObsExpression__IndexAssignment_2_1


    // $ANTLR start rule__DurationObsExpression__ConditionAssignment_3_2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6496:1: rule__DurationObsExpression__ConditionAssignment_3_2 : ( ruleExpression ) ;
    public final void rule__DurationObsExpression__ConditionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6500:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6501:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6501:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6502:1: ruleExpression
            {
             before(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__DurationObsExpression__ConditionAssignment_3_213192);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 

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
    // $ANTLR end rule__DurationObsExpression__ConditionAssignment_3_2


    // $ANTLR start rule__DurationObsName__PathAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6511:1: rule__DurationObsName__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__DurationObsName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6515:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6516:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6516:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6517:1: ruleQualifiedName
            {
             before(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__DurationObsName__PathAssignment_013223);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 

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
    // $ANTLR end rule__DurationObsName__PathAssignment_0


    // $ANTLR start rule__DurationObsName__DurationIdAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6526:1: rule__DurationObsName__DurationIdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DurationObsName__DurationIdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6530:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6531:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6531:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6532:1: ( RULE_ID )
            {
             before(grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6533:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6534:1: RULE_ID
            {
             before(grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DurationObsName__DurationIdAssignment_113258); 
             after(grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationCrossReference_1_0()); 

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
    // $ANTLR end rule__DurationObsName__DurationIdAssignment_1


    // $ANTLR start rule__JitterExp__FirstInstantAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6545:1: rule__JitterExp__FirstInstantAssignment_1 : ( ruleInstantObsExpression ) ;
    public final void rule__JitterExp__FirstInstantAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6549:1: ( ( ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6550:1: ( ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6550:1: ( ruleInstantObsExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6551:1: ruleInstantObsExpression
            {
             before(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__FirstInstantAssignment_113293);
            ruleInstantObsExpression();
            _fsp--;

             after(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0()); 

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
    // $ANTLR end rule__JitterExp__FirstInstantAssignment_1


    // $ANTLR start rule__JitterExp__SecondInstantAssignment_2_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6560:1: rule__JitterExp__SecondInstantAssignment_2_1 : ( ruleInstantObsExpression ) ;
    public final void rule__JitterExp__SecondInstantAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6564:1: ( ( ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6565:1: ( ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6565:1: ( ruleInstantObsExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6566:1: ruleInstantObsExpression
            {
             before(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__SecondInstantAssignment_2_113324);
            ruleInstantObsExpression();
            _fsp--;

             after(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__JitterExp__SecondInstantAssignment_2_1


    // $ANTLR start rule__VariableDeclaration__VariableDeclarationAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6575:1: rule__VariableDeclaration__VariableDeclarationAssignment_0 : ( ruleVariableDirectionKind ) ;
    public final void rule__VariableDeclaration__VariableDeclarationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6579:1: ( ( ruleVariableDirectionKind ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6580:1: ( ruleVariableDirectionKind )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6580:1: ( ruleVariableDirectionKind )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6581:1: ruleVariableDirectionKind
            {
             before(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_rule__VariableDeclaration__VariableDeclarationAssignment_013355);
            ruleVariableDirectionKind();
            _fsp--;

             after(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0()); 

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
    // $ANTLR end rule__VariableDeclaration__VariableDeclarationAssignment_0


    // $ANTLR start rule__VariableDeclaration__NameAssignment_2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6590:1: rule__VariableDeclaration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__VariableDeclaration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6594:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6595:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6595:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6596:1: RULE_ID
            {
             before(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableDeclaration__NameAssignment_213386); 
             after(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end rule__VariableDeclaration__NameAssignment_2


    // $ANTLR start rule__VariableDeclaration__TypeAssignment_3_0_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6605:1: rule__VariableDeclaration__TypeAssignment_3_0_1 : ( ruleDataTypeName ) ;
    public final void rule__VariableDeclaration__TypeAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6609:1: ( ( ruleDataTypeName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6610:1: ( ruleDataTypeName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6610:1: ( ruleDataTypeName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6611:1: ruleDataTypeName
            {
             before(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0()); 
            pushFollow(FOLLOW_ruleDataTypeName_in_rule__VariableDeclaration__TypeAssignment_3_0_113417);
            ruleDataTypeName();
            _fsp--;

             after(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0()); 

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
    // $ANTLR end rule__VariableDeclaration__TypeAssignment_3_0_1


    // $ANTLR start rule__VariableDeclaration__InitValueAssignment_3_0_2_2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6620:1: rule__VariableDeclaration__InitValueAssignment_3_0_2_2 : ( ruleExpression ) ;
    public final void rule__VariableDeclaration__InitValueAssignment_3_0_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6624:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6625:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6625:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6626:1: ruleExpression
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_0_2_213448);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0()); 

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
    // $ANTLR end rule__VariableDeclaration__InitValueAssignment_3_0_2_2


    // $ANTLR start rule__VariableDeclaration__InitValueAssignment_3_1_2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6635:1: rule__VariableDeclaration__InitValueAssignment_3_1_2 : ( ruleExpression ) ;
    public final void rule__VariableDeclaration__InitValueAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6639:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6640:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6640:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6641:1: ruleExpression
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_1_213479);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0()); 

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
    // $ANTLR end rule__VariableDeclaration__InitValueAssignment_3_1_2


    // $ANTLR start rule__DataTypeName__PathAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6650:1: rule__DataTypeName__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__DataTypeName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6654:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6655:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6655:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6656:1: ruleQualifiedName
            {
             before(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__DataTypeName__PathAssignment_013510);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 

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
    // $ANTLR end rule__DataTypeName__PathAssignment_0


    // $ANTLR start rule__DataTypeName__TypeAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6665:1: rule__DataTypeName__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DataTypeName__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6669:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6670:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6670:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6671:1: ( RULE_ID )
            {
             before(grammarAccess.getDataTypeNameAccess().getTypeDataTypeCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6672:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6673:1: RULE_ID
            {
             before(grammarAccess.getDataTypeNameAccess().getTypeDataTypeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DataTypeName__TypeAssignment_113545); 
             after(grammarAccess.getDataTypeNameAccess().getTypeDataTypeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getDataTypeNameAccess().getTypeDataTypeCrossReference_1_0()); 

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
    // $ANTLR end rule__DataTypeName__TypeAssignment_1


    // $ANTLR start rule__IntegerLiteralRule__ValueAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6684:1: rule__IntegerLiteralRule__ValueAssignment : ( RULE_INTEGERLITERAL ) ;
    public final void rule__IntegerLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6688:1: ( ( RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6689:1: ( RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6689:1: ( RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6690:1: RULE_INTEGERLITERAL
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getValueIntegerLiteralTerminalRuleCall_0()); 
            match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_rule__IntegerLiteralRule__ValueAssignment13580); 
             after(grammarAccess.getIntegerLiteralRuleAccess().getValueIntegerLiteralTerminalRuleCall_0()); 

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
    // $ANTLR end rule__IntegerLiteralRule__ValueAssignment


    // $ANTLR start rule__UnlimitedLiteralRule__ValueAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6699:1: rule__UnlimitedLiteralRule__ValueAssignment : ( ( '*' ) ) ;
    public final void rule__UnlimitedLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6703:1: ( ( ( '*' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6704:1: ( ( '*' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6704:1: ( ( '*' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6705:1: ( '*' )
            {
             before(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6706:1: ( '*' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6707:1: '*'
            {
             before(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__UnlimitedLiteralRule__ValueAssignment13616); 
             after(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0()); 

            }

             after(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0()); 

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
    // $ANTLR end rule__UnlimitedLiteralRule__ValueAssignment


    // $ANTLR start rule__RealLiteralRule__ValueAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6722:1: rule__RealLiteralRule__ValueAssignment : ( RULE_REALLITERAL ) ;
    public final void rule__RealLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6726:1: ( ( RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6727:1: ( RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6727:1: ( RULE_REALLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6728:1: RULE_REALLITERAL
            {
             before(grammarAccess.getRealLiteralRuleAccess().getValueRealLiteralTerminalRuleCall_0()); 
            match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_rule__RealLiteralRule__ValueAssignment13655); 
             after(grammarAccess.getRealLiteralRuleAccess().getValueRealLiteralTerminalRuleCall_0()); 

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
    // $ANTLR end rule__RealLiteralRule__ValueAssignment


    // $ANTLR start rule__DateTimeLiteralRule__ValueAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6737:1: rule__DateTimeLiteralRule__ValueAssignment : ( RULE_DATETIMELITERAL ) ;
    public final void rule__DateTimeLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6741:1: ( ( RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6742:1: ( RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6742:1: ( RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6743:1: RULE_DATETIMELITERAL
            {
             before(grammarAccess.getDateTimeLiteralRuleAccess().getValueDateTimeLiteralTerminalRuleCall_0()); 
            match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_rule__DateTimeLiteralRule__ValueAssignment13686); 
             after(grammarAccess.getDateTimeLiteralRuleAccess().getValueDateTimeLiteralTerminalRuleCall_0()); 

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
    // $ANTLR end rule__DateTimeLiteralRule__ValueAssignment


    // $ANTLR start rule__BooleanLiteralRule__ValueAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6752:1: rule__BooleanLiteralRule__ValueAssignment : ( RULE_BOOLEANLITERAL ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6756:1: ( ( RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6757:1: ( RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6757:1: ( RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6758:1: RULE_BOOLEANLITERAL
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueBooleanLiteralTerminalRuleCall_0()); 
            match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_rule__BooleanLiteralRule__ValueAssignment13717); 
             after(grammarAccess.getBooleanLiteralRuleAccess().getValueBooleanLiteralTerminalRuleCall_0()); 

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
    // $ANTLR end rule__BooleanLiteralRule__ValueAssignment


    // $ANTLR start rule__NullLiteralRule__ValueAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6767:1: rule__NullLiteralRule__ValueAssignment : ( RULE_NULLLITERAL ) ;
    public final void rule__NullLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6771:1: ( ( RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6772:1: ( RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6772:1: ( RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6773:1: RULE_NULLLITERAL
            {
             before(grammarAccess.getNullLiteralRuleAccess().getValueNullLiteralTerminalRuleCall_0()); 
            match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_rule__NullLiteralRule__ValueAssignment13748); 
             after(grammarAccess.getNullLiteralRuleAccess().getValueNullLiteralTerminalRuleCall_0()); 

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
    // $ANTLR end rule__NullLiteralRule__ValueAssignment


    // $ANTLR start rule__DefaultLiteralRule__ValueAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6782:1: rule__DefaultLiteralRule__ValueAssignment : ( ( '/' ) ) ;
    public final void rule__DefaultLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6786:1: ( ( ( '/' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6787:1: ( ( '/' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6787:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6788:1: ( '/' )
            {
             before(grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6789:1: ( '/' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6790:1: '/'
            {
             before(grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__DefaultLiteralRule__ValueAssignment13784); 
             after(grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0()); 

            }

             after(grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0()); 

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
    // $ANTLR end rule__DefaultLiteralRule__ValueAssignment


    // $ANTLR start rule__StringLiteralRule__ValueAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6805:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6809:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6810:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6810:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6811:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteralRule__ValueAssignment13823); 
             after(grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0()); 

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
    // $ANTLR end rule__StringLiteralRule__ValueAssignment


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__ExpAssignment_in_ruleExpression94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__0_in_ruleAndOrXorExpression154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__0_in_ruleEqualityExpression214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__0_in_ruleRelationalExpression274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__0_in_ruleConditionalExpression334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__0_in_ruleAdditiveExpression394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__0_in_ruleMultiplicativeExpression454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Alternatives_in_ruleUnaryExpression514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group__0_in_rulePrimaryExpression574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Alternatives_in_ruleValueSpecification634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuffixExpression__Alternatives_in_ruleSuffixExpression694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group__0_in_rulePropertyCallExpression754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__0_in_ruleOperationCallExpression814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0_in_ruleNameOrChoiceOrBehaviorCall934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__0_in_ruleInterval1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__0_in_ruleCollectionOrTuple1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__Group__0_in_ruleTuple1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues1201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__0_in_ruleListOfValues1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs1261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group__0_in_ruleListOfValueNamePairs1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__0_in_ruleValueNamePair1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression1381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimeExpression__Alternatives_in_ruleTimeExpression1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression1441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__0_in_ruleInstantObsExpression1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName1501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__Group__0_in_ruleInstantObsName1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression1561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__0_in_ruleDurationObsExpression1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName1621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__Group__0_in_ruleDurationObsName1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp1681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__0_in_ruleJitterExp1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__0_in_ruleVariableDeclaration1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind1801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDirectionKind__Alternatives_in_ruleVariableDirectionKind1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName1861 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__Group__0_in_ruleDataTypeName1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule1921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteralRule__Alternatives_in_ruleNumberLiteralRule1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule1981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerLiteralRule__ValueAssignment_in_ruleIntegerLiteralRule2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule2041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnlimitedLiteralRule__ValueAssignment_in_ruleUnlimitedLiteralRule2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule2101 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteralRule__ValueAssignment_in_ruleRealLiteralRule2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule2161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule2168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateTimeLiteralRule__ValueAssignment_in_ruleDateTimeLiteralRule2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule2221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteralRule__ValueAssignment_in_ruleBooleanLiteralRule2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule2281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullLiteralRule__ValueAssignment_in_ruleNullLiteralRule2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule2341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultLiteralRule__ValueAssignment_in_ruleDefaultLiteralRule2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule2401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule2408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteralRule__ValueAssignment_in_ruleStringLiteralRule2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__AndOrXorExpression__OpAlternatives_1_0_02471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__AndOrXorExpression__OpAlternatives_1_0_02491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__AndOrXorExpression__OpAlternatives_1_0_02511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__EqualityExpression__OpAlternatives_1_0_02546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__EqualityExpression__OpAlternatives_1_0_02566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__RelationalExpression__OpAlternatives_1_0_02601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__RelationalExpression__OpAlternatives_1_0_02621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__RelationalExpression__OpAlternatives_1_0_02641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__RelationalExpression__OpAlternatives_1_0_02661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__AdditiveExpression__OpAlternatives_1_0_02696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__AdditiveExpression__OpAlternatives_1_0_02716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group_0__0_in_rule__UnaryExpression__Alternatives2825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__ExpAssignment_1_in_rule__UnaryExpression__Alternatives2843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__UnaryExpression__OpAlternatives_0_0_02877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__UnaryExpression__OpAlternatives_0_0_02897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__UnaryExpression__OpAlternatives_0_0_02917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__ValueSpecification__Alternatives2951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_rule__ValueSpecification__Alternatives2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_rule__ValueSpecification__Alternatives2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_rule__ValueSpecification__Alternatives3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_rule__ValueSpecification__Alternatives3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_rule__ValueSpecification__Alternatives3036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_rule__ValueSpecification__Alternatives3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__0_in_rule__ValueSpecification__Alternatives3070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_rule__SuffixExpression__Alternatives3103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_rule__SuffixExpression__Alternatives3120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_rule__Literal__Alternatives3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_rule__Literal__Alternatives3169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_rule__Literal__Alternatives3186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_rule__Literal__Alternatives3203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_rule__Literal__Alternatives3220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_rule__Literal__Alternatives3237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Interval__Alternatives_03270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__IsLowerIncludedAssignment_0_1_in_rule__Interval__Alternatives_03289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__IsUpperIncludedAssignment_4_0_in_rule__Interval__Alternatives_43322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Interval__Alternatives_43341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_rule__TimeExpression__Alternatives3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_rule__TimeExpression__Alternatives3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_rule__TimeExpression__Alternatives3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__0_in_rule__VariableDeclaration__Alternatives_33441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__0_in_rule__VariableDeclaration__Alternatives_33459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__VariableDirectionKind__Alternatives3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__VariableDirectionKind__Alternatives3513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__VariableDirectionKind__Alternatives3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_rule__NumberLiteralRule__Alternatives3567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_rule__NumberLiteralRule__Alternatives3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_rule__NumberLiteralRule__Alternatives3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__0__Impl_in_rule__AndOrXorExpression__Group__03631 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__1_in_rule__AndOrXorExpression__Group__03634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__ExpAssignment_0_in_rule__AndOrXorExpression__Group__0__Impl3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__1__Impl_in_rule__AndOrXorExpression__Group__13691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__0_in_rule__AndOrXorExpression__Group__1__Impl3718 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__0__Impl_in_rule__AndOrXorExpression__Group_1__03753 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__1_in_rule__AndOrXorExpression__Group_1__03756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__OpAssignment_1_0_in_rule__AndOrXorExpression__Group_1__0__Impl3783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__1__Impl_in_rule__AndOrXorExpression__Group_1__13813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__ExpAssignment_1_1_in_rule__AndOrXorExpression__Group_1__1__Impl3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__0__Impl_in_rule__EqualityExpression__Group__03874 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__1_in_rule__EqualityExpression__Group__03877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__ExpAssignment_0_in_rule__EqualityExpression__Group__0__Impl3904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__1__Impl_in_rule__EqualityExpression__Group__13934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__0_in_rule__EqualityExpression__Group__1__Impl3961 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__0__Impl_in_rule__EqualityExpression__Group_1__03996 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__1_in_rule__EqualityExpression__Group_1__03999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__OpAssignment_1_0_in_rule__EqualityExpression__Group_1__0__Impl4026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__1__Impl_in_rule__EqualityExpression__Group_1__14056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__ExpAssignment_1_1_in_rule__EqualityExpression__Group_1__1__Impl4083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__0__Impl_in_rule__RelationalExpression__Group__04117 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__1_in_rule__RelationalExpression__Group__04120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__ExpAssignment_0_in_rule__RelationalExpression__Group__0__Impl4147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__1__Impl_in_rule__RelationalExpression__Group__14177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__0_in_rule__RelationalExpression__Group__1__Impl4204 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__0__Impl_in_rule__RelationalExpression__Group_1__04239 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__1_in_rule__RelationalExpression__Group_1__04242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__OpAssignment_1_0_in_rule__RelationalExpression__Group_1__0__Impl4269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__1__Impl_in_rule__RelationalExpression__Group_1__14299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__ExpAssignment_1_1_in_rule__RelationalExpression__Group_1__1__Impl4326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__04360 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__1_in_rule__ConditionalExpression__Group__04363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__ExpAssignment_0_in_rule__ConditionalExpression__Group__0__Impl4390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__1__Impl_in_rule__ConditionalExpression__Group__14420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__0_in_rule__ConditionalExpression__Group__1__Impl4447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__0__Impl_in_rule__ConditionalExpression__Group_1__04482 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__1_in_rule__ConditionalExpression__Group_1__04485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__OpAssignment_1_0_in_rule__ConditionalExpression__Group_1__0__Impl4512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__1__Impl_in_rule__ConditionalExpression__Group_1__14542 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__2_in_rule__ConditionalExpression__Group_1__14545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__ExpAssignment_1_1_in_rule__ConditionalExpression__Group_1__1__Impl4572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__2__Impl_in_rule__ConditionalExpression__Group_1__24602 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__3_in_rule__ConditionalExpression__Group_1__24605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ConditionalExpression__Group_1__2__Impl4633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__3__Impl_in_rule__ConditionalExpression__Group_1__34664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__ExpAssignment_1_3_in_rule__ConditionalExpression__Group_1__3__Impl4691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__0__Impl_in_rule__AdditiveExpression__Group__04729 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__1_in_rule__AdditiveExpression__Group__04732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__ExpAssignment_0_in_rule__AdditiveExpression__Group__0__Impl4759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__1__Impl_in_rule__AdditiveExpression__Group__14789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__0_in_rule__AdditiveExpression__Group__1__Impl4816 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__0__Impl_in_rule__AdditiveExpression__Group_1__04851 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__1_in_rule__AdditiveExpression__Group_1__04854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__OpAssignment_1_0_in_rule__AdditiveExpression__Group_1__0__Impl4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__1__Impl_in_rule__AdditiveExpression__Group_1__14911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__ExpAssignment_1_1_in_rule__AdditiveExpression__Group_1__1__Impl4938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__0__Impl_in_rule__MultiplicativeExpression__Group__04972 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__1_in_rule__MultiplicativeExpression__Group__04975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__ExpAssignment_0_in_rule__MultiplicativeExpression__Group__0__Impl5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__1__Impl_in_rule__MultiplicativeExpression__Group__15032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group_1__0_in_rule__MultiplicativeExpression__Group__1__Impl5059 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group_1__0__Impl_in_rule__MultiplicativeExpression__Group_1__05094 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group_1__1_in_rule__MultiplicativeExpression__Group_1__05097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__OpAssignment_1_0_in_rule__MultiplicativeExpression__Group_1__0__Impl5124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group_1__1__Impl_in_rule__MultiplicativeExpression__Group_1__15154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__ExpAssignment_1_1_in_rule__MultiplicativeExpression__Group_1__1__Impl5181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group_0__0__Impl_in_rule__UnaryExpression__Group_0__05215 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group_0__1_in_rule__UnaryExpression__Group_0__05218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__OpAssignment_0_0_in_rule__UnaryExpression__Group_0__0__Impl5245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group_0__1__Impl_in_rule__UnaryExpression__Group_0__15275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__UnaryAssignment_0_1_in_rule__UnaryExpression__Group_0__1__Impl5302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group__0__Impl_in_rule__PrimaryExpression__Group__05336 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group__1_in_rule__PrimaryExpression__Group__05339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__PrefixAssignment_0_in_rule__PrimaryExpression__Group__0__Impl5366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group__1__Impl_in_rule__PrimaryExpression__Group__15396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Group__1__Impl5423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__05458 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__05461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__PrimaryExpression__Group_1__0__Impl5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__15520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__SuffixAssignment_1_1_in_rule__PrimaryExpression__Group_1__1__Impl5547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__0__Impl_in_rule__ValueSpecification__Group_7__05581 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__1_in_rule__ValueSpecification__Group_7__05584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ValueSpecification__Group_7__0__Impl5612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__1__Impl_in_rule__ValueSpecification__Group_7__15643 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__2_in_rule__ValueSpecification__Group_7__15646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ValueSpecification__Group_7__1__Impl5673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__2__Impl_in_rule__ValueSpecification__Group_7__25702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ValueSpecification__Group_7__2__Impl5730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group__0__Impl_in_rule__PropertyCallExpression__Group__05767 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group__1_in_rule__PropertyCallExpression__Group__05770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__PropertyAssignment_0_in_rule__PropertyCallExpression__Group__0__Impl5797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group__1__Impl_in_rule__PropertyCallExpression__Group__15827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group_1__0_in_rule__PropertyCallExpression__Group__1__Impl5854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group_1__0__Impl_in_rule__PropertyCallExpression__Group_1__05889 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group_1__1_in_rule__PropertyCallExpression__Group_1__05892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__PropertyCallExpression__Group_1__0__Impl5920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group_1__1__Impl_in_rule__PropertyCallExpression__Group_1__15951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__SuffixAssignment_1_1_in_rule__PropertyCallExpression__Group_1__1__Impl5978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__0__Impl_in_rule__OperationCallExpression__Group__06012 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__1_in_rule__OperationCallExpression__Group__06015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__OperationAssignment_0_in_rule__OperationCallExpression__Group__0__Impl6042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__1__Impl_in_rule__OperationCallExpression__Group__16072 = new BitSet(new long[]{0x000744CFDE0007F0L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__2_in_rule__OperationCallExpression__Group__16075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__OperationCallExpression__Group__1__Impl6103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__2__Impl_in_rule__OperationCallExpression__Group__26134 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__3_in_rule__OperationCallExpression__Group__26137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__ArgumentsAssignment_2_in_rule__OperationCallExpression__Group__2__Impl6164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__3__Impl_in_rule__OperationCallExpression__Group__36195 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__4_in_rule__OperationCallExpression__Group__36198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__OperationCallExpression__Group__3__Impl6226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__4__Impl_in_rule__OperationCallExpression__Group__46257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group_4__0_in_rule__OperationCallExpression__Group__4__Impl6284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group_4__0__Impl_in_rule__OperationCallExpression__Group_4__06325 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group_4__1_in_rule__OperationCallExpression__Group_4__06328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__OperationCallExpression__Group_4__0__Impl6356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group_4__1__Impl_in_rule__OperationCallExpression__Group_4__16387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__SuffixAssignment_4_1_in_rule__OperationCallExpression__Group_4__1__Impl6414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__06448 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1_in_rule__NameOrChoiceOrBehaviorCall__Group__06451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__PathAssignment_0_in_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl6478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__16509 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2_in_rule__NameOrChoiceOrBehaviorCall__Group__16512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__IdAssignment_1_in_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl6539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__26569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0_in_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl6596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__06633 = new BitSet(new long[]{0x000744CFDE0007F0L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__06636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl6664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__16695 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2_in_rule__NameOrChoiceOrBehaviorCall__Group_2__16698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl6725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__26756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl6784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__06821 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__06824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl6851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__16881 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__16884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__QualifiedName__Group__1__Impl6912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__26943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl6970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__0__Impl_in_rule__Interval__Group__07007 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__Interval__Group__1_in_rule__Interval__Group__07010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Alternatives_0_in_rule__Interval__Group__0__Impl7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__1__Impl_in_rule__Interval__Group__17067 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Interval__Group__2_in_rule__Interval__Group__17070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__LowerAssignment_1_in_rule__Interval__Group__1__Impl7097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__2__Impl_in_rule__Interval__Group__27127 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__Interval__Group__3_in_rule__Interval__Group__27130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Interval__Group__2__Impl7158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__3__Impl_in_rule__Interval__Group__37189 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__Interval__Group__4_in_rule__Interval__Group__37192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__UpperAssignment_3_in_rule__Interval__Group__3__Impl7219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__4__Impl_in_rule__Interval__Group__47249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Alternatives_4_in_rule__Interval__Group__4__Impl7276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__0__Impl_in_rule__CollectionOrTuple__Group__07316 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__1_in_rule__CollectionOrTuple__Group__07319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__CollectionOrTuple__Group__0__Impl7347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__1__Impl_in_rule__CollectionOrTuple__Group__17378 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__2_in_rule__CollectionOrTuple__Group__17381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__ListOfValuesAssignment_1_in_rule__CollectionOrTuple__Group__1__Impl7408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__2__Impl_in_rule__CollectionOrTuple__Group__27438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__CollectionOrTuple__Group__2__Impl7466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__Group__0__Impl_in_rule__Tuple__Group__07503 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Tuple__Group__1_in_rule__Tuple__Group__07506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Tuple__Group__0__Impl7534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__Group__1__Impl_in_rule__Tuple__Group__17565 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__Tuple__Group__2_in_rule__Tuple__Group__17568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__ListOfValueNamePairsAssignment_1_in_rule__Tuple__Group__1__Impl7595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__Group__2__Impl_in_rule__Tuple__Group__27625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Tuple__Group__2__Impl7653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__0__Impl_in_rule__ListOfValues__Group__07690 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__1_in_rule__ListOfValues__Group__07693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__ValuesAssignment_0_in_rule__ListOfValues__Group__0__Impl7720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__1__Impl_in_rule__ListOfValues__Group__17750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__0_in_rule__ListOfValues__Group__1__Impl7777 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__0__Impl_in_rule__ListOfValues__Group_1__07812 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__1_in_rule__ListOfValues__Group_1__07815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ListOfValues__Group_1__0__Impl7843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__1__Impl_in_rule__ListOfValues__Group_1__17874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__ValuesAssignment_1_1_in_rule__ListOfValues__Group_1__1__Impl7901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group__0__Impl_in_rule__ListOfValueNamePairs__Group__07935 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group__1_in_rule__ListOfValueNamePairs__Group__07938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_0_in_rule__ListOfValueNamePairs__Group__0__Impl7965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group__1__Impl_in_rule__ListOfValueNamePairs__Group__17995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group_1__0_in_rule__ListOfValueNamePairs__Group__1__Impl8022 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group_1__0__Impl_in_rule__ListOfValueNamePairs__Group_1__08057 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group_1__1_in_rule__ListOfValueNamePairs__Group_1__08060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ListOfValueNamePairs__Group_1__0__Impl8088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group_1__1__Impl_in_rule__ListOfValueNamePairs__Group_1__18119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1_in_rule__ListOfValueNamePairs__Group_1__1__Impl8146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__0__Impl_in_rule__ValueNamePair__Group__08180 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__1_in_rule__ValueNamePair__Group__08183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__PropertyAssignment_0_in_rule__ValueNamePair__Group__0__Impl8210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__1__Impl_in_rule__ValueNamePair__Group__18240 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__2_in_rule__ValueNamePair__Group__18243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ValueNamePair__Group__1__Impl8271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__2__Impl_in_rule__ValueNamePair__Group__28302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__ValueAssignment_2_in_rule__ValueNamePair__Group__2__Impl8329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__0__Impl_in_rule__InstantObsExpression__Group__08365 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__1_in_rule__InstantObsExpression__Group__08368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__InstantObsExpression__Group__0__Impl8396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__1__Impl_in_rule__InstantObsExpression__Group__18427 = new BitSet(new long[]{0x0000804000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__2_in_rule__InstantObsExpression__Group__18430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__IdAssignment_1_in_rule__InstantObsExpression__Group__1__Impl8457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__2__Impl_in_rule__InstantObsExpression__Group__28487 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__3_in_rule__InstantObsExpression__Group__28490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__0_in_rule__InstantObsExpression__Group__2__Impl8517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__3__Impl_in_rule__InstantObsExpression__Group__38548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__0_in_rule__InstantObsExpression__Group__3__Impl8575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__0__Impl_in_rule__InstantObsExpression__Group_2__08614 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__1_in_rule__InstantObsExpression__Group_2__08617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__InstantObsExpression__Group_2__0__Impl8645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__1__Impl_in_rule__InstantObsExpression__Group_2__18676 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__2_in_rule__InstantObsExpression__Group_2__18679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__IndexAssignment_2_1_in_rule__InstantObsExpression__Group_2__1__Impl8706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__2__Impl_in_rule__InstantObsExpression__Group_2__28736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__InstantObsExpression__Group_2__2__Impl8764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__0__Impl_in_rule__InstantObsExpression__Group_3__08801 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__1_in_rule__InstantObsExpression__Group_3__08804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__InstantObsExpression__Group_3__0__Impl8832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__1__Impl_in_rule__InstantObsExpression__Group_3__18863 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__2_in_rule__InstantObsExpression__Group_3__18866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__InstantObsExpression__Group_3__1__Impl8894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__2__Impl_in_rule__InstantObsExpression__Group_3__28925 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__3_in_rule__InstantObsExpression__Group_3__28928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__ConditionAssignment_3_2_in_rule__InstantObsExpression__Group_3__2__Impl8955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__3__Impl_in_rule__InstantObsExpression__Group_3__38985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__InstantObsExpression__Group_3__3__Impl9013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__Group__0__Impl_in_rule__InstantObsName__Group__09052 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__InstantObsName__Group__1_in_rule__InstantObsName__Group__09055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__PathAssignment_0_in_rule__InstantObsName__Group__0__Impl9082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__Group__1__Impl_in_rule__InstantObsName__Group__19113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__InstantIdAssignment_1_in_rule__InstantObsName__Group__1__Impl9140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__0__Impl_in_rule__DurationObsExpression__Group__09174 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__1_in_rule__DurationObsExpression__Group__09177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__DurationObsExpression__Group__0__Impl9205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__1__Impl_in_rule__DurationObsExpression__Group__19236 = new BitSet(new long[]{0x0000804000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__2_in_rule__DurationObsExpression__Group__19239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__IdAssignment_1_in_rule__DurationObsExpression__Group__1__Impl9266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__2__Impl_in_rule__DurationObsExpression__Group__29296 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__3_in_rule__DurationObsExpression__Group__29299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__0_in_rule__DurationObsExpression__Group__2__Impl9326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__3__Impl_in_rule__DurationObsExpression__Group__39357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__0_in_rule__DurationObsExpression__Group__3__Impl9384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__0__Impl_in_rule__DurationObsExpression__Group_2__09423 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__1_in_rule__DurationObsExpression__Group_2__09426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__DurationObsExpression__Group_2__0__Impl9454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__1__Impl_in_rule__DurationObsExpression__Group_2__19485 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__2_in_rule__DurationObsExpression__Group_2__19488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__IndexAssignment_2_1_in_rule__DurationObsExpression__Group_2__1__Impl9515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__2__Impl_in_rule__DurationObsExpression__Group_2__29545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__DurationObsExpression__Group_2__2__Impl9573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__0__Impl_in_rule__DurationObsExpression__Group_3__09610 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__1_in_rule__DurationObsExpression__Group_3__09613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__DurationObsExpression__Group_3__0__Impl9641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__1__Impl_in_rule__DurationObsExpression__Group_3__19672 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__2_in_rule__DurationObsExpression__Group_3__19675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__DurationObsExpression__Group_3__1__Impl9703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__2__Impl_in_rule__DurationObsExpression__Group_3__29734 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__3_in_rule__DurationObsExpression__Group_3__29737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__ConditionAssignment_3_2_in_rule__DurationObsExpression__Group_3__2__Impl9764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__3__Impl_in_rule__DurationObsExpression__Group_3__39794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__DurationObsExpression__Group_3__3__Impl9822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__Group__0__Impl_in_rule__DurationObsName__Group__09861 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DurationObsName__Group__1_in_rule__DurationObsName__Group__09864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__PathAssignment_0_in_rule__DurationObsName__Group__0__Impl9891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__Group__1__Impl_in_rule__DurationObsName__Group__19922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__DurationIdAssignment_1_in_rule__DurationObsName__Group__1__Impl9949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__0__Impl_in_rule__JitterExp__Group__09983 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__1_in_rule__JitterExp__Group__09986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__JitterExp__Group__0__Impl10014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__1__Impl_in_rule__JitterExp__Group__110045 = new BitSet(new long[]{0x0000008004000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__2_in_rule__JitterExp__Group__110048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__FirstInstantAssignment_1_in_rule__JitterExp__Group__1__Impl10075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__2__Impl_in_rule__JitterExp__Group__210105 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__3_in_rule__JitterExp__Group__210108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__0_in_rule__JitterExp__Group__2__Impl10135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__3__Impl_in_rule__JitterExp__Group__310166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__JitterExp__Group__3__Impl10194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__0__Impl_in_rule__JitterExp__Group_2__010233 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__1_in_rule__JitterExp__Group_2__010236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__JitterExp__Group_2__0__Impl10264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__1__Impl_in_rule__JitterExp__Group_2__110295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__SecondInstantAssignment_2_1_in_rule__JitterExp__Group_2__1__Impl10322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__0__Impl_in_rule__VariableDeclaration__Group__010356 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__1_in_rule__VariableDeclaration__Group__010359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__VariableDeclarationAssignment_0_in_rule__VariableDeclaration__Group__0__Impl10386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__1__Impl_in_rule__VariableDeclaration__Group__110417 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__2_in_rule__VariableDeclaration__Group__110420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__VariableDeclaration__Group__1__Impl10448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__2__Impl_in_rule__VariableDeclaration__Group__210479 = new BitSet(new long[]{0x0000201000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__3_in_rule__VariableDeclaration__Group__210482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__NameAssignment_2_in_rule__VariableDeclaration__Group__2__Impl10509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__3__Impl_in_rule__VariableDeclaration__Group__310539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Alternatives_3_in_rule__VariableDeclaration__Group__3__Impl10566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__0__Impl_in_rule__VariableDeclaration__Group_3_0__010604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__1_in_rule__VariableDeclaration__Group_3_0__010607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__VariableDeclaration__Group_3_0__0__Impl10635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__1__Impl_in_rule__VariableDeclaration__Group_3_0__110666 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__2_in_rule__VariableDeclaration__Group_3_0__110669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__TypeAssignment_3_0_1_in_rule__VariableDeclaration__Group_3_0__1__Impl10696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__2__Impl_in_rule__VariableDeclaration__Group_3_0__210726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__0_in_rule__VariableDeclaration__Group_3_0__2__Impl10753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__0__Impl_in_rule__VariableDeclaration__Group_3_0_2__010790 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__1_in_rule__VariableDeclaration__Group_3_0_2__010793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__VariableDeclaration__Group_3_0_2__0__Impl10821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__1__Impl_in_rule__VariableDeclaration__Group_3_0_2__110852 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__2_in_rule__VariableDeclaration__Group_3_0_2__110855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__VariableDeclaration__Group_3_0_2__1__Impl10883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__2__Impl_in_rule__VariableDeclaration__Group_3_0_2__210914 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__3_in_rule__VariableDeclaration__Group_3_0_2__210917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_0_2_2_in_rule__VariableDeclaration__Group_3_0_2__2__Impl10944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__3__Impl_in_rule__VariableDeclaration__Group_3_0_2__310974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__VariableDeclaration__Group_3_0_2__3__Impl11002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__0__Impl_in_rule__VariableDeclaration__Group_3_1__011041 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__1_in_rule__VariableDeclaration__Group_3_1__011044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__VariableDeclaration__Group_3_1__0__Impl11072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__1__Impl_in_rule__VariableDeclaration__Group_3_1__111103 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__2_in_rule__VariableDeclaration__Group_3_1__111106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__VariableDeclaration__Group_3_1__1__Impl11134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__2__Impl_in_rule__VariableDeclaration__Group_3_1__211165 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__3_in_rule__VariableDeclaration__Group_3_1__211168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_1_2_in_rule__VariableDeclaration__Group_3_1__2__Impl11195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__3__Impl_in_rule__VariableDeclaration__Group_3_1__311225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__VariableDeclaration__Group_3_1__3__Impl11253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__Group__0__Impl_in_rule__DataTypeName__Group__011292 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DataTypeName__Group__1_in_rule__DataTypeName__Group__011295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__PathAssignment_0_in_rule__DataTypeName__Group__0__Impl11322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__Group__1__Impl_in_rule__DataTypeName__Group__111353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__TypeAssignment_1_in_rule__DataTypeName__Group__1__Impl11380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_rule__Expression__ExpAssignment11419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_011450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__OpAlternatives_1_0_0_in_rule__AndOrXorExpression__OpAssignment_1_011481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_1_111514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_011545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__OpAlternatives_1_0_0_in_rule__EqualityExpression__OpAssignment_1_011576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_1_111609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_011640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__OpAlternatives_1_0_0_in_rule__RelationalExpression__OpAssignment_1_011671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_1_111704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_011735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ConditionalExpression__OpAssignment_1_011771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_111810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_311841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_011872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__OpAlternatives_1_0_0_in_rule__AdditiveExpression__OpAssignment_1_011903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_1_111936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_011967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__OpAlternatives_1_0_0_in_rule__MultiplicativeExpression__OpAssignment_1_011998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_1_112031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__OpAlternatives_0_0_0_in_rule__UnaryExpression__OpAssignment_0_012062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rule__UnaryExpression__UnaryAssignment_0_112095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__UnaryExpression__ExpAssignment_112126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rule__PrimaryExpression__PrefixAssignment_012157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rule__PrimaryExpression__SuffixAssignment_1_112188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyCallExpression__PropertyAssignment_012223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rule__PropertyCallExpression__SuffixAssignment_1_112258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__OperationCallExpression__OperationAssignment_012293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_rule__OperationCallExpression__ArgumentsAssignment_212328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rule__OperationCallExpression__SuffixAssignment_4_112359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__NameOrChoiceOrBehaviorCall__PathAssignment_012390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NameOrChoiceOrBehaviorCall__IdAssignment_112425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_112460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_012495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_212530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Interval__IsLowerIncludedAssignment_0_112566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Interval__LowerAssignment_112605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Interval__UpperAssignment_312636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Interval__IsUpperIncludedAssignment_4_012672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_rule__CollectionOrTuple__ListOfValuesAssignment_112711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_rule__Tuple__ListOfValueNamePairsAssignment_112742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_012773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_1_112804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_012835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_112866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ValueNamePair__PropertyAssignment_012901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ValueNamePair__ValueAssignment_212936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_rule__InstantObsExpression__IdAssignment_112967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__InstantObsExpression__IndexAssignment_2_112998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__InstantObsExpression__ConditionAssignment_3_213029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__InstantObsName__PathAssignment_013060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__InstantObsName__InstantIdAssignment_113095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_rule__DurationObsExpression__IdAssignment_113130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__DurationObsExpression__IndexAssignment_2_113161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__DurationObsExpression__ConditionAssignment_3_213192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__DurationObsName__PathAssignment_013223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DurationObsName__DurationIdAssignment_113258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__FirstInstantAssignment_113293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__SecondInstantAssignment_2_113324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_rule__VariableDeclaration__VariableDeclarationAssignment_013355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableDeclaration__NameAssignment_213386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_rule__VariableDeclaration__TypeAssignment_3_0_113417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_0_2_213448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_1_213479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__DataTypeName__PathAssignment_013510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DataTypeName__TypeAssignment_113545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_rule__IntegerLiteralRule__ValueAssignment13580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__UnlimitedLiteralRule__ValueAssignment13616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_rule__RealLiteralRule__ValueAssignment13655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_rule__DateTimeLiteralRule__ValueAssignment13686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_rule__BooleanLiteralRule__ValueAssignment13717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_rule__NullLiteralRule__ValueAssignment13748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__DefaultLiteralRule__ValueAssignment13784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteralRule__ValueAssignment13823 = new BitSet(new long[]{0x0000000000000002L});

}