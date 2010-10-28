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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INTEGERLITERAL", "RULE_REALLITERAL", "RULE_DATETIMELITERAL", "RULE_BOOLEANLITERAL", "RULE_NULLLITERAL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'mod'", "'not'", "']'", "'['", "'in'", "'out'", "'inout'", "'value'", "'import'", "'context'", "':'", "'.'", "'('", "')'", "'::'", "'..'", "'{'", "'}'", "','", "'='", "'@'", "'when'", "'&'", "'jitter('", "'$'", "'?'"
    };
    public static final int RULE_NULLLITERAL=10;
    public static final int RULE_DATETIMELITERAL=8;
    public static final int RULE_BOOLEANLITERAL=9;
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=15;
    public static final int RULE_REALLITERAL=7;
    public static final int RULE_INTEGERLITERAL=6;
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




    // $ANTLR start entryRuleModel
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:63:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:70:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:74:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:75:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:75:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:76:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:77:1: ( rule__Model__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:77:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleImport
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:89:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:90:1: ( ruleImport EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:91:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport121);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport128); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:98:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:102:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:103:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:103:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:104:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:105:1: ( rule__Import__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:105:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport154);
            rule__Import__Group__0();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleContext
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:117:1: entryRuleContext : ruleContext EOF ;
    public final void entryRuleContext() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:118:1: ( ruleContext EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:119:1: ruleContext EOF
            {
             before(grammarAccess.getContextRule()); 
            pushFollow(FOLLOW_ruleContext_in_entryRuleContext181);
            ruleContext();
            _fsp--;

             after(grammarAccess.getContextRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContext188); 

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
    // $ANTLR end entryRuleContext


    // $ANTLR start ruleContext
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:126:1: ruleContext : ( ( rule__Context__Group__0 ) ) ;
    public final void ruleContext() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:130:2: ( ( ( rule__Context__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:131:1: ( ( rule__Context__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:131:1: ( ( rule__Context__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:132:1: ( rule__Context__Group__0 )
            {
             before(grammarAccess.getContextAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:133:1: ( rule__Context__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:133:2: rule__Context__Group__0
            {
            pushFollow(FOLLOW_rule__Context__Group__0_in_ruleContext214);
            rule__Context__Group__0();
            _fsp--;


            }

             after(grammarAccess.getContextAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleContext


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:145:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:146:1: ( ruleExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:147:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression241);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression248); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:154:1: ruleExpression : ( ( rule__Expression__ExpAssignment ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:158:2: ( ( ( rule__Expression__ExpAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:159:1: ( ( rule__Expression__ExpAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:159:1: ( ( rule__Expression__ExpAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:160:1: ( rule__Expression__ExpAssignment )
            {
             before(grammarAccess.getExpressionAccess().getExpAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:161:1: ( rule__Expression__ExpAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:161:2: rule__Expression__ExpAssignment
            {
            pushFollow(FOLLOW_rule__Expression__ExpAssignment_in_ruleExpression274);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:173:1: entryRuleAndOrXorExpression : ruleAndOrXorExpression EOF ;
    public final void entryRuleAndOrXorExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:174:1: ( ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:175:1: ruleAndOrXorExpression EOF
            {
             before(grammarAccess.getAndOrXorExpressionRule()); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression301);
            ruleAndOrXorExpression();
            _fsp--;

             after(grammarAccess.getAndOrXorExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOrXorExpression308); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:182:1: ruleAndOrXorExpression : ( ( rule__AndOrXorExpression__Group__0 ) ) ;
    public final void ruleAndOrXorExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:186:2: ( ( ( rule__AndOrXorExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:187:1: ( ( rule__AndOrXorExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:187:1: ( ( rule__AndOrXorExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:188:1: ( rule__AndOrXorExpression__Group__0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:189:1: ( rule__AndOrXorExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:189:2: rule__AndOrXorExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__0_in_ruleAndOrXorExpression334);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:201:1: entryRuleEqualityExpression : ruleEqualityExpression EOF ;
    public final void entryRuleEqualityExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:202:1: ( ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:203:1: ruleEqualityExpression EOF
            {
             before(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression361);
            ruleEqualityExpression();
            _fsp--;

             after(grammarAccess.getEqualityExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression368); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:210:1: ruleEqualityExpression : ( ( rule__EqualityExpression__Group__0 ) ) ;
    public final void ruleEqualityExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:214:2: ( ( ( rule__EqualityExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:215:1: ( ( rule__EqualityExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:215:1: ( ( rule__EqualityExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:216:1: ( rule__EqualityExpression__Group__0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:217:1: ( rule__EqualityExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:217:2: rule__EqualityExpression__Group__0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__0_in_ruleEqualityExpression394);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:229:1: entryRuleRelationalExpression : ruleRelationalExpression EOF ;
    public final void entryRuleRelationalExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:230:1: ( ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:231:1: ruleRelationalExpression EOF
            {
             before(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression421);
            ruleRelationalExpression();
            _fsp--;

             after(grammarAccess.getRelationalExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression428); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:238:1: ruleRelationalExpression : ( ( rule__RelationalExpression__Group__0 ) ) ;
    public final void ruleRelationalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:242:2: ( ( ( rule__RelationalExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:243:1: ( ( rule__RelationalExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:243:1: ( ( rule__RelationalExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:244:1: ( rule__RelationalExpression__Group__0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:245:1: ( rule__RelationalExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:245:2: rule__RelationalExpression__Group__0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__0_in_ruleRelationalExpression454);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:257:1: entryRuleConditionalExpression : ruleConditionalExpression EOF ;
    public final void entryRuleConditionalExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:258:1: ( ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:259:1: ruleConditionalExpression EOF
            {
             before(grammarAccess.getConditionalExpressionRule()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression481);
            ruleConditionalExpression();
            _fsp--;

             after(grammarAccess.getConditionalExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression488); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:266:1: ruleConditionalExpression : ( ( rule__ConditionalExpression__Group__0 ) ) ;
    public final void ruleConditionalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:270:2: ( ( ( rule__ConditionalExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:271:1: ( ( rule__ConditionalExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:271:1: ( ( rule__ConditionalExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:272:1: ( rule__ConditionalExpression__Group__0 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:273:1: ( rule__ConditionalExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:273:2: rule__ConditionalExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__0_in_ruleConditionalExpression514);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:285:1: entryRuleAdditiveExpression : ruleAdditiveExpression EOF ;
    public final void entryRuleAdditiveExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:286:1: ( ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:287:1: ruleAdditiveExpression EOF
            {
             before(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression541);
            ruleAdditiveExpression();
            _fsp--;

             after(grammarAccess.getAdditiveExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression548); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:294:1: ruleAdditiveExpression : ( ( rule__AdditiveExpression__Group__0 ) ) ;
    public final void ruleAdditiveExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:298:2: ( ( ( rule__AdditiveExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:299:1: ( ( rule__AdditiveExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:299:1: ( ( rule__AdditiveExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:300:1: ( rule__AdditiveExpression__Group__0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:301:1: ( rule__AdditiveExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:301:2: rule__AdditiveExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__0_in_ruleAdditiveExpression574);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:313:1: entryRuleMultiplicativeExpression : ruleMultiplicativeExpression EOF ;
    public final void entryRuleMultiplicativeExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:314:1: ( ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:315:1: ruleMultiplicativeExpression EOF
            {
             before(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression601);
            ruleMultiplicativeExpression();
            _fsp--;

             after(grammarAccess.getMultiplicativeExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression608); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:322:1: ruleMultiplicativeExpression : ( ( rule__MultiplicativeExpression__Group__0 ) ) ;
    public final void ruleMultiplicativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:326:2: ( ( ( rule__MultiplicativeExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:327:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:327:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:328:1: ( rule__MultiplicativeExpression__Group__0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:329:1: ( rule__MultiplicativeExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:329:2: rule__MultiplicativeExpression__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__0_in_ruleMultiplicativeExpression634);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:341:1: entryRuleUnaryExpression : ruleUnaryExpression EOF ;
    public final void entryRuleUnaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:342:1: ( ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:343:1: ruleUnaryExpression EOF
            {
             before(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression661);
            ruleUnaryExpression();
            _fsp--;

             after(grammarAccess.getUnaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression668); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:350:1: ruleUnaryExpression : ( ( rule__UnaryExpression__Alternatives ) ) ;
    public final void ruleUnaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:354:2: ( ( ( rule__UnaryExpression__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:355:1: ( ( rule__UnaryExpression__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:355:1: ( ( rule__UnaryExpression__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:356:1: ( rule__UnaryExpression__Alternatives )
            {
             before(grammarAccess.getUnaryExpressionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:357:1: ( rule__UnaryExpression__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:357:2: rule__UnaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Alternatives_in_ruleUnaryExpression694);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:369:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:370:1: ( rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:371:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression721);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression728); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:378:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Group__0 ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:382:2: ( ( ( rule__PrimaryExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:383:1: ( ( rule__PrimaryExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:383:1: ( ( rule__PrimaryExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:384:1: ( rule__PrimaryExpression__Group__0 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:385:1: ( rule__PrimaryExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:385:2: rule__PrimaryExpression__Group__0
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group__0_in_rulePrimaryExpression754);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:397:1: entryRuleValueSpecification : ruleValueSpecification EOF ;
    public final void entryRuleValueSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:398:1: ( ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:399:1: ruleValueSpecification EOF
            {
             before(grammarAccess.getValueSpecificationRule()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification781);
            ruleValueSpecification();
            _fsp--;

             after(grammarAccess.getValueSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification788); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:406:1: ruleValueSpecification : ( ( rule__ValueSpecification__Alternatives ) ) ;
    public final void ruleValueSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:410:2: ( ( ( rule__ValueSpecification__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:411:1: ( ( rule__ValueSpecification__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:411:1: ( ( rule__ValueSpecification__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:412:1: ( rule__ValueSpecification__Alternatives )
            {
             before(grammarAccess.getValueSpecificationAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:413:1: ( rule__ValueSpecification__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:413:2: rule__ValueSpecification__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Alternatives_in_ruleValueSpecification814);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:425:1: entryRuleSuffixExpression : ruleSuffixExpression EOF ;
    public final void entryRuleSuffixExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:426:1: ( ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:427:1: ruleSuffixExpression EOF
            {
             before(grammarAccess.getSuffixExpressionRule()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression841);
            ruleSuffixExpression();
            _fsp--;

             after(grammarAccess.getSuffixExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression848); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:434:1: ruleSuffixExpression : ( ( rule__SuffixExpression__Alternatives ) ) ;
    public final void ruleSuffixExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:438:2: ( ( ( rule__SuffixExpression__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:439:1: ( ( rule__SuffixExpression__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:439:1: ( ( rule__SuffixExpression__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:440:1: ( rule__SuffixExpression__Alternatives )
            {
             before(grammarAccess.getSuffixExpressionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:441:1: ( rule__SuffixExpression__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:441:2: rule__SuffixExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__SuffixExpression__Alternatives_in_ruleSuffixExpression874);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:453:1: entryRulePropertyCallExpression : rulePropertyCallExpression EOF ;
    public final void entryRulePropertyCallExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:454:1: ( rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:455:1: rulePropertyCallExpression EOF
            {
             before(grammarAccess.getPropertyCallExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression901);
            rulePropertyCallExpression();
            _fsp--;

             after(grammarAccess.getPropertyCallExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression908); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:462:1: rulePropertyCallExpression : ( ( rule__PropertyCallExpression__Group__0 ) ) ;
    public final void rulePropertyCallExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:466:2: ( ( ( rule__PropertyCallExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:467:1: ( ( rule__PropertyCallExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:467:1: ( ( rule__PropertyCallExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:468:1: ( rule__PropertyCallExpression__Group__0 )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:469:1: ( rule__PropertyCallExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:469:2: rule__PropertyCallExpression__Group__0
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__0_in_rulePropertyCallExpression934);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:481:1: entryRuleOperationCallExpression : ruleOperationCallExpression EOF ;
    public final void entryRuleOperationCallExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:482:1: ( ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:483:1: ruleOperationCallExpression EOF
            {
             before(grammarAccess.getOperationCallExpressionRule()); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression961);
            ruleOperationCallExpression();
            _fsp--;

             after(grammarAccess.getOperationCallExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression968); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:490:1: ruleOperationCallExpression : ( ( rule__OperationCallExpression__Group__0 ) ) ;
    public final void ruleOperationCallExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:494:2: ( ( ( rule__OperationCallExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:495:1: ( ( rule__OperationCallExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:495:1: ( ( rule__OperationCallExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:496:1: ( rule__OperationCallExpression__Group__0 )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:497:1: ( rule__OperationCallExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:497:2: rule__OperationCallExpression__Group__0
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__0_in_ruleOperationCallExpression994);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:509:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:510:1: ( ruleLiteral EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:511:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1021);
            ruleLiteral();
            _fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1028); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:518:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:522:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:523:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:523:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:524:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:525:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:525:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1054);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:537:1: entryRuleNameOrChoiceOrBehaviorCall : ruleNameOrChoiceOrBehaviorCall EOF ;
    public final void entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:538:1: ( ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:539:1: ruleNameOrChoiceOrBehaviorCall EOF
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallRule()); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall1081);
            ruleNameOrChoiceOrBehaviorCall();
            _fsp--;

             after(grammarAccess.getNameOrChoiceOrBehaviorCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall1088); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:546:1: ruleNameOrChoiceOrBehaviorCall : ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) ) ;
    public final void ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:550:2: ( ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:551:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:551:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:552:1: ( rule__NameOrChoiceOrBehaviorCall__Group__0 )
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:553:1: ( rule__NameOrChoiceOrBehaviorCall__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:553:2: rule__NameOrChoiceOrBehaviorCall__Group__0
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0_in_ruleNameOrChoiceOrBehaviorCall1114);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:565:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:566:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:567:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1141);
            ruleQualifiedName();
            _fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1148); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:574:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:578:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:579:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:579:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:580:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:581:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:581:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName1174);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:593:1: entryRuleInterval : ruleInterval EOF ;
    public final void entryRuleInterval() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:594:1: ( ruleInterval EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:595:1: ruleInterval EOF
            {
             before(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval1201);
            ruleInterval();
            _fsp--;

             after(grammarAccess.getIntervalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval1208); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:602:1: ruleInterval : ( ( rule__Interval__Group__0 ) ) ;
    public final void ruleInterval() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:606:2: ( ( ( rule__Interval__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:607:1: ( ( rule__Interval__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:607:1: ( ( rule__Interval__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:608:1: ( rule__Interval__Group__0 )
            {
             before(grammarAccess.getIntervalAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:609:1: ( rule__Interval__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:609:2: rule__Interval__Group__0
            {
            pushFollow(FOLLOW_rule__Interval__Group__0_in_ruleInterval1234);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:621:1: entryRuleCollectionOrTuple : ruleCollectionOrTuple EOF ;
    public final void entryRuleCollectionOrTuple() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:622:1: ( ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:623:1: ruleCollectionOrTuple EOF
            {
             before(grammarAccess.getCollectionOrTupleRule()); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple1261);
            ruleCollectionOrTuple();
            _fsp--;

             after(grammarAccess.getCollectionOrTupleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionOrTuple1268); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:630:1: ruleCollectionOrTuple : ( ( rule__CollectionOrTuple__Group__0 ) ) ;
    public final void ruleCollectionOrTuple() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:634:2: ( ( ( rule__CollectionOrTuple__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:635:1: ( ( rule__CollectionOrTuple__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:635:1: ( ( rule__CollectionOrTuple__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:636:1: ( rule__CollectionOrTuple__Group__0 )
            {
             before(grammarAccess.getCollectionOrTupleAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:637:1: ( rule__CollectionOrTuple__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:637:2: rule__CollectionOrTuple__Group__0
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__0_in_ruleCollectionOrTuple1294);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:649:1: entryRuleTuple : ruleTuple EOF ;
    public final void entryRuleTuple() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:650:1: ( ruleTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:651:1: ruleTuple EOF
            {
             before(grammarAccess.getTupleRule()); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple1321);
            ruleTuple();
            _fsp--;

             after(grammarAccess.getTupleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple1328); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:658:1: ruleTuple : ( ( rule__Tuple__Group__0 ) ) ;
    public final void ruleTuple() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:662:2: ( ( ( rule__Tuple__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:663:1: ( ( rule__Tuple__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:663:1: ( ( rule__Tuple__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:664:1: ( rule__Tuple__Group__0 )
            {
             before(grammarAccess.getTupleAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:665:1: ( rule__Tuple__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:665:2: rule__Tuple__Group__0
            {
            pushFollow(FOLLOW_rule__Tuple__Group__0_in_ruleTuple1354);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:677:1: entryRuleListOfValues : ruleListOfValues EOF ;
    public final void entryRuleListOfValues() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:678:1: ( ruleListOfValues EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:679:1: ruleListOfValues EOF
            {
             before(grammarAccess.getListOfValuesRule()); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues1381);
            ruleListOfValues();
            _fsp--;

             after(grammarAccess.getListOfValuesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValues1388); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:686:1: ruleListOfValues : ( ( rule__ListOfValues__Group__0 ) ) ;
    public final void ruleListOfValues() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:690:2: ( ( ( rule__ListOfValues__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:691:1: ( ( rule__ListOfValues__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:691:1: ( ( rule__ListOfValues__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:692:1: ( rule__ListOfValues__Group__0 )
            {
             before(grammarAccess.getListOfValuesAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:693:1: ( rule__ListOfValues__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:693:2: rule__ListOfValues__Group__0
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group__0_in_ruleListOfValues1414);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:705:1: entryRuleListOfValueNamePairs : ruleListOfValueNamePairs EOF ;
    public final void entryRuleListOfValueNamePairs() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:706:1: ( ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:707:1: ruleListOfValueNamePairs EOF
            {
             before(grammarAccess.getListOfValueNamePairsRule()); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs1441);
            ruleListOfValueNamePairs();
            _fsp--;

             after(grammarAccess.getListOfValueNamePairsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListOfValueNamePairs1448); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:714:1: ruleListOfValueNamePairs : ( ( rule__ListOfValueNamePairs__Group__0 ) ) ;
    public final void ruleListOfValueNamePairs() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:718:2: ( ( ( rule__ListOfValueNamePairs__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:719:1: ( ( rule__ListOfValueNamePairs__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:719:1: ( ( rule__ListOfValueNamePairs__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:720:1: ( rule__ListOfValueNamePairs__Group__0 )
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:721:1: ( rule__ListOfValueNamePairs__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:721:2: rule__ListOfValueNamePairs__Group__0
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__0_in_ruleListOfValueNamePairs1474);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:733:1: entryRuleValueNamePair : ruleValueNamePair EOF ;
    public final void entryRuleValueNamePair() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:734:1: ( ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:735:1: ruleValueNamePair EOF
            {
             before(grammarAccess.getValueNamePairRule()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair1501);
            ruleValueNamePair();
            _fsp--;

             after(grammarAccess.getValueNamePairRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNamePair1508); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:742:1: ruleValueNamePair : ( ( rule__ValueNamePair__Group__0 ) ) ;
    public final void ruleValueNamePair() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:746:2: ( ( ( rule__ValueNamePair__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:747:1: ( ( rule__ValueNamePair__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:747:1: ( ( rule__ValueNamePair__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:748:1: ( rule__ValueNamePair__Group__0 )
            {
             before(grammarAccess.getValueNamePairAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:749:1: ( rule__ValueNamePair__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:749:2: rule__ValueNamePair__Group__0
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__0_in_ruleValueNamePair1534);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:761:1: entryRuleTimeExpression : ruleTimeExpression EOF ;
    public final void entryRuleTimeExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:762:1: ( ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:763:1: ruleTimeExpression EOF
            {
             before(grammarAccess.getTimeExpressionRule()); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression1561);
            ruleTimeExpression();
            _fsp--;

             after(grammarAccess.getTimeExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeExpression1568); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:770:1: ruleTimeExpression : ( ( rule__TimeExpression__Alternatives ) ) ;
    public final void ruleTimeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:774:2: ( ( ( rule__TimeExpression__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:775:1: ( ( rule__TimeExpression__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:775:1: ( ( rule__TimeExpression__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:776:1: ( rule__TimeExpression__Alternatives )
            {
             before(grammarAccess.getTimeExpressionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:777:1: ( rule__TimeExpression__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:777:2: rule__TimeExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__TimeExpression__Alternatives_in_ruleTimeExpression1594);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:789:1: entryRuleInstantObsExpression : ruleInstantObsExpression EOF ;
    public final void entryRuleInstantObsExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:790:1: ( ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:791:1: ruleInstantObsExpression EOF
            {
             before(grammarAccess.getInstantObsExpressionRule()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression1621);
            ruleInstantObsExpression();
            _fsp--;

             after(grammarAccess.getInstantObsExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsExpression1628); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:798:1: ruleInstantObsExpression : ( ( rule__InstantObsExpression__Group__0 ) ) ;
    public final void ruleInstantObsExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:802:2: ( ( ( rule__InstantObsExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:803:1: ( ( rule__InstantObsExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:803:1: ( ( rule__InstantObsExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:804:1: ( rule__InstantObsExpression__Group__0 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:805:1: ( rule__InstantObsExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:805:2: rule__InstantObsExpression__Group__0
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__0_in_ruleInstantObsExpression1654);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:817:1: entryRuleInstantObsName : ruleInstantObsName EOF ;
    public final void entryRuleInstantObsName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:818:1: ( ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:819:1: ruleInstantObsName EOF
            {
             before(grammarAccess.getInstantObsNameRule()); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName1681);
            ruleInstantObsName();
            _fsp--;

             after(grammarAccess.getInstantObsNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantObsName1688); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:826:1: ruleInstantObsName : ( ( rule__InstantObsName__Group__0 ) ) ;
    public final void ruleInstantObsName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:830:2: ( ( ( rule__InstantObsName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:831:1: ( ( rule__InstantObsName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:831:1: ( ( rule__InstantObsName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:832:1: ( rule__InstantObsName__Group__0 )
            {
             before(grammarAccess.getInstantObsNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:833:1: ( rule__InstantObsName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:833:2: rule__InstantObsName__Group__0
            {
            pushFollow(FOLLOW_rule__InstantObsName__Group__0_in_ruleInstantObsName1714);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:845:1: entryRuleDurationObsExpression : ruleDurationObsExpression EOF ;
    public final void entryRuleDurationObsExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:846:1: ( ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:847:1: ruleDurationObsExpression EOF
            {
             before(grammarAccess.getDurationObsExpressionRule()); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression1741);
            ruleDurationObsExpression();
            _fsp--;

             after(grammarAccess.getDurationObsExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsExpression1748); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:854:1: ruleDurationObsExpression : ( ( rule__DurationObsExpression__Group__0 ) ) ;
    public final void ruleDurationObsExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:858:2: ( ( ( rule__DurationObsExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:859:1: ( ( rule__DurationObsExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:859:1: ( ( rule__DurationObsExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:860:1: ( rule__DurationObsExpression__Group__0 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:861:1: ( rule__DurationObsExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:861:2: rule__DurationObsExpression__Group__0
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__0_in_ruleDurationObsExpression1774);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:873:1: entryRuleDurationObsName : ruleDurationObsName EOF ;
    public final void entryRuleDurationObsName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:874:1: ( ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:875:1: ruleDurationObsName EOF
            {
             before(grammarAccess.getDurationObsNameRule()); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName1801);
            ruleDurationObsName();
            _fsp--;

             after(grammarAccess.getDurationObsNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDurationObsName1808); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:882:1: ruleDurationObsName : ( ( rule__DurationObsName__Group__0 ) ) ;
    public final void ruleDurationObsName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:886:2: ( ( ( rule__DurationObsName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:887:1: ( ( rule__DurationObsName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:887:1: ( ( rule__DurationObsName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:888:1: ( rule__DurationObsName__Group__0 )
            {
             before(grammarAccess.getDurationObsNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:889:1: ( rule__DurationObsName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:889:2: rule__DurationObsName__Group__0
            {
            pushFollow(FOLLOW_rule__DurationObsName__Group__0_in_ruleDurationObsName1834);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:901:1: entryRuleJitterExp : ruleJitterExp EOF ;
    public final void entryRuleJitterExp() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:902:1: ( ruleJitterExp EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:903:1: ruleJitterExp EOF
            {
             before(grammarAccess.getJitterExpRule()); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp1861);
            ruleJitterExp();
            _fsp--;

             after(grammarAccess.getJitterExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJitterExp1868); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:910:1: ruleJitterExp : ( ( rule__JitterExp__Group__0 ) ) ;
    public final void ruleJitterExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:914:2: ( ( ( rule__JitterExp__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:915:1: ( ( rule__JitterExp__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:915:1: ( ( rule__JitterExp__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:916:1: ( rule__JitterExp__Group__0 )
            {
             before(grammarAccess.getJitterExpAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:917:1: ( rule__JitterExp__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:917:2: rule__JitterExp__Group__0
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__0_in_ruleJitterExp1894);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:929:1: entryRuleVariableDeclaration : ruleVariableDeclaration EOF ;
    public final void entryRuleVariableDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:930:1: ( ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:931:1: ruleVariableDeclaration EOF
            {
             before(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1921);
            ruleVariableDeclaration();
            _fsp--;

             after(grammarAccess.getVariableDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration1928); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:938:1: ruleVariableDeclaration : ( ( rule__VariableDeclaration__Group__0 ) ) ;
    public final void ruleVariableDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:942:2: ( ( ( rule__VariableDeclaration__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:943:1: ( ( rule__VariableDeclaration__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:943:1: ( ( rule__VariableDeclaration__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:944:1: ( rule__VariableDeclaration__Group__0 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:945:1: ( rule__VariableDeclaration__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:945:2: rule__VariableDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__0_in_ruleVariableDeclaration1954);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:957:1: entryRuleVariableDirectionKind : ruleVariableDirectionKind EOF ;
    public final void entryRuleVariableDirectionKind() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:958:1: ( ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:959:1: ruleVariableDirectionKind EOF
            {
             before(grammarAccess.getVariableDirectionKindRule()); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind1981);
            ruleVariableDirectionKind();
            _fsp--;

             after(grammarAccess.getVariableDirectionKindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDirectionKind1988); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:966:1: ruleVariableDirectionKind : ( ( rule__VariableDirectionKind__Alternatives ) ) ;
    public final void ruleVariableDirectionKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:970:2: ( ( ( rule__VariableDirectionKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:971:1: ( ( rule__VariableDirectionKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:971:1: ( ( rule__VariableDirectionKind__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:972:1: ( rule__VariableDirectionKind__Alternatives )
            {
             before(grammarAccess.getVariableDirectionKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:973:1: ( rule__VariableDirectionKind__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:973:2: rule__VariableDirectionKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VariableDirectionKind__Alternatives_in_ruleVariableDirectionKind2014);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:985:1: entryRuleDataTypeName : ruleDataTypeName EOF ;
    public final void entryRuleDataTypeName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:986:1: ( ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:987:1: ruleDataTypeName EOF
            {
             before(grammarAccess.getDataTypeNameRule()); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName2041);
            ruleDataTypeName();
            _fsp--;

             after(grammarAccess.getDataTypeNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeName2048); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:994:1: ruleDataTypeName : ( ( rule__DataTypeName__Group__0 ) ) ;
    public final void ruleDataTypeName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:998:2: ( ( ( rule__DataTypeName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:999:1: ( ( rule__DataTypeName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:999:1: ( ( rule__DataTypeName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1000:1: ( rule__DataTypeName__Group__0 )
            {
             before(grammarAccess.getDataTypeNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1001:1: ( rule__DataTypeName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1001:2: rule__DataTypeName__Group__0
            {
            pushFollow(FOLLOW_rule__DataTypeName__Group__0_in_ruleDataTypeName2074);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1013:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1014:1: ( ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1015:1: ruleNumberLiteralRule EOF
            {
             before(grammarAccess.getNumberLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule2101);
            ruleNumberLiteralRule();
            _fsp--;

             after(grammarAccess.getNumberLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralRule2108); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1022:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1026:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1027:1: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1027:1: ( ( rule__NumberLiteralRule__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1028:1: ( rule__NumberLiteralRule__Alternatives )
            {
             before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1029:1: ( rule__NumberLiteralRule__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1029:2: rule__NumberLiteralRule__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteralRule__Alternatives_in_ruleNumberLiteralRule2134);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1041:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1042:1: ( ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1043:1: ruleIntegerLiteralRule EOF
            {
             before(grammarAccess.getIntegerLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule2161);
            ruleIntegerLiteralRule();
            _fsp--;

             after(grammarAccess.getIntegerLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteralRule2168); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1050:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__ValueAssignment ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1054:2: ( ( ( rule__IntegerLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1055:1: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1055:1: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1056:1: ( rule__IntegerLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1057:1: ( rule__IntegerLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1057:2: rule__IntegerLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__IntegerLiteralRule__ValueAssignment_in_ruleIntegerLiteralRule2194);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1069:1: entryRuleUnlimitedLiteralRule : ruleUnlimitedLiteralRule EOF ;
    public final void entryRuleUnlimitedLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1070:1: ( ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1071:1: ruleUnlimitedLiteralRule EOF
            {
             before(grammarAccess.getUnlimitedLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule2221);
            ruleUnlimitedLiteralRule();
            _fsp--;

             after(grammarAccess.getUnlimitedLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule2228); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1078:1: ruleUnlimitedLiteralRule : ( ( rule__UnlimitedLiteralRule__ValueAssignment ) ) ;
    public final void ruleUnlimitedLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1082:2: ( ( ( rule__UnlimitedLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1083:1: ( ( rule__UnlimitedLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1083:1: ( ( rule__UnlimitedLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1084:1: ( rule__UnlimitedLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1085:1: ( rule__UnlimitedLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1085:2: rule__UnlimitedLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__UnlimitedLiteralRule__ValueAssignment_in_ruleUnlimitedLiteralRule2254);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1097:1: entryRuleRealLiteralRule : ruleRealLiteralRule EOF ;
    public final void entryRuleRealLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1098:1: ( ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1099:1: ruleRealLiteralRule EOF
            {
             before(grammarAccess.getRealLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule2281);
            ruleRealLiteralRule();
            _fsp--;

             after(grammarAccess.getRealLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralRule2288); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1106:1: ruleRealLiteralRule : ( ( rule__RealLiteralRule__ValueAssignment ) ) ;
    public final void ruleRealLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1110:2: ( ( ( rule__RealLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1111:1: ( ( rule__RealLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1111:1: ( ( rule__RealLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1112:1: ( rule__RealLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getRealLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1113:1: ( rule__RealLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1113:2: rule__RealLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__RealLiteralRule__ValueAssignment_in_ruleRealLiteralRule2314);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1125:1: entryRuleDateTimeLiteralRule : ruleDateTimeLiteralRule EOF ;
    public final void entryRuleDateTimeLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1126:1: ( ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1127:1: ruleDateTimeLiteralRule EOF
            {
             before(grammarAccess.getDateTimeLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule2341);
            ruleDateTimeLiteralRule();
            _fsp--;

             after(grammarAccess.getDateTimeLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateTimeLiteralRule2348); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1134:1: ruleDateTimeLiteralRule : ( ( rule__DateTimeLiteralRule__ValueAssignment ) ) ;
    public final void ruleDateTimeLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1138:2: ( ( ( rule__DateTimeLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1139:1: ( ( rule__DateTimeLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1139:1: ( ( rule__DateTimeLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1140:1: ( rule__DateTimeLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getDateTimeLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1141:1: ( rule__DateTimeLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1141:2: rule__DateTimeLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__DateTimeLiteralRule__ValueAssignment_in_ruleDateTimeLiteralRule2374);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1153:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1154:1: ( ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1155:1: ruleBooleanLiteralRule EOF
            {
             before(grammarAccess.getBooleanLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule2401);
            ruleBooleanLiteralRule();
            _fsp--;

             after(grammarAccess.getBooleanLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralRule2408); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1162:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__ValueAssignment ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1166:2: ( ( ( rule__BooleanLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1167:1: ( ( rule__BooleanLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1167:1: ( ( rule__BooleanLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1168:1: ( rule__BooleanLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1169:1: ( rule__BooleanLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1169:2: rule__BooleanLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BooleanLiteralRule__ValueAssignment_in_ruleBooleanLiteralRule2434);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1181:1: entryRuleNullLiteralRule : ruleNullLiteralRule EOF ;
    public final void entryRuleNullLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1182:1: ( ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1183:1: ruleNullLiteralRule EOF
            {
             before(grammarAccess.getNullLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule2461);
            ruleNullLiteralRule();
            _fsp--;

             after(grammarAccess.getNullLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralRule2468); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1190:1: ruleNullLiteralRule : ( ( rule__NullLiteralRule__ValueAssignment ) ) ;
    public final void ruleNullLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1194:2: ( ( ( rule__NullLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1195:1: ( ( rule__NullLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1195:1: ( ( rule__NullLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1196:1: ( rule__NullLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getNullLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1197:1: ( rule__NullLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1197:2: rule__NullLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__NullLiteralRule__ValueAssignment_in_ruleNullLiteralRule2494);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1209:1: entryRuleDefaultLiteralRule : ruleDefaultLiteralRule EOF ;
    public final void entryRuleDefaultLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1210:1: ( ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1211:1: ruleDefaultLiteralRule EOF
            {
             before(grammarAccess.getDefaultLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule2521);
            ruleDefaultLiteralRule();
            _fsp--;

             after(grammarAccess.getDefaultLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultLiteralRule2528); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1218:1: ruleDefaultLiteralRule : ( ( rule__DefaultLiteralRule__ValueAssignment ) ) ;
    public final void ruleDefaultLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1222:2: ( ( ( rule__DefaultLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1223:1: ( ( rule__DefaultLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1223:1: ( ( rule__DefaultLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1224:1: ( rule__DefaultLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getDefaultLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1225:1: ( rule__DefaultLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1225:2: rule__DefaultLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__DefaultLiteralRule__ValueAssignment_in_ruleDefaultLiteralRule2554);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1237:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1238:1: ( ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1239:1: ruleStringLiteralRule EOF
            {
             before(grammarAccess.getStringLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule2581);
            ruleStringLiteralRule();
            _fsp--;

             after(grammarAccess.getStringLiteralRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralRule2588); 

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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1246:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1250:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1251:1: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1251:1: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1252:1: ( rule__StringLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1253:1: ( rule__StringLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1253:2: rule__StringLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__StringLiteralRule__ValueAssignment_in_ruleStringLiteralRule2614);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1265:1: rule__AndOrXorExpression__OpAlternatives_1_0_0 : ( ( 'and' ) | ( 'or' ) | ( 'xor' ) );
    public final void rule__AndOrXorExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1269:1: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) )
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
                    new NoViableAltException("1265:1: rule__AndOrXorExpression__OpAlternatives_1_0_0 : ( ( 'and' ) | ( 'or' ) | ( 'xor' ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1270:1: ( 'and' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1270:1: ( 'and' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1271:1: 'and'
                    {
                     before(grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__AndOrXorExpression__OpAlternatives_1_0_02651); 
                     after(grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1278:6: ( 'or' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1278:6: ( 'or' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1279:1: 'or'
                    {
                     before(grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__AndOrXorExpression__OpAlternatives_1_0_02671); 
                     after(grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1286:6: ( 'xor' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1286:6: ( 'xor' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1287:1: 'xor'
                    {
                     before(grammarAccess.getAndOrXorExpressionAccess().getOpXorKeyword_1_0_0_2()); 
                    match(input,18,FOLLOW_18_in_rule__AndOrXorExpression__OpAlternatives_1_0_02691); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1299:1: rule__EqualityExpression__OpAlternatives_1_0_0 : ( ( '==' ) | ( '<>' ) );
    public final void rule__EqualityExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1303:1: ( ( '==' ) | ( '<>' ) )
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
                    new NoViableAltException("1299:1: rule__EqualityExpression__OpAlternatives_1_0_0 : ( ( '==' ) | ( '<>' ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1304:1: ( '==' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1304:1: ( '==' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1305:1: '=='
                    {
                     before(grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0()); 
                    match(input,19,FOLLOW_19_in_rule__EqualityExpression__OpAlternatives_1_0_02726); 
                     after(grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1312:6: ( '<>' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1312:6: ( '<>' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1313:1: '<>'
                    {
                     before(grammarAccess.getEqualityExpressionAccess().getOpLessThanSignGreaterThanSignKeyword_1_0_0_1()); 
                    match(input,20,FOLLOW_20_in_rule__EqualityExpression__OpAlternatives_1_0_02746); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1325:1: rule__RelationalExpression__OpAlternatives_1_0_0 : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) );
    public final void rule__RelationalExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1329:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) )
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
                    new NoViableAltException("1325:1: rule__RelationalExpression__OpAlternatives_1_0_0 : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1330:1: ( '<' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1330:1: ( '<' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1331:1: '<'
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0()); 
                    match(input,21,FOLLOW_21_in_rule__RelationalExpression__OpAlternatives_1_0_02781); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1338:6: ( '>' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1338:6: ( '>' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1339:1: '>'
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1()); 
                    match(input,22,FOLLOW_22_in_rule__RelationalExpression__OpAlternatives_1_0_02801); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1346:6: ( '<=' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1346:6: ( '<=' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1347:1: '<='
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2()); 
                    match(input,23,FOLLOW_23_in_rule__RelationalExpression__OpAlternatives_1_0_02821); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1354:6: ( '>=' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1354:6: ( '>=' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1355:1: '>='
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_0_3()); 
                    match(input,24,FOLLOW_24_in_rule__RelationalExpression__OpAlternatives_1_0_02841); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1367:1: rule__AdditiveExpression__OpAlternatives_1_0_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__AdditiveExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1371:1: ( ( '+' ) | ( '-' ) )
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
                    new NoViableAltException("1367:1: rule__AdditiveExpression__OpAlternatives_1_0_0 : ( ( '+' ) | ( '-' ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1372:1: ( '+' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1372:1: ( '+' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1373:1: '+'
                    {
                     before(grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0()); 
                    match(input,25,FOLLOW_25_in_rule__AdditiveExpression__OpAlternatives_1_0_02876); 
                     after(grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1380:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1380:6: ( '-' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1381:1: '-'
                    {
                     before(grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_0_0_1()); 
                    match(input,26,FOLLOW_26_in_rule__AdditiveExpression__OpAlternatives_1_0_02896); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1393:1: rule__MultiplicativeExpression__OpAlternatives_1_0_0 : ( ( '*' ) | ( '/' ) | ( 'mod' ) );
    public final void rule__MultiplicativeExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1397:1: ( ( '*' ) | ( '/' ) | ( 'mod' ) )
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
                    new NoViableAltException("1393:1: rule__MultiplicativeExpression__OpAlternatives_1_0_0 : ( ( '*' ) | ( '/' ) | ( 'mod' ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1398:1: ( '*' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1398:1: ( '*' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1399:1: '*'
                    {
                     before(grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0()); 
                    match(input,27,FOLLOW_27_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02931); 
                     after(grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1406:6: ( '/' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1406:6: ( '/' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1407:1: '/'
                    {
                     before(grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1()); 
                    match(input,28,FOLLOW_28_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02951); 
                     after(grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1414:6: ( 'mod' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1414:6: ( 'mod' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1415:1: 'mod'
                    {
                     before(grammarAccess.getMultiplicativeExpressionAccess().getOpModKeyword_1_0_0_2()); 
                    match(input,29,FOLLOW_29_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02971); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1427:1: rule__UnaryExpression__Alternatives : ( ( ( rule__UnaryExpression__Group_0__0 ) ) | ( ( rule__UnaryExpression__ExpAssignment_1 ) ) );
    public final void rule__UnaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1431:1: ( ( ( rule__UnaryExpression__Group_0__0 ) ) | ( ( rule__UnaryExpression__ExpAssignment_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=25 && LA6_0<=26)||LA6_0==30) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_NULLLITERAL)||(LA6_0>=27 && LA6_0<=28)||(LA6_0>=31 && LA6_0<=35)||LA6_0==41||LA6_0==45||LA6_0==49||(LA6_0>=51 && LA6_0<=53)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1427:1: rule__UnaryExpression__Alternatives : ( ( ( rule__UnaryExpression__Group_0__0 ) ) | ( ( rule__UnaryExpression__ExpAssignment_1 ) ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1432:1: ( ( rule__UnaryExpression__Group_0__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1432:1: ( ( rule__UnaryExpression__Group_0__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1433:1: ( rule__UnaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getGroup_0()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1434:1: ( rule__UnaryExpression__Group_0__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1434:2: rule__UnaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__UnaryExpression__Group_0__0_in_rule__UnaryExpression__Alternatives3005);
                    rule__UnaryExpression__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getUnaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1438:6: ( ( rule__UnaryExpression__ExpAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1438:6: ( ( rule__UnaryExpression__ExpAssignment_1 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1439:1: ( rule__UnaryExpression__ExpAssignment_1 )
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getExpAssignment_1()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1440:1: ( rule__UnaryExpression__ExpAssignment_1 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1440:2: rule__UnaryExpression__ExpAssignment_1
                    {
                    pushFollow(FOLLOW_rule__UnaryExpression__ExpAssignment_1_in_rule__UnaryExpression__Alternatives3023);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1449:1: rule__UnaryExpression__OpAlternatives_0_0_0 : ( ( 'not' ) | ( '-' ) | ( '+' ) );
    public final void rule__UnaryExpression__OpAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1453:1: ( ( 'not' ) | ( '-' ) | ( '+' ) )
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
                    new NoViableAltException("1449:1: rule__UnaryExpression__OpAlternatives_0_0_0 : ( ( 'not' ) | ( '-' ) | ( '+' ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1454:1: ( 'not' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1454:1: ( 'not' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1455:1: 'not'
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0()); 
                    match(input,30,FOLLOW_30_in_rule__UnaryExpression__OpAlternatives_0_0_03057); 
                     after(grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1462:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1462:6: ( '-' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1463:1: '-'
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1()); 
                    match(input,26,FOLLOW_26_in_rule__UnaryExpression__OpAlternatives_0_0_03077); 
                     after(grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1470:6: ( '+' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1470:6: ( '+' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1471:1: '+'
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getOpPlusSignKeyword_0_0_0_2()); 
                    match(input,25,FOLLOW_25_in_rule__UnaryExpression__OpAlternatives_0_0_03097); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1483:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );
    public final void rule__ValueSpecification__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1487:1: ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) )
            int alt8=8;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INTEGERLITERAL:
            case RULE_REALLITERAL:
            case RULE_DATETIMELITERAL:
            case RULE_BOOLEANLITERAL:
            case RULE_NULLLITERAL:
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
            case 45:
                {
                int LA8_4 = input.LA(2);

                if ( (LA8_4==RULE_STRING||(LA8_4>=RULE_INTEGERLITERAL && LA8_4<=RULE_NULLLITERAL)||(LA8_4>=25 && LA8_4<=28)||(LA8_4>=30 && LA8_4<=35)||LA8_4==41||LA8_4==45||LA8_4==49||(LA8_4>=51 && LA8_4<=53)) ) {
                    alt8=4;
                }
                else if ( (LA8_4==RULE_ID) ) {
                    int LA8_9 = input.LA(3);

                    if ( ((LA8_9>=16 && LA8_9<=29)||(LA8_9>=40 && LA8_9<=41)||LA8_9==43||(LA8_9>=46 && LA8_9<=47)||LA8_9==54) ) {
                        alt8=4;
                    }
                    else if ( (LA8_9==48) ) {
                        alt8=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1483:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );", 8, 9, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1483:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );", 8, 4, input);

                    throw nvae;
                }
                }
                break;
            case 49:
            case 51:
            case 52:
                {
                alt8=6;
                }
                break;
            case 33:
            case 34:
            case 35:
            case 53:
                {
                alt8=7;
                }
                break;
            case 41:
                {
                alt8=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1483:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1488:1: ( ruleLiteral )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1488:1: ( ruleLiteral )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1489:1: ruleLiteral
                    {
                     before(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLiteral_in_rule__ValueSpecification__Alternatives3131);
                    ruleLiteral();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1494:6: ( ruleNameOrChoiceOrBehaviorCall )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1494:6: ( ruleNameOrChoiceOrBehaviorCall )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1495:1: ruleNameOrChoiceOrBehaviorCall
                    {
                     before(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_rule__ValueSpecification__Alternatives3148);
                    ruleNameOrChoiceOrBehaviorCall();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1500:6: ( ruleInterval )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1500:6: ( ruleInterval )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1501:1: ruleInterval
                    {
                     before(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleInterval_in_rule__ValueSpecification__Alternatives3165);
                    ruleInterval();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1506:6: ( ruleCollectionOrTuple )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1506:6: ( ruleCollectionOrTuple )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1507:1: ruleCollectionOrTuple
                    {
                     before(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_rule__ValueSpecification__Alternatives3182);
                    ruleCollectionOrTuple();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1512:6: ( ruleTuple )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1512:6: ( ruleTuple )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1513:1: ruleTuple
                    {
                     before(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleTuple_in_rule__ValueSpecification__Alternatives3199);
                    ruleTuple();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1518:6: ( ruleTimeExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1518:6: ( ruleTimeExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1519:1: ruleTimeExpression
                    {
                     before(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleTimeExpression_in_rule__ValueSpecification__Alternatives3216);
                    ruleTimeExpression();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1524:6: ( ruleVariableDeclaration )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1524:6: ( ruleVariableDeclaration )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1525:1: ruleVariableDeclaration
                    {
                     before(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_rule__ValueSpecification__Alternatives3233);
                    ruleVariableDeclaration();
                    _fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1530:6: ( ( rule__ValueSpecification__Group_7__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1530:6: ( ( rule__ValueSpecification__Group_7__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1531:1: ( rule__ValueSpecification__Group_7__0 )
                    {
                     before(grammarAccess.getValueSpecificationAccess().getGroup_7()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1532:1: ( rule__ValueSpecification__Group_7__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1532:2: rule__ValueSpecification__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ValueSpecification__Group_7__0_in_rule__ValueSpecification__Alternatives3250);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1541:1: rule__SuffixExpression__Alternatives : ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) );
    public final void rule__SuffixExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1545:1: ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==EOF||(LA9_1>=16 && LA9_1<=29)||(LA9_1>=31 && LA9_1<=32)||(LA9_1>=39 && LA9_1<=40)||LA9_1==42||LA9_1==44||(LA9_1>=46 && LA9_1<=47)||LA9_1==54) ) {
                    alt9=1;
                }
                else if ( (LA9_1==41) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1541:1: rule__SuffixExpression__Alternatives : ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) );", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1541:1: rule__SuffixExpression__Alternatives : ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1546:1: ( rulePropertyCallExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1546:1: ( rulePropertyCallExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1547:1: rulePropertyCallExpression
                    {
                     before(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_rule__SuffixExpression__Alternatives3283);
                    rulePropertyCallExpression();
                    _fsp--;

                     after(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1552:6: ( ruleOperationCallExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1552:6: ( ruleOperationCallExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1553:1: ruleOperationCallExpression
                    {
                     before(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_rule__SuffixExpression__Alternatives3300);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1563:1: rule__Literal__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleDateTimeLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleNullLiteralRule ) | ( ruleDefaultLiteralRule ) | ( ruleStringLiteralRule ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1567:1: ( ( ruleNumberLiteralRule ) | ( ruleDateTimeLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleNullLiteralRule ) | ( ruleDefaultLiteralRule ) | ( ruleStringLiteralRule ) )
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
                    new NoViableAltException("1563:1: rule__Literal__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleDateTimeLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleNullLiteralRule ) | ( ruleDefaultLiteralRule ) | ( ruleStringLiteralRule ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1568:1: ( ruleNumberLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1568:1: ( ruleNumberLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1569:1: ruleNumberLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_rule__Literal__Alternatives3332);
                    ruleNumberLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1574:6: ( ruleDateTimeLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1574:6: ( ruleDateTimeLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1575:1: ruleDateTimeLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_rule__Literal__Alternatives3349);
                    ruleDateTimeLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1580:6: ( ruleBooleanLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1580:6: ( ruleBooleanLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1581:1: ruleBooleanLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_rule__Literal__Alternatives3366);
                    ruleBooleanLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1586:6: ( ruleNullLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1586:6: ( ruleNullLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1587:1: ruleNullLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_rule__Literal__Alternatives3383);
                    ruleNullLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1592:6: ( ruleDefaultLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1592:6: ( ruleDefaultLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1593:1: ruleDefaultLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_rule__Literal__Alternatives3400);
                    ruleDefaultLiteralRule();
                    _fsp--;

                     after(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1598:6: ( ruleStringLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1598:6: ( ruleStringLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1599:1: ruleStringLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_rule__Literal__Alternatives3417);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1609:1: rule__Interval__Alternatives_0 : ( ( ']' ) | ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) ) );
    public final void rule__Interval__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1613:1: ( ( ']' ) | ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) ) )
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
                    new NoViableAltException("1609:1: rule__Interval__Alternatives_0 : ( ( ']' ) | ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) ) );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1614:1: ( ']' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1614:1: ( ']' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1615:1: ']'
                    {
                     before(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0()); 
                    match(input,31,FOLLOW_31_in_rule__Interval__Alternatives_03450); 
                     after(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1622:6: ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1622:6: ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1623:1: ( rule__Interval__IsLowerIncludedAssignment_0_1 )
                    {
                     before(grammarAccess.getIntervalAccess().getIsLowerIncludedAssignment_0_1()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1624:1: ( rule__Interval__IsLowerIncludedAssignment_0_1 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1624:2: rule__Interval__IsLowerIncludedAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__Interval__IsLowerIncludedAssignment_0_1_in_rule__Interval__Alternatives_03469);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1633:1: rule__Interval__Alternatives_4 : ( ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) ) | ( '[' ) );
    public final void rule__Interval__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1637:1: ( ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) ) | ( '[' ) )
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
                    new NoViableAltException("1633:1: rule__Interval__Alternatives_4 : ( ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) ) | ( '[' ) );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1638:1: ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1638:1: ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1639:1: ( rule__Interval__IsUpperIncludedAssignment_4_0 )
                    {
                     before(grammarAccess.getIntervalAccess().getIsUpperIncludedAssignment_4_0()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1640:1: ( rule__Interval__IsUpperIncludedAssignment_4_0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1640:2: rule__Interval__IsUpperIncludedAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__Interval__IsUpperIncludedAssignment_4_0_in_rule__Interval__Alternatives_43502);
                    rule__Interval__IsUpperIncludedAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getIntervalAccess().getIsUpperIncludedAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1644:6: ( '[' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1644:6: ( '[' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1645:1: '['
                    {
                     before(grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_4_1()); 
                    match(input,32,FOLLOW_32_in_rule__Interval__Alternatives_43521); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1657:1: rule__TimeExpression__Alternatives : ( ( ruleInstantObsExpression ) | ( ruleDurationObsExpression ) | ( ruleJitterExp ) );
    public final void rule__TimeExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1661:1: ( ( ruleInstantObsExpression ) | ( ruleDurationObsExpression ) | ( ruleJitterExp ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt13=1;
                }
                break;
            case 51:
                {
                alt13=2;
                }
                break;
            case 52:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1657:1: rule__TimeExpression__Alternatives : ( ( ruleInstantObsExpression ) | ( ruleDurationObsExpression ) | ( ruleJitterExp ) );", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1662:1: ( ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1662:1: ( ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1663:1: ruleInstantObsExpression
                    {
                     before(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_rule__TimeExpression__Alternatives3555);
                    ruleInstantObsExpression();
                    _fsp--;

                     after(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1668:6: ( ruleDurationObsExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1668:6: ( ruleDurationObsExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1669:1: ruleDurationObsExpression
                    {
                     before(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_rule__TimeExpression__Alternatives3572);
                    ruleDurationObsExpression();
                    _fsp--;

                     after(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1674:6: ( ruleJitterExp )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1674:6: ( ruleJitterExp )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1675:1: ruleJitterExp
                    {
                     before(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleJitterExp_in_rule__TimeExpression__Alternatives3589);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1685:1: rule__VariableDeclaration__Alternatives_3 : ( ( ( rule__VariableDeclaration__Group_3_0__0 ) ) | ( ( rule__VariableDeclaration__Group_3_1__0 ) ) );
    public final void rule__VariableDeclaration__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1689:1: ( ( ( rule__VariableDeclaration__Group_3_0__0 ) ) | ( ( rule__VariableDeclaration__Group_3_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==39) ) {
                alt14=1;
            }
            else if ( (LA14_0==48) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1685:1: rule__VariableDeclaration__Alternatives_3 : ( ( ( rule__VariableDeclaration__Group_3_0__0 ) ) | ( ( rule__VariableDeclaration__Group_3_1__0 ) ) );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1690:1: ( ( rule__VariableDeclaration__Group_3_0__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1690:1: ( ( rule__VariableDeclaration__Group_3_0__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1691:1: ( rule__VariableDeclaration__Group_3_0__0 )
                    {
                     before(grammarAccess.getVariableDeclarationAccess().getGroup_3_0()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1692:1: ( rule__VariableDeclaration__Group_3_0__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1692:2: rule__VariableDeclaration__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__0_in_rule__VariableDeclaration__Alternatives_33621);
                    rule__VariableDeclaration__Group_3_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getVariableDeclarationAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1696:6: ( ( rule__VariableDeclaration__Group_3_1__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1696:6: ( ( rule__VariableDeclaration__Group_3_1__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1697:1: ( rule__VariableDeclaration__Group_3_1__0 )
                    {
                     before(grammarAccess.getVariableDeclarationAccess().getGroup_3_1()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1698:1: ( rule__VariableDeclaration__Group_3_1__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1698:2: rule__VariableDeclaration__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__0_in_rule__VariableDeclaration__Alternatives_33639);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1707:1: rule__VariableDirectionKind__Alternatives : ( ( 'in' ) | ( 'out' ) | ( 'inout' ) );
    public final void rule__VariableDirectionKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1711:1: ( ( 'in' ) | ( 'out' ) | ( 'inout' ) )
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
                    new NoViableAltException("1707:1: rule__VariableDirectionKind__Alternatives : ( ( 'in' ) | ( 'out' ) | ( 'inout' ) );", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1712:1: ( 'in' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1712:1: ( 'in' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1713:1: 'in'
                    {
                     before(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0()); 
                    match(input,33,FOLLOW_33_in_rule__VariableDirectionKind__Alternatives3673); 
                     after(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1720:6: ( 'out' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1720:6: ( 'out' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1721:1: 'out'
                    {
                     before(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1()); 
                    match(input,34,FOLLOW_34_in_rule__VariableDirectionKind__Alternatives3693); 
                     after(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1728:6: ( 'inout' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1728:6: ( 'inout' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1729:1: 'inout'
                    {
                     before(grammarAccess.getVariableDirectionKindAccess().getInoutKeyword_2()); 
                    match(input,35,FOLLOW_35_in_rule__VariableDirectionKind__Alternatives3713); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1741:1: rule__NumberLiteralRule__Alternatives : ( ( ruleIntegerLiteralRule ) | ( ruleUnlimitedLiteralRule ) | ( ruleRealLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1745:1: ( ( ruleIntegerLiteralRule ) | ( ruleUnlimitedLiteralRule ) | ( ruleRealLiteralRule ) )
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
                    new NoViableAltException("1741:1: rule__NumberLiteralRule__Alternatives : ( ( ruleIntegerLiteralRule ) | ( ruleUnlimitedLiteralRule ) | ( ruleRealLiteralRule ) );", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1746:1: ( ruleIntegerLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1746:1: ( ruleIntegerLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1747:1: ruleIntegerLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_rule__NumberLiteralRule__Alternatives3747);
                    ruleIntegerLiteralRule();
                    _fsp--;

                     after(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1752:6: ( ruleUnlimitedLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1752:6: ( ruleUnlimitedLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1753:1: ruleUnlimitedLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_rule__NumberLiteralRule__Alternatives3764);
                    ruleUnlimitedLiteralRule();
                    _fsp--;

                     after(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1758:6: ( ruleRealLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1758:6: ( ruleRealLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1759:1: ruleRealLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_rule__NumberLiteralRule__Alternatives3781);
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


    // $ANTLR start rule__Model__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1771:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1775:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1776:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__03811);
            rule__Model__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__03814);
            rule__Model__Group__1();
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
    // $ANTLR end rule__Model__Group__0


    // $ANTLR start rule__Model__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1783:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1787:1: ( ( ( rule__Model__ImportsAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1788:1: ( ( rule__Model__ImportsAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1788:1: ( ( rule__Model__ImportsAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1789:1: ( rule__Model__ImportsAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1790:1: ( rule__Model__ImportsAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1790:2: rule__Model__ImportsAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl3841);
            rule__Model__ImportsAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__0__Impl


    // $ANTLR start rule__Model__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1800:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1804:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1805:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__13871);
            rule__Model__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__13874);
            rule__Model__Group__2();
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
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Model__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1812:1: rule__Model__Group__1__Impl : ( ( rule__Model__ContextAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1816:1: ( ( ( rule__Model__ContextAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1817:1: ( ( rule__Model__ContextAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1817:1: ( ( rule__Model__ContextAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1818:1: ( rule__Model__ContextAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getContextAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1819:1: ( rule__Model__ContextAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1819:2: rule__Model__ContextAssignment_1
            {
            pushFollow(FOLLOW_rule__Model__ContextAssignment_1_in_rule__Model__Group__1__Impl3901);
            rule__Model__ContextAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getContextAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__1__Impl


    // $ANTLR start rule__Model__Group__2
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1829:1: rule__Model__Group__2 : rule__Model__Group__2__Impl ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1833:1: ( rule__Model__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1834:2: rule__Model__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__23931);
            rule__Model__Group__2__Impl();
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
    // $ANTLR end rule__Model__Group__2


    // $ANTLR start rule__Model__Group__2__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1840:1: rule__Model__Group__2__Impl : ( ( rule__Model__Group_2__0 ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1844:1: ( ( ( rule__Model__Group_2__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1845:1: ( ( rule__Model__Group_2__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1845:1: ( ( rule__Model__Group_2__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1846:1: ( rule__Model__Group_2__0 )
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1847:1: ( rule__Model__Group_2__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1847:2: rule__Model__Group_2__0
            {
            pushFollow(FOLLOW_rule__Model__Group_2__0_in_rule__Model__Group__2__Impl3958);
            rule__Model__Group_2__0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__2__Impl


    // $ANTLR start rule__Model__Group_2__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1863:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1867:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1868:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
            {
            pushFollow(FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__03994);
            rule__Model__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__03997);
            rule__Model__Group_2__1();
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
    // $ANTLR end rule__Model__Group_2__0


    // $ANTLR start rule__Model__Group_2__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1875:1: rule__Model__Group_2__0__Impl : ( 'value' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1879:1: ( ( 'value' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1880:1: ( 'value' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1880:1: ( 'value' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1881:1: 'value'
            {
             before(grammarAccess.getModelAccess().getValueKeyword_2_0()); 
            match(input,36,FOLLOW_36_in_rule__Model__Group_2__0__Impl4025); 
             after(grammarAccess.getModelAccess().getValueKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_2__0__Impl


    // $ANTLR start rule__Model__Group_2__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1894:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1898:1: ( rule__Model__Group_2__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1899:2: rule__Model__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__14056);
            rule__Model__Group_2__1__Impl();
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
    // $ANTLR end rule__Model__Group_2__1


    // $ANTLR start rule__Model__Group_2__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1905:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__ValueAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1909:1: ( ( ( rule__Model__ValueAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1910:1: ( ( rule__Model__ValueAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1910:1: ( ( rule__Model__ValueAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1911:1: ( rule__Model__ValueAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getValueAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1912:1: ( rule__Model__ValueAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1912:2: rule__Model__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Model__ValueAssignment_2_1_in_rule__Model__Group_2__1__Impl4083);
            rule__Model__ValueAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group_2__1__Impl


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1926:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1930:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1931:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__04117);
            rule__Import__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__04120);
            rule__Import__Group__1();
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
    // $ANTLR end rule__Import__Group__0


    // $ANTLR start rule__Import__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1938:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1942:1: ( ( 'import' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1943:1: ( 'import' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1943:1: ( 'import' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1944:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__Import__Group__0__Impl4148); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__0__Impl


    // $ANTLR start rule__Import__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1957:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1961:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1962:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__14179);
            rule__Import__Group__1__Impl();
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
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__Import__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1968:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1972:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1973:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1973:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1974:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1975:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1975:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl4206);
            rule__Import__ImportURIAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__1__Impl


    // $ANTLR start rule__Context__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1989:1: rule__Context__Group__0 : rule__Context__Group__0__Impl rule__Context__Group__1 ;
    public final void rule__Context__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1993:1: ( rule__Context__Group__0__Impl rule__Context__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1994:2: rule__Context__Group__0__Impl rule__Context__Group__1
            {
            pushFollow(FOLLOW_rule__Context__Group__0__Impl_in_rule__Context__Group__04240);
            rule__Context__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Context__Group__1_in_rule__Context__Group__04243);
            rule__Context__Group__1();
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
    // $ANTLR end rule__Context__Group__0


    // $ANTLR start rule__Context__Group__0__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2001:1: rule__Context__Group__0__Impl : ( 'context' ) ;
    public final void rule__Context__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2005:1: ( ( 'context' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2006:1: ( 'context' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2006:1: ( 'context' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2007:1: 'context'
            {
             before(grammarAccess.getContextAccess().getContextKeyword_0()); 
            match(input,38,FOLLOW_38_in_rule__Context__Group__0__Impl4271); 
             after(grammarAccess.getContextAccess().getContextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Context__Group__0__Impl


    // $ANTLR start rule__Context__Group__1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2020:1: rule__Context__Group__1 : rule__Context__Group__1__Impl ;
    public final void rule__Context__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2024:1: ( rule__Context__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2025:2: rule__Context__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Context__Group__1__Impl_in_rule__Context__Group__14302);
            rule__Context__Group__1__Impl();
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
    // $ANTLR end rule__Context__Group__1


    // $ANTLR start rule__Context__Group__1__Impl
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2031:1: rule__Context__Group__1__Impl : ( ( rule__Context__ContextAssignment_1 ) ) ;
    public final void rule__Context__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2035:1: ( ( ( rule__Context__ContextAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2036:1: ( ( rule__Context__ContextAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2036:1: ( ( rule__Context__ContextAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2037:1: ( rule__Context__ContextAssignment_1 )
            {
             before(grammarAccess.getContextAccess().getContextAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2038:1: ( rule__Context__ContextAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2038:2: rule__Context__ContextAssignment_1
            {
            pushFollow(FOLLOW_rule__Context__ContextAssignment_1_in_rule__Context__Group__1__Impl4329);
            rule__Context__ContextAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getContextAccess().getContextAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Context__Group__1__Impl


    // $ANTLR start rule__AndOrXorExpression__Group__0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2052:1: rule__AndOrXorExpression__Group__0 : rule__AndOrXorExpression__Group__0__Impl rule__AndOrXorExpression__Group__1 ;
    public final void rule__AndOrXorExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2056:1: ( rule__AndOrXorExpression__Group__0__Impl rule__AndOrXorExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2057:2: rule__AndOrXorExpression__Group__0__Impl rule__AndOrXorExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__0__Impl_in_rule__AndOrXorExpression__Group__04363);
            rule__AndOrXorExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__1_in_rule__AndOrXorExpression__Group__04366);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2064:1: rule__AndOrXorExpression__Group__0__Impl : ( ( rule__AndOrXorExpression__ExpAssignment_0 ) ) ;
    public final void rule__AndOrXorExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2068:1: ( ( ( rule__AndOrXorExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2069:1: ( ( rule__AndOrXorExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2069:1: ( ( rule__AndOrXorExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2070:1: ( rule__AndOrXorExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2071:1: ( rule__AndOrXorExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2071:2: rule__AndOrXorExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__ExpAssignment_0_in_rule__AndOrXorExpression__Group__0__Impl4393);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2081:1: rule__AndOrXorExpression__Group__1 : rule__AndOrXorExpression__Group__1__Impl ;
    public final void rule__AndOrXorExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2085:1: ( rule__AndOrXorExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2086:2: rule__AndOrXorExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__1__Impl_in_rule__AndOrXorExpression__Group__14423);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2092:1: rule__AndOrXorExpression__Group__1__Impl : ( ( rule__AndOrXorExpression__Group_1__0 )* ) ;
    public final void rule__AndOrXorExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2096:1: ( ( ( rule__AndOrXorExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2097:1: ( ( rule__AndOrXorExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2097:1: ( ( rule__AndOrXorExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2098:1: ( rule__AndOrXorExpression__Group_1__0 )*
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2099:1: ( rule__AndOrXorExpression__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=16 && LA17_0<=18)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2099:2: rule__AndOrXorExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__0_in_rule__AndOrXorExpression__Group__1__Impl4450);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2113:1: rule__AndOrXorExpression__Group_1__0 : rule__AndOrXorExpression__Group_1__0__Impl rule__AndOrXorExpression__Group_1__1 ;
    public final void rule__AndOrXorExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2117:1: ( rule__AndOrXorExpression__Group_1__0__Impl rule__AndOrXorExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2118:2: rule__AndOrXorExpression__Group_1__0__Impl rule__AndOrXorExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__0__Impl_in_rule__AndOrXorExpression__Group_1__04485);
            rule__AndOrXorExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__1_in_rule__AndOrXorExpression__Group_1__04488);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2125:1: rule__AndOrXorExpression__Group_1__0__Impl : ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) ) ;
    public final void rule__AndOrXorExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2129:1: ( ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2130:1: ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2130:1: ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2131:1: ( rule__AndOrXorExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2132:1: ( rule__AndOrXorExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2132:2: rule__AndOrXorExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__OpAssignment_1_0_in_rule__AndOrXorExpression__Group_1__0__Impl4515);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2142:1: rule__AndOrXorExpression__Group_1__1 : rule__AndOrXorExpression__Group_1__1__Impl ;
    public final void rule__AndOrXorExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2146:1: ( rule__AndOrXorExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2147:2: rule__AndOrXorExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__1__Impl_in_rule__AndOrXorExpression__Group_1__14545);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2153:1: rule__AndOrXorExpression__Group_1__1__Impl : ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__AndOrXorExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2157:1: ( ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2158:1: ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2158:1: ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2159:1: ( rule__AndOrXorExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2160:1: ( rule__AndOrXorExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2160:2: rule__AndOrXorExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__ExpAssignment_1_1_in_rule__AndOrXorExpression__Group_1__1__Impl4572);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2174:1: rule__EqualityExpression__Group__0 : rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 ;
    public final void rule__EqualityExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2178:1: ( rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2179:2: rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__0__Impl_in_rule__EqualityExpression__Group__04606);
            rule__EqualityExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EqualityExpression__Group__1_in_rule__EqualityExpression__Group__04609);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2186:1: rule__EqualityExpression__Group__0__Impl : ( ( rule__EqualityExpression__ExpAssignment_0 ) ) ;
    public final void rule__EqualityExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2190:1: ( ( ( rule__EqualityExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2191:1: ( ( rule__EqualityExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2191:1: ( ( rule__EqualityExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2192:1: ( rule__EqualityExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2193:1: ( rule__EqualityExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2193:2: rule__EqualityExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__ExpAssignment_0_in_rule__EqualityExpression__Group__0__Impl4636);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2203:1: rule__EqualityExpression__Group__1 : rule__EqualityExpression__Group__1__Impl ;
    public final void rule__EqualityExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2207:1: ( rule__EqualityExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2208:2: rule__EqualityExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__1__Impl_in_rule__EqualityExpression__Group__14666);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2214:1: rule__EqualityExpression__Group__1__Impl : ( ( rule__EqualityExpression__Group_1__0 )* ) ;
    public final void rule__EqualityExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2218:1: ( ( ( rule__EqualityExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2219:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2219:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2220:1: ( rule__EqualityExpression__Group_1__0 )*
            {
             before(grammarAccess.getEqualityExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2221:1: ( rule__EqualityExpression__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=19 && LA18_0<=20)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2221:2: rule__EqualityExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__EqualityExpression__Group_1__0_in_rule__EqualityExpression__Group__1__Impl4693);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2235:1: rule__EqualityExpression__Group_1__0 : rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 ;
    public final void rule__EqualityExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2239:1: ( rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2240:2: rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group_1__0__Impl_in_rule__EqualityExpression__Group_1__04728);
            rule__EqualityExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__EqualityExpression__Group_1__1_in_rule__EqualityExpression__Group_1__04731);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2247:1: rule__EqualityExpression__Group_1__0__Impl : ( ( rule__EqualityExpression__OpAssignment_1_0 ) ) ;
    public final void rule__EqualityExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2251:1: ( ( ( rule__EqualityExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2252:1: ( ( rule__EqualityExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2252:1: ( ( rule__EqualityExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2253:1: ( rule__EqualityExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2254:1: ( rule__EqualityExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2254:2: rule__EqualityExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__OpAssignment_1_0_in_rule__EqualityExpression__Group_1__0__Impl4758);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2264:1: rule__EqualityExpression__Group_1__1 : rule__EqualityExpression__Group_1__1__Impl ;
    public final void rule__EqualityExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2268:1: ( rule__EqualityExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2269:2: rule__EqualityExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group_1__1__Impl_in_rule__EqualityExpression__Group_1__14788);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2275:1: rule__EqualityExpression__Group_1__1__Impl : ( ( rule__EqualityExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__EqualityExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2279:1: ( ( ( rule__EqualityExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2280:1: ( ( rule__EqualityExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2280:1: ( ( rule__EqualityExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2281:1: ( rule__EqualityExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2282:1: ( rule__EqualityExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2282:2: rule__EqualityExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__ExpAssignment_1_1_in_rule__EqualityExpression__Group_1__1__Impl4815);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2296:1: rule__RelationalExpression__Group__0 : rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 ;
    public final void rule__RelationalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2300:1: ( rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2301:2: rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__0__Impl_in_rule__RelationalExpression__Group__04849);
            rule__RelationalExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__RelationalExpression__Group__1_in_rule__RelationalExpression__Group__04852);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2308:1: rule__RelationalExpression__Group__0__Impl : ( ( rule__RelationalExpression__ExpAssignment_0 ) ) ;
    public final void rule__RelationalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2312:1: ( ( ( rule__RelationalExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2313:1: ( ( rule__RelationalExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2313:1: ( ( rule__RelationalExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2314:1: ( rule__RelationalExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2315:1: ( rule__RelationalExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2315:2: rule__RelationalExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__ExpAssignment_0_in_rule__RelationalExpression__Group__0__Impl4879);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2325:1: rule__RelationalExpression__Group__1 : rule__RelationalExpression__Group__1__Impl ;
    public final void rule__RelationalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2329:1: ( rule__RelationalExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2330:2: rule__RelationalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__1__Impl_in_rule__RelationalExpression__Group__14909);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2336:1: rule__RelationalExpression__Group__1__Impl : ( ( rule__RelationalExpression__Group_1__0 )* ) ;
    public final void rule__RelationalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2340:1: ( ( ( rule__RelationalExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2341:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2341:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2342:1: ( rule__RelationalExpression__Group_1__0 )*
            {
             before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2343:1: ( rule__RelationalExpression__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=21 && LA19_0<=24)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2343:2: rule__RelationalExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__RelationalExpression__Group_1__0_in_rule__RelationalExpression__Group__1__Impl4936);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2357:1: rule__RelationalExpression__Group_1__0 : rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 ;
    public final void rule__RelationalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2361:1: ( rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2362:2: rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group_1__0__Impl_in_rule__RelationalExpression__Group_1__04971);
            rule__RelationalExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__RelationalExpression__Group_1__1_in_rule__RelationalExpression__Group_1__04974);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2369:1: rule__RelationalExpression__Group_1__0__Impl : ( ( rule__RelationalExpression__OpAssignment_1_0 ) ) ;
    public final void rule__RelationalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2373:1: ( ( ( rule__RelationalExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2374:1: ( ( rule__RelationalExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2374:1: ( ( rule__RelationalExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2375:1: ( rule__RelationalExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2376:1: ( rule__RelationalExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2376:2: rule__RelationalExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__OpAssignment_1_0_in_rule__RelationalExpression__Group_1__0__Impl5001);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2386:1: rule__RelationalExpression__Group_1__1 : rule__RelationalExpression__Group_1__1__Impl ;
    public final void rule__RelationalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2390:1: ( rule__RelationalExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2391:2: rule__RelationalExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group_1__1__Impl_in_rule__RelationalExpression__Group_1__15031);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2397:1: rule__RelationalExpression__Group_1__1__Impl : ( ( rule__RelationalExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__RelationalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2401:1: ( ( ( rule__RelationalExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2402:1: ( ( rule__RelationalExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2402:1: ( ( rule__RelationalExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2403:1: ( rule__RelationalExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2404:1: ( rule__RelationalExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2404:2: rule__RelationalExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__ExpAssignment_1_1_in_rule__RelationalExpression__Group_1__1__Impl5058);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2418:1: rule__ConditionalExpression__Group__0 : rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 ;
    public final void rule__ConditionalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2422:1: ( rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2423:2: rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__05092);
            rule__ConditionalExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1_in_rule__ConditionalExpression__Group__05095);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2430:1: rule__ConditionalExpression__Group__0__Impl : ( ( rule__ConditionalExpression__ExpAssignment_0 ) ) ;
    public final void rule__ConditionalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2434:1: ( ( ( rule__ConditionalExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2435:1: ( ( rule__ConditionalExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2435:1: ( ( rule__ConditionalExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2436:1: ( rule__ConditionalExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2437:1: ( rule__ConditionalExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2437:2: rule__ConditionalExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__ExpAssignment_0_in_rule__ConditionalExpression__Group__0__Impl5122);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2447:1: rule__ConditionalExpression__Group__1 : rule__ConditionalExpression__Group__1__Impl ;
    public final void rule__ConditionalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2451:1: ( rule__ConditionalExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2452:2: rule__ConditionalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1__Impl_in_rule__ConditionalExpression__Group__15152);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2458:1: rule__ConditionalExpression__Group__1__Impl : ( ( rule__ConditionalExpression__Group_1__0 )? ) ;
    public final void rule__ConditionalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2462:1: ( ( ( rule__ConditionalExpression__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2463:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2463:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2464:1: ( rule__ConditionalExpression__Group_1__0 )?
            {
             before(grammarAccess.getConditionalExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2465:1: ( rule__ConditionalExpression__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==54) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2465:2: rule__ConditionalExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0_in_rule__ConditionalExpression__Group__1__Impl5179);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2479:1: rule__ConditionalExpression__Group_1__0 : rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 ;
    public final void rule__ConditionalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2483:1: ( rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2484:2: rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0__Impl_in_rule__ConditionalExpression__Group_1__05214);
            rule__ConditionalExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1_in_rule__ConditionalExpression__Group_1__05217);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2491:1: rule__ConditionalExpression__Group_1__0__Impl : ( ( rule__ConditionalExpression__OpAssignment_1_0 ) ) ;
    public final void rule__ConditionalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2495:1: ( ( ( rule__ConditionalExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2496:1: ( ( rule__ConditionalExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2496:1: ( ( rule__ConditionalExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2497:1: ( rule__ConditionalExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2498:1: ( rule__ConditionalExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2498:2: rule__ConditionalExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__OpAssignment_1_0_in_rule__ConditionalExpression__Group_1__0__Impl5244);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2508:1: rule__ConditionalExpression__Group_1__1 : rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 ;
    public final void rule__ConditionalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2512:1: ( rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2513:2: rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1__Impl_in_rule__ConditionalExpression__Group_1__15274);
            rule__ConditionalExpression__Group_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2_in_rule__ConditionalExpression__Group_1__15277);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2520:1: rule__ConditionalExpression__Group_1__1__Impl : ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__ConditionalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2524:1: ( ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2525:1: ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2525:1: ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2526:1: ( rule__ConditionalExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2527:1: ( rule__ConditionalExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2527:2: rule__ConditionalExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__ExpAssignment_1_1_in_rule__ConditionalExpression__Group_1__1__Impl5304);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2537:1: rule__ConditionalExpression__Group_1__2 : rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 ;
    public final void rule__ConditionalExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2541:1: ( rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2542:2: rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2__Impl_in_rule__ConditionalExpression__Group_1__25334);
            rule__ConditionalExpression__Group_1__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3_in_rule__ConditionalExpression__Group_1__25337);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2549:1: rule__ConditionalExpression__Group_1__2__Impl : ( ':' ) ;
    public final void rule__ConditionalExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2553:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2554:1: ( ':' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2554:1: ( ':' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2555:1: ':'
            {
             before(grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_2()); 
            match(input,39,FOLLOW_39_in_rule__ConditionalExpression__Group_1__2__Impl5365); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2568:1: rule__ConditionalExpression__Group_1__3 : rule__ConditionalExpression__Group_1__3__Impl ;
    public final void rule__ConditionalExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2572:1: ( rule__ConditionalExpression__Group_1__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2573:2: rule__ConditionalExpression__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3__Impl_in_rule__ConditionalExpression__Group_1__35396);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2579:1: rule__ConditionalExpression__Group_1__3__Impl : ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) ) ;
    public final void rule__ConditionalExpression__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2583:1: ( ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2584:1: ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2584:1: ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2585:1: ( rule__ConditionalExpression__ExpAssignment_1_3 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAssignment_1_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2586:1: ( rule__ConditionalExpression__ExpAssignment_1_3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2586:2: rule__ConditionalExpression__ExpAssignment_1_3
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__ExpAssignment_1_3_in_rule__ConditionalExpression__Group_1__3__Impl5423);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2604:1: rule__AdditiveExpression__Group__0 : rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 ;
    public final void rule__AdditiveExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2608:1: ( rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2609:2: rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__0__Impl_in_rule__AdditiveExpression__Group__05461);
            rule__AdditiveExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AdditiveExpression__Group__1_in_rule__AdditiveExpression__Group__05464);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2616:1: rule__AdditiveExpression__Group__0__Impl : ( ( rule__AdditiveExpression__ExpAssignment_0 ) ) ;
    public final void rule__AdditiveExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2620:1: ( ( ( rule__AdditiveExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2621:1: ( ( rule__AdditiveExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2621:1: ( ( rule__AdditiveExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2622:1: ( rule__AdditiveExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2623:1: ( rule__AdditiveExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2623:2: rule__AdditiveExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__ExpAssignment_0_in_rule__AdditiveExpression__Group__0__Impl5491);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2633:1: rule__AdditiveExpression__Group__1 : rule__AdditiveExpression__Group__1__Impl ;
    public final void rule__AdditiveExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2637:1: ( rule__AdditiveExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2638:2: rule__AdditiveExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__1__Impl_in_rule__AdditiveExpression__Group__15521);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2644:1: rule__AdditiveExpression__Group__1__Impl : ( ( rule__AdditiveExpression__Group_1__0 )* ) ;
    public final void rule__AdditiveExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2648:1: ( ( ( rule__AdditiveExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2649:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2649:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2650:1: ( rule__AdditiveExpression__Group_1__0 )*
            {
             before(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2651:1: ( rule__AdditiveExpression__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=25 && LA21_0<=26)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2651:2: rule__AdditiveExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__0_in_rule__AdditiveExpression__Group__1__Impl5548);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2665:1: rule__AdditiveExpression__Group_1__0 : rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 ;
    public final void rule__AdditiveExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2669:1: ( rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2670:2: rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__0__Impl_in_rule__AdditiveExpression__Group_1__05583);
            rule__AdditiveExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__1_in_rule__AdditiveExpression__Group_1__05586);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2677:1: rule__AdditiveExpression__Group_1__0__Impl : ( ( rule__AdditiveExpression__OpAssignment_1_0 ) ) ;
    public final void rule__AdditiveExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2681:1: ( ( ( rule__AdditiveExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2682:1: ( ( rule__AdditiveExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2682:1: ( ( rule__AdditiveExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2683:1: ( rule__AdditiveExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2684:1: ( rule__AdditiveExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2684:2: rule__AdditiveExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__OpAssignment_1_0_in_rule__AdditiveExpression__Group_1__0__Impl5613);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2694:1: rule__AdditiveExpression__Group_1__1 : rule__AdditiveExpression__Group_1__1__Impl ;
    public final void rule__AdditiveExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2698:1: ( rule__AdditiveExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2699:2: rule__AdditiveExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__1__Impl_in_rule__AdditiveExpression__Group_1__15643);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2705:1: rule__AdditiveExpression__Group_1__1__Impl : ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__AdditiveExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2709:1: ( ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2710:1: ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2710:1: ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2711:1: ( rule__AdditiveExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2712:1: ( rule__AdditiveExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2712:2: rule__AdditiveExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__ExpAssignment_1_1_in_rule__AdditiveExpression__Group_1__1__Impl5670);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2726:1: rule__MultiplicativeExpression__Group__0 : rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 ;
    public final void rule__MultiplicativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2730:1: ( rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2731:2: rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__0__Impl_in_rule__MultiplicativeExpression__Group__05704);
            rule__MultiplicativeExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__1_in_rule__MultiplicativeExpression__Group__05707);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2738:1: rule__MultiplicativeExpression__Group__0__Impl : ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) ) ;
    public final void rule__MultiplicativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2742:1: ( ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2743:1: ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2743:1: ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2744:1: ( rule__MultiplicativeExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2745:1: ( rule__MultiplicativeExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2745:2: rule__MultiplicativeExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__ExpAssignment_0_in_rule__MultiplicativeExpression__Group__0__Impl5734);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2755:1: rule__MultiplicativeExpression__Group__1 : rule__MultiplicativeExpression__Group__1__Impl ;
    public final void rule__MultiplicativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2759:1: ( rule__MultiplicativeExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2760:2: rule__MultiplicativeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__1__Impl_in_rule__MultiplicativeExpression__Group__15764);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2766:1: rule__MultiplicativeExpression__Group__1__Impl : ( ( rule__MultiplicativeExpression__Group_1__0 )* ) ;
    public final void rule__MultiplicativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2770:1: ( ( ( rule__MultiplicativeExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2771:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2771:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2772:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2773:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=27 && LA22_0<=29)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2773:2: rule__MultiplicativeExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__0_in_rule__MultiplicativeExpression__Group__1__Impl5791);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2787:1: rule__MultiplicativeExpression__Group_1__0 : rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 ;
    public final void rule__MultiplicativeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2791:1: ( rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2792:2: rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__0__Impl_in_rule__MultiplicativeExpression__Group_1__05826);
            rule__MultiplicativeExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__1_in_rule__MultiplicativeExpression__Group_1__05829);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2799:1: rule__MultiplicativeExpression__Group_1__0__Impl : ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2803:1: ( ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2804:1: ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2804:1: ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2805:1: ( rule__MultiplicativeExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2806:1: ( rule__MultiplicativeExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2806:2: rule__MultiplicativeExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__OpAssignment_1_0_in_rule__MultiplicativeExpression__Group_1__0__Impl5856);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2816:1: rule__MultiplicativeExpression__Group_1__1 : rule__MultiplicativeExpression__Group_1__1__Impl ;
    public final void rule__MultiplicativeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2820:1: ( rule__MultiplicativeExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2821:2: rule__MultiplicativeExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__1__Impl_in_rule__MultiplicativeExpression__Group_1__15886);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2827:1: rule__MultiplicativeExpression__Group_1__1__Impl : ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2831:1: ( ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2832:1: ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2832:1: ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2833:1: ( rule__MultiplicativeExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2834:1: ( rule__MultiplicativeExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2834:2: rule__MultiplicativeExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__ExpAssignment_1_1_in_rule__MultiplicativeExpression__Group_1__1__Impl5913);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2848:1: rule__UnaryExpression__Group_0__0 : rule__UnaryExpression__Group_0__0__Impl rule__UnaryExpression__Group_0__1 ;
    public final void rule__UnaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2852:1: ( rule__UnaryExpression__Group_0__0__Impl rule__UnaryExpression__Group_0__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2853:2: rule__UnaryExpression__Group_0__0__Impl rule__UnaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Group_0__0__Impl_in_rule__UnaryExpression__Group_0__05947);
            rule__UnaryExpression__Group_0__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__UnaryExpression__Group_0__1_in_rule__UnaryExpression__Group_0__05950);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2860:1: rule__UnaryExpression__Group_0__0__Impl : ( ( rule__UnaryExpression__OpAssignment_0_0 ) ) ;
    public final void rule__UnaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2864:1: ( ( ( rule__UnaryExpression__OpAssignment_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2865:1: ( ( rule__UnaryExpression__OpAssignment_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2865:1: ( ( rule__UnaryExpression__OpAssignment_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2866:1: ( rule__UnaryExpression__OpAssignment_0_0 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2867:1: ( rule__UnaryExpression__OpAssignment_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2867:2: rule__UnaryExpression__OpAssignment_0_0
            {
            pushFollow(FOLLOW_rule__UnaryExpression__OpAssignment_0_0_in_rule__UnaryExpression__Group_0__0__Impl5977);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2877:1: rule__UnaryExpression__Group_0__1 : rule__UnaryExpression__Group_0__1__Impl ;
    public final void rule__UnaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2881:1: ( rule__UnaryExpression__Group_0__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2882:2: rule__UnaryExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Group_0__1__Impl_in_rule__UnaryExpression__Group_0__16007);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2888:1: rule__UnaryExpression__Group_0__1__Impl : ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) ) ;
    public final void rule__UnaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2892:1: ( ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2893:1: ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2893:1: ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2894:1: ( rule__UnaryExpression__UnaryAssignment_0_1 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getUnaryAssignment_0_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2895:1: ( rule__UnaryExpression__UnaryAssignment_0_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2895:2: rule__UnaryExpression__UnaryAssignment_0_1
            {
            pushFollow(FOLLOW_rule__UnaryExpression__UnaryAssignment_0_1_in_rule__UnaryExpression__Group_0__1__Impl6034);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2909:1: rule__PrimaryExpression__Group__0 : rule__PrimaryExpression__Group__0__Impl rule__PrimaryExpression__Group__1 ;
    public final void rule__PrimaryExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2913:1: ( rule__PrimaryExpression__Group__0__Impl rule__PrimaryExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2914:2: rule__PrimaryExpression__Group__0__Impl rule__PrimaryExpression__Group__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group__0__Impl_in_rule__PrimaryExpression__Group__06068);
            rule__PrimaryExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group__1_in_rule__PrimaryExpression__Group__06071);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2921:1: rule__PrimaryExpression__Group__0__Impl : ( ( rule__PrimaryExpression__PrefixAssignment_0 ) ) ;
    public final void rule__PrimaryExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2925:1: ( ( ( rule__PrimaryExpression__PrefixAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2926:1: ( ( rule__PrimaryExpression__PrefixAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2926:1: ( ( rule__PrimaryExpression__PrefixAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2927:1: ( rule__PrimaryExpression__PrefixAssignment_0 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrefixAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2928:1: ( rule__PrimaryExpression__PrefixAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2928:2: rule__PrimaryExpression__PrefixAssignment_0
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__PrefixAssignment_0_in_rule__PrimaryExpression__Group__0__Impl6098);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2938:1: rule__PrimaryExpression__Group__1 : rule__PrimaryExpression__Group__1__Impl ;
    public final void rule__PrimaryExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2942:1: ( rule__PrimaryExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2943:2: rule__PrimaryExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group__1__Impl_in_rule__PrimaryExpression__Group__16128);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2949:1: rule__PrimaryExpression__Group__1__Impl : ( ( rule__PrimaryExpression__Group_1__0 )? ) ;
    public final void rule__PrimaryExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2953:1: ( ( ( rule__PrimaryExpression__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2954:1: ( ( rule__PrimaryExpression__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2954:1: ( ( rule__PrimaryExpression__Group_1__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2955:1: ( rule__PrimaryExpression__Group_1__0 )?
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2956:1: ( rule__PrimaryExpression__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2956:2: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Group__1__Impl6155);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2970:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2974:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2975:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__06190);
            rule__PrimaryExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__06193);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2982:1: rule__PrimaryExpression__Group_1__0__Impl : ( '.' ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2986:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2987:1: ( '.' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2987:1: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2988:1: '.'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0()); 
            match(input,40,FOLLOW_40_in_rule__PrimaryExpression__Group_1__0__Impl6221); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3001:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3005:1: ( rule__PrimaryExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3006:2: rule__PrimaryExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__16252);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3012:1: rule__PrimaryExpression__Group_1__1__Impl : ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3016:1: ( ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3017:1: ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3017:1: ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3018:1: ( rule__PrimaryExpression__SuffixAssignment_1_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getSuffixAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3019:1: ( rule__PrimaryExpression__SuffixAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3019:2: rule__PrimaryExpression__SuffixAssignment_1_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__SuffixAssignment_1_1_in_rule__PrimaryExpression__Group_1__1__Impl6279);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3033:1: rule__ValueSpecification__Group_7__0 : rule__ValueSpecification__Group_7__0__Impl rule__ValueSpecification__Group_7__1 ;
    public final void rule__ValueSpecification__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3037:1: ( rule__ValueSpecification__Group_7__0__Impl rule__ValueSpecification__Group_7__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3038:2: rule__ValueSpecification__Group_7__0__Impl rule__ValueSpecification__Group_7__1
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__0__Impl_in_rule__ValueSpecification__Group_7__06313);
            rule__ValueSpecification__Group_7__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__1_in_rule__ValueSpecification__Group_7__06316);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3045:1: rule__ValueSpecification__Group_7__0__Impl : ( '(' ) ;
    public final void rule__ValueSpecification__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3049:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3050:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3050:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3051:1: '('
            {
             before(grammarAccess.getValueSpecificationAccess().getLeftParenthesisKeyword_7_0()); 
            match(input,41,FOLLOW_41_in_rule__ValueSpecification__Group_7__0__Impl6344); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3064:1: rule__ValueSpecification__Group_7__1 : rule__ValueSpecification__Group_7__1__Impl rule__ValueSpecification__Group_7__2 ;
    public final void rule__ValueSpecification__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3068:1: ( rule__ValueSpecification__Group_7__1__Impl rule__ValueSpecification__Group_7__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3069:2: rule__ValueSpecification__Group_7__1__Impl rule__ValueSpecification__Group_7__2
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__1__Impl_in_rule__ValueSpecification__Group_7__16375);
            rule__ValueSpecification__Group_7__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__2_in_rule__ValueSpecification__Group_7__16378);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3076:1: rule__ValueSpecification__Group_7__1__Impl : ( ruleExpression ) ;
    public final void rule__ValueSpecification__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3080:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3081:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3081:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3082:1: ruleExpression
            {
             before(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ValueSpecification__Group_7__1__Impl6405);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3093:1: rule__ValueSpecification__Group_7__2 : rule__ValueSpecification__Group_7__2__Impl ;
    public final void rule__ValueSpecification__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3097:1: ( rule__ValueSpecification__Group_7__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3098:2: rule__ValueSpecification__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__2__Impl_in_rule__ValueSpecification__Group_7__26434);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3104:1: rule__ValueSpecification__Group_7__2__Impl : ( ')' ) ;
    public final void rule__ValueSpecification__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3108:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3109:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3109:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3110:1: ')'
            {
             before(grammarAccess.getValueSpecificationAccess().getRightParenthesisKeyword_7_2()); 
            match(input,42,FOLLOW_42_in_rule__ValueSpecification__Group_7__2__Impl6462); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3129:1: rule__PropertyCallExpression__Group__0 : rule__PropertyCallExpression__Group__0__Impl rule__PropertyCallExpression__Group__1 ;
    public final void rule__PropertyCallExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3133:1: ( rule__PropertyCallExpression__Group__0__Impl rule__PropertyCallExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3134:2: rule__PropertyCallExpression__Group__0__Impl rule__PropertyCallExpression__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__0__Impl_in_rule__PropertyCallExpression__Group__06499);
            rule__PropertyCallExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__1_in_rule__PropertyCallExpression__Group__06502);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3141:1: rule__PropertyCallExpression__Group__0__Impl : ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) ) ;
    public final void rule__PropertyCallExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3145:1: ( ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3146:1: ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3146:1: ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3147:1: ( rule__PropertyCallExpression__PropertyAssignment_0 )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getPropertyAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3148:1: ( rule__PropertyCallExpression__PropertyAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3148:2: rule__PropertyCallExpression__PropertyAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__PropertyAssignment_0_in_rule__PropertyCallExpression__Group__0__Impl6529);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3158:1: rule__PropertyCallExpression__Group__1 : rule__PropertyCallExpression__Group__1__Impl ;
    public final void rule__PropertyCallExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3162:1: ( rule__PropertyCallExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3163:2: rule__PropertyCallExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__1__Impl_in_rule__PropertyCallExpression__Group__16559);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3169:1: rule__PropertyCallExpression__Group__1__Impl : ( ( rule__PropertyCallExpression__Group_1__0 )? ) ;
    public final void rule__PropertyCallExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3173:1: ( ( ( rule__PropertyCallExpression__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3174:1: ( ( rule__PropertyCallExpression__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3174:1: ( ( rule__PropertyCallExpression__Group_1__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3175:1: ( rule__PropertyCallExpression__Group_1__0 )?
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3176:1: ( rule__PropertyCallExpression__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==40) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3176:2: rule__PropertyCallExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__0_in_rule__PropertyCallExpression__Group__1__Impl6586);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3190:1: rule__PropertyCallExpression__Group_1__0 : rule__PropertyCallExpression__Group_1__0__Impl rule__PropertyCallExpression__Group_1__1 ;
    public final void rule__PropertyCallExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3194:1: ( rule__PropertyCallExpression__Group_1__0__Impl rule__PropertyCallExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3195:2: rule__PropertyCallExpression__Group_1__0__Impl rule__PropertyCallExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__0__Impl_in_rule__PropertyCallExpression__Group_1__06621);
            rule__PropertyCallExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__1_in_rule__PropertyCallExpression__Group_1__06624);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3202:1: rule__PropertyCallExpression__Group_1__0__Impl : ( '.' ) ;
    public final void rule__PropertyCallExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3206:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3207:1: ( '.' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3207:1: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3208:1: '.'
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_1_0()); 
            match(input,40,FOLLOW_40_in_rule__PropertyCallExpression__Group_1__0__Impl6652); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3221:1: rule__PropertyCallExpression__Group_1__1 : rule__PropertyCallExpression__Group_1__1__Impl ;
    public final void rule__PropertyCallExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3225:1: ( rule__PropertyCallExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3226:2: rule__PropertyCallExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__1__Impl_in_rule__PropertyCallExpression__Group_1__16683);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3232:1: rule__PropertyCallExpression__Group_1__1__Impl : ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) ) ;
    public final void rule__PropertyCallExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3236:1: ( ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3237:1: ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3237:1: ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3238:1: ( rule__PropertyCallExpression__SuffixAssignment_1_1 )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getSuffixAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3239:1: ( rule__PropertyCallExpression__SuffixAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3239:2: rule__PropertyCallExpression__SuffixAssignment_1_1
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__SuffixAssignment_1_1_in_rule__PropertyCallExpression__Group_1__1__Impl6710);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3253:1: rule__OperationCallExpression__Group__0 : rule__OperationCallExpression__Group__0__Impl rule__OperationCallExpression__Group__1 ;
    public final void rule__OperationCallExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3257:1: ( rule__OperationCallExpression__Group__0__Impl rule__OperationCallExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3258:2: rule__OperationCallExpression__Group__0__Impl rule__OperationCallExpression__Group__1
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__0__Impl_in_rule__OperationCallExpression__Group__06744);
            rule__OperationCallExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__1_in_rule__OperationCallExpression__Group__06747);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3265:1: rule__OperationCallExpression__Group__0__Impl : ( ( rule__OperationCallExpression__OperationAssignment_0 ) ) ;
    public final void rule__OperationCallExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3269:1: ( ( ( rule__OperationCallExpression__OperationAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3270:1: ( ( rule__OperationCallExpression__OperationAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3270:1: ( ( rule__OperationCallExpression__OperationAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3271:1: ( rule__OperationCallExpression__OperationAssignment_0 )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getOperationAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3272:1: ( rule__OperationCallExpression__OperationAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3272:2: rule__OperationCallExpression__OperationAssignment_0
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__OperationAssignment_0_in_rule__OperationCallExpression__Group__0__Impl6774);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3282:1: rule__OperationCallExpression__Group__1 : rule__OperationCallExpression__Group__1__Impl rule__OperationCallExpression__Group__2 ;
    public final void rule__OperationCallExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3286:1: ( rule__OperationCallExpression__Group__1__Impl rule__OperationCallExpression__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3287:2: rule__OperationCallExpression__Group__1__Impl rule__OperationCallExpression__Group__2
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__1__Impl_in_rule__OperationCallExpression__Group__16804);
            rule__OperationCallExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__2_in_rule__OperationCallExpression__Group__16807);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3294:1: rule__OperationCallExpression__Group__1__Impl : ( '(' ) ;
    public final void rule__OperationCallExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3298:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3299:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3299:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3300:1: '('
            {
             before(grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__OperationCallExpression__Group__1__Impl6835); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3313:1: rule__OperationCallExpression__Group__2 : rule__OperationCallExpression__Group__2__Impl rule__OperationCallExpression__Group__3 ;
    public final void rule__OperationCallExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3317:1: ( rule__OperationCallExpression__Group__2__Impl rule__OperationCallExpression__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3318:2: rule__OperationCallExpression__Group__2__Impl rule__OperationCallExpression__Group__3
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__2__Impl_in_rule__OperationCallExpression__Group__26866);
            rule__OperationCallExpression__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__3_in_rule__OperationCallExpression__Group__26869);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3325:1: rule__OperationCallExpression__Group__2__Impl : ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? ) ;
    public final void rule__OperationCallExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3329:1: ( ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3330:1: ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3330:1: ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3331:1: ( rule__OperationCallExpression__ArgumentsAssignment_2 )?
            {
             before(grammarAccess.getOperationCallExpressionAccess().getArgumentsAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3332:1: ( rule__OperationCallExpression__ArgumentsAssignment_2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_NULLLITERAL)||(LA25_0>=25 && LA25_0<=28)||(LA25_0>=30 && LA25_0<=35)||LA25_0==41||LA25_0==45||LA25_0==49||(LA25_0>=51 && LA25_0<=53)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3332:2: rule__OperationCallExpression__ArgumentsAssignment_2
                    {
                    pushFollow(FOLLOW_rule__OperationCallExpression__ArgumentsAssignment_2_in_rule__OperationCallExpression__Group__2__Impl6896);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3342:1: rule__OperationCallExpression__Group__3 : rule__OperationCallExpression__Group__3__Impl rule__OperationCallExpression__Group__4 ;
    public final void rule__OperationCallExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3346:1: ( rule__OperationCallExpression__Group__3__Impl rule__OperationCallExpression__Group__4 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3347:2: rule__OperationCallExpression__Group__3__Impl rule__OperationCallExpression__Group__4
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__3__Impl_in_rule__OperationCallExpression__Group__36927);
            rule__OperationCallExpression__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__4_in_rule__OperationCallExpression__Group__36930);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3354:1: rule__OperationCallExpression__Group__3__Impl : ( ')' ) ;
    public final void rule__OperationCallExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3358:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3359:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3359:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3360:1: ')'
            {
             before(grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_3()); 
            match(input,42,FOLLOW_42_in_rule__OperationCallExpression__Group__3__Impl6958); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3373:1: rule__OperationCallExpression__Group__4 : rule__OperationCallExpression__Group__4__Impl ;
    public final void rule__OperationCallExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3377:1: ( rule__OperationCallExpression__Group__4__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3378:2: rule__OperationCallExpression__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__4__Impl_in_rule__OperationCallExpression__Group__46989);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3384:1: rule__OperationCallExpression__Group__4__Impl : ( ( rule__OperationCallExpression__Group_4__0 )? ) ;
    public final void rule__OperationCallExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3388:1: ( ( ( rule__OperationCallExpression__Group_4__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3389:1: ( ( rule__OperationCallExpression__Group_4__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3389:1: ( ( rule__OperationCallExpression__Group_4__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3390:1: ( rule__OperationCallExpression__Group_4__0 )?
            {
             before(grammarAccess.getOperationCallExpressionAccess().getGroup_4()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3391:1: ( rule__OperationCallExpression__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==40) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3391:2: rule__OperationCallExpression__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__0_in_rule__OperationCallExpression__Group__4__Impl7016);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3411:1: rule__OperationCallExpression__Group_4__0 : rule__OperationCallExpression__Group_4__0__Impl rule__OperationCallExpression__Group_4__1 ;
    public final void rule__OperationCallExpression__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3415:1: ( rule__OperationCallExpression__Group_4__0__Impl rule__OperationCallExpression__Group_4__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3416:2: rule__OperationCallExpression__Group_4__0__Impl rule__OperationCallExpression__Group_4__1
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__0__Impl_in_rule__OperationCallExpression__Group_4__07057);
            rule__OperationCallExpression__Group_4__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__1_in_rule__OperationCallExpression__Group_4__07060);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3423:1: rule__OperationCallExpression__Group_4__0__Impl : ( '.' ) ;
    public final void rule__OperationCallExpression__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3427:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3428:1: ( '.' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3428:1: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3429:1: '.'
            {
             before(grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_4_0()); 
            match(input,40,FOLLOW_40_in_rule__OperationCallExpression__Group_4__0__Impl7088); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3442:1: rule__OperationCallExpression__Group_4__1 : rule__OperationCallExpression__Group_4__1__Impl ;
    public final void rule__OperationCallExpression__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3446:1: ( rule__OperationCallExpression__Group_4__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3447:2: rule__OperationCallExpression__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__1__Impl_in_rule__OperationCallExpression__Group_4__17119);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3453:1: rule__OperationCallExpression__Group_4__1__Impl : ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) ) ;
    public final void rule__OperationCallExpression__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3457:1: ( ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3458:1: ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3458:1: ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3459:1: ( rule__OperationCallExpression__SuffixAssignment_4_1 )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getSuffixAssignment_4_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3460:1: ( rule__OperationCallExpression__SuffixAssignment_4_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3460:2: rule__OperationCallExpression__SuffixAssignment_4_1
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__SuffixAssignment_4_1_in_rule__OperationCallExpression__Group_4__1__Impl7146);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3474:1: rule__NameOrChoiceOrBehaviorCall__Group__0 : rule__NameOrChoiceOrBehaviorCall__Group__0__Impl rule__NameOrChoiceOrBehaviorCall__Group__1 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3478:1: ( rule__NameOrChoiceOrBehaviorCall__Group__0__Impl rule__NameOrChoiceOrBehaviorCall__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3479:2: rule__NameOrChoiceOrBehaviorCall__Group__0__Impl rule__NameOrChoiceOrBehaviorCall__Group__1
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__07180);
            rule__NameOrChoiceOrBehaviorCall__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1_in_rule__NameOrChoiceOrBehaviorCall__Group__07183);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3486:1: rule__NameOrChoiceOrBehaviorCall__Group__0__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3490:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3491:1: ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3491:1: ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3492:1: ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )?
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3493:1: ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==43) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3493:2: rule__NameOrChoiceOrBehaviorCall__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__PathAssignment_0_in_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl7210);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3503:1: rule__NameOrChoiceOrBehaviorCall__Group__1 : rule__NameOrChoiceOrBehaviorCall__Group__1__Impl rule__NameOrChoiceOrBehaviorCall__Group__2 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3507:1: ( rule__NameOrChoiceOrBehaviorCall__Group__1__Impl rule__NameOrChoiceOrBehaviorCall__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3508:2: rule__NameOrChoiceOrBehaviorCall__Group__1__Impl rule__NameOrChoiceOrBehaviorCall__Group__2
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__17241);
            rule__NameOrChoiceOrBehaviorCall__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2_in_rule__NameOrChoiceOrBehaviorCall__Group__17244);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3515:1: rule__NameOrChoiceOrBehaviorCall__Group__1__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3519:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3520:1: ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3520:1: ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3521:1: ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 )
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3522:1: ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3522:2: rule__NameOrChoiceOrBehaviorCall__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__IdAssignment_1_in_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl7271);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3532:1: rule__NameOrChoiceOrBehaviorCall__Group__2 : rule__NameOrChoiceOrBehaviorCall__Group__2__Impl ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3536:1: ( rule__NameOrChoiceOrBehaviorCall__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3537:2: rule__NameOrChoiceOrBehaviorCall__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__27301);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3543:1: rule__NameOrChoiceOrBehaviorCall__Group__2__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3547:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3548:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3548:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3549:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )?
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3550:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==41) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3550:2: rule__NameOrChoiceOrBehaviorCall__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0_in_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl7328);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3566:1: rule__NameOrChoiceOrBehaviorCall__Group_2__0 : rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__1 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3570:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3571:2: rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__1
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__07365);
            rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__07368);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3578:1: rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl : ( '(' ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3582:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3583:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3583:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3584:1: '('
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,41,FOLLOW_41_in_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl7396); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3597:1: rule__NameOrChoiceOrBehaviorCall__Group_2__1 : rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__2 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3601:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3602:2: rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__2
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__17427);
            rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2_in_rule__NameOrChoiceOrBehaviorCall__Group_2__17430);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3609:1: rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3613:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3614:1: ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3614:1: ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3615:1: ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )?
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3616:1: ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_NULLLITERAL)||(LA29_0>=25 && LA29_0<=28)||(LA29_0>=30 && LA29_0<=35)||LA29_0==41||LA29_0==45||LA29_0==49||(LA29_0>=51 && LA29_0<=53)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3616:2: rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl7457);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3626:1: rule__NameOrChoiceOrBehaviorCall__Group_2__2 : rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3630:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3631:2: rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__27488);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3637:1: rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl : ( ')' ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3641:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3642:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3642:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3643:1: ')'
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getRightParenthesisKeyword_2_2()); 
            match(input,42,FOLLOW_42_in_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl7516); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3662:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3666:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3667:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__07553);
            rule__QualifiedName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__07556);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3674:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3678:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3679:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3679:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3680:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3681:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3681:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl7583);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3691:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3695:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3696:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__17613);
            rule__QualifiedName__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__17616);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3703:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3707:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3708:1: ( '::' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3708:1: ( '::' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3709:1: '::'
            {
             before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); 
            match(input,43,FOLLOW_43_in_rule__QualifiedName__Group__1__Impl7644); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3722:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3726:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3727:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__27675);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3733:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3737:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3738:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3738:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3739:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3740:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==43) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3740:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl7702);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3756:1: rule__Interval__Group__0 : rule__Interval__Group__0__Impl rule__Interval__Group__1 ;
    public final void rule__Interval__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3760:1: ( rule__Interval__Group__0__Impl rule__Interval__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3761:2: rule__Interval__Group__0__Impl rule__Interval__Group__1
            {
            pushFollow(FOLLOW_rule__Interval__Group__0__Impl_in_rule__Interval__Group__07739);
            rule__Interval__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__1_in_rule__Interval__Group__07742);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3768:1: rule__Interval__Group__0__Impl : ( ( rule__Interval__Alternatives_0 ) ) ;
    public final void rule__Interval__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3772:1: ( ( ( rule__Interval__Alternatives_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3773:1: ( ( rule__Interval__Alternatives_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3773:1: ( ( rule__Interval__Alternatives_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3774:1: ( rule__Interval__Alternatives_0 )
            {
             before(grammarAccess.getIntervalAccess().getAlternatives_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3775:1: ( rule__Interval__Alternatives_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3775:2: rule__Interval__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Interval__Alternatives_0_in_rule__Interval__Group__0__Impl7769);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3785:1: rule__Interval__Group__1 : rule__Interval__Group__1__Impl rule__Interval__Group__2 ;
    public final void rule__Interval__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3789:1: ( rule__Interval__Group__1__Impl rule__Interval__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3790:2: rule__Interval__Group__1__Impl rule__Interval__Group__2
            {
            pushFollow(FOLLOW_rule__Interval__Group__1__Impl_in_rule__Interval__Group__17799);
            rule__Interval__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__2_in_rule__Interval__Group__17802);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3797:1: rule__Interval__Group__1__Impl : ( ( rule__Interval__LowerAssignment_1 ) ) ;
    public final void rule__Interval__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3801:1: ( ( ( rule__Interval__LowerAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3802:1: ( ( rule__Interval__LowerAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3802:1: ( ( rule__Interval__LowerAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3803:1: ( rule__Interval__LowerAssignment_1 )
            {
             before(grammarAccess.getIntervalAccess().getLowerAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3804:1: ( rule__Interval__LowerAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3804:2: rule__Interval__LowerAssignment_1
            {
            pushFollow(FOLLOW_rule__Interval__LowerAssignment_1_in_rule__Interval__Group__1__Impl7829);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3814:1: rule__Interval__Group__2 : rule__Interval__Group__2__Impl rule__Interval__Group__3 ;
    public final void rule__Interval__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3818:1: ( rule__Interval__Group__2__Impl rule__Interval__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3819:2: rule__Interval__Group__2__Impl rule__Interval__Group__3
            {
            pushFollow(FOLLOW_rule__Interval__Group__2__Impl_in_rule__Interval__Group__27859);
            rule__Interval__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__3_in_rule__Interval__Group__27862);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3826:1: rule__Interval__Group__2__Impl : ( '..' ) ;
    public final void rule__Interval__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3830:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3831:1: ( '..' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3831:1: ( '..' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3832:1: '..'
            {
             before(grammarAccess.getIntervalAccess().getFullStopFullStopKeyword_2()); 
            match(input,44,FOLLOW_44_in_rule__Interval__Group__2__Impl7890); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3845:1: rule__Interval__Group__3 : rule__Interval__Group__3__Impl rule__Interval__Group__4 ;
    public final void rule__Interval__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3849:1: ( rule__Interval__Group__3__Impl rule__Interval__Group__4 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3850:2: rule__Interval__Group__3__Impl rule__Interval__Group__4
            {
            pushFollow(FOLLOW_rule__Interval__Group__3__Impl_in_rule__Interval__Group__37921);
            rule__Interval__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__4_in_rule__Interval__Group__37924);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3857:1: rule__Interval__Group__3__Impl : ( ( rule__Interval__UpperAssignment_3 ) ) ;
    public final void rule__Interval__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3861:1: ( ( ( rule__Interval__UpperAssignment_3 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3862:1: ( ( rule__Interval__UpperAssignment_3 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3862:1: ( ( rule__Interval__UpperAssignment_3 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3863:1: ( rule__Interval__UpperAssignment_3 )
            {
             before(grammarAccess.getIntervalAccess().getUpperAssignment_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3864:1: ( rule__Interval__UpperAssignment_3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3864:2: rule__Interval__UpperAssignment_3
            {
            pushFollow(FOLLOW_rule__Interval__UpperAssignment_3_in_rule__Interval__Group__3__Impl7951);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3874:1: rule__Interval__Group__4 : rule__Interval__Group__4__Impl ;
    public final void rule__Interval__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3878:1: ( rule__Interval__Group__4__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3879:2: rule__Interval__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Interval__Group__4__Impl_in_rule__Interval__Group__47981);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3885:1: rule__Interval__Group__4__Impl : ( ( rule__Interval__Alternatives_4 ) ) ;
    public final void rule__Interval__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3889:1: ( ( ( rule__Interval__Alternatives_4 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3890:1: ( ( rule__Interval__Alternatives_4 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3890:1: ( ( rule__Interval__Alternatives_4 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3891:1: ( rule__Interval__Alternatives_4 )
            {
             before(grammarAccess.getIntervalAccess().getAlternatives_4()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3892:1: ( rule__Interval__Alternatives_4 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3892:2: rule__Interval__Alternatives_4
            {
            pushFollow(FOLLOW_rule__Interval__Alternatives_4_in_rule__Interval__Group__4__Impl8008);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3912:1: rule__CollectionOrTuple__Group__0 : rule__CollectionOrTuple__Group__0__Impl rule__CollectionOrTuple__Group__1 ;
    public final void rule__CollectionOrTuple__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3916:1: ( rule__CollectionOrTuple__Group__0__Impl rule__CollectionOrTuple__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3917:2: rule__CollectionOrTuple__Group__0__Impl rule__CollectionOrTuple__Group__1
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__0__Impl_in_rule__CollectionOrTuple__Group__08048);
            rule__CollectionOrTuple__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__1_in_rule__CollectionOrTuple__Group__08051);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3924:1: rule__CollectionOrTuple__Group__0__Impl : ( '{' ) ;
    public final void rule__CollectionOrTuple__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3928:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3929:1: ( '{' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3929:1: ( '{' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3930:1: '{'
            {
             before(grammarAccess.getCollectionOrTupleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,45,FOLLOW_45_in_rule__CollectionOrTuple__Group__0__Impl8079); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3943:1: rule__CollectionOrTuple__Group__1 : rule__CollectionOrTuple__Group__1__Impl rule__CollectionOrTuple__Group__2 ;
    public final void rule__CollectionOrTuple__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3947:1: ( rule__CollectionOrTuple__Group__1__Impl rule__CollectionOrTuple__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3948:2: rule__CollectionOrTuple__Group__1__Impl rule__CollectionOrTuple__Group__2
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__1__Impl_in_rule__CollectionOrTuple__Group__18110);
            rule__CollectionOrTuple__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__2_in_rule__CollectionOrTuple__Group__18113);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3955:1: rule__CollectionOrTuple__Group__1__Impl : ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) ) ;
    public final void rule__CollectionOrTuple__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3959:1: ( ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3960:1: ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3960:1: ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3961:1: ( rule__CollectionOrTuple__ListOfValuesAssignment_1 )
            {
             before(grammarAccess.getCollectionOrTupleAccess().getListOfValuesAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3962:1: ( rule__CollectionOrTuple__ListOfValuesAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3962:2: rule__CollectionOrTuple__ListOfValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__ListOfValuesAssignment_1_in_rule__CollectionOrTuple__Group__1__Impl8140);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3972:1: rule__CollectionOrTuple__Group__2 : rule__CollectionOrTuple__Group__2__Impl ;
    public final void rule__CollectionOrTuple__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3976:1: ( rule__CollectionOrTuple__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3977:2: rule__CollectionOrTuple__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__2__Impl_in_rule__CollectionOrTuple__Group__28170);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3983:1: rule__CollectionOrTuple__Group__2__Impl : ( '}' ) ;
    public final void rule__CollectionOrTuple__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3987:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3988:1: ( '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3988:1: ( '}' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3989:1: '}'
            {
             before(grammarAccess.getCollectionOrTupleAccess().getRightCurlyBracketKeyword_2()); 
            match(input,46,FOLLOW_46_in_rule__CollectionOrTuple__Group__2__Impl8198); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4008:1: rule__Tuple__Group__0 : rule__Tuple__Group__0__Impl rule__Tuple__Group__1 ;
    public final void rule__Tuple__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4012:1: ( rule__Tuple__Group__0__Impl rule__Tuple__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4013:2: rule__Tuple__Group__0__Impl rule__Tuple__Group__1
            {
            pushFollow(FOLLOW_rule__Tuple__Group__0__Impl_in_rule__Tuple__Group__08235);
            rule__Tuple__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Tuple__Group__1_in_rule__Tuple__Group__08238);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4020:1: rule__Tuple__Group__0__Impl : ( '{' ) ;
    public final void rule__Tuple__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4024:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4025:1: ( '{' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4025:1: ( '{' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4026:1: '{'
            {
             before(grammarAccess.getTupleAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,45,FOLLOW_45_in_rule__Tuple__Group__0__Impl8266); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4039:1: rule__Tuple__Group__1 : rule__Tuple__Group__1__Impl rule__Tuple__Group__2 ;
    public final void rule__Tuple__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4043:1: ( rule__Tuple__Group__1__Impl rule__Tuple__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4044:2: rule__Tuple__Group__1__Impl rule__Tuple__Group__2
            {
            pushFollow(FOLLOW_rule__Tuple__Group__1__Impl_in_rule__Tuple__Group__18297);
            rule__Tuple__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Tuple__Group__2_in_rule__Tuple__Group__18300);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4051:1: rule__Tuple__Group__1__Impl : ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) ) ;
    public final void rule__Tuple__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4055:1: ( ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4056:1: ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4056:1: ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4057:1: ( rule__Tuple__ListOfValueNamePairsAssignment_1 )
            {
             before(grammarAccess.getTupleAccess().getListOfValueNamePairsAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4058:1: ( rule__Tuple__ListOfValueNamePairsAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4058:2: rule__Tuple__ListOfValueNamePairsAssignment_1
            {
            pushFollow(FOLLOW_rule__Tuple__ListOfValueNamePairsAssignment_1_in_rule__Tuple__Group__1__Impl8327);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4068:1: rule__Tuple__Group__2 : rule__Tuple__Group__2__Impl ;
    public final void rule__Tuple__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4072:1: ( rule__Tuple__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4073:2: rule__Tuple__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Tuple__Group__2__Impl_in_rule__Tuple__Group__28357);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4079:1: rule__Tuple__Group__2__Impl : ( '}' ) ;
    public final void rule__Tuple__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4083:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4084:1: ( '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4084:1: ( '}' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4085:1: '}'
            {
             before(grammarAccess.getTupleAccess().getRightCurlyBracketKeyword_2()); 
            match(input,46,FOLLOW_46_in_rule__Tuple__Group__2__Impl8385); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4104:1: rule__ListOfValues__Group__0 : rule__ListOfValues__Group__0__Impl rule__ListOfValues__Group__1 ;
    public final void rule__ListOfValues__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4108:1: ( rule__ListOfValues__Group__0__Impl rule__ListOfValues__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4109:2: rule__ListOfValues__Group__0__Impl rule__ListOfValues__Group__1
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group__0__Impl_in_rule__ListOfValues__Group__08422);
            rule__ListOfValues__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ListOfValues__Group__1_in_rule__ListOfValues__Group__08425);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4116:1: rule__ListOfValues__Group__0__Impl : ( ( rule__ListOfValues__ValuesAssignment_0 ) ) ;
    public final void rule__ListOfValues__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4120:1: ( ( ( rule__ListOfValues__ValuesAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4121:1: ( ( rule__ListOfValues__ValuesAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4121:1: ( ( rule__ListOfValues__ValuesAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4122:1: ( rule__ListOfValues__ValuesAssignment_0 )
            {
             before(grammarAccess.getListOfValuesAccess().getValuesAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4123:1: ( rule__ListOfValues__ValuesAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4123:2: rule__ListOfValues__ValuesAssignment_0
            {
            pushFollow(FOLLOW_rule__ListOfValues__ValuesAssignment_0_in_rule__ListOfValues__Group__0__Impl8452);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4133:1: rule__ListOfValues__Group__1 : rule__ListOfValues__Group__1__Impl ;
    public final void rule__ListOfValues__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4137:1: ( rule__ListOfValues__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4138:2: rule__ListOfValues__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group__1__Impl_in_rule__ListOfValues__Group__18482);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4144:1: rule__ListOfValues__Group__1__Impl : ( ( rule__ListOfValues__Group_1__0 )* ) ;
    public final void rule__ListOfValues__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4148:1: ( ( ( rule__ListOfValues__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4149:1: ( ( rule__ListOfValues__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4149:1: ( ( rule__ListOfValues__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4150:1: ( rule__ListOfValues__Group_1__0 )*
            {
             before(grammarAccess.getListOfValuesAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4151:1: ( rule__ListOfValues__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==47) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4151:2: rule__ListOfValues__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ListOfValues__Group_1__0_in_rule__ListOfValues__Group__1__Impl8509);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4165:1: rule__ListOfValues__Group_1__0 : rule__ListOfValues__Group_1__0__Impl rule__ListOfValues__Group_1__1 ;
    public final void rule__ListOfValues__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4169:1: ( rule__ListOfValues__Group_1__0__Impl rule__ListOfValues__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4170:2: rule__ListOfValues__Group_1__0__Impl rule__ListOfValues__Group_1__1
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group_1__0__Impl_in_rule__ListOfValues__Group_1__08544);
            rule__ListOfValues__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ListOfValues__Group_1__1_in_rule__ListOfValues__Group_1__08547);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4177:1: rule__ListOfValues__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ListOfValues__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4181:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4182:1: ( ',' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4182:1: ( ',' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4183:1: ','
            {
             before(grammarAccess.getListOfValuesAccess().getCommaKeyword_1_0()); 
            match(input,47,FOLLOW_47_in_rule__ListOfValues__Group_1__0__Impl8575); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4196:1: rule__ListOfValues__Group_1__1 : rule__ListOfValues__Group_1__1__Impl ;
    public final void rule__ListOfValues__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4200:1: ( rule__ListOfValues__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4201:2: rule__ListOfValues__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group_1__1__Impl_in_rule__ListOfValues__Group_1__18606);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4207:1: rule__ListOfValues__Group_1__1__Impl : ( ( rule__ListOfValues__ValuesAssignment_1_1 ) ) ;
    public final void rule__ListOfValues__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4211:1: ( ( ( rule__ListOfValues__ValuesAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4212:1: ( ( rule__ListOfValues__ValuesAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4212:1: ( ( rule__ListOfValues__ValuesAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4213:1: ( rule__ListOfValues__ValuesAssignment_1_1 )
            {
             before(grammarAccess.getListOfValuesAccess().getValuesAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4214:1: ( rule__ListOfValues__ValuesAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4214:2: rule__ListOfValues__ValuesAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ListOfValues__ValuesAssignment_1_1_in_rule__ListOfValues__Group_1__1__Impl8633);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4228:1: rule__ListOfValueNamePairs__Group__0 : rule__ListOfValueNamePairs__Group__0__Impl rule__ListOfValueNamePairs__Group__1 ;
    public final void rule__ListOfValueNamePairs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4232:1: ( rule__ListOfValueNamePairs__Group__0__Impl rule__ListOfValueNamePairs__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4233:2: rule__ListOfValueNamePairs__Group__0__Impl rule__ListOfValueNamePairs__Group__1
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__0__Impl_in_rule__ListOfValueNamePairs__Group__08667);
            rule__ListOfValueNamePairs__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__1_in_rule__ListOfValueNamePairs__Group__08670);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4240:1: rule__ListOfValueNamePairs__Group__0__Impl : ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) ) ;
    public final void rule__ListOfValueNamePairs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4244:1: ( ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4245:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4245:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4246:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 )
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4247:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4247:2: rule__ListOfValueNamePairs__ValueNamePairsAssignment_0
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_0_in_rule__ListOfValueNamePairs__Group__0__Impl8697);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4257:1: rule__ListOfValueNamePairs__Group__1 : rule__ListOfValueNamePairs__Group__1__Impl ;
    public final void rule__ListOfValueNamePairs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4261:1: ( rule__ListOfValueNamePairs__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4262:2: rule__ListOfValueNamePairs__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__1__Impl_in_rule__ListOfValueNamePairs__Group__18727);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4268:1: rule__ListOfValueNamePairs__Group__1__Impl : ( ( rule__ListOfValueNamePairs__Group_1__0 )* ) ;
    public final void rule__ListOfValueNamePairs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4272:1: ( ( ( rule__ListOfValueNamePairs__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4273:1: ( ( rule__ListOfValueNamePairs__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4273:1: ( ( rule__ListOfValueNamePairs__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4274:1: ( rule__ListOfValueNamePairs__Group_1__0 )*
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4275:1: ( rule__ListOfValueNamePairs__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==47) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4275:2: rule__ListOfValueNamePairs__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__0_in_rule__ListOfValueNamePairs__Group__1__Impl8754);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4289:1: rule__ListOfValueNamePairs__Group_1__0 : rule__ListOfValueNamePairs__Group_1__0__Impl rule__ListOfValueNamePairs__Group_1__1 ;
    public final void rule__ListOfValueNamePairs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4293:1: ( rule__ListOfValueNamePairs__Group_1__0__Impl rule__ListOfValueNamePairs__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4294:2: rule__ListOfValueNamePairs__Group_1__0__Impl rule__ListOfValueNamePairs__Group_1__1
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__0__Impl_in_rule__ListOfValueNamePairs__Group_1__08789);
            rule__ListOfValueNamePairs__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__1_in_rule__ListOfValueNamePairs__Group_1__08792);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4301:1: rule__ListOfValueNamePairs__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ListOfValueNamePairs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4305:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4306:1: ( ',' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4306:1: ( ',' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4307:1: ','
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getCommaKeyword_1_0()); 
            match(input,47,FOLLOW_47_in_rule__ListOfValueNamePairs__Group_1__0__Impl8820); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4320:1: rule__ListOfValueNamePairs__Group_1__1 : rule__ListOfValueNamePairs__Group_1__1__Impl ;
    public final void rule__ListOfValueNamePairs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4324:1: ( rule__ListOfValueNamePairs__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4325:2: rule__ListOfValueNamePairs__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__1__Impl_in_rule__ListOfValueNamePairs__Group_1__18851);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4331:1: rule__ListOfValueNamePairs__Group_1__1__Impl : ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) ) ;
    public final void rule__ListOfValueNamePairs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4335:1: ( ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4336:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4336:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4337:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 )
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4338:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4338:2: rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1_in_rule__ListOfValueNamePairs__Group_1__1__Impl8878);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4352:1: rule__ValueNamePair__Group__0 : rule__ValueNamePair__Group__0__Impl rule__ValueNamePair__Group__1 ;
    public final void rule__ValueNamePair__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4356:1: ( rule__ValueNamePair__Group__0__Impl rule__ValueNamePair__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4357:2: rule__ValueNamePair__Group__0__Impl rule__ValueNamePair__Group__1
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__0__Impl_in_rule__ValueNamePair__Group__08912);
            rule__ValueNamePair__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ValueNamePair__Group__1_in_rule__ValueNamePair__Group__08915);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4364:1: rule__ValueNamePair__Group__0__Impl : ( ( rule__ValueNamePair__PropertyAssignment_0 ) ) ;
    public final void rule__ValueNamePair__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4368:1: ( ( ( rule__ValueNamePair__PropertyAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4369:1: ( ( rule__ValueNamePair__PropertyAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4369:1: ( ( rule__ValueNamePair__PropertyAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4370:1: ( rule__ValueNamePair__PropertyAssignment_0 )
            {
             before(grammarAccess.getValueNamePairAccess().getPropertyAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4371:1: ( rule__ValueNamePair__PropertyAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4371:2: rule__ValueNamePair__PropertyAssignment_0
            {
            pushFollow(FOLLOW_rule__ValueNamePair__PropertyAssignment_0_in_rule__ValueNamePair__Group__0__Impl8942);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4381:1: rule__ValueNamePair__Group__1 : rule__ValueNamePair__Group__1__Impl rule__ValueNamePair__Group__2 ;
    public final void rule__ValueNamePair__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4385:1: ( rule__ValueNamePair__Group__1__Impl rule__ValueNamePair__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4386:2: rule__ValueNamePair__Group__1__Impl rule__ValueNamePair__Group__2
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__1__Impl_in_rule__ValueNamePair__Group__18972);
            rule__ValueNamePair__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ValueNamePair__Group__2_in_rule__ValueNamePair__Group__18975);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4393:1: rule__ValueNamePair__Group__1__Impl : ( '=' ) ;
    public final void rule__ValueNamePair__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4397:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4398:1: ( '=' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4398:1: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4399:1: '='
            {
             before(grammarAccess.getValueNamePairAccess().getEqualsSignKeyword_1()); 
            match(input,48,FOLLOW_48_in_rule__ValueNamePair__Group__1__Impl9003); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4412:1: rule__ValueNamePair__Group__2 : rule__ValueNamePair__Group__2__Impl ;
    public final void rule__ValueNamePair__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4416:1: ( rule__ValueNamePair__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4417:2: rule__ValueNamePair__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__2__Impl_in_rule__ValueNamePair__Group__29034);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4423:1: rule__ValueNamePair__Group__2__Impl : ( ( rule__ValueNamePair__ValueAssignment_2 ) ) ;
    public final void rule__ValueNamePair__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4427:1: ( ( ( rule__ValueNamePair__ValueAssignment_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4428:1: ( ( rule__ValueNamePair__ValueAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4428:1: ( ( rule__ValueNamePair__ValueAssignment_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4429:1: ( rule__ValueNamePair__ValueAssignment_2 )
            {
             before(grammarAccess.getValueNamePairAccess().getValueAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4430:1: ( rule__ValueNamePair__ValueAssignment_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4430:2: rule__ValueNamePair__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ValueNamePair__ValueAssignment_2_in_rule__ValueNamePair__Group__2__Impl9061);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4446:1: rule__InstantObsExpression__Group__0 : rule__InstantObsExpression__Group__0__Impl rule__InstantObsExpression__Group__1 ;
    public final void rule__InstantObsExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4450:1: ( rule__InstantObsExpression__Group__0__Impl rule__InstantObsExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4451:2: rule__InstantObsExpression__Group__0__Impl rule__InstantObsExpression__Group__1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__0__Impl_in_rule__InstantObsExpression__Group__09097);
            rule__InstantObsExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group__1_in_rule__InstantObsExpression__Group__09100);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4458:1: rule__InstantObsExpression__Group__0__Impl : ( '@' ) ;
    public final void rule__InstantObsExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4462:1: ( ( '@' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4463:1: ( '@' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4463:1: ( '@' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4464:1: '@'
            {
             before(grammarAccess.getInstantObsExpressionAccess().getCommercialAtKeyword_0()); 
            match(input,49,FOLLOW_49_in_rule__InstantObsExpression__Group__0__Impl9128); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4477:1: rule__InstantObsExpression__Group__1 : rule__InstantObsExpression__Group__1__Impl rule__InstantObsExpression__Group__2 ;
    public final void rule__InstantObsExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4481:1: ( rule__InstantObsExpression__Group__1__Impl rule__InstantObsExpression__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4482:2: rule__InstantObsExpression__Group__1__Impl rule__InstantObsExpression__Group__2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__1__Impl_in_rule__InstantObsExpression__Group__19159);
            rule__InstantObsExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group__2_in_rule__InstantObsExpression__Group__19162);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4489:1: rule__InstantObsExpression__Group__1__Impl : ( ( rule__InstantObsExpression__IdAssignment_1 ) ) ;
    public final void rule__InstantObsExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4493:1: ( ( ( rule__InstantObsExpression__IdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4494:1: ( ( rule__InstantObsExpression__IdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4494:1: ( ( rule__InstantObsExpression__IdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4495:1: ( rule__InstantObsExpression__IdAssignment_1 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4496:1: ( rule__InstantObsExpression__IdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4496:2: rule__InstantObsExpression__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__IdAssignment_1_in_rule__InstantObsExpression__Group__1__Impl9189);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4506:1: rule__InstantObsExpression__Group__2 : rule__InstantObsExpression__Group__2__Impl rule__InstantObsExpression__Group__3 ;
    public final void rule__InstantObsExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4510:1: ( rule__InstantObsExpression__Group__2__Impl rule__InstantObsExpression__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4511:2: rule__InstantObsExpression__Group__2__Impl rule__InstantObsExpression__Group__3
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__2__Impl_in_rule__InstantObsExpression__Group__29219);
            rule__InstantObsExpression__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group__3_in_rule__InstantObsExpression__Group__29222);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4518:1: rule__InstantObsExpression__Group__2__Impl : ( ( rule__InstantObsExpression__Group_2__0 )? ) ;
    public final void rule__InstantObsExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4522:1: ( ( ( rule__InstantObsExpression__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4523:1: ( ( rule__InstantObsExpression__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4523:1: ( ( rule__InstantObsExpression__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4524:1: ( rule__InstantObsExpression__Group_2__0 )?
            {
             before(grammarAccess.getInstantObsExpressionAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4525:1: ( rule__InstantObsExpression__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==41) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4525:2: rule__InstantObsExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__0_in_rule__InstantObsExpression__Group__2__Impl9249);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4535:1: rule__InstantObsExpression__Group__3 : rule__InstantObsExpression__Group__3__Impl ;
    public final void rule__InstantObsExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4539:1: ( rule__InstantObsExpression__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4540:2: rule__InstantObsExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__3__Impl_in_rule__InstantObsExpression__Group__39280);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4546:1: rule__InstantObsExpression__Group__3__Impl : ( ( rule__InstantObsExpression__Group_3__0 )? ) ;
    public final void rule__InstantObsExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4550:1: ( ( ( rule__InstantObsExpression__Group_3__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4551:1: ( ( rule__InstantObsExpression__Group_3__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4551:1: ( ( rule__InstantObsExpression__Group_3__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4552:1: ( rule__InstantObsExpression__Group_3__0 )?
            {
             before(grammarAccess.getInstantObsExpressionAccess().getGroup_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4553:1: ( rule__InstantObsExpression__Group_3__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==50) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4553:2: rule__InstantObsExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__0_in_rule__InstantObsExpression__Group__3__Impl9307);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4571:1: rule__InstantObsExpression__Group_2__0 : rule__InstantObsExpression__Group_2__0__Impl rule__InstantObsExpression__Group_2__1 ;
    public final void rule__InstantObsExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4575:1: ( rule__InstantObsExpression__Group_2__0__Impl rule__InstantObsExpression__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4576:2: rule__InstantObsExpression__Group_2__0__Impl rule__InstantObsExpression__Group_2__1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__0__Impl_in_rule__InstantObsExpression__Group_2__09346);
            rule__InstantObsExpression__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__1_in_rule__InstantObsExpression__Group_2__09349);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4583:1: rule__InstantObsExpression__Group_2__0__Impl : ( '(' ) ;
    public final void rule__InstantObsExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4587:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4588:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4588:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4589:1: '('
            {
             before(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,41,FOLLOW_41_in_rule__InstantObsExpression__Group_2__0__Impl9377); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4602:1: rule__InstantObsExpression__Group_2__1 : rule__InstantObsExpression__Group_2__1__Impl rule__InstantObsExpression__Group_2__2 ;
    public final void rule__InstantObsExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4606:1: ( rule__InstantObsExpression__Group_2__1__Impl rule__InstantObsExpression__Group_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4607:2: rule__InstantObsExpression__Group_2__1__Impl rule__InstantObsExpression__Group_2__2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__1__Impl_in_rule__InstantObsExpression__Group_2__19408);
            rule__InstantObsExpression__Group_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__2_in_rule__InstantObsExpression__Group_2__19411);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4614:1: rule__InstantObsExpression__Group_2__1__Impl : ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) ) ;
    public final void rule__InstantObsExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4618:1: ( ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4619:1: ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4619:1: ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4620:1: ( rule__InstantObsExpression__IndexAssignment_2_1 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIndexAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4621:1: ( rule__InstantObsExpression__IndexAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4621:2: rule__InstantObsExpression__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__IndexAssignment_2_1_in_rule__InstantObsExpression__Group_2__1__Impl9438);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4631:1: rule__InstantObsExpression__Group_2__2 : rule__InstantObsExpression__Group_2__2__Impl ;
    public final void rule__InstantObsExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4635:1: ( rule__InstantObsExpression__Group_2__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4636:2: rule__InstantObsExpression__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__2__Impl_in_rule__InstantObsExpression__Group_2__29468);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4642:1: rule__InstantObsExpression__Group_2__2__Impl : ( ')' ) ;
    public final void rule__InstantObsExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4646:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4647:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4647:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4648:1: ')'
            {
             before(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_2_2()); 
            match(input,42,FOLLOW_42_in_rule__InstantObsExpression__Group_2__2__Impl9496); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4667:1: rule__InstantObsExpression__Group_3__0 : rule__InstantObsExpression__Group_3__0__Impl rule__InstantObsExpression__Group_3__1 ;
    public final void rule__InstantObsExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4671:1: ( rule__InstantObsExpression__Group_3__0__Impl rule__InstantObsExpression__Group_3__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4672:2: rule__InstantObsExpression__Group_3__0__Impl rule__InstantObsExpression__Group_3__1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__0__Impl_in_rule__InstantObsExpression__Group_3__09533);
            rule__InstantObsExpression__Group_3__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__1_in_rule__InstantObsExpression__Group_3__09536);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4679:1: rule__InstantObsExpression__Group_3__0__Impl : ( 'when' ) ;
    public final void rule__InstantObsExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4683:1: ( ( 'when' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4684:1: ( 'when' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4684:1: ( 'when' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4685:1: 'when'
            {
             before(grammarAccess.getInstantObsExpressionAccess().getWhenKeyword_3_0()); 
            match(input,50,FOLLOW_50_in_rule__InstantObsExpression__Group_3__0__Impl9564); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4698:1: rule__InstantObsExpression__Group_3__1 : rule__InstantObsExpression__Group_3__1__Impl rule__InstantObsExpression__Group_3__2 ;
    public final void rule__InstantObsExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4702:1: ( rule__InstantObsExpression__Group_3__1__Impl rule__InstantObsExpression__Group_3__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4703:2: rule__InstantObsExpression__Group_3__1__Impl rule__InstantObsExpression__Group_3__2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__1__Impl_in_rule__InstantObsExpression__Group_3__19595);
            rule__InstantObsExpression__Group_3__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__2_in_rule__InstantObsExpression__Group_3__19598);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4710:1: rule__InstantObsExpression__Group_3__1__Impl : ( '(' ) ;
    public final void rule__InstantObsExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4714:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4715:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4715:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4716:1: '('
            {
             before(grammarAccess.getInstantObsExpressionAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,41,FOLLOW_41_in_rule__InstantObsExpression__Group_3__1__Impl9626); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4729:1: rule__InstantObsExpression__Group_3__2 : rule__InstantObsExpression__Group_3__2__Impl rule__InstantObsExpression__Group_3__3 ;
    public final void rule__InstantObsExpression__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4733:1: ( rule__InstantObsExpression__Group_3__2__Impl rule__InstantObsExpression__Group_3__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4734:2: rule__InstantObsExpression__Group_3__2__Impl rule__InstantObsExpression__Group_3__3
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__2__Impl_in_rule__InstantObsExpression__Group_3__29657);
            rule__InstantObsExpression__Group_3__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__3_in_rule__InstantObsExpression__Group_3__29660);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4741:1: rule__InstantObsExpression__Group_3__2__Impl : ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) ) ;
    public final void rule__InstantObsExpression__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4745:1: ( ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4746:1: ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4746:1: ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4747:1: ( rule__InstantObsExpression__ConditionAssignment_3_2 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getConditionAssignment_3_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4748:1: ( rule__InstantObsExpression__ConditionAssignment_3_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4748:2: rule__InstantObsExpression__ConditionAssignment_3_2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__ConditionAssignment_3_2_in_rule__InstantObsExpression__Group_3__2__Impl9687);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4758:1: rule__InstantObsExpression__Group_3__3 : rule__InstantObsExpression__Group_3__3__Impl ;
    public final void rule__InstantObsExpression__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4762:1: ( rule__InstantObsExpression__Group_3__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4763:2: rule__InstantObsExpression__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__3__Impl_in_rule__InstantObsExpression__Group_3__39717);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4769:1: rule__InstantObsExpression__Group_3__3__Impl : ( ')' ) ;
    public final void rule__InstantObsExpression__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4773:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4774:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4774:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4775:1: ')'
            {
             before(grammarAccess.getInstantObsExpressionAccess().getRightParenthesisKeyword_3_3()); 
            match(input,42,FOLLOW_42_in_rule__InstantObsExpression__Group_3__3__Impl9745); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4796:1: rule__InstantObsName__Group__0 : rule__InstantObsName__Group__0__Impl rule__InstantObsName__Group__1 ;
    public final void rule__InstantObsName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4800:1: ( rule__InstantObsName__Group__0__Impl rule__InstantObsName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4801:2: rule__InstantObsName__Group__0__Impl rule__InstantObsName__Group__1
            {
            pushFollow(FOLLOW_rule__InstantObsName__Group__0__Impl_in_rule__InstantObsName__Group__09784);
            rule__InstantObsName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__InstantObsName__Group__1_in_rule__InstantObsName__Group__09787);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4808:1: rule__InstantObsName__Group__0__Impl : ( ( rule__InstantObsName__PathAssignment_0 )? ) ;
    public final void rule__InstantObsName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4812:1: ( ( ( rule__InstantObsName__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4813:1: ( ( rule__InstantObsName__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4813:1: ( ( rule__InstantObsName__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4814:1: ( rule__InstantObsName__PathAssignment_0 )?
            {
             before(grammarAccess.getInstantObsNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4815:1: ( rule__InstantObsName__PathAssignment_0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==43) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4815:2: rule__InstantObsName__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__InstantObsName__PathAssignment_0_in_rule__InstantObsName__Group__0__Impl9814);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4825:1: rule__InstantObsName__Group__1 : rule__InstantObsName__Group__1__Impl ;
    public final void rule__InstantObsName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4829:1: ( rule__InstantObsName__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4830:2: rule__InstantObsName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsName__Group__1__Impl_in_rule__InstantObsName__Group__19845);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4836:1: rule__InstantObsName__Group__1__Impl : ( ( rule__InstantObsName__InstantIdAssignment_1 ) ) ;
    public final void rule__InstantObsName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4840:1: ( ( ( rule__InstantObsName__InstantIdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4841:1: ( ( rule__InstantObsName__InstantIdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4841:1: ( ( rule__InstantObsName__InstantIdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4842:1: ( rule__InstantObsName__InstantIdAssignment_1 )
            {
             before(grammarAccess.getInstantObsNameAccess().getInstantIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4843:1: ( rule__InstantObsName__InstantIdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4843:2: rule__InstantObsName__InstantIdAssignment_1
            {
            pushFollow(FOLLOW_rule__InstantObsName__InstantIdAssignment_1_in_rule__InstantObsName__Group__1__Impl9872);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4857:1: rule__DurationObsExpression__Group__0 : rule__DurationObsExpression__Group__0__Impl rule__DurationObsExpression__Group__1 ;
    public final void rule__DurationObsExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4861:1: ( rule__DurationObsExpression__Group__0__Impl rule__DurationObsExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4862:2: rule__DurationObsExpression__Group__0__Impl rule__DurationObsExpression__Group__1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__0__Impl_in_rule__DurationObsExpression__Group__09906);
            rule__DurationObsExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group__1_in_rule__DurationObsExpression__Group__09909);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4869:1: rule__DurationObsExpression__Group__0__Impl : ( '&' ) ;
    public final void rule__DurationObsExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4873:1: ( ( '&' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4874:1: ( '&' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4874:1: ( '&' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4875:1: '&'
            {
             before(grammarAccess.getDurationObsExpressionAccess().getAmpersandKeyword_0()); 
            match(input,51,FOLLOW_51_in_rule__DurationObsExpression__Group__0__Impl9937); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4888:1: rule__DurationObsExpression__Group__1 : rule__DurationObsExpression__Group__1__Impl rule__DurationObsExpression__Group__2 ;
    public final void rule__DurationObsExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4892:1: ( rule__DurationObsExpression__Group__1__Impl rule__DurationObsExpression__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4893:2: rule__DurationObsExpression__Group__1__Impl rule__DurationObsExpression__Group__2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__1__Impl_in_rule__DurationObsExpression__Group__19968);
            rule__DurationObsExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group__2_in_rule__DurationObsExpression__Group__19971);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4900:1: rule__DurationObsExpression__Group__1__Impl : ( ( rule__DurationObsExpression__IdAssignment_1 ) ) ;
    public final void rule__DurationObsExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4904:1: ( ( ( rule__DurationObsExpression__IdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4905:1: ( ( rule__DurationObsExpression__IdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4905:1: ( ( rule__DurationObsExpression__IdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4906:1: ( rule__DurationObsExpression__IdAssignment_1 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4907:1: ( rule__DurationObsExpression__IdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4907:2: rule__DurationObsExpression__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__IdAssignment_1_in_rule__DurationObsExpression__Group__1__Impl9998);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4917:1: rule__DurationObsExpression__Group__2 : rule__DurationObsExpression__Group__2__Impl rule__DurationObsExpression__Group__3 ;
    public final void rule__DurationObsExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4921:1: ( rule__DurationObsExpression__Group__2__Impl rule__DurationObsExpression__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4922:2: rule__DurationObsExpression__Group__2__Impl rule__DurationObsExpression__Group__3
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__2__Impl_in_rule__DurationObsExpression__Group__210028);
            rule__DurationObsExpression__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group__3_in_rule__DurationObsExpression__Group__210031);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4929:1: rule__DurationObsExpression__Group__2__Impl : ( ( rule__DurationObsExpression__Group_2__0 )? ) ;
    public final void rule__DurationObsExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4933:1: ( ( ( rule__DurationObsExpression__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4934:1: ( ( rule__DurationObsExpression__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4934:1: ( ( rule__DurationObsExpression__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4935:1: ( rule__DurationObsExpression__Group_2__0 )?
            {
             before(grammarAccess.getDurationObsExpressionAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4936:1: ( rule__DurationObsExpression__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==41) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4936:2: rule__DurationObsExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__0_in_rule__DurationObsExpression__Group__2__Impl10058);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4946:1: rule__DurationObsExpression__Group__3 : rule__DurationObsExpression__Group__3__Impl ;
    public final void rule__DurationObsExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4950:1: ( rule__DurationObsExpression__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4951:2: rule__DurationObsExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__3__Impl_in_rule__DurationObsExpression__Group__310089);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4957:1: rule__DurationObsExpression__Group__3__Impl : ( ( rule__DurationObsExpression__Group_3__0 )? ) ;
    public final void rule__DurationObsExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4961:1: ( ( ( rule__DurationObsExpression__Group_3__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4962:1: ( ( rule__DurationObsExpression__Group_3__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4962:1: ( ( rule__DurationObsExpression__Group_3__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4963:1: ( rule__DurationObsExpression__Group_3__0 )?
            {
             before(grammarAccess.getDurationObsExpressionAccess().getGroup_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4964:1: ( rule__DurationObsExpression__Group_3__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==50) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4964:2: rule__DurationObsExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__0_in_rule__DurationObsExpression__Group__3__Impl10116);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4982:1: rule__DurationObsExpression__Group_2__0 : rule__DurationObsExpression__Group_2__0__Impl rule__DurationObsExpression__Group_2__1 ;
    public final void rule__DurationObsExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4986:1: ( rule__DurationObsExpression__Group_2__0__Impl rule__DurationObsExpression__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4987:2: rule__DurationObsExpression__Group_2__0__Impl rule__DurationObsExpression__Group_2__1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__0__Impl_in_rule__DurationObsExpression__Group_2__010155);
            rule__DurationObsExpression__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__1_in_rule__DurationObsExpression__Group_2__010158);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4994:1: rule__DurationObsExpression__Group_2__0__Impl : ( '(' ) ;
    public final void rule__DurationObsExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4998:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4999:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4999:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5000:1: '('
            {
             before(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,41,FOLLOW_41_in_rule__DurationObsExpression__Group_2__0__Impl10186); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5013:1: rule__DurationObsExpression__Group_2__1 : rule__DurationObsExpression__Group_2__1__Impl rule__DurationObsExpression__Group_2__2 ;
    public final void rule__DurationObsExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5017:1: ( rule__DurationObsExpression__Group_2__1__Impl rule__DurationObsExpression__Group_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5018:2: rule__DurationObsExpression__Group_2__1__Impl rule__DurationObsExpression__Group_2__2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__1__Impl_in_rule__DurationObsExpression__Group_2__110217);
            rule__DurationObsExpression__Group_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__2_in_rule__DurationObsExpression__Group_2__110220);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5025:1: rule__DurationObsExpression__Group_2__1__Impl : ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) ) ;
    public final void rule__DurationObsExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5029:1: ( ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5030:1: ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5030:1: ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5031:1: ( rule__DurationObsExpression__IndexAssignment_2_1 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIndexAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5032:1: ( rule__DurationObsExpression__IndexAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5032:2: rule__DurationObsExpression__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__IndexAssignment_2_1_in_rule__DurationObsExpression__Group_2__1__Impl10247);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5042:1: rule__DurationObsExpression__Group_2__2 : rule__DurationObsExpression__Group_2__2__Impl ;
    public final void rule__DurationObsExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5046:1: ( rule__DurationObsExpression__Group_2__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5047:2: rule__DurationObsExpression__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__2__Impl_in_rule__DurationObsExpression__Group_2__210277);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5053:1: rule__DurationObsExpression__Group_2__2__Impl : ( ')' ) ;
    public final void rule__DurationObsExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5057:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5058:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5058:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5059:1: ')'
            {
             before(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_2_2()); 
            match(input,42,FOLLOW_42_in_rule__DurationObsExpression__Group_2__2__Impl10305); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5078:1: rule__DurationObsExpression__Group_3__0 : rule__DurationObsExpression__Group_3__0__Impl rule__DurationObsExpression__Group_3__1 ;
    public final void rule__DurationObsExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5082:1: ( rule__DurationObsExpression__Group_3__0__Impl rule__DurationObsExpression__Group_3__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5083:2: rule__DurationObsExpression__Group_3__0__Impl rule__DurationObsExpression__Group_3__1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__0__Impl_in_rule__DurationObsExpression__Group_3__010342);
            rule__DurationObsExpression__Group_3__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__1_in_rule__DurationObsExpression__Group_3__010345);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5090:1: rule__DurationObsExpression__Group_3__0__Impl : ( 'when' ) ;
    public final void rule__DurationObsExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5094:1: ( ( 'when' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5095:1: ( 'when' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5095:1: ( 'when' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5096:1: 'when'
            {
             before(grammarAccess.getDurationObsExpressionAccess().getWhenKeyword_3_0()); 
            match(input,50,FOLLOW_50_in_rule__DurationObsExpression__Group_3__0__Impl10373); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5109:1: rule__DurationObsExpression__Group_3__1 : rule__DurationObsExpression__Group_3__1__Impl rule__DurationObsExpression__Group_3__2 ;
    public final void rule__DurationObsExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5113:1: ( rule__DurationObsExpression__Group_3__1__Impl rule__DurationObsExpression__Group_3__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5114:2: rule__DurationObsExpression__Group_3__1__Impl rule__DurationObsExpression__Group_3__2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__1__Impl_in_rule__DurationObsExpression__Group_3__110404);
            rule__DurationObsExpression__Group_3__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__2_in_rule__DurationObsExpression__Group_3__110407);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5121:1: rule__DurationObsExpression__Group_3__1__Impl : ( '(' ) ;
    public final void rule__DurationObsExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5125:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5126:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5126:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5127:1: '('
            {
             before(grammarAccess.getDurationObsExpressionAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,41,FOLLOW_41_in_rule__DurationObsExpression__Group_3__1__Impl10435); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5140:1: rule__DurationObsExpression__Group_3__2 : rule__DurationObsExpression__Group_3__2__Impl rule__DurationObsExpression__Group_3__3 ;
    public final void rule__DurationObsExpression__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5144:1: ( rule__DurationObsExpression__Group_3__2__Impl rule__DurationObsExpression__Group_3__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5145:2: rule__DurationObsExpression__Group_3__2__Impl rule__DurationObsExpression__Group_3__3
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__2__Impl_in_rule__DurationObsExpression__Group_3__210466);
            rule__DurationObsExpression__Group_3__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__3_in_rule__DurationObsExpression__Group_3__210469);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5152:1: rule__DurationObsExpression__Group_3__2__Impl : ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) ) ;
    public final void rule__DurationObsExpression__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5156:1: ( ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5157:1: ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5157:1: ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5158:1: ( rule__DurationObsExpression__ConditionAssignment_3_2 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getConditionAssignment_3_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5159:1: ( rule__DurationObsExpression__ConditionAssignment_3_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5159:2: rule__DurationObsExpression__ConditionAssignment_3_2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__ConditionAssignment_3_2_in_rule__DurationObsExpression__Group_3__2__Impl10496);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5169:1: rule__DurationObsExpression__Group_3__3 : rule__DurationObsExpression__Group_3__3__Impl ;
    public final void rule__DurationObsExpression__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5173:1: ( rule__DurationObsExpression__Group_3__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5174:2: rule__DurationObsExpression__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__3__Impl_in_rule__DurationObsExpression__Group_3__310526);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5180:1: rule__DurationObsExpression__Group_3__3__Impl : ( ')' ) ;
    public final void rule__DurationObsExpression__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5184:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5185:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5185:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5186:1: ')'
            {
             before(grammarAccess.getDurationObsExpressionAccess().getRightParenthesisKeyword_3_3()); 
            match(input,42,FOLLOW_42_in_rule__DurationObsExpression__Group_3__3__Impl10554); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5207:1: rule__DurationObsName__Group__0 : rule__DurationObsName__Group__0__Impl rule__DurationObsName__Group__1 ;
    public final void rule__DurationObsName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5211:1: ( rule__DurationObsName__Group__0__Impl rule__DurationObsName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5212:2: rule__DurationObsName__Group__0__Impl rule__DurationObsName__Group__1
            {
            pushFollow(FOLLOW_rule__DurationObsName__Group__0__Impl_in_rule__DurationObsName__Group__010593);
            rule__DurationObsName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DurationObsName__Group__1_in_rule__DurationObsName__Group__010596);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5219:1: rule__DurationObsName__Group__0__Impl : ( ( rule__DurationObsName__PathAssignment_0 )? ) ;
    public final void rule__DurationObsName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5223:1: ( ( ( rule__DurationObsName__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5224:1: ( ( rule__DurationObsName__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5224:1: ( ( rule__DurationObsName__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5225:1: ( rule__DurationObsName__PathAssignment_0 )?
            {
             before(grammarAccess.getDurationObsNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5226:1: ( rule__DurationObsName__PathAssignment_0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==43) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5226:2: rule__DurationObsName__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DurationObsName__PathAssignment_0_in_rule__DurationObsName__Group__0__Impl10623);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5236:1: rule__DurationObsName__Group__1 : rule__DurationObsName__Group__1__Impl ;
    public final void rule__DurationObsName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5240:1: ( rule__DurationObsName__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5241:2: rule__DurationObsName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsName__Group__1__Impl_in_rule__DurationObsName__Group__110654);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5247:1: rule__DurationObsName__Group__1__Impl : ( ( rule__DurationObsName__DurationIdAssignment_1 ) ) ;
    public final void rule__DurationObsName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5251:1: ( ( ( rule__DurationObsName__DurationIdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5252:1: ( ( rule__DurationObsName__DurationIdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5252:1: ( ( rule__DurationObsName__DurationIdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5253:1: ( rule__DurationObsName__DurationIdAssignment_1 )
            {
             before(grammarAccess.getDurationObsNameAccess().getDurationIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5254:1: ( rule__DurationObsName__DurationIdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5254:2: rule__DurationObsName__DurationIdAssignment_1
            {
            pushFollow(FOLLOW_rule__DurationObsName__DurationIdAssignment_1_in_rule__DurationObsName__Group__1__Impl10681);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5268:1: rule__JitterExp__Group__0 : rule__JitterExp__Group__0__Impl rule__JitterExp__Group__1 ;
    public final void rule__JitterExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5272:1: ( rule__JitterExp__Group__0__Impl rule__JitterExp__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5273:2: rule__JitterExp__Group__0__Impl rule__JitterExp__Group__1
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__0__Impl_in_rule__JitterExp__Group__010715);
            rule__JitterExp__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group__1_in_rule__JitterExp__Group__010718);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5280:1: rule__JitterExp__Group__0__Impl : ( 'jitter(' ) ;
    public final void rule__JitterExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5284:1: ( ( 'jitter(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5285:1: ( 'jitter(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5285:1: ( 'jitter(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5286:1: 'jitter('
            {
             before(grammarAccess.getJitterExpAccess().getJitterKeyword_0()); 
            match(input,52,FOLLOW_52_in_rule__JitterExp__Group__0__Impl10746); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5299:1: rule__JitterExp__Group__1 : rule__JitterExp__Group__1__Impl rule__JitterExp__Group__2 ;
    public final void rule__JitterExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5303:1: ( rule__JitterExp__Group__1__Impl rule__JitterExp__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5304:2: rule__JitterExp__Group__1__Impl rule__JitterExp__Group__2
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__1__Impl_in_rule__JitterExp__Group__110777);
            rule__JitterExp__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group__2_in_rule__JitterExp__Group__110780);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5311:1: rule__JitterExp__Group__1__Impl : ( ( rule__JitterExp__FirstInstantAssignment_1 ) ) ;
    public final void rule__JitterExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5315:1: ( ( ( rule__JitterExp__FirstInstantAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5316:1: ( ( rule__JitterExp__FirstInstantAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5316:1: ( ( rule__JitterExp__FirstInstantAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5317:1: ( rule__JitterExp__FirstInstantAssignment_1 )
            {
             before(grammarAccess.getJitterExpAccess().getFirstInstantAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5318:1: ( rule__JitterExp__FirstInstantAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5318:2: rule__JitterExp__FirstInstantAssignment_1
            {
            pushFollow(FOLLOW_rule__JitterExp__FirstInstantAssignment_1_in_rule__JitterExp__Group__1__Impl10807);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5328:1: rule__JitterExp__Group__2 : rule__JitterExp__Group__2__Impl rule__JitterExp__Group__3 ;
    public final void rule__JitterExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5332:1: ( rule__JitterExp__Group__2__Impl rule__JitterExp__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5333:2: rule__JitterExp__Group__2__Impl rule__JitterExp__Group__3
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__2__Impl_in_rule__JitterExp__Group__210837);
            rule__JitterExp__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group__3_in_rule__JitterExp__Group__210840);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5340:1: rule__JitterExp__Group__2__Impl : ( ( rule__JitterExp__Group_2__0 )? ) ;
    public final void rule__JitterExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5344:1: ( ( ( rule__JitterExp__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5345:1: ( ( rule__JitterExp__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5345:1: ( ( rule__JitterExp__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5346:1: ( rule__JitterExp__Group_2__0 )?
            {
             before(grammarAccess.getJitterExpAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5347:1: ( rule__JitterExp__Group_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==26) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5347:2: rule__JitterExp__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__JitterExp__Group_2__0_in_rule__JitterExp__Group__2__Impl10867);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5357:1: rule__JitterExp__Group__3 : rule__JitterExp__Group__3__Impl ;
    public final void rule__JitterExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5361:1: ( rule__JitterExp__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5362:2: rule__JitterExp__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__3__Impl_in_rule__JitterExp__Group__310898);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5368:1: rule__JitterExp__Group__3__Impl : ( ')' ) ;
    public final void rule__JitterExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5372:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5373:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5373:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5374:1: ')'
            {
             before(grammarAccess.getJitterExpAccess().getRightParenthesisKeyword_3()); 
            match(input,42,FOLLOW_42_in_rule__JitterExp__Group__3__Impl10926); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5395:1: rule__JitterExp__Group_2__0 : rule__JitterExp__Group_2__0__Impl rule__JitterExp__Group_2__1 ;
    public final void rule__JitterExp__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5399:1: ( rule__JitterExp__Group_2__0__Impl rule__JitterExp__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5400:2: rule__JitterExp__Group_2__0__Impl rule__JitterExp__Group_2__1
            {
            pushFollow(FOLLOW_rule__JitterExp__Group_2__0__Impl_in_rule__JitterExp__Group_2__010965);
            rule__JitterExp__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group_2__1_in_rule__JitterExp__Group_2__010968);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5407:1: rule__JitterExp__Group_2__0__Impl : ( '-' ) ;
    public final void rule__JitterExp__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5411:1: ( ( '-' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5412:1: ( '-' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5412:1: ( '-' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5413:1: '-'
            {
             before(grammarAccess.getJitterExpAccess().getHyphenMinusKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__JitterExp__Group_2__0__Impl10996); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5426:1: rule__JitterExp__Group_2__1 : rule__JitterExp__Group_2__1__Impl ;
    public final void rule__JitterExp__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5430:1: ( rule__JitterExp__Group_2__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5431:2: rule__JitterExp__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__JitterExp__Group_2__1__Impl_in_rule__JitterExp__Group_2__111027);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5437:1: rule__JitterExp__Group_2__1__Impl : ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) ) ;
    public final void rule__JitterExp__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5441:1: ( ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5442:1: ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5442:1: ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5443:1: ( rule__JitterExp__SecondInstantAssignment_2_1 )
            {
             before(grammarAccess.getJitterExpAccess().getSecondInstantAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5444:1: ( rule__JitterExp__SecondInstantAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5444:2: rule__JitterExp__SecondInstantAssignment_2_1
            {
            pushFollow(FOLLOW_rule__JitterExp__SecondInstantAssignment_2_1_in_rule__JitterExp__Group_2__1__Impl11054);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5458:1: rule__VariableDeclaration__Group__0 : rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 ;
    public final void rule__VariableDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5462:1: ( rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5463:2: rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__0__Impl_in_rule__VariableDeclaration__Group__011088);
            rule__VariableDeclaration__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group__1_in_rule__VariableDeclaration__Group__011091);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5470:1: rule__VariableDeclaration__Group__0__Impl : ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? ) ;
    public final void rule__VariableDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5474:1: ( ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5475:1: ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5475:1: ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5476:1: ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )?
            {
             before(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5477:1: ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=33 && LA40_0<=35)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5477:2: rule__VariableDeclaration__VariableDeclarationAssignment_0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__VariableDeclarationAssignment_0_in_rule__VariableDeclaration__Group__0__Impl11118);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5487:1: rule__VariableDeclaration__Group__1 : rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2 ;
    public final void rule__VariableDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5491:1: ( rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5492:2: rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__1__Impl_in_rule__VariableDeclaration__Group__111149);
            rule__VariableDeclaration__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group__2_in_rule__VariableDeclaration__Group__111152);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5499:1: rule__VariableDeclaration__Group__1__Impl : ( '$' ) ;
    public final void rule__VariableDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5503:1: ( ( '$' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5504:1: ( '$' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5504:1: ( '$' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5505:1: '$'
            {
             before(grammarAccess.getVariableDeclarationAccess().getDollarSignKeyword_1()); 
            match(input,53,FOLLOW_53_in_rule__VariableDeclaration__Group__1__Impl11180); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5518:1: rule__VariableDeclaration__Group__2 : rule__VariableDeclaration__Group__2__Impl rule__VariableDeclaration__Group__3 ;
    public final void rule__VariableDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5522:1: ( rule__VariableDeclaration__Group__2__Impl rule__VariableDeclaration__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5523:2: rule__VariableDeclaration__Group__2__Impl rule__VariableDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__2__Impl_in_rule__VariableDeclaration__Group__211211);
            rule__VariableDeclaration__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group__3_in_rule__VariableDeclaration__Group__211214);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5530:1: rule__VariableDeclaration__Group__2__Impl : ( ( rule__VariableDeclaration__NameAssignment_2 ) ) ;
    public final void rule__VariableDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5534:1: ( ( ( rule__VariableDeclaration__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5535:1: ( ( rule__VariableDeclaration__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5535:1: ( ( rule__VariableDeclaration__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5536:1: ( rule__VariableDeclaration__NameAssignment_2 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5537:1: ( rule__VariableDeclaration__NameAssignment_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5537:2: rule__VariableDeclaration__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__NameAssignment_2_in_rule__VariableDeclaration__Group__2__Impl11241);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5547:1: rule__VariableDeclaration__Group__3 : rule__VariableDeclaration__Group__3__Impl ;
    public final void rule__VariableDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5551:1: ( rule__VariableDeclaration__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5552:2: rule__VariableDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__3__Impl_in_rule__VariableDeclaration__Group__311271);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5558:1: rule__VariableDeclaration__Group__3__Impl : ( ( rule__VariableDeclaration__Alternatives_3 ) ) ;
    public final void rule__VariableDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5562:1: ( ( ( rule__VariableDeclaration__Alternatives_3 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5563:1: ( ( rule__VariableDeclaration__Alternatives_3 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5563:1: ( ( rule__VariableDeclaration__Alternatives_3 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5564:1: ( rule__VariableDeclaration__Alternatives_3 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getAlternatives_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5565:1: ( rule__VariableDeclaration__Alternatives_3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5565:2: rule__VariableDeclaration__Alternatives_3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Alternatives_3_in_rule__VariableDeclaration__Group__3__Impl11298);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5583:1: rule__VariableDeclaration__Group_3_0__0 : rule__VariableDeclaration__Group_3_0__0__Impl rule__VariableDeclaration__Group_3_0__1 ;
    public final void rule__VariableDeclaration__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5587:1: ( rule__VariableDeclaration__Group_3_0__0__Impl rule__VariableDeclaration__Group_3_0__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5588:2: rule__VariableDeclaration__Group_3_0__0__Impl rule__VariableDeclaration__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__0__Impl_in_rule__VariableDeclaration__Group_3_0__011336);
            rule__VariableDeclaration__Group_3_0__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__1_in_rule__VariableDeclaration__Group_3_0__011339);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5595:1: rule__VariableDeclaration__Group_3_0__0__Impl : ( ':' ) ;
    public final void rule__VariableDeclaration__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5599:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5600:1: ( ':' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5600:1: ( ':' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5601:1: ':'
            {
             before(grammarAccess.getVariableDeclarationAccess().getColonKeyword_3_0_0()); 
            match(input,39,FOLLOW_39_in_rule__VariableDeclaration__Group_3_0__0__Impl11367); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5614:1: rule__VariableDeclaration__Group_3_0__1 : rule__VariableDeclaration__Group_3_0__1__Impl rule__VariableDeclaration__Group_3_0__2 ;
    public final void rule__VariableDeclaration__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5618:1: ( rule__VariableDeclaration__Group_3_0__1__Impl rule__VariableDeclaration__Group_3_0__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5619:2: rule__VariableDeclaration__Group_3_0__1__Impl rule__VariableDeclaration__Group_3_0__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__1__Impl_in_rule__VariableDeclaration__Group_3_0__111398);
            rule__VariableDeclaration__Group_3_0__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__2_in_rule__VariableDeclaration__Group_3_0__111401);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5626:1: rule__VariableDeclaration__Group_3_0__1__Impl : ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) ) ;
    public final void rule__VariableDeclaration__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5630:1: ( ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5631:1: ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5631:1: ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5632:1: ( rule__VariableDeclaration__TypeAssignment_3_0_1 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_3_0_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5633:1: ( rule__VariableDeclaration__TypeAssignment_3_0_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5633:2: rule__VariableDeclaration__TypeAssignment_3_0_1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__TypeAssignment_3_0_1_in_rule__VariableDeclaration__Group_3_0__1__Impl11428);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5643:1: rule__VariableDeclaration__Group_3_0__2 : rule__VariableDeclaration__Group_3_0__2__Impl ;
    public final void rule__VariableDeclaration__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5647:1: ( rule__VariableDeclaration__Group_3_0__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5648:2: rule__VariableDeclaration__Group_3_0__2__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__2__Impl_in_rule__VariableDeclaration__Group_3_0__211458);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5654:1: rule__VariableDeclaration__Group_3_0__2__Impl : ( ( rule__VariableDeclaration__Group_3_0_2__0 )? ) ;
    public final void rule__VariableDeclaration__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5658:1: ( ( ( rule__VariableDeclaration__Group_3_0_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5659:1: ( ( rule__VariableDeclaration__Group_3_0_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5659:1: ( ( rule__VariableDeclaration__Group_3_0_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5660:1: ( rule__VariableDeclaration__Group_3_0_2__0 )?
            {
             before(grammarAccess.getVariableDeclarationAccess().getGroup_3_0_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5661:1: ( rule__VariableDeclaration__Group_3_0_2__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==48) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5661:2: rule__VariableDeclaration__Group_3_0_2__0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__0_in_rule__VariableDeclaration__Group_3_0__2__Impl11485);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5677:1: rule__VariableDeclaration__Group_3_0_2__0 : rule__VariableDeclaration__Group_3_0_2__0__Impl rule__VariableDeclaration__Group_3_0_2__1 ;
    public final void rule__VariableDeclaration__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5681:1: ( rule__VariableDeclaration__Group_3_0_2__0__Impl rule__VariableDeclaration__Group_3_0_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5682:2: rule__VariableDeclaration__Group_3_0_2__0__Impl rule__VariableDeclaration__Group_3_0_2__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__0__Impl_in_rule__VariableDeclaration__Group_3_0_2__011522);
            rule__VariableDeclaration__Group_3_0_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__1_in_rule__VariableDeclaration__Group_3_0_2__011525);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5689:1: rule__VariableDeclaration__Group_3_0_2__0__Impl : ( '=' ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5693:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5694:1: ( '=' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5694:1: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5695:1: '='
            {
             before(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0_2_0()); 
            match(input,48,FOLLOW_48_in_rule__VariableDeclaration__Group_3_0_2__0__Impl11553); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5708:1: rule__VariableDeclaration__Group_3_0_2__1 : rule__VariableDeclaration__Group_3_0_2__1__Impl rule__VariableDeclaration__Group_3_0_2__2 ;
    public final void rule__VariableDeclaration__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5712:1: ( rule__VariableDeclaration__Group_3_0_2__1__Impl rule__VariableDeclaration__Group_3_0_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5713:2: rule__VariableDeclaration__Group_3_0_2__1__Impl rule__VariableDeclaration__Group_3_0_2__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__1__Impl_in_rule__VariableDeclaration__Group_3_0_2__111584);
            rule__VariableDeclaration__Group_3_0_2__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__2_in_rule__VariableDeclaration__Group_3_0_2__111587);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5720:1: rule__VariableDeclaration__Group_3_0_2__1__Impl : ( '(' ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5724:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5725:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5725:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5726:1: '('
            {
             before(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_0_2_1()); 
            match(input,41,FOLLOW_41_in_rule__VariableDeclaration__Group_3_0_2__1__Impl11615); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5739:1: rule__VariableDeclaration__Group_3_0_2__2 : rule__VariableDeclaration__Group_3_0_2__2__Impl rule__VariableDeclaration__Group_3_0_2__3 ;
    public final void rule__VariableDeclaration__Group_3_0_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5743:1: ( rule__VariableDeclaration__Group_3_0_2__2__Impl rule__VariableDeclaration__Group_3_0_2__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5744:2: rule__VariableDeclaration__Group_3_0_2__2__Impl rule__VariableDeclaration__Group_3_0_2__3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__2__Impl_in_rule__VariableDeclaration__Group_3_0_2__211646);
            rule__VariableDeclaration__Group_3_0_2__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__3_in_rule__VariableDeclaration__Group_3_0_2__211649);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5751:1: rule__VariableDeclaration__Group_3_0_2__2__Impl : ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5755:1: ( ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5756:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5756:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5757:1: ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueAssignment_3_0_2_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5758:1: ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5758:2: rule__VariableDeclaration__InitValueAssignment_3_0_2_2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_0_2_2_in_rule__VariableDeclaration__Group_3_0_2__2__Impl11676);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5768:1: rule__VariableDeclaration__Group_3_0_2__3 : rule__VariableDeclaration__Group_3_0_2__3__Impl ;
    public final void rule__VariableDeclaration__Group_3_0_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5772:1: ( rule__VariableDeclaration__Group_3_0_2__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5773:2: rule__VariableDeclaration__Group_3_0_2__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__3__Impl_in_rule__VariableDeclaration__Group_3_0_2__311706);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5779:1: rule__VariableDeclaration__Group_3_0_2__3__Impl : ( ')' ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5783:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5784:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5784:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5785:1: ')'
            {
             before(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_0_2_3()); 
            match(input,42,FOLLOW_42_in_rule__VariableDeclaration__Group_3_0_2__3__Impl11734); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5806:1: rule__VariableDeclaration__Group_3_1__0 : rule__VariableDeclaration__Group_3_1__0__Impl rule__VariableDeclaration__Group_3_1__1 ;
    public final void rule__VariableDeclaration__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5810:1: ( rule__VariableDeclaration__Group_3_1__0__Impl rule__VariableDeclaration__Group_3_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5811:2: rule__VariableDeclaration__Group_3_1__0__Impl rule__VariableDeclaration__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__0__Impl_in_rule__VariableDeclaration__Group_3_1__011773);
            rule__VariableDeclaration__Group_3_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__1_in_rule__VariableDeclaration__Group_3_1__011776);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5818:1: rule__VariableDeclaration__Group_3_1__0__Impl : ( '=' ) ;
    public final void rule__VariableDeclaration__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5822:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5823:1: ( '=' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5823:1: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5824:1: '='
            {
             before(grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_1_0()); 
            match(input,48,FOLLOW_48_in_rule__VariableDeclaration__Group_3_1__0__Impl11804); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5837:1: rule__VariableDeclaration__Group_3_1__1 : rule__VariableDeclaration__Group_3_1__1__Impl rule__VariableDeclaration__Group_3_1__2 ;
    public final void rule__VariableDeclaration__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5841:1: ( rule__VariableDeclaration__Group_3_1__1__Impl rule__VariableDeclaration__Group_3_1__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5842:2: rule__VariableDeclaration__Group_3_1__1__Impl rule__VariableDeclaration__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__1__Impl_in_rule__VariableDeclaration__Group_3_1__111835);
            rule__VariableDeclaration__Group_3_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__2_in_rule__VariableDeclaration__Group_3_1__111838);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5849:1: rule__VariableDeclaration__Group_3_1__1__Impl : ( '(' ) ;
    public final void rule__VariableDeclaration__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5853:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5854:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5854:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5855:1: '('
            {
             before(grammarAccess.getVariableDeclarationAccess().getLeftParenthesisKeyword_3_1_1()); 
            match(input,41,FOLLOW_41_in_rule__VariableDeclaration__Group_3_1__1__Impl11866); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5868:1: rule__VariableDeclaration__Group_3_1__2 : rule__VariableDeclaration__Group_3_1__2__Impl rule__VariableDeclaration__Group_3_1__3 ;
    public final void rule__VariableDeclaration__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5872:1: ( rule__VariableDeclaration__Group_3_1__2__Impl rule__VariableDeclaration__Group_3_1__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5873:2: rule__VariableDeclaration__Group_3_1__2__Impl rule__VariableDeclaration__Group_3_1__3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__2__Impl_in_rule__VariableDeclaration__Group_3_1__211897);
            rule__VariableDeclaration__Group_3_1__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__3_in_rule__VariableDeclaration__Group_3_1__211900);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5880:1: rule__VariableDeclaration__Group_3_1__2__Impl : ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) ) ;
    public final void rule__VariableDeclaration__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5884:1: ( ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5885:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5885:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5886:1: ( rule__VariableDeclaration__InitValueAssignment_3_1_2 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueAssignment_3_1_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5887:1: ( rule__VariableDeclaration__InitValueAssignment_3_1_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5887:2: rule__VariableDeclaration__InitValueAssignment_3_1_2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_1_2_in_rule__VariableDeclaration__Group_3_1__2__Impl11927);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5897:1: rule__VariableDeclaration__Group_3_1__3 : rule__VariableDeclaration__Group_3_1__3__Impl ;
    public final void rule__VariableDeclaration__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5901:1: ( rule__VariableDeclaration__Group_3_1__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5902:2: rule__VariableDeclaration__Group_3_1__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__3__Impl_in_rule__VariableDeclaration__Group_3_1__311957);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5908:1: rule__VariableDeclaration__Group_3_1__3__Impl : ( ')' ) ;
    public final void rule__VariableDeclaration__Group_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5912:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5913:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5913:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5914:1: ')'
            {
             before(grammarAccess.getVariableDeclarationAccess().getRightParenthesisKeyword_3_1_3()); 
            match(input,42,FOLLOW_42_in_rule__VariableDeclaration__Group_3_1__3__Impl11985); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5935:1: rule__DataTypeName__Group__0 : rule__DataTypeName__Group__0__Impl rule__DataTypeName__Group__1 ;
    public final void rule__DataTypeName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5939:1: ( rule__DataTypeName__Group__0__Impl rule__DataTypeName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5940:2: rule__DataTypeName__Group__0__Impl rule__DataTypeName__Group__1
            {
            pushFollow(FOLLOW_rule__DataTypeName__Group__0__Impl_in_rule__DataTypeName__Group__012024);
            rule__DataTypeName__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__DataTypeName__Group__1_in_rule__DataTypeName__Group__012027);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5947:1: rule__DataTypeName__Group__0__Impl : ( ( rule__DataTypeName__PathAssignment_0 )? ) ;
    public final void rule__DataTypeName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5951:1: ( ( ( rule__DataTypeName__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5952:1: ( ( rule__DataTypeName__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5952:1: ( ( rule__DataTypeName__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5953:1: ( rule__DataTypeName__PathAssignment_0 )?
            {
             before(grammarAccess.getDataTypeNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5954:1: ( rule__DataTypeName__PathAssignment_0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==43) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5954:2: rule__DataTypeName__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DataTypeName__PathAssignment_0_in_rule__DataTypeName__Group__0__Impl12054);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5964:1: rule__DataTypeName__Group__1 : rule__DataTypeName__Group__1__Impl ;
    public final void rule__DataTypeName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5968:1: ( rule__DataTypeName__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5969:2: rule__DataTypeName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DataTypeName__Group__1__Impl_in_rule__DataTypeName__Group__112085);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5975:1: rule__DataTypeName__Group__1__Impl : ( ( rule__DataTypeName__TypeAssignment_1 ) ) ;
    public final void rule__DataTypeName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5979:1: ( ( ( rule__DataTypeName__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5980:1: ( ( rule__DataTypeName__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5980:1: ( ( rule__DataTypeName__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5981:1: ( rule__DataTypeName__TypeAssignment_1 )
            {
             before(grammarAccess.getDataTypeNameAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5982:1: ( rule__DataTypeName__TypeAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5982:2: rule__DataTypeName__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__DataTypeName__TypeAssignment_1_in_rule__DataTypeName__Group__1__Impl12112);
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


    // $ANTLR start rule__Model__ImportsAssignment_0
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5997:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6001:1: ( ( ruleImport ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6002:1: ( ruleImport )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6002:1: ( ruleImport )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6003:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_012151);
            ruleImport();
            _fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ImportsAssignment_0


    // $ANTLR start rule__Model__ContextAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6012:1: rule__Model__ContextAssignment_1 : ( ruleContext ) ;
    public final void rule__Model__ContextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6016:1: ( ( ruleContext ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6017:1: ( ruleContext )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6017:1: ( ruleContext )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6018:1: ruleContext
            {
             before(grammarAccess.getModelAccess().getContextContextParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleContext_in_rule__Model__ContextAssignment_112182);
            ruleContext();
            _fsp--;

             after(grammarAccess.getModelAccess().getContextContextParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ContextAssignment_1


    // $ANTLR start rule__Model__ValueAssignment_2_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6027:1: rule__Model__ValueAssignment_2_1 : ( ruleExpression ) ;
    public final void rule__Model__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6031:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6032:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6032:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6033:1: ruleExpression
            {
             before(grammarAccess.getModelAccess().getValueExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Model__ValueAssignment_2_112213);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getModelAccess().getValueExpressionParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ValueAssignment_2_1


    // $ANTLR start rule__Import__ImportURIAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6042:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6046:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6047:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6047:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6048:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_112244); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__ImportURIAssignment_1


    // $ANTLR start rule__Context__ContextAssignment_1
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6057:1: rule__Context__ContextAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Context__ContextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6061:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6062:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6062:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6063:1: ( RULE_ID )
            {
             before(grammarAccess.getContextAccess().getContextNamedElementCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6064:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6065:1: RULE_ID
            {
             before(grammarAccess.getContextAccess().getContextNamedElementIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Context__ContextAssignment_112279); 
             after(grammarAccess.getContextAccess().getContextNamedElementIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getContextAccess().getContextNamedElementCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Context__ContextAssignment_1


    // $ANTLR start rule__Expression__ExpAssignment
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6076:1: rule__Expression__ExpAssignment : ( ruleAndOrXorExpression ) ;
    public final void rule__Expression__ExpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6080:1: ( ( ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6081:1: ( ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6081:1: ( ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6082:1: ruleAndOrXorExpression
            {
             before(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_rule__Expression__ExpAssignment12314);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6091:1: rule__AndOrXorExpression__ExpAssignment_0 : ( ruleEqualityExpression ) ;
    public final void rule__AndOrXorExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6095:1: ( ( ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6096:1: ( ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6096:1: ( ruleEqualityExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6097:1: ruleEqualityExpression
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_012345);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6106:1: rule__AndOrXorExpression__OpAssignment_1_0 : ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__AndOrXorExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6110:1: ( ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6111:1: ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6111:1: ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6112:1: ( rule__AndOrXorExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6113:1: ( rule__AndOrXorExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6113:2: rule__AndOrXorExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__OpAlternatives_1_0_0_in_rule__AndOrXorExpression__OpAssignment_1_012376);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6122:1: rule__AndOrXorExpression__ExpAssignment_1_1 : ( ruleEqualityExpression ) ;
    public final void rule__AndOrXorExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6126:1: ( ( ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6127:1: ( ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6127:1: ( ruleEqualityExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6128:1: ruleEqualityExpression
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_1_112409);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6137:1: rule__EqualityExpression__ExpAssignment_0 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6141:1: ( ( ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6142:1: ( ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6142:1: ( ruleRelationalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6143:1: ruleRelationalExpression
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_012440);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6152:1: rule__EqualityExpression__OpAssignment_1_0 : ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__EqualityExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6156:1: ( ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6157:1: ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6157:1: ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6158:1: ( rule__EqualityExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6159:1: ( rule__EqualityExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6159:2: rule__EqualityExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__OpAlternatives_1_0_0_in_rule__EqualityExpression__OpAssignment_1_012471);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6168:1: rule__EqualityExpression__ExpAssignment_1_1 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6172:1: ( ( ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6173:1: ( ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6173:1: ( ruleRelationalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6174:1: ruleRelationalExpression
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_1_112504);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6183:1: rule__RelationalExpression__ExpAssignment_0 : ( ruleConditionalExpression ) ;
    public final void rule__RelationalExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6187:1: ( ( ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6188:1: ( ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6188:1: ( ruleConditionalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6189:1: ruleConditionalExpression
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_012535);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6198:1: rule__RelationalExpression__OpAssignment_1_0 : ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__RelationalExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6202:1: ( ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6203:1: ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6203:1: ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6204:1: ( rule__RelationalExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6205:1: ( rule__RelationalExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6205:2: rule__RelationalExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__OpAlternatives_1_0_0_in_rule__RelationalExpression__OpAssignment_1_012566);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6214:1: rule__RelationalExpression__ExpAssignment_1_1 : ( ruleConditionalExpression ) ;
    public final void rule__RelationalExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6218:1: ( ( ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6219:1: ( ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6219:1: ( ruleConditionalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6220:1: ruleConditionalExpression
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_1_112599);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6229:1: rule__ConditionalExpression__ExpAssignment_0 : ( ruleAdditiveExpression ) ;
    public final void rule__ConditionalExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6233:1: ( ( ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6234:1: ( ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6234:1: ( ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6235:1: ruleAdditiveExpression
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_012630);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6244:1: rule__ConditionalExpression__OpAssignment_1_0 : ( ( '?' ) ) ;
    public final void rule__ConditionalExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6248:1: ( ( ( '?' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6249:1: ( ( '?' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6249:1: ( ( '?' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6250:1: ( '?' )
            {
             before(grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6251:1: ( '?' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6252:1: '?'
            {
             before(grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0()); 
            match(input,54,FOLLOW_54_in_rule__ConditionalExpression__OpAssignment_1_012666); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6267:1: rule__ConditionalExpression__ExpAssignment_1_1 : ( ruleAdditiveExpression ) ;
    public final void rule__ConditionalExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6271:1: ( ( ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6272:1: ( ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6272:1: ( ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6273:1: ruleAdditiveExpression
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_112705);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6282:1: rule__ConditionalExpression__ExpAssignment_1_3 : ( ruleAdditiveExpression ) ;
    public final void rule__ConditionalExpression__ExpAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6286:1: ( ( ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6287:1: ( ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6287:1: ( ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6288:1: ruleAdditiveExpression
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_312736);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6297:1: rule__AdditiveExpression__ExpAssignment_0 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6301:1: ( ( ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6302:1: ( ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6302:1: ( ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6303:1: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_012767);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6312:1: rule__AdditiveExpression__OpAssignment_1_0 : ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__AdditiveExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6316:1: ( ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6317:1: ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6317:1: ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6318:1: ( rule__AdditiveExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6319:1: ( rule__AdditiveExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6319:2: rule__AdditiveExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__OpAlternatives_1_0_0_in_rule__AdditiveExpression__OpAssignment_1_012798);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6328:1: rule__AdditiveExpression__ExpAssignment_1_1 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6332:1: ( ( ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6333:1: ( ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6333:1: ( ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6334:1: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_1_112831);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6343:1: rule__MultiplicativeExpression__ExpAssignment_0 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6347:1: ( ( ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6348:1: ( ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6348:1: ( ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6349:1: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_012862);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6358:1: rule__MultiplicativeExpression__OpAssignment_1_0 : ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__MultiplicativeExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6362:1: ( ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6363:1: ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6363:1: ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6364:1: ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6365:1: ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6365:2: rule__MultiplicativeExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__OpAlternatives_1_0_0_in_rule__MultiplicativeExpression__OpAssignment_1_012893);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6374:1: rule__MultiplicativeExpression__ExpAssignment_1_1 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6378:1: ( ( ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6379:1: ( ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6379:1: ( ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6380:1: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_1_112926);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6389:1: rule__UnaryExpression__OpAssignment_0_0 : ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) ) ;
    public final void rule__UnaryExpression__OpAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6393:1: ( ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6394:1: ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6394:1: ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6395:1: ( rule__UnaryExpression__OpAlternatives_0_0_0 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpAlternatives_0_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6396:1: ( rule__UnaryExpression__OpAlternatives_0_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6396:2: rule__UnaryExpression__OpAlternatives_0_0_0
            {
            pushFollow(FOLLOW_rule__UnaryExpression__OpAlternatives_0_0_0_in_rule__UnaryExpression__OpAssignment_0_012957);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6405:1: rule__UnaryExpression__UnaryAssignment_0_1 : ( ruleUnaryExpression ) ;
    public final void rule__UnaryExpression__UnaryAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6409:1: ( ( ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6410:1: ( ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6410:1: ( ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6411:1: ruleUnaryExpression
            {
             before(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__UnaryExpression__UnaryAssignment_0_112990);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6420:1: rule__UnaryExpression__ExpAssignment_1 : ( rulePrimaryExpression ) ;
    public final void rule__UnaryExpression__ExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6424:1: ( ( rulePrimaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6425:1: ( rulePrimaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6425:1: ( rulePrimaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6426:1: rulePrimaryExpression
            {
             before(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__UnaryExpression__ExpAssignment_113021);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6435:1: rule__PrimaryExpression__PrefixAssignment_0 : ( ruleValueSpecification ) ;
    public final void rule__PrimaryExpression__PrefixAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6439:1: ( ( ruleValueSpecification ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6440:1: ( ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6440:1: ( ruleValueSpecification )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6441:1: ruleValueSpecification
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_rule__PrimaryExpression__PrefixAssignment_013052);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6450:1: rule__PrimaryExpression__SuffixAssignment_1_1 : ( ruleSuffixExpression ) ;
    public final void rule__PrimaryExpression__SuffixAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6454:1: ( ( ruleSuffixExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6455:1: ( ruleSuffixExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6455:1: ( ruleSuffixExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6456:1: ruleSuffixExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_rule__PrimaryExpression__SuffixAssignment_1_113083);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6465:1: rule__PropertyCallExpression__PropertyAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__PropertyCallExpression__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6469:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6470:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6470:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6471:1: ( RULE_ID )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6472:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6473:1: RULE_ID
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyCallExpression__PropertyAssignment_013118); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6484:1: rule__PropertyCallExpression__SuffixAssignment_1_1 : ( ruleSuffixExpression ) ;
    public final void rule__PropertyCallExpression__SuffixAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6488:1: ( ( ruleSuffixExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6489:1: ( ruleSuffixExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6489:1: ( ruleSuffixExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6490:1: ruleSuffixExpression
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_rule__PropertyCallExpression__SuffixAssignment_1_113153);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6499:1: rule__OperationCallExpression__OperationAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__OperationCallExpression__OperationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6503:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6504:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6504:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6505:1: ( RULE_ID )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6506:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6507:1: RULE_ID
            {
             before(grammarAccess.getOperationCallExpressionAccess().getOperationOperationIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__OperationCallExpression__OperationAssignment_013188); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6518:1: rule__OperationCallExpression__ArgumentsAssignment_2 : ( ruleListOfValues ) ;
    public final void rule__OperationCallExpression__ArgumentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6522:1: ( ( ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6523:1: ( ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6523:1: ( ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6524:1: ruleListOfValues
            {
             before(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleListOfValues_in_rule__OperationCallExpression__ArgumentsAssignment_213223);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6533:1: rule__OperationCallExpression__SuffixAssignment_4_1 : ( ruleSuffixExpression ) ;
    public final void rule__OperationCallExpression__SuffixAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6537:1: ( ( ruleSuffixExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6538:1: ( ruleSuffixExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6538:1: ( ruleSuffixExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6539:1: ruleSuffixExpression
            {
             before(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_rule__OperationCallExpression__SuffixAssignment_4_113254);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6548:1: rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6552:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6553:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6553:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6554:1: ruleQualifiedName
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__NameOrChoiceOrBehaviorCall__PathAssignment_013285);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6563:1: rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6567:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6568:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6568:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6569:1: ( RULE_ID )
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6570:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6571:1: RULE_ID
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NameOrChoiceOrBehaviorCall__IdAssignment_113320); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6582:1: rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 : ( ruleListOfValues ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6586:1: ( ( ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6587:1: ( ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6587:1: ( ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6588:1: ruleListOfValues
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleListOfValues_in_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_113355);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6597:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6601:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6602:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6602:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6603:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6604:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6605:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_013390); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6616:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6620:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6621:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6621:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6622:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_213425);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6631:1: rule__Interval__IsLowerIncludedAssignment_0_1 : ( ( '[' ) ) ;
    public final void rule__Interval__IsLowerIncludedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6635:1: ( ( ( '[' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6636:1: ( ( '[' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6636:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6637:1: ( '[' )
            {
             before(grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6638:1: ( '[' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6639:1: '['
            {
             before(grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0()); 
            match(input,32,FOLLOW_32_in_rule__Interval__IsLowerIncludedAssignment_0_113461); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6654:1: rule__Interval__LowerAssignment_1 : ( ruleExpression ) ;
    public final void rule__Interval__LowerAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6658:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6659:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6659:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6660:1: ruleExpression
            {
             before(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Interval__LowerAssignment_113500);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6669:1: rule__Interval__UpperAssignment_3 : ( ruleExpression ) ;
    public final void rule__Interval__UpperAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6673:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6674:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6674:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6675:1: ruleExpression
            {
             before(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Interval__UpperAssignment_313531);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6684:1: rule__Interval__IsUpperIncludedAssignment_4_0 : ( ( ']' ) ) ;
    public final void rule__Interval__IsUpperIncludedAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6688:1: ( ( ( ']' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6689:1: ( ( ']' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6689:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6690:1: ( ']' )
            {
             before(grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6691:1: ( ']' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6692:1: ']'
            {
             before(grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0()); 
            match(input,31,FOLLOW_31_in_rule__Interval__IsUpperIncludedAssignment_4_013567); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6707:1: rule__CollectionOrTuple__ListOfValuesAssignment_1 : ( ruleListOfValues ) ;
    public final void rule__CollectionOrTuple__ListOfValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6711:1: ( ( ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6712:1: ( ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6712:1: ( ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6713:1: ruleListOfValues
            {
             before(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleListOfValues_in_rule__CollectionOrTuple__ListOfValuesAssignment_113606);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6722:1: rule__Tuple__ListOfValueNamePairsAssignment_1 : ( ruleListOfValueNamePairs ) ;
    public final void rule__Tuple__ListOfValueNamePairsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6726:1: ( ( ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6727:1: ( ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6727:1: ( ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6728:1: ruleListOfValueNamePairs
            {
             before(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_rule__Tuple__ListOfValueNamePairsAssignment_113637);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6737:1: rule__ListOfValues__ValuesAssignment_0 : ( ruleExpression ) ;
    public final void rule__ListOfValues__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6741:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6742:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6742:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6743:1: ruleExpression
            {
             before(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_013668);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6752:1: rule__ListOfValues__ValuesAssignment_1_1 : ( ruleExpression ) ;
    public final void rule__ListOfValues__ValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6756:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6757:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6757:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6758:1: ruleExpression
            {
             before(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_1_113699);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6767:1: rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 : ( ruleValueNamePair ) ;
    public final void rule__ListOfValueNamePairs__ValueNamePairsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6771:1: ( ( ruleValueNamePair ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6772:1: ( ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6772:1: ( ruleValueNamePair )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6773:1: ruleValueNamePair
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_013730);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6782:1: rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 : ( ruleValueNamePair ) ;
    public final void rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6786:1: ( ( ruleValueNamePair ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6787:1: ( ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6787:1: ( ruleValueNamePair )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6788:1: ruleValueNamePair
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_113761);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6797:1: rule__ValueNamePair__PropertyAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ValueNamePair__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6801:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6802:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6802:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6803:1: ( RULE_ID )
            {
             before(grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6804:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6805:1: RULE_ID
            {
             before(grammarAccess.getValueNamePairAccess().getPropertyPropertyIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ValueNamePair__PropertyAssignment_013796); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6816:1: rule__ValueNamePair__ValueAssignment_2 : ( ruleExpression ) ;
    public final void rule__ValueNamePair__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6820:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6821:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6821:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6822:1: ruleExpression
            {
             before(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ValueNamePair__ValueAssignment_213831);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6831:1: rule__InstantObsExpression__IdAssignment_1 : ( ruleInstantObsName ) ;
    public final void rule__InstantObsExpression__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6835:1: ( ( ruleInstantObsName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6836:1: ( ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6836:1: ( ruleInstantObsName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6837:1: ruleInstantObsName
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInstantObsName_in_rule__InstantObsExpression__IdAssignment_113862);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6846:1: rule__InstantObsExpression__IndexAssignment_2_1 : ( ruleExpression ) ;
    public final void rule__InstantObsExpression__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6850:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6851:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6851:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6852:1: ruleExpression
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__InstantObsExpression__IndexAssignment_2_113893);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6861:1: rule__InstantObsExpression__ConditionAssignment_3_2 : ( ruleExpression ) ;
    public final void rule__InstantObsExpression__ConditionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6865:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6866:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6866:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6867:1: ruleExpression
            {
             before(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__InstantObsExpression__ConditionAssignment_3_213924);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6876:1: rule__InstantObsName__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__InstantObsName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6880:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6881:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6881:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6882:1: ruleQualifiedName
            {
             before(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__InstantObsName__PathAssignment_013955);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6891:1: rule__InstantObsName__InstantIdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__InstantObsName__InstantIdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6895:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6896:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6896:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6897:1: ( RULE_ID )
            {
             before(grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6898:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6899:1: RULE_ID
            {
             before(grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__InstantObsName__InstantIdAssignment_113990); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6910:1: rule__DurationObsExpression__IdAssignment_1 : ( ruleDurationObsName ) ;
    public final void rule__DurationObsExpression__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6914:1: ( ( ruleDurationObsName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6915:1: ( ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6915:1: ( ruleDurationObsName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6916:1: ruleDurationObsName
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDurationObsName_in_rule__DurationObsExpression__IdAssignment_114025);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6925:1: rule__DurationObsExpression__IndexAssignment_2_1 : ( ruleExpression ) ;
    public final void rule__DurationObsExpression__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6929:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6930:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6930:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6931:1: ruleExpression
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__DurationObsExpression__IndexAssignment_2_114056);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6940:1: rule__DurationObsExpression__ConditionAssignment_3_2 : ( ruleExpression ) ;
    public final void rule__DurationObsExpression__ConditionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6944:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6945:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6945:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6946:1: ruleExpression
            {
             before(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__DurationObsExpression__ConditionAssignment_3_214087);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6955:1: rule__DurationObsName__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__DurationObsName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6959:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6960:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6960:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6961:1: ruleQualifiedName
            {
             before(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__DurationObsName__PathAssignment_014118);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6970:1: rule__DurationObsName__DurationIdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DurationObsName__DurationIdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6974:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6975:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6975:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6976:1: ( RULE_ID )
            {
             before(grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6977:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6978:1: RULE_ID
            {
             before(grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DurationObsName__DurationIdAssignment_114153); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6989:1: rule__JitterExp__FirstInstantAssignment_1 : ( ruleInstantObsExpression ) ;
    public final void rule__JitterExp__FirstInstantAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6993:1: ( ( ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6994:1: ( ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6994:1: ( ruleInstantObsExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6995:1: ruleInstantObsExpression
            {
             before(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__FirstInstantAssignment_114188);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7004:1: rule__JitterExp__SecondInstantAssignment_2_1 : ( ruleInstantObsExpression ) ;
    public final void rule__JitterExp__SecondInstantAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7008:1: ( ( ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7009:1: ( ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7009:1: ( ruleInstantObsExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7010:1: ruleInstantObsExpression
            {
             before(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__SecondInstantAssignment_2_114219);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7019:1: rule__VariableDeclaration__VariableDeclarationAssignment_0 : ( ruleVariableDirectionKind ) ;
    public final void rule__VariableDeclaration__VariableDeclarationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7023:1: ( ( ruleVariableDirectionKind ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7024:1: ( ruleVariableDirectionKind )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7024:1: ( ruleVariableDirectionKind )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7025:1: ruleVariableDirectionKind
            {
             before(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_rule__VariableDeclaration__VariableDeclarationAssignment_014250);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7034:1: rule__VariableDeclaration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__VariableDeclaration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7038:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7039:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7039:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7040:1: RULE_ID
            {
             before(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableDeclaration__NameAssignment_214281); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7049:1: rule__VariableDeclaration__TypeAssignment_3_0_1 : ( ruleDataTypeName ) ;
    public final void rule__VariableDeclaration__TypeAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7053:1: ( ( ruleDataTypeName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7054:1: ( ruleDataTypeName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7054:1: ( ruleDataTypeName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7055:1: ruleDataTypeName
            {
             before(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0()); 
            pushFollow(FOLLOW_ruleDataTypeName_in_rule__VariableDeclaration__TypeAssignment_3_0_114312);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7064:1: rule__VariableDeclaration__InitValueAssignment_3_0_2_2 : ( ruleExpression ) ;
    public final void rule__VariableDeclaration__InitValueAssignment_3_0_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7068:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7069:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7069:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7070:1: ruleExpression
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_0_2_214343);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7079:1: rule__VariableDeclaration__InitValueAssignment_3_1_2 : ( ruleExpression ) ;
    public final void rule__VariableDeclaration__InitValueAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7083:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7084:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7084:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7085:1: ruleExpression
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_1_214374);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7094:1: rule__DataTypeName__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__DataTypeName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7098:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7099:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7099:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7100:1: ruleQualifiedName
            {
             before(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__DataTypeName__PathAssignment_014405);
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7109:1: rule__DataTypeName__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DataTypeName__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7113:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7114:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7114:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7115:1: ( RULE_ID )
            {
             before(grammarAccess.getDataTypeNameAccess().getTypeDataTypeCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7116:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7117:1: RULE_ID
            {
             before(grammarAccess.getDataTypeNameAccess().getTypeDataTypeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DataTypeName__TypeAssignment_114440); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7128:1: rule__IntegerLiteralRule__ValueAssignment : ( RULE_INTEGERLITERAL ) ;
    public final void rule__IntegerLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7132:1: ( ( RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7133:1: ( RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7133:1: ( RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7134:1: RULE_INTEGERLITERAL
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getValueIntegerLiteralTerminalRuleCall_0()); 
            match(input,RULE_INTEGERLITERAL,FOLLOW_RULE_INTEGERLITERAL_in_rule__IntegerLiteralRule__ValueAssignment14475); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7143:1: rule__UnlimitedLiteralRule__ValueAssignment : ( ( '*' ) ) ;
    public final void rule__UnlimitedLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7147:1: ( ( ( '*' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7148:1: ( ( '*' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7148:1: ( ( '*' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7149:1: ( '*' )
            {
             before(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7150:1: ( '*' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7151:1: '*'
            {
             before(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__UnlimitedLiteralRule__ValueAssignment14511); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7166:1: rule__RealLiteralRule__ValueAssignment : ( RULE_REALLITERAL ) ;
    public final void rule__RealLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7170:1: ( ( RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7171:1: ( RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7171:1: ( RULE_REALLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7172:1: RULE_REALLITERAL
            {
             before(grammarAccess.getRealLiteralRuleAccess().getValueRealLiteralTerminalRuleCall_0()); 
            match(input,RULE_REALLITERAL,FOLLOW_RULE_REALLITERAL_in_rule__RealLiteralRule__ValueAssignment14550); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7181:1: rule__DateTimeLiteralRule__ValueAssignment : ( RULE_DATETIMELITERAL ) ;
    public final void rule__DateTimeLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7185:1: ( ( RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7186:1: ( RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7186:1: ( RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7187:1: RULE_DATETIMELITERAL
            {
             before(grammarAccess.getDateTimeLiteralRuleAccess().getValueDateTimeLiteralTerminalRuleCall_0()); 
            match(input,RULE_DATETIMELITERAL,FOLLOW_RULE_DATETIMELITERAL_in_rule__DateTimeLiteralRule__ValueAssignment14581); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7196:1: rule__BooleanLiteralRule__ValueAssignment : ( RULE_BOOLEANLITERAL ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7200:1: ( ( RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7201:1: ( RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7201:1: ( RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7202:1: RULE_BOOLEANLITERAL
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueBooleanLiteralTerminalRuleCall_0()); 
            match(input,RULE_BOOLEANLITERAL,FOLLOW_RULE_BOOLEANLITERAL_in_rule__BooleanLiteralRule__ValueAssignment14612); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7211:1: rule__NullLiteralRule__ValueAssignment : ( RULE_NULLLITERAL ) ;
    public final void rule__NullLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7215:1: ( ( RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7216:1: ( RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7216:1: ( RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7217:1: RULE_NULLLITERAL
            {
             before(grammarAccess.getNullLiteralRuleAccess().getValueNullLiteralTerminalRuleCall_0()); 
            match(input,RULE_NULLLITERAL,FOLLOW_RULE_NULLLITERAL_in_rule__NullLiteralRule__ValueAssignment14643); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7226:1: rule__DefaultLiteralRule__ValueAssignment : ( ( '/' ) ) ;
    public final void rule__DefaultLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7230:1: ( ( ( '/' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7231:1: ( ( '/' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7231:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7232:1: ( '/' )
            {
             before(grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7233:1: ( '/' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7234:1: '/'
            {
             before(grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__DefaultLiteralRule__ValueAssignment14679); 
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
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7249:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7253:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7254:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7254:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:7255:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteralRule__ValueAssignment14718); 
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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContext_in_entryRuleContext181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContext188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Context__Group__0_in_ruleContext214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__ExpAssignment_in_ruleExpression274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOrXorExpression308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__0_in_ruleAndOrXorExpression334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__0_in_ruleEqualityExpression394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__0_in_ruleRelationalExpression454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__0_in_ruleConditionalExpression514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__0_in_ruleAdditiveExpression574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__0_in_ruleMultiplicativeExpression634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Alternatives_in_ruleUnaryExpression694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group__0_in_rulePrimaryExpression754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Alternatives_in_ruleValueSpecification814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuffixExpression__Alternatives_in_ruleSuffixExpression874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group__0_in_rulePropertyCallExpression934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__0_in_ruleOperationCallExpression994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameOrChoiceOrBehaviorCall1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0_in_ruleNameOrChoiceOrBehaviorCall1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval1201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__0_in_ruleInterval1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple1261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionOrTuple1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__0_in_ruleCollectionOrTuple1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__Group__0_in_ruleTuple1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_entryRuleListOfValues1381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValues1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__0_in_ruleListOfValues1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs1441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListOfValueNamePairs1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group__0_in_ruleListOfValueNamePairs1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair1501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNamePair1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__0_in_ruleValueNamePair1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression1561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeExpression1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TimeExpression__Alternatives_in_ruleTimeExpression1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression1621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsExpression1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__0_in_ruleInstantObsExpression1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName1681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantObsName1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__Group__0_in_ruleInstantObsName1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression1741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsExpression1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__0_in_ruleDurationObsExpression1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName1801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDurationObsName1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__Group__0_in_ruleDurationObsName1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_entryRuleJitterExp1861 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJitterExp1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__0_in_ruleJitterExp1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__0_in_ruleVariableDeclaration1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind1981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDirectionKind1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDirectionKind__Alternatives_in_ruleVariableDirectionKind2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName2041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeName2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__Group__0_in_ruleDataTypeName2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule2101 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralRule2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteralRule__Alternatives_in_ruleNumberLiteralRule2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule2161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteralRule2168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerLiteralRule__ValueAssignment_in_ruleIntegerLiteralRule2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule2221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedLiteralRule2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnlimitedLiteralRule__ValueAssignment_in_ruleUnlimitedLiteralRule2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule2281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralRule2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RealLiteralRule__ValueAssignment_in_ruleRealLiteralRule2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule2341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateTimeLiteralRule2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DateTimeLiteralRule__ValueAssignment_in_ruleDateTimeLiteralRule2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule2401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralRule2408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteralRule__ValueAssignment_in_ruleBooleanLiteralRule2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule2461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralRule2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullLiteralRule__ValueAssignment_in_ruleNullLiteralRule2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule2521 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultLiteralRule2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DefaultLiteralRule__ValueAssignment_in_ruleDefaultLiteralRule2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule2581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralRule2588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteralRule__ValueAssignment_in_ruleStringLiteralRule2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__AndOrXorExpression__OpAlternatives_1_0_02651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__AndOrXorExpression__OpAlternatives_1_0_02671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__AndOrXorExpression__OpAlternatives_1_0_02691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__EqualityExpression__OpAlternatives_1_0_02726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__EqualityExpression__OpAlternatives_1_0_02746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__RelationalExpression__OpAlternatives_1_0_02781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__RelationalExpression__OpAlternatives_1_0_02801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__RelationalExpression__OpAlternatives_1_0_02821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__RelationalExpression__OpAlternatives_1_0_02841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__AdditiveExpression__OpAlternatives_1_0_02876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__AdditiveExpression__OpAlternatives_1_0_02896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group_0__0_in_rule__UnaryExpression__Alternatives3005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__ExpAssignment_1_in_rule__UnaryExpression__Alternatives3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__UnaryExpression__OpAlternatives_0_0_03057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__UnaryExpression__OpAlternatives_0_0_03077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__UnaryExpression__OpAlternatives_0_0_03097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__ValueSpecification__Alternatives3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_rule__ValueSpecification__Alternatives3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_rule__ValueSpecification__Alternatives3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionOrTuple_in_rule__ValueSpecification__Alternatives3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_rule__ValueSpecification__Alternatives3199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeExpression_in_rule__ValueSpecification__Alternatives3216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_rule__ValueSpecification__Alternatives3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__0_in_rule__ValueSpecification__Alternatives3250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_rule__SuffixExpression__Alternatives3283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_rule__SuffixExpression__Alternatives3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralRule_in_rule__Literal__Alternatives3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateTimeLiteralRule_in_rule__Literal__Alternatives3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralRule_in_rule__Literal__Alternatives3366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralRule_in_rule__Literal__Alternatives3383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultLiteralRule_in_rule__Literal__Alternatives3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralRule_in_rule__Literal__Alternatives3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Interval__Alternatives_03450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__IsLowerIncludedAssignment_0_1_in_rule__Interval__Alternatives_03469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__IsUpperIncludedAssignment_4_0_in_rule__Interval__Alternatives_43502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Interval__Alternatives_43521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_rule__TimeExpression__Alternatives3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsExpression_in_rule__TimeExpression__Alternatives3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJitterExp_in_rule__TimeExpression__Alternatives3589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__0_in_rule__VariableDeclaration__Alternatives_33621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__0_in_rule__VariableDeclaration__Alternatives_33639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__VariableDirectionKind__Alternatives3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__VariableDirectionKind__Alternatives3693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__VariableDirectionKind__Alternatives3713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteralRule_in_rule__NumberLiteralRule__Alternatives3747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedLiteralRule_in_rule__NumberLiteralRule__Alternatives3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralRule_in_rule__NumberLiteralRule__Alternatives3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__03811 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__03814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__13871 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__13874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ContextAssignment_1_in_rule__Model__Group__1__Impl3901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__23931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_2__0_in_rule__Model__Group__2__Impl3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_2__0__Impl_in_rule__Model__Group_2__03994 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__03997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Model__Group_2__0__Impl4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_2__1__Impl_in_rule__Model__Group_2__14056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ValueAssignment_2_1_in_rule__Model__Group_2__1__Impl4083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__04117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__04120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Import__Group__0__Impl4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__14179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl4206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Context__Group__0__Impl_in_rule__Context__Group__04240 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Context__Group__1_in_rule__Context__Group__04243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Context__Group__0__Impl4271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Context__Group__1__Impl_in_rule__Context__Group__14302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Context__ContextAssignment_1_in_rule__Context__Group__1__Impl4329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__0__Impl_in_rule__AndOrXorExpression__Group__04363 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__1_in_rule__AndOrXorExpression__Group__04366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__ExpAssignment_0_in_rule__AndOrXorExpression__Group__0__Impl4393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__1__Impl_in_rule__AndOrXorExpression__Group__14423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__0_in_rule__AndOrXorExpression__Group__1__Impl4450 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__0__Impl_in_rule__AndOrXorExpression__Group_1__04485 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__1_in_rule__AndOrXorExpression__Group_1__04488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__OpAssignment_1_0_in_rule__AndOrXorExpression__Group_1__0__Impl4515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__1__Impl_in_rule__AndOrXorExpression__Group_1__14545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__ExpAssignment_1_1_in_rule__AndOrXorExpression__Group_1__1__Impl4572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__0__Impl_in_rule__EqualityExpression__Group__04606 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__1_in_rule__EqualityExpression__Group__04609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__ExpAssignment_0_in_rule__EqualityExpression__Group__0__Impl4636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__1__Impl_in_rule__EqualityExpression__Group__14666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__0_in_rule__EqualityExpression__Group__1__Impl4693 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__0__Impl_in_rule__EqualityExpression__Group_1__04728 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__1_in_rule__EqualityExpression__Group_1__04731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__OpAssignment_1_0_in_rule__EqualityExpression__Group_1__0__Impl4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__1__Impl_in_rule__EqualityExpression__Group_1__14788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__ExpAssignment_1_1_in_rule__EqualityExpression__Group_1__1__Impl4815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__0__Impl_in_rule__RelationalExpression__Group__04849 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__1_in_rule__RelationalExpression__Group__04852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__ExpAssignment_0_in_rule__RelationalExpression__Group__0__Impl4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__1__Impl_in_rule__RelationalExpression__Group__14909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__0_in_rule__RelationalExpression__Group__1__Impl4936 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__0__Impl_in_rule__RelationalExpression__Group_1__04971 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__1_in_rule__RelationalExpression__Group_1__04974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__OpAssignment_1_0_in_rule__RelationalExpression__Group_1__0__Impl5001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__1__Impl_in_rule__RelationalExpression__Group_1__15031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__ExpAssignment_1_1_in_rule__RelationalExpression__Group_1__1__Impl5058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__05092 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__1_in_rule__ConditionalExpression__Group__05095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__ExpAssignment_0_in_rule__ConditionalExpression__Group__0__Impl5122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__1__Impl_in_rule__ConditionalExpression__Group__15152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__0_in_rule__ConditionalExpression__Group__1__Impl5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__0__Impl_in_rule__ConditionalExpression__Group_1__05214 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__1_in_rule__ConditionalExpression__Group_1__05217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__OpAssignment_1_0_in_rule__ConditionalExpression__Group_1__0__Impl5244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__1__Impl_in_rule__ConditionalExpression__Group_1__15274 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__2_in_rule__ConditionalExpression__Group_1__15277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__ExpAssignment_1_1_in_rule__ConditionalExpression__Group_1__1__Impl5304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__2__Impl_in_rule__ConditionalExpression__Group_1__25334 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__3_in_rule__ConditionalExpression__Group_1__25337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ConditionalExpression__Group_1__2__Impl5365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group_1__3__Impl_in_rule__ConditionalExpression__Group_1__35396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__ExpAssignment_1_3_in_rule__ConditionalExpression__Group_1__3__Impl5423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__0__Impl_in_rule__AdditiveExpression__Group__05461 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__1_in_rule__AdditiveExpression__Group__05464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__ExpAssignment_0_in_rule__AdditiveExpression__Group__0__Impl5491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__1__Impl_in_rule__AdditiveExpression__Group__15521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__0_in_rule__AdditiveExpression__Group__1__Impl5548 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__0__Impl_in_rule__AdditiveExpression__Group_1__05583 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__1_in_rule__AdditiveExpression__Group_1__05586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__OpAssignment_1_0_in_rule__AdditiveExpression__Group_1__0__Impl5613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__1__Impl_in_rule__AdditiveExpression__Group_1__15643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__ExpAssignment_1_1_in_rule__AdditiveExpression__Group_1__1__Impl5670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__0__Impl_in_rule__MultiplicativeExpression__Group__05704 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__1_in_rule__MultiplicativeExpression__Group__05707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__ExpAssignment_0_in_rule__MultiplicativeExpression__Group__0__Impl5734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__1__Impl_in_rule__MultiplicativeExpression__Group__15764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group_1__0_in_rule__MultiplicativeExpression__Group__1__Impl5791 = new BitSet(new long[]{0x0000000038000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group_1__0__Impl_in_rule__MultiplicativeExpression__Group_1__05826 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group_1__1_in_rule__MultiplicativeExpression__Group_1__05829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__OpAssignment_1_0_in_rule__MultiplicativeExpression__Group_1__0__Impl5856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group_1__1__Impl_in_rule__MultiplicativeExpression__Group_1__15886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__ExpAssignment_1_1_in_rule__MultiplicativeExpression__Group_1__1__Impl5913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group_0__0__Impl_in_rule__UnaryExpression__Group_0__05947 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group_0__1_in_rule__UnaryExpression__Group_0__05950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__OpAssignment_0_0_in_rule__UnaryExpression__Group_0__0__Impl5977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__Group_0__1__Impl_in_rule__UnaryExpression__Group_0__16007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__UnaryAssignment_0_1_in_rule__UnaryExpression__Group_0__1__Impl6034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group__0__Impl_in_rule__PrimaryExpression__Group__06068 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group__1_in_rule__PrimaryExpression__Group__06071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__PrefixAssignment_0_in_rule__PrimaryExpression__Group__0__Impl6098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group__1__Impl_in_rule__PrimaryExpression__Group__16128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Group__1__Impl6155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__06190 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__06193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__PrimaryExpression__Group_1__0__Impl6221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__16252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__SuffixAssignment_1_1_in_rule__PrimaryExpression__Group_1__1__Impl6279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__0__Impl_in_rule__ValueSpecification__Group_7__06313 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__1_in_rule__ValueSpecification__Group_7__06316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ValueSpecification__Group_7__0__Impl6344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__1__Impl_in_rule__ValueSpecification__Group_7__16375 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__2_in_rule__ValueSpecification__Group_7__16378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ValueSpecification__Group_7__1__Impl6405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueSpecification__Group_7__2__Impl_in_rule__ValueSpecification__Group_7__26434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ValueSpecification__Group_7__2__Impl6462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group__0__Impl_in_rule__PropertyCallExpression__Group__06499 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group__1_in_rule__PropertyCallExpression__Group__06502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__PropertyAssignment_0_in_rule__PropertyCallExpression__Group__0__Impl6529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group__1__Impl_in_rule__PropertyCallExpression__Group__16559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group_1__0_in_rule__PropertyCallExpression__Group__1__Impl6586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group_1__0__Impl_in_rule__PropertyCallExpression__Group_1__06621 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group_1__1_in_rule__PropertyCallExpression__Group_1__06624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__PropertyCallExpression__Group_1__0__Impl6652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group_1__1__Impl_in_rule__PropertyCallExpression__Group_1__16683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyCallExpression__SuffixAssignment_1_1_in_rule__PropertyCallExpression__Group_1__1__Impl6710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__0__Impl_in_rule__OperationCallExpression__Group__06744 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__1_in_rule__OperationCallExpression__Group__06747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__OperationAssignment_0_in_rule__OperationCallExpression__Group__0__Impl6774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__1__Impl_in_rule__OperationCallExpression__Group__16804 = new BitSet(new long[]{0x003A260FDE0007F0L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__2_in_rule__OperationCallExpression__Group__16807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__OperationCallExpression__Group__1__Impl6835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__2__Impl_in_rule__OperationCallExpression__Group__26866 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__3_in_rule__OperationCallExpression__Group__26869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__ArgumentsAssignment_2_in_rule__OperationCallExpression__Group__2__Impl6896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__3__Impl_in_rule__OperationCallExpression__Group__36927 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__4_in_rule__OperationCallExpression__Group__36930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__OperationCallExpression__Group__3__Impl6958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__4__Impl_in_rule__OperationCallExpression__Group__46989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group_4__0_in_rule__OperationCallExpression__Group__4__Impl7016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group_4__0__Impl_in_rule__OperationCallExpression__Group_4__07057 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group_4__1_in_rule__OperationCallExpression__Group_4__07060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__OperationCallExpression__Group_4__0__Impl7088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group_4__1__Impl_in_rule__OperationCallExpression__Group_4__17119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__SuffixAssignment_4_1_in_rule__OperationCallExpression__Group_4__1__Impl7146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__07180 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1_in_rule__NameOrChoiceOrBehaviorCall__Group__07183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__PathAssignment_0_in_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl7210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__17241 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2_in_rule__NameOrChoiceOrBehaviorCall__Group__17244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__IdAssignment_1_in_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl7271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__27301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0_in_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl7328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__07365 = new BitSet(new long[]{0x003A260FDE0007F0L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__07368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl7396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__17427 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2_in_rule__NameOrChoiceOrBehaviorCall__Group_2__17430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl7457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__27488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl7516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__07553 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__07556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl7583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__17613 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__17616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__QualifiedName__Group__1__Impl7644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__27675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl7702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__0__Impl_in_rule__Interval__Group__07739 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__Interval__Group__1_in_rule__Interval__Group__07742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Alternatives_0_in_rule__Interval__Group__0__Impl7769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__1__Impl_in_rule__Interval__Group__17799 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Interval__Group__2_in_rule__Interval__Group__17802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__LowerAssignment_1_in_rule__Interval__Group__1__Impl7829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__2__Impl_in_rule__Interval__Group__27859 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__Interval__Group__3_in_rule__Interval__Group__27862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Interval__Group__2__Impl7890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__3__Impl_in_rule__Interval__Group__37921 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__Interval__Group__4_in_rule__Interval__Group__37924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__UpperAssignment_3_in_rule__Interval__Group__3__Impl7951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Group__4__Impl_in_rule__Interval__Group__47981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Interval__Alternatives_4_in_rule__Interval__Group__4__Impl8008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__0__Impl_in_rule__CollectionOrTuple__Group__08048 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__1_in_rule__CollectionOrTuple__Group__08051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__CollectionOrTuple__Group__0__Impl8079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__1__Impl_in_rule__CollectionOrTuple__Group__18110 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__2_in_rule__CollectionOrTuple__Group__18113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__ListOfValuesAssignment_1_in_rule__CollectionOrTuple__Group__1__Impl8140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionOrTuple__Group__2__Impl_in_rule__CollectionOrTuple__Group__28170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__CollectionOrTuple__Group__2__Impl8198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__Group__0__Impl_in_rule__Tuple__Group__08235 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Tuple__Group__1_in_rule__Tuple__Group__08238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Tuple__Group__0__Impl8266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__Group__1__Impl_in_rule__Tuple__Group__18297 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Tuple__Group__2_in_rule__Tuple__Group__18300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__ListOfValueNamePairsAssignment_1_in_rule__Tuple__Group__1__Impl8327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tuple__Group__2__Impl_in_rule__Tuple__Group__28357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Tuple__Group__2__Impl8385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__0__Impl_in_rule__ListOfValues__Group__08422 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__1_in_rule__ListOfValues__Group__08425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__ValuesAssignment_0_in_rule__ListOfValues__Group__0__Impl8452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__1__Impl_in_rule__ListOfValues__Group__18482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__0_in_rule__ListOfValues__Group__1__Impl8509 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__0__Impl_in_rule__ListOfValues__Group_1__08544 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__1_in_rule__ListOfValues__Group_1__08547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ListOfValues__Group_1__0__Impl8575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__1__Impl_in_rule__ListOfValues__Group_1__18606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__ValuesAssignment_1_1_in_rule__ListOfValues__Group_1__1__Impl8633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group__0__Impl_in_rule__ListOfValueNamePairs__Group__08667 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group__1_in_rule__ListOfValueNamePairs__Group__08670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_0_in_rule__ListOfValueNamePairs__Group__0__Impl8697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group__1__Impl_in_rule__ListOfValueNamePairs__Group__18727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group_1__0_in_rule__ListOfValueNamePairs__Group__1__Impl8754 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group_1__0__Impl_in_rule__ListOfValueNamePairs__Group_1__08789 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group_1__1_in_rule__ListOfValueNamePairs__Group_1__08792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__ListOfValueNamePairs__Group_1__0__Impl8820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group_1__1__Impl_in_rule__ListOfValueNamePairs__Group_1__18851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1_in_rule__ListOfValueNamePairs__Group_1__1__Impl8878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__0__Impl_in_rule__ValueNamePair__Group__08912 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__1_in_rule__ValueNamePair__Group__08915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__PropertyAssignment_0_in_rule__ValueNamePair__Group__0__Impl8942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__1__Impl_in_rule__ValueNamePair__Group__18972 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__2_in_rule__ValueNamePair__Group__18975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ValueNamePair__Group__1__Impl9003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__Group__2__Impl_in_rule__ValueNamePair__Group__29034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNamePair__ValueAssignment_2_in_rule__ValueNamePair__Group__2__Impl9061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__0__Impl_in_rule__InstantObsExpression__Group__09097 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__1_in_rule__InstantObsExpression__Group__09100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__InstantObsExpression__Group__0__Impl9128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__1__Impl_in_rule__InstantObsExpression__Group__19159 = new BitSet(new long[]{0x0004020000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__2_in_rule__InstantObsExpression__Group__19162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__IdAssignment_1_in_rule__InstantObsExpression__Group__1__Impl9189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__2__Impl_in_rule__InstantObsExpression__Group__29219 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__3_in_rule__InstantObsExpression__Group__29222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__0_in_rule__InstantObsExpression__Group__2__Impl9249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__3__Impl_in_rule__InstantObsExpression__Group__39280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__0_in_rule__InstantObsExpression__Group__3__Impl9307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__0__Impl_in_rule__InstantObsExpression__Group_2__09346 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__1_in_rule__InstantObsExpression__Group_2__09349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__InstantObsExpression__Group_2__0__Impl9377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__1__Impl_in_rule__InstantObsExpression__Group_2__19408 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__2_in_rule__InstantObsExpression__Group_2__19411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__IndexAssignment_2_1_in_rule__InstantObsExpression__Group_2__1__Impl9438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_2__2__Impl_in_rule__InstantObsExpression__Group_2__29468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__InstantObsExpression__Group_2__2__Impl9496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__0__Impl_in_rule__InstantObsExpression__Group_3__09533 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__1_in_rule__InstantObsExpression__Group_3__09536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__InstantObsExpression__Group_3__0__Impl9564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__1__Impl_in_rule__InstantObsExpression__Group_3__19595 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__2_in_rule__InstantObsExpression__Group_3__19598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__InstantObsExpression__Group_3__1__Impl9626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__2__Impl_in_rule__InstantObsExpression__Group_3__29657 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__3_in_rule__InstantObsExpression__Group_3__29660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__ConditionAssignment_3_2_in_rule__InstantObsExpression__Group_3__2__Impl9687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group_3__3__Impl_in_rule__InstantObsExpression__Group_3__39717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__InstantObsExpression__Group_3__3__Impl9745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__Group__0__Impl_in_rule__InstantObsName__Group__09784 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__InstantObsName__Group__1_in_rule__InstantObsName__Group__09787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__PathAssignment_0_in_rule__InstantObsName__Group__0__Impl9814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__Group__1__Impl_in_rule__InstantObsName__Group__19845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsName__InstantIdAssignment_1_in_rule__InstantObsName__Group__1__Impl9872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__0__Impl_in_rule__DurationObsExpression__Group__09906 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__1_in_rule__DurationObsExpression__Group__09909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__DurationObsExpression__Group__0__Impl9937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__1__Impl_in_rule__DurationObsExpression__Group__19968 = new BitSet(new long[]{0x0004020000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__2_in_rule__DurationObsExpression__Group__19971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__IdAssignment_1_in_rule__DurationObsExpression__Group__1__Impl9998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__2__Impl_in_rule__DurationObsExpression__Group__210028 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__3_in_rule__DurationObsExpression__Group__210031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__0_in_rule__DurationObsExpression__Group__2__Impl10058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__3__Impl_in_rule__DurationObsExpression__Group__310089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__0_in_rule__DurationObsExpression__Group__3__Impl10116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__0__Impl_in_rule__DurationObsExpression__Group_2__010155 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__1_in_rule__DurationObsExpression__Group_2__010158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__DurationObsExpression__Group_2__0__Impl10186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__1__Impl_in_rule__DurationObsExpression__Group_2__110217 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__2_in_rule__DurationObsExpression__Group_2__110220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__IndexAssignment_2_1_in_rule__DurationObsExpression__Group_2__1__Impl10247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_2__2__Impl_in_rule__DurationObsExpression__Group_2__210277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__DurationObsExpression__Group_2__2__Impl10305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__0__Impl_in_rule__DurationObsExpression__Group_3__010342 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__1_in_rule__DurationObsExpression__Group_3__010345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__DurationObsExpression__Group_3__0__Impl10373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__1__Impl_in_rule__DurationObsExpression__Group_3__110404 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__2_in_rule__DurationObsExpression__Group_3__110407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__DurationObsExpression__Group_3__1__Impl10435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__2__Impl_in_rule__DurationObsExpression__Group_3__210466 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__3_in_rule__DurationObsExpression__Group_3__210469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__ConditionAssignment_3_2_in_rule__DurationObsExpression__Group_3__2__Impl10496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group_3__3__Impl_in_rule__DurationObsExpression__Group_3__310526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__DurationObsExpression__Group_3__3__Impl10554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__Group__0__Impl_in_rule__DurationObsName__Group__010593 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DurationObsName__Group__1_in_rule__DurationObsName__Group__010596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__PathAssignment_0_in_rule__DurationObsName__Group__0__Impl10623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__Group__1__Impl_in_rule__DurationObsName__Group__110654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsName__DurationIdAssignment_1_in_rule__DurationObsName__Group__1__Impl10681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__0__Impl_in_rule__JitterExp__Group__010715 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__1_in_rule__JitterExp__Group__010718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__JitterExp__Group__0__Impl10746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__1__Impl_in_rule__JitterExp__Group__110777 = new BitSet(new long[]{0x0000040004000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__2_in_rule__JitterExp__Group__110780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__FirstInstantAssignment_1_in_rule__JitterExp__Group__1__Impl10807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__2__Impl_in_rule__JitterExp__Group__210837 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__3_in_rule__JitterExp__Group__210840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__0_in_rule__JitterExp__Group__2__Impl10867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__3__Impl_in_rule__JitterExp__Group__310898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__JitterExp__Group__3__Impl10926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__0__Impl_in_rule__JitterExp__Group_2__010965 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__1_in_rule__JitterExp__Group_2__010968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__JitterExp__Group_2__0__Impl10996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__1__Impl_in_rule__JitterExp__Group_2__111027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__SecondInstantAssignment_2_1_in_rule__JitterExp__Group_2__1__Impl11054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__0__Impl_in_rule__VariableDeclaration__Group__011088 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__1_in_rule__VariableDeclaration__Group__011091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__VariableDeclarationAssignment_0_in_rule__VariableDeclaration__Group__0__Impl11118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__1__Impl_in_rule__VariableDeclaration__Group__111149 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__2_in_rule__VariableDeclaration__Group__111152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__VariableDeclaration__Group__1__Impl11180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__2__Impl_in_rule__VariableDeclaration__Group__211211 = new BitSet(new long[]{0x0001008000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__3_in_rule__VariableDeclaration__Group__211214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__NameAssignment_2_in_rule__VariableDeclaration__Group__2__Impl11241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__3__Impl_in_rule__VariableDeclaration__Group__311271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Alternatives_3_in_rule__VariableDeclaration__Group__3__Impl11298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__0__Impl_in_rule__VariableDeclaration__Group_3_0__011336 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__1_in_rule__VariableDeclaration__Group_3_0__011339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__VariableDeclaration__Group_3_0__0__Impl11367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__1__Impl_in_rule__VariableDeclaration__Group_3_0__111398 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__2_in_rule__VariableDeclaration__Group_3_0__111401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__TypeAssignment_3_0_1_in_rule__VariableDeclaration__Group_3_0__1__Impl11428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__2__Impl_in_rule__VariableDeclaration__Group_3_0__211458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__0_in_rule__VariableDeclaration__Group_3_0__2__Impl11485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__0__Impl_in_rule__VariableDeclaration__Group_3_0_2__011522 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__1_in_rule__VariableDeclaration__Group_3_0_2__011525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__VariableDeclaration__Group_3_0_2__0__Impl11553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__1__Impl_in_rule__VariableDeclaration__Group_3_0_2__111584 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__2_in_rule__VariableDeclaration__Group_3_0_2__111587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__VariableDeclaration__Group_3_0_2__1__Impl11615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__2__Impl_in_rule__VariableDeclaration__Group_3_0_2__211646 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__3_in_rule__VariableDeclaration__Group_3_0_2__211649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_0_2_2_in_rule__VariableDeclaration__Group_3_0_2__2__Impl11676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0_2__3__Impl_in_rule__VariableDeclaration__Group_3_0_2__311706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__VariableDeclaration__Group_3_0_2__3__Impl11734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__0__Impl_in_rule__VariableDeclaration__Group_3_1__011773 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__1_in_rule__VariableDeclaration__Group_3_1__011776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__VariableDeclaration__Group_3_1__0__Impl11804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__1__Impl_in_rule__VariableDeclaration__Group_3_1__111835 = new BitSet(new long[]{0x003A220FDE0007F0L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__2_in_rule__VariableDeclaration__Group_3_1__111838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__VariableDeclaration__Group_3_1__1__Impl11866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__2__Impl_in_rule__VariableDeclaration__Group_3_1__211897 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__3_in_rule__VariableDeclaration__Group_3_1__211900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_1_2_in_rule__VariableDeclaration__Group_3_1__2__Impl11927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_1__3__Impl_in_rule__VariableDeclaration__Group_3_1__311957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__VariableDeclaration__Group_3_1__3__Impl11985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__Group__0__Impl_in_rule__DataTypeName__Group__012024 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DataTypeName__Group__1_in_rule__DataTypeName__Group__012027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__PathAssignment_0_in_rule__DataTypeName__Group__0__Impl12054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__Group__1__Impl_in_rule__DataTypeName__Group__112085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DataTypeName__TypeAssignment_1_in_rule__DataTypeName__Group__1__Impl12112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_012151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContext_in_rule__Model__ContextAssignment_112182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Model__ValueAssignment_2_112213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_112244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Context__ContextAssignment_112279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOrXorExpression_in_rule__Expression__ExpAssignment12314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_012345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__OpAlternatives_1_0_0_in_rule__AndOrXorExpression__OpAssignment_1_012376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_1_112409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_012440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__OpAlternatives_1_0_0_in_rule__EqualityExpression__OpAssignment_1_012471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_1_112504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_012535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__OpAlternatives_1_0_0_in_rule__RelationalExpression__OpAssignment_1_012566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_1_112599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_012630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__ConditionalExpression__OpAssignment_1_012666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_112705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_312736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_012767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__OpAlternatives_1_0_0_in_rule__AdditiveExpression__OpAssignment_1_012798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_1_112831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_012862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__OpAlternatives_1_0_0_in_rule__MultiplicativeExpression__OpAssignment_1_012893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_1_112926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryExpression__OpAlternatives_0_0_0_in_rule__UnaryExpression__OpAssignment_0_012957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rule__UnaryExpression__UnaryAssignment_0_112990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__UnaryExpression__ExpAssignment_113021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rule__PrimaryExpression__PrefixAssignment_013052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rule__PrimaryExpression__SuffixAssignment_1_113083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyCallExpression__PropertyAssignment_013118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rule__PropertyCallExpression__SuffixAssignment_1_113153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__OperationCallExpression__OperationAssignment_013188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_rule__OperationCallExpression__ArgumentsAssignment_213223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rule__OperationCallExpression__SuffixAssignment_4_113254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__NameOrChoiceOrBehaviorCall__PathAssignment_013285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NameOrChoiceOrBehaviorCall__IdAssignment_113320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_113355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__PathAssignment_013390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_213425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Interval__IsLowerIncludedAssignment_0_113461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Interval__LowerAssignment_113500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Interval__UpperAssignment_313531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Interval__IsUpperIncludedAssignment_4_013567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValues_in_rule__CollectionOrTuple__ListOfValuesAssignment_113606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListOfValueNamePairs_in_rule__Tuple__ListOfValueNamePairsAssignment_113637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_013668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_1_113699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_013730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_113761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ValueNamePair__PropertyAssignment_013796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ValueNamePair__ValueAssignment_213831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsName_in_rule__InstantObsExpression__IdAssignment_113862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__InstantObsExpression__IndexAssignment_2_113893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__InstantObsExpression__ConditionAssignment_3_213924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__InstantObsName__PathAssignment_013955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__InstantObsName__InstantIdAssignment_113990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDurationObsName_in_rule__DurationObsExpression__IdAssignment_114025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__DurationObsExpression__IndexAssignment_2_114056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__DurationObsExpression__ConditionAssignment_3_214087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__DurationObsName__PathAssignment_014118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DurationObsName__DurationIdAssignment_114153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__FirstInstantAssignment_114188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__SecondInstantAssignment_2_114219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDirectionKind_in_rule__VariableDeclaration__VariableDeclarationAssignment_014250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableDeclaration__NameAssignment_214281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeName_in_rule__VariableDeclaration__TypeAssignment_3_0_114312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_0_2_214343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_1_214374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__DataTypeName__PathAssignment_014405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DataTypeName__TypeAssignment_114440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERLITERAL_in_rule__IntegerLiteralRule__ValueAssignment14475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__UnlimitedLiteralRule__ValueAssignment14511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REALLITERAL_in_rule__RealLiteralRule__ValueAssignment14550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DATETIMELITERAL_in_rule__DateTimeLiteralRule__ValueAssignment14581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEANLITERAL_in_rule__BooleanLiteralRule__ValueAssignment14612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NULLLITERAL_in_rule__NullLiteralRule__ValueAssignment14643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__DefaultLiteralRule__ValueAssignment14679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteralRule__ValueAssignment14718 = new BitSet(new long[]{0x0000000000000002L});

}