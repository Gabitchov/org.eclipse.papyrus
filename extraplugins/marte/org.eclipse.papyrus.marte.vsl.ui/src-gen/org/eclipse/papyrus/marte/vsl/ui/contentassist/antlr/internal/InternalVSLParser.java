package org.eclipse.papyrus.marte.vsl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
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
    public static final int RULE_DATETIMELITERAL=7;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_REALLITERAL=6;
    public static final int EOF=-1;
    public static final int RULE_BOOLEANLITERAL=8;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_INT=11;
    public static final int T__50=50;
    public static final int RULE_NULLLITERAL=9;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_INTEGERLITERAL=5;
    public static final int RULE_SL_COMMENT=13;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=10;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=14;

    // delegates
    // delegators


        public InternalVSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVSLParser.tokenNames; }
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




    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:60:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:61:1: ( ruleExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:62:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression61);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:69:1: ruleExpression : ( ( rule__Expression__ExpAssignment ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:73:2: ( ( ( rule__Expression__ExpAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:74:1: ( ( rule__Expression__ExpAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:74:1: ( ( rule__Expression__ExpAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:75:1: ( rule__Expression__ExpAssignment )
            {
             before(grammarAccess.getExpressionAccess().getExpAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:76:1: ( rule__Expression__ExpAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:76:2: rule__Expression__ExpAssignment
            {
            pushFollow(FOLLOW_rule__Expression__ExpAssignment_in_ruleExpression94);
            rule__Expression__ExpAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAndOrXorExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:88:1: entryRuleAndOrXorExpression : ruleAndOrXorExpression EOF ;
    public final void entryRuleAndOrXorExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:89:1: ( ruleAndOrXorExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:90:1: ruleAndOrXorExpression EOF
            {
             before(grammarAccess.getAndOrXorExpressionRule()); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_entryRuleAndOrXorExpression121);
            ruleAndOrXorExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleAndOrXorExpression"


    // $ANTLR start "ruleAndOrXorExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:97:1: ruleAndOrXorExpression : ( ( rule__AndOrXorExpression__Group__0 ) ) ;
    public final void ruleAndOrXorExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:101:2: ( ( ( rule__AndOrXorExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:102:1: ( ( rule__AndOrXorExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:102:1: ( ( rule__AndOrXorExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:103:1: ( rule__AndOrXorExpression__Group__0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:104:1: ( rule__AndOrXorExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:104:2: rule__AndOrXorExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__0_in_ruleAndOrXorExpression154);
            rule__AndOrXorExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleAndOrXorExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:116:1: entryRuleEqualityExpression : ruleEqualityExpression EOF ;
    public final void entryRuleEqualityExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:117:1: ( ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:118:1: ruleEqualityExpression EOF
            {
             before(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression181);
            ruleEqualityExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:125:1: ruleEqualityExpression : ( ( rule__EqualityExpression__Group__0 ) ) ;
    public final void ruleEqualityExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:129:2: ( ( ( rule__EqualityExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:130:1: ( ( rule__EqualityExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:130:1: ( ( rule__EqualityExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:131:1: ( rule__EqualityExpression__Group__0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:132:1: ( rule__EqualityExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:132:2: rule__EqualityExpression__Group__0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__0_in_ruleEqualityExpression214);
            rule__EqualityExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:144:1: entryRuleRelationalExpression : ruleRelationalExpression EOF ;
    public final void entryRuleRelationalExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:145:1: ( ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:146:1: ruleRelationalExpression EOF
            {
             before(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression241);
            ruleRelationalExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:153:1: ruleRelationalExpression : ( ( rule__RelationalExpression__Group__0 ) ) ;
    public final void ruleRelationalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:157:2: ( ( ( rule__RelationalExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:158:1: ( ( rule__RelationalExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:158:1: ( ( rule__RelationalExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:159:1: ( rule__RelationalExpression__Group__0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:160:1: ( rule__RelationalExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:160:2: rule__RelationalExpression__Group__0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__0_in_ruleRelationalExpression274);
            rule__RelationalExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:172:1: entryRuleConditionalExpression : ruleConditionalExpression EOF ;
    public final void entryRuleConditionalExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:173:1: ( ruleConditionalExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:174:1: ruleConditionalExpression EOF
            {
             before(grammarAccess.getConditionalExpressionRule()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression301);
            ruleConditionalExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:181:1: ruleConditionalExpression : ( ( rule__ConditionalExpression__Group__0 ) ) ;
    public final void ruleConditionalExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:185:2: ( ( ( rule__ConditionalExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:186:1: ( ( rule__ConditionalExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:186:1: ( ( rule__ConditionalExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:187:1: ( rule__ConditionalExpression__Group__0 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:188:1: ( rule__ConditionalExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:188:2: rule__ConditionalExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__0_in_ruleConditionalExpression334);
            rule__ConditionalExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:200:1: entryRuleAdditiveExpression : ruleAdditiveExpression EOF ;
    public final void entryRuleAdditiveExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:201:1: ( ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:202:1: ruleAdditiveExpression EOF
            {
             before(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression361);
            ruleAdditiveExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:209:1: ruleAdditiveExpression : ( ( rule__AdditiveExpression__Group__0 ) ) ;
    public final void ruleAdditiveExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:213:2: ( ( ( rule__AdditiveExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:214:1: ( ( rule__AdditiveExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:214:1: ( ( rule__AdditiveExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:215:1: ( rule__AdditiveExpression__Group__0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:216:1: ( rule__AdditiveExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:216:2: rule__AdditiveExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__0_in_ruleAdditiveExpression394);
            rule__AdditiveExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:228:1: entryRuleMultiplicativeExpression : ruleMultiplicativeExpression EOF ;
    public final void entryRuleMultiplicativeExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:229:1: ( ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:230:1: ruleMultiplicativeExpression EOF
            {
             before(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression421);
            ruleMultiplicativeExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:237:1: ruleMultiplicativeExpression : ( ( rule__MultiplicativeExpression__Group__0 ) ) ;
    public final void ruleMultiplicativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:241:2: ( ( ( rule__MultiplicativeExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:242:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:242:1: ( ( rule__MultiplicativeExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:243:1: ( rule__MultiplicativeExpression__Group__0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:244:1: ( rule__MultiplicativeExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:244:2: rule__MultiplicativeExpression__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__0_in_ruleMultiplicativeExpression454);
            rule__MultiplicativeExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:256:1: entryRuleUnaryExpression : ruleUnaryExpression EOF ;
    public final void entryRuleUnaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:257:1: ( ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:258:1: ruleUnaryExpression EOF
            {
             before(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression481);
            ruleUnaryExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:265:1: ruleUnaryExpression : ( ( rule__UnaryExpression__Alternatives ) ) ;
    public final void ruleUnaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:269:2: ( ( ( rule__UnaryExpression__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:270:1: ( ( rule__UnaryExpression__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:270:1: ( ( rule__UnaryExpression__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:271:1: ( rule__UnaryExpression__Alternatives )
            {
             before(grammarAccess.getUnaryExpressionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:272:1: ( rule__UnaryExpression__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:272:2: rule__UnaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Alternatives_in_ruleUnaryExpression514);
            rule__UnaryExpression__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:284:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:285:1: ( rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:286:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression541);
            rulePrimaryExpression();

            state._fsp--;

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:293:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Group__0 ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:297:2: ( ( ( rule__PrimaryExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:298:1: ( ( rule__PrimaryExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:298:1: ( ( rule__PrimaryExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:299:1: ( rule__PrimaryExpression__Group__0 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:300:1: ( rule__PrimaryExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:300:2: rule__PrimaryExpression__Group__0
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group__0_in_rulePrimaryExpression574);
            rule__PrimaryExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleValueSpecification"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:312:1: entryRuleValueSpecification : ruleValueSpecification EOF ;
    public final void entryRuleValueSpecification() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:313:1: ( ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:314:1: ruleValueSpecification EOF
            {
             before(grammarAccess.getValueSpecificationRule()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification601);
            ruleValueSpecification();

            state._fsp--;

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
    // $ANTLR end "entryRuleValueSpecification"


    // $ANTLR start "ruleValueSpecification"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:321:1: ruleValueSpecification : ( ( rule__ValueSpecification__Alternatives ) ) ;
    public final void ruleValueSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:325:2: ( ( ( rule__ValueSpecification__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:326:1: ( ( rule__ValueSpecification__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:326:1: ( ( rule__ValueSpecification__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:327:1: ( rule__ValueSpecification__Alternatives )
            {
             before(grammarAccess.getValueSpecificationAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:328:1: ( rule__ValueSpecification__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:328:2: rule__ValueSpecification__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Alternatives_in_ruleValueSpecification634);
            rule__ValueSpecification__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleValueSpecification"


    // $ANTLR start "entryRuleSuffixExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:340:1: entryRuleSuffixExpression : ruleSuffixExpression EOF ;
    public final void entryRuleSuffixExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:341:1: ( ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:342:1: ruleSuffixExpression EOF
            {
             before(grammarAccess.getSuffixExpressionRule()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression661);
            ruleSuffixExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleSuffixExpression"


    // $ANTLR start "ruleSuffixExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:349:1: ruleSuffixExpression : ( ( rule__SuffixExpression__Alternatives ) ) ;
    public final void ruleSuffixExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:353:2: ( ( ( rule__SuffixExpression__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:354:1: ( ( rule__SuffixExpression__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:354:1: ( ( rule__SuffixExpression__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:355:1: ( rule__SuffixExpression__Alternatives )
            {
             before(grammarAccess.getSuffixExpressionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:356:1: ( rule__SuffixExpression__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:356:2: rule__SuffixExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__SuffixExpression__Alternatives_in_ruleSuffixExpression694);
            rule__SuffixExpression__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleSuffixExpression"


    // $ANTLR start "entryRulePropertyCallExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:368:1: entryRulePropertyCallExpression : rulePropertyCallExpression EOF ;
    public final void entryRulePropertyCallExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:369:1: ( rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:370:1: rulePropertyCallExpression EOF
            {
             before(grammarAccess.getPropertyCallExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression721);
            rulePropertyCallExpression();

            state._fsp--;

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
    // $ANTLR end "entryRulePropertyCallExpression"


    // $ANTLR start "rulePropertyCallExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:377:1: rulePropertyCallExpression : ( ( rule__PropertyCallExpression__Group__0 ) ) ;
    public final void rulePropertyCallExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:381:2: ( ( ( rule__PropertyCallExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:382:1: ( ( rule__PropertyCallExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:382:1: ( ( rule__PropertyCallExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:383:1: ( rule__PropertyCallExpression__Group__0 )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:384:1: ( rule__PropertyCallExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:384:2: rule__PropertyCallExpression__Group__0
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__0_in_rulePropertyCallExpression754);
            rule__PropertyCallExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "rulePropertyCallExpression"


    // $ANTLR start "entryRuleOperationCallExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:396:1: entryRuleOperationCallExpression : ruleOperationCallExpression EOF ;
    public final void entryRuleOperationCallExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:397:1: ( ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:398:1: ruleOperationCallExpression EOF
            {
             before(grammarAccess.getOperationCallExpressionRule()); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression781);
            ruleOperationCallExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleOperationCallExpression"


    // $ANTLR start "ruleOperationCallExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:405:1: ruleOperationCallExpression : ( ( rule__OperationCallExpression__Group__0 ) ) ;
    public final void ruleOperationCallExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:409:2: ( ( ( rule__OperationCallExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:410:1: ( ( rule__OperationCallExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:410:1: ( ( rule__OperationCallExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:411:1: ( rule__OperationCallExpression__Group__0 )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:412:1: ( rule__OperationCallExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:412:2: rule__OperationCallExpression__Group__0
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__0_in_ruleOperationCallExpression814);
            rule__OperationCallExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleOperationCallExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:424:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:425:1: ( ruleLiteral EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:426:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral841);
            ruleLiteral();

            state._fsp--;

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:433:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:437:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:438:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:438:1: ( ( rule__Literal__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:439:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:440:1: ( rule__Literal__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:440:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral874);
            rule__Literal__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleNameOrChoiceOrBehaviorCall"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:452:1: entryRuleNameOrChoiceOrBehaviorCall : ruleNameOrChoiceOrBehaviorCall EOF ;
    public final void entryRuleNameOrChoiceOrBehaviorCall() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:453:1: ( ruleNameOrChoiceOrBehaviorCall EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:454:1: ruleNameOrChoiceOrBehaviorCall EOF
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallRule()); 
            pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_entryRuleNameOrChoiceOrBehaviorCall901);
            ruleNameOrChoiceOrBehaviorCall();

            state._fsp--;

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
    // $ANTLR end "entryRuleNameOrChoiceOrBehaviorCall"


    // $ANTLR start "ruleNameOrChoiceOrBehaviorCall"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:461:1: ruleNameOrChoiceOrBehaviorCall : ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) ) ;
    public final void ruleNameOrChoiceOrBehaviorCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:465:2: ( ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:466:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:466:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:467:1: ( rule__NameOrChoiceOrBehaviorCall__Group__0 )
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:468:1: ( rule__NameOrChoiceOrBehaviorCall__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:468:2: rule__NameOrChoiceOrBehaviorCall__Group__0
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0_in_ruleNameOrChoiceOrBehaviorCall934);
            rule__NameOrChoiceOrBehaviorCall__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleNameOrChoiceOrBehaviorCall"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:480:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:481:1: ( ruleQualifiedName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:482:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName961);
            ruleQualifiedName();

            state._fsp--;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:489:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:493:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:494:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:494:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:495:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:496:1: ( rule__QualifiedName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:496:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName994);
            rule__QualifiedName__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleInterval"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:508:1: entryRuleInterval : ruleInterval EOF ;
    public final void entryRuleInterval() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:509:1: ( ruleInterval EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:510:1: ruleInterval EOF
            {
             before(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval1021);
            ruleInterval();

            state._fsp--;

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
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:517:1: ruleInterval : ( ( rule__Interval__Group__0 ) ) ;
    public final void ruleInterval() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:521:2: ( ( ( rule__Interval__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:522:1: ( ( rule__Interval__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:522:1: ( ( rule__Interval__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:523:1: ( rule__Interval__Group__0 )
            {
             before(grammarAccess.getIntervalAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:524:1: ( rule__Interval__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:524:2: rule__Interval__Group__0
            {
            pushFollow(FOLLOW_rule__Interval__Group__0_in_ruleInterval1054);
            rule__Interval__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleCollectionOrTuple"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:536:1: entryRuleCollectionOrTuple : ruleCollectionOrTuple EOF ;
    public final void entryRuleCollectionOrTuple() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:537:1: ( ruleCollectionOrTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:538:1: ruleCollectionOrTuple EOF
            {
             before(grammarAccess.getCollectionOrTupleRule()); 
            pushFollow(FOLLOW_ruleCollectionOrTuple_in_entryRuleCollectionOrTuple1081);
            ruleCollectionOrTuple();

            state._fsp--;

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
    // $ANTLR end "entryRuleCollectionOrTuple"


    // $ANTLR start "ruleCollectionOrTuple"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:545:1: ruleCollectionOrTuple : ( ( rule__CollectionOrTuple__Group__0 ) ) ;
    public final void ruleCollectionOrTuple() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:549:2: ( ( ( rule__CollectionOrTuple__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:550:1: ( ( rule__CollectionOrTuple__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:550:1: ( ( rule__CollectionOrTuple__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:551:1: ( rule__CollectionOrTuple__Group__0 )
            {
             before(grammarAccess.getCollectionOrTupleAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:552:1: ( rule__CollectionOrTuple__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:552:2: rule__CollectionOrTuple__Group__0
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__0_in_ruleCollectionOrTuple1114);
            rule__CollectionOrTuple__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleCollectionOrTuple"


    // $ANTLR start "entryRuleTuple"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:564:1: entryRuleTuple : ruleTuple EOF ;
    public final void entryRuleTuple() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:565:1: ( ruleTuple EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:566:1: ruleTuple EOF
            {
             before(grammarAccess.getTupleRule()); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple1141);
            ruleTuple();

            state._fsp--;

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
    // $ANTLR end "entryRuleTuple"


    // $ANTLR start "ruleTuple"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:573:1: ruleTuple : ( ( rule__Tuple__Group__0 ) ) ;
    public final void ruleTuple() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:577:2: ( ( ( rule__Tuple__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:578:1: ( ( rule__Tuple__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:578:1: ( ( rule__Tuple__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:579:1: ( rule__Tuple__Group__0 )
            {
             before(grammarAccess.getTupleAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:580:1: ( rule__Tuple__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:580:2: rule__Tuple__Group__0
            {
            pushFollow(FOLLOW_rule__Tuple__Group__0_in_ruleTuple1174);
            rule__Tuple__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleTuple"


    // $ANTLR start "entryRuleListOfValues"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:592:1: entryRuleListOfValues : ruleListOfValues EOF ;
    public final void entryRuleListOfValues() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:593:1: ( ruleListOfValues EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:594:1: ruleListOfValues EOF
            {
             before(grammarAccess.getListOfValuesRule()); 
            pushFollow(FOLLOW_ruleListOfValues_in_entryRuleListOfValues1201);
            ruleListOfValues();

            state._fsp--;

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
    // $ANTLR end "entryRuleListOfValues"


    // $ANTLR start "ruleListOfValues"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:601:1: ruleListOfValues : ( ( rule__ListOfValues__Group__0 ) ) ;
    public final void ruleListOfValues() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:605:2: ( ( ( rule__ListOfValues__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:606:1: ( ( rule__ListOfValues__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:606:1: ( ( rule__ListOfValues__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:607:1: ( rule__ListOfValues__Group__0 )
            {
             before(grammarAccess.getListOfValuesAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:608:1: ( rule__ListOfValues__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:608:2: rule__ListOfValues__Group__0
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group__0_in_ruleListOfValues1234);
            rule__ListOfValues__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleListOfValues"


    // $ANTLR start "entryRuleListOfValueNamePairs"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:620:1: entryRuleListOfValueNamePairs : ruleListOfValueNamePairs EOF ;
    public final void entryRuleListOfValueNamePairs() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:621:1: ( ruleListOfValueNamePairs EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:622:1: ruleListOfValueNamePairs EOF
            {
             before(grammarAccess.getListOfValueNamePairsRule()); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_entryRuleListOfValueNamePairs1261);
            ruleListOfValueNamePairs();

            state._fsp--;

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
    // $ANTLR end "entryRuleListOfValueNamePairs"


    // $ANTLR start "ruleListOfValueNamePairs"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:629:1: ruleListOfValueNamePairs : ( ( rule__ListOfValueNamePairs__Group__0 ) ) ;
    public final void ruleListOfValueNamePairs() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:633:2: ( ( ( rule__ListOfValueNamePairs__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:634:1: ( ( rule__ListOfValueNamePairs__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:634:1: ( ( rule__ListOfValueNamePairs__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:635:1: ( rule__ListOfValueNamePairs__Group__0 )
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:636:1: ( rule__ListOfValueNamePairs__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:636:2: rule__ListOfValueNamePairs__Group__0
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__0_in_ruleListOfValueNamePairs1294);
            rule__ListOfValueNamePairs__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleListOfValueNamePairs"


    // $ANTLR start "entryRuleValueNamePair"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:648:1: entryRuleValueNamePair : ruleValueNamePair EOF ;
    public final void entryRuleValueNamePair() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:649:1: ( ruleValueNamePair EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:650:1: ruleValueNamePair EOF
            {
             before(grammarAccess.getValueNamePairRule()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_entryRuleValueNamePair1321);
            ruleValueNamePair();

            state._fsp--;

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
    // $ANTLR end "entryRuleValueNamePair"


    // $ANTLR start "ruleValueNamePair"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:657:1: ruleValueNamePair : ( ( rule__ValueNamePair__Group__0 ) ) ;
    public final void ruleValueNamePair() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:661:2: ( ( ( rule__ValueNamePair__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:662:1: ( ( rule__ValueNamePair__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:662:1: ( ( rule__ValueNamePair__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:663:1: ( rule__ValueNamePair__Group__0 )
            {
             before(grammarAccess.getValueNamePairAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:664:1: ( rule__ValueNamePair__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:664:2: rule__ValueNamePair__Group__0
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__0_in_ruleValueNamePair1354);
            rule__ValueNamePair__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleValueNamePair"


    // $ANTLR start "entryRuleTimeExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:676:1: entryRuleTimeExpression : ruleTimeExpression EOF ;
    public final void entryRuleTimeExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:677:1: ( ruleTimeExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:678:1: ruleTimeExpression EOF
            {
             before(grammarAccess.getTimeExpressionRule()); 
            pushFollow(FOLLOW_ruleTimeExpression_in_entryRuleTimeExpression1381);
            ruleTimeExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleTimeExpression"


    // $ANTLR start "ruleTimeExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:685:1: ruleTimeExpression : ( ( rule__TimeExpression__Alternatives ) ) ;
    public final void ruleTimeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:689:2: ( ( ( rule__TimeExpression__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:690:1: ( ( rule__TimeExpression__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:690:1: ( ( rule__TimeExpression__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:691:1: ( rule__TimeExpression__Alternatives )
            {
             before(grammarAccess.getTimeExpressionAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:692:1: ( rule__TimeExpression__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:692:2: rule__TimeExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__TimeExpression__Alternatives_in_ruleTimeExpression1414);
            rule__TimeExpression__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleTimeExpression"


    // $ANTLR start "entryRuleInstantObsExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:704:1: entryRuleInstantObsExpression : ruleInstantObsExpression EOF ;
    public final void entryRuleInstantObsExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:705:1: ( ruleInstantObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:706:1: ruleInstantObsExpression EOF
            {
             before(grammarAccess.getInstantObsExpressionRule()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_entryRuleInstantObsExpression1441);
            ruleInstantObsExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleInstantObsExpression"


    // $ANTLR start "ruleInstantObsExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:713:1: ruleInstantObsExpression : ( ( rule__InstantObsExpression__Group__0 ) ) ;
    public final void ruleInstantObsExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:717:2: ( ( ( rule__InstantObsExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:718:1: ( ( rule__InstantObsExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:718:1: ( ( rule__InstantObsExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:719:1: ( rule__InstantObsExpression__Group__0 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:720:1: ( rule__InstantObsExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:720:2: rule__InstantObsExpression__Group__0
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__0_in_ruleInstantObsExpression1474);
            rule__InstantObsExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleInstantObsExpression"


    // $ANTLR start "entryRuleInstantObsName"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:732:1: entryRuleInstantObsName : ruleInstantObsName EOF ;
    public final void entryRuleInstantObsName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:733:1: ( ruleInstantObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:734:1: ruleInstantObsName EOF
            {
             before(grammarAccess.getInstantObsNameRule()); 
            pushFollow(FOLLOW_ruleInstantObsName_in_entryRuleInstantObsName1501);
            ruleInstantObsName();

            state._fsp--;

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
    // $ANTLR end "entryRuleInstantObsName"


    // $ANTLR start "ruleInstantObsName"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:741:1: ruleInstantObsName : ( ( rule__InstantObsName__Group__0 ) ) ;
    public final void ruleInstantObsName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:745:2: ( ( ( rule__InstantObsName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:746:1: ( ( rule__InstantObsName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:746:1: ( ( rule__InstantObsName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:747:1: ( rule__InstantObsName__Group__0 )
            {
             before(grammarAccess.getInstantObsNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:748:1: ( rule__InstantObsName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:748:2: rule__InstantObsName__Group__0
            {
            pushFollow(FOLLOW_rule__InstantObsName__Group__0_in_ruleInstantObsName1534);
            rule__InstantObsName__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleInstantObsName"


    // $ANTLR start "entryRuleDurationObsExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:760:1: entryRuleDurationObsExpression : ruleDurationObsExpression EOF ;
    public final void entryRuleDurationObsExpression() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:761:1: ( ruleDurationObsExpression EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:762:1: ruleDurationObsExpression EOF
            {
             before(grammarAccess.getDurationObsExpressionRule()); 
            pushFollow(FOLLOW_ruleDurationObsExpression_in_entryRuleDurationObsExpression1561);
            ruleDurationObsExpression();

            state._fsp--;

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
    // $ANTLR end "entryRuleDurationObsExpression"


    // $ANTLR start "ruleDurationObsExpression"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:769:1: ruleDurationObsExpression : ( ( rule__DurationObsExpression__Group__0 ) ) ;
    public final void ruleDurationObsExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:773:2: ( ( ( rule__DurationObsExpression__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:774:1: ( ( rule__DurationObsExpression__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:774:1: ( ( rule__DurationObsExpression__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:775:1: ( rule__DurationObsExpression__Group__0 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:776:1: ( rule__DurationObsExpression__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:776:2: rule__DurationObsExpression__Group__0
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__0_in_ruleDurationObsExpression1594);
            rule__DurationObsExpression__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleDurationObsExpression"


    // $ANTLR start "entryRuleDurationObsName"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:788:1: entryRuleDurationObsName : ruleDurationObsName EOF ;
    public final void entryRuleDurationObsName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:789:1: ( ruleDurationObsName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:790:1: ruleDurationObsName EOF
            {
             before(grammarAccess.getDurationObsNameRule()); 
            pushFollow(FOLLOW_ruleDurationObsName_in_entryRuleDurationObsName1621);
            ruleDurationObsName();

            state._fsp--;

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
    // $ANTLR end "entryRuleDurationObsName"


    // $ANTLR start "ruleDurationObsName"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:797:1: ruleDurationObsName : ( ( rule__DurationObsName__Group__0 ) ) ;
    public final void ruleDurationObsName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:801:2: ( ( ( rule__DurationObsName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:802:1: ( ( rule__DurationObsName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:802:1: ( ( rule__DurationObsName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:803:1: ( rule__DurationObsName__Group__0 )
            {
             before(grammarAccess.getDurationObsNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:804:1: ( rule__DurationObsName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:804:2: rule__DurationObsName__Group__0
            {
            pushFollow(FOLLOW_rule__DurationObsName__Group__0_in_ruleDurationObsName1654);
            rule__DurationObsName__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleDurationObsName"


    // $ANTLR start "entryRuleJitterExp"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:816:1: entryRuleJitterExp : ruleJitterExp EOF ;
    public final void entryRuleJitterExp() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:817:1: ( ruleJitterExp EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:818:1: ruleJitterExp EOF
            {
             before(grammarAccess.getJitterExpRule()); 
            pushFollow(FOLLOW_ruleJitterExp_in_entryRuleJitterExp1681);
            ruleJitterExp();

            state._fsp--;

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
    // $ANTLR end "entryRuleJitterExp"


    // $ANTLR start "ruleJitterExp"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:825:1: ruleJitterExp : ( ( rule__JitterExp__Group__0 ) ) ;
    public final void ruleJitterExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:829:2: ( ( ( rule__JitterExp__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:830:1: ( ( rule__JitterExp__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:830:1: ( ( rule__JitterExp__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:831:1: ( rule__JitterExp__Group__0 )
            {
             before(grammarAccess.getJitterExpAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:832:1: ( rule__JitterExp__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:832:2: rule__JitterExp__Group__0
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__0_in_ruleJitterExp1714);
            rule__JitterExp__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleJitterExp"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:844:1: entryRuleVariableDeclaration : ruleVariableDeclaration EOF ;
    public final void entryRuleVariableDeclaration() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:845:1: ( ruleVariableDeclaration EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:846:1: ruleVariableDeclaration EOF
            {
             before(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration1741);
            ruleVariableDeclaration();

            state._fsp--;

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
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:853:1: ruleVariableDeclaration : ( ( rule__VariableDeclaration__Group__0 ) ) ;
    public final void ruleVariableDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:857:2: ( ( ( rule__VariableDeclaration__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:858:1: ( ( rule__VariableDeclaration__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:858:1: ( ( rule__VariableDeclaration__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:859:1: ( rule__VariableDeclaration__Group__0 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:860:1: ( rule__VariableDeclaration__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:860:2: rule__VariableDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__0_in_ruleVariableDeclaration1774);
            rule__VariableDeclaration__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleVariableDirectionKind"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:872:1: entryRuleVariableDirectionKind : ruleVariableDirectionKind EOF ;
    public final void entryRuleVariableDirectionKind() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:873:1: ( ruleVariableDirectionKind EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:874:1: ruleVariableDirectionKind EOF
            {
             before(grammarAccess.getVariableDirectionKindRule()); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_entryRuleVariableDirectionKind1801);
            ruleVariableDirectionKind();

            state._fsp--;

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
    // $ANTLR end "entryRuleVariableDirectionKind"


    // $ANTLR start "ruleVariableDirectionKind"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:881:1: ruleVariableDirectionKind : ( ( rule__VariableDirectionKind__Alternatives ) ) ;
    public final void ruleVariableDirectionKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:885:2: ( ( ( rule__VariableDirectionKind__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:886:1: ( ( rule__VariableDirectionKind__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:886:1: ( ( rule__VariableDirectionKind__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:887:1: ( rule__VariableDirectionKind__Alternatives )
            {
             before(grammarAccess.getVariableDirectionKindAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:888:1: ( rule__VariableDirectionKind__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:888:2: rule__VariableDirectionKind__Alternatives
            {
            pushFollow(FOLLOW_rule__VariableDirectionKind__Alternatives_in_ruleVariableDirectionKind1834);
            rule__VariableDirectionKind__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleVariableDirectionKind"


    // $ANTLR start "entryRuleDataTypeName"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:900:1: entryRuleDataTypeName : ruleDataTypeName EOF ;
    public final void entryRuleDataTypeName() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:901:1: ( ruleDataTypeName EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:902:1: ruleDataTypeName EOF
            {
             before(grammarAccess.getDataTypeNameRule()); 
            pushFollow(FOLLOW_ruleDataTypeName_in_entryRuleDataTypeName1861);
            ruleDataTypeName();

            state._fsp--;

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
    // $ANTLR end "entryRuleDataTypeName"


    // $ANTLR start "ruleDataTypeName"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:909:1: ruleDataTypeName : ( ( rule__DataTypeName__Group__0 ) ) ;
    public final void ruleDataTypeName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:913:2: ( ( ( rule__DataTypeName__Group__0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:914:1: ( ( rule__DataTypeName__Group__0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:914:1: ( ( rule__DataTypeName__Group__0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:915:1: ( rule__DataTypeName__Group__0 )
            {
             before(grammarAccess.getDataTypeNameAccess().getGroup()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:916:1: ( rule__DataTypeName__Group__0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:916:2: rule__DataTypeName__Group__0
            {
            pushFollow(FOLLOW_rule__DataTypeName__Group__0_in_ruleDataTypeName1894);
            rule__DataTypeName__Group__0();

            state._fsp--;


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
    // $ANTLR end "ruleDataTypeName"


    // $ANTLR start "entryRuleNumberLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:928:1: entryRuleNumberLiteralRule : ruleNumberLiteralRule EOF ;
    public final void entryRuleNumberLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:929:1: ( ruleNumberLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:930:1: ruleNumberLiteralRule EOF
            {
             before(grammarAccess.getNumberLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNumberLiteralRule_in_entryRuleNumberLiteralRule1921);
            ruleNumberLiteralRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleNumberLiteralRule"


    // $ANTLR start "ruleNumberLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:937:1: ruleNumberLiteralRule : ( ( rule__NumberLiteralRule__Alternatives ) ) ;
    public final void ruleNumberLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:941:2: ( ( ( rule__NumberLiteralRule__Alternatives ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:942:1: ( ( rule__NumberLiteralRule__Alternatives ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:942:1: ( ( rule__NumberLiteralRule__Alternatives ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:943:1: ( rule__NumberLiteralRule__Alternatives )
            {
             before(grammarAccess.getNumberLiteralRuleAccess().getAlternatives()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:944:1: ( rule__NumberLiteralRule__Alternatives )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:944:2: rule__NumberLiteralRule__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberLiteralRule__Alternatives_in_ruleNumberLiteralRule1954);
            rule__NumberLiteralRule__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleNumberLiteralRule"


    // $ANTLR start "entryRuleIntegerLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:956:1: entryRuleIntegerLiteralRule : ruleIntegerLiteralRule EOF ;
    public final void entryRuleIntegerLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:957:1: ( ruleIntegerLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:958:1: ruleIntegerLiteralRule EOF
            {
             before(grammarAccess.getIntegerLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleIntegerLiteralRule_in_entryRuleIntegerLiteralRule1981);
            ruleIntegerLiteralRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleIntegerLiteralRule"


    // $ANTLR start "ruleIntegerLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:965:1: ruleIntegerLiteralRule : ( ( rule__IntegerLiteralRule__ValueAssignment ) ) ;
    public final void ruleIntegerLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:969:2: ( ( ( rule__IntegerLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:970:1: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:970:1: ( ( rule__IntegerLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:971:1: ( rule__IntegerLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getIntegerLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:972:1: ( rule__IntegerLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:972:2: rule__IntegerLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__IntegerLiteralRule__ValueAssignment_in_ruleIntegerLiteralRule2014);
            rule__IntegerLiteralRule__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleIntegerLiteralRule"


    // $ANTLR start "entryRuleUnlimitedLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:984:1: entryRuleUnlimitedLiteralRule : ruleUnlimitedLiteralRule EOF ;
    public final void entryRuleUnlimitedLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:985:1: ( ruleUnlimitedLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:986:1: ruleUnlimitedLiteralRule EOF
            {
             before(grammarAccess.getUnlimitedLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_entryRuleUnlimitedLiteralRule2041);
            ruleUnlimitedLiteralRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleUnlimitedLiteralRule"


    // $ANTLR start "ruleUnlimitedLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:993:1: ruleUnlimitedLiteralRule : ( ( rule__UnlimitedLiteralRule__ValueAssignment ) ) ;
    public final void ruleUnlimitedLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:997:2: ( ( ( rule__UnlimitedLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:998:1: ( ( rule__UnlimitedLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:998:1: ( ( rule__UnlimitedLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:999:1: ( rule__UnlimitedLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1000:1: ( rule__UnlimitedLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1000:2: rule__UnlimitedLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__UnlimitedLiteralRule__ValueAssignment_in_ruleUnlimitedLiteralRule2074);
            rule__UnlimitedLiteralRule__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleUnlimitedLiteralRule"


    // $ANTLR start "entryRuleRealLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1012:1: entryRuleRealLiteralRule : ruleRealLiteralRule EOF ;
    public final void entryRuleRealLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1013:1: ( ruleRealLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1014:1: ruleRealLiteralRule EOF
            {
             before(grammarAccess.getRealLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleRealLiteralRule_in_entryRuleRealLiteralRule2101);
            ruleRealLiteralRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleRealLiteralRule"


    // $ANTLR start "ruleRealLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1021:1: ruleRealLiteralRule : ( ( rule__RealLiteralRule__ValueAssignment ) ) ;
    public final void ruleRealLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1025:2: ( ( ( rule__RealLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1026:1: ( ( rule__RealLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1026:1: ( ( rule__RealLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1027:1: ( rule__RealLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getRealLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1028:1: ( rule__RealLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1028:2: rule__RealLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__RealLiteralRule__ValueAssignment_in_ruleRealLiteralRule2134);
            rule__RealLiteralRule__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleRealLiteralRule"


    // $ANTLR start "entryRuleDateTimeLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1040:1: entryRuleDateTimeLiteralRule : ruleDateTimeLiteralRule EOF ;
    public final void entryRuleDateTimeLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1041:1: ( ruleDateTimeLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1042:1: ruleDateTimeLiteralRule EOF
            {
             before(grammarAccess.getDateTimeLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_entryRuleDateTimeLiteralRule2161);
            ruleDateTimeLiteralRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleDateTimeLiteralRule"


    // $ANTLR start "ruleDateTimeLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1049:1: ruleDateTimeLiteralRule : ( ( rule__DateTimeLiteralRule__ValueAssignment ) ) ;
    public final void ruleDateTimeLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1053:2: ( ( ( rule__DateTimeLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1054:1: ( ( rule__DateTimeLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1054:1: ( ( rule__DateTimeLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1055:1: ( rule__DateTimeLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getDateTimeLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1056:1: ( rule__DateTimeLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1056:2: rule__DateTimeLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__DateTimeLiteralRule__ValueAssignment_in_ruleDateTimeLiteralRule2194);
            rule__DateTimeLiteralRule__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleDateTimeLiteralRule"


    // $ANTLR start "entryRuleBooleanLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1068:1: entryRuleBooleanLiteralRule : ruleBooleanLiteralRule EOF ;
    public final void entryRuleBooleanLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1069:1: ( ruleBooleanLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1070:1: ruleBooleanLiteralRule EOF
            {
             before(grammarAccess.getBooleanLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteralRule_in_entryRuleBooleanLiteralRule2221);
            ruleBooleanLiteralRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleBooleanLiteralRule"


    // $ANTLR start "ruleBooleanLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1077:1: ruleBooleanLiteralRule : ( ( rule__BooleanLiteralRule__ValueAssignment ) ) ;
    public final void ruleBooleanLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1081:2: ( ( ( rule__BooleanLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1082:1: ( ( rule__BooleanLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1082:1: ( ( rule__BooleanLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1083:1: ( rule__BooleanLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getBooleanLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1084:1: ( rule__BooleanLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1084:2: rule__BooleanLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BooleanLiteralRule__ValueAssignment_in_ruleBooleanLiteralRule2254);
            rule__BooleanLiteralRule__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleBooleanLiteralRule"


    // $ANTLR start "entryRuleNullLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1096:1: entryRuleNullLiteralRule : ruleNullLiteralRule EOF ;
    public final void entryRuleNullLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1097:1: ( ruleNullLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1098:1: ruleNullLiteralRule EOF
            {
             before(grammarAccess.getNullLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleNullLiteralRule_in_entryRuleNullLiteralRule2281);
            ruleNullLiteralRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleNullLiteralRule"


    // $ANTLR start "ruleNullLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1105:1: ruleNullLiteralRule : ( ( rule__NullLiteralRule__ValueAssignment ) ) ;
    public final void ruleNullLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1109:2: ( ( ( rule__NullLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1110:1: ( ( rule__NullLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1110:1: ( ( rule__NullLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1111:1: ( rule__NullLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getNullLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1112:1: ( rule__NullLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1112:2: rule__NullLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__NullLiteralRule__ValueAssignment_in_ruleNullLiteralRule2314);
            rule__NullLiteralRule__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleNullLiteralRule"


    // $ANTLR start "entryRuleDefaultLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1124:1: entryRuleDefaultLiteralRule : ruleDefaultLiteralRule EOF ;
    public final void entryRuleDefaultLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1125:1: ( ruleDefaultLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1126:1: ruleDefaultLiteralRule EOF
            {
             before(grammarAccess.getDefaultLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleDefaultLiteralRule_in_entryRuleDefaultLiteralRule2341);
            ruleDefaultLiteralRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleDefaultLiteralRule"


    // $ANTLR start "ruleDefaultLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1133:1: ruleDefaultLiteralRule : ( ( rule__DefaultLiteralRule__ValueAssignment ) ) ;
    public final void ruleDefaultLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1137:2: ( ( ( rule__DefaultLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1138:1: ( ( rule__DefaultLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1138:1: ( ( rule__DefaultLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1139:1: ( rule__DefaultLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getDefaultLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1140:1: ( rule__DefaultLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1140:2: rule__DefaultLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__DefaultLiteralRule__ValueAssignment_in_ruleDefaultLiteralRule2374);
            rule__DefaultLiteralRule__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleDefaultLiteralRule"


    // $ANTLR start "entryRuleStringLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1152:1: entryRuleStringLiteralRule : ruleStringLiteralRule EOF ;
    public final void entryRuleStringLiteralRule() throws RecognitionException {
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1153:1: ( ruleStringLiteralRule EOF )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1154:1: ruleStringLiteralRule EOF
            {
             before(grammarAccess.getStringLiteralRuleRule()); 
            pushFollow(FOLLOW_ruleStringLiteralRule_in_entryRuleStringLiteralRule2401);
            ruleStringLiteralRule();

            state._fsp--;

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
    // $ANTLR end "entryRuleStringLiteralRule"


    // $ANTLR start "ruleStringLiteralRule"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1161:1: ruleStringLiteralRule : ( ( rule__StringLiteralRule__ValueAssignment ) ) ;
    public final void ruleStringLiteralRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1165:2: ( ( ( rule__StringLiteralRule__ValueAssignment ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1166:1: ( ( rule__StringLiteralRule__ValueAssignment ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1166:1: ( ( rule__StringLiteralRule__ValueAssignment ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1167:1: ( rule__StringLiteralRule__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralRuleAccess().getValueAssignment()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1168:1: ( rule__StringLiteralRule__ValueAssignment )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1168:2: rule__StringLiteralRule__ValueAssignment
            {
            pushFollow(FOLLOW_rule__StringLiteralRule__ValueAssignment_in_ruleStringLiteralRule2434);
            rule__StringLiteralRule__ValueAssignment();

            state._fsp--;


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
    // $ANTLR end "ruleStringLiteralRule"


    // $ANTLR start "rule__AndOrXorExpression__OpAlternatives_1_0_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1180:1: rule__AndOrXorExpression__OpAlternatives_1_0_0 : ( ( 'and' ) | ( 'or' ) | ( 'xor' ) );
    public final void rule__AndOrXorExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1184:1: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1185:1: ( 'and' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1185:1: ( 'and' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1186:1: 'and'
                    {
                     before(grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__AndOrXorExpression__OpAlternatives_1_0_02471); 
                     after(grammarAccess.getAndOrXorExpressionAccess().getOpAndKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1193:6: ( 'or' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1193:6: ( 'or' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1194:1: 'or'
                    {
                     before(grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__AndOrXorExpression__OpAlternatives_1_0_02491); 
                     after(grammarAccess.getAndOrXorExpressionAccess().getOpOrKeyword_1_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1201:6: ( 'xor' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1201:6: ( 'xor' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1202:1: 'xor'
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
    // $ANTLR end "rule__AndOrXorExpression__OpAlternatives_1_0_0"


    // $ANTLR start "rule__EqualityExpression__OpAlternatives_1_0_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1214:1: rule__EqualityExpression__OpAlternatives_1_0_0 : ( ( '==' ) | ( '<>' ) );
    public final void rule__EqualityExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1218:1: ( ( '==' ) | ( '<>' ) )
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
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1219:1: ( '==' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1219:1: ( '==' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1220:1: '=='
                    {
                     before(grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0()); 
                    match(input,19,FOLLOW_19_in_rule__EqualityExpression__OpAlternatives_1_0_02546); 
                     after(grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1227:6: ( '<>' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1227:6: ( '<>' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1228:1: '<>'
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
    // $ANTLR end "rule__EqualityExpression__OpAlternatives_1_0_0"


    // $ANTLR start "rule__RelationalExpression__OpAlternatives_1_0_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1240:1: rule__RelationalExpression__OpAlternatives_1_0_0 : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) );
    public final void rule__RelationalExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1244:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) )
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
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1245:1: ( '<' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1245:1: ( '<' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1246:1: '<'
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0()); 
                    match(input,21,FOLLOW_21_in_rule__RelationalExpression__OpAlternatives_1_0_02601); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1253:6: ( '>' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1253:6: ( '>' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1254:1: '>'
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1()); 
                    match(input,22,FOLLOW_22_in_rule__RelationalExpression__OpAlternatives_1_0_02621); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1261:6: ( '<=' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1261:6: ( '<=' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1262:1: '<='
                    {
                     before(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2()); 
                    match(input,23,FOLLOW_23_in_rule__RelationalExpression__OpAlternatives_1_0_02641); 
                     after(grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1269:6: ( '>=' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1269:6: ( '>=' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1270:1: '>='
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
    // $ANTLR end "rule__RelationalExpression__OpAlternatives_1_0_0"


    // $ANTLR start "rule__AdditiveExpression__OpAlternatives_1_0_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1282:1: rule__AdditiveExpression__OpAlternatives_1_0_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__AdditiveExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1286:1: ( ( '+' ) | ( '-' ) )
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
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1287:1: ( '+' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1287:1: ( '+' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1288:1: '+'
                    {
                     before(grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0()); 
                    match(input,25,FOLLOW_25_in_rule__AdditiveExpression__OpAlternatives_1_0_02696); 
                     after(grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1295:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1295:6: ( '-' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1296:1: '-'
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
    // $ANTLR end "rule__AdditiveExpression__OpAlternatives_1_0_0"


    // $ANTLR start "rule__MultiplicativeExpression__OpAlternatives_1_0_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1308:1: rule__MultiplicativeExpression__OpAlternatives_1_0_0 : ( ( '*' ) | ( '/' ) | ( 'mod' ) );
    public final void rule__MultiplicativeExpression__OpAlternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1312:1: ( ( '*' ) | ( '/' ) | ( 'mod' ) )
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
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1313:1: ( '*' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1313:1: ( '*' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1314:1: '*'
                    {
                     before(grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0()); 
                    match(input,27,FOLLOW_27_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02751); 
                     after(grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1321:6: ( '/' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1321:6: ( '/' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1322:1: '/'
                    {
                     before(grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1()); 
                    match(input,28,FOLLOW_28_in_rule__MultiplicativeExpression__OpAlternatives_1_0_02771); 
                     after(grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1329:6: ( 'mod' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1329:6: ( 'mod' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1330:1: 'mod'
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
    // $ANTLR end "rule__MultiplicativeExpression__OpAlternatives_1_0_0"


    // $ANTLR start "rule__UnaryExpression__Alternatives"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1342:1: rule__UnaryExpression__Alternatives : ( ( ( rule__UnaryExpression__Group_0__0 ) ) | ( ( rule__UnaryExpression__ExpAssignment_1 ) ) );
    public final void rule__UnaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1346:1: ( ( ( rule__UnaryExpression__Group_0__0 ) ) | ( ( rule__UnaryExpression__ExpAssignment_1 ) ) )
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
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1347:1: ( ( rule__UnaryExpression__Group_0__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1347:1: ( ( rule__UnaryExpression__Group_0__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1348:1: ( rule__UnaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getGroup_0()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1349:1: ( rule__UnaryExpression__Group_0__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1349:2: rule__UnaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__UnaryExpression__Group_0__0_in_rule__UnaryExpression__Alternatives2825);
                    rule__UnaryExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1353:6: ( ( rule__UnaryExpression__ExpAssignment_1 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1353:6: ( ( rule__UnaryExpression__ExpAssignment_1 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1354:1: ( rule__UnaryExpression__ExpAssignment_1 )
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getExpAssignment_1()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1355:1: ( rule__UnaryExpression__ExpAssignment_1 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1355:2: rule__UnaryExpression__ExpAssignment_1
                    {
                    pushFollow(FOLLOW_rule__UnaryExpression__ExpAssignment_1_in_rule__UnaryExpression__Alternatives2843);
                    rule__UnaryExpression__ExpAssignment_1();

                    state._fsp--;


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
    // $ANTLR end "rule__UnaryExpression__Alternatives"


    // $ANTLR start "rule__UnaryExpression__OpAlternatives_0_0_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1364:1: rule__UnaryExpression__OpAlternatives_0_0_0 : ( ( 'not' ) | ( '-' ) | ( '+' ) );
    public final void rule__UnaryExpression__OpAlternatives_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1368:1: ( ( 'not' ) | ( '-' ) | ( '+' ) )
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
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1369:1: ( 'not' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1369:1: ( 'not' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1370:1: 'not'
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0()); 
                    match(input,30,FOLLOW_30_in_rule__UnaryExpression__OpAlternatives_0_0_02877); 
                     after(grammarAccess.getUnaryExpressionAccess().getOpNotKeyword_0_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1377:6: ( '-' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1377:6: ( '-' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1378:1: '-'
                    {
                     before(grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1()); 
                    match(input,26,FOLLOW_26_in_rule__UnaryExpression__OpAlternatives_0_0_02897); 
                     after(grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1385:6: ( '+' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1385:6: ( '+' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1386:1: '+'
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
    // $ANTLR end "rule__UnaryExpression__OpAlternatives_0_0_0"


    // $ANTLR start "rule__ValueSpecification__Alternatives"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1398:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );
    public final void rule__ValueSpecification__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1402:1: ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) )
            int alt8=8;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1403:1: ( ruleLiteral )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1403:1: ( ruleLiteral )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1404:1: ruleLiteral
                    {
                     before(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLiteral_in_rule__ValueSpecification__Alternatives2951);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1409:6: ( ruleNameOrChoiceOrBehaviorCall )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1409:6: ( ruleNameOrChoiceOrBehaviorCall )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1410:1: ruleNameOrChoiceOrBehaviorCall
                    {
                     before(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNameOrChoiceOrBehaviorCall_in_rule__ValueSpecification__Alternatives2968);
                    ruleNameOrChoiceOrBehaviorCall();

                    state._fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getNameOrChoiceOrBehaviorCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1415:6: ( ruleInterval )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1415:6: ( ruleInterval )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1416:1: ruleInterval
                    {
                     before(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleInterval_in_rule__ValueSpecification__Alternatives2985);
                    ruleInterval();

                    state._fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getIntervalParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1421:6: ( ruleCollectionOrTuple )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1421:6: ( ruleCollectionOrTuple )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1422:1: ruleCollectionOrTuple
                    {
                     before(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleCollectionOrTuple_in_rule__ValueSpecification__Alternatives3002);
                    ruleCollectionOrTuple();

                    state._fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getCollectionOrTupleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1427:6: ( ruleTuple )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1427:6: ( ruleTuple )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1428:1: ruleTuple
                    {
                     before(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleTuple_in_rule__ValueSpecification__Alternatives3019);
                    ruleTuple();

                    state._fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getTupleParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1433:6: ( ruleTimeExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1433:6: ( ruleTimeExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1434:1: ruleTimeExpression
                    {
                     before(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleTimeExpression_in_rule__ValueSpecification__Alternatives3036);
                    ruleTimeExpression();

                    state._fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getTimeExpressionParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1439:6: ( ruleVariableDeclaration )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1439:6: ( ruleVariableDeclaration )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1440:1: ruleVariableDeclaration
                    {
                     before(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_rule__ValueSpecification__Alternatives3053);
                    ruleVariableDeclaration();

                    state._fsp--;

                     after(grammarAccess.getValueSpecificationAccess().getVariableDeclarationParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1445:6: ( ( rule__ValueSpecification__Group_7__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1445:6: ( ( rule__ValueSpecification__Group_7__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1446:1: ( rule__ValueSpecification__Group_7__0 )
                    {
                     before(grammarAccess.getValueSpecificationAccess().getGroup_7()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1447:1: ( rule__ValueSpecification__Group_7__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1447:2: rule__ValueSpecification__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__ValueSpecification__Group_7__0_in_rule__ValueSpecification__Alternatives3070);
                    rule__ValueSpecification__Group_7__0();

                    state._fsp--;


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
    // $ANTLR end "rule__ValueSpecification__Alternatives"


    // $ANTLR start "rule__SuffixExpression__Alternatives"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1456:1: rule__SuffixExpression__Alternatives : ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) );
    public final void rule__SuffixExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1460:1: ( ( rulePropertyCallExpression ) | ( ruleOperationCallExpression ) )
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
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1461:1: ( rulePropertyCallExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1461:1: ( rulePropertyCallExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1462:1: rulePropertyCallExpression
                    {
                     before(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_rule__SuffixExpression__Alternatives3103);
                    rulePropertyCallExpression();

                    state._fsp--;

                     after(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1467:6: ( ruleOperationCallExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1467:6: ( ruleOperationCallExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1468:1: ruleOperationCallExpression
                    {
                     before(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_rule__SuffixExpression__Alternatives3120);
                    ruleOperationCallExpression();

                    state._fsp--;

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
    // $ANTLR end "rule__SuffixExpression__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1478:1: rule__Literal__Alternatives : ( ( ruleNumberLiteralRule ) | ( ruleDateTimeLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleNullLiteralRule ) | ( ruleDefaultLiteralRule ) | ( ruleStringLiteralRule ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1482:1: ( ( ruleNumberLiteralRule ) | ( ruleDateTimeLiteralRule ) | ( ruleBooleanLiteralRule ) | ( ruleNullLiteralRule ) | ( ruleDefaultLiteralRule ) | ( ruleStringLiteralRule ) )
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
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1483:1: ( ruleNumberLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1483:1: ( ruleNumberLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1484:1: ruleNumberLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNumberLiteralRule_in_rule__Literal__Alternatives3152);
                    ruleNumberLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1489:6: ( ruleDateTimeLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1489:6: ( ruleDateTimeLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1490:1: ruleDateTimeLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDateTimeLiteralRule_in_rule__Literal__Alternatives3169);
                    ruleDateTimeLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getDateTimeLiteralRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1495:6: ( ruleBooleanLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1495:6: ( ruleBooleanLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1496:1: ruleBooleanLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleBooleanLiteralRule_in_rule__Literal__Alternatives3186);
                    ruleBooleanLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanLiteralRuleParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1501:6: ( ruleNullLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1501:6: ( ruleNullLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1502:1: ruleNullLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleNullLiteralRule_in_rule__Literal__Alternatives3203);
                    ruleNullLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNullLiteralRuleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1507:6: ( ruleDefaultLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1507:6: ( ruleDefaultLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1508:1: ruleDefaultLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleDefaultLiteralRule_in_rule__Literal__Alternatives3220);
                    ruleDefaultLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getDefaultLiteralRuleParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1513:6: ( ruleStringLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1513:6: ( ruleStringLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1514:1: ruleStringLiteralRule
                    {
                     before(grammarAccess.getLiteralAccess().getStringLiteralRuleParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleStringLiteralRule_in_rule__Literal__Alternatives3237);
                    ruleStringLiteralRule();

                    state._fsp--;

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
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__Interval__Alternatives_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1524:1: rule__Interval__Alternatives_0 : ( ( ']' ) | ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) ) );
    public final void rule__Interval__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1528:1: ( ( ']' ) | ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) ) )
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
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1529:1: ( ']' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1529:1: ( ']' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1530:1: ']'
                    {
                     before(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0()); 
                    match(input,31,FOLLOW_31_in_rule__Interval__Alternatives_03270); 
                     after(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1537:6: ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1537:6: ( ( rule__Interval__IsLowerIncludedAssignment_0_1 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1538:1: ( rule__Interval__IsLowerIncludedAssignment_0_1 )
                    {
                     before(grammarAccess.getIntervalAccess().getIsLowerIncludedAssignment_0_1()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1539:1: ( rule__Interval__IsLowerIncludedAssignment_0_1 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1539:2: rule__Interval__IsLowerIncludedAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__Interval__IsLowerIncludedAssignment_0_1_in_rule__Interval__Alternatives_03289);
                    rule__Interval__IsLowerIncludedAssignment_0_1();

                    state._fsp--;


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
    // $ANTLR end "rule__Interval__Alternatives_0"


    // $ANTLR start "rule__Interval__Alternatives_4"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1548:1: rule__Interval__Alternatives_4 : ( ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) ) | ( '[' ) );
    public final void rule__Interval__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1552:1: ( ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) ) | ( '[' ) )
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
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1553:1: ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1553:1: ( ( rule__Interval__IsUpperIncludedAssignment_4_0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1554:1: ( rule__Interval__IsUpperIncludedAssignment_4_0 )
                    {
                     before(grammarAccess.getIntervalAccess().getIsUpperIncludedAssignment_4_0()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1555:1: ( rule__Interval__IsUpperIncludedAssignment_4_0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1555:2: rule__Interval__IsUpperIncludedAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__Interval__IsUpperIncludedAssignment_4_0_in_rule__Interval__Alternatives_43322);
                    rule__Interval__IsUpperIncludedAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntervalAccess().getIsUpperIncludedAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1559:6: ( '[' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1559:6: ( '[' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1560:1: '['
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
    // $ANTLR end "rule__Interval__Alternatives_4"


    // $ANTLR start "rule__TimeExpression__Alternatives"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1572:1: rule__TimeExpression__Alternatives : ( ( ruleInstantObsExpression ) | ( ruleDurationObsExpression ) | ( ruleJitterExp ) );
    public final void rule__TimeExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1576:1: ( ( ruleInstantObsExpression ) | ( ruleDurationObsExpression ) | ( ruleJitterExp ) )
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
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1577:1: ( ruleInstantObsExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1577:1: ( ruleInstantObsExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1578:1: ruleInstantObsExpression
                    {
                     before(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleInstantObsExpression_in_rule__TimeExpression__Alternatives3375);
                    ruleInstantObsExpression();

                    state._fsp--;

                     after(grammarAccess.getTimeExpressionAccess().getInstantObsExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1583:6: ( ruleDurationObsExpression )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1583:6: ( ruleDurationObsExpression )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1584:1: ruleDurationObsExpression
                    {
                     before(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDurationObsExpression_in_rule__TimeExpression__Alternatives3392);
                    ruleDurationObsExpression();

                    state._fsp--;

                     after(grammarAccess.getTimeExpressionAccess().getDurationObsExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1589:6: ( ruleJitterExp )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1589:6: ( ruleJitterExp )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1590:1: ruleJitterExp
                    {
                     before(grammarAccess.getTimeExpressionAccess().getJitterExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleJitterExp_in_rule__TimeExpression__Alternatives3409);
                    ruleJitterExp();

                    state._fsp--;

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
    // $ANTLR end "rule__TimeExpression__Alternatives"


    // $ANTLR start "rule__VariableDeclaration__Alternatives_3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1600:1: rule__VariableDeclaration__Alternatives_3 : ( ( ( rule__VariableDeclaration__Group_3_0__0 ) ) | ( ( rule__VariableDeclaration__Group_3_1__0 ) ) );
    public final void rule__VariableDeclaration__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1604:1: ( ( ( rule__VariableDeclaration__Group_3_0__0 ) ) | ( ( rule__VariableDeclaration__Group_3_1__0 ) ) )
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
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1605:1: ( ( rule__VariableDeclaration__Group_3_0__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1605:1: ( ( rule__VariableDeclaration__Group_3_0__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1606:1: ( rule__VariableDeclaration__Group_3_0__0 )
                    {
                     before(grammarAccess.getVariableDeclarationAccess().getGroup_3_0()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1607:1: ( rule__VariableDeclaration__Group_3_0__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1607:2: rule__VariableDeclaration__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__0_in_rule__VariableDeclaration__Alternatives_33441);
                    rule__VariableDeclaration__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getVariableDeclarationAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1611:6: ( ( rule__VariableDeclaration__Group_3_1__0 ) )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1611:6: ( ( rule__VariableDeclaration__Group_3_1__0 ) )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1612:1: ( rule__VariableDeclaration__Group_3_1__0 )
                    {
                     before(grammarAccess.getVariableDeclarationAccess().getGroup_3_1()); 
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1613:1: ( rule__VariableDeclaration__Group_3_1__0 )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1613:2: rule__VariableDeclaration__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__0_in_rule__VariableDeclaration__Alternatives_33459);
                    rule__VariableDeclaration__Group_3_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__VariableDeclaration__Alternatives_3"


    // $ANTLR start "rule__VariableDirectionKind__Alternatives"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1622:1: rule__VariableDirectionKind__Alternatives : ( ( 'in' ) | ( 'out' ) | ( 'inout' ) );
    public final void rule__VariableDirectionKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1626:1: ( ( 'in' ) | ( 'out' ) | ( 'inout' ) )
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
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1627:1: ( 'in' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1627:1: ( 'in' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1628:1: 'in'
                    {
                     before(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0()); 
                    match(input,33,FOLLOW_33_in_rule__VariableDirectionKind__Alternatives3493); 
                     after(grammarAccess.getVariableDirectionKindAccess().getInKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1635:6: ( 'out' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1635:6: ( 'out' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1636:1: 'out'
                    {
                     before(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1()); 
                    match(input,34,FOLLOW_34_in_rule__VariableDirectionKind__Alternatives3513); 
                     after(grammarAccess.getVariableDirectionKindAccess().getOutKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1643:6: ( 'inout' )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1643:6: ( 'inout' )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1644:1: 'inout'
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
    // $ANTLR end "rule__VariableDirectionKind__Alternatives"


    // $ANTLR start "rule__NumberLiteralRule__Alternatives"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1656:1: rule__NumberLiteralRule__Alternatives : ( ( ruleIntegerLiteralRule ) | ( ruleUnlimitedLiteralRule ) | ( ruleRealLiteralRule ) );
    public final void rule__NumberLiteralRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1660:1: ( ( ruleIntegerLiteralRule ) | ( ruleUnlimitedLiteralRule ) | ( ruleRealLiteralRule ) )
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
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1661:1: ( ruleIntegerLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1661:1: ( ruleIntegerLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1662:1: ruleIntegerLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntegerLiteralRule_in_rule__NumberLiteralRule__Alternatives3567);
                    ruleIntegerLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralRuleAccess().getIntegerLiteralRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1667:6: ( ruleUnlimitedLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1667:6: ( ruleUnlimitedLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1668:1: ruleUnlimitedLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleUnlimitedLiteralRule_in_rule__NumberLiteralRule__Alternatives3584);
                    ruleUnlimitedLiteralRule();

                    state._fsp--;

                     after(grammarAccess.getNumberLiteralRuleAccess().getUnlimitedLiteralRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1673:6: ( ruleRealLiteralRule )
                    {
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1673:6: ( ruleRealLiteralRule )
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1674:1: ruleRealLiteralRule
                    {
                     before(grammarAccess.getNumberLiteralRuleAccess().getRealLiteralRuleParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleRealLiteralRule_in_rule__NumberLiteralRule__Alternatives3601);
                    ruleRealLiteralRule();

                    state._fsp--;

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
    // $ANTLR end "rule__NumberLiteralRule__Alternatives"


    // $ANTLR start "rule__AndOrXorExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1686:1: rule__AndOrXorExpression__Group__0 : rule__AndOrXorExpression__Group__0__Impl rule__AndOrXorExpression__Group__1 ;
    public final void rule__AndOrXorExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1690:1: ( rule__AndOrXorExpression__Group__0__Impl rule__AndOrXorExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1691:2: rule__AndOrXorExpression__Group__0__Impl rule__AndOrXorExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__0__Impl_in_rule__AndOrXorExpression__Group__03631);
            rule__AndOrXorExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__1_in_rule__AndOrXorExpression__Group__03634);
            rule__AndOrXorExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOrXorExpression__Group__0"


    // $ANTLR start "rule__AndOrXorExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1698:1: rule__AndOrXorExpression__Group__0__Impl : ( ( rule__AndOrXorExpression__ExpAssignment_0 ) ) ;
    public final void rule__AndOrXorExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1702:1: ( ( ( rule__AndOrXorExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1703:1: ( ( rule__AndOrXorExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1703:1: ( ( rule__AndOrXorExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1704:1: ( rule__AndOrXorExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1705:1: ( rule__AndOrXorExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1705:2: rule__AndOrXorExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__ExpAssignment_0_in_rule__AndOrXorExpression__Group__0__Impl3661);
            rule__AndOrXorExpression__ExpAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__AndOrXorExpression__Group__0__Impl"


    // $ANTLR start "rule__AndOrXorExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1715:1: rule__AndOrXorExpression__Group__1 : rule__AndOrXorExpression__Group__1__Impl ;
    public final void rule__AndOrXorExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1719:1: ( rule__AndOrXorExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1720:2: rule__AndOrXorExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group__1__Impl_in_rule__AndOrXorExpression__Group__13691);
            rule__AndOrXorExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOrXorExpression__Group__1"


    // $ANTLR start "rule__AndOrXorExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1726:1: rule__AndOrXorExpression__Group__1__Impl : ( ( rule__AndOrXorExpression__Group_1__0 )* ) ;
    public final void rule__AndOrXorExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1730:1: ( ( ( rule__AndOrXorExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1731:1: ( ( rule__AndOrXorExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1731:1: ( ( rule__AndOrXorExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1732:1: ( rule__AndOrXorExpression__Group_1__0 )*
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1733:1: ( rule__AndOrXorExpression__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=16 && LA17_0<=18)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1733:2: rule__AndOrXorExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__0_in_rule__AndOrXorExpression__Group__1__Impl3718);
            	    rule__AndOrXorExpression__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__AndOrXorExpression__Group__1__Impl"


    // $ANTLR start "rule__AndOrXorExpression__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1747:1: rule__AndOrXorExpression__Group_1__0 : rule__AndOrXorExpression__Group_1__0__Impl rule__AndOrXorExpression__Group_1__1 ;
    public final void rule__AndOrXorExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1751:1: ( rule__AndOrXorExpression__Group_1__0__Impl rule__AndOrXorExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1752:2: rule__AndOrXorExpression__Group_1__0__Impl rule__AndOrXorExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__0__Impl_in_rule__AndOrXorExpression__Group_1__03753);
            rule__AndOrXorExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__1_in_rule__AndOrXorExpression__Group_1__03756);
            rule__AndOrXorExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOrXorExpression__Group_1__0"


    // $ANTLR start "rule__AndOrXorExpression__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1759:1: rule__AndOrXorExpression__Group_1__0__Impl : ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) ) ;
    public final void rule__AndOrXorExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1763:1: ( ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1764:1: ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1764:1: ( ( rule__AndOrXorExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1765:1: ( rule__AndOrXorExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1766:1: ( rule__AndOrXorExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1766:2: rule__AndOrXorExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__OpAssignment_1_0_in_rule__AndOrXorExpression__Group_1__0__Impl3783);
            rule__AndOrXorExpression__OpAssignment_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__AndOrXorExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AndOrXorExpression__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1776:1: rule__AndOrXorExpression__Group_1__1 : rule__AndOrXorExpression__Group_1__1__Impl ;
    public final void rule__AndOrXorExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1780:1: ( rule__AndOrXorExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1781:2: rule__AndOrXorExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__Group_1__1__Impl_in_rule__AndOrXorExpression__Group_1__13813);
            rule__AndOrXorExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOrXorExpression__Group_1__1"


    // $ANTLR start "rule__AndOrXorExpression__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1787:1: rule__AndOrXorExpression__Group_1__1__Impl : ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__AndOrXorExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1791:1: ( ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1792:1: ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1792:1: ( ( rule__AndOrXorExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1793:1: ( rule__AndOrXorExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1794:1: ( rule__AndOrXorExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1794:2: rule__AndOrXorExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__ExpAssignment_1_1_in_rule__AndOrXorExpression__Group_1__1__Impl3840);
            rule__AndOrXorExpression__ExpAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__AndOrXorExpression__Group_1__1__Impl"


    // $ANTLR start "rule__EqualityExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1808:1: rule__EqualityExpression__Group__0 : rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 ;
    public final void rule__EqualityExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1812:1: ( rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1813:2: rule__EqualityExpression__Group__0__Impl rule__EqualityExpression__Group__1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__0__Impl_in_rule__EqualityExpression__Group__03874);
            rule__EqualityExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EqualityExpression__Group__1_in_rule__EqualityExpression__Group__03877);
            rule__EqualityExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__0"


    // $ANTLR start "rule__EqualityExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1820:1: rule__EqualityExpression__Group__0__Impl : ( ( rule__EqualityExpression__ExpAssignment_0 ) ) ;
    public final void rule__EqualityExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1824:1: ( ( ( rule__EqualityExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1825:1: ( ( rule__EqualityExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1825:1: ( ( rule__EqualityExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1826:1: ( rule__EqualityExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1827:1: ( rule__EqualityExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1827:2: rule__EqualityExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__ExpAssignment_0_in_rule__EqualityExpression__Group__0__Impl3904);
            rule__EqualityExpression__ExpAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__EqualityExpression__Group__0__Impl"


    // $ANTLR start "rule__EqualityExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1837:1: rule__EqualityExpression__Group__1 : rule__EqualityExpression__Group__1__Impl ;
    public final void rule__EqualityExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1841:1: ( rule__EqualityExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1842:2: rule__EqualityExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group__1__Impl_in_rule__EqualityExpression__Group__13934);
            rule__EqualityExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group__1"


    // $ANTLR start "rule__EqualityExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1848:1: rule__EqualityExpression__Group__1__Impl : ( ( rule__EqualityExpression__Group_1__0 )* ) ;
    public final void rule__EqualityExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1852:1: ( ( ( rule__EqualityExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1853:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1853:1: ( ( rule__EqualityExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1854:1: ( rule__EqualityExpression__Group_1__0 )*
            {
             before(grammarAccess.getEqualityExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1855:1: ( rule__EqualityExpression__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=19 && LA18_0<=20)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1855:2: rule__EqualityExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__EqualityExpression__Group_1__0_in_rule__EqualityExpression__Group__1__Impl3961);
            	    rule__EqualityExpression__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__EqualityExpression__Group__1__Impl"


    // $ANTLR start "rule__EqualityExpression__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1869:1: rule__EqualityExpression__Group_1__0 : rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 ;
    public final void rule__EqualityExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1873:1: ( rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1874:2: rule__EqualityExpression__Group_1__0__Impl rule__EqualityExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group_1__0__Impl_in_rule__EqualityExpression__Group_1__03996);
            rule__EqualityExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EqualityExpression__Group_1__1_in_rule__EqualityExpression__Group_1__03999);
            rule__EqualityExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1__0"


    // $ANTLR start "rule__EqualityExpression__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1881:1: rule__EqualityExpression__Group_1__0__Impl : ( ( rule__EqualityExpression__OpAssignment_1_0 ) ) ;
    public final void rule__EqualityExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1885:1: ( ( ( rule__EqualityExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1886:1: ( ( rule__EqualityExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1886:1: ( ( rule__EqualityExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1887:1: ( rule__EqualityExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1888:1: ( rule__EqualityExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1888:2: rule__EqualityExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__OpAssignment_1_0_in_rule__EqualityExpression__Group_1__0__Impl4026);
            rule__EqualityExpression__OpAssignment_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__EqualityExpression__Group_1__0__Impl"


    // $ANTLR start "rule__EqualityExpression__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1898:1: rule__EqualityExpression__Group_1__1 : rule__EqualityExpression__Group_1__1__Impl ;
    public final void rule__EqualityExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1902:1: ( rule__EqualityExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1903:2: rule__EqualityExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpression__Group_1__1__Impl_in_rule__EqualityExpression__Group_1__14056);
            rule__EqualityExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpression__Group_1__1"


    // $ANTLR start "rule__EqualityExpression__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1909:1: rule__EqualityExpression__Group_1__1__Impl : ( ( rule__EqualityExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__EqualityExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1913:1: ( ( ( rule__EqualityExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1914:1: ( ( rule__EqualityExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1914:1: ( ( rule__EqualityExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1915:1: ( rule__EqualityExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1916:1: ( rule__EqualityExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1916:2: rule__EqualityExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__EqualityExpression__ExpAssignment_1_1_in_rule__EqualityExpression__Group_1__1__Impl4083);
            rule__EqualityExpression__ExpAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__EqualityExpression__Group_1__1__Impl"


    // $ANTLR start "rule__RelationalExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1930:1: rule__RelationalExpression__Group__0 : rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 ;
    public final void rule__RelationalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1934:1: ( rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1935:2: rule__RelationalExpression__Group__0__Impl rule__RelationalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__0__Impl_in_rule__RelationalExpression__Group__04117);
            rule__RelationalExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RelationalExpression__Group__1_in_rule__RelationalExpression__Group__04120);
            rule__RelationalExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__0"


    // $ANTLR start "rule__RelationalExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1942:1: rule__RelationalExpression__Group__0__Impl : ( ( rule__RelationalExpression__ExpAssignment_0 ) ) ;
    public final void rule__RelationalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1946:1: ( ( ( rule__RelationalExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1947:1: ( ( rule__RelationalExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1947:1: ( ( rule__RelationalExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1948:1: ( rule__RelationalExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1949:1: ( rule__RelationalExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1949:2: rule__RelationalExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__ExpAssignment_0_in_rule__RelationalExpression__Group__0__Impl4147);
            rule__RelationalExpression__ExpAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__RelationalExpression__Group__0__Impl"


    // $ANTLR start "rule__RelationalExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1959:1: rule__RelationalExpression__Group__1 : rule__RelationalExpression__Group__1__Impl ;
    public final void rule__RelationalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1963:1: ( rule__RelationalExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1964:2: rule__RelationalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group__1__Impl_in_rule__RelationalExpression__Group__14177);
            rule__RelationalExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group__1"


    // $ANTLR start "rule__RelationalExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1970:1: rule__RelationalExpression__Group__1__Impl : ( ( rule__RelationalExpression__Group_1__0 )* ) ;
    public final void rule__RelationalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1974:1: ( ( ( rule__RelationalExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1975:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1975:1: ( ( rule__RelationalExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1976:1: ( rule__RelationalExpression__Group_1__0 )*
            {
             before(grammarAccess.getRelationalExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1977:1: ( rule__RelationalExpression__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=21 && LA19_0<=24)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1977:2: rule__RelationalExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__RelationalExpression__Group_1__0_in_rule__RelationalExpression__Group__1__Impl4204);
            	    rule__RelationalExpression__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__RelationalExpression__Group__1__Impl"


    // $ANTLR start "rule__RelationalExpression__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1991:1: rule__RelationalExpression__Group_1__0 : rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 ;
    public final void rule__RelationalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1995:1: ( rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:1996:2: rule__RelationalExpression__Group_1__0__Impl rule__RelationalExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group_1__0__Impl_in_rule__RelationalExpression__Group_1__04239);
            rule__RelationalExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RelationalExpression__Group_1__1_in_rule__RelationalExpression__Group_1__04242);
            rule__RelationalExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1__0"


    // $ANTLR start "rule__RelationalExpression__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2003:1: rule__RelationalExpression__Group_1__0__Impl : ( ( rule__RelationalExpression__OpAssignment_1_0 ) ) ;
    public final void rule__RelationalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2007:1: ( ( ( rule__RelationalExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2008:1: ( ( rule__RelationalExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2008:1: ( ( rule__RelationalExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2009:1: ( rule__RelationalExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2010:1: ( rule__RelationalExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2010:2: rule__RelationalExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__OpAssignment_1_0_in_rule__RelationalExpression__Group_1__0__Impl4269);
            rule__RelationalExpression__OpAssignment_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__RelationalExpression__Group_1__0__Impl"


    // $ANTLR start "rule__RelationalExpression__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2020:1: rule__RelationalExpression__Group_1__1 : rule__RelationalExpression__Group_1__1__Impl ;
    public final void rule__RelationalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2024:1: ( rule__RelationalExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2025:2: rule__RelationalExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RelationalExpression__Group_1__1__Impl_in_rule__RelationalExpression__Group_1__14299);
            rule__RelationalExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelationalExpression__Group_1__1"


    // $ANTLR start "rule__RelationalExpression__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2031:1: rule__RelationalExpression__Group_1__1__Impl : ( ( rule__RelationalExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__RelationalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2035:1: ( ( ( rule__RelationalExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2036:1: ( ( rule__RelationalExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2036:1: ( ( rule__RelationalExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2037:1: ( rule__RelationalExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2038:1: ( rule__RelationalExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2038:2: rule__RelationalExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RelationalExpression__ExpAssignment_1_1_in_rule__RelationalExpression__Group_1__1__Impl4326);
            rule__RelationalExpression__ExpAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__RelationalExpression__Group_1__1__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2052:1: rule__ConditionalExpression__Group__0 : rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 ;
    public final void rule__ConditionalExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2056:1: ( rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2057:2: rule__ConditionalExpression__Group__0__Impl rule__ConditionalExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__04360);
            rule__ConditionalExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1_in_rule__ConditionalExpression__Group__04363);
            rule__ConditionalExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group__0"


    // $ANTLR start "rule__ConditionalExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2064:1: rule__ConditionalExpression__Group__0__Impl : ( ( rule__ConditionalExpression__ExpAssignment_0 ) ) ;
    public final void rule__ConditionalExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2068:1: ( ( ( rule__ConditionalExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2069:1: ( ( rule__ConditionalExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2069:1: ( ( rule__ConditionalExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2070:1: ( rule__ConditionalExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2071:1: ( rule__ConditionalExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2071:2: rule__ConditionalExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__ExpAssignment_0_in_rule__ConditionalExpression__Group__0__Impl4390);
            rule__ConditionalExpression__ExpAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__ConditionalExpression__Group__0__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2081:1: rule__ConditionalExpression__Group__1 : rule__ConditionalExpression__Group__1__Impl ;
    public final void rule__ConditionalExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2085:1: ( rule__ConditionalExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2086:2: rule__ConditionalExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group__1__Impl_in_rule__ConditionalExpression__Group__14420);
            rule__ConditionalExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group__1"


    // $ANTLR start "rule__ConditionalExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2092:1: rule__ConditionalExpression__Group__1__Impl : ( ( rule__ConditionalExpression__Group_1__0 )? ) ;
    public final void rule__ConditionalExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2096:1: ( ( ( rule__ConditionalExpression__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2097:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2097:1: ( ( rule__ConditionalExpression__Group_1__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2098:1: ( rule__ConditionalExpression__Group_1__0 )?
            {
             before(grammarAccess.getConditionalExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2099:1: ( rule__ConditionalExpression__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==51) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2099:2: rule__ConditionalExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0_in_rule__ConditionalExpression__Group__1__Impl4447);
                    rule__ConditionalExpression__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__ConditionalExpression__Group__1__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2113:1: rule__ConditionalExpression__Group_1__0 : rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 ;
    public final void rule__ConditionalExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2117:1: ( rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2118:2: rule__ConditionalExpression__Group_1__0__Impl rule__ConditionalExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__0__Impl_in_rule__ConditionalExpression__Group_1__04482);
            rule__ConditionalExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1_in_rule__ConditionalExpression__Group_1__04485);
            rule__ConditionalExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__0"


    // $ANTLR start "rule__ConditionalExpression__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2125:1: rule__ConditionalExpression__Group_1__0__Impl : ( ( rule__ConditionalExpression__OpAssignment_1_0 ) ) ;
    public final void rule__ConditionalExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2129:1: ( ( ( rule__ConditionalExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2130:1: ( ( rule__ConditionalExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2130:1: ( ( rule__ConditionalExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2131:1: ( rule__ConditionalExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2132:1: ( rule__ConditionalExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2132:2: rule__ConditionalExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__OpAssignment_1_0_in_rule__ConditionalExpression__Group_1__0__Impl4512);
            rule__ConditionalExpression__OpAssignment_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__ConditionalExpression__Group_1__0__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2142:1: rule__ConditionalExpression__Group_1__1 : rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 ;
    public final void rule__ConditionalExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2146:1: ( rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2147:2: rule__ConditionalExpression__Group_1__1__Impl rule__ConditionalExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__1__Impl_in_rule__ConditionalExpression__Group_1__14542);
            rule__ConditionalExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2_in_rule__ConditionalExpression__Group_1__14545);
            rule__ConditionalExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__1"


    // $ANTLR start "rule__ConditionalExpression__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2154:1: rule__ConditionalExpression__Group_1__1__Impl : ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__ConditionalExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2158:1: ( ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2159:1: ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2159:1: ( ( rule__ConditionalExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2160:1: ( rule__ConditionalExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2161:1: ( rule__ConditionalExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2161:2: rule__ConditionalExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__ExpAssignment_1_1_in_rule__ConditionalExpression__Group_1__1__Impl4572);
            rule__ConditionalExpression__ExpAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__ConditionalExpression__Group_1__1__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group_1__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2171:1: rule__ConditionalExpression__Group_1__2 : rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 ;
    public final void rule__ConditionalExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2175:1: ( rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2176:2: rule__ConditionalExpression__Group_1__2__Impl rule__ConditionalExpression__Group_1__3
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__2__Impl_in_rule__ConditionalExpression__Group_1__24602);
            rule__ConditionalExpression__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3_in_rule__ConditionalExpression__Group_1__24605);
            rule__ConditionalExpression__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__2"


    // $ANTLR start "rule__ConditionalExpression__Group_1__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2183:1: rule__ConditionalExpression__Group_1__2__Impl : ( ':' ) ;
    public final void rule__ConditionalExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2187:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2188:1: ( ':' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2188:1: ( ':' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2189:1: ':'
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
    // $ANTLR end "rule__ConditionalExpression__Group_1__2__Impl"


    // $ANTLR start "rule__ConditionalExpression__Group_1__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2202:1: rule__ConditionalExpression__Group_1__3 : rule__ConditionalExpression__Group_1__3__Impl ;
    public final void rule__ConditionalExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2206:1: ( rule__ConditionalExpression__Group_1__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2207:2: rule__ConditionalExpression__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__Group_1__3__Impl_in_rule__ConditionalExpression__Group_1__34664);
            rule__ConditionalExpression__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalExpression__Group_1__3"


    // $ANTLR start "rule__ConditionalExpression__Group_1__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2213:1: rule__ConditionalExpression__Group_1__3__Impl : ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) ) ;
    public final void rule__ConditionalExpression__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2217:1: ( ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2218:1: ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2218:1: ( ( rule__ConditionalExpression__ExpAssignment_1_3 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2219:1: ( rule__ConditionalExpression__ExpAssignment_1_3 )
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAssignment_1_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2220:1: ( rule__ConditionalExpression__ExpAssignment_1_3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2220:2: rule__ConditionalExpression__ExpAssignment_1_3
            {
            pushFollow(FOLLOW_rule__ConditionalExpression__ExpAssignment_1_3_in_rule__ConditionalExpression__Group_1__3__Impl4691);
            rule__ConditionalExpression__ExpAssignment_1_3();

            state._fsp--;


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
    // $ANTLR end "rule__ConditionalExpression__Group_1__3__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2238:1: rule__AdditiveExpression__Group__0 : rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 ;
    public final void rule__AdditiveExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2242:1: ( rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2243:2: rule__AdditiveExpression__Group__0__Impl rule__AdditiveExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__0__Impl_in_rule__AdditiveExpression__Group__04729);
            rule__AdditiveExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AdditiveExpression__Group__1_in_rule__AdditiveExpression__Group__04732);
            rule__AdditiveExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__0"


    // $ANTLR start "rule__AdditiveExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2250:1: rule__AdditiveExpression__Group__0__Impl : ( ( rule__AdditiveExpression__ExpAssignment_0 ) ) ;
    public final void rule__AdditiveExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2254:1: ( ( ( rule__AdditiveExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2255:1: ( ( rule__AdditiveExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2255:1: ( ( rule__AdditiveExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2256:1: ( rule__AdditiveExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2257:1: ( rule__AdditiveExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2257:2: rule__AdditiveExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__ExpAssignment_0_in_rule__AdditiveExpression__Group__0__Impl4759);
            rule__AdditiveExpression__ExpAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__AdditiveExpression__Group__0__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2267:1: rule__AdditiveExpression__Group__1 : rule__AdditiveExpression__Group__1__Impl ;
    public final void rule__AdditiveExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2271:1: ( rule__AdditiveExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2272:2: rule__AdditiveExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group__1__Impl_in_rule__AdditiveExpression__Group__14789);
            rule__AdditiveExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group__1"


    // $ANTLR start "rule__AdditiveExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2278:1: rule__AdditiveExpression__Group__1__Impl : ( ( rule__AdditiveExpression__Group_1__0 )* ) ;
    public final void rule__AdditiveExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2282:1: ( ( ( rule__AdditiveExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2283:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2283:1: ( ( rule__AdditiveExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2284:1: ( rule__AdditiveExpression__Group_1__0 )*
            {
             before(grammarAccess.getAdditiveExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2285:1: ( rule__AdditiveExpression__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=25 && LA21_0<=26)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2285:2: rule__AdditiveExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__0_in_rule__AdditiveExpression__Group__1__Impl4816);
            	    rule__AdditiveExpression__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__AdditiveExpression__Group__1__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2299:1: rule__AdditiveExpression__Group_1__0 : rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 ;
    public final void rule__AdditiveExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2303:1: ( rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2304:2: rule__AdditiveExpression__Group_1__0__Impl rule__AdditiveExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__0__Impl_in_rule__AdditiveExpression__Group_1__04851);
            rule__AdditiveExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__1_in_rule__AdditiveExpression__Group_1__04854);
            rule__AdditiveExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1__0"


    // $ANTLR start "rule__AdditiveExpression__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2311:1: rule__AdditiveExpression__Group_1__0__Impl : ( ( rule__AdditiveExpression__OpAssignment_1_0 ) ) ;
    public final void rule__AdditiveExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2315:1: ( ( ( rule__AdditiveExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2316:1: ( ( rule__AdditiveExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2316:1: ( ( rule__AdditiveExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2317:1: ( rule__AdditiveExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2318:1: ( rule__AdditiveExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2318:2: rule__AdditiveExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__OpAssignment_1_0_in_rule__AdditiveExpression__Group_1__0__Impl4881);
            rule__AdditiveExpression__OpAssignment_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__AdditiveExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AdditiveExpression__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2328:1: rule__AdditiveExpression__Group_1__1 : rule__AdditiveExpression__Group_1__1__Impl ;
    public final void rule__AdditiveExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2332:1: ( rule__AdditiveExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2333:2: rule__AdditiveExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__Group_1__1__Impl_in_rule__AdditiveExpression__Group_1__14911);
            rule__AdditiveExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpression__Group_1__1"


    // $ANTLR start "rule__AdditiveExpression__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2339:1: rule__AdditiveExpression__Group_1__1__Impl : ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__AdditiveExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2343:1: ( ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2344:1: ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2344:1: ( ( rule__AdditiveExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2345:1: ( rule__AdditiveExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2346:1: ( rule__AdditiveExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2346:2: rule__AdditiveExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__ExpAssignment_1_1_in_rule__AdditiveExpression__Group_1__1__Impl4938);
            rule__AdditiveExpression__ExpAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__AdditiveExpression__Group_1__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2360:1: rule__MultiplicativeExpression__Group__0 : rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 ;
    public final void rule__MultiplicativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2364:1: ( rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2365:2: rule__MultiplicativeExpression__Group__0__Impl rule__MultiplicativeExpression__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__0__Impl_in_rule__MultiplicativeExpression__Group__04972);
            rule__MultiplicativeExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__1_in_rule__MultiplicativeExpression__Group__04975);
            rule__MultiplicativeExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__0"


    // $ANTLR start "rule__MultiplicativeExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2372:1: rule__MultiplicativeExpression__Group__0__Impl : ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) ) ;
    public final void rule__MultiplicativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2376:1: ( ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2377:1: ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2377:1: ( ( rule__MultiplicativeExpression__ExpAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2378:1: ( rule__MultiplicativeExpression__ExpAssignment_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2379:1: ( rule__MultiplicativeExpression__ExpAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2379:2: rule__MultiplicativeExpression__ExpAssignment_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__ExpAssignment_0_in_rule__MultiplicativeExpression__Group__0__Impl5002);
            rule__MultiplicativeExpression__ExpAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__MultiplicativeExpression__Group__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2389:1: rule__MultiplicativeExpression__Group__1 : rule__MultiplicativeExpression__Group__1__Impl ;
    public final void rule__MultiplicativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2393:1: ( rule__MultiplicativeExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2394:2: rule__MultiplicativeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group__1__Impl_in_rule__MultiplicativeExpression__Group__15032);
            rule__MultiplicativeExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group__1"


    // $ANTLR start "rule__MultiplicativeExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2400:1: rule__MultiplicativeExpression__Group__1__Impl : ( ( rule__MultiplicativeExpression__Group_1__0 )* ) ;
    public final void rule__MultiplicativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2404:1: ( ( ( rule__MultiplicativeExpression__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2405:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2405:1: ( ( rule__MultiplicativeExpression__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2406:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2407:1: ( rule__MultiplicativeExpression__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=27 && LA22_0<=29)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2407:2: rule__MultiplicativeExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__0_in_rule__MultiplicativeExpression__Group__1__Impl5059);
            	    rule__MultiplicativeExpression__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__MultiplicativeExpression__Group__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2421:1: rule__MultiplicativeExpression__Group_1__0 : rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 ;
    public final void rule__MultiplicativeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2425:1: ( rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2426:2: rule__MultiplicativeExpression__Group_1__0__Impl rule__MultiplicativeExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__0__Impl_in_rule__MultiplicativeExpression__Group_1__05094);
            rule__MultiplicativeExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__1_in_rule__MultiplicativeExpression__Group_1__05097);
            rule__MultiplicativeExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__0"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2433:1: rule__MultiplicativeExpression__Group_1__0__Impl : ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2437:1: ( ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2438:1: ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2438:1: ( ( rule__MultiplicativeExpression__OpAssignment_1_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2439:1: ( rule__MultiplicativeExpression__OpAssignment_1_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2440:1: ( rule__MultiplicativeExpression__OpAssignment_1_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2440:2: rule__MultiplicativeExpression__OpAssignment_1_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__OpAssignment_1_0_in_rule__MultiplicativeExpression__Group_1__0__Impl5124);
            rule__MultiplicativeExpression__OpAssignment_1_0();

            state._fsp--;


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
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2450:1: rule__MultiplicativeExpression__Group_1__1 : rule__MultiplicativeExpression__Group_1__1__Impl ;
    public final void rule__MultiplicativeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2454:1: ( rule__MultiplicativeExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2455:2: rule__MultiplicativeExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__Group_1__1__Impl_in_rule__MultiplicativeExpression__Group_1__15154);
            rule__MultiplicativeExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__1"


    // $ANTLR start "rule__MultiplicativeExpression__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2461:1: rule__MultiplicativeExpression__Group_1__1__Impl : ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) ) ;
    public final void rule__MultiplicativeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2465:1: ( ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2466:1: ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2466:1: ( ( rule__MultiplicativeExpression__ExpAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2467:1: ( rule__MultiplicativeExpression__ExpAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2468:1: ( rule__MultiplicativeExpression__ExpAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2468:2: rule__MultiplicativeExpression__ExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__ExpAssignment_1_1_in_rule__MultiplicativeExpression__Group_1__1__Impl5181);
            rule__MultiplicativeExpression__ExpAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__MultiplicativeExpression__Group_1__1__Impl"


    // $ANTLR start "rule__UnaryExpression__Group_0__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2482:1: rule__UnaryExpression__Group_0__0 : rule__UnaryExpression__Group_0__0__Impl rule__UnaryExpression__Group_0__1 ;
    public final void rule__UnaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2486:1: ( rule__UnaryExpression__Group_0__0__Impl rule__UnaryExpression__Group_0__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2487:2: rule__UnaryExpression__Group_0__0__Impl rule__UnaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Group_0__0__Impl_in_rule__UnaryExpression__Group_0__05215);
            rule__UnaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__UnaryExpression__Group_0__1_in_rule__UnaryExpression__Group_0__05218);
            rule__UnaryExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__Group_0__0"


    // $ANTLR start "rule__UnaryExpression__Group_0__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2494:1: rule__UnaryExpression__Group_0__0__Impl : ( ( rule__UnaryExpression__OpAssignment_0_0 ) ) ;
    public final void rule__UnaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2498:1: ( ( ( rule__UnaryExpression__OpAssignment_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2499:1: ( ( rule__UnaryExpression__OpAssignment_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2499:1: ( ( rule__UnaryExpression__OpAssignment_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2500:1: ( rule__UnaryExpression__OpAssignment_0_0 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2501:1: ( rule__UnaryExpression__OpAssignment_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2501:2: rule__UnaryExpression__OpAssignment_0_0
            {
            pushFollow(FOLLOW_rule__UnaryExpression__OpAssignment_0_0_in_rule__UnaryExpression__Group_0__0__Impl5245);
            rule__UnaryExpression__OpAssignment_0_0();

            state._fsp--;


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
    // $ANTLR end "rule__UnaryExpression__Group_0__0__Impl"


    // $ANTLR start "rule__UnaryExpression__Group_0__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2511:1: rule__UnaryExpression__Group_0__1 : rule__UnaryExpression__Group_0__1__Impl ;
    public final void rule__UnaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2515:1: ( rule__UnaryExpression__Group_0__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2516:2: rule__UnaryExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__UnaryExpression__Group_0__1__Impl_in_rule__UnaryExpression__Group_0__15275);
            rule__UnaryExpression__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryExpression__Group_0__1"


    // $ANTLR start "rule__UnaryExpression__Group_0__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2522:1: rule__UnaryExpression__Group_0__1__Impl : ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) ) ;
    public final void rule__UnaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2526:1: ( ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2527:1: ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2527:1: ( ( rule__UnaryExpression__UnaryAssignment_0_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2528:1: ( rule__UnaryExpression__UnaryAssignment_0_1 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getUnaryAssignment_0_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2529:1: ( rule__UnaryExpression__UnaryAssignment_0_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2529:2: rule__UnaryExpression__UnaryAssignment_0_1
            {
            pushFollow(FOLLOW_rule__UnaryExpression__UnaryAssignment_0_1_in_rule__UnaryExpression__Group_0__1__Impl5302);
            rule__UnaryExpression__UnaryAssignment_0_1();

            state._fsp--;


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
    // $ANTLR end "rule__UnaryExpression__Group_0__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2543:1: rule__PrimaryExpression__Group__0 : rule__PrimaryExpression__Group__0__Impl rule__PrimaryExpression__Group__1 ;
    public final void rule__PrimaryExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2547:1: ( rule__PrimaryExpression__Group__0__Impl rule__PrimaryExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2548:2: rule__PrimaryExpression__Group__0__Impl rule__PrimaryExpression__Group__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group__0__Impl_in_rule__PrimaryExpression__Group__05336);
            rule__PrimaryExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group__1_in_rule__PrimaryExpression__Group__05339);
            rule__PrimaryExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group__0"


    // $ANTLR start "rule__PrimaryExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2555:1: rule__PrimaryExpression__Group__0__Impl : ( ( rule__PrimaryExpression__PrefixAssignment_0 ) ) ;
    public final void rule__PrimaryExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2559:1: ( ( ( rule__PrimaryExpression__PrefixAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2560:1: ( ( rule__PrimaryExpression__PrefixAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2560:1: ( ( rule__PrimaryExpression__PrefixAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2561:1: ( rule__PrimaryExpression__PrefixAssignment_0 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrefixAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2562:1: ( rule__PrimaryExpression__PrefixAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2562:2: rule__PrimaryExpression__PrefixAssignment_0
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__PrefixAssignment_0_in_rule__PrimaryExpression__Group__0__Impl5366);
            rule__PrimaryExpression__PrefixAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__PrimaryExpression__Group__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2572:1: rule__PrimaryExpression__Group__1 : rule__PrimaryExpression__Group__1__Impl ;
    public final void rule__PrimaryExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2576:1: ( rule__PrimaryExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2577:2: rule__PrimaryExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group__1__Impl_in_rule__PrimaryExpression__Group__15396);
            rule__PrimaryExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group__1"


    // $ANTLR start "rule__PrimaryExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2583:1: rule__PrimaryExpression__Group__1__Impl : ( ( rule__PrimaryExpression__Group_1__0 )? ) ;
    public final void rule__PrimaryExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2587:1: ( ( ( rule__PrimaryExpression__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2588:1: ( ( rule__PrimaryExpression__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2588:1: ( ( rule__PrimaryExpression__Group_1__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2589:1: ( rule__PrimaryExpression__Group_1__0 )?
            {
             before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2590:1: ( rule__PrimaryExpression__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==37) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2590:2: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Group__1__Impl5423);
                    rule__PrimaryExpression__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__PrimaryExpression__Group__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2604:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2608:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2609:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__05458);
            rule__PrimaryExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__05461);
            rule__PrimaryExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__0"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2616:1: rule__PrimaryExpression__Group_1__0__Impl : ( '.' ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2620:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2621:1: ( '.' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2621:1: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2622:1: '.'
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
    // $ANTLR end "rule__PrimaryExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2635:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2639:1: ( rule__PrimaryExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2640:2: rule__PrimaryExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__15520);
            rule__PrimaryExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__1"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2646:1: rule__PrimaryExpression__Group_1__1__Impl : ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2650:1: ( ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2651:1: ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2651:1: ( ( rule__PrimaryExpression__SuffixAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2652:1: ( rule__PrimaryExpression__SuffixAssignment_1_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getSuffixAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2653:1: ( rule__PrimaryExpression__SuffixAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2653:2: rule__PrimaryExpression__SuffixAssignment_1_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__SuffixAssignment_1_1_in_rule__PrimaryExpression__Group_1__1__Impl5547);
            rule__PrimaryExpression__SuffixAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__PrimaryExpression__Group_1__1__Impl"


    // $ANTLR start "rule__ValueSpecification__Group_7__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2667:1: rule__ValueSpecification__Group_7__0 : rule__ValueSpecification__Group_7__0__Impl rule__ValueSpecification__Group_7__1 ;
    public final void rule__ValueSpecification__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2671:1: ( rule__ValueSpecification__Group_7__0__Impl rule__ValueSpecification__Group_7__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2672:2: rule__ValueSpecification__Group_7__0__Impl rule__ValueSpecification__Group_7__1
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__0__Impl_in_rule__ValueSpecification__Group_7__05581);
            rule__ValueSpecification__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__1_in_rule__ValueSpecification__Group_7__05584);
            rule__ValueSpecification__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueSpecification__Group_7__0"


    // $ANTLR start "rule__ValueSpecification__Group_7__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2679:1: rule__ValueSpecification__Group_7__0__Impl : ( '(' ) ;
    public final void rule__ValueSpecification__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2683:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2684:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2684:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2685:1: '('
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
    // $ANTLR end "rule__ValueSpecification__Group_7__0__Impl"


    // $ANTLR start "rule__ValueSpecification__Group_7__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2698:1: rule__ValueSpecification__Group_7__1 : rule__ValueSpecification__Group_7__1__Impl rule__ValueSpecification__Group_7__2 ;
    public final void rule__ValueSpecification__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2702:1: ( rule__ValueSpecification__Group_7__1__Impl rule__ValueSpecification__Group_7__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2703:2: rule__ValueSpecification__Group_7__1__Impl rule__ValueSpecification__Group_7__2
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__1__Impl_in_rule__ValueSpecification__Group_7__15643);
            rule__ValueSpecification__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__2_in_rule__ValueSpecification__Group_7__15646);
            rule__ValueSpecification__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueSpecification__Group_7__1"


    // $ANTLR start "rule__ValueSpecification__Group_7__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2710:1: rule__ValueSpecification__Group_7__1__Impl : ( ruleExpression ) ;
    public final void rule__ValueSpecification__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2714:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2715:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2715:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2716:1: ruleExpression
            {
             before(grammarAccess.getValueSpecificationAccess().getExpressionParserRuleCall_7_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ValueSpecification__Group_7__1__Impl5673);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__ValueSpecification__Group_7__1__Impl"


    // $ANTLR start "rule__ValueSpecification__Group_7__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2727:1: rule__ValueSpecification__Group_7__2 : rule__ValueSpecification__Group_7__2__Impl ;
    public final void rule__ValueSpecification__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2731:1: ( rule__ValueSpecification__Group_7__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2732:2: rule__ValueSpecification__Group_7__2__Impl
            {
            pushFollow(FOLLOW_rule__ValueSpecification__Group_7__2__Impl_in_rule__ValueSpecification__Group_7__25702);
            rule__ValueSpecification__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueSpecification__Group_7__2"


    // $ANTLR start "rule__ValueSpecification__Group_7__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2738:1: rule__ValueSpecification__Group_7__2__Impl : ( ')' ) ;
    public final void rule__ValueSpecification__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2742:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2743:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2743:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2744:1: ')'
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
    // $ANTLR end "rule__ValueSpecification__Group_7__2__Impl"


    // $ANTLR start "rule__PropertyCallExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2763:1: rule__PropertyCallExpression__Group__0 : rule__PropertyCallExpression__Group__0__Impl rule__PropertyCallExpression__Group__1 ;
    public final void rule__PropertyCallExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2767:1: ( rule__PropertyCallExpression__Group__0__Impl rule__PropertyCallExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2768:2: rule__PropertyCallExpression__Group__0__Impl rule__PropertyCallExpression__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__0__Impl_in_rule__PropertyCallExpression__Group__05767);
            rule__PropertyCallExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__1_in_rule__PropertyCallExpression__Group__05770);
            rule__PropertyCallExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCallExpression__Group__0"


    // $ANTLR start "rule__PropertyCallExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2775:1: rule__PropertyCallExpression__Group__0__Impl : ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) ) ;
    public final void rule__PropertyCallExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2779:1: ( ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2780:1: ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2780:1: ( ( rule__PropertyCallExpression__PropertyAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2781:1: ( rule__PropertyCallExpression__PropertyAssignment_0 )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getPropertyAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2782:1: ( rule__PropertyCallExpression__PropertyAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2782:2: rule__PropertyCallExpression__PropertyAssignment_0
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__PropertyAssignment_0_in_rule__PropertyCallExpression__Group__0__Impl5797);
            rule__PropertyCallExpression__PropertyAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__PropertyCallExpression__Group__0__Impl"


    // $ANTLR start "rule__PropertyCallExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2792:1: rule__PropertyCallExpression__Group__1 : rule__PropertyCallExpression__Group__1__Impl ;
    public final void rule__PropertyCallExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2796:1: ( rule__PropertyCallExpression__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2797:2: rule__PropertyCallExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group__1__Impl_in_rule__PropertyCallExpression__Group__15827);
            rule__PropertyCallExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCallExpression__Group__1"


    // $ANTLR start "rule__PropertyCallExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2803:1: rule__PropertyCallExpression__Group__1__Impl : ( ( rule__PropertyCallExpression__Group_1__0 )? ) ;
    public final void rule__PropertyCallExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2807:1: ( ( ( rule__PropertyCallExpression__Group_1__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2808:1: ( ( rule__PropertyCallExpression__Group_1__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2808:1: ( ( rule__PropertyCallExpression__Group_1__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2809:1: ( rule__PropertyCallExpression__Group_1__0 )?
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2810:1: ( rule__PropertyCallExpression__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==37) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2810:2: rule__PropertyCallExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__0_in_rule__PropertyCallExpression__Group__1__Impl5854);
                    rule__PropertyCallExpression__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__PropertyCallExpression__Group__1__Impl"


    // $ANTLR start "rule__PropertyCallExpression__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2824:1: rule__PropertyCallExpression__Group_1__0 : rule__PropertyCallExpression__Group_1__0__Impl rule__PropertyCallExpression__Group_1__1 ;
    public final void rule__PropertyCallExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2828:1: ( rule__PropertyCallExpression__Group_1__0__Impl rule__PropertyCallExpression__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2829:2: rule__PropertyCallExpression__Group_1__0__Impl rule__PropertyCallExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__0__Impl_in_rule__PropertyCallExpression__Group_1__05889);
            rule__PropertyCallExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__1_in_rule__PropertyCallExpression__Group_1__05892);
            rule__PropertyCallExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCallExpression__Group_1__0"


    // $ANTLR start "rule__PropertyCallExpression__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2836:1: rule__PropertyCallExpression__Group_1__0__Impl : ( '.' ) ;
    public final void rule__PropertyCallExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2840:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2841:1: ( '.' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2841:1: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2842:1: '.'
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
    // $ANTLR end "rule__PropertyCallExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PropertyCallExpression__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2855:1: rule__PropertyCallExpression__Group_1__1 : rule__PropertyCallExpression__Group_1__1__Impl ;
    public final void rule__PropertyCallExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2859:1: ( rule__PropertyCallExpression__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2860:2: rule__PropertyCallExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__Group_1__1__Impl_in_rule__PropertyCallExpression__Group_1__15951);
            rule__PropertyCallExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCallExpression__Group_1__1"


    // $ANTLR start "rule__PropertyCallExpression__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2866:1: rule__PropertyCallExpression__Group_1__1__Impl : ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) ) ;
    public final void rule__PropertyCallExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2870:1: ( ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2871:1: ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2871:1: ( ( rule__PropertyCallExpression__SuffixAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2872:1: ( rule__PropertyCallExpression__SuffixAssignment_1_1 )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getSuffixAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2873:1: ( rule__PropertyCallExpression__SuffixAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2873:2: rule__PropertyCallExpression__SuffixAssignment_1_1
            {
            pushFollow(FOLLOW_rule__PropertyCallExpression__SuffixAssignment_1_1_in_rule__PropertyCallExpression__Group_1__1__Impl5978);
            rule__PropertyCallExpression__SuffixAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__PropertyCallExpression__Group_1__1__Impl"


    // $ANTLR start "rule__OperationCallExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2887:1: rule__OperationCallExpression__Group__0 : rule__OperationCallExpression__Group__0__Impl rule__OperationCallExpression__Group__1 ;
    public final void rule__OperationCallExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2891:1: ( rule__OperationCallExpression__Group__0__Impl rule__OperationCallExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2892:2: rule__OperationCallExpression__Group__0__Impl rule__OperationCallExpression__Group__1
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__0__Impl_in_rule__OperationCallExpression__Group__06012);
            rule__OperationCallExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__1_in_rule__OperationCallExpression__Group__06015);
            rule__OperationCallExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCallExpression__Group__0"


    // $ANTLR start "rule__OperationCallExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2899:1: rule__OperationCallExpression__Group__0__Impl : ( ( rule__OperationCallExpression__OperationAssignment_0 ) ) ;
    public final void rule__OperationCallExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2903:1: ( ( ( rule__OperationCallExpression__OperationAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2904:1: ( ( rule__OperationCallExpression__OperationAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2904:1: ( ( rule__OperationCallExpression__OperationAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2905:1: ( rule__OperationCallExpression__OperationAssignment_0 )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getOperationAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2906:1: ( rule__OperationCallExpression__OperationAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2906:2: rule__OperationCallExpression__OperationAssignment_0
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__OperationAssignment_0_in_rule__OperationCallExpression__Group__0__Impl6042);
            rule__OperationCallExpression__OperationAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__OperationCallExpression__Group__0__Impl"


    // $ANTLR start "rule__OperationCallExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2916:1: rule__OperationCallExpression__Group__1 : rule__OperationCallExpression__Group__1__Impl rule__OperationCallExpression__Group__2 ;
    public final void rule__OperationCallExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2920:1: ( rule__OperationCallExpression__Group__1__Impl rule__OperationCallExpression__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2921:2: rule__OperationCallExpression__Group__1__Impl rule__OperationCallExpression__Group__2
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__1__Impl_in_rule__OperationCallExpression__Group__16072);
            rule__OperationCallExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__2_in_rule__OperationCallExpression__Group__16075);
            rule__OperationCallExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCallExpression__Group__1"


    // $ANTLR start "rule__OperationCallExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2928:1: rule__OperationCallExpression__Group__1__Impl : ( '(' ) ;
    public final void rule__OperationCallExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2932:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2933:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2933:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2934:1: '('
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
    // $ANTLR end "rule__OperationCallExpression__Group__1__Impl"


    // $ANTLR start "rule__OperationCallExpression__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2947:1: rule__OperationCallExpression__Group__2 : rule__OperationCallExpression__Group__2__Impl rule__OperationCallExpression__Group__3 ;
    public final void rule__OperationCallExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2951:1: ( rule__OperationCallExpression__Group__2__Impl rule__OperationCallExpression__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2952:2: rule__OperationCallExpression__Group__2__Impl rule__OperationCallExpression__Group__3
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__2__Impl_in_rule__OperationCallExpression__Group__26134);
            rule__OperationCallExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__3_in_rule__OperationCallExpression__Group__26137);
            rule__OperationCallExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCallExpression__Group__2"


    // $ANTLR start "rule__OperationCallExpression__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2959:1: rule__OperationCallExpression__Group__2__Impl : ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? ) ;
    public final void rule__OperationCallExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2963:1: ( ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2964:1: ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2964:1: ( ( rule__OperationCallExpression__ArgumentsAssignment_2 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2965:1: ( rule__OperationCallExpression__ArgumentsAssignment_2 )?
            {
             before(grammarAccess.getOperationCallExpressionAccess().getArgumentsAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2966:1: ( rule__OperationCallExpression__ArgumentsAssignment_2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)||(LA25_0>=25 && LA25_0<=28)||(LA25_0>=30 && LA25_0<=35)||LA25_0==38||LA25_0==42||LA25_0==46||(LA25_0>=48 && LA25_0<=50)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2966:2: rule__OperationCallExpression__ArgumentsAssignment_2
                    {
                    pushFollow(FOLLOW_rule__OperationCallExpression__ArgumentsAssignment_2_in_rule__OperationCallExpression__Group__2__Impl6164);
                    rule__OperationCallExpression__ArgumentsAssignment_2();

                    state._fsp--;


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
    // $ANTLR end "rule__OperationCallExpression__Group__2__Impl"


    // $ANTLR start "rule__OperationCallExpression__Group__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2976:1: rule__OperationCallExpression__Group__3 : rule__OperationCallExpression__Group__3__Impl rule__OperationCallExpression__Group__4 ;
    public final void rule__OperationCallExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2980:1: ( rule__OperationCallExpression__Group__3__Impl rule__OperationCallExpression__Group__4 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2981:2: rule__OperationCallExpression__Group__3__Impl rule__OperationCallExpression__Group__4
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__3__Impl_in_rule__OperationCallExpression__Group__36195);
            rule__OperationCallExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group__4_in_rule__OperationCallExpression__Group__36198);
            rule__OperationCallExpression__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCallExpression__Group__3"


    // $ANTLR start "rule__OperationCallExpression__Group__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2988:1: rule__OperationCallExpression__Group__3__Impl : ( ')' ) ;
    public final void rule__OperationCallExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2992:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2993:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2993:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:2994:1: ')'
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
    // $ANTLR end "rule__OperationCallExpression__Group__3__Impl"


    // $ANTLR start "rule__OperationCallExpression__Group__4"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3007:1: rule__OperationCallExpression__Group__4 : rule__OperationCallExpression__Group__4__Impl ;
    public final void rule__OperationCallExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3011:1: ( rule__OperationCallExpression__Group__4__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3012:2: rule__OperationCallExpression__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group__4__Impl_in_rule__OperationCallExpression__Group__46257);
            rule__OperationCallExpression__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCallExpression__Group__4"


    // $ANTLR start "rule__OperationCallExpression__Group__4__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3018:1: rule__OperationCallExpression__Group__4__Impl : ( ( rule__OperationCallExpression__Group_4__0 )? ) ;
    public final void rule__OperationCallExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3022:1: ( ( ( rule__OperationCallExpression__Group_4__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3023:1: ( ( rule__OperationCallExpression__Group_4__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3023:1: ( ( rule__OperationCallExpression__Group_4__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3024:1: ( rule__OperationCallExpression__Group_4__0 )?
            {
             before(grammarAccess.getOperationCallExpressionAccess().getGroup_4()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3025:1: ( rule__OperationCallExpression__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3025:2: rule__OperationCallExpression__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__0_in_rule__OperationCallExpression__Group__4__Impl6284);
                    rule__OperationCallExpression__Group_4__0();

                    state._fsp--;


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
    // $ANTLR end "rule__OperationCallExpression__Group__4__Impl"


    // $ANTLR start "rule__OperationCallExpression__Group_4__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3045:1: rule__OperationCallExpression__Group_4__0 : rule__OperationCallExpression__Group_4__0__Impl rule__OperationCallExpression__Group_4__1 ;
    public final void rule__OperationCallExpression__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3049:1: ( rule__OperationCallExpression__Group_4__0__Impl rule__OperationCallExpression__Group_4__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3050:2: rule__OperationCallExpression__Group_4__0__Impl rule__OperationCallExpression__Group_4__1
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__0__Impl_in_rule__OperationCallExpression__Group_4__06325);
            rule__OperationCallExpression__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__1_in_rule__OperationCallExpression__Group_4__06328);
            rule__OperationCallExpression__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCallExpression__Group_4__0"


    // $ANTLR start "rule__OperationCallExpression__Group_4__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3057:1: rule__OperationCallExpression__Group_4__0__Impl : ( '.' ) ;
    public final void rule__OperationCallExpression__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3061:1: ( ( '.' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3062:1: ( '.' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3062:1: ( '.' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3063:1: '.'
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
    // $ANTLR end "rule__OperationCallExpression__Group_4__0__Impl"


    // $ANTLR start "rule__OperationCallExpression__Group_4__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3076:1: rule__OperationCallExpression__Group_4__1 : rule__OperationCallExpression__Group_4__1__Impl ;
    public final void rule__OperationCallExpression__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3080:1: ( rule__OperationCallExpression__Group_4__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3081:2: rule__OperationCallExpression__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__Group_4__1__Impl_in_rule__OperationCallExpression__Group_4__16387);
            rule__OperationCallExpression__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCallExpression__Group_4__1"


    // $ANTLR start "rule__OperationCallExpression__Group_4__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3087:1: rule__OperationCallExpression__Group_4__1__Impl : ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) ) ;
    public final void rule__OperationCallExpression__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3091:1: ( ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3092:1: ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3092:1: ( ( rule__OperationCallExpression__SuffixAssignment_4_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3093:1: ( rule__OperationCallExpression__SuffixAssignment_4_1 )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getSuffixAssignment_4_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3094:1: ( rule__OperationCallExpression__SuffixAssignment_4_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3094:2: rule__OperationCallExpression__SuffixAssignment_4_1
            {
            pushFollow(FOLLOW_rule__OperationCallExpression__SuffixAssignment_4_1_in_rule__OperationCallExpression__Group_4__1__Impl6414);
            rule__OperationCallExpression__SuffixAssignment_4_1();

            state._fsp--;


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
    // $ANTLR end "rule__OperationCallExpression__Group_4__1__Impl"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3108:1: rule__NameOrChoiceOrBehaviorCall__Group__0 : rule__NameOrChoiceOrBehaviorCall__Group__0__Impl rule__NameOrChoiceOrBehaviorCall__Group__1 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3112:1: ( rule__NameOrChoiceOrBehaviorCall__Group__0__Impl rule__NameOrChoiceOrBehaviorCall__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3113:2: rule__NameOrChoiceOrBehaviorCall__Group__0__Impl rule__NameOrChoiceOrBehaviorCall__Group__1
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__06448);
            rule__NameOrChoiceOrBehaviorCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1_in_rule__NameOrChoiceOrBehaviorCall__Group__06451);
            rule__NameOrChoiceOrBehaviorCall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group__0"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3120:1: rule__NameOrChoiceOrBehaviorCall__Group__0__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3124:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3125:1: ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3125:1: ( ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3126:1: ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )?
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3127:1: ( rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 )?
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
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3127:2: rule__NameOrChoiceOrBehaviorCall__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__PathAssignment_0_in_rule__NameOrChoiceOrBehaviorCall__Group__0__Impl6478);
                    rule__NameOrChoiceOrBehaviorCall__PathAssignment_0();

                    state._fsp--;


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
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group__0__Impl"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3137:1: rule__NameOrChoiceOrBehaviorCall__Group__1 : rule__NameOrChoiceOrBehaviorCall__Group__1__Impl rule__NameOrChoiceOrBehaviorCall__Group__2 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3141:1: ( rule__NameOrChoiceOrBehaviorCall__Group__1__Impl rule__NameOrChoiceOrBehaviorCall__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3142:2: rule__NameOrChoiceOrBehaviorCall__Group__1__Impl rule__NameOrChoiceOrBehaviorCall__Group__2
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__16509);
            rule__NameOrChoiceOrBehaviorCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2_in_rule__NameOrChoiceOrBehaviorCall__Group__16512);
            rule__NameOrChoiceOrBehaviorCall__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group__1"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3149:1: rule__NameOrChoiceOrBehaviorCall__Group__1__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3153:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3154:1: ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3154:1: ( ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3155:1: ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 )
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3156:1: ( rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3156:2: rule__NameOrChoiceOrBehaviorCall__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__IdAssignment_1_in_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl6539);
            rule__NameOrChoiceOrBehaviorCall__IdAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group__1__Impl"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3166:1: rule__NameOrChoiceOrBehaviorCall__Group__2 : rule__NameOrChoiceOrBehaviorCall__Group__2__Impl ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3170:1: ( rule__NameOrChoiceOrBehaviorCall__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3171:2: rule__NameOrChoiceOrBehaviorCall__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__26569);
            rule__NameOrChoiceOrBehaviorCall__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group__2"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3177:1: rule__NameOrChoiceOrBehaviorCall__Group__2__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3181:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3182:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3182:1: ( ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3183:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )?
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3184:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==38) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3184:2: rule__NameOrChoiceOrBehaviorCall__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0_in_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl6596);
                    rule__NameOrChoiceOrBehaviorCall__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group__2__Impl"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group_2__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3200:1: rule__NameOrChoiceOrBehaviorCall__Group_2__0 : rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__1 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3204:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3205:2: rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__1
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__06633);
            rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__06636);
            rule__NameOrChoiceOrBehaviorCall__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group_2__0"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3212:1: rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl : ( '(' ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3216:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3217:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3217:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3218:1: '('
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
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group_2__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3231:1: rule__NameOrChoiceOrBehaviorCall__Group_2__1 : rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__2 ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3235:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3236:2: rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl rule__NameOrChoiceOrBehaviorCall__Group_2__2
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__16695);
            rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2_in_rule__NameOrChoiceOrBehaviorCall__Group_2__16698);
            rule__NameOrChoiceOrBehaviorCall__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group_2__1"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3243:1: rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl : ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3247:1: ( ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3248:1: ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3248:1: ( ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3249:1: ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )?
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3250:1: ( rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_STRING)||(LA29_0>=25 && LA29_0<=28)||(LA29_0>=30 && LA29_0<=35)||LA29_0==38||LA29_0==42||LA29_0==46||(LA29_0>=48 && LA29_0<=50)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3250:2: rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl6725);
                    rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1();

                    state._fsp--;


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
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group_2__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3260:1: rule__NameOrChoiceOrBehaviorCall__Group_2__2 : rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3264:1: ( rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3265:2: rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__26756);
            rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group_2__2"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3271:1: rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl : ( ')' ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3275:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3276:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3276:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3277:1: ')'
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
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3296:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3300:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3301:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__06821);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__06824);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3308:1: rule__QualifiedName__Group__0__Impl : ( ( rule__QualifiedName__PathAssignment_0 ) ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3312:1: ( ( ( rule__QualifiedName__PathAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3313:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3313:1: ( ( rule__QualifiedName__PathAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3314:1: ( rule__QualifiedName__PathAssignment_0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3315:1: ( rule__QualifiedName__PathAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3315:2: rule__QualifiedName__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl6851);
            rule__QualifiedName__PathAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3325:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3329:1: ( rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3330:2: rule__QualifiedName__Group__1__Impl rule__QualifiedName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__16881);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__2_in_rule__QualifiedName__Group__16884);
            rule__QualifiedName__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3337:1: rule__QualifiedName__Group__1__Impl : ( '::' ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3341:1: ( ( '::' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3342:1: ( '::' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3342:1: ( '::' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3343:1: '::'
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
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3356:1: rule__QualifiedName__Group__2 : rule__QualifiedName__Group__2__Impl ;
    public final void rule__QualifiedName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3360:1: ( rule__QualifiedName__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3361:2: rule__QualifiedName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__2__Impl_in_rule__QualifiedName__Group__26943);
            rule__QualifiedName__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__2"


    // $ANTLR start "rule__QualifiedName__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3367:1: rule__QualifiedName__Group__2__Impl : ( ( rule__QualifiedName__RemainingAssignment_2 )? ) ;
    public final void rule__QualifiedName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3371:1: ( ( ( rule__QualifiedName__RemainingAssignment_2 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3372:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3372:1: ( ( rule__QualifiedName__RemainingAssignment_2 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3373:1: ( rule__QualifiedName__RemainingAssignment_2 )?
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3374:1: ( rule__QualifiedName__RemainingAssignment_2 )?
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
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3374:2: rule__QualifiedName__RemainingAssignment_2
                    {
                    pushFollow(FOLLOW_rule__QualifiedName__RemainingAssignment_2_in_rule__QualifiedName__Group__2__Impl6970);
                    rule__QualifiedName__RemainingAssignment_2();

                    state._fsp--;


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
    // $ANTLR end "rule__QualifiedName__Group__2__Impl"


    // $ANTLR start "rule__Interval__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3390:1: rule__Interval__Group__0 : rule__Interval__Group__0__Impl rule__Interval__Group__1 ;
    public final void rule__Interval__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3394:1: ( rule__Interval__Group__0__Impl rule__Interval__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3395:2: rule__Interval__Group__0__Impl rule__Interval__Group__1
            {
            pushFollow(FOLLOW_rule__Interval__Group__0__Impl_in_rule__Interval__Group__07007);
            rule__Interval__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__1_in_rule__Interval__Group__07010);
            rule__Interval__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group__0"


    // $ANTLR start "rule__Interval__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3402:1: rule__Interval__Group__0__Impl : ( ( rule__Interval__Alternatives_0 ) ) ;
    public final void rule__Interval__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3406:1: ( ( ( rule__Interval__Alternatives_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3407:1: ( ( rule__Interval__Alternatives_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3407:1: ( ( rule__Interval__Alternatives_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3408:1: ( rule__Interval__Alternatives_0 )
            {
             before(grammarAccess.getIntervalAccess().getAlternatives_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3409:1: ( rule__Interval__Alternatives_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3409:2: rule__Interval__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Interval__Alternatives_0_in_rule__Interval__Group__0__Impl7037);
            rule__Interval__Alternatives_0();

            state._fsp--;


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
    // $ANTLR end "rule__Interval__Group__0__Impl"


    // $ANTLR start "rule__Interval__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3419:1: rule__Interval__Group__1 : rule__Interval__Group__1__Impl rule__Interval__Group__2 ;
    public final void rule__Interval__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3423:1: ( rule__Interval__Group__1__Impl rule__Interval__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3424:2: rule__Interval__Group__1__Impl rule__Interval__Group__2
            {
            pushFollow(FOLLOW_rule__Interval__Group__1__Impl_in_rule__Interval__Group__17067);
            rule__Interval__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__2_in_rule__Interval__Group__17070);
            rule__Interval__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group__1"


    // $ANTLR start "rule__Interval__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3431:1: rule__Interval__Group__1__Impl : ( ( rule__Interval__LowerAssignment_1 ) ) ;
    public final void rule__Interval__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3435:1: ( ( ( rule__Interval__LowerAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3436:1: ( ( rule__Interval__LowerAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3436:1: ( ( rule__Interval__LowerAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3437:1: ( rule__Interval__LowerAssignment_1 )
            {
             before(grammarAccess.getIntervalAccess().getLowerAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3438:1: ( rule__Interval__LowerAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3438:2: rule__Interval__LowerAssignment_1
            {
            pushFollow(FOLLOW_rule__Interval__LowerAssignment_1_in_rule__Interval__Group__1__Impl7097);
            rule__Interval__LowerAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__Interval__Group__1__Impl"


    // $ANTLR start "rule__Interval__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3448:1: rule__Interval__Group__2 : rule__Interval__Group__2__Impl rule__Interval__Group__3 ;
    public final void rule__Interval__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3452:1: ( rule__Interval__Group__2__Impl rule__Interval__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3453:2: rule__Interval__Group__2__Impl rule__Interval__Group__3
            {
            pushFollow(FOLLOW_rule__Interval__Group__2__Impl_in_rule__Interval__Group__27127);
            rule__Interval__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__3_in_rule__Interval__Group__27130);
            rule__Interval__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group__2"


    // $ANTLR start "rule__Interval__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3460:1: rule__Interval__Group__2__Impl : ( '..' ) ;
    public final void rule__Interval__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3464:1: ( ( '..' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3465:1: ( '..' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3465:1: ( '..' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3466:1: '..'
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
    // $ANTLR end "rule__Interval__Group__2__Impl"


    // $ANTLR start "rule__Interval__Group__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3479:1: rule__Interval__Group__3 : rule__Interval__Group__3__Impl rule__Interval__Group__4 ;
    public final void rule__Interval__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3483:1: ( rule__Interval__Group__3__Impl rule__Interval__Group__4 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3484:2: rule__Interval__Group__3__Impl rule__Interval__Group__4
            {
            pushFollow(FOLLOW_rule__Interval__Group__3__Impl_in_rule__Interval__Group__37189);
            rule__Interval__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Interval__Group__4_in_rule__Interval__Group__37192);
            rule__Interval__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group__3"


    // $ANTLR start "rule__Interval__Group__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3491:1: rule__Interval__Group__3__Impl : ( ( rule__Interval__UpperAssignment_3 ) ) ;
    public final void rule__Interval__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3495:1: ( ( ( rule__Interval__UpperAssignment_3 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3496:1: ( ( rule__Interval__UpperAssignment_3 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3496:1: ( ( rule__Interval__UpperAssignment_3 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3497:1: ( rule__Interval__UpperAssignment_3 )
            {
             before(grammarAccess.getIntervalAccess().getUpperAssignment_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3498:1: ( rule__Interval__UpperAssignment_3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3498:2: rule__Interval__UpperAssignment_3
            {
            pushFollow(FOLLOW_rule__Interval__UpperAssignment_3_in_rule__Interval__Group__3__Impl7219);
            rule__Interval__UpperAssignment_3();

            state._fsp--;


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
    // $ANTLR end "rule__Interval__Group__3__Impl"


    // $ANTLR start "rule__Interval__Group__4"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3508:1: rule__Interval__Group__4 : rule__Interval__Group__4__Impl ;
    public final void rule__Interval__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3512:1: ( rule__Interval__Group__4__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3513:2: rule__Interval__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Interval__Group__4__Impl_in_rule__Interval__Group__47249);
            rule__Interval__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group__4"


    // $ANTLR start "rule__Interval__Group__4__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3519:1: rule__Interval__Group__4__Impl : ( ( rule__Interval__Alternatives_4 ) ) ;
    public final void rule__Interval__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3523:1: ( ( ( rule__Interval__Alternatives_4 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3524:1: ( ( rule__Interval__Alternatives_4 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3524:1: ( ( rule__Interval__Alternatives_4 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3525:1: ( rule__Interval__Alternatives_4 )
            {
             before(grammarAccess.getIntervalAccess().getAlternatives_4()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3526:1: ( rule__Interval__Alternatives_4 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3526:2: rule__Interval__Alternatives_4
            {
            pushFollow(FOLLOW_rule__Interval__Alternatives_4_in_rule__Interval__Group__4__Impl7276);
            rule__Interval__Alternatives_4();

            state._fsp--;


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
    // $ANTLR end "rule__Interval__Group__4__Impl"


    // $ANTLR start "rule__CollectionOrTuple__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3546:1: rule__CollectionOrTuple__Group__0 : rule__CollectionOrTuple__Group__0__Impl rule__CollectionOrTuple__Group__1 ;
    public final void rule__CollectionOrTuple__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3550:1: ( rule__CollectionOrTuple__Group__0__Impl rule__CollectionOrTuple__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3551:2: rule__CollectionOrTuple__Group__0__Impl rule__CollectionOrTuple__Group__1
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__0__Impl_in_rule__CollectionOrTuple__Group__07316);
            rule__CollectionOrTuple__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__1_in_rule__CollectionOrTuple__Group__07319);
            rule__CollectionOrTuple__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOrTuple__Group__0"


    // $ANTLR start "rule__CollectionOrTuple__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3558:1: rule__CollectionOrTuple__Group__0__Impl : ( '{' ) ;
    public final void rule__CollectionOrTuple__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3562:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3563:1: ( '{' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3563:1: ( '{' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3564:1: '{'
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
    // $ANTLR end "rule__CollectionOrTuple__Group__0__Impl"


    // $ANTLR start "rule__CollectionOrTuple__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3577:1: rule__CollectionOrTuple__Group__1 : rule__CollectionOrTuple__Group__1__Impl rule__CollectionOrTuple__Group__2 ;
    public final void rule__CollectionOrTuple__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3581:1: ( rule__CollectionOrTuple__Group__1__Impl rule__CollectionOrTuple__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3582:2: rule__CollectionOrTuple__Group__1__Impl rule__CollectionOrTuple__Group__2
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__1__Impl_in_rule__CollectionOrTuple__Group__17378);
            rule__CollectionOrTuple__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__2_in_rule__CollectionOrTuple__Group__17381);
            rule__CollectionOrTuple__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOrTuple__Group__1"


    // $ANTLR start "rule__CollectionOrTuple__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3589:1: rule__CollectionOrTuple__Group__1__Impl : ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) ) ;
    public final void rule__CollectionOrTuple__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3593:1: ( ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3594:1: ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3594:1: ( ( rule__CollectionOrTuple__ListOfValuesAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3595:1: ( rule__CollectionOrTuple__ListOfValuesAssignment_1 )
            {
             before(grammarAccess.getCollectionOrTupleAccess().getListOfValuesAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3596:1: ( rule__CollectionOrTuple__ListOfValuesAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3596:2: rule__CollectionOrTuple__ListOfValuesAssignment_1
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__ListOfValuesAssignment_1_in_rule__CollectionOrTuple__Group__1__Impl7408);
            rule__CollectionOrTuple__ListOfValuesAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__CollectionOrTuple__Group__1__Impl"


    // $ANTLR start "rule__CollectionOrTuple__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3606:1: rule__CollectionOrTuple__Group__2 : rule__CollectionOrTuple__Group__2__Impl ;
    public final void rule__CollectionOrTuple__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3610:1: ( rule__CollectionOrTuple__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3611:2: rule__CollectionOrTuple__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__CollectionOrTuple__Group__2__Impl_in_rule__CollectionOrTuple__Group__27438);
            rule__CollectionOrTuple__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOrTuple__Group__2"


    // $ANTLR start "rule__CollectionOrTuple__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3617:1: rule__CollectionOrTuple__Group__2__Impl : ( '}' ) ;
    public final void rule__CollectionOrTuple__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3621:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3622:1: ( '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3622:1: ( '}' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3623:1: '}'
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
    // $ANTLR end "rule__CollectionOrTuple__Group__2__Impl"


    // $ANTLR start "rule__Tuple__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3642:1: rule__Tuple__Group__0 : rule__Tuple__Group__0__Impl rule__Tuple__Group__1 ;
    public final void rule__Tuple__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3646:1: ( rule__Tuple__Group__0__Impl rule__Tuple__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3647:2: rule__Tuple__Group__0__Impl rule__Tuple__Group__1
            {
            pushFollow(FOLLOW_rule__Tuple__Group__0__Impl_in_rule__Tuple__Group__07503);
            rule__Tuple__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Tuple__Group__1_in_rule__Tuple__Group__07506);
            rule__Tuple__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tuple__Group__0"


    // $ANTLR start "rule__Tuple__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3654:1: rule__Tuple__Group__0__Impl : ( '{' ) ;
    public final void rule__Tuple__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3658:1: ( ( '{' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3659:1: ( '{' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3659:1: ( '{' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3660:1: '{'
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
    // $ANTLR end "rule__Tuple__Group__0__Impl"


    // $ANTLR start "rule__Tuple__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3673:1: rule__Tuple__Group__1 : rule__Tuple__Group__1__Impl rule__Tuple__Group__2 ;
    public final void rule__Tuple__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3677:1: ( rule__Tuple__Group__1__Impl rule__Tuple__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3678:2: rule__Tuple__Group__1__Impl rule__Tuple__Group__2
            {
            pushFollow(FOLLOW_rule__Tuple__Group__1__Impl_in_rule__Tuple__Group__17565);
            rule__Tuple__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Tuple__Group__2_in_rule__Tuple__Group__17568);
            rule__Tuple__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tuple__Group__1"


    // $ANTLR start "rule__Tuple__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3685:1: rule__Tuple__Group__1__Impl : ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) ) ;
    public final void rule__Tuple__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3689:1: ( ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3690:1: ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3690:1: ( ( rule__Tuple__ListOfValueNamePairsAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3691:1: ( rule__Tuple__ListOfValueNamePairsAssignment_1 )
            {
             before(grammarAccess.getTupleAccess().getListOfValueNamePairsAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3692:1: ( rule__Tuple__ListOfValueNamePairsAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3692:2: rule__Tuple__ListOfValueNamePairsAssignment_1
            {
            pushFollow(FOLLOW_rule__Tuple__ListOfValueNamePairsAssignment_1_in_rule__Tuple__Group__1__Impl7595);
            rule__Tuple__ListOfValueNamePairsAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__Tuple__Group__1__Impl"


    // $ANTLR start "rule__Tuple__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3702:1: rule__Tuple__Group__2 : rule__Tuple__Group__2__Impl ;
    public final void rule__Tuple__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3706:1: ( rule__Tuple__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3707:2: rule__Tuple__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Tuple__Group__2__Impl_in_rule__Tuple__Group__27625);
            rule__Tuple__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Tuple__Group__2"


    // $ANTLR start "rule__Tuple__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3713:1: rule__Tuple__Group__2__Impl : ( '}' ) ;
    public final void rule__Tuple__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3717:1: ( ( '}' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3718:1: ( '}' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3718:1: ( '}' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3719:1: '}'
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
    // $ANTLR end "rule__Tuple__Group__2__Impl"


    // $ANTLR start "rule__ListOfValues__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3738:1: rule__ListOfValues__Group__0 : rule__ListOfValues__Group__0__Impl rule__ListOfValues__Group__1 ;
    public final void rule__ListOfValues__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3742:1: ( rule__ListOfValues__Group__0__Impl rule__ListOfValues__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3743:2: rule__ListOfValues__Group__0__Impl rule__ListOfValues__Group__1
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group__0__Impl_in_rule__ListOfValues__Group__07690);
            rule__ListOfValues__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListOfValues__Group__1_in_rule__ListOfValues__Group__07693);
            rule__ListOfValues__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOfValues__Group__0"


    // $ANTLR start "rule__ListOfValues__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3750:1: rule__ListOfValues__Group__0__Impl : ( ( rule__ListOfValues__ValuesAssignment_0 ) ) ;
    public final void rule__ListOfValues__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3754:1: ( ( ( rule__ListOfValues__ValuesAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3755:1: ( ( rule__ListOfValues__ValuesAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3755:1: ( ( rule__ListOfValues__ValuesAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3756:1: ( rule__ListOfValues__ValuesAssignment_0 )
            {
             before(grammarAccess.getListOfValuesAccess().getValuesAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3757:1: ( rule__ListOfValues__ValuesAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3757:2: rule__ListOfValues__ValuesAssignment_0
            {
            pushFollow(FOLLOW_rule__ListOfValues__ValuesAssignment_0_in_rule__ListOfValues__Group__0__Impl7720);
            rule__ListOfValues__ValuesAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__ListOfValues__Group__0__Impl"


    // $ANTLR start "rule__ListOfValues__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3767:1: rule__ListOfValues__Group__1 : rule__ListOfValues__Group__1__Impl ;
    public final void rule__ListOfValues__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3771:1: ( rule__ListOfValues__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3772:2: rule__ListOfValues__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group__1__Impl_in_rule__ListOfValues__Group__17750);
            rule__ListOfValues__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOfValues__Group__1"


    // $ANTLR start "rule__ListOfValues__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3778:1: rule__ListOfValues__Group__1__Impl : ( ( rule__ListOfValues__Group_1__0 )* ) ;
    public final void rule__ListOfValues__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3782:1: ( ( ( rule__ListOfValues__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3783:1: ( ( rule__ListOfValues__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3783:1: ( ( rule__ListOfValues__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3784:1: ( rule__ListOfValues__Group_1__0 )*
            {
             before(grammarAccess.getListOfValuesAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3785:1: ( rule__ListOfValues__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==44) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3785:2: rule__ListOfValues__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ListOfValues__Group_1__0_in_rule__ListOfValues__Group__1__Impl7777);
            	    rule__ListOfValues__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__ListOfValues__Group__1__Impl"


    // $ANTLR start "rule__ListOfValues__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3799:1: rule__ListOfValues__Group_1__0 : rule__ListOfValues__Group_1__0__Impl rule__ListOfValues__Group_1__1 ;
    public final void rule__ListOfValues__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3803:1: ( rule__ListOfValues__Group_1__0__Impl rule__ListOfValues__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3804:2: rule__ListOfValues__Group_1__0__Impl rule__ListOfValues__Group_1__1
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group_1__0__Impl_in_rule__ListOfValues__Group_1__07812);
            rule__ListOfValues__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListOfValues__Group_1__1_in_rule__ListOfValues__Group_1__07815);
            rule__ListOfValues__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOfValues__Group_1__0"


    // $ANTLR start "rule__ListOfValues__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3811:1: rule__ListOfValues__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ListOfValues__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3815:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3816:1: ( ',' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3816:1: ( ',' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3817:1: ','
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
    // $ANTLR end "rule__ListOfValues__Group_1__0__Impl"


    // $ANTLR start "rule__ListOfValues__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3830:1: rule__ListOfValues__Group_1__1 : rule__ListOfValues__Group_1__1__Impl ;
    public final void rule__ListOfValues__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3834:1: ( rule__ListOfValues__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3835:2: rule__ListOfValues__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValues__Group_1__1__Impl_in_rule__ListOfValues__Group_1__17874);
            rule__ListOfValues__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOfValues__Group_1__1"


    // $ANTLR start "rule__ListOfValues__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3841:1: rule__ListOfValues__Group_1__1__Impl : ( ( rule__ListOfValues__ValuesAssignment_1_1 ) ) ;
    public final void rule__ListOfValues__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3845:1: ( ( ( rule__ListOfValues__ValuesAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3846:1: ( ( rule__ListOfValues__ValuesAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3846:1: ( ( rule__ListOfValues__ValuesAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3847:1: ( rule__ListOfValues__ValuesAssignment_1_1 )
            {
             before(grammarAccess.getListOfValuesAccess().getValuesAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3848:1: ( rule__ListOfValues__ValuesAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3848:2: rule__ListOfValues__ValuesAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ListOfValues__ValuesAssignment_1_1_in_rule__ListOfValues__Group_1__1__Impl7901);
            rule__ListOfValues__ValuesAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__ListOfValues__Group_1__1__Impl"


    // $ANTLR start "rule__ListOfValueNamePairs__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3862:1: rule__ListOfValueNamePairs__Group__0 : rule__ListOfValueNamePairs__Group__0__Impl rule__ListOfValueNamePairs__Group__1 ;
    public final void rule__ListOfValueNamePairs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3866:1: ( rule__ListOfValueNamePairs__Group__0__Impl rule__ListOfValueNamePairs__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3867:2: rule__ListOfValueNamePairs__Group__0__Impl rule__ListOfValueNamePairs__Group__1
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__0__Impl_in_rule__ListOfValueNamePairs__Group__07935);
            rule__ListOfValueNamePairs__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__1_in_rule__ListOfValueNamePairs__Group__07938);
            rule__ListOfValueNamePairs__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOfValueNamePairs__Group__0"


    // $ANTLR start "rule__ListOfValueNamePairs__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3874:1: rule__ListOfValueNamePairs__Group__0__Impl : ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) ) ;
    public final void rule__ListOfValueNamePairs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3878:1: ( ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3879:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3879:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3880:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 )
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3881:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3881:2: rule__ListOfValueNamePairs__ValueNamePairsAssignment_0
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_0_in_rule__ListOfValueNamePairs__Group__0__Impl7965);
            rule__ListOfValueNamePairs__ValueNamePairsAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__ListOfValueNamePairs__Group__0__Impl"


    // $ANTLR start "rule__ListOfValueNamePairs__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3891:1: rule__ListOfValueNamePairs__Group__1 : rule__ListOfValueNamePairs__Group__1__Impl ;
    public final void rule__ListOfValueNamePairs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3895:1: ( rule__ListOfValueNamePairs__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3896:2: rule__ListOfValueNamePairs__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group__1__Impl_in_rule__ListOfValueNamePairs__Group__17995);
            rule__ListOfValueNamePairs__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOfValueNamePairs__Group__1"


    // $ANTLR start "rule__ListOfValueNamePairs__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3902:1: rule__ListOfValueNamePairs__Group__1__Impl : ( ( rule__ListOfValueNamePairs__Group_1__0 )* ) ;
    public final void rule__ListOfValueNamePairs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3906:1: ( ( ( rule__ListOfValueNamePairs__Group_1__0 )* ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3907:1: ( ( rule__ListOfValueNamePairs__Group_1__0 )* )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3907:1: ( ( rule__ListOfValueNamePairs__Group_1__0 )* )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3908:1: ( rule__ListOfValueNamePairs__Group_1__0 )*
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getGroup_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3909:1: ( rule__ListOfValueNamePairs__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==44) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3909:2: rule__ListOfValueNamePairs__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__0_in_rule__ListOfValueNamePairs__Group__1__Impl8022);
            	    rule__ListOfValueNamePairs__Group_1__0();

            	    state._fsp--;


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
    // $ANTLR end "rule__ListOfValueNamePairs__Group__1__Impl"


    // $ANTLR start "rule__ListOfValueNamePairs__Group_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3923:1: rule__ListOfValueNamePairs__Group_1__0 : rule__ListOfValueNamePairs__Group_1__0__Impl rule__ListOfValueNamePairs__Group_1__1 ;
    public final void rule__ListOfValueNamePairs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3927:1: ( rule__ListOfValueNamePairs__Group_1__0__Impl rule__ListOfValueNamePairs__Group_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3928:2: rule__ListOfValueNamePairs__Group_1__0__Impl rule__ListOfValueNamePairs__Group_1__1
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__0__Impl_in_rule__ListOfValueNamePairs__Group_1__08057);
            rule__ListOfValueNamePairs__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__1_in_rule__ListOfValueNamePairs__Group_1__08060);
            rule__ListOfValueNamePairs__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOfValueNamePairs__Group_1__0"


    // $ANTLR start "rule__ListOfValueNamePairs__Group_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3935:1: rule__ListOfValueNamePairs__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ListOfValueNamePairs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3939:1: ( ( ',' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3940:1: ( ',' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3940:1: ( ',' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3941:1: ','
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
    // $ANTLR end "rule__ListOfValueNamePairs__Group_1__0__Impl"


    // $ANTLR start "rule__ListOfValueNamePairs__Group_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3954:1: rule__ListOfValueNamePairs__Group_1__1 : rule__ListOfValueNamePairs__Group_1__1__Impl ;
    public final void rule__ListOfValueNamePairs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3958:1: ( rule__ListOfValueNamePairs__Group_1__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3959:2: rule__ListOfValueNamePairs__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__Group_1__1__Impl_in_rule__ListOfValueNamePairs__Group_1__18119);
            rule__ListOfValueNamePairs__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListOfValueNamePairs__Group_1__1"


    // $ANTLR start "rule__ListOfValueNamePairs__Group_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3965:1: rule__ListOfValueNamePairs__Group_1__1__Impl : ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) ) ;
    public final void rule__ListOfValueNamePairs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3969:1: ( ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3970:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3970:1: ( ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3971:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 )
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsAssignment_1_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3972:1: ( rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3972:2: rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1_in_rule__ListOfValueNamePairs__Group_1__1__Impl8146);
            rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__ListOfValueNamePairs__Group_1__1__Impl"


    // $ANTLR start "rule__ValueNamePair__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3986:1: rule__ValueNamePair__Group__0 : rule__ValueNamePair__Group__0__Impl rule__ValueNamePair__Group__1 ;
    public final void rule__ValueNamePair__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3990:1: ( rule__ValueNamePair__Group__0__Impl rule__ValueNamePair__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3991:2: rule__ValueNamePair__Group__0__Impl rule__ValueNamePair__Group__1
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__0__Impl_in_rule__ValueNamePair__Group__08180);
            rule__ValueNamePair__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueNamePair__Group__1_in_rule__ValueNamePair__Group__08183);
            rule__ValueNamePair__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueNamePair__Group__0"


    // $ANTLR start "rule__ValueNamePair__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:3998:1: rule__ValueNamePair__Group__0__Impl : ( ( rule__ValueNamePair__PropertyAssignment_0 ) ) ;
    public final void rule__ValueNamePair__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4002:1: ( ( ( rule__ValueNamePair__PropertyAssignment_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4003:1: ( ( rule__ValueNamePair__PropertyAssignment_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4003:1: ( ( rule__ValueNamePair__PropertyAssignment_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4004:1: ( rule__ValueNamePair__PropertyAssignment_0 )
            {
             before(grammarAccess.getValueNamePairAccess().getPropertyAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4005:1: ( rule__ValueNamePair__PropertyAssignment_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4005:2: rule__ValueNamePair__PropertyAssignment_0
            {
            pushFollow(FOLLOW_rule__ValueNamePair__PropertyAssignment_0_in_rule__ValueNamePair__Group__0__Impl8210);
            rule__ValueNamePair__PropertyAssignment_0();

            state._fsp--;


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
    // $ANTLR end "rule__ValueNamePair__Group__0__Impl"


    // $ANTLR start "rule__ValueNamePair__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4015:1: rule__ValueNamePair__Group__1 : rule__ValueNamePair__Group__1__Impl rule__ValueNamePair__Group__2 ;
    public final void rule__ValueNamePair__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4019:1: ( rule__ValueNamePair__Group__1__Impl rule__ValueNamePair__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4020:2: rule__ValueNamePair__Group__1__Impl rule__ValueNamePair__Group__2
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__1__Impl_in_rule__ValueNamePair__Group__18240);
            rule__ValueNamePair__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueNamePair__Group__2_in_rule__ValueNamePair__Group__18243);
            rule__ValueNamePair__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueNamePair__Group__1"


    // $ANTLR start "rule__ValueNamePair__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4027:1: rule__ValueNamePair__Group__1__Impl : ( '=' ) ;
    public final void rule__ValueNamePair__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4031:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4032:1: ( '=' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4032:1: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4033:1: '='
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
    // $ANTLR end "rule__ValueNamePair__Group__1__Impl"


    // $ANTLR start "rule__ValueNamePair__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4046:1: rule__ValueNamePair__Group__2 : rule__ValueNamePair__Group__2__Impl ;
    public final void rule__ValueNamePair__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4050:1: ( rule__ValueNamePair__Group__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4051:2: rule__ValueNamePair__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ValueNamePair__Group__2__Impl_in_rule__ValueNamePair__Group__28302);
            rule__ValueNamePair__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueNamePair__Group__2"


    // $ANTLR start "rule__ValueNamePair__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4057:1: rule__ValueNamePair__Group__2__Impl : ( ( rule__ValueNamePair__ValueAssignment_2 ) ) ;
    public final void rule__ValueNamePair__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4061:1: ( ( ( rule__ValueNamePair__ValueAssignment_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4062:1: ( ( rule__ValueNamePair__ValueAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4062:1: ( ( rule__ValueNamePair__ValueAssignment_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4063:1: ( rule__ValueNamePair__ValueAssignment_2 )
            {
             before(grammarAccess.getValueNamePairAccess().getValueAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4064:1: ( rule__ValueNamePair__ValueAssignment_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4064:2: rule__ValueNamePair__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ValueNamePair__ValueAssignment_2_in_rule__ValueNamePair__Group__2__Impl8329);
            rule__ValueNamePair__ValueAssignment_2();

            state._fsp--;


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
    // $ANTLR end "rule__ValueNamePair__Group__2__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4080:1: rule__InstantObsExpression__Group__0 : rule__InstantObsExpression__Group__0__Impl rule__InstantObsExpression__Group__1 ;
    public final void rule__InstantObsExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4084:1: ( rule__InstantObsExpression__Group__0__Impl rule__InstantObsExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4085:2: rule__InstantObsExpression__Group__0__Impl rule__InstantObsExpression__Group__1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__0__Impl_in_rule__InstantObsExpression__Group__08365);
            rule__InstantObsExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group__1_in_rule__InstantObsExpression__Group__08368);
            rule__InstantObsExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group__0"


    // $ANTLR start "rule__InstantObsExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4092:1: rule__InstantObsExpression__Group__0__Impl : ( '@' ) ;
    public final void rule__InstantObsExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4096:1: ( ( '@' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4097:1: ( '@' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4097:1: ( '@' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4098:1: '@'
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
    // $ANTLR end "rule__InstantObsExpression__Group__0__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4111:1: rule__InstantObsExpression__Group__1 : rule__InstantObsExpression__Group__1__Impl rule__InstantObsExpression__Group__2 ;
    public final void rule__InstantObsExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4115:1: ( rule__InstantObsExpression__Group__1__Impl rule__InstantObsExpression__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4116:2: rule__InstantObsExpression__Group__1__Impl rule__InstantObsExpression__Group__2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__1__Impl_in_rule__InstantObsExpression__Group__18427);
            rule__InstantObsExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group__2_in_rule__InstantObsExpression__Group__18430);
            rule__InstantObsExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group__1"


    // $ANTLR start "rule__InstantObsExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4123:1: rule__InstantObsExpression__Group__1__Impl : ( ( rule__InstantObsExpression__IdAssignment_1 ) ) ;
    public final void rule__InstantObsExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4127:1: ( ( ( rule__InstantObsExpression__IdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4128:1: ( ( rule__InstantObsExpression__IdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4128:1: ( ( rule__InstantObsExpression__IdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4129:1: ( rule__InstantObsExpression__IdAssignment_1 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4130:1: ( rule__InstantObsExpression__IdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4130:2: rule__InstantObsExpression__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__IdAssignment_1_in_rule__InstantObsExpression__Group__1__Impl8457);
            rule__InstantObsExpression__IdAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__InstantObsExpression__Group__1__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4140:1: rule__InstantObsExpression__Group__2 : rule__InstantObsExpression__Group__2__Impl rule__InstantObsExpression__Group__3 ;
    public final void rule__InstantObsExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4144:1: ( rule__InstantObsExpression__Group__2__Impl rule__InstantObsExpression__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4145:2: rule__InstantObsExpression__Group__2__Impl rule__InstantObsExpression__Group__3
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__2__Impl_in_rule__InstantObsExpression__Group__28487);
            rule__InstantObsExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group__3_in_rule__InstantObsExpression__Group__28490);
            rule__InstantObsExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group__2"


    // $ANTLR start "rule__InstantObsExpression__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4152:1: rule__InstantObsExpression__Group__2__Impl : ( ( rule__InstantObsExpression__Group_2__0 )? ) ;
    public final void rule__InstantObsExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4156:1: ( ( ( rule__InstantObsExpression__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4157:1: ( ( rule__InstantObsExpression__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4157:1: ( ( rule__InstantObsExpression__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4158:1: ( rule__InstantObsExpression__Group_2__0 )?
            {
             before(grammarAccess.getInstantObsExpressionAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4159:1: ( rule__InstantObsExpression__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4159:2: rule__InstantObsExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__0_in_rule__InstantObsExpression__Group__2__Impl8517);
                    rule__InstantObsExpression__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__InstantObsExpression__Group__2__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4169:1: rule__InstantObsExpression__Group__3 : rule__InstantObsExpression__Group__3__Impl ;
    public final void rule__InstantObsExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4173:1: ( rule__InstantObsExpression__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4174:2: rule__InstantObsExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group__3__Impl_in_rule__InstantObsExpression__Group__38548);
            rule__InstantObsExpression__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group__3"


    // $ANTLR start "rule__InstantObsExpression__Group__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4180:1: rule__InstantObsExpression__Group__3__Impl : ( ( rule__InstantObsExpression__Group_3__0 )? ) ;
    public final void rule__InstantObsExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4184:1: ( ( ( rule__InstantObsExpression__Group_3__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4185:1: ( ( rule__InstantObsExpression__Group_3__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4185:1: ( ( rule__InstantObsExpression__Group_3__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4186:1: ( rule__InstantObsExpression__Group_3__0 )?
            {
             before(grammarAccess.getInstantObsExpressionAccess().getGroup_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4187:1: ( rule__InstantObsExpression__Group_3__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==47) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4187:2: rule__InstantObsExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__0_in_rule__InstantObsExpression__Group__3__Impl8575);
                    rule__InstantObsExpression__Group_3__0();

                    state._fsp--;


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
    // $ANTLR end "rule__InstantObsExpression__Group__3__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group_2__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4205:1: rule__InstantObsExpression__Group_2__0 : rule__InstantObsExpression__Group_2__0__Impl rule__InstantObsExpression__Group_2__1 ;
    public final void rule__InstantObsExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4209:1: ( rule__InstantObsExpression__Group_2__0__Impl rule__InstantObsExpression__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4210:2: rule__InstantObsExpression__Group_2__0__Impl rule__InstantObsExpression__Group_2__1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__0__Impl_in_rule__InstantObsExpression__Group_2__08614);
            rule__InstantObsExpression__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__1_in_rule__InstantObsExpression__Group_2__08617);
            rule__InstantObsExpression__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group_2__0"


    // $ANTLR start "rule__InstantObsExpression__Group_2__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4217:1: rule__InstantObsExpression__Group_2__0__Impl : ( '(' ) ;
    public final void rule__InstantObsExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4221:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4222:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4222:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4223:1: '('
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
    // $ANTLR end "rule__InstantObsExpression__Group_2__0__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group_2__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4236:1: rule__InstantObsExpression__Group_2__1 : rule__InstantObsExpression__Group_2__1__Impl rule__InstantObsExpression__Group_2__2 ;
    public final void rule__InstantObsExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4240:1: ( rule__InstantObsExpression__Group_2__1__Impl rule__InstantObsExpression__Group_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4241:2: rule__InstantObsExpression__Group_2__1__Impl rule__InstantObsExpression__Group_2__2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__1__Impl_in_rule__InstantObsExpression__Group_2__18676);
            rule__InstantObsExpression__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__2_in_rule__InstantObsExpression__Group_2__18679);
            rule__InstantObsExpression__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group_2__1"


    // $ANTLR start "rule__InstantObsExpression__Group_2__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4248:1: rule__InstantObsExpression__Group_2__1__Impl : ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) ) ;
    public final void rule__InstantObsExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4252:1: ( ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4253:1: ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4253:1: ( ( rule__InstantObsExpression__IndexAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4254:1: ( rule__InstantObsExpression__IndexAssignment_2_1 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIndexAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4255:1: ( rule__InstantObsExpression__IndexAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4255:2: rule__InstantObsExpression__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__IndexAssignment_2_1_in_rule__InstantObsExpression__Group_2__1__Impl8706);
            rule__InstantObsExpression__IndexAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__InstantObsExpression__Group_2__1__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group_2__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4265:1: rule__InstantObsExpression__Group_2__2 : rule__InstantObsExpression__Group_2__2__Impl ;
    public final void rule__InstantObsExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4269:1: ( rule__InstantObsExpression__Group_2__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4270:2: rule__InstantObsExpression__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_2__2__Impl_in_rule__InstantObsExpression__Group_2__28736);
            rule__InstantObsExpression__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group_2__2"


    // $ANTLR start "rule__InstantObsExpression__Group_2__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4276:1: rule__InstantObsExpression__Group_2__2__Impl : ( ')' ) ;
    public final void rule__InstantObsExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4280:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4281:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4281:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4282:1: ')'
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
    // $ANTLR end "rule__InstantObsExpression__Group_2__2__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group_3__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4301:1: rule__InstantObsExpression__Group_3__0 : rule__InstantObsExpression__Group_3__0__Impl rule__InstantObsExpression__Group_3__1 ;
    public final void rule__InstantObsExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4305:1: ( rule__InstantObsExpression__Group_3__0__Impl rule__InstantObsExpression__Group_3__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4306:2: rule__InstantObsExpression__Group_3__0__Impl rule__InstantObsExpression__Group_3__1
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__0__Impl_in_rule__InstantObsExpression__Group_3__08801);
            rule__InstantObsExpression__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__1_in_rule__InstantObsExpression__Group_3__08804);
            rule__InstantObsExpression__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group_3__0"


    // $ANTLR start "rule__InstantObsExpression__Group_3__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4313:1: rule__InstantObsExpression__Group_3__0__Impl : ( 'when' ) ;
    public final void rule__InstantObsExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4317:1: ( ( 'when' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4318:1: ( 'when' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4318:1: ( 'when' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4319:1: 'when'
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
    // $ANTLR end "rule__InstantObsExpression__Group_3__0__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group_3__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4332:1: rule__InstantObsExpression__Group_3__1 : rule__InstantObsExpression__Group_3__1__Impl rule__InstantObsExpression__Group_3__2 ;
    public final void rule__InstantObsExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4336:1: ( rule__InstantObsExpression__Group_3__1__Impl rule__InstantObsExpression__Group_3__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4337:2: rule__InstantObsExpression__Group_3__1__Impl rule__InstantObsExpression__Group_3__2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__1__Impl_in_rule__InstantObsExpression__Group_3__18863);
            rule__InstantObsExpression__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__2_in_rule__InstantObsExpression__Group_3__18866);
            rule__InstantObsExpression__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group_3__1"


    // $ANTLR start "rule__InstantObsExpression__Group_3__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4344:1: rule__InstantObsExpression__Group_3__1__Impl : ( '(' ) ;
    public final void rule__InstantObsExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4348:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4349:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4349:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4350:1: '('
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
    // $ANTLR end "rule__InstantObsExpression__Group_3__1__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group_3__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4363:1: rule__InstantObsExpression__Group_3__2 : rule__InstantObsExpression__Group_3__2__Impl rule__InstantObsExpression__Group_3__3 ;
    public final void rule__InstantObsExpression__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4367:1: ( rule__InstantObsExpression__Group_3__2__Impl rule__InstantObsExpression__Group_3__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4368:2: rule__InstantObsExpression__Group_3__2__Impl rule__InstantObsExpression__Group_3__3
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__2__Impl_in_rule__InstantObsExpression__Group_3__28925);
            rule__InstantObsExpression__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__3_in_rule__InstantObsExpression__Group_3__28928);
            rule__InstantObsExpression__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group_3__2"


    // $ANTLR start "rule__InstantObsExpression__Group_3__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4375:1: rule__InstantObsExpression__Group_3__2__Impl : ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) ) ;
    public final void rule__InstantObsExpression__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4379:1: ( ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4380:1: ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4380:1: ( ( rule__InstantObsExpression__ConditionAssignment_3_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4381:1: ( rule__InstantObsExpression__ConditionAssignment_3_2 )
            {
             before(grammarAccess.getInstantObsExpressionAccess().getConditionAssignment_3_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4382:1: ( rule__InstantObsExpression__ConditionAssignment_3_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4382:2: rule__InstantObsExpression__ConditionAssignment_3_2
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__ConditionAssignment_3_2_in_rule__InstantObsExpression__Group_3__2__Impl8955);
            rule__InstantObsExpression__ConditionAssignment_3_2();

            state._fsp--;


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
    // $ANTLR end "rule__InstantObsExpression__Group_3__2__Impl"


    // $ANTLR start "rule__InstantObsExpression__Group_3__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4392:1: rule__InstantObsExpression__Group_3__3 : rule__InstantObsExpression__Group_3__3__Impl ;
    public final void rule__InstantObsExpression__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4396:1: ( rule__InstantObsExpression__Group_3__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4397:2: rule__InstantObsExpression__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsExpression__Group_3__3__Impl_in_rule__InstantObsExpression__Group_3__38985);
            rule__InstantObsExpression__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsExpression__Group_3__3"


    // $ANTLR start "rule__InstantObsExpression__Group_3__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4403:1: rule__InstantObsExpression__Group_3__3__Impl : ( ')' ) ;
    public final void rule__InstantObsExpression__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4407:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4408:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4408:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4409:1: ')'
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
    // $ANTLR end "rule__InstantObsExpression__Group_3__3__Impl"


    // $ANTLR start "rule__InstantObsName__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4430:1: rule__InstantObsName__Group__0 : rule__InstantObsName__Group__0__Impl rule__InstantObsName__Group__1 ;
    public final void rule__InstantObsName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4434:1: ( rule__InstantObsName__Group__0__Impl rule__InstantObsName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4435:2: rule__InstantObsName__Group__0__Impl rule__InstantObsName__Group__1
            {
            pushFollow(FOLLOW_rule__InstantObsName__Group__0__Impl_in_rule__InstantObsName__Group__09052);
            rule__InstantObsName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__InstantObsName__Group__1_in_rule__InstantObsName__Group__09055);
            rule__InstantObsName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsName__Group__0"


    // $ANTLR start "rule__InstantObsName__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4442:1: rule__InstantObsName__Group__0__Impl : ( ( rule__InstantObsName__PathAssignment_0 )? ) ;
    public final void rule__InstantObsName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4446:1: ( ( ( rule__InstantObsName__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4447:1: ( ( rule__InstantObsName__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4447:1: ( ( rule__InstantObsName__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4448:1: ( rule__InstantObsName__PathAssignment_0 )?
            {
             before(grammarAccess.getInstantObsNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4449:1: ( rule__InstantObsName__PathAssignment_0 )?
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
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4449:2: rule__InstantObsName__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__InstantObsName__PathAssignment_0_in_rule__InstantObsName__Group__0__Impl9082);
                    rule__InstantObsName__PathAssignment_0();

                    state._fsp--;


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
    // $ANTLR end "rule__InstantObsName__Group__0__Impl"


    // $ANTLR start "rule__InstantObsName__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4459:1: rule__InstantObsName__Group__1 : rule__InstantObsName__Group__1__Impl ;
    public final void rule__InstantObsName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4463:1: ( rule__InstantObsName__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4464:2: rule__InstantObsName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__InstantObsName__Group__1__Impl_in_rule__InstantObsName__Group__19113);
            rule__InstantObsName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InstantObsName__Group__1"


    // $ANTLR start "rule__InstantObsName__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4470:1: rule__InstantObsName__Group__1__Impl : ( ( rule__InstantObsName__InstantIdAssignment_1 ) ) ;
    public final void rule__InstantObsName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4474:1: ( ( ( rule__InstantObsName__InstantIdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4475:1: ( ( rule__InstantObsName__InstantIdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4475:1: ( ( rule__InstantObsName__InstantIdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4476:1: ( rule__InstantObsName__InstantIdAssignment_1 )
            {
             before(grammarAccess.getInstantObsNameAccess().getInstantIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4477:1: ( rule__InstantObsName__InstantIdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4477:2: rule__InstantObsName__InstantIdAssignment_1
            {
            pushFollow(FOLLOW_rule__InstantObsName__InstantIdAssignment_1_in_rule__InstantObsName__Group__1__Impl9140);
            rule__InstantObsName__InstantIdAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__InstantObsName__Group__1__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4491:1: rule__DurationObsExpression__Group__0 : rule__DurationObsExpression__Group__0__Impl rule__DurationObsExpression__Group__1 ;
    public final void rule__DurationObsExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4495:1: ( rule__DurationObsExpression__Group__0__Impl rule__DurationObsExpression__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4496:2: rule__DurationObsExpression__Group__0__Impl rule__DurationObsExpression__Group__1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__0__Impl_in_rule__DurationObsExpression__Group__09174);
            rule__DurationObsExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group__1_in_rule__DurationObsExpression__Group__09177);
            rule__DurationObsExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group__0"


    // $ANTLR start "rule__DurationObsExpression__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4503:1: rule__DurationObsExpression__Group__0__Impl : ( '&' ) ;
    public final void rule__DurationObsExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4507:1: ( ( '&' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4508:1: ( '&' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4508:1: ( '&' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4509:1: '&'
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
    // $ANTLR end "rule__DurationObsExpression__Group__0__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4522:1: rule__DurationObsExpression__Group__1 : rule__DurationObsExpression__Group__1__Impl rule__DurationObsExpression__Group__2 ;
    public final void rule__DurationObsExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4526:1: ( rule__DurationObsExpression__Group__1__Impl rule__DurationObsExpression__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4527:2: rule__DurationObsExpression__Group__1__Impl rule__DurationObsExpression__Group__2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__1__Impl_in_rule__DurationObsExpression__Group__19236);
            rule__DurationObsExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group__2_in_rule__DurationObsExpression__Group__19239);
            rule__DurationObsExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group__1"


    // $ANTLR start "rule__DurationObsExpression__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4534:1: rule__DurationObsExpression__Group__1__Impl : ( ( rule__DurationObsExpression__IdAssignment_1 ) ) ;
    public final void rule__DurationObsExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4538:1: ( ( ( rule__DurationObsExpression__IdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4539:1: ( ( rule__DurationObsExpression__IdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4539:1: ( ( rule__DurationObsExpression__IdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4540:1: ( rule__DurationObsExpression__IdAssignment_1 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4541:1: ( rule__DurationObsExpression__IdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4541:2: rule__DurationObsExpression__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__IdAssignment_1_in_rule__DurationObsExpression__Group__1__Impl9266);
            rule__DurationObsExpression__IdAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__DurationObsExpression__Group__1__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4551:1: rule__DurationObsExpression__Group__2 : rule__DurationObsExpression__Group__2__Impl rule__DurationObsExpression__Group__3 ;
    public final void rule__DurationObsExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4555:1: ( rule__DurationObsExpression__Group__2__Impl rule__DurationObsExpression__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4556:2: rule__DurationObsExpression__Group__2__Impl rule__DurationObsExpression__Group__3
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__2__Impl_in_rule__DurationObsExpression__Group__29296);
            rule__DurationObsExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group__3_in_rule__DurationObsExpression__Group__29299);
            rule__DurationObsExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group__2"


    // $ANTLR start "rule__DurationObsExpression__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4563:1: rule__DurationObsExpression__Group__2__Impl : ( ( rule__DurationObsExpression__Group_2__0 )? ) ;
    public final void rule__DurationObsExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4567:1: ( ( ( rule__DurationObsExpression__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4568:1: ( ( rule__DurationObsExpression__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4568:1: ( ( rule__DurationObsExpression__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4569:1: ( rule__DurationObsExpression__Group_2__0 )?
            {
             before(grammarAccess.getDurationObsExpressionAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4570:1: ( rule__DurationObsExpression__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==38) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4570:2: rule__DurationObsExpression__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__0_in_rule__DurationObsExpression__Group__2__Impl9326);
                    rule__DurationObsExpression__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__DurationObsExpression__Group__2__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4580:1: rule__DurationObsExpression__Group__3 : rule__DurationObsExpression__Group__3__Impl ;
    public final void rule__DurationObsExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4584:1: ( rule__DurationObsExpression__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4585:2: rule__DurationObsExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group__3__Impl_in_rule__DurationObsExpression__Group__39357);
            rule__DurationObsExpression__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group__3"


    // $ANTLR start "rule__DurationObsExpression__Group__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4591:1: rule__DurationObsExpression__Group__3__Impl : ( ( rule__DurationObsExpression__Group_3__0 )? ) ;
    public final void rule__DurationObsExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4595:1: ( ( ( rule__DurationObsExpression__Group_3__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4596:1: ( ( rule__DurationObsExpression__Group_3__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4596:1: ( ( rule__DurationObsExpression__Group_3__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4597:1: ( rule__DurationObsExpression__Group_3__0 )?
            {
             before(grammarAccess.getDurationObsExpressionAccess().getGroup_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4598:1: ( rule__DurationObsExpression__Group_3__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==47) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4598:2: rule__DurationObsExpression__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__0_in_rule__DurationObsExpression__Group__3__Impl9384);
                    rule__DurationObsExpression__Group_3__0();

                    state._fsp--;


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
    // $ANTLR end "rule__DurationObsExpression__Group__3__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group_2__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4616:1: rule__DurationObsExpression__Group_2__0 : rule__DurationObsExpression__Group_2__0__Impl rule__DurationObsExpression__Group_2__1 ;
    public final void rule__DurationObsExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4620:1: ( rule__DurationObsExpression__Group_2__0__Impl rule__DurationObsExpression__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4621:2: rule__DurationObsExpression__Group_2__0__Impl rule__DurationObsExpression__Group_2__1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__0__Impl_in_rule__DurationObsExpression__Group_2__09423);
            rule__DurationObsExpression__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__1_in_rule__DurationObsExpression__Group_2__09426);
            rule__DurationObsExpression__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group_2__0"


    // $ANTLR start "rule__DurationObsExpression__Group_2__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4628:1: rule__DurationObsExpression__Group_2__0__Impl : ( '(' ) ;
    public final void rule__DurationObsExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4632:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4633:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4633:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4634:1: '('
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
    // $ANTLR end "rule__DurationObsExpression__Group_2__0__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group_2__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4647:1: rule__DurationObsExpression__Group_2__1 : rule__DurationObsExpression__Group_2__1__Impl rule__DurationObsExpression__Group_2__2 ;
    public final void rule__DurationObsExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4651:1: ( rule__DurationObsExpression__Group_2__1__Impl rule__DurationObsExpression__Group_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4652:2: rule__DurationObsExpression__Group_2__1__Impl rule__DurationObsExpression__Group_2__2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__1__Impl_in_rule__DurationObsExpression__Group_2__19485);
            rule__DurationObsExpression__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__2_in_rule__DurationObsExpression__Group_2__19488);
            rule__DurationObsExpression__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group_2__1"


    // $ANTLR start "rule__DurationObsExpression__Group_2__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4659:1: rule__DurationObsExpression__Group_2__1__Impl : ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) ) ;
    public final void rule__DurationObsExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4663:1: ( ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4664:1: ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4664:1: ( ( rule__DurationObsExpression__IndexAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4665:1: ( rule__DurationObsExpression__IndexAssignment_2_1 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIndexAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4666:1: ( rule__DurationObsExpression__IndexAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4666:2: rule__DurationObsExpression__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__IndexAssignment_2_1_in_rule__DurationObsExpression__Group_2__1__Impl9515);
            rule__DurationObsExpression__IndexAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__DurationObsExpression__Group_2__1__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group_2__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4676:1: rule__DurationObsExpression__Group_2__2 : rule__DurationObsExpression__Group_2__2__Impl ;
    public final void rule__DurationObsExpression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4680:1: ( rule__DurationObsExpression__Group_2__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4681:2: rule__DurationObsExpression__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_2__2__Impl_in_rule__DurationObsExpression__Group_2__29545);
            rule__DurationObsExpression__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group_2__2"


    // $ANTLR start "rule__DurationObsExpression__Group_2__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4687:1: rule__DurationObsExpression__Group_2__2__Impl : ( ')' ) ;
    public final void rule__DurationObsExpression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4691:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4692:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4692:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4693:1: ')'
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
    // $ANTLR end "rule__DurationObsExpression__Group_2__2__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group_3__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4712:1: rule__DurationObsExpression__Group_3__0 : rule__DurationObsExpression__Group_3__0__Impl rule__DurationObsExpression__Group_3__1 ;
    public final void rule__DurationObsExpression__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4716:1: ( rule__DurationObsExpression__Group_3__0__Impl rule__DurationObsExpression__Group_3__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4717:2: rule__DurationObsExpression__Group_3__0__Impl rule__DurationObsExpression__Group_3__1
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__0__Impl_in_rule__DurationObsExpression__Group_3__09610);
            rule__DurationObsExpression__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__1_in_rule__DurationObsExpression__Group_3__09613);
            rule__DurationObsExpression__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group_3__0"


    // $ANTLR start "rule__DurationObsExpression__Group_3__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4724:1: rule__DurationObsExpression__Group_3__0__Impl : ( 'when' ) ;
    public final void rule__DurationObsExpression__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4728:1: ( ( 'when' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4729:1: ( 'when' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4729:1: ( 'when' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4730:1: 'when'
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
    // $ANTLR end "rule__DurationObsExpression__Group_3__0__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group_3__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4743:1: rule__DurationObsExpression__Group_3__1 : rule__DurationObsExpression__Group_3__1__Impl rule__DurationObsExpression__Group_3__2 ;
    public final void rule__DurationObsExpression__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4747:1: ( rule__DurationObsExpression__Group_3__1__Impl rule__DurationObsExpression__Group_3__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4748:2: rule__DurationObsExpression__Group_3__1__Impl rule__DurationObsExpression__Group_3__2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__1__Impl_in_rule__DurationObsExpression__Group_3__19672);
            rule__DurationObsExpression__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__2_in_rule__DurationObsExpression__Group_3__19675);
            rule__DurationObsExpression__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group_3__1"


    // $ANTLR start "rule__DurationObsExpression__Group_3__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4755:1: rule__DurationObsExpression__Group_3__1__Impl : ( '(' ) ;
    public final void rule__DurationObsExpression__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4759:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4760:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4760:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4761:1: '('
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
    // $ANTLR end "rule__DurationObsExpression__Group_3__1__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group_3__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4774:1: rule__DurationObsExpression__Group_3__2 : rule__DurationObsExpression__Group_3__2__Impl rule__DurationObsExpression__Group_3__3 ;
    public final void rule__DurationObsExpression__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4778:1: ( rule__DurationObsExpression__Group_3__2__Impl rule__DurationObsExpression__Group_3__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4779:2: rule__DurationObsExpression__Group_3__2__Impl rule__DurationObsExpression__Group_3__3
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__2__Impl_in_rule__DurationObsExpression__Group_3__29734);
            rule__DurationObsExpression__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__3_in_rule__DurationObsExpression__Group_3__29737);
            rule__DurationObsExpression__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group_3__2"


    // $ANTLR start "rule__DurationObsExpression__Group_3__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4786:1: rule__DurationObsExpression__Group_3__2__Impl : ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) ) ;
    public final void rule__DurationObsExpression__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4790:1: ( ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4791:1: ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4791:1: ( ( rule__DurationObsExpression__ConditionAssignment_3_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4792:1: ( rule__DurationObsExpression__ConditionAssignment_3_2 )
            {
             before(grammarAccess.getDurationObsExpressionAccess().getConditionAssignment_3_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4793:1: ( rule__DurationObsExpression__ConditionAssignment_3_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4793:2: rule__DurationObsExpression__ConditionAssignment_3_2
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__ConditionAssignment_3_2_in_rule__DurationObsExpression__Group_3__2__Impl9764);
            rule__DurationObsExpression__ConditionAssignment_3_2();

            state._fsp--;


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
    // $ANTLR end "rule__DurationObsExpression__Group_3__2__Impl"


    // $ANTLR start "rule__DurationObsExpression__Group_3__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4803:1: rule__DurationObsExpression__Group_3__3 : rule__DurationObsExpression__Group_3__3__Impl ;
    public final void rule__DurationObsExpression__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4807:1: ( rule__DurationObsExpression__Group_3__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4808:2: rule__DurationObsExpression__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsExpression__Group_3__3__Impl_in_rule__DurationObsExpression__Group_3__39794);
            rule__DurationObsExpression__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsExpression__Group_3__3"


    // $ANTLR start "rule__DurationObsExpression__Group_3__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4814:1: rule__DurationObsExpression__Group_3__3__Impl : ( ')' ) ;
    public final void rule__DurationObsExpression__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4818:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4819:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4819:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4820:1: ')'
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
    // $ANTLR end "rule__DurationObsExpression__Group_3__3__Impl"


    // $ANTLR start "rule__DurationObsName__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4841:1: rule__DurationObsName__Group__0 : rule__DurationObsName__Group__0__Impl rule__DurationObsName__Group__1 ;
    public final void rule__DurationObsName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4845:1: ( rule__DurationObsName__Group__0__Impl rule__DurationObsName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4846:2: rule__DurationObsName__Group__0__Impl rule__DurationObsName__Group__1
            {
            pushFollow(FOLLOW_rule__DurationObsName__Group__0__Impl_in_rule__DurationObsName__Group__09861);
            rule__DurationObsName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DurationObsName__Group__1_in_rule__DurationObsName__Group__09864);
            rule__DurationObsName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsName__Group__0"


    // $ANTLR start "rule__DurationObsName__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4853:1: rule__DurationObsName__Group__0__Impl : ( ( rule__DurationObsName__PathAssignment_0 )? ) ;
    public final void rule__DurationObsName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4857:1: ( ( ( rule__DurationObsName__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4858:1: ( ( rule__DurationObsName__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4858:1: ( ( rule__DurationObsName__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4859:1: ( rule__DurationObsName__PathAssignment_0 )?
            {
             before(grammarAccess.getDurationObsNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4860:1: ( rule__DurationObsName__PathAssignment_0 )?
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
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4860:2: rule__DurationObsName__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DurationObsName__PathAssignment_0_in_rule__DurationObsName__Group__0__Impl9891);
                    rule__DurationObsName__PathAssignment_0();

                    state._fsp--;


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
    // $ANTLR end "rule__DurationObsName__Group__0__Impl"


    // $ANTLR start "rule__DurationObsName__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4870:1: rule__DurationObsName__Group__1 : rule__DurationObsName__Group__1__Impl ;
    public final void rule__DurationObsName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4874:1: ( rule__DurationObsName__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4875:2: rule__DurationObsName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DurationObsName__Group__1__Impl_in_rule__DurationObsName__Group__19922);
            rule__DurationObsName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DurationObsName__Group__1"


    // $ANTLR start "rule__DurationObsName__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4881:1: rule__DurationObsName__Group__1__Impl : ( ( rule__DurationObsName__DurationIdAssignment_1 ) ) ;
    public final void rule__DurationObsName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4885:1: ( ( ( rule__DurationObsName__DurationIdAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4886:1: ( ( rule__DurationObsName__DurationIdAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4886:1: ( ( rule__DurationObsName__DurationIdAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4887:1: ( rule__DurationObsName__DurationIdAssignment_1 )
            {
             before(grammarAccess.getDurationObsNameAccess().getDurationIdAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4888:1: ( rule__DurationObsName__DurationIdAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4888:2: rule__DurationObsName__DurationIdAssignment_1
            {
            pushFollow(FOLLOW_rule__DurationObsName__DurationIdAssignment_1_in_rule__DurationObsName__Group__1__Impl9949);
            rule__DurationObsName__DurationIdAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__DurationObsName__Group__1__Impl"


    // $ANTLR start "rule__JitterExp__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4902:1: rule__JitterExp__Group__0 : rule__JitterExp__Group__0__Impl rule__JitterExp__Group__1 ;
    public final void rule__JitterExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4906:1: ( rule__JitterExp__Group__0__Impl rule__JitterExp__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4907:2: rule__JitterExp__Group__0__Impl rule__JitterExp__Group__1
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__0__Impl_in_rule__JitterExp__Group__09983);
            rule__JitterExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group__1_in_rule__JitterExp__Group__09986);
            rule__JitterExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JitterExp__Group__0"


    // $ANTLR start "rule__JitterExp__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4914:1: rule__JitterExp__Group__0__Impl : ( 'jitter(' ) ;
    public final void rule__JitterExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4918:1: ( ( 'jitter(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4919:1: ( 'jitter(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4919:1: ( 'jitter(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4920:1: 'jitter('
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
    // $ANTLR end "rule__JitterExp__Group__0__Impl"


    // $ANTLR start "rule__JitterExp__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4933:1: rule__JitterExp__Group__1 : rule__JitterExp__Group__1__Impl rule__JitterExp__Group__2 ;
    public final void rule__JitterExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4937:1: ( rule__JitterExp__Group__1__Impl rule__JitterExp__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4938:2: rule__JitterExp__Group__1__Impl rule__JitterExp__Group__2
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__1__Impl_in_rule__JitterExp__Group__110045);
            rule__JitterExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group__2_in_rule__JitterExp__Group__110048);
            rule__JitterExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JitterExp__Group__1"


    // $ANTLR start "rule__JitterExp__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4945:1: rule__JitterExp__Group__1__Impl : ( ( rule__JitterExp__FirstInstantAssignment_1 ) ) ;
    public final void rule__JitterExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4949:1: ( ( ( rule__JitterExp__FirstInstantAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4950:1: ( ( rule__JitterExp__FirstInstantAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4950:1: ( ( rule__JitterExp__FirstInstantAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4951:1: ( rule__JitterExp__FirstInstantAssignment_1 )
            {
             before(grammarAccess.getJitterExpAccess().getFirstInstantAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4952:1: ( rule__JitterExp__FirstInstantAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4952:2: rule__JitterExp__FirstInstantAssignment_1
            {
            pushFollow(FOLLOW_rule__JitterExp__FirstInstantAssignment_1_in_rule__JitterExp__Group__1__Impl10075);
            rule__JitterExp__FirstInstantAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__JitterExp__Group__1__Impl"


    // $ANTLR start "rule__JitterExp__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4962:1: rule__JitterExp__Group__2 : rule__JitterExp__Group__2__Impl rule__JitterExp__Group__3 ;
    public final void rule__JitterExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4966:1: ( rule__JitterExp__Group__2__Impl rule__JitterExp__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4967:2: rule__JitterExp__Group__2__Impl rule__JitterExp__Group__3
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__2__Impl_in_rule__JitterExp__Group__210105);
            rule__JitterExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group__3_in_rule__JitterExp__Group__210108);
            rule__JitterExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JitterExp__Group__2"


    // $ANTLR start "rule__JitterExp__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4974:1: rule__JitterExp__Group__2__Impl : ( ( rule__JitterExp__Group_2__0 )? ) ;
    public final void rule__JitterExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4978:1: ( ( ( rule__JitterExp__Group_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4979:1: ( ( rule__JitterExp__Group_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4979:1: ( ( rule__JitterExp__Group_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4980:1: ( rule__JitterExp__Group_2__0 )?
            {
             before(grammarAccess.getJitterExpAccess().getGroup_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4981:1: ( rule__JitterExp__Group_2__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==26) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4981:2: rule__JitterExp__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__JitterExp__Group_2__0_in_rule__JitterExp__Group__2__Impl10135);
                    rule__JitterExp__Group_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__JitterExp__Group__2__Impl"


    // $ANTLR start "rule__JitterExp__Group__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4991:1: rule__JitterExp__Group__3 : rule__JitterExp__Group__3__Impl ;
    public final void rule__JitterExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4995:1: ( rule__JitterExp__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:4996:2: rule__JitterExp__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__JitterExp__Group__3__Impl_in_rule__JitterExp__Group__310166);
            rule__JitterExp__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JitterExp__Group__3"


    // $ANTLR start "rule__JitterExp__Group__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5002:1: rule__JitterExp__Group__3__Impl : ( ')' ) ;
    public final void rule__JitterExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5006:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5007:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5007:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5008:1: ')'
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
    // $ANTLR end "rule__JitterExp__Group__3__Impl"


    // $ANTLR start "rule__JitterExp__Group_2__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5029:1: rule__JitterExp__Group_2__0 : rule__JitterExp__Group_2__0__Impl rule__JitterExp__Group_2__1 ;
    public final void rule__JitterExp__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5033:1: ( rule__JitterExp__Group_2__0__Impl rule__JitterExp__Group_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5034:2: rule__JitterExp__Group_2__0__Impl rule__JitterExp__Group_2__1
            {
            pushFollow(FOLLOW_rule__JitterExp__Group_2__0__Impl_in_rule__JitterExp__Group_2__010233);
            rule__JitterExp__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__JitterExp__Group_2__1_in_rule__JitterExp__Group_2__010236);
            rule__JitterExp__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JitterExp__Group_2__0"


    // $ANTLR start "rule__JitterExp__Group_2__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5041:1: rule__JitterExp__Group_2__0__Impl : ( '-' ) ;
    public final void rule__JitterExp__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5045:1: ( ( '-' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5046:1: ( '-' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5046:1: ( '-' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5047:1: '-'
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
    // $ANTLR end "rule__JitterExp__Group_2__0__Impl"


    // $ANTLR start "rule__JitterExp__Group_2__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5060:1: rule__JitterExp__Group_2__1 : rule__JitterExp__Group_2__1__Impl ;
    public final void rule__JitterExp__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5064:1: ( rule__JitterExp__Group_2__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5065:2: rule__JitterExp__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__JitterExp__Group_2__1__Impl_in_rule__JitterExp__Group_2__110295);
            rule__JitterExp__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JitterExp__Group_2__1"


    // $ANTLR start "rule__JitterExp__Group_2__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5071:1: rule__JitterExp__Group_2__1__Impl : ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) ) ;
    public final void rule__JitterExp__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5075:1: ( ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5076:1: ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5076:1: ( ( rule__JitterExp__SecondInstantAssignment_2_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5077:1: ( rule__JitterExp__SecondInstantAssignment_2_1 )
            {
             before(grammarAccess.getJitterExpAccess().getSecondInstantAssignment_2_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5078:1: ( rule__JitterExp__SecondInstantAssignment_2_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5078:2: rule__JitterExp__SecondInstantAssignment_2_1
            {
            pushFollow(FOLLOW_rule__JitterExp__SecondInstantAssignment_2_1_in_rule__JitterExp__Group_2__1__Impl10322);
            rule__JitterExp__SecondInstantAssignment_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__JitterExp__Group_2__1__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5092:1: rule__VariableDeclaration__Group__0 : rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 ;
    public final void rule__VariableDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5096:1: ( rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5097:2: rule__VariableDeclaration__Group__0__Impl rule__VariableDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__0__Impl_in_rule__VariableDeclaration__Group__010356);
            rule__VariableDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group__1_in_rule__VariableDeclaration__Group__010359);
            rule__VariableDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__0"


    // $ANTLR start "rule__VariableDeclaration__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5104:1: rule__VariableDeclaration__Group__0__Impl : ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? ) ;
    public final void rule__VariableDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5108:1: ( ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5109:1: ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5109:1: ( ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5110:1: ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )?
            {
             before(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5111:1: ( rule__VariableDeclaration__VariableDeclarationAssignment_0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=33 && LA40_0<=35)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5111:2: rule__VariableDeclaration__VariableDeclarationAssignment_0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__VariableDeclarationAssignment_0_in_rule__VariableDeclaration__Group__0__Impl10386);
                    rule__VariableDeclaration__VariableDeclarationAssignment_0();

                    state._fsp--;


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
    // $ANTLR end "rule__VariableDeclaration__Group__0__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5121:1: rule__VariableDeclaration__Group__1 : rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2 ;
    public final void rule__VariableDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5125:1: ( rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5126:2: rule__VariableDeclaration__Group__1__Impl rule__VariableDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__1__Impl_in_rule__VariableDeclaration__Group__110417);
            rule__VariableDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group__2_in_rule__VariableDeclaration__Group__110420);
            rule__VariableDeclaration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__1"


    // $ANTLR start "rule__VariableDeclaration__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5133:1: rule__VariableDeclaration__Group__1__Impl : ( '$' ) ;
    public final void rule__VariableDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5137:1: ( ( '$' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5138:1: ( '$' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5138:1: ( '$' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5139:1: '$'
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
    // $ANTLR end "rule__VariableDeclaration__Group__1__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5152:1: rule__VariableDeclaration__Group__2 : rule__VariableDeclaration__Group__2__Impl rule__VariableDeclaration__Group__3 ;
    public final void rule__VariableDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5156:1: ( rule__VariableDeclaration__Group__2__Impl rule__VariableDeclaration__Group__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5157:2: rule__VariableDeclaration__Group__2__Impl rule__VariableDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__2__Impl_in_rule__VariableDeclaration__Group__210479);
            rule__VariableDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group__3_in_rule__VariableDeclaration__Group__210482);
            rule__VariableDeclaration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__2"


    // $ANTLR start "rule__VariableDeclaration__Group__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5164:1: rule__VariableDeclaration__Group__2__Impl : ( ( rule__VariableDeclaration__NameAssignment_2 ) ) ;
    public final void rule__VariableDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5168:1: ( ( ( rule__VariableDeclaration__NameAssignment_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5169:1: ( ( rule__VariableDeclaration__NameAssignment_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5169:1: ( ( rule__VariableDeclaration__NameAssignment_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5170:1: ( rule__VariableDeclaration__NameAssignment_2 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5171:1: ( rule__VariableDeclaration__NameAssignment_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5171:2: rule__VariableDeclaration__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__NameAssignment_2_in_rule__VariableDeclaration__Group__2__Impl10509);
            rule__VariableDeclaration__NameAssignment_2();

            state._fsp--;


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
    // $ANTLR end "rule__VariableDeclaration__Group__2__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5181:1: rule__VariableDeclaration__Group__3 : rule__VariableDeclaration__Group__3__Impl ;
    public final void rule__VariableDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5185:1: ( rule__VariableDeclaration__Group__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5186:2: rule__VariableDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group__3__Impl_in_rule__VariableDeclaration__Group__310539);
            rule__VariableDeclaration__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group__3"


    // $ANTLR start "rule__VariableDeclaration__Group__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5192:1: rule__VariableDeclaration__Group__3__Impl : ( ( rule__VariableDeclaration__Alternatives_3 ) ) ;
    public final void rule__VariableDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5196:1: ( ( ( rule__VariableDeclaration__Alternatives_3 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5197:1: ( ( rule__VariableDeclaration__Alternatives_3 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5197:1: ( ( rule__VariableDeclaration__Alternatives_3 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5198:1: ( rule__VariableDeclaration__Alternatives_3 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getAlternatives_3()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5199:1: ( rule__VariableDeclaration__Alternatives_3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5199:2: rule__VariableDeclaration__Alternatives_3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Alternatives_3_in_rule__VariableDeclaration__Group__3__Impl10566);
            rule__VariableDeclaration__Alternatives_3();

            state._fsp--;


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
    // $ANTLR end "rule__VariableDeclaration__Group__3__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5217:1: rule__VariableDeclaration__Group_3_0__0 : rule__VariableDeclaration__Group_3_0__0__Impl rule__VariableDeclaration__Group_3_0__1 ;
    public final void rule__VariableDeclaration__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5221:1: ( rule__VariableDeclaration__Group_3_0__0__Impl rule__VariableDeclaration__Group_3_0__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5222:2: rule__VariableDeclaration__Group_3_0__0__Impl rule__VariableDeclaration__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__0__Impl_in_rule__VariableDeclaration__Group_3_0__010604);
            rule__VariableDeclaration__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__1_in_rule__VariableDeclaration__Group_3_0__010607);
            rule__VariableDeclaration__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_0__0"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5229:1: rule__VariableDeclaration__Group_3_0__0__Impl : ( ':' ) ;
    public final void rule__VariableDeclaration__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5233:1: ( ( ':' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5234:1: ( ':' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5234:1: ( ':' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5235:1: ':'
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
    // $ANTLR end "rule__VariableDeclaration__Group_3_0__0__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5248:1: rule__VariableDeclaration__Group_3_0__1 : rule__VariableDeclaration__Group_3_0__1__Impl rule__VariableDeclaration__Group_3_0__2 ;
    public final void rule__VariableDeclaration__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5252:1: ( rule__VariableDeclaration__Group_3_0__1__Impl rule__VariableDeclaration__Group_3_0__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5253:2: rule__VariableDeclaration__Group_3_0__1__Impl rule__VariableDeclaration__Group_3_0__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__1__Impl_in_rule__VariableDeclaration__Group_3_0__110666);
            rule__VariableDeclaration__Group_3_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__2_in_rule__VariableDeclaration__Group_3_0__110669);
            rule__VariableDeclaration__Group_3_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_0__1"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5260:1: rule__VariableDeclaration__Group_3_0__1__Impl : ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) ) ;
    public final void rule__VariableDeclaration__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5264:1: ( ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5265:1: ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5265:1: ( ( rule__VariableDeclaration__TypeAssignment_3_0_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5266:1: ( rule__VariableDeclaration__TypeAssignment_3_0_1 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_3_0_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5267:1: ( rule__VariableDeclaration__TypeAssignment_3_0_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5267:2: rule__VariableDeclaration__TypeAssignment_3_0_1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__TypeAssignment_3_0_1_in_rule__VariableDeclaration__Group_3_0__1__Impl10696);
            rule__VariableDeclaration__TypeAssignment_3_0_1();

            state._fsp--;


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
    // $ANTLR end "rule__VariableDeclaration__Group_3_0__1__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5277:1: rule__VariableDeclaration__Group_3_0__2 : rule__VariableDeclaration__Group_3_0__2__Impl ;
    public final void rule__VariableDeclaration__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5281:1: ( rule__VariableDeclaration__Group_3_0__2__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5282:2: rule__VariableDeclaration__Group_3_0__2__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0__2__Impl_in_rule__VariableDeclaration__Group_3_0__210726);
            rule__VariableDeclaration__Group_3_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_0__2"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5288:1: rule__VariableDeclaration__Group_3_0__2__Impl : ( ( rule__VariableDeclaration__Group_3_0_2__0 )? ) ;
    public final void rule__VariableDeclaration__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5292:1: ( ( ( rule__VariableDeclaration__Group_3_0_2__0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5293:1: ( ( rule__VariableDeclaration__Group_3_0_2__0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5293:1: ( ( rule__VariableDeclaration__Group_3_0_2__0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5294:1: ( rule__VariableDeclaration__Group_3_0_2__0 )?
            {
             before(grammarAccess.getVariableDeclarationAccess().getGroup_3_0_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5295:1: ( rule__VariableDeclaration__Group_3_0_2__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==45) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5295:2: rule__VariableDeclaration__Group_3_0_2__0
                    {
                    pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__0_in_rule__VariableDeclaration__Group_3_0__2__Impl10753);
                    rule__VariableDeclaration__Group_3_0_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__VariableDeclaration__Group_3_0__2__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0_2__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5311:1: rule__VariableDeclaration__Group_3_0_2__0 : rule__VariableDeclaration__Group_3_0_2__0__Impl rule__VariableDeclaration__Group_3_0_2__1 ;
    public final void rule__VariableDeclaration__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5315:1: ( rule__VariableDeclaration__Group_3_0_2__0__Impl rule__VariableDeclaration__Group_3_0_2__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5316:2: rule__VariableDeclaration__Group_3_0_2__0__Impl rule__VariableDeclaration__Group_3_0_2__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__0__Impl_in_rule__VariableDeclaration__Group_3_0_2__010790);
            rule__VariableDeclaration__Group_3_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__1_in_rule__VariableDeclaration__Group_3_0_2__010793);
            rule__VariableDeclaration__Group_3_0_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_0_2__0"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0_2__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5323:1: rule__VariableDeclaration__Group_3_0_2__0__Impl : ( '=' ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5327:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5328:1: ( '=' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5328:1: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5329:1: '='
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
    // $ANTLR end "rule__VariableDeclaration__Group_3_0_2__0__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0_2__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5342:1: rule__VariableDeclaration__Group_3_0_2__1 : rule__VariableDeclaration__Group_3_0_2__1__Impl rule__VariableDeclaration__Group_3_0_2__2 ;
    public final void rule__VariableDeclaration__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5346:1: ( rule__VariableDeclaration__Group_3_0_2__1__Impl rule__VariableDeclaration__Group_3_0_2__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5347:2: rule__VariableDeclaration__Group_3_0_2__1__Impl rule__VariableDeclaration__Group_3_0_2__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__1__Impl_in_rule__VariableDeclaration__Group_3_0_2__110852);
            rule__VariableDeclaration__Group_3_0_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__2_in_rule__VariableDeclaration__Group_3_0_2__110855);
            rule__VariableDeclaration__Group_3_0_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_0_2__1"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0_2__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5354:1: rule__VariableDeclaration__Group_3_0_2__1__Impl : ( '(' ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5358:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5359:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5359:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5360:1: '('
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
    // $ANTLR end "rule__VariableDeclaration__Group_3_0_2__1__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0_2__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5373:1: rule__VariableDeclaration__Group_3_0_2__2 : rule__VariableDeclaration__Group_3_0_2__2__Impl rule__VariableDeclaration__Group_3_0_2__3 ;
    public final void rule__VariableDeclaration__Group_3_0_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5377:1: ( rule__VariableDeclaration__Group_3_0_2__2__Impl rule__VariableDeclaration__Group_3_0_2__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5378:2: rule__VariableDeclaration__Group_3_0_2__2__Impl rule__VariableDeclaration__Group_3_0_2__3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__2__Impl_in_rule__VariableDeclaration__Group_3_0_2__210914);
            rule__VariableDeclaration__Group_3_0_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__3_in_rule__VariableDeclaration__Group_3_0_2__210917);
            rule__VariableDeclaration__Group_3_0_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_0_2__2"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0_2__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5385:1: rule__VariableDeclaration__Group_3_0_2__2__Impl : ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5389:1: ( ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5390:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5390:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5391:1: ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueAssignment_3_0_2_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5392:1: ( rule__VariableDeclaration__InitValueAssignment_3_0_2_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5392:2: rule__VariableDeclaration__InitValueAssignment_3_0_2_2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_0_2_2_in_rule__VariableDeclaration__Group_3_0_2__2__Impl10944);
            rule__VariableDeclaration__InitValueAssignment_3_0_2_2();

            state._fsp--;


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
    // $ANTLR end "rule__VariableDeclaration__Group_3_0_2__2__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0_2__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5402:1: rule__VariableDeclaration__Group_3_0_2__3 : rule__VariableDeclaration__Group_3_0_2__3__Impl ;
    public final void rule__VariableDeclaration__Group_3_0_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5406:1: ( rule__VariableDeclaration__Group_3_0_2__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5407:2: rule__VariableDeclaration__Group_3_0_2__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_0_2__3__Impl_in_rule__VariableDeclaration__Group_3_0_2__310974);
            rule__VariableDeclaration__Group_3_0_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_0_2__3"


    // $ANTLR start "rule__VariableDeclaration__Group_3_0_2__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5413:1: rule__VariableDeclaration__Group_3_0_2__3__Impl : ( ')' ) ;
    public final void rule__VariableDeclaration__Group_3_0_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5417:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5418:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5418:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5419:1: ')'
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
    // $ANTLR end "rule__VariableDeclaration__Group_3_0_2__3__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_1__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5440:1: rule__VariableDeclaration__Group_3_1__0 : rule__VariableDeclaration__Group_3_1__0__Impl rule__VariableDeclaration__Group_3_1__1 ;
    public final void rule__VariableDeclaration__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5444:1: ( rule__VariableDeclaration__Group_3_1__0__Impl rule__VariableDeclaration__Group_3_1__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5445:2: rule__VariableDeclaration__Group_3_1__0__Impl rule__VariableDeclaration__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__0__Impl_in_rule__VariableDeclaration__Group_3_1__011041);
            rule__VariableDeclaration__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__1_in_rule__VariableDeclaration__Group_3_1__011044);
            rule__VariableDeclaration__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_1__0"


    // $ANTLR start "rule__VariableDeclaration__Group_3_1__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5452:1: rule__VariableDeclaration__Group_3_1__0__Impl : ( '=' ) ;
    public final void rule__VariableDeclaration__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5456:1: ( ( '=' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5457:1: ( '=' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5457:1: ( '=' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5458:1: '='
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
    // $ANTLR end "rule__VariableDeclaration__Group_3_1__0__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_1__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5471:1: rule__VariableDeclaration__Group_3_1__1 : rule__VariableDeclaration__Group_3_1__1__Impl rule__VariableDeclaration__Group_3_1__2 ;
    public final void rule__VariableDeclaration__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5475:1: ( rule__VariableDeclaration__Group_3_1__1__Impl rule__VariableDeclaration__Group_3_1__2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5476:2: rule__VariableDeclaration__Group_3_1__1__Impl rule__VariableDeclaration__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__1__Impl_in_rule__VariableDeclaration__Group_3_1__111103);
            rule__VariableDeclaration__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__2_in_rule__VariableDeclaration__Group_3_1__111106);
            rule__VariableDeclaration__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_1__1"


    // $ANTLR start "rule__VariableDeclaration__Group_3_1__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5483:1: rule__VariableDeclaration__Group_3_1__1__Impl : ( '(' ) ;
    public final void rule__VariableDeclaration__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5487:1: ( ( '(' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5488:1: ( '(' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5488:1: ( '(' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5489:1: '('
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
    // $ANTLR end "rule__VariableDeclaration__Group_3_1__1__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_1__2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5502:1: rule__VariableDeclaration__Group_3_1__2 : rule__VariableDeclaration__Group_3_1__2__Impl rule__VariableDeclaration__Group_3_1__3 ;
    public final void rule__VariableDeclaration__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5506:1: ( rule__VariableDeclaration__Group_3_1__2__Impl rule__VariableDeclaration__Group_3_1__3 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5507:2: rule__VariableDeclaration__Group_3_1__2__Impl rule__VariableDeclaration__Group_3_1__3
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__2__Impl_in_rule__VariableDeclaration__Group_3_1__211165);
            rule__VariableDeclaration__Group_3_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__3_in_rule__VariableDeclaration__Group_3_1__211168);
            rule__VariableDeclaration__Group_3_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_1__2"


    // $ANTLR start "rule__VariableDeclaration__Group_3_1__2__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5514:1: rule__VariableDeclaration__Group_3_1__2__Impl : ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) ) ;
    public final void rule__VariableDeclaration__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5518:1: ( ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5519:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5519:1: ( ( rule__VariableDeclaration__InitValueAssignment_3_1_2 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5520:1: ( rule__VariableDeclaration__InitValueAssignment_3_1_2 )
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueAssignment_3_1_2()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5521:1: ( rule__VariableDeclaration__InitValueAssignment_3_1_2 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5521:2: rule__VariableDeclaration__InitValueAssignment_3_1_2
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__InitValueAssignment_3_1_2_in_rule__VariableDeclaration__Group_3_1__2__Impl11195);
            rule__VariableDeclaration__InitValueAssignment_3_1_2();

            state._fsp--;


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
    // $ANTLR end "rule__VariableDeclaration__Group_3_1__2__Impl"


    // $ANTLR start "rule__VariableDeclaration__Group_3_1__3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5531:1: rule__VariableDeclaration__Group_3_1__3 : rule__VariableDeclaration__Group_3_1__3__Impl ;
    public final void rule__VariableDeclaration__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5535:1: ( rule__VariableDeclaration__Group_3_1__3__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5536:2: rule__VariableDeclaration__Group_3_1__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableDeclaration__Group_3_1__3__Impl_in_rule__VariableDeclaration__Group_3_1__311225);
            rule__VariableDeclaration__Group_3_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDeclaration__Group_3_1__3"


    // $ANTLR start "rule__VariableDeclaration__Group_3_1__3__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5542:1: rule__VariableDeclaration__Group_3_1__3__Impl : ( ')' ) ;
    public final void rule__VariableDeclaration__Group_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5546:1: ( ( ')' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5547:1: ( ')' )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5547:1: ( ')' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5548:1: ')'
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
    // $ANTLR end "rule__VariableDeclaration__Group_3_1__3__Impl"


    // $ANTLR start "rule__DataTypeName__Group__0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5569:1: rule__DataTypeName__Group__0 : rule__DataTypeName__Group__0__Impl rule__DataTypeName__Group__1 ;
    public final void rule__DataTypeName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5573:1: ( rule__DataTypeName__Group__0__Impl rule__DataTypeName__Group__1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5574:2: rule__DataTypeName__Group__0__Impl rule__DataTypeName__Group__1
            {
            pushFollow(FOLLOW_rule__DataTypeName__Group__0__Impl_in_rule__DataTypeName__Group__011292);
            rule__DataTypeName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DataTypeName__Group__1_in_rule__DataTypeName__Group__011295);
            rule__DataTypeName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeName__Group__0"


    // $ANTLR start "rule__DataTypeName__Group__0__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5581:1: rule__DataTypeName__Group__0__Impl : ( ( rule__DataTypeName__PathAssignment_0 )? ) ;
    public final void rule__DataTypeName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5585:1: ( ( ( rule__DataTypeName__PathAssignment_0 )? ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5586:1: ( ( rule__DataTypeName__PathAssignment_0 )? )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5586:1: ( ( rule__DataTypeName__PathAssignment_0 )? )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5587:1: ( rule__DataTypeName__PathAssignment_0 )?
            {
             before(grammarAccess.getDataTypeNameAccess().getPathAssignment_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5588:1: ( rule__DataTypeName__PathAssignment_0 )?
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
                    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5588:2: rule__DataTypeName__PathAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DataTypeName__PathAssignment_0_in_rule__DataTypeName__Group__0__Impl11322);
                    rule__DataTypeName__PathAssignment_0();

                    state._fsp--;


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
    // $ANTLR end "rule__DataTypeName__Group__0__Impl"


    // $ANTLR start "rule__DataTypeName__Group__1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5598:1: rule__DataTypeName__Group__1 : rule__DataTypeName__Group__1__Impl ;
    public final void rule__DataTypeName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5602:1: ( rule__DataTypeName__Group__1__Impl )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5603:2: rule__DataTypeName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DataTypeName__Group__1__Impl_in_rule__DataTypeName__Group__111353);
            rule__DataTypeName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataTypeName__Group__1"


    // $ANTLR start "rule__DataTypeName__Group__1__Impl"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5609:1: rule__DataTypeName__Group__1__Impl : ( ( rule__DataTypeName__TypeAssignment_1 ) ) ;
    public final void rule__DataTypeName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5613:1: ( ( ( rule__DataTypeName__TypeAssignment_1 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5614:1: ( ( rule__DataTypeName__TypeAssignment_1 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5614:1: ( ( rule__DataTypeName__TypeAssignment_1 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5615:1: ( rule__DataTypeName__TypeAssignment_1 )
            {
             before(grammarAccess.getDataTypeNameAccess().getTypeAssignment_1()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5616:1: ( rule__DataTypeName__TypeAssignment_1 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5616:2: rule__DataTypeName__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__DataTypeName__TypeAssignment_1_in_rule__DataTypeName__Group__1__Impl11380);
            rule__DataTypeName__TypeAssignment_1();

            state._fsp--;


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
    // $ANTLR end "rule__DataTypeName__Group__1__Impl"


    // $ANTLR start "rule__Expression__ExpAssignment"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5631:1: rule__Expression__ExpAssignment : ( ruleAndOrXorExpression ) ;
    public final void rule__Expression__ExpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5635:1: ( ( ruleAndOrXorExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5636:1: ( ruleAndOrXorExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5636:1: ( ruleAndOrXorExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5637:1: ruleAndOrXorExpression
            {
             before(grammarAccess.getExpressionAccess().getExpAndOrXorExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAndOrXorExpression_in_rule__Expression__ExpAssignment11419);
            ruleAndOrXorExpression();

            state._fsp--;

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
    // $ANTLR end "rule__Expression__ExpAssignment"


    // $ANTLR start "rule__AndOrXorExpression__ExpAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5646:1: rule__AndOrXorExpression__ExpAssignment_0 : ( ruleEqualityExpression ) ;
    public final void rule__AndOrXorExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5650:1: ( ( ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5651:1: ( ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5651:1: ( ruleEqualityExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5652:1: ruleEqualityExpression
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_011450);
            ruleEqualityExpression();

            state._fsp--;

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
    // $ANTLR end "rule__AndOrXorExpression__ExpAssignment_0"


    // $ANTLR start "rule__AndOrXorExpression__OpAssignment_1_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5661:1: rule__AndOrXorExpression__OpAssignment_1_0 : ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__AndOrXorExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5665:1: ( ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5666:1: ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5666:1: ( ( rule__AndOrXorExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5667:1: ( rule__AndOrXorExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5668:1: ( rule__AndOrXorExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5668:2: rule__AndOrXorExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__AndOrXorExpression__OpAlternatives_1_0_0_in_rule__AndOrXorExpression__OpAssignment_1_011481);
            rule__AndOrXorExpression__OpAlternatives_1_0_0();

            state._fsp--;


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
    // $ANTLR end "rule__AndOrXorExpression__OpAssignment_1_0"


    // $ANTLR start "rule__AndOrXorExpression__ExpAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5677:1: rule__AndOrXorExpression__ExpAssignment_1_1 : ( ruleEqualityExpression ) ;
    public final void rule__AndOrXorExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5681:1: ( ( ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5682:1: ( ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5682:1: ( ruleEqualityExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5683:1: ruleEqualityExpression
            {
             before(grammarAccess.getAndOrXorExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_rule__AndOrXorExpression__ExpAssignment_1_111514);
            ruleEqualityExpression();

            state._fsp--;

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
    // $ANTLR end "rule__AndOrXorExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__EqualityExpression__ExpAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5692:1: rule__EqualityExpression__ExpAssignment_0 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5696:1: ( ( ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5697:1: ( ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5697:1: ( ruleRelationalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5698:1: ruleRelationalExpression
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_011545);
            ruleRelationalExpression();

            state._fsp--;

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
    // $ANTLR end "rule__EqualityExpression__ExpAssignment_0"


    // $ANTLR start "rule__EqualityExpression__OpAssignment_1_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5707:1: rule__EqualityExpression__OpAssignment_1_0 : ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__EqualityExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5711:1: ( ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5712:1: ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5712:1: ( ( rule__EqualityExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5713:1: ( rule__EqualityExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getEqualityExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5714:1: ( rule__EqualityExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5714:2: rule__EqualityExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__EqualityExpression__OpAlternatives_1_0_0_in_rule__EqualityExpression__OpAssignment_1_011576);
            rule__EqualityExpression__OpAlternatives_1_0_0();

            state._fsp--;


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
    // $ANTLR end "rule__EqualityExpression__OpAssignment_1_0"


    // $ANTLR start "rule__EqualityExpression__ExpAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5723:1: rule__EqualityExpression__ExpAssignment_1_1 : ( ruleRelationalExpression ) ;
    public final void rule__EqualityExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5727:1: ( ( ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5728:1: ( ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5728:1: ( ruleRelationalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5729:1: ruleRelationalExpression
            {
             before(grammarAccess.getEqualityExpressionAccess().getExpRelationalExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_rule__EqualityExpression__ExpAssignment_1_111609);
            ruleRelationalExpression();

            state._fsp--;

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
    // $ANTLR end "rule__EqualityExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__RelationalExpression__ExpAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5738:1: rule__RelationalExpression__ExpAssignment_0 : ( ruleConditionalExpression ) ;
    public final void rule__RelationalExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5742:1: ( ( ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5743:1: ( ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5743:1: ( ruleConditionalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5744:1: ruleConditionalExpression
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_011640);
            ruleConditionalExpression();

            state._fsp--;

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
    // $ANTLR end "rule__RelationalExpression__ExpAssignment_0"


    // $ANTLR start "rule__RelationalExpression__OpAssignment_1_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5753:1: rule__RelationalExpression__OpAssignment_1_0 : ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__RelationalExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5757:1: ( ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5758:1: ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5758:1: ( ( rule__RelationalExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5759:1: ( rule__RelationalExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getRelationalExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5760:1: ( rule__RelationalExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5760:2: rule__RelationalExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__RelationalExpression__OpAlternatives_1_0_0_in_rule__RelationalExpression__OpAssignment_1_011671);
            rule__RelationalExpression__OpAlternatives_1_0_0();

            state._fsp--;


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
    // $ANTLR end "rule__RelationalExpression__OpAssignment_1_0"


    // $ANTLR start "rule__RelationalExpression__ExpAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5769:1: rule__RelationalExpression__ExpAssignment_1_1 : ( ruleConditionalExpression ) ;
    public final void rule__RelationalExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5773:1: ( ( ruleConditionalExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5774:1: ( ruleConditionalExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5774:1: ( ruleConditionalExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5775:1: ruleConditionalExpression
            {
             before(grammarAccess.getRelationalExpressionAccess().getExpConditionalExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleConditionalExpression_in_rule__RelationalExpression__ExpAssignment_1_111704);
            ruleConditionalExpression();

            state._fsp--;

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
    // $ANTLR end "rule__RelationalExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__ConditionalExpression__ExpAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5784:1: rule__ConditionalExpression__ExpAssignment_0 : ( ruleAdditiveExpression ) ;
    public final void rule__ConditionalExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5788:1: ( ( ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5789:1: ( ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5789:1: ( ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5790:1: ruleAdditiveExpression
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_011735);
            ruleAdditiveExpression();

            state._fsp--;

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
    // $ANTLR end "rule__ConditionalExpression__ExpAssignment_0"


    // $ANTLR start "rule__ConditionalExpression__OpAssignment_1_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5799:1: rule__ConditionalExpression__OpAssignment_1_0 : ( ( '?' ) ) ;
    public final void rule__ConditionalExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5803:1: ( ( ( '?' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5804:1: ( ( '?' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5804:1: ( ( '?' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5805:1: ( '?' )
            {
             before(grammarAccess.getConditionalExpressionAccess().getOpQuestionMarkKeyword_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5806:1: ( '?' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5807:1: '?'
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
    // $ANTLR end "rule__ConditionalExpression__OpAssignment_1_0"


    // $ANTLR start "rule__ConditionalExpression__ExpAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5822:1: rule__ConditionalExpression__ExpAssignment_1_1 : ( ruleAdditiveExpression ) ;
    public final void rule__ConditionalExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5826:1: ( ( ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5827:1: ( ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5827:1: ( ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5828:1: ruleAdditiveExpression
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_111810);
            ruleAdditiveExpression();

            state._fsp--;

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
    // $ANTLR end "rule__ConditionalExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__ConditionalExpression__ExpAssignment_1_3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5837:1: rule__ConditionalExpression__ExpAssignment_1_3 : ( ruleAdditiveExpression ) ;
    public final void rule__ConditionalExpression__ExpAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5841:1: ( ( ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5842:1: ( ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5842:1: ( ruleAdditiveExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5843:1: ruleAdditiveExpression
            {
             before(grammarAccess.getConditionalExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_rule__ConditionalExpression__ExpAssignment_1_311841);
            ruleAdditiveExpression();

            state._fsp--;

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
    // $ANTLR end "rule__ConditionalExpression__ExpAssignment_1_3"


    // $ANTLR start "rule__AdditiveExpression__ExpAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5852:1: rule__AdditiveExpression__ExpAssignment_0 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5856:1: ( ( ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5857:1: ( ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5857:1: ( ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5858:1: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_011872);
            ruleMultiplicativeExpression();

            state._fsp--;

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
    // $ANTLR end "rule__AdditiveExpression__ExpAssignment_0"


    // $ANTLR start "rule__AdditiveExpression__OpAssignment_1_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5867:1: rule__AdditiveExpression__OpAssignment_1_0 : ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__AdditiveExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5871:1: ( ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5872:1: ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5872:1: ( ( rule__AdditiveExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5873:1: ( rule__AdditiveExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getAdditiveExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5874:1: ( rule__AdditiveExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5874:2: rule__AdditiveExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__AdditiveExpression__OpAlternatives_1_0_0_in_rule__AdditiveExpression__OpAssignment_1_011903);
            rule__AdditiveExpression__OpAlternatives_1_0_0();

            state._fsp--;


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
    // $ANTLR end "rule__AdditiveExpression__OpAssignment_1_0"


    // $ANTLR start "rule__AdditiveExpression__ExpAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5883:1: rule__AdditiveExpression__ExpAssignment_1_1 : ( ruleMultiplicativeExpression ) ;
    public final void rule__AdditiveExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5887:1: ( ( ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5888:1: ( ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5888:1: ( ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5889:1: ruleMultiplicativeExpression
            {
             before(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_rule__AdditiveExpression__ExpAssignment_1_111936);
            ruleMultiplicativeExpression();

            state._fsp--;

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
    // $ANTLR end "rule__AdditiveExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__MultiplicativeExpression__ExpAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5898:1: rule__MultiplicativeExpression__ExpAssignment_0 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpression__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5902:1: ( ( ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5903:1: ( ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5903:1: ( ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5904:1: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_011967);
            ruleUnaryExpression();

            state._fsp--;

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
    // $ANTLR end "rule__MultiplicativeExpression__ExpAssignment_0"


    // $ANTLR start "rule__MultiplicativeExpression__OpAssignment_1_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5913:1: rule__MultiplicativeExpression__OpAssignment_1_0 : ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) ) ;
    public final void rule__MultiplicativeExpression__OpAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5917:1: ( ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5918:1: ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5918:1: ( ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5919:1: ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 )
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getOpAlternatives_1_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5920:1: ( rule__MultiplicativeExpression__OpAlternatives_1_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5920:2: rule__MultiplicativeExpression__OpAlternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpression__OpAlternatives_1_0_0_in_rule__MultiplicativeExpression__OpAssignment_1_011998);
            rule__MultiplicativeExpression__OpAlternatives_1_0_0();

            state._fsp--;


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
    // $ANTLR end "rule__MultiplicativeExpression__OpAssignment_1_0"


    // $ANTLR start "rule__MultiplicativeExpression__ExpAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5929:1: rule__MultiplicativeExpression__ExpAssignment_1_1 : ( ruleUnaryExpression ) ;
    public final void rule__MultiplicativeExpression__ExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5933:1: ( ( ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5934:1: ( ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5934:1: ( ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5935:1: ruleUnaryExpression
            {
             before(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__MultiplicativeExpression__ExpAssignment_1_112031);
            ruleUnaryExpression();

            state._fsp--;

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
    // $ANTLR end "rule__MultiplicativeExpression__ExpAssignment_1_1"


    // $ANTLR start "rule__UnaryExpression__OpAssignment_0_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5944:1: rule__UnaryExpression__OpAssignment_0_0 : ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) ) ;
    public final void rule__UnaryExpression__OpAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5948:1: ( ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5949:1: ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5949:1: ( ( rule__UnaryExpression__OpAlternatives_0_0_0 ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5950:1: ( rule__UnaryExpression__OpAlternatives_0_0_0 )
            {
             before(grammarAccess.getUnaryExpressionAccess().getOpAlternatives_0_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5951:1: ( rule__UnaryExpression__OpAlternatives_0_0_0 )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5951:2: rule__UnaryExpression__OpAlternatives_0_0_0
            {
            pushFollow(FOLLOW_rule__UnaryExpression__OpAlternatives_0_0_0_in_rule__UnaryExpression__OpAssignment_0_012062);
            rule__UnaryExpression__OpAlternatives_0_0_0();

            state._fsp--;


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
    // $ANTLR end "rule__UnaryExpression__OpAssignment_0_0"


    // $ANTLR start "rule__UnaryExpression__UnaryAssignment_0_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5960:1: rule__UnaryExpression__UnaryAssignment_0_1 : ( ruleUnaryExpression ) ;
    public final void rule__UnaryExpression__UnaryAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5964:1: ( ( ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5965:1: ( ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5965:1: ( ruleUnaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5966:1: ruleUnaryExpression
            {
             before(grammarAccess.getUnaryExpressionAccess().getUnaryUnaryExpressionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_rule__UnaryExpression__UnaryAssignment_0_112095);
            ruleUnaryExpression();

            state._fsp--;

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
    // $ANTLR end "rule__UnaryExpression__UnaryAssignment_0_1"


    // $ANTLR start "rule__UnaryExpression__ExpAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5975:1: rule__UnaryExpression__ExpAssignment_1 : ( rulePrimaryExpression ) ;
    public final void rule__UnaryExpression__ExpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5979:1: ( ( rulePrimaryExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5980:1: ( rulePrimaryExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5980:1: ( rulePrimaryExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5981:1: rulePrimaryExpression
            {
             before(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__UnaryExpression__ExpAssignment_112126);
            rulePrimaryExpression();

            state._fsp--;

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
    // $ANTLR end "rule__UnaryExpression__ExpAssignment_1"


    // $ANTLR start "rule__PrimaryExpression__PrefixAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5990:1: rule__PrimaryExpression__PrefixAssignment_0 : ( ruleValueSpecification ) ;
    public final void rule__PrimaryExpression__PrefixAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5994:1: ( ( ruleValueSpecification ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5995:1: ( ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5995:1: ( ruleValueSpecification )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:5996:1: ruleValueSpecification
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_rule__PrimaryExpression__PrefixAssignment_012157);
            ruleValueSpecification();

            state._fsp--;

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
    // $ANTLR end "rule__PrimaryExpression__PrefixAssignment_0"


    // $ANTLR start "rule__PrimaryExpression__SuffixAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6005:1: rule__PrimaryExpression__SuffixAssignment_1_1 : ( ruleSuffixExpression ) ;
    public final void rule__PrimaryExpression__SuffixAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6009:1: ( ( ruleSuffixExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6010:1: ( ruleSuffixExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6010:1: ( ruleSuffixExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6011:1: ruleSuffixExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_rule__PrimaryExpression__SuffixAssignment_1_112188);
            ruleSuffixExpression();

            state._fsp--;

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
    // $ANTLR end "rule__PrimaryExpression__SuffixAssignment_1_1"


    // $ANTLR start "rule__PropertyCallExpression__PropertyAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6020:1: rule__PropertyCallExpression__PropertyAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__PropertyCallExpression__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6024:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6025:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6025:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6026:1: ( RULE_ID )
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getPropertyPropertyCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6027:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6028:1: RULE_ID
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
    // $ANTLR end "rule__PropertyCallExpression__PropertyAssignment_0"


    // $ANTLR start "rule__PropertyCallExpression__SuffixAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6039:1: rule__PropertyCallExpression__SuffixAssignment_1_1 : ( ruleSuffixExpression ) ;
    public final void rule__PropertyCallExpression__SuffixAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6043:1: ( ( ruleSuffixExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6044:1: ( ruleSuffixExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6044:1: ( ruleSuffixExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6045:1: ruleSuffixExpression
            {
             before(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_rule__PropertyCallExpression__SuffixAssignment_1_112258);
            ruleSuffixExpression();

            state._fsp--;

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
    // $ANTLR end "rule__PropertyCallExpression__SuffixAssignment_1_1"


    // $ANTLR start "rule__OperationCallExpression__OperationAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6054:1: rule__OperationCallExpression__OperationAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__OperationCallExpression__OperationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6058:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6059:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6059:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6060:1: ( RULE_ID )
            {
             before(grammarAccess.getOperationCallExpressionAccess().getOperationOperationCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6061:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6062:1: RULE_ID
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
    // $ANTLR end "rule__OperationCallExpression__OperationAssignment_0"


    // $ANTLR start "rule__OperationCallExpression__ArgumentsAssignment_2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6073:1: rule__OperationCallExpression__ArgumentsAssignment_2 : ( ruleListOfValues ) ;
    public final void rule__OperationCallExpression__ArgumentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6077:1: ( ( ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6078:1: ( ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6078:1: ( ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6079:1: ruleListOfValues
            {
             before(grammarAccess.getOperationCallExpressionAccess().getArgumentsListOfValuesParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleListOfValues_in_rule__OperationCallExpression__ArgumentsAssignment_212328);
            ruleListOfValues();

            state._fsp--;

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
    // $ANTLR end "rule__OperationCallExpression__ArgumentsAssignment_2"


    // $ANTLR start "rule__OperationCallExpression__SuffixAssignment_4_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6088:1: rule__OperationCallExpression__SuffixAssignment_4_1 : ( ruleSuffixExpression ) ;
    public final void rule__OperationCallExpression__SuffixAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6092:1: ( ( ruleSuffixExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6093:1: ( ruleSuffixExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6093:1: ( ruleSuffixExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6094:1: ruleSuffixExpression
            {
             before(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_rule__OperationCallExpression__SuffixAssignment_4_112359);
            ruleSuffixExpression();

            state._fsp--;

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
    // $ANTLR end "rule__OperationCallExpression__SuffixAssignment_4_1"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__PathAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6103:1: rule__NameOrChoiceOrBehaviorCall__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6107:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6108:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6108:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6109:1: ruleQualifiedName
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__NameOrChoiceOrBehaviorCall__PathAssignment_012390);
            ruleQualifiedName();

            state._fsp--;

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
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__PathAssignment_0"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__IdAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6118:1: rule__NameOrChoiceOrBehaviorCall__IdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6122:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6123:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6123:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6124:1: ( RULE_ID )
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getIdNamedElementCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6125:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6126:1: RULE_ID
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
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__IdAssignment_1"


    // $ANTLR start "rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6137:1: rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1 : ( ruleListOfValues ) ;
    public final void rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6141:1: ( ( ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6142:1: ( ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6142:1: ( ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6143:1: ruleListOfValues
            {
             before(grammarAccess.getNameOrChoiceOrBehaviorCallAccess().getArgumentsListOfValuesParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleListOfValues_in_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_112460);
            ruleListOfValues();

            state._fsp--;

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
    // $ANTLR end "rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1"


    // $ANTLR start "rule__QualifiedName__PathAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6152:1: rule__QualifiedName__PathAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__QualifiedName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6156:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6157:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6157:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6158:1: ( RULE_ID )
            {
             before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6159:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6160:1: RULE_ID
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
    // $ANTLR end "rule__QualifiedName__PathAssignment_0"


    // $ANTLR start "rule__QualifiedName__RemainingAssignment_2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6171:1: rule__QualifiedName__RemainingAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__QualifiedName__RemainingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6175:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6176:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6176:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6177:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedName__RemainingAssignment_212530);
            ruleQualifiedName();

            state._fsp--;

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
    // $ANTLR end "rule__QualifiedName__RemainingAssignment_2"


    // $ANTLR start "rule__Interval__IsLowerIncludedAssignment_0_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6186:1: rule__Interval__IsLowerIncludedAssignment_0_1 : ( ( '[' ) ) ;
    public final void rule__Interval__IsLowerIncludedAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6190:1: ( ( ( '[' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6191:1: ( ( '[' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6191:1: ( ( '[' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6192:1: ( '[' )
            {
             before(grammarAccess.getIntervalAccess().getIsLowerIncludedLeftSquareBracketKeyword_0_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6193:1: ( '[' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6194:1: '['
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
    // $ANTLR end "rule__Interval__IsLowerIncludedAssignment_0_1"


    // $ANTLR start "rule__Interval__LowerAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6209:1: rule__Interval__LowerAssignment_1 : ( ruleExpression ) ;
    public final void rule__Interval__LowerAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6213:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6214:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6214:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6215:1: ruleExpression
            {
             before(grammarAccess.getIntervalAccess().getLowerExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Interval__LowerAssignment_112605);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__Interval__LowerAssignment_1"


    // $ANTLR start "rule__Interval__UpperAssignment_3"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6224:1: rule__Interval__UpperAssignment_3 : ( ruleExpression ) ;
    public final void rule__Interval__UpperAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6228:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6229:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6229:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6230:1: ruleExpression
            {
             before(grammarAccess.getIntervalAccess().getUpperExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Interval__UpperAssignment_312636);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__Interval__UpperAssignment_3"


    // $ANTLR start "rule__Interval__IsUpperIncludedAssignment_4_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6239:1: rule__Interval__IsUpperIncludedAssignment_4_0 : ( ( ']' ) ) ;
    public final void rule__Interval__IsUpperIncludedAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6243:1: ( ( ( ']' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6244:1: ( ( ']' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6244:1: ( ( ']' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6245:1: ( ']' )
            {
             before(grammarAccess.getIntervalAccess().getIsUpperIncludedRightSquareBracketKeyword_4_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6246:1: ( ']' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6247:1: ']'
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
    // $ANTLR end "rule__Interval__IsUpperIncludedAssignment_4_0"


    // $ANTLR start "rule__CollectionOrTuple__ListOfValuesAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6262:1: rule__CollectionOrTuple__ListOfValuesAssignment_1 : ( ruleListOfValues ) ;
    public final void rule__CollectionOrTuple__ListOfValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6266:1: ( ( ruleListOfValues ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6267:1: ( ruleListOfValues )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6267:1: ( ruleListOfValues )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6268:1: ruleListOfValues
            {
             before(grammarAccess.getCollectionOrTupleAccess().getListOfValuesListOfValuesParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleListOfValues_in_rule__CollectionOrTuple__ListOfValuesAssignment_112711);
            ruleListOfValues();

            state._fsp--;

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
    // $ANTLR end "rule__CollectionOrTuple__ListOfValuesAssignment_1"


    // $ANTLR start "rule__Tuple__ListOfValueNamePairsAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6277:1: rule__Tuple__ListOfValueNamePairsAssignment_1 : ( ruleListOfValueNamePairs ) ;
    public final void rule__Tuple__ListOfValueNamePairsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6281:1: ( ( ruleListOfValueNamePairs ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6282:1: ( ruleListOfValueNamePairs )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6282:1: ( ruleListOfValueNamePairs )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6283:1: ruleListOfValueNamePairs
            {
             before(grammarAccess.getTupleAccess().getListOfValueNamePairsListOfValueNamePairsParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleListOfValueNamePairs_in_rule__Tuple__ListOfValueNamePairsAssignment_112742);
            ruleListOfValueNamePairs();

            state._fsp--;

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
    // $ANTLR end "rule__Tuple__ListOfValueNamePairsAssignment_1"


    // $ANTLR start "rule__ListOfValues__ValuesAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6292:1: rule__ListOfValues__ValuesAssignment_0 : ( ruleExpression ) ;
    public final void rule__ListOfValues__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6296:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6297:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6297:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6298:1: ruleExpression
            {
             before(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_012773);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__ListOfValues__ValuesAssignment_0"


    // $ANTLR start "rule__ListOfValues__ValuesAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6307:1: rule__ListOfValues__ValuesAssignment_1_1 : ( ruleExpression ) ;
    public final void rule__ListOfValues__ValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6311:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6312:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6312:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6313:1: ruleExpression
            {
             before(grammarAccess.getListOfValuesAccess().getValuesExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ListOfValues__ValuesAssignment_1_112804);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__ListOfValues__ValuesAssignment_1_1"


    // $ANTLR start "rule__ListOfValueNamePairs__ValueNamePairsAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6322:1: rule__ListOfValueNamePairs__ValueNamePairsAssignment_0 : ( ruleValueNamePair ) ;
    public final void rule__ListOfValueNamePairs__ValueNamePairsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6326:1: ( ( ruleValueNamePair ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6327:1: ( ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6327:1: ( ruleValueNamePair )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6328:1: ruleValueNamePair
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_012835);
            ruleValueNamePair();

            state._fsp--;

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
    // $ANTLR end "rule__ListOfValueNamePairs__ValueNamePairsAssignment_0"


    // $ANTLR start "rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6337:1: rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1 : ( ruleValueNamePair ) ;
    public final void rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6341:1: ( ( ruleValueNamePair ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6342:1: ( ruleValueNamePair )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6342:1: ( ruleValueNamePair )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6343:1: ruleValueNamePair
            {
             before(grammarAccess.getListOfValueNamePairsAccess().getValueNamePairsValueNamePairParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleValueNamePair_in_rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_112866);
            ruleValueNamePair();

            state._fsp--;

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
    // $ANTLR end "rule__ListOfValueNamePairs__ValueNamePairsAssignment_1_1"


    // $ANTLR start "rule__ValueNamePair__PropertyAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6352:1: rule__ValueNamePair__PropertyAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ValueNamePair__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6356:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6357:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6357:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6358:1: ( RULE_ID )
            {
             before(grammarAccess.getValueNamePairAccess().getPropertyPropertyCrossReference_0_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6359:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6360:1: RULE_ID
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
    // $ANTLR end "rule__ValueNamePair__PropertyAssignment_0"


    // $ANTLR start "rule__ValueNamePair__ValueAssignment_2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6371:1: rule__ValueNamePair__ValueAssignment_2 : ( ruleExpression ) ;
    public final void rule__ValueNamePair__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6375:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6376:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6376:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6377:1: ruleExpression
            {
             before(grammarAccess.getValueNamePairAccess().getValueExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ValueNamePair__ValueAssignment_212936);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__ValueNamePair__ValueAssignment_2"


    // $ANTLR start "rule__InstantObsExpression__IdAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6386:1: rule__InstantObsExpression__IdAssignment_1 : ( ruleInstantObsName ) ;
    public final void rule__InstantObsExpression__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6390:1: ( ( ruleInstantObsName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6391:1: ( ruleInstantObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6391:1: ( ruleInstantObsName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6392:1: ruleInstantObsName
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIdInstantObsNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInstantObsName_in_rule__InstantObsExpression__IdAssignment_112967);
            ruleInstantObsName();

            state._fsp--;

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
    // $ANTLR end "rule__InstantObsExpression__IdAssignment_1"


    // $ANTLR start "rule__InstantObsExpression__IndexAssignment_2_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6401:1: rule__InstantObsExpression__IndexAssignment_2_1 : ( ruleExpression ) ;
    public final void rule__InstantObsExpression__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6405:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6406:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6406:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6407:1: ruleExpression
            {
             before(grammarAccess.getInstantObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__InstantObsExpression__IndexAssignment_2_112998);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__InstantObsExpression__IndexAssignment_2_1"


    // $ANTLR start "rule__InstantObsExpression__ConditionAssignment_3_2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6416:1: rule__InstantObsExpression__ConditionAssignment_3_2 : ( ruleExpression ) ;
    public final void rule__InstantObsExpression__ConditionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6420:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6421:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6421:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6422:1: ruleExpression
            {
             before(grammarAccess.getInstantObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__InstantObsExpression__ConditionAssignment_3_213029);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__InstantObsExpression__ConditionAssignment_3_2"


    // $ANTLR start "rule__InstantObsName__PathAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6431:1: rule__InstantObsName__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__InstantObsName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6435:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6436:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6436:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6437:1: ruleQualifiedName
            {
             before(grammarAccess.getInstantObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__InstantObsName__PathAssignment_013060);
            ruleQualifiedName();

            state._fsp--;

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
    // $ANTLR end "rule__InstantObsName__PathAssignment_0"


    // $ANTLR start "rule__InstantObsName__InstantIdAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6446:1: rule__InstantObsName__InstantIdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__InstantObsName__InstantIdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6450:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6451:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6451:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6452:1: ( RULE_ID )
            {
             before(grammarAccess.getInstantObsNameAccess().getInstantIdTimeObservationCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6453:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6454:1: RULE_ID
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
    // $ANTLR end "rule__InstantObsName__InstantIdAssignment_1"


    // $ANTLR start "rule__DurationObsExpression__IdAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6465:1: rule__DurationObsExpression__IdAssignment_1 : ( ruleDurationObsName ) ;
    public final void rule__DurationObsExpression__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6469:1: ( ( ruleDurationObsName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6470:1: ( ruleDurationObsName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6470:1: ( ruleDurationObsName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6471:1: ruleDurationObsName
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIdDurationObsNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDurationObsName_in_rule__DurationObsExpression__IdAssignment_113130);
            ruleDurationObsName();

            state._fsp--;

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
    // $ANTLR end "rule__DurationObsExpression__IdAssignment_1"


    // $ANTLR start "rule__DurationObsExpression__IndexAssignment_2_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6480:1: rule__DurationObsExpression__IndexAssignment_2_1 : ( ruleExpression ) ;
    public final void rule__DurationObsExpression__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6484:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6485:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6485:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6486:1: ruleExpression
            {
             before(grammarAccess.getDurationObsExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__DurationObsExpression__IndexAssignment_2_113161);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__DurationObsExpression__IndexAssignment_2_1"


    // $ANTLR start "rule__DurationObsExpression__ConditionAssignment_3_2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6495:1: rule__DurationObsExpression__ConditionAssignment_3_2 : ( ruleExpression ) ;
    public final void rule__DurationObsExpression__ConditionAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6499:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6500:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6500:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6501:1: ruleExpression
            {
             before(grammarAccess.getDurationObsExpressionAccess().getConditionExpressionParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__DurationObsExpression__ConditionAssignment_3_213192);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__DurationObsExpression__ConditionAssignment_3_2"


    // $ANTLR start "rule__DurationObsName__PathAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6510:1: rule__DurationObsName__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__DurationObsName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6514:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6515:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6515:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6516:1: ruleQualifiedName
            {
             before(grammarAccess.getDurationObsNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__DurationObsName__PathAssignment_013223);
            ruleQualifiedName();

            state._fsp--;

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
    // $ANTLR end "rule__DurationObsName__PathAssignment_0"


    // $ANTLR start "rule__DurationObsName__DurationIdAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6525:1: rule__DurationObsName__DurationIdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DurationObsName__DurationIdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6529:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6530:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6530:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6531:1: ( RULE_ID )
            {
             before(grammarAccess.getDurationObsNameAccess().getDurationIdDurationObservationCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6532:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6533:1: RULE_ID
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
    // $ANTLR end "rule__DurationObsName__DurationIdAssignment_1"


    // $ANTLR start "rule__JitterExp__FirstInstantAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6544:1: rule__JitterExp__FirstInstantAssignment_1 : ( ruleInstantObsExpression ) ;
    public final void rule__JitterExp__FirstInstantAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6548:1: ( ( ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6549:1: ( ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6549:1: ( ruleInstantObsExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6550:1: ruleInstantObsExpression
            {
             before(grammarAccess.getJitterExpAccess().getFirstInstantInstantObsExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__FirstInstantAssignment_113293);
            ruleInstantObsExpression();

            state._fsp--;

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
    // $ANTLR end "rule__JitterExp__FirstInstantAssignment_1"


    // $ANTLR start "rule__JitterExp__SecondInstantAssignment_2_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6559:1: rule__JitterExp__SecondInstantAssignment_2_1 : ( ruleInstantObsExpression ) ;
    public final void rule__JitterExp__SecondInstantAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6563:1: ( ( ruleInstantObsExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6564:1: ( ruleInstantObsExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6564:1: ( ruleInstantObsExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6565:1: ruleInstantObsExpression
            {
             before(grammarAccess.getJitterExpAccess().getSecondInstantInstantObsExpressionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleInstantObsExpression_in_rule__JitterExp__SecondInstantAssignment_2_113324);
            ruleInstantObsExpression();

            state._fsp--;

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
    // $ANTLR end "rule__JitterExp__SecondInstantAssignment_2_1"


    // $ANTLR start "rule__VariableDeclaration__VariableDeclarationAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6574:1: rule__VariableDeclaration__VariableDeclarationAssignment_0 : ( ruleVariableDirectionKind ) ;
    public final void rule__VariableDeclaration__VariableDeclarationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6578:1: ( ( ruleVariableDirectionKind ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6579:1: ( ruleVariableDirectionKind )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6579:1: ( ruleVariableDirectionKind )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6580:1: ruleVariableDirectionKind
            {
             before(grammarAccess.getVariableDeclarationAccess().getVariableDeclarationVariableDirectionKindParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleVariableDirectionKind_in_rule__VariableDeclaration__VariableDeclarationAssignment_013355);
            ruleVariableDirectionKind();

            state._fsp--;

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
    // $ANTLR end "rule__VariableDeclaration__VariableDeclarationAssignment_0"


    // $ANTLR start "rule__VariableDeclaration__NameAssignment_2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6589:1: rule__VariableDeclaration__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__VariableDeclaration__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6593:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6594:1: ( RULE_ID )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6594:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6595:1: RULE_ID
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
    // $ANTLR end "rule__VariableDeclaration__NameAssignment_2"


    // $ANTLR start "rule__VariableDeclaration__TypeAssignment_3_0_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6604:1: rule__VariableDeclaration__TypeAssignment_3_0_1 : ( ruleDataTypeName ) ;
    public final void rule__VariableDeclaration__TypeAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6608:1: ( ( ruleDataTypeName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6609:1: ( ruleDataTypeName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6609:1: ( ruleDataTypeName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6610:1: ruleDataTypeName
            {
             before(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeNameParserRuleCall_3_0_1_0()); 
            pushFollow(FOLLOW_ruleDataTypeName_in_rule__VariableDeclaration__TypeAssignment_3_0_113417);
            ruleDataTypeName();

            state._fsp--;

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
    // $ANTLR end "rule__VariableDeclaration__TypeAssignment_3_0_1"


    // $ANTLR start "rule__VariableDeclaration__InitValueAssignment_3_0_2_2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6619:1: rule__VariableDeclaration__InitValueAssignment_3_0_2_2 : ( ruleExpression ) ;
    public final void rule__VariableDeclaration__InitValueAssignment_3_0_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6623:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6624:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6624:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6625:1: ruleExpression
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_0_2_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_0_2_213448);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__VariableDeclaration__InitValueAssignment_3_0_2_2"


    // $ANTLR start "rule__VariableDeclaration__InitValueAssignment_3_1_2"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6634:1: rule__VariableDeclaration__InitValueAssignment_3_1_2 : ( ruleExpression ) ;
    public final void rule__VariableDeclaration__InitValueAssignment_3_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6638:1: ( ( ruleExpression ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6639:1: ( ruleExpression )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6639:1: ( ruleExpression )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6640:1: ruleExpression
            {
             before(grammarAccess.getVariableDeclarationAccess().getInitValueExpressionParserRuleCall_3_1_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__VariableDeclaration__InitValueAssignment_3_1_213479);
            ruleExpression();

            state._fsp--;

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
    // $ANTLR end "rule__VariableDeclaration__InitValueAssignment_3_1_2"


    // $ANTLR start "rule__DataTypeName__PathAssignment_0"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6649:1: rule__DataTypeName__PathAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__DataTypeName__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6653:1: ( ( ruleQualifiedName ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6654:1: ( ruleQualifiedName )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6654:1: ( ruleQualifiedName )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6655:1: ruleQualifiedName
            {
             before(grammarAccess.getDataTypeNameAccess().getPathQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__DataTypeName__PathAssignment_013510);
            ruleQualifiedName();

            state._fsp--;

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
    // $ANTLR end "rule__DataTypeName__PathAssignment_0"


    // $ANTLR start "rule__DataTypeName__TypeAssignment_1"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6664:1: rule__DataTypeName__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DataTypeName__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6668:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6669:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6669:1: ( ( RULE_ID ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6670:1: ( RULE_ID )
            {
             before(grammarAccess.getDataTypeNameAccess().getTypeDataTypeCrossReference_1_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6671:1: ( RULE_ID )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6672:1: RULE_ID
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
    // $ANTLR end "rule__DataTypeName__TypeAssignment_1"


    // $ANTLR start "rule__IntegerLiteralRule__ValueAssignment"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6683:1: rule__IntegerLiteralRule__ValueAssignment : ( RULE_INTEGERLITERAL ) ;
    public final void rule__IntegerLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6687:1: ( ( RULE_INTEGERLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6688:1: ( RULE_INTEGERLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6688:1: ( RULE_INTEGERLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6689:1: RULE_INTEGERLITERAL
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
    // $ANTLR end "rule__IntegerLiteralRule__ValueAssignment"


    // $ANTLR start "rule__UnlimitedLiteralRule__ValueAssignment"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6698:1: rule__UnlimitedLiteralRule__ValueAssignment : ( ( '*' ) ) ;
    public final void rule__UnlimitedLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6702:1: ( ( ( '*' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6703:1: ( ( '*' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6703:1: ( ( '*' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6704:1: ( '*' )
            {
             before(grammarAccess.getUnlimitedLiteralRuleAccess().getValueAsteriskKeyword_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6705:1: ( '*' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6706:1: '*'
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
    // $ANTLR end "rule__UnlimitedLiteralRule__ValueAssignment"


    // $ANTLR start "rule__RealLiteralRule__ValueAssignment"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6721:1: rule__RealLiteralRule__ValueAssignment : ( RULE_REALLITERAL ) ;
    public final void rule__RealLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6725:1: ( ( RULE_REALLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6726:1: ( RULE_REALLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6726:1: ( RULE_REALLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6727:1: RULE_REALLITERAL
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
    // $ANTLR end "rule__RealLiteralRule__ValueAssignment"


    // $ANTLR start "rule__DateTimeLiteralRule__ValueAssignment"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6736:1: rule__DateTimeLiteralRule__ValueAssignment : ( RULE_DATETIMELITERAL ) ;
    public final void rule__DateTimeLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6740:1: ( ( RULE_DATETIMELITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6741:1: ( RULE_DATETIMELITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6741:1: ( RULE_DATETIMELITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6742:1: RULE_DATETIMELITERAL
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
    // $ANTLR end "rule__DateTimeLiteralRule__ValueAssignment"


    // $ANTLR start "rule__BooleanLiteralRule__ValueAssignment"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6751:1: rule__BooleanLiteralRule__ValueAssignment : ( RULE_BOOLEANLITERAL ) ;
    public final void rule__BooleanLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6755:1: ( ( RULE_BOOLEANLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6756:1: ( RULE_BOOLEANLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6756:1: ( RULE_BOOLEANLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6757:1: RULE_BOOLEANLITERAL
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
    // $ANTLR end "rule__BooleanLiteralRule__ValueAssignment"


    // $ANTLR start "rule__NullLiteralRule__ValueAssignment"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6766:1: rule__NullLiteralRule__ValueAssignment : ( RULE_NULLLITERAL ) ;
    public final void rule__NullLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6770:1: ( ( RULE_NULLLITERAL ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6771:1: ( RULE_NULLLITERAL )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6771:1: ( RULE_NULLLITERAL )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6772:1: RULE_NULLLITERAL
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
    // $ANTLR end "rule__NullLiteralRule__ValueAssignment"


    // $ANTLR start "rule__DefaultLiteralRule__ValueAssignment"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6781:1: rule__DefaultLiteralRule__ValueAssignment : ( ( '/' ) ) ;
    public final void rule__DefaultLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6785:1: ( ( ( '/' ) ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6786:1: ( ( '/' ) )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6786:1: ( ( '/' ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6787:1: ( '/' )
            {
             before(grammarAccess.getDefaultLiteralRuleAccess().getValueSolidusKeyword_0()); 
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6788:1: ( '/' )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6789:1: '/'
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
    // $ANTLR end "rule__DefaultLiteralRule__ValueAssignment"


    // $ANTLR start "rule__StringLiteralRule__ValueAssignment"
    // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6804:1: rule__StringLiteralRule__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralRule__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6808:1: ( ( RULE_STRING ) )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6809:1: ( RULE_STRING )
            {
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6809:1: ( RULE_STRING )
            // ../org.eclipse.papyrus.marte.vsl.ui/src-gen/org/eclipse/papyrus/marte/vsl/ui/contentassist/antlr/internal/InternalVSL.g:6810:1: RULE_STRING
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
    // $ANTLR end "rule__StringLiteralRule__ValueAssignment"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\13\uffff";
    static final String DFA8_eofS =
        "\13\uffff";
    static final String DFA8_minS =
        "\1\4\3\uffff\1\4\4\uffff\1\20\1\uffff";
    static final String DFA8_maxS =
        "\1\62\3\uffff\1\62\4\uffff\1\63\1\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\1\10\1\4\1\uffff\1\5";
    static final String DFA8_specialS =
        "\13\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\2\6\1\20\uffff\2\1\2\uffff\2\3\3\6\2\uffff\1\7\3\uffff\1"+
            "\4\3\uffff\1\5\1\uffff\2\5\1\6",
            "",
            "",
            "",
            "\1\11\6\10\16\uffff\4\10\1\uffff\6\10\2\uffff\1\10\3\uffff"+
            "\1\10\3\uffff\1\10\1\uffff\3\10",
            "",
            "",
            "",
            "",
            "\16\10\7\uffff\2\10\1\uffff\1\10\2\uffff\2\10\1\12\5\uffff"+
            "\1\10",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1398:1: rule__ValueSpecification__Alternatives : ( ( ruleLiteral ) | ( ruleNameOrChoiceOrBehaviorCall ) | ( ruleInterval ) | ( ruleCollectionOrTuple ) | ( ruleTuple ) | ( ruleTimeExpression ) | ( ruleVariableDeclaration ) | ( ( rule__ValueSpecification__Group_7__0 ) ) );";
        }
    }
 

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
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__0__Impl_in_rule__AndOrXorExpression__Group__03631 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__1_in_rule__AndOrXorExpression__Group__03634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__ExpAssignment_0_in_rule__AndOrXorExpression__Group__0__Impl3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group__1__Impl_in_rule__AndOrXorExpression__Group__13691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__0_in_rule__AndOrXorExpression__Group__1__Impl3718 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__0__Impl_in_rule__AndOrXorExpression__Group_1__03753 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__1_in_rule__AndOrXorExpression__Group_1__03756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__OpAssignment_1_0_in_rule__AndOrXorExpression__Group_1__0__Impl3783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__Group_1__1__Impl_in_rule__AndOrXorExpression__Group_1__13813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOrXorExpression__ExpAssignment_1_1_in_rule__AndOrXorExpression__Group_1__1__Impl3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__0__Impl_in_rule__EqualityExpression__Group__03874 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__1_in_rule__EqualityExpression__Group__03877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__ExpAssignment_0_in_rule__EqualityExpression__Group__0__Impl3904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group__1__Impl_in_rule__EqualityExpression__Group__13934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__0_in_rule__EqualityExpression__Group__1__Impl3961 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__0__Impl_in_rule__EqualityExpression__Group_1__03996 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__1_in_rule__EqualityExpression__Group_1__03999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__OpAssignment_1_0_in_rule__EqualityExpression__Group_1__0__Impl4026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__Group_1__1__Impl_in_rule__EqualityExpression__Group_1__14056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpression__ExpAssignment_1_1_in_rule__EqualityExpression__Group_1__1__Impl4083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__0__Impl_in_rule__RelationalExpression__Group__04117 = new BitSet(new long[]{0x0000000001E00000L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__1_in_rule__RelationalExpression__Group__04120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__ExpAssignment_0_in_rule__RelationalExpression__Group__0__Impl4147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group__1__Impl_in_rule__RelationalExpression__Group__14177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__0_in_rule__RelationalExpression__Group__1__Impl4204 = new BitSet(new long[]{0x0000000001E00002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__0__Impl_in_rule__RelationalExpression__Group_1__04239 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__1_in_rule__RelationalExpression__Group_1__04242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__OpAssignment_1_0_in_rule__RelationalExpression__Group_1__0__Impl4269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__Group_1__1__Impl_in_rule__RelationalExpression__Group_1__14299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RelationalExpression__ExpAssignment_1_1_in_rule__RelationalExpression__Group_1__1__Impl4326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConditionalExpression__Group__0__Impl_in_rule__ConditionalExpression__Group__04360 = new BitSet(new long[]{0x0008000000000000L});
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
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__0__Impl_in_rule__AdditiveExpression__Group__04729 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__1_in_rule__AdditiveExpression__Group__04732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__ExpAssignment_0_in_rule__AdditiveExpression__Group__0__Impl4759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group__1__Impl_in_rule__AdditiveExpression__Group__14789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__0_in_rule__AdditiveExpression__Group__1__Impl4816 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__0__Impl_in_rule__AdditiveExpression__Group_1__04851 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__1_in_rule__AdditiveExpression__Group_1__04854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__OpAssignment_1_0_in_rule__AdditiveExpression__Group_1__0__Impl4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__Group_1__1__Impl_in_rule__AdditiveExpression__Group_1__14911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpression__ExpAssignment_1_1_in_rule__AdditiveExpression__Group_1__1__Impl4938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpression__Group__0__Impl_in_rule__MultiplicativeExpression__Group__04972 = new BitSet(new long[]{0x0000000038000000L});
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
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group__0__Impl_in_rule__PrimaryExpression__Group__05336 = new BitSet(new long[]{0x0000002000000000L});
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
    public static final BitSet FOLLOW_rule__PropertyCallExpression__Group__0__Impl_in_rule__PropertyCallExpression__Group__05767 = new BitSet(new long[]{0x0000002000000000L});
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
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__2__Impl_in_rule__OperationCallExpression__Group__26134 = new BitSet(new long[]{0x000744CFDE0007F0L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__3_in_rule__OperationCallExpression__Group__26137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__ArgumentsAssignment_2_in_rule__OperationCallExpression__Group__2__Impl6164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OperationCallExpression__Group__3__Impl_in_rule__OperationCallExpression__Group__36195 = new BitSet(new long[]{0x0000002000000000L});
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
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__16509 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2_in_rule__NameOrChoiceOrBehaviorCall__Group__16512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__IdAssignment_1_in_rule__NameOrChoiceOrBehaviorCall__Group__1__Impl6539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group__26569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0_in_rule__NameOrChoiceOrBehaviorCall__Group__2__Impl6596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__06633 = new BitSet(new long[]{0x000744CFDE0007F0L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__06636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__NameOrChoiceOrBehaviorCall__Group_2__0__Impl6664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__16695 = new BitSet(new long[]{0x000744CFDE0007F0L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2_in_rule__NameOrChoiceOrBehaviorCall__Group_2__16698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__ArgumentsAssignment_2_1_in_rule__NameOrChoiceOrBehaviorCall__Group_2__1__Impl6725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl_in_rule__NameOrChoiceOrBehaviorCall__Group_2__26756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__NameOrChoiceOrBehaviorCall__Group_2__2__Impl6784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__06821 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__06824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__PathAssignment_0_in_rule__QualifiedName__Group__0__Impl6851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__16881 = new BitSet(new long[]{0x0000000000000010L});
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
    public static final BitSet FOLLOW_rule__ListOfValues__Group__0__Impl_in_rule__ListOfValues__Group__07690 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__1_in_rule__ListOfValues__Group__07693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__ValuesAssignment_0_in_rule__ListOfValues__Group__0__Impl7720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group__1__Impl_in_rule__ListOfValues__Group__17750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__0_in_rule__ListOfValues__Group__1__Impl7777 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__0__Impl_in_rule__ListOfValues__Group_1__07812 = new BitSet(new long[]{0x0007444FDE0007F0L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__1_in_rule__ListOfValues__Group_1__07815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ListOfValues__Group_1__0__Impl7843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__Group_1__1__Impl_in_rule__ListOfValues__Group_1__17874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValues__ValuesAssignment_1_1_in_rule__ListOfValues__Group_1__1__Impl7901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ListOfValueNamePairs__Group__0__Impl_in_rule__ListOfValueNamePairs__Group__07935 = new BitSet(new long[]{0x0000100000000000L});
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
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__1__Impl_in_rule__InstantObsExpression__Group__18427 = new BitSet(new long[]{0x0000804000000000L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__2_in_rule__InstantObsExpression__Group__18430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__IdAssignment_1_in_rule__InstantObsExpression__Group__1__Impl8457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__InstantObsExpression__Group__2__Impl_in_rule__InstantObsExpression__Group__28487 = new BitSet(new long[]{0x0000804000000000L});
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
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__1__Impl_in_rule__DurationObsExpression__Group__19236 = new BitSet(new long[]{0x0000804000000000L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__2_in_rule__DurationObsExpression__Group__19239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__IdAssignment_1_in_rule__DurationObsExpression__Group__1__Impl9266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DurationObsExpression__Group__2__Impl_in_rule__DurationObsExpression__Group__29296 = new BitSet(new long[]{0x0000804000000000L});
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
    public static final BitSet FOLLOW_rule__JitterExp__Group__2__Impl_in_rule__JitterExp__Group__210105 = new BitSet(new long[]{0x0000008004000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__3_in_rule__JitterExp__Group__210108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__0_in_rule__JitterExp__Group__2__Impl10135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group__3__Impl_in_rule__JitterExp__Group__310166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__JitterExp__Group__3__Impl10194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__0__Impl_in_rule__JitterExp__Group_2__010233 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__1_in_rule__JitterExp__Group_2__010236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__JitterExp__Group_2__0__Impl10264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__Group_2__1__Impl_in_rule__JitterExp__Group_2__110295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JitterExp__SecondInstantAssignment_2_1_in_rule__JitterExp__Group_2__1__Impl10322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group__0__Impl_in_rule__VariableDeclaration__Group__010356 = new BitSet(new long[]{0x0004000E00000000L});
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
    public static final BitSet FOLLOW_rule__VariableDeclaration__Group_3_0__1__Impl_in_rule__VariableDeclaration__Group_3_0__110666 = new BitSet(new long[]{0x0000200000000000L});
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